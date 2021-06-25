package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.system.domain.Annnotation.CommonTimeFrameAnnotation;

import java.util.Date;

/**
 * 一事一档-事件趋势VO
 */
public class EventTrendVO {

    /**
     * 事件创建时间 当天 格式: 00:00-02:00 本周: 2021:01:01 本月 2021:01:01-2021:01:07
     **/
    private Date createTime;

    /**
     * 时间段
     */
    private String time;

    /**
     * 违规事件
     */
    private Integer eventCount;

    /**
     * 界面违规事件
     */
    private Integer shopEventCount;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getShopEventCount() {
        return shopEventCount;
    }

    public void setShopEventCount(Integer shopEventCount) {
        this.shopEventCount = shopEventCount;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
