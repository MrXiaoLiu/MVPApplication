package text.tao.com.myapplication.MVPDemo.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.List;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.section.StatelessSection;
import text.tao.com.myapplication.MVPDemo.section.ViewHolder;
import text.tao.com.myapplication.R;

public class ChaseIndexSection extends StatelessSection {
  List<IndexBean.HotCityBean> hot_city;
  List<IndexBean.PushStewardBean> push_steward;
  
  public ChaseIndexSection(List<IndexBean.HotCityBean> paramList, List<IndexBean.PushStewardBean> paramList1)
  {
    super(R.layout.acticity_main_demo,R.layout.acticity_main_demo, R.layout.acticity_main_demo);
    this.push_steward = paramList1;
    this.hot_city = paramList;
  }
  
  public void onBindFooterViewHolder(ViewHolder paramViewHolder)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramViewHolder.getView(R.id.recycle_view);
    localRecyclerView.setHasFixedSize(true);
    localRecyclerView.setNestedScrollingEnabled(false);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
    ChaseRecommendJPAdapter2 localChaseRecommendJPAdapter2 = new ChaseRecommendJPAdapter2(this.hot_city);
    localChaseRecommendJPAdapter2.openLoadAnimation(5);
    localRecyclerView.setAdapter(localChaseRecommendJPAdapter2);
  }
  
  public void onBindHeaderViewHolder(ViewHolder paramViewHolder)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramViewHolder.getView(R.id.recycle_view);
  }
  
  public void onBindItemViewHolder(ViewHolder paramViewHolder, int paramInt)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramViewHolder.getView(R.id.recycle_view);
    localRecyclerView.setHasFixedSize(true);
    localRecyclerView.setNestedScrollingEnabled(false);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
    ChaseRecommendJPAdapter chaseRecommendJPAdapter =new ChaseRecommendJPAdapter(this.push_steward);
    localRecyclerView.setAdapter(chaseRecommendJPAdapter);
  }
}