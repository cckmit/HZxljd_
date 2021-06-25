package com.ruoyi.quartz.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.quartz.domain.HkSourceFieldConfig;
import com.ruoyi.quartz.domain.HkSourceFieldFilter;
import com.ruoyi.quartz.domain.Source;
import com.ruoyi.quartz.service.IHkSourceFieldConfigService;
import com.ruoyi.quartz.service.IHkSourceFieldFilterService;
import com.ruoyi.quartz.service.SourceService;
import com.ruoyi.quartz.util.SourceUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据接入字段配置Controller
 * 
 * @author liuf
 * @date 2021-01-14
 */
@Controller
@RequestMapping("/monitor/source")
public class HkSourceFieldConfigController extends BaseController
{
    private String prefix = "monitor/job";

    @Autowired
    private IHkSourceFieldConfigService hkSourceFieldConfigService;
    
    @Autowired
    private IHkSourceFieldFilterService hkSourceFieldFilterService;
    
    @Autowired
    private SourceService sourceService;

    /**
     * 
     * @param jobId
     * @param mmap
     * @return
     */
    @GetMapping("/fieldconfig/{jobId}")
    public String config(@PathVariable("jobId") String jobId, ModelMap mmap)
    {
    	HkSourceFieldConfig hkSourceFieldConfig = new HkSourceFieldConfig();
    	hkSourceFieldConfig.setSourceId(Integer.parseInt(jobId));
    	List<HkSourceFieldConfig> list = hkSourceFieldConfigService.selectHkSourceFieldConfigList(hkSourceFieldConfig);
    	if(null ==list || list.isEmpty()){
    		 // 保存列信息
    		hkSourceFieldConfig.setSourceId(-1);
    		hkSourceFieldConfig.setIsShow("1");
    		List<HkSourceFieldConfig> filedList = hkSourceFieldConfigService.selectHkSourceFieldConfigList(hkSourceFieldConfig);
    		for(HkSourceFieldConfig field:filedList){
    			field.setSourceId(Integer.parseInt(jobId));
    			SourceUtils.initColumnField(field);
    			hkSourceFieldConfigService.insertHkSourceFieldConfig(field);
    		}
    	}
    	HkSourceFieldFilter hkSourceFieldFilter = new HkSourceFieldFilter();
    	hkSourceFieldFilter.setSourceId(Long.parseLong(jobId));
        List<HkSourceFieldFilter> filterList = hkSourceFieldFilterService.selectHkSourceFieldFilterList(hkSourceFieldFilter);

    	if(null == filterList || filterList.isEmpty()){
    		
        	hkSourceFieldFilter.setSourceId(-1l);
        	filterList = hkSourceFieldFilterService.selectHkSourceFieldFilterList(hkSourceFieldFilter);
        	if(null != filterList && !filterList.isEmpty()){
        		for(HkSourceFieldFilter filter:filterList){
        			filter.setSourceId(Long.parseLong(jobId));
        			filter.setId(null);
        			hkSourceFieldFilterService.insertHkSourceFieldFilter(filter);
        		}
        	}
        }
    	
    	Source source = sourceService.findHkSource(Integer.parseInt(jobId));
    	mmap.put("source", source);
    	SysUser user = ShiroUtils.getSysUser();
    	source.setUpdateUser(user.getUserName());
        return prefix + "/fieldConfig";
    }

    /**
     * 查询数据接入字段配置列表
     */
    @RequiresPermissions("system:config:list")
    @PostMapping("/fieldlist")
    @ResponseBody
    public TableDataInfo list(HkSourceFieldConfig hkSourceFieldConfig)
    {
//        startPage();
        List<HkSourceFieldConfig> list = hkSourceFieldConfigService.selectHkSourceFieldConfigList(hkSourceFieldConfig);
        return getDataTable(list);
    }
    
    @PostMapping("/saveField")
    @ResponseBody
    public AjaxResult save(Source source)
    {
    	List<HkSourceFieldConfig> list = source.getFieldList();
    	for(HkSourceFieldConfig c:list){
    		c.setSourceId(source.getId());
    		hkSourceFieldConfigService.updateHkSourceFieldConfig(c);
    	}
    	
    	List<HkSourceFieldFilter> filterList = source.getFilterList();
    	for(HkSourceFieldFilter filter:filterList){
    		filter.setSourceId(Long.parseLong(source.getId()+""));
    		hkSourceFieldFilterService.updateHkSourceFieldFilter(filter);
    	}
        return toAjax(true);
    }
    
    /**
     * 查询选择来源列名称
     */
    @GetMapping("/toSelectSourceColumnPage/{sourceId}/{columnId}")
    public String selectSourceColumn(@PathVariable("sourceId") String sourceId,@PathVariable("columnId") String columnId, ModelMap mmap) {
        mmap.put("sourceId", sourceId);
        mmap.put("columnId", columnId);
        return prefix + "/selectSourceColumn";
    }

    /**
     * 查询数据源字段列表
     */
    @PostMapping("/ajaxSourceColumnList")
    @ResponseBody
    public TableDataInfo ajaxSourceColumnList(HkSourceFieldConfig hkSourceFieldConfig)
    {
        List<HkSourceFieldConfig> list = hkSourceFieldConfigService.getHkSourceFieldConfigBySourceId(hkSourceFieldConfig.getSourceId());
        return getDataTable(list);
    }
}
