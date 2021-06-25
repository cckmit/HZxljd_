package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.HkRentHouseInfo;

/**
 * 房屋管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public interface HkRentHouseInfoMapper 
{
    /**
     * 查询房屋管理
     * 
     * @param id 房屋管理ID
     * @return 房屋管理
     */
    public HkRentHouseInfo selectHkRentHouseInfoById(Long id);

    /**
     * 根据房屋编号查询房屋信息
     * @param houseCode
     * @return
     */
    public HkRentHouseInfo selectHkRentHouseInfoByCode(String houseCode);

    /**
     * 查询房屋管理列表
     * 
     * @param hkRentHouseInfo 房屋管理
     * @return 房屋管理集合
     */
    public List<HkRentHouseInfo> selectHkRentHouseInfoList(HkRentHouseInfo hkRentHouseInfo);

    /**
     * 新增房屋管理
     * 
     * @param hkRentHouseInfo 房屋管理
     * @return 结果
     */
    public int insertHkRentHouseInfo(HkRentHouseInfo hkRentHouseInfo);

    /**
     * 修改房屋管理
     * 
     * @param hkRentHouseInfo 房屋管理
     * @return 结果
     */
    public int updateHkRentHouseInfo(HkRentHouseInfo hkRentHouseInfo);

    /**
     * 删除房屋管理
     * 
     * @param id 房屋管理ID
     * @return 结果
     */
    public int deleteHkRentHouseInfoById(Long id);

    /**
     * 批量删除房屋管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkRentHouseInfoByIds(String[] ids);

    int allCount(Map<String,Object> params);
}
