package com.freshen.barrierGate.service;

import java.util.List;

import org.hibernate.Session;
import com.freshen.entity.barrierGate.TBarriergateCancellationBak;

public interface IbarrierGateCancellationService {
	 
	/**
	 * 保存车卡作废信息oracle	   
	 * OperationBarrierGateJurisdiction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TBarriergateCancellationBak> OperationBarrierGateJurisdiction(
			List<TBarriergateCancellationBak> barrierGateJurisdicList, int operation,Session session)
			throws Exception ;
	
	/**
	 * 作废卡片保存到sql server中
	 * CancellationCardSql 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int CancellationCardSql(List<TBarriergateCancellationBak> list) throws Exception;
	
	/**
	 * 作废卡片操作
	 * CancellationCardSql 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TBarriergateCancellationBak>  CancellationCard(List<TBarriergateCancellationBak> list,Session session) throws Exception;
}
