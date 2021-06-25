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
import com.ruoyi.system.domain.XlEquipmentInfo;
import com.ruoyi.system.service.IXlEquipmentInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公共管理/物业--设备信息Controller
 *
 * @author ruoyi
 * @date 2021-05-18
 */
@Controller
@RequestMapping("/system/equipmentInfo")
public class XlEquipmentInfoController extends BaseController
{
    private String prefix = "system/equipmentInfo";

    @Autowired
    private IXlEquipmentInfoService xlEquipmentInfoService;

    @RequiresPermissions("system:equipmentInfo:view")
    @GetMapping()
    public String equipmentInfo()
    {
        return prefix + "/equipmentInfo";
    }

    /**
     * 查询公共管理/物业--设备信息列表
     */
    @RequiresPermissions("system:equipmentInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlEquipmentInfo xlEquipmentInfo)
    {
        startPage();
        List<XlEquipmentInfo> list = xlEquipmentInfoService.selectXlEquipmentInfoList(xlEquipmentInfo);
        return getDataTable(list);
    }

    /**
     * 导出公共管理/物业--设备信息列表
     */
    @RequiresPermissions("system:equipmentInfo:export")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlEquipmentInfo xlEquipmentInfo)
    {
        List<XlEquipmentInfo> list = xlEquipmentInfoService.selectXlEquipmentInfoList(xlEquipmentInfo);
        ExcelUtil<XlEquipmentInfo> util = new ExcelUtil<XlEquipmentInfo>(XlEquipmentInfo.class);
        return util.exportExcel(list, "equipmentInfo");
    }

    /**
     * 新增公共管理/物业--设备信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公共管理/物业--设备信息
     */
    @RequiresPermissions("system:equipmentInfo:add")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlEquipmentInfo xlEquipmentInfo)
    {
        return toAjax(xlEquipmentInfoService.insertXlEquipmentInfo(xlEquipmentInfo));
    }

    /**
     * 修改公共管理/物业--设备信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlEquipmentInfo xlEquipmentInfo = xlEquipmentInfoService.selectXlEquipmentInfoById(id);
        mmap.put("xlEquipmentInfo", xlEquipmentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存公共管理/物业--设备信息
     */
    @RequiresPermissions("system:equipmentInfo:edit")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlEquipmentInfo xlEquipmentInfo)
    {
        return toAjax(xlEquipmentInfoService.updateXlEquipmentInfo(xlEquipmentInfo));
    }

    /**
     * 删除公共管理/物业--设备信息
     */
    @RequiresPermissions("system:equipmentInfo:remove")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlEquipmentInfoService.deleteXlEquipmentInfoByIds(ids));
    }
}
