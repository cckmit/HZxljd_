package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一事一档-赋能流转
 * @author zjf
 */
public class EventChangeVO {

    /**
     * 流转分类名称
     */
    private String name;

    /**
     * 事件状态
     */
    private String alterStatus;

    /**
     * 流转分类总数
     */
    private Integer eventChangeCount;

    /**
     * 流转分类值
     */
    private Double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAlterStatus() {
        return alterStatus;
    }

    public void setAlterStatus(String alterStatus) {
        this.alterStatus = alterStatus;
    }

    public Integer getEventChangeCount() {
        return eventChangeCount;
    }

    public void setEventChangeCount(Integer eventChangeCount) {
        this.eventChangeCount = eventChangeCount;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
