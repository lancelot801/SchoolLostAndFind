package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.myproject.service.BasicDataService;
import com.myproject.service.impl.BasicDataSeriviceImpl;
import com.myproject.vo.Account;
import com.myproject.vo.FindingRecords;
import com.myproject.vo.Publishing;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BasicDataHandler extends ActionSupport implements
ModelDriven<Publishing> {
	//登录账号
	private String accountId;
	//登录密码
	private String password;
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Publishing publishing=new Publishing();
	/**
	 * 获取所有的物品的类别
	 * @throws IOException 
	 */
	public void getAllItemsCategory() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {			 
			out.println(JSON.toJSONString(basic.loadCategory()));	 
		} catch (SQLException e) {		 
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询网站公告的前10条记录
	 * @throws IOException 
	 */
	public void findNews() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(basic.findAllNews()));	 
		out.flush();
	}
	
	/**
	 * 通过学生的学号查询学生的信息
	 */
	public void findUserDetail() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(basic.findUserDetail(this.accountId)));	 
		out.flush();
	}
    //添加网站公告
	public void addWAd() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (basic.addAd(publishing)==1) {
			out.println("<script>alert('发布成功！');window.location.href='Admin/PublishingAd.jsp'</script>");
		}
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public Publishing getModel() {
		
		return this.publishing;
	}

	
}
