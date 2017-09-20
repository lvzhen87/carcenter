package com.freshen.oneCard.service;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.oneCard.TOnecardMjreguserBak;
import com.freshen.entity.oneCard.TOnecardPbemplyBak;
import com.freshen.entity.reception.ReceptionCustomerUser;

public interface ItOnecardMjreguserService {

	/**
	 * 操作一卡通登记用户表	   
	 * OperationMjreguserOneCard 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationMjreguserOneCard(List<TOnecardMjreguserBak>  list,String orderID, int operation,Connection sqlcon)
		throws Exception;
	
	/**
	 * 根据订单相关客户人员信息以及选择房门信息转换为登记用户表信息
	 * setTOnecardMjreguserPro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TOnecardMjreguserBak> setTOnecardMjreguserPro(List<ReceptionCustomerUser> receptionCustomerUsers)
	throws Exception;
	 
	
	/**
	 * 操作试验场管理系统登记用户表（Mj_RegUser）
	 * OperationTOnecardMjreguserBak 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTOnecardMjreguserBak(
			 List<TOnecardMjreguserBak> tOnecardMjreguserBaks,Session session,int operation)
			throws Exception ;
	
	/**
	 * 赋权或删除权限操作	   
	 * OperationMjreguser 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationMjreguser(String orderID_s,int operation) throws Exception;
	
}
