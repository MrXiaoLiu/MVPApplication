package text.tao.com.myapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

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

    public void onCreate() {
        super.onCreate();
        this.mRefWatcher = LeakCanary.install(this);
        mContext = this;
        Stetho.initializeWithDefaults(this);
        AppUtils.init(this);
        initComponent();
    }

    private void initComponent() {
        this.mAppComponent = DaggerAppComponent.builder().httpModule(new httpModule()).appModule(new AppModule(this)).build();
    }
}
