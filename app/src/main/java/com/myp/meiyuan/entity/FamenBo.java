package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/2/28.
 * <p>
 * 阀门的数据
 */

public class FamenBo implements Serializable {


    /**
     * deviceId : 40
     * deviceName : 金枫模拟水阀
     * deviceTypeId : 15
     * estate : 1
     * lastStatusChangeTime : 2018-02-28 20:47:45
     * mode : 手动
     * timeParameters : 01:00-01:00-0%
     * timeStatus : 0
     */

    private int deviceId;
    private String deviceName;
    private int deviceTypeId;
    private int estate;
    private String lastStatusChangeTime;
    private String mode;
    private String timeParameters;
    private String timeStatus;

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    private String firstLetter;



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

    public int getEstate() {
        return estate;
    }

    public void setEstate(int estate) {
        this.estate = estate;
    }

    public String getLastStatusChangeTime() {
        return lastStatusChangeTime;
    }

    public void setLastStatusChangeTime(String lastStatusChangeTime) {
        this.lastStatusChangeTime = lastStatusChangeTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTimeParameters() {
        return timeParameters;
    }

    public void setTimeParameters(String timeParameters) {
        this.timeParameters = timeParameters;
    }

    public String getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(String timeStatus) {
        this.timeStatus = timeStatus;
    }
}
