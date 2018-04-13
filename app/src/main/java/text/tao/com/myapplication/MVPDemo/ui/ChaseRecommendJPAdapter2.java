package text.tao.com.myapplication.MVPDemo.ui;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.R;

public class ChaseRecommendJPAdapter2
  extends BaseQuickAdapter<IndexBean.HotCityBean, BaseViewHolder>
{
  public ChaseRecommendJPAdapter2(@Nullable List<IndexBean.HotCityBean> paramList)
  {
    super(R.layout.adapter_itme2, paramList);
  }
  
  protected void convert(BaseViewHolder paramBaseViewHolder, IndexBean.HotCityBean paramHotCityBean)
  {
    Glide.with(this.mContext).load(paramHotCityBean.getImg()).centerCrop().placeholder(R.drawable.time2).dontAnimate().into((ImageView)paramBaseViewHolder.getView(R.id.image));
  }
}
