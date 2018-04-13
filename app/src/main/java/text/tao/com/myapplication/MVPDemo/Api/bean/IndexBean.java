package text.tao.com.myapplication.MVPDemo.Api.bean;

import java.util.List;

public class IndexBean {
  private List<AdListBean> ad_list;
  private List<BannerBean> banner;
  private Object home_pop_ad;
  private List<HotCityBean> hot_city;
  private List<PushHomestayBean> push_homestay;
  private List<PushStewardBean> push_steward;
  private List<RouteBean> route;
  private Object ticket;
  private List<?> topic;
  private List<TravelStoryBean> travel_story;
  
  public List<AdListBean> getAd_list()
  {
    return this.ad_list;
  }
  
  public List<BannerBean> getBanner()
  {
    return this.banner;
  }
  
  public Object getHome_pop_ad()
  {
    return this.home_pop_ad;
  }
  
  public List<HotCityBean> getHot_city()
  {
    return this.hot_city;
  }
  
  public List<PushHomestayBean> getPush_homestay()
  {
    return this.push_homestay;
  }
  
  public List<PushStewardBean> getPush_steward()
  {
    return this.push_steward;
  }
  
  public List<RouteBean> getRoute()
  {
    return this.route;
  }
  
  public Object getTicket()
  {
    return this.ticket;
  }
  
  public List<?> getTopic()
  {
    return this.topic;
  }
  
  public List<TravelStoryBean> getTravel_story()
  {
    return this.travel_story;
  }
  
  public void setAd_list(List<AdListBean> paramList)
  {
    this.ad_list = paramList;
  }
  
  public void setBanner(List<BannerBean> paramList)
  {
    this.banner = paramList;
  }
  
  public void setHome_pop_ad(Object paramObject)
  {
    this.home_pop_ad = paramObject;
  }
  
  public void setHot_city(List<HotCityBean> paramList)
  {
    this.hot_city = paramList;
  }
  
  public void setPush_homestay(List<PushHomestayBean> paramList)
  {
    this.push_homestay = paramList;
  }
  
  public void setPush_steward(List<PushStewardBean> paramList)
  {
    this.push_steward = paramList;
  }
  
  public void setRoute(List<RouteBean> paramList)
  {
    this.route = paramList;
  }
  
  public void setTicket(Object paramObject)
  {
    this.ticket = paramObject;
  }
  
  public void setTopic(List<?> paramList)
  {
    this.topic = paramList;
  }
  
  public void setTravel_story(List<TravelStoryBean> paramList)
  {
    this.travel_story = paramList;
  }
  
  public static class AdListBean
  {
    private String ad_share_img;
    private int ad_sub_type;
    private String desc;
    private String img;
    private String link;
    private String title;
    
    public String getAd_share_img()
    {
      return this.ad_share_img;
    }
    
