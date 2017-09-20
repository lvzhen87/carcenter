package com.freshen.basis.service;

import org.hibernate.Session;

import com.freshen.entity.basis.PasswordInfo;

public interface IpasswordInfoService {

	/**
	 *  Function:根据指导的PasswordInfo实体，查询该对象的完整属性
	 *  @author Freshen  DateTime 2014-4-17 上午10:58:35
	 *  @param pi，PasswordInfo实体，含有employeeID_s属性
	 *  @return
	 *  @throws Exception
	 */
	public PasswordInfo getPasswordInfo(PasswordInfo pi) throws Exception;
	
	
	public int OperationPasswordInfo(PasswordInfo pi,int operation) throws Exception;
	
	public int OperationPasswordInfo(PasswordInfo pi ,int operation,Session session) throws Exception ;
}
