package com.freshen.basis.service;

import java.util.ArrayList;

import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.VCustomeuser;
import com.freshen.util.Page;


public interface ICustomerUserViewService {
	/**
	 * 查询客户人员与客户驾驶员试图
	 * 
	 * @param1		指定条件的人员
	 * @param2     	 分页
	 * @param3		每页指定数量
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public ArrayList<VCustomeuser> getCustomerUser(VCustomeuser vcustomeuser,int start,int size) throws Exception;
	public ArrayList<VCustomeuser> getCusUserforReception(VCustomeuser vcustomeuser,int start,int size) throws Exception;

	
	public long getCustomerUserNumber(VCustomeuser vcustomeuser) throws Exception;
	
	/**
	 * 查询进入到试验场
	 * getIndata
	 * 
	 * @param		String strSysNo
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public ArrayList<CustomerUser> getIndata(String dptName, String emplyName, Page page) throws Exception;
	
	/**
	 * 查询进入到试验场人员总数
	 * getIndataNumber
	 * 
	 * @param		String strSysNo
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public int getIndataNumber(String dptName, String emplyName) throws Exception;
	
}
