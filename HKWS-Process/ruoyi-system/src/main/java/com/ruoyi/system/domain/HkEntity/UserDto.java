package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2020-12-27-0:08
 */
public class UserDto implements Serializable {
    private String userId;

    private String userName;

    private String userTag;

    private String userTagName;

    private String realName;

    private String idCard;

    private String phoneNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public String getUserTagName() {
        return userTagName;
    }

    public void setUserTagName(String userTagName) {
        this.userTagName = userTagName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
