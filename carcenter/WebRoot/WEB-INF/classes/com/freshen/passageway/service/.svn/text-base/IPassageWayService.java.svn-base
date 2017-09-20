package com.freshen.passageway.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.passageway.entity.PassageWay;

public interface IPassageWayService {
	/**
	 * 查询接口道闸信息 
	 * lz
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<PassageWay> getBasisPassageWayInfo( PassageWay passageWay, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询接口道闸信息 返回记录总数
	 * lz
	 * @param barrierGate
	 * @return
	 * @throws Exception
	 */
	public long getBasisPassageWayInfoNumber(PassageWay passageWay) throws Exception;
	
	/**
	 * 修改接口道闸信息记录
	 * lz
	 * @param barrierGate
	 * @param operation 1 增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int UpdateBasisPassageWayInfo(List<PassageWay> list)
	throws Exception;
}
