package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HkMapPoint;

/**
 * 设备地图点位Service接口
 *
 * @author guohailong
 * @date 2021-04-12
 */
public interface IHkMapPointService {
    /**
     * 查询设备地图点位
     *
     * @param id 设备地图点位ID
     * @return 设备地图点位
     */
    public HkMapPoint selectHkMapPointById(Long id);

    /**
     * 查询设备地图点位列表
     *
     * @param hkMapPoint 设备地图点位
     * @return 设备地图点位集合
     */
    public List<HkMapPoint> selectHkMapPointList(HkMapPoint hkMapPoint);

    /**
     * 新增设备地图点位
     *
     * @param hkMapPoint 设备地图点位
     * @return 结果
     */
    public int insertHkMapPoint(HkMapPoint hkMapPoint);

    /**
     * 修改设备地图点位
     *
     * @param hkMapPoint 设备地图点位
     * @return 结果
     */
    public int updateHkMapPoint(HkMapPoint hkMapPoint);

    /**
     * 批量删除设备地图点位
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkMapPointByIds(String ids);

    /**
     * 删除设备地图点位信息
     *
     * @param id 设备地图点位ID
     * @return 结果
     */
    public int deleteHkMapPointById(Long id);

    int changeStatus(HkMapPoint mapPoint);
}
