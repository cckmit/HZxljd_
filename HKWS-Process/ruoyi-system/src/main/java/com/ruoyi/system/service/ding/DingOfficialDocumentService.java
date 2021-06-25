package com.ruoyi.system.service.ding;

import com.ruoyi.system.domain.HkOfficialDocument;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.ding
 * @ClassName: DingOfficialDocumentService
 * @Author: guohailong
 * @Description: 政务钉-公文服务
 * @Date: 2021/3/10 20:50
 * @Version: 1.0
 */
public interface DingOfficialDocumentService {

    /**
     * 获取可见公文列表
     *
     * @return
     */
    List<HkOfficialDocument> getDocumentList();

    /**
     * 获取公文详情
     *
     * @param id
     * @return
     */
    HkOfficialDocument getDocumentDetail(Long id);

    /**
     * 收藏/取消
     * 调用接出口查询存在的话,则删除当前关系.取消收藏.若不存在.则添加对应关系.收藏成功
     *
     * @param uid
     * @param did
     * @return
     */
    int collection(Long uid, Long did);

    /**
     * 判断是否收藏
     * @param uid
     * @param did
     * @return
     */
    boolean checkIsCollect(Long uid, long did);

}
