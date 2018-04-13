package text.tao.com.myapplication.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class BlurBitmapUtil
{
  private static final float BITMAP_SCALE = 0.4F;
  
  public static Bitmap blurBitmap(Context paramContext, Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, Math.round(0.4F * paramBitmap.getWidth()), Math.round(0.4F * paramBitmap.getHeight()), false);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1);
    RenderScript localRenderScript = RenderScript.create(paramContext);
    ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(localRenderScript, Element.U8_4(localRenderScript));
    Allocation localAllocation1 = Allocation.createFromBitmap(localRenderScript, localBitmap1);
    Allocation localAllocation2 = Allocation.createFromBitmap(localRenderScript, localBitmap2);
    localScriptIntrinsicBlur.setRadius(paramFloat);
    localScriptIntrinsicBlur.setInput(localAllocation1);
    localScriptIntrinsicBlur.forEach(localAllocation2);
    localAllocation2.copyTo(localBitmap2);
    return localBitmap2;
  }
}
