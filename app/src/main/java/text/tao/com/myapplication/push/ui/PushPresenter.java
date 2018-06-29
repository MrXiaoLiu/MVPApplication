package text.tao.com.myapplication.push.ui;


import android.util.Log;

import javax.inject.Inject;

import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.login.LoginView;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;
import text.tao.com.myapplication.MVPDemo.rx.BaseSubscriber;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;
import text.tao.com.myapplication.MVPDemo.rx.RxUtils;
import text.tao.com.myapplication.push.Node;
import text.tao.com.myapplication.push.Node2;

//P层
//两个特点
//第一个特点：持有M层引用
//第二个特点：持有V层引用
public class PushPresenter extends RxPresenter<PushView> {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public PushPresenter(RetrofitHelper paramRetrofitHelper) {
        this.mRetrofitHelper = paramRetrofitHelper;
    }

    public void login(String key) {

        addSubscribe(mRetrofitHelper.getPush()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<Node>(getView()) {
                    @Override
                    public void onSuccess(Node paramT) {
                        Log.i("aaa","请求成功"+paramT.toString());
                        if (getView()!=null){
                            String[] args = paramT.getData().getServer().split(":");

                            paramT.setKey(key);
                            paramT.setHost(args[0]);
                            paramT.setPort(Integer.parseInt(args[1]));

                            getView().onLoginResult(paramT);
                        }

                    }
                }));

    }

    //获取离线消息
    public void getOfflineMessages() {

//        addSubscribe(mRetrofitHelper.Offline()
//                .compose(RxUtils.rxSchedulerHelper())
//                .subscribeWith(new BaseSubscriber<Node2>(getView()) {
//                    @Override
//                    public void onSuccess(Node2 paramT) {
//                        Log.i("aaa","请求成功"+paramT.toString());
//                        if (getView()!=null){
//
////                            getView().onOfflineMessages(paramT);
//                        }
//
//                    }
//                }));

    }


}