package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HkOfficialDocument;

/**
 * 公文管理Service接口
 * 
 * @author ruoyi
 * @date 2021-03-10
 */
public interface IHkOfficialDocumentService 
{
    /**
     * 查询公文管理
     * 
     * @param id 公文管理ID
     * @return 公文管理
     */
    public HkOfficialDocument selectHkOfficialDocumentById(Long id);

    /**
     * 查询公文管理列表
     * 
     * @param hkOfficialDocument 公文管理
     * @return 公文管理集合
     */
    public List<HkOfficialDocument> selectHkOfficialDocumentList(HkOfficialDocument hkOfficialDocument);

    /**
     * 新增公文管理
     * 
     * @param hkOfficialDocument 公文管理
     * @return 结果
     */
    public int insertHkOfficialDocument(HkOfficialDocument hkOfficialDocument);

    /**
     * 修改公文管理
     * 
     * @param hkOfficialDocument 公文管理
     * @return 结果
     */
    public int updateHkOfficialDocument(HkOfficialDocument hkOfficialDocument);

    /**
     * 批量删除公文管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkOfficialDocumentByIds(String ids);

    /**
     * 删除公文管理信息
     * 
     * @param id 公文管理ID
     * @return 结果
     */
    public int deleteHkOfficialDocumentById(Long id);
}
