package com.ruoyi.system.domain.property;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2021-06-11-11:49
 */
public class XlPropertyAndVillageVo implements Serializable {

    /** 事件id */
    private Long eventId;

    /** 小区id */
    @Excel(name = "小区id")
    private Integer villageId;

    /** 事件标题 */
    @Excel(name = "事件标题")
    private String eventTitle;

    /** 事件来源（1：智慧监测；2：意见反馈；3：报修维护；4：整改工程；5：巡更巡防） */
    @Excel(name = "事件来源", readConverterExp = "1=：智慧监测；2：意见反馈；3：报修维护；4：整改工程；5：巡更巡防")
    private Integer eventSource;

    /** 事件类型（1：消防通道占用；2：消控室人员离岗；3：高空抛物；4：非机动车违停；） */
    @Excel(name = "事件类型", readConverterExp = "1=：消防通道占用；2：消控室人员离岗；3：高空抛物；4：非机动车违停；")
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
    //小区名称
    private String name;
    //物业名称
    private String propertyName;

    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Integer getEventSource() {
        return eventSource;
    }

    public void setEventSource(Integer eventSource) {
        this.eventSource = eventSource;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporterPhone() {
        return reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportImage() {
        return reportImage;
    }

    public void setReportImage(String reportImage) {
        this.reportImage = reportImage;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Long handlerId) {
        this.handlerId = handlerId;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getHandleContent() {
        return handleContent;
    }

    public void setHandleContent(String handleContent) {
        this.handleContent = handleContent;
    }

    public String getHandleImage() {
        return handleImage;
    }

    public void setHandleImage(String handleImage) {
        this.handleImage = handleImage;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getFinishContent() {
        return finishContent;
    }

    public void setFinishContent(String finishContent) {
        this.finishContent = finishContent;
    }

    public String getFinishImage() {
        return finishImage;
    }

    public void setFinishImage(String finishImage) {
        this.finishImage = finishImage;
    }

    public Date getExpectedFinishTime() {
        return expectedFinishTime;
    }

    public void setExpectedFinishTime(Date expectedFinishTime) {
        this.expectedFinishTime = expectedFinishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
