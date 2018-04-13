//package text.tao.com.myapplication.utils;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.util.DisplayMetrics;
//import android.util.TypedValue;
//import android.view.View;
//import android.view.ViewGroup.MarginLayoutParams;
//
//public class MeasureUtils
//{
//  private MeasureUtils()
//  {
//    throw new AssertionError();
//  }
//
//  public static float dp2px(Context paramContext, float paramFloat)
//  {
//    return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
//  }
//
//  public static DisplayMetrics getDisplayMetrics(Context paramContext)
//  {
//    if (paramContext == null) {
//      return null;
//    }
//    return paramContext.getResources().getDisplayMetrics();
//  }
//
//  public static int getMeasuredWidthWithMargins(View paramView)
//  {
//    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
//    return paramView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
//  }
//
//  public static int[] getViewLocation(View paramView)
//  {
//    int[] arrayOfInt = new int[2];
//    paramView.getLocationOnScreen(arrayOfInt);
//    return arrayOfInt;
//  }
//
//  public static float sp2px(Context paramContext, float paramFloat)
//  {
//    return TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/utils/MeasureUtils.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */