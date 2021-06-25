package com.ruoyi.quartz.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-11-02 15:27
 **/
public class Source extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**数据源编码 */
    private  Integer id;
    @Excel(name = "数据源编码")
    private  String uuid;

    /**数据源名称 */
    @Excel(name = "用户账号")
    private String sourceName;

    /**数据源接入方式 */
    @Excel(name = "数据源接入方式")
    private String sourceAccess;

    /**数据源接入地址 */
    @Excel(name = "数据源接入地址")
    private String sourceAddress;

    /**数据源同步频率 */
    @Excel(name = "数据源同步频率")
    private String sourceSynchronize;
    
    /**
     * DB类型
     */
    private String dataType;
    
    /**
     * 同步频率值
     */
    private Integer sourceSynRateVal;

    /**主机 */
    @Excel(name = "主机")
    private String sourceHost;

    /**端口 */
    @Excel(name = "端口")
    private String sourcePort;

    /**用户名 */
    @Excel(name = "用户名")
    private String sourceUsername;

    /**密码 */
    @Excel(name = "密码")
    private String sourcePassword;
    
    /**
     * 数据库名
     */
    private String sourceDbName;
    
    /**
     * 数据库表名
     */
    private String sourceTableName;

    /**备注 */
    @Excel(name = "备注")
    private String sourceRemarks;

    /**是否删除 */
    @Excel(name = "是否删除", readConverterExp = "0=是,1=否,")
    private Integer isDelete;

    /**数据源状态 */
    @Excel(name = "数据源状态", readConverterExp = "0=正常,1=连接失败,2=禁用")
    private Integer sourceStatus;

    /**调用成功次数 */
    @Excel(name = "调用成功次数")
    private String sourceTransfer;

    /**创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /**创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /**修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    //最后修改时间
    private Date lastUpdateTime;
    
    private List<HkSourceFieldConfig> fieldList;
    
    private List<HkSourceFieldFilter> filterList;

    private Long Sysid;

    /**定时器id */
    private Long jobId;

    /** 任务组名 */
    private String jobGroup;
    /** 任务状态（0正常 1暂停） */

    private String status;

    public List<HkSourceFieldConfig> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<HkSourceFieldConfig> fieldList) {
		this.fieldList = fieldList;
	}

	public List<HkSourceFieldFilter> getFilterList() {
		return filterList;
	}

	public void setFilterList(List<HkSourceFieldFilter> filterList) {
		this.filterList = filterList;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


	public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Long getSysid() {
        return Sysid;
    }

    public void setSysid(Long sysid) {
        Sysid = sysid;
    }


    public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getSourceSynRateVal() {
		return sourceSynRateVal;
	}

	public void setSourceSynRateVal(Integer sourceSynRateVal) {
		this.sourceSynRateVal = sourceSynRateVal;
	}

	public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @NotBlank(message = "数据源名称不能为空")
    @Size(min = 0, max = 20, message = "数据源名称长度不能超过20个字符")
    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceAccess() {
        return sourceAccess;
    }

    public void setSourceAccess(String sourceAccess) {
        this.sourceAccess = sourceAccess;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getSourceSynchronize() {
        return sourceSynchronize;
    }

    public void setSourceSynchronize(String sourceSynchronize) {
        this.sourceSynchronize = sourceSynchronize;
    }

    public String getSourceHost() {
        return sourceHost;
    }

    public void setSourceHost(String sourceHost) {
        this.sourceHost = sourceHost;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getSourceUsername() {
        return sourceUsername;
    }

    public void setSourceUsername(String sourceUsername) {
        this.sourceUsername = sourceUsername;
    }

    public String getSourcePassword() {
        return sourcePassword;
    }

    public void setSourcePassword(String sourcePassword) {
        this.sourcePassword = sourcePassword;
    }
    
    
    
    public String getSourceDbName() {
		return sourceDbName;
	}

	public void setSourceDbName(String sourceDbName) {
		this.sourceDbName = sourceDbName;
	}

	public String getSourceTableName() {
		return sourceTableName;
	}

	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}

	@Size(min = 0, max = 100, message = "备注不能超过200个字符")
    public String getSourceRemarks() {
        return sourceRemarks;
    }

    public void setSourceRemarks(String sourceRemarks) {
        this.sourceRemarks = sourceRemarks;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSourceStatus() {
        return sourceStatus;
    }

    public void setSourceStatus(Integer sourceStatus) {
        this.sourceStatus = sourceStatus;
    }

    public String getSourceTransfer() {
        return sourceTransfer;
    }

    public void setSourceTransfer(String sourceTransfer) {
        this.sourceTransfer = sourceTransfer;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public Source(){

    }
    public Source(Integer id, String uuid, String sourceName, String sourceAccess, String sourceAddress, String sourceSynchronize, String sourceHost, String sourcePort, String sourceUsername, String sourcePassword, String sourceRemarks, Integer isDelete, Integer sourceStatus, String sourceTransfer, String createUser, Date createDate, String updateUser, Date updateDate) {
        this.id = id;
        this.uuid = uuid;
        this.sourceName = sourceName;
        this.sourceAccess = sourceAccess;
        this.sourceAddress = sourceAddress;
        this.sourceSynchronize = sourceSynchronize;
        this.sourceHost = sourceHost;
        this.sourcePort = sourcePort;
        this.sourceUsername = sourceUsername;
        this.sourcePassword = sourcePassword;
        this.sourceRemarks = sourceRemarks;
        this.isDelete = isDelete;
        this.sourceStatus = sourceStatus;
        this.sourceTransfer = sourceTransfer;
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "HkSource{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceAccess='" + sourceAccess + '\'' +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", sourceSynchronize='" + sourceSynchronize + '\'' +
                ", sourceHost='" + sourceHost + '\'' +
                ", sourcePort='" + sourcePort + '\'' +
                ", sourceUsername='" + sourceUsername + '\'' +
                ", sourcePassword='" + sourcePassword + '\'' +
                ", sourceRemarks='" + sourceRemarks + '\'' +
                ", isDelete=" + isDelete +
                ", sourceStatus=" + sourceStatus +
                ", sourceTransfer='" + sourceTransfer + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
