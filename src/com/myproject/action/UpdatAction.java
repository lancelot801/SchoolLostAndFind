package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.myproject.dao.impl.UserDaoImpl;
import com.myproject.factory.DaoFactory;
import com.myproject.service.BasicDataService;
import com.myproject.service.impl.BasicDataSeriviceImpl;
import com.myproject.vo.Account;
import com.myproject.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdatAction extends ActionSupport implements ModelDriven<Account> {
    private Account account;
	
  public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	//修改登录密码
	public void uppswd() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (basic.updatepassword(account)==1) {
			out.println("<script>alert('修改成功！');window.location.href='User/MyInfo.jsp'</script>");
		}
	}
    
	
	
	public int updateUserInfo(Account account) throws SQLException {
		DaoFactory dao = new DaoFactory();
		int flag=0;
		User user=new User();
		try {
			user.setUserId(account);
			flag+=dao.getUserDao().save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	//模型驱动
	@Override
	public Account getModel() {
		
		return this.account;
	}

}
