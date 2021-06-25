package com.ruoyi.system.domain.app;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * @program: data-ruoyi
 * @description: app-管理员（按人员查看）
 * @author: Yang-Teng-Fei
 * @create: 2020-12-11 02:35
 **/
public class hkAdminEvent implements Serializable {
    /**用户姓名 */
    private String userName;
    /**待处理数 */
    private Integer pengNum;

    /**已逾期数 */
    private Integer overNum;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPengNum() {
        return pengNum;
    }

    public void setPengNum(Integer pengNum) {
        this.pengNum = pengNum;
    }

    public Integer getOverNum() {
        return overNum;
    }

    public void setOverNum(Integer overNum) {
        this.overNum = overNum;
    }
}
