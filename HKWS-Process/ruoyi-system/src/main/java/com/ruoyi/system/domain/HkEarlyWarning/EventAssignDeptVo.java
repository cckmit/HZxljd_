package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.system.domain.SysDept;

import java.io.Serializable;

public class EventAssignDeptVo extends SysDept implements Serializable {

    private String assignDepts;

    private String eventId;

    public String getAssignDepts() {
        return assignDepts;
    }

    public void setAssignDepts(String assignDepts) {
        this.assignDepts = assignDepts;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
