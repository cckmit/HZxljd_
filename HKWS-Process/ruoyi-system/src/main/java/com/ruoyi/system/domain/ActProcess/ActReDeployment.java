package com.ruoyi.system.domain.ActProcess;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-11-15-3:38
 */
public class ActReDeployment extends BaseEntity {
    /**
     * 部署信息表id
     */
    private String id;
    /**
     * 部署名称
     */
    private String name;
    /**
     * 部署类型
     */
    private String category;
    /**
     * 租户
     */
    private String tenantId;
    /**
     * 部署时间
     */
    private Date deployTime;

    private String engineVersion;
    /**
     * 流程定义表 中 的部署表外键
     */
    private String deploymentId;
    /**
     *  工作流的唯一标识
     */
    private String key;

    public ActReDeployment() {
    }

    public ActReDeployment(String id, String name, String category, String tenantId, Date deployTime, String engineVersion, String deploymentId, String key) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.tenantId = tenantId;
        this.deployTime = deployTime;
        this.engineVersion = engineVersion;
        this.deploymentId = deploymentId;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
