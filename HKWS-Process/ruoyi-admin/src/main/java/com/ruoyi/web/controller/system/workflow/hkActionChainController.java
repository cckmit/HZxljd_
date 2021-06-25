package com.ruoyi.web.controller.system.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.Action.HkActionChain;
import com.ruoyi.system.domain.Action.HkActionDefinition;
import com.ruoyi.system.domain.HkEarlyWarning.SysUserPostRegionVo;
import com.ruoyi.system.domain.vo.HkActionChainVo;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.*;

/**
 * @author FanKaibiao
 * @date 2020-12-14-12:29
 * 行动链配置
 */
@RequestMapping("system/workFlow")
@Controller
public class hkActionChainController  extends BaseController {
    private String prefix = "system/workFlow";

    @Autowired
    private HkActionChainService hkActionChainService;
    /*@Autowired
    private ISysDeptService iSysDeptService;*/
    @Autowired
    private ISysRegionService iSysRegionService;
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private HkActionDefinitionService hkActionDefinitionService;
    @Autowired
    private HkAConfigurationService aConfigurationService;
    @Autowired
    private HkEClassificationService hkEClassificationService;

    @RequiresPermissions("system:workFlow:view")
    @GetMapping()
    public String workFlow()
    {
        return prefix + "/workFlow";
    }

    /**
     * 查询行动链列表
     */
    @RequiresPermissions("system:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkActionChain hkActionChain)
    {
        startPage();
        List<HkActionChain> list=hkActionChainService.findHkActionChain(hkActionChain);
        return getDataTable(list);
    }
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        List<HkEClassification> eClassifications= hkEClassificationService.findEclass();
        map.put("eClassifications",eClassifications);
        List<HkAConfiguration> aConfigurations= aConfigurationService.findaConfiguration();
        map.put("aConfigurations",aConfigurations);
        return prefix + "/step";
    }
    /**
     * 选择网格员
     * @param regionId
     * @return
     */
    @GetMapping(value = "chooseEventOwer")
    @ResponseBody
    public AjaxResult chooseEventOwener(String regionId){
        if(StringUtils.isEmpty(regionId)){
            return AjaxResult.error("网格区域id不能为空");
        }
        return AjaxResult.success(iSysUserService.findUserPostByRegionId(regionId));
    }

    /**
     * 新增行动链和行动链定义
     * @param actionChainVo
     * @return
     */
    @PostMapping(value = "/addHkActionChainAndDefini")
    @ResponseBody
    public AjaxResult addHkActionChainAndDefini(@RequestBody HkActionChainVo vo){

        String userName = ShiroUtils.getSysUser().getUserName();

        String actionChainId = UUID.randomUUID().toString().trim().replaceAll("-","");//行动链id
        //行动链set值
        HkActionChain hkActionChain = new HkActionChain();
        hkActionChain.setActionName(vo.getActionName());
        hkActionChain.setActionRegionCode(vo.getActionRegionCode());
        hkActionChain.setActionRegion(vo.getActionRegion());
        hkActionChain.setExpectedEvents(vo.getOverTimeType()+"/"+vo.getOverTimeNum());
        hkActionChain.setActionChainId(actionChainId);
        hkActionChain.setCreateUser(userName);
        hkActionChain.setActionStandard(vo.getEcNameType());
        hkActionChain.setCreateTime(new Date());
        hkActionChain.setActionRemark(vo.getActionRemark());
        logger.info("<<<<<<开始添加行动链，入参:{}",JSON.toJSONString(hkActionChain));

        //添加行动链定义表set值
        List<Map<String,Object>> jsonArray = vo.getClrArray();
        if (jsonArray.size() == 0){
            return AjaxResult.error("添加处理人信息为空，请重新添加。");
        }
        List<HkActionDefinition> definitionList = new ArrayList<>();
        Date createTime = new Date();
        for (int i = 0; i <jsonArray.size() ; i++) {
            Map<String,Object> map = jsonArray.get(i);

            HkActionDefinition hkActionDefinition = new HkActionDefinition();
            hkActionDefinition.setActionChainId(actionChainId);
            hkActionDefinition.setActionStandardId(map.get("actionStandardId").toString());//标准动作id
            hkActionDefinition.setHandlerPostId(Integer.parseInt(map.get("postId").toString()));//职能id
            hkActionDefinition.setHandlerOrder(map.get("executionIndex").toString());//执行顺序
            hkActionDefinition.setCreateTime(createTime);
            hkActionDefinition.setCreateUser(userName);
            definitionList.add(hkActionDefinition);
        }
        logger.info("<<<<<<开始添加行动链定义，入参:{}",JSON.toJSONString(definitionList));
        boolean isSuccess = hkActionDefinitionService.addHkActionChainAndDetailed(hkActionChain,definitionList);
        if (isSuccess){
            return AjaxResult.success();
        }
        return AjaxResult.error("新增行动链和行动链定义失败，请联系管理人员。");
    }


