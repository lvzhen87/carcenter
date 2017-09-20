package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.OrderWorkShop;

public interface IorderWorkShopService {
	/**
	 * 维护车间信息 
	 * @param orderWorkShop
	 * @param operation 1增加修改  2删除
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int OperationorderWorkShop(List<OrderWorkShop> orderWorkShop,int operation,Session session) throws Exception;
	public int OperationorderWorkShop(List<OrderWorkShop> orderWorkShop,int operation) throws Exception;

	
	/**
	 * 车间信息查询
	 * @param OrderWorkShop
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<OrderWorkShop> getBasisWorkShop(OrderWorkShop orderWorkShop,int start, int size) throws Exception;
	/**
	 * 车间数量查询
	 * @param OrderWorkShop
	 * @return
	 * @throws Exception
	 */
	public long getBasisWorkShop(OrderWorkShop orderWorkShop) throws Exception;
	
	/**
	 * 按照对象开始时间和结束时间查询是否有在该时间段内预订的车间	   
	 * getBasisWorkShopByDate 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderWorkShop> getBasisWorkShopByDate(
			OrderWorkShop orderWorkShop, int start, int size) throws Exception ;
}
