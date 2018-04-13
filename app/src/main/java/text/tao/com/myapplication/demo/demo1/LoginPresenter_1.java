package text.tao.com.myapplication.demo.demo1;


import text.tao.com.myapplication.utils.HttpUtils;

//P层
//两个特点
//第一个特点：持有M层引用
//第二个特点：持有V层引用
public class LoginPresenter_1 {

    //持有M层引用
    private LoginModel_1 model;

    //持有V层引用
    private LoginView_1 view;

    public LoginPresenter_1(){
        this.model = new LoginModel_1();
    }

    //绑定UI层
    public void attachView(LoginView_1 view){
        this.view = view;
    }

    //解除绑定
    public void detachView(){
        this.view = null;
    }

    public void login(String code,String username, String password){
        this.model.login(code,username, password, result -> {
            if (view != null){
                //回调UI
                view.onLoginResult(result);
            }
        });
    }

}
