//package text.tao.com.myapplication.view.dagger;
//
//import dagger.internal.Factory;
//
//public enum Student_Factory
//  implements Factory<Student>
//{
//  static
//  {
//    Student_Factory[] arrayOfStudent_Factory = new Student_Factory[1];
//    arrayOfStudent_Factory[0] = INSTANCE;
//    $VALUES = arrayOfStudent_Factory;
//  }
//
//  private Student_Factory() {}
//
//  public static Factory<Student> create()
//  {
//    return INSTANCE;
//  }
//
//  public Student get()
//  {
//    return new Student();
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/dagger/Student_Factory.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */