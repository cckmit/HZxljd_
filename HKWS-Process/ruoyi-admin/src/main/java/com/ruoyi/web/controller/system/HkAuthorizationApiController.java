package com.ruoyi.web.controller.system;

import java.util.Date;
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
import com.ruoyi.system.domain.HkAuthorizationApi;
import com.ruoyi.system.service.IHkAuthorizationApiService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 接口Controller
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
@Controller
@RequestMapping("/system/api")
public class HkAuthorizationApiController extends BaseController
{
    private String prefix = "system/api";

    @Autowired
    private IHkAuthorizationApiService hkAuthorizationApiService;

    @RequiresPermissions("system:api:view")
    @GetMapping()
    public String api()
    {
        return prefix + "/api";
    }

    /**
     * 查询接口列表
     */
    @RequiresPermissions("system:api:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkAuthorizationApi hkAuthorizationApi)
    {
        startPage();
        List<HkAuthorizationApi> list = hkAuthorizationApiService.selectHkAuthorizationApiList(hkAuthorizationApi);
        return getDataTable(list);
    }

    /**
     * 导出接口列表
     */
    @RequiresPermissions("system:api:export")
    @Log(title = "接口", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkAuthorizationApi hkAuthorizationApi)
    {
        List<HkAuthorizationApi> list = hkAuthorizationApiService.selectHkAuthorizationApiList(hkAuthorizationApi);
        ExcelUtil<HkAuthorizationApi> util = new ExcelUtil<HkAuthorizationApi>(HkAuthorizationApi.class);
        return util.exportExcel(list, "api");
    }

    /**
     * 新增接口
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存接口
     */
    @RequiresPermissions("system:api:add")
    @Log(title = "接口", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkAuthorizationApi hkAuthorizationApi)
    {
        hkAuthorizationApi.setaCreateTime(new Date());
        hkAuthorizationApi.setaCreateAdmin("管理员");
        return toAjax(hkAuthorizationApiService.insertHkAuthorizationApi(hkAuthorizationApi));
    }

    /**
     * 修改接口
     */
    @GetMapping("/edit/{aId}")
    public String edit(@PathVariable("aId") Long aId, ModelMap mmap)
    {
        HkAuthorizationApi hkAuthorizationApi = hkAuthorizationApiService.selectHkAuthorizationApiById(aId);
        mmap.put("hkAuthorizationApi", hkAuthorizationApi);
        return prefix + "/edit";
    }

    /**
     * 修改保存接口
     */
    @RequiresPermissions("system:api:edit")
    @Log(title = "", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkAuthorizationApi hkAuthorizationApi)
    {
        hkAuthorizationApi.setaUpdateTime(new Date());
        return toAjax(hkAuthorizationApiService.updateHkAuthorizationApi(hkAuthorizationApi));
    }

    /**
     * 删除接口
     */
    @RequiresPermissions("system:api:remove")
    @Log(title = "接口", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkAuthorizationApiService.deleteHkAuthorizationApiByIds(ids));
    }
}
