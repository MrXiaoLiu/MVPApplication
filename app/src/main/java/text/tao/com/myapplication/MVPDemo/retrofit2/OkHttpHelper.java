package text.tao.com.myapplication.MVPDemo.retrofit2;

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * @date 创建时间：2017/5/10 10:23
 * 描述:okHttp 帮助类
 */

import android.content.Context;


import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import text.tao.com.myapplication.utils.AppUtils;
import text.tao.com.myapplication.utils.BaseApi;
import text.tao.com.myapplication.utils.FileUtils;
import text.tao.com.myapplication.utils.NetworkUtils;

/**
 * 全局统一使用的OkHttpClient工具，okhttp版本：okhttp3
 */
public class OkHttpHelper {
    //读取时间
    private static final long DEFAULT_READ_TIMEOUT_MILLIS = 20 * 1000;
    //写入时间
    private static final long DEFAULT_WRITE_TIMEOUT_MILLIS = 20 * 1000;
    //超时时间
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 20 * 1000;
    //最大缓存
    private static final long HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 20 * 1024 * 1024;//设置20M
    //长缓存有效期为7天
    private static final int CACHE_STALE_LONG = 60 * 60 * 24 * 7;

    private static volatile OkHttpHelper sInstance;

    private OkHttpClient mOkHttpClient;
    private Context mContext = AppUtils.getAppContext();

    private OkHttpHelper() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //包含header、body数据
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                //处理多BaseUrl,添加应用拦截器
                .addInterceptor(new MoreBaseUrlInterceptor())
                .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .cache(getCache(mContext))//设置缓存
                // 失败重发
                .retryOnConnectionFailure(true)
                //设置缓存
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)

                .addInterceptor(mRewriteCacheControlInterceptor)
                //FaceBook 网络调试器，可在Chrome调试网络请求，查看SharePreferences,数据库等
                .addNetworkInterceptor(new StethoInterceptor())
                //http数据log，日志中打印出HTTP请求&响应数据
                .addInterceptor(loggingInterceptor)
                //便于查看json
                 .addInterceptor(new LoggerInterceptor())
//                .addInterceptor(new UserAgentInterceptor())
                .build();
    }

    public static OkHttpHelper getInstance() {
        if (sInstance == null) {
            synchronized (OkHttpHelper.class) {
                if (sInstance == null) {
                    sInstance = new OkHttpHelper();
                }
            }
        }
        return sInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    /**
     * 设置缓存路径
     *
     * @param context 上下文
     */
    public void setCache(Context context) {
        final File baseDir = context.getApplicationContext().getCacheDir();
        if (baseDir != null) {
            final File cacheDir = new File(baseDir, "CopyCache");
            mOkHttpClient.newBuilder().cache((new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE)));
        }
    }


    /**
     * 获取缓存路径
     *
     * @return cache
     */
    private Cache getCache(Context context) {
        Cache cache = null;
        String path = FileUtils.createRootPath(context);
        final File baseDir = new File(path);
        final File cacheDir = new File(baseDir, "CopyCache");
        cache = new Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
        return cache;
    }



    // 云端响应头拦截器，用来配置缓存策略
    //离线读取本地缓存，在线获取最新数据(读取单个请求的请求头，亦可统一设置)。
    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            // Logger.d(NetworkUtils.isAvailable(mContext));
            if (!NetworkUtils.isConnected(mContext)) {
                //CacheControl.FORCE_CACHE; 没有网络时强制使用缓存
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }

            Response originalResponse = chain.proceed(request);

            if (NetworkUtils.isConnected(mContext)) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse
                        .newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();

            } else {

                return originalResponse
                        .newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    /**
     * 添加统一请求体
     */
    private static class UserAgentInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request originalRequest = chain.request();

            HttpUrl httpUrl  =  originalRequest.url().newBuilder()
                    .addQueryParameter("user","1111")
                    .build();

            Request request = originalRequest.newBuilder().url(httpUrl).build();
//
//            Request requestWithUserAgent = originalRequest
//                    .newBuilder()
//                    .addPar
////                    .removeHeader("user")
//                    .addHeader()
//                    .build();

            return chain.proceed(request);
        }
    }

    /**
     * 解决多个头部
     */
    public class MoreBaseUrlInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {



            //获取原始的originalRequest
            Request originalRequest = chain.request();
            //获取老的url
            HttpUrl oldUrl = originalRequest.url();
            //获取originalRequest的创建者builder
            Request.Builder builder = originalRequest.newBuilder();
            //获取头信息的集合如：manage,mdffx
            List<String> urlnameList = originalRequest.headers("urlname");
            if (urlnameList != null && urlnameList.size() > 0) {
                //删除原有配置中的值,就是namesAndValues集合里的值
                builder.removeHeader("urlname");
                //获取头信息中配置的value,如：manage或者mdffx
                String urlname = urlnameList.get(0);
                HttpUrl baseURL=null;
                //根据头信息中配置的value,来匹配新的base_url地址
                if ("manage".equals(urlname)) {
                    baseURL = HttpUrl.parse(BaseApi.base);
                } else if ("mdffx".equals(urlname)) {
                    baseURL = HttpUrl.parse(BaseApi.base2);
                }else if ("ssss".equals(urlname)) {
                    baseURL = HttpUrl.parse(BaseApi.base3);
                }else {
                    baseURL = HttpUrl.parse(BaseApi.base);
                }
                //重建新的HttpUrl，需要重新设置的url部分
                HttpUrl newHttpUrl = oldUrl.newBuilder()
                        .scheme(baseURL.scheme())//http协议如：http或者https
                        .host(baseURL.host())//主机地址
                        .port(baseURL.port())//端口
                        .build();
                //获取处理后的新newRequest
                Request newRequest = builder.url(newHttpUrl).build();
                return  chain.proceed(newRequest);
            }else{
                return chain.proceed(originalRequest);
            }

        }
    }

}
