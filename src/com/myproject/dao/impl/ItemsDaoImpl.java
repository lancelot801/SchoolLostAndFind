package com.myproject.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javassist.bytecode.ByteArray;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.dao.DataAccessDao;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.Items;
import com.myproject.vo.ItemsCategory;
import com.myproject.vo.ItemsStatues;

public class ItemsDaoImpl implements DataAccessDao<Items> {

	private QueryRunner qr = new QueryRunner();

	@Override
	public int add(Items items) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into items(ItemsName,ItemDescribtion,ItemsStatues,CategoryId) values(?,?,?,?)";
		int i = qr.update(conn, sql, items.getItemsName(), items
				.getItemsDescribtion(), items.getItemsStatues().getStatuesId(),
				items.getItemsCategory().getCategoryId());
		DbUtils.close(conn);
		return i;
	}

	@Override
	public int remove(Items items) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from items where ItemsId=?";
		int flag = qr.update(conn, sql, items.getItemsId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(Items items) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update items set ItemsName=?,"
				+ "ItemDescribtion=?,ItemsStatues=?,CategoryId=? where ItemsId=?";
		int flag = qr.update(conn, sql, items.getItemsName(), items
				.getItemsDescribtion(), items.getItemsStatues().getStatuesId(),
				items.getItemsCategory().getCategoryId(), items.getItemsId());
		return flag;
	}

	@Override
	public Items find(Items items) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		Items result = new Items();
		ItemsStatues statues = new ItemsStatues();
		ItemsCategory category = new ItemsCategory();
		String sql = "select * from items where ItemsId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				items.getItemsId());
		if (map == null) {
			return null;
		} else {
			result.setItemsId(Integer.parseInt(map.get("ItemsId").toString()
					.trim()));
			result.setItemsName(map.get("ItemsName").toString());
			result.setItemsDescribtion(map.get("ItemDescribtion").toString());
			statues.setStatuesId(Integer.parseInt(map.get("ItemsStatues")
					.toString().trim()));
			result.setItemsStatues(statues);
			category.setCategoryId(Integer.parseInt(map.get("CategoryId")
					.toString().trim()));
			result.setItemsCategory(category);
			DbUtils.close(conn);
			return result;
		}
	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		List<Map<String, Object>> mapList = null;
		String sql = "select * from items";
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
