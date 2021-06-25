package com.ruoyi.quartz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.quartz.domain.Source;


/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-11-06 14:12
 **/
public class DBHelper {

    private static Logger logger = LogManager.getLogger();

    /**
     * @description 创建MYSQL连接信息
     * @param jdbcurl
     * @param sourceUsername
     * @param sourcePassword
     * @param autoCommit
     * @return
     */
    public static Connection initMysql(String jdbcurl, String sourceUsername, String sourcePassword, boolean autoCommit) {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection(jdbcurl, sourceUsername, sourcePassword);
            conn.setAutoCommit(autoCommit);
//            logger.debug(jdbcurl);
//            logger.debug("username=【"+username+"】");
//            logger.debug("MYSQL DATABASE: Connection success!");
        }catch(Exception se) {
            //连接失败
            conn = null;
//            logger.debug("initMYSQL："+jdbcurl + "\r\n" + " Connection failed! " + se.getMessage());
            logger.error("MYSQL连接失败",se);
            return null;
        }
        return conn;
    }

    /**
     * 创建postgtesSQL连接信息
     * @param jdbcurl
     * @param sourceUsername
     * @param sourcePassword
     * @param autoCommit
     * @return
     */
    public static Connection initPostgetSQL(String jdbcurl, String sourceUsername, String sourcePassword, boolean autoCommit) {
        Connection conn=null;
        try {
            Class.forName("org.postgresql.Driver");
            //连接数据库
            conn = DriverManager.getConnection(jdbcurl, sourceUsername, sourcePassword);
            conn.setAutoCommit(autoCommit);
            logger.debug(jdbcurl);
            logger.debug("username=【"+sourceUsername+"】");
            logger.debug("postgresql DATABASE: Connection success!");
        }catch(Exception se) {
            //连接失败
            conn = null;
//            logger.debug("initMYSQL："+jdbcurl + "\r\n" + " Connection failed! " + se.getMessage());
            logger.error("postgtesSQL连接失败",se);
            return null;
        }
        return conn;
    }
    
    /**
     * 根据数据源获取数据库连接
     * @param source
     * @return
     */
    public static Connection getConnection(Source source){
    	 String connectionURL ="";
    	 Connection conn = null;
         try {
        	 	String sourceAccess = source.getDataType();
				if(sourceAccess.equals(Constants.DATA_SOURCE_MYSQL)){
					Class.forName("com.mysql.jdbc.Driver");
					connectionURL=String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%%2B8&nullCatalogMeansCurrent=true",
							source.getSourceHost(),source.getSourcePort(),source.getSourceDbName());
				}else if(sourceAccess.equals(Constants.DATA_SOURCE_ORACLE)){
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connectionURL=String.format("jdbc:oracle:thin:@%s:%s:%s",source.getSourceHost(),source.getSourcePort(),source.getSourceDbName());
				}else if(sourceAccess.equals(Constants.DATA_SOURCE_POSTGETSQL)){
					Class.forName("org.postgresql.Driver");
					connectionURL=String.format("jdbc:postgresql://%s:%s/%s",source.getSourceHost(),source.getSourcePort(),source.getSourceDbName());
				}
             conn = DriverManager.getConnection(connectionURL, source.getSourceUsername(), source.getSourcePassword());
         } catch (ClassNotFoundException e) {
        	 logger.error(e.getMessage(), e);
         } catch (SQLException e) {
        	 logger.error(e.getMessage(), e);
         }
         if (conn == null) {
             throw new RuntimeException("数据库连接失败！URL:{" + connectionURL + "}, userName:{" + source.getSourceUsername() + "}, password:{" + source.getSourcePassword() + "}");
         }
         return conn;
    }
    
    public static List<Map<String,String>> getTableColumns(Source source){
    	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
    	try{
    	Connection conn = getConnection(source);
    	}catch(Exception e){
    		
    	}
    	return list;
    }
    
    
    public static void main(String[] args) {
		Source source = new Source();
		source.setSourceHost("localhost");
		source.setSourcePort("3306");
		source.setSourceDbName("maao-db");
		source.setSourceUsername("root");
		source.setSourcePassword("test");
		source.setSourceAccess(Constants.DATA_SOURCE_MYSQL);
		try{
			Connection conn = getConnection(source);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
