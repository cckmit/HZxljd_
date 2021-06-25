package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.HkEarlyWarning.RegionChangeVO;
import com.ruoyi.system.domain.HkEarlyWarning.RegionLoadVO;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.dto.RegionDto;

/**
 * 区域Service接口
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
public interface ISysRegionService 
{
    /**
     * 查询区域
     * 
     * @param regionId 区域ID
     * @return 区域
     */
    public SysRegion selectSysRegionById(Long regionId);

    int selectRegionCount(Long parentId);

    List<Ztree> selectRegionTree(SysRegion region);

    String checkRegionNameUnique(SysRegion region);
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
     * 批量删除区域
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRegionByIds(String ids);

    /**
     * 删除区域信息
     * 
     * @param regionId 区域ID
     * @return 结果
     */
    public int deleteSysRegionById(Long regionId);

    List<SysRegion> findSysRegionList();

    List<Map<String,Object>> getSomeRegionNoUser();

    /**
     * 获取其上一级区域
     * @param regionId 部门Id
     */
    Long queryParentRegionByRegionId(Long regionId);

    String queryRegionAncestorsByRegion(Integer regionId);

    List<RegionDto> queryRegionTree();

    int queryRegionCountByParam(Map<String,Object> param);

    List<RegionChangeVO> queryRegionChange(Map<String, Object> params);

    List<RegionLoadVO> queryRegionLoad(Map<String, Object> params);

    List<SysRegion> queryRegionNames();
    //查询村社总数
    int queryVillageCommunity();
    //网格总数
    int queryGridALl();

    //查询所有网格信息
    public List<SysRegion> selectRegionList();

    //根据网格id查询所属社区名称
    public String queryCommunityName(String deptId);
    //查询社区
    List<SysRegion> queryCommunitList(SysRegion sysRegion);
    //查询社区
    List<SysRegion> queryCommunitWangList(SysRegion sysRegion);
    //查询网格
    List<SysRegion> queryGrilName(SysRegion sysRegion);
    //查询所有的网格
    List<SysRegion> queryCommunitWangListAll(SysRegion sysRegion);
}
