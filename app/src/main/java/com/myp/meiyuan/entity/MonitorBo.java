package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/2/25.
 * <p>
 * 监测状态bean
 */

public class MonitorBo implements Serializable {


    /**
     * lastTime : 2018-02-10 11:13:10
     * value : 15.80
     */

    private String lastTime;
    private String value;

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
