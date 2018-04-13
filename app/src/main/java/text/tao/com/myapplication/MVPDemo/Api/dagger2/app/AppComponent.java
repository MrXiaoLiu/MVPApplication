package text.tao.com.myapplication.MVPDemo.Api.dagger2.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;


/**
 * 描述:AppComponent
 */
@Component(modules={AppModule.class, httpModule.class})
@Singleton
public  interface AppComponent
{
  Context getContext();
  
  RetrofitHelper getRetrofitHelper();
}
