package text.tao.com.myapplication.MVPDemo.login;


import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.BaseView;

//UI回调
public interface LoginView extends BaseView {

//    String getName();

//    void setName(String name);

    void onLoginResult(IndexBean paramIndexBean);

}


