package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.Customer;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ShowCustomerByIDAction extends CapgActionSupport{
	List<Customer> customer = new ArrayList<Customer>();
	String userID;
	
	public String showCustomerByID(){
		try {
			
			//设置customer的状态为1：提交
			Customer tempcus=new Customer();
			tempcus.setCustomerID_s(userID);
			
			//System.out.println("+++++++++++++"+userID);
			IcustomerService icustomerService = new CustomerServiceImpl();
			////System.out.println("11111111");
			customer= icustomerService.getCustomer(tempcus, ConstantUtil.pagingNot,0);
			////System.out.println("222222");
			//System.out.println("查出 信息 "+customer.size());
		
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		
		return "query";
	}

	
	public List<Customer> getCustomer() {
		return customer;
	}


	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
}
