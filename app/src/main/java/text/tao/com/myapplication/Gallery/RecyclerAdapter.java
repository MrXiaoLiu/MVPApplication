//package text.tao.com.myapplication.Gallery;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.Adapter;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import java.util.List;
//
//public class RecyclerAdapter
//  extends RecyclerView.Adapter<MyHolder>
//{
//  private final String TAG = "RecyclerAdapter";
//  private Context mContext;
//  private List<Integer> mDatas;
//  private ViewGroup mParent;
//
//  public RecyclerAdapter(Context paramContext, List<Integer> paramList)
//  {
//    this.mContext = paramContext;
//    this.mDatas = paramList;
//  }
//
//  public int getItemCount()
//  {
//    return this.mDatas.size();
//  }
//
//  public int getResId(int paramInt)
//  {
//    if (this.mDatas == null) {
//      return 0;
//    }
//    return ((Integer)this.mDatas.get(paramInt)).intValue();
//  }
//
//  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
//  {
//    Log.d("RecyclerAdapter", "onAttachedToRecyclerView");
//    this.mParent = paramRecyclerView;
//    super.onAttachedToRecyclerView(paramRecyclerView);
//  }
//
//  public void onBindViewHolder(MyHolder paramMyHolder, int paramInt)
//  {
//    Log.d("RecyclerAdapter", "onBindViewHolder--> position = " + paramInt);
//    paramMyHolder.mView.setImageResource(((Integer)this.mDatas.get(paramInt)).intValue());
//  }
//
//  public MyHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
//  {
//    Log.d("RecyclerAdapter", "onCreateViewHolder width = " + paramViewGroup.getWidth());
//    return new MyHolder(LayoutInflater.from(this.mContext).inflate(2130968646, paramViewGroup, false));
//  }
//
//  class MyHolder
//    extends RecyclerView.ViewHolder
//  {
//    public final ImageView mView;
//
//    public MyHolder(View paramView)
//    {
//      super();
//      Log.d("RecyclerAdapter", "MyHolder");
//      this.mView = ((ImageView)paramView.findViewById(2131689710));
//    }
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/RecyclerAdapter.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */