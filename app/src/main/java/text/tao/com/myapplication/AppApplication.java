package text.tao.com.myapplication;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;
//import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.Stetho;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.smtt.sdk.QbSdk;

import text.tao.com.myapplication.MVPDemo.Api.dagger2.app.AppComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.app.AppModule;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.app.DaggerAppComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.app.httpModule;
import text.tao.com.myapplication.utils.AppUtils;


public class AppApplication extends Application {
    private static AppApplication mContext;
    private AppComponent mAppComponent;
    private RefWatcher mRefWatcher;

    public AppApplication() {
    }

    public static AppApplication getInstance() {
        return mContext;
    }

    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(R.color.tab_color_false, android.R.color.white);//全局设置主题颜色
            return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        });
        //设置全局的Footer构建器
//        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
//            @Override
//            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                //指定为经典Footer，默认是 BallPulseFooter
//                return new ClassicsFooter(context).setDrawableSize(20);
//            }
//        });
    }
    public void onCreate() {
        super.onCreate();


        MultiDex.install(this);
        mContext = this;

        LeakCanary.install(this);


        Stetho.initializeWithDefaults(this);
        AppUtils.init(this);
        initComponent();

        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("aaa", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);




        if (BuildConfig.DEBUG) {        // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace();
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化



    }

    private void initComponent() {
        this.mAppComponent = DaggerAppComponent
                .builder()
                .httpModule(new httpModule())
                .appModule(new AppModule(this))
                .build();
    }
}
