package text.tao.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 2018/4/13
 */

public class DargActivity extends AppCompatActivity {


    static final int REQUEST_CODE_CHOOSE = 123;
//    List<Integer> mSelected = new ArrayList<>();
    RecyclerView recycle_view;
    MyAdapter myAdapter;

    private ImmersionBar mImmersionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darg);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
                mImmersionBar.statusBarView(R.id.top_view)
//                .navigationBarColor(R.color.colorPrimary)
//                .fullScreen(true)
//                .addTag("PicAndColor")  //给上面参数打标记，以后可以通过标记恢复
                .init();

                findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getImage();
                    }
                });

//        for (int i=0;i<3;i++) {
//            mSelected.add(R.drawable.tim);
//            mSelected.add(R.drawable.meinv);
//            mSelected.add(R.drawable.time2);
//            mSelected.add(R.drawable.miss);
//            mSelected.add(R.drawable.timg);
//            mSelected.add(R.drawable.timgqq);
//            mSelected.add(R.drawable.timg1);
//            mSelected.add(R.drawable.timgsd);
//
//        }
//        recycle_view = findViewById(R.id.recycle_view);
//        recycle_view.setLayoutManager(new GridLayoutManager(this, 3));
//        myAdapter = new MyAdapter(mSelected);
//        recycle_view.setAdapter(myAdapter);
//
//        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//
//            }
//        });


    }

    void getImage(){
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofAll())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                .theme()//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(9)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .previewVideo(true)// 是否可预览视频 true or false
                .enablePreviewAudio(true) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
//                .enableCrop()// 是否裁剪 true or false
//                .compress()// 是否压缩 true or false
//                .glideOverride(30,30)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio()// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                .hideBottomControls()// 是否显示uCrop工具栏，默认不显示 true or false
//                .isGif()// 是否显示gif图片 true or false
//                .compressSavePath(getPath())//压缩图片保存地址
//                .freeStyleCropEnabled()// 裁剪框是否可拖拽 true or false
//                .circleDimmedLayer()// 是否圆形裁剪 true or false
//                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
//                .openClickSound()// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs()// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled() // 裁剪是否可旋转图片 true or false
//                .scaleEnabled()// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
                .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
                .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
                .isDragFrame(false)// 是否可拖动裁剪框(固定)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    Log.i("aaa","结果回调"+selectList);
                    break;
            }
        }
    }

    private class MyAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {


        List<Integer> mList;

        public MyAdapter(@Nullable List<Integer> data) {
            super(R.layout.adapter_itme2, data);
            this.mList = data;
        }

        @Override
        protected void convert(BaseViewHolder helper, Integer item) {

            Glide.with(this.mContext)
                    .load(item)
                    .into((ImageView) helper.getView(R.id.image));



        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("aaa","是不是空"+mImmersionBar);
        if (mImmersionBar!=null){
            mImmersionBar.destroy();
        }
    }
}