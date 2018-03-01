package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/2/28.
 * <p>
 * 阀门的数据
 */

public class FamenBo implements Serializable {


    /**
     * deviceId : 39
     * deviceName : 金枫基础水阀
     * deviceTypeId : 6
     * estate : 离线
     * lastStatusChangeTime : 2018-02-28 00:00:00
     * mode : 手动
     */

    private int deviceId;
    private String deviceName;
    private int deviceTypeId;
    private String estate;
    private String lastStatusChangeTime;
    private String mode;

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

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
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
}
