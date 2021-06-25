package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.HkActionApply;
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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.service.IHkActionApplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
@Controller
@RequestMapping("/system/apply")
public class HkActionApplyController extends BaseController
{
    private String prefix = "system/apply";

    @Autowired
    private IHkActionApplyService hkActionApplyService;

    @RequiresPermissions("system:apply:view")
    @GetMapping()
    public String apply()
    {
        return prefix + "/apply";
    }

    /**
     * 查询申请列表
     */
    @RequiresPermissions("system:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkActionApply hkActionApply)
    {
        startPage();
        List<HkActionApply> list = hkActionApplyService.selectHkActionApplyList(hkActionApply);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:apply:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkActionApply hkActionApply)
    {
        List<HkActionApply> list = hkActionApplyService.selectHkActionApplyList(hkActionApply);
        ExcelUtil<HkActionApply> util = new ExcelUtil<HkActionApply>(HkActionApply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:apply:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkActionApply hkActionApply)
    {
        return toAjax(hkActionApplyService.insertHkActionApply(hkActionApply));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{acId}")
    public String edit(@PathVariable("acId") Long acId, ModelMap mmap)
    {
        HkActionApply hkActionApply = hkActionApplyService.selectHkActionApplyById(acId);
        mmap.put("hkActionApply", hkActionApply);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:apply:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkActionApply hkActionApply)
    {
        return toAjax(hkActionApplyService.updateHkActionApply(hkActionApply));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:apply:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkActionApplyService.deleteHkActionApplyByIds(ids));
    }
}
