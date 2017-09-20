package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.cost.OrdercostInfo;


public interface IorderPreRoadService {
	/**
	 * 增加 修改 删除 预付费信息
	 * @param orderSharingRoad
	 * @param operation  1：增加 修改 2：删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationOrderPreRoad(List<OrderPreRoad> orderPreRoad,int operation) throws Exception;
	/**
	 * 查询实验预付费信息
	 * @param orderSharingRoad
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<OrderPreRoad> getBasisOrderPreRoad(OrderPreRoad orderPreRoad,int start, int size) throws Exception;
	
	/**
	 * 查询实验预付费信息数量
	 * @param orderSharingRoad
	 * @return
	 * @throws Exception
	 */
	public long getBasisOrderPreRoad(OrderPreRoad orderPreRoad) throws Exception;
	
	/**
	 * 获得order精确预订道路费用信息
	 * getPereRoadcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrdercostInfo> getPreRoadcostInfo(String orderID) throws Exception ;
}
