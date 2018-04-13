package text.tao.com.myapplication.MVPDemo.login;


import text.tao.com.myapplication.utils.BaseApi;
import text.tao.com.myapplication.utils.HttpTask;
import text.tao.com.myapplication.utils.HttpUtils;

public class LoginModel {
    public void Login(String paramString1, String paramString2, String paramString3, final HttpUtils.OnHttpResultListener paramOnHttpResultListener) {
        new HttpTask(paramAnonymousString ->
                paramOnHttpResultListener
                        .onResult(paramAnonymousString))
                .execute(new String[]{BaseApi.login, paramString1, paramString2, paramString3});
    }
}