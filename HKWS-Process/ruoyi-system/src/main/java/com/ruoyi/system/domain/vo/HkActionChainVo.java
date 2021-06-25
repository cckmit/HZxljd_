package com.ruoyi.system.domain.vo;

import java.util.List;
import java.util.Map;

/**
 * 行动链与后端接口交互vo
 */
public class HkActionChainVo {
    private String actionName;//行动链名称
    private String actionChainId;//行动链id
    private String ecNameType;//事件类别
    private String overTimeType;//超时时间类型
    private String overTimeNum;//超时时间
    private String actionRegion;//网格区域名称
    private String actionRegionCode;//网格区域代码
    private String actionRemark;//备注
    private List<Map<String,Object>> clrArray;//处理层级明细

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

    public String getOverTimeType() {
        return overTimeType;
    }

    public void setOverTimeType(String overTimeType) {
        this.overTimeType = overTimeType;
    }

    public String getOverTimeNum() {
        return overTimeNum;
    }

    public void setOverTimeNum(String overTimeNum) {
        this.overTimeNum = overTimeNum;
    }

    public String getActionRegion() {
        return actionRegion;
    }

    public void setActionRegion(String actionRegion) {
        this.actionRegion = actionRegion;
    }

    public String getActionRegionCode() {
        return actionRegionCode;
    }

    public void setActionRegionCode(String actionRegionCode) {
        this.actionRegionCode = actionRegionCode;
    }

    public String getActionRemark() {
        return actionRemark;
    }

    public void setActionRemark(String actionRemark) {
        this.actionRemark = actionRemark;
    }

    public List<Map<String, Object>> getClrArray() {
        return clrArray;
    }

    public void setClrArray(List<Map<String, Object>> clrArray) {
        this.clrArray = clrArray;
    }

    public String getActionChainId() {
        return actionChainId;
    }

    public void setActionChainId(String actionChainId) {
        this.actionChainId = actionChainId;
    }
}
