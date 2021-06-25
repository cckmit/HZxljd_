package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.HkEntity.UserPostRegionVo;
import com.ruoyi.system.domain.SysUserPostRegion;

/**
 * 用户岗位区域中间Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-28
 */
public interface SysUserPostRegionMapper
{
    /**
     * 查询用户岗位区域中间
     * 
     * @param userId 用户岗位区域中间ID
     * @return 用户岗位区域中间
     */
    public List<SysUserPostRegion> selectSysUserPostRegionById(Long userId);

    /**
     * 查询用户岗位区域中间列表
     * 
     * @param sysUserPostRegion 用户岗位区域中间
     * @return 用户岗位区域中间集合
     */
    public List<SysUserPostRegion> selectSysUserPostRegionList(SysUserPostRegion sysUserPostRegion);

    /**
     * 新增用户岗位区域中间
     * 
     * @param sysUserPostRegion 用户岗位区域中间
     * @return 结果
     */
    public int insertSysUserPostRegion(SysUserPostRegion sysUserPostRegion);

    /**
     * 修改用户岗位区域中间
     * 
     * @param sysUserPostRegion 用户岗位区域中间
     * @return 结果
     */
    public int updateSysUserPostRegion(SysUserPostRegion sysUserPostRegion);

    /**
     * 删除用户岗位区域中间
     * 
     * @param userId 用户岗位区域中间ID
     * @return 结果
     */
    public int deleteSysUserPostRegionById(Long userId);

    /**
     * 批量删除用户岗位区域中间
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserPostRegionByIds(String[] userIds);


    public List<String> selectPostIdByUserId(Long userId);

    List<UserPostRegionVo> queryUserPostRegionInfo(Long userId);
}
