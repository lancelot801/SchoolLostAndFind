package com.myproject.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myproject.vo.Account;

/**
 * 数据访问增删改查，查询所有
 * @author dntch
 *
 */
public interface DataAccessDao<T> {
	public int add(T t) throws SQLException;//添加信息
	public int remove(T t) throws SQLException; //修改信息
	public int save(T t) throws SQLException;//删除信息
	public T find(T t) throws SQLException;//查询信息
	public List<Map<String,Object>> findAll() throws SQLException;//查询所有信息
	
	
}
