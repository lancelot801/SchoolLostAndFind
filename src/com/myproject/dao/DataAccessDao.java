package com.myproject.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myproject.vo.Account;

/**
 * ���ݷ�����ɾ�Ĳ飬��ѯ����
 * @author dntch
 *
 */
public interface DataAccessDao<T> {
	public int add(T t) throws SQLException;//�����Ϣ
	public int remove(T t) throws SQLException; //�޸���Ϣ
	public int save(T t) throws SQLException;//ɾ����Ϣ
	public T find(T t) throws SQLException;//��ѯ��Ϣ
	public List<Map<String,Object>> findAll() throws SQLException;//��ѯ������Ϣ
	
	
}
