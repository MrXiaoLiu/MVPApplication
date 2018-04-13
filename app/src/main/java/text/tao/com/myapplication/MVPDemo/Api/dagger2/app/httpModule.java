package text.tao.com.myapplication.MVPDemo.Api.dagger2.app;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import text.tao.com.myapplication.MVPDemo.Api.jie_kou.AppUrl;
import text.tao.com.myapplication.MVPDemo.retrofit2.ApiConstants;
import text.tao.com.myapplication.MVPDemo.retrofit2.OkHttpHelper;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;
import text.tao.com.myapplication.utils.BaseApi;


/**
 * 描述:Api网络模型
 */
@Module
public class httpModule
{
  public Retrofit createRetrofit(Retrofit.Builder paramBuilder, OkHttpClient paramOkHttpClient, String paramString)
  {
    return paramBuilder.baseUrl(paramString).client(paramOkHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
  }
  
  @Provides
  @Singleton
  @AppUrl
  public Retrofit provideAppRetrofit(Retrofit.Builder paramBuilder, OkHttpClient paramOkHttpClient)
  {
    return createRetrofit(paramBuilder, paramOkHttpClient, BaseApi.base);
  }
  
  @Provides
  @Singleton
  public ApiConstants provideAppService(@AppUrl Retrofit paramRetrofit)
  {
    return (ApiConstants)paramRetrofit.create(ApiConstants.class);
  }
  
  @Provides
  @Singleton
  public OkHttpClient provideOkHttpClient()
  {
    return OkHttpHelper.getInstance().getOkHttpClient();
  }
  
  @Provides
  @Singleton
  public Retrofit.Builder provideRetrofitBuilder()
  {
    return new Retrofit.Builder();
  }
  
  @Provides
  @Singleton
  public RetrofitHelper provideRetrofitHelper(ApiConstants paramApiConstants)
  {
    return new RetrofitHelper(paramApiConstants);
  }
}
