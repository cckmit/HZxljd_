package com.ruoyi.system.domain.ding;

import java.io.Serializable;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain.ding
 * @ClassName: DingEventTypeCount
 * @Author: guohailong
 * @Description: 浙政钉-事件类型和数量对象
 * @Date: 2021/3/12 1:23
 * @Version: 1.0
 */
public class DingEventTypeCount implements Serializable {

    /**
     * 事件类型名称
     */
    private String eventTypeName;

    /**
     * 事件类型总数
     */
    private Integer eventCount;

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
}
