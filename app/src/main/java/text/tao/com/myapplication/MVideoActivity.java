package text.tao.com.myapplication;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import text.tao.com.myapplication.databinding.ActivityVideoBinding;
import text.tao.com.myapplication.databinding.AdapterItemBinding;


/**
 * MrLiu253@163.com
 *
 * @time 2018/4/23
 */

public class MVideoActivity extends AppCompatActivity {


    List<TextBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       ActivityVideoBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_video);


        for (int i=0;i<30;i++) {
            mList.add(new TextBean("测试"));
        }

        binding.recycleView.setHasFixedSize(true);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleView.setAdapter(new MyAdapter(mList,this));
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        List<TextBean> list;
        Context context;
        public MyAdapter(List<TextBean> list,Context context) {
            this.list = list;
            this.context = context;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            AdapterItemBinding binding = AdapterItemBinding.inflate(LayoutInflater.from(context),parent,false);
            return new MyViewHolder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//            AdapterItemBinding binding = DataBindingUtil.getBinding(holder.itemView);
            holder.mAdapterItemBinding.setText(list.get(position));
            holder.mAdapterItemBinding.executePendingBindings();
        }



        @Override
        public int getItemCount() {
            return list.size();
        }

       class MyViewHolder extends RecyclerView.ViewHolder{

            AdapterItemBinding mAdapterItemBinding;
           public MyViewHolder(View itemView) {
               super(itemView);
               mAdapterItemBinding =  DataBindingUtil.bind(itemView);
           }
       }
    }
}
