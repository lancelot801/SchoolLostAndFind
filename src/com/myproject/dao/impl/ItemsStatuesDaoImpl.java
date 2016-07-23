package com.myproject.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.dao.DataAccessDao;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.ItemsStatues;

public class ItemsStatuesDaoImpl implements DataAccessDao<ItemsStatues> {

	private QueryRunner qr = new QueryRunner();

	@Override
	public int add(ItemsStatues itemsStatues) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into itemsstatues(Statues) values(?)";
		int flag = qr.update(conn, sql, itemsStatues.getStatues());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int remove(ItemsStatues itemsStatues) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from itemsstatues where StatuesId=?";
		int flag = qr.update(conn, sql, itemsStatues.getStatuesId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(ItemsStatues itemsStatues) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update itemsstatues set Statues=?" + "where StatuesId=?";
		int flag = qr.update(conn, sql, itemsStatues.getStatues(),
				itemsStatues.getStatuesId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public ItemsStatues find(ItemsStatues itemsStateus) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from itemsstatues where " + "StatuesId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				itemsStateus.getStatuesId());
		if(map == null){
			return null;
		}else{
			ItemsStatues result = new ItemsStatues();
			result.setStatuesId(Integer.parseInt(map.get("StatuesId").toString()
					.trim()));
			result.setStatues(map.get("Statues").toString().trim());
			return result;
		}		
	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from itemsstatues";
		List<Map<String, Object>> mapList = null;
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
