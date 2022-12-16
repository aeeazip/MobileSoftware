package ddwucom.mobile.week10.customadaptertest;

import android.content.Context;

public class MyData {
    private long _id;
    private String name;
    private String phone;

    public MyData(long _id, String name, String phone) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
