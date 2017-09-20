package com.freshen.reception.action;

import java.util.ArrayList;

import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: VehicleInfoAction.java
 *  Function:车型信息
 *     Modifications:   
 *  @author   DateTime 2014-4-16 下午06:17:28    
 *  @version 1.0
 */
public class VehicleInfoAction extends CapgActionSupport {
	String rs=SUCCESS;
	String orderID;//获取订单id
	ArrayList<ReceptionVehicleInfo> recVehicleList=new ArrayList<ReceptionVehicleInfo>(); 
	String msg;
	
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	public String execute(){
		searchByID();
		return rs;
	}
	
	/** 
	 * Function:根据订单号查询车辆信息
	 * @author sharonyshi 2014-4-24
	 * @return 查询车辆信息
	 */
	public String searchByID(){
		try {
			
			/*if(orderID==null || orderID.length()<1){
				msg="请输入要查询的订单编号！";
				return rs;
			}*/
			
			//设置要查询的orderid
			ReceptionVehicleInfo vehicleforsearch=new ReceptionVehicleInfo();
			vehicleforsearch.setOrderID_s(orderID);
			
			
			IreceptionVehicleInfoService irecVehicleService=new ReceptionVehicleInfoServiceImpl();
			
			//确定记录总数
			totalPages =irecVehicleService.getReceptionVehicleInfoNumber(vehicleforsearch);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			recVehicleList=irecVehicleService.getReceptionVehicleInfo(vehicleforsearch, currentPage*pageSize, pageSize);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		
		return rs;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	
	public ArrayList<ReceptionVehicleInfo> getRecVehicleList() {
		return recVehicleList;
	}

	public void setRecVehicleList(ArrayList<ReceptionVehicleInfo> recVehicleList) {
		this.recVehicleList = recVehicleList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

}
