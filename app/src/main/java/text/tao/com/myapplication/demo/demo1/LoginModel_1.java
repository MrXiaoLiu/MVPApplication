package text.tao.com.myapplication.demo.demo1;


import text.tao.com.myapplication.utils.BaseApi;
import text.tao.com.myapplication.utils.HttpTask;
import text.tao.com.myapplication.utils.HttpUtils;

//M层搭建完成
public class LoginModel_1 {

    public void login(String code, String username, String password,final HttpUtils.OnHttpResultListener onHttpResultListener){
        //采用传统代码实现
        HttpTask httpTask = new HttpTask(result -> {
            //解析JSON，查询数据库
            //..忽略100行代码
            onHttpResultListener.onResult(result);
        });
        httpTask.execute(BaseApi.login,code,username,password);

    }

    public void close(){

    }

}
