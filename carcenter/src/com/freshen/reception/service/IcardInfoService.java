package com.freshen.reception.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.barrierGate.BarrierGateJurisdiction;
import com.freshen.entity.reception.CardInfo;

public interface IcardInfoService {

	/**
	 * 通过条件查询卡信息表
	 * getReceptionCardInfo 
	 * @param  CardInfo
	 * @param  page开始页
	 * @param  page总数
	 * @return    ArrayList     
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<CardInfo> getReceptionCardInfo(CardInfo cardInfo, int start, int size) throws Exception;
	
	/**
	 * 保存卡信息
	 * saveOrUpdateReceptionCardInfo 
	 * @param   name    
	 * @return   1. 成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getReceptionCardInfoNumber(CardInfo cardInfo)throws Exception;
	
	/**
	 * 保存卡信息
	   
	 * saveReceptionCardInfo 
	 * @param   list   卡信息    
	 * @param  @return    1 成功
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveOrUpdateReceptionCardInfo(ArrayList<CardInfo> list) throws Exception;
	
	/**
	 * 删除卡信息
	 * deleteReceptionCardInfo 
	 * @param   name    
	 * @return   1. 成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionCardInfo(ArrayList<CardInfo> list,Session session) throws Exception;
	
	/**
	 * 处理卡信息	   
	 * manageCardInfo 
	 * @param   list      卡信息集合
	 *          orderid   订单编号
	 *          operation 操作 1:新增/修改 2:删除
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	//public int manageCardInfo(ArrayList<CardInfo> list,String orderid,int operation) throws Exception;
	
	/**
	 * 当订单接待时， 根据orderid对计划车辆信息初始化
	 * initVehicleInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int initVehicleInfo(String orderid) throws Exception;
	
	/**
	 * 在事务中保存卡信息
	 * saveOrUpdateReceptionCardInfo 
	 * @param   name    
	 * @return   bjlist  权限信息中间表备份对象集合
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveReceptionCardInfobyTransaction(ArrayList<CardInfo> list,Session session) throws Exception;
	
	/**
	 * 在事务中删除卡信息
	 * deleteReceptionCardInfo 
	 * @param   name    
	 * @return   1. 成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionCardInfobyTransaction(ArrayList<CardInfo> list,Session session) throws Exception;
	
	/**
	 * 删除卡信息
	 * deleteReceptionCardInfo 
	 * @param   name    
	 * @return   1. 成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionCardInfoAlone(ArrayList<CardInfo> list) throws Exception;
	/**
	 * 根据订单id删除卡信息
	 * deleteReceptionCardInfo 
	 * @param   orderid_s 订单id
	 *     	    card_type 卡类型
	 * @return   1. 成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionCardInfoByOrderId(String orderid_s,String card_type) throws Exception;
	
	/**
	 * 查询卡是否已经在其他订单使用，并且使用的订单状态不为7
	 * isCardApply 
	 * @param   name    
	 * @return   String:返回已经在使用的车卡号，null代表卡都没有使用
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String isCardApply(String cardIDes,String orderId) throws Exception;
}
