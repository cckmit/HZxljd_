package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.service.IXlVillageService;
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
import com.ruoyi.system.domain.XlCarInfo;
import com.ruoyi.system.service.IXlCarInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公共管理/物业--车辆信息Controller
 * 
 * @author ruoyi
 * @date 2021-05-21
 */
@Controller
@RequestMapping("/system/carInfo")
public class XlCarInfoController extends BaseController
{
    private String prefix = "system/carInfo";

    @Autowired
    private IXlCarInfoService xlCarInfoService;
    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system:carInfo:view")
    @GetMapping()
    public String carInfo()
    {
        return prefix + "/carInfo";
    }

    /**
     * 查询公共管理/物业--车辆信息列表
     */
    @RequiresPermissions("system:carInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlCarInfo xlCarInfo)
    {
        startPage();
        List<XlCarInfo> list = xlCarInfoService.selectXlCarInfoList(xlCarInfo);
        return getDataTable(list);
    }

    /**
     * 导出公共管理/物业--车辆信息列表
     */
    @RequiresPermissions("system:carInfo:export")
    @Log(title = "公共管理/物业--车辆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlCarInfo xlCarInfo)
    {
        List<XlCarInfo> list = xlCarInfoService.selectXlCarInfoList(xlCarInfo);
        ExcelUtil<XlCarInfo> util = new ExcelUtil<XlCarInfo>(XlCarInfo.class);
        return util.exportExcel(list, "carInfo");
    }

    /**
     * 新增公共管理/物业--车辆信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公共管理/物业--车辆信息
     */
    @RequiresPermissions("system:carInfo:add")
    @Log(title = "公共管理/物业--车辆信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlCarInfo xlCarInfo)
    {
        return toAjax(xlCarInfoService.insertXlCarInfo(xlCarInfo));
    }

    /**
     * 修改公共管理/物业--车辆信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlCarInfo xlCarInfo = xlCarInfoService.selectXlCarInfoById(id);
        List<XlVillageModel> list = xlVillageService.selectXlVillageList(new XlVillageModel());
        mmap.put("xlCarInfo", xlCarInfo);
        mmap.put("list", list);
        return prefix + "/edit";
    }

    /**
     * 修改保存公共管理/物业--车辆信息
     */
    @RequiresPermissions("system:carInfo:edit")
    @Log(title = "公共管理/物业--车辆信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlCarInfo xlCarInfo)
    {
        return toAjax(xlCarInfoService.updateXlCarInfo(xlCarInfo));
    }

    /**
     * 删除公共管理/物业--车辆信息
     */
    @RequiresPermissions("system:carInfo:remove")
    @Log(title = "公共管理/物业--车辆信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlCarInfoService.deleteXlCarInfoByIds(ids));
    }
}
