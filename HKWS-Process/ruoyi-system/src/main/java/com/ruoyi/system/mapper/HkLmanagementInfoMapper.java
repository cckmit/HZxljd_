package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.*;
import org.apache.ibatis.annotations.Param;

/**
 * 自定义标签Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
public interface HkLmanagementInfoMapper
{
    /**
     * 查询自定义标签
     * 
     * @param lmId 自定义标签ID
     * @return 自定义标签
     */
    public HkLmanagementInfo selectHkLmanagementInfoById(Long lmId);

    /**
     * 查询自定义标签列表
     * 
     * @param HkLmanagementInfo 自定义标签
     * @return 自定义标签集合
     */
    public List<HkLmanagementInfo> selectHkLmanagementInfoList(HkLmanagementInfo HkLmanagementInfo);

    /**
     * 新增自定义标签
     * 
     * @param HkLmanagementInfo 自定义标签
     * @return 结果
     */
    public int insertHkLmanagementInfo(HkLmanagementInfo HkLmanagementInfo);

    /**
     * 修改自定义标签
     * 
     * @param HkLmanagementInfo 自定义标签
     * @return 结果
     */
    public int updateHkLmanagementInfo(HkLmanagementInfo HkLmanagementInfo);

    /**
     * 删除自定义标签
     * 
     * @param lmId 自定义标签ID
     * @return 结果
     */
    public int deleteHkLmanagementInfoById(Long lmId);

    /**
     * 批量删除自定义标签
     * 
     * @param lmIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkLmanagementInfoByIds(String[] lmIds);

    public int checkLmNameUnique(@Param("lmName") String lmName,@Param("lmId") Long lmId);


    List<SysRole> queryLmRole(Long lmId);

    List<SysRegion> queryLmRegion(Map<String,Object> param);

    List<HkEClassification> queryLmEventType(Long lmId);

    List<HkLmanagementInfo> queryLmByEvent(Long eventId);

    /**
     * 插入事件标签关联表
     * @param list
     * @return
     */
    int insertEventLmanager(@Param("list") List<HkEventLmanage> list);

    /**删除事件标签关联信息**/
    int deleteEventLmanager(Map<String,Long> params);

    public int insertHkLmanagementBackPriKey(HkLmanagementInfo hkLmanagement);
}
