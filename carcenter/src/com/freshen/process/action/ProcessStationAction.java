package com.freshen.process.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.cost.service.impl.OrdercostInfoServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.process.Station;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.util.ConstantUtil;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.process.service.IstationService;
import com.freshen.process.service.impl.StationServiceImpl;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;

public class ProcessStationAction  extends CapgActionSupport{
	List<Station> stationlist=new ArrayList<Station>();
	List<ReceptionOrder> OrderList=new ArrayList();
	List<RoadInfo> roadlist = new ArrayList<RoadInfo>();
	String startDate;
	String endDate;
	String serialNumber_s, orderID_s, facilityID_s,vehicleID_s, vehicleCPG_s,roadName_s,customerName,states;
	String orderName_s,roadID_s;
	String orderNameShow;
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	/**************20160518 kxc****************************/	
	String resaveds2;//cpg拍照
	public String getResaveds2() {
		return resaveds2;
	}

	public void setResaveds2(String resaveds2) {
		this.resaveds2 = resaveds2;
	}
	public String execute(){
		try {
			//设置要查询的条件
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start = new Date();
			//System.out.println(startDate);
			//System.out.println(endDate);
			if(startDate == null)
			{
				start = getNextDay(new Date());
				//endDate = sdf.format(new Date()).toString(); 
				//startDate = sdf.format(start).toString(); 
				startDate= sdf.format(new Date()).toString(); 
				//OrderDetail ro=new OrderDetail();2014-8-25 之前默认查询预约表信息，改为查询接待表信息
			}*/
			//cpg牌照不为空，查询出订单编号
			if(resaveds2!=null&&resaveds2.trim().length()>0){
				IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
				ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
				rVehicleInfo.setResaveds2_s(resaveds2);
				ArrayList<ReceptionVehicleInfo> rviList = ireceptionVehicleInfoService.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0);
				if(rviList != null && rviList.size()>0){	
					orderID_s = rviList.get(0).getOrderID_s();
				}
			}
			
			//设置要查询的订单条件
			ReceptionOrder recorder =new ReceptionOrder();
			recorder.setOrderID_s(orderID_s);
			recorder.setOrderName_s(orderName_s);
			if(states != null && states.length()>0 && !states.equals("-1")){
				recorder.setStatus_s(states);
			}
			
			Customer c=new Customer();
			c.setCustomerName_s(customerName);
			recorder.setCustomer(c);
			if(startDate != null && !startDate.equals("")){
				recorder.setStartDate_d(DateUtil.getDate(startDate));	
			}
			if(endDate != null && !endDate.equals("")){
				recorder.setEndDate_d(DateUtil.getDate(endDate));
			}
			
			IreceptionOrderService irecorderService=new ReceptionOrderServiceImpl();
			//确定记录总数
			totalPages =irecorderService.getReceptionOrderNumber(recorder);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				OrderList=irecorderService.getReceptionOrder(recorder,currentPage*pageSize, pageSize);
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

	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 订单道路查询	   
	 * processDetail 
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String processDetail(){
		IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
		try {
			
			RoadInfo r=new RoadInfo();
			if(roadID_s != null && roadID_s.length() > 0 && !roadID_s.equals("-1")){
				r.setRoadID_s(roadID_s);
			}
			r.setRoadName_s(roadName_s);		
			Station s=new Station();
			//s.setSerialNumber_s(serialNumber_s);
			s.setOrderID_s(orderID_s);
			s.setRoadInfo(r);
			
			s.setResaveds5_s(vehicleCPG_s);
			s.setResaveds2_s("null");
			if(startDate != null && !startDate.equals("")){
				s.setStartSDate(startDate);
			}
			if(endDate != null && !endDate.equals("")){
				s.setStartEDate(endDate);
			}
			
			IOrdercostInfoService iois=new OrdercostInfoServiceImpl();
			//接收sql server过站数据并进行匹配
			iois.ComputeOrderCost(orderID_s);

			IstationService iss=new StationServiceImpl();
			//确定记录总数
			totalPages =iss.getBasisStationInfo(s);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			if(totalPages > 0){
				stationlist=iss.getBasisStationInfo(s, currentPage*pageSize, pageSize);
			}						 
			
			//用于订单名称显示
			OrderDetail od=new OrderDetail();
			od.setOrderID_s(orderID_s);
			IorderInfoService ios=new OrderInfoServiceImpl();
			List<OrderDetail> olist=ios.getOrder(od);
			if(olist != null && olist.size() > 0){
				orderNameShow = olist.get(0).getOrderName_s();
			}
			//用于道路下拉菜单
			IroadInfoService irs = new RoadInfoServiceImpl();
			roadlist = irs.getRoadInfo(null, ConstantUtil.pagingNot,0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public List<Station> getStationlist() {
		return stationlist;
	}

	public void setStationlist(List<Station> stationlist) {
		this.stationlist = stationlist;
	}

	public String getSerialNumber_s() {
		return serialNumber_s;
	}

	public void setSerialNumber_s(String serialNumber_s) {
		this.serialNumber_s = serialNumber_s;
	}

	public String getOrderID_s() {
		return orderID_s;
	}

	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}

	public String getFacilityID_s() {
		return facilityID_s;
	}

	public void setFacilityID_s(String facilityID_s) {
		this.facilityID_s = facilityID_s;
	}

	public String getVehicleID_s() {
		return vehicleID_s;
	}

	public void setVehicleID_s(String vehicleID_s) {
		this.vehicleID_s = vehicleID_s;
	}

	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}

	public void setVehicleCPG_s(String vehicleCPG_s) {
		this.vehicleCPG_s = vehicleCPG_s;
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

	public List<ReceptionOrder> getOrderList() {
		return OrderList;
	}

	public void setOrderList(List<ReceptionOrder> orderList) {
		OrderList = orderList;
	}

	public String getOrderName_s() {
		return orderName_s;
	}

	public void setOrderName_s(String orderName_s) {
		this.orderName_s = orderName_s;
	}

	public String getRoadName_s() {
		return roadName_s;
	}

	public void setRoadName_s(String roadName_s) {
		this.roadName_s = roadName_s;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getOrderNameShow() {
		return orderNameShow;
	}

	public void setOrderNameShow(String orderNameShow) {
		this.orderNameShow = orderNameShow;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getRoadID_s() {
		return roadID_s;
	}

	public void setRoadID_s(String roadID_s) {
		this.roadID_s = roadID_s;
	}

	public List<RoadInfo> getRoadlist() {
		return roadlist;
	}

	public void setRoadlist(List<RoadInfo> roadlist) {
		this.roadlist = roadlist;
	}
}