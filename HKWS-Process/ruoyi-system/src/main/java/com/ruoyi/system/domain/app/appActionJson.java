package com.ruoyi.system.domain.app;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.*;

/**
 * @program: data-ruoyi
 * @description: 接受app返回的参数
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 21:14
 **/
public class appActionJson implements Serializable {
    /**行动名称 */
    private String actionName;
    /**行动唯一标识 */
    private String commonlyId;
    /**处理人id */
    private Long handlerUserId;
    /**事件id */
    private String eventId;
    /**处理结果 */
    private String handlerContent;
    /**处理人 */
    private String handlerName;
    /**事件类型*/
    private String eventType;
    /**事件处置标识**/
    private String handleStatus;

    private String closeResaon;

    /**当前处理时间 */
    private String nowTime;

    public String getCloseResaon() {
        return closeResaon;
    }

    public void setCloseResaon(String closeResaon) {
        this.closeResaon = closeResaon;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    private List<appField> appField;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getCommonlyId() {
        return commonlyId;
    }

    public void setCommonlyId(String commonlyId) {
        this.commonlyId = commonlyId;
    }

    public Long getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(Long handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getHandlerContent() {
        return handlerContent;
    }

    public void setHandlerContent(String handlerContent) {
        this.handlerContent = handlerContent;
    }

    public List<com.ruoyi.system.domain.app.appField> getAppField() {
        return appField;
    }

    public void setAppField(List<com.ruoyi.system.domain.app.appField> appField) {
        this.appField = appField;
    }
}
