package text.tao.com.myapplication.adapter;

import android.util.Log;

import javax.inject.Inject;

import text.tao.com.myapplication.MVPDemo.BasePresenter;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;
import text.tao.com.myapplication.MVPDemo.rx.BaseSubscriber;
import text.tao.com.myapplication.MVPDemo.rx.RxPresenter;
import text.tao.com.myapplication.MVPDemo.rx.RxUtils;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/7
 */

public class PrPresenter extends RxPresenter<PrView> {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public PrPresenter(RetrofitHelper paramRetrofitHelper) {
        this.mRetrofitHelper = paramRetrofitHelper;
    }

    public void getList(int page) {
        Log.i("aaa","开始执行");
        addSubscribe((BaseSubscriber) this.mRetrofitHelper.getList(page)
                .compose(RxUtils.handleResult())
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseSubscriber<PrBean>(getView()) {
                    @Override
                    public void onSuccess(PrBean paramT) {
                        getView().onResult(paramT);
                    }
                }));
    }
}
