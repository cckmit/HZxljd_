package com.ruoyi.system.domain.honey;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Dell
 * 类名称：
 * 类描述：事件信息处理流程
 * `xl_property_event`---`xl_appeal_record`
 * @date 2021-06-03 11:38
 */
public class PropertyEventVo extends BaseEntity {
    /** 事件id */
    private Long eventId;
    /** 小区id */
    @Excel(name = "小区id")
    private Integer villageId;
    /** 小区名称 */
    @Excel(name = "小区名称")
    private String name;
    /** 物业名称 */
    @Excel(name = "物业名称")
    private String propertyName;
    /** 事件来源（1：智慧监测；2：意见反馈；3：报修维护；4：整改工程；5巡更巡防） */
    @Excel(name = "事件来源", readConverterExp = "1=：智慧监测；2：意见反馈；3：报修维护；4：整改工程；5巡更巡防")
    private Integer eventSource;
    /** 事件类型（1：消防通道占用；2：消控室人员离岗；3：高空抛物；4：非机动车违停；） */
    @Excel(name = "事件类型", readConverterExp = "1=：消防通道占用；2：消控室人员离岗；3：高空抛物；4：非机动车违停；")
    private Integer eventType;
    /**
     * `event_title` AS '事件标题'
     */
    private String eventTitle;
    /**
     * `repairs_type` AS '报修类型'
     */
    private String repairsType;
    /**
     * `event_status` AS '事件状态'
     */
    private Integer eventStatus;
    /**
     * `reporter` AS '事件上报人',
     */
    private String reporter;
    /**
     * `reporter_phone` AS '事件上报人电话'
     */
    private String reporterPhone;
    /**
     * `report_Content` AS '事件上报内容'
     */
    private String reportContent;
    /**
     * `report_time` AS '事件上报时间'
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportTime;
    /**
     * `report_image` AS '事件上报图片'
     */
    private String reportImage;
    /**
     *  `handler` AS '事件处理人'
     */
    private String handler;
    /**
     *  `handler_id` AS '事件处理人id，需查出处理人电话'
     */
    private String handlerId;
    /**
     *  事件处理人电话
     */
    private String handlerPhone;
    /**
     * `handle_time` AS '事件处理时间'
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date handleTime;
    /**
     * `handle_content` AS '事件处理内容'
     */
    private String handleContent;
    /**
     * `handle_image` AS '事件处理图片'
     */
    private String handleImage;
    /**
     * `finish_time` AS '事件完成时间'
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishTime;
    /**
     * `finish_content` AS '事件完成内容'
     */
    private String finishContent;

    /**
     * `finish_content` AS '事件完成内容'
     */
    private Date expectedFinishTime;

    /**
     * `finish_image` AS '事件完成图片'
     */
    private String finishImage;

    /**
     * `appeal_person` AS '居民申诉人'
     */
    private String appealPerson;
    /**
     * `appeal_time` AS '居民申诉时间'
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appealTime;
    /**
     * `appeal_content` AS '居民申诉内容'
     */
    private String appealContent;
    /**
     * `appeal_image` AS '居民申诉图片'
     */
    private String appealImage;
    /**
     * `appeal_property` AS '申诉物业'
     */
    private String appealProperty;
    /**
     * `appeal_property_time` AS '物业申诉时间'
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appealPropertyTime;
    /**
     * `appeal_property_content` AS '物业申诉内容'
     */
    private String appealPropertyContent;
    /**
     * `appeal_property_image` AS '物业申诉图片'
     */
    private String appealPropertyImage;
    /**
     * `appeal_result` AS '申诉结果'
     */
    private String appealResult;
    /**
     * `appeal_result_time` AS '申述结果时间'
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appealResultTime;
    /**
     * 事件发生位置
     */
    private String eventAddress;
    /** 设备序列号 */
    @Excel(name = "设备序列号")
    private Long equipmentSerialNumber;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    public Long getEquipmentSerialNumber() {
        return equipmentSerialNumber;
    }

