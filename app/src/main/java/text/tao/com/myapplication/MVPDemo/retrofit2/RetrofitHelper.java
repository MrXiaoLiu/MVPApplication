package text.tao.com.myapplication.MVPDemo.retrofit2;

import io.reactivex.Flowable;
import text.tao.com.myapplication.MVPDemo.Api.bean.Bean2;
import text.tao.com.myapplication.MVPDemo.Api.bean.CollectBean;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.Api.bean.InfoBean;
import text.tao.com.myapplication.adapter.PrBean;
import text.tao.com.myapplication.push.Node;
import text.tao.com.myapplication.push.Node2;


/**
 * 描述:RetrofitHelper 帮助类
 */
public class RetrofitHelper {
    private final ApiConstants mLiveService;

    public RetrofitHelper(ApiConstants paramApiConstants) {
        this.mLiveService = paramApiConstants;
    }

    public Flowable<Bean2<IndexBean>> getIndex() {
        return this.mLiveService.getIndex();
    }

    public Flowable<Bean2<CollectBean>> getLiveCollect(int paramInt, String paramString) {
        return this.mLiveService.getLiveCollect(paramInt, paramString);
    }

    public Flowable<Bean2<InfoBean>> getLiveRecommend(String paramString1, String paramString2, String paramString3) {
        return this.mLiveService.getInfo(paramString1, paramString2, paramString3);
    }

    public Flowable<Bean2<PrBean>> getList(int page) {
        return this.mLiveService.getList(page, "4");
    }

    public Flowable<Node> getPush() {
        return this.mLiveService.getPush("ni", "2");
    }

    public Flowable<Node2> Offline(String key) {
        return this.mLiveService.Offline(key, "1", "1");
    }
}
