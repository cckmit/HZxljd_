package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlCarInfoMapper;
import com.ruoyi.system.domain.XlCarInfo;
import com.ruoyi.system.service.IXlCarInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公共管理/物业--车辆信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-21
 */
@Service
public class XlCarInfoServiceImpl implements IXlCarInfoService 
{
    @Autowired
    private XlCarInfoMapper xlCarInfoMapper;

    /**
     * 查询公共管理/物业--车辆信息
     * 
     * @param id 公共管理/物业--车辆信息ID
     * @return 公共管理/物业--车辆信息
     */
    @Override
    public XlCarInfo selectXlCarInfoById(Long id)
    {
        return xlCarInfoMapper.selectXlCarInfoById(id);
    }

    /**
     * 查询公共管理/物业--车辆信息列表
     * 
     * @param xlCarInfo 公共管理/物业--车辆信息
     * @return 公共管理/物业--车辆信息
     */
    @Override
    public List<XlCarInfo> selectXlCarInfoList(XlCarInfo xlCarInfo)
    {
        return xlCarInfoMapper.selectXlCarInfoList(xlCarInfo);
    }

    /**
     * 新增公共管理/物业--车辆信息
     * 
     * @param xlCarInfo 公共管理/物业--车辆信息
     * @return 结果
     */
    @Override
    public int insertXlCarInfo(XlCarInfo xlCarInfo)
    {
        //修改时间
        xlCarInfo.setUpdateTime(DateUtils.getNowDate());
        //新增时间
        xlCarInfo.setCreateTime(DateUtils.getNowDate());
        return xlCarInfoMapper.insertXlCarInfo(xlCarInfo);
    }

    /**
     * 修改公共管理/物业--车辆信息
     * 
     * @param xlCarInfo 公共管理/物业--车辆信息
     * @return 结果
     */
    @Override
    public int updateXlCarInfo(XlCarInfo xlCarInfo)
    {
        //修改时间
        xlCarInfo.setUpdateTime(DateUtils.getNowDate());
        return xlCarInfoMapper.updateXlCarInfo(xlCarInfo);
    }

    /**
     * 删除公共管理/物业--车辆信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlCarInfoByIds(String ids)
    {
        return xlCarInfoMapper.deleteXlCarInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公共管理/物业--车辆信息信息
     * 
     * @param id 公共管理/物业--车辆信息ID
     * @return 结果
     */
    @Override
    public int deleteXlCarInfoById(Long id)
    {
        return xlCarInfoMapper.deleteXlCarInfoById(id);
    }
}
