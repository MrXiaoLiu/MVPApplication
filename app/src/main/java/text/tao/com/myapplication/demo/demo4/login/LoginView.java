package text.tao.com.myapplication.demo.demo4.login;


import text.tao.com.myapplication.demo.demo4.MvpView;



//V层回调
public interface LoginView extends MvpView {

    void onLoginResult(String result);

}
