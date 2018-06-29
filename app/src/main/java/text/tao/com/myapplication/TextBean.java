package text.tao.com.myapplication;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/11
 */

public class TextBean {

    String name;

    public TextBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
