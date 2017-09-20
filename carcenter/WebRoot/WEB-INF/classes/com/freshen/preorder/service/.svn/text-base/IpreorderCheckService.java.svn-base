package com.freshen.preorder.service;

import java.util.ArrayList;

import com.freshen.entity.Customer;


public interface IpreorderCheckService {

	/**
	 * 客户注册审核功能
	 * customerCheck 
	 * @param   customerid 客户人员id
	 * @param   status     状态
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int customerCheck(String customerUserid, String status)throws Exception ;

	/**
	 * 订单审核功能
	 * preorderCheck 
	 * @param   orderid  订单id    
	 *          type     1:审核通过  其他代表审核不通过  
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int preorderCheck(String orderID,int type)throws Exception ;
	
	/**
	 * 一键审核方法
	 * @param orderId_s
	 * @param status
	 * @return
	 * @throws Exception
	 */
//	public int OneKeyCheckOrder(String orderId_s,String status)throws Exception;
}
