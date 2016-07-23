
package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class SessionHandler extends ActionSupport {
	private String key;
	
    public String getKey() {
		return key;
	}

	public void setKey(String key) {	 
		this.key = key;
	}

	/**
     * 获取session
     * @throws IOException 
     */
	public void getSession() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		try {
			String value = session.getAttribute(key).toString();				
			out.println(value);		 
		} catch (Exception e) {	
			out.println("暂时没有登录");
		}			  
	}
	
	/**
	 * 清空session
	 * @throws IOException 
	 */
	public void clearSession() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		try {
			session.setAttribute(key, null);				
			out.println("success");		 
		} catch (Exception e) {	
			out.println("error");
		}
	}
}
