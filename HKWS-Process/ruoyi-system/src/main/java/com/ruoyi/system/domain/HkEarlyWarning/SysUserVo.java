package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.SysRanks;
import com.ruoyi.system.domain.SysUser;

/**s
 * @author FanKaibiao
 * @date 2020-11-16-16:41
 */
public class SysUserVo extends SysUser {

    /**用户id集合**/
    private Long[] userIds;

    private static Integer pageNum = 1;

    private static Integer pageSize = 10;

    @Override
    public Long[] getUserIds() {
        return userIds;
    }

    @Override
    public void setUserIds(Long[] userIds) {
        this.userIds = userIds;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
