package com.ruoyi.system.domain.app;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.*;

/**
 * @program: data-ruoyi
 * @description: app -事件详情
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 16:57
 **/
public class appAction implements Serializable {

    /**行动名称 */
    private String actionName;
    /**行动唯一标识 */
    private String commonlyId;
    /**处理人 */
    private String handlerName;
    /**处理人id */
    private Long handlerUserId;
    /**处理内容 */
    private String  handlerContent;

    private Integer handleStatus;
    // 处理字段
    private List<appField> appFieldList;

    /**处理时间 */
    private String nowTime;

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public List<appField> getAppFieldList() {
        return appFieldList;
    }

    public void setAppFieldList(List<appField> appFieldList) {
        this.appFieldList = appFieldList;
    }

    public String getHandlerContent() {
        return handlerContent;
    }

    public void setHandlerContent(String handlerContent) {
        this.handlerContent = handlerContent;
    }



    public Long getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(Long handlerUserId) {
        this.handlerUserId = handlerUserId;
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

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }


}
