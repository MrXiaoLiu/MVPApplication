package text.tao.com.myapplication.demo.demo4.support.activity;

import android.os.Bundle;

import text.tao.com.myapplication.demo.demo4.MvpPresenter;
import text.tao.com.myapplication.demo.demo4.MvpView;




//第一重代理->第一个角色->目标接口
public interface ActivityMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    //课后自己扩展其它方法


    //    双重代理（第一重代理是为第二重代理做准备）
//    第一个代理各个模块生命周期
//    一、创建目标接口：定义各个模块生命周期
//    二、目标对象(生命周期的实现)：生命周期的实现
//    三、代理对象（baseActivity）：要实现目标接口（可忽略）。持有目标对象引用
//


//    第二个代理代理各个模块的MVP实现（绑定和解绑操作）
//    一、目标接口（MvpCallback）；定义了绑定和解绑的规范
//    二、目标对象（baseActivity具体对象）：具体的绑定和解绑是有具体的activity决定的
//    三、代理对象（ProxyMvpCallback）：高度抽象的绑定和解绑
//
//
//

}