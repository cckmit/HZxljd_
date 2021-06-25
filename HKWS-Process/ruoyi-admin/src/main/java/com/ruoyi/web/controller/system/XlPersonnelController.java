package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.XianLinConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.XlPersonnel;
import com.ruoyi.system.domain.XlRoom;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.service.ISysRegionService;
import com.ruoyi.system.service.IXlPersonnelService;
import com.ruoyi.system.service.IXlRoomService;
import com.ruoyi.system.service.IXlVillageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 人员信息Controller
 *
 * @author ruoyi
 * @date 2021-05-17
 */
@Api(tags = "人员信息")
@Controller
@RequestMapping("/system/personnel")
public class XlPersonnelController extends BaseController {
    private String prefix = "system/personnel";

    @Autowired
    private IXlPersonnelService xlPersonnelService;
    @Autowired
    private IXlVillageService xlVillageService;
    @Autowired
    private ISysRegionService sysRegionService;
    @Autowired
    private IXlRoomService xlRoomService;

    @RequiresPermissions("system:personnel:view")
    @GetMapping()
    public String personnel() {
        return prefix + "/personnel";
    }

    /**
     * 查询人员信息列表
     */
    //  @RequiresPermissions("system:personnel:list")
    @ApiOperation(value = "查询人员信息列表", notes = "查询人员信息列表")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlPersonnel xlPersonnel) {
        startPage();
        List<XlPersonnel> list = xlPersonnelService.selectXlPersonnelList(xlPersonnel);
        return getDataTable(list);
    }

    /**
     * 导出人员信息列表
     */
    @RequiresPermissions("system:personnel:export")
    @Log(title = "人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlPersonnel xlPersonnel) {
        List<XlPersonnel> list = xlPersonnelService.selectXlPersonnelList(xlPersonnel);
        ExcelUtil<XlPersonnel> util = new ExcelUtil<XlPersonnel>(XlPersonnel.class);
        return util.exportExcel(list, "personnel");
    }

    /**
     * 导出数据
     */
    @PostMapping("/exportData")
    @ResponseBody
    public AjaxResult exportSelected(XlPersonnel xlPersonnel, String Ids) {
        List<XlPersonnel> list = null;
        String[] arr = null;
        if (Ids != null) {
            arr = Ids.split(",");
            list = xlPersonnelService.selectXlPersonnelInIds(arr);
        } else {
            list = xlPersonnelService.selectXlPersonnelList(xlPersonnel);
        }
        List<XlPersonnel> xlPersonnelList = new ArrayList<XlPersonnel>(Arrays.asList(new XlPersonnel[list.size()]));
        Collections.copy(xlPersonnelList, list);

        // 条件过滤
        if (StringUtils.isNotEmpty(Ids)) {
            xlPersonnelList.clear();
            for (Long id : Convert.toLongArray(Ids)) {
                for (XlPersonnel xlPersonnel1 : list) {
                    if (xlPersonnel1.getId() == id.intValue()) {
                        xlPersonnelList.add(xlPersonnel1);
                    }
                }
            }
        }
        ExcelUtil<XlPersonnel> util = new ExcelUtil<XlPersonnel>(XlPersonnel.class);
        return util.exportExcel(xlPersonnelList, "人员数据");
    }

    /**
     * 新增人员信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        List<XlVillageModel> villageList = xlVillageService.selectXlVillageList(new XlVillageModel());
        List<SysRegion> regionList = sysRegionService.selectRegionList();
        mmap.put("villageList", villageList);
        mmap.put("regionList", regionList);
        return prefix + "/add";
    }

    /**
     * 新增保存人员信息
     */
    @ApiOperation(value = "人员信息添加", notes = "人员信息添加")
