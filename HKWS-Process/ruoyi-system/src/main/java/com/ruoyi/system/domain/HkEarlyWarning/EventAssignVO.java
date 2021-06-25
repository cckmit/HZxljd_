package com.ruoyi.system.domain.HkEarlyWarning;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件交办 接受对象
 */
public class EventAssignVO implements Serializable {

    /**事件ID**/
    private String eventId;
    /**交办部门**/
    private String deptIds;
    /**操作人**/
    private Long assignOperator;
    /**交办原因**/
    private String assignReason;

    public Long getAssignOperator() {
        return assignOperator;
    }

    public void setAssignOperator(Long assignOperator) {
        this.assignOperator = assignOperator;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public String getAssignReason() {
        return assignReason;
    }

    public void setAssignReason(String assignReason) {
        this.assignReason = assignReason;
    }
}
