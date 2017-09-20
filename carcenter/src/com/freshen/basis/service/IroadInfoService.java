package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.freshen.entity.basis.RoadInfo;

public interface IroadInfoService {

	/**
	 * 得到道路基础信息
	 * getOrder 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<RoadInfo> getRoadInfo(RoadInfo roadInfo) throws Exception;
	
	public ArrayList<RoadInfo> getRoadInfo(RoadInfo roadInfo,int start ,int size) throws Exception;
	
	/**
	 * 查询道路信息 返回记录总数
	 * sharonyshi
	 * @param 道路信息对象roadinfo
	 * @return
	 * @throws Exception
	 */
	public long getRoadInfoNumber(RoadInfo raodinfo) throws Exception;
	
	/**
	 * 道路信息增加修改删除 
	 * @param roadInfo 1增加修改 2删除
	 * @param operation
	 * @return
	 * @throws Exception
	 */
	public int OperationRoadInfoInfo(List<RoadInfo> roadInfo,
			int operation) throws Exception ;
	
	
	/**
	 * 判断该条道路信息是否为道闸的入口，如果是则不能够删除，否则查不出来就能删除该条道路
	 * @param roadID 入口ID
	 * @return
	 * @throws Exception
	 */
	public boolean getIsVisible(String roadID) throws Exception ;
	
	/**
	 * 用于使用事务	   
	 * getRoadInfoByTX 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<RoadInfo> getRoadInfoByTX(RoadInfo roadInfo,Session session) throws Exception ;
	
	/**
	 * 添加道路同步订单道路费用信息表
	 * initOrderPrice 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void initOrderRoadCost(String orderID,String roadID) throws Exception;
}
