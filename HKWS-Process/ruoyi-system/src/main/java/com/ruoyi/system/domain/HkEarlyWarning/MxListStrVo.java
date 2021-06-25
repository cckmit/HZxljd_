package com.ruoyi.system.domain.HkEarlyWarning;

import java.util.Arrays;

/**
 * @author: 刘浩亮
 * @description:
 * @create: 2021-03-28 15:06
 **/
public class MxListStrVo {

    private Integer postId;
   private SysUserPostRegionVo[] regionList;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "ExListStrVo{" +
                "postId=" + postId +
                ", regionList=" + Arrays.toString(regionList) +
                '}';
    }

    public SysUserPostRegionVo[] getRegionList() {
        return regionList;
    }

    public void setRegionList(SysUserPostRegionVo[] regionList) {
        this.regionList = regionList;
    }
}
