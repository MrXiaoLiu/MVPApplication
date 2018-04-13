//package text.tao.com.myapplication.Gallery;
//
//import android.graphics.Rect;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.Adapter;
//import android.support.v7.widget.RecyclerView.ItemDecoration;
//import android.support.v7.widget.RecyclerView.LayoutParams;
//import android.support.v7.widget.RecyclerView.State;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//
//public class GalleryItemDecoration
//  extends RecyclerView.ItemDecoration
//{
//  public static int mItemComusemX = 0;
//  public static int mItemComusemY;
//  public static int mLeftPageVisibleWidth;
//  public static int mPageMargin = 0;
//  private final String TAG = "GalleryItemDecoration";
//  private GalleryRecyclerView.OnItemClickListener onItemClickListener;
//
//  static
//  {
//    mLeftPageVisibleWidth = 50;
//    mItemComusemY = 0;
//  }
//
//  private void onSetHoritiontalParams(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
//  {
//    int i = paramViewGroup.getWidth() - OsUtil.dpToPx(4 * mPageMargin + 2 * mLeftPageVisibleWidth);
//    int j = paramViewGroup.getHeight();
//    mItemComusemX = i + OsUtil.dpToPx(2 * mPageMargin);
//    DLog.d("GalleryItemDecoration", "onSetHoritiontalParams -->parent.width=" + paramViewGroup.getWidth() + ";mPageMargin=" + OsUtil.dpToPx(mPageMargin) + ";mLeftVis=" + OsUtil.dpToPx(mLeftPageVisibleWidth) + ";itemNewWidth=" + i);
//    int k;
//    if (paramInt1 == 0)
//    {
//      k = OsUtil.dpToPx(mLeftPageVisibleWidth + 2 * mPageMargin);
//      if (paramInt1 != paramInt2 - 1) {
//        break label173;
//      }
//    }
//    label173:
//    for (int m = OsUtil.dpToPx(mLeftPageVisibleWidth + 2 * mPageMargin);; m = OsUtil.dpToPx(mPageMargin))
//    {
//      setLayoutParams(paramView, k, 0, m, 0, i, j);
//      return;
//      k = OsUtil.dpToPx(mPageMargin);
//      break;
//    }
//  }
//
//  private void onSetVerticalParams(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
//  {
//    int i = paramViewGroup.getWidth();
//    int j = paramViewGroup.getHeight() - OsUtil.dpToPx(4 * mPageMargin + 2 * mLeftPageVisibleWidth);
//    mItemComusemY = j + OsUtil.dpToPx(2 * mPageMargin);
//    DLog.d("GalleryItemDecoration", "itemNewHeight=" + j);
//    int k;
//    if (paramInt1 == 0)
//    {
//      k = OsUtil.dpToPx(mLeftPageVisibleWidth + 2 * mPageMargin);
//      if (paramInt1 != paramInt2 - 1) {
//        break label133;
//      }
//    }
//    label133:
//    for (int m = OsUtil.dpToPx(mLeftPageVisibleWidth + 2 * mPageMargin);; m = OsUtil.dpToPx(mPageMargin))
//    {
//      setLayoutParams(paramView, 0, k, 0, m, i, j);
//      return;
//      k = OsUtil.dpToPx(mPageMargin);
//      break;
//    }
//  }
//
//  private void setLayoutParams(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
//  {
//    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
//    int i;
//    if ((localLayoutParams.leftMargin == paramInt1) && (localLayoutParams.topMargin == paramInt2) && (localLayoutParams.rightMargin == paramInt3))
//    {
//      int i1 = localLayoutParams.bottomMargin;
//      i = 0;
//      if (i1 == paramInt4) {}
//    }
//    else
//    {
//      localLayoutParams.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
//      i = 1;
//    }
//    int j = localLayoutParams.width;
//    int k = 0;
//    if (j != paramInt5)
//    {
//      localLayoutParams.width = paramInt5;
//      k = 1;
//    }
//    int m = localLayoutParams.height;
//    int n = 0;
//    if (m != paramInt6)
//    {
//      localLayoutParams.height = paramInt6;
//      n = 1;
//    }
//    if ((k != 0) || (i != 0) || (n != 0)) {
//      paramView.setLayoutParams(localLayoutParams);
//    }
//  }
//
//  public void getItemOffsets(Rect paramRect, final View paramView, final RecyclerView paramRecyclerView, RecyclerView.State paramState)
//  {
//    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
//    Log.d("GalleryItemDecoration", "getItemOffset() --> position = " + paramRecyclerView.getChildAdapterPosition(paramView));
//    final int i = paramRecyclerView.getChildAdapterPosition(paramView);
//    paramRecyclerView.post(new Runnable()
//    {
//      public void run()
//      {
//        if (((GalleryRecyclerView)paramRecyclerView).getOrientation() == 0)
//        {
//          GalleryItemDecoration.this.onSetHoritiontalParams(paramRecyclerView, paramView, i, this.val$itemCount);
//          return;
//        }
//        GalleryItemDecoration.this.onSetVerticalParams(paramRecyclerView, paramView, i, this.val$itemCount);
//      }
//    });
//    paramView.setOnClickListener(new OnClickListener()
//    {
//      public void onClick(View paramAnonymousView)
//      {
//        if (GalleryItemDecoration.this.onItemClickListener != null) {
//          GalleryItemDecoration.this.onItemClickListener.onItemClick(paramAnonymousView, i);
//        }
//      }
//    });
//  }
//
//  public void setOnItemClickListener(GalleryRecyclerView.OnItemClickListener paramOnItemClickListener)
//  {
//    this.onItemClickListener = paramOnItemClickListener;
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/GalleryItemDecoration.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */