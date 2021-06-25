package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxinxin
 * 接受事件标签数据
 */
public class HkEventLmanageVo implements Serializable {

    private Long eventId;

    List<Map<String,Object>> lmList;

    private String createUser;

    private String riskLevel;

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public List<Map<String, Object>> getLmList() {
        return lmList;
    }

    public void setLmList(List<Map<String, Object>> lmList) {
        this.lmList = lmList;
    }
}
