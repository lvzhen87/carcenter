package com.freshen.basis.service;

import java.util.List;

import com.freshen.entity.basis.OrganizationTree;

/**
 * 
 * 组织架构树操作    
 * 项目名称：carcenter    
 * 类名称：IorganizationTreeService    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-6-25 上午09:39:12    
 * 修改人：kxc    
 * 修改时间：2014-6-25 上午09:39:12    
 * 修改备注：    
 * @version     
 *
 */
public interface IorganizationTreeService {

	/**
	 * 根据上级编号和上级类型查询它的下一级对象
	 * getOrganizationNodebySuperior 
	 * @param   superior_s 上级编号
	 *     		superiorType_i 上级类型
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationTree> getOrganizationNodebySuperior(String superior_s,Integer superiorType_i) throws Exception ;
	
	/**
	 * 操作组织架构树 	   
	 * OperationOrganization 
	 * @param   organizationTree 树对象    
	 * 			operation 操作 1：新增  2：修改 3：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationOrganization(OrganizationTree organizationTree, int operation)
	throws Exception ;
	
	
	/**
	 * 操作组织架构树 	   
	 * OperationOrganization 
	 * @param   organizationTree 树对象    
	 * 			operation 操作 1：新增  2：修改 3：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String OperationOrganizationReturnNo(List<OrganizationTree> organizationTree, int operation)
	throws Exception ;
	
	/**
	 * 获得整个组织架构树对象
	 * getOrganizationNodebySuperior 
	 * @param   superior_s 上级编号
	 *     		superiorType_i 上级类型
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrganizationTree> getAllOrganizationNode() throws Exception ;
}
