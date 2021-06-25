package com.ruoyi.web.controller.system.property.event;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.property.XlCarPassRecord;
import com.ruoyi.system.service.property.IXlCarPassRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物业--车辆进出记录Controller
 *
 * @author ruoyi
 * @date 2021-06-09
 */
@Controller
@RequestMapping("/system/property/event/carpass")
public class XlCarPassRecordController extends BaseController
{
    private String prefix = "system/property/event/carpass";

    @Autowired
    private IXlCarPassRecordService xlCarPassRecordService;

    @RequiresPermissions("system/property/event:carpass:view")
    @GetMapping()
    public String carpass()
    {
        return prefix + "/carpass";
    }

    /**
     * 查询物业--车辆进出记录列表
     */
    @RequiresPermissions("system/property/event:carpass:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlCarPassRecord xlCarPassRecord)
    {
        startPage();
        List<XlCarPassRecord> list = xlCarPassRecordService.selectXlCarPassRecordList(xlCarPassRecord);
        return getDataTable(list);
    }
}
