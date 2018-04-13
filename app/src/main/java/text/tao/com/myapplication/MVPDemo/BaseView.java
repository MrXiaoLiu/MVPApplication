package text.tao.com.myapplication.MVPDemo;


//MVP框架里面: 高度抽象UI回调接口
public interface BaseView {
    void complete();

    void showError(String paramString);
}
