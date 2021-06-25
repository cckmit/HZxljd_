package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.HkDingUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: HkDingUserMapper
 * @Author: guohailong
 * @Description: 浙政钉-系统用户绑定关系表
 * @Date: 2021/3/22 14:56
 * @Version: 1.0
 */
public interface HkDingUserMapper {
    /**
     * 查询浙政钉-系统用户关系
     *
     * @param id 浙政钉-系统用户关系ID
     * @return 浙政钉-系统用户关系
     */
    public HkDingUser selectHkDingUserById(Long id);

    /**
     * 查询浙政钉-系统用户关系列表
     *
     * @param hkDingUser 浙政钉-系统用户关系
     * @return 浙政钉-系统用户关系集合
     */
    public List<HkDingUser> selectHkDingUserList(HkDingUser hkDingUser);

    /**
     * 新增浙政钉-系统用户关系
     *
     * @param hkDingUser 浙政钉-系统用户关系
     * @return 结果
     */
    public int insertHkDingUser(HkDingUser hkDingUser);

    /**
     * 修改浙政钉-系统用户关系
     *
     * @param hkDingUser 浙政钉-系统用户关系
     * @return 结果
     */
    public int updateHkDingUser(HkDingUser hkDingUser);

    /**
     * 删除浙政钉-系统用户关系
     *
     * @param id 浙政钉-系统用户关系ID
     * @return 结果
     */
    public int deleteHkDingUserById(Long id);

    /**
     * 批量删除浙政钉-系统用户关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkDingUserByIds(String[] ids);


    HkDingUser selectHkDingUserByDingUserId(@Param("dingUserId")String dingUserId);

    /**
     * 推出.删除
     * @param dingUser
     * @return
     */
    int deleteHkDingUserBySysUserIdAndDingUserId(HkDingUser dingUser);

    HkDingUser selectHkDingUserBySysUserId(@Param("sysUserId") Long sysUserId);
}
