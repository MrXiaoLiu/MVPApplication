package text.tao.com.myapplication.view.RemoteControl;

import java.io.Serializable;

public class DraggableInfo
  implements Serializable
{
  private int id;
  private int pic;
  private String text;
  private int type;

  public DraggableInfo(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.text = paramString;
    this.pic = paramInt1;
    this.id = paramInt2;
    this.type = paramInt3;
  }

  public int getId()
  {
    return this.id;
  }

  public int getPic()
  {
    return this.pic;
  }

  public String getText()
  {
    return this.text;
  }

  public int getType()
  {
    return this.type;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setPic(int paramInt)
  {
    this.pic = paramInt;
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}

