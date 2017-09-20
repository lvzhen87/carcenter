package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.RoadCost;

public interface IroadCostService {
	/**
	 * 查询道路费用信息
	 * lz
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<RoadCost> getRoadCostInfo( RoadCost roadCost, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询道路费用信息 返回记录总数
	 * lz
	 * @param barrierGate
	 * @return
	 * @throws Exception
	 */
	public long getRoadCostInfoNumber(RoadCost roadCost) throws Exception;
	
	/**
	 * 修改道路费用信息
	 * lz
	 * @param barrierGate
	 * @param operation 1 增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationRoadCostInfo(List<RoadCost> roadCost, int operation)
	throws Exception;
}
