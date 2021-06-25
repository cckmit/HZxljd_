package com.ruoyi.web.controller.thirdParty.enterprise;


import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * EnterpriseListReq
 *
 * @author lcl
 * @date: 2021/4/13
 **/
public class EnterpriseListReq implements Serializable {

    /**
     * 应用APPKEY
     */
    @Value("${enterprise.ak}")
    private String key;

    /**
     * 搜索关键字
     */
    private String keyword;

    /**
     *查询维度
     */
    private String type;

    /**
     * 页码
     */
    private String  pageIndex  = "1";


    /**
     * 每页显示数据数
     */
    private String pageSize = "20";

    /**
     * 返回数据格式
     */
    private String dtype;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }
}
