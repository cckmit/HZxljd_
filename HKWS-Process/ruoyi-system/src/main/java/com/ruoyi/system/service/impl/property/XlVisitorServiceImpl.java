package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.property.XlVisitor;
import com.ruoyi.system.mapper.property.XlVisitorMapper;
import com.ruoyi.system.service.property.IXlVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 物业--访客记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-18
 */
@Service
public class XlVisitorServiceImpl implements IXlVisitorService
{
    @Autowired
    private XlVisitorMapper xlVisitorMapper;

    /**
     * 查询物业--访客记录
     *
     * @param id 物业--访客记录ID
     * @return 物业--访客记录
     */
    @Override
    public XlVisitor selectXlVisitorById(Long id)
    {
        return xlVisitorMapper.selectXlVisitorById(id);
    }

    /**
     * 查询物业--访客记录列表
     *
     * @param xlVisitor 物业--访客记录
     * @return 物业--访客记录
     */
    @Override
    public List<XlVisitor> selectXlVisitorList(XlVisitor xlVisitor)
    {
        return xlVisitorMapper.selectXlVisitorList(xlVisitor);
    }

    /**
     * 新增物业--访客记录
     *
     * @param xlVisitor 物业--访客记录
     * @return 结果
     */
    @Override
    public int insertXlVisitor(XlVisitor xlVisitor)
    {
        return xlVisitorMapper.insertXlVisitor(xlVisitor);
    }

    /**
     * 修改物业--访客记录
     *
     * @param xlVisitor 物业--访客记录
     * @return 结果
     */
    @Override
    public int updateXlVisitor(XlVisitor xlVisitor)
    {
        return xlVisitorMapper.updateXlVisitor(xlVisitor);
    }

    /**
     * 删除物业--访客记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlVisitorByIds(String ids)
    {
        return xlVisitorMapper.deleteXlVisitorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业--访客记录信息
     *
     * @param id 物业--访客记录ID
     * @return 结果
     */
    @Override
    public int deleteXlVisitorById(Long id)
    {
        return xlVisitorMapper.deleteXlVisitorById(id);
    }
    /**
     * 根据物业id查询某天或历史访客
     * @param xlVisitor
     * @return
     */
    @Override
    public List<XlVisitor> selectXlVisitorListById(XlVisitor xlVisitor) {
        return xlVisitorMapper.selectXlVisitorListById(xlVisitor);
    }

    @Override
    public List<XlVisitor> selectXlVisitorPropertyList(Integer[] villageId, XlVisitor xlVisitor) {
        HashMap map=new HashMap();
        map.put("villageId",villageId);
        map.put("xlVisitor",xlVisitor);
        return xlVisitorMapper.selectXlVisitorPropertyList(map);
    }
}
