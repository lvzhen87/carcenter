package com.freshen.process.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.barrierGate.service.BarrierGateInorOutinfoService;
import com.freshen.barrierGate.service.impl.BarrierGateInorOutinfoServiceImpl;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.cost.service.impl.OrdercostInfoServiceImpl;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.barrierGate.BarrierGateInorOutinfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.process.Station;
import com.freshen.entity.reception.ReceptionVehicleInfo;

import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.process.service.IstationService;
import com.freshen.process.service.impl.StationServiceImpl;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;

public class ProcessStatisticalAction extends CapgActionSupport{
	List<Station> stationlist=new ArrayList<Station>();
	String orderID_s,roadID_s,motion_s,createTime_s,cpg_s;
	String roadName_s,vehicleID_s,vehicleCPG_s,startSDate,startEDate,endSDate,endEDate;
	List<RoadInfo> roadlist = new ArrayList<RoadInfo>();
	String orderNameShow;
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	String msg;
	BarrierGateInorOutinfo model = new BarrierGateInorOutinfo();
	ArrayList<RoadInfo> roadforbarrier=new ArrayList<RoadInfo>();//道路信息
	ArrayList<ReceptionVehicleInfo> cpglist = new ArrayList<ReceptionVehicleInfo>();
	/**
	 * 进出查询
	 * processStatistic 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String processStatistic(){
		IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
		try {
			IOrdercostInfoService impl = new OrdercostInfoServiceImpl();
			impl.OrderProcessStationCost(orderID_s);
			
			RoadInfo r=new RoadInfo();
			if(roadID_s != null && !roadID_s.equals("-1")){
				r.setRoadID_s(roadID_s);
			}
			r.setRoadName_s(roadName_s);
			
			Station s=new Station();
			//s.setSerialNumber_s(serialNumber_s);
			s.setOrderID_s(orderID_s);
			//查询所有过道闸流水
			s.setResaveds2_s("null");
			s.setCurrent("1");
			//s.setMappingSerialNumber_s("notnull");
		 
			s.setRoadInfo(r);
			/*if(vehicleCPG_s!=null && vehicleCPG_s.length() > 0){
				ReceptionVehicleInfo receptionVehicleInfo = new ReceptionVehicleInfo();
				receptionVehicleInfo.setResaveds2_s(vehicleCPG_s);
				List<ReceptionVehicleInfo> l = ireceptionVehicleInfoService.getReceptionVehicleInfo(receptionVehicleInfo, ConstantUtil.pagingNot, 0);				
				if(BasicTools.isnotNull(l)&&l.size()==1){
					s.setVehicleCPG_s(l.get(0).getVehicleCPG_s());
				}else{
					s.setVehicleCPG_s(vehicleCPG_s);
				}
			}*/
			s.setResaveds5_s(vehicleCPG_s);
			s.setVehicleID_s(vehicleID_s);
			s.setStartSDate(startSDate);
		    s.setStartEDate(startEDate);
		    s.setEndEDate(endEDate);
		    s.setEndSDate(endSDate);
		    s.setMappingSerialNumber_s("notnull");
			IstationService iss=new StationServiceImpl();
			totalPages=iss.getBasisStationInfo(s);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			stationlist=iss.getBasisStationInfo(s,currentPage*pageSize, pageSize);
			if(BasicTools.isnotNull(stationlist)){
				for(int i=0;i<stationlist.size();i++){
					Station bean = stationlist.get(i);
					if(bean.getAction_s()==2){
						bean.setResaveds3_s(DateUtil.dateToString(bean.getRecordDate_d(),"yyyy-MM-dd HH:mm:ss"));
						bean.setRecordDate_d(null);
					}
				}
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
	
	/**
	 * 进入添加进出道闸信息页面
	 * processStatistic 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String initAddInorOutBarrierGate(){
		IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
		try {
			//查询道路信息
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadforbarrier=irs.getRoadInfo(null);
			
			//查询订单下的cpg
			ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
			rVehicleInfo.setOrderID_s(orderID_s);
			cpglist = ireceptionVehicleInfoService.getReceptionVehicleInfo(rVehicleInfo,ConstantUtil.pagingNot,0);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 手工添加进出道闸信息
	 * processStatistic 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String addInorOutBarrierGate(){		
		try {
			BarrierGateInorOutinfoService service = new BarrierGateInorOutinfoServiceImpl();
			model.setResaveds5_s("1");
			model.setRoadID_s(roadID_s);
			model.setMotion_s(motion_s);
			model.setResaveds3_s(cpg_s);
			model.setCreateTime_s(createTime_s);		
			msg = service.OperationBarrierGateInorOutinfoService(model, 1);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public ArrayList<ReceptionVehicleInfo> getCpglist() {
		return cpglist;
	}

	public void setCpglist(ArrayList<ReceptionVehicleInfo> cpglist) {
		this.cpglist = cpglist;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Station> getStationlist() {
		return stationlist;
	}
	public void setStationlist(List<Station> stationlist) {
		this.stationlist = stationlist;
	}
	public String getOrderID_s() {
		return orderID_s;
	}
	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
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
	public String getRoadName_s() {
		return roadName_s;
	}
	public void setRoadName_s(String roadName_s) {
		this.roadName_s = roadName_s;
	}
	public String getVehicleID_s() {
		return vehicleID_s;
	}
	public void setVehicleID_s(String vehicleID_s) {
		this.vehicleID_s = vehicleID_s;
	}
	public String getStartSDate() {
		return startSDate;
	}
	public void setStartSDate(String startSDate) {
		this.startSDate = startSDate;
	}
	public String getStartEDate() {
		return startEDate;
	}
	public void setStartEDate(String startEDate) {
		this.startEDate = startEDate;
	}
	public String getEndSDate() {
		return endSDate;
	}
	public void setEndSDate(String endSDate) {
		this.endSDate = endSDate;
	}
	public String getEndEDate() {
		return endEDate;
	}
	public void setEndEDate(String endEDate) {
		this.endEDate = endEDate;
	}
	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}
	public void setVehicleCPG_s(String vehicleCPGS) {
		vehicleCPG_s = vehicleCPGS;
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
	public String getOrderNameShow() {
		return orderNameShow;
	}
	public void setOrderNameShow(String orderNameShow) {
		this.orderNameShow = orderNameShow;
	}

	public BarrierGateInorOutinfo getModel() {
		return model;
	}

	public void setModel(BarrierGateInorOutinfo model) {
		this.model = model;
	}

	public ArrayList<RoadInfo> getRoadforbarrier() {
		return roadforbarrier;
	}

	public void setRoadforbarrier(ArrayList<RoadInfo> roadforbarrier) {
		this.roadforbarrier = roadforbarrier;
	}

	public String getMotion_s() {
		return motion_s;
	}

	public void setMotion_s(String motionS) {
		motion_s = motionS;
	}

	public String getCreateTime_s() {
		return createTime_s;
	}

	public void setCreateTime_s(String createTimeS) {
		createTime_s = createTimeS;
	}

	public String getCpg_s() {
		return cpg_s;
	}

	public void setCpg_s(String cpgS) {
		cpg_s = cpgS;
	}	
}
