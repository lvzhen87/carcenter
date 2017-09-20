package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IorganizationPostService;
import com.freshen.basis.service.impl.OrganizationPostServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationPost;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class LimitAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	String limit;
	String post;
	List<OrganizationPost>  oplist=new ArrayList<OrganizationPost>();
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	
	/**
	 * 查询岗位信息
	 */
	public void drawlimit(){
		try {
			if(post != null){
				OrganizationPost op=new OrganizationPost();
				op.setOrganizationPost_s(post);
				IorganizationPostService ips=new OrganizationPostServiceImpl();
				List<OrganizationPost> oplist= ips.getOrganizationPost(op, ConstantUtil.pagingNot,0);
				if(oplist!=null)
				{
					limit=oplist.get(0).getLimitpage_s();
				}
			}
			

			//转换成json格式
			HttpServletResponse response = ServletActionContext.getResponse();
			String json=new LimitJson().limitJson(limit);
			//System.out.println(json);
			//设置编码格式
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 

//			JSONObject jsontest=new JSONObject();  
//			jsontest.accumulate("success", true);  
//			json = jsontest.toString();
	        out.println(json.toString());  
	        out.flush();  
	        out.close();  
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			//return ERROR;
			// TODO: handle exception
			 
		}

		
	}

	public String searchPost(){
		try {
			IorganizationPostService ips=new OrganizationPostServiceImpl();
			oplist=ips.getOrganizationPost(null, ConstantUtil.pagingNot,0);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;
	}
	
	
	public String setPost(){
		try {
			//System.out.println(post);
			//System.out.println(limit);
			OrganizationPost op=new OrganizationPost();
			String temp[]=post.split(",");
			op.setPostName_s(temp[0]);
			op.setOrganizationPost_s(temp[1]);
			op.setLimitpage_s(limit);
			op.setCreateDate_t(DateUtil.getCurrentDate());
			op.setCreateUser_s(employ.getCustomerUserName_s());
			
			IorganizationPostService ips=new OrganizationPostServiceImpl();
			ips.OperationOrganizationDept(op, 1);	
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public List<OrganizationPost> getOplist() {
		return oplist;
	}

	public void setOplist(List<OrganizationPost> oplist) {
		this.oplist = oplist;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	
}
