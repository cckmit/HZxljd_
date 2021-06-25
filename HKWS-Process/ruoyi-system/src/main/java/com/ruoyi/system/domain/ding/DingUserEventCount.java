package com.ruoyi.system.domain.ding;

import java.io.Serializable;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain.ding
 * @ClassName: DingUserEventCount
 * @Author: guohailong
 * @Description: 浙政钉-用户事件完成数量对象
 * @Date: 2021/3/12 1:23
 * @Version: 1.0
 */
public class DingUserEventCount implements Serializable {
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 待处理数
     */
    private Integer toDoCount;

    /**
     * 已逾期数
     */
    private Integer overCount;

    /**
     * 已完成数
     */
    private Integer endCount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getToDoCount() {
        return toDoCount;
    }

    public void setToDoCount(Integer toDoCount) {
        this.toDoCount = toDoCount;
    }

    public Integer getOverCount() {
        return overCount;
    }

    public void setOverCount(Integer overCount) {
        this.overCount = overCount;
    }

    public Integer getEndCount() {
        return endCount;
    }

    public void setEndCount(Integer endCount) {
        this.endCount = endCount;
    }
}
