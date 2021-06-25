package com.ruoyi.system.domain.HkEarlyWarning;

import java.io.Serializable;
import java.util.Date;

/**
 * 一事一档 事件处置分析VO
 */
public class EventProcessAnalysisVO implements Serializable {

    /**事件类型名称**/
    private String eventAnalysisTypeName;

    /**事件类型编码**/
    private String eventAnalysisTypeCode;

    /**事件数量**/
    private Integer eventAnalysisTypeCount;

    /**流转数量（流转率根据此字段排序）**/
    private Integer transforCount;

    /**共治数量（共治率根据此字段排序）**/
    private Integer governanceCount;

    /**流转率**/
    private String transforRate;

    /**共治率**/
    private String governanceRate;

    public String getEventAnalysisTypeName() {
        return eventAnalysisTypeName;
    }

    public void setEventAnalysisTypeName(String eventAnalysisTypeName) {
        this.eventAnalysisTypeName = eventAnalysisTypeName;
    }

    public String getEventAnalysisTypeCode() {
        return eventAnalysisTypeCode;
    }

    public void setEventAnalysisTypeCode(String eventAnalysisTypeCode) {
        this.eventAnalysisTypeCode = eventAnalysisTypeCode;
    }

    public Integer getEventAnalysisTypeCount() {
        return eventAnalysisTypeCount;
    }

    public void setEventAnalysisTypeCount(Integer eventAnalysisTypeCount) {
        this.eventAnalysisTypeCount = eventAnalysisTypeCount;
    }

    public Integer getTransforCount() {
        return transforCount;
    }

    public void setTransforCount(Integer transforCount) {
        this.transforCount = transforCount;
    }

    public Integer getGovernanceCount() {
        return governanceCount;
    }

    public void setGovernanceCount(Integer governanceCount) {
        this.governanceCount = governanceCount;
    }

    public String getTransforRate() {
        return transforRate;
    }

    public void setTransforRate(String transforRate) {
        this.transforRate = transforRate;
    }

    public String getGovernanceRate() {
        return governanceRate;
    }

    public void setGovernanceRate(String governanceRate) {
        this.governanceRate = governanceRate;
    }
}
