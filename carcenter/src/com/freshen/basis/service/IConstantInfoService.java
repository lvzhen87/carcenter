package com.freshen.basis.service;

import java.util.ArrayList;

import java.util.List;

import com.freshen.entity.basis.ConstantInfo;

public interface IConstantInfoService {
	/**
	 * 查询常量信息
	 * lz
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ConstantInfo> getConstantInfo( ConstantInfo constantInfo, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询常量信息 返回记录总数
	 * lz
	 * @param barrierGate
	 * @return
	 * @throws Exception
	 */
	public long getConstantInfoNumber( ConstantInfo constantInfo) throws Exception;
	
	/**
	 * 修改常量信息
	 * lz
	 * @param barrierGate
	 * @param operation 1 增加修改  2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationConstantInfo(List<ConstantInfo> constantInfo, int operation)
	throws Exception;
}
