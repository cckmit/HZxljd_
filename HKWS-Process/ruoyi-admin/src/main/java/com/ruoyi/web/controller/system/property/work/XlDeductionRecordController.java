package com.ruoyi.web.controller.system.property.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.domain.property.XlDeductionRecord;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IXlPropertyEventService;
import com.ruoyi.system.service.property.IXlDeductionRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物业--考核扣分Controller
 *
 * @author ruoyi
 * @date 2021-05-26
 */
@Controller
@RequestMapping("/system/property/xldeductionrecord")
public class XlDeductionRecordController extends BaseController
{
    private String prefix = "system/property/xldeductionrecord";

    @Autowired
    private IXlDeductionRecordService xlDeductionRecordService;

    @Autowired
    private IXlPropertyEventService xlPropertyEventService;

    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system/property:xldeductionrecord:view")
    @GetMapping()
    public String xldeductionrecord()
    {
        return prefix + "/xldeductionrecord";
    }

    /**
     * 查询物业--考核扣分列表
     */
    @RequiresPermissions("system/property:xldeductionrecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlDeductionRecord xlDeductionRecord)
    {
        startPage();
        List<XlDeductionRecord> list = xlDeductionRecordService.selectXlDeductionRecordVoList(xlDeductionRecord);
        return getDataTable(list);
    }

    /**
     * 查看处理流程
     * @return
     */
    @GetMapping("/process/{id}")
    public String process(@PathVariable("id") Long id, ModelMap mmap){
        //查询扣分记录
        XlDeductionRecord xlDeductionRecord = xlDeductionRecordService.selectXlDeductionRecordVoById(id);
        XlPropertyEvent xlPropertyEvent = xlDeductionRecord.getXlPropertyEvent();
        //处理人信息
        SysUser user = userService.selectUserById(xlPropertyEvent.getHandlerId());
        mmap.put("xlPropertyEvent", xlPropertyEvent);
        mmap.put("user",user);
        return prefix + "/process";
    }
}
