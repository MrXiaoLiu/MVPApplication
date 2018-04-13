package text.tao.com.myapplication.MVPDemo.retrofit2;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import text.tao.com.myapplication.MVPDemo.Api.bean.Bean2;
import text.tao.com.myapplication.MVPDemo.Api.bean.CollectBean;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.Api.bean.InfoBean;
import text.tao.com.myapplication.utils.BaseApi;

public  interface ApiConstants
{
   String APP_BASE_URL = BaseApi.base;
  
  @GET("index/index")
  public abstract Flowable<Bean2<IndexBean>> getIndex();
  
  @GET("index/passwdLogin")
  public abstract Flowable<Bean2<InfoBean>> getInfo(@Query("user_name") String paramString1, @Query("user_passwd") String paramString2, @Query("user_country_code") String paramString3);
  
  @GET("personal/collectStewardList")
  public abstract Flowable<Bean2<CollectBean>> getLiveCollect(@Query("user_id") int paramInt, @Query("token") String paramString);
}
