package com.freshen.ground.action;

import com.freshen.action.common.CapgActionSupport;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.util.ExceptionDispose;

public class ApplyAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	String orderId;
	String status;
	
	public String execute(){
		try {
			//记录传入的orderID，用于每次请求数据
			ActionContext.getContext().getSession().put("orderId",orderId);
			ActionContext.getContext().getSession().put("orderstatus",status);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;
	}

	
	public String recordOrderinfo(){
		try {
			//记录传入的orderID，用于每次请求数据
			ActionContext.getContext().getSession().put("orderId",orderId);
			ActionContext.getContext().getSession().put("orderstatus",status);
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
