package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.XlSubdivide;
import com.ruoyi.system.service.IXlSubdivideService;
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
import com.ruoyi.system.domain.XlAssessmentItems;
import com.ruoyi.system.service.IXlAssessmentItemsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格员--考核项Controller
 * 
 * @author ruoyi
 * @date 2021-06-01
 */
@Controller
@RequestMapping("/system/societyManage/assessmentManage/assessmentItems")
public class XlAssessmentItemsController extends BaseController
{
    private String prefix = "system/societyManage/assessmentManage/assessmentItems";

    @Autowired
    private IXlAssessmentItemsService xlAssessmentItemsService;
    @Autowired
    private IXlSubdivideService subdivideService;

    @RequiresPermissions("system:assessmentItems:view")
    @GetMapping()
    public String assessmentItems()
    {
        return prefix + "/assessmentItems";
    }

    /**
     * 查询网格员--考核项列表
     */
    @RequiresPermissions("system:assessmentItems:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlAssessmentItems xlAssessmentItems)
    {
        startPage();
        List<XlAssessmentItems> list = xlAssessmentItemsService.selectXlAssessmentItemsList(xlAssessmentItems);
        return getDataTable(list);
    }

    /**
     * 导出网格员--考核项列表
     */
    @RequiresPermissions("system:assessmentItems:export")
    @Log(title = "网格员--考核项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlAssessmentItems xlAssessmentItems)
    {
        List<XlAssessmentItems> list = xlAssessmentItemsService.selectXlAssessmentItemsList(xlAssessmentItems);
        ExcelUtil<XlAssessmentItems> util = new ExcelUtil<XlAssessmentItems>(XlAssessmentItems.class);
        return util.exportExcel(list, "assessmentItems");
    }

    /**
     * 新增网格员--考核项
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网格员--考核项
     */
    @RequiresPermissions("system:assessmentItems:add")
    @Log(title = "网格员--考核项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlAssessmentItems xlAssessmentItems)
    {
        return toAjax(xlAssessmentItemsService.insertXlAssessmentItems(xlAssessmentItems));
    }

    /**
     * 修改网格员--考核项
     */
    @GetMapping("/edit/{assessmentId}")
    public String edit(@PathVariable("assessmentId") Long assessmentId, ModelMap mmap)
    {
        XlAssessmentItems xlAssessmentItems = xlAssessmentItemsService.selectXlAssessmentItemsById(assessmentId);
        mmap.put("xlAssessmentItems", xlAssessmentItems);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格员--考核项
     */
    @RequiresPermissions("system:assessmentItems:edit")
    @Log(title = "网格员--考核项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlAssessmentItems xlAssessmentItems)
    {
        return toAjax(xlAssessmentItemsService.updateXlAssessmentItems(xlAssessmentItems));
    }

    /**
     * 考核项详情页面
     */
    @GetMapping("/detail/{assessmentId}")
    public String detail(@PathVariable("assessmentId") Long assessmentId, ModelMap mmap){
        XlAssessmentItems xlAssessmentItems = xlAssessmentItemsService.selectXlAssessmentItemsById(assessmentId);
        List<XlSubdivide> subdivides = subdivideService.selectXlSubdivideByAssessmentId(assessmentId);
        mmap.put("xlAssessmentItems", xlAssessmentItems);
        mmap.put("subdivides", subdivides);
        return prefix + "/detail";
    }

    /**
     * 删除网格员--考核项
     */
    @RequiresPermissions("system:assessmentItems:remove")
    @Log(title = "网格员--考核项", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlAssessmentItemsService.deleteXlAssessmentItemsByIds(ids));
    }
}
