package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.XlAppealRecord;
import com.ruoyi.system.service.IXlAppealRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 居民/物业--申诉Controller
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Api(tags="居民/物业--申诉列表")
@Controller
@RequestMapping("/system/appealRecord")
public class XlAppealRecordController extends BaseController
{
    private String prefix = "system/appealRecord";

    @Autowired
    private IXlAppealRecordService xlAppealRecordService;

    @RequiresPermissions("system:appealRecord:view")
    @GetMapping()
    public String appealRecord()
    {
        return prefix + "/appealRecord";
    }

    /**
     * 查询居民/物业--申诉列表
     */
 //   @RequiresPermissions("system:appealRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlAppealRecord xlAppealRecord)
    {
        startPage();
        List<XlAppealRecord> list = xlAppealRecordService.selectXlAppealRecordList(xlAppealRecord);
        return getDataTable(list);
    }

    /**
     * 导出居民/物业--申诉列表
     */
    @RequiresPermissions("system:appealRecord:export")
    @Log(title = "居民/物业--申诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlAppealRecord xlAppealRecord)
    {
        List<XlAppealRecord> list = xlAppealRecordService.selectXlAppealRecordList(xlAppealRecord);
        ExcelUtil<XlAppealRecord> util = new ExcelUtil<XlAppealRecord>(XlAppealRecord.class);
        return util.exportExcel(list, "appealRecord");
    }

    /**
     * 新增居民/物业--申诉
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存居民/物业--申诉
     */
 //   @RequiresPermissions("system:appealRecord:add")
    @Log(title = "居民/物业--申诉", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlAppealRecord xlAppealRecord)
    {
        return toAjax(xlAppealRecordService.insertXlAppealRecord(xlAppealRecord));
    }

    /**
     * 修改居民/物业--申诉
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlAppealRecord xlAppealRecord = xlAppealRecordService.selectXlAppealRecordById(id);
        mmap.put("xlAppealRecord", xlAppealRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存居民/物业--申诉
     */
    @ApiOperation(value="居民/物业--申诉", notes="居民/物业--申诉")
//    @RequiresPermissions("system:appealRecord:edit")
    @Log(title = "居民/物业--申诉", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlAppealRecord xlAppealRecord)
    {
        if(xlAppealRecord.getAppealPerson()!=null&&xlAppealRecord.getAppealPerson()!="") {
            xlAppealRecord.setAppealStage("单方申诉");
        }
         if (xlAppealRecord.getAppealProperty()!=null&&xlAppealRecord.getAppealProperty()!="") {
             xlAppealRecord.setAppealStage("双方申诉");
         }
         if (xlAppealRecord.getAppealResult()!=null&&xlAppealRecord.getAppealResult()!=""){
             xlAppealRecord.setAppealStage("判定完成");
         }

        return toAjax(xlAppealRecordService.updateXlAppealRecord(xlAppealRecord));
    }

    /**
     * 删除居民/物业--申诉
     */
    @RequiresPermissions("system:appealRecord:remove")
    @Log(title = "居民/物业--申诉", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlAppealRecordService.deleteXlAppealRecordByIds(ids));
    }

    @RequiresPermissions("system:appealRecord:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")String id, ModelMap mmap){
        XlAppealRecord xlAppealRecord =xlAppealRecordService.selectXlAppealRecordById(Long.valueOf(id));
        mmap.put("xlAppealRecord", xlAppealRecord);
        return prefix + "/details";
    }
}
