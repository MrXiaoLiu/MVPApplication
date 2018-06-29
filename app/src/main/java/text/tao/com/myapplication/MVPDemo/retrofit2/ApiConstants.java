package text.tao.com.myapplication.MVPDemo.retrofit2;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import text.tao.com.myapplication.MVPDemo.Api.bean.Bean2;
import text.tao.com.myapplication.MVPDemo.Api.bean.CollectBean;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.Api.bean.InfoBean;
import text.tao.com.myapplication.adapter.PrBean;
import text.tao.com.myapplication.push.Node;
import text.tao.com.myapplication.push.Node2;
import text.tao.com.myapplication.utils.BaseApi;

public interface ApiConstants {

    @Headers("urlname:manage")
    @GET("index/index")
    public abstract Flowable<Bean2<IndexBean>> getIndex();

    @Headers("urlname:manage")
    @GET("index/passwdLogin")
    public abstract Flowable<Bean2<InfoBean>> getInfo(@Query("user_name") String paramString1, @Query("user_passwd") String paramString2, @Query("user_country_code") String paramString3);

    @Headers("urlname:manage")
    @GET("personal/collectStewardList")
    public abstract Flowable<Bean2<CollectBean>> getLiveCollect(@Query("user_id") int paramInt, @Query("token") String paramString);


    @Headers("urlname:mdffx")
    @GET(BaseApi.STEWARD_LIST)
    Flowable<Bean2<PrBean>> getList(@Query("page") int page,@Query("ser_type")String ser_type);

    @Headers("urlname:ssss")
    @GET(BaseApi.SERVICE)
    Flowable<Node> getPush(@Query("key") String key,@Query("proto")String proto);

    @Headers("urlname:ssss")
    @GET(BaseApi.MSG)
    Flowable<Node2> Offline(@Query("key") String key,@Query("mid")String mid,@Query("pmid") String pmid);
}
