package text.tao.com.myapplication.MVPDemo.support;

import android.os.Bundle;

import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;

//第一重代理->第一个角色->目标接口
public  interface ActivityMvpDelegate<V extends BaseView, P extends RxPresenter<V>>
{
  void onCreate(Bundle savedInstanceState);

  void onStart();

  void onResume();

  void onPause();

  void onStop();

  void onDestroy();

  //课后自己扩展其它方法

}