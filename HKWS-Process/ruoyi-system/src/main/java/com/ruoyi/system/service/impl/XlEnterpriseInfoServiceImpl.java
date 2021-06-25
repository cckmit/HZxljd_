package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XlEnterpriseInfo;
import com.ruoyi.system.mapper.XlEnterpriseInfoMapper;
import com.ruoyi.system.service.IXlEnterpriseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公共管理--企业信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Service
public class XlEnterpriseInfoServiceImpl implements IXlEnterpriseInfoService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private XlEnterpriseInfoMapper xlEnterpriseInfoMapper;

    /**
     * 查询公共管理--企业信息
     *
     * @param id 公共管理--企业信息ID
     * @return 公共管理--企业信息
     */
    @Override
    public XlEnterpriseInfo selectXlEnterpriseInfoById(Long id)
    {
        return xlEnterpriseInfoMapper.selectXlEnterpriseInfoById(id);
    }

    @Override
    public List<XlEnterpriseInfo> selectXlEnterpriseInfoInIds(String[] ids) {
        return xlEnterpriseInfoMapper.selectXlEnterpriseInfoInIds(ids);
    }

    /**
     * 查询公共管理--企业信息列表
     *
     * @param xlEnterpriseInfo 公共管理--企业信息
     * @return 公共管理--企业信息
     */
    @Override
    public List<XlEnterpriseInfo> selectXlEnterpriseInfoList(XlEnterpriseInfo xlEnterpriseInfo)
    {
        return xlEnterpriseInfoMapper.selectXlEnterpriseInfoList(xlEnterpriseInfo);
    }

    /**
     * 新增公共管理--企业信息
     *
     * @param xlEnterpriseInfo 公共管理--企业信息
     * @return 结果
     */
    @Override
    public int insertXlEnterpriseInfo(XlEnterpriseInfo xlEnterpriseInfo)
    {
        return xlEnterpriseInfoMapper.insertXlEnterpriseInfo(xlEnterpriseInfo);
    }

    /**
     * 修改公共管理--企业信息
     *
     * @param xlEnterpriseInfo 公共管理--企业信息
     * @return 结果
     */
    @Override
    public int updateXlEnterpriseInfo(XlEnterpriseInfo xlEnterpriseInfo)
    {
        return xlEnterpriseInfoMapper.updateXlEnterpriseInfo(xlEnterpriseInfo);
    }

    /**
     * 删除公共管理--企业信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlEnterpriseInfoByIds(String ids)
    {
        return xlEnterpriseInfoMapper.deleteXlEnterpriseInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公共管理--企业信息信息
     *
     * @param id 公共管理--企业信息ID
     * @return 结果
     */
    @Override
    public int deleteXlEnterpriseInfoById(Long id)
    {
        return xlEnterpriseInfoMapper.deleteXlEnterpriseInfoById(id);
    }

    @Override
    public String checkEnterpriseNameUnique(String enterpriseName) {
        int count = xlEnterpriseInfoMapper.checkEnterpriseNameUnique(enterpriseName);
        if (count > 0)
        {
            return Constants.FAIL;
        }
        return Constants.SUCCESS;
    }

    @Override
    public String importEnterpriseInfo(List<XlEnterpriseInfo> xlEnterpriseInfoList, boolean isUpdateSupport) {
        {
            if (StringUtils.isNull(xlEnterpriseInfoList) || xlEnterpriseInfoList.size() == 0)
            {
                throw new BusinessException("导入企业数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            for (XlEnterpriseInfo xlEnterpriseInfo : xlEnterpriseInfoList)
            {
                try
                {
                    // 验证是否存在这条数据
                    XlEnterpriseInfo u = xlEnterpriseInfoMapper.selectXlEstateManagementByEnterpriseName(xlEnterpriseInfo.getEnterpriseName());
                    if (StringUtils.isNull(u))
                    {
                        setDic(xlEnterpriseInfo);
                        this.insertXlEnterpriseInfo(xlEnterpriseInfo);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、企业 "+ xlEnterpriseInfo.getEnterpriseName()  + " 导入成功");
                    }
                    else if (isUpdateSupport)
                    {
                        setDic(xlEnterpriseInfo);
                        this.updateXlEnterpriseInfo(xlEnterpriseInfo);
                        successNum++;
                        //+ user.getLoginName()
                        successMsg.append("<br/>" + successNum + "、企业 "+ xlEnterpriseInfo.getEnterpriseName()  + " 更新成功");
                    }
                    else
                    {
                        failureNum++;
                        //+ user.getLoginName()
                        failureMsg.append("<br/>" + failureNum + "、企业 "+ xlEnterpriseInfo.getEnterpriseName()  + " 已存在");
                    }
                }
                catch (Exception e)
                {
                    failureNum++;
                    //+ user.getLoginName()
                    String msg = "<br/>" + failureNum + "、企业 "  + " 导入失败：";
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

    public void setDic(XlEnterpriseInfo xlEnterpriseInfo) {
        //根据表格内容,设置企业类型和状态码存入数据库
        if(xlEnterpriseInfo.getEnterpriseStatusName().trim().equals("在业")) {
            xlEnterpriseInfo.setEnterpriseStatus(1);
        } else if(xlEnterpriseInfo.getEnterpriseStatusName().trim().equals("存续")){
            xlEnterpriseInfo.setEnterpriseStatus(2);
        }else if(xlEnterpriseInfo.getEnterpriseStatusName().trim().equals("注销")){
            xlEnterpriseInfo.setEnterpriseStatus(3);
        }else if(xlEnterpriseInfo.getEnterpriseStatusName().trim().contains("已注销")){
            xlEnterpriseInfo.setEnterpriseStatus(4);
        }else if(xlEnterpriseInfo.getEnterpriseStatusName().trim().contains("未注销")) {
            xlEnterpriseInfo.setEnterpriseStatus(5);
        }

        if (xlEnterpriseInfo.getEnterpriseType().trim().equals("个体工商户") || xlEnterpriseInfo.getEnterpriseType().trim().contains("个体工商户")) {
            xlEnterpriseInfo.setEnterpriseTypeNum(1);
        } else {
            xlEnterpriseInfo.setEnterpriseTypeNum(2);
        }
    }

    @Override
    public List<XlEnterpriseInfo> selectenterpriseType() {
        return xlEnterpriseInfoMapper.selectenterpriseType();
    }

    @Override
    public void updateenterprisesCode(XlEnterpriseInfo xlEnterpriseInfo) {
        xlEnterpriseInfoMapper.updateenterprisesCode(xlEnterpriseInfo);
    }

    @Override
    public void updateenterprises(XlEnterpriseInfo xlEnterpriseInfo) {
        xlEnterpriseInfoMapper.updateenterprises(xlEnterpriseInfo);
    }

    @Override
    public void updateenterprisesNumber(XlEnterpriseInfo xlEnterpriseInfo) {
        xlEnterpriseInfoMapper.updateenterprisesNumber(xlEnterpriseInfo);
    }

    @Override
    public int queryEnterpriseAll(XlEnterpriseInfo xlEnterpriseInfo) {
        return xlEnterpriseInfoMapper.queryEnterpriseAll(xlEnterpriseInfo);
    }

    @Override
    public int queryListedEnterprise(XlEnterpriseInfo xlEnterpriseInfo) {
        return xlEnterpriseInfoMapper.queryListedEnterprise(xlEnterpriseInfo);
    }
    @Override
    public List<XlEnterpriseInfo> selectXlEnterpriseInfo(Map<String,Object> result) {
        return xlEnterpriseInfoMapper.selectXlEnterpriseInfo(result);
    }

    @Override
    public int queryListGeTiEnterprise(XlEnterpriseInfo xlEnterpriseInfo) {
        return xlEnterpriseInfoMapper.queryListGeTiEnterprise(xlEnterpriseInfo);
    }

/*    @Override
    public List<XlEnterpriseInfo> queryGeTiList() {
        return xlEnterpriseInfoMapper.queryGeTiList();
    }*/

}
