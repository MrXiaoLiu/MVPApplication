package text.tao.com.myapplication.demo.demo4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import text.tao.com.myapplication.demo.demo4.support.activity.ActivityMvpDelegate;
import text.tao.com.myapplication.demo.demo4.support.activity.ActivityMvpDelegateImpl;
import text.tao.com.myapplication.demo.demo4.support.activity.MvpCallback;


//父类->基类->动态指定类型->泛型设计(通过泛型指定动态类型->由子类指定，父类只需要规定类型范围即可)
//第一重代理->代理对象->第三个角色：代理对象->MvpActivity
//第二重代理->目标对象->第二个角色->具体的P和V由子类决定
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends Activity implements MvpCallback<V, P> {

    private ActivityMvpDelegate<V, P> mvpDelegate;

    private ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new ActivityMvpDelegateImpl<V, P>(this);
        }
        return this.mvpDelegate;
    }



    private P mP;
    private V mV;

    @Override
    public P createPresenter() {
        return this.mP;
    }

    @Override
    public P getMvpPresenter() {
        return this.mP;
    }

    @Override
    public void setMvpPresenter(P presenter) {
        this.mP = presenter;
    }

    @Override
    public V createView() {
        return this.mV;
    }

    @Override
    public V getMvpView() {
        return this.mV;
    }

    @Override
    public void setMvpView(V view) {
        this.mV = view;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }



    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    //......

}
