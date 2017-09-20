package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.CustomerRegister;


public interface IcustomerRegisterService {
	/**
	 * 增加 修改 删除 到访人员信息
	 * @param orderSharingRoad
	 * @param operation  1：增加 修改 2：删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationCustomerRegister(List<CustomerRegister> customerRegister,int operation) throws Exception;
	/**
	 * 查询到访人员信息
	 * @param orderSharingRoad
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<CustomerRegister> getBasisCustomerRegister(CustomerRegister customerRegister,int start, int size) throws Exception;
	
	/**
	 * 查询到访人员数量
	 * @param orderSharingRoad
	 * @return
	 * @throws Exception
	 */
	public long getBasisCustomerRegister(CustomerRegister customerRegister) throws Exception;
	
	/**
	 * 查询人员是否在订单中，如果存在则不能删除
	 * @param 人员ID
	 * @return
	 * @throws Exception
	 */
	public boolean isCustomerUserhere(String customeruserId) throws Exception;
}
