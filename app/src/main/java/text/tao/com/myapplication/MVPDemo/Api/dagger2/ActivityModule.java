package text.tao.com.myapplication.MVPDemo.Api.dagger2;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.scope.ActivityScope;


/**
 * 描述:Activity模型
 */
@Module
public class ActivityModule
{
  private Activity mActivity;
  
  public ActivityModule(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  @Provides
  @ActivityScope
  public Activity provideActivity()
  {
    return this.mActivity;
  }
}
