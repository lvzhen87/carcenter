package com.freshen.ground.action;

import java.util.ArrayList;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.ICustomerUserViewService;
import com.freshen.basis.service.impl.CutomerUserViewServiceimpl;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.util.Page;

public class GroundCustomeruserAction extends CapgActionSupport{
	
	String deptName;
	String emplyName;
	
	ArrayList<CustomerUser> customerustlist=new ArrayList<CustomerUser>();
	//分页必须
	int totalPages;
	int currentPage, maxPage, pageSize = ConstantUtil.pageSize;
	
	
	public String searchCustomeruserShow(){
		try {			
			ICustomerUserViewService c = new CutomerUserViewServiceimpl();
			totalPages=c.getIndataNumber(deptName, emplyName);
			maxPage = (int) (totalPages % pageSize == 0 ? totalPages / pageSize : totalPages / pageSize + 1);
			//	合适当前页的有效性
			if(currentPage <= 0){
				currentPage = 0;
			}else if(currentPage >= maxPage){
				currentPage = maxPage;
			}
			Page page = new Page(totalPages, currentPage);
			customerustlist=c.getIndata(deptName,emplyName,page);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getEmplyName() {
		return emplyName;
	}


	public void setEmplyName(String emplyName) {
		this.emplyName = emplyName;
	}


	public ArrayList<CustomerUser> getCustomerustlist() {
		return customerustlist;
	}


	public void setCustomerustlist(ArrayList<CustomerUser> customerustlist) {
		this.customerustlist = customerustlist;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
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
