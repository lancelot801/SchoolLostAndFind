package com.myproject.service.impl;

import java.sql.SQLException;

import com.myproject.common.GetLastInseretId;
import com.myproject.common.MD5;
import com.myproject.factory.DaoFactory;
import com.myproject.service.RegistService;
import com.myproject.vo.User;

public class RegistServiceImpl implements RegistService {

	/**
	 * 添加用户的信息 添加账户详情表
	 */
	@Override
	public int RegistStudent(User user) {
		int flag = 0;
		DaoFactory dao = new DaoFactory();
		try {
			//采用md5加密进行密码的加密
			MD5 md5 = new MD5();
		    user.getUserId().setPassword(md5.MD5Encoding(user.getUserId().getPassword().trim()));
		    //添加账户的信息
			flag += dao.getAccountDao().add(user.getUserId());			 
			//添加账户的详细信息
			flag += dao.getUserDao().add(user);		 
			if (flag == 2) {
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
