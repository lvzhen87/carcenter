package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.OrderWorkShopDay;

public interface IorderWorkShopDayService {

	/**
	 * 
	   
	 * getOrder 得到车间及办公室预订信息 按天拆分的
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderWorkShopDay> getOrderWorkShopDay(OrderWorkShopDay orderWorkShopDay,int start,
			int pageSize) throws Exception;
	//获得数量
	public long getOrderWorkShopDayNumber(OrderWorkShopDay orderWorkShopDay)  throws Exception;
	/**
	 * 批量修改车间及办公室按天拆分子订单状态
	 * checkOrderWorkShopDay 
	 * @param   list    每个元素为 Object数组，数组为:子订单号，日期，状态    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int checkOrderWorkShopDay(List list) throws Exception;
	/**
	 * 修改车间及办公室订单信息 按天拆分的记录单条状态
	   
	 * updateorderWorkShopDayStatus 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateorderWorkShopDayStatus(String orderWorkShopID_s,Date dateT, Integer status,Session session)throws Exception;
}
