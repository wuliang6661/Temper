package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/2/25.
 * <p>
 * 设备状态bean
 */

public class DeviceBO implements Serializable {


    /**
     * deviceId : 109
     * deviceName : 接待区
     * deviceTypeId : 1
     * deviceTypeName : 空气温度设备
     * estate : 在线
     * lastTime : 2018-02-25 11:12:43
     * value : 13.50℃
     */

    private int deviceId;
    private String deviceName;
    private int deviceTypeId;
    private String deviceTypeName;
    private String estate;
    private String lastTime;
    private String value;

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

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
