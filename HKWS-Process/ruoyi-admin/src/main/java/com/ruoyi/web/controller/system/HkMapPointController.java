package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.HkMapPoint;
import com.ruoyi.system.service.IHkMapPointService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备地图点位Controller
 *
 * @author guohailong
 * @date 2021-04-12
 */
@Controller
@RequestMapping("/system/device")
public class HkMapPointController extends BaseController {
    private String prefix = "system/device";

    @Autowired
    private IHkMapPointService hkMapPointService;

    @RequiresPermissions("system:device:view")
    @GetMapping()
    public String device() {
        return prefix + "/device";
    }

    /**
     * 查询设备地图点位列表
     */
    @RequiresPermissions("system:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkMapPoint hkMapPoint) {
        startPage();
        List<HkMapPoint> list = hkMapPointService.selectHkMapPointList(hkMapPoint);
        return getDataTable(list);
    }

    /**
     * 导出设备地图点位列表
     */
    @RequiresPermissions("system:device:export")
    @Log(title = "设备地图点位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkMapPoint hkMapPoint) {
        List<HkMapPoint> list = hkMapPointService.selectHkMapPointList(hkMapPoint);
        ExcelUtil<HkMapPoint> util = new ExcelUtil<HkMapPoint>(HkMapPoint.class);
        return util.exportExcel(list, "device");
    }

    /**
     * 新增设备地图点位
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设备地图点位
     */
    @RequiresPermissions("system:device:add")
    @Log(title = "设备地图点位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkMapPoint hkMapPoint) {
        return toAjax(hkMapPointService.insertHkMapPoint(hkMapPoint));
    }

    /**
     * 修改设备地图点位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        HkMapPoint hkMapPoint = hkMapPointService.selectHkMapPointById(id);
        mmap.put("hkMapPoint", hkMapPoint);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备地图点位
     */
    @RequiresPermissions("system:device:edit")
    @Log(title = "设备地图点位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkMapPoint hkMapPoint) {
        return toAjax(hkMapPointService.updateHkMapPoint(hkMapPoint));
    }

    /**
     * 删除设备地图点位
     */
    @RequiresPermissions("system:device:remove")
    @Log(title = "设备地图点位", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(hkMapPointService.deleteHkMapPointByIds(ids));
    }

    /**
     * 设备点位状态修改
     */
    @Log(title = "设备点位", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:device:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(HkMapPoint mapPoint) {
        return toAjax(hkMapPointService.changeStatus(mapPoint));
    }
}
