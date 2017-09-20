package com.freshen.basis.service;

import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.OrganizationDept;

public interface IorganizationDeptService {

	/**
	 * 获得 组织架构部门表对象
	 * getOrganizationDept 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationDept> getOrganizationDept(OrganizationDept organizationDept,int start ,int size) throws Exception ;
	
	/**
	 * 操作组织架构部门表
	 * OperationOrganizationDept 
	 * @param   organizationDept  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return    如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public OrganizationDept OperationOrganizationDeptbyTransaction(OrganizationDept organizationDept, Session session,int operation)
	throws Exception ;
	
	/**
	 * 操作组织架构部门表
	 * OperationOrganizationDept 
	 * @param   organizationDept  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return    如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public OrganizationDept OperationOrganizationDept(OrganizationDept organizationDept,int operation)
	throws Exception ;
	
	/**
	 * 获得一卡通部门信息集合	   
	 * getOneCardpbDepart 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationDept> getOneCardpbDepart() throws Exception;
	
	/**
	 * 同步部门	   
	 * synchronizationDept 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void synchronizationDept()throws Exception;
}
