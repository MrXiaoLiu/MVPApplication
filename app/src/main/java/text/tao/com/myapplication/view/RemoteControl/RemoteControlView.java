//package text.tao.com.myapplication.view.RemoteControl;
//
//import android.content.ClipData;
//import android.content.ClipData.Item;
//import android.content.ClipDescription;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.DashPathEffect;
//import android.graphics.Paint;
//import android.graphics.Paint.Style;
//import android.graphics.Path;
//import android.graphics.Rect;
//import android.graphics.RectF;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.DragEvent;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.view.View.OnDragListener;
//import android.view.View.OnLongClickListener;
//import android.widget.FrameLayout;
//import android.widget.FrameLayout.LayoutParams;
//import android.widget.ImageView;
//import android.widget.TextView;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class RemoteControlView
//  extends FrameLayout
//  implements OnDragListener
//{
//  private static final String BORDER_COLOR = "#70FFFFFF";
//  private static final String CONTENT_COLOR = "#0E000000";
//  private static final String DASHED_COLOR = "#20FFFFFF";
//  private static final int HEIGHT_COUNT = 7;
//  private static final String SOLID_COLOR = "#30FFFFFF";
//  private static final String TAG = "RemoteControlView";
//  private static final int WIDTH_COUNT = 4;
//  private Rect dragRect;
//  private View dragView;
//  private FrameLayout frameLayout;
//  private DraggableInfo info;
//  private boolean isOut;
//  private Path mBackPath;
//  private DashPathEffect mDashPathEffect = new DashPathEffect(new float[] { 10.0F, 10.0F }, 0.0F);
//  private int mPhoneContentHeight;
//  private int mPhoneContentWidth;
//  private Paint mPhonePaint;
//  private int mPhoneWidth;
//  private Rect mRect = new Rect();
//  private RectF mRectF = new RectF();
//  private List<Rect> mRectList = new ArrayList();
//  Rect mTextRect = new Rect();
//  private TextView mTextView;
//  private Bitmap shadowBitmap;
//  private Rect shadowRect;
//  private int startX;
//
//  public RemoteControlView(Context paramContext)
//  {
//    this(paramContext, null);
//  }
//
//  public RemoteControlView(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    this(paramContext, paramAttributeSet, 0);
//  }
//
//  public RemoteControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
//  {
//    super(paramContext, paramAttributeSet, paramInt);
//    init(paramContext);
//  }
//
//  private void adjust(int paramInt, Rect paramRect, DragEvent paramDragEvent)
//  {
//    int i = this.mPhoneContentWidth / 4 / 2;
//    int j = dp2px(5);
//    int k = i * 2 - dp2px(10);
//    int m = (paramRect.left - j) % i;
//    int n;
//    label100:
//    label131:
//    int i1;
//    int i2;
//    int i3;
//    int i4;
//    if (m < i / 2)
//    {
//      paramRect.left = (j + paramRect.left - m);
//      n = (paramRect.top - j) % i;
//      if (n >= i / 2) {
//        break label230;
//      }
//      paramRect.top = (j + paramRect.top - n);
//      if ((paramInt != 0) && (paramInt != 1)) {
//        break label250;
//      }
//      paramRect.right = (k + paramRect.left);
//      paramRect.bottom = (k + paramRect.top);
//      if ((paramRect.right > this.frameLayout.getWidth()) || (paramRect.bottom > this.frameLayout.getHeight()))
//      {
//        i1 = (int)paramDragEvent.getX();
//        i2 = (int)paramDragEvent.getY();
//        i3 = this.frameLayout.getWidth() / 2;
//        i4 = this.frameLayout.getHeight() / 2;
//        if ((i1 > i3) || (i2 > i4)) {
//          break label353;
//        }
//      }
//    }
//    label230:
//    label250:
//    label353:
//    do
//    {
//      do
//      {
//        return;
//        paramRect.left = (i + (j + paramRect.left - m));
//        break;
//        paramRect.top = (i + (j + paramRect.top - n));
//        break label100;
//        if (paramInt == 3)
//        {
//          paramRect.top = (j + paramRect.top);
//          paramRect.right = (k + paramRect.left);
//          paramRect.bottom = (paramRect.top + k * 2);
//          break label131;
//        }
//        if (paramInt != 2) {
//          break label131;
//        }
//        paramRect.top += j * 2;
//        paramRect.left += j * 2;
//        paramRect.right = (paramRect.left + k * 3);
//        paramRect.bottom = (paramRect.top + k * 3);
//        break label131;
//        if ((i1 >= i3) && (i2 <= i4))
//        {
//          paramRect.left -= i;
//          paramRect.right -= i;
//          return;
//        }
//        if ((i1 <= i3) && (i2 >= i4))
//        {
//          paramRect.top -= i;
//          paramRect.bottom -= i;
//          return;
//        }
//      } while ((i1 < i3) || (i2 < i4));
//      if (paramRect.right > this.frameLayout.getWidth())
//      {
//        paramRect.left -= i;
//        paramRect.right -= i;
//      }
//    } while (paramRect.bottom <= this.frameLayout.getHeight());
//    paramRect.top -= i;
//    paramRect.bottom -= i;
//  }
//
//  private void compute(int paramInt, Rect paramRect, DragEvent paramDragEvent)
//  {
//    int i = this.mPhoneContentWidth / 4 - dp2px(10);
//    int j = (int)paramDragEvent.getX();
//    int k = (int)paramDragEvent.getY();
//    if ((paramInt == 0) || (paramInt == 1))
//    {
//      paramRect.left = (j - i / 2);
//      paramRect.top = (k - i / 2);
//      paramRect.right = (j + i / 2);
//      paramRect.bottom = (k + i / 2);
//    }
//    do
//    {
//      return;
//      if (paramInt == 2)
//      {
//        paramRect.left = (j - i * 3 / 2);
//        paramRect.top = (k - i * 3 / 2);
//        paramRect.right = (j + i * 3 / 2);
//        paramRect.bottom = (k + i * 3 / 2);
//        return;
//      }
//    } while (paramInt != 3);
//    paramRect.left = (j - i / 2);
//    paramRect.top = (k - i);
//    paramRect.right = (j + i / 2);
//    paramRect.bottom = (k + i);
//  }
//
//  private int dp2px(int paramInt)
//  {
//    return (int)(0.5F + getContext().getResources().getDisplayMetrics().scaledDensity * paramInt);
//  }
//
//  private void init(Context paramContext)
//  {
//    setWillNotDraw(false);
//    this.mPhonePaint = new Paint(1);
//    this.mBackPath = new Path();
//    setLayerType(1, null);
//    this.frameLayout = new FrameLayout(paramContext);
//    this.frameLayout.setBackgroundColor(Color.parseColor("#0E000000"));
//    this.frameLayout.setOnDragListener(this);
//    addView(this.frameLayout);
//    this.mTextView = new TextView(paramContext);
//    this.mTextView.setTextSize(1, 12.0F);
//    this.mTextView.setTextColor(-1);
//    this.mTextView.setText("长按并拖拽下方按钮到这里");
//    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
//    localLayoutParams.gravity = 17;
//    this.mTextView.setLayoutParams(localLayoutParams);
//    this.mTextView.measure(0, 0);
//    addView(this.mTextView);
//  }
//
//  private boolean isEffectiveArea(Rect paramRect)
//  {
//    return (paramRect.left >= 0) && (paramRect.top >= 0) && (paramRect.right >= 0) && (paramRect.bottom >= 0) && (paramRect.right <= this.frameLayout.getWidth()) && (paramRect.bottom <= this.frameLayout.getHeight());
//  }
//
//  private boolean isEqual(Rect paramRect)
//  {
//    if (this.dragRect == null) {}
//    while ((paramRect.left != this.dragRect.left) || (paramRect.right != this.dragRect.right) || (paramRect.top != this.dragRect.top) || (paramRect.bottom != this.dragRect.bottom)) {
//      return false;
//    }
//    return true;
//  }
//
//  private boolean isOverlap(Rect paramRect)
//  {
//    Iterator localIterator = this.mRectList.iterator();
//    while (localIterator.hasNext())
//    {
//      Rect localRect = (Rect)localIterator.next();
//      if ((!isEqual(localRect)) && (isRectOverlap(localRect, paramRect))) {
//        return true;
//      }
//    }
//    return false;
//  }
//
//  private boolean isRectOverlap(Rect paramRect1, Rect paramRect2)
//  {
//    return (paramRect1.right > paramRect2.left) && (paramRect2.right > paramRect1.left) && (paramRect1.bottom > paramRect2.top) && (paramRect2.bottom > paramRect1.top);
//  }
//
//  private int measure(int paramInt)
//  {
//    int i = MeasureSpec.getMode(paramInt);
//    int j = MeasureSpec.getSize(paramInt);
//    switch (i)
//    {
//    default:
//      return 0;
//    case -2147483648:
//      return j;
//    case 1073741824:
//      return j;
//    }
//    return dp2px(300);
//  }
//
//  private void stopDrag()
//  {
//    this.shadowRect = null;
//    this.info = null;
//    invalidate();
//  }
//
//  public boolean onDrag(View paramView, DragEvent paramDragEvent)
//  {
//    switch (paramDragEvent.getAction())
//    {
//    default:
//    case 1:
//      do
//      {
//        return false;
//      } while (!paramDragEvent.getClipDescription().hasMimeType("text/vnd.android.intent"));
//      Log.e("RemoteControlView", "开始拖动");
//    case 5:
//    case 6:
//    case 4:
//    case 2:
//      for (;;)
//      {
//        return true;
//        Log.e("RemoteControlView", "进入");
//        this.mTextView.setVisibility(8);
//        this.isOut = false;
//        continue;
//        Log.e("RemoteControlView", "移出");
//        if (this.frameLayout.getChildCount() == 0) {
//          this.mTextView.setVisibility(0);
//        }
//        this.isOut = true;
//        this.shadowRect = null;
//        invalidate();
//        continue;
//        Log.e("RemoteControlView", "停止拖动");
//        if ((this.dragView != null) && (this.isOut))
//        {
//          this.mRectList.remove(this.dragRect);
//          this.frameLayout.removeView(this.dragView);
//        }
//        if (this.frameLayout.getChildCount() == 0) {
//          this.mTextView.setVisibility(0);
//        }
//        this.dragView = null;
//        this.dragRect = null;
//        stopDrag();
//        continue;
//        if (this.dragView != null) {
//          this.info = ((DraggableInfo)this.dragView.getTag());
//        }
//        if (this.info != null)
//        {
//          compute(this.info.getType(), this.mRect, paramDragEvent);
//          adjust(this.info.getType(), this.mRect, paramDragEvent);
//          if ((isEffectiveArea(this.mRect)) && (!isOverlap(this.mRect))) {
//            this.shadowRect = this.mRect;
//          }
//          try
//          {
//            for (;;)
//            {
//              Thread.sleep(33L);
//              invalidate();
//              break;
//              this.shadowRect = null;
//            }
//          }
//          catch (InterruptedException localInterruptedException)
//          {
//            for (;;)
//            {
//              Thread.currentThread().interrupt();
//            }
//          }
//        }
//      }
//    }
//    Log.e("RemoteControlView", "释放拖动");
//    if (this.dragView == null)
//    {
//      final DraggableInfo localDraggableInfo2 = (DraggableInfo)paramDragEvent.getClipData().getItemAt(0).getIntent().getSerializableExtra("data");
//      int i;
//      final Object localObject;
//      if (localDraggableInfo2 != null)
//      {
//        i = (this.mPhoneContentWidth / 4 - dp2px(10)) / 4;
//        if (localDraggableInfo2.getType() != 3) {
//          break label542;
//        }
//        localObject = new ImageView(getContext());
//        ((ImageView)localObject).setImageResource(localDraggableInfo2.getPic());
//      }
//      for (;;)
//      {
//        ((ImageView)localObject).setTag(localDraggableInfo2);
//        final Rect localRect2 = new Rect();
//        ((ImageView)localObject).setOnLongClickListener(new OnLongClickListener()
//        {
//          public boolean onLongClick(View paramAnonymousView)
//          {
//            Tools.startDrag(localObject);
//            RemoteControlView.access$002(RemoteControlView.this, localObject);
//            RemoteControlView.access$102(RemoteControlView.this, localRect2);
//            RemoteControlView.this.setDragInfo(localDraggableInfo2);
//            localObject.setVisibility(8);
//            return false;
//          }
//        });
//        compute(localDraggableInfo2.getType(), localRect2, paramDragEvent);
//        adjust(localDraggableInfo2.getType(), localRect2, paramDragEvent);
//        if ((isEffectiveArea(localRect2)) && (!isOverlap(localRect2)))
//        {
//          this.mRectList.add(localRect2);
//          this.frameLayout.addView((View)localObject);
//        }
//        stopDrag();
//        break;
//        label542:
//        localObject = new DraggableButton(getContext());
//        ((ImageView)localObject).setPadding(i, i, i, i);
//        if (localDraggableInfo2.getType() == 1) {
//          ((DraggableButton)localObject).setText(localDraggableInfo2.getText());
//        } else {
//          ((ImageView)localObject).setImageResource(localDraggableInfo2.getPic());
//        }
//      }
//    }
//    DraggableInfo localDraggableInfo1 = (DraggableInfo)this.dragView.getTag();
//    Rect localRect1 = this.dragRect;
//    compute(localDraggableInfo1.getType(), localRect1, paramDragEvent);
//    adjust(localDraggableInfo1.getType(), localRect1, paramDragEvent);
//    if ((isEffectiveArea(localRect1)) && (!isOverlap(localRect1))) {
//      this.dragView.setVisibility(0);
//    }
//    for (;;)
//    {
//      this.dragView = null;
//      this.dragRect = null;
//      break;
//      this.mRectList.remove(this.dragRect);
//      this.frameLayout.removeView(this.dragView);
//    }
//  }
//
//  protected void onDraw(Canvas paramCanvas)
//  {
//    super.onDraw(paramCanvas);
//    this.mPhonePaint.setColor(Color.parseColor("#70FFFFFF"));
//    this.mPhonePaint.setStyle(Style.STROKE);
//    this.mPhonePaint.setStrokeWidth(2.0F);
//    int i = dp2px(12);
//    this.mRectF.left = this.startX;
//    this.mRectF.right = (getMeasuredWidth() - this.startX);
//    this.mRectF.top = i;
//    this.mRectF.bottom = (getMeasuredHeight() - i);
//    paramCanvas.drawRoundRect(this.mRectF, i, i, this.mPhonePaint);
//    paramCanvas.drawLine(this.startX, i * 3, getMeasuredWidth() - this.startX, i * 3, this.mPhonePaint);
//    paramCanvas.drawLine(this.startX, getMeasuredHeight() - i * 3, getMeasuredWidth() - this.startX, getMeasuredHeight() - i * 3, this.mPhonePaint);
//    this.mRectF.left = (getMeasuredWidth() / 2 - dp2px(25));
//    this.mRectF.right = (getMeasuredWidth() / 2 + dp2px(25));
//    this.mRectF.top = dp2px(22);
//    this.mRectF.bottom = dp2px(26);
//    paramCanvas.drawRoundRect(this.mRectF, dp2px(2), dp2px(2), this.mPhonePaint);
//    paramCanvas.drawCircle(getMeasuredWidth() / 2 - dp2px(40), i * 2, i / 3, this.mPhonePaint);
//    paramCanvas.drawCircle(getMeasuredWidth() / 2 + dp2px(40), i * 2, i / 3, this.mPhonePaint);
//    paramCanvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() - i * 2, i / 2, this.mPhonePaint);
//    paramCanvas.drawRect(this.startX + this.mPhoneWidth / 5, getMeasuredHeight() - dp2px(29), this.startX + this.mPhoneWidth / 5 + dp2px(10), getMeasuredHeight() - dp2px(19), this.mPhonePaint);
//    this.mBackPath.moveTo(getMeasuredWidth() - this.startX - this.mPhoneWidth / 5, getMeasuredHeight() - dp2px(30));
//    this.mBackPath.lineTo(getMeasuredWidth() - this.startX - this.mPhoneWidth / 5 - dp2px(10), getMeasuredHeight() - dp2px(24));
//    this.mBackPath.lineTo(getMeasuredWidth() - this.startX - this.mPhoneWidth / 5, getMeasuredHeight() - dp2px(18));
//    this.mBackPath.close();
//    paramCanvas.drawPath(this.mBackPath, this.mPhonePaint);
//    int j = dp2px(5);
//    int k = this.mPhoneContentHeight / 7;
//    for (int m = 0; m <= 7; m++)
//    {
//      this.mPhonePaint.setPathEffect(null);
//      this.mPhonePaint.setColor(Color.parseColor("#30FFFFFF"));
//      this.mPhonePaint.setStrokeWidth(1.0F);
//      paramCanvas.drawLine(j + this.startX, dp2px(41) + m * k, getMeasuredWidth() - this.startX - j, dp2px(41) + m * k, this.mPhonePaint);
//      if (m != 7)
//      {
//        this.mPhonePaint.setPathEffect(this.mDashPathEffect);
//        this.mPhonePaint.setColor(Color.parseColor("#20FFFFFF"));
//        paramCanvas.drawLine(j + this.startX, dp2px(41) + m * k + k / 2, getMeasuredWidth() - this.startX - j, dp2px(41) + m * k + k / 2, this.mPhonePaint);
//      }
//    }
//    for (int n = 0; n <= 4; n++)
//    {
//      this.mPhonePaint.setPathEffect(null);
//      this.mPhonePaint.setColor(Color.parseColor("#30FFFFFF"));
//      this.mPhonePaint.setStrokeWidth(1.0F);
//      paramCanvas.drawLine(j + this.startX + n * k, dp2px(41), j + this.startX + n * k, getMeasuredHeight() - dp2px(41), this.mPhonePaint);
//      if (n != 4)
//      {
//        this.mPhonePaint.setPathEffect(this.mDashPathEffect);
//        this.mPhonePaint.setColor(Color.parseColor("#20FFFFFF"));
//        paramCanvas.drawLine(j + this.startX + n * k + k / 2, dp2px(41), j + this.startX + n * k + k / 2, getMeasuredHeight() - dp2px(41), this.mPhonePaint);
//      }
//    }
//    int i1;
//    if (this.shadowRect != null)
//    {
//      i1 = this.info.getType();
//      this.mPhonePaint.setStyle(Style.FILL);
//      this.mPhonePaint.setColor(-1);
//      this.shadowRect.left += this.startX;
//      this.shadowRect.right += this.startX;
//      this.shadowRect.top += dp2px(36);
//      this.shadowRect.bottom += dp2px(36);
//      if (i1 == 1)
//      {
//        int i5 = this.shadowRect.right - this.shadowRect.left;
//        String str = this.info.getText();
//        this.mPhonePaint.setTextSize(i5 / 4);
//        this.mPhonePaint.getTextBounds(str, 0, str.length(), this.mTextRect);
//        int i6 = this.mTextRect.bottom - this.mTextRect.top;
//        int i7 = this.mTextRect.right - this.mTextRect.left;
//        paramCanvas.drawText(str, this.shadowRect.left + i5 / 2 - i7 / 2, this.shadowRect.top + i5 / 2 + i6 / 2, this.mPhonePaint);
//      }
//    }
//    else
//    {
//      return;
//    }
//    if (i1 == 0)
//    {
//      int i4 = dp2px(12);
//      this.shadowRect.left = (i4 + this.shadowRect.left);
//      this.shadowRect.right -= i4;
//      this.shadowRect.top = (i4 + this.shadowRect.top);
//      this.shadowRect.bottom -= i4;
//    }
//    for (;;)
//    {
//      paramCanvas.drawBitmap(this.shadowBitmap, null, this.shadowRect, this.mPhonePaint);
//      return;
//      if (i1 == 2)
//      {
//        int i3 = dp2px(10);
//        this.shadowRect.left = (i3 + this.shadowRect.left);
//        this.shadowRect.right -= i3;
//        this.shadowRect.top = (i3 + this.shadowRect.top);
//        this.shadowRect.bottom -= i3;
//      }
//      else if (i1 == 3)
//      {
//        int i2 = dp2px(4);
//        this.shadowRect.left = (i2 + this.shadowRect.left);
//        this.shadowRect.right -= i2;
//      }
//    }
//  }
//
//  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
//  {
//    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
//    this.frameLayout.layout(this.startX, dp2px(36), getMeasuredWidth() - this.startX, getMeasuredHeight() - dp2px(36));
//    if (this.frameLayout.getChildCount() > 0) {
//      for (int i = 0; i < this.frameLayout.getChildCount(); i++)
//      {
//        Rect localRect = (Rect)this.mRectList.get(i);
//        this.frameLayout.getChildAt(i).layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
//      }
//    }
//  }
//
//  protected void onMeasure(int paramInt1, int paramInt2)
//  {
//    setMeasuredDimension(measure(paramInt1), measure(paramInt2));
//    this.mPhoneContentHeight = (getMeasuredHeight() - dp2px(24) - dp2px(58));
//    this.mPhoneContentWidth = (4 * (this.mPhoneContentHeight / 7));
//    this.mPhoneWidth = (this.mPhoneContentWidth + dp2px(10));
//    this.startX = ((getMeasuredWidth() - this.mPhoneWidth) / 2);
//  }
//
//  public void setDragInfo(DraggableInfo paramDraggableInfo)
//  {
//    this.info = paramDraggableInfo;
//    if (paramDraggableInfo.getType() != 1) {
//      this.shadowBitmap = BitmapFactory.decodeResource(getResources(), paramDraggableInfo.getPic());
//    }
//  }
//}
//
