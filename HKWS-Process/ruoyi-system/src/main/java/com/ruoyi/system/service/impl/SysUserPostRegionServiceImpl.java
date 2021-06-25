package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysUserPostRegion;
import com.ruoyi.system.mapper.SysUserPostRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.ISysUserPostRegionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户岗位区域中间Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-28
 */
@Service
public class SysUserPostRegionServiceImpl implements ISysUserPostRegionService
{
    @Autowired
    private SysUserPostRegionMapper sysUserPostRegionMapper;

    /**
     * 根据用户id查询对应的岗位和区域
     * 
     * @param userId
     * @return 用户岗位区域
     */
    @Override
    public List<SysUserPostRegion> selectSysUserPostRegionById(Long userId)
    {
        return sysUserPostRegionMapper.selectSysUserPostRegionById(userId);
    }

    /**
     * 查询用户岗位区域中间列表
     * 
     * @param sysUserPostRegion 用户岗位区域中间
     * @return 用户岗位区域中间
     */
    @Override
    public List<SysUserPostRegion> selectSysUserPostRegionList(SysUserPostRegion sysUserPostRegion)
    {
        return sysUserPostRegionMapper.selectSysUserPostRegionList(sysUserPostRegion);
    }

    /**
     * 新增用户岗位区域中间
     * 
     * @param sysUserPostRegion 用户岗位区域中间
     * @return 结果
     */
    @Override
    public int insertSysUserPostRegion(SysUserPostRegion sysUserPostRegion)
    {
        return sysUserPostRegionMapper.insertSysUserPostRegion(sysUserPostRegion);
    }

    /**
     * 修改用户岗位区域中间
     * 
     * @param sysUserPostRegion 用户岗位区域中间
     * @return 结果
     */
    @Override
    public int updateSysUserPostRegion(SysUserPostRegion sysUserPostRegion)
    {
        return sysUserPostRegionMapper.updateSysUserPostRegion(sysUserPostRegion);
    }

    /**
     * 删除用户岗位区域中间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUserPostRegionByIds(String ids)
    {
        return sysUserPostRegionMapper.deleteSysUserPostRegionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户岗位区域中间信息
     * 
     * @param userId 用户岗位区域中间ID
     * @return 结果
     */
    @Override
    public int deleteSysUserPostRegionById(Long userId)
    {
        return sysUserPostRegionMapper.deleteSysUserPostRegionById(userId);
    }
}
