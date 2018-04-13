package text.tao.com.myapplication.MVPDemo.support;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.login.LoginPresenter;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;
import text.tao.com.myapplication.R;


//第一重代理->第二个角色->目标对象->生命周期
public class ActivityMvpDelegateImpl<V extends BaseView, P extends RxPresenter<V>> implements ActivityMvpDelegate<V, P>
{
  //调用第二重代理代理对象   进行第一重第二重关联
  //第一重代理已经对整个Activity生命周期进行代理，所以你可以直接在这个目标对象里面实现功能
  private ProxyMvpCallback<V, P> proxyMvpCallback;

  public ActivityMvpDelegateImpl(MvpCallback<V, P> mvpCallback){
    this.proxyMvpCallback = new ProxyMvpCallback<V, P>(mvpCallback);
  }



  @Override
  public void onCreate(Bundle savedInstanceState) {
    this.proxyMvpCallback.createPresenter();
    this.proxyMvpCallback.createView();
    this.proxyMvpCallback.attachView();



    Log.i("aaa","执行这里ActivityMvpDelegateImpl");
  }

  @Override
  public void onStart() {

  }

  @Override
  public void onResume() {

  }

  @Override
  public void onPause() {

  }

  @Override
  public void onStop() {

  }

  @Override
  public void onDestroy() {
    this.proxyMvpCallback.detachView();
  }
}

