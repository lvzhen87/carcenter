package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.entity.cost.OrdercostInfo;

public interface IorderWholeRoadService {
	/**
	 * 增加 修改 删除 包场预定信息
	 * @param orderSharingRoad
	 * @param operation  1：增加 修改 2：删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationOrderWholeRoad(List<OrderWholeRoad> orderWholeRoad,int operation) throws Exception;
	/**
	 * 查询实验包场预定信息
	 * @param orderSharingRoad
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<OrderWholeRoad> getBasisOrderWholeRoad(OrderWholeRoad orderWholeRoad,int start, int size) throws Exception;
	
	/**
	 * 查询实验包场预定信息数量
	 * @param orderSharingRoad
	 * @return
	 * @throws Exception
	 */
	public long getBasisOrderWholeRoad(OrderWholeRoad orderWholeRoad) throws Exception;
	
	/**
	 * 获得order包场预订道路费用信息
	 * getWholeRoadcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrdercostInfo> getWholeRoadcostInfo(String orderID) throws Exception ;
}
