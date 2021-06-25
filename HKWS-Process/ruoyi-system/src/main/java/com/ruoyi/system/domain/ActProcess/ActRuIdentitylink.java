package com.ruoyi.system.domain.ActProcess;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author FanKaibiao
 * @date 2020-11-21-0:37
 * ACT_RU_IDENTITYLINK（身份联系）
 */
public class ActRuIdentitylink extends BaseEntity {
    /**
     *
     */
    private String id;
    /**
     *版本号
     */
    private Integer rev;
    /**
     *用户组ＩＤ
     */
    private String groupId;
    /**
     *用户组类型
     */
    private String type;
    /**
     *用户 ID
     */
    private String userId;
    /**
     *任务 Id
     */
    private String taskId;
    /**
     *流程实例 ID
     */
    private String procInstId;
    /**
     *流程定义 Id
     */
    private String ProcDefId;

    public ActRuIdentitylink() {
    }

    public ActRuIdentitylink(String id, Integer rev, String groupId, String type, String userId, String taskId, String procInstId, String procDefId) {
        this.id = id;
        this.rev = rev;
        this.groupId = groupId;
        this.type = type;
        this.userId = userId;
        this.taskId = taskId;
        this.procInstId = procInstId;
        ProcDefId = procDefId;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getProcDefId() {
        return ProcDefId;
    }

    public void setProcDefId(String procDefId) {
        ProcDefId = procDefId;
    }
}
