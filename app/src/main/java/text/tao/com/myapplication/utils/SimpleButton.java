//package text.tao.com.myapplication.utils;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Paint.FontMetrics;
//import android.graphics.Paint.Style;
//import android.graphics.PorterDuff.Mode;
//import android.graphics.RectF;
//import android.graphics.drawable.Drawable;
//import android.support.v4.view.MotionEventCompat;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import mvp.tao.com.R.styleable;
//
//public class SimpleButton
//  extends View
//{
//  public static final int MODE_CHECK = 202;
//  public static final int MODE_ICON_CHECK_CHANGE = 204;
//  public static final int MODE_ICON_CHECK_INVISIBLE = 203;
//  public static final int MODE_NORMAL = 201;
//  public static final int SHAPE_ARC = 102;
//  public static final int SHAPE_RECT = 103;
//  public static final int SHAPE_ROUND_RECT = 101;
//  private float mBaseLineDistance;
//  private int mBgColor = -1;
//  private int mBgColorChecked = -1;
//  private int mBorderColor = Color.parseColor("#ff333333");
//  private int mBorderColorChecked = Color.parseColor("#ff333333");
//  private float mBorderWidth;
//  private OnCheckedChangeListener mCheckListener;
//  private Drawable mDecorateIcon;
//  private Drawable mDecorateIconChange;
//  private int mFontH;
//  private int mFontLen;
//  private int mFontLenChecked;
//  private int mHorizontalPadding;
//  private int mIconGravity = 3;
//  private int mIconPadding = 0;
//  private int mIconSize = 0;
//  private boolean mIsAutoToggleCheck = false;
//  private boolean mIsChecked = false;
//  private boolean mIsPressed = false;
//  private Paint mPaint;
//  private float mRadius;
//  private RectF mRect;
//  private int mScrimColor = Color.argb(102, 192, 192, 192);
//  private String mShowText;
//  private int mTagMode = 201;
//  private int mTagShape = 101;
//  private String mText;
//  private String mTextChecked;
//  private int mTextColor = Color.parseColor("#ff666666");
//  private int mTextColorChecked = Color.parseColor("#ff666666");
//  private float mTextSize;
//  private int mVerticalPadding;
//
//  public SimpleButton(Context paramContext)
//  {
//    this(paramContext, null);
//  }
//
//  public SimpleButton(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    super(paramContext, paramAttributeSet);
//    _init(paramContext, paramAttributeSet);
//  }
//
//  private int _adjustText(int paramInt)
//  {
//    if (this.mPaint.getTextSize() != this.mTextSize)
//    {
//      this.mPaint.setTextSize(this.mTextSize);
//      FontMetrics localFontMetrics = this.mPaint.getFontMetrics();
//      this.mFontH = ((int)(localFontMetrics.descent - localFontMetrics.ascent));
//      this.mBaseLineDistance = ((int)Math.ceil((localFontMetrics.descent - localFontMetrics.ascent) / 2.0F - localFontMetrics.descent));
//    }
//    if (TextUtils.isEmpty(this.mText)) {
//      this.mText = "";
//    }
//    this.mFontLen = ((int)this.mPaint.measureText(this.mText));
//    int i;
//    if (TextUtils.isEmpty(this.mTextChecked))
//    {
//      this.mFontLenChecked = this.mFontLen;
//      if (((this.mDecorateIcon != null) || (this.mDecorateIconChange != null)) && (this.mIconSize != this.mFontH)) {
//        this.mIconSize = this.mFontH;
//      }
//      if ((this.mTagMode != 203) || (!this.mIsChecked)) {
//        break label292;
//      }
//      i = 2 * this.mHorizontalPadding;
//    }
//    for (;;)
//    {
//      if ((this.mIsChecked) && (!TextUtils.isEmpty(this.mTextChecked)))
//      {
//        if (i + this.mFontLenChecked > paramInt)
//        {
//          float f3 = this.mPaint.measureText(".");
//          float f4 = paramInt - i - f3 * 3.0F;
//          this.mShowText = _clipShowText(this.mTextChecked, this.mPaint, f4);
//          this.mFontLenChecked = ((int)this.mPaint.measureText(this.mShowText));
//          return i;
//          this.mFontLenChecked = ((int)this.mPaint.measureText(this.mTextChecked));
//          break;
//          label292:
//          if ((this.mDecorateIcon == null) && (!this.mIsChecked))
//          {
//            i = 2 * this.mHorizontalPadding;
//            continue;
//          }
//          i = this.mIconPadding + this.mIconSize + 2 * this.mHorizontalPadding;
//          continue;
//        }
//        this.mShowText = this.mTextChecked;
//        return i;
//      }
//    }
//    if (i + this.mFontLen > paramInt)
//    {
//      float f1 = this.mPaint.measureText(".");
//      float f2 = paramInt - i - f1 * 3.0F;
//      this.mShowText = _clipShowText(this.mText, this.mPaint, f2);
//      this.mFontLen = ((int)this.mPaint.measureText(this.mShowText));
//      return i;
//    }
//    this.mShowText = this.mText;
//    return i;
//  }
//
//  private String _clipShowText(String paramString, Paint paramPaint, float paramFloat)
//  {
//    float f1 = 0.0F;
//    StringBuilder localStringBuilder = new StringBuilder();
//    for (int i = 0;; i++)
//    {
//      char c;
//      float f2;
//      if (i < paramString.length())
//      {
//        c = paramString.charAt(i);
//        f2 = paramPaint.measureText(String.valueOf(c));
//        if (f1 + f2 <= paramFloat) {}
//      }
//      else
//      {
//        localStringBuilder.append("...");
//        return localStringBuilder.toString();
//      }
//      localStringBuilder.append(c);
//      f1 += f2;
//    }
//  }
//
//  private void _init(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    this.mBorderWidth = MeasureUtils.dp2px(paramContext, 0.5F);
//    this.mRadius = MeasureUtils.dp2px(paramContext, 5.0F);
//    this.mHorizontalPadding = ((int)MeasureUtils.dp2px(paramContext, 5.0F));
//    this.mVerticalPadding = ((int)MeasureUtils.dp2px(paramContext, 5.0F));
//    this.mIconPadding = ((int)MeasureUtils.dp2px(paramContext, 3.0F));
//    this.mTextSize = MeasureUtils.sp2px(paramContext, 14.0F);
//    TypedArray localTypedArray;
//    if (paramAttributeSet != null) {
//      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SimpleButton);
//    }
//    try
//    {
//      this.mTagShape = localTypedArray.getInteger(1, 101);
//      this.mTagMode = localTypedArray.getInteger(0, 201);
//      if ((this.mTagMode == 202) || (this.mTagMode == 203) || (this.mTagMode == 204))
//      {
//        this.mIsAutoToggleCheck = true;
//        this.mIsChecked = localTypedArray.getBoolean(4, false);
//        this.mDecorateIconChange = localTypedArray.getDrawable(20);
//      }
//      this.mIsAutoToggleCheck = localTypedArray.getBoolean(3, this.mIsAutoToggleCheck);
//      this.mText = localTypedArray.getString(11);
//      this.mTextChecked = localTypedArray.getString(12);
//      this.mTextSize = localTypedArray.getDimension(13, this.mTextSize);
//      this.mBgColor = localTypedArray.getColor(5, -1);
//      this.mBorderColor = localTypedArray.getColor(6, Color.parseColor("#ff333333"));
//      this.mTextColor = localTypedArray.getColor(7, Color.parseColor("#ff666666"));
//      this.mBgColorChecked = localTypedArray.getColor(8, this.mBgColor);
//      this.mBorderColorChecked = localTypedArray.getColor(9, this.mBorderColor);
//      this.mTextColorChecked = localTypedArray.getColor(10, this.mTextColor);
//      this.mBorderWidth = localTypedArray.getDimension(14, this.mBorderWidth);
//      this.mRadius = localTypedArray.getDimension(15, this.mRadius);
//      this.mHorizontalPadding = ((int)localTypedArray.getDimension(17, this.mHorizontalPadding));
//      this.mVerticalPadding = ((int)localTypedArray.getDimension(16, this.mVerticalPadding));
//      this.mIconPadding = ((int)localTypedArray.getDimension(18, this.mIconPadding));
//      this.mDecorateIcon = localTypedArray.getDrawable(19);
//      this.mIconGravity = localTypedArray.getInteger(2, 3);
//      localTypedArray.recycle();
//      if ((this.mTagMode == 204) && (this.mDecorateIconChange == null)) {
//        throw new RuntimeException("You must set the drawable by 'tag_icon_change' property in MODE_ICON_CHECK_CHANGE mode");
//      }
//    }
//    finally
//    {
//      localTypedArray.recycle();
//    }
//    if ((this.mDecorateIcon == null) && (this.mDecorateIconChange == null)) {
//      this.mIconPadding = 0;
//    }
//    this.mRect = new RectF();
//    this.mPaint = new Paint(1);
//    setClickable(true);
//  }
//
//  private boolean _isViewUnder(float paramFloat1, float paramFloat2)
//  {
//    return (paramFloat1 >= 0.0F) && (paramFloat1 < getWidth()) && (paramFloat2 >= 0.0F) && (paramFloat2 < getHeight());
//  }
//
//  private void _toggleTagCheckStatus()
//  {
//    if (this.mIsAutoToggleCheck) {
//      if (this.mIsChecked) {
//        break label22;
//      }
//    }
//    label22:
//    for (boolean bool = true;; bool = false)
//    {
//      setChecked(bool);
//      return;
//    }
//  }
//
//  private void _update()
//  {
//    requestLayout();
//    invalidate();
//  }
//
//  public int getBgColor()
//  {
//    return this.mBgColor;
//  }
//
//  public int getBgColorChecked()
//  {
//    return this.mBgColorChecked;
//  }
//
//  public int getBorderColor()
//  {
//    return this.mBorderColor;
//  }
//
//  public int getBorderColorChecked()
//  {
//    return this.mBorderColorChecked;
//  }
//
//  public float getBorderWidth()
//  {
//    return this.mBorderWidth;
//  }
//
//  public Drawable getDecorateIcon()
//  {
//    return this.mDecorateIcon;
//  }
//
//  public Drawable getDecorateIconChange()
//  {
//    return this.mDecorateIconChange;
//  }
//
//  public int getHorizontalPadding()
//  {
//    return this.mHorizontalPadding;
//  }
//
//  public int getIconPadding()
//  {
//    return this.mIconPadding;
//  }
//
//  public float getRadius()
//  {
//    return this.mRadius;
//  }
//
//  public int getScrimColor()
//  {
//    return this.mScrimColor;
//  }
//
//  public int getTagMode()
//  {
//    return this.mTagMode;
//  }
//
//  public int getTagShape()
//  {
//    return this.mTagShape;
//  }
//
//  public String getText()
//  {
//    return this.mText;
//  }
//
//  public String getTextChecked()
//  {
//    return this.mTextChecked;
//  }
//
//  public int getTextColor()
//  {
//    return this.mTextColor;
//  }
//
//  public int getTextColorChecked()
//  {
//    return this.mTextColorChecked;
//  }
//
//  public float getTextSize()
//  {
//    return this.mTextSize;
//  }
//
//  public int getVerticalPadding()
//  {
//    return this.mVerticalPadding;
//  }
//
//  public boolean isAutoToggleCheck()
//  {
//    return this.mIsAutoToggleCheck;
//  }
//
//  public boolean isChecked()
//  {
//    return this.mIsChecked;
//  }
//
//  protected void onDraw(Canvas paramCanvas)
//  {
//    float f1 = this.mRadius;
//    label52:
//    label105:
//    int k;
//    label164:
//    float f3;
//    if (this.mTagShape == 102)
//    {
//      f1 = this.mRect.height() / 2.0F;
//      this.mPaint.setStyle(Style.FILL);
//      if (!this.mIsChecked) {
//        break label315;
//      }
//      this.mPaint.setColor(this.mBgColorChecked);
//      paramCanvas.drawRoundRect(this.mRect, f1, f1, this.mPaint);
//      this.mPaint.setStyle(Style.STROKE);
//      this.mPaint.setStrokeWidth(this.mBorderWidth);
//      if (!this.mIsChecked) {
//        break label329;
//      }
//      this.mPaint.setColor(this.mBorderColorChecked);
//      paramCanvas.drawRoundRect(this.mRect, f1, f1, this.mPaint);
//      this.mPaint.setStyle(Style.FILL);
//      if (!this.mIsChecked) {
//        break label380;
//      }
//      this.mPaint.setColor(this.mTextColorChecked);
//      int j = this.mTagMode;
//      k = 0;
//      if (j != 203) {
//        break label343;
//      }
//      String str2 = this.mShowText;
//      if (this.mIconGravity != 5) {
//        break label357;
//      }
//      f3 = (getWidth() - this.mFontLenChecked - k) / 2;
//      label195:
//      paramCanvas.drawText(str2, f3, getHeight() / 2 + this.mBaseLineDistance, this.mPaint);
//      if ((this.mTagMode != 204) || (!this.mIsChecked) || (this.mDecorateIconChange == null)) {
//        break label498;
//      }
//      this.mDecorateIconChange.setColorFilter(this.mPaint.getColor(), PorterDuff.Mode.SRC_IN);
//      this.mDecorateIconChange.draw(paramCanvas);
//    }
//    for (;;)
//    {
//      if (this.mIsPressed)
//      {
//        this.mPaint.setColor(this.mScrimColor);
//        paramCanvas.drawRoundRect(this.mRect, f1, f1, this.mPaint);
//      }
//      return;
//      if (this.mTagShape != 103) {
//        break;
//      }
//      f1 = 0.0F;
//      break;
//      label315:
//      this.mPaint.setColor(this.mBgColor);
//      break label52;
//      label329:
//      this.mPaint.setColor(this.mBorderColor);
//      break label105;
//      label343:
//      k = this.mIconSize + this.mIconPadding;
//      break label164;
//      label357:
//      f3 = k + (getWidth() - this.mFontLenChecked - k) / 2;
//      break label195;
//      label380:
//      this.mPaint.setColor(this.mTextColor);
//      Drawable localDrawable = this.mDecorateIcon;
//      int i = 0;
//      label403:
//      String str1;
//      if (localDrawable == null)
//      {
//        str1 = this.mShowText;
//        if (this.mIconGravity != 5) {
//          break label475;
//        }
//      }
//      label475:
//      for (float f2 = (getWidth() - this.mFontLen - i) / 2;; f2 = i + (getWidth() - this.mFontLen - i) / 2)
//      {
//        paramCanvas.drawText(str1, f2, getHeight() / 2 + this.mBaseLineDistance, this.mPaint);
//        break;
//        i = this.mIconSize + this.mIconPadding;
//        break label403;
//      }
//      label498:
//      if (((this.mTagMode != 203) || (!this.mIsChecked)) && (this.mDecorateIcon != null))
//      {
//        this.mDecorateIcon.setColorFilter(this.mPaint.getColor(), PorterDuff.Mode.SRC_IN);
//        this.mDecorateIcon.draw(paramCanvas);
//      }
//    }
//  }
//
//  protected void onMeasure(int paramInt1, int paramInt2)
//  {
//    super.onMeasure(paramInt1, paramInt2);
//    int i = _adjustText(getMeasuredWidth());
//    int j;
//    int k;
//    label44:
//    int m;
//    label60:
//    int n;
//    int i1;
//    if (this.mIsChecked)
//    {
//      j = this.mFontLenChecked;
//      if (MeasureSpec.getMode(paramInt1) != 1073741824) {
//        break label187;
//      }
//      k = MeasureSpec.getSize(paramInt1);
//      if (MeasureSpec.getMode(paramInt2) != 1073741824) {
//        break label196;
//      }
//      m = MeasureSpec.getSize(paramInt2);
//      setMeasuredDimension(k, m);
//      if ((this.mDecorateIcon != null) || (this.mDecorateIconChange != null))
//      {
//        n = (m - this.mIconSize) / 2;
//        if (this.mIconGravity != 5) {
//          break label212;
//        }
//        i1 = k - (k - this.mIconSize - j - this.mIconPadding) / 2 - this.mIconSize;
//        label128:
//        if ((this.mTagMode != 204) || (!this.mIsChecked) || (this.mDecorateIconChange == null)) {
//          break label234;
//        }
//        this.mDecorateIconChange.setBounds(i1, n, i1 + this.mIconSize, n + this.mIconSize);
//      }
//    }
//    label187:
//    label196:
//    label212:
//    label234:
//    while (this.mDecorateIcon == null)
//    {
//      return;
//      j = this.mFontLen;
//      break;
//      k = i + j;
//      break label44;
//      m = 2 * this.mVerticalPadding + this.mFontH;
//      break label60;
//      i1 = (k - this.mIconSize - j - this.mIconPadding) / 2;
//      break label128;
//    }
//    this.mDecorateIcon.setBounds(i1, n, i1 + this.mIconSize, n + this.mIconSize);
//  }
//
//  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
//  {
//    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
//    this.mRect.set(this.mBorderWidth, this.mBorderWidth, paramInt1 - this.mBorderWidth, paramInt2 - this.mBorderWidth);
//  }
//
//  public boolean onTouchEvent(MotionEvent paramMotionEvent)
//  {
//    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
//    {
//    }
//    for (;;)
//    {
//      return super.onTouchEvent(paramMotionEvent);
//      this.mIsPressed = true;
//      invalidate();
//      continue;
//      if ((this.mIsPressed) && (!_isViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY())))
//      {
//        this.mIsPressed = false;
//        invalidate();
//        continue;
//        if (_isViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY())) {
//          _toggleTagCheckStatus();
//        }
//        if (this.mIsPressed)
//        {
//          this.mIsPressed = false;
//          invalidate();
//        }
//      }
//    }
//  }
//
//  public void setAutoToggleCheck(boolean paramBoolean)
//  {
//    this.mIsAutoToggleCheck = paramBoolean;
//  }
//
//  public void setBgColor(int paramInt)
//  {
//    this.mBgColor = paramInt;
//    invalidate();
//  }
//
//  public void setBgColorChecked(int paramInt)
//  {
//    this.mBgColorChecked = paramInt;
//    invalidate();
//  }
//
//  public void setBorderColor(int paramInt)
//  {
//    this.mBorderColor = paramInt;
//    invalidate();
//  }
//
//  public void setBorderColorChecked(int paramInt)
//  {
//    this.mBorderColorChecked = paramInt;
//    invalidate();
//  }
//
//  public void setBorderWidth(float paramFloat)
//  {
//    this.mBorderWidth = paramFloat;
//  }
//
//  public void setCheckListener(OnCheckedChangeListener paramOnCheckedChangeListener)
//  {
//    this.mCheckListener = paramOnCheckedChangeListener;
//  }
//
//  public void setChecked(boolean paramBoolean)
//  {
//    if (this.mIsChecked == paramBoolean) {}
//    do
//    {
//      return;
//      this.mIsChecked = paramBoolean;
//      requestLayout();
//      invalidate();
//    } while (this.mCheckListener == null);
//    this.mCheckListener.onCheckedChanged(this.mIsChecked);
//  }
//
//  public void setDecorateIcon(Drawable paramDrawable)
//  {
//    this.mDecorateIcon = paramDrawable;
//    _update();
//  }
//
//  public void setDecorateIconChange(Drawable paramDrawable)
//  {
//    this.mDecorateIconChange = paramDrawable;
//    _update();
//  }
//
//  public void setHorizontalPadding(int paramInt)
//  {
//    this.mHorizontalPadding = paramInt;
//    _update();
//  }
//
//  public void setIconPadding(int paramInt)
//  {
//    this.mIconPadding = paramInt;
//    _update();
//  }
//
//  public void setRadius(float paramFloat)
//  {
//    this.mRadius = paramFloat;
//    invalidate();
//  }
//
//  public void setScrimColor(int paramInt)
//  {
//    this.mScrimColor = paramInt;
//    invalidate();
//  }
//
//  public void setTagMode(int paramInt)
//  {
//    this.mTagMode = paramInt;
//    _update();
//  }
//
//  public void setTagShape(int paramInt)
//  {
//    this.mTagShape = paramInt;
//    _update();
//  }
//
//  public void setText(String paramString)
//  {
//    this.mText = paramString;
//    _update();
//  }
//
//  public void setTextChecked(String paramString)
//  {
//    this.mTextChecked = paramString;
//    _update();
//  }
//
//  public void setTextColor(int paramInt)
//  {
//    this.mTextColor = paramInt;
//    invalidate();
//  }
//
//  public void setTextColorChecked(int paramInt)
//  {
//    this.mTextColorChecked = paramInt;
//    invalidate();
//  }
//
//  public void setTextSize(float paramFloat)
//  {
//    this.mTextSize = paramFloat;
//  }
//
//  public void setVerticalPadding(int paramInt)
//  {
//    this.mVerticalPadding = paramInt;
//    _update();
//  }
//
//  public static abstract interface OnCheckedChangeListener
//  {
//    public abstract void onCheckedChanged(boolean paramBoolean);
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/utils/SimpleButton.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */