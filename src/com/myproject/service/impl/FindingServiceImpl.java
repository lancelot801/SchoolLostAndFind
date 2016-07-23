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
	 * �����Ѱ��Ʒ
	 * 1.�����Ʒ��Ϣ(�ı���Ʒ��״̬)
	 * 2.�����Ѱ��¼��Ϣ
	 */
	@Override
	public int addFindingItems(Losing losing) {	
		DaoFactory dao = new DaoFactory();
		int flag = 0;
		try {
			//�����Ʒ����Ϣ
			flag += dao.getItemsDao().add(losing.getItems());
			//��ȡ��Ʒ��¼������
			GetLastInseretId get = new GetLastInseretId();
			//���ò�ѯ��Ʒ������ʵ�����������
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
	 * ��ѯ��ʧ��Ʒ��¼����ʱ������ѡȡǰn�����ݣ�ͨ�����
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
	 * ͨ����Ų�ѯ��Ʒ����ϸ��Ϣ
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
	 * ��ѯ���У�ͨ�����
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
	 * ��������ѯ���е���Ϣ����ͨ��
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
	 * ��ѯ���еȴ���˵���Ϣ
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
	 * ��˶�ʧ
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
     //ͨ��ѧ�Ų�ѯ���ж�ʧ����Ʒ
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
