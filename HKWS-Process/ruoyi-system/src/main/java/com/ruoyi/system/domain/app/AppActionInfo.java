package com.ruoyi.system.domain.app;

import java.io.Serializable;
import java.util.List;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-12-14 19:23
 **/
public class AppActionInfo implements Serializable {

    /**行动名称 */
    private String actionName;
    /**行动唯一标识 */
    private String commonlyId;
    /**处理人 */
    private String handlerName;
    /**处理人id */
    private Long handlerUserId;

    // 处理字段
    private String appField;

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

    public Long getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(Long handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public String getAppField() {
        return appField;
    }

    public void setAppField(String appField) {
        this.appField = appField;
    }
}
