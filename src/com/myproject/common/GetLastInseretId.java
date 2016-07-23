package com.myproject.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import com.myproject.utils.JdbcUtils;

/**
 * ��ҪΪ��ȡ�²���ı������
 * @author dntch
 *
 */
public class GetLastInseretId {
     private String tableName;//��������
     private String idName;//����������
     protected QueryRunner qr = new QueryRunner();//���ݷ���
     
     public GetLastInseretId(){
    	 
     }
        
     /**
      * ��ȡĳ������������
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
