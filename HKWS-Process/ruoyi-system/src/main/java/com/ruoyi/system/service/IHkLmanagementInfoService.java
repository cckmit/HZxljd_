package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.HkLmanagementInfo;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.domain.HkEarlyWarning.HkLmInfoVo;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.SysRole;

/**
 * 自定义标签Service接口
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
public interface IHkLmanagementInfoService
{
    /**
     * 查询自定义标签
     * 
     * @param lmId 自定义标签ID
     * @return 自定义标签
     */
    public HkLmanagementInfo selectHkLmanagementInfoById(Long lmId);


    public HkLmInfoVo selectHkLmById(Long lmId);

    /**
     * 查询自定义标签列表
     * 
     * @param HkLmanagementInfo 自定义标签
     * @return 自定义标签集合
     */
    public List<HkLmInfoVo> selectHkLmList(HkLmanagementInfo HkLmanagementInfo);

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
     * @param vo 自定义标签
     * @return 结果
     */
    public int updateHkLmanagementInfo(HkLmInfoVo vo);

    /**
     * 批量删除自定义标签
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkLmanagementInfoByIds(String ids);

    /**
     * 删除自定义标签信息
     * 
     * @param lmId 自定义标签ID
     * @return 结果
     */
    public int deleteHkLmanagementInfoById(Long lmId);


    String checkLmNameUnique(String lmName,Long lmId);

    List<SysRole> queryLmRole(Long lmId);

    List<SysRegion> queryLmRegion(Long lmId);

    List<HkEClassification> queryLmEventType(Long lmId);

    List<Ztree> lmRegionTreeData(Long lmId);

    List<HkLmanagementInfo> queryLmByEvent(Long eventId);
}
