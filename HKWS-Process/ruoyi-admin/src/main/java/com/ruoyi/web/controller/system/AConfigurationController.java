package com.ruoyi.web.controller.system;


import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.system.domain.HKfield.hkfield;
import com.ruoyi.system.domain.HkAConfiguration;

import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.service.HKfield.HKfieldService;
import com.ruoyi.system.service.HkAConfigurationService;
import com.ruoyi.system.service.HkEClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("system/gzhi")

@Api(tags = "行动节点接口")
public class AConfigurationController extends BaseController {
    @Autowired(required = false)
    private HkAConfigurationService aConfigurationService;
    @Autowired(required = false)
    private HkEClassificationService hkEClassificationService;
    @Autowired(required = false)
    private HKfieldService hKfieldService;


    private String prefix = "system/gzhi";
    /**
     * 查询行动信息
     */
    @RequiresPermissions("system/gzhi:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/xdong";
    }
    @RequiresPermissions("system/gzhi:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo xdong(HkAConfiguration hkAConfiguration,ModelMap mmap)
    {
        // 查询事件类型
        List<HkEClassification> hkEClassificationList=hkEClassificationService.eventType();
        mmap.put("hkEClassificationList",hkEClassificationList);
        startPage();
        List<HkAConfiguration> list=aConfigurationService.selectRoleList(hkAConfiguration);

        return getDataTable(list);

    }
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        // 查询事件类型
        List<HkEClassification> hkEClassificationList=hkEClassificationService.eventType();
        mmap.put("hkEClassificationList",hkEClassificationList);

        String tableData="[{\"commonlyId\":\"8b9c8733d4834dfeba90f7bb2fdb728a\",\"createDate\":1605249925000,\"fieldCommit\":\"www\",\"fieldLength\":\"255\",\"fieldName\":\"\",\"fieldNull\":\"\",\"fieldType\":\"\",\"id\":52,\"params\":{}}]";
        mmap.put("tableData",tableData);
        return prefix + "/step";
    }

    @GetMapping("/addplus")
    public String addplus()
    {
        return prefix + "/addplus";
    }

    @RequestMapping("/manage")
    @ResponseBody
    @ApiOperation("事件菜单")
    public TableDataInfo manage(HkAConfiguration role,Model model)  {
        startPage();
        List<HkAConfiguration> list = aConfigurationService.selectRoleList(role);
        model.addAttribute("roles",hkEClassificationService.finby());
        return getDataTable(list);

    }

    @Log(title = "管理标签", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:role:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Integer ac_id, String ac_type)
    {
        HkAConfiguration hkAConfiguration=new HkAConfiguration();
        hkAConfiguration.setActionType(ac_type);
        hkAConfiguration.setId(ac_id);
        aConfigurationService.checkRoleAllowed(hkAConfiguration);
        return toAjax(aConfigurationService.checkRoleAllowed(hkAConfiguration));
    }




    /**
     *  添加行动配置
     * @param hkAConfiguration
     * @return
     */
    @RequiresPermissions("system:gzhi:add")
    @Log(title = "行动配置添加", businessType = BusinessType.INSERT)
    @PostMapping("/addHKAconfiguration")
    @ResponseBody
    public AjaxResult addHKAconfiguration(HkAConfiguration hkAConfiguration)
    {
        // 判断行动名称是否唯一
        int only=aConfigurationService.checkRoleAllowed(hkAConfiguration);
        if(only>0){
            return AjaxResult.warn("行动名称已存在");
        }
            // 添加事件id
            String actionType=hkAConfiguration.getActionType();
            HkEClassification hkEClassification= hkEClassificationService.findHkEClassification(actionType);
            hkAConfiguration.setActionTypeId(String.valueOf(hkEClassification.getEc_id()));
            // 添加数据源id
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            hkAConfiguration.setUuid(uuid);
            int count = aConfigurationService.addHKAconfiguration(hkAConfiguration);

            hkAConfiguration = aConfigurationService.findHKAconfiguration(uuid);
            AjaxResult ajaxResult = AjaxResult.success(hkAConfiguration);
            return ajaxResult;

    }


