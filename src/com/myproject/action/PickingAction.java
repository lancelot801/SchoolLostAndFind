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
	//picking �ı��
	private String thePickingId;
	//���
	private String myCategory;
	//ѧ��
	private String userId;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	//��Ӽ�ʰ��
	public String addPicking() throws IOException{	    
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(pickingItemsService.addPickingItems(this.picking) == 1){	
			out.println("<script>alert('��Ӽ�ʰ��Ʒ�ɹ���');</script>");
			out.flush();
			return SUCCESS;
		}else{	
			out.println("<script>alert('��Ӽ�ʰ��Ʒʧ��');</script>");
			out.flush();
			return ERROR;
		}
	}
	
	//��ѯǰn������ʱ�併������
	public void findTopItems() throws IOException{
		PickingItemsService service = new PickingItemsServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(service.findTopItems(10)));	 
		out.flush();
	}
	
	//��ѯ��ʰ��Ʒ����ϸ��Ϣ
	public void findPickingDetail() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		 		 
		out.println(JSON.toJSONString(pickingItemsService.findPicking(Integer.parseInt(this.thePickingId.trim()))));
		out.flush();		
	}
	
	/**
	 * ��ѯ����
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
	 * ��������ѯ
	 */
	public void findAllPickingByCategory() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(this.pickingItemsService.findPickingByCategory(Integer.parseInt(this.myCategory.trim()))));
		out.flush();
	}
	/**
	 * ����ѧ�Ų�ѯ���м�ʰ
	 */
	public void findAllPickingByuserId() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(pickingItemsService.findPickingByUserId(userId)));
		out.flush();
	}
	/**
     * ��ѯ����˼�ʰ����Ϣ
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
	 * ��˼�ʰ
	 * 
	 */
 
	public void passValidatePick() throws IOException{		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		//���ͨ��
		if(pickingItemsService.validatePick(this.picking.getItems().getItemsId())==1){
			out.println("<script>alert('��˳ɹ���');window.location.href='Admin/CheckFinding.jsp'</script>");
		}
	}
	
	//ģ������
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
