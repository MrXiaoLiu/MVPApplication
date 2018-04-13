package text.tao.com.myapplication.view.RemoteControl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.DragShadowBuilder;

public class MyDragShadowBuilder
  extends DragShadowBuilder
{
  private static Drawable shadow;
  private int height;
  private int width;
  
  public MyDragShadowBuilder(View paramView)
  {
    super(paramView);
    paramView.setDrawingCacheEnabled(true);
    shadow = new BitmapDrawable(null, Bitmap.createBitmap(paramView.getDrawingCache(true)));
    paramView.destroyDrawingCache();
    paramView.setDrawingCacheEnabled(false);
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    shadow.draw(paramCanvas);
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    this.width = getView().getWidth();
    this.height = getView().getHeight();
    shadow.setBounds(0, 0, this.width, this.height);
    paramPoint1.set(this.width, this.height);
    paramPoint2.set(this.width / 2, this.height / 2);
  }
}
