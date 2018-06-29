package text.tao.com.myapplication.MVPDemo.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import javax.inject.Inject;

import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.BaseActivity;
import text.tao.com.myapplication.MVPDemo.login.LoginPresenter;
import text.tao.com.myapplication.MVPDemo.login.LoginView;
import text.tao.com.myapplication.MVPDemo.section.SectionedRVAdapter;
import text.tao.com.myapplication.R;

public class MainDemoActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {
    @Inject
    LoginPresenter mPresenter;


    SectionedRVAdapter mSectionedAdapter;
    RecyclerView recycle_view;



    public void complete() {
        Log.i("aaa", "complete请求数据完成");
    }

    public void showError(String paramString) {
        Log.i("aaa", "showError请求数据出错" + paramString);
    }

    public LoginPresenter createPresenter() {
        return this.mPresenter;
    }

    public LoginView createView() {
        return this;
    }


    @Override
    protected void onitiv(Bundle paramBundle) {
             setContentView( R.layout.acticity_main_demo);

        this.recycle_view = ((RecyclerView) findViewById(R.id.recycle_view));


        recycle_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    Glide.with(MainDemoActivity.this).resumeRequests();
                }else {
//                    Glide.with(MainDemoActivity.this).pauseRequests();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        //获取数据
        ((LoginPresenter) getMvpPresenter()).login("184", "111111", "86");


        //设置公共适配器
        this.mSectionedAdapter = new SectionedRVAdapter();
        this.recycle_view.setHasFixedSize(true);
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
        this.recycle_view.setLayoutManager(localLinearLayoutManager);
        this.recycle_view.setAdapter(this.mSectionedAdapter);
    }


    protected void initInject() {
        getActivityComponent().inject(this);
    }


    public void onLoginResult(IndexBean paramIndexBean) {
        //设置数据
        this.mSectionedAdapter.addSection(new ChaseIndexSection(paramIndexBean.getHot_city(), paramIndexBean.getPush_steward()));
        this.mSectionedAdapter.notifyDataSetChanged();

    }


}