package text.tao.com.myapplication.view.RemoteControl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;

public class DraggableButton
  extends AppCompatImageView
{
  private Paint mPaint = new Paint(1);
  private Rect mRect = new Rect();
  private String text;
  
  public DraggableButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DraggableButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DraggableButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setStrokeWidth(1.0F);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public String getText()
  {
    return this.text;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth() / 2;
    this.mPaint.setStyle(Style.STROKE);
    this.mPaint.setColor(Color.parseColor("#cdcdcd"));
    paramCanvas.drawCircle(i, i, i - 2, this.mPaint);
    if (isPressed())
    {
      this.mPaint.setStyle(Style.FILL);
      this.mPaint.setColor(Color.parseColor("#20000000"));
      paramCanvas.drawCircle(i, i, i - 4, this.mPaint);
    }
    if (!TextUtils.isEmpty(this.text))
    {
      this.mPaint.setStyle(Style.FILL);
      this.mPaint.setColor(-1);
      this.mPaint.setTextSize(i / 2);
      this.mPaint.getTextBounds(this.text, 0, this.text.length(), this.mRect);
      int j = this.mRect.bottom - this.mRect.top;
      int k = this.mRect.right - this.mRect.left;
      paramCanvas.drawText(this.text, i - k / 2, i + j / 2, this.mPaint);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = Math.min(getMeasuredWidth(), getMeasuredHeight());
    setMeasuredDimension(i, i);
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
}


/* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/RemoteControl/DraggableButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */