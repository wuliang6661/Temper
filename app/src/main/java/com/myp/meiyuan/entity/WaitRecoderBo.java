package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/3/3.
 * <p>
 * 告警记录bO
 */

public class WaitRecoderBo implements Serializable {


    /**
     * id : 45
     * remark : co2浓度太高
     * time : 2018-02-06 00:00:00
     */

    private int id;
    private String remark;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
