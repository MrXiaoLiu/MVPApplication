package text.tao.com.myapplication.push;

import javax.inject.Inject;

import io.reactivex.Flowable;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;
import text.tao.com.myapplication.MVPDemo.rx.BaseServiceSubscriber;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;
import text.tao.com.myapplication.MVPDemo.rx.RxUtils;
import text.tao.com.myapplication.push.ui.PushView;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/17
 */

public class BaseP extends RxPresenter<PushView> {

    RetrofitHelper mRetrofitHelper;

    @Inject
    public BaseP(RetrofitHelper paramRetrofitHelper) {
        this.mRetrofitHelper = paramRetrofitHelper;

    }

    Node2 node2 = null;

    public Node2 getP(String key) {

        mRetrofitHelper.Offline(key)
                .subscribeWith(new BaseServiceSubscriber<Node2>() {
                    @Override
                    public void onSuccess(Node2 paramT) {
                        node2 = paramT;
                    }
                });

        return node2;
    }
}
