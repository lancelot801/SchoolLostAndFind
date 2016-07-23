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
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.myproject.common.MD5;
import com.myproject.factory.DaoFactory;
import com.myproject.service.BasicDataService;
import com.myproject.utils.JdbcUtils;
import com.myproject.vo.Account;
import com.myproject.vo.Publishing;
import com.myproject.vo.User;

public class BasicDataSeriviceImpl implements BasicDataService {
private String userId;
	// �������
	@Override
	public List<Map<String, Object>> loadCategory() throws SQLException {
		DaoFactory dao = new DaoFactory();
		return dao.getItemsCategoryDao().findAll();
	}

	//��ѯ�û�������
	@Override
	public User searchUserInfo(Account account) throws SQLException {
		DaoFactory dao = new DaoFactory();
		User user = new User();
		List<Map<String,Object>> result = dao.getUserDao().findAll();
		for(Map<String,Object> sinRes : result){
			try {
				//�ҵ����������ļ�¼
				if(sinRes.get("userId").toString().trim().equals(account.getUserId().trim())){
					 user.setUserInfoId(Integer.parseInt(sinRes.get("userInfoId").toString().trim()));
					 user = dao.getUserDao().find(user);
				}
			} catch (Exception e) {
				continue;
			}			
		}
		return user;
	}
	
	//��ѯ��վ����
	public List<Map<String,Object>> findAllNews(){
		DaoFactory dao = new DaoFactory();
		List<Map<String,Object>> result = null;
		try {
			result = dao.getPublishingDao().findAll();
			if(result.size() >10){
				result = result.subList(0, 9);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	//ͨ��ѧ����ѧ�Ų�ѯѧ����ϸ��Ϣ
	@Override
	public Map<String,Object> findUserDetail(String account) {
		QueryRunner qr = new QueryRunner();
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from userdetailinfo where userdetailinfo.UserId = "+account+";";
		Map<String,Object> result = null;
		try {
			result = qr.query(conn, sql, new MapHandler());
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
     //��ӹ���
	@Override
	public int addAd(Publishing publishing) {
		DaoFactory dao = new DaoFactory();
		int flag=0;
		try {
			//���ʱ��
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date); 
			publishing.setPublishingTime(time);
			Account account=new Account();
			account.setUserId(publishing.getAccount().getUserId());
			publishing.setAccount(account);
			publishing.setStatues(0);
			flag+=dao.getPublishingDao().add(publishing);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
   //�޸ĵ�¼����
	@Override
	public int updatepassword(Account account) {
		DaoFactory dao = new DaoFactory();
		int flag=0;
		try {	
			account.setUserId(account.getUserId());
			account.setRole(account.getRole());
			account.setPassword(MD5.MD5Encoding(account.getPassword().trim()));
			flag+=dao.getAccountDao().save(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
}
