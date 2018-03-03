package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/3/3.
 *
 * 用户bean
 */

public class UserBo implements Serializable{


    /**
     * email : 1235689@qq.com
     * name : 赣州
     * phone : 18888888888
     * touxiangsrc : /images/e60e5a42-f8e1-42c6-8525-a4f3f953b7c2.jpg
     */

    private String email;
    private String name;
    private String phone;
    private String touxiangsrc;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTouxiangsrc() {
        return touxiangsrc;
    }

    public void setTouxiangsrc(String touxiangsrc) {
        this.touxiangsrc = touxiangsrc;
    }
}
