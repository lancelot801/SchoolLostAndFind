package com.myproject.service.impl;

import java.sql.SQLException;

import com.myproject.common.MD5;
import com.myproject.factory.DaoFactory;
import com.myproject.service.LoginService;
import com.myproject.vo.Account;

/**
 * ��¼
 * @author dntch
 *
 */
public class LoginServiceImpl implements LoginService {

	/**
	 * ��ѯ�Ƿ�����û�
	 * ��������û�
	 * �ٴ�
	 * �鿴�û��������Ƿ���ȷ
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
