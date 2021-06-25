package com.ruoyi.web.controller.ding;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.HkOfficialDocument;
import com.ruoyi.system.service.ding.DingOfficialDocumentService;
import com.ruoyi.web.annotation.IdentityVerify;
import com.ruoyi.web.annotation.IdentityVerifys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingOfficalDocumentController
 * @Author: guohailong
 * @Description: 浙政钉-公文管理
 * @Date: 2021/3/10 20:17
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingOfficialDocumentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DingOfficialDocumentController.class);

    @Resource
    private DingOfficialDocumentService dingOfficialDocumentService;


    /**
     * 获取公文列表
     *
     * @return
     */
    @GetMapping("/document/list")
    public AjaxResult getDocumentList() {

        return AjaxResult.success(dingOfficialDocumentService.getDocumentList());
    }

    /**
     * 获取公文详情
     *
     * @param uid
     * @param did
     * @return
     */
    @IdentityVerify
    @GetMapping("/document/{uid}/{did}")
    public AjaxResult getDocumentDetail(@PathVariable @IdentityVerifys Long uid, @PathVariable Long did) {
        //获取公文详情
        HkOfficialDocument documentDetail = dingOfficialDocumentService.getDocumentDetail(did);
        //判断当前用户是否收藏当前文章
        boolean collectFlag = checkIsCollect(uid, did);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("documentDetail", documentDetail);
        resultMap.put("collectFlag", collectFlag);
        return AjaxResult.success(resultMap);
    }

    /**
     * 收藏/取消
     * 调用接口查询存在的话,则删除当前关系.取消收藏.若不存在.则添加对应关系.收藏成功
     * 收藏成功 返回10
     * 取消成功 返回20
     *
     * @param uid
     * @param did
     * @return
     */
    @IdentityVerify
    @PostMapping("/document/collect")
    public AjaxResult collection(@IdentityVerifys Long uid, Long did) {
        int collectionResult = dingOfficialDocumentService.collection(uid, did);
        return AjaxResult.success(collectionResult);
    }


    /**
     * 通过用户id和公文id判断是否收藏
     *
     * @param uid
     * @param did
     * @return
     */
    private boolean checkIsCollect(Long uid, Long did) {
        return dingOfficialDocumentService.checkIsCollect(uid, did);
    }

}
