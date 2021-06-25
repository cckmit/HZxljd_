package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 事件处理记录
 * @author: Lijiajia8
 * @date: 2020/4/30 11:22
 * @since: jdk1.8
 */
public class EventProcessRecordDTO  implements Serializable {
    /** 传入的事件处理记录标识 */
    private String handlerRecordIndexCode;

    /** 事件处理人标识 */
    private String handlerIndexCode;

    /** 事件处理人 */
    private String handlerName;

    /** 事件处理人关联的区域标识 */
    private String regionIndexCode;

    /** 事件处理人关联的区域名称 */
    private String regionName;

    /** 事件处理人手机号 */
    private String handlerPhone;

    /** 处理人处置事件的状态（1审核超时，2处置超时，3超时处置，4已处理） */
    private Integer processStatus;

    /** 处理人处置事件的状态名称（1审核超时，2处置超时，3超时处置，4已处理） */
    private String processStatusName;

    /** 处理时间 */
    private String processTime;

    /** 处理结果 */
    private List<EventProcessResultDTO> processResult;

    private Integer extendInt1;

    private Integer extendInt2;

    private Integer extendInt3;

    private String extendStr1;

    private String extendStr2;

    private String extendStr3;

    private String extendJson;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHandlerRecordIndexCode() {
        return handlerRecordIndexCode;
    }

    public void setHandlerRecordIndexCode(String handlerRecordIndexCode) {
        this.handlerRecordIndexCode = handlerRecordIndexCode;
    }

    public String getHandlerIndexCode() {
        return handlerIndexCode;
    }

    public void setHandlerIndexCode(String handlerIndexCode) {
        this.handlerIndexCode = handlerIndexCode;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessStatusName() {
        return processStatusName;
    }

    public void setProcessStatusName(String processStatusName) {
        this.processStatusName = processStatusName;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public List<EventProcessResultDTO> getProcessResult() {
        return processResult;
    }

    public void setProcessResult(List<EventProcessResultDTO> processResult) {
        this.processResult = processResult;
    }

    public Integer getExtendInt1() {
        return extendInt1;
    }

    public void setExtendInt1(Integer extendInt1) {
        this.extendInt1 = extendInt1;
    }

    public Integer getExtendInt2() {
        return extendInt2;
    }

    public void setExtendInt2(Integer extendInt2) {
        this.extendInt2 = extendInt2;
    }

    public Integer getExtendInt3() {
        return extendInt3;
    }

    public void setExtendInt3(Integer extendInt3) {
        this.extendInt3 = extendInt3;
    }

    public String getExtendStr1() {
        return extendStr1;
    }

    public void setExtendStr1(String extendStr1) {
        this.extendStr1 = extendStr1;
    }

    public String getExtendStr2() {
        return extendStr2;
    }

    public void setExtendStr2(String extendStr2) {
        this.extendStr2 = extendStr2;
    }

    public String getExtendStr3() {
        return extendStr3;
    }

    public void setExtendStr3(String extendStr3) {
        this.extendStr3 = extendStr3;
    }

    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson;
    }
}
