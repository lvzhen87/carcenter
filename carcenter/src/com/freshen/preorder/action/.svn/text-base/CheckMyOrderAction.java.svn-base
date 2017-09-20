package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.Orderroaddaydetail;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.IorderRoadDayDetailService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.preorder.service.impl.OrderRoadDayDetailServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: CheckMyOrderAction.java
 *  Function:审核试验  菜单，用于查出相应订单
 *     Modifications:   
 *  @author   DateTime 2014-4-19 下午03:24:27    
 *  @version 1.0
 */
public class CheckMyOrderAction extends CapgActionSupport{
	String QUERY="query";
	List<OrderDetail> myOrdersList=new ArrayList<OrderDetail>();
	String orderID,orderName,states;	//查询订单的条件，订单号和订单状态
	//分页
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	/**
	 *  Function: 页面初始化时调用，默认查出 登录 试验助理 所要处理  的 订单信息
	 *  @author Freshen  DateTime 2014-4-19 下午03:25:55
	 *  @return
	 */
	public String initorders(){
		try {
			Map mapSess=ActionContext.getContext().getSession();
			Employee employee=null;
			if(mapSess.get("loginEmployee")==null){
				//return ERROR;
			}else{
				employee=(Employee) mapSess.get("loginEmployee");
			}
			OrderDetail orders=new OrderDetail();
			orders.setStatus_i(ConstantUtil.orderStatus_1);
			//获取登录员工ID
			Employee employ=(Employee) mapSess.get("loginEmployee");
			if(employ != null){
				orders.setEmployeeID_s(employ.getEmployeeID_s());
			}
			
			
				IorderInfoService iorderInfoService=new OrderInfoServiceImpl();
				//myOrdersList=iorderInfoService.getOrder(orders);
				
				totalPages=iorderInfoService.getOrderInfoNumber(orders);
				maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
				//合适当前页的有效性
				if(currentPage<=0){
					currentPage=0;
				}else if(currentPage>=maxPage){
					currentPage=maxPage;
				}
				
				myOrdersList=iorderInfoService.getOrder(orders,currentPage*pageSize, pageSize);
				
				
				QUERY=SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		
		return QUERY;
	}
	/**
	 *  Function:条件查询订单， 登录 助理，可以指定条件查询 对于的订单信息
	 *  @author Freshen  DateTime 2014-4-19 下午03:27:41
	 *  @return
	 */
	public String searchOrders(){
//		//System.out.println("条件查询 订单   orderID="+orderID +" states="+states);
		//判断登录
		Map mapSess=ActionContext.getContext().getSession();
		Employee employee=null;
		if(mapSess.get("loginEmployee")==null){
			return ERROR;
		}else{
			employee=(Employee) mapSess.get("loginEmployee");
		}
		OrderDetail order=new OrderDetail();
		//设定 查询条件
		
		order.setOrderID_s(orderID);
		order.setOrderName_s(orderName);
		if(states!=null && !states.equals("-1")){
			order.setStatus_i(Integer.parseInt(states));
		}else{
			order.setStatus_i(ConstantUtil.orderStatus_1);
		}
		//设定助理 ID号，登录助理，只能查询自己 所拥有的订单
		order.setEmployeeID_s(employee.getEmployeeID_s());
		
		try {
			IorderInfoService iorderInfoService=new OrderInfoServiceImpl();
			totalPages=iorderInfoService.getOrderInfoNumber(order);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			myOrdersList=iorderInfoService.getOrder(order,currentPage*pageSize, pageSize);
			QUERY=SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return QUERY;
	}
	
	

	public List<OrderDetail> getMyOrdersList() {
		return myOrdersList;
	}

	public void setMyOrdersList(List<OrderDetail> myOrdersList) {
		this.myOrdersList = myOrdersList;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
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
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
}
