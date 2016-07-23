package com.myproject.service.impl;

import java.sql.SQLException;

import com.myproject.common.MD5;
import com.myproject.factory.DaoFactory;
import com.myproject.service.LoginService;
import com.myproject.vo.Account;

/**
 * 登录
 * @author dntch
 *
 */
public class LoginServiceImpl implements LoginService {

	/**
	 * 查询是否存在用户
	 * 如果存在用户
	 * 再次
	 * 查看用户的密码是否正确
	 */
	@Override	
	public int login(Account account) {	 
		DaoFactory dao = new DaoFactory();
		int flag = 0;
		Account result;
		try {
			result = dao.getAccountDao().find(account);
			if(result == null){
				flag = -1;
			}else{
				if(result.getPassword().trim().equals(MD5.MD5Encoding(account.getPassword().trim()))){
					flag = 1;
				}else{
					flag = 0;
				}
			}
		} catch (SQLException e) {			 
			e.printStackTrace();
			flag = -2;
		}		 
		return flag;
	}

}
