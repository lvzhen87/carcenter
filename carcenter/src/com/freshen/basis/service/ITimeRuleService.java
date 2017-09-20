package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.TimeRule;


public interface ITimeRuleService {
	/**
	 * 查询退订规则信息 
	 * @param unsubscribeRule
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<TimeRule> getTimeRule(TimeRule timeRule,int start ,int size) throws Exception;
	
	/**
	 * 查询退订规则信息 数量
	 * @param 道路信息对象roadinfo
	 * @return
	 * @throws Exception
	 */
	public long getTimeRule(TimeRule timeRule) throws Exception;
	
	/**
	 * 退订信息增加修改删除 
	 * @param roadInfo 1增加修改 2删除
	 * @param operation
	 * @return
	 * @throws Exception
	 */
	public int OperationTimeRule(List<TimeRule> list,
			int operation) throws Exception ;
}
