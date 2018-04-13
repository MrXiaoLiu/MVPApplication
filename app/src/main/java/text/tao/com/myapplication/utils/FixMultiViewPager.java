//package text.tao.com.myapplication.utils;
//
//import android.content.Context;
//import android.support.v4.view.ViewPager;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
//
//public class FixMultiViewPager
//  extends ViewPager
//{
//  private static final String TAG = FixMultiViewPager.class.getSimpleName();
//
//  public FixMultiViewPager(Context paramContext)
//  {
//    super(paramContext);
//  }
//
//  public FixMultiViewPager(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    super(paramContext, paramAttributeSet);
//  }
//
//  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
//  {
//    try
//    {
//      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
//      return bool;
//    }
//    catch (IllegalArgumentException localIllegalArgumentException)
//    {
//      Log.w(TAG, "onInterceptTouchEvent() ", localIllegalArgumentException);
//      ThrowableExtension.printStackTrace(localIllegalArgumentException);
//    }
//    return false;
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/utils/FixMultiViewPager.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */