package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HkProcessDocument;

/**
 * 流程档案Service接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface IHkProcessDocumentService 
{
    /**
     * 查询流程档案
     * 
     * @param id 流程档案ID
     * @return 流程档案
     */
    public HkProcessDocument selectHkProcessDocumentById(Long id);

    /**
     * 查询流程档案列表
     * 
     * @param hkProcessDocument 流程档案
     * @return 流程档案集合
     */
    public List<HkProcessDocument> selectHkProcessDocumentList(HkProcessDocument hkProcessDocument);

    /**
     * 新增流程档案
     * 
     * @param hkProcessDocument 流程档案
     * @return 结果
     */
    public int insertHkProcessDocument(HkProcessDocument hkProcessDocument);

    /**
     * 修改流程档案
     * 
     * @param hkProcessDocument 流程档案
     * @return 结果
     */
    public int updateHkProcessDocument(HkProcessDocument hkProcessDocument);

    /**
     * 批量删除流程档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkProcessDocumentByIds(String ids);

    /**
     * 删除流程档案信息
     * 
     * @param id 流程档案ID
     * @return 结果
     */
    public int deleteHkProcessDocumentById(Long id);
}
