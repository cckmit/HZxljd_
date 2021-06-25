package com.ruoyi.web.controller.system.property.info;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.XianLinConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.json.JSON;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.XlCarInfo;
import com.ruoyi.system.domain.XlPersonnel;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.service.IXlCarInfoService;
import com.ruoyi.system.service.IXlPersonnelService;
import com.ruoyi.system.service.IXlVillageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: Riley
 * Date: 2021/5/25
 * Description:
 */
@Controller
@RequestMapping("/system/property/xlcarinfo")
public class PropertyCarInfoController extends BaseController {

    private String prefix = "system/property/xlcarinfo";

    @Autowired
    private IXlCarInfoService xlCarInfoService;

    @Autowired
    private IXlPersonnelService xlPersonnelService;

    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system/property:xlcarinfo:view")
    @GetMapping()
    public String xlcarinfo()
    {
        return prefix + "/xlcarinfo";
    }

    /**
     * 查询公共管理/物业--车辆信息列表
     */
    @RequiresPermissions("system/property:xlcarinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlCarInfo xlCarInfo)
    {
        startPage();
        //物业公司用户只能查看自己小区的信息
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        xlCarInfo.setVillageId(villageId);
        List<XlCarInfo> list = xlCarInfoService.selectXlCarInfoList(xlCarInfo);
        return getDataTable(list);
    }

    /**
     * 新增公共管理/物业--车辆信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        return prefix + "/add";
    }

    /**
     * 新增保存公共管理/物业--车辆信息
     */
    @RequiresPermissions("system/property:xlcarinfo:add")
    @Log(title = "公共管理/物业--车辆信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlCarInfo xlCarInfo)
    {
        //车主所处小区id
        xlCarInfo.setVillageId(ShiroUtils.getSysUser().getDeptId());
        return toAjax(xlCarInfoService.insertXlCarInfo(xlCarInfo));
    }

    /**
     * 修改公共管理/物业--车辆信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlCarInfo xlCarInfo = xlCarInfoService.selectXlCarInfoById(id);
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        mmap.put("xlCarInfo", xlCarInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存公共管理/物业--车辆信息
     */
    @RequiresPermissions("system/property:xlcarinfo:edit")
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
    @RequiresPermissions("system/property:xlcarinfo:remove")
    @Log(title = "公共管理/物业--车辆信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xlCarInfoService.deleteXlCarInfoByIds(ids));
    }

    //检验车牌号码是否唯一
    @ResponseBody
    @RequestMapping("/checkCarNumberUnique")
    public String checkCarNumberUnique(XlCarInfo xlCarInfo){
        List<XlCarInfo> xlCarInfoList = xlCarInfoService.selectXlCarInfoList(xlCarInfo);
        if(xlCarInfoList.size() <= 0){
            //不存在
            return XianLinConstants.DATA_UNIQUE;
        }else{
            if(null != xlCarInfo.getId()){//非空判断
                //存在 判断是否是当前编辑的信息
                if(xlCarInfo.getId().longValue() == xlCarInfoList.get(0).getId().longValue()){
                    //不存在
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //存在
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
    }

    //通过手机号码校验车主唯一性
    @ResponseBody
    @RequestMapping("/checkPhoneUnique")
    public String checkPhoneUnique(XlCarInfo xlCarInfo){
        List<XlCarInfo> xlCarInfoList = xlCarInfoService.selectXlCarInfoList(xlCarInfo);
        if(xlCarInfoList.size() <= 0){
            //不存在
            return XianLinConstants.DATA_UNIQUE;
        }else{
            if(null != xlCarInfo.getId()){//非空判断
                //存在 判断是否是当前编辑的信息
                if(xlCarInfo.getId().longValue() == xlCarInfoList.get(0).getId().longValue()){
                    //不存在
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //存在
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
    }

    /**
     * select2加载数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getXlPersonnel")
    public AjaxResult getXlPersonnel(HttpServletRequest request){
        //人员名称 模糊搜素
        String name = request.getParameter("search");
        //页号
        String page = request.getParameter("page");
        //每页数量
        String pageSize = request.getParameter("pageSize");
        //查询
        XlPersonnel personnel = new XlPersonnel();
        personnel.setName(name);
        startPage(Integer.valueOf(page),Integer.valueOf(pageSize)); //分页
        //人员信息
        List<XlPersonnel> xlPersonnelList = xlPersonnelService.selectXlPersonnelList(personnel);
        //返回结果
        AjaxResult ajax = AjaxResult.success();
        ajax.put("personnels",xlPersonnelList);
        ajax.put("total",new PageInfo(xlPersonnelList).getTotal()); //总记录数
        return ajax;
    }
}
