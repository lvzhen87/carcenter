package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;


import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class HotelAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	List<OrderHotelOther> hotelotherlist=new ArrayList<OrderHotelOther>();
	
	public String execute(){
		try {
			
			IorderInfoService iis=new OrderInfoServiceImpl();
							
			hotelotherlist=iis.getOrderHotelOther(orderId);
			
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


	public List<OrderHotelOther> getHotelotherlist() {
		return hotelotherlist;
	}


	public void setHotelotherlist(List<OrderHotelOther> hotelotherlist) {
		this.hotelotherlist = hotelotherlist;
	}


	

}
