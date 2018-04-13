package text.tao.com.myapplication.MVPDemo.Api.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseBean implements Parcelable {
    public static final Creator<BaseBean> CREATOR = new Creator() {
        public BaseBean createFromParcel(Parcel paramAnonymousParcel) {
            return new BaseBean(paramAnonymousParcel);
        }

        public BaseBean[] newArray(int paramAnonymousInt) {
            return new BaseBean[paramAnonymousInt];
        }
    };
    private String msg;
    private int status;
    private boolean token_status;

    public BaseBean() {
    }

    protected BaseBean(Parcel paramParcel) {
        this.status = paramParcel.readInt();
        if (paramParcel.readByte() != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.token_status = bool;
            this.msg = paramParcel.readString();
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.status);
        if (this.token_status) {
        }
        for (byte b = 1; ; b = 0) {
            paramParcel.writeByte(b);
            paramParcel.writeString(this.msg);
            return;
        }
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String paramString) {
        this.msg = paramString;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int paramInt) {
        this.status = paramInt;
    }

    public boolean isToken_status() {
        return this.token_status;
    }

    public void setToken_status(boolean paramBoolean) {
        this.token_status = paramBoolean;
    }
}
