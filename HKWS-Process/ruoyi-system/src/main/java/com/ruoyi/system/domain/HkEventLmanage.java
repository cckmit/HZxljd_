package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2020-11-11-19:27
 * 标签表和事件表 关联表
 */
public class HkEventLmanage implements Serializable {

    /**
     * 自增id
     */
    private Long id;
    /**
     * 事件表id
     */
    private Long eventId;
    /**
     * 标签表id
     */
    private Long lmId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getLmId() {
        return lmId;
    }

    public void setLmId(Long lmId) {
        this.lmId = lmId;
    }

    public HkEventLmanage() {
    }

    public HkEventLmanage(Long id, Long eventId, Long lmId) {
        this.id = id;
        this.eventId = eventId;
        this.lmId = lmId;
    }
}
