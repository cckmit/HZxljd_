package com.ruoyi.system.domain.app;

import java.io.Serializable;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 04:04
 **/
public class WxHkEventVo implements Serializable {

    /**事件标题 */
    private String eventTitle;
    /**事件类型**/
    private String eventTypeName;
    /**分页数据**/
    private Integer pageNum = 1;
    /**数量**/
    private Integer pageSize = 10;
    /**用户**/
    private Long userId;

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
