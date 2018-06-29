package text.tao.com.myapplication.MVPDemo.login;


import android.util.Log;

import javax.inject.Inject;

import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;
import text.tao.com.myapplication.MVPDemo.rx.BaseSubscriber;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;
import text.tao.com.myapplication.MVPDemo.rx.RxUtils;
import text.tao.com.myapplication.adapter.PrBean;

//P层
//两个特点
//第一个特点：持有M层引用
//第二个特点：持有V层引用
public class LoginPresenter extends RxPresenter<LoginView> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public LoginPresenter(RetrofitHelper paramRetrofitHelper) {
        this.mRetrofitHelper = paramRetrofitHelper;
    }

    public void login(String paramString1, String paramString2, String paramString3) {
        addSubscribe((BaseSubscriber) this.mRetrofitHelper.getIndex()
                .compose(RxUtils.handleResult())
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<IndexBean>(getView()) {

                    public void onSuccess(IndexBean paramAnonymousIndexBean) {
                        ((LoginView) LoginPresenter.this.getView()).onLoginResult(paramAnonymousIndexBean);
                    }
                }));
    }



}