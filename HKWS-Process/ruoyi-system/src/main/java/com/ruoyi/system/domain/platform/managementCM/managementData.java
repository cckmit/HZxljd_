package com.ruoyi.system.domain.platform.managementCM;


/**
 * Copyright 2021 json.cn
 */

import java.util.List;

/**
 * Auto-generated: 2021-05-20 14:9:3
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class managementData {

    private int pageNo;
    private int pageSize;
    private int total;
    private List<managementList> list;
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageNo() {
        return pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }

    public List<managementList> getList() {
        return list;
    }

    public void setList(List<managementList> list) {
        this.list = list;
    }
}
