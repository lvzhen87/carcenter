package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.UnsubscribeRule;


public interface IUnsubscribeRuleService {

	/**
	 * 查询退订规则信息 
	 * @param unsubscribeRule
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<UnsubscribeRule> getUnsubscribeRule(UnsubscribeRule unsubscribeRule,int start ,int size) throws Exception;
	
	/**
	 * 查询退订规则信息 数量
	 * @param 道路信息对象roadinfo
	 * @return
	 * @throws Exception
	 */
	public long getUnsubscribeRule(UnsubscribeRule unsubscribeRule) throws Exception;
	
	/**
	 * 退订信息增加修改删除 
	 * @param roadInfo 1增加修改 2删除
	 * @param operation
	 * @return
	 * @throws Exception
	 */
	public int OperationUnsubscribeRule(List<UnsubscribeRule> list,
			int operation) throws Exception ;
	
	/**
	 * 根据相差的时间得到扣减的比例	   
	 * getBreakPromiseDeduction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int getBreakPromiseDeduction(int differHour)throws Exception;
}
