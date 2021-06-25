package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一域一档 赋能流转
 */
public class RegionChangeVO {

    /**
     * 区域名称
     */
    private String eventChangeName;

    /**
     * 区域事件总数
     */
    private Integer eventChangeCount;

    public String getEventChangeName() {
        return eventChangeName;
    }

    public void setEventChangeName(String eventChangeName) {
        this.eventChangeName = eventChangeName;
    }

    public Integer getEventChangeCount() {
        return eventChangeCount;
    }

    public void setEventChangeCount(Integer eventChangeCount) {
        this.eventChangeCount = eventChangeCount;
    }
}
