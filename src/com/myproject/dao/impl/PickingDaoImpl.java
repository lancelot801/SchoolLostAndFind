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
import com.myproject.vo.Items;
import com.myproject.vo.Picking;

public class PickingDaoImpl implements DataAccessDao<Picking> {

	private QueryRunner qr = new QueryRunner();

	@Override
	public int add(Picking picking) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into picking(ItemsId,Picker,PickTime,PickPhone,PickLocation) "
				+ "values(?,?,?,?,?)";
		int flag = qr.update(conn, sql, picking.getItems().getItemsId(),
				picking.getPicker(), picking.getPickTime(),
				picking.getPickPhone(), picking.getPickLocation());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int remove(Picking picking) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from picking where PickingId=?";
		int flag = qr.update(conn, sql, picking.getPickingId());
		DbUtils.close(conn);
		return flag;
	}

	@Override
	public int save(Picking picking) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update picking set ItemsId=?"
				+ ",Picker=?,PickTime=?,PickPhone=?,PickLocation=? where PickingId=?";
		int flag = qr.update(conn, sql, picking.getItems().getItemsId(),
				picking.getPicker(), picking.getPickTime(),
				picking.getPickPhone(), picking.getPickLocation(),
				picking.getPickingId());
		return flag;
	}

	@Override
	public Picking find(Picking picking) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		Picking result = new Picking();
		String sql = "select * from picking where PickingId=?";
		Map<String, Object> map = qr.query(conn, sql, new MapHandler(),
				picking.getPickingId());
		if (map == null) {
			return null;
		} else {
			result.setPickingId(Integer.parseInt(map.get("PickingId")
					.toString()));
			Items items = new Items();
			items.setItemsId(Integer.parseInt(map.get("ItemsId").toString()
					.trim()));
			result.setItems(items);
			result.setPicker(map.get("Picker").toString());
			result.setPickTime(map.get("PickTime").toString());
			result.setPickPhone(map.get("PickPhone").toString());
			result.setPickLocation(map.get("PickLocation").toString().trim());
			DbUtils.close(conn);
			return result;
		}

	}

	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		List<Map<String, Object>> mapList = null;
		String sql = "select * from picking";
		mapList = qr.query(conn, sql, new MapListHandler());
		DbUtils.close(conn);
		return mapList;
	}

}
