package com.freshen.preorder.action;

import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class ApplyAction extends CapgActionSupport{
	String orderId;
	
	public String execute(){
		//记录传入的orderID，用于每次请求数据（目前计划将tab拆开做）
		ActionContext.getContext().getSession().put("orderId",orderId);
		
		return SUCCESS;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	

}
