package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;

/**
 *     
 * 项目名称：carcenter    
 * 类名称：IcustomerService    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-3-29 下午04:50:37    
 * 修改人：kxc    
 * 修改时间：2014-3-29 下午04:50:37    
 * 修改备注：    
 * @version     
 *
 */
public interface  IcustomerUserService {

	
	/**
	 * 
	   
	 * getCustomer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<CustomerUser> getCustomerUser(CustomerUser customerUser) throws Exception;
	/**
	 * 找到该公司的客户负责人
	 * @param  客户人员
	 * @param  @return    设定文件    
	 * @return String    
	 * @author sharonyshi
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList findCustomerUser(CustomerUser customerUser) throws Exception;
	/**
	 *  Function:查询注册用户，分页
	 *  @author Freshen  DateTime 2014-4-9 上午11:20:38
	 *  @param customerUser
	 *  @param start
	 *  @param size
	 *  @return
	 */
	public ArrayList getCustomerUser(CustomerUser customerUser,int start,int size) throws Exception;
	/**
	 * 
	 * updateCustomerUserStatus 修改状态
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	//public int updateCustomerUserStatus(String customerUserid, String status,Session session) throws Exception; 
	/**
	 *  Function:获取符合条件 联系人数目
	 *  @author Freshen  DateTime 2014-4-9 上午11:25:45
	 *  @param customerUser
	 *  @return 联系人数量
	 */
	public long getCustomerUserNubmer(CustomerUser customerUser) throws Exception;
	
	/**
	 * 保存客户人员信息表
	 * OperationBasisCustomerUser 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationBasisCustomerUser(CustomerUser customerUser) throws Exception;
	public String OperationBasisCustomerUser2(CustomerUser customerUser) throws Exception;
	
	/**
	 * 删除客户信息
	 * @param customerUser
	 * @return
	 * @throws Exception
	 */
	public int DeleteBasisCustomerUser(CustomerUser customerUser) throws Exception;
	
	/**
	 * 批量操作客户人员信息表
	 * OperationBasisCustomerUserList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationBasisCustomerUserList(List<CustomerUser> customerUsers,Session session) throws Exception;
}
