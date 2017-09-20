package com.freshen.preorder.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.entity.basis.OrderWholeRoad;

public interface ITimequantumService {

	/**
	 * 精确预订， 获得指定日期，指定道路24小时段的可预约数量
	 * getTimequantum 
	 * @param   startdate_t  指定日期
	 * 	    	roadid_s 指定道路
	 * @param  @return    设定文件    		
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<Map<String,Integer>> getTimequantum(Date startdate_t,String roadid_s) throws Exception;
	
	/**
	 * 预约的共享道路是否可通过	   
	 * isPassBySharingRoad 
	 * @param   orderSharingRoads :共享预订集合    
	 * @param  @return    1:表示通过，其他非通过
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isPassBySharingRoad(List<OrderSharingRoad> orderSharingRoads)throws Exception;
	
	/**
	 * 预约的预付费道路是否可通过
	 * isPassBySharingRoad 
	 * @param   orderSharingRoads :共享预订集合    
	 * @param  @return    1:表示通过，其他非通过
	 * @return String
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isPassByPrepaymentRoad(List<OrderPreRoad> orderPreRoads)throws Exception;
	
	/**
	 * 预约的 包场道路是否可通过
	 * isPassBySharingRoad 
	 * @param   orderWholeRoads :包场预订集合    
	 * @param  @return    1:表示通过，其他非通过
	 * @return String
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isPassByWholeRoad(List<OrderWholeRoad> orderWholeRoads)throws Exception;
	
	/**
	 * 该车间是否在指定日期是否可预订
	 * isSubscribeWorkShop 
	 * @param   orderWorkShops 车间预订对象
	 *           
	 * @param  @return    1 可以预订
	 * @return throws ClimsException
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isSubscribeWorkShop(List<OrderWorkShop> orderWorkShops)throws Exception;
}
