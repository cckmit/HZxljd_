package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkMapPointMapper;
import com.ruoyi.system.domain.HkMapPoint;
import com.ruoyi.system.service.IHkMapPointService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备地图点位Service业务层处理
 *
 * @author guohailong
 * @date 2021-04-12
 */
@Service
public class HkMapPointServiceImpl implements IHkMapPointService {
    @Autowired
    private HkMapPointMapper hkMapPointMapper;

    /**
     * 查询设备地图点位
     *
     * @param id 设备地图点位ID
     * @return 设备地图点位
     */
    @Override
    public HkMapPoint selectHkMapPointById(Long id) {
        return hkMapPointMapper.selectHkMapPointById(id);
    }

    /**
     * 查询设备地图点位列表
     *
     * @param hkMapPoint 设备地图点位
     * @return 设备地图点位
     */
    @Override
    public List<HkMapPoint> selectHkMapPointList(HkMapPoint hkMapPoint) {
        return hkMapPointMapper.selectHkMapPointList(hkMapPoint);
    }

    /**
     * 新增设备地图点位
     *
     * @param hkMapPoint 设备地图点位
     * @return 结果
     */
    @Override
    public int insertHkMapPoint(HkMapPoint hkMapPoint) {
        hkMapPoint.setCreateTime(DateUtils.getNowDate());
        return hkMapPointMapper.insertHkMapPoint(hkMapPoint);
    }

    /**
     * 修改设备地图点位
     *
     * @param hkMapPoint 设备地图点位
     * @return 结果
     */
    @Override
    public int updateHkMapPoint(HkMapPoint hkMapPoint) {
        hkMapPoint.setUpdateTime(DateUtils.getNowDate());
        return hkMapPointMapper.updateHkMapPoint(hkMapPoint);
    }

    /**
     * 删除设备地图点位对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkMapPointByIds(String ids) {
        return hkMapPointMapper.deleteHkMapPointByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备地图点位信息
     *
     * @param id 设备地图点位ID
     * @return 结果
     */
    @Override
    public int deleteHkMapPointById(Long id) {
        return hkMapPointMapper.deleteHkMapPointById(id);
    }

    @Override
    public int changeStatus(HkMapPoint mapPoint) {
        return hkMapPointMapper.updateHkMapPoint(mapPoint);
    }
}
