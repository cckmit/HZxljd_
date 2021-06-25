package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HkUserDocument;
import com.ruoyi.system.mapper.HkUserDocumentMapper;
import com.ruoyi.system.service.IHkUserDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl
 * @ClassName: IHkUserDocumentServiceImpl
 * @Author: guohailong
 * @Description:
 * @Date: 2021/3/10 20:43
 * @Version: 1.0
 */
@Service
public class IHkUserDocumentServiceImpl implements IHkUserDocumentService {

    @Autowired
    private HkUserDocumentMapper hkUserDocumentMapper;



    /**
     * 查询用户公文收藏关系列表
     *
     * @param hkUserDocument 用户公文收藏关系
     * @return 用户公文收藏关系
     */
    @Override
    public List<HkUserDocument> selectHkUserDocumentList(HkUserDocument hkUserDocument)
    {
        return hkUserDocumentMapper.selectHkUserDocumentList(hkUserDocument);
    }

    /**
     * 新增用户公文收藏关系
     *
     * @param hkUserDocument 用户公文收藏关系
     * @return 结果
     */
    @Override
    public int insertHkUserDocument(HkUserDocument hkUserDocument)
    {
        return hkUserDocumentMapper.insertHkUserDocument(hkUserDocument);
    }



    /**
     * 删除用户公文收藏关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkUserDocumentByIds(String ids)
    {
        return hkUserDocumentMapper.deleteHkUserDocumentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户公文收藏关系信息
     *
     * @param userId 用户公文收藏关系ID
     * @return 结果
     */
    @Override
    public int deleteHkUserDocumentById(Long userId)
    {
        return hkUserDocumentMapper.deleteHkUserDocumentById(userId);
    }

}
