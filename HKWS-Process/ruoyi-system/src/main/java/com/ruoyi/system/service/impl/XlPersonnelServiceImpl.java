package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XlPersonnel;
import com.ruoyi.system.mapper.XlPersonnelMapper;
import com.ruoyi.system.service.IXlPersonnelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人员信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-17
 */
@Service
public class XlPersonnelServiceImpl implements IXlPersonnelService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private XlPersonnelMapper xlPersonnelMapper;

    /**
     * 查询人员信息
     *
     * @param id 人员信息ID
     * @return 人员信息
     */
    @Override
    public XlPersonnel selectXlPersonnelById(Long id) {
        return xlPersonnelMapper.selectXlPersonnelById(id);
    }

    /**
     * 查询人员信息列表
     *
     * @param xlPersonnel 人员信息
     * @return 人员信息
     */
    @Override
    public List<XlPersonnel> selectXlPersonnelList(XlPersonnel xlPersonnel) {
        return xlPersonnelMapper.selectXlPersonnelList(xlPersonnel);
    }

    /**
     * 新增人员信息
     *
     * @param xlPersonnel 人员信息
     * @return 结果
     */
    @Override
    public int insertXlPersonnel(XlPersonnel xlPersonnel) {
        xlPersonnel.setCreateTime(DateUtils.getNowDate());
        return xlPersonnelMapper.insertXlPersonnel(xlPersonnel);
    }

    /**
     * 修改人员信息
     *
     * @param xlPersonnel 人员信息
     * @return 结果
     */
    @Override
    public int updateXlPersonnel(XlPersonnel xlPersonnel) {
        xlPersonnel.setUpdateTime(DateUtils.getNowDate());
        return xlPersonnelMapper.updateXlPersonnel(xlPersonnel);
    }

    /**
     * 删除人员信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPersonnelByIds(String ids) {
        return xlPersonnelMapper.deleteXlPersonnelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员信息信息
     *
     * @param id 人员信息ID
     * @return 结果
     */
    @Override
    public int deleteXlPersonnelById(Long id) {
        return xlPersonnelMapper.deleteXlPersonnelById(id);
    }

    @Override
    public String importPersonnel(List<XlPersonnel> xlPersonnelList, boolean isUpdateSupport) {
        if (StringUtils.isNull(xlPersonnelList) || xlPersonnelList.size() == 0) {
            throw new BusinessException("导入人员数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (XlPersonnel xlPersonnel : xlPersonnelList) {
            try {
                // 验证是否存在这条数据
                XlPersonnel u = xlPersonnelMapper.selectXlPersonnelByIdcard(xlPersonnel.getIdcard());
                if (StringUtils.isNull(u)) {
                    setDic(xlPersonnel);
                    this.insertXlPersonnel(xlPersonnel);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、人员 " + xlPersonnel.getName() + " 导入成功");
                } else if (isUpdateSupport) {
                    setDic(xlPersonnel);
                    this.updateXlPersonnel(xlPersonnel);
                    successNum++;
                    //+ user.getLoginName()
                    successMsg.append("<br/>" + successNum + "、人员 " + xlPersonnel.getName() + " 更新成功");
                } else {
                    failureNum++;
                    //+ user.getLoginName()
                    failureMsg.append("<br/>" + failureNum + "、人员 " + xlPersonnel.getName() + " 已存在");
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

    @Override
    public List<XlPersonnel> selectXlPersonnelInIds(String[] ids) {
        return xlPersonnelMapper.selectXlPersonnelInIds(ids);
    }

    public void setDic(XlPersonnel xlPersonnel) {
        //根据表格内容,设置人员属性字典值
        if (xlPersonnel.getGender().trim().equals("男")) {
            xlPersonnel.setGender("1");
        } else if (xlPersonnel.getGender().trim().equals("女")) {
            xlPersonnel.setGender("2");
        } else {
            xlPersonnel.setGender("3");
        }

        if (xlPersonnel.getEducation().trim().equals("小学")) {
            xlPersonnel.setEducation("1");
        } else if (xlPersonnel.getEducation().trim().equals("初中")) {
            xlPersonnel.setEducation("2");
        } else if (xlPersonnel.getEducation().trim().equals("高中")) {
            xlPersonnel.setEducation("3");
        } else if (xlPersonnel.getEducation().trim().equals("中专")) {
            xlPersonnel.setEducation("4");
        } else if (xlPersonnel.getEducation().trim().equals("大专")) {
            xlPersonnel.setEducation("5");
        } else if (xlPersonnel.getEducation().trim().equals("本科")) {
            xlPersonnel.setEducation("6");
        } else if (xlPersonnel.getEducation().trim().equals("研究生")) {
            xlPersonnel.setEducation("7");
        } else if (xlPersonnel.getEducation().trim().equals("硕士")) {
            xlPersonnel.setEducation("8");
        } else if (xlPersonnel.getEducation().trim().equals("博士")) {
            xlPersonnel.setEducation("9");
        }

        if (xlPersonnel.getMarry().trim().equals("未婚")) {
            xlPersonnel.setMarry("1");
        } else if (xlPersonnel.getMarry().trim().equals("已婚")) {
            xlPersonnel.setMarry("2");
        } else if (xlPersonnel.getMarry().trim().equals("离婚")) {
            xlPersonnel.setMarry("3");
        } else if (xlPersonnel.getMarry().trim().equals("丧偶")) {
            xlPersonnel.setMarry("4");
        }

        if (xlPersonnel.getPolity().trim().equals("中共党员")) {
            xlPersonnel.setPolity("1");
        } else if (xlPersonnel.getPolity().trim().equals("预备党员")) {
            xlPersonnel.setPolity("2");
        } else if (xlPersonnel.getPolity().trim().equals("共青团员")) {
            xlPersonnel.setPolity("3");
        } else if (xlPersonnel.getPolity().trim().equals("民主党派")) {
            xlPersonnel.setPolity("4");
        } else if (xlPersonnel.getPolity().trim().equals("群众")) {
            xlPersonnel.setPolity("5");
        } else if (xlPersonnel.getPolity().trim().equals("其他")) {
            xlPersonnel.setPolity("6");
        }

        if (xlPersonnel.getRoomType().trim().equals("商品房")) {
            xlPersonnel.setRoomType("1");
        } else if (xlPersonnel.getRoomType().trim().equals("自建房")) {
            xlPersonnel.setRoomType("2");
        }

        if (xlPersonnel.getLiveType().trim().equals("流动人口")) {
            xlPersonnel.setLiveType("1");
        } else if (xlPersonnel.getLiveType().trim().equals("户籍人口")) {
            xlPersonnel.setLiveType("2");
        }

        if (xlPersonnel.getHouseholderRelation().trim().equals("户主")) {
            xlPersonnel.setHouseholderRelation("1");
        } else if (xlPersonnel.getHouseholderRelation().trim().equals("住户")) {
            xlPersonnel.setHouseholderRelation("2");
        } else if (xlPersonnel.getHouseholderRelation().trim().equals("租客")) {
            xlPersonnel.setHouseholderRelation("3");
        }

        if(xlPersonnel.getPropertyRight().trim().equals("是")){
            xlPersonnel.setPropertyRight("0");
        }else if(xlPersonnel.getPropertyRight().trim().equals("否")){
            xlPersonnel.setPropertyRight("1");
        }
    }

    @Override
    public int queryPersonCount(XlPersonnel xlPersonnel) {
        return xlPersonnelMapper.queryPersonCount(xlPersonnel);
    }

    @Override
    public int queryLiuPopulation(XlPersonnel xlPersonnel) {
        return xlPersonnelMapper.queryLiuPopulation(xlPersonnel);
    }

    @Override
    public int queryHuPopulation(XlPersonnel xlPersonnel) {
        return xlPersonnelMapper.queryHuPopulation(xlPersonnel);
    }

   /* @Override
    public List<XlPersonnel> queryPersonList(XlPersonnel xlPersonnel) {
        return xlPersonnelMapper.queryPersonList(xlPersonnel);
    }*/

    @Override
    public int queryPersonCountAll(Map<String, Object> thingResult) {
        return xlPersonnelMapper.queryPersonCountAll(thingResult);
    }

   /* @Override
    public void updatePersonVillageId(Map<String, Object> thingResult) {
        xlPersonnelMapper.updatePersonVillageId(thingResult);
    }

    @Override
    public List<XlPersonnel> selectXlPersonnelListAll() {
        return xlPersonnelMapper.selectXlPersonnelListAll();
    }*/

    @Override
    public List<XlPersonnel> queryPersonHu(Map<String,Object> params) {
        return xlPersonnelMapper.queryPersonHu(params);
    }

    @Override
    public String queryPersonVillageCode(Integer nameId) {
        return xlPersonnelMapper.queryPersonVillageCode(nameId);
    }

    @Override
    public Integer queryPersonAllList(Map<String, Object> paramsAll) {
        return xlPersonnelMapper.queryPersonAllList(paramsAll);
    }

    @Override
    public List<XlPersonnel> selectXlPersonnelWork(XlPersonnel xlPersonnel) {
        return xlPersonnelMapper.selectXlPersonnelWork(xlPersonnel);
    }

    @Override
    public List<XlPersonnel> estatePersonnelList(XlPersonnel xlPersonnel,String estateId) {
        HashMap map=new HashMap();
        map.put("xlPersonnel",xlPersonnel);
        map.put("estateId",estateId);
        return xlPersonnelMapper.estatePersonnelList(map);
    }
}
