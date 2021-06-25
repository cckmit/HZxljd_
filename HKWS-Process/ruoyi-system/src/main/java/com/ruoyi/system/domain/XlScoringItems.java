package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 网格-考核评分项对象 xl_scoring_items
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public class XlScoringItems extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 描述 */
    @Excel(name = "描述")
    private String describes;

    /** 所属细分项 */
    @Excel(name = "所属细分项")
    private Long subdivideId;

    /** 考核责任单位 */
    @Excel(name = "考核责任单位")
    private String deptId;

    /** 创建人 */
    private String createUser;

    /** 关联单位部门 **/
    private SysDept sysDept;

    /** 关联细分项 **/
    private XlSubdivide xlSubdivide;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDescribes(String describes) 
    {
        this.describes = describes;
    }

    public String getDescribes() 
    {
        return describes;
    }
    public void setSubdivideId(Long subdivideId) 
    {
        this.subdivideId = subdivideId;
    }

    public Long getSubdivideId() 
    {
        return subdivideId;
    }
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public XlSubdivide getXlSubdivide() {
        return xlSubdivide;
    }

    public void setXlSubdivide(XlSubdivide xlSubdivide) {
        this.xlSubdivide = xlSubdivide;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("describes", getDescribes())
            .append("subdivideId", getSubdivideId())
            .append("deptId", getDeptId())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("sysDept", getSysDept())
            .append("xlSubdivide", getXlSubdivide())
            .toString();
    }
}
