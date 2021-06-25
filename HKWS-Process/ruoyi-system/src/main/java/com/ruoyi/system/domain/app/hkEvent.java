package com.ruoyi.system.domain.app;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 04:04
 **/
public class hkEvent implements Serializable {

    /**
     * 事件类型名称
     */
    private String eventTypeName;

    /**
     * 事件类型总数
     */
    private Integer eventCount;

    /**
     * 事件类型占比
     *
     * @return
     */
    private Float percentage;

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
