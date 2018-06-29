package text.tao.com.myapplication.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/7
 */

public class ImageViewAttrAdapter {
    /**
     * 电影列表图片
     */
    @BindingAdapter("android:prImage")
    public static void prImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
