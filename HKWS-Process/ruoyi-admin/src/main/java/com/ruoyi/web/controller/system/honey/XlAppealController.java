package com.ruoyi.web.controller.system.honey;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.honey.XlAppeal;
import com.ruoyi.system.service.honey.IXlAppealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网格员--申诉Controller
 *
 * @author ruoyi
 * @date 2021-05-28
 */
@Api(tags="考核申述")
@Controller
@RequestMapping("/system/appeal")
public class XlAppealController extends BaseController
{
    private String prefix = "system/appeal";

    @Autowired
    private IXlAppealService xlAppealService;

    @RequiresPermissions("system:appeal:view")
    @GetMapping()
    public String appeal()
    {
        return "system/honey/appeal/appeal";
    }

    /**
     * 查询网格员--申诉列表
     */
    //@RequiresPermissions("system:appeal:list")
    @ApiOperation(value="申诉列表查询", notes="申诉列表查询")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlAppeal xlAppeal)
    {
        startPage();
        List<XlAppeal> list = xlAppealService.selectXlAppealList(xlAppeal);
        return getDataTable(list);
    }

    /**
     * 导出网格员--申诉列表
     */
    @RequiresPermissions("system:appeal:export")
    @Log(title = "网格员--申诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlAppeal xlAppeal)
    {
        List<XlAppeal> list = xlAppealService.selectXlAppealList(xlAppeal);
        ExcelUtil<XlAppeal> util = new ExcelUtil<XlAppeal>(XlAppeal.class);
        return util.exportExcel(list, "appeal");
    }

    /**
     * 新增网格员--申诉
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网格员--申诉
     */
 //   @RequiresPermissions("system:appeal:add")
    @ApiOperation(value="网格员--申诉新增", notes="网格员--申诉新增")
    @Log(title = "网格员--申诉", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlAppeal xlAppeal)
    {
        return toAjax(xlAppealService.insertXlAppeal(xlAppeal));
    }

    /**
     * 修改网格员--申诉
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlAppeal xlAppeal = xlAppealService.selectXlAppealById(id);
        mmap.put("xlAppeal", xlAppeal);
        return "system/honey/appeal/edit";
    }

    /**
     * 修改保存网格员--申诉
     */
    @RequiresPermissions("system:appeal:edit")
    @Log(title = "网格员--申诉", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlAppeal xlAppeal)
    {
        return toAjax(xlAppealService.updateXlAppeal(xlAppeal));
    }

    /**
     * 删除网格员--申诉
     */
    @RequiresPermissions("system:appeal:remove")
    @Log(title = "网格员--申诉", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlAppealService.deleteXlAppealByIds(ids));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id, ModelMap mmap){
        XlAppeal xlAppeal =xlAppealService.selectXlAppealById(id);
        mmap.put("xlAppeal", xlAppeal);
        return "system/honey/appeal/detail";
    }
}
