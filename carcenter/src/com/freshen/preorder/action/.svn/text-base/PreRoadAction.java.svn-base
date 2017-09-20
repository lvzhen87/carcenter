package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.preorder.service.impl.OrderPreRoadServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class PreRoadAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	List<OrderPreRoad> preroadlist=new ArrayList<OrderPreRoad>();//预付费道路集合
	
	
	public String execute(){
		try {
			OrderPreRoad or=new OrderPreRoad();
			or.setOrderID_s(orderId);
			
			IorderPreRoadService ips=new OrderPreRoadServiceImpl();
			totalPages =ips.getBasisOrderPreRoad(or);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			preroadlist=ips.getBasisOrderPreRoad(or,currentPage*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Employee getEmploy() {
		return employ;
	}


	public void setEmploy(Employee employ) {
		this.employ = employ;
	}


	public long getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public List<OrderPreRoad> getPreroadlist() {
		return preroadlist;
	}


	public void setPreroadlist(List<OrderPreRoad> preroadlist) {
		this.preroadlist = preroadlist;
	}
	

}
