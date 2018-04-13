//package text.tao.com.myapplication.Gallery;
//
//import android.content.res.Resources;
//import android.content.res.TypedArray;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.graphics.drawable.TransitionDrawable;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.OnScrollListener;
//import android.util.Log;
//import android.view.View;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import mvp.tao.com.utils.BlurBitmapUtil;
//
//public class Main8
//  extends AppCompatActivity
//  implements GalleryRecyclerView.OnItemClickListener
//{
//  private static final String KEY_PRE_DRAW = "key_pre_draw";
//  private RelativeLayout mContainer;
//  private GalleryRecyclerView mRecyclerView;
//  private Map<String, Drawable> mTSDraCacheMap = new HashMap();
//
//  public List<Integer> getDatas()
//  {
//    int i = 0;
//    TypedArray localTypedArray = getResources().obtainTypedArray(2131623938);
//    int[] arrayOfInt = new int[localTypedArray.length()];
//    for (int j = 0; j < localTypedArray.length(); j++) {
//      arrayOfInt[j] = localTypedArray.getResourceId(j, 0);
//    }
//    localTypedArray.recycle();
//    ArrayList localArrayList = new ArrayList();
//    int k = arrayOfInt.length;
//    while (i < k)
//    {
//      localArrayList.add(Integer.valueOf(arrayOfInt[i]));
//      i++;
//    }
//    return localArrayList;
//  }
//
//  protected void onCreate(Bundle paramBundle)
//  {
//    super.onCreate(paramBundle);
//    setContentView(2130968644);
//    this.mRecyclerView = ((GalleryRecyclerView)findViewById(2131689707));
//    this.mContainer = ((RelativeLayout)findViewById(2131689706));
//    DLog.setDebug(true);
//    RecyclerAdapter localRecyclerAdapter = new RecyclerAdapter(getApplicationContext(), getDatas());
//    this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
//    this.mRecyclerView.setAdapter(localRecyclerAdapter);
//    this.mRecyclerView.initFlingSpeed(9000).initPageParams(0, 60).setAnimFactor(0.15F).setAnimType(0).setOnItemClickListener(this);
//    this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
//    {
//      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
//      {
//        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
//        Log.i("aaa", "第几个图片" + (1 + Main8.this.mRecyclerView.getScrolledPosition()));
//        if (paramAnonymousInt == 0) {
//          Main8.this.setBlurImage();
//        }
//      }
//    });
//    setBlurImage();
//  }
//
//  public void onItemClick(View paramView, int paramInt)
//  {
//    Toast.makeText(getApplicationContext(), "position=" + paramInt, 0).show();
//  }
//
//  public void setBlurImage()
//  {
//    if (((RecyclerAdapter)this.mRecyclerView.getAdapter() == null) || (this.mRecyclerView == null)) {
//      return;
//    }
//    this.mRecyclerView.post(new Runnable()
//    {
//      public void run()
//      {
//        int i = ((RecyclerAdapter)Main8.this.mRecyclerView.getAdapter()).getResId(Main8.this.mRecyclerView.getScrolledPosition());
//        Bitmap localBitmap = BitmapFactory.decodeResource(Main8.this.getResources(), i);
//        BitmapDrawable localBitmapDrawable = new BitmapDrawable(BlurBitmapUtil.blurBitmap(Main8.this.mRecyclerView.getContext(), localBitmap, 15.0F));
//        if (Main8.this.mTSDraCacheMap.get("key_pre_draw") == null) {}
//        for (Object localObject = localBitmapDrawable;; localObject = (Drawable)Main8.this.mTSDraCacheMap.get("key_pre_draw"))
//        {
//          TransitionDrawable localTransitionDrawable = new TransitionDrawable(new Drawable[] { localObject, localBitmapDrawable });
//          Main8.this.mContainer.setBackgroundDrawable(localTransitionDrawable);
//          localTransitionDrawable.startTransition(500);
//          Main8.this.mTSDraCacheMap.put("key_pre_draw", localBitmapDrawable);
//          return;
//        }
//      }
//    });
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/Gallery/Main8.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */