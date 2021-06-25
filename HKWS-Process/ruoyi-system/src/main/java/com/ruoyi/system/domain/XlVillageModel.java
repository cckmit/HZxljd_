package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 小区信息对象 xl_village
 *
 * @author ruoyi
 * @date 2021-05-24
 */
public class XlVillageModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 小区编号 */
    @Excel(name = "小区编号")
    private String code;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String name;

    /** 网格id */
    @Excel(name = "网格id", type = Excel.Type.IMPORT)
    private String deptId;

    /** 网格名称 */
    @Excel(name = "网格名称")
    private String deptName;

    /** 物业id */
    @Excel(name = "物业id", type = Excel.Type.IMPORT)
    private String propertyId;

    /** 物业名称 */
    @Excel(name = "物业名称")
    private String propertyName;
    /** 物业负责人联系方式 */
    @Excel(name = "物业负责人联系方式")
    private String propertyPhone;
    /** 物业名称 */
    @Excel(name = "物业负责人")
    private String propertyPerson;
    /** 小区业委会负责人 */
    @Excel(name = "小区业委会负责人")
    private String quartersCommitteePerson;

    /** 小区业委会负责人联系方式 */
    @Excel(name = "小区业委会负责人联系方式")
    private String quartersCommitteePhone;

    /** 居委会负责人 */
    @Excel(name = "居委会负责人")
    private String neighborhoodPerson;

    /** 居委会负责人联系方式 */
    @Excel(name = "居委会负责人联系方式")
    private String neighborhoodPhone;

    //Xl_village表和sys_region表关联
    /** 社区名称名称 */
    @Excel(name = "社区名称")
    private String regionName;

    /** 所属村社 */
    @Excel(name = "所属村社")
    private String regionParentName;

    //创建人
    private String createBy;
    //创建时间
    private Date createTime;
    //修改人
    private String updateBy;
    //修改时间
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyPhone() {
        return propertyPhone;
    }

    public void setPropertyPhone(String propertyPhone) {
        this.propertyPhone = propertyPhone;
    }

    public String getPropertyPerson() {
        return propertyPerson;
    }

    public void setPropertyPerson(String propertyPerson) {
        this.propertyPerson = propertyPerson;
    }

    public String getQuartersCommitteePerson() {
        return quartersCommitteePerson;
    }

    public void setQuartersCommitteePerson(String quartersCommitteePerson) {
        this.quartersCommitteePerson = quartersCommitteePerson;
    }

    public String getQuartersCommitteePhone() {
        return quartersCommitteePhone;
    }

    public void setQuartersCommitteePhone(String quartersCommitteePhone) {
        this.quartersCommitteePhone = quartersCommitteePhone;
    }

    public String getNeighborhoodPerson() {
        return neighborhoodPerson;
    }

    public void setNeighborhoodPerson(String neighborhoodPerson) {
        this.neighborhoodPerson = neighborhoodPerson;
    }

    public String getNeighborhoodPhone() {
        return neighborhoodPhone;
    }

    public void setNeighborhoodPhone(String neighborhoodPhone) {
        this.neighborhoodPhone = neighborhoodPhone;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionParentName() {
        return regionParentName;
    }

    public void setRegionParentName(String regionParentName) {
        this.regionParentName = regionParentName;
    }

    @Override
    public String toString() {
        return "XlVillageModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyPhone='" + propertyPhone + '\'' +
                ", propertyPerson='" + propertyPerson + '\'' +
                ", quartersCommitteePerson='" + quartersCommitteePerson + '\'' +
                ", quartersCommitteePhone='" + quartersCommitteePhone + '\'' +
                ", neighborhoodPerson='" + neighborhoodPerson + '\'' +
                ", neighborhoodPhone='" + neighborhoodPhone + '\'' +
                ", regionName='" + regionName + '\'' +
                ", regionParentName='" + regionParentName + '\'' +
                '}';
    }
}
