package com.ruoyi.system.service.ding;

import com.ruoyi.system.domain.HkDingUser;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.ding
 * @ClassName: IHkDingUserService
 * @Author: guohailong
 * @Description: 浙政钉-系统用户绑定关系表
 * @Date: 2021/3/22 15:10
 * @Version: 1.0
 */
public interface IHkDingUserService {

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
     * 批量删除浙政钉-系统用户关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkDingUserByIds(String ids);

    /**
     * 删除浙政钉-系统用户关系信息
     *
     * @param id 浙政钉-系统用户关系ID
     * @return 结果
     */
    public int deleteHkDingUserById(Long id);

    HkDingUser selectHkDingUserByDingUserId(String dingUserId);

    int deleteHkDingUserBySysUserIdAndDingUserId(Long userId, String accountId);

    /**
     * 根据系统用户id判断,当前系统账户是否已被使用
     * @param userId
     * @return
     */
    HkDingUser selectHkDingUserBySysUserId(Long userId);
}