//    @RequiresPermissions("system:personnel:add")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlPersonnel xlPersonnel) {
        if (xlPersonnel.getProvince() != null && !xlPersonnel.getProvince().equals("")) {
            if (!xlPersonnel.getProvince().equals("-请选择-")) {
                xlPersonnel.setNativePlace(xlPersonnel.getProvince() + " " + xlPersonnel.getCity());
            } else {
                return AjaxResult.error("请选择籍贯！");
            }
        }
        if (xlPersonnel.getDeptId() != null && !xlPersonnel.getDeptId().equals("")) {
            xlPersonnel.setDeptName(sysRegionService.selectSysRegionById(Long.parseLong(xlPersonnel.getDeptId())).getRegionName());
        } else return AjaxResult.error("请选择网格！");
        if (xlPersonnel.getVillageId() != null && !xlPersonnel.getVillageId().equals("")) {
            xlPersonnel.setVillageName(xlVillageService.selectXlVillageById(xlPersonnel.getVillageId()).getName());
        } else return AjaxResult.error("请选择小区！");
        xlPersonnel.setAddress(xlPersonnel.getVillageName()+xlPersonnel.getBuilding()+xlPersonnel.getUnit()+xlPersonnel.getRoom());
        XlRoom xlRoom = new XlRoom();
        xlRoom.setVillageName(xlVillageService.selectXlVillageById(xlPersonnel.getVillageId()).getName());
        xlRoom.setBuilding(xlPersonnel.getBuilding());
        xlRoom.setUnit(xlPersonnel.getUnit());
        xlRoom.setRoom(xlPersonnel.getRoom());
        List<XlRoom> xlRooms = xlRoomService.selectXlRoomList(xlRoom);
        if (xlRooms != null && xlRooms.size()>0) {
            xlPersonnel.setVillageCode(xlRooms.get(0).getId().toString());
        }
        return toAjax(xlPersonnelService.insertXlPersonnel(xlPersonnel));
    }

    /**
     * 修改人员信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        XlPersonnel xlPersonnel = xlPersonnelService.selectXlPersonnelById(id);
        //籍贯
        if(null != xlPersonnel.getNativePlace() && !xlPersonnel.getNativePlace().equals("")){
            String[] nativePlace = xlPersonnel.getNativePlace().split("\\s+");
            xlPersonnel.setProvince(nativePlace[0]); //省
            xlPersonnel.setCity(nativePlace[1]); //市
        }
        List<XlVillageModel> villageList = xlVillageService.selectXlVillageList(new XlVillageModel());
        List<SysRegion> regionList = sysRegionService.selectRegionList();
        mmap.put("xlPersonnel", xlPersonnel);
        mmap.put("villageList", villageList);
        mmap.put("regionList", regionList);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员信息
     */
    //  @RequiresPermissions("system:personnel:edit")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlPersonnel xlPersonnel) {
        if (xlPersonnel.getProvince() != null && !xlPersonnel.getProvince().equals("")) {
            if (!xlPersonnel.getProvince().equals("-请选择-")) {
                xlPersonnel.setNativePlace(xlPersonnel.getProvince() + " " + xlPersonnel.getCity());
            } else {
                return AjaxResult.error("请选择籍贯！");
            }
        }
        if (xlPersonnel.getDeptId() != null && !xlPersonnel.getDeptId().equals("")) {
            xlPersonnel.setDeptName(sysRegionService.selectSysRegionById(Long.parseLong(xlPersonnel.getDeptId())).getRegionName());
        } else return AjaxResult.error("请选择网格！");
        if (xlPersonnel.getVillageId() != null && !xlPersonnel.getVillageId().equals("")) {
            xlPersonnel.setVillageName(xlVillageService.selectXlVillageById(xlPersonnel.getVillageId()).getName());
        } else return AjaxResult.error("请选择小区！");
        xlPersonnel.setAddress(xlPersonnel.getVillageName()+xlPersonnel.getBuilding()+xlPersonnel.getUnit()+xlPersonnel.getRoom());
        XlRoom xlRoom = new XlRoom();
        xlRoom.setVillageName(xlVillageService.selectXlVillageById(xlPersonnel.getVillageId()).getName());
        xlRoom.setBuilding(xlPersonnel.getBuilding());
        xlRoom.setUnit(xlPersonnel.getUnit());
        xlRoom.setRoom(xlPersonnel.getRoom());
        List<XlRoom> xlRooms = xlRoomService.selectXlRoomList(xlRoom);
        if (xlRooms != null && xlRooms.size()>0) {
            xlPersonnel.setVillageCode(xlRooms.get(0).getId().toString());
        }
        return toAjax(xlPersonnelService.updateXlPersonnel(xlPersonnel));
    }

    /**
     * 查询人员信息详情
     */
    @RequiresPermissions("system:personnel:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        XlPersonnel xlPersonnel = xlPersonnelService.selectXlPersonnelById(id);
        mmap.put("xlPersonnel", xlPersonnel);
        return prefix + "/detail";
    }

    /**
     * 删除人员信息
     */
    @RequiresPermissions("system:personnel:remove")
    @Log(title = "人员信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlPersonnelService.deleteXlPersonnelByIds(ids));
    }

    //导入人员信息
    @Log(title = "公共管理--人员信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:personnel:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<XlPersonnel> util = new ExcelUtil<XlPersonnel>(XlPersonnel.class);
        List<XlPersonnel> xlPersonnelList = util.importExcel(file.getInputStream());
        String message = xlPersonnelService.importPersonnel(xlPersonnelList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<XlPersonnel> util = new ExcelUtil<XlPersonnel>(XlPersonnel.class);
        return util.importTemplateExcel("人员信息数据");
    }

    @ApiOperation(value = "入户走访查看人员信息", notes = "入户走访查看人员信息")
    @PostMapping("/selectPersonnel")
    @ResponseBody
    public TableDataInfo selectPersonnel(XlPersonnel xlPersonnel) {
        startPage();
        List<XlPersonnel> list = xlPersonnelService.selectXlPersonnelWork(xlPersonnel);
        return getDataTable(list);
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
    /**
     * 查询当前物业下小区住户
     */
    //  @RequiresPermissions("system:personnel:list")
    @ApiOperation(value = "查询当前物业下小区住户", notes = "查询当前物业下小区住户")
    @PostMapping("/estatePersonnelList")
    @ResponseBody
    public TableDataInfo estatePersonnelList(XlPersonnel xlPersonnel,String estateId) {
        startPage();
        List<XlPersonnel> list = xlPersonnelService.estatePersonnelList(xlPersonnel,estateId);
        return getDataTable(list);
    }
}
