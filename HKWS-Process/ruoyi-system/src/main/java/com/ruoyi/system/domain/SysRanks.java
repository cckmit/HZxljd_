package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.HkEntity.UserPostRegionVo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

/**
 * 队伍信息
 * 
 * @author ruoyi
 */
public class SysRanks extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long ranksId;
    /**用户名称**/
    @Excel(name = "用户名称")
    @Size(min = 0, max = 30, message = "用户名称长度不能超过30个字符")
    private String ranksName;
    /**邮箱**/
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;
    /**手机**/
    @Excel(name = "用户手机号")
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    private String phone;
    /**性别**/
    @Excel(name = "性别")
    private String sex;
    /**头像路径**/
    private String avatar;
    /**账号状态**/
    private String status;
    /**删除标识**/
    private String delFlag;
    /**地址**/
    @Excel(name = "地址")
    private String addr;

    private Map<String,List<UserPostRegionVo>> userParams;

    public Map<String, List<UserPostRegionVo>> getUserParams() {
        return userParams;
    }

    public void setUserParams(Map<String, List<UserPostRegionVo>> userParams) {
        this.userParams = userParams;
    }

    public Long getRanksId() {
        return ranksId;
    }

    public void setRanksId(Long ranksId) {
        this.ranksId = ranksId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRanksName() {
        return ranksName;
    }

    public void setRanksName(String ranksName) {
        this.ranksName = ranksName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
