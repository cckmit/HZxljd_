package com.ruoyi.system.domain.platform.camera;


/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Copyright 2021 json.cn
 */
        import java.util.List;

/**
 * Auto-generated: 2021-06-01 18:47:26
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class cameraDate {

    private int total;
    private int pageSize;
    private int pageNo;
    private List<camersList> list;
    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageNo() {
        return pageNo;
    }

    public List<camersList> getList() {
        return list;
    }

    public void setList(List<camersList> list) {
        this.list = list;
    }
}