    public int getAd_sub_type()
    {
      return this.ad_sub_type;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public String getLink()
    {
      return this.link;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setAd_share_img(String paramString)
    {
      this.ad_share_img = paramString;
    }
    
    public void setAd_sub_type(int paramInt)
    {
      this.ad_sub_type = paramInt;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setLink(String paramString)
    {
      this.link = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
  
  public static class BannerBean
  {
    private String ad_share_img;
    private int ad_sub_type;
    private String desc;
    private String img;
    private String link;
    private String title;
    
    public String getAd_share_img()
    {
      return this.ad_share_img;
    }
    
    public int getAd_sub_type()
    {
      return this.ad_sub_type;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public String getLink()
    {
      return this.link;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setAd_share_img(String paramString)
    {
      this.ad_share_img = paramString;
    }
    
    public void setAd_sub_type(int paramInt)
    {
      this.ad_sub_type = paramInt;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setLink(String paramString)
    {
      this.link = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
  
  public static class HotCityBean
  {
    private int homestay_num;
    private int id;
    private String img;
    private String name;
    private int ser_num;
    private int steward_num;
    
    public int getHomestay_num()
    {
      return this.homestay_num;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public int getSer_num()
    {
      return this.ser_num;
    }
    
    public int getSteward_num()
    {
      return this.steward_num;
    }
    
    public void setHomestay_num(int paramInt)
    {
      this.homestay_num = paramInt;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setSer_num(int paramInt)
    {
      this.ser_num = paramInt;
    }
    
    public void setSteward_num(int paramInt)
    {
      this.steward_num = paramInt;
    }
  }
  
  public static class PushHomestayBean
  {
    private String city_name;
    private String country_name;
    private int id;
    private String img;
    private List<String> label;
    private int max_price;
    private int min_price;
    private int original_price;
    private String ste_head_img;
    private int ste_id;
    private String title;
    private String unit;
    
    public String getCity_name()
    {
      return this.city_name;
    }
    
    public String getCountry_name()
    {
      return this.country_name;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public List<String> getLabel()
    {
      return this.label;
    }
    
    public int getMax_price()
    {
      return this.max_price;
    }
    
    public int getMin_price()
    {
      return this.min_price;
    }
    
    public int getOriginal_price()
    {
      return this.original_price;
    }
    
    public String getSte_head_img()
    {
      return this.ste_head_img;
    }
    
    public int getSte_id()
    {
      return this.ste_id;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getUnit()
    {
      return this.unit;
    }
    
    public void setCity_name(String paramString)
    {
      this.city_name = paramString;
    }
    
    public void setCountry_name(String paramString)
    {
      this.country_name = paramString;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setLabel(List<String> paramList)
    {
      this.label = paramList;
    }
    
    public void setMax_price(int paramInt)
    {
      this.max_price = paramInt;
    }
    
    public void setMin_price(int paramInt)
    {
      this.min_price = paramInt;
    }
    
    public void setOriginal_price(int paramInt)
    {
      this.original_price = paramInt;
    }
    
    public void setSte_head_img(String paramString)
    {
      this.ste_head_img = paramString;
    }
    
    public void setSte_id(int paramInt)
    {
      this.ste_id = paramInt;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setUnit(String paramString)
    {
      this.unit = paramString;
    }
  }
  
  public static class PushStewardBean
  {
    private String brief_sml;
    private String city_name;
    private int comment_star;
    private String country_name;
    private String grade;
    private int grade_code;
    private int id;
    private String img;
    private List<String> label;
    private String name;
    private List<String> service;
    
    public String getBrief_sml()
    {
      return this.brief_sml;
    }
    
    public String getCity_name()
    {
      return this.city_name;
    }
    
    public int getComment_star()
    {
      return this.comment_star;
    }
    
    public String getCountry_name()
    {
      return this.country_name;
    }
    
    public String getGrade()
    {
      return this.grade;
    }
    
    public int getGrade_code()
    {
      return this.grade_code;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImg()
    {
      return this.img;
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
    
    public void setBrief_sml(String paramString)
    {
      this.brief_sml = paramString;
    }
    
    public void setCity_name(String paramString)
    {
      this.city_name = paramString;
    }
    
    public void setComment_star(int paramInt)
    {
      this.comment_star = paramInt;
    }
    
    public void setCountry_name(String paramString)
    {
      this.country_name = paramString;
    }
    
    public void setGrade(String paramString)
    {
      this.grade = paramString;
    }
    
    public void setGrade_code(int paramInt)
    {
      this.grade_code = paramInt;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
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
  }
  
  public static class RouteBean
  {
    private String city_name;
    private String country_name;
    private String daynum_label;
    private int id;
    private String img;
    private List<String> label;
    private int max_price;
    private int min_price;
    private int original_price;
    private String ste_head_img;
    private int ste_id;
    private String title;
    private String unit;
    
    public String getCity_name()
    {
      return this.city_name;
    }
    
    public String getCountry_name()
    {
      return this.country_name;
    }
    
    public String getDaynum_label()
    {
      return this.daynum_label;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public List<String> getLabel()
    {
      return this.label;
    }
    
    public int getMax_price()
    {
      return this.max_price;
    }
    
    public int getMin_price()
    {
      return this.min_price;
    }
    
    public int getOriginal_price()
    {
      return this.original_price;
    }
    
    public String getSte_head_img()
    {
      return this.ste_head_img;
    }
    
    public int getSte_id()
    {
      return this.ste_id;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getUnit()
    {
      return this.unit;
    }
    
    public void setCity_name(String paramString)
    {
      this.city_name = paramString;
    }
    
    public void setCountry_name(String paramString)
    {
      this.country_name = paramString;
    }
    
    public void setDaynum_label(String paramString)
    {
      this.daynum_label = paramString;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setLabel(List<String> paramList)
    {
      this.label = paramList;
    }
    
    public void setMax_price(int paramInt)
    {
      this.max_price = paramInt;
    }
    
    public void setMin_price(int paramInt)
    {
      this.min_price = paramInt;
    }
    
    public void setOriginal_price(int paramInt)
    {
      this.original_price = paramInt;
    }
    
    public void setSte_head_img(String paramString)
    {
      this.ste_head_img = paramString;
    }
    
    public void setSte_id(int paramInt)
    {
      this.ste_id = paramInt;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setUnit(String paramString)
    {
      this.unit = paramString;
    }
  }
  
  public static class TravelStoryBean
  {
    private String art_img;
    private String art_tag;
    private String author;
    private String city_name;
    private String country_name;
    private int create_time;
    private String desc;
    private int id;
    private String img;
    private String ste_head_img;
    private int ste_id;
    private String title;
    
    public String getArt_img()
    {
      return this.art_img;
    }
    
    public String getArt_tag()
    {
      return this.art_tag;
    }
    
    public String getAuthor()
    {
      return this.author;
    }
    
    public String getCity_name()
    {
      return this.city_name;
    }
    
    public String getCountry_name()
    {
      return this.country_name;
    }
    
    public int getCreate_time()
    {
      return this.create_time;
    }
    
    public String getDesc()
    {
      return this.desc;
    }
    
    public int getId()
    {
      return this.id;
    }
    
    public String getImg()
    {
      return this.img;
    }
    
    public String getSte_head_img()
    {
      return this.ste_head_img;
    }
    
    public int getSte_id()
    {
      return this.ste_id;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setArt_img(String paramString)
    {
      this.art_img = paramString;
    }
    
    public void setArt_tag(String paramString)
    {
      this.art_tag = paramString;
    }
    
    public void setAuthor(String paramString)
    {
      this.author = paramString;
    }
    
    public void setCity_name(String paramString)
    {
      this.city_name = paramString;
    }
    
    public void setCountry_name(String paramString)
    {
      this.country_name = paramString;
    }
    
    public void setCreate_time(int paramInt)
    {
      this.create_time = paramInt;
    }
    
    public void setDesc(String paramString)
    {
      this.desc = paramString;
    }
    
    public void setId(int paramInt)
    {
      this.id = paramInt;
    }
    
    public void setImg(String paramString)
    {
      this.img = paramString;
    }
    
    public void setSte_head_img(String paramString)
    {
      this.ste_head_img = paramString;
    }
    
    public void setSte_id(int paramInt)
    {
      this.ste_id = paramInt;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}

