package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.HkUserDocument;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingUserDocumentMapper
 * @Author: guohailong
 * @Description: 浙政钉-用户公文收藏关系
 * @Date: 2021/3/10 21:17
 * @Version: 1.0
 */
public interface DingUserDocumentMapper {

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
     * 删除用户公文收藏关系
     *
     * @param userId 用户公文收藏关系ID
     * @return 结果
     */
    public int deleteHkUserDocumentById(Long userId);

    /**
     * 批量删除用户公文收藏关系
     *
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkUserDocumentByIds(String[] userIds);


    /**
     * 根据用户id和公文id查询
     *
     * @param uid
     * @param did
     * @return
     */
    HkUserDocument selectUserDocumentByUidAndDid(@Param("uid") Long uid, @Param("did") Long did);

    /**
     * 根据用户id和公文id删除
     *
     * @param uid
     * @param did
     * @return
     */
    int deleteUserDocumentByUidAndDid(@Param("uid") Long uid, @Param("did") Long did);
}
