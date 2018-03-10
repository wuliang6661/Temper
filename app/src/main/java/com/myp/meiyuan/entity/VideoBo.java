package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/3/10.
 * <p>
 * 视频bo
 */

public class VideoBo implements Serializable {


    /**
     * deviceID : 7XTTN9YHFCLED4RV111A
     * deviceId : 63
     * deviceName : 兰科植物全景
     * deviceTypeId : 5
     * live_url : com.baibeiyun.xiaokedou.base.
     * password : admin
     * state : 0
     */

    private String deviceID;
    private int deviceId;
    private String deviceName;
    private int deviceTypeId;
    private String live_url;
    private String password;
    private int state;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(int deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getLive_url() {
        return live_url;
    }

    public void setLive_url(String live_url) {
        this.live_url = live_url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
