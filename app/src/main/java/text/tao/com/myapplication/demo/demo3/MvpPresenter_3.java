package text.tao.com.myapplication.demo.demo3;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import text.tao.com.myapplication.demo.demo2.MvpView_2;

//抽象类->高度抽象
public class MvpPresenter_3<V extends MvpView_2> {

    //持有V层引用
    private V view;
    private V proxyView;

    public V getView() {
        return this.proxyView;
    }

    //绑定UI层
    public void attachView(V view){
        this.view = view;
        //目标接口->MvpView
        ClassLoader loader = view.getClass().getClassLoader();
        Class<?>[] interfaces = view.getClass().getInterfaces();
        //目标对象->Activity(具体实现了我们的MvpView的Activity)
        ViewInvocationHandler handler = new ViewInvocationHandler(this.view);
        //代理对象
        proxyView = (V) Proxy.newProxyInstance(loader, interfaces, handler);
    }

    //解除绑定
    public void detachView(){
        this.view = null;
    }

    private class ViewInvocationHandler implements InvocationHandler {

        private V view;

        public ViewInvocationHandler(V view){
            this.view = view;
        }

        //代理对象->控制对目标对象访问
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            if (this.view != null){
                //你不等于null，我就立马回调ActivityUI层的方法
                return method.invoke(view, objects);
            }
            return null;
        }
    }

}
