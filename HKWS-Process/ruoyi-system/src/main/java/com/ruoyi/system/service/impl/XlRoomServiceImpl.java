package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XlEnterpriseInfo;
import com.ruoyi.system.domain.XlRoom;
import com.ruoyi.system.mapper.XlRoomMapper;
import com.ruoyi.system.service.IXlRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 房屋信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-17
 */
@Service
public class XlRoomServiceImpl implements IXlRoomService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private XlRoomMapper xlRoomMapper;

    /**
     * 查询房屋信息
     *
     * @param id 房屋信息ID
     * @return 房屋信息
     */
    @Override
    public XlRoom selectXlRoomById(Long id) {
        return xlRoomMapper.selectXlRoomById(id);
    }

    /**
     * 查询房屋信息列表
     *
     * @param xlRoom 房屋信息
     * @return 房屋信息
     */
    @Override
    public List<XlRoom> selectXlRoomList(XlRoom xlRoom) {
        return xlRoomMapper.selectXlRoomList(xlRoom);
    }

    /**
     * 新增房屋信息
     *
     * @param xlRoom 房屋信息
     * @return 结果
     */
    @Override
    public int insertXlRoom(XlRoom xlRoom) {
//        xlRoom.setCreateTime(DateUtils.getNowDate());
        return xlRoomMapper.insertXlRoom(xlRoom);
    }

    /**
     * 修改房屋信息
     *
     * @param xlRoom 房屋信息
     * @return 结果
     */
    @Override
    public int updateXlRoom(XlRoom xlRoom) {
        return xlRoomMapper.updateXlRoom(xlRoom);
    }

    /**
     * 删除房屋信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlRoomByIds(String ids) {
        return xlRoomMapper.deleteXlRoomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房屋信息信息
     *
     * @param id 房屋信息ID
     * @return 结果
     */
    @Override
    public int deleteXlRoomById(Long id) {
        return xlRoomMapper.deleteXlRoomById(id);
    }

    @Override
    public int queryRoomAll(XlRoom xlRoom) {
        return xlRoomMapper.queryRoomAll(xlRoom);
    }

    @Override
    public int queryCommercialCount(XlRoom xlRoom) {
        return xlRoomMapper.queryCommercialCount(xlRoom);
    }

    @Override
    public int querySelfBuiltCount(XlRoom xlRoom) {
        return xlRoomMapper.querySelfBuiltCount(xlRoom);
    }

    @Override
    public List<XlEnterpriseInfo> queryRoomDetail(int id) {
        return xlRoomMapper.queryRoomDetail(id);
    }

    @Override
    public int queryRoomCount(Map<String, Object> thingResult) {
        return xlRoomMapper.queryRoomCount(thingResult);
    }

    @Override
    public List<XlRoom> queryRoomId(String address) {
        return xlRoomMapper.queryRoomId(address);
    }

    @Override
    public List<XlRoom>  selectXlPersonnelListAll() {
        return xlRoomMapper.selectXlPersonnelListAll();
    }

    @Override
    public void updatePersonVillageId(Map<String, Object> thingResult) {
        xlRoomMapper.updatePersonVillageId(thingResult);
    }

    @Override
    public String queryRoomAdress(Integer roomId) {
        return xlRoomMapper.queryRoomAdress(roomId);
    }

    @Override
    public Integer queryRoomListCount(Map<String, Object> paramsAll) {
        return xlRoomMapper.queryRoomListCount(paramsAll);
    }

    @Override
    public String importRoom(List<XlRoom> xlRoomList, boolean isUpdateSupport) {
        {
            if (StringUtils.isNull(xlRoomList) || xlRoomList.size() == 0) {
                throw new BusinessException("导入房屋数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            for (XlRoom xlRoom : xlRoomList) {
                try {
                    // 验证是否存在这条数据
                    XlRoom u = xlRoomMapper.selectXlRoomByAddress(xlRoom.getAddress());
                    if (StringUtils.isNull(u)) {
                        setDic(xlRoom);//设置字典项
                        this.insertXlRoom(xlRoom);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、房屋 " + xlRoom.getAddress() + " 导入成功");
                    } else if (isUpdateSupport) {
                        setDic(xlRoom);
                        this.updateXlRoom(xlRoom);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、房屋 " + xlRoom.getAddress() + " 更新成功");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、房屋 " + xlRoom.getAddress() + " 已存在");
                    }
                } catch (Exception e) {
                    failureNum++;
                    //+ user.getLoginName()
                    String msg = "<br/>" + failureNum + "、房屋 " + " 导入失败：";
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
    public List<XlRoom> selectXlRoomInIds(String[] arr) {
        return xlRoomMapper.selectXlRoomInIds(arr);
    }

    @Override
    public List<Map<String,Object>> findbuilding(Integer deptId, Integer villageId) {
        return xlRoomMapper.findbuilding(deptId,villageId);
    }

    @Override
    public List<Map<String,Object>> findUnit(Integer deptId, Integer villageId, Integer buildingCode) {
        return xlRoomMapper.findUnit(deptId,villageId,buildingCode);
    }


    private void setDic(XlRoom xlRoom) {
        if (xlRoom.getRoomType().trim().equals("商品房")) {
            xlRoom.setRoomType("1");
        } else if (xlRoom.getRoomType().trim().equals("自建房")) {
            xlRoom.setRoomType("2");
        }
        if (xlRoom.getEconomicType().trim().equals("一般户")) {
            xlRoom.setEconomicType("1");
        } else if (xlRoom.getEconomicType().trim().equals("贫困残疾户")) {
            xlRoom.setEconomicType("2");
        } else if (xlRoom.getEconomicType().trim().equals("低保户")) {
            xlRoom.setEconomicType("3");
        } else if (xlRoom.getEconomicType().trim().equals("分散供养特困户")) {
            xlRoom.setEconomicType("4");
        }
        if (xlRoom.getUseType().trim().equals("用作经营用房")) {
            xlRoom.setUseType("1");
        } else if (xlRoom.getUseType().trim().equals("非用作经营用房")) {
            xlRoom.setUseType("2");
        }
        if (xlRoom.getAround().trim().equals("平地")) {
            xlRoom.setAround("1");
        } else if (xlRoom.getAround().trim().equals("低洼地")) {
            xlRoom.setAround("2");
        } else if (xlRoom.getAround().trim().equals("水边")) {
            xlRoom.setAround("3");
        } else if (xlRoom.getAround().trim().equals("山边")) {
            xlRoom.setAround("4");
        } else if (xlRoom.getAround().trim().equals("地质灾害易发区")) {
            xlRoom.setAround("5");
        } else if (xlRoom.getAround().trim().equals("海边")) {
            xlRoom.setAround("6");
        } else if (xlRoom.getAround().trim().equals("其他")) {
            xlRoom.setAround("7");
        }
        if (xlRoom.getBuildType().trim().equals("空斗")) {
            xlRoom.setBuildType("1");
        } else if (xlRoom.getBuildType().trim().equals("实砌")) {
            xlRoom.setBuildType("2");
        } else if (xlRoom.getBuildType().trim().equals("其他")) {
            xlRoom.setBuildType("3");
        }
        if (xlRoom.getStructureType().trim().contains("砖石结构") && !xlRoom.getStructureType().trim().contains("非预制板")) {
            xlRoom.setStructureType("1");
        } else if (xlRoom.getStructureType().trim().contains("砖石结构") && xlRoom.getStructureType().trim().contains("非预制板")) {
            xlRoom.setStructureType("2");
        } else if (xlRoom.getStructureType().trim().equals("混凝土结构")) {
            xlRoom.setStructureType("3");
        } else if (xlRoom.getStructureType().trim().equals("混杂结构")) {
            xlRoom.setStructureType("4");
        } else if (xlRoom.getStructureType().trim().equals("土木结构")) {
            xlRoom.setStructureType("5");
        } else if (xlRoom.getStructureType().trim().equals("钢结构")) {
            xlRoom.setStructureType("6");
        } else if (xlRoom.getStructureType().trim().equals("其他")) {
            xlRoom.setStructureType("7");
        }
        if (xlRoom.getAdding().trim().equals("有")) {
            xlRoom.setAdding("0");
        } else if (xlRoom.getAdding().trim().equals("无")) {
            xlRoom.setAdding("1");
        }
        if (xlRoom.getCellar().trim().equals("有")) {
            xlRoom.setCellar("0");
        } else if (xlRoom.getCellar().trim().equals("无")) {
            xlRoom.setCellar("1");
        }
        if (xlRoom.getThreeNo().trim().equals("是")) {
            xlRoom.setThreeNo("0");
        } else if (xlRoom.getThreeNo().trim().equals("否")) {
            xlRoom.setThreeNo("1");
        }
        if (xlRoom.getBoard().trim().equals("有")) {
            xlRoom.setBoard("0");
        } else if (xlRoom.getBoard().trim().equals("无")) {
            xlRoom.setBoard("1");
        }
        if (xlRoom.getProcedures().trim().equals("有")) {
            xlRoom.setProcedures("0");
        } else if (xlRoom.getProcedures().trim().equals("无")) {
            xlRoom.setProcedures("1");
        }
        if (xlRoom.getPlanNote().trim().equals("有")) {
            xlRoom.setPlanNote("0");
        } else if (xlRoom.getPlanNote().trim().equals("无")) {
            xlRoom.setPlanNote("1");
        }
        if (xlRoom.getCertificate().trim().equals("有")) {
            xlRoom.setCertificate("0");
        } else if (xlRoom.getCertificate().trim().equals("无")) {
            xlRoom.setCertificate("1");
        }
        if (xlRoom.getAssistance().trim().equals("是")) {
            xlRoom.setAssistance("0");
        } else if (xlRoom.getAssistance().trim().equals("否")) {
            xlRoom.setAssistance("1");
        }
        if (xlRoom.getAppraisal().trim().equals("未鉴定")) {
            xlRoom.setAppraisal("1");
        } else if (xlRoom.getAppraisal().trim().equals("A")) {
            xlRoom.setAppraisal("2");
        } else if (xlRoom.getAppraisal().trim().equals("B")) {
            xlRoom.setAppraisal("3");
        } else if (xlRoom.getAppraisal().trim().equals("C")) {
            xlRoom.setAppraisal("4");
        } else if (xlRoom.getAppraisal().trim().equals("D")) {
            xlRoom.setAppraisal("5");
        }
        if (xlRoom.getDanger().trim().equals("基本安全")) {
            xlRoom.setDanger("1");
        } else if (xlRoom.getDanger().trim().equals("存在风险")) {
            xlRoom.setDanger("2");
        }else if (xlRoom.getDanger().trim().equals("其他")) {
            xlRoom.setDanger("3");
        }
        if (xlRoom.getReinforce().trim().equals("是")) {
            xlRoom.setReinforce("0");
        } else if (xlRoom.getReinforce().trim().equals("否")) {
            xlRoom.setReinforce("1");
        }
        if (xlRoom.getRenovate().equals("已整治")) {
            xlRoom.setRenovate("1");
        } else if (xlRoom.getRenovate().equals("无整治计划")) {
            xlRoom.setRenovate("2");
        } else if (xlRoom.getRenovate().equals("计划半年内")) {
            xlRoom.setRenovate("3");
        } else if (xlRoom.getRenovate().equals("计划一年内")) {
            xlRoom.setRenovate("4");
        } else if (xlRoom.getRenovate().equals("其他")) {
            xlRoom.setRenovate("5");
        }
        if (xlRoom.getWaterflood().trim().equals("是")) {
            xlRoom.setWaterflood("0");
        } else if (xlRoom.getWaterflood().trim().equals("否")) {
            xlRoom.setWaterflood("1");
        }
    }
}
