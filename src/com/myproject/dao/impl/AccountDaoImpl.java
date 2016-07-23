package com.myproject.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.dao.DataAccessDao;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.Account;
import com.myproject.vo.Role;

/**
 * 账户的数据访问
 * 
 * @author dntch
 * 
 */
public class AccountDaoImpl implements DataAccessDao<Account> {

	private QueryRunner qr = new QueryRunner();

	// 添加信息
	@Override
	public int add(Account account) throws SQLException {
		Connection conn = JdbcUtils.getConnection();// 获取数据连接
		String sql = "insert into account(UserId,Password,RoleId) values(?,?,?)";
		int flag = qr.update(conn, sql, account.getUserId(),
				account.getPassword(), account.getRole().getRoleId());
		DbUtils.close(conn);
		return flag;
	}

	// 删除信息
	@Override
	public int remove(Account account) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from account where UserId=?";
		int flag = qr.update(conn, sql, account.getUserId());
		DbUtils.close(conn);
		return flag;
	}

	// 修改信息
	@Override
	public int save(Account account) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update account set Password=?,RoleId=? where UserId=?";
		int flag = qr.update(conn, sql, account.getPassword(), account
				.getRole().getRoleId(), account.getUserId());
		DbUtils.close(conn);
		return flag;
	}

	// 查询信息
	@Override
	public Account find(Account account) throws SQLException {
		Connection conn = JdbcUtils.getConnection();// 获取数据库连接
		Account result = new Account();// 实例化一个accont类
		Role role = new Role();// 实例化一个role类
		String sql = "select * from account where UserID=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				account.getUserId());// 结果
		if (map == null) {
			return null;
		} else {
			role.setRoleId(Integer
					.parseInt(map.get("RoleId").toString().trim()));
			result.setRole(role);
			result.setUserId(map.get("UserId").toString().trim());
			result.setPassword(map.get("Password").toString().trim());
			DbUtils.close(conn);// 关闭数据连接
			return result;
		}
	}

	// 查询所有信息
	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		List<Map<String, Object>> mapList = null;
		String sql = "select * from account";
		try {
			mapList = qr.query(conn, sql, new MapListHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapList;
	}

}
