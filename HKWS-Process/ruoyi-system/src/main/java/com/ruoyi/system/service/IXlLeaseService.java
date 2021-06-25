package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.XlLease;

/**
 * 出租房信息Service接口
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public interface IXlLeaseService 
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
     * 批量删除出租房信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlLeaseByIds(String ids);

    /**
     * 删除出租房信息信息
     * 
     * @param id 出租房信息ID
     * @return 结果
     */
    public int deleteXlLeaseById(Long id);

    //导入功能
    public String importLease(List<XlLease> xlLeaseList, boolean updateSupport);
    //查询小区出租房信息
    int queryRoomListCount(Map<String, Object> thingResult);
}
