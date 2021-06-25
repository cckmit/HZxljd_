package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 网格员--检查项信息对象 xl_check_items
 *
 * @author ruoyi
 * @date 2021-05-24
 */
public class XlCheckItems extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long checkId;

    /**
     * 检查项描述
     */
    @Excel(name = "检查项描述")
    private String checkName;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String createUser;

    /**
     * 修改时间
     */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /**
     * 修改人
     */
    @Excel(name = "修改人")
    private String updateUser;

    //事件类型编码
    private String eclassCode;

    //网格-类别12345
    private Integer status;

    //关联事件分类
    private HkEClassification hkEClassification;

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getEclassCode() {
        return eclassCode;
    }

    public void setEclassCode(String eclassCode) {
        this.eclassCode = eclassCode;
    }

    public HkEClassification getHkEClassification() {
        return hkEClassification;
    }

    public void setHkEClassification(HkEClassification hkEClassification) {
        this.hkEClassification = hkEClassification;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("checkId", getCheckId())
                .append("checkName", getCheckName())
                .append("createDate", getCreateDate())
                .append("createUser", getCreateUser())
                .append("updateDate", getUpdateDate())
                .append("updateUser", getUpdateUser())
                .append("eclassCode", getEclassCode())
                .append("hkEClassification", getHkEClassification())
                .append("status", getStatus())
                .toString();
    }
}
