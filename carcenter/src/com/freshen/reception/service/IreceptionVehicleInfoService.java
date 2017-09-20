package com.freshen.reception.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.barrierGate.BarrierGateJurisdiction;
import com.freshen.entity.reception.ReceptionVehicleInfo;

public interface IreceptionVehicleInfoService {

	/**
	 * 通过条件查询卡信息表
	   
	 * getReceptionCardInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<ReceptionVehicleInfo> getReceptionVehicleInfo(ReceptionVehicleInfo rVehicleInfo,int start,	int size,Session session) throws Exception;
	
	/**
	 * 通过条件查询计划车辆信息表，返回取得个数
	   
	 * getReceptionVehicleInfoNumber 
	 * @param   name    
	 * @param  @return    Long    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public long getReceptionVehicleInfoNumber(ReceptionVehicleInfo rVehicleInfo) throws Exception;
	
	/**
	 * 保存计划车辆信息
	   
	 * saveOrUpdateReceptionVehicleInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return 业务cpg    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String saveOrUpdateReceptionVehicleInfo(ArrayList<ReceptionVehicleInfo> list) throws Exception;
	
	/**
	 * 删除计划车辆信息
	   
	 * deleteReceptionVehicleInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionVehicleInfoByTx(ArrayList<ReceptionVehicleInfo> list,Session session) throws Exception;
	public int deleteReceptionVehicleInfo(ArrayList<ReceptionVehicleInfo> vlist) throws Exception;
	/**
	 * 保存车卡权限信息表(oracle)
	 * assemblyJurisdictionInfo 
	 * @param   name    
	 * @param  @return    返回oracle车卡权限信息表
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<BarrierGateJurisdiction> saveJurisdictionInfo(String orderid,Session session) throws Exception;
	
	/**
	 * 保存sql server中间表数据	   
	 * saveSQLJurisdictionInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	//public int saveSQLJurisdictionInfo(List<BarrierGateJurisdiction> list) throws Exception;
	
	/**
	 * 车卡发放方法
	 * 1、保存接待模块计划车辆信息
	 * 2、保存oracle车卡权限信息表
	 * 3、保存sql server车卡权限信息表
	 * saveJurisdiction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int provideJurisdiction(ArrayList<ReceptionVehicleInfo> receptionvehiclelist,String orderids,List cancelList) throws Exception;
	
	/**
	 * 公卡发放车卡发放方法位置servie/IreceptionVehicleInfoService
	 * 1、保存接待模块计划车辆信息
	 * 2、保存oracle车卡权限信息表
	 * 3、保存sql server车卡权限信息表
	 * saveJurisdiction
	 * @param   name
	 * @param  @return    设定文件
	 * @return String
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int provideJurisdictionGKService(ArrayList<ReceptionVehicleInfo> receptionvehiclelist,String orderids,List cancelList) throws Exception;
	
	/**
	 * 保存计划车辆信息，在事务中处理
	 * saveOrUpdateReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   业务cpg       
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String saveOrUpdateReceptionVehicleInfoByTransaction(ArrayList<ReceptionVehicleInfo> list,Session session) throws Exception;
	
	/**
	 * 根据订单得到预约模块单台车辆信息表复制到接待模块计划车辆信息表	   
	 * addReceptionVehicleInfo 
	 * @param   orderID_s 订单编号    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void addReceptionVehicleInfo(String orderID_s,Session session)throws Exception;
	
	/**
	 * 通过条件查询计划车辆信息表
	 * getReceptionVehicleInfo 
	 * @param  ReceptionVehicleInfo
	 * @param  page开始页
	 * @param  page总数
	 * @return    ArrayList     
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<ReceptionVehicleInfo> getReceptionVehicleInfo(ReceptionVehicleInfo rVehicleInfo,int start,	int size) throws Exception;

	/**
	 * 判断该车是否已经进入道闸，如果进入道闸则不能删除。
	 * @param 车辆ID
	 * @return
	 * @throws Exception
	 */
	public boolean getIsVisible(String vehicleID) throws Exception ;
}
