package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XlEstateManagement;
import com.ruoyi.system.domain.dto.EstateDto;
import com.ruoyi.system.mapper.XlEstateManagementMapper;
import com.ruoyi.system.service.IXlEstateManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 街道管理--物业信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Service
public class XlEstateManagementServiceImpl implements IXlEstateManagementService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private XlEstateManagementMapper xlEstateManagementMapper;

    /**
     * 查询街道管理--物业信息
     *
     * @param id 街道管理--物业信息ID
     * @return 街道管理--物业信息
     */
    @Override
    public XlEstateManagement selectXlEstateManagementById(Long id)
    {
        return xlEstateManagementMapper.selectXlEstateManagementById(id);
    }

    /**
     * 查询街道管理--物业信息列表
     *
     * @param xlEstateManagement 街道管理--物业信息
     * @return 街道管理--物业信息
     */
    @Override
    public List<XlEstateManagement> selectXlEstateManagementList(XlEstateManagement xlEstateManagement)
    {
        return xlEstateManagementMapper.selectXlEstateManagementList(xlEstateManagement);
    }

    /**
     * 新增街道管理--物业信息
     *
     * @param xlEstateManagement 街道管理--物业信息
     * @return 结果
     */
    @Override
    public int insertXlEstateManagement(XlEstateManagement xlEstateManagement)
    {
        return xlEstateManagementMapper.insertXlEstateManagement(xlEstateManagement);
    }

    /**
     * 修改街道管理--物业信息
     *
     * @param xlEstateManagement 街道管理--物业信息
     * @return 结果
     */
    @Override
    public int updateXlEstateManagement(XlEstateManagement xlEstateManagement)
    {
        return xlEstateManagementMapper.updateXlEstateManagement(xlEstateManagement);
    }

    /**
     * 删除街道管理--物业信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlEstateManagementByIds(String ids)
    {
        return xlEstateManagementMapper.deleteXlEstateManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除街道管理--物业信息信息
     *
     * @param id 街道管理--物业信息ID
     * @return 结果
     */
    @Override
    public int deleteXlEstateManagementById(Long id)
    {
        return xlEstateManagementMapper.deleteXlEstateManagementById(id);
    }

    @Override
    public String importXlEstateManagement(List<XlEstateManagement> xlEstateManagementList, Boolean isUpdateSupport) {
        {
            if (StringUtils.isNull(xlEstateManagementList) || xlEstateManagementList.size() == 0)
            {
                throw new BusinessException("导入用户数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            for (XlEstateManagement xlEstateManagement : xlEstateManagementList)
            {
                try
                {
                    // 验证是否存在这条数据
                    XlEstateManagement u = xlEstateManagementMapper.selectXlEstateManagementByquartersName(xlEstateManagement.getQuartersName());
                    if (StringUtils.isNull(u))
                    {
//                        xlEstateManagement.setQuartersName();
//                        xlEstateManagement.setEstateName();
//                        xlEstateManagement.setEstateStar();
                        this.insertXlEstateManagement(xlEstateManagement);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、小区 "+ xlEstateManagement.getQuartersName()  + " 导入成功");
                    }
                    else if (isUpdateSupport)
                    {
                        this.updateXlEstateManagement(xlEstateManagement);
                        successNum++;
                        //+ user.getLoginName()
                        successMsg.append("<br/>" + successNum + "、小区 "+ xlEstateManagement.getQuartersName()  + " 更新成功");
                    }
                    else
                    {
                        failureNum++;
                        //+ user.getLoginName()
                        failureMsg.append("<br/>" + failureNum + "、小区 "+ xlEstateManagement.getQuartersName()  + " 已存在");
                    }
                }
                catch (Exception e)
                {
                    failureNum++;
                    //+ user.getLoginName()
                    String msg = "<br/>" + failureNum + "、小区 "  + " 导入失败：";
                    failureMsg.append(msg + e.getMessage());
                    log.error(msg, e);
                }
            }
            if (failureNum > 0)
            {
                failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
                throw new BusinessException(failureMsg.toString());
            }
            else
            {
                successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
            }
            return successMsg.toString();
        }
    }

    @Override
    public int queryPropert(Map<String,Object> thingResult) {
        return xlEstateManagementMapper.queryPropert(thingResult);
    }

    @Override
    public List<EstateDto> selectXlEstateManagementCountById(Integer id) {
        return xlEstateManagementMapper.selectXlEstateManagementCountById(id);
    }

    @Override
    public List<XlEstateManagement> selectXlEstateManagementInIds(String[] ids) {
        return xlEstateManagementMapper.selectXlEstateManagementInIds(ids);
    }
    @Override
    public List<XlEstateManagement> queryPropertEfficiency() {
        return xlEstateManagementMapper.queryPropertEfficiency();
    }

    @Override
    public List<XlEstateManagement> queryPropertyDownName(XlEstateManagement xlEstateManagement) {
        return xlEstateManagementMapper.queryPropertyDownName(xlEstateManagement);
    }
}
