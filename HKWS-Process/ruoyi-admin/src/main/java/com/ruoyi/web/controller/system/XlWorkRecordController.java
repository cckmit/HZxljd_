package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlWorkRecord;
import com.ruoyi.system.service.IXlRecordDetailService;
import com.ruoyi.system.service.IXlWorkRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网格员--工作检查记录Controller
 *
 * @author ruoyi
 * @date 2021-05-22
 */
@Api(tags="网格员--工作检查记录")
@Controller
@RequestMapping("/system/workRecord")
public class XlWorkRecordController extends BaseController
{
    private String prefix = "system/workRecord";

    @Autowired
    private IXlWorkRecordService xlWorkRecordService;
    @Autowired
    private IXlRecordDetailService xlRecordDetailService;

    @RequiresPermissions("system:workRecord:view")
    @GetMapping()
    public String workRecord()
    {
        return prefix + "/workRecord";
    }

    /**
     * 查询网格员--工作检查记录列表
     */
   // @RequiresPermissions("system:workRecord:list")
    @ApiOperation(value="工作检查记录列表", notes="工作检查记录列表")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlWorkRecord xlWorkRecord)
    {
        startPage();
        List<XlWorkRecord> list = xlWorkRecordService.selectXlWorkRecordList(xlWorkRecord);
        return getDataTable(list);
    }

    /**
     * 导出网格员--工作检查记录列表
     */
    @RequiresPermissions("system:workRecord:export")
    @Log(title = "网格员--工作检查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlWorkRecord xlWorkRecord)
    {
        List<XlWorkRecord> list = xlWorkRecordService.selectXlWorkRecordList(xlWorkRecord);
        ExcelUtil<XlWorkRecord> util = new ExcelUtil<XlWorkRecord>(XlWorkRecord.class);
        return util.exportExcel(list, "workRecord");
    }

    /**
     * 新增网格员--工作检查记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网格员--工作检查记录
     */
    @RequiresPermissions("system:workRecord:add")
    @Log(title = "网格员--工作检查记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlWorkRecord xlWorkRecord)
    {
        return toAjax(xlWorkRecordService.insertXlWorkRecord(xlWorkRecord));
    }

    /**
     * 修改网格员--工作检查记录
     */
    @GetMapping("/edit/{workId}")
    public String edit(@PathVariable("workId") Long workId, ModelMap mmap)
    {
        XlWorkRecord xlWorkRecord = xlWorkRecordService.selectXlWorkRecordById(workId);
        mmap.put("xlWorkRecord", xlWorkRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存网格员--工作检查记录
     */
    @RequiresPermissions("system:workRecord:edit")
    @Log(title = "网格员--工作检查记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlWorkRecord xlWorkRecord)
    {
        return toAjax(xlWorkRecordService.updateXlWorkRecord(xlWorkRecord));
    }

    /**
     * 删除网格员--工作检查记录
     */
    @RequiresPermissions("system:workRecord:remove")
    @Log(title = "网格员--工作检查记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlWorkRecordService.deleteXlWorkRecordByIds(ids));
    }

    /**
     * 根据记录id查询所有记录详情
     */
    @ApiOperation(value="工作检查记录详情", notes="工作检查记录详情")
    @GetMapping("/info/{workId}")
    public String detail(@PathVariable("workId") Long workId, ModelMap mmap)
    {
        XlWorkRecord workRecord = xlWorkRecordService.selectXlWorkRecordById(workId);
        List<XlWorkRecord> workRecordList = xlWorkRecordService.selectXlWorkRecordList(new XlWorkRecord());
        mmap.put("workRecord",workRecord);
        mmap.put("workRecordList",workRecordList);
        return "system/recordDetail/recordDetail";
    }

    /**
     * 根据记录id查询所有记录详情
     */
    @ApiOperation(value="工作检查记录详情", notes="工作检查记录详情")
    @PostMapping("/detail/{workId}")
    @ResponseBody
    public AjaxResult details(@PathVariable("workId") Long workId, ModelMap mmap)
    {
        return AjaxResult.success(xlWorkRecordService.selectXlWorkRecordById(workId));
    }

}
