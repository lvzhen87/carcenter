package com.freshen.process.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.process.TProcessInterphoneemployinfo;

public interface TProcessInterPhoneEmployinfoService {
	/**
	 * 查询对讲机对应人员信息
	 * @param tProcessInterphoneemployinfo
	 * @param start 记录开始位置
	 * @param size 显示记录长度
	 * @return
	 */
	public ArrayList<TProcessInterphoneemployinfo> getTProcessInterPhoneEmployinfo(TProcessInterphoneemployinfo tProcessInterphoneemployinfo,
			int start ,int size) throws Exception;
	
	/**
	 * 内部使用
	 * @param tProcessInterphoneemployinfo
	 * @return
	 * @throws Exception
	 */
	public ArrayList<TProcessInterphoneemployinfo> getTotalTProcessInterPhoneEmployinfo(TProcessInterphoneemployinfo tProcessInterphoneemployinfo) throws Exception;
	/**
	 * 查询对讲机对应人员信息条数
	 * @param tProcessInterphoneemployinfo
	 * @return
	 * @throws Exception
	 */
	public long getTProcessInterPhoneEmployinfo(TProcessInterphoneemployinfo tProcessInterphoneemployinfo) throws Exception ;
	/**
	 * 修改删除对讲机信息
	 * @param tProcessInterphoneemployinfo id的三个值必须给定 才可以执行 
	 * @param operation 1 增加 修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationTProcessInterphoneemployinfo(List<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo, int operation)
	throws Exception;
	
	/**
	 * 查询对讲机明细信息 
	 * @param info 对讲机对象 需要设置ID
	 * @return
	 * @throws Exception
	 */
	public TProcessInterphoneemployinfo getTProcessInterPhoneEmployinfoByInterphone(InterphoneInfo info) throws Exception;
	
	
	public ArrayList<TProcessInterphoneemployinfo> getTProcessInterPhoneEmployinfoListByInterphone(ArrayList<InterphoneInfo> info) throws Exception;
	
	/**
	 * 在事务中保存对讲机使用过程
	 * OperationTProcessInterphoneemployinfobyTransaction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessInterphoneemployinfobyTransaction(
			List<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo,Session session,
			int operation) throws Exception ;
	
	
	/**
	 * 修改删除对讲机信息
	 * @param tProcessInterphoneemployinfo id的三个值必须给定 才可以执行 
	 * @param operation 1 增加 修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationTProcessInterphoneemployinfoWithoutTrans(ArrayList<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo, Integer operation)
	throws Exception;
	
	/**
	 * 归还使用
	 * OperationTProcessInterphoneemployinfobysession 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessInterphoneemployinfobysession(
			List<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo,
			int operation,Session session) throws Exception ;
	
	public ArrayList<TProcessInterphoneemployinfo> getTProcessInterPhoneEmployinfoBysession(
			TProcessInterphoneemployinfo tProcessInterphoneemployinfo,
			int start, int size,Session session) throws Exception ;
	
}
