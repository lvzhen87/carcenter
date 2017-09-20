package com.freshen.groundcontrol.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.groundcontrol.FacilityState;

public interface IfacilityStatelService {
	/**
	 * 查询设备占用信息
	 * @param facilityState
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<FacilityState> getfacilityStatelInfo(FacilityState facilityState, int start, int size) throws Exception;
	/**
	 * 查询设备占用数量
	 * @param facilityState
	 * @return
	 * @throws Exception
	 */
	public long getfacilityStatelInfoNumber(FacilityState facilityState) throws Exception;
	/**
	 * 修改删除设备占用信息
	 * @param facilityState
	 * @param operation 1增加 修改 2 删除
	 * @return
	 * @throws Exception
	 */
	public int OperationfacilityStatelInfo(List<FacilityState> facilityState, int operation)
	throws Exception;
}
