package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;



import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.Orderroaddaydetail;

public interface IorderRoadDayDetailService {

	/**
	 * 
	   
	 * getOrder 得到试验路面预约详细订单信息 按天拆分
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Orderroaddaydetail> getOrderRoadDay(Orderroaddaydetail orderroaddaydetail,int start,
			int pageSize) throws Exception;
	/**
	 * 得到满足条件的数量
	   
	 * getOrderRoadDay 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getOrderRoadDayNumber(Orderroaddaydetail orderroaddaydetail) throws Exception;
	
	/**
	 * 修改试验路面预约详细订单信息 按天拆分的记录集合状态	   
	 * checkOrderRoadDay 
	 * @param   list： 每个元素为 Object数组，数组为:子订单号，日期，状态    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int checkOrderRoadDay(List list) throws Exception ;
	
	/**
	 * 修改试验路面预约详细订单信息 按天拆分的记录单条状态
	 * updateOrderRoadDayStatus 
	 * @param   orderRoadIDS 子订单号
	 * 		    dateT      日期
	 *          status     状态
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateOrderRoadDayStatus(String orderRoadIDS,Date dateT, Integer status,Session session)throws Exception;
}
