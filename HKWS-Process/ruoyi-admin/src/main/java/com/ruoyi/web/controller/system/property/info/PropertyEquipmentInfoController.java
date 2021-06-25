package com.ruoyi.web.controller.system.property.info;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.XlEquipmentInfo;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.service.IXlEquipmentInfoService;
import com.ruoyi.system.service.IXlVillageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Riley
 * Date: 2021/5/25
 * Description:
 */
@Controller
@RequestMapping("/system/property/xlequipmentinfo")
public class PropertyEquipmentInfoController extends BaseController {

    private String prefix = "system/property/xlequipmentinfo";

    @Autowired
    private IXlEquipmentInfoService xlEquipmentInfoService;

    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system/property:xlequipmentinfo:view")
    @GetMapping()
    public String xlequipmentinfo() {
        return prefix + "/xlequipmentinfo";
    }

    /**
     * 查询公共管理/物业--设备信息列表
     */
    @RequiresPermissions("system/property:xlequipmentinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlEquipmentInfo xlEquipmentInfo) {
        startPage();
        //物业公司用户只能查看自己小区的信息
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        xlEquipmentInfo.setVillageId(villageId);
        List<XlEquipmentInfo> list = xlEquipmentInfoService.selectXlEquipmentInfoList(xlEquipmentInfo);
        return getDataTable(list);
    }

    /**
     * 新增公共管理/物业--设备信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        return prefix + "/add";
    }

    /**
     * 新增保存公共管理/物业--设备信息
     */
    @RequiresPermissions("system/property:xlequipmentinfo:add")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlEquipmentInfo xlEquipmentInfo) {
        //小区
        xlEquipmentInfo.setVillageId(ShiroUtils.getSysUser().getDeptId());
        return toAjax(xlEquipmentInfoService.insertXlEquipmentInfo(xlEquipmentInfo));
    }

    /**
     * 修改公共管理/物业--设备信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        XlEquipmentInfo xlEquipmentInfo = xlEquipmentInfoService.selectXlEquipmentInfoById(id);
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        mmap.put("xlEquipmentInfo", xlEquipmentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存公共管理/物业--设备信息
     */
    @RequiresPermissions("system/property:xlequipmentinfo:edit")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlEquipmentInfo xlEquipmentInfo) {
        return toAjax(xlEquipmentInfoService.updateXlEquipmentInfo(xlEquipmentInfo));
    }

    /**
     * 删除公共管理/物业--设备信息
     */
    @RequiresPermissions("system/property:xlequipmentinfo:remove")
    @Log(title = "公共管理/物业--设备信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlEquipmentInfoService.deleteXlEquipmentInfoByIds(ids));
    }
}