package text.tao.com.myapplication.MVPDemo.rx;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;

import io.reactivex.subscribers.ResourceSubscriber;

import java.net.SocketTimeoutException;

import retrofit2.HttpException;
import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.exception.ApiException;
import text.tao.com.myapplication.utils.AppUtils;
import text.tao.com.myapplication.utils.NetworkUtils;


/**
 * 描述:统一处理订阅者
 */
public abstract class BaseSubscriber<T> extends ResourceSubscriber<T> {
    private String mMsg;
    private BaseView mView;

    public BaseSubscriber(BaseView paramBaseView) {
        this.mView = paramBaseView;
    }

    public void onFailure(int paramInt, String paramString) {

    }

    public void onNext(T paramT) {
        if (this.mView == null) {
            return;
        }
        this.mView.complete();
        onSuccess(paramT);
    }

    public void onError(Throwable paramThrowable) {
        if (this.mView == null) return;
        if ((this.mMsg != null) && (!TextUtils.isEmpty(this.mMsg))) {
            this.mView.showError(this.mMsg);
        }else if ((paramThrowable instanceof ApiException)) {
            this.mView.showError(paramThrowable.toString());
        }else if ((paramThrowable instanceof SocketTimeoutException)) {
            this.mView.showError("服务器响应超时ヽ(≧Д≦)ノ");
        }else if ((paramThrowable instanceof HttpException)) {
            this.mView.showError("数据加载失败ヽ(≧Д≦)ノ");
        }else {
            this.mView.showError("未知错误ヽ(≧Д≦)ノ");
        }

    }

    public void onComplete() {
    }

    public abstract void onSuccess(T paramT);

    protected void onStart() {
        super.onStart();
        if (!NetworkUtils.isConnected(AppUtils.getAppContext())) {
            Log.i("aaa", "没有网络");
        }
    }
}

