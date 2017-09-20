package com.freshen.basis.service;

import java.util.ArrayList;

import com.freshen.entity.basis.Driver;

public interface IDriverService {

	/**
	 * 通过条件查询驾驶员信息表
	   
	 * getBasisDriverInfo 
	 * @param   name    
	 * @param  @return    List    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<Driver> getBasisDriverInfo(Driver driver, int start, int size) throws Exception;
	
	/**
	 * 通过条件查询驾驶员信息表，返回取得个数
	   
	 * getBasisDriverInfoNumber 
	 * @param   name    
	 * @param  @return    Long    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public long getBasisDriverInfoNumber(Driver driver) throws Exception;
	
	/**
	 * 保存驾驶员信息
	   
	 * saveOrUpdateBasisDriverInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveOrUpdateBasisDriverInfo(ArrayList<Driver> list) throws Exception;
	public String saveOrUpdateBasisDriverInfo2(ArrayList<Driver> list) throws Exception;
	/**
	 * 删除驾驶员信息
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public int deleteBasisDriverInfo(ArrayList<Driver> list) throws Exception;
}
