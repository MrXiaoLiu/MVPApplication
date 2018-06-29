package text.tao.com.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import text.tao.com.myapplication.databinding.ActivitySkipBinding;
import text.tao.com.myapplication.utils.CountTimerView;
import text.tao.com.myapplication.view.AddSubUtils;
import text.tao.com.myapplication.view.MovingImageView;


/**
 * MrLiu253@163.com
 *
 * @time 2018/4/13
 */

public class SkipActivity extends AppCompatActivity implements AddSubUtils.OnWarnListener,AddSubUtils.OnChangeValueListener {

    CountTimerView countTimerView;
    MovingImageView mMovingImageView;
    AddSubUtils addSubUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivitySkipBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_skip);


        addSubUtils = findViewById(R.id.addsubutils);

        binding.addsubutils.setOnWarnListener(this);
        binding.addsubutils.setOnChangeValueListener(this);



        countTimerView = new CountTimerView(  binding.mtime);
        binding.mtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countTimerView!=null&&  binding.mtime.getText().toString().trim().equals("倒计时")){
                    countTimerView.start();
                }else if (countTimerView!=null){
                    countTimerView.start();
                }

            }
        });



        binding.movingImage.setOnClickListener(sssssssss -> binding.movingImage.startMoving());



//        RxView.clicks(View)
//                .throttleFirst(3, TimeUnit.SECONDS)//3秒内响应第一次发射数据
//                .compose(集成RXActivity)
//                .subscribe(object -> redirect());
    }

    @Override
    public void onWarningForInventory(int inventory) {
        Log.i("aaa","onWarningForInventory="+inventory);
    }

    @Override
    public void onWarningForBuyMax(int max) {
        Log.i("aaa","onWarningForBuyMax="+max);
    }

    @Override
    public void onWarningForBuyMin(int min) {
        Log.i("aaa","onWarningForBuyMin="+min);
    }

    @Override
    public void onChangeValue(int value, int position) {
        Log.i("aaa","onChangeValue="+value+"onChangeValue="+position);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countTimerView!=null)
            countTimerView.cancel();
        if (mMovingImageView!=null)
            mMovingImageView.stopMoving();
    }
}
