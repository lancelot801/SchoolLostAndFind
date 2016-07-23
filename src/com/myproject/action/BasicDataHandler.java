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
	//��¼�˺�
	private String accountId;
	//��¼����
	private String password;
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Publishing publishing=new Publishing();
	/**
	 * ��ȡ���е���Ʒ�����
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
	 * ��ѯ��վ�����ǰ10����¼
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
	 * ͨ��ѧ����ѧ�Ų�ѯѧ������Ϣ
	 */
	public void findUserDetail() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(basic.findUserDetail(this.accountId)));	 
		out.flush();
	}
    //�����վ����
	public void addWAd() throws IOException{
		BasicDataService basic = new BasicDataSeriviceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (basic.addAd(publishing)==1) {
			out.println("<script>alert('�����ɹ���');window.location.href='Admin/PublishingAd.jsp'</script>");
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
