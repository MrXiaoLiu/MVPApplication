//package text.tao.com.myapplication.Gallery;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.Adapter;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import mvp.tao.com.R.styleable;
//
//public class GalleryRecyclerView
//  extends RecyclerView
//{
//  public static final int LinearySnapHelper = 0;
//  public static final int PagerSnapHelper = 1;
//  private int FLING_SPEED = 1000;
//  private GalleryItemDecoration mDecoration;
//  public boolean mHasWindowFocus = false;
//  private ScrollManager mScrollManager;
//
//  public GalleryRecyclerView(Context paramContext)
//  {
//    this(paramContext, null);
//  }
//
//  public GalleryRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
//  {
//    this(paramContext, paramAttributeSet, 0);
//  }
//
//  public GalleryRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
//  {
//    super(paramContext, paramAttributeSet, paramInt);
//    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.gallery_recyclerview);
//    int i = localTypedArray.getInteger(0, 0);
//    localTypedArray.recycle();
//    attachDecoration();
//    attachToRecyclerHelper(i);
//  }
//
//  private void attachDecoration()
//  {
//    this.mDecoration = new GalleryItemDecoration();
//    addItemDecoration(this.mDecoration);
//  }
//
//  private void attachToRecyclerHelper(int paramInt)
//  {
//    Log.i("aaa", "这个是多少" + paramInt);
//    this.mScrollManager = new ScrollManager(this);
//    this.mScrollManager.initSnapHelper(paramInt);
//  }
//
//  private int balancelocity(int paramInt)
//  {
//    if (paramInt > 0) {
//      return Math.min(paramInt, this.FLING_SPEED);
//    }
//    return Math.max(paramInt, -this.FLING_SPEED);
//  }
//
//  public boolean fling(int paramInt1, int paramInt2)
//  {
//    return super.fling(balancelocity(paramInt1), balancelocity(paramInt2));
//  }
//
//  public boolean getHasWindowFocus()
//  {
//    return this.mHasWindowFocus;
//  }
//
//  public LinearLayoutManager getLinearLayoutManager()
//  {
//    if ((getLayoutManager() instanceof LinearLayoutManager))
//    {
//      if ((getLayoutManager() instanceof GridLayoutManager)) {
//        throw new RuntimeException("请设置LayoutManager为LinearLayoutManager");
//      }
//      return (LinearLayoutManager)getLayoutManager();
//    }
//    throw new RuntimeException("请设置LayoutManager为LinearLayoutManager");
//  }
//
//  public int getOrientation()
//  {
//    if ((getLayoutManager() instanceof LinearLayoutManager))
//    {
//      if ((getLayoutManager() instanceof GridLayoutManager)) {
//        throw new RuntimeException("请设置LayoutManager为LinearLayoutManager");
//      }
//      return ((LinearLayoutManager)getLayoutManager()).getOrientation();
//    }
//    throw new RuntimeException("请设置LayoutManager为LinearLayoutManager");
//  }
//
//  public int getScrolledPosition()
//  {
//    if (this.mScrollManager == null) {
//      return 0;
//    }
//    return this.mScrollManager.getPosition();
//  }
//
//  public GalleryRecyclerView initFlingSpeed(int paramInt)
//  {
//    this.FLING_SPEED = paramInt;
//    return this;
//  }
//
//  public GalleryRecyclerView initPageParams(int paramInt1, int paramInt2)
//  {
//    GalleryItemDecoration.mPageMargin = paramInt1;
//    GalleryItemDecoration.mLeftPageVisibleWidth = paramInt2;
//    return this;
//  }
//
//  protected void onFinishInflate()
//  {
//    super.onFinishInflate();
//  }
//
//  public void onWindowFocusChanged(boolean paramBoolean)
//  {
//    super.onWindowFocusChanged(paramBoolean);
//    this.mHasWindowFocus = paramBoolean;
//    if (getAdapter().getItemCount() <= 0) {
//      return;
//    }
//    if (paramBoolean) {
//      smoothScrollToPosition(0);
//    }
//    for (;;)
//    {
//      this.mScrollManager.initScrollListener();
//      if (this.mScrollManager == null) {
//        break;
//      }
//      this.mScrollManager.updateComsume();
//      return;
//      scrollToPosition(0);
//    }
//  }
//
//  public GalleryRecyclerView setAnimFactor(float paramFloat)
//  {
//    AnimManager.getInstance().setmAnimFactor(paramFloat);
//    return this;
//  }
//
//  public GalleryRecyclerView setAnimType(int paramInt)
//  {
//    AnimManager.getInstance().setmAnimType(paramInt);
//    return this;
//  }
//
//  public GalleryRecyclerView setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
//  {
//    if (this.mDecoration != null) {
//      this.mDecoration.setOnItemClickListener(paramOnItemClickListener);
//    }
//    return this;
//  }
//
//  public static abstract interface OnItemClickListener
//  {
//    public abstract void onItemClick(View paramView, int paramInt);
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/GalleryRecyclerView.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */