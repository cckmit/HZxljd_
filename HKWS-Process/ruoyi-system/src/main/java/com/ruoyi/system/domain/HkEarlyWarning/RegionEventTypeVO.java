package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一域一档-类型统计VO
 */
public class RegionEventTypeVO {

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域事件数
     */
    private Integer value;

    /**
     * 事件百分比
     */
    private String eventRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getEventRate() {
        return eventRate;
    }

    public void setEventRate(String eventRate) {
        this.eventRate = eventRate;
    }
}
