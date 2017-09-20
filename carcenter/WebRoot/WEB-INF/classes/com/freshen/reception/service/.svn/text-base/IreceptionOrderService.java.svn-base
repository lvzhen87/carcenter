package com.freshen.reception.service;

import java.util.ArrayList;

import org.hibernate.Session;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.reception.ReceptionOrder;

/**
 * 
 *     
 * 项目名称：carcenter    
 * 类名称：IreceptionOrderService    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-4-14 上午10:55:51    
 * 修改人：kxc    
 * 修改时间：2014-4-14 上午10:55:51    
 * 修改备注：    
 * @version     
 *
 */
public interface IreceptionOrderService {
	/**
	 * 得到计划订单表(已确认/未完成)	   
	 * getReceptionOrder 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<ReceptionOrder> getReceptionOrder(ReceptionOrder receptionOrder,int start,
			int size) throws Exception;
	
	public long getReceptionOrderNumber(ReceptionOrder receptionOrder) throws Exception;
	
	public int OperationReceptionOrder(ReceptionOrder receptionOrder,int operation,Session session) throws Exception;
	
	/**
	 * 得到计划订单表(已确认/未完成)	 时间是当天
	 * getReceptionOrderbyDate 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<ReceptionOrder> getReceptionOrderbyDate(
			ReceptionOrder receptionOrder,int start,
			int size) throws Exception;
	/**
	 * 
	     得到计划订单表(已确认/未完成)数量	时间是当天
	 * getReceptionOrderbyDateNumber 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getReceptionOrderbyDateNumber(ReceptionOrder receptionOrder) throws Exception;
	/**
	 * 根据订单号  修改订单状态 
	 * lzh
	 * @param orderId_s
	 * @param state_s
	 * @return
	 * @throws Exception
	 */
	public int setReceptionOrderAndOrderDetailState(String orderId_s ,int state_i,Session session) throws Exception;
	
	/**
	 * 确认订单进行接待	   
	 * affirmReception 
	 * @param   orderID_s 订单id    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void affirmReception(String orderID_s) throws Exception;
	
	/**
	 * 按事务查询
	 * @param receptionOrder
	 * @param start
	 * @param size
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ReceptionOrder> getReceptionOrderByTx(
			ReceptionOrder receptionOrder,int start,
			int size,Session session) throws Exception;
	
}
