package com.ruoyi.quartz.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.quartz.domain.HkSourceFieldFilter;
import com.ruoyi.quartz.service.IHkSourceFieldFilterService;

/**
 * 条件Controller
 * 
 * @author ruoyi
 * @date 2021-01-22
 */
@Controller
@RequestMapping("/source/filter")
public class HkSourceFieldFilterController extends BaseController
{

    @Autowired
    private IHkSourceFieldFilterService hkSourceFieldFilterService;

    /**
     * 查询条件列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkSourceFieldFilter hkSourceFieldFilter)
    {
        List<HkSourceFieldFilter> list = hkSourceFieldFilterService.selectHkSourceFieldFilterList(hkSourceFieldFilter);
        return getDataTable(list);
    }

    /**
     * 导出条件列表
     */
    @RequiresPermissions("system:filter:export")
    @Log(title = "条件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkSourceFieldFilter hkSourceFieldFilter)
    {
        List<HkSourceFieldFilter> list = hkSourceFieldFilterService.selectHkSourceFieldFilterList(hkSourceFieldFilter);
        ExcelUtil<HkSourceFieldFilter> util = new ExcelUtil<HkSourceFieldFilter>(HkSourceFieldFilter.class);
        return util.exportExcel(list, "filter");
    }

    /**
     * 新增保存条件
     */
    @RequiresPermissions("system:filter:add")
    @Log(title = "条件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkSourceFieldFilter hkSourceFieldFilter)
    {
        return toAjax(hkSourceFieldFilterService.insertHkSourceFieldFilter(hkSourceFieldFilter));
    }


    /**
     * 修改保存条件
     */
    @RequiresPermissions("system:filter:edit")
    @Log(title = "条件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkSourceFieldFilter hkSourceFieldFilter)
    {
        return toAjax(hkSourceFieldFilterService.updateHkSourceFieldFilter(hkSourceFieldFilter));
    }

    /**
     * 删除条件
     */
    @RequiresPermissions("system:filter:remove")
    @Log(title = "条件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkSourceFieldFilterService.deleteHkSourceFieldFilterByIds(ids));
    }
}
