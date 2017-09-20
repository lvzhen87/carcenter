package com.freshen.barrierGate.service;

import java.util.ArrayList;

import com.freshen.entity.barrierGate.BarrierGateControl;

public interface BarrierGateControlService {
	/**
	 * 查询道闸信号灯控制信息
	 * @param barrierGateControl
	 * @param start 起始位置  值为-1时 不分页
	 * @param size 显示长度
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BarrierGateControl> getBarrierGateControlInfo(BarrierGateControl barrierGateControl
			,int start , int size) throws Exception;
	
	/**
	 * 查询道闸信号灯控制信息数量
	 * @param barrierGateControl
	 * @return
	 * @throws Exception
	 */
	public long getBarrierGateControlInfo(BarrierGateControl barrierGateControl) throws Exception;
	/**
	 * 修改删除 道闸控制信息
	 * @param barrierGateControl
	 * @param operation 1 修改 增加 2删除 
	 * @return
	 * @throws Exception
	 */
	public int OperationBarrierGateControl(BarrierGateControl barrierGateControl,int operation) throws Exception;
	
}