    /**
     * 删除行动链和行动链定义
     * @param ids
     * @return
     */
    @RequiresPermissions("system:workFlow:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hkActionChainService.deleteHKActionChain(ids));
    }

    @Log(title = "行动链", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:workFlow:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkActionChain hkActionChain)
    {
        List<HkActionChain> list=hkActionChainService.findHkActionChain(hkActionChain);
        ExcelUtil<HkActionChain> util = new ExcelUtil<HkActionChain>(HkActionChain.class);
        return util.exportExcel(list, "行动链");
    }

    /**
     * 修改行动链页面
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Integer id, ModelMap mmap)
    {
        //查询行动链基本信息
        HkActionChain hkActionChain= hkActionChainService.findChain(id);
        String expectedEvents = hkActionChain.getExpectedEvents();
        String[] split = expectedEvents.split("/");
        String time=split[0];
        String num=split[1];
        hkActionChain.setTime(time);
        hkActionChain.setNum(num);
        String form= JSONArray.toJSONString(hkActionChain);
        mmap.put("form", form);

        List<SysUserPostRegionVo> postArray = iSysUserService.findUserPostByRegionId(hkActionChain.getActionRegionCode());
        mmap.put("postArray",JSON.toJSONString(postArray));//获取职能

        List<HkEClassification> eClassifications= hkEClassificationService.findEclass(); //获取事件分类
        mmap.put("eClassifications",eClassifications);
        List<HkAConfiguration> aConfigurations= aConfigurationService.findaConfiguration(); //获取行动配置
        mmap.put("aConfigurations",aConfigurations);

        HkActionDefinition hkActionDefinition = new HkActionDefinition();
        hkActionDefinition.setActionChainId(hkActionChain.getActionChainId());
        //获取行动链定义
        List<HkActionDefinition> hkActionDefinitionList = hkActionDefinitionService.findDefinitionByChainId(hkActionDefinition);
        mmap.put("standard1","");
        mmap.put("standard2","");
        mmap.put("standard3","");
        mmap.put("standard4","");
        mmap.put("post1","");
        mmap.put("post2","");
        mmap.put("post3","");
        mmap.put("post4","");
        for (HkActionDefinition hkDe : hkActionDefinitionList) {
            if ("1".equals(hkDe.getHandlerOrder())){
                mmap.put("standard1",hkDe.getActionStandardId());//标准动作id
                mmap.put("post1",hkDe.getHandlerPostId());//第一个指派职能id
            }else if ("2".equals(hkDe.getHandlerOrder())){
                mmap.put("standard2",hkDe.getActionStandardId());
                mmap.put("post2",hkDe.getHandlerPostId());
            }else if ("3".equals(hkDe.getHandlerOrder())){
                mmap.put("standard3",hkDe.getActionStandardId());
                mmap.put("post3",hkDe.getHandlerPostId());
            }else if ("4".equals(hkDe.getHandlerOrder())){
                mmap.put("standard4",hkDe.getActionStandardId());
                mmap.put("post4",hkDe.getHandlerPostId());
            }
        }
        return prefix + "/edit";
    }

    /**
     * 行动链修改
     * @param vo
     * @return
     */
    @RequiresPermissions("system:workFlow:edit")
    @Log(title = "行动链修改", businessType = BusinessType.UPDATE)
    @PostMapping("/editHkActionChain")
    @ResponseBody
    public AjaxResult editHkActionChain(@RequestBody HkActionChainVo vo){
        String userName = ShiroUtils.getSysUser().getUserName();
        //行动链set值
        HkActionChain hkActionChain = new HkActionChain();
        hkActionChain.setActionChainId(vo.getActionChainId());

        hkActionChain.setActionName(vo.getActionName());
        hkActionChain.setActionRegionCode(vo.getActionRegionCode());
        hkActionChain.setActionRegion(vo.getActionRegion());
        hkActionChain.setExpectedEvents(vo.getOverTimeType()+"/"+vo.getOverTimeNum());
        hkActionChain.setUpdateUser(userName);
        hkActionChain.setActionStandard(vo.getEcNameType());
        hkActionChain.setUpdateTime(DateUtils.getNowDate());
        hkActionChain.setActionRemark(vo.getActionRemark());
        logger.info("<<<<<<开始修改行动链，入参:{}",JSON.toJSONString(hkActionChain));

        //添加行动链定义表set值
        List<Map<String,Object>> jsonArray = vo.getClrArray();
        if (jsonArray.size() == 0){
            return AjaxResult.error("添加处理人信息为空，请重新添加。");
        }
        List<HkActionDefinition> definitionList = new ArrayList<>();

        Date createTime = DateUtils.getNowDate();
        for (int i = 0; i <jsonArray.size() ; i++) {
            Map<String,Object> jsonObject = jsonArray.get(i);
            HkActionDefinition hkActionDefinition = new HkActionDefinition();
            hkActionDefinition.setActionChainId(vo.getActionChainId());
            hkActionDefinition.setActionStandardId(jsonObject.get("actionStandardId").toString());//标准动作id
            hkActionDefinition.setHandlerOrder(jsonObject.get("executionIndex").toString());//执行顺序
            hkActionDefinition.setHandlerPostId(Integer.parseInt(jsonObject.get("postId").toString()));//职能id
            hkActionDefinition.setCreateTime(createTime);
            hkActionDefinition.setCreateUser(userName);
            definitionList.add(hkActionDefinition);
        }
        logger.info("<<<<<<开始修改行动链定义，入参:{}",JSON.toJSONString(definitionList));
        boolean isSuccess = hkActionDefinitionService.updateHkActionChainAndDetailed(hkActionChain,definitionList);
        if (isSuccess){
            return AjaxResult.success();
        }
        return AjaxResult.error("修改新动链失败，请联系管理人员。");
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Integer id, ModelMap mmap){
        //查询行动链
        HkActionChain hkActionChain= hkActionChainService.findChain(id);
        String expectedEvents = hkActionChain.getExpectedEvents();
        String[] split = expectedEvents.split("/");
        String time=split[0];
        String num=split[1];
        hkActionChain.setTime(time);
        hkActionChain.setNum(num);
        String form= JSONArray.toJSONString(hkActionChain);
        mmap.put("form", form);
        //查询事件分类
        List<HkEClassification> eClassifications= hkEClassificationService.selectHkEClassByEcCategory(hkActionChain.getActionStandard());
        mmap.put("ecName",eClassifications.get(0).getEc_name());
        //根据行动链id获取处理人和标准动作
        List<Map<String,Object>> tableList = hkActionDefinitionService.selectDefinitionAndConfigAndSysUser(hkActionChain.getActionChainId(),hkActionChain.getActionRegion());
        mmap.put("tableData", JSON.toJSONString(tableList));
        return prefix + "/detail";
    }

    /**
     * 校验行动链名称是否唯一
     * 校验事件类别和区域在行动链是否唯一
     * @param vo
     * @return
     */
    @PostMapping("/ajaxCheckActionName")
    @ResponseBody
    public AjaxResult ajaxCheckActionName(HkActionVo vo){
        HkActionChain actionChain = hkActionChainService.selectActionChainByName(vo.getActionName());
        String id = StringUtils.isEmpty(vo.getActionChainId()) ? "1":vo.getActionChainId();
        if (StringUtils.isNotNull(actionChain) && !actionChain.getActionChainId().equals(id)){
            return AjaxResult.warn("行动链名称已存在，请重新输入。");
        }
        HkActionChain hkActionChain = hkActionChainService.findActionChainByRegionEventType(vo.getActionRegionCode(), vo.getEcNameType());
        if (StringUtils.isNotNull(hkActionChain) && !hkActionChain.getActionChainId().equals(id)){
            return AjaxResult.warn("该网格区域和事件类型在其他行动链已存在，请重新选择。");
        }
        return AjaxResult.success();
    }
}
