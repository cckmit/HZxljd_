package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.XlLease;

/**
 * 出租房信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public interface XlLeaseMapper 
{
    /**
     * 查询出租房信息
     * 
     * @param id 出租房信息ID
     * @return 出租房信息
     */
    public XlLease selectXlLeaseById(Long id);

    /**
     * 查询出租房信息列表
     * 
     * @param xlLease 出租房信息
     * @return 出租房信息集合
     */
    public List<XlLease> selectXlLeaseList(XlLease xlLease);

    /**
     * 新增出租房信息
     * 
     * @param xlLease 出租房信息
     * @return 结果
     */
    public int insertXlLease(XlLease xlLease);

    /**
     * 修改出租房信息
     * 
     * @param xlLease 出租房信息
     * @return 结果
     */
    public int updateXlLease(XlLease xlLease);

    /**
     * 删除出租房信息
     * 
     * @param id 出租房信息ID
     * @return 结果
     */
    public int deleteXlLeaseById(Long id);

    /**
     * 批量删除出租房信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlLeaseByIds(String[] ids);

    //根据详细地址判断是都已有数据
    public XlLease selectXlLeaseByAddress(String address);

    //查询小区出租房数据
    int queryRoomListCount(Map<String, Object> thingResult);
}
