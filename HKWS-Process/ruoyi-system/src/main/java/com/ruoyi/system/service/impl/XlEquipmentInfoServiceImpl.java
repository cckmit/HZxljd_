package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.vo.EventListCountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlEquipmentInfoMapper;
import com.ruoyi.system.domain.XlEquipmentInfo;
import com.ruoyi.system.service.IXlEquipmentInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公共管理/物业--设备信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-25
 */
@Service
public class XlEquipmentInfoServiceImpl implements IXlEquipmentInfoService
{
    @Autowired
    private XlEquipmentInfoMapper xlEquipmentInfoMapper;

    /**
     * 查询公共管理/物业--设备信息
     *
     * @param id 公共管理/物业--设备信息ID
     * @return 公共管理/物业--设备信息
     */
    @Override
    public XlEquipmentInfo selectXlEquipmentInfoById(Long id)
    {
        return xlEquipmentInfoMapper.selectXlEquipmentInfoById(id);
    }

    /**
     * 查询公共管理/物业--设备信息列表
     *
     * @param xlEquipmentInfo 公共管理/物业--设备信息
     * @return 公共管理/物业--设备信息
     */
    @Override
    public List<XlEquipmentInfo> selectXlEquipmentInfoList(XlEquipmentInfo xlEquipmentInfo)
    {
        return xlEquipmentInfoMapper.selectXlEquipmentInfoList(xlEquipmentInfo);
    }

    /**
     * 新增公共管理/物业--设备信息
     *
     * @param xlEquipmentInfo 公共管理/物业--设备信息
     * @return 结果
     */
    @Override
    public int insertXlEquipmentInfo(XlEquipmentInfo xlEquipmentInfo)
    {
        xlEquipmentInfo.setCreateTime(DateUtils.getNowDate());
        return xlEquipmentInfoMapper.insertXlEquipmentInfo(xlEquipmentInfo);
    }

    /**
     * 修改公共管理/物业--设备信息
     *
     * @param xlEquipmentInfo 公共管理/物业--设备信息
     * @return 结果
     */
    @Override
    public int updateXlEquipmentInfo(XlEquipmentInfo xlEquipmentInfo)
    {
        xlEquipmentInfo.setUpdateTime(DateUtils.getNowDate());
        return xlEquipmentInfoMapper.updateXlEquipmentInfo(xlEquipmentInfo);
    }

    /**
     * 删除公共管理/物业--设备信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlEquipmentInfoByIds(String ids)
    {
        return xlEquipmentInfoMapper.deleteXlEquipmentInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公共管理/物业--设备信息信息
     *
     * @param id 公共管理/物业--设备信息ID
     * @return 结果
     */
    @Override
    public int deleteXlEquipmentInfoById(Long id)
    {
        return xlEquipmentInfoMapper.deleteXlEquipmentInfoById(id);
    }

    @Override
    public int queryEquipmentCount() {
        return xlEquipmentInfoMapper.queryEquipmentCount();
    }

//    @Override
//    public List<XlEquipmentInfo> queryEquipmentList() {
//        return xlEquipmentInfoMapper.queryEquipmentList();
//    }

    @Override
    public int queryEquipmentCamindexCode(String cameraIndexCode) {
        return xlEquipmentInfoMapper.queryEquipmentCamindexCode(cameraIndexCode);
    }

    @Override
    public List<XlEquipmentInfo> queryEquipmentPoliceList() {
        return xlEquipmentInfoMapper.queryEquipmentPoliceList();
    }

    @Override
    public int queryEquipmentPoliceCount(Map<String,Object> params) {
        return xlEquipmentInfoMapper.queryEquipmentPoliceCount(params);
    }

    @Override
    public List<EventListCountVo> queryEquipmentLongitude(Map<String, Object> thingResult) {
        return xlEquipmentInfoMapper.queryEquipmentLongitude(thingResult);
    }

    @Override
    public List<XlEquipmentInfo> queryList(Map<String, Object> thingResult) {
        return xlEquipmentInfoMapper.queryList(thingResult);
    }
}