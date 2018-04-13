//package text.tao.com.myapplication.view.dagger;
//
//import dagger.MembersInjector;
//import dagger.internal.Preconditions;
//import mvp.tao.com.Main5;
//import mvp.tao.com.Main5_MembersInjector;
//
//public final class DaggerA01SimpleComponent
//  implements A01SimpleComponent
//{
//  private MembersInjector<Main5> main5MembersInjector;
//
//  static
//  {
//    if (!DaggerA01SimpleComponent.class.desiredAssertionStatus()) {}
//    for (boolean bool = true;; bool = false)
//    {
//      $assertionsDisabled = bool;
//      return;
//    }
//  }
//
//  private DaggerA01SimpleComponent(Builder paramBuilder)
//  {
//    assert (paramBuilder != null);
//    initialize(paramBuilder);
//  }
//
//  public static Builder builder()
//  {
//    return new Builder(null);
//  }
//
//  public static A01SimpleComponent create()
//  {
//    return builder().build();
//  }
//
//  private void initialize(Builder paramBuilder)
//  {
//    this.main5MembersInjector = Main5_MembersInjector.create(Student_Factory.create());
//  }
//
//  public void inject(Main5 paramMain5)
//  {
//    this.main5MembersInjector.injectMembers(paramMain5);
//  }
//
//  public static final class Builder
//  {
//    @Deprecated
//    public Builder a01SimpleModule(A01SimpleModule paramA01SimpleModule)
//    {
//      Preconditions.checkNotNull(paramA01SimpleModule);
//      return this;
//    }
//
//    public A01SimpleComponent build()
//    {
//      return new DaggerA01SimpleComponent(this, null);
//    }
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/dagger/DaggerA01SimpleComponent.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */