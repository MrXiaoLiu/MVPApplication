//package text.tao.com.myapplication.MVPDemo
//
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//
//import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
//
//import me.imid.swipebacklayout.lib.SwipeBackLayout
//import me.imid.swipebacklayout.lib.Utils
//import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase
//import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper
//import text.tao.com.myapplication.AppApplication
//import text.tao.com.myapplication.MVPDemo.Api.dagger2.ActivityComponent
//import text.tao.com.myapplication.MVPDemo.Api.dagger2.ActivityModule
//import text.tao.com.myapplication.MVPDemo.Api.dagger2.DaggerActivityComponent
//import text.tao.com.myapplication.MVPDemo.rx.RxPresenter
//import text.tao.com.myapplication.MVPDemo.support.ActivityMvpDelegate
//import text.tao.com.myapplication.MVPDemo.support.ActivityMvpDelegateImpl
//import text.tao.com.myapplication.MVPDemo.support.MvpCallback
//
//
////父类->基类->动态指定类型->泛型设计(通过泛型指定动态类型->由子类指定，父类只需要规定类型范围即可)
////第一重代理->代理对象->第三个角色：代理对象->BaseActivity
////第二重代理->目标对象->第二个角色->具体的P和V由子类决定
//abstract class BaseActivity<V : BaseView, P : RxPresenter<V>> : RxAppCompatActivity(), MvpCallback<V, P>, SwipeBackActivityBase {
//
//
//    private var mHelper: SwipeBackActivityHelper? = null
//    private var mvpDelegate: ActivityMvpDelegate<V, P>? = null
//
//    private var presenter: P? = null
//    private var view: V? = null
//
//
//    protected val activityComponent: ActivityComponent
//        get() = DaggerActivityComponent.builder().appComponent(AppApplication.getInstance().appComponent).activityModule(activityModule).build()
//
//    protected val activityModule: ActivityModule
//        get() = ActivityModule(this)
//
//    private fun getMvpDelegate(): ActivityMvpDelegate<V, P> {
//        if (this.mvpDelegate == null) {
//            this.mvpDelegate = ActivityMvpDelegateImpl(this)
//        }
//        return this.mvpDelegate
//    }
//
//    override fun createPresenter(): P? {
//        return this.presenter
//    }
//
//    override fun getMvpPresenter(): P? {
//        return this.presenter
//    }
//
//    override fun setMvpPresenter(paramP: P) {
//        this.presenter = paramP
//    }
//
//
//    override fun createView(): V? {
//        return this.view
//    }
//
//    override fun getMvpView(): V? {
//        return this.view
//    }
//
//    override fun setMvpView(paramV: V) {
//        this.view = paramV
//    }
//
//    override fun onCreate(paramBundle: Bundle?) {
//        super.onCreate(paramBundle)
//
//        mHelper = SwipeBackActivityHelper(this)
//        mHelper!!.onActivityCreate()
//
//        initInject()
//
//        getMvpDelegate().onCreate(paramBundle)
//        onitiv(paramBundle)
//
//
//    }
//
//    override fun onPostCreate(savedInstanceState: Bundle?) {
//        super.onPostCreate(savedInstanceState)
//        mHelper!!.onPostCreate()
//    }
//
//    override fun findViewById(id: Int): View? {
//        val v = super.findViewById<View>(id)
//        return if (v == null && mHelper != null) {
//            mHelper!!.findViewById(id)
//        } else v
//    }
//
//    override fun getSwipeBackLayout(): SwipeBackLayout {
//        return mHelper!!.swipeBackLayout
//    }
//
//    override fun setSwipeBackEnable(enable: Boolean) {
//        swipeBackLayout.setEnableGesture(enable)
//    }
//
//    override fun scrollToFinishActivity() {
//        Utils.convertActivityToTranslucent(this)
//        swipeBackLayout.scrollToFinishActivity()
//    }
//
//    protected abstract fun onitiv(paramBundle: Bundle?)
//
//    protected open fun initInject() {}
//
//
//    override fun onStart() {
//        super.onStart()
//        getMvpDelegate().onStart()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        getMvpDelegate().onResume()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        getMvpDelegate().onPause()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        getMvpDelegate().onStop()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        getMvpDelegate().onDestroy()
//    }
//}
//
//
