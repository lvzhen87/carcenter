package com.freshen.basis.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.basis.OtherChargeInfo;

public interface IOtherChargeInfoService {

	/**
	 * 获得其他费用表对象
	 * getOrganizationDept 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OtherChargeInfo> getOtherChargeInfo(OtherChargeInfo otherChargeInfo,int start ,int size) throws Exception ;
	

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
	public long getOtherChargeInfo(OtherChargeInfo otherChargeInfo) throws Exception;
	
	/**
	 * 修改 其他费用
	 * lz
	 * @param interphoneInfo
	 * @param operation 1增加修改 2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationOtherChargeInfo(ArrayList<OtherChargeInfo> otherChargeInfo, Integer operation)
	throws Exception;
	
	/**
	 * 修改 其他费用
	 * lz
	 * @param interphoneInfo
	 * @param operation 1增加修改 2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationOtherChargeInfoWithOutTrans(ArrayList<OtherChargeInfo> otherChargeInfo, Integer operation)
	throws Exception;
}
