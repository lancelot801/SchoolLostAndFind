package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.myproject.service.BasicDataService;
import com.myproject.service.LoginService;
import com.myproject.service.impl.BasicDataSeriviceImpl;
import com.myproject.service.impl.LoginServiceImpl;
import com.myproject.vo.Account;
import com.myproject.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Account> {

	private Account account = new Account();

	/**
	 * 用户登录
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public String userLogin() throws IOException, SQLException{
		//执行登录
		LoginService service = new LoginServiceImpl();
		int flag = service.login(this.account);
		//获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if( flag == 1){			
			//获取session对象
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();	
			//获取用户的详细信息
			BasicDataService bas = new BasicDataSeriviceImpl();
			User user = new User();
			user = bas.searchUserInfo(this.account);
			//设置session的值
			session.setAttribute("userId", this.account.getUserId());				
			session.setAttribute("userName",user.getUserName());
			return SUCCESS;
		}else{					 			
			return ERROR;
		}
	}
	
	@Override
	public Account getModel() {			
		return this.account;
	}

}
