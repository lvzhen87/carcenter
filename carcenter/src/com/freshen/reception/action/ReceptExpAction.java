package com.freshen.reception.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.Customer;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
/**
 *  Class Name: ReceptExpAction.java
 *  Function:查询当日需要接待的试验，跳转到试验接待页面
 *     Modifications:   
 *  @author   DateTime 2014-4-11 下午02:28:00    
 *  @version 1.0
 */
public class ReceptExpAction extends CapgActionSupport{
	String rs=SUCCESS;
	List<ReceptionOrder> OrderList=new ArrayList();
	//List<ReceptionOrder> OrderListforSearch=new ArrayList();

	String orderID,orderName,customerName;
	String msg="";
	//分页必须
	long totalOrders;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	/**************20160518 kxc****************************/	
	String resaveds2;//cpg拍照
	public String getResaveds2() {
		return resaveds2;
	}

	public void setResaveds2(String resaveds2) {
		this.resaveds2 = resaveds2;
	}

	/******************end************************************/
	/**
	 * Function:查询今日需要接待的试验订单
	 * @author sharonyshi 2014-4-19
	 */
	public String execute(){
		try {
			//设置要查询的订单条件
			ReceptionOrder recorder =new ReceptionOrder();
			recorder.setStatus_i(ConstantUtil.orderStatus_2);//订单状态为2：预订已确认
			recorder.setStartDate_d(DateUtil.getCurrentDate());//获取今日试验时间
			
			
			IreceptionOrderService irecorderService=new ReceptionOrderServiceImpl();
			/*//确定记录总数
			totalOrders =irecorderService.getReceptionOrderbyDateNumber(recorder);
			maxPage=(int) (totalOrders%pageSize==0?totalOrders/pageSize:totalOrders/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}*/
			OrderList=irecorderService.getReceptionOrderbyDate(recorder,ConstantUtil.pagingNot,0);

		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		
		return rs;
	}
	
	public String searchExperience(){
		try {
		/*	Customer c=new Customer();
			c.setCustomerName_s(customerName);
			
			IcustomerService ics=new CustomerServiceImpl();
			ArrayList<Customer> clist=ics.getCustomer(c, ConstantUtil.pagingNot,ConstantUtil.pageSize);
			
			if(clist != null && clist.size()>0){
				for (int i = 0; i < clist.size(); i++) {*/
			
			//cpg牌照不为空，查询出订单编号
			if(resaveds2!=null&&resaveds2.trim().length()>0){
				IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
				ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
				rVehicleInfo.setResaveds2_s(resaveds2);
				ArrayList<ReceptionVehicleInfo> rviList = ireceptionVehicleInfoService.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0);
				if(rviList != null && rviList.size()>0){	
					orderID = rviList.get(0).getOrderID_s();
				}
			}
	
			//设置要查询的订单条件
			ReceptionOrder recorder =new ReceptionOrder();
			recorder.setOrderID_s(orderID);
			recorder.setOrderName_s(orderName);
			/*if(clist.get(i).getCustomerID_s() != null && clist.get(i).getCustomerID_s().length() >0){
				recorder.setCustomerID_s(clist.get(i).getCustomerID_s());
			}*/
			Customer c=new Customer();
			c.setCustomerName_s(customerName);
			recorder.setCustomer(c);
			
			//订单状态为5：已进场VV6：实验进行中
			recorder.setStatus_s(ConstantUtil.orderStatus_5+"vv"+ConstantUtil.orderStatus_6);
			
			IreceptionOrderService irecorderService=new ReceptionOrderServiceImpl();
			ArrayList<ReceptionOrder> rolist=irecorderService.getReceptionOrder(recorder,ConstantUtil.pagingNot,0);
			OrderList.addAll(rolist);
			/*	}
				
			}*/
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
			// TODO: handle exception
		}
		return rs;
	}
	
	
	
	public String SearchOrderByID(){
		try {
			/*if(orderID==null || orderID.length()<1){
				msg="请输入要查询的订单编号！";
				return ERROR;
			}
			
			*/
			//设置要查询的订单条件
			Customer c=new Customer();
			c.setCustomerName_s(customerName);
			
			IcustomerService ics=new CustomerServiceImpl();
			ArrayList<Customer> clist=ics.getCustomer(c, ConstantUtil.pagingNot,ConstantUtil.pageSize);
			
			//cpg拍照不为空，查询出订单编号
			if(resaveds2!=null&&resaveds2.trim().length()>0){
				IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
				ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
				rVehicleInfo.setResaveds2_s(resaveds2);
				ArrayList<ReceptionVehicleInfo> rviList = ireceptionVehicleInfoService.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0);
				if(rviList != null && rviList.size()>0){	
					orderID = rviList.get(0).getOrderID_s();
				}
			}
			
			if(clist != null && clist.size()>0){
				for (int i = 0; i < clist.size(); i++) {
					ReceptionOrder recorder =new ReceptionOrder();
					recorder.setOrderID_s(orderID);//设置要查询的订单编号
					recorder.setOrderName_s(orderName);
					if(clist.get(i).getCustomerID_s() != null && clist.get(i).getCustomerID_s().length() >0){
						//2014-11-14
						recorder.getCustomer().setCustomerID_s(clist.get(i).getCustomerID_s());
					}
					recorder.setStatus_i(ConstantUtil.orderStatus_2);//订单状态为2：预订已确认
					recorder.setStartDate_d(DateUtil.getCurrentDate());//获取今日试验时间
					
					
					IreceptionOrderService irecorderService=new ReceptionOrderServiceImpl();
					ArrayList<ReceptionOrder> rolist=irecorderService.getReceptionOrder(recorder, ConstantUtil.pagingNot,0);
					OrderList.addAll(rolist);
				}
			}
			
			
			
			if(OrderList==null){
				msg="查无该订单记录";
				return ERROR;
			}
			//	Yepeng Add Start
			if(OrderList.size() == 0){
				msg="查无该订单记录";
				return ERROR;
			}
			//	Yepeng Add End
			if(OrderList.get(0)==null){
				msg="查无该订单记录";
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
			// TODO: handle exception
		}
		return SUCCESS;
	}
	
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(long totalOrders) {
		this.totalOrders = totalOrders;
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

	public List<ReceptionOrder> getOrderList() {
		return OrderList;
	}

	public void setOrderList(List<ReceptionOrder> orderList) {
		OrderList = orderList;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	

	
	
}
