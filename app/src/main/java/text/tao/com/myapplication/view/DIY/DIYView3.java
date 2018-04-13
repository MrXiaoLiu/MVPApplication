package text.tao.com.myapplication.view.DIY;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class DIYView3
  extends FrameLayout
{
  private static String TAG = "DIYView";
  private ViewDragHelper mDragHelper = ViewDragHelper.create(this, new Callback()
  {
    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.i("aaa", "left拖拽位置" + paramAnonymousInt1);
      return paramAnonymousInt1;
    }
    
    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.i("aaa", "top拖拽位置" + paramAnonymousInt1);
      return paramAnonymousInt1;
    }
    
    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      super.onViewReleased(paramAnonymousView, paramAnonymousFloat1, paramAnonymousFloat2);
    }
    
    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      return true;
    }
  });
  
  public DIYView3(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DIYView3(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DIYView3(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    return true;
  }
}