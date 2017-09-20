package com.freshen.ground.action;

import java.util.ArrayList;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.groundcontrol.FacilityState;
import com.freshen.groundcontrol.service.IfacilityStatelService;
import com.freshen.groundcontrol.service.impl.FacilityStateSerceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class OccupationAction extends CapgActionSupport{
	String serialNumber_s,roadID,state_s,specialInfo_s,appointDate_d;	
	String roadName;//用于日历修改占用状态时查询相关道路信息
	ArrayList<FacilityState> facilityStateList=new ArrayList<FacilityState>();//存放状态信息
	ArrayList<RoadInfo> roadlist=new ArrayList<RoadInfo>();//记录道路信息，用于修改状态
	FacilityState facilityState=new FacilityState();//存放要更新的状态信息
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	

	//分页
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	/**
	 * 默认查询所有信息，有条件时查询相关信息
	 * @author sharonyshi 2014-6-5
	 */
	public String execute(){
		try {
			FacilityState fs=new FacilityState();
			
			IfacilityStatelService ifss=new FacilityStateSerceImpl();
			//确定记录总数
			totalPages =ifss.getfacilityStatelInfoNumber(fs);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			facilityStateList=ifss.getfacilityStatelInfo(fs, currentPage*pageSize, pageSize);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}

	
	/**
	 * 查询要新增或者更新道路占用状态信息
	 * @return
	 */
	public String prepareupdateState(){
		try {
			//如果编号不为空，查询相关信息，说明是更新操作
			if(serialNumber_s != null && !serialNumber_s.equals("")){
				FacilityState temp=new FacilityState();
				temp.setSerialNumber_s(serialNumber_s);
				
				IfacilityStatelService ifss=new FacilityStateSerceImpl();
				ArrayList<FacilityState> flist=ifss.getfacilityStatelInfo(temp, ConstantUtil.pagingNot,0);
				
				if(flist!=null && flist.size()>0){
					facilityState=flist.get(0);
					appointDate_d=facilityState.getAppointDate_d().toString();
				}
				
				
				//查询所有道路信息
				IroadInfoService irs=new RoadInfoServiceImpl();
				roadlist=irs.getRoadInfo(null);
			}
			
			if(roadName != null && !roadName.equals("")){//说明是日历更新占用状态操作
				IroadInfoService irs=new RoadInfoServiceImpl();
				//查询出相关列的道路信息
				RoadInfo ri=new RoadInfo();
				ri.setRoadName_s(roadName);
				roadlist=irs.getRoadInfo(ri);
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	
	
	/**
	 * 新增或者更新道路占用状态信息
	 * @return
	 */
	public String updateState(){
		try {
			FacilityState fs=new FacilityState();
			//说明是更新操作
			if(serialNumber_s!=null && !serialNumber_s.equals("")){
				fs.setSerialNumber_s(serialNumber_s);
				fs.setLastUpdateDate_t(DateUtil.getCurrentDate());
				fs.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{//说明是新增操作
				fs.setCreateDate_t(DateUtil.getCurrentDate());
				fs.setCreateUser_s(employ.getCustomerUserName_s());
			}
			fs.setState_s(state_s);
			fs.setSpecialInfo_s(specialInfo_s);
			fs.setAppointDate_d(DateUtil.getDate(appointDate_d));
			fs.setFacilityID_s(roadID);
			
			//封装list中
			ArrayList<FacilityState> flist=new ArrayList<FacilityState>();
			flist.add(fs);
			
			IfacilityStatelService ifss=new FacilityStateSerceImpl();
			ifss.OperationfacilityStatelInfo(flist,1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	

	public ArrayList<FacilityState> getFacilityStateList() {
		return facilityStateList;
	}


	public void setFacilityStateList(ArrayList<FacilityState> facilityStateList) {
		this.facilityStateList = facilityStateList;
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


	public ArrayList<RoadInfo> getRoadlist() {
		return roadlist;
	}


	public void setRoadlist(ArrayList<RoadInfo> roadlist) {
		this.roadlist = roadlist;
	}


	public String getSerialNumber_s() {
		return serialNumber_s;
	}


	public void setSerialNumber_s(String serialNumber_s) {
		this.serialNumber_s = serialNumber_s;
	}


	public String getRoadID() {
		return roadID;
	}


	public void setRoadID(String roadID) {
		this.roadID = roadID;
	}


	public String getState_s() {
		return state_s;
	}


	public void setState_s(String state_s) {
		this.state_s = state_s;
	}


	public String getSpecialInfo_s() {
		return specialInfo_s;
	}


	public void setSpecialInfo_s(String specialInfo_s) {
		this.specialInfo_s = specialInfo_s;
	}


	public FacilityState getFacilityState() {
		return facilityState;
	}


	public void setFacilityState(FacilityState facilityState) {
		this.facilityState = facilityState;
	}


	public String getAppointDate_d() {
		return appointDate_d;
	}


	public void setAppointDate_d(String appointDate_d) {
		this.appointDate_d = appointDate_d;
	}
	public String getRoadName() {
		return roadName;
	}


	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	

}
