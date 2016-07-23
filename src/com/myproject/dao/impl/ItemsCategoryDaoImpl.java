package com.myproject.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.dao.DataAccessDao;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.ItemsCategory;

public class ItemsCategoryDaoImpl implements DataAccessDao<ItemsCategory> {

	private QueryRunner qr = new QueryRunner();
	
	@Override
	public int add(ItemsCategory itemsCategory) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into itemscategory(CategoryName) values(?)";
		int flag = qr.update(conn, sql, itemsCategory.getCategoryName());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int remove(ItemsCategory itemsCategory) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from itemscategory where CategoryId=?";
		int flag = qr.update(conn, sql, itemsCategory.getCategoryId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(ItemsCategory itemsCategory) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update itemscategory set CategoryName=?" + "where CategoryId=?";
		int flag = qr.update(conn, sql, itemsCategory.getCategoryName(),
				itemsCategory.getCategoryId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public ItemsCategory find(ItemsCategory itemsCategory) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from itemsCategory where " + "CategoryId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				itemsCategory.getCategoryId());
		if(map == null){
			return null;
		}else{
			ItemsCategory result = new ItemsCategory();
			result.setCategoryId(Integer.parseInt(map.get("CategoryId").toString()
					.trim()));
			result.setCategoryName(map.get("CategoryName").toString().trim());
			return result;
		}	
	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from itemscategory";
		List<Map<String, Object>> mapList = null;
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

	 
}
