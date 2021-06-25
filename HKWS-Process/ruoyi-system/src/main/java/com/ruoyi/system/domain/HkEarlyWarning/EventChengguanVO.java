package com.ruoyi.system.domain.HkEarlyWarning;

import java.util.List;

public class EventChengguanVO {
    private String periodTime;
    private Integer percentage;
    private List<EventChenAccVO> list;

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

    public List<EventChenAccVO> getList() {
        return list;
    }

    public void setList(List<EventChenAccVO> list) {
        this.list = list;
    }

}
