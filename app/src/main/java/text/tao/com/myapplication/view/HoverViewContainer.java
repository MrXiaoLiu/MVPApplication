//package text.tao.com.myapplication.view;
//
//import android.content.Context;
//import android.support.v4.view.ViewCompat;
//import android.support.v4.widget.ViewDragHelper;
//import android.support.v4.widget.ViewDragHelper.Callback;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.FrameLayout;
//import android.widget.FrameLayout.LayoutParams;
//
//public class HoverViewContainer
//  extends FrameLayout
//  implements ViewStateManager
//{
//  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
//  HoverView EMPTY_VIEW;
//  private final String TAG = getClass().getSimpleName();
//  private DragCallback mBottomCallback = new DragCallback(null);
//  private ViewDragHelper mBottomDragger;
//  private HoverView mBottomView;
//  private Context mContext;
//  private ViewState mViewState = ViewState.CLOSE;
//
//  public HoverViewContainer(Context paramContext)
//  {
//    super(paramContext);
//    init(paramContext);
//  }
//
//  public HoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    super(paramContext, paramAttributeSet);
//    init(paramContext);
//  }
//
//  public HoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
//  {
//    super(paramContext, paramAttributeSet, paramInt);
//    init(paramContext);
//  }
//
//  private HoverView findHoverView()
//  {
//    for (int i = 0; i < getChildCount(); i++) {
//      if ((getChildAt(i) instanceof HoverView)) {
//        return (HoverView)getChildAt(i);
//      }
//    }
//    return this.EMPTY_VIEW;
//  }
//
//  private void init(Context paramContext)
//  {
//    this.mContext = paramContext;
//    this.mBottomDragger = ViewDragHelper.create(this, 1.0F, this.mBottomCallback);
//    Log.i("aaa", "底部边缘位置是多少8");
//    this.mBottomDragger.setEdgeTrackingEnabled(8);
//    this.EMPTY_VIEW = new HoverView(paramContext);
//    this.EMPTY_VIEW.setLayoutParams(new LayoutParams(0, 0));
//  }
//
//  private void scrollTo(int paramInt)
//  {
//    ViewCompat.offsetTopAndBottom(this.mBottomView, paramInt - getTop());
//    ViewCompat.postInvalidateOnAnimation(this);
//  }
//
//  private void smoothScrollTo(int paramInt)
//  {
//    this.mBottomDragger.smoothSlideViewTo(this.mBottomView, 0, paramInt);
//    ViewCompat.postInvalidateOnAnimation(this);
//  }
//
//  public void changeState(ViewState paramViewState)
//  {
//    changeState(paramViewState, true);
//  }
//
//  public void changeState(ViewState paramViewState, boolean paramBoolean)
//  {
//    this.mViewState = paramViewState;
//    if (paramBoolean)
//    {
//      smoothScrollTo(getTopOfState(paramViewState));
//      return;
//    }
//    scrollTo(getTopOfState(paramViewState));
//  }
//
//  public void computeScroll()
//  {
//    if (this.mBottomDragger.continueSettling(true)) {
//      ViewCompat.postInvalidateOnAnimation(this);
//    }
//  }
//
//  public ViewState getState()
//  {
//    return this.mViewState;
//  }
//
//  int getTopOfState(ViewState paramViewState)
//  {
//    return paramViewState.getTop(this.mBottomView);
//  }
//
//  protected void onFinishInflate()
//  {
//    super.onFinishInflate();
//    this.mBottomView = findHoverView();
//    if (this.mBottomView == this.EMPTY_VIEW) {
//      addView(this.EMPTY_VIEW);
//    }
//  }
//
//  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
//  {
//    return this.mBottomDragger.shouldInterceptTouchEvent(paramMotionEvent);
//  }
//
//  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
//  {
//    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
//    changeState(ViewState.CLOSE, false);
//    Log.i("aaa", "是否向下滑动onLayout");
//  }
//
//  public boolean onTouchEvent(MotionEvent paramMotionEvent)
//  {
//    this.mBottomDragger.processTouchEvent(paramMotionEvent);
//    return true;
//  }
//
//  private class DragCallback
//    extends Callback
//  {
//    private DragCallback() {}
//
//    private void setClosestStateIfBetween(ViewState paramViewState1, ViewState paramViewState2, int paramInt)
//    {
//      int i = HoverViewContainer.this.getTopOfState(paramViewState1);
//      int j = HoverViewContainer.this.getTopOfState(paramViewState2);
//      StringBuilder localStringBuilder;
//      if ((paramInt >= i) && (paramInt <= j))
//      {
//        HoverViewContainer localHoverViewContainer = HoverViewContainer.this;
//        if (paramInt < (i + j) / 2) {
//          localHoverViewContainer.changeState(paramViewState1);
//        }
//      }
//      else
//      {
//        localStringBuilder = new StringBuilder().append("是否向下滑动changeState");
//        if ((paramInt < i) || (paramInt > j)) {
//          break label106;
//        }
//      }
//      label106:
//      for (boolean bool = true;; bool = false)
//      {
//        Log.i("aaa", bool);
//        return;
//        paramViewState1 = paramViewState2;
//        break;
//      }
//    }
//
//    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
//    {
//      if (paramView == HoverViewContainer.this.mBottomView) {
//        return Math.max(paramInt1, ViewState.FILL.getTop(HoverViewContainer.this.mBottomView));
//      }
//      return paramInt1;
//    }
//
//    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
//    {
//      if (paramView == HoverViewContainer.this.mBottomView)
//      {
//        int i = paramView.getTop();
//        setClosestStateIfBetween(ViewState.FILL, ViewState.HOVER, i);
//        setClosestStateIfBetween(ViewState.HOVER, ViewState.CLOSE, i);
//      }
//    }
//
//    public boolean tryCaptureView(View paramView, int paramInt)
//    {
//      return paramView == HoverViewContainer.this.mBottomView;
//    }
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/HoverViewContainer.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */