package com.freshen.preorder.service;

import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderOther;
import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.Employee;

public interface IorderDetailService {

	/**
	 * 
	   
	 * updateOrderStatus  修改订单状态
	 * @param   orderID_s 订单id    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateOrderStatus(String orderID_s,Integer status_i,Session session);
	
	/**
	 * 
	 * updateOrderRoadStatus  修改试验路面预约详细订单状态
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateOrderRoadStatus(String orderRoadID_s,Integer status_i,Session session);
	
	/**
	 * 
	   
	 * updateOrderWorkShopStatus  修改车间及办公室预订订单状态
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateOrderWorkShopStatus(String orderWorkShopID_s,Integer status_i,Session session);
	
	/**
	 * 
	   
	 * updateOrderHotelOtherStatus  修改酒店及其他服务预订状态
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	//public int updateOrderHotelOtherStatus(String orderID_s,Integer status_i);
	
	/**
	 * 修改预约订单 
	 * 步骤：
	 * 1.判断订单状态，订单状态为1，3 直接修改，删除接待模块的 ORDER，增加触发器删除订单计划表
	 * 2.订单状态=2 或者订单状态>4  先将ORDER的状态设置为1，修改订单内容，然后再讲状态修改为原状态。
	 * 3
	 */
	public int OperationOrderWorkShopStatusInfo(OrderDetail orderDetail,List<OrderRoadDetail> orderRoadDetailList,
			List<OrderOther> orderOthersList,List<OrderWorkShop> orderWorkShopsList,OrderHotelOther orderHotelOther)
	throws Exception;
	/**
	 * 修改预约订单  1代表修改 2代表删除
	 * @param orderDetail
	 * @param operation
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int OperationOrder(OrderDetail orderDetail,int operation,Session session) throws Exception;
	
	/**
	 * 修改订单状态
	 * lz
	 * @param orderId_s
	 * @param state_s
	 * @return
	 * @throws Exception
	 */
	public int setOrderDetailState(String orderId_s ,int state_i) throws Exception;
	
	
	/**
	 * 修改预约订单  1代表修改 2代表删除
	 * @param orderDetail
	 * @param operation
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int OperationOrder(OrderDetail orderDetail,Integer operation) throws Exception;
	
	
	/**
	 * 
	   
	 * updateOrderStatus  删除客户助理信息
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateOrderDetail(Employee employee, Session session);
	
}
