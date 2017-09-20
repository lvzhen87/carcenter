package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.OrderWholeRoad;

public interface IcustomerService {

	/**
	 * 	   
	 * updateCustomerStatus 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateCustomerStatus(String customer_id, String status,Session session)throws Exception ;
	
	/**
	 * 查询客户信息
	   
	 * getCustomer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Customer> getCustomer(Customer customer,int start,int size) throws Exception;
	/**
	 * 符合条件数量
	   
	 * getCustomerNubmer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getCustomerNubmer(Customer customer) throws Exception;
	
	/**
	 * 
	 * registCustomer 内网注册客户信息
	 * @param	Customer
	 * @param	contactcustomerUser
	 * @param	responsecustomerUser
	 * @return	int 1.注册成功  
	 * @author	yepeng   
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int registCustomer(Customer customer, CustomerUser contactcustomerUser,CustomerUser responsecustomerUser) throws Exception;
	
	/**
	 * 
	 * getInvoiceOrder 发票抬头不能重复的check
	 * @param	    
	 * @return	
	 * @author	yepeng   
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getInvoiceOrder(String invoiceOrder) throws Exception;
	
	/**
	 * 
	 * getCustomerLoginName 昵称不能重复的check
	 * @param	    
	 * @return	
	 * @author	yepeng   
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getCustomerLoginName(String CustomerLoginName) throws Exception;
	
	/**
	 * 增加 修改 删除 客户信息
	 * @param orderSharingRoad
	 * @param operation  1：增加 修改 2：删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationCustomer(List<Customer> customer,int operation) throws Exception;
}
