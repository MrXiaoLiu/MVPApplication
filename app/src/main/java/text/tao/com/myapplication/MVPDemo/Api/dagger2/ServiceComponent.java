package text.tao.com.myapplication.MVPDemo.Api.dagger2;

import android.app.Service;

import dagger.Component;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.app.AppComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.scope.ActivityScope;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.scope.ServiceScope;
import text.tao.com.myapplication.push.BaseService;
import text.tao.com.myapplication.push.ui.BackService2;

@Component(dependencies={AppComponent.class}, modules={ServiceModule.class})
@ServiceScope
public  interface ServiceComponent
{
 Service getService();
  
  void inject(BackService2 backService2);

  void inject(BaseService baseService);


}
