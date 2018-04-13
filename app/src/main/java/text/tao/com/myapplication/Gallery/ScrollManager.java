//package text.tao.com.myapplication.Gallery;
//
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.LinearSnapHelper;
//import android.support.v7.widget.PagerSnapHelper;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.OnScrollListener;
//
//public class ScrollManager
//{
//  private static final int SLIDE_BOTTOM = 4;
//  private static final int SLIDE_LEFT = 1;
//  private static final int SLIDE_RIGHT = 2;
//  private static final int SLIDE_TOP = 3;
//  private static final String TAG = "ScrollManager";
//  private int mConsumeX = 0;
//  private int mConsumeY = 0;
//  private GalleryRecyclerView mGalleryRecyclerView;
//  private LinearSnapHelper mLinearySnapHelper;
//  private PagerSnapHelper mPagerSnapHelper;
//  private int mPosition = 0;
//  private int slideDirct = 2;
//
//  public ScrollManager(GalleryRecyclerView paramGalleryRecyclerView)
//  {
//    this.mGalleryRecyclerView = paramGalleryRecyclerView;
//  }
//
//  private int getPosition(int paramInt1, int paramInt2)
//  {
//    int i = Math.round(paramInt1 / paramInt2);
//    this.mPosition = i;
//    return i;
//  }
//
//  private void onHoritiontalScroll(final RecyclerView paramRecyclerView, int paramInt)
//  {
//    DLog.d("ScrollManager", "mConsumeX=" + this.mConsumeX + "; dx=" + paramInt);
//    this.mConsumeX = (paramInt + this.mConsumeX);
//    if (paramInt > 0) {}
//    for (this.slideDirct = 2;; this.slideDirct = 1)
//    {
//      paramRecyclerView.post(new Runnable()
//      {
//        public void run()
//        {
//          int i = GalleryItemDecoration.mItemComusemX;
//          int j = ScrollManager.this.getPosition(ScrollManager.this.mConsumeX, i);
//          float f1 = ScrollManager.this.mConsumeX / i;
//          if ((f1 >= 1 + ScrollManager.this.mGalleryRecyclerView.getLinearLayoutManager().findFirstVisibleItemPosition()) && (ScrollManager.this.slideDirct == 2)) {
//            return;
//          }
//          float f2 = f1 - (int)f1;
//          DLog.d("ScrollManager", "offset=" + f1 + "; percent=" + f2 + "; mConsumeX=" + ScrollManager.this.mConsumeX + "; shouldConsumeX=" + i + "; position=" + j);
//          AnimManager.getInstance().setAnimation(paramRecyclerView, j, f2);
//        }
//      });
//      return;
//    }
//  }
//
//  private void onVerticalScroll(final RecyclerView paramRecyclerView, int paramInt)
//  {
//    this.mConsumeY = (paramInt + this.mConsumeY);
//    if (paramInt > 0) {}
//    for (this.slideDirct = 4;; this.slideDirct = 3)
//    {
//      paramRecyclerView.post(new Runnable()
//      {
//        public void run()
//        {
//          int i = GalleryItemDecoration.mItemComusemY;
//          int j = ScrollManager.this.getPosition(ScrollManager.this.mConsumeY, i);
//          float f1 = ScrollManager.this.mConsumeY / i;
//          if ((f1 >= 1 + ScrollManager.this.mGalleryRecyclerView.getLinearLayoutManager().findFirstVisibleItemPosition()) && (ScrollManager.this.slideDirct == 4)) {
//            return;
//          }
//          float f2 = f1 - (int)f1;
//          DLog.d("ScrollManager", "offset=" + f1 + "; mConsumeY=" + ScrollManager.this.mConsumeY + "; shouldConsumeY=" + i);
//          AnimManager.getInstance().setAnimation(paramRecyclerView, j, f2);
//        }
//      });
//      return;
//    }
//  }
//
//  public int getPosition()
//  {
//    return this.mPosition;
//  }
//
//  public void initScrollListener()
//  {
//    GalleryScrollerListener localGalleryScrollerListener = new GalleryScrollerListener();
//    this.mGalleryRecyclerView.addOnScrollListener(localGalleryScrollerListener);
//  }
//
//  public void initSnapHelper(int paramInt)
//  {
//    switch (paramInt)
//    {
//    default:
//      return;
//    case 0:
//      this.mLinearySnapHelper = new LinearSnapHelper();
//      this.mLinearySnapHelper.attachToRecyclerView(this.mGalleryRecyclerView);
//      return;
//    }
//    this.mPagerSnapHelper = new PagerSnapHelper();
//    this.mPagerSnapHelper.attachToRecyclerView(this.mGalleryRecyclerView);
//  }
//
//  public void updateComsume()
//  {
//    this.mConsumeX += OsUtil.dpToPx(GalleryItemDecoration.mLeftPageVisibleWidth + 2 * GalleryItemDecoration.mPageMargin);
//    this.mConsumeY += OsUtil.dpToPx(GalleryItemDecoration.mLeftPageVisibleWidth + 2 * GalleryItemDecoration.mPageMargin);
//    DLog.d("ScrollManager", "updateComsume mConsumeX=" + this.mConsumeX);
//  }
//
//  class GalleryScrollerListener
//    extends RecyclerView.OnScrollListener
//  {
//    GalleryScrollerListener() {}
//
//    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
//    {
//      DLog.d("ScrollManager", "newState=" + paramInt);
//      super.onScrollStateChanged(paramRecyclerView, paramInt);
//    }
//
//    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
//    {
//      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
//      if (!ScrollManager.this.mGalleryRecyclerView.getHasWindowFocus()) {
//        return;
//      }
//      if (ScrollManager.this.mGalleryRecyclerView.getOrientation() == 0)
//      {
//        ScrollManager.this.onHoritiontalScroll(paramRecyclerView, paramInt1);
//        return;
//      }
//      ScrollManager.this.onVerticalScroll(paramRecyclerView, paramInt2);
//    }
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/ScrollManager.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */