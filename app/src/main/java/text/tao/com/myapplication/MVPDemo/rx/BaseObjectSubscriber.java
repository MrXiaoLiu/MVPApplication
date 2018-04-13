package text.tao.com.myapplication.MVPDemo.rx;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;

import io.reactivex.subscribers.ResourceSubscriber;

import java.net.SocketTimeoutException;

import retrofit2.HttpException;
import text.tao.com.myapplication.MVPDemo.Api.bean.Bean2;
import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.exception.ApiException;
import text.tao.com.myapplication.utils.AppUtils;
import text.tao.com.myapplication.utils.NetworkUtils;


/**
 * 描述:统一处理订阅者
 */
public abstract class BaseObjectSubscriber<T> extends ResourceSubscriber<Bean2<T>> {
    private String mMsg;
    private BaseView mView;

    public BaseObjectSubscriber(BaseView paramBaseView) {
        this.mView = paramBaseView;
    }

    public void onFailure(int code, String message) {

    }

    protected void onStart() {
        super.onStart();
        if (!NetworkUtils.isConnected(AppUtils.getAppContext())) {
            Logger.i("aaa", "没有网络");
        }
    }

    public void onNext(Bean2<T> paramBean2) {
        if (this.mView == null) return;
        if (paramBean2.getStatus() == 1) {
            Log.i("aaa", "这个数组是多少" + paramBean2.getData());
            onSuccess(paramBean2.getData());
            this.mView.complete();
        } else {
            this.mView.showError(paramBean2.getMsg());
        }

    }

    public abstract void onSuccess(T paramT);

    public void onError(Throwable paramThrowable) {
        if (this.mView == null) return;

        if ((this.mMsg != null) && (!TextUtils.isEmpty(this.mMsg))) {
            this.mView.showError(this.mMsg);
        }else if ((paramThrowable instanceof ApiException)) {
            Logger.i("aaa", "11111111错误" + paramThrowable.getLocalizedMessage());
            this.mView.showError(paramThrowable.toString());
        }else if ((paramThrowable instanceof SocketTimeoutException)) {
            this.mView.showError("服务器响应超时ヽ(≧Д≦)ノ");
            Logger.i("aaa", "服务器响应超时ヽ");
        }else if ((paramThrowable instanceof HttpException)) {
            this.mView.showError("数据加载失败ヽ(≧Д≦)ノ");
            Logger.i("aaa", "数据加载失败ヽ");
        }else {
            this.mView.showError("未知错误ヽ(≧Д≦)ノ");
            Logger.i("aaa", "未知错误ヽ" + paramThrowable.toString());
        }

    }

    public void onComplete() {
    }


}
