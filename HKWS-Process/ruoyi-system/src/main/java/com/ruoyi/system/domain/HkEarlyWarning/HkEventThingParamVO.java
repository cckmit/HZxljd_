package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;

/**
 * 一事一档事件列表返回字段
 */
public class HkEventThingParamVO implements Serializable {

    /**日期类型**/
    private String type;

    /**社区编号**/
    private String regionCode;

    /**排序字段**/
    private String sortItem;

    /**正序倒序**/
    private String sort;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getSortItem() {
        return sortItem;
    }

    public void setSortItem(String sortItem) {
        this.sortItem = sortItem;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
