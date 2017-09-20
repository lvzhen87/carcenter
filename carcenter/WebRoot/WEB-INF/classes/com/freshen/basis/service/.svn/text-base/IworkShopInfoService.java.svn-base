package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.WorkShopInfo;;

public interface IworkShopInfoService {

	/**
	 * 获得车间基础信息表信息
	   
	 * getWorkShopInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<WorkShopInfo> getWorkShopInfo(WorkShopInfo workshopInfo) throws Exception;
	
	public ArrayList<WorkShopInfo> getWorkShopInfo(WorkShopInfo workshopInfo, int start , int size) throws Exception ;

	/**
	 * 查询车间信息 返回记录总数
	 * sharonyshi 2014-5-22
	 * @param 车间信息对象workshopinfo
	 * @return
	 * @throws Exception
	 */
	public long getWorkShopInfoNumber(WorkShopInfo workshopInfo) throws Exception;
	
	
	/**
	 * 对车间基础信息进行增加修改删除操作
	 * @param workShopInfo
	 * @param operation 1增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationWorkShopInfo(List<WorkShopInfo> workShopInfo,
			int operation) throws Exception ;
	
	
	/**
	 * 对车间基础信息进行增加修改删除操作
	 * @param workShopInfo
	 * @param operation 1增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationWorkShopInfo(List<WorkShopInfo> workShopInfo,
			int operation,Session session) throws Exception ;
	
	
	
	/**
	 * 修改使用状态信息 
	 * @param workShopID_s 需要删除的车间顺序号
	 * @param useInfos_s 传入需要删除的使用信息
	 * @return
	 * @throws Exception
	 */
	public int OperationWorkShopInfoUseInfos(String workShopID_s,String useInfos_s ) throws Exception;
	
}
