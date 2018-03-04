package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/3/3.
 *
 * 用户bean
 */

public class UserBo implements Serializable{


    /**
     * address : 西园四路
     * addressDetail : 8幢8楼
     * company : 百倍云
     * dept : 研发部
     * email : @163.com
     * gender : 0
     * name : Djdj
     * phone : Jddjj
     * telPhone : 0731
     * touxiangsrc : /images/bd411ef5-d69c-41ae-bd16-c7efb4ed8b01.jpg
     */

    private String address;
    private String addressDetail;
    private String company;
    private String dept;
    private String email;
    private int gender;
    private String name;
    private String phone;
    private String telPhone;
    private String touxiangsrc;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getTouxiangsrc() {
        return touxiangsrc;
    }

    public void setTouxiangsrc(String touxiangsrc) {
        this.touxiangsrc = touxiangsrc;
    }
}
