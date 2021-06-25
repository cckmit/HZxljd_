package com.ruoyi.system.domain.HkEarlyWarning;

import java.io.Serializable;
import java.util.Date;

/**
 * 一事一档 事件分析VO
 */
public class EventAnalysisVO implements Serializable {


    /**
     * 事件创建事件
     */
    private Date createTime;
    /**
     * 完成时间
     */
    private Date updateTime;
    /**
     * 事件分析类型名称
     */
    private String eventAnalysisTypeName;
    /**
     * 事件分析类型编号
     */
    private String eventAnalysisTypeCode;
    /**
     * 事件分析类型数量
     */
    private Integer eventAnalysisTypeCount;
    /**
     * 事件分析类型总时长
     */
    private Integer eventAnalysisSumTime;
    /**
     * 事件分析类型平均时长
     */
    private Integer eventAnalysisAvgTime;

    /**流转率**/
    private String transforRate;

    /**共治率**/
    private String governanceRate;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEventAnalysisTypeName() {
        return eventAnalysisTypeName;
    }

    public void setEventAnalysisTypeName(String eventAnalysisTypeName) {
        this.eventAnalysisTypeName = eventAnalysisTypeName;
    }

    public Integer getEventAnalysisTypeCount() {
        return eventAnalysisTypeCount;
    }

    public void setEventAnalysisTypeCount(Integer eventAnalysisTypeCount) {
        this.eventAnalysisTypeCount = eventAnalysisTypeCount;
    }

    public String getEventAnalysisTypeCode() {
        return eventAnalysisTypeCode;
    }

    public void setEventAnalysisTypeCode(String eventAnalysisTypeCode) {
        this.eventAnalysisTypeCode = eventAnalysisTypeCode;
    }

    public Integer getEventAnalysisSumTime() {
        return eventAnalysisSumTime;
    }

    public void setEventAnalysisSumTime(Integer eventAnalysisSumTime) {
        this.eventAnalysisSumTime = eventAnalysisSumTime;
    }

    public Integer getEventAnalysisAvgTime() {
        return eventAnalysisAvgTime;
    }

    public void setEventAnalysisAvgTime(Integer eventAnalysisAvgTime) {
        this.eventAnalysisAvgTime = eventAnalysisAvgTime;
    }
}
