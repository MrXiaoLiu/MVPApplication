package text.tao.com.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import text.tao.com.myapplication.MVPDemo.ui.MainDemoActivity;
import text.tao.com.myapplication.push.PushActivity2;
import text.tao.com.myapplication.push.ui.PushActivity;
import text.tao.com.myapplication.utils.BaseApi;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        findViewById(R.id.bt_simple).setOnClickListener(this);
        findViewById(R.id.bt_project).setOnClickListener(this);
        findViewById(R.id.bt_skip).setOnClickListener(this);
        findViewById(R.id.bt_darg).setOnClickListener(this);
        findViewById(R.id.mvideo).setOnClickListener(this);
        findViewById(R.id.calendar).setOnClickListener(this);
        findViewById(R.id.animation).setOnClickListener(this);
        findViewById(R.id.push).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_simple://mvp简单搭建到双重代理搭建
//                startActivity(new Intent(MainActivity.this,SimpleActivity.class));

                ARouter.getInstance().build(BaseApi.simple).navigation();
                break;
            case R.id.bt_project://双重代理实战应用
                startActivity(new Intent(MainActivity.this,MainDemoActivity.class));
                break;
            case R.id.bt_skip://跳过按钮自定义
                startActivity(new Intent(MainActivity.this,SkipActivity.class));
                break;
            case R.id.bt_darg://拖拽
                startActivity(new Intent(MainActivity.this,DargActivity.class));
                break;
            case R.id.mvideo://视频
                startActivity(new Intent(MainActivity.this,MVideoActivity.class));
                break;
            case R.id.calendar://日历
                startActivity(new Intent(MainActivity.this,CalendarActivity.class));
                break;
            case R.id.animation://databinding
                startActivity(new Intent(MainActivity.this,PrActivity.class));
                break;
            case R.id.push://databinding
                startActivity(new Intent(MainActivity.this,PushActivity2.class));
                break;
            default:
        }
    }
}
