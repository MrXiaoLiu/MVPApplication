//package text.tao.com.myapplication.view.RemoteControl;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView.Adapter;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnLongClickListener;
//import android.view.ViewGroup;
//import android.widget.AdapterView.OnItemLongClickListener;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyAdapter
//  extends RecyclerView.Adapter<ViewHolder>
//{
//  private Context mContext;
//  private List<DraggableInfo> mData = new ArrayList();
//  private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
//
//  public MyAdapter(Context paramContext, List<DraggableInfo> paramList)
//  {
//    this.mContext = paramContext;
//    this.mData = paramList;
//  }
//
//  public DraggableInfo getItem(int paramInt)
//  {
//    return (DraggableInfo)this.mData.get(Math.max(0, paramInt));
//  }
//
//  public int getItemCount()
//  {
//    return this.mData.size();
//  }
//
//  public void onBindViewHolder(ViewHolder paramViewHolder, final int paramInt)
//  {
//    if (((DraggableInfo)this.mData.get(paramInt)).getType() == 1) {
//      paramViewHolder.mButton.setText(((DraggableInfo)this.mData.get(paramInt)).getText());
//    }
//    for (;;)
//    {
//      paramViewHolder.itemView.setOnLongClickListener(new OnLongClickListener()
//      {
//        public boolean onLongClick(View paramAnonymousView)
//        {
//          MyAdapter.this.mOnItemLongClickListener.onItemLongClick(null, paramAnonymousView, paramInt, paramInt);
//          return false;
//        }
//      });
//      return;
//      paramViewHolder.mButton.setImageResource(((DraggableInfo)this.mData.get(paramInt)).getPic());
//    }
//  }
//
//  public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
//  {
//    return new ViewHolder(LayoutInflater.from(this.mContext).inflate(2130968641, paramViewGroup, false));
//  }
//
//  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
//  {
//    this.mOnItemLongClickListener = paramOnItemLongClickListener;
//  }
//
//  public class ViewHolder
//    extends RecyclerView.ViewHolder
//  {
//    private DraggableButton mButton;
//
//    ViewHolder(View paramView)
//    {
//      super();
//      this.mButton = ((DraggableButton)paramView.findViewById(2131689704));
//    }
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/RemoteControl/MyAdapter.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */