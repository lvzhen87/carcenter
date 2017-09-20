package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.InterphoneInfo;

public interface IinterphoneInfoService {

	/**
	 * 通过条件查询对讲机信息表
	   
	 * getBasisInterPhoneInfo 
	 * @param   name    
	 * @param  @return    List    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<InterphoneInfo> getBasisInterPhoneInfo(InterphoneInfo interPhoneInfo, int start, int size) throws Exception;
	
	/**
	 * 通过条件查询对讲机信息表，返回取得个数
	   
	 * getBasisInterPhoneInfoNumber 
	 * @param   name    
	 * @param  @return    Long    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public long getBasisInterPhoneInfoNumber(InterphoneInfo interPhoneInfo) throws Exception;
	
	/**
	 * 修改 对讲机表
	 * lz
	 * @param interphoneInfo
	 * @param operation 1增加修改 2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationInterphoneInfo(List<InterphoneInfo> interphoneInfo, int operation)
	throws Exception;
	
	/**
	 * 修改对讲机状态 
	   *lz
	 * saveOrUpdateBasisInterPhoneInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	 public int UpdateBasisInterPhoneStateInfo(InterphoneInfo interphoneInfo) throws Exception;
	 /**
	  * 批量修改对讲机状态 
	  * lz
	  * @param interphoneID_s
	  * @param state_i
	  * @return
	  * @throws Exception
	  */
	 public int UpdateBasisTotalInterPhoneStateInfo (List<InterphoneInfo> interphoneInfo) throws Exception;
	 
	 /**
	 * 在事务中更新对讲机信息
	 * UpdateBasisInterPhoneStateInfobyTransaction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int UpdateBasisInterPhoneStateInfobyTransaction(InterphoneInfo interphone,Session session)throws Exception;
	
	/**
	 * 在事务中更新对讲机信息
	 * UpdateBasisTotalInterPhoneStateInfobyTransaction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int UpdateBasisTotalInterPhoneStateInfobyTransaction(List<InterphoneInfo> interphoneID_s,Session session
	) throws Exception ;
	
	/**
	 * 对讲机发放/收回
	 * interphoneProvide 
	 * @param   interphoneIDs:对讲机编号
	 * userCardIDs:人卡编号
	 *  vehicleCardIDs:车卡编号
	 *  orderId:订单
	 *  employ:操作人
	 *  operation:操作  ConstantUtil.interphoneOperation_1：发放  ConstantUtil.interphoneOperation_2：归还
	 * @param  @return    设定文件    
	 * @return int 1:成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int interphoneProvide(List<String> interphoneIDs,List<String> userCardIDs,
			List<String> vehicleCardIDs,String orderId,Employee employ,Integer operation)
	 		throws Exception ;
	
	/**
	 * 判断该条对讲机信息是否在过程信息表中存在，如果存在则不能被停用，否则会被停用
	 * @param   interphoneIDs:对讲机编号
	 * @return true:说明过程信息表中存在该对讲机，不能停用，返回false说明没有过程信息，可以停用
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public boolean getIsVisible(String interphoneID)
	throws Exception;
	
	/**
	 * 修改对讲机状态 
	   *lz
	 * saveOrUpdateBasisInterPhoneInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	 public int UpdateBasisInterPhoneStateInfoWithoutTrans(InterphoneInfo interphoneInfo) throws Exception;
	 
	 /**
		 * 归还对讲机
		 * interphoneReturn 
		 * @param   name    
		 * @param  processIDs 使用记录号 
		 * 		   interphoneIDs 对讲机编号
		 * 		   userCardIDs 归还人卡id
		 * @return String    
		 * @Exception 异常对象    
		 * @since  CodingExample　Ver(编码范例查看) 1.1
		 */
		public int interphoneReturn(String processIDs,String interphoneIDs,String orderId)
			throws Exception ;
		
		/**
		 * 保存对讲机信息
		 * saveOrUpdateBasisInterPhoneInfo 
		 * @param   name    1:增加 修改 2：删除
		 * @param  @return   1. 成功    
		 * @return String    
		 * @Exception 异常对象    
		 * @since  CodingExample　Ver(编码范例查看) 1.1
		 */
		public int OperationInterphoneInfoBysession(List<InterphoneInfo> interphoneInfo, int operation,Session session)
		throws Exception ;
}
