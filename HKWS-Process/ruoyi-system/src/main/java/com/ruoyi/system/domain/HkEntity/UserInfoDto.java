package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxinxin
 * @date 2020-12-27-0:08
 */
public class UserInfoDto implements Serializable {

    private Integer userId;

    private String userName;

    private Integer sex;

    private String phone;

    private String deptName;

    private String searchValue;

    private Map<String,List<UserPostRegionVo>> userParams;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Map<String, List<UserPostRegionVo>> getUserParams() {
        return userParams;
    }

    public void setUserParams(Map<String, List<UserPostRegionVo>> userParams) {
        this.userParams = userParams;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
