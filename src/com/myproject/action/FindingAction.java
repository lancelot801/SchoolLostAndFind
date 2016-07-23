package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.myproject.service.FindingService;
import com.myproject.service.impl.FindingServiceImpl;
import com.myproject.vo.Account;
import com.myproject.vo.FindingRecords;
import com.myproject.vo.Losing;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindingAction extends ActionSupport implements
		ModelDriven<Losing> {

	private Losing losing = new Losing();
	private String theLosingId;
	private String thelosingCategory;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 添加搜寻的记录
	 */
	public void addFindingRecords() {
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			//获取到用户的编号
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();				
			if(session.getAttribute("userId")!=null){
				//获取当前用户的编号
				Account account = new Account();
				account.setUserId(session.getAttribute("userId").toString().trim());
				//设置当前用户的编号
				this.losing.setFinder(account);
				if (findingService.addFindingItems(losing) == 1) {
					out.println("<script>alert('添加搜寻记录成功！');window.location.href='main.jsp';</script>");
					out.flush();
				}else{
					out.println("<script>alert('添加搜寻记录失败！');window.location.href='main.jsp';</script>");
					out.flush();
				}
			}else{
				out.println("<script>alert('您还未曾登录请先登录！');window.location.href='main.jsp'</script>");
				out.flush();
			}			
		} catch (IOException e) {
			e.printStackTrace();		 
		}
		
	}

	/**
	 * 查询前10条记录按照时间降序排序
	 * @throws IOException 
	 */
	
	public void findTopItems() throws IOException{
		FindingService service = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(service.findTopLosingItems(10)));	 		 
		out.flush();
	}
	
	/**
	 * 查询搜寻的详细信息
	 */
	public void findFindgDetail() throws IOException{
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	 		 
		out.println(JSON.toJSONString(findingService.findByItemsId(Integer.parseInt(theLosingId))));
		out.flush();		
	}
	
	/**
	 * 查询所有
	 * @throws IOException 
	 */
	public void findAllLosingItems() throws IOException{
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		out.println(JSON.toJSONString(findingService.findAllFinding()));		
		out.flush();
	}
	
	/**
	 * 按照类别查询
	 */
	public void findAllLosingItemsByCategory() throws IOException{
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();			 
		out.println(JSON.toJSONString(findingService.findFindingByCategory(Integer.parseInt(this.thelosingCategory.trim()))));		
		out.flush();
	}
	/**
	 * 按照学号查询所有丢失
	 * 
	 */
	public void findAllLosingItemsByUsrId() throws IOException{
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
	    System.out.println(findingService.findAllByUserId(this.userId));
		out.println(JSON.toJSONString(findingService.findAllByUserId(this.userId)));		
		out.flush();
	}
	/**
	 * 查询待审核丢失的信息
	 * @throws IOException 
	 */
	public void findVaLosing() throws IOException{
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(JSON.toJSONString(findingService.findVaLose()));
		System.out.println(JSON.toJSONString(findingService.findVaLose()));
		out.flush();
	}	
	
	/**
	 * 审核丢失
	 * @throws IOException 
	 */
	public void passValidate() throws IOException{
		FindingService findingService = new FindingServiceImpl();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		//审核通过
		if(findingService.validateFind(this.losing.getItems().getItemsId())==1){
			out.println("<script>alert('审核成功！');window.location.href='Admin/CheckPublishing.jsp'</script>");
		}
	}
      
	@Override
	public Losing getModel() {		 
		return this.losing;
	}

	public String getTheLosingId() {
		return theLosingId;
	}

	public void setTheLosingId(String theLosingId) {
		this.theLosingId = theLosingId;
	}

	public String getThelosingCategory() {
		return thelosingCategory;
	}

	public void setThelosingCategory(String thelosingCategory) {
		this.thelosingCategory = thelosingCategory;
	}
		

}
