package com.freshen.process.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.process.TProcessWashcarinvalid;

public interface TprocessWashcarinvalidService {

	/**
	 * 查询作废记录
	 * getTProcessWashcarinvalidInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<TProcessWashcarinvalid> getTProcessWashcarinvalidInfo(TProcessWashcarinvalid bean, int start,
			int size) throws Exception ;
	
	/**
	 * 查询记录条数	   
	 * getTProcessWashcarinvalidInfoNum 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getTProcessWashcarinvalidInfoNum(TProcessWashcarinvalid bean) throws Exception ;
	
	/**
	 * 维护洗车作废表	   
	 * OperationCustomer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessWashcarinvalidInfo(List<TProcessWashcarinvalid> list, int operation)
	throws Exception ;
	
	/**
	 * 维护洗车作废表	   
	 * OperationCustomer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessWashcarinvalidInfoByTx(List<TProcessWashcarinvalid> list, int operation,Session session)
	throws Exception ;
}
