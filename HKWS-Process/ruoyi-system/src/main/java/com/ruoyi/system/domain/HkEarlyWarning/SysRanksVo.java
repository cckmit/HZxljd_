package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.HkEntity.UserPostRegionVo;
import com.ruoyi.system.domain.SysRanks;

import java.util.List;
import java.util.Map;

/**s
 * @author FanKaibiao
 * @date 2020-11-16-16:41
 */
public class SysRanksVo extends SysRanks {

    /**部门ID**/
    private String deptId;

    @Excel(name = "部门名称")
    private String deptName;

    private String searchValue;

    private Map<String,List<UserPostRegionVo>> userParams;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public Map<String, List<UserPostRegionVo>> getUserParams() {
        return userParams;
    }

    @Override
    public void setUserParams(Map<String, List<UserPostRegionVo>> userParams) {
        this.userParams = userParams;
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
