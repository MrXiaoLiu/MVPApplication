package text.tao.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import text.tao.com.myapplication.demo.demo4.MvpActivity;
import text.tao.com.myapplication.demo.demo4.login.LoginPresenter;
import text.tao.com.myapplication.demo.demo4.login.LoginView;
import text.tao.com.myapplication.utils.BaseApi;

/**
 * MrLiu253@163.com
 *
 * @time 2018/4/13
 */

@Route(path = BaseApi.simple)
public class SimpleActivity
        extends MvpActivity<LoginView, LoginPresenter> implements LoginView {

    //第四步：MVP设计->优化?
    public void clickLogin(View v) {
        getMvpPresenter().login("86","184","111111");
    }


    //第一步：搭建最基本MVP？
//    public void clickLogin(View v){
//        //采用传统代码实现
////        HttpTask httpTask = new HttpTask(new HttpUtils.OnHttpResultListener() {
////            @Override
////            public void onResult(String result) {
////                Toast.makeText(MainActivity.this, "返回内容："+result, Toast.LENGTH_LONG).show();
////            }
////        });
////        httpTask.execute("http://169.254.78.127:8080/Dream_6_19_LoginServer/LoginServlet", "Dream", "123456");
//
//
//        //采用MVP实现->测试
//        this.presenter1.login("Sid", "123456");
//    }
//
//    @Override
//    public void onLoginResult(String result) {
//        Toast.makeText(MainActivity.this, "返回内容："+result, Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        this.presenter1.detachView();
//    }


    //第二步：搭建MVP升级->优化？
//    @Override
//    public LoginPresenter_2 createPresenter() {
//        return new LoginPresenter_2();
//    }
//
//    @Override
//    public LoginView_2 createView() {
//        return this;
//    }
//
//    public void clickLogin(View v){
//        getPresenter().login("Sid", "123456");
//    }
//
//    @Override
//    public void onLoginResult(String result) {
//        Toast.makeText(MainActivity.this, "返回内容："+result, Toast.LENGTH_LONG).show();
//    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }

    @Override
    public void onLoginResult(String result) {
        Log.i("aaa","返回:"+result);
    }
}
