package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 网格员--检查组信息对象 xl_inspection_team
 *
 * @author ruoyi
 * @date 2021-05-22
 */
public class XlInspectionTeam extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 检查组id
     */
    private Long teamId;

    /**
     * 检查组名称
     */
    @Excel(name = "检查组名称")
    private String teamName;

    /**
     * 巡查计划id
     */
    private Integer patrolplanId;

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

    //包含检查项数量
    private Integer counts;

    //网格-类别状态12345
    private Integer status;

    //新增页面向后台传递的检查项ids
    private String checks;

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getPatrolplanId() {
        return patrolplanId;
    }

    public void setPatrolplanId(Integer patrolplanId) {
        this.patrolplanId = patrolplanId;
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

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getChecks() {
        return checks;
    }

    public void setChecks(String checks) {
        this.checks = checks;
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
                .append("teamId", getTeamId())
                .append("teamName", getTeamName())
                .append("patrolplanId", getPatrolplanId())
                .append("createDate", getCreateDate())
                .append("createUser", getCreateUser())
                .append("updateDate", getUpdateDate())
                .append("updateUser", getUpdateUser())
                .append("status", getStatus())
                .toString();
    }
}
