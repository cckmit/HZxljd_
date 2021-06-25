package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.XlPropertyEvent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业--考核扣分对象 xl_deduction_record
 *
 * @author ruoyi
 * @date 2021-06-19
 */
public class XlDeductionRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 事件id */
    @Excel(name = "事件id")
    private Long eventId;
    //事件
    private XlPropertyEvent xlPropertyEvent;

    //小区id
    private Long villageId;
    //物业id
    private Long propertyId;

    /** 扣分 */
    @Excel(name = "扣分")
    private String deductionNumber;

    /** 考核结果 */
    @Excel(name = "考核结果")
    private String assessmentResults;

    /**
     * 以下属性用于搜素
     */
    //事件来源
    private Integer eventSource;

    //事件处理人
    private String handler;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEventId(Long eventId)
    {
        this.eventId = eventId;
    }

    public Long getEventId()
    {
        return eventId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public XlPropertyEvent getXlPropertyEvent() {
        if(null == xlPropertyEvent){
            xlPropertyEvent = new XlPropertyEvent();
        }
        return xlPropertyEvent;
    }

    public void setXlPropertyEvent(XlPropertyEvent xlPropertyEvent) {
        this.xlPropertyEvent = xlPropertyEvent;
    }

    public void setDeductionNumber(String deductionNumber)
    {
        this.deductionNumber = deductionNumber;
    }

    public String getDeductionNumber()
    {
        return deductionNumber;
    }
    public void setAssessmentResults(String assessmentResults)
    {
        this.assessmentResults = assessmentResults;
    }

    public String getAssessmentResults()
    {
        return assessmentResults;
    }

    public Integer getEventSource() {
        return eventSource;
    }

    public void setEventSource(Integer eventSource) {
        this.eventSource = eventSource;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("eventId", getEventId())
                .append("villageId", getVillageId())
                .append("propertyId", getPropertyId())
                .append("deductionNumber", getDeductionNumber())
                .append("assessmentResults", getAssessmentResults())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}