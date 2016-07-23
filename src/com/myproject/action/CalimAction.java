package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.myproject.service.CalimService;
import com.myproject.service.FindingService;
import com.myproject.service.impl.CalimServiceImpl;
import com.myproject.service.impl.FindingServiceImpl;
import com.myproject.vo.FindingRecords;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CalimAction extends ActionSupport implements
		ModelDriven<FindingRecords> {
	private CalimService cs = new CalimServiceImpl();
	private FindingRecords fr = new FindingRecords();
	
	private String userId;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	// 认领
	public void CClaim() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		if (cs.addClaimRecords(fr) == 1) {
			out.println("<script>alert('认领成功！');window.location.href='Admin/Claim.jsp'</script>");
		}
	}
    //按照学号查询认领记录
	public void findAllByUsrId() throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
	    System.out.println(cs.findAllByUserId(this.userId));
		out.println(JSON.toJSONString(cs.findAllByUserId(this.userId)));		
		out.flush();
	}
	@Override
	public FindingRecords getModel() {		 
		return this.fr;
	}
}
