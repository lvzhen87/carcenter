package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.basis.OrderSharingRoad;

public interface IorderSharingRoadService {

	/**
	 * 增加 修改 删除 共享测试道路试验信息
	 * @param orderSharingRoad
	 * @param operation  1：增加 修改 2：删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationOrderSharingRoad(List<OrderSharingRoad> orderSharingRoad,int operation) throws Exception;
	/**
	 * 查询实验共享测试道路信息
	 * @param orderSharingRoad
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<OrderSharingRoad> getBasisOrderSharingRoad(OrderSharingRoad orderSharingRoad,int start, int size) throws Exception;
	
	/**
	 * 查询实验共享测试道路信息数量
	 * @param orderSharingRoad
	 * @return
	 * @throws Exception
	 */
	public long getBasisOrderSharingRoad(OrderSharingRoad orderSharingRoad) throws Exception;
}
