package com.ruoyi.system.service;

import com.ruoyi.system.domain.HkMapCover;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service
 * @ClassName: IHkMapCoverService
 * @Author: guohailong
 * @Description: 地图覆盖物
 * @Date: 2021/3/16 1:42
 * @Version: 1.0
 */
public interface IHkMapCoverService {


    /**
     * 新增地图覆盖物-地区关联
     *
     * @param hkMapCover 地图覆盖物-地区关联
     * @return 结果
     */
    public int insertHkMapCover(HkMapCover hkMapCover);


    /**
     * 根据地区id查询地图覆盖物
     * @param regionId
     * @return
     */
    HkMapCover getHkMapCover(Long regionId);

    /**
     * 根据地区id 获取其所有下级地区地图覆盖物标记点.
     * @param regionId
     * @return
     */
    List<HkMapCover> getChildHkMapCoverList(Long regionId);

    /**
     * 根据地区id. 获取其所有兄弟地区的地图覆盖物标记点
     * @param regionId
     * @return
     */
    List<HkMapCover> getBrotherHkMapCoverList(Long regionId);

    /**
     * 根据地区id删除当前覆盖物
     * @param regionId
     * @return
     */
    int deleteHkMapCoverByParentId(Long regionId);

    /**
     *
     * @param regionId
     * @return
     */
    HkMapCover getParentHkMapCover(Long regionId);


    /**
     * 获取所有地区点位
     * @return
     */
    List<HkMapCover> getALLMapCoverList();

    /**
     * 获取当前地区堂兄弟节点.
     * @param regionId
     * @return
     */
    List<HkMapCover> getCousinHkMapCoverList(Long regionId);
}
