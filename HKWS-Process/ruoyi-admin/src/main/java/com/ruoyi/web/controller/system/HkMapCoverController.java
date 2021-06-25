package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkMapCover;
import com.ruoyi.system.service.IHkMapCoverService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller
 * @ClassName: HkMapCoverController
 * @Author: guohailong
 * @Description: 地图覆盖物-地区关联表
 * @Date: 2021/3/16 2:10
 * @Version: 1.0
 */
@Controller
@RequestMapping("/system/region")
public class HkMapCoverController extends BaseController {
    private String prefix = "system/region";

    @Autowired
    private IHkMapCoverService hkMapCoverService;

    /**
     * 跳转到绘制覆盖物地图页面.
     *
     * @param regionId
     * @param model
     * @return
     */
    @RequiresPermissions("system:region:view")
    @GetMapping("/map/{regionId}")
    public String cover(@PathVariable Long regionId, Model model) {
        model.addAttribute("regionId", regionId);
        //获取当前地区的覆盖物.
        HkMapCover mapCover = hkMapCoverService.getHkMapCover(regionId);
        model.addAttribute("mapCover", mapCover);
        //获取当前地区兄弟节点的覆盖物集合.
        List<HkMapCover> brotherMapCoverList = hkMapCoverService.getBrotherHkMapCoverList(regionId);
        model.addAttribute("brotherMapCoverList", brotherMapCoverList);
        //获取当前地区堂兄弟节点
        List<HkMapCover> cousinMapCoverList =hkMapCoverService.getCousinHkMapCoverList(regionId);
        model.addAttribute("cousinMapCoverList", cousinMapCoverList);
        //获取当前地区父节点的覆盖物
        HkMapCover parentMapCover = hkMapCoverService.getParentHkMapCover(regionId);
        model.addAttribute("parentMapCover", parentMapCover);
        return prefix + "/map";
    }


    /**
     * 跳转到覆盖物地图列表页面.点击地图总览按钮
     *
     * @param regionId
     * @param model
     * @return
     */
    @RequiresPermissions("system:region:view")
    @GetMapping("/map/list/{regionId}")
    public String coverList(@PathVariable Long regionId, Model model) {
        model.addAttribute("regionId", regionId);
        //获取所有存在地图覆盖物的地区列表
        List<HkMapCover> mapCoverList = hkMapCoverService.getALLMapCoverList();//获取所有地区点位
        model.addAttribute("markerPointsList", mapCoverList);
        return prefix + "/map-list";
    }


    /**
     * 新增保存地图覆盖物-地区关联
     */
    @RequiresPermissions("system:region:edit")
    @Log(title = "地图覆盖物-地区关联", businessType = BusinessType.INSERT)
    @PostMapping("/map/save")
    @ResponseBody
    public AjaxResult saveCover(@RequestBody HkMapCover hkMapCover) {
        hkMapCover.setCreateBy(ShiroUtils.getLoginName());
        hkMapCover.setCreateTime(DateUtils.getNowDate());
        return toAjax(hkMapCoverService.insertHkMapCover(hkMapCover));
    }

    /**
     * 删除
     *
     * @param regionId
     * @return
     */
    @RequiresPermissions("system:region:edit")
    @Log(title = "地图覆盖物-地区关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/map/{regionId}")
    @ResponseBody
    public AjaxResult deleteCover(@PathVariable Long regionId) {
        return toAjax(hkMapCoverService.deleteHkMapCoverByParentId(regionId));
    }

    /**
     * 综合调度-地图覆盖物
     *
     * @param regionId
     * @return
     */
    @PostMapping("/map/details")
    @ResponseBody
    public AjaxResult getCoverDetails(Long regionId) {
        //获取当前地区下的子地区地图页面存在的覆盖物列表
        List<HkMapCover> mapCoverList = hkMapCoverService.getALLMapCoverList();
        return AjaxResult.success(mapCoverList);
    }
}
