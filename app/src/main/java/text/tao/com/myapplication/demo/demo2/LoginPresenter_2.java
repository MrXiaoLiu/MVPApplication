package text.tao.com.myapplication.demo.demo2;


import text.tao.com.myapplication.demo.demo1.LoginModel_1;
import text.tao.com.myapplication.utils.HttpUtils;

//P层
//两个特点
//第一个特点：持有M层引用
//第二个特点：持有V层引用
public class LoginPresenter_2 extends MvpPresenter_2<LoginView_2> {

    //持有M层引用
    private LoginModel_1 model;

    public LoginPresenter_2() {
        this.model = new LoginModel_1();
    }

    public void login(String code,String username, String password) {
        this.model.login(code,username, password, result -> {
            if (getView() != null) {
                //回调UI
                getView().onLoginResult(result);
            }
        });
    }

}
