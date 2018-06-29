package text.tao.com.myapplication.push.ui;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import text.tao.com.myapplication.MVPDemo.Api.bean.Bean2;
import text.tao.com.myapplication.MVPDemo.exception.ApiException;


/**
 * 描述:RxUtils
 */
public class RxUtils {


  /**
   * 统一线程处理
   *
   * @param <T>
   * @return
   */
  public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程 统一处理线程
    return new FlowableTransformer<T, T>() {
      @Override
      public Publisher<T> apply(Flowable<T> observable) {
        //使用subscribeOn()指定被观察者代码运行的线程
        return observable.subscribeOn(Schedulers.io())
                //使用observerOn()指定订阅者运行的线程
                .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }
  /**
   * 生成Flowable
   *
   * @param <T>
   * @return
   */
  public static <T> Flowable<T> createData(final T t) {
    return Flowable.create(emitter -> {
      try {
        emitter.onNext(t);
        emitter.onComplete();
      } catch (Exception e) {
        emitter.onError(e);
      }
    }, BackpressureStrategy.BUFFER);
  }


  /**
   * 生成Flowable
   *
   * @param <T>
   * @return
   */
  public static <T> Flowable<List<T>> createData(final List<T> t) {
    return Flowable.create(emitter -> {
      try {
        emitter.onNext(t);
        emitter.onComplete();
      } catch (Exception e) {
        emitter.onError(e);
      }
    }, BackpressureStrategy.BUFFER);
  }
  /**
   * 统一返回结果处理
   *
   * @param <T>
   * @return
   */
  public static <T> FlowableTransformer<Bean2<T>, T> handleResult() {
    return new FlowableTransformer<Bean2<T>, T>() {
      @Override
      public Publisher<T> apply(Flowable<Bean2<T>> httpResponseFlowable) {
        return httpResponseFlowable.flatMap(new Function<Bean2<T>, Flowable<T>>() {
          @Override
          public Flowable<T> apply(Bean2<T> httpResponse) throws Exception {
            if (httpResponse.getStatus() == 1) {
              if (httpResponse.getData() != null)
                return createData(httpResponse.getData());
              return Flowable.error(new ApiException("服务器返回error"));
            } else {
              return Flowable.error(new ApiException("服务器返回error"));
            }
          }
        });
      }
    };
  }

  /**
   * 统一返回结果处理
   *
   * @param <T>
   * @return
   */
  public static <T> FlowableTransformer<Bean2<List<T>>, List<T>> handleListResult() {
    return new FlowableTransformer<Bean2<List<T>>, List<T>>() {
      @Override
      public Publisher<List<T>> apply(Flowable<Bean2<List<T>>> httpResponseFlowable) {
        return httpResponseFlowable.flatMap((Function<Bean2<List<T>>, Flowable<List<T>>>) httpResponse -> {
          if (httpResponse.getStatus() == 1) {
            if (httpResponse.getData() != null)
              return createData(httpResponse.getData());
            return Flowable.error(new ApiException("服务器返回error"));
          } else {
            return Flowable.error(new ApiException("服务器返回error"));
          }
        });
      }
    };
  }
  

}