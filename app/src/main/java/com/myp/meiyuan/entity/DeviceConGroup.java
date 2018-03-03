package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/3/3.
 *
 * 设备bean
 */

public class DeviceConGroup implements Serializable {
    private int groupId;
    private String groupName;
    private int deviceId;
    private String deviceName;
    private int deviceTypeId;


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
}
