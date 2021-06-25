package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkOfficialDocumentMapper;
import com.ruoyi.system.domain.HkOfficialDocument;
import com.ruoyi.system.service.IHkOfficialDocumentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公文管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-10
 */
@Service
public class HkOfficialDocumentServiceImpl implements IHkOfficialDocumentService 
{
    @Autowired
    private HkOfficialDocumentMapper hkOfficialDocumentMapper;

    /**
     * 查询公文管理
     * 
     * @param id 公文管理ID
     * @return 公文管理
     */
    @Override
    public HkOfficialDocument selectHkOfficialDocumentById(Long id)
    {
        return hkOfficialDocumentMapper.selectHkOfficialDocumentById(id);
    }

    /**
     * 查询公文管理列表
     * 
     * @param hkOfficialDocument 公文管理
     * @return 公文管理
     */
    @Override
    public List<HkOfficialDocument> selectHkOfficialDocumentList(HkOfficialDocument hkOfficialDocument)
    {
        return hkOfficialDocumentMapper.selectHkOfficialDocumentList(hkOfficialDocument);
    }

    /**
     * 新增公文管理
     * 
     * @param hkOfficialDocument 公文管理
     * @return 结果
     */
    @Override
    public int insertHkOfficialDocument(HkOfficialDocument hkOfficialDocument)
    {
        hkOfficialDocument.setPublicFlag(1);
        hkOfficialDocument.setDelFlag(0);
        hkOfficialDocument.setCreateTime(DateUtils.getNowDate());
        return hkOfficialDocumentMapper.insertHkOfficialDocument(hkOfficialDocument);
    }

    /**
     * 修改公文管理
     * 
     * @param hkOfficialDocument 公文管理
     * @return 结果
     */
    @Override
    public int updateHkOfficialDocument(HkOfficialDocument hkOfficialDocument)
    {
        hkOfficialDocument.setUpdateTime(DateUtils.getNowDate());
        return hkOfficialDocumentMapper.updateHkOfficialDocument(hkOfficialDocument);
    }

    /**
     * 删除公文管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkOfficialDocumentByIds(String ids)
    {
        return hkOfficialDocumentMapper.deleteHkOfficialDocumentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公文管理信息
     * 
     * @param id 公文管理ID
     * @return 结果
     */
    @Override
    public int deleteHkOfficialDocumentById(Long id)
    {
        return hkOfficialDocumentMapper.deleteHkOfficialDocumentById(id);
    }
}
