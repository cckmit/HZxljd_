package com.ruoyi.web.controller.system.property.patrol;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.property.XlPropertyPatrolSchedule;
import com.ruoyi.system.service.property.IXlPropertyPatrolScheduleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物业-巡更排班Controller
 *
 * @author ruoyi
 * @date 2021-06-03
 */
@Controller
@RequestMapping("/system/property/patrol/schedule")
public class XlPropertyPatrolScheduleController extends BaseController
{
    private String prefix = "system/property/patrol/schedule";

    @Autowired
    private IXlPropertyPatrolScheduleService xlPropertyPatrolScheduleService;

    @RequiresPermissions("system/property/patrol:schedule:view")
    @GetMapping()
    public String schedule()
    {
        return prefix + "/schedule";
    }

    /**
     * 查询物业-巡更排班列表
     */
    @RequiresPermissions("system/property/patrol:schedule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyPatrolSchedule xlPropertyPatrolSchedule)
    {
        startPage();
        List<XlPropertyPatrolSchedule> list = xlPropertyPatrolScheduleService.selectXlPropertyPatrolScheduleList(xlPropertyPatrolSchedule);
        return getDataTable(list);
    }

    /**
     * 新增物业-巡更排班
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物业-巡更排班
     */
    @RequiresPermissions("system/property/patrol:schedule:add")
    @Log(title = "物业-巡更排班", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPropertyPatrolSchedule xlPropertyPatrolSchedule)
    {
        return toAjax(xlPropertyPatrolScheduleService.insertXlPropertyPatrolSchedule(xlPropertyPatrolSchedule));
    }

    /**
     * 修改物业-巡更排班
     */
    @GetMapping("/edit/{scheduleId}")
    public String edit(@PathVariable("scheduleId") Long scheduleId, ModelMap mmap)
    {
        XlPropertyPatrolSchedule xlPropertyPatrolSchedule = xlPropertyPatrolScheduleService.selectXlPropertyPatrolScheduleById(scheduleId);
        mmap.put("xlPropertyPatrolSchedule", xlPropertyPatrolSchedule);
        return prefix + "/edit";
    }

    /**
     * 修改保存物业-巡更排班
     */
    @RequiresPermissions("system/property/patrol:schedule:edit")
    @Log(title = "物业-巡更排班", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPropertyPatrolSchedule xlPropertyPatrolSchedule)
    {
        return toAjax(xlPropertyPatrolScheduleService.updateXlPropertyPatrolSchedule(xlPropertyPatrolSchedule));
    }

    /**
     * 删除物业-巡更排班
     */
    @RequiresPermissions("system/property/patrol:schedule:remove")
    @Log(title = "物业-巡更排班", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlPropertyPatrolScheduleService.deleteXlPropertyPatrolScheduleByIds(ids));
    }
}