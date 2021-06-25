package com.ruoyi.web.controller.system.honey;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.honey.XlMemorandum;
import com.ruoyi.system.service.honey.IXlMemorandumService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网格移动端--备忘录Controller
 *
 * @author ruoyi
 * @date 2021-06-10
 */
@Controller
@RequestMapping("/system/memorandum")
public class XlMemorandumController extends BaseController
{
    private String prefix = "system/memorandum";

    @Autowired
    private IXlMemorandumService xlMemorandumService;

    @RequiresPermissions("system:memorandum:view")
    @GetMapping()
    public String memorandum()
    {
        return prefix + "/memorandum";
    }

    /**
     * 查询网格移动端--备忘录列表
     */
  //  @RequiresPermissions("system:memorandum:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlMemorandum xlMemorandum)
    {
        startPage();
        List<XlMemorandum> list = xlMemorandumService.selectXlMemorandumList(xlMemorandum);
        return getDataTable(list);
    }

    /**
     * 导出网格移动端--备忘录列表
     */
    @RequiresPermissions("system:memorandum:export")
    @Log(title = "网格移动端--备忘录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlMemorandum xlMemorandum)
    {
        List<XlMemorandum> list = xlMemorandumService.selectXlMemorandumList(xlMemorandum);
        ExcelUtil<XlMemorandum> util = new ExcelUtil<XlMemorandum>(XlMemorandum.class);
        return util.exportExcel(list, "memorandum");
    }

    /**
     * 新增网格移动端--备忘录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网格移动端--备忘录
     */
//    @RequiresPermissions("system:memorandum:add")
    @Log(title = "网格移动端--备忘录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlMemorandum xlMemorandum)
    {
        return toAjax(xlMemorandumService.insertXlMemorandum(xlMemorandum));
    }

    /**
     * 修改网格移动端--备忘录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlMemorandum xlMemorandum = xlMemorandumService.selectXlMemorandumById(id);
        mmap.put("xlMemorandum", xlMemorandum);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格移动端--备忘录
     */
//    @RequiresPermissions("system:memorandum:edit")
    @Log(title = "网格移动端--备忘录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlMemorandum xlMemorandum)
    {
        return toAjax(xlMemorandumService.updateXlMemorandum(xlMemorandum));
    }

    /**
     * 删除网格移动端--备忘录
     */
   // @RequiresPermissions("system:memorandum:remove")
    @Log(title = "网格移动端--备忘录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlMemorandumService.deleteXlMemorandumByIds(ids));
    }
}
