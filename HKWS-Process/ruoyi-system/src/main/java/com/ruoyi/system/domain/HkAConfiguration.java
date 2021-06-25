package com.ruoyi.system.domain;
import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * 行动配置表
 */
public class HkAConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;
    /**id*/
    private Integer id;

    /**行动id */
    private String uuid;

    /**行动名称 */
    private String actionName;

    /**行动备注 */
    private String actionRemarks;
    /**事件类型id */
    private String actionTypeId;
    /**事件类型 */
    private String actionType;

    /**行动状态 */
    private Integer actionStatus;

    /**是否删除 */
    private Integer isDelete;

    /**创建人 */
    private String createUser;

    /**创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**修改人 */
    private String updateUser;

    /**事件名称 */
    private String  ec_name;
    /** 事件id*/
    private Integer ecId;



    /**修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    public Date updateDate;

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(String actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public String getEc_name() {
        return ec_name;
    }

    public void setEc_name(String ec_name) {
        this.ec_name = ec_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionRemarks() {
        return actionRemarks;
    }

    public void setActionRemarks(String actionRemarks) {
        this.actionRemarks = actionRemarks;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Integer getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(Integer actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public HkAConfiguration(Integer id, String uuid, String actionName, String actionRemarks, String actionType, Integer actionStatus, Integer isDelete, String createUser, Date createDate, String updateUser, Date updateDate) {
        this.id = id;
        this.uuid = uuid;
        this.actionName = actionName;
        this.actionRemarks = actionRemarks;
        this.actionType = actionType;
        this.actionStatus = actionStatus;
        this.isDelete = isDelete;
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    public HkAConfiguration(){

    }

    @Override
    public String toString() {
        return "HkAConfiguration{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", actionName='" + actionName + '\'' +
                ", actionRemarks='" + actionRemarks + '\'' +
                ", actionType='" + actionType + '\'' +
                ", actionStatus=" + actionStatus +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
