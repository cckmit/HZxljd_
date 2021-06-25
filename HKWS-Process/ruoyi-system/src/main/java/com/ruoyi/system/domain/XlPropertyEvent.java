package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业--事件信息对象 xl_property_event
 *
 * @author ruoyi
 * @date 2021-06-02
 */
public class XlPropertyEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件id */
    private Long eventId;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    /**
     * 物业id
     */
    private Long propertyId;

    /** 事件标题 */
    @Excel(name = "事件标题")
    private String eventTitle;

    /** 事件来源（1：智慧监测；2：意见反馈；3：报修维护；4：整改工程；5：巡更巡防） */
    @Excel(name = "事件来源", readConverterExp = "1=：智慧监测；2：意见反馈；3：报修维护；4：整改工程；5：巡更巡防")
    private Integer eventSource;

    /**
     * 事件类型
     * （101：消防通道占用；102：消控室人员离岗；103：高空抛物；104：非机动车违停；）
     * （201：公共维修；202：房屋维修；203：水电维修；204：家电维修；205：其他维修）
     * （301：安防；302：消防；303：清洁卫生；304：绿化管理；305：房屋建筑维护；306：公共设施维护；307：车库车辆管理；308：秩序管理）
     * */
    @Excel(name = "事件类型", readConverterExp = "")
    private Integer eventType;

    /** 事件状态（1：待处理；2：处理中；3：已处理） */
    @Excel(name = "事件状态", readConverterExp = "1=：待处理；2：处理中；3：已处理")
    private Integer eventStatus;

    /** 事件发生位置 */
    @Excel(name = "事件发生位置")
    private String eventAddress;

    /** 事件上报人 */
    @Excel(name = "事件上报人")
    private String reporter;

    /** 事件上报人手机号码 */
    @Excel(name = "事件上报人手机号码")
    private String reporterPhone;

    /** 事件上报时间 */
    @Excel(name = "事件上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportTime;

    /** 事件上报内容 */
    @Excel(name = "事件上报内容")
    private String reportContent;

    /** 事件上报图片 */
    @Excel(name = "事件上报图片")
    private String reportImage;

    /** 事件处理人 */
    @Excel(name = "事件处理人")
    private String handler;

    /** 事件处理人手机号码 */
    @Excel(name = "事件处理人手机号码")
    private String handlerPhone;

    /** 事件处理人id */
    @Excel(name = "事件处理人id")
    private Long handlerId;

    /** 事件处理时间 */
    @Excel(name = "事件处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date handleTime;

    /** 事件处理内容 */
    @Excel(name = "事件处理内容")
    private String handleContent;

    /** 事件处理图片 */
    @Excel(name = "事件处理图片")
    private String handleImage;

    /** 事件完成时间 */
    @Excel(name = "事件完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    /** 事件完成内容 */
    @Excel(name = "事件完成内容")
    private String finishContent;

    /** 事件完成图片 */
    @Excel(name = "事件完成图片")
    private String finishImage;

    /** 预计完成时间 */
    @Excel(name = "预计完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectedFinishTime;

    public void setEventId(Long eventId)
    {
        this.eventId = eventId;
    }

    public Long getEventId()
    {
        return eventId;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public void setEventTitle(String eventTitle)
    {
        this.eventTitle = eventTitle;
    }

    public String getEventTitle()
    {
        return eventTitle;
    }
    public void setEventSource(Integer eventSource)
    {
        this.eventSource = eventSource;
    }

    public Integer getEventSource()
    {
        return eventSource;
    }
    public void setEventType(Integer eventType)
    {
        this.eventType = eventType;
    }

    public Integer getEventType()
    {
        return eventType;
    }
    public void setEventStatus(Integer eventStatus)
    {
        this.eventStatus = eventStatus;
    }

    public Integer getEventStatus()
    {
        return eventStatus;
    }
    public void setEventAddress(String eventAddress)
    {
        this.eventAddress = eventAddress;
    }

    public String getEventAddress()
    {
        return eventAddress;
    }
    public void setReporter(String reporter)
    {
        this.reporter = reporter;
    }

    public String getReporter()
    {
        return reporter;
    }
    public void setReporterPhone(String reporterPhone)
    {
        this.reporterPhone = reporterPhone;
    }

    public String getReporterPhone()
    {
        return reporterPhone;
    }
    public void setReportTime(Date reportTime)
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime()
    {
        return reportTime;
    }
    public void setReportContent(String reportContent)
    {
        this.reportContent = reportContent;
    }

    public String getReportContent()
    {
        return reportContent;
    }
    public void setReportImage(String reportImage)
    {
        this.reportImage = reportImage;
    }

    public String getReportImage()
    {
        return reportImage;
    }
    public void setHandler(String handler)
    {
        this.handler = handler;
    }

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    public String getHandler()
    {
        return handler;
    }
    public void setHandlerId(Long handlerId)
    {
        this.handlerId = handlerId;
    }

    public Long getHandlerId()
    {
        return handlerId;
    }
    public void setHandleTime(Date handleTime)
    {
        this.handleTime = handleTime;
    }

    public Date getHandleTime()
    {
        return handleTime;
    }
    public void setHandleContent(String handleContent)
    {
        this.handleContent = handleContent;
    }

    public String getHandleContent()
    {
        return handleContent;
    }
    public void setHandleImage(String handleImage)
    {
        this.handleImage = handleImage;
    }

    public String getHandleImage()
    {
        return handleImage;
    }
    public void setFinishTime(Date finishTime)
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime()
    {
        return finishTime;
    }
    public void setFinishContent(String finishContent)
    {
        this.finishContent = finishContent;
    }

    public String getFinishContent()
    {
        return finishContent;
    }
    public void setFinishImage(String finishImage)
    {
        this.finishImage = finishImage;
    }

    public String getFinishImage()
    {
        return finishImage;
    }
    public void setExpectedFinishTime(Date expectedFinishTime)
    {
        this.expectedFinishTime = expectedFinishTime;
    }

    public Date getExpectedFinishTime()
    {
        return expectedFinishTime;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("eventId", getEventId())
                .append("villageId", getVillageId())
                .append("propertyId", getPropertyId())
                .append("eventTitle", getEventTitle())
                .append("eventSource", getEventSource())
                .append("eventType", getEventType())
                .append("eventStatus", getEventStatus())
                .append("eventAddress", getEventAddress())
                .append("reporter", getReporter())
                .append("reporterPhone", getReporterPhone())
                .append("reportTime", getReportTime())
                .append("reportContent", getReportContent())
                .append("reportImage", getReportImage())
                .append("handler", getHandler())
                .append("handlerPhone", getHandlerPhone())
                .append("handlerId", getHandlerId())
                .append("handleTime", getHandleTime())
                .append("handleContent", getHandleContent())
                .append("handleImage", getHandleImage())
                .append("finishTime", getFinishTime())
                .append("finishContent", getFinishContent())
                .append("finishImage", getFinishImage())
                .append("expectedFinishTime", getExpectedFinishTime())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}