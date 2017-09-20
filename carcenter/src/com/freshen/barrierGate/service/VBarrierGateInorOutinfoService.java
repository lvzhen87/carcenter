package com.freshen.barrierGate.service;

import java.util.ArrayList;

import com.freshen.entity.barrierGate.VBarriergateInoroutinfo;

public interface VBarrierGateInorOutinfoService {

	public ArrayList<VBarriergateInoroutinfo> getBarrierGateInorOutinfo(
			VBarriergateInoroutinfo barrierGateInorOutinfo, int start, int size)
			throws Exception ;
	
	public long getVBarrierGateInorOutinfo(
			VBarriergateInoroutinfo barrierGateInorOutinfo) throws Exception ;
	
	public ArrayList<VBarriergateInoroutinfo> getOvertimeinfo(
			String orderid,String overtime)
			throws Exception ;
}
