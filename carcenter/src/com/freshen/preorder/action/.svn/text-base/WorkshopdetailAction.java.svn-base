package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.preorder.service.impl.OrderWorkShopServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class WorkshopdetailAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	List<OrderWorkShop> workshoplist=new ArrayList<OrderWorkShop>();
	
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	
	public String execute(){
		try {
			OrderWorkShop ows=new OrderWorkShop();
			ows.setOrderID_s(orderId);
			
			IorderWorkShopService iwss=new OrderWorkShopServiceImpl();
			//确定记录总数
			totalPages =iwss.getBasisWorkShop(ows);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			workshoplist=iwss.getBasisWorkShop(ows,currentPage*pageSize, pageSize);
			
			
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



	public List<OrderWorkShop> getWorkshoplist() {
		return workshoplist;
	}



	public void setWorkshoplist(List<OrderWorkShop> workshoplist) {
		this.workshoplist = workshoplist;
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
