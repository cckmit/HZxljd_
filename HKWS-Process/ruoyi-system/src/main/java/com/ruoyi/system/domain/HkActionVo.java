package com.ruoyi.system.domain;

import java.io.Serializable;

public class HkActionVo implements Serializable {

    //行动链id
    private String actionChainId;

    /**事件名称**/
    private String actionName;
    /**事件类别**/
    private String ecNameType;
    /**标准动作名称**/
    private String actionStandard;
    /**网格编号**/
    private String actionRegionCode;
    /**网格名称**/
    private String actionRegion;
    /**网格员名称**/
    private String userName;
    /**分钟/小时**/
    private String expectedEvents;
    /**超时试驾**/
    private String expectedEvents1;
    /**是否共治**/
    private Integer isGovernance;
    /**备注**/
    private String actionRemark;

    private String index;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getEcNameType() {
        return ecNameType;
    }

    public void setEcNameType(String ecNameType) {
        this.ecNameType = ecNameType;
    }

    public String getActionStandard() {
        return actionStandard;
    }

    public void setActionStandard(String actionStandard) {
        this.actionStandard = actionStandard;
    }

    public String getActionRegionCode() {
        return actionRegionCode;
    }

    public void setActionRegionCode(String actionRegionCode) {
        this.actionRegionCode = actionRegionCode;
    }

    public String getActionRegion() {
        return actionRegion;
    }

    public void setActionRegion(String actionRegion) {
        this.actionRegion = actionRegion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExpectedEvents() {
        return expectedEvents;
    }

    public void setExpectedEvents(String expectedEvents) {
        this.expectedEvents = expectedEvents;
    }

    public String getExpectedEvents1() {
        return expectedEvents1;
    }

    public void setExpectedEvents1(String expectedEvents1) {
        this.expectedEvents1 = expectedEvents1;
    }

    public Integer getIsGovernance() {
        return isGovernance;
    }

    public void setIsGovernance(Integer isGovernance) {
        this.isGovernance = isGovernance;
    }

    public String getActionRemark() {
        return actionRemark;
    }

    public void setActionRemark(String actionRemark) {
        this.actionRemark = actionRemark;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getActionChainId() {
        return actionChainId;
    }

    public void setActionChainId(String actionChainId) {
        this.actionChainId = actionChainId;
    }
}
