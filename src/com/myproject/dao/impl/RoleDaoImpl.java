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
import com.myproject.vo.Role;

public class RoleDaoImpl implements DataAccessDao<Role> {

	private QueryRunner qr = new QueryRunner();

	@Override
	public int add(Role role) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into role(RoleName) values(?)";
		int flag = qr.update(conn, sql, role.getRoleName());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int remove(Role role) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from role where RoleId=?";
		int flag = qr.update(conn, sql, role.getRoleId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(Role role) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update role set RoleName=?" + " where RoleId=?";
		int flag = qr.update(conn, sql, role.getRoleName(), role.getRoleId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public Role find(Role role) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		Role result = new Role();
		String sql = "select * from role where RoleId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				role.getRoleId());
		if(map == null){
			return null;
		}else{
			result.setRoleId(Integer.parseInt(map.get("RoleId").toString().trim()));
			result.setRoleName(map.get("RoleName").toString());
			DbUtils.close(conn);
			return result;
		}		
	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		List<Map<String, Object>> mapList = null;
		String sql = "select * from role";
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
