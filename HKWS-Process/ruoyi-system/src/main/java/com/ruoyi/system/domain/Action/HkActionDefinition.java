package com.ruoyi.system.domain.Action;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-12-09-23:10
 * 行动链定义表
 */
public class HkActionDefinition extends BaseEntity {
    /**
     * 自增id
     */
    private Integer id;
    /**
     *行动链ID
     */
    private String actionChainId;
    /**
     *处理人id
     */
    private String handlerUserId;
    /**
     *标准动作
     */
    private String actionStandardId;
    /**
     *处理顺序
     */
    private String handlerOrder;
    /**
     *创建人
     */
    private String createUser;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *修改人
     */
    private String updateUser;
    /**
     *修改时间
     */
    private Date updateTime;
    /**
     * 是否共治
     */
    private Integer isGovernance;

    /**
     * 职能id
     */
    private Integer handlerPostId;

    public Integer getIsGovernance() {
        return isGovernance;
    }

    public void setIsGovernance(Integer isGovernance) {
        this.isGovernance = isGovernance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionChainId() {
        return actionChainId;
    }

    public void setActionChainId(String actionChainId) {
        this.actionChainId = actionChainId;
    }

    public String getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(String handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public String getActionStandardId() {
        return actionStandardId;
    }

    public void setActionStandardId(String actionStandardId) {
        this.actionStandardId = actionStandardId;
    }

    public String getHandlerOrder() {
        return handlerOrder;
    }

    public void setHandlerOrder(String handlerOrder) {
        this.handlerOrder = handlerOrder;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getHandlerPostId() {
        return handlerPostId;
    }

    public void setHandlerPostId(Integer handlerPostId) {
        this.handlerPostId = handlerPostId;
    }

    @Override
    public String toString() {
        return "HkActionDefinition{" +
                "id=" + id +
                ", actionChainId='" + actionChainId + '\'' +
                ", handlerUserId='" + handlerUserId + '\'' +
                ", actionStandardId='" + actionStandardId + '\'' +
                ", handlerOrder='" + handlerOrder + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", isGovernance=" + isGovernance +
                ", handlerPostId=" + handlerPostId +
                '}';
    }
}
