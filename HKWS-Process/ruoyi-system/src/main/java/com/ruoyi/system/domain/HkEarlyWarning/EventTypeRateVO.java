package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 稠城云图-社区报表-告警数周环比5
 */
public class EventTypeRateVO {

    /**
     * 事件告警数
     */
    private Integer eventTypeCount;

    /**
     * 事件发生街道名
     */
    private String eventTypeName;

    /**
     * 周环比例
     */
    private Double eventRate;

    public Integer getEventTypeCount() {
        return eventTypeCount;
    }

    public void setEventTypeCount(Integer eventTypeCount) {
        this.eventTypeCount = eventTypeCount;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public Double getEventRate() {
        return eventRate;
    }

    public void setEventRate(Double eventRate) {
        this.eventRate = eventRate;
    }
}
