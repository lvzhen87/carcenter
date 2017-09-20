package com.freshen.preorder.action;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IpreorderCheckService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.preorder.service.impl.PreorderCheckServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 *  Class Name: PreorderCheckActio.java
 *  Function:登录成功后，跳转到此Action，查询 申请申请页面的基本数据
 *  
 *     Modifications:   
 *  
 *  @author freshen  DateTime 2014-3-28 下午12:ConstantUtil.pageSize:19    
 *  @version 1.0
 */
public class PreorderCheckAction extends CapgActionSupport{

	List<Customer> customerList;//存放客户信息
	String msg;
	String userID,customerstatus;
	public static String PREORDER = "preorder";
	public String resStr=SUCCESS;
	//分页必须
	long totalCustomer;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	/**
	 *  Function:查询所有注册客户信息
	 *  @author Freshen  DateTime 2014-4-9 上午10:34:41
	 *  @return
	 */
	public String searchAllRegUsers(){
		try {
			
			Customer customer = new Customer();
			IcustomerService icustomerService = new CustomerServiceImpl();
			//确定记录总数
			totalCustomer =icustomerService.getCustomerNubmer(customer);
			
			maxPage=(int) (totalCustomer%pageSize==0?totalCustomer/pageSize:totalCustomer/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
		
			customerList= icustomerService.getCustomer(customer,currentPage*pageSize,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}		
		
		//System.out.println("查出联系人数目："+customerList.size());
		return resStr;
	}
	/**
	 *	Function:查询所有未审核的注册联系人信息
	 *  @author sharonyshi  DateTime 2014-4-18 上午10:56:41
	 * @return
	 */
	public String initialize(){
		//System.out.println("进入PreorderCheckAction中 initialize方法 ");
	try {
		
		//设置customer的状态为1：提交
		Customer customer = new Customer();
		customer.setStatus_i(1);
		
		IcustomerService icustomerService = new CustomerServiceImpl();
		
		//确定记录总数
		totalCustomer =icustomerService.getCustomerNubmer(customer);
		//System.out.println("totalcustomer  Number===="+totalCustomer);
		maxPage=(int) (totalCustomer%pageSize==0?totalCustomer/pageSize:totalCustomer/pageSize+1);
		//合适当前页的有效性
		if(currentPage<=0){
			currentPage=0;
		}else if(currentPage>=maxPage){
			currentPage=maxPage;
		}
		
		customerList= icustomerService.getCustomer(customer,currentPage*pageSize,pageSize);
		//System.out.println("查出 信息 "+customerList.toString());

		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}		
		return PREORDER;
	}
	/**
	 *	Function:修改注册联系人状态
	 *  @author sharonyshi  DateTime 2014-4-18 上午10:56:41
	 * @return
	 */
	public String check(){
		try {
		
			IpreorderCheckService ipreorderCheckService = new PreorderCheckServiceImpl();
			String customerid = userID;
			String status = String.valueOf(customerstatus);
		
			ipreorderCheckService.customerCheck(customerid,status);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return initialize();
	}
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCustomerstatus() {
		return customerstatus;
	}

	public void setCustomerstatus(String customerstatus) {
		this.customerstatus = customerstatus;
	}

	public String getResStr() {
		return resStr;
	}

	public void setResStr(String resStr) {
		this.resStr = resStr;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public long getTotalCustomer() {
		return totalCustomer;
	}
	public void setTotalCustomer(long totalCustomer) {
		this.totalCustomer = totalCustomer;
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
