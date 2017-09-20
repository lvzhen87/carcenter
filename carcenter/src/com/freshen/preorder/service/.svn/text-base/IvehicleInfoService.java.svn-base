package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.Customer;
import com.freshen.entity.VehicleInfo;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.reception.CardInfo;

public interface IvehicleInfoService {

	/**
	 * 
	   
	 * getVehicleInfo 
	 * @param   name    获得预约第订单车辆信息
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<VehicleInfo> getVehicleInfo(VehicleInfo vehicleInfo, int start, int size) throws Exception;
	
	/**
	 * 获得预约第订单车辆信息数量
	 * getVehicleInfoNumber 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getVehicleInfoNumber(VehicleInfo vehicleInfo)throws Exception;
	/**
	 * 操作订单车辆信息表	   
	 * OperationSubscribeVehicleInfo 
	 * @param   operation    1：新增  2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationSubscribeVehicleInfo(List<VehicleInfo> vehicleInfo,int operation)throws Exception;
	
	/**
	 * 操作订单车辆信息表	   
	 * OperationSubscribeVehicleInfo 
	 * @param   operation    1：新增  2：删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationSubscribeVehicleInfo(List<VehicleInfo> vehicleInfo,int operation,Session session)throws Exception;
}
