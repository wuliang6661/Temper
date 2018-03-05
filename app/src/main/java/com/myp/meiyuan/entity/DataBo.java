package com.myp.meiyuan.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2018/3/5.
 */

public class DataBo implements Serializable{

    private List<MonitorBo> data;

    private String max;

    private String min;


    public List<MonitorBo> getData() {
        return data;
    }

    public void setData(List<MonitorBo> data) {
        this.data = data;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
