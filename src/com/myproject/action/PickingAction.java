package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.myproject.service.FindingService;
import com.myproject.service.PickingItemsService;
import com.myproject.service.impl.FindingServiceImpl;
import com.myproject.service.impl.PickingItemsServiceImpl;
import com.myproject.vo.Picking;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PickingAction extends ActionSupport implements ModelDriven<Picking>{

	private PickingItemsService pickingItemsService = new PickingItemsServiceImpl();
	private Picking picking = new Picking();
	//picking 的编号
	private String thePickingId;
	//类别
	private String myCategory;
	//学号
	private String userId;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	//添加捡拾物
	public String addPicking() throws IOException{	    
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(pickingItemsService.addPickingItems(this.picking) == 1){	
			out.println("<script>alert('添加捡拾物品成功！');</script>");
			out.flush();
			return SUCCESS;
		}else{	
			out.println("<script>alert('添加捡拾物品失败');</script>");
			out.flush();
			return ERROR;
		}
	}
	
	//查询前n条按照时间降序排序
	public void findTopItems() throws IOException{
		PickingItemsService service = new PickingItemsServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(service.findTopItems(10)));	 
		out.flush();
	}
	
	//查询捡拾物品的详细信息
	public void findPickingDetail() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		 		 
		out.println(JSON.toJSONString(pickingItemsService.findPicking(Integer.parseInt(this.thePickingId.trim()))));
		out.flush();		
	}
	
	/**
	 * 查询所有
	 * @return 
	 * @throws IOException 
	 */
	public void findAllPickingItems() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 	 
		out.println(JSON.toJSONString(this.pickingItemsService.findAllPicking()));		
		out.flush();
	}
	
	/**
	 * 按照类别查询
	 */
	public void findAllPickingByCategory() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(this.pickingItemsService.findPickingByCategory(Integer.parseInt(this.myCategory.trim()))));
		out.flush();
	}
	/**
	 * 按照学号查询所有捡拾
	 */
	public void findAllPickingByuserId() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(pickingItemsService.findPickingByUserId(userId)));
		out.flush();
	}
	/**
     * 查询待审核捡拾的信息
     */
	public void findVaFind() throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(pickingItemsService.findVaFind()));
		System.out.println(JSON.toJSONString(pickingItemsService.findVaFind()));
		out.flush();
	}
	/**
	 * 审核捡拾
	 * 
	 */
 
	public void passValidatePick() throws IOException{		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		//审核通过
		if(pickingItemsService.validatePick(this.picking.getItems().getItemsId())==1){
			out.println("<script>alert('审核成功！');window.location.href='Admin/CheckFinding.jsp'</script>");
		}
	}
	
	//模型驱动
	@Override
	public Picking getModel() {	 
		return this.picking;
	}

	public String getThePickingId() {
		return thePickingId;
	}

	public void setThePickingId(String thePickingId) {
		this.thePickingId = thePickingId;
	}

	public String getMyCategory() {
		return myCategory;
	}

	public void setMyCategory(String myCategory) {		 
		this.myCategory = myCategory;
	}

 

	 
	
}
