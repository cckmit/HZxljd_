package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业--访客记录对象 xl_visitor
 *
 * @author ruoyi
 * @date 2021-05-26
 */
public class XlVisitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 身份证 */
    @Excel(name = "身份证")
    private String identityNumber;

    /** 性别(0男  1女 3未知) */
    @Excel(name = "性别(0男  1女 3未知)")
    private Integer sex;

    /** 被访人 */
    @Excel(name = "被访人")
    private String interviewee;

    /** 被访事由 */
    @Excel(name = "被访事由")
    private String reasonsInterviewed;
    /** 访问时间 */
    @Excel(name = "预约访问时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reasonsDateAppoint;
    /** 访问时间 */
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reasonsDate;
    /** 到访状态 */
    @Excel(name = "到访状态：1.已到访2.未到访")
    private Integer visitorStatus;

    /** 照片 */
    @Excel(name = "照片")
    private String visitorImg;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    public Date getReasonsDateAppoint() {
        return reasonsDateAppoint;
    }

    public void setReasonsDateAppoint(Date reasonsDateAppoint) {
        this.reasonsDateAppoint = reasonsDateAppoint;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setIdentityNumber(String identityNumber)
    {
        this.identityNumber = identityNumber;
    }

    public String getIdentityNumber()
    {
        return identityNumber;
    }
    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public Integer getSex()
    {
        return sex;
    }
    public void setInterviewee(String interviewee)
    {
        this.interviewee = interviewee;
    }

    public String getInterviewee()
    {
        return interviewee;
    }
    public void setReasonsInterviewed(String reasonsInterviewed)
    {
        this.reasonsInterviewed = reasonsInterviewed;
    }

    public String getReasonsInterviewed()
    {
        return reasonsInterviewed;
    }
    public void setReasonsDate(Date reasonsDate)
    {
        this.reasonsDate = reasonsDate;
    }

    public Date getReasonsDate()
    {
        return reasonsDate;
    }
    public void setVisitorImg(String visitorImg)
    {
        this.visitorImg = visitorImg;
    }

    public String getVisitorImg()
    {
        return visitorImg;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }

    public Integer getVisitorStatus() {
        return visitorStatus;
    }

    public void setVisitorStatus(Integer visitorStatus) {
        this.visitorStatus = visitorStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("phone", getPhone())
                .append("identityNumber", getIdentityNumber())
                .append("sex", getSex())
                .append("interviewee", getInterviewee())
                .append("reasonsInterviewed", getReasonsInterviewed())
                .append("reasonsDate", getReasonsDate())
                .append("visitorImg", getVisitorImg())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
