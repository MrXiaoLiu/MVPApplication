package text.tao.com.myapplication.MVPDemo.support;

import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;

//第二重代理->角色三->代理对象
public class ProxyMvpCallback<V extends BaseView, P extends RxPresenter<V>> implements MvpCallback<V, P> {

  //持有目标对象引用->MvpActivity
  private MvpCallback<V, P> mvpCallback;

  public ProxyMvpCallback(MvpCallback<V, P> mvpCallback){
    this.mvpCallback = mvpCallback;
  }

  @Override
  public P createPresenter() {
    P presenter = this.mvpCallback.getMvpPresenter();
    if (presenter == null){
      presenter = this.mvpCallback.createPresenter();
    }
    if (presenter == null){
      throw new NullPointerException("presenter不能够为空!");
    }
    this.mvpCallback.setMvpPresenter(presenter);
    return presenter;
  }

  @Override
  public V createView() {
    V view = this.mvpCallback.getMvpView();
    if (view == null){
      view = this.mvpCallback.createView();
    }
    if (view == null){
      throw new NullPointerException("view不能够为空!");
    }
    this.mvpCallback.setMvpView(view);
    return view;
  }

  @Override
  public P getMvpPresenter() {
    return this.mvpCallback.getMvpPresenter();
  }

  @Override
  public void setMvpPresenter(P presenter) {
    this.mvpCallback.setMvpPresenter(presenter);
  }

  @Override
  public V getMvpView() {
    return this.mvpCallback.getMvpView();
  }

  @Override
  public void setMvpView(V view) {

  }

  public void attachView(){
    this.getMvpPresenter().attachView(getMvpView());
  }

  public void detachView(){
    this.getMvpPresenter().detachView();
  }
}


