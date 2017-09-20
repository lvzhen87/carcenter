package com.freshen.basis.service;

import java.util.ArrayList;

import com.freshen.entity.basis.ExpendRecord;
import com.freshen.util.Page;

public interface ExpendRecordService {

	/**
	 * 通过条件查询员工消费记录表
	 * 	   
	 * getExpendRecord
	 * 
	 * @param		String strSysNo 员工编号
	 * 				month 月份
	 * 			    page  分页对象
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public ArrayList<ExpendRecord> getExpendRecord(String strSysNo, String strEmplyName, Page page) throws Exception;
	
	/**
	 * 通过条件查询员工消费记录表,返回记录件数
	 * 	   
	 * getExpendRecordNum
	 * 
	 * @param		String strSysNo 员工编号
	 * 				month 月份
	 * @return		Int    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public int getExpendRecordNumber(String strSysNo, String strEmplyName) throws Exception;
	
	
	public int setExpend() throws Exception;
	
	
	public ArrayList<ExpendRecord> getLastBalenceinfo() throws Exception;
}
