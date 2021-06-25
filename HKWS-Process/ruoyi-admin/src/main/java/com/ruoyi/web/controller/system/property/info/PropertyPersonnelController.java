package com.ruoyi.web.controller.system.property.info;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.XianLinConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
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

import java.util.List;

/**
 * author: Riley
 * Date: 2021/5/25
 * Description:
 */
@Controller
@RequestMapping("/system/property/xlpersonnel")
public class PropertyPersonnelController extends BaseController {

    private String prefix = "system/property/xlpersonnel";

    @Autowired
    private IXlPersonnelService xlPersonnelService;

    @Autowired
    private IXlVillageService xlVillageService;

    @Autowired
    private IXlCarInfoService xlCarInfoService;

    @RequiresPermissions("system/property:xlpersonnel:view")
    @GetMapping()
    public String xlpersonnel()
    {
        return prefix + "/xlpersonnel";
    }

    /**
     * 查询人员信息列表
     */
    @RequiresPermissions("system/property:xlpersonnel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPersonnel xlPersonnel)
    {
        startPage();
        //物业公司用户只能查看自己小区的人员信息
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        xlPersonnel.setVillageId(villageId);
        List<XlPersonnel> list = xlPersonnelService.selectXlPersonnelList(xlPersonnel);
        return getDataTable(list);
    }

    /**
     * 新增人员信息
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
     * 新增保存人员信息
     */
    @RequiresPermissions("system/property:xlpersonnel:add")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPersonnel xlPersonnel)
    {
        //小区
        xlPersonnel.setVillageId(ShiroUtils.getSysUser().getDeptId());
        //籍贯
        if(null !=xlPersonnel.getProvince() && !xlPersonnel.getProvince().equals("")){
            if(!xlPersonnel.getProvince().equals("-请选择-")){
                xlPersonnel.setNativePlace(xlPersonnel.getProvince()+" "+ xlPersonnel.getCity());
            }else{
                return AjaxResult.error("请选择籍贯！");
            }
        }
        return toAjax(xlPersonnelService.insertXlPersonnel(xlPersonnel));
    }

    /**
     * 修改人员信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        XlPersonnel xlPersonnel = xlPersonnelService.selectXlPersonnelById(id);
        //籍贯
        if(null != xlPersonnel.getNativePlace() && !xlPersonnel.getNativePlace().equals("")){
            String[] nativePlace = xlPersonnel.getNativePlace().split("\\s+");
            xlPersonnel.setProvince(nativePlace[0]); //省
            xlPersonnel.setCity(nativePlace[1]); //市
        }
        //小区
        Long villageId = ShiroUtils.getSysUser().getDeptId();
        XlVillageModel xlVillage = xlVillageService.selectXlVillageById(villageId);
        mmap.put("xlVillage",xlVillage);
        mmap.put("xlPersonnel", xlPersonnel);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员信息
     */
    @RequiresPermissions("system/property:xlpersonnel:edit")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPersonnel xlPersonnel)
    {
        //籍贯
        if(null !=xlPersonnel.getProvince() && !xlPersonnel.getProvince().equals("")){
            if(!xlPersonnel.getProvince().equals("-请选择-")){
                xlPersonnel.setNativePlace(xlPersonnel.getProvince()+" "+ xlPersonnel.getCity());
            }else{
                return AjaxResult.error("请选择籍贯！");
            }
        }
        return toAjax(xlPersonnelService.updateXlPersonnel(xlPersonnel));
    }

    /**
     * 删除人员信息
     */
    @RequiresPermissions("system/property:xlpersonnel:remove")
    @Log(title = "人员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //计数变量
        Integer count = 0;
        //查询是否有关联的车辆信息
        for(String id: Convert.toStrArray(ids)){
            //人员信息
            XlPersonnel xlPersonnel = xlPersonnelService.selectXlPersonnelById(Long.valueOf(id));
            //人员关联的车辆信息
            XlCarInfo xlCarInfo = new XlCarInfo();
            xlCarInfo.setOwnerPhone(xlPersonnel.getPhone());
            xlCarInfo.setOwnerName(xlPersonnel.getName());
            List<XlCarInfo> xlCarInfoList = xlCarInfoService.selectXlCarInfoList(xlCarInfo);
            if(null == xlCarInfoList){
                count++; //计数加1
                break; //跳出循环
            }
        }
        if(count > 0){
            return AjaxResult.error("请先删除该人员关联的车辆！");
        }
        return toAjax(xlPersonnelService.deleteXlPersonnelByIds(ids));
    }

    //验证身份证号
    @ResponseBody
    @RequestMapping("/checkIdcardUnique")
    public String checkIdcardUnique(XlPersonnel xlPersonnel){
        List<XlPersonnel> xlPersonnelList = xlPersonnelService.selectXlPersonnelList(xlPersonnel);
        if(xlPersonnelList.size() <= 0){
            //不存在
            return XianLinConstants.DATA_UNIQUE;
        }else{
            if(null != xlPersonnel.getId()){//非空判断
                //存在 判断是否是当前编辑的信息
                if(xlPersonnel.getId().longValue() == xlPersonnelList.get(0).getId().longValue()){
                    //不存在
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //存在
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
    }

    //验证手机号码
    @ResponseBody
    @RequestMapping("/checkPhoneUnique")
    public String checkPhoneUnique(XlPersonnel xlPersonnel){
        List<XlPersonnel> xlPersonnelList = xlPersonnelService.selectXlPersonnelList(xlPersonnel);
        if(xlPersonnelList.size() <= 0){
            //不存在
            return XianLinConstants.DATA_UNIQUE;
        }else{
            if(null != xlPersonnel.getId()){//非空判断
                //存在 判断是否是当前编辑的信息
                if(xlPersonnel.getId().longValue() == xlPersonnelList.get(0).getId().longValue()){
                    //不存在
                    return XianLinConstants.DATA_UNIQUE;
                }
            }
            //存在
            return XianLinConstants.DATA_NOT_UNIQUE;
        }
    }
}
