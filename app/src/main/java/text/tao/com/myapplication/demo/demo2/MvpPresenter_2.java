package text.tao.com.myapplication.demo.demo2;



//抽象类->高度抽象
public class MvpPresenter_2<V extends MvpView_2> {

    //持有V层引用
    private V view;

    public V getView() {
        return view;
    }

    //绑定UI层
    public void attachView(V view){
        this.view = view;
    }

    //解除绑定
    public void detachView(){
        this.view = null;
    }

}
