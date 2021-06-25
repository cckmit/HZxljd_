package com.ruoyi.system.domain.HKfield;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @program: data-ruoyi
 * @description: 字段类型表
 * @author: Yang-Teng-Fei
 * @create: 2020-11-11 17:39
 **/
public class hkfield extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**id */
    private Integer id;

    /**字段类型uuid */
    private String uuid;

    /**常用字段id */
    private String commonlyId;
    /**行动id*/
    private String actionId;

    /**字段名称 */
    private String fieldName;
    /**字段英文名称 */
    private String fieldEnglishName;
    /**字段类型 */
    private String fieldType;

    /**文本长度 */
    private String fieldLength;

    /**提示语 */
    private String fieldCommit;

    /**是否必填 */
    private String fieldNull;

    /**选择内容 */
    private String fieldContent;

    /**创建人 */
    private String createUser;

    /**创建时间 */
    private Date createDate;

    /**修改人 */
    private String updateUser;

    /**修改时间 */
    private Date updateDate;

    /**排序 */
    private Integer fieldSort;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFieldEnglishName() {
        return fieldEnglishName;
    }

    public void setFieldEnglishName(String fieldEnglishName) {
        this.fieldEnglishName = fieldEnglishName;
    }

    public Integer getFieldSort() {
        return fieldSort;
    }

    public void setFieldSort(Integer fieldSort) {
        this.fieldSort = fieldSort;
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getFieldCommit() {
        return fieldCommit;
    }

    public void setFieldCommit(String fieldCommit) {
        this.fieldCommit = fieldCommit;
    }

    public String getFieldNull() {
        return fieldNull;
    }

    public void setFieldNull(String fieldNull) {
        this.fieldNull = fieldNull;
    }

    public String getFieldContent() {
        return fieldContent;
    }

    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent;
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

    public String getCommonlyId() {
        return commonlyId;
    }

    public void setCommonlyId(String commonlyId) {
        this.commonlyId = commonlyId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public hkfield(Integer id, String uuid, String commonlyId, String actionId, String fieldName, String fieldType, String fieldLength, String fieldCommit, String fieldNull, String fieldContent, String createUser, Date createDate, String updateUser, Date updateDate) {
        this.id = id;
        this.uuid = uuid;
        this.commonlyId = commonlyId;
        this.actionId = actionId;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldLength = fieldLength;
        this.fieldCommit = fieldCommit;
        this.fieldNull = fieldNull;
        this.fieldContent = fieldContent;
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    public hkfield(){

    }

    @Override
    public String toString() {
        return "hkfield{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", commonlyId='" + commonlyId + '\'' +
                ", actionId='" + actionId + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldLength='" + fieldLength + '\'' +
                ", fieldCommit='" + fieldCommit + '\'' +
                ", fieldNull='" + fieldNull + '\'' +
                ", fieldContent='" + fieldContent + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
