package com.myproject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.common.GetLastInseretId;
import com.myproject.factory.DaoFactory;
import com.myproject.service.FindingService;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.Account;
import com.myproject.vo.FindingRecords;
import com.myproject.vo.Items;
import com.myproject.vo.Losing;
import com.myproject.vo.User;

public class FindingServiceImpl implements FindingService {

	private QueryRunner qr = new QueryRunner();
	private DaoFactory da = new DaoFactory();
	
	/**
	 * 添加搜寻物品
	 * 1.添加物品信息(改变物品的状态)
	 * 2.添加搜寻记录信息
	 */
	@Override
	public int addFindingItems(Losing losing) {	
		DaoFactory dao = new DaoFactory();
		int flag = 0;
		try {
			//添加物品的信息
			flag += dao.getItemsDao().add(losing.getItems());
			//获取物品记录的主键
			GetLastInseretId get = new GetLastInseretId();
			//设置查询物品表的外键实现主外键关联
			losing.getItems().setItemsId(get.getTableMaxId("items", "ItemsId"));
			flag += dao.getLosingDao().add(losing);
			if(flag == 2){
				flag = 1;
			}
		} catch (SQLException e) {		 
			e.printStackTrace();
			flag = -1;
		}		
		return flag;
	}
	
	/**
	 * 查询丢失物品记录按照时间排序选取前n条数据，通过审核
	 */
	public List<Map<String,Object>> findTopLosingItems(int n){
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,losing where items.ItemsId = losing.ItemsId and items.ItemsStatues = 1 order by losing.LosingTime desc limit "+n+";";
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
	 * 通过编号查询物品的详细信息
	 */
	@Override
	public Map<String,Object> findByItemsId(int id) {
		Connection conn = JdbcUtils.getConnection();
		 String sql = "select * from items,losing,userdetailinfo,itemscategory where items.ItemsId = losing.ItemsId and losing.Finder = userdetailinfo.UserId  and items.CategoryId = itemscategory.CategoryId and losing.LosingId="+id+";";		 
		 Map<String,Object> result = null;
		 try {
			result = qr.query(conn, sql, new MapHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {			 
			e.printStackTrace();			 
		}		 
	    return result;
	}

	/**
	 * 查询所有，通过审核
	 */
	@Override
	public List<Map<String, Object>> findAllFinding() {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,losing,itemscategory where items.ItemsId = losing.ItemsId and items.ItemsStatues = 1 and items.CategoryId = itemscategory.CategoryId order by losing.LosingTime desc;";
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
	 * 按照类别查询所有的信息，所通过
	 */
	@Override
	public List<Map<String, Object>> findFindingByCategory(int category) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,losing,itemscategory where items.ItemsId = losing.ItemsId and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 1 and items.CategoryId="+category+" order by losing.LosingTime desc;";
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
	 * 查询所有等待审核的信息
	 */
	@Override
	public List<Map<String, Object>> findVaLose() {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,losing,itemscategory where items.ItemsId = losing.ItemsId and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 0 order by losing.LosingTime desc;";
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
	 * 审核丢失
	 */
	@Override
	public int validateFind(int id) {
	    Items items = new Items();
	    items.setItemsId(id);
	    int flag = 0;
	    try {
			items = da.getItemsDao().find(items);
			items.getItemsStatues().setStatuesId(1);
			flag = da.getItemsDao().save(items);
		} catch (SQLException e) {		 
			e.printStackTrace();
		}	    
		return flag;
	}
     //通过学号查询所有丢失的物品
	@Override
	public List<Map<String, Object>> findAllByUserId(String userId) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,losing,itemscategory where items.ItemsId = losing.ItemsId and items.CategoryId = itemscategory.CategoryId and items.ItemsStatues = 1 and losing.Finder="+userId+" order by losing.LosingTime desc;";
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
