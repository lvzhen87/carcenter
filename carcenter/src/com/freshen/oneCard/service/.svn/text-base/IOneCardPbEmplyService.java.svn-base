package com.freshen.oneCard.service;

import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.oneCard.TOnecardPbemplyBak;
import com.freshen.entity.reception.ReceptionCustomerUser;

public interface IOneCardPbEmplyService {

	/**
	 * 操作一卡通用户信息表
	 * OperationPbEmply
	 * @param   tOnecardPbemplyBaks  用户信息    
	 * 			operation 1:新增 2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationPbEmply(List<ReceptionCustomerUser> receptionCustomerUsers,String orderID_s,int operation) throws Exception;
	
	/**
	 * 操作一卡通sql server数据库用户基本信息表
	 * OperationPbEmplyoOeCard 
	 * @param   receptionCustomerUsers 接待模块订单相关客户人员信息表
	 * 			operation 1：新增 2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<CustomerUser> OperationPbEmplyoOneCard(List<ReceptionCustomerUser> receptionCustomerUsers,int operation) throws Exception;
	
	/**
	 * 对试验场管理系统的用户基本信息表进行操作
	 * OperationPbEmplyClims 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationPbEmplyClims(List<TOnecardPbemplyBak> tOnecardPbemplyBaks,int operation,Session session) throws Exception;
}
