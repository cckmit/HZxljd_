package com.ruoyi.system.service.impl.unifyAdress;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.unifyAdress.XlUnifyAddressInfo;
import com.ruoyi.system.mapper.XlUnifyAddressInfoMapper;
import com.ruoyi.system.service.unifyAdress.IXlUnifyAddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-20
 */
@Service
public class XlUnifyAddressInfoServiceImpl implements IXlUnifyAddressInfoService
{
    @Autowired
    private XlUnifyAddressInfoMapper xlUnifyAddressInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param unifyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public XlUnifyAddressInfo selectXlUnifyAddressInfoById(Long unifyId)
    {
        return xlUnifyAddressInfoMapper.selectXlUnifyAddressInfoById(unifyId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param xlUnifyAddressInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<XlUnifyAddressInfo> selectXlUnifyAddressInfoList(XlUnifyAddressInfo xlUnifyAddressInfo)
    {
        return xlUnifyAddressInfoMapper.selectXlUnifyAddressInfoList(xlUnifyAddressInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param xlUnifyAddressInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertXlUnifyAddressInfo(XlUnifyAddressInfo xlUnifyAddressInfo)
    {
        xlUnifyAddressInfo.setCreateTime(DateUtils.getNowDate());
        return xlUnifyAddressInfoMapper.insertXlUnifyAddressInfo(xlUnifyAddressInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param xlUnifyAddressInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateXlUnifyAddressInfo(XlUnifyAddressInfo xlUnifyAddressInfo)
    {
        xlUnifyAddressInfo.setUpdateTime(DateUtils.getNowDate());
        return xlUnifyAddressInfoMapper.updateXlUnifyAddressInfo(xlUnifyAddressInfo);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlUnifyAddressInfoByIds(String ids)
    {
        return xlUnifyAddressInfoMapper.deleteXlUnifyAddressInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param unifyId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteXlUnifyAddressInfoById(Long unifyId)
    {
        return xlUnifyAddressInfoMapper.deleteXlUnifyAddressInfoById(unifyId);
    }
}
