package com.freshen.process.service;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.cost.OrdercostInfo;
import com.freshen.entity.cost.OrderroadcostTemp;
import com.freshen.entity.process.RoadEmployInventory;
import com.freshen.entity.process.Station;

public interface IstationService {
	/**
	 * 进出设施查询
	 * @param station 进出设施对象
	 * @param start 开始位置
	 * @param size 结束位置
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Station> getBasisStationInfo( Station station, int start, int size) 
	throws Exception ;
	
	/**
	 * 查询进出设施数量
	 * @param station 进出设施对象
	 * @return
	 * @throws Exception
	 */
	public long getBasisStationInfo( Station station) throws Exception;
	
	/**
	 * 获得order进出道闸费用信息
	 * getBasisStationcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderroadcostTemp> getBasisStationcostInfo(String orderID) throws Exception ;
	
	/**
	 * 获得order进出道闸按车辆、道路的统计信息
	 * getBasisStationStaticsInfo 
	 * @param   name    
	 * @param  @return     resaveds1_s：总用时(分钟)
	 *                     spanMinute_i：收费用时
	 *                     facilityID_s:道路id
	 *                     FacilityName:道路名称
	 *                     vehicleCPG_s：车的CPG号
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getBasisStationStaticsInfo(String orderID) throws Exception ;
	
	/**
	 * 获得order进出道闸按车辆、道路的统计信息,如果没有信息，进行一次费用统计
	 * getBasisStationStaticsInfo 
	 * @param   name    
	 * @param  @return     resaveds1_s：总用时(分钟)
	 *                     spanMinute_i：收费用时
	 *                     facilityID_s:道路id
	 *                     FacilityName:道路名称
	 *                     vehicleCPG_s：车的CPG号
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getBasisStationStaticsInfoBymain(String orderID) throws Exception ;
	
	/**
	 * 获得洗车信息
	 * getxcInOutInfo 
	 * @param   name    
	 * @param  @return     
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getXcInOutInfo(Station station,int start,int size) throws Exception ;
	
	/**
	 * 获得洗车信息数量
	 * getxcInOutInfo 
	 * @param   name    
	 * @param  @return     
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getXcInOutInfoNum(Station station) throws Exception ;
	
	/**
	 * 道路使用量确认清单	   
	 * getRoadEmployInventoryList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<RoadEmployInventory> getRoadEmployInventoryList(RoadEmployInventory model)throws Exception;
	
	/**
	 * 道路使用量确认清单导出pdf	   
	 * getRoadEmployInventoryList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String[] getRoadEmployInventoryPDF(RoadEmployInventory model,List<RoadEmployInventory> list)throws Exception;
	
	
	public void CaluEmployInventory(RoadEmployInventory model)throws Exception;
		 
}
