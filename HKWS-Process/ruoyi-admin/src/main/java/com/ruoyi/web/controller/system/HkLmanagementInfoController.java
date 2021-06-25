package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.domain.HkEarlyWarning.HkLmInfoVo;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.service.HkEClassificationService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.statistics.HkEventStatisticsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HkLmanagementInfo;
import com.ruoyi.system.service.IHkLmanagementInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签Controller
 * @author ruoyi
 * @date 2021-05-07
 */
@Controller
@RequestMapping("/system/lmanagementInfo")
public class HkLmanagementInfoController extends BaseController
{
    private String prefix = "system/lmanagement";

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IHkLmanagementInfoService customLmService;

    @Autowired
    private HkEClassificationService eClassificationService;

    @RequiresPermissions("system:customLm:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询自定义标签列表
     */
    @RequiresPermissions("system:customLm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HkLmanagementInfo HkLmanagementInfo)
    {
        startPage();
        List<HkLmInfoVo> list = customLmService.selectHkLmList(HkLmanagementInfo);
        return getDataTable(list);
    }

    /**
     * 导出自定义标签列表
     */
    @RequiresPermissions("system:customLm:export")
    @Log(title = "自定义标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HkLmanagementInfo HkLmanagementInfo)
    {
        List<HkLmanagementInfo> list = customLmService.selectHkLmanagementInfoList(HkLmanagementInfo);
        ExcelUtil<HkLmanagementInfo> util = new ExcelUtil<HkLmanagementInfo>(HkLmanagementInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增自定义标签
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("lmRoleList", roleService.selectRoleAll());
        mmap.put("lmEclassList",eClassificationService.queryEventEClassifications());
        return prefix + "/add";
    }

    /**
     * 新增保存自定义标签
     */
    @RequiresPermissions("system:customLm:add")
    @Log(title = "自定义标签", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HkLmanagementInfo info)
    {
        if(UserConstants.CUSTOM_LM_NAME_NOT_UNIQUE.equals(customLmService.checkLmNameUnique(info.getLmName(),null))){
            return error("新增标签'" + info.getLmName() + "'失败，标签名称已存在");
        }
        /*if(StringUtils.isEmpty(info.getLmAuth())){
            return AjaxResult.error("权限项不能为空");
        }
        if(StringUtils.isEmpty(info.getLmRegion())){
            return AjaxResult.error("区域不能为空");
        }
        if(StringUtils.isEmpty(info.getLmEventType())){
            return AjaxResult.error("事件分类不能为空");
        }*/
        return toAjax(customLmService.insertHkLmanagementInfo(info));
    }

    /**
     * 修改自定义标签
     */
    @GetMapping("/edit/{lmId}")
    public String edit(@PathVariable("lmId") Long lmId, ModelMap mmap)
    {
        HkLmanagementInfo vo = customLmService.selectHkLmanagementInfoById(lmId);
        List<SysRole> sysRoles = customLmService.queryLmRole(lmId);
        List<HkEClassification> hkEClassifications = customLmService.queryLmEventType(lmId);
        mmap.put("customLm", vo);
        mmap.put("lmRoleList", sysRoles);
        mmap.put("lmEclassList", hkEClassifications);
        return prefix + "/edit";
    }

    /**
     * 修改保存自定义标签
     */
    @RequiresPermissions("system:customLm:edit")
    @Log(title = "自定义标签", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HkLmInfoVo vo)
    {
        if(UserConstants.CUSTOM_LM_NAME_NOT_UNIQUE.equals(customLmService.checkLmNameUnique(vo.getLmName(),vo.getLmId()))){
            return error("修改标签'" + vo.getLmName() + "'失败，标签名称已存在");
        }
        if(StringUtils.isNull(vo.getLmId())){
            return AjaxResult.error("标签ID不能为空");
        }
        /*if(StringUtils.isEmpty(vo.getLmAuth())){
            return AjaxResult.error("权限项不能为空");
        }
        if(StringUtils.isEmpty(vo.getLmRegion())){
            return AjaxResult.error("区域不能为空");
        }
        if(StringUtils.isEmpty(vo.getLmEventType())){
            return AjaxResult.error("事件分类不能为空");
        }*/
        return toAjax(customLmService.updateHkLmanagementInfo(vo));
    }


    @Log(title = "自定义标签验重")
    @PostMapping( "/checkLmNameUnique")
    @ResponseBody
    public String checkLmNameUnique(@RequestParam String lmName,@RequestParam(required = false)Long lmId)
    {
        return customLmService.checkLmNameUnique(lmName,lmId);
    }


    /**
     * 删除自定义标签
     */
    @RequiresPermissions("system:customLm:remove")
    @Log(title = "自定义标签", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customLmService.deleteHkLmanagementInfoByIds(ids));
    }


    /**
     * 加载标签区域列表树
     */
    @GetMapping("/lmRegionTreeData")
    @ResponseBody
    public List<Ztree> lmRegionTreeData(Long lmId)
    {
        List<Ztree> ztrees = customLmService.lmRegionTreeData(lmId);
        return ztrees;
    }

    /**
     * 查询事件的所有标签信息
     * @param id
     * @return
     */
    @GetMapping(value = "queryLmByEvent")
    @ResponseBody
    public AjaxResult queryLmByEvent(Long id){
        List<HkLmanagementInfo> seeLm= customLmService.queryLmByEvent(id);
        return AjaxResult.success(seeLm);
    }

}
