package com.myp.meiyuan.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2018/2/28.
 * <p>
 * 大棚bean
 */

public class GroupBO implements Serializable {


    /**
     * groupId : 51
     * groupName : 默认分组
     */

    private int groupId;
    private String groupName;
    private int groupType;

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

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
}
