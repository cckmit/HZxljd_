package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XlCarInfo;

/**
 * 公共管理/物业--车辆信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-21
 */
public interface XlCarInfoMapper 
{
    /**
     * 查询公共管理/物业--车辆信息
     * 
     * @param id 公共管理/物业--车辆信息ID
     * @return 公共管理/物业--车辆信息
     */
    public XlCarInfo selectXlCarInfoById(Long id);

    /**
     * 查询公共管理/物业--车辆信息列表
     * 
     * @param xlCarInfo 公共管理/物业--车辆信息
     * @return 公共管理/物业--车辆信息集合
     */
    public List<XlCarInfo> selectXlCarInfoList(XlCarInfo xlCarInfo);

    /**
     * 新增公共管理/物业--车辆信息
     * 
     * @param xlCarInfo 公共管理/物业--车辆信息
     * @return 结果
     */
    public int insertXlCarInfo(XlCarInfo xlCarInfo);

    /**
     * 修改公共管理/物业--车辆信息
     * 
     * @param xlCarInfo 公共管理/物业--车辆信息
     * @return 结果
     */
    public int updateXlCarInfo(XlCarInfo xlCarInfo);

    /**
     * 删除公共管理/物业--车辆信息
     * 
     * @param id 公共管理/物业--车辆信息ID
     * @return 结果
     */
    public int deleteXlCarInfoById(Long id);

    /**
     * 批量删除公共管理/物业--车辆信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlCarInfoByIds(String[] ids);
}
