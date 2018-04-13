package text.tao.com.myapplication.MVPDemo.Api.bean;

public class Bean2<T> extends BaseBean
{
  private T data;
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public void setData(T paramT)
  {
    this.data = paramT;
  }
}

