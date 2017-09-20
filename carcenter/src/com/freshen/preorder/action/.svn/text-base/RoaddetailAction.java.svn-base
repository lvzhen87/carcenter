package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.preorder.service.IorderSharingRoadService;
import com.freshen.preorder.service.impl.OrderSharingRoadServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class RoaddetailAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	List<OrderSharingRoad> sharingroadlist=new ArrayList<OrderSharingRoad>();
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	
	public String execute(){
		try {
			OrderSharingRoad osd=new OrderSharingRoad();
			osd.setOrderID_s(orderId);
			
			IorderSharingRoadService iosrs=new OrderSharingRoadServiceImpl();
			//确定记录总数
			totalPages =iosrs.getBasisOrderSharingRoad(osd);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			sharingroadlist=iosrs.getBasisOrderSharingRoad(osd,currentPage*pageSize, pageSize);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public List<OrderSharingRoad> getSharingroadlist() {
		return sharingroadlist;
	}



	public void setSharingroadlist(List<OrderSharingRoad> sharingroadlist) {
		this.sharingroadlist = sharingroadlist;
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
	
	
	
	
}
