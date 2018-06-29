package text.tao.com.myapplication.MVPDemo.Api.dagger2;

import android.app.Activity;
import android.app.Service;

import dagger.Module;
import dagger.Provides;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.scope.ActivityScope;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.scope.ServiceScope;


/**
 * 描述:Activity模型
 */
@Module
public class ServiceModule
{
  private Service mService;

  public ServiceModule(Service paramService)
  {
    this.mService = paramService;
  }
  
  @Provides
  @ServiceScope
  public Service provideActivity()
  {
    return this.mService;
  }
}
