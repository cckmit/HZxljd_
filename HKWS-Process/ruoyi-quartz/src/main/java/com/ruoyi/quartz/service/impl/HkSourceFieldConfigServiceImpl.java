package com.ruoyi.quartz.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.quartz.domain.HkSourceFieldConfig;
import com.ruoyi.quartz.domain.Source;
import com.ruoyi.quartz.mapper.HkSourceFieldConfigMapper;
import com.ruoyi.quartz.mapper.SourceMapper;
import com.ruoyi.quartz.service.IHkSourceFieldConfigService;
import com.ruoyi.quartz.util.DBHelper;

/**
 * 数据接入字段配置Service业务层处理
 * 
 * @author liuf
 * @date 2021-01-14
 */
@Service
public class HkSourceFieldConfigServiceImpl implements IHkSourceFieldConfigService 
{
public static void main(String[] args) {
	JSONObject d = new JSONObject();
	d.getClass().getFields();
}
	
    @Autowired
    private HkSourceFieldConfigMapper hkSourceFieldConfigMapper;
    
    @Autowired
    private SourceMapper SourceMapper;

    
	@Override
	public List<HkSourceFieldConfig> getHkSourceFieldConfigByTable(String tableName) {
		return hkSourceFieldConfigMapper.getHkSourceFieldConfigByTable(tableName);
	}


	@Override
	public List<HkSourceFieldConfig> getHkSourceFieldConfigBySourceId(Integer sourceId) {
		Source source = SourceMapper.findHkSource(sourceId);
		List<HkSourceFieldConfig> fieldList = new ArrayList<HkSourceFieldConfig>();
		Connection conn = null;
		Statement stmt = null;
		try{
			
			conn = DBHelper.getConnection(source);
			stmt = conn.createStatement();
			String sql = "";
			if(Constants.DATA_SOURCE_MYSQL.equals(source.getDataType())){
				sql = "select column_name,column_comment,column_type from information_schema.columns where table_schema = (select database()) and table_name = '"+source.getSourceTableName()+"'order by ordinal_position";
			}else if(Constants.DATA_SOURCE_ORACLE.equals(source.getDataType())){
				sql = "select ut.COLUMN_NAME as column_name,uc.comments as column_comment,ut.DATA_TYPE as column_type ,ut.DATA_LENGTH from user_tab_columns  ut inner JOIN user_col_comments "
						+ "uc on ut.TABLE_NAME  = uc.table_name and ut.COLUMN_NAME = uc.column_name where "
						+ "ut.Table_Name='"+source.getSourceTableName()+"' ";
			}else{
				throw new Exception ("暂不支持此数据库配置");
			}
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				HkSourceFieldConfig columns = new HkSourceFieldConfig();
				columns.setSourceColumnName(rs.getString("column_name"));
				columns.setSourceColumnComment(rs.getString("column_comment"));
				columns.setSourceColumnType(rs.getString("column_type"));
				fieldList.add(columns);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
			if(null != stmt){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null != conn){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return fieldList;
	}

	
    
    /**
     * 查询数据接入字段配置
     * 
     * @param id 数据接入字段配置ID
     * @return 数据接入字段配置
     */
    @Override
    public HkSourceFieldConfig selectHkSourceFieldConfigById(Long id)
    {
        return hkSourceFieldConfigMapper.selectHkSourceFieldConfigById(id);
    }

    /**
     * 查询数据接入字段配置列表
     * 
     * @param hkSourceFieldConfig 数据接入字段配置
     * @return 数据接入字段配置
     */
    @Override
    public List<HkSourceFieldConfig> selectHkSourceFieldConfigList(HkSourceFieldConfig hkSourceFieldConfig)
    {
    	List<HkSourceFieldConfig> list = hkSourceFieldConfigMapper.selectHkSourceFieldConfigList(hkSourceFieldConfig);
        return list;
    }
    
    

    /**
     * 新增数据接入字段配置
     * 
     * @param hkSourceFieldConfig 数据接入字段配置
     * @return 结果
     */
    @Override
    public int insertHkSourceFieldConfig(HkSourceFieldConfig hkSourceFieldConfig)
    {
        hkSourceFieldConfig.setCreateTime(DateUtils.getNowDate());
        return hkSourceFieldConfigMapper.insertHkSourceFieldConfig(hkSourceFieldConfig);
    }

    /**
     * 修改数据接入字段配置
     * 
     * @param hkSourceFieldConfig 数据接入字段配置
     * @return 结果
     */
    @Override
    public int updateHkSourceFieldConfig(HkSourceFieldConfig hkSourceFieldConfig)
    {
        hkSourceFieldConfig.setUpdateTime(DateUtils.getNowDate());
        return hkSourceFieldConfigMapper.updateHkSourceFieldConfig(hkSourceFieldConfig);
    }

    /**
     * 删除数据接入字段配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkSourceFieldConfigByIds(String ids)
    {
        return hkSourceFieldConfigMapper.deleteHkSourceFieldConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据接入字段配置信息
     * 
     * @param id 数据接入字段配置ID
     * @return 结果
     */
    @Override
    public int deleteHkSourceFieldConfigById(Long id)
    {
        return hkSourceFieldConfigMapper.deleteHkSourceFieldConfigById(id);
    }



}
