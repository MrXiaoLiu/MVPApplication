package text.tao.com.myapplication.MVPDemo.Api.bean;

public class InfoBean {
  private String token;
  private UserInfoBean user_info;
  
  public String getToken()
  {
    return this.token;
  }
  
  public UserInfoBean getUser_info()
  {
    return this.user_info;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setUser_info(UserInfoBean paramUserInfoBean)
  {
    this.user_info = paramUserInfoBean;
  }
  
  public static class UserInfoBean
  {
    private String country_name;
    private String per_img;
    private String per_my_code;
    private String per_nickname;
    private String per_sex;
    private String per_spare_con_code;
    private String per_spare_phone;
    private int per_tiger_money;
    private String user_country_code;
    private int user_enabled;
    private int user_id;
    private String user_name;
    private int user_type;
    
    public String getCountry_name()
    {
      return this.country_name;
    }
    
    public String getPer_img()
    {
      return this.per_img;
    }
    
    public String getPer_my_code()
    {
      return this.per_my_code;
    }
    
    public String getPer_nickname()
    {
      return this.per_nickname;
    }
    
    public String getPer_sex()
    {
      return this.per_sex;
    }
    
    public String getPer_spare_con_code()
    {
      return this.per_spare_con_code;
    }
    
    public String getPer_spare_phone()
    {
      return this.per_spare_phone;
    }
    
    public int getPer_tiger_money()
    {
      return this.per_tiger_money;
    }
    
    public String getUser_country_code()
    {
      return this.user_country_code;
    }
    
    public int getUser_enabled()
    {
      return this.user_enabled;
    }
    
    public int getUser_id()
    {
      return this.user_id;
    }
    
    public String getUser_name()
    {
      return this.user_name;
    }
    
    public int getUser_type()
    {
      return this.user_type;
    }
    
    public void setCountry_name(String paramString)
    {
      this.country_name = paramString;
    }
    
    public void setPer_img(String paramString)
    {
      this.per_img = paramString;
    }
    
    public void setPer_my_code(String paramString)
    {
      this.per_my_code = paramString;
    }
    
    public void setPer_nickname(String paramString)
    {
      this.per_nickname = paramString;
    }
    
    public void setPer_sex(String paramString)
    {
      this.per_sex = paramString;
    }
    
    public void setPer_spare_con_code(String paramString)
    {
      this.per_spare_con_code = paramString;
    }
    
    public void setPer_spare_phone(String paramString)
    {
      this.per_spare_phone = paramString;
    }
    
    public void setPer_tiger_money(int paramInt)
    {
      this.per_tiger_money = paramInt;
    }
    
    public void setUser_country_code(String paramString)
    {
      this.user_country_code = paramString;
    }
    
    public void setUser_enabled(int paramInt)
    {
      this.user_enabled = paramInt;
    }
    
    public void setUser_id(int paramInt)
    {
      this.user_id = paramInt;
    }
    
    public void setUser_name(String paramString)
    {
      this.user_name = paramString;
    }
    
    public void setUser_type(int paramInt)
    {
      this.user_type = paramInt;
    }
  }
}
