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
import com.myproject.vo.User;

public class UserDaoImpl implements DataAccessDao<User> {

	private QueryRunner qr = new QueryRunner();

	@Override
	public int add(User user) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into " + "userdetailinfo(UserId,UserName,Gender,"
				+ "Email,PhoneNumber,DetailAddress)" + " values(?,?,?,?,?,?)";
		int flag = qr.update(conn, sql, user.getUserId().getUserId(),
				user.getUserName(), user.getGender(), user.getEmail(),
				user.getPhoneNumber(), user.getDetailAddress());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int remove(User user) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from userdetailinfo where UserInfoId=?";
		int flag = qr.update(conn, sql, user.getUserInfoId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(User user) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update userdetailinfo set UserId=?,"
				+ "UserName=?,Gender=?,Email=?,"
				+ "PhoneNumber=?,DetailAddress=? where UserInfoId=?";
		int flag = qr.update(conn, sql, user.getUserId().getUserId(), user.getUserName(),
				user.getGender(), user.getEmail(), user.getPhoneNumber(),
				user.getDetailAddress(), user.getUserInfoId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public User find(User user) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		User result = new User();
		String sql = "select * from userdetailinfo" + " where UserInfoId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				user.getUserInfoId());
		if(map == null){
			return null;
		}else{
			result.setUserInfoId(Integer.parseInt(map.get("UserInfoId").toString()));
			Account account = new Account();
			account.setUserId(map.get("UserId").toString().trim());
			result.setUserId(account);
			result.setUserName(map.get("UserName").toString().trim());
			result.setGender(map.get("Gender").toString().trim());	 
			result.setEmail(map.get("Email").toString().trim());
			result.setPhoneNumber(map.get("PhoneNumber").toString().trim());
			result.setDetailAddress(map.get("DetailAddress").toString().trim());
			DbUtils.close(conn);
			return result;
		}		
	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from userdetailinfo";
		List<Map<String, Object>> mapList = null;
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