    /**
     * 添加字段
     * @param hk
     * @return
     */
    @RequiresPermissions("system:gzhi:add")
    @Log(title = "行动配置添加", businessType = BusinessType.INSERT)
    @PostMapping("/addField")
    @ResponseBody
    public AjaxResult addField(hkfield hk)
    {
        // 判断行动名称是否唯一
        int only=hKfieldService.checkField(hk);
        if(only>0){
            return AjaxResult.warn("字段名称已存在");
        }
       int count =hKfieldService.addHkAfieldMapper(hk);
       String commid=hk.getCommonlyId();
       List<hkfield> hkfieldList=  hKfieldService.findHKAfield(commid);
       AjaxResult ajaxResult=AjaxResult.success(hkfieldList);
       return ajaxResult;

    }
    /**
     * 行动配置编辑
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        // 查询事件类型
        List<HkEClassification> hkEClassificationList=hkEClassificationService.eventType();
        mmap.put("hkEClassificationList",hkEClassificationList);
        // 编辑页面第一页回显数据
        HkAConfiguration hkAConfiguration=aConfigurationService.selecAConfiguration(id);
        String form=JSONArray.toJSONString(hkAConfiguration);
        mmap.put("form", form);
         // 添加字段所需的uuid
        String commid=hkAConfiguration.getUuid();
        mmap.put("commid", commid);
        // 字段数据回显表格
        List<hkfield> hkfieldList=hKfieldService.findHKAfield(commid);
        if(hkfieldList.size()==0){
            String tableData="[{\"commonlyId\":\"8b9c8733d4834dfeba90f7bb2fdb728a\",\"createDate\":1605249925000,\"fieldCommit\":\"www\",\"fieldLength\":\"255\",\"fieldName\":\"\",\"fieldNull\":\"\",\"fieldType\":\"\",\"id\":52,\"params\":{}}]";
            mmap.put("tableData", tableData);
            mmap.put("UpdateTabform", tableData);
        }else {
            for (int i = 0; i < hkfieldList.size(); i++) {
               String tableData = JSONArray.toJSONString(hkfieldList);
               mmap.put("tableData", tableData);

               // 编辑回显内容
                String commonlyId = hkfieldList.get(i).getCommonlyId();
                id = hkfieldList.get(i).getId();
                hkfield hk = hKfieldService.selectHKAfieldBy(commonlyId, id);
                String UpdateTabform = JSONArray.toJSONString(hk);
                mmap.put("UpdateTabform", UpdateTabform);
            }
        }

        return prefix + "/edit";
    }
    /**
     * 修改行动配置
     */
    @RequiresPermissions("system:gzhi:edit")
    @Log(title = "行动配置修改", businessType = BusinessType.UPDATE)
    @PostMapping("/editHKAconfiguration")
    @ResponseBody
    public AjaxResult editHKAconfiguration(HkAConfiguration hkAConfiguration){
        // 判断行动名称是否唯一
        int only=aConfigurationService.checkRoleAllowed(hkAConfiguration);
        if(only>0){
            return AjaxResult.warn("行动名称已存在");
        }
        int count=aConfigurationService.editHKAconfiguration(hkAConfiguration);
        if(count>0){
            String uuid=hkAConfiguration.getUuid();
            hkAConfiguration=aConfigurationService.findHKAconfiguration(uuid);

        }
        AjaxResult ajaxResult=AjaxResult.success(hkAConfiguration);
        return ajaxResult;
    }

    /**
     * 删除行动配置
     * @param ids
     * @return
     */
    @RequiresPermissions("system:gzhi:remove")
    @Log(title = "行动配置删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aConfigurationService.deleteHKAconfiguration(ids));
    }

    /**
     * 删除字段数据
     */
    @RequiresPermissions("system:gzhi:remove")
    @Log(title = "行动配置删除", businessType = BusinessType.DELETE)
    @PostMapping("/deleteHKfield")
    @ResponseBody
    public AjaxResult deleteHKfield(Integer id){
        return toAjax(hKfieldService.deleteHKfield(id));
    }


    /**
     * 修改字段数据
     * @param hk
     * @return
     */
    @RequiresPermissions("system:gzhi:edit")
    @Log(title = "行动配置修改", businessType = BusinessType.UPDATE)
    @PostMapping("/updateField")
    @ResponseBody
    public AjaxResult updateField(hkfield hk){
        // 修改文本类型
        String fieldType=hk.getFieldType();

       return toAjax(hKfieldService.updateField(hk)) ;
    }
}
