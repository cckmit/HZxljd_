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
import com.ruoyi.system.domain.HkRentHouseInfo;
import com.ruoyi.system.service.IHkRentHouseInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房屋管理Controller
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
@Controller
@RequestMapping("/system/house")
public class HkRentHouseInfoController extends BaseController
{
    private String prefix = "system/house";

    @Autowired
    private IHkRentHouseInfoService hkRentHouseInfoService;

    @RequiresPermissions("system:house:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/house";
    }

    /**
     * 查询房屋管理列表
     */
    @RequiresPermissions("system:house:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkRentHouseInfo hkRentHouseInfo)
    {
        startPage();
        List<HkRentHouseInfo> list = hkRentHouseInfoService.selectHkRentHouseInfoList(hkRentHouseInfo);
        return getDataTable(list);
    }

    /**
     * 导出房屋管理列表
     */
    @RequiresPermissions("system:house:export")
    @Log(title = "房屋管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkRentHouseInfo hkRentHouseInfo)
    {
        List<HkRentHouseInfo> list = hkRentHouseInfoService.selectHkRentHouseInfoList(hkRentHouseInfo);
        ExcelUtil<HkRentHouseInfo> util = new ExcelUtil<HkRentHouseInfo>(HkRentHouseInfo.class);
        return util.exportExcel(list, "house");
    }

    /**
     * 新增房屋管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存房屋管理
     */
    @RequiresPermissions("system:house:add")
    @Log(title = "房屋管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkRentHouseInfo hkRentHouseInfo)
    {
        return toAjax(hkRentHouseInfoService.insertHkRentHouseInfo(hkRentHouseInfo));
    }

    /**
     * 修改房屋管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HkRentHouseInfo hkRentHouseInfo = hkRentHouseInfoService.selectHkRentHouseInfoById(id);
        mmap.put("hkRentHouseInfo", hkRentHouseInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋管理
     */
    @RequiresPermissions("system:house:edit")
    @Log(title = "房屋管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkRentHouseInfo hkRentHouseInfo)
    {
        return toAjax(hkRentHouseInfoService.updateHkRentHouseInfo(hkRentHouseInfo));
    }

    /**
     * 删除房屋管理
     */
    @RequiresPermissions("system:house:remove")
    @Log(title = "房屋管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkRentHouseInfoService.deleteHkRentHouseInfoByIds(ids));
    }
}
