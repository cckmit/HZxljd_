package com.ruoyi.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.exception.user.UserException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.HkEntity.UserInfoDto;
import com.ruoyi.system.domain.HkEntity.UserPostRegionVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户 业务层处理
 *
 * @author ruoyi
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRanksMapper ranksMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPostMapper postMapper;

    @Autowired
    private SysDeptMapper deptMapper;

    @Autowired
    private SysUserPostMapper userPostMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private SysUserPostRegionMapper userPostRegionMapper;

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUserList(SysUser user)
    {
        return userMapper.selectUserList(user);
    }

    @Override
    public PageInfo<SysUserResultVo> queryUser(SysUserVo user) {
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        if(StringUtils.isEmpty(user.getUserIds())){
            user.setUserIds(null);
        }
        List<SysUserResultVo> list = userMapper.queryUser(user);
        for(SysUserResultVo vo : list){
            List<Map<String, Object>> deptList = new ArrayList<>();
            if(!StringUtils.isEmpty(vo.getDeptIds())){
                String[] arr = vo.getDeptIds().split(",");
                for(String id : arr){
                    List<Map<String, Object>> listMap = deptMapper.queryAllDeptByUser(Long.parseLong(id));
                    for(Map<String, Object> map : listMap){
                        if(!deptList.contains(map)){
                            deptList.add(map);
                        }
                    }
                }
            }
            vo.setDeptIds("");
            vo.setDepts(deptList);
        }
        PageInfo<SysUserResultVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 根据条件分页查询已分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectAllocatedList(SysUser user)
    {
        return userMapper.selectAllocatedList(user);
    }

    @Override
    public List<UserInfoDto> selectCanBeChoose(Map<String, Object> map) {
        List<UserInfoDto> sysUsers = userMapper.selectCanBeChoose(map);
        if(sysUsers != null && sysUsers.size() > 0){
            for(UserInfoDto user : sysUsers){
                Map<String,List<UserPostRegionVo>> userPostRegionStr = new HashMap<>();
                List<UserPostRegionVo> sysUserPostRegionList = userPostRegionMapper.queryUserPostRegionInfo((long) user.getUserId());
                if(sysUserPostRegionList != null && sysUserPostRegionList.size() > 0){
                    //职能对应区域集合
                    userPostRegionStr = sysUserPostRegionList.stream().collect(
                            Collectors.groupingBy(
                                    post ->post.getPostId().toString() //根据岗位id分组
                            ));
                    user.setUserParams(userPostRegionStr);
                }
            }
        }
        return sysUsers;
    }

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUnallocatedList(SysUser user)
    {
        return userMapper.selectUnallocatedList(user);
    }

    @Override
    public SysUser selectUserByidAndDelFalg(SysUser user) {
        return userMapper.selectUserByidAndDelFalg(user);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByLoginName(String userName)
    {
        return userMapper.selectUserByLoginName(userName);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByPhoneNumber(String phoneNumber)
    {
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByEmail(String email)
    {
        return userMapper.selectUserByEmail(email);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }

    /**
     * 通过用户ID查询用户和角色关联
     *
     * @param userId 用户ID
     * @return 用户和角色关联列表
     */
    @Override
    public List<SysUserRole> selectUserRoleByUserId(Long userId)
    {
        return userRoleMapper.selectUserRoleByUserId(userId);
    }

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long userId)
    {
        int result = 0;
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 删除用户与岗位表
        /*userPostMapper.deleteUserPostByUserId(userId);*/
        //删除用户与岗位，区域关联
        userMapper.deleteUserPostRegionByUserId(userId);

        result = userMapper.deleteUserById(userId);
        if(result > 0){
            ranksMapper.deleteRanksById(userId);
        }
        return result;
    }

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteUserByIds(String ids) throws BusinessException
    {
        int result = 0;
        Long[] userIds = Convert.toLongArray(ids);
        for (Long userId : userIds)
        {
            checkUserAllowed(new SysUser(userId));
        }
        result = userMapper.deleteUserByIds(userIds);
        if(result > 0){
            ranksMapper.deleteRanksByIds(userIds);
        }
        return result;
    }

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(SysUser user)
    {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        //获取到用户的ID
        Integer userId = Integer.valueOf(user.getUserId().toString());
        List<SysUserPostRegion> aslist=new ArrayList<>();
        //获取到存放所有岗位，和区域的集合
        String mxListStr = user.getMxListStr();
        if(!StringUtils.isEmpty(mxListStr)){
            //吧string字符串转换为数组对象
            List<MxListStrVo> object = JSON.parseArray(mxListStr, MxListStrVo.class);
            for (MxListStrVo mxListStrVo : object) {
                Integer postId = mxListStrVo.getPostId();
                SysUserPostRegionVo[] regionList = mxListStrVo.getRegionList();
                for (SysUserPostRegionVo vo : regionList) {
                    Integer regionId = vo.getId();
                    SysUserPostRegion supd=new SysUserPostRegion(userId,postId,regionId);
                    aslist.add(supd);
                }
            }
            try {
                userMapper.insertUserPostRegion(aslist);
            }catch (Exception e){
                Throwable cause = e.getCause();
                if (cause instanceof SQLIntegrityConstraintViolationException){
                    log.error("sys_user_post_region表异常，违反唯一约束，异常信息:{}",e.getMessage());
                    throw new UserException("1000","同一个职位中不能有相同的区域，请仔细检查后再次保存。","");
                }
            }
        }
        // 新增用户与角色管理
        insertUserRole(user.getUserId(), user.getRoleIds());
        if("1".equals(user.getIsRanks())){
            SysUser sysUser = userMapper.selectUserByLoginName(user.getLoginName());
            SysRanks ranks = new SysRanks();
            BeanUtils.copyProperties(sysUser,ranks);
            ranks.setRanksId(sysUser.getUserId());
            ranks.setRanksName(sysUser.getUserName());
            ranks.setPhone(sysUser.getPhonenumber());
            ranksMapper.insertRanks(ranks);
        }
        return rows;
    }

    /**
     * 注册用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean registerUser(SysUser user)
    {
        user.setUserType(UserConstants.REGISTER_USER_TYPE);
        return userMapper.insertUser(user) > 0;
    }

    /**
     * 修改保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUser(SysUser user)
    {
        int result = 0;
        Long userId = user.getUserId();
        Integer intUserId=Integer.valueOf(userId.toString());
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(user.getUserId(), user.getRoleIds());
        // 删除用户与岗位关联
        userPostMapper.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
        insertUserPost(user);


        //删除用户与所有的岗位，区域的关联
        userMapper.deleteUserPostRegionByUserId(userId);
        //新增用户与岗位，区域的关联
        List<Map<String, List<SysUserPostRegionVo>>> list = new ArrayList<>();
        //定义一个集合
        List<SysUserPostRegion> aslist=new ArrayList<>();
        //获取到存放所有岗位，和区域的集合
        String mxListStr = user.getMxListStr();
        //吧string字符串转换为数组对象
        List<MxListStrVo> object = JSON.parseArray(mxListStr, MxListStrVo.class);
        for (MxListStrVo mxListStrVo : object) {
            Integer postId = mxListStrVo.getPostId();
            SysUserPostRegionVo[] regionList = mxListStrVo.getRegionList();
            for (SysUserPostRegionVo vo : regionList) {
                Integer regionId = vo.getId();
                SysUserPostRegion upr = new SysUserPostRegion(Integer.valueOf(userId.toString()),postId,regionId);
                aslist.add(upr);
            }
        }
        try {
            userMapper.insertUserPostRegion(aslist);
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException){
                log.error("sys_user_post_region表异常，违反唯一约束，异常信息:{}",e.getMessage());
                throw new UserException("1000","同一个职位中不能有相同的区域，请仔细检查后再次保存。","");
            }
        }
        result = userMapper.updateUser(user);
        if(result > 0){
            SysRanks ranks = new SysRanks();
            BeanUtils.copyProperties(user,ranks);
            ranks.setRanksId(user.getUserId());
            ranks.setRanksName(user.getUserName());
            ranks.setPhone(user.getPhonenumber());
            ranksMapper.updateRanks(ranks);
        }
        return  result;
    }

    /**
     * 修改用户个人详细信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 用户授权角色
     *
     * @param userId 用户ID
     * @param roleIds 角色组
     */
    @Override
    public void insertUserAuth(Long userId, Long[] roleIds)
    {
        userRoleMapper.deleteUserRoleByUserId(userId);
        insertUserRole(userId, roleIds);
    }

    /**
     * 修改用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetUserPwd(SysUser user)
    {
        return updateUserInfo(user);
    }

    /**
     * 新增用户角色信息
     *
     * @param
     */
    public void insertUserRole(Long userId, Long[] roleIds)
    {
        if (StringUtils.isNotNull(roleIds))
        {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roleIds)
            {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.size() > 0)
            {
                userRoleMapper.batchUserRole(list);
            }
        }
    }

    /**
     * 新增用户岗位信息
     *
     * @param user 用户对象
     */
    public void insertUserPost(SysUser user)
    {
        Long[] posts = user.getPostIds();
        if (StringUtils.isNotNull(posts))
        {
            // 新增用户与岗位管理
            List<SysUserPost> list = new ArrayList<SysUserPost>();
            for (Long postId : posts)
            {
                SysUserPost up = new SysUserPost();
                up.setUserId(user.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            if (list.size() > 0)
            {
                userPostMapper.batchUserPost(list);
            }
        }
    }

    /**
     * 校验登录名称是否唯一
     *
     * @param loginName 用户名
     * @return
     */
    @Override
    public String checkLoginNameUnique(String loginName)
    {
        int count = userMapper.checkLoginNameUnique(loginName);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkPhoneUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkEmailUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    @Override
    public void checkUserAllowed(SysUser user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && user.isAdmin())
        {
            throw new BusinessException("不允许操作超级管理员用户");
        }
    }

    /**
     * 查询用户所属角色组
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserRoleGroup(Long userId)
    {
        List<SysRole> list = roleMapper.selectRolesByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysRole role : list)
        {
            idsStr.append(role.getRoleName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /**
     * 查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserPostGroup(Long userId)
    {
        List<SysPost> list = postMapper.selectPostsByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysPost post : list)
        {
            idsStr.append(post.getPostName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /**
     * 导入用户数据
     *
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (SysUser user : userList)
        {
            try
            {
                // 验证是否存在这个用户
                SysUser u = userMapper.selectUserByLoginName(user.getLoginName());
                if (StringUtils.isNull(u))
                {
                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    user.setCreateBy(operName);
                    this.insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    user.setUpdateBy(operName);
                    this.updateUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getLoginName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getLoginName() + " 导入失败：";
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

    /**
     * 用户状态修改
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int changeStatus(SysUser user)
    {
        int result = 0;
        result = userMapper.updateUser(user);
        if(result > 0){
            SysRanks ranks = new SysRanks();
            BeanUtils.copyProperties(user,ranks);
            ranks.setRanksId(user.getUserId());
            ranks.setRanksName(user.getUserName());
            ranks.setPhone(user.getPhonenumber());
            ranksMapper.updateRanks(ranks);
        }
        return result;
    }

    /*暂无用*/
    @Override
    public int insertSysuser(SysUser sysUser) {
        return userMapper.insertSysuser(sysUser);
    }

    @Override
    public void insertUserRole(SysUserRole sysUserRole) {
        userRoleMapper.insertUserRole(sysUserRole);
    }

    @Override
    public int findUserCount(SysUser sysUser) {
        return userMapper.findUserCount(sysUser);
    }

    @Override
    public List<SysUser> findAllUserName(String regionId) {
        return userMapper.findAllUserName(regionId);
    }

    @Override
    public List<SysUserPostRegionVo> findUserPostByRegionId(String regionId) {
        return userMapper.findUserPostByRegionId(regionId);
    }

    @Override
    public List<SysUserPostRegion> selectUserPostRegionByRidPid(String regionId, String postId) {
        return userMapper.selectUserPostRegionByRidPid(regionId,postId);
    }

    @Override
    public SysUser queryUserByOpenId(String openId) {
        return userMapper.queryUserByOpenId(openId);
    }

    @Override
    public void updateUserOpenid(SysUser user) {
        SysUser sysUser = this.selectUserByLoginName(user.getLoginName());
        sysUser.setOpenId(user.getOpenId());
        userMapper.updateOpenIdByUser(sysUser);
        int count = userMapper.updateUser(sysUser);
        if(count == 0){
            throw new BusinessException("openid更新失败");
        }
    }

    @Override
    public int findUserCountByParam(Map<String, Object> params) {
        return userMapper.findUserCountByParam(params);
    }

    @Override
    public List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysisByRegionName(Map<String, Object> params) {
        return userMapper.queryPeopleDisposalAnalysisByRegionName(params);
    }

    @Override
    public List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysis(Map<String, Object> params) {
        return userMapper.queryPeopleDisposalAnalysis(params);
    }

    @Override
    public List<PeopleTimeVO> queryPeopleTime(Map<String, Object> params) {
        return userMapper.queryPeopleTime(params);
    }

    //通过角色名称查询用户信息
    @Override
    public List<SysUser> selectUserByRoleName(String roleName) {
        return userMapper.selectUserByRoleName(roleName);
    }
    @Override
    public Long insertUserInfo(SysUser sysUser) {
        userMapper.insertUserInfo(sysUser);
        return sysUser.getUserId();
    }
}
