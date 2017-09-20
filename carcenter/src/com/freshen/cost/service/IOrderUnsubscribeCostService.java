package com.freshen.cost.service;

import java.util.ArrayList;

import com.freshen.entity.cost.TCostOrderunsubscribecost;

public interface IOrderUnsubscribeCostService {

	/**
	 * 获得退订记录	   
	 * getTCostOrderothercost 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<TCostOrderunsubscribecost> getTCostOrderothercost(
			TCostOrderunsubscribecost tCostOrderunsubscribecost, int start, int size)
			throws Exception ;
	
	/**
	 * 获得退订记录数	   
	 * getTCostOrderothercostNumber 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getTCostOrderothercostNumber(
			TCostOrderunsubscribecost tCostOrderunsubscribecost)
			throws Exception ;
	
	/**
	 * 维护退订信息	   
	 * OperationTCostOrderothercost 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTCostOrderothercost(
			TCostOrderunsubscribecost tCostOrderunsubscribecost, Integer operation)
			throws Exception ;
}
