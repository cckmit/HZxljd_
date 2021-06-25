package com.ruoyi.system.service;

import com.ruoyi.system.domain.HkUserDocument;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service
 * @ClassName: IHkUserDocumentService
 * @Author: guohailong
 * @Description:
 * @Date: 2021/3/10 20:42
 * @Version: 1.0
 */
public interface IHkUserDocumentService {



    /**
     * 查询用户公文收藏关系列表
     *
     * @param hkUserDocument 用户公文收藏关系
     * @return 用户公文收藏关系集合
     */
    public List<HkUserDocument> selectHkUserDocumentList(HkUserDocument hkUserDocument);

    /**
     * 新增用户公文收藏关系
     *
     * @param hkUserDocument 用户公文收藏关系
     * @return 结果
     */
    public int insertHkUserDocument(HkUserDocument hkUserDocument);



    /**
     * 批量删除用户公文收藏关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkUserDocumentByIds(String ids);

    /**
     * 删除用户公文收藏关系信息
     *
     * @param userId 用户公文收藏关系ID
     * @return 结果
     */
    public int deleteHkUserDocumentById(Long userId);

}
