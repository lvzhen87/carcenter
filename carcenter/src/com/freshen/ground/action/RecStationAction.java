package com.freshen.ground.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.barrierGate.service.BarrierGateInorOutinfoService;
import com.freshen.barrierGate.service.VBarrierGateInorOutinfoService;
import com.freshen.barrierGate.service.impl.BarrierGateInorOutinfoServiceImpl;
import com.freshen.barrierGate.service.impl.VBarrierGateInorOutinfoServiceImpl;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.barrierGate.BarrierGateInorOutinfo;
import com.freshen.entity.barrierGate.VBarriergateInoroutinfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.process.Station;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.process.service.impl.StationServiceImpl;
import com.freshen.util.ChineseTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;

public class RecStationAction extends CapgActionSupport{
	 
	String rstr=SUCCESS;
	List<Station> station = new ArrayList<Station>();
	List<VBarriergateInoroutinfo> inoroutinfo = new ArrayList<VBarriergateInoroutinfo>();
	String vehicleID_s ;
	String orderName_s;
	String startDate;
	String endDate;
	String resaveds2_s;
	String motion_s;
	String roadnameS;
	String orderidS;
	String eventnumberS;
	String speedtype_s;
 	String overtimemin;//超时时间
	List<ReceptionOrder> orderlist = new ArrayList<ReceptionOrder>();
	List<RoadInfo> roadlist = new ArrayList<RoadInfo>();
	//分页
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 
	 * 车辆通过查询
	 * searchRecStation 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String searchRecStation()
	{
		try {
			//设置要查询的条件
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start = new Date();
			//System.out.println(startDate);
			////System.out.println(endDate);
			if(startDate == null)
			{
				start = getNextDay(new Date());
				startDate= sdf.format(new Date()).toString(); 
			}*/
			IroadInfoService irs = new RoadInfoServiceImpl();
			roadlist = irs.getRoadInfo(null);
			VBarriergateInoroutinfo tmp = new VBarriergateInoroutinfo();
			
			//Station sta = new Station();
			RoadInfo ri = new RoadInfo();
			if(startDate == null || startDate.equals("") || endDate == null || endDate.equals(""))
			{
				return SUCCESS;
			}
			if(orderidS != null && !"".equals(orderidS.trim()))
			{
				tmp.setOrderidS(orderidS);
			}
			
			if(orderName_s != null && !"".equals(orderName_s.trim()) && ChineseTools.isMessyCode(orderName_s))
			{
				orderName_s = new String(orderName_s.getBytes("ISO-8859-1"),"UTF-8").trim();
			}
			tmp.setOrdernameS(orderName_s);
			if(vehicleID_s != null && !"".equals(vehicleID_s.trim()))
			{
				tmp.setCardidS(vehicleID_s);
			}
			if(resaveds2_s != null && !"".equals(resaveds2_s.trim()))
			{
				tmp.setResaveds3_s(resaveds2_s);
			}
			if(roadnameS!=null&&!roadnameS.equals("-1") && !roadnameS.equals("")){
				//tmp.setRoadnameS(roadnameS);
				tmp.setRoadidS(roadnameS);
			}
			if(motion_s!=null&&!motion_s.equals("-1")){
				tmp.setMotionS(motion_s);
			}
			if(startDate != null && !startDate.equals("")){
				tmp.setEditflagtimeS(startDate);
			}
			if(endDate != null && !endDate.equals("")){
				tmp.setEditflagEndtimeS(endDate);
			}
			
			VBarrierGateInorOutinfoService service = new VBarrierGateInorOutinfoServiceImpl();
			//确定记录总数
			totalPages =service.getVBarrierGateInorOutinfo(tmp);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			if(totalPages > 0){
				inoroutinfo = service.getBarrierGateInorOutinfo(tmp, currentPage*pageSize, pageSize);
			}
			
			//System.out.println(inoroutinfo.size());
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		
		
	}
	
	/**
	 * 在场车辆查询	   
	 * searchRecStationold 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String searchRecStationold()
	{
		try {
			
			//设置要查询的条件
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start = new Date();
			//System.out.println(startDate);
			////System.out.println(endDate);
			if(startDate == null)
			{
				start = getNextDay(new Date());
				startDate= sdf.format(new Date()).toString(); 
			}
			IroadInfoService irs = new RoadInfoServiceImpl();
			roadlist = irs.getRoadInfo(null);
			Station sta = new Station();
			RoadInfo ri = new RoadInfo();
 			
			if(orderName_s != null)
			{
				sta.setFacilityID_s(orderName_s);
			}
			if(vehicleID_s != null && !"".equals(vehicleID_s.trim()))
			{
				sta.setVehicleID_s(vehicleID_s);
			}

			if(startDate != null && !startDate.equals("")){
				sta.setRecordDate_d(DateUtil.getDate(startDate));
			}

			StationServiceImpl service = new StationServiceImpl();
			station = service.getProcessStationInCardInfo(sta);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 修改速度类型	   
	 * updateSpeed 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String updateSpeed()
	{
		try {
			
			System.out.println("eventnumberS====="+eventnumberS);
			System.out.println("speedtype_s====="+speedtype_s);
			BarrierGateInorOutinfoService service = new BarrierGateInorOutinfoServiceImpl();
			BarrierGateInorOutinfo model = new BarrierGateInorOutinfo();
			model.setEventNumber_s(eventnumberS);
			if(speedtype_s==null||speedtype_s.equals("1")){
				speedtype_s="2";
			}else{
				speedtype_s="1";
			}
			model.setSpeedtype_s(speedtype_s);
			service.OperationBarrierGateInorOutinfo2(model, 1);
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		
		return this.searchRecStation();
	}
	
	/**
	 * 
	 * 查询超时车辆
	 * searchRecStation 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String searchOvertimeRecStation()
	{
		try {
			//设置要查询的条件
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start = new Date();
			//System.out.println(startDate);
			////System.out.println(endDate);
			if(startDate == null)
			{
				start = getNextDay(new Date());
				startDate= sdf.format(new Date()).toString(); 
			}*/
			IroadInfoService irs = new RoadInfoServiceImpl();
			roadlist = irs.getRoadInfo(null);
			if(overtimemin==null||overtimemin.equals("")||overtimemin.equals("0")){
				overtimemin = "10";
			}
			VBarrierGateInorOutinfoService service = new VBarrierGateInorOutinfoServiceImpl();
			inoroutinfo = service.getOvertimeinfo(roadnameS, overtimemin);
			
			
			//System.out.println(inoroutinfo.size());
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}		
	}
	
	public String getResaveds2_s() {
		return resaveds2_s;
	}

	public void setResaveds2_s(String resaveds2S) {
		resaveds2_s = resaveds2S;
	}

	public String getMotion_s() {
		return motion_s;
	}

	public void setMotion_s(String motionS) {
		motion_s = motionS;
	}

	public List<RoadInfo> getRoadlist() {
		return roadlist;
	}

	public void setRoadlist(List<RoadInfo> roadlist) {
		this.roadlist = roadlist;
	}

	public List<ReceptionOrder> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<ReceptionOrder> orderlist) {
		this.orderlist = orderlist;
	}

	public String getRstr() {
		return rstr;
	}
	public void setRstr(String rstr) {
		this.rstr = rstr;
	}
	public List<Station> getStation() {
		return station;
	}
	public void setStation(List<Station> station) {
		this.station = station;
	}
	public String getVehicleID_s() {
		return vehicleID_s;
	}
	public void setVehicleID_s(String vehicleID_s) {
		this.vehicleID_s = vehicleID_s;
	}
	public String getOrderName_s() {
		return orderName_s;
	}
	public void setOrderName_s(String orderName_s) {
		this.orderName_s = orderName_s;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	 

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<VBarriergateInoroutinfo> getInoroutinfo() {
		return inoroutinfo;
	}

	public void setInoroutinfo(List<VBarriergateInoroutinfo> inoroutinfo) {
		this.inoroutinfo = inoroutinfo;
	}

	public String getRoadnameS() {
		return roadnameS;
	}

	public void setRoadnameS(String roadnameS) {
		this.roadnameS = roadnameS;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderidS() {
		return orderidS;
	}

	public void setOrderidS(String orderidS) {
		this.orderidS = orderidS;
	}

	public String getEventnumberS() {
		return eventnumberS;
	}

	public void setEventnumberS(String eventnumberS) {
		this.eventnumberS = eventnumberS;
	}

	public String getSpeedtype_s() {
		return speedtype_s;
	}

	public void setSpeedtype_s(String speedtypeS) {
		speedtype_s = speedtypeS;
	}

	public String getOvertimemin() {
		return overtimemin;
	}

	public void setOvertimemin(String overtimemin) {
		this.overtimemin = overtimemin;
	}
	
	
}
