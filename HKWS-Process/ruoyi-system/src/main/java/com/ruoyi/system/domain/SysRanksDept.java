package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和角色关联 sys_user_role
 * 
 * @author ruoyi
 */
public class SysRanksDept
{
    /** 队伍ID */
    private Long ranksId;
    
    /** 部门ID */
    private Long deptId;

    public Long getRanksId() {
        return ranksId;
    }

    public void setRanksId(Long ranksId) {
        this.ranksId = ranksId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ranksId", getRanksId())
            .append("deptId", getDeptId())
            .toString();
    }
}
