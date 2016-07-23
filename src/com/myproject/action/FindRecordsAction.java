package com.myproject.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.myproject.service.CalimService;
import com.myproject.service.impl.CalimServiceImpl;
import com.myproject.vo.FindingRecords;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindRecordsAction extends ActionSupport implements ModelDriven<FindingRecords> {

	private FindingRecords fr=new FindingRecords();
    private CalimService cal = new CalimServiceImpl();
	
	/**
	 * »œ¡Ï
	 * @throws IOException 
	 */
	public void addfr() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(cal.addClaimRecords(this.fr)==1){
			out.print("");
			out.flush();
		}
	}
	
	@Override
	public FindingRecords getModel() {
		
		return fr;
	}
	
	

}
