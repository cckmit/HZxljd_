package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlLeaseMapper;
import com.ruoyi.system.domain.XlLease;
import com.ruoyi.system.service.IXlLeaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出租房信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
@Service
public class XlLeaseServiceImpl implements IXlLeaseService 
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private XlLeaseMapper xlLeaseMapper;

    /**
     * 查询出租房信息
     * 
     * @param id 出租房信息ID
     * @return 出租房信息
     */
    @Override
    public XlLease selectXlLeaseById(Long id)
    {
        return xlLeaseMapper.selectXlLeaseById(id);
    }

    /**
     * 查询出租房信息列表
     * 
     * @param xlLease 出租房信息
     * @return 出租房信息
     */
    @Override
    public List<XlLease> selectXlLeaseList(XlLease xlLease)
    {
        return xlLeaseMapper.selectXlLeaseList(xlLease);
    }

    /**
     * 新增出租房信息
     * 
     * @param xlLease 出租房信息
     * @return 结果
     */
    @Override
    public int insertXlLease(XlLease xlLease)
    {
        return xlLeaseMapper.insertXlLease(xlLease);
    }

    /**
     * 修改出租房信息
     * 
     * @param xlLease 出租房信息
     * @return 结果
     */
    @Override
    public int updateXlLease(XlLease xlLease)
    {
        return xlLeaseMapper.updateXlLease(xlLease);
    }

    /**
     * 删除出租房信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlLeaseByIds(String ids)
    {
        return xlLeaseMapper.deleteXlLeaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除出租房信息信息
     * 
     * @param id 出租房信息ID
     * @return 结果
     */
    @Override
    public int deleteXlLeaseById(Long id)
    {
        return xlLeaseMapper.deleteXlLeaseById(id);
    }

    @Override
    public String importLease(List<XlLease> xlLeaseList, boolean isUpdateSupport) {
        if (StringUtils.isNull(xlLeaseList) || xlLeaseList.size() == 0) {
            throw new BusinessException("导入出租房数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (XlLease xlLease : xlLeaseList) {
            try {
                // 验证是否存在这条数据
                XlLease u = xlLeaseMapper.selectXlLeaseByAddress(xlLease.getLeaseAddress().trim());
                if (StringUtils.isNull(u)) {
                    setDic(xlLease);
                    this.insertXlLease(xlLease);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、出租房 " + xlLease.getLeaseName() + " 导入成功");
                } else if (isUpdateSupport) {
                    setDic(xlLease);
                    this.updateXlLease(xlLease);
                    successNum++;
                    //+ user.getLoginName()
                    successMsg.append("<br/>" + successNum + "、出租房 " + xlLease.getLeaseName() + " 更新成功");
                } else {
                    failureNum++;
                    //+ user.getLoginName()
                    failureMsg.append("<br/>" + failureNum + "、出租房 " + xlLease.getLeaseName() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                //+ user.getLoginName()
                String msg = "<br/>" + failureNum + "、人员 " + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    private void setDic(XlLease xlLease) {
        if(xlLease.getRoomType().trim().equals("商品房")){
            xlLease.setRoomTypeStatus(1);
        }else if(xlLease.getRoomType().trim().equals("自建房")){
            xlLease.setRoomTypeStatus(2);
        }

        if(xlLease.getLeaseType().trim().equals("出租")){
            xlLease.setLeaseTypeStatus(1);
        }else if(xlLease.getLeaseType().trim().equals("自住")){
            xlLease.setLeaseTypeStatus(2);
        }
    }

    @Override
    public int queryRoomListCount(Map<String, Object> thingResult) {
        return xlLeaseMapper.queryRoomListCount(thingResult);
    }
}
