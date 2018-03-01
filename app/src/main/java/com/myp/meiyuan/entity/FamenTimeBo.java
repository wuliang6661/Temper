package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/2/28.
 * <p>
 * 阀门定时器
 */

public class FamenTimeBo implements Serializable {


    private String startTime;

    private String endTime;

    private String kaidu;

    private boolean checked;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKaidu() {
        return kaidu;
    }

    public void setKaidu(String kaidu) {
        this.kaidu = kaidu;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
