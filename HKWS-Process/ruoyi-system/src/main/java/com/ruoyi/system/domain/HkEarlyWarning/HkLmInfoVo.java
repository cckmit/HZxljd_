package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.HkLmanagementInfo;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.SysRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 自定义标签对象 hk_lmanagement_info
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
public class HkLmInfoVo extends HkLmanagementInfo
{
    private static final long serialVersionUID = 1L;

    private List<SysRole> roleList;

    private List<SysRegion> regionList;

    private List<HkEClassification> eclassList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public List<SysRegion> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<SysRegion> regionList) {
        this.regionList = regionList;
    }

    public List<HkEClassification> getEclassList() {
        return eclassList;
    }

    public void setEclassList(List<HkEClassification> eclassList) {
        this.eclassList = eclassList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lmId", getLmId())
            .append("lmName", getLmName())
            .append("remark", getRemark())
            .append("lmRegion", getLmRegion())
            .append("lmEventType", getLmEventType())
            .append("lmAuth", getLmAuth())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
