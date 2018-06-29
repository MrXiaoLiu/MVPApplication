package text.tao.com.myapplication.adapter;

import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/7
 */

public class PrBean {


    private List<ServiceListBean> service_list;

    public List<ServiceListBean> getService_list() {
        return service_list;
    }

    public void setService_list(List<ServiceListBean> service_list) {
        this.service_list = service_list;
    }

    public static class ServiceListBean {
        /**
         * ser_id : 2212
         * ser_img : https://static.tigeryou.com/upload/self/56da9829d6024c6be3a8d9089f74961d.jpeg
         * ser_min_price : 1
         * ser_max_price : 1
         * ser_unit : 人
         * ste_id : 109086
         * ste_head_img : https://static.tigeryou.com/upload/head/109086_1512376227458.png
         * ser_title : 温泉、熊牧场、北海道，彩色梦境之旅123
         * original_price : 100000
         * daynum_label : 一日游
         * country_name : 中国
         * city_name : 嘉兴
         * ser_type : 线路玩法
         */

        private int ser_id;
        private String ser_img;
        private int ser_min_price;
        private int ser_max_price;
        private String ser_unit;
        private int ste_id;
        private String ste_head_img;
        private String ser_title;
        private int original_price;
        private String daynum_label;
        private String country_name;
        private String city_name;
        private String ser_type;

        public int getSer_id() {
            return ser_id;
        }

        public void setSer_id(int ser_id) {
            this.ser_id = ser_id;
        }

        public String getSer_img() {
            return ser_img;
        }

        public void setSer_img(String ser_img) {
            this.ser_img = ser_img;
        }

        public int getSer_min_price() {
            return ser_min_price;
        }

        public void setSer_min_price(int ser_min_price) {
            this.ser_min_price = ser_min_price;
        }

        public int getSer_max_price() {
            return ser_max_price;
        }

        public void setSer_max_price(int ser_max_price) {
            this.ser_max_price = ser_max_price;
        }

        public String getSer_unit() {
            return ser_unit;
        }

        public void setSer_unit(String ser_unit) {
            this.ser_unit = ser_unit;
        }

        public int getSte_id() {
            return ste_id;
        }

        public void setSte_id(int ste_id) {
            this.ste_id = ste_id;
        }

        public String getSte_head_img() {
            return ste_head_img;
        }

        public void setSte_head_img(String ste_head_img) {
            this.ste_head_img = ste_head_img;
        }

        public String getSer_title() {
            return ser_title;
        }

        public void setSer_title(String ser_title) {
            this.ser_title = ser_title;
        }

        public int getOriginal_price() {
            return original_price;
        }

        public void setOriginal_price(int original_price) {
            this.original_price = original_price;
        }

        public String getDaynum_label() {
            return daynum_label;
        }

        public void setDaynum_label(String daynum_label) {
            this.daynum_label = daynum_label;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getSer_type() {
            return ser_type;
        }

        public void setSer_type(String ser_type) {
            this.ser_type = ser_type;
        }
    }
}
