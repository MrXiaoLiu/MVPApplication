package text.tao.com.myapplication.demo.demo4.support.activity;

import text.tao.com.myapplication.demo.demo4.MvpPresenter;
import text.tao.com.myapplication.demo.demo4.MvpView;



//第二重代理->目标接口->定义了高度抽象的解绑和绑定规范
public interface MvpCallback<V extends MvpView, P extends MvpPresenter<V>> {

    //设置P层
    P createPresenter();

    //设置V层
    V createView();

    //获取P层
    P getMvpPresenter();

    //设置P
    void setMvpPresenter(P presenter);

    //获取V层
    V getMvpView();

    //设置V
    void setMvpView(V view);

}
