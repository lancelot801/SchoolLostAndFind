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
import com.myproject.vo.Publishing;

public class PublishingDaoImpl implements DataAccessDao<Publishing> {

	private QueryRunner qr = new QueryRunner();

	@Override
	public int add(Publishing publishing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into publishing(Publisher,"
				+ "Title,Content,PublishingTime,Statues) values(?,?,?,?,?)";
		int flag = qr.update(conn, sql, publishing.getAccount().getUserId(),
				publishing.getTitle(), publishing.getContent(),
				publishing.getPublishingTime(), publishing.getStatues());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int remove(Publishing publishing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from publishing where PublishingId=?";
		int flag = qr.update(conn, sql, publishing.getPublishingId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(Publishing publishing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update publishing set Publisher=?,"
				+ "Title=?,Content=?,PublishingTime=?,Statues=? "
				+ "where PublishingId=?";
		int flag = qr.update(conn, sql, publishing.getAccount().getUserId(),
				publishing.getTitle(), publishing.getContent(),
				publishing.getPublishingTime(), publishing.getStatues(),
				publishing.getPublishingId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public Publishing find(Publishing publishing) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from publishing where PublishingId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				publishing.getPublishingId());
		if (map == null) {
			return null;
		} else {
			Publishing result = new Publishing();
			result.setPublishingId(Integer.parseInt(map.get("PublishingId")
					.toString().trim()));
			Account account = new Account();
			account.setUserId(map.get("Publisher").toString().trim());
			result.setAccount(account);
			result.setTitle(map.get("Title").toString());
			result.setContent(map.get("Content").toString());
			result.setPublishingTime(map.get("PublishingTime").toString()
					.trim());
			result.setStatues(Integer.parseInt(map.get("Statues").toString()
					.trim()));
			DbUtils.close(conn);
			return result;
		}

	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from publishing";
		List<Map<String, Object>> mapList = qr.query(conn, sql,
				new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
