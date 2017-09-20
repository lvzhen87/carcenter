package com.freshen.reception.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: EntourageSearchAction.java
 *  Function:查询随行人员信息
 *     Modifications:   
 *  @author   DateTime 2014-4-25 上午11:45:47    
 *  @version 1.0
 */
public class EntourageSearchAction extends CapgActionSupport {
	String orderID;	//订单id
	String customerUserID;//客户人员ID
	List<ReceptionCustomerUser> entourages;	//随行人员 实体集合
	String msg;
	/**
	 * 直接跳转到 随行人员查询entouragesearch.jsp页面
	 */
	public String execute(){
		//	yepeng add Start
		searchEntouragesByOrderId();
		//	yepeng add End
		/*try {
			IreceptionCustomerUserService entourageSer=new ReceptionCustomerUserServiceImpl();
			ReceptionCustomerUser temp=new ReceptionCustomerUser();
			temp.setOrderID_s("null");	//查询该订单 所对应的 随行人员
			//将查询到的 结果，存入集合
			setEntourages(entourageSer.getReceptionCustomerUser(temp, ConstantUtil.pagingNot, 0));
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}*/
		return SUCCESS;
	}
	/**
	 *  Function:根据页面传来的订单ID，查询该订单的相关 随行人员 
	 *  @author Freshen  DateTime 2014-4-25 上午11:51:40
	 *  @return
	 */
	public String searchEntouragesByOrderId(){
		/*if(orderID==null || orderID.trim().length()<1){
			setMsg("请输入订单号！");
			return SUCCESS;
		}*/
		try {
			IreceptionCustomerUserService entourageSer=new ReceptionCustomerUserServiceImpl();
			ReceptionCustomerUser temp=new ReceptionCustomerUser();
			temp.setOrderID_s(orderID);	//查询该订单 所对应的 随行人员
			//将查询到的 结果，存入集合
			setEntourages(entourageSer.getReceptionCustomerUser(temp, ConstantUtil.pagingNot, 0));
			//System.out.println("查出 订单"+orderID+ "的随行人员个数  "+entourages.size());
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			  
		}
		
		return SUCCESS;
	}
	
	/**
	 * Function 删除接待客户人员信息
	 * @author sharonyshi 2014-4-25
	 * @return
	 */
	public String deleteEntouragesByOrderId(){
		try {
			//要删除的接待客户人员信息
			ReceptionCustomerUser recCustomerUser=new ReceptionCustomerUser();
			recCustomerUser.setCustomerUserID_s(customerUserID);
			recCustomerUser.setOrderID_s(orderID);
			ArrayList<ReceptionCustomerUser> recepCustomerUserList=new ArrayList<ReceptionCustomerUser>();
			recepCustomerUserList.add(recCustomerUser);
			
			IreceptionCustomerUserService irecepUserService=new ReceptionCustomerUserServiceImpl();
			irecepUserService.OperationReceptionCustomerUser(recepCustomerUserList, 2);
			
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
	public List<ReceptionCustomerUser> getEntourages() {
		return entourages;
	}
	public void setEntourages(List<ReceptionCustomerUser> entourages) {
		this.entourages = entourages;
	}
	public String getCustomerUserID() {
		return customerUserID;
	}
	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}
	
}
