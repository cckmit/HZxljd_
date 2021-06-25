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
import com.ruoyi.system.domain.XlRecordDetail;
import com.ruoyi.system.service.IXlRecordDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网格管理-工作记录关联详情Controller
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
@Controller
@RequestMapping("/system/recordDetail")
public class XlRecordDetailController extends BaseController
{
    private String prefix = "system/recordDetail";

    @Autowired
    private IXlRecordDetailService xlRecordDetailService;

    @RequiresPermissions("system:recordDetail:view")
    @GetMapping()
    public String recordDetail()
    {
        return prefix + "/recordDetail";
    }

    /**
     * 查询网格管理-工作记录关联详情列表
     */
    @RequiresPermissions("system:recordDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlRecordDetail xlRecordDetail)
    {
        startPage();
        List<XlRecordDetail> list = xlRecordDetailService.selectXlRecordDetailList(xlRecordDetail);
        return getDataTable(list);
    }

    /**
     * 导出网格管理-工作记录关联详情列表
     */
    @RequiresPermissions("system:recordDetail:export")
    @Log(title = "网格管理-工作记录关联详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlRecordDetail xlRecordDetail)
    {
        List<XlRecordDetail> list = xlRecordDetailService.selectXlRecordDetailList(xlRecordDetail);
        ExcelUtil<XlRecordDetail> util = new ExcelUtil<XlRecordDetail>(XlRecordDetail.class);
        return util.exportExcel(list, "recordDetail");
    }

    /**
     * 新增网格管理-工作记录关联详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网格管理-工作记录关联详情
     */
    @RequiresPermissions("system:recordDetail:add")
    @Log(title = "网格管理-工作记录关联详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlRecordDetail xlRecordDetail)
    {
        return toAjax(xlRecordDetailService.insertXlRecordDetail(xlRecordDetail));
    }

    /**
     * 修改网格管理-工作记录关联详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlRecordDetail xlRecordDetail = xlRecordDetailService.selectXlRecordDetailById(id);
        mmap.put("xlRecordDetail", xlRecordDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格管理-工作记录关联详情
     */
    @RequiresPermissions("system:recordDetail:edit")
    @Log(title = "网格管理-工作记录关联详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlRecordDetail xlRecordDetail)
    {
        return toAjax(xlRecordDetailService.updateXlRecordDetail(xlRecordDetail));
    }

    /**
     * 删除网格管理-工作记录关联详情
     */
    @RequiresPermissions("system:recordDetail:remove")
    @Log(title = "网格管理-工作记录关联详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlRecordDetailService.deleteXlRecordDetailByIds(ids));
    }
}
