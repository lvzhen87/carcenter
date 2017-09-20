package com.freshen.basis.service;

import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.OrganizationPost;

public interface IorganizationPostService {

	/**
	 * 获得 组织架构岗位表对象
	 * getOrganizationDept 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationPost> getOrganizationPost(OrganizationPost organizationPost,int start ,int size) throws Exception ;
	
	/**
	 * 在事务中操作组织架构岗位表
	 * OperationOrganizationPostbyTransaction 
	 * @param   OrganizationPost  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return    如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String OperationOrganizationPostbyTransaction(OrganizationPost organizationPost, Session session,int operation)
	throws Exception ;
	
	/**
	 * 操作组织架构岗位表
	 * OperationOrganizationDept 
	 * @param   organizationDept  修改的对象  
	 * session 上下文  
	 * operation 操作 1：新增或修改 2：删除 3：根据id增加下级
	 * @param  @return    如果是修改下级序号+1，将当前下级序号返回
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String OperationOrganizationDept(OrganizationPost organizationPost,int operation)
	throws Exception ;
}
