package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.BarrierGate;

public interface IBarrierGateService {

	/**
	 * 查询道闸信息 
	 * lz
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BarrierGate> getBasisBarrierGateInfo( BarrierGate barrierGate, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询道闸信息 返回记录总数
	 * lz
	 * @param barrierGate
	 * @return
	 * @throws Exception
	 */
	public long getBasisBasisBarrierGateInfoNumber(BarrierGate barrierGate) throws Exception;
	
	/**
	 * 修改道闸信息记录
	 * lz
	 * @param barrierGate
	 * @param operation 1 增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationBasisBarrierGateInfo(List<BarrierGate> barrierGate, int operation)
	throws Exception;
	
	/**
	 * 事务中查询
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BarrierGate> getBasisBarrierGateInfoByTx(
			BarrierGate barrierGate, int start, int size,Session session) throws Exception ;
	
	/**
	 * 获得sqlserver道闸信息
	 * getBarrierGateModelList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<BarrierGate> getBarrierGateModelList() throws Exception ;
	
	/**
	 * 将道闸信息保存到oracle中	  
	 * saveBarrierGateModel 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveBarrierGateModel(List<BarrierGate> barrierGateModel)
	throws Exception ;
}
