package com.myproject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.common.GetLastInseretId;
import com.myproject.factory.DaoFactory;
import com.myproject.service.CalimService;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.FindingRecords;
import com.myproject.vo.Items;

public class CalimServiceImpl implements CalimService {
	private QueryRunner qr = new QueryRunner();
	private DaoFactory dao = new DaoFactory();
	//添加认领记录
	
	@Override
	public int addClaimRecords(FindingRecords findingrecords) {
		int flag=0;
		try {
			//添加时间
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date); 
			findingrecords.setGetTime(time);
			//添加到数据库中
			flag+=dao.getFindRecordsDao().add(findingrecords);
			Items items = new Items();			 
		    items.setItemsId(findingrecords.getItems().getItemsId());
			items = dao.getItemsDao().find(items);
			items.getItemsStatues().setStatuesId(2);
			flag+=dao.getItemsDao().save(items);
			if (flag == 2) {
				return 1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
     //按照学号查找认领记录
	@Override
	public List<Map<String, Object>> findAllByUserId(String userId) {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from items,findingrecords where items.ItemsId = findingrecords.ItemsId and items.ItemsStatues = 2 and findingrecords.Finder="+userId+" order by findingrecords.GetTime desc;";
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
