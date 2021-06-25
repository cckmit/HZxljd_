package com.ruoyi.system.domain.app;

import java.io.Serializable;
import java.util.List;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-12-14 19:23
 **/
public class appActionNow implements Serializable {

    /**行动名称 */
    private String actionName;
    /**行动唯一标识 */
    private String commonlyId;
    /**处理人 */
    private String handlerName;
    /**处理人id */
    private Long handlerUserId;
    /**行动链是否共治*/
    private Integer isGovernance;

    // 处理字段
    private List<appField> appField;

    public Integer getIsGovernance() {
        return isGovernance;
    }

    public void setIsGovernance(Integer isGovernance) {
        this.isGovernance = isGovernance;
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

    public Long getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(Long handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public List<com.ruoyi.system.domain.app.appField> getAppField() {
        return appField;
    }

    public void setAppField(List<com.ruoyi.system.domain.app.appField> appField) {
        this.appField = appField;
    }
}
