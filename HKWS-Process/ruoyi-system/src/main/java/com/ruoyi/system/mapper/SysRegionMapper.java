package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.HkEarlyWarning.RegionChangeVO;
import com.ruoyi.system.domain.HkEarlyWarning.RegionLoadVO;
import com.ruoyi.system.domain.SysRegion;
import org.apache.ibatis.annotations.Param;

/**
 * 区域Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public interface SysRegionMapper 
{
    /**
     * 查询区域
     * 
     * @param deptId 区域ID
     * @return 区域
     */
    public SysRegion selectSysRegionById(Long deptId);


    int selectRegionCount(SysRegion sysRegion);
    /**
     * 校验区域名称是否唯一
     * @param regionName 区域名称
     * @param parentId 父区域ID
     * @return 结果
     */
    public SysRegion checkRegionNameUnique(@Param("regionName") String regionName, @Param("parentId") Long parentId);

    /**
     * 查询区域列表
     * 
     * @param sysRegion 区域
     * @return 区域集合
     */
    public List<SysRegion> selectSysRegionList(SysRegion sysRegion);

    /**
     * 新增区域
     * 
     * @param sysRegion 区域
     * @return 结果
     */
    public int insertSysRegion(SysRegion sysRegion);

    /**
     * 修改区域
     * 
     * @param sysRegion 区域
     * @return 结果
     */
    public int updateSysRegion(SysRegion sysRegion);

    /**
     * 删除区域
     * 
     * @param deptId 区域ID
     * @return 结果
     */
    public int deleteSysRegionById(Long deptId);

    /**
     * 批量删除区域
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRegionByIds(String[] deptIds);

    List<SysRegion> findSysRegionList();

    /**
     * 获取其上一级区域
     * @param deptId 部门Id
     */
    Long queryParentRegionByRegionId(Long deptId);

    int queryRegionCountByParam(Map<String, Object> param);

    List<String> queryRegionAncestorsByRegion(Integer regionId);

    /**
     * @param params
     * @return
     */
    List<RegionChangeVO> queryRegionChange(Map<String, Object> params);

    List<RegionLoadVO> queryRegionLoad(Map<String, Object> params);
    /**查询区域下职能的用户数量**/
    List<RegionLoadVO> queryUserCountByRegion(Map<String, Object> params);


    List<SysRegion> queryRegionNames();

    List<Map<String,Object>> getRanksCountByRegion();
    //查询村社总数
    int queryVillageCommunity();
    // 网格总数
    int queryGridALl();

    List<SysRegion> selectRegionList();

    public String queryCommunityName(String deptId);

    //查询社区
    List<SysRegion> queryCommunitList(SysRegion sysRegion);
    //查询网格
    List<SysRegion> queryCommunitWangList(SysRegion sysRegion);

    List<SysRegion> queryGrilName(SysRegion sysRegion);
    //查询所有网格
    List<SysRegion> queryCommunitWangListAll(SysRegion sysRegion);
}
