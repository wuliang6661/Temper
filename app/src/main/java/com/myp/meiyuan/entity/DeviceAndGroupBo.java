package com.myp.meiyuan.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2018/3/3.
 *
 * 设备所属分组bean
 */

public class DeviceAndGroupBo implements Serializable{


    /**
     * devices : [{"deviceId":109,"deviceName":"接待区","deviceTypeId":1},{"deviceId":40,"deviceName":"接待区","deviceTypeId":2}]
     * groupId : 51
     * groupName : 明年
     */

    private int groupId;
    private String groupName;
    private List<DevicesBean> devices;

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

    public List<DevicesBean> getDevices() {
        return devices;
    }

    public void setDevices(List<DevicesBean> devices) {
        this.devices = devices;
    }

    public static class DevicesBean {
        /**
         * deviceId : 109
         * deviceName : 接待区
         * deviceTypeId : 1
         */

        private int deviceId;
        private String deviceName;
        private int deviceTypeId;

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
}
