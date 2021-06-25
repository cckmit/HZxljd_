package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.unifyAdress.XlUnifyAddressInfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-20
 */
public interface XlUnifyAddressInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param unifyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public XlUnifyAddressInfo selectXlUnifyAddressInfoById(Long unifyId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param xlUnifyAddressInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<XlUnifyAddressInfo> selectXlUnifyAddressInfoList(XlUnifyAddressInfo xlUnifyAddressInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param xlUnifyAddressInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertXlUnifyAddressInfo(XlUnifyAddressInfo xlUnifyAddressInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param xlUnifyAddressInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateXlUnifyAddressInfo(XlUnifyAddressInfo xlUnifyAddressInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param unifyId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteXlUnifyAddressInfoById(Long unifyId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param unifyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlUnifyAddressInfoByIds(String[] unifyIds);
}
