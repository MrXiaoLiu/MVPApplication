package text.tao.com.myapplication.MVPDemo.rx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import text.tao.com.myapplication.MVPDemo.BasePresenter;
import text.tao.com.myapplication.MVPDemo.BaseView;


/**
 * Created by zzq on 2016/12/20.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter<V extends BaseView> extends BasePresenter<V> {
    protected V mView;
    private CompositeDisposable mCompositeDisposable;

    protected <K> void addRxBusSubscribe(Class<K> paramClass, Consumer<K> paramConsumer) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(RxBus.INSTANCE.toDefaultFlowable(paramClass, paramConsumer));
    }

    protected void addSubscribe(Disposable paramDisposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(paramDisposable);
    }

    public void attachView(V paramV) {
        this.mView = paramV;
    }

    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (this.mCompositeDisposable != null) {
            this.mCompositeDisposable.dispose();
        }
    }

    public V getView() {
        return this.mView;
    }


    /**
     * 删除
     *
     * @param paramDisposable disposable
     */
    protected boolean remove(Disposable paramDisposable) {
        return (this.mCompositeDisposable != null) && (this.mCompositeDisposable.remove(paramDisposable));
    }
}