package com.ruoyi.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain.dto
 * @ClassName: RegionInfoDto
 * @Author: guohailong
 * @Description: 地区信息查询封装类
 * @Date: 2021/3/17 15:28
 * @Version: 1.0
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RegionDto implements Serializable {

    private Long id;

    private String name;

    private Long parentId;

    private List<RegionDto> childrenList;

    public RegionDto() {
    }

    public RegionDto(Long id, String name, Long parentId, List<RegionDto> childrenList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childrenList = childrenList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<RegionDto> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<RegionDto> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "RegionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", childrenList=" + childrenList +
                '}';
    }
}
