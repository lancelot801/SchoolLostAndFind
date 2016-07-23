package com.myproject.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import com.myproject.utils.JdbcUtils;

/**
 * 主要为获取新插入的表的主键
 * @author dntch
 *
 */
public class GetLastInseretId {
     private String tableName;//表格的名字
     private String idName;//主键的名字
     protected QueryRunner qr = new QueryRunner();//数据访问
     
     public GetLastInseretId(){
    	 
     }
        
     /**
      * 获取某个表最大的主键
      * @return
     * @throws SQLException 
      */
     public int getTableMaxId(String tableName,String primaryName) throws SQLException{
    	 int flag = 0;
    	 Connection conn = JdbcUtils.getConnection();
    	 String sql = "select max("+primaryName+") from "+tableName;    	 
    	 Statement statement = conn.createStatement();    
    	 ResultSet rs = statement.executeQuery(sql);
    	 while(rs.next()){
    		flag = rs.getInt(1);
    	 }
    	 conn.close();
    	 return flag;
     }
     
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	          
}
