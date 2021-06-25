package com.ruoyi.web.controller.system.property.event;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.property.XlPersonPassRecord;
import com.ruoyi.system.service.property.IXlPersonPassRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物业--人员进出记录Controller
 *
 * @author ruoyi
 * @date 2021-06-09
 */
@Controller
@RequestMapping("/system/property/event/personpass")
public class XlPersonPassRecordController extends BaseController
{
    private String prefix = "system/property/event/personpass";

    @Autowired
    private IXlPersonPassRecordService xlPersonPassRecordService;

    @RequiresPermissions("system/property/event:personpass:view")
    @GetMapping()
    public String personpass()
    {
        return prefix + "/personpass";
    }

    /**
     * 查询物业--人员进出记录列表
     */
    @RequiresPermissions("system/property/event:personpass:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPersonPassRecord xlPersonPassRecord)
    {
        startPage();
        List<XlPersonPassRecord> list = xlPersonPassRecordService.selectXlPersonPassRecordList(xlPersonPassRecord);
        return getDataTable(list);
    }
}
