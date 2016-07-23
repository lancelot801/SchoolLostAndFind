package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.myproject.service.RegistService;
import com.myproject.service.impl.RegistServiceImpl;
import com.myproject.vo.Account;
import com.myproject.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegistAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User(); 
	
	//注册
	public String registUser(){
		RegistService regist = new RegistServiceImpl();		
		if(regist.RegistStudent(this.user) == 1){	
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码				
				out.print("<script>alert('恭喜  "+user.getUserName()+" 注册成功！');window.location.href='main.jsp';</script>");
				out.flush();
				out.close();
			} catch (IOException e) {				 
				e.printStackTrace();
			}						
			return SUCCESS;
		}else{
			return ERROR;
		} 
	}
	
	@Override
	public User getModel() {	    
		return this.user;
	}
	
}
