package com.freshen.cost.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.cost.TCostOrderworkshopcostbasis;

public interface IOrderWorkShopCostBasisService {
	/**
	 * 查询订单其他费用基础信息表
	 * lz
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<TCostOrderworkshopcostbasis> getTCostOrderworkshopcostbasis( TCostOrderworkshopcostbasis tCostOrderworkshopcostbasis, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询订单其他费用基础信息表 返回记录总数
	 * lz
	 * @param barrierGate
	 * @return
	 * @throws Exception
	 */
	public long getTCostOrderworkshopcostbasisNumber(TCostOrderworkshopcostbasis tCostOrderworkshopcostbasis) throws Exception;
	
	/**
	 * 修改订单其他费用基础信息表
	 * lz
	 * @param barrierGate
	 * @param operation 1 增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationTCostOrderworkshopcostbasis(List<TCostOrderworkshopcostbasis> tCostOrderworkshopcostbasis, int operation)
	throws Exception;
}
