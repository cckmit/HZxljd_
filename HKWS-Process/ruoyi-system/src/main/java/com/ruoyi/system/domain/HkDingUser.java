package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain
 * @ClassName: HkDingUser
 * @Author: guohailong
 * @Description: 浙政钉-系统用户绑定关系表
 * @Date: 2021/3/22 14:53
 * @Version: 1.0
 */
public class HkDingUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 浙政钉用户id
     */
    private String dingUserId;

    /**
     * 系统用户id
     */
    private Long sysUserId;

    /**
     * 浙政钉用户信息
     */
    private String dingUserInfo;

    /**
     * 系统用户名
     */
    private String sysUserName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDingUserId(String dingUserId) {
        this.dingUserId = dingUserId;
    }

    public String getDingUserId() {
        return dingUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setDingUserInfo(String dingUserInfo) {
        this.dingUserInfo = dingUserInfo;
    }

    public String getDingUserInfo() {
        return dingUserInfo;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dingUserId", getDingUserId())
                .append("sysUserId", getSysUserId())
                .append("dingUserInfo", getDingUserInfo())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("sysUserName", getSysUserName())
                .toString();
    }
}
