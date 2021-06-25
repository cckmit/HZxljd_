package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 【请填写功能名称】对象 hk_action_apply
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
public class HkActionApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请id */
    private Long acId;

    /** 申请图片 */
    @Excel(name = "申请图片")
    private String acImageurls;

    /** 停放区经度 */
    @Excel(name = "停放区经度")
    private String acLongitude;

    /** 停放区纬度 */
    @Excel(name = "停放区纬度")
    private String acLatitude;

    /** 地址 */
    @Excel(name = "地址")
    private String acApplyaddressname;

    /** 申请人id */
    @Excel(name = "申请人id")
    private Long acUserid;

    /** 申请时间 */
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acApplydate;

    public void setAcId(Long acId) 
    {
        this.acId = acId;
    }

    public Long getAcId() 
    {
        return acId;
    }
    public void setAcImageurls(String acImageurls) 
    {
        this.acImageurls = acImageurls;
    }

    public String getAcImageurls() 
    {
        return acImageurls;
    }
    public void setAcLongitude(String acLongitude) 
    {
        this.acLongitude = acLongitude;
    }

    public String getAcLongitude() 
    {
        return acLongitude;
    }
    public void setAcLatitude(String acLatitude) 
    {
        this.acLatitude = acLatitude;
    }

    public String getAcLatitude() 
    {
        return acLatitude;
    }
    public void setAcApplyaddressname(String acApplyaddressname) 
    {
        this.acApplyaddressname = acApplyaddressname;
    }

    public String getAcApplyaddressname() 
    {
        return acApplyaddressname;
    }
    public void setAcUserid(Long acUserid) 
    {
        this.acUserid = acUserid;
    }

    public Long getAcUserid() 
    {
        return acUserid;
    }
    public void setAcApplydate(Date acApplydate) 
    {
        this.acApplydate = acApplydate;
    }

    public Date getAcApplydate() 
    {
        return acApplydate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("acId", getAcId())
            .append("acImageurls", getAcImageurls())
            .append("acLongitude", getAcLongitude())
            .append("acLatitude", getAcLatitude())
            .append("acApplyaddressname", getAcApplyaddressname())
            .append("acUserid", getAcUserid())
            .append("acApplydate", getAcApplydate())
            .toString();
    }
}
