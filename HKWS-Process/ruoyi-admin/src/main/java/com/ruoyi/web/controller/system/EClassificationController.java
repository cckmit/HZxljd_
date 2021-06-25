package com.ruoyi.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.HkAConfigurationService;
import com.ruoyi.system.service.HkEClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/eclass")
public class EClassificationController  extends BaseController {

    @Autowired(required = false)
    private HkAConfigurationService aConfigurationService;
    private String prefix = "system/aiew";

    @RequiresPermissions("system:eclass:view")
    @GetMapping()
    public String eclass()
    {
        return prefix + "/eclass";
    }

    /**
     * 新增事件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @Autowired
    private HkEClassificationService eClassificationService;
    /**
     * 新增保存事件
     */
    @RequiresPermissions("system:role:add")
    @Log(title = "事件添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated HkEClassification hkEClassification)
    {
//        if (eClassificationService.checkRoleNameUnique(hkEClassification).equals("名称已存在"))
//        {
//            return error("新增编号'" + hkEClassification.getEc_ids() + "'失败，编号名称已存在");
//        }
        hkEClassification.setEc_created_time(DateUtils.getNowDate());
        hkEClassification.setEc_type("1");
        hkEClassification.setEc_admin(ShiroUtils.getLoginName());
        return toAjax(eClassificationService.create(hkEClassification));

    }

    @RequestMapping("/manage")
    @ResponseBody
    @ApiOperation("事件菜单")
    public TableDataInfo manage(String ec_name, String ec_type, String ec_id,String ec_category) throws Exception {
        startPage();
        List<HkEClassification> list= eClassificationService.selectByEClass(ec_name,ec_type,ec_id,ec_category);

        return getDataTable(list);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public AjaxResult finById(@PathVariable Integer id) {
        return AjaxResult.success(eClassificationService.findById(id));
    }


    @Log(title = "事件管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:role:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Integer ec_id,String ec_type)
    {
        HkEClassification hkEClassification=new HkEClassification();
        hkEClassification.setEc_id(ec_id);
        hkEClassification.setEc_type(ec_type);
        eClassificationService.checkRoleAllowed(hkEClassification);
        return toAjax(eClassificationService.checkRoleAllowed(hkEClassification));
    }

    /**
     * 校验事件名称
     */
    @PostMapping("/checkRoleNameUnique")
    @ResponseBody
    public String checkRoleNameUnique(HkEClassification role)
    {
        return eClassificationService.checkRoleNameUnique(role);
    }


    /**
     * 修改事件
     */
    @GetMapping("/edit/{ec_id}")
    public String edit(@PathVariable("ec_id") String ec_id, ModelMap mmap)
    {
        mmap.put("role", eClassificationService.selectRoleById(ec_id));
        return prefix + "/edit";
    }

    /**
     * 修改保存事件
     */
    @RequiresPermissions("system:role:edit")
    @Log(title = "事件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated HkEClassification hkEClassification)
    {
        eClassificationService.checkRoleAllowed(hkEClassification);
        hkEClassification.setEc_update_time(DateUtils.getNowDate());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(eClassificationService.updateRole(hkEClassification));
    }


    @RequiresPermissions("system:role:remove")
    @Log(title = "事件管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            if(aConfigurationService.countHkAConfiguration(ids)>0){
                return AjaxResult.warn("该事件下存在标准行动,不允许删除");
            }
            return toAjax(eClassificationService.deleteConfigByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }



}
