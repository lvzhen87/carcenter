package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class WholeRoadAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	List<OrderWholeRoad> wholeroadlist=new ArrayList<OrderWholeRoad>();
	
	
	
	public String execute(){
		try {
			OrderWholeRoad owd=new OrderWholeRoad();
			owd.setOrderID_s(orderId);
			
			IorderWholeRoadService iowrs=new OrderWholeRoadServiceImpl();
			totalPages =iowrs.getBasisOrderWholeRoad(owd);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			wholeroadlist=iowrs.getBasisOrderWholeRoad(owd,currentPage*pageSize, pageSize);
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



	public List<OrderWholeRoad> getWholeroadlist() {
		return wholeroadlist;
	}



	public void setWholeroadlist(List<OrderWholeRoad> wholeroadlist) {
		this.wholeroadlist = wholeroadlist;
	}
	
	
	
	
}
