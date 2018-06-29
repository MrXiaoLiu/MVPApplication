package text.tao.com.myapplication.push;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

import text.tao.com.myapplication.AppApplication;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.DaggerServiceComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.ServiceModule;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/17
 */

public class BaseService extends IntentService {

    {
        Log.i("aaa", "空的");
        DaggerServiceComponent
                .builder()
                .appComponent(AppApplication.getInstance().getAppComponent())
                .serviceModule(new ServiceModule(this))
                .build()
                .inject(this);

    }

    @Inject
    BaseP mBaseP;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public BaseService() {
        super("BaseService");
        Log.i("aaa", "BaseService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Node node = intent.getParcelableExtra("node");
        Node2 p = mBaseP.getP("liu");
        Log.i("aaa", "onHandleIntent" + p.getRet());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i("aaa", "onDestroy" + mBaseP);
    }
}
