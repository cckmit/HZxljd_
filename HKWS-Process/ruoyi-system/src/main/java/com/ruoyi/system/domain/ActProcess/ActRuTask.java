package com.ruoyi.system.domain.ActProcess;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-11-21-0:43
 * ACT_RU_TASK(运行时任务数据表)
 */
public class ActRuTask extends BaseEntity {

    private String id;

    private Integer rev;

    private String executionId;

    private String procInstId;

    private String procDefId;

    private String name;

    private String parentTaskId;

    private String descRiption;

    private String taskDefKey;

    private String owner;

    private String assignee;

    private String delegation;

    private Integer priority;

    private Date createTime;

    private Date dueDate;

    private String category;

    private Integer suspensionState;

    private String tenantId;

    private String fromKey;

    private Date claimTime;

    public ActRuTask() {
    }

    public ActRuTask(String id, Integer rev, String executionId, String procInstId, String procDefId, String name, String parentTaskId, String descRiption, String taskDefKey, String owner, String assignee, String delegation, Integer priority, Date createTime, Date dueDate, String category, Integer suspensionState, String tenantId, String fromKey, Date claimTime) {
        this.id = id;
        this.rev = rev;
        this.executionId = executionId;
        this.procInstId = procInstId;
        this.procDefId = procDefId;
        this.name = name;
        this.parentTaskId = parentTaskId;
        this.descRiption = descRiption;
        this.taskDefKey = taskDefKey;
        this.owner = owner;
        this.assignee = assignee;
        this.delegation = delegation;
        this.priority = priority;
        this.createTime = createTime;
        this.dueDate = dueDate;
        this.category = category;
        this.suspensionState = suspensionState;
        this.tenantId = tenantId;
        this.fromKey = fromKey;
        this.claimTime = claimTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getDescRiption() {
        return descRiption;
    }

    public void setDescRiption(String descRiption) {
        this.descRiption = descRiption;
    }

    public String getTaskDefKey() {
        return taskDefKey;
    }

    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getFromKey() {
        return fromKey;
    }

    public void setFromKey(String fromKey) {
        this.fromKey = fromKey;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }
}
