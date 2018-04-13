//package text.tao.com.myapplication.utils;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.os.Environment;
//import android.util.Log;
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//public class LogUtils
//{
//  @SuppressLint({"SimpleDateFormat"})
//  private static final SimpleDateFormat FILE_SUFFIX = new SimpleDateFormat("yyyy-MM-dd");
//  private static String LOG_FILE_NAME;
//  private static String LOG_FILE_PATH;
//  @SuppressLint({"SimpleDateFormat"})
//  private static final SimpleDateFormat LOG_FORMAT;
//  private static int LOG_SAVE_DAYS;
//  private static Boolean LOG_SWITCH = Boolean.valueOf(true);
//  private static String LOG_TAG;
//  private static Boolean LOG_TO_FILE = Boolean.valueOf(false);
//  private static char LOG_TYPE;
//
//  static
//  {
//    LOG_TAG = "TAG";
//    LOG_TYPE = 'v';
//    LOG_SAVE_DAYS = 7;
//    LOG_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//  }
//
//  public static void d(Object paramObject)
//  {
//    d(LOG_TAG, paramObject);
//  }
//
//  public static void d(String paramString, Object paramObject)
//  {
//    d(paramString, paramObject, null);
//  }
//
//  public static void d(String paramString, Object paramObject, Throwable paramThrowable)
//  {
//    log(paramString, paramObject.toString(), paramThrowable, 'd');
//  }
//
//  public static void delFile()
//  {
//    String str = FILE_SUFFIX.format(getDateBefore());
//    File localFile = new File(LOG_FILE_PATH, str + LOG_FILE_NAME);
//    if (localFile.exists()) {
//      localFile.delete();
//    }
//  }
//
//  public static void e(Object paramObject)
//  {
//    e(LOG_TAG, paramObject);
//  }
//
//  public static void e(String paramString, Object paramObject)
//  {
//    e(paramString, paramObject, null);
//  }
//
//  public static void e(String paramString, Object paramObject, Throwable paramThrowable)
//  {
//    log(paramString, paramObject.toString(), paramThrowable, 'e');
//  }
//
//  private static Date getDateBefore()
//  {
//    Date localDate = new Date();
//    Calendar localCalendar = Calendar.getInstance();
//    localCalendar.setTime(localDate);
//    localCalendar.set(5, localCalendar.get(5) - LOG_SAVE_DAYS);
//    return localCalendar.getTime();
//  }
//
//  public static void i(Object paramObject)
//  {
//    i(LOG_TAG, paramObject);
//  }
//
//  public static void i(String paramString, Object paramObject)
//  {
//    i(paramString, paramObject, null);
//  }
//
//  public static void i(String paramString, Object paramObject, Throwable paramThrowable)
//  {
//    if (paramObject == null) {}
//    for (String str = null;; str = paramObject.toString())
//    {
//      log(paramString, str, paramThrowable, 'i');
//      return;
//    }
//  }
//
//  public static void init(Context paramContext)
//  {
//    LOG_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + paramContext.getPackageName();
//    LOG_FILE_NAME = "Log";
//  }
//
//  private static void log(String paramString1, String paramString2, Throwable paramThrowable, char paramChar)
//  {
//    String str1;
//    if (LOG_SWITCH.booleanValue())
//    {
//      if (('e' != paramChar) || (('e' != LOG_TYPE) && ('v' != LOG_TYPE))) {
//        break label87;
//      }
//      Log.e(paramString1, paramString2, paramThrowable);
//      if (LOG_TO_FILE.booleanValue())
//      {
//        str1 = String.valueOf(paramChar);
//        if (paramString2 + paramThrowable != null) {
//          break label193;
//        }
//      }
//    }
//    label87:
//    label193:
//    for (String str2 = "";; str2 = "\n" + Log.getStackTraceString(paramThrowable))
//    {
//      log2File(str1, paramString1, str2);
//      return;
//      if (('w' == paramChar) && (('w' == LOG_TYPE) || ('v' == LOG_TYPE)))
//      {
//        Log.w(paramString1, paramString2, paramThrowable);
//        break;
//      }
//      if (('d' == paramChar) && (('d' == LOG_TYPE) || ('v' == LOG_TYPE)))
//      {
//        Log.d(paramString1, paramString2, paramThrowable);
//        break;
//      }
//      if (('i' == paramChar) && (('d' == LOG_TYPE) || ('v' == LOG_TYPE)))
//      {
//        Log.i(paramString1, paramString2, paramThrowable);
//        break;
//      }
//      Log.v(paramString1, paramString2, paramThrowable);
//      break;
//    }
//  }
//
//  /* Error */
//  private static void log2File(String paramString1, String paramString2, String paramString3)
//  {
//    // Byte code:
//    //   0: ldc 2
//    //   2: monitorenter
//    //   3: new 113	java/util/Date
//    //   6: dup
//    //   7: invokespecial 114	java/util/Date:<init>	()V
//    //   10: astore_3
//    //   11: getstatic 55	mvp/tao/com/utils/LogUtils:FILE_SUFFIX	Ljava/text/SimpleDateFormat;
//    //   14: aload_3
//    //   15: invokevirtual 82	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
//    //   18: astore 5
//    //   20: new 88	java/lang/StringBuilder
//    //   23: dup
//    //   24: invokespecial 89	java/lang/StringBuilder:<init>	()V
//    //   27: getstatic 51	mvp/tao/com/utils/LogUtils:LOG_FORMAT	Ljava/text/SimpleDateFormat;
//    //   30: aload_3
//    //   31: invokevirtual 82	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
//    //   34: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   37: ldc -53
//    //   39: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   42: aload_0
//    //   43: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   46: ldc -53
//    //   48: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   51: aload_1
//    //   52: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   55: ldc -53
//    //   57: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   60: aload_2
//    //   61: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   64: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
//    //   67: astore 6
//    //   69: new 84	java/io/File
//    //   72: dup
//    //   73: getstatic 86	mvp/tao/com/utils/LogUtils:LOG_FILE_PATH	Ljava/lang/String;
//    //   76: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
//    //   79: astore 7
//    //   81: aload 7
//    //   83: invokevirtual 103	java/io/File:exists	()Z
//    //   86: ifne +9 -> 95
//    //   89: aload 7
//    //   91: invokevirtual 207	java/io/File:mkdirs	()Z
//    //   94: pop
//    //   95: new 84	java/io/File
//    //   98: dup
//    //   99: getstatic 86	mvp/tao/com/utils/LogUtils:LOG_FILE_PATH	Ljava/lang/String;
//    //   102: new 88	java/lang/StringBuilder
//    //   105: dup
//    //   106: invokespecial 89	java/lang/StringBuilder:<init>	()V
//    //   109: getstatic 95	mvp/tao/com/utils/LogUtils:LOG_FILE_NAME	Ljava/lang/String;
//    //   112: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   115: aload 5
//    //   117: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
//    //   120: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
//    //   123: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
//    //   126: astore 8
//    //   128: new 209	java/io/FileWriter
//    //   131: dup
//    //   132: aload 8
//    //   134: iconst_1
//    //   135: invokespecial 212	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
//    //   138: astore 9
//    //   140: new 214	java/io/BufferedWriter
//    //   143: dup
//    //   144: aload 9
//    //   146: invokespecial 217	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
//    //   149: astore 10
//    //   151: aload 10
//    //   153: aload 6
//    //   155: invokevirtual 220	java/io/BufferedWriter:write	(Ljava/lang/String;)V
//    //   158: aload 10
//    //   160: invokevirtual 223	java/io/BufferedWriter:newLine	()V
//    //   163: aload 10
//    //   165: invokevirtual 226	java/io/BufferedWriter:close	()V
//    //   168: aload 9
//    //   170: invokevirtual 227	java/io/FileWriter:close	()V
//    //   173: ldc 2
//    //   175: monitorexit
//    //   176: return
//    //   177: astore 11
//    //   179: aload 11
//    //   181: invokestatic 233	com/google/devtools/build/android/desugar/runtime/ThrowableExtension:printStackTrace	(Ljava/lang/Throwable;)V
//    //   184: goto -11 -> 173
//    //   187: astore 4
//    //   189: ldc 2
//    //   191: monitorexit
//    //   192: aload 4
//    //   194: athrow
//    // Local variable table:
//    //   start	length	slot	name	signature
//    //   0	195	0	paramString1	String
//    //   0	195	1	paramString2	String
//    //   0	195	2	paramString3	String
//    //   10	21	3	localDate	Date
//    //   187	6	4	localObject	Object
//    //   18	98	5	str1	String
//    //   67	87	6	str2	String
//    //   79	11	7	localFile1	File
//    //   126	7	8	localFile2	File
//    //   138	31	9	localFileWriter	java.io.FileWriter
//    //   149	15	10	localBufferedWriter	java.io.BufferedWriter
//    //   177	3	11	localIOException	java.io.IOException
//    // Exception table:
//    //   from	to	target	type
//    //   128	173	177	java/io/IOException
//    //   3	95	187	finally
//    //   95	128	187	finally
//    //   128	173	187	finally
//    //   179	184	187	finally
//  }
//
//  public static void v(Object paramObject)
//  {
//    v(LOG_TAG, paramObject);
//  }
//
//  public static void v(String paramString, Object paramObject)
//  {
//    v(paramString, paramObject, null);
//  }
//
//  public static void v(String paramString, Object paramObject, Throwable paramThrowable)
//  {
//    log(paramString, paramObject.toString(), paramThrowable, 'v');
//  }
//
//  public static void w(Object paramObject)
//  {
//    w(LOG_TAG, paramObject);
//  }
//
//  public static void w(String paramString, Object paramObject)
//  {
//    w(paramString, paramObject, null);
//  }
//
//  public static void w(String paramString, Object paramObject, Throwable paramThrowable)
//  {
//    log(paramString, paramObject.toString(), paramThrowable, 'w');
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/utils/LogUtils.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */