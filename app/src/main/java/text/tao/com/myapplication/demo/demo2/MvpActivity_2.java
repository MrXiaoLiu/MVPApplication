package text.tao.com.myapplication.demo.demo2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;


//父类->基类->动态指定类型->泛型设计(通过泛型指定动态类型->由子类指定，父类只需要规定类型范围即可)
public abstract class MvpActivity_2<V extends MvpView_2, P extends MvpPresenter_2<V>> extends Activity {

    //引用V层和P层
    //有写死了
    private P presenter;

    private V view;

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.presenter == null){
            this.presenter = createPresenter();
        }
        if (this.view == null){
            this.view = createView();
        }
        if (this.presenter != null && this.view != null){
            this.presenter.attachView(this.view);
        }
    }

    //由子类指定具体类型
    public abstract P createPresenter();
    public abstract V createView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.presenter != null){
            this.presenter.detachView();
        }
    }
}
