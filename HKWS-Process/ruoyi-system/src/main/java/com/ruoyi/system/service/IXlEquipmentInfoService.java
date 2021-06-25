package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.XlEquipmentInfo;
import com.ruoyi.system.domain.vo.EventListCountVo;

/**
 * 公共管理/物业--设备信息Service接口
 *
 * @author ruoyi
 * @date 2021-05-25
 */
public interface IXlEquipmentInfoService
{
    /**
     * 查询公共管理/物业--设备信息
     *
     * @param id 公共管理/物业--设备信息ID
     * @return 公共管理/物业--设备信息
     */
    public XlEquipmentInfo selectXlEquipmentInfoById(Long id);

    /**
     * 查询公共管理/物业--设备信息列表
     *
     * @param xlEquipmentInfo 公共管理/物业--设备信息
     * @return 公共管理/物业--设备信息集合
     */
    public List<XlEquipmentInfo> selectXlEquipmentInfoList(XlEquipmentInfo xlEquipmentInfo);

    /**
     * 新增公共管理/物业--设备信息
     *
     * @param xlEquipmentInfo 公共管理/物业--设备信息
     * @return 结果
     */
    public int insertXlEquipmentInfo(XlEquipmentInfo xlEquipmentInfo);

    /**
     * 修改公共管理/物业--设备信息
     *
     * @param xlEquipmentInfo 公共管理/物业--设备信息
     * @return 结果
     */
    public int updateXlEquipmentInfo(XlEquipmentInfo xlEquipmentInfo);

    /**
     * 批量删除公共管理/物业--设备信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlEquipmentInfoByIds(String ids);

    /**
     * 删除公共管理/物业--设备信息信息
     *
     * @param id 公共管理/物业--设备信息ID
     * @return 结果
     */
    public int deleteXlEquipmentInfoById(Long id);
    //设备总数
    int queryEquipmentCount();
    //设备信息
//    List<XlEquipmentInfo> queryEquipmentList();
    //查询是否有监控编号
    int queryEquipmentCamindexCode(String cameraIndexCode);
    //城管设备信息
    List<XlEquipmentInfo> queryEquipmentPoliceList();
    //城管设备总数
    int queryEquipmentPoliceCount(Map<String,Object> params);
    //设备热力图
    List<EventListCountVo> queryEquipmentLongitude(Map<String, Object> thingResult);
    //根据设备序列号查询设备
    List<XlEquipmentInfo> queryList(Map<String, Object> thingResult);
}