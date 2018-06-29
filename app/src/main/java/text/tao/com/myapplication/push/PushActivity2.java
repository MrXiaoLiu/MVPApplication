package text.tao.com.myapplication.push;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import text.tao.com.myapplication.MVPDemo.BaseActivity;
import text.tao.com.myapplication.R;
import text.tao.com.myapplication.push.ui.BackService;
import text.tao.com.myapplication.push.ui.BackService2;
import text.tao.com.myapplication.push.ui.PushPresenter;
import text.tao.com.myapplication.push.ui.PushView;


/**
 * MrLiu253@163.com
 *
 * @time 2018/5/14
 */

public class PushActivity2 extends BaseActivity<PushView, PushPresenter> implements View.OnClickListener, PushView {


    @Inject
    PushPresenter mPresenter;

    @Override
    protected void onitiv(Bundle paramBundle) {
        setContentView(R.layout.activity_push);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

//        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);




//        mIntentFilter = new IntentFilter();
//        mIntentFilter.addAction(BackService.HEART_BEAT_ACTION);
//        mIntentFilter.addAction(BackService.MESSAGE_ACTION);

        mPresenter.login("liu");
    }

    @Override
    public PushPresenter createPresenter() {
        return this.mPresenter;
    }

    @Override
    public PushView createView() {
        return this;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
//                try {
////                    boolean isSend = iBackService.sendMessage("h");//Send Content by socket
////                    Toast.makeText(this, isSend ? "success" : "fail", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

                break;
            case R.id.button2:
                break;
        }
    }

    @Override
    public void complete() {
        Log.i("aaa", "请求完成");
    }

    @Override
    public void showError(String paramString) {
        Log.i("aaa", "请求出错" + paramString);
    }

    @Override
    public void onLoginResult(Node node) {
        Log.i("aaa", "请求完成");
        mServiceIntent = new Intent(this, BackService2.class);
        mServiceIntent.putExtra("node",node);
        startService(mServiceIntent);

//        AlarmManager alarmManager = new AlarmManager();
    }


    private static final String TAG = "MainActivity";

//    private IBackService iBackService;
//
//    private ServiceConnection conn = new ServiceConnection() {
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            iBackService = null;
//
//        }
//
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            iBackService = IBackService.Stub.asInterface(service);
//        }
//    };

    private Intent mServiceIntent;

    class MessageBackReciver extends BroadcastReceiver {
        private WeakReference<TextView> textView;

        public MessageBackReciver(TextView tv) {
            textView = new WeakReference<TextView>(tv);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            TextView tv = textView.get();
            if (action.equals(BackService.HEART_BEAT_ACTION)) {
                if (null != tv) {
                    tv.setText("Get a heart heat");
                }
            } else {
                String message = intent.getStringExtra("message");
                tv.setText(message);
            }
        };
    }

    private MessageBackReciver mReciver;

    private IntentFilter mIntentFilter;

//    private LocalBroadcastManager mLocalBroadcastManager;


    @Override
    protected void onStart() {
        super.onStart();
//        mLocalBroadcastManager.registerReceiver(mReciver, mIntentFilter);
//        bindService(mServiceIntent, conn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unbindService(conn);
//        mLocalBroadcastManager.unregisterReceiver(mReciver);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("aaa","Activity_onDestroy");
    }
}
