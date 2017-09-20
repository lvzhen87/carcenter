package com.freshen.cost.service;

import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.cost.OrdercostInfo;

/**
 * 费用操作
 *     
 * 项目名称：carcenter    
 * 类名称：IOrdercostInfoService    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-7-22 下午04:43:59    
 * 修改人：kxc    
 * 修改时间：2014-7-22 下午04:43:59    
 * 修改备注：    
 * @version     
 *
 */
public interface IOrdercostInfoService {

	/**
	 * 计算订单进出设施费用信息 
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void OrderProcessStationCostByTime(String orderID,String startTime,String endTime)throws Exception;	/**
	 * 计算订单进出设施费用信息 
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void OrderProcessStationCostByTimeandCarID(String orderID,String startTime,String endTime,String carid)throws Exception;
	/**
	 * 获得订单车间费用信息
	 * getOrderWorkShopCost 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> getOrderWorkShopCost(String orderID)throws Exception;
	
	/**
	 * 通过车间预订表信息对订单费用信息赋值
	 * setProByWorkShop 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> setProByWorkShop(List list,Class classname)throws Exception;
	
	/**
	 * 初始化order单价信息表	   
	 * initOrderPrice 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void initOrderPrice(String orderID,Session session) throws Exception;
	
	/**
	 * 初始化order单价信息表在事务中	   
	 * initOrderPrice 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void initOrderPriceBytransaction(String orderID);
	
	/**
	 * 得到订单费用信息	   
	 * getAllOrdercostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List[] getAllOrdercostInfo(String orderID)throws Exception;
	
	/**
	 * 计算订单费用明细	   
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void ComputeOrderCost(String orderID)throws Exception;
	
	/**
	 * 计算订单进出设施费用信息 
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void OrderProcessStationCost(String orderID)throws Exception;
	
	/**
	 * 计算订单预付费费用   
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void PreRoadCost(String orderID,Session session)throws Exception;
}
