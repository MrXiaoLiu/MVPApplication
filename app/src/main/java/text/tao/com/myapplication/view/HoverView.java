//package text.tao.com.myapplication.view;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.widget.LinearLayout;
//
//public class HoverView
//  extends LinearLayout
//  implements ViewStateManager
//{
//  public static final float TOP_CLOSE = 0.9F;
//  private final String TAG = getClass().getSimpleName();
//  private Context mContext;
//  private float mTopFill = 0.0F;
//  private float mTopHover = 0.6F;
//
//  public HoverView(Context paramContext)
//  {
//    super(paramContext);
//    init(paramContext);
//    initAttrs(paramContext, null);
//  }
//
//  public HoverView(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    super(paramContext, paramAttributeSet);
//    init(paramContext);
//    initAttrs(paramContext, paramAttributeSet);
//  }
//
//  public HoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
//  {
//    super(paramContext, paramAttributeSet, paramInt);
//    init(paramContext);
//    initAttrs(paramContext, paramAttributeSet);
//  }
//
//  private void init(Context paramContext)
//  {
//    this.mContext = paramContext;
//  }
//
//  public void changeState(ViewState paramViewState)
//  {
//    changeState(paramViewState, true);
//  }
//
//  public void changeState(ViewState paramViewState, boolean paramBoolean)
//  {
//    if (getContainer() != null) {
//      getContainer().changeState(paramViewState, paramBoolean);
//    }
//  }
//
//  public HoverViewContainer getContainer()
//  {
//    if ((getParent() instanceof HoverViewContainer)) {
//      return (HoverViewContainer)getParent();
//    }
//    return null;
//  }
//
//  public ViewState getState()
//  {
//    if (getContainer() != null) {
//      return getContainer().getState();
//    }
//    return ViewState.CLOSE;
//  }
//
//  public float getTopFill()
//  {
//    return this.mTopFill;
//  }
//
//  public float getTopHover()
//  {
//    return this.mTopHover;
//  }
//
//  protected void initAttrs(Context paramContext, AttributeSet paramAttributeSet)
//  {
//    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HoverView);
//    this.mTopFill = localTypedArray.getFloat(0, this.mTopFill);
//    this.mTopHover = localTypedArray.getFloat(1, this.mTopHover);
//    localTypedArray.recycle();
//  }
//
//  public void setTopFill(float paramFloat)
//  {
//    this.mTopFill = paramFloat;
//  }
//
//  public void setTopHover(float paramFloat)
//  {
//    this.mTopHover = paramFloat;
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/HoverView.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */