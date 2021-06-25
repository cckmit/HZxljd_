package com.ruoyi.system.domain.ActProcess;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-11-21-0:22
 * ACT_HI_TASKINST 历史任务流程实例信息
 */
public class ActHiTaskinst extends BaseEntity {
    /**
     *主键 ID
     */
    private String id;
    /**
     *
     * 流程定义 ID
     */
    private String procDefId;
    /**
     *节点定义 ID
     */
    private String taskDefKey;
    /**
     *流程实例 ID
     */
    private String procInstId;
    /**
     *执行实例 ID
     */
    private String executionId;
    /**
     *名称
     */
    private String name;
    /**
     *父节点实例 ID
     */
    private String parentTaskId;
    /**
     *描述
     */
    private String description;
    /**
     *签收人（默认为空，只有在委托时才有值）
     */
    private String owner;
    /**
     *签收人或被委托
     */
    private String assignee;
    /**
     *开始时间
     */
    private Date startTime;
    /**
     *提醒时间
     */
    private Date claimTime;
    /**
     *结束时间
     */
    private Date endTime;
    /**
     *耗时
     */
    private Integer duration;
    /**
     *删除原因
     */
    private String deleteReason;
    /**
     *优先级别
     */
    private Integer priority;
    /**
     *过期时间，表明任务应在多长时间内完成
     */
    private Date dueDate;
    /**
     *desinger 节点定义的
     *
     * form_key 属性
     */
    private String formKey;

    private String category;

    private String tenantId;


    public ActHiTaskinst() {
    }

    public ActHiTaskinst(String id, String procDefId, String taskDefKey, String procInstId, String executionId, String name, String parentTaskId, String description, String owner, String assignee, Date startTime, Date claimTime, Date endTime, Integer duration, String deleteReason, Integer priority, Date dueDate, String formKey, String category, String tenantId) {
        this.id = id;
        this.procDefId = procDefId;
        this.taskDefKey = taskDefKey;
        this.procInstId = procInstId;
        this.executionId = executionId;
        this.name = name;
        this.parentTaskId = parentTaskId;
        this.description = description;
        this.owner = owner;
        this.assignee = assignee;
        this.startTime = startTime;
        this.claimTime = claimTime;
        this.endTime = endTime;
        this.duration = duration;
        this.deleteReason = deleteReason;
        this.priority = priority;
        this.dueDate = dueDate;
        this.formKey = formKey;
        this.category = category;
        this.tenantId = tenantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getTaskDefKey() {
        return taskDefKey;
    }

    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
