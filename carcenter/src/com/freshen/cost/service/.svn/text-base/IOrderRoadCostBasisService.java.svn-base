package com.freshen.cost.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.cost.TCostOrderroadcostbasis;

public interface IOrderRoadCostBasisService {
	/**
	 * 查询订单其他费用基础信息表 
	 * 对tCostOrderroadcostbasis.CostRoadID中的
	 * setOrderid_S，setRoadid_S
	 * lz
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<TCostOrderroadcostbasis> getTCostOrderroadcostbasis( TCostOrderroadcostbasis tCostOrderroadcostbasis, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询订单其他费用基础信息表 返回记录总数
	 * lz
	 * @param barrierGate
	 * @return
	 * @throws Exception
	 */
	public long getTCostOrderroadcostbasis(TCostOrderroadcostbasis tCostOrderroadcostbasis) throws Exception;
	
	/**
	 * 修改订单其他费用基础信息表
	 * lz
	 * @param barrierGate
	 * @param operation 1 增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationTCostOrderroadcostbasis(List<TCostOrderroadcostbasis> tCostOrderroadcostbasis, int operation)
	throws Exception;
}
