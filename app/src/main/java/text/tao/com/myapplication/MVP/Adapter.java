//package text.tao.com.myapplication.MVP;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView.Adapter;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//public class Adapter
//  extends RecyclerView.Adapter<ViewHolder>
//{
//  private int[] mColors = { 2130903044, 2130903045, 2130903046, 2130903047, 2130903048, 2130903049 };
//  private Context mContext;
//
//  public Adapter(Context paramContext)
//  {
//    this.mContext = paramContext;
//  }
//
//  public int getItemCount()
//  {
//    return 50;
//  }
//
//  public void onBindViewHolder(ViewHolder paramViewHolder, final int paramInt)
//  {
//    paramViewHolder.img.setImageResource(this.mColors[(paramInt % this.mColors.length)]);
//    paramViewHolder.itemView.setOnClickListener(new OnClickListener()
//    {
//      public void onClick(View paramAnonymousView)
//      {
//        Toast.makeText(Adapter.this.mContext, "点击了：" + paramInt, 0).show();
//      }
//    });
//  }
//
//  public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
//  {
//    return new ViewHolder(LayoutInflater.from(this.mContext).inflate(2130968632, paramViewGroup, false));
//  }
//
//  class ViewHolder
//    extends RecyclerView.ViewHolder
//  {
//    ImageView img;
//
//    public ViewHolder(View paramView)
//    {
//      super();
//      this.img = ((ImageView)paramView.findViewById(2131689687));
//    }
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/MVP/Adapter.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */