package com.xxl.job.admin.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public class XxlJobLogChild {

    private int id;
    private int prentCount;        // 父任务执行数量
    private int childJobId;   //任务ID
    private long updateTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }


    public int getChildJobId() {
        return childJobId;
    }

    public void setChildJobId(int childJobId) {
        this.childJobId = childJobId;
    }

    public int getPrentCount() {
        return prentCount;
    }

    public void setPrentCount(int prentCount) {
        this.prentCount = prentCount;
    }
}
