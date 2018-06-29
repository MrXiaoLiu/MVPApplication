package text.tao.com.myapplication;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/4
 */

public class User extends BaseObservable{

    String name;

    public User(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void onClick(View view) {
        Toast.makeText(view.getContext(), "click", Toast.LENGTH_SHORT).show();
    }
}
