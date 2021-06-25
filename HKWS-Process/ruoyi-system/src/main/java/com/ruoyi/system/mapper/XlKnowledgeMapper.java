package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XlKnowledge;

/**
 * 街道管理-知识库Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
public interface XlKnowledgeMapper 
{
    /**
     * 查询街道管理-知识库
     * 
     * @param id 街道管理-知识库ID
     * @return 街道管理-知识库
     */
    public XlKnowledge selectXlKnowledgeById(Long id);

    /**
     * 查询街道管理-知识库列表
     * 
     * @param xlKnowledge 街道管理-知识库
     * @return 街道管理-知识库集合
     */
    public List<XlKnowledge> selectXlKnowledgeList(XlKnowledge xlKnowledge);

    /**
     * 新增街道管理-知识库
     * 
     * @param xlKnowledge 街道管理-知识库
     * @return 结果
     */
    public int insertXlKnowledge(XlKnowledge xlKnowledge);

    /**
     * 修改街道管理-知识库
     * 
     * @param xlKnowledge 街道管理-知识库
     * @return 结果
     */
    public int updateXlKnowledge(XlKnowledge xlKnowledge);

    /**
     * 删除街道管理-知识库
     * 
     * @param id 街道管理-知识库ID
     * @return 结果
     */
    public int deleteXlKnowledgeById(Long id);

    /**
     * 批量删除街道管理-知识库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlKnowledgeByIds(String[] ids);
}
