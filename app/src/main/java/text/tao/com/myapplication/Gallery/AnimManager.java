//package text.tao.com.myapplication.Gallery;
//
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.LayoutManager;
//import android.view.View;
//
//public class AnimManager
//{
//  public static final int ANIM_BOTTOM_TO_TOP = 0;
//  public static final int ANIM_TOP_TO_BOTTOM = 1;
//  private static AnimManager INSTANCE;
//  private static final String TAG = "AnimManager";
//  private float mAnimFactor = 0.2F;
//  private int mAnimType = 0;
//
//  public static AnimManager getInstance()
//  {
//    if (INSTANCE == null) {
//      INSTANCE = new AnimManager();
//    }
//    return INSTANCE;
//  }
//
//  private void setBottomToTopAnim(RecyclerView paramRecyclerView, int paramInt, float paramFloat)
//  {
//    View localView1 = paramRecyclerView.getLayoutManager().findViewByPosition(paramInt);
//    View localView2 = paramRecyclerView.getLayoutManager().findViewByPosition(paramInt + 1);
//    View localView3 = paramRecyclerView.getLayoutManager().findViewByPosition(paramInt - 1);
//    if (paramFloat <= 0.5D)
//    {
//      if (localView3 != null)
//      {
//        DLog.d("AnimManager", "mLeftView=" + (1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor) + "; position=" + paramInt + "; percent=" + paramFloat);
//        localView3.setScaleX(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//        localView3.setScaleY(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//      }
//      if (localView1 != null)
//      {
//        DLog.d("AnimManager", "mCurView=" + (1.0F - paramFloat * this.mAnimFactor) + "; position=" + paramInt + "; percent=" + paramFloat);
//        localView1.setScaleX(1.0F - paramFloat * this.mAnimFactor);
//        localView1.setScaleY(1.0F - paramFloat * this.mAnimFactor);
//      }
//      if (localView2 != null)
//      {
//        DLog.d("AnimManager", "mRightView=" + (1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor) + "; position=" + paramInt + "; percent=" + paramFloat);
//        localView2.setScaleX(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//        localView2.setScaleY(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//      }
//    }
//    do
//    {
//      return;
//      if (localView3 != null)
//      {
//        DLog.d("AnimManager", "mLeftView=" + (1.0F - paramFloat * this.mAnimFactor) + "; position=" + paramInt + "; percent=" + paramFloat);
//        localView3.setScaleX(1.0F - paramFloat * this.mAnimFactor);
//        localView3.setScaleY(1.0F - paramFloat * this.mAnimFactor);
//      }
//      if (localView1 != null)
//      {
//        DLog.d("AnimManager", "mCurView=" + (1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor) + "; position=" + paramInt + "; percent=" + paramFloat);
//        localView1.setScaleX(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//        localView1.setScaleY(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//      }
//    } while (localView2 == null);
//    DLog.d("AnimManager", "mRightView=" + (1.0F - paramFloat * this.mAnimFactor) + "; position=" + paramInt + "; percent=" + paramFloat);
//    localView2.setScaleX(1.0F - paramFloat * this.mAnimFactor);
//    localView2.setScaleY(1.0F - paramFloat * this.mAnimFactor);
//  }
//
//  private void setTopToBottomAnim(RecyclerView paramRecyclerView, int paramInt, float paramFloat)
//  {
//    View localView1 = paramRecyclerView.getLayoutManager().findViewByPosition(paramInt);
//    View localView2 = paramRecyclerView.getLayoutManager().findViewByPosition(paramInt + 1);
//    View localView3 = paramRecyclerView.getLayoutManager().findViewByPosition(paramInt - 1);
//    if (paramFloat <= 0.5D)
//    {
//      if (localView3 != null)
//      {
//        localView3.setScaleX(1.0F - paramFloat * this.mAnimFactor);
//        localView3.setScaleY(1.0F - paramFloat * this.mAnimFactor);
//      }
//      if (localView1 != null)
//      {
//        localView1.setScaleX(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//        localView1.setScaleY(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//      }
//      if (localView2 != null)
//      {
//        localView2.setScaleX(1.0F - paramFloat * this.mAnimFactor);
//        localView2.setScaleY(1.0F - paramFloat * this.mAnimFactor);
//      }
//    }
//    do
//    {
//      return;
//      if (localView3 != null)
//      {
//        localView3.setScaleX(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//        localView3.setScaleY(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//      }
//      if (localView1 != null)
//      {
//        localView1.setScaleX(1.0F - paramFloat * this.mAnimFactor);
//        localView1.setScaleY(1.0F - paramFloat * this.mAnimFactor);
//      }
//    } while (localView2 == null);
//    localView2.setScaleX(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//    localView2.setScaleY(1.0F - this.mAnimFactor + paramFloat * this.mAnimFactor);
//  }
//
//  public void setAnimation(RecyclerView paramRecyclerView, int paramInt, float paramFloat)
//  {
//    switch (this.mAnimType)
//    {
//    default:
//      setBottomToTopAnim(paramRecyclerView, paramInt, paramFloat);
//      return;
//    case 0:
//      setBottomToTopAnim(paramRecyclerView, paramInt, paramFloat);
//      return;
//    }
//    setTopToBottomAnim(paramRecyclerView, paramInt, paramFloat);
//  }
//
//  public void setmAnimFactor(float paramFloat)
//  {
//    this.mAnimFactor = paramFloat;
//  }
//
//  public void setmAnimType(int paramInt)
//  {
//    this.mAnimType = paramInt;
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/AnimManager.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */