package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.barrierGate.service.BarrierGateInorOutinfoService;
import com.freshen.barrierGate.service.impl.BarrierGateInorOutinfoServiceImpl;
import com.freshen.entity.barrierGate.BarrierGateInorOutinfo;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.process.Station;
import com.freshen.entity.process.TProcessWashcarinvalid;
import com.freshen.process.service.IstationService;
import com.freshen.process.service.TprocessWashcarinvalidService;
import com.freshen.process.service.impl.StationServiceImpl;
import com.freshen.process.service.impl.TprocessWashcarinvalidServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class WashcarAction  extends CapgActionSupport{
	String orderID,orderName,startDate,endDate,status;
	String facilityID,serialNumber,recordDate,cpg,vehicleCPG_s;
	String recordDates;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	ArrayList<Station> stationlist=new ArrayList<Station>();	
	ArrayList<TProcessWashcarinvalid> twlist = new ArrayList<TProcessWashcarinvalid>();
	//分页
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
		
	public String execute(){
		try {
			if(status.equals("0")){
				 Station station = new Station();	 
				 station.setOrderID_s(orderID);
				 station.setOrderName(orderName);
				 
				 if(startDate != null && !startDate.equals("")){
					 station.setStartSDate(startDate);
				 }
				 if(endDate != null && !endDate.equals("")){
					 station.setStartEDate(endDate);
				 }
					
				 IstationService service  = new StationServiceImpl();
				//确定记录总数
				 totalPages =service.getXcInOutInfoNum(station);
				 maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
				 //合适当前页的有效性
				 if(currentPage<=0){
					 currentPage=0;
				 }else if(currentPage>=maxPage){
					 currentPage=maxPage;
				 }
				 stationlist=service.getXcInOutInfo(station,currentPage*pageSize,pageSize);
			}else if(status.equals("1")){
				TProcessWashcarinvalid tw = new TProcessWashcarinvalid();
				tw.setOrderidS(orderID);
				tw.setOrderName(orderName);
				tw.setResaveds1S("1");
				if(startDate != null && !startDate.equals("")){
					tw.setCreatestartDate_t(DateUtil.getDate(startDate));
				}
				if(endDate != null && !endDate.equals("")){
					 tw.setCreateendDate_t(DateUtil.getDate(endDate));
				}
				TprocessWashcarinvalidService tws = new TprocessWashcarinvalidServiceImpl();
				totalPages = tws.getTProcessWashcarinvalidInfoNum(tw);
				maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
				//合适当前页的有效性
				if(currentPage<=0){
					currentPage=0;
				}else if(currentPage>=maxPage){
					currentPage=maxPage;
				}
 				twlist = tws.getTProcessWashcarinvalidInfo(tw,currentPage*pageSize,pageSize);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	

	public void deleteWashcar(){
		try {
			TProcessWashcarinvalid tw = new TProcessWashcarinvalid();
			tw.setSerialnumberS(serialNumber);
			tw.setOrderidS(orderID);
			//tw.setRecorddateT(DateUtil.getDate(recordDate,"yyyy-MM-dd HH:mm:ss"));
			tw.setRecorddateT(DateUtil.getDate(recordDates,"yyyy-MM-dd HH:mm:ss"));
			tw.setFacilityID_s(facilityID);
			tw.setResaveds2S(cpg);
			tw.setVehiclecpgS(vehicleCPG_s);
			tw.setCreateuserS(employ.getCustomerUserName_s());
			tw.setCreatedateT(DateUtil.getCurrentDate());
			tw.setResaveds1S("1");
			
			List<TProcessWashcarinvalid> list = new ArrayList<TProcessWashcarinvalid>();
			list.add(tw);
			
			TprocessWashcarinvalidService tws = new TprocessWashcarinvalidServiceImpl();
			tws.OperationTProcessWashcarinvalidInfo(list,1);
		 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
		 
		}	 
	}

	 
	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}
	
	public void setVehicleCPG_s(String vehicleCPG_s) {
		this.vehicleCPG_s = vehicleCPG_s;
	}

	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
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
	public ArrayList<Station> getStationlist() {
		return stationlist;
	}
	public void setStationlist(ArrayList<Station> stationlist) {
		this.stationlist = stationlist;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<TProcessWashcarinvalid> getTwlist() {
		return twlist;
	}
	public void setTwlist(ArrayList<TProcessWashcarinvalid> twlist) {
		this.twlist = twlist;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	  
	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordDates() {
		return recordDates;
	}

	public void setRecordDates(String recordDates) {
		this.recordDates = recordDates;
	}
	
	public String getCpg() {
		return cpg;
	}
	public void setCpg(String cpg) {
		this.cpg = cpg;
	}
	
	
}
