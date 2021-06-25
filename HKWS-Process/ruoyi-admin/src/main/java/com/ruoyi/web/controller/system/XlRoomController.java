package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.XlRoom;
import com.ruoyi.system.service.ISysRegionService;
import com.ruoyi.system.service.IXlRoomService;
import com.ruoyi.system.service.IXlVillageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * 房屋信息Controller
 *
 * @author ruoyi
 * @date 2021-05-17
 */
@Controller
@RequestMapping("/system/room")
public class XlRoomController extends BaseController {
    private String prefix = "system/room";

    @Autowired
    private IXlRoomService xlRoomService;
    @Autowired
    private ISysRegionService sysRegionService;
    @Autowired
    private IXlVillageService xlVillageService;

    @RequiresPermissions("system:room:view")
    @GetMapping()
    public String room() {
        return prefix + "/room";
    }

    /**
     * 查询房屋信息列表
     */
  //  @RequiresPermissions("system:room:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XlRoom xlRoom) {
        startPage();
        List<XlRoom> list = xlRoomService.selectXlRoomList(xlRoom);
        return getDataTable(list);
    }

    /**
     * 导出房屋信息列表
     */
    @RequiresPermissions("system:room:export")
    @Log(title = "房屋信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XlRoom xlRoom) {
        List<XlRoom> list = xlRoomService.selectXlRoomList(xlRoom);
        ExcelUtil<XlRoom> util = new ExcelUtil<XlRoom>(XlRoom.class);
        return util.exportExcel(list, "room");
    }

    /**
     * 导出数据
     */
    @PostMapping("/exportData")
    @ResponseBody
    public AjaxResult exportSelected(XlRoom xlRoom, String Ids)
    {
        List<XlRoom> list=null;
        String[] arr=null;
        if (Ids!=null) {
            arr = Ids.split(",");
            list = xlRoomService.selectXlRoomInIds(arr);
        }else {
            list=xlRoomService.selectXlRoomList(xlRoom);
        }
        List<XlRoom> xlRoomList = new ArrayList<XlRoom>(Arrays.asList(new XlRoom[list.size()]));
        Collections.copy(xlRoomList, list);

        // 条件过滤
        if (StringUtils.isNotEmpty(Ids))
        {
            xlRoomList.clear();
            for (Long id : Convert.toLongArray(Ids))
            {
                for (XlRoom xlRoom1 : list)
                {
                    if (xlRoom1.getId() == id.intValue())
                    {
                        xlRoomList.add(xlRoom1);
                    }
                }
            }
        }
        ExcelUtil<XlRoom> util = new ExcelUtil<XlRoom>(XlRoom.class);
        return util.exportExcel(xlRoomList, "房屋数据");
    }

    /**
     * 新增房屋信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存房屋信息
     */
 //   @RequiresPermissions("system:room:add")
    @Log(title = "房屋信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XlRoom xlRoom) {
        if (xlRoom.getDeptId() != null && !xlRoom.getDeptId().equals("")) {
            xlRoom.setDeptName(sysRegionService.selectSysRegionById(Long.parseLong(xlRoom.getDeptId())).getRegionName());
            String communityName = sysRegionService.queryCommunityName(xlRoom.getDeptId());
            xlRoom.setCommunityName(communityName);
        }
        if (xlRoom.getVillageId() != null && !xlRoom.getVillageId().equals("")) {
            xlRoom.setVillageName(xlVillageService.selectXlVillageById(Long.parseLong(xlRoom.getVillageId())).getName());
        }
        return toAjax(xlRoomService.insertXlRoom(xlRoom));
    }

    /**
     * 修改房屋信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        XlRoom xlRoom = xlRoomService.selectXlRoomById(id);
        mmap.put("xlRoom", xlRoom);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋信息
     */
    @RequiresPermissions("system:room:edit")
    @Log(title = "房屋信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XlRoom xlRoom) {
        if (xlRoom.getDeptId() != null && !xlRoom.getDeptId().equals("")) {
            xlRoom.setDeptName(sysRegionService.selectSysRegionById(Long.parseLong(xlRoom.getDeptId())).getRegionName());
            String communityName = sysRegionService.queryCommunityName(xlRoom.getDeptId());
            xlRoom.setCommunityName(communityName);
        }
        if (xlRoom.getVillageId() != null && !xlRoom.getVillageId().equals("")) {
            xlRoom.setVillageName(xlVillageService.selectXlVillageById(Long.parseLong(xlRoom.getVillageId())).getName());
        }
        return toAjax(xlRoomService.updateXlRoom(xlRoom));
    }

    /**
     * 房屋信息详情
     */
    @RequiresPermissions("system:room:detail")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        XlRoom xlRoom = xlRoomService.selectXlRoomById(id);
        mmap.put("xlRoom", xlRoom);
        return prefix + "/detail";
    }

    @GetMapping("/regionList")
    @ResponseBody
    public List<SysRegion> listForCar()
    {
        List<SysRegion> regionList = sysRegionService.selectRegionList();
        return regionList;
    }


    /**
     * 删除房屋信息
     */
    @RequiresPermissions("system:room:remove")
    @Log(title = "房屋信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(xlRoomService.deleteXlRoomByIds(ids));
    }

    @Log(title = "公共管理--房屋信息", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:room:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<XlRoom> util = new ExcelUtil<XlRoom>(XlRoom.class);
        List<XlRoom> xlRoomList = util.importExcel(file.getInputStream());
        String message = xlRoomService.importRoom(xlRoomList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<XlRoom> util = new ExcelUtil<XlRoom>(XlRoom.class);
        return util.importTemplateExcel("房屋信息数据");
    }
    /**
     * 下拉框动态获取小区
     * @return
     */
    @PostMapping("/findVillageIdsNames")
    @ResponseBody
    public List<Map<String,Object>> findVillageIdsNames(Integer deptId){
        return xlVillageService.findVillageIdsNames(deptId);
    }

    /**
     * 下拉框动态获取楼幢
     * @param
     * @return
     */
    @PostMapping("/findbuilding")
    @ResponseBody
    public List<Map<String,Object>> findbuilding(Integer deptId,Integer villageId){
        return xlRoomService.findbuilding(deptId,villageId);
    }

    /**
     * 下拉框动态获取单元
     * @param
     * @return
     */
    @PostMapping("/findUnit")
    @ResponseBody
    public List<Map<String,Object>> findUnit(Integer deptId,Integer villageId, Integer buildingCode){
        return xlRoomService.findUnit(deptId,villageId,buildingCode);
    }

}
