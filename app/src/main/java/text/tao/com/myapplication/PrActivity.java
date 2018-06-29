package text.tao.com.myapplication;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.gyf.barlibrary.ImmersionBar;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import text.tao.com.myapplication.MVPDemo.BaseActivity;
import text.tao.com.myapplication.adapter.PrAdapter;
import text.tao.com.myapplication.adapter.PrBean;
import text.tao.com.myapplication.adapter.PrPresenter;
import text.tao.com.myapplication.adapter.PrView;
import text.tao.com.myapplication.databinding.ActivityPrBinding;
import text.tao.com.myapplication.databinding.ActivitySimpleBinding;

/**
 * MrLiu253@163.com
 *
 * @time 2018/4/13
 */

public class PrActivity extends BaseActivity<PrView, PrPresenter> implements PrView,BaseQuickAdapter.RequestLoadMoreListener,OnRefreshListener {


    @Inject
    PrPresenter mPresenter;
    ActivityPrBinding prBinding;
    ActivitySimpleBinding simpleBinding;
    List<PrBean.ServiceListBean> data = new ArrayList<>();
    PrAdapter prAdapter;
    int page = 1;
    boolean isOne = false;
    private ImmersionBar mImmersionBar;



    OnItemDragListener listener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.d("aaa", "drag start");
            BaseViewHolder holder = ((BaseViewHolder) viewHolder);
//                holder.setTextColor(R.id.tv, Color.WHITE);
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
            Log.d("aaa", "move from: " + source.getAdapterPosition() + " to: " + target.getAdapterPosition());
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.d("aaa", "drag end");
            BaseViewHolder holder = ((BaseViewHolder) viewHolder);
//                holder.setTextColor(R.id.tv, Color.BLACK);
        }
    };




    @Override
    protected void onitiv(Bundle paramBundle) {


        prBinding = DataBindingUtil.setContentView(this, R.layout.activity_pr);


        simpleBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_simple, null, false);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        mImmersionBar.statusBarView(R.id.top_view)
//                .navigationBarColor(R.color.white)
//                .fullScreen(true)
//                .addTag("PicAndColor")  //给上面参数打标记，以后可以通过标记恢复
                .init();

        StaggeredGridLayoutManager localLinearLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        prBinding.recycleView.setLayoutManager(localLinearLayoutManager);

        prBinding.refreshLayout.setEnableLoadMore(false);
        prBinding.refreshLayout.setOnRefreshListener(this);


        prAdapter = new PrAdapter(data);
        prAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);

        prAdapter.setHeaderView(simpleBinding.getRoot());


        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(20);
        paint.setColor(Color.BLACK);
        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.d("aaa", "view swiped start: " + pos);
                BaseViewHolder holder = ((BaseViewHolder) viewHolder);
//                holder.setTextColor(R.id.tv, Color.WHITE);
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.d("aaa", "View reset: " + pos);
                BaseViewHolder holder = ((BaseViewHolder) viewHolder);
//                holder.setTextColor(R.id.tv, Color.BLACK);
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.d("aaa", "View Swiped: " + pos);
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
                canvas.drawColor(ContextCompat.getColor(PrActivity.this, R.color.addsubutils_text));
                canvas.drawText("Just some text", 0, 40, paint);
            }
        };
        // 开启滑动删除
        prAdapter.enableSwipeItem();
        prAdapter.setOnItemSwipeListener(onItemSwipeListener);


        ItemDragAndSwipeCallback   mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(prAdapter);
//        mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
//
        mItemTouchHelper.attachToRecyclerView(  prBinding.recycleView);
//        //开启拖拽
        prAdapter.enableDragItem(mItemTouchHelper );
//        prAdapter.setOnItemDragListener(listener);


        //设置加载更多监听
        prAdapter.setOnLoadMoreListener(this, prBinding.recycleView);

        prBinding.recycleView.setAdapter(prAdapter);
        loadData();


        prAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

               Log.i("aaa","点击事件");
            }
        });
    }

    private void loadData() {

        for (int i =0;i<100;i++) {
            Log.i("aaa","延时="+i);
        }
        mPresenter.getList(page);
        Log.i("aaa","之后执行的线程名字="+Thread.currentThread().getName());
    }

    @Override
    public PrPresenter createPresenter() {
        return mPresenter;
    }

    @Override
    public PrView createView() {
        return this;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void complete() {
        Log.i("aaa", "完成");
    }

    @Override
    public void showError(String paramString) {
        Log.i("aaa", "错误" + paramString);
    }

    @Override
    public void onResult(PrBean prBean) {

        Log.i("aaa","当前线程的名字="+Thread.currentThread().getName());

        if (isOne){
            prBinding.refreshLayout.finishRefresh();
            data.clear();
            data.addAll(prBean.getService_list());
            prAdapter.setNewData(data);

        }else {
            if (prBean.getService_list().size()<30){
                prAdapter.loadMoreEnd();
            }else {
                prAdapter.addData(prBean.getService_list());
                prAdapter.loadMoreComplete();//加载完成
            }

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar!=null){
            mImmersionBar.destroy();
        }
    }

    @Override
    public void onLoadMoreRequested() {
        isOne = false;
        page++;
        loadData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        isOne = true;
        page = 1;
        loadData();
    }
}
