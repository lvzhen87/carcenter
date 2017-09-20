package com.freshen.reception.action;

import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class GrantApplyAction extends CapgActionSupport{
	String orderId,customerId;
	
	public String execute(){
		try {
			//将orderid 和customerid记录到session中
			ActionContext.getContext().getSession().put("orderId",orderId);
			ActionContext.getContext().getSession().put("customerId",customerId);
			
			//确认订单进行接待
			IreceptionOrderService rec=new  ReceptionOrderServiceImpl();
			rec.affirmReception(orderId);
			/*IcardInfoService icis=new CardInfoServiceImpl();
			int r=icis.initVehicleInfo(orderId);*/
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}

	public String recordID(){
		try {
			//将orderid 和customerid记录到session中
			ActionContext.getContext().getSession().put("orderId",orderId);
			ActionContext.getContext().getSession().put("customerId",customerId);
			
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
