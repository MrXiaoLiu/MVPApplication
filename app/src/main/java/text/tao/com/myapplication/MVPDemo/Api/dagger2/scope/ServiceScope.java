package text.tao.com.myapplication.MVPDemo.Api.dagger2.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * 描述:Fragment 生命周期
 */
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface ServiceScope {}
