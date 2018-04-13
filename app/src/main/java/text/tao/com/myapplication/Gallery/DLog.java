package text.tao.com.myapplication.Gallery;

import android.util.Log;

public class DLog
{
  private static boolean isDebug = false;
  
  public static void d(String paramString1, String paramString2)
  {
    if (isDebug) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (isDebug) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static boolean getDebug()
  {
    return isDebug;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (isDebug) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    isDebug = paramBoolean;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (isDebug) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (isDebug) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/DLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */