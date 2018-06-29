package text.tao.com.myapplication.MVPDemo.rx;

import android.text.TextUtils;
import android.util.Log;

import java.net.SocketTimeoutException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;
import text.tao.com.myapplication.MVPDemo.BaseView;
import text.tao.com.myapplication.MVPDemo.exception.ApiException;
import text.tao.com.myapplication.utils.AppUtils;
import text.tao.com.myapplication.utils.NetworkUtils;


/**
 * 描述:统一处理订阅者
 */
public abstract class BaseServiceSubscriber<T> extends ResourceSubscriber<T> {
    private String mMsg;

    public BaseServiceSubscriber() {
    }

    public void onFailure(int paramInt, String paramString) {

    }

    public void onNext(T paramT) {

        onSuccess(paramT);
    }

    public void onError(Throwable paramThrowable) {


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

