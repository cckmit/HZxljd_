package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 当日告警统计VO
 */
public class EventTypeCountsVO {

    /**
     * 事件类型名称
     */
    private String eventTypeName;

    /**
     * 事件统计数
     */
    private String eventCount;

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventCount() {
        return eventCount;
    }

    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }
}
