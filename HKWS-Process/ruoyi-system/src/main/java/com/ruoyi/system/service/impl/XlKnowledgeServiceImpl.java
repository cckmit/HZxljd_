package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlKnowledgeMapper;
import com.ruoyi.system.domain.XlKnowledge;
import com.ruoyi.system.service.IXlKnowledgeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 街道管理-知识库Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-19
 */
@Service
public class XlKnowledgeServiceImpl implements IXlKnowledgeService 
{
    @Autowired
    private XlKnowledgeMapper xlKnowledgeMapper;

    /**
     * 查询街道管理-知识库
     * 
     * @param id 街道管理-知识库ID
     * @return 街道管理-知识库
     */
    @Override
    public XlKnowledge selectXlKnowledgeById(Long id)
    {
        return xlKnowledgeMapper.selectXlKnowledgeById(id);
    }

    /**
     * 查询街道管理-知识库列表
     * 
     * @param xlKnowledge 街道管理-知识库
     * @return 街道管理-知识库
     */
    @Override
    public List<XlKnowledge> selectXlKnowledgeList(XlKnowledge xlKnowledge)
    {
        return xlKnowledgeMapper.selectXlKnowledgeList(xlKnowledge);
    }

    /**
     * 新增街道管理-知识库
     * 
     * @param xlKnowledge 街道管理-知识库
     * @return 结果
     */
    @Override
    public int insertXlKnowledge(XlKnowledge xlKnowledge)
    {
        return xlKnowledgeMapper.insertXlKnowledge(xlKnowledge);
    }

    /**
     * 修改街道管理-知识库
     * 
     * @param xlKnowledge 街道管理-知识库
     * @return 结果
     */
    @Override
    public int updateXlKnowledge(XlKnowledge xlKnowledge)
    {
        return xlKnowledgeMapper.updateXlKnowledge(xlKnowledge);
    }

    /**
     * 删除街道管理-知识库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlKnowledgeByIds(String ids)
    {
        return xlKnowledgeMapper.deleteXlKnowledgeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除街道管理-知识库信息
     * 
     * @param id 街道管理-知识库ID
     * @return 结果
     */
    @Override
    public int deleteXlKnowledgeById(Long id)
    {
        return xlKnowledgeMapper.deleteXlKnowledgeById(id);
    }
}
