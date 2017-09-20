package com.freshen.process.service;

import java.util.ArrayList;

import com.freshen.entity.process.OccupyConsumerLists;

public interface IoccupyConsumerListsService {
	/**
	 * 道路、车间占用消费清单表查询
	 * @param station 消费清单对象
	 * @param start 开始位置
	 * @param size 结束位置
	 * @return
	 * @throws Exception
	 */
	public ArrayList<OccupyConsumerLists> getBasisOccupyConsumerListsInfo( OccupyConsumerLists occupyConsumerLists, int start, int size) 
	throws Exception ;
	
	/**
	 * 道路、车间占用消费清单数量查询
	 * @param station 消费清单对象
	 * @return
	 * @throws Exception
	 */
	public long getBasisOccupyConsumerListsInfo( OccupyConsumerLists occupyConsumerLists) throws Exception;
}
