package com.ruoyi.system.domain.Action;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-12-09-23:14
 * 行动流程表
 */
public class HkActionProcess extends BaseEntity {
    /**
     * 自增id
     */
    private Integer id;
    /**
     *行动链ID
     */
    private String actionChainId;
    /**
     *事件ID
     */
    private String eventId;
    /**
     * 职位ID
     */
    private Integer postId;
    /**
     *处理人ID
     */
    private String handlerUserId;
    /**
     *标准动作ID
     */
    private String actionStandardId;
    /**
     *处理顺序
     */
    private String handlerOrder;
    /**
     *是否完成
     */
    private Integer isComplete;
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

    /**处理总数 */
    private int PendingCount;

    /**登录名称 */
    private String userName;

    /**事件类型名称 */
    private String eventTypeName;

    /**事件类型总数 */
    private Integer eventCount;

    /** */
    private Long userId;

    /**
     * 退回标识
     */
    private Integer returnFlag;

    /**
     * 是否共治
     */
    private Integer isGovernance;

    public Integer getPostId() { return postId; }

    public void setPostId(Integer postId) { this.postId = postId; }

    public Integer getIsGovernance() {
        return isGovernance;
    }

    public void setIsGovernance(Integer isGovernance) {
        this.isGovernance = isGovernance;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
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

    public int getPendingCount() {
        return PendingCount;
    }

    public void setPendingCount(int pendingCount) {
        PendingCount = pendingCount;
    }

    public Integer getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(Integer returnFlag) {
        this.returnFlag = returnFlag;
    }
}
