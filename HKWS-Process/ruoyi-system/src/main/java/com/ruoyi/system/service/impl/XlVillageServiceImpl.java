package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XlVillageModel;
import com.ruoyi.system.mapper.XlVillageMapper;
import com.ruoyi.system.service.IXlVillageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 小区信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-24
 */
@Service
public class XlVillageServiceImpl implements IXlVillageService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private XlVillageMapper xlVillageMapper;

    /**
     * 查询小区信息
     *
     * @param id 小区信息ID
     * @return 小区信息
     */
    @Override
    public XlVillageModel selectXlVillageById(Long id) {
        return xlVillageMapper.selectXlVillageById(id);
    }

    /**
     * 查询小区信息列表
     *
     * @param xlVillageModel 小区信息
     * @return 小区信息
     */
    @Override
    public List<XlVillageModel> selectXlVillageList(XlVillageModel xlVillageModel) {
        return xlVillageMapper.selectXlVillageList(xlVillageModel);
    }

    @Override
    public List<XlVillageModel> selectXlVillageLists(XlVillageModel xlVillageModel) {
        return xlVillageMapper.selectXlVillageLists(xlVillageModel);
    }

    /**
     * 新增小区信息
     *
     * @param xlVillageModel 小区信息
     * @return 结果
     */
    @Override
    public int insertXlVillage(XlVillageModel xlVillageModel) {
        xlVillageModel.setCreateTime(DateUtils.getNowDate());
        return xlVillageMapper.insertXlVillage(xlVillageModel);
    }

    /**
     * 修改小区信息
     *
     * @param xlVillageModel 小区信息
     * @return 结果
     */
    @Override
    public int updateXlVillage(XlVillageModel xlVillageModel) {
        xlVillageModel.setUpdateTime(DateUtils.getNowDate());
        return xlVillageMapper.updateXlVillage(xlVillageModel);
    }

    /**
     * 删除小区信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlVillageByIds(String ids) {
        return xlVillageMapper.deleteXlVillageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小区信息信息
     *
     * @param id 小区信息ID
     * @return 结果
     */
    @Override
    public int deleteXlVillageById(Long id) {
        return xlVillageMapper.deleteXlVillageById(id);
    }

    @Override
    public String checkVillageCodeUnique(String xlVillageModelCode) {
        int count = xlVillageMapper.checkVillageCodeUnique(xlVillageModelCode);
        if (count > 0) {
            return Constants.FAIL;
        }
        return Constants.SUCCESS;
    }

    @Override
    public String checkVillageNameUnique(String xlVillageModelName) {
        int count = xlVillageMapper.checkVillageNameUnique(xlVillageModelName);
        if (count > 0) {
            return Constants.FAIL;
        }
        return Constants.SUCCESS;
    }

    @Override
    public List<XlVillageModel> selectdeptNames() {
        return xlVillageMapper.selectdeptNames();
    }

    @Override
    public String importVillage(List<XlVillageModel> xlVillageList, boolean isUpdateSupport) {
        {
            if (StringUtils.isNull(xlVillageList) || xlVillageList.size() == 0) {
                throw new BusinessException("导入小区数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            for (XlVillageModel xlVillage : xlVillageList) {
                try {
                    // 验证是否存在这条数据
                    int num = xlVillageMapper.checkVillageNameUnique(xlVillage.getName().trim());
                    if (num==0) {
                        this.insertXlVillage(xlVillage);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、小区 " + xlVillage.getName() + " 导入成功");
                    } else if (isUpdateSupport) {
                        this.updateXlVillage(xlVillage);
                        successNum++;
                        //+ user.getLoginName()
                        successMsg.append("<br/>" + successNum + "、小区 " + xlVillage.getName() + " 更新成功");
                    } else {
                        failureNum++;
                        //+ user.getLoginName()
                        failureMsg.append("<br/>" + failureNum + "、小区 " + xlVillage.getName() + " 已存在");
                    }
                } catch (Exception e) {
                    failureNum++;
                    //+ user.getLoginName()
                    String msg = "<br/>" + failureNum + "、小区 " + " 导入失败：";
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
    }
    @Override
    public int queryVillageCount() {
        return xlVillageMapper.queryVillageCount();
    }

    @Override
    public List<XlVillageModel> selectXlVillageByPropertyName(String propertyName) {
        return  xlVillageMapper.selectXlVillageByPropertyName(propertyName);
    }

    @Override
    public List<XlVillageModel> selectNames() {
        return xlVillageMapper.selectNames();
    }

    @Override
    public Integer[] selectVillageId(String propertyId, String propertyName) {
        return xlVillageMapper.selectVillageId(propertyId,propertyName);
    }

    @Override
    public List<XlVillageModel> queryVillageList() {
        return xlVillageMapper.queryVillageList();
    }

    @Override
    public List<XlVillageModel> queryVillageComList() {
        return xlVillageMapper.queryVillageComList();
    }

    @Override
    public List<XlVillageModel> queryPropertyList() {
        return xlVillageMapper.queryPropertyList();
    }

    @Override
    public int queryVillageId(XlVillageModel xlVillageModel) {
        return xlVillageMapper.queryVillageId(xlVillageModel);
    }

    @Override
    public List<XlVillageModel> queryvillageName(XlVillageModel xlVillageModel) {
        return xlVillageMapper.queryvillageName(xlVillageModel);
    }

    @Override
    public List<Map<String,Object>> findVillageIdsNames(Integer deptId) {
        return xlVillageMapper.findVillageIdsNames(deptId);
    }


}

