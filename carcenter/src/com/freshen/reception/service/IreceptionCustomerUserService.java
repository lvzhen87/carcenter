package com.freshen.reception.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.CustomerRegister;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.reception.CardInfo;
import com.freshen.entity.reception.ReceptionCustomerUser;

/**
 * 订单相关客户人员信息表 操作
 *     
 * 项目名称：carcenter    
 * 类名称：IreceptionCustomerUserService    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-4-14 下午04:15:19    
 * 修改人：kxc    
 * 修改时间：2014-4-14 下午04:15:19    
 * 修改备注：    
 * @version     
 *
 */
public interface IreceptionCustomerUserService {

	/**
	 * 得到订单相关客户人员信息表信息	   
	 * getReceptionCustomerUser 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<ReceptionCustomerUser> getReceptionCustomerUser(ReceptionCustomerUser receptionCustomerUser,int start,int size)throws Exception;
	/**
	 * 得到订单相关客户人员信息表数量
	 * getReceptionCustomerUserNumber 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getReceptionCustomerUserNumber(ReceptionCustomerUser receptionCustomerUser) throws Exception;
	
	/**
	 * 
	 * OperationReceptionCustomerUser 
	 * @param   
	 *          customerUser  客户人员集合  
	 *          operatio 1：新增 2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationReceptionCustomerUser (List<ReceptionCustomerUser> customerUser,int operatio) throws Exception;
	
	/**
	 * 操作接待模块订单相关客户人员信息表 在事务中
	 * OperationReceptionCustomerUser
	 * @param   
	 *          customerUser  客户人员集合  
	 *          operatio 1：新增 2：删除
	 *          session :在某事务中
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationReceptionCustomerUser(
			 List<ReceptionCustomerUser> customerUsers,Session session,int operation)
			throws Exception ;
	
	/**
	 * 根据ReceptionCustomerUser集合查询customerUser得到每个用户的sysNo_s
	 * setCustomerUser 
	 * @param   orderid_s 订单编号    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<ReceptionCustomerUser> getCustomerUserAllpro(ReceptionCustomerUser receptionCustomerUser)throws Exception;
	
	/**
	 * 
	 * 将订单对应的预约模块到访人员信息表复制到接待模块订单相关客户人员信息表
	 * addReceptionCustomerUser 
	 * @param   orderID_s 订单id
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void addReceptionCustomerUser(String orderID_s,Session session)throws Exception;
}
