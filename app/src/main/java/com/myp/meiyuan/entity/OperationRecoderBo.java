package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/3/3.
 * <p>
 * 操作记录bean
 */

public class OperationRecoderBo implements Serializable {


    /**
     * deviceId : 40
     * operation : 基础水阀添加定时
     * time : 2017-01-14 14:46:53
     */

    private int deviceId;
    private String operation;
    private String time;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
