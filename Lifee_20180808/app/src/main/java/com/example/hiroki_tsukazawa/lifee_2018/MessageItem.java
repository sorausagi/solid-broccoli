package com.example.hiroki_tsukazawa.lifee_2018;

import java.util.Date;

/**
 * Created by Nousagi on 2018/09/09.
 */

public class MessageItem {
    private String edit01;
    private String edit02;
    private String edit03;
    private String edit04;
    private Date timestamp_;

    public void setMessage(String data) {
        edit01 = data;
    }

    public String getMessage() {
        return edit01;
    }

    public void setEdit02(String height) {
        edit02 = height;
    }

    public String getUserName() {
        return edit02;
    }

    public void setUserId(String whight) {
        edit03 = whight;
    }

    public String getUserId() {
        return edit03;
    }

    public void setTimestamp(Date timestamp) {
        timestamp_ = timestamp;
    }

    public Date getTimestamp() {
        return timestamp_;
    }
}