    public void setEquipmentSerialNumber(Long equipmentSerialNumber) {
        this.equipmentSerialNumber = equipmentSerialNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
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

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getRepairsType() {
        return repairsType;
    }

    public void setRepairsType(String repairsType) {
        this.repairsType = repairsType;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
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

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
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

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
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

    public Date getExpectedFinishTime() {
        return expectedFinishTime;
    }

    public void setExpectedFinishTime(Date expectedFinishTime) {
        this.expectedFinishTime = expectedFinishTime;
    }

    public String getFinishImage() {
        return finishImage;
    }

    public void setFinishImage(String finishImage) {
        this.finishImage = finishImage;
    }

    public String getAppealPerson() {
        return appealPerson;
    }

    public void setAppealPerson(String appealPerson) {
        this.appealPerson = appealPerson;
    }

    public Date getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(Date appealTime) {
        this.appealTime = appealTime;
    }

    public String getAppealContent() {
        return appealContent;
    }

    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent;
    }

    public String getAppealImage() {
        return appealImage;
    }

    public void setAppealImage(String appealImage) {
        this.appealImage = appealImage;
    }

    public String getAppealProperty() {
        return appealProperty;
    }

    public void setAppealProperty(String appealProperty) {
        this.appealProperty = appealProperty;
    }

    public Date getAppealPropertyTime() {
        return appealPropertyTime;
    }

    public void setAppealPropertyTime(Date appealPropertyTime) {
        this.appealPropertyTime = appealPropertyTime;
    }

    public String getAppealPropertyContent() {
        return appealPropertyContent;
    }

    public void setAppealPropertyContent(String appealPropertyContent) {
        this.appealPropertyContent = appealPropertyContent;
    }

    public String getAppealPropertyImage() {
        return appealPropertyImage;
    }

    public void setAppealPropertyImage(String appealPropertyImage) {
        this.appealPropertyImage = appealPropertyImage;
    }

    public String getAppealResult() {
        return appealResult;
    }

    public void setAppealResult(String appealResult) {
        this.appealResult = appealResult;
    }

    public Date getAppealResultTime() {
        return appealResultTime;
    }

    public void setAppealResultTime(Date appealResultTime) {
        this.appealResultTime = appealResultTime;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    @Override
    public String toString() {
        return "PropertyEventVo{" +
                "eventId=" + eventId +
                ", villageId=" + villageId +
                ", name='" + name + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", eventSource=" + eventSource +
                ", eventType=" + eventType +
                ", eventTitle='" + eventTitle + '\'' +
                ", repairsType='" + repairsType + '\'' +
                ", eventStatus=" + eventStatus +
                ", reporter='" + reporter + '\'' +
                ", reporterPhone='" + reporterPhone + '\'' +
                ", reportContent='" + reportContent + '\'' +
                ", reportTime=" + reportTime +
                ", reportImage='" + reportImage + '\'' +
                ", handler='" + handler + '\'' +
                ", handlerId='" + handlerId + '\'' +
                ", handlerPhone='" + handlerPhone + '\'' +
                ", handleTime=" + handleTime +
                ", handleContent='" + handleContent + '\'' +
                ", handleImage='" + handleImage + '\'' +
                ", finishTime=" + finishTime +
                ", finishContent='" + finishContent + '\'' +
                ", expectedFinishTime=" + expectedFinishTime +
                ", finishImage='" + finishImage + '\'' +
                ", appealPerson='" + appealPerson + '\'' +
                ", appealTime=" + appealTime +
                ", appealContent='" + appealContent + '\'' +
                ", appealImage='" + appealImage + '\'' +
                ", appealProperty='" + appealProperty + '\'' +
                ", appealPropertyTime=" + appealPropertyTime +
                ", appealPropertyContent='" + appealPropertyContent + '\'' +
                ", appealPropertyImage='" + appealPropertyImage + '\'' +
                ", appealResult='" + appealResult + '\'' +
                ", appealResultTime=" + appealResultTime +
                ", eventAddress='" + eventAddress + '\'' +
                '}';
    }
}
