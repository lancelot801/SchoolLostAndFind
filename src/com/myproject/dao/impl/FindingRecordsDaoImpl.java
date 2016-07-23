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
import com.myproject.vo.FindingRecords;
import com.myproject.vo.Items;

public class FindingRecordsDaoImpl implements DataAccessDao<FindingRecords> {

	private QueryRunner qr = new QueryRunner();// dbutils核心访问

	// 添加
	@Override
	public int add(FindingRecords findingRecords) throws SQLException {
		Connection conn = JdbcUtils.getConnection();// 获取数据连接
		String sql = "insert into findingrecords(Finder,ItemsId,GetTime) values(?,?,?)";
		int flag = qr.update(conn, sql,
				findingRecords.getAccount().getUserId(), findingRecords
						.getItems().getItemsId(), findingRecords.getGetTime());
		DbUtils.close(conn);
		return flag;
	}

	// 删除
	@Override
	public int remove(FindingRecords findingRecords) throws SQLException {
		Connection conn = JdbcUtils.getConnection();// 获取数据连接
		String sql = "delete from findingrecords where FindingRecordsId=?";
		int flag = qr.update(conn, sql, findingRecords.getFindRecordsId());
		DbUtils.close(conn);
		return flag;
	}

	// 修改
	@Override
	public int save(FindingRecords findingRecords) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update findingrecords set Finder=?,"
				+ "ItemsId=?,GetTime=? where FindingRecordsId=?";
		int flag = qr.update(conn, sql,
				findingRecords.getAccount().getUserId(), findingRecords
						.getItems().getItemsId(), findingRecords.getGetTime(),
				findingRecords.getFindRecordsId());
		DbUtils.close(conn);
		return flag;
	}

	// 查询
	@Override
	public FindingRecords find(FindingRecords findingRecords)
			throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from findingrecords where"
				+ " FindingRecordsId=?";
		FindingRecords result = new FindingRecords();
		Account account = new Account();
		Items items = new Items();
		Map<String, Object> dr = qr.query(conn, sql, new MapHandler(),
				findingRecords.getFindRecordsId());
		if (dr == null) {
			return null;
		} else {
			result.setFindRecordsId(Integer.parseInt(dr.get("FindingRecordsId")
					.toString().trim()));
			account.setUserId(dr.get("Finder").toString().trim());
			result.setAccount(account);
			items.setItemsId(Integer.parseInt(dr.get("ItemsId").toString()
					.trim()));
			result.setItems(items);
			result.setGetTime(dr.get("GetTime").toString().trim());
			DbUtils.close(conn);
			return result;
		}
	}

	// 查询所有
	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from findingrecords";
		List<Map<String, Object>> mapList = null;
		mapList = qr.query(conn, sql, new MapListHandler());
		return mapList;
	}

}
