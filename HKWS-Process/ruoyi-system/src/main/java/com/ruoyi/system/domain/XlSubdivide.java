package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 网格员--考核细分项对象 xl_subdivide
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public class XlSubdivide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long subdivideId;

    /** 细分项名称 */
    @Excel(name = "细分项名称")
    private String subdivideName;

    /** 所属考核项 */
    @Excel(name = "所属考核项")
    private Long assessmentId;

    /** 分值 */
    @Excel(name = "分值")
    private Long assessmentScore;

    /** 考核周期 */
    @Excel(name = "考核周期")
    private String assessmentCycle;

    /** 工作要求 */
    private String workRequirement;

    /** 考核数据来源 */
    private String dataSource;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 创建人 */
    private String createUser;

    /** 修改时间 */
    private Date updateDate;

    /** 修改人 */
    private String updateUser;

    /** 关联考核项 */
    private XlAssessmentItems xlAssessmentItems;

    /** 关联单位信息 */
    private String deptNames;

    public void setSubdivideId(Long subdivideId) 
    {
        this.subdivideId = subdivideId;
    }

    public Long getSubdivideId() 
    {
        return subdivideId;
    }
    public void setSubdivideName(String subdivideName) 
    {
        this.subdivideName = subdivideName;
    }

    public String getSubdivideName() 
    {
        return subdivideName;
    }
    public void setAssessmentId(Long assessmentId) 
    {
        this.assessmentId = assessmentId;
    }

    public Long getAssessmentId() 
    {
        return assessmentId;
    }
    public void setAssessmentScore(Long assessmentScore)
    {
        this.assessmentScore = assessmentScore;
    }

    public Long getAssessmentScore()
    {
        return assessmentScore;
    }
    public void setAssessmentCycle(String assessmentCycle)
    {
        this.assessmentCycle = assessmentCycle;
    }

    public String getAssessmentCycle()
    {
        return assessmentCycle;
    }
    public void setWorkRequirement(String workRequirement) 
    {
        this.workRequirement = workRequirement;
    }

    public String getWorkRequirement() 
    {
        return workRequirement;
    }
    public void setDataSource(String dataSource) 
    {
        this.dataSource = dataSource;
    }

    public String getDataSource() 
    {
        return dataSource;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    public XlAssessmentItems getXlAssessmentItems() {
        return xlAssessmentItems;
    }

    public void setXlAssessmentItems(XlAssessmentItems xlAssessmentItems) {
        this.xlAssessmentItems = xlAssessmentItems;
    }

    public String getDeptNames() {
        return deptNames;
    }

    public void setDeptNames(String deptNames) {
        this.deptNames = deptNames;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subdivideId", getSubdivideId())
            .append("subdivideName", getSubdivideName())
            .append("assessmentId", getAssessmentId())
            .append("assessmentScore", getAssessmentScore())
            .append("assessmentCycle", getAssessmentCycle())
            .append("workRequirement", getWorkRequirement())
            .append("dataSource", getDataSource())
            .append("createDate", getCreateDate())
            .append("createUser", getCreateUser())
            .append("updateDate", getUpdateDate())
            .append("updateUser", getUpdateUser())
            .append("deptNames", getDeptNames())
            .toString();
    }
}
