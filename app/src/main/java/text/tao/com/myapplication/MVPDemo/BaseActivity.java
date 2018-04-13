package text.tao.com.myapplication.MVPDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import text.tao.com.myapplication.AppApplication;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.ActivityComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.ActivityModule;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.DaggerActivityComponent;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;
import text.tao.com.myapplication.MVPDemo.support.ActivityMvpDelegate;
import text.tao.com.myapplication.MVPDemo.support.ActivityMvpDelegateImpl;
import text.tao.com.myapplication.MVPDemo.support.MvpCallback;


//父类->基类->动态指定类型->泛型设计(通过泛型指定动态类型->由子类指定，父类只需要规定类型范围即可)
//第一重代理->代理对象->第三个角色：代理对象->BaseActivity
//第二重代理->目标对象->第二个角色->具体的P和V由子类决定
public abstract class BaseActivity<V extends BaseView, P extends RxPresenter<V>> extends RxAppCompatActivity implements MvpCallback<V, P> {

    private ActivityMvpDelegate<V, P> mvpDelegate;

    private ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new ActivityMvpDelegateImpl(this);
        }
        return this.mvpDelegate;
    }

    private P presenter;
    private V view;

    public P createPresenter() {
        return this.presenter;
    }

    public P getMvpPresenter() {
        return this.presenter;
    }

    public void setMvpPresenter(P paramP) {
        this.presenter = paramP;
    }



    public V createView() {
        return this.view;
    }

    public V getMvpView() {
        return this.view;
    }

    public void setMvpView(V paramV) {
        this.view = paramV;
    }




    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder().appComponent(AppApplication.getInstance().getAppComponent()).activityModule(getActivityModule()).build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected void onCreate(@Nullable Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.i("aaa","BaseActivity111");
        initInject();
        Log.i("aaa","BaseActivity222");
        onitiv(paramBundle);
        getMvpDelegate().onCreate(paramBundle);
        Log.i("aaa","BaseActivity333");

    }

    protected abstract void onitiv(Bundle paramBundle);

    protected void initInject() {
    }



    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }
}


