package text.tao.com.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import text.tao.com.myapplication.MVPDemo.ui.MainDemoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_simple).setOnClickListener(this);
        findViewById(R.id.bt_project).setOnClickListener(this);
        findViewById(R.id.bt_skip).setOnClickListener(this);
        findViewById(R.id.bt_darg).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_simple://mvp简单搭建到双重代理搭建
                startActivity(new Intent(MainActivity.this,SimpleActivity.class));
                break;
            case R.id.bt_project://双重代理实战应用
                startActivity(new Intent(MainActivity.this,MainDemoActivity.class));
                break;
            case R.id.bt_skip:
                break;
            case R.id.bt_darg:
                break;
            default:
        }
    }
}
