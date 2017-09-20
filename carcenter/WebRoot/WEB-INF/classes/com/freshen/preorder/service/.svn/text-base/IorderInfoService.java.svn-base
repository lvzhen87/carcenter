package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderOther;
import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.OrderWholeRoad;



/**
 * 项目名称：carcenter 订单操作的类    
 * 类名称：IorderInfoService    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-3-29 下午06:02:49    
 * 修改人：kxc    
 * 修改时间：2014-3-29 下午06:02:49    
 * 修改备注：    
 * @version     
 */
public interface IorderInfoService {

	/**
	 * getOrder 得到订单信息 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderDetail> getOrder(OrderDetail orderDetail) throws Exception;
	/**
	 *  Function:分页 查询订单详情
	 *  @author Freshen  DateTime 2014-4-10 下午06:23:47
	 *  @param orderDetail	订单实体对象
	 *  @param start	开始记录
	 *  @param pageSize	每页记录数
	 *  @return	
	 */
	public ArrayList<OrderDetail> getOrder(OrderDetail orderDetail,
			int start,int pageSize)throws Exception;
	/**
	 *  Function:查询给定 OrderInfo实体的数量
	 *  @author Freshen  DateTime 2014-4-10 下午06:29:35
	 *  @param orderDetail
	 *  @return 实体数目
	 */
	public long getOrderInfoNumber(OrderDetail orderDetail)throws Exception;
	
	/**
	 * getOrder 得到试验路面预约详细订单信息 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderRoadDetail> getOrderRoad(String orderID_s)throws Exception;
	
	/**
	 * getOrder 得到车间及办公室预订信息 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderWorkShop> getOrderWorkShop(String orderID_s)throws Exception;
	
	/**
	 * 
	   
	 * getOrder 得到酒店及其他服务预订信息
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderHotelOther> getOrderHotelOther(String orderID_s)throws Exception;
	/**
	 * 
	   
	 * getOrder 得到订单其他信息(车辆及安全信息)
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderOther> getOrderOther(String orderID_s)throws Exception;
	
	/**
	 * 查询车辆及安全信息 
	 * lz
	 * @param orderOther 
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	 
	public ArrayList<OrderOther> getOrderOtherbyModel(OrderOther orderOther,int start,int size)throws Exception;
	
	/**
	 * 查询车辆及安全信息数量
	 * lz
	 * @param orderOther
	 * @return
	 * @throws Exception
	 */
	
	public long getOrderOtherbyModelNumber(OrderOther orderOther)throws Exception;
	/**
	 * 	  
	 * checkOrder 修改预约订单表状态
	 * @param    list    <idvv状态>  的集合   
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
//	public int checkOrder(List list)throws Exception;
	
	
	/**
	 * 	  
	 * checkOrderRoad 修改试验路面预约详细订单表状态
	 * @param   list    <idvv状态> 的集合   
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int checkOrderRoad(List list)throws Exception;
	
	/**
	 * 	  
	 * checkOrderRoad 修改车间及办公室预订信息表状态
	 * @param   list    <idvv状态> 的集合   
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int checkOrderWorkShop(List list)throws Exception;
	
	/**
	 * 	  
	 * checkOrderHotelOther 修改酒店及其他服务预订信息表状态
	 * @param   list    <idvv状态> 的集合   
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int checkOrderHotelOther(List list)throws Exception;
	
	/**
	 * 根据订单ID修改客户助理
	 * updateOrderDetailEmployeeID 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int updateOrderDetailEmployeeID(String orderID_s, String employeeID_s) throws Exception ;
	
	/**
	 * /**
	 *  Function:分页 查询订单详情
	 *  @author Freshen  DateTime 2014-4-10 下午06:23:47
	 *  @param orderDetail	订单实体对象
	 *  @param start	开始记录
	 *  @param pageSize	每页记录数
	 *  @return	
	 */
	public ArrayList<OrderWorkShop> getOrderWorkShop(String orderIDS,int start,
			int pageSize)throws Exception;
	/**
	 * 实现 查询 订单数目
	 */
	public long getOrderWorkShopNumber(String orderIDS)  throws Exception;
	
	/**
	 * 安装试验路面预约详细订单表对象查询
	   
	 * getOrderRoadByModel 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderRoadDetail> getOrderRoadByModel(OrderRoadDetail orderRoadDetail) throws Exception;
	
	/**
	 * 增加 修改 删除 酒店信息
	 * @param orderSharingRoad
	 * @param operation  1：增加 修改 2：删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationOrderHotelOther(List<OrderHotelOther> orderHotelOther,int operation) throws Exception;
}
