//package text.tao.com.myapplication.view.DIY;
//
//import android.content.Context;
//import android.graphics.Rect;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.view.ViewCompat;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewConfiguration;
//import android.widget.FrameLayout;
//
//public class DIYView
//  extends FrameLayout
//{
//  private static String TAG = "DIYView";
//  State mCurrentState;
//  private View mDragView;
//  private float mLastPointX;
//  private float mLastPointY;
//  private int mSlop;
//
//  public DIYView(@NonNull Context paramContext)
//  {
//    super(paramContext);
//  }
//
//  public DIYView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
//  {
//    super(paramContext, paramAttributeSet);
//  }
//
//  public DIYView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
//  {
//    super(paramContext, paramAttributeSet, paramInt);
//    this.mSlop = ViewConfiguration.getWindowTouchSlop();
//  }
//
//  private boolean isPointOnViews(MotionEvent paramMotionEvent)
//  {
//    Rect localRect = new Rect();
//    for (int i = -1 + getChildCount();; i--)
//    {
//      int j = 0;
//      if (i >= 0)
//      {
//        View localView = getChildAt(i);
//        localRect.set((int)localView.getX(), (int)localView.getY(), (int)localView.getX() + localView.getWidth(), (int)localView.getY() + localView.getHeight());
//        if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
//        {
//          this.mDragView = localView;
//          j = 1;
//        }
//      }
//      else
//      {
//        if ((j == 0) || (this.mCurrentState == State.DRAGGING)) {
//          break;
//        }
//        return true;
//      }
//    }
//    return false;
//  }
//
//  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
//  {
//    return true;
//  }
//
//  public boolean onTouchEvent(MotionEvent paramMotionEvent)
//  {
//    switch (paramMotionEvent.getAction())
//    {
//    }
//    for (;;)
//    {
//      return true;
//      if (isPointOnViews(paramMotionEvent))
//      {
//        this.mCurrentState = State.DRAGGING;
//        this.mLastPointX = paramMotionEvent.getX();
//        this.mLastPointY = paramMotionEvent.getY();
//        continue;
//        int i = (int)(paramMotionEvent.getX() - this.mLastPointX);
//        int j = (int)(paramMotionEvent.getY() - this.mLastPointY);
//        if ((this.mCurrentState == State.DRAGGING) && (this.mDragView != null) && ((Math.abs(i) > this.mSlop) || (Math.abs(j) > this.mSlop)))
//        {
//          ViewCompat.offsetLeftAndRight(this.mDragView, i);
//          ViewCompat.offsetTopAndBottom(this.mDragView, j);
//          this.mLastPointX = paramMotionEvent.getX();
//          this.mLastPointY = paramMotionEvent.getY();
//          continue;
//          if (this.mCurrentState == State.DRAGGING)
//          {
//            this.mCurrentState = State.IDLE;
//            this.mDragView = null;
//          }
//        }
//      }
//    }
//  }
//
//  static enum State
//  {
//    static
//    {
//      DRAGGING = new State("DRAGGING", 1);
//      State[] arrayOfState = new State[2];
//      arrayOfState[0] = IDLE;
//      arrayOfState[1] = DRAGGING;
//      $VALUES = arrayOfState;
//    }
//
//    private State() {}
//  }
//}