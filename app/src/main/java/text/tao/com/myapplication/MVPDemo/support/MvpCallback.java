package text.tao.com.myapplication.MVPDemo.support;


import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;

//第二重代理->目标接口->定义了高度抽象的解绑和绑定规范
public  interface MvpCallback<V extends BaseView, P extends RxPresenter<V>>
{
  P createPresenter();

  V createView();

  P getMvpPresenter();

  void setMvpPresenter(P presenter);

  V getMvpView();

  void setMvpView(V view);

}