package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.basis.BarrierGate;

public interface IorderRoadDetailsService {
	/**
	 * 维护道路信息
	 * @param orderRoadDetail
	 * @param operation 1增加修改  2 删除
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public int OperationRoadDetail(List<OrderRoadDetail> orderRoadDetail,int operation,Session session) throws Exception;
	/**
	 * 查询道路详细信息
	 * @param orderRoadDetail
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<OrderRoadDetail> getBasisOrderRoadDetail(OrderRoadDetail orderRoadDetail,int start, int size) throws Exception;
	
	public long getBasisOrderRoadDetail(OrderRoadDetail orderRoadDetail) throws Exception;
}
