package text.tao.com.myapplication.MVPDemo.Api.dagger2;

import android.app.Activity;
import dagger.Component;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.app.AppComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.scope.ActivityScope;
import text.tao.com.myapplication.MVPDemo.ui.MainDemoActivity;

@Component(dependencies={AppComponent.class}, modules={ActivityModule.class})
@ActivityScope
public  interface ActivityComponent
{
 Activity getActivity();
  
  void inject(MainDemoActivity paramMainDemoActivity);
}
