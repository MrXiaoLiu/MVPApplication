//package text.tao.com.myapplication.view.DIY;
//
//import android.animation.Animator;
//import android.animation.AnimatorListenerAdapter;
//import android.animation.AnimatorSet;
//import android.animation.ValueAnimator;
//import android.animation.ValueAnimator.AnimatorUpdateListener;
//import android.content.Context;
//import android.graphics.Rect;
//import android.support.annotation.NonNull;
//import android.support.v4.view.ViewCompat;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewConfiguration;
//import android.widget.FrameLayout;
//
//public class DIYView2
//  extends FrameLayout
//{
//  private static String TAG = "DIYView";
//  State mCurrentState;
//  private View mDragView;
//  private float mDragViewOrigX;
//  private float mDragViewOrigY;
//  private float mLastPointX;
//  private float mLastPointY;
//  private int mSlop;
//
//  public DIYView2(@NonNull Context paramContext)
//  {
//    super(paramContext);
//  }
//
//  public DIYView2(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    this(paramContext, paramAttributeSet, 0);
//  }
//
//  public DIYView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
//          this.mDragViewOrigX = this.mDragView.getX();
//          this.mDragViewOrigY = this.mDragView.getY();
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
//  public boolean onTouchEvent(MotionEvent paramMotionEvent)
//  {
//    switch (paramMotionEvent.getAction())
//    {
//    }
//    do
//    {
//      int i;
//      int j;
//      do
//      {
//        do
//        {
//          return true;
//        } while (!isPointOnViews(paramMotionEvent));
//        this.mCurrentState = State.DRAGGING;
//        this.mLastPointX = paramMotionEvent.getX();
//        this.mLastPointY = paramMotionEvent.getY();
//        return true;
//        i = (int)(paramMotionEvent.getX() - this.mLastPointX);
//        j = (int)(paramMotionEvent.getY() - this.mLastPointY);
//      } while ((this.mCurrentState != State.DRAGGING) || (this.mDragView == null) || ((Math.abs(i) <= this.mSlop) && (Math.abs(j) <= this.mSlop)));
//      ViewCompat.offsetLeftAndRight(this.mDragView, i);
//      ViewCompat.offsetTopAndBottom(this.mDragView, j);
//      this.mLastPointX = paramMotionEvent.getX();
//      this.mLastPointY = paramMotionEvent.getY();
//      return true;
//    } while (this.mCurrentState != State.DRAGGING);
//    if (this.mDragView != null)
//    {
//      float[] arrayOfFloat1 = new float[2];
//      arrayOfFloat1[0] = this.mDragView.getX();
//      arrayOfFloat1[1] = this.mDragViewOrigX;
//      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(arrayOfFloat1);
//      localValueAnimator1.addUpdateListener(new AnimatorUpdateListener()
//      {
//        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
//        {
//          DIYView2.this.mDragView.setX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
//        }
//      });
//      float[] arrayOfFloat2 = new float[2];
//      arrayOfFloat2[0] = this.mDragView.getY();
//      arrayOfFloat2[1] = this.mDragViewOrigY;
//      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(arrayOfFloat2);
//      localValueAnimator2.addUpdateListener(new AnimatorUpdateListener()
//      {
//        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
//        {
//          DIYView2.this.mDragView.setY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
//        }
//      });
//      AnimatorSet localAnimatorSet = new AnimatorSet();
//      localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
//      localAnimatorSet.addListener(new AnimatorListenerAdapter()
//      {
//        public void onAnimationEnd(Animator paramAnonymousAnimator)
//        {
//          super.onAnimationEnd(paramAnonymousAnimator);
//          DIYView2.access$002(DIYView2.this, null);
//        }
//      });
//      localAnimatorSet.start();
//    }
//    for (;;)
//    {
//      this.mCurrentState = State.IDLE;
//      return true;
//      this.mDragView = null;
//    }
//  }
//
//  static enum State {
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
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/DIY/DIYView2.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */