package com.freshen.preorder.action;

import com.freshen.preorder.service.IpreorderCheckService;
import com.freshen.preorder.service.impl.PreorderCheckServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: OneKeyCheckOrderAction.java
 *  Function:用于一键审核 订单，
 *     Modifications:   
 *  @author   DateTime 2014-4-19 下午01:49:07    
 *  @version 1.0
 */
public class OneKeyCheckOrderAction extends CapgActionSupport {
	String rs=SUCCESS;
	String orderid;	//需要一键审核的 订单ID
	int isok;
	String msg="";
	/**
	 * 一键审核 默认采用的方法， 是否需要实现该方法，需要 试验场确认！
	 */
	public String execute(){
		try {
			if(orderid==null){
				return rs;
			}
			IpreorderCheckService ipreorderCheckService = new PreorderCheckServiceImpl();
			//如果审核通过传入参数1，否则传入非1的参数视为冲突
			ipreorderCheckService.preorderCheck(orderid,isok);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return rs;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getIsok() {
		return isok;
	}
	public void setIsok(int isok) {
		this.isok = isok;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
