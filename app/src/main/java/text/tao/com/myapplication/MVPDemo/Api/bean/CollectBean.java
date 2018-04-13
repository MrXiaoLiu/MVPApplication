package text.tao.com.myapplication.MVPDemo.Api.bean;

import java.util.List;

public class CollectBean {
  private List<SteListBean> ste_list;
  
  public List<SteListBean> getSte_list()
  {
    return this.ste_list;
  }
  
  public void setSte_list(List<SteListBean> paramList)
  {
    this.ste_list = paramList;
  }
  
  public static class SteListBean
  {
    private String brief;
    private int col_id;
    private int comment_star;
    private String head_img;
    private int is_show;
    private List<String> label;
    private String name;
    private List<String> service;
    private int ste_id;
    
    public String getBrief()
    {
      return this.brief;
    }
    
    public int getCol_id()
    {
      return this.col_id;
    }
    
    public int getComment_star()
    {
      return this.comment_star;
    }
    
    public String getHead_img()
    {
      return this.head_img;
    }
    
    public int getIs_show()
    {
      return this.is_show;
    }
    
    public List<String> getLabel()
    {
      return this.label;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public List<String> getService()
    {
      return this.service;
    }
    
    public int getSte_id()
    {
      return this.ste_id;
    }
    
    public void setBrief(String paramString)
    {
      this.brief = paramString;
    }
    
    public void setCol_id(int paramInt)
    {
      this.col_id = paramInt;
    }
    
    public void setComment_star(int paramInt)
    {
      this.comment_star = paramInt;
    }
    
    public void setHead_img(String paramString)
    {
      this.head_img = paramString;
    }
    
    public void setIs_show(int paramInt)
    {
      this.is_show = paramInt;
    }
    
    public void setLabel(List<String> paramList)
    {
      this.label = paramList;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setService(List<String> paramList)
    {
      this.service = paramList;
    }
    
    public void setSte_id(int paramInt)
    {
      this.ste_id = paramInt;
    }
  }
}

