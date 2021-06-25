package com.ruoyi.web.controller.system.property.work;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.property.XlPropertyAuditHouse;
import com.ruoyi.system.service.property.IXlPropertyAuditHouseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物业-房屋审核Controller
 *
 * @author ruoyi
 * @date 2021-05-26
 */
@Controller
@RequestMapping("/system/property/xlpropertyaudithouse")
public class XlPropertyAuditHouseController extends BaseController
{
    private String prefix = "system/property/xlpropertyaudithouse";

    @Autowired
    private IXlPropertyAuditHouseService xlPropertyAuditHouseService;

    @RequiresPermissions("system/property:xlpropertyaudithouse:view")
    @GetMapping()
    public String xlpropertyaudithouse()
    {
        return prefix + "/xlpropertyaudithouse";
    }

    /**
     * 查询物业-房屋审核列表
     */
    @RequiresPermissions("system/property:xlpropertyaudithouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPropertyAuditHouse xlPropertyAuditHouse)
    {
        startPage();
        List<XlPropertyAuditHouse> list = xlPropertyAuditHouseService.selectXlPropertyAuditHouseList(xlPropertyAuditHouse);
        return getDataTable(list);
    }

    /**
     * 审核房屋
     * @param auditId
     * @param mmap
     * @return
     */
    @GetMapping("/audit/{auditId}")
    public String audit(@PathVariable("auditId") Long auditId, ModelMap mmap){
        mmap.put("xlPropertyAuditHouse",xlPropertyAuditHouseService.selectXlPropertyAuditHouseById(auditId));
        return prefix + "/audit";
    }

    /**
     * 审核结果保存
     * @param xlPropertyAuditHouse
     * @return
     */
    @ResponseBody
    @PostMapping("/audit")
    public AjaxResult savaAudit(XlPropertyAuditHouse xlPropertyAuditHouse){
        return toAjax(xlPropertyAuditHouseService.updateXlPropertyAuditHouse(xlPropertyAuditHouse));
    }
}