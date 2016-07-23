package com.myproject.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myproject.vo.Account;
import com.myproject.vo.Publishing;
import com.myproject.vo.User;

public interface BasicDataService {
	//加载物品的类别
	public List<Map<String,Object>> loadCategory() throws SQLException;
	//查询用户信息
	public User searchUserInfo(Account account) throws SQLException;
	//查询前10条网站公告
	public List<Map<String,Object>> findAllNews();
	//通过学生的学号查询学生的详细信息
	public Map<String,Object> findUserDetail(String Account);
	//添加网站公告
	public int addAd(Publishing publishing);
	//修改登录密码
	public int updatepassword(Account account);

}
