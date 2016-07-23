package com.myproject.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myproject.vo.Account;
import com.myproject.vo.Publishing;
import com.myproject.vo.User;

public interface BasicDataService {
	//������Ʒ�����
	public List<Map<String,Object>> loadCategory() throws SQLException;
	//��ѯ�û���Ϣ
	public User searchUserInfo(Account account) throws SQLException;
	//��ѯǰ10����վ����
	public List<Map<String,Object>> findAllNews();
	//ͨ��ѧ����ѧ�Ų�ѯѧ������ϸ��Ϣ
	public Map<String,Object> findUserDetail(String Account);
	//�����վ����
	public int addAd(Publishing publishing);
	//�޸ĵ�¼����
	public int updatepassword(Account account);

}
