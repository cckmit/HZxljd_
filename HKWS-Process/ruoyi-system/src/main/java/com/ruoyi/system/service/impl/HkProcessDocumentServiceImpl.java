package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkProcessDocumentMapper;
import com.ruoyi.system.domain.HkProcessDocument;
import com.ruoyi.system.service.IHkProcessDocumentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 流程档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Service
public class HkProcessDocumentServiceImpl implements IHkProcessDocumentService 
{
    @Autowired
    private HkProcessDocumentMapper hkProcessDocumentMapper;

    /**
     * 查询流程档案
     * 
     * @param id 流程档案ID
     * @return 流程档案
     */
    @Override
    public HkProcessDocument selectHkProcessDocumentById(Long id)
    {
        return hkProcessDocumentMapper.selectHkProcessDocumentById(id);
    }

    /**
     * 查询流程档案列表
     * 
     * @param hkProcessDocument 流程档案
     * @return 流程档案
     */
    @Override
    public List<HkProcessDocument> selectHkProcessDocumentList(HkProcessDocument hkProcessDocument)
    {
        return hkProcessDocumentMapper.selectHkProcessDocumentList(hkProcessDocument);
    }

    /**
     * 新增流程档案
     * 
     * @param hkProcessDocument 流程档案
     * @return 结果
     */
    @Override
    public int insertHkProcessDocument(HkProcessDocument hkProcessDocument)
    {
        hkProcessDocument.setCreateTime(DateUtils.getNowDate());
        return hkProcessDocumentMapper.insertHkProcessDocument(hkProcessDocument);
    }

    /**
     * 修改流程档案
     * 
     * @param hkProcessDocument 流程档案
     * @return 结果
     */
    @Override
    public int updateHkProcessDocument(HkProcessDocument hkProcessDocument)
    {
        hkProcessDocument.setUpdateTime(DateUtils.getNowDate());
        return hkProcessDocumentMapper.updateHkProcessDocument(hkProcessDocument);
    }

    /**
     * 删除流程档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkProcessDocumentByIds(String ids)
    {
        return hkProcessDocumentMapper.deleteHkProcessDocumentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除流程档案信息
     * 
     * @param id 流程档案ID
     * @return 结果
     */
    @Override
    public int deleteHkProcessDocumentById(Long id)
    {
        return hkProcessDocumentMapper.deleteHkProcessDocumentById(id);
    }
}
