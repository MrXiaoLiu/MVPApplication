package text.tao.com.myapplication.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import text.tao.com.myapplication.R;
import text.tao.com.myapplication.databinding.PrAdapterItme2Binding;


/**
 * MrLiu253@163.com
 *
 * @time 2018/5/7
 */

public class PrAdapter extends BaseItemDraggableAdapter<PrBean.ServiceListBean, BaseViewHolder> {


    public PrAdapter(@Nullable List<PrBean.ServiceListBean> data) {

        super(R.layout.pr_adapter_itme2, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PrBean.ServiceListBean item) {

        Log.i("aaa","加载第几个");
        PrAdapterItme2Binding binding =  DataBindingUtil.bind(helper.itemView);
        binding.setPrbaen(item);
        binding.executePendingBindings();
//        Glide.with(this.mContext)
//                .load(item.getImg())
//                .into((ImageView) helper.getView(R.id.pr_image));

    }
}
