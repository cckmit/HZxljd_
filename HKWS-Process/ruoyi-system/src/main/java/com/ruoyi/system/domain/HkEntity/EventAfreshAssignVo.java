package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;

public class EventAfreshAssignVo implements Serializable {

    private String procdefType;//事件

    private String eventId;//事件id

    private String beforeHandlerUserId;//改派前的处理人

    private Integer handlerOrder;//当前处理人排序

    private String afterHandlerUserId;//改派后的处理人

    private String operator;//操作员

    /**是否强制指派（1是）**/
    private String assignType;

    public String getProcdefType() {
        return procdefType;
    }

    public void setProcdefType(String procdefType) {
        this.procdefType = procdefType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getHandlerOrder() {
        return handlerOrder;
    }

    public void setHandlerOrder(Integer handlerOrder) {
        this.handlerOrder = handlerOrder;
    }

    public String getBeforeHandlerUserId() {
        return beforeHandlerUserId;
    }

    public void setBeforeHandlerUserId(String beforeHandlerUserId) {
        this.beforeHandlerUserId = beforeHandlerUserId;
    }

    public String getAfterHandlerUserId() {
        return afterHandlerUserId;
    }

    public void setAfterHandlerUserId(String afterHandlerUserId) {
        this.afterHandlerUserId = afterHandlerUserId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }
}
