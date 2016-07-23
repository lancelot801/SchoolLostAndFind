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
import com.myproject.vo.Account;
import com.myproject.vo.Items;
import com.myproject.vo.Losing;

public class LosingDaoImpl implements DataAccessDao<Losing> {

	private QueryRunner qr = new QueryRunner();

	// 添加
	@Override
	public int add(Losing losing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into losing(ItemsId,Finder,LosingTime) values(?,?,?)";
		int flag = qr.update(conn, sql, losing.getItems().getItemsId(), losing
				.getFinder().getUserId(), losing.getLosingTime());
		DbUtils.close(conn);
		return flag;
	}

	// 移除
	@Override
	public int remove(Losing losing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from losing where LosingId=?";
		int flag = qr.update(conn, sql, losing.getLosingId());
		DbUtils.close(conn);
		return flag;
	}

	// 修改信息
	@Override
	public int save(Losing losing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update losing set ItemsId=?,Finder=?,LosingTime=? "
				+ "where LosingId=?";
		int flag = qr.update(conn, sql, losing.getItems().getItemsId(), losing
				.getFinder().getUserId(), losing.getLosingTime(), losing
				.getLosingId());
		DbUtils.close(conn);
		return flag;
	}

	// 查询信息
	@Override
	public Losing find(Losing losing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from losing where LosingId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				losing.getLosingId());
		if (map == null) {
			return null;
		} else {
			Losing result = new Losing();
			result.setLosingId(Integer.parseInt(map.get("LosingId").toString()
					.trim()));
			Items items = new Items();
			items.setItemsId(Integer.parseInt(map.get("ItemsId").toString()
					.trim()));
			result.setItems(items);
			Account account = new Account();
			account.setUserId(map.get("Finder").toString().trim());
			result.setFinder(account);
			result.setLosingTime(map.get("LosingTime").toString().trim());
			DbUtils.close(conn);
			return result;
		}
	}

	// 查询所有
	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		List<Map<String, Object>> mapList = null;
		String sql = "select * from losing";
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
