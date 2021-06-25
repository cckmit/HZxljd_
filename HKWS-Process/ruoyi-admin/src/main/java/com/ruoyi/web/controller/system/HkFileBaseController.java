package com.ruoyi.web.controller.system;

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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HkFileBase;
import com.ruoyi.system.service.IHkFileBaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资料库Controller
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@Controller
@RequestMapping("/system/base")
public class HkFileBaseController extends BaseController
{
    private String prefix = "system/base";

    @Autowired
    private IHkFileBaseService hkFileBaseService;

    @RequiresPermissions("system:base:view")
    @GetMapping()
    public String base()
    {
        return prefix + "/base";
    }

    /**
     * 查询资料库列表
     */
    @RequiresPermissions("system:base:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkFileBase hkFileBase)
    {
        startPage();
        List<HkFileBase> list = hkFileBaseService.selectHkFileBaseList(hkFileBase);
        return getDataTable(list);
    }

    /**
     * 导出资料库列表
     */
    @RequiresPermissions("system:base:export")
    @Log(title = "资料库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkFileBase hkFileBase)
    {
        List<HkFileBase> list = hkFileBaseService.selectHkFileBaseList(hkFileBase);
        ExcelUtil<HkFileBase> util = new ExcelUtil<HkFileBase>(HkFileBase.class);
        return util.exportExcel(list, "base");
    }

    /**
     * 新增资料库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资料库
     */
    @RequiresPermissions("system:base:add")
    @Log(title = "资料库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkFileBase hkFileBase)
    {
        return toAjax(hkFileBaseService.insertHkFileBase(hkFileBase));
    }

    /**
     * 修改资料库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HkFileBase hkFileBase = hkFileBaseService.selectHkFileBaseById(id);
        mmap.put("hkFileBase", hkFileBase);
        return prefix + "/edit";
    }

    /**
     * 修改保存资料库
     */
    @RequiresPermissions("system:base:edit")
    @Log(title = "资料库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkFileBase hkFileBase)
    {
        return toAjax(hkFileBaseService.updateHkFileBase(hkFileBase));
    }

    /**
     * 删除资料库
     */
    @RequiresPermissions("system:base:remove")
    @Log(title = "资料库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkFileBaseService.deleteHkFileBaseByIds(ids));
    }
}
