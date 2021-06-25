package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxinxin
 * @date 2020-12-27-0:08
 */
public class UserPostRegionVo implements Serializable {

    private Integer postId;

    private String postName;

    private Integer regionId;

    private String regionName;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}
