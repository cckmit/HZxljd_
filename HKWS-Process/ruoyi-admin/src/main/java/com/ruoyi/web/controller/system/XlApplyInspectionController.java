package com.ruoyi.web.controller.system;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XlApplyInspection;
import com.ruoyi.system.service.IXlApplyInspectionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格管理-检查组应用Controller
 *
 * @author ruoyi
 * @date 2021-06-04
 */
@Controller
@RequestMapping("/system/applyInspection")
public class XlApplyInspectionController extends BaseController {
    private String prefix = "system/applyInspection";

    @Autowired
    private IXlApplyInspectionService xlApplyInspectionService;

    @RequiresPermissions("system:apaplyInspection:view")
    @GetMapping()
    public String ApplyInspection() {
        return prefix + "/applyInspection";
    }

    /**
     * 查询网格管理-检查组应用列表
     */
    @RequiresPermissions("system:applyInspection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlApplyInspection xlApplyInspection) {
        startPage();
        List<XlApplyInspection> list = xlApplyInspectionService.selectXlApplyInspectionList(xlApplyInspection);
        return getDataTable(list);
    }

    /**
     * 导出网格管理-检查组应用列表
     */
    @RequiresPermissions("system:applyInspection:export")
    @Log(title = "网格管理-检查组应用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlApplyInspection xlApplyInspection) {
        List<XlApplyInspection> list = xlApplyInspectionService.selectXlApplyInspectionList(xlApplyInspection);
        ExcelUtil<XlApplyInspection> util = new ExcelUtil<XlApplyInspection>(XlApplyInspection.class);
        return util.exportExcel(list, "ApplyInspection");
    }

    /**
     * 新增网格管理-检查组应用
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存网格管理-检查组应用
     */
    @RequiresPermissions("system:applyInspection:add")
    @Log(title = "网格管理-检查组应用", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("inspectionId") Long inspectionId, @RequestParam("ids[]") String[] ids, @RequestParam("status") Integer status) {
        if (ids.length != 0) {
            for (String id : ids) {
                XlApplyInspection xlApplyInspection = new XlApplyInspection();
                xlApplyInspection.setThingId(id);
                xlApplyInspection.setInspectionId(inspectionId);
                xlApplyInspection.setStatus(status);
                xlApplyInspectionService.insertXlApplyInspection(xlApplyInspection);
            }
            return AjaxResult.success("操作成功");//success
        } else return AjaxResult.error("操作失败,请重试");//error

    }

    /**
     * 修改网格管理-检查组应用
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        XlApplyInspection xlApplyInspection = xlApplyInspectionService.selectXlApplyInspectionById(id);
        mmap.put("xlApplyInspection", xlApplyInspection);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格管理-检查组应用
     */
    @RequiresPermissions("system:applyInspection:edit")
    @Log(title = "网格管理-检查组应用", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlApplyInspection xlApplyInspection) {
        return toAjax(xlApplyInspectionService.updateXlApplyInspection(xlApplyInspection));
    }

    /**
     * 删除网格管理-检查组应用
     */
    @RequiresPermissions("system:applyInspection:remove")
    @Log(title = "网格管理-检查组应用", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlApplyInspectionService.deleteXlApplyInspectionByIds(ids));
    }
}
