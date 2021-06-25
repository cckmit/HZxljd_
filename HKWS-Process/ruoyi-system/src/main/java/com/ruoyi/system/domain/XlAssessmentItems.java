package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 网格员--考核项对象 xl_assessment_items
 * 
 * @author ruoyi
 * @date 2021-06-01
 */
public class XlAssessmentItems extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long assessmentId;

    /** 考核项 */
    @Excel(name = "考核项")
    private String assessmentName;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 修改人 */
    private String updateUser;

    /** 修改时间 */
    private Date updateDate;

    /** 包含细分项数量 **/
    private int counts;

    public void setAssessmentId(Long assessmentId) 
    {
        this.assessmentId = assessmentId;
    }

    public Long getAssessmentId() 
    {
        return assessmentId;
    }
    public void setAssessmentName(String assessmentName)
    {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentName()
    {
        return assessmentName;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("assessmentId", getAssessmentId())
            .append("assessmentName", getAssessmentName())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .append("updateUser", getUpdateUser())
            .append("updateDate", getUpdateDate())
            .append("counts",getCounts())
            .toString();
    }
}
