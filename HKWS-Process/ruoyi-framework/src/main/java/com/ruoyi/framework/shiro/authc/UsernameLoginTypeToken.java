package com.ruoyi.framework.shiro.authc;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 统一用户登录
 *
 * @author liuf
 */
public class UsernameLoginTypeToken extends UsernamePasswordToken implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String userType;

    private String secretId;

    public UsernameLoginTypeToken() {
    }

    public UsernameLoginTypeToken(final String userType) {
        this.userType = userType;
    }

    public UsernameLoginTypeToken(final String userType, final String username, final String password, final boolean rememberMe) {
        super(username, password, rememberMe);
        this.userType = userType;

    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

}
