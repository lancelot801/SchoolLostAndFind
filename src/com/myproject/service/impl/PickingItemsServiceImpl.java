package com.myproject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.alibaba.fastjson.JSON;
import com.myproject.common.GetLastInseretId;
import com.myproject.factory.DaoFactory;
import com.myproject.service.PickingItemsService;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.Items;
import com.myproject.vo.Picking;

public class PickingItemsServiceImpl implements PickingItemsService {

	private QueryRunner qr = new QueryRunner();
	private DaoFactory dao = new DaoFactory();

	/**
	 * 添加捡拾物品 1.添加物品信息 2.添加捡拾信息
	 * 
	 * @throws
	 */
	@Override
	public int addPickingItems(Picking picking) {
		DaoFactory dao = new DaoFactory();
		int flag = 0;
		try {
			// 添加物品信息
			flag += dao.getItemsDao().add(picking.getItems());
			// 获取添加的主键值
			GetLastInseretId get = new GetLastInseretId();
			picking.getItems()
					.setItemsId(get.getTableMaxId("items", "ItemsId"));
			// 添加捡拾信息
			flag += dao.getPickingDao().add(picking);
			if (flag == 2) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	/**
	 * 按照时间降序查询前n个数据，通过审核
	 * 
	 * @throws SQLException
	 */
	@Override
	public List<Map<String, Object>> findTopItems(int n) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,picking  where items.ItemsId = picking.ItemsId and items.ItemsStatues = 1 order by picking.PickTime desc  limit "
				+ n + ";";
		List<Map<String, Object>> result = null;
		try {
			result = qr.query(conn, sql, new MapListHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询找寻的信息
	 */
	@Override
	public Map<String, Object> findPicking(int id) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,picking,itemscategory  where items.ItemsId = picking.ItemsId and items.CategoryId = itemscategory.CategoryId and picking.PickingId = "
				+ id + ";";
		Map<String, Object> result = null;
		try {
			result = qr.query(conn, sql, new MapHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询所有通过的信息
	 */
	@Override
	public List<Map<String, Object>> findAllPicking() {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,picking,itemscategory where items.ItemsId = picking.ItemsId  and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 1  order by picking.PickTime desc;";		 
		List<Map<String, Object>> result = null;
		try {
			result = qr.query(conn, sql, new MapListHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	/**
	 * 按照类别查询通过的信息
	 */
	@Override
	public List<Map<String, Object>> findPickingByCategory(int category) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,picking,itemscategory where items.ItemsId = picking.ItemsId and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 1 and items.CategoryId="
				+ category + "  order by picking.PickTime desc;";
		List<Map<String, Object>> result = null;
		try {
			result = qr.query(conn, sql, new MapListHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	    * 查询所有待审核捡拾
	    */
		@Override
		public List<Map<String, Object>> findVaFind() {
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from items,picking,itemscategory where items.ItemsId = picking.ItemsId and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 0 order by picking.PickTime desc;";
			List<Map<String, Object>> result = null;
			try {
				result = qr.query(conn, sql, new MapListHandler());
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	/**
	 * 审核捡拾
	 */
	@Override
	public int validatePick(int id) {
		Items items = new Items();
	    items.setItemsId(id);
	    int flag = 0;
	    try {
			items = dao.getItemsDao().find(items);
			items.getItemsStatues().setStatuesId(1);
			flag = dao.getItemsDao().save(items);
		} catch (SQLException e) {		 
			e.printStackTrace();
		}	    
		return flag;
	}
      /**
       * 通过学号查询所有捡拾
       */
	@Override
	public List<Map<String, Object>> findPickingByUserId(String userId) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,picking,itemscategory where items.ItemsId = picking.ItemsId and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 1 and picking.Picker="+userId+" order by picking.PickTime desc;";
		List<Map<String, Object>> result = null;
		try {
			result = qr.query(conn, sql, new MapListHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
