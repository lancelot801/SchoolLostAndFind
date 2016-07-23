package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.myproject.dao.impl.UserDaoImpl;
import com.myproject.vo.Account;
import com.myproject.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
 
	//�޸��û�������Ϣ
	public void updateUserInfo() throws IOException{
		UserDaoImpl dao=new UserDaoImpl();		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			if (dao.save(this.user)==1) {
				out.println("<script>alert('�޸ĳɹ���');window.location.href='User/MyInfo.jsp'</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
