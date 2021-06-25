package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRanks;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.service.ISysRegionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/region")
public class SysRegionController extends BaseController
{
    private String prefix = "system/region";

    @Autowired
    private ISysRegionService regionService;

    @RequiresPermissions("system:region:view")
    @GetMapping()
    public String region()
    {
        return prefix + "/region";
    }

    @RequiresPermissions("system:region:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysRegion> list(SysRegion region)
    {
        List<SysRegion> regionList = regionService.selectSysRegionList(region);
        return regionList;
    }

    /**
     * 新增区域
     * @param parentId
     * @param mmap
     * @return
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        mmap.put("region", regionService.selectSysRegionById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存区域信息
     * @param region
     * @return
     */
    @Log(title = "区域管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:region:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysRegion region)
    {
        if (UserConstants.REGION_NAME_NOT_UNIQUE.equals(regionService.checkRegionNameUnique(region)))
        {
            return error("新增区域'" + region.getRegionName() + "'失败，区域名称已存在");
        }
        region.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(regionService.insertSysRegion(region));
    }

    /**
     * 修改区域页面
     * @param regionId
     * @param mmap
     * @return
     */
    @GetMapping("/edit/{regionId}")
    public String edit(@PathVariable("regionId") Long regionId, ModelMap mmap)
    {
        SysRegion region = regionService.selectSysRegionById(regionId);
        if (StringUtils.isNotNull(region) && 100L == regionId)
        {
            region.setParentName("无");
        }
        mmap.put("region", region);
        return prefix + "/edit";
    }


    /**
     * 修改保存区域信息
     * @param region
     * @return
     */
    @Log(title = "区域管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:region:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysRegion region)
    {
        if (UserConstants.REGION_NAME_NOT_UNIQUE.equals(regionService.checkRegionNameUnique(region)))
        {
            return error("修改区域'" + region.getRegionName() + "'失败，区域名称已存在");
        }
        else if (region.getParentId().equals(region.getRegionId()))
        {
            return error("修改区域'" + region.getRegionName() + "'失败，上级区域不能是自己");
        }
        region.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(regionService.updateSysRegion(region));
    }

    /***
     *  删除区域信息
     * @param regionId
     * @return
     */
    @Log(title = "区域管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:region:remove")
    @GetMapping("/remove/{regionId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("regionId") Long regionId)
    {
        if (regionService.selectRegionCount(regionId) > 0)
        {
            return AjaxResult.warn("存在下级区域,不允许删除");
        }
        return toAjax(regionService.deleteSysRegionById(regionId));
    }

    /**
     * 校验区域名称
     */
    @PostMapping("/checkRegionNameUnique")
    @ResponseBody
    public String checkRegionNameUnique(SysRegion region)
    {
        return regionService.checkRegionNameUnique(region);
    }

    /**
     * 查询区域树
     * @param regionId
     * @param mmap
     * @return
     */
    @GetMapping("/selectRegionTree/{regionId}")
    public String selectRegionTree(@PathVariable("regionId") Long regionId, ModelMap mmap)
    {
        mmap.put("region", regionService.selectSysRegionById(regionId));
        return prefix + "/tree";
    }

    /**
     * 加载区域列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = regionService.selectRegionTree(new SysRegion());
        return ztrees;
    }

    /**
     * 获取其上一级区域
     * @param regionId
     * @return
     */
    @PostMapping("/queryParentRegionByRegionId")
    @ResponseBody
    public AjaxResult queryParentRegionByRegionId(@RequestParam(required = true) Long regionId)
    {
        return AjaxResult.success(regionService.queryParentRegionByRegionId(regionId));
    }

    /**
     * 获取其上一级区域
     * @return
     */
    @GetMapping("/queryRegionTree")
    @ResponseBody
    public AjaxResult queryRegionTree()
    {
        return AjaxResult.success(regionService.queryRegionTree());
    }

}
