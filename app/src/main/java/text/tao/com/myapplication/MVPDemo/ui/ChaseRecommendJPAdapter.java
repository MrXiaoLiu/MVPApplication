package text.tao.com.myapplication.MVPDemo.ui;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.R;

public class ChaseRecommendJPAdapter
  extends BaseQuickAdapter<IndexBean.PushStewardBean, BaseViewHolder>
{
  public ChaseRecommendJPAdapter(@Nullable List<IndexBean.PushStewardBean> paramList)
  {
    super(R.layout.adapter_itme, paramList);
  }
  
  protected void convert(BaseViewHolder paramBaseViewHolder, IndexBean.PushStewardBean paramPushStewardBean)
  {
    Glide.with(this.mContext).load(paramPushStewardBean.getImg()).centerCrop().placeholder(R.drawable.time2).dontAnimate().into((ImageView)paramBaseViewHolder.getView(R.id.image));
    paramBaseViewHolder.setText(R.id.text, paramPushStewardBean.getBrief_sml());
  }
}