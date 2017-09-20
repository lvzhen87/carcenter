package com.freshen.barrierGate.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.freshen.entity.barrierGate.BarrierGateJurisdiction;

public interface BarrierGateJurisdictionService {
	/**
	 * 查询授权信息
	 * @param barrierGateJurisdic
	 * @param start 开始位置  不分页情况输入-1
	 * @param size 结束位置
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BarrierGateJurisdiction> getBarrierGateJurisdictionInfo(BarrierGateJurisdiction barrierGateJurisdic,int start ,int size)
	throws Exception;
	/**
	 * 查询授权数量
	 * @param barrierGateJurisdic
	 * @return
	 * @throws Exception
	 */
	public Long getBarrierGateJurisdictionInfo(BarrierGateJurisdiction barrierGateJurisdic)
	throws Exception;
	/**
	 * 修改删除授权信息
	 * @param barrierGateJurisdic
	 * @param operation 1 增加 修改  2 删除
	 * @return  返回增加后的对象集合
	 * @throws Exception
	 */
	public List<BarrierGateJurisdiction> OperationBarrierGateJurisdiction(List<BarrierGateJurisdiction> barrierGateJurisdicList,int operation,Session session)
	throws Exception;
	
	/**
	 * 保存sql server中间表数据	   
	 * saveSQLJurisdictionInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveSQLJurisdictionInfo(List<BarrierGateJurisdiction> list,List<String> cancelList) throws Exception;
	
}
