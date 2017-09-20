package com.freshen.entity.process;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.reception.ReceptionOrder;

public class Station  extends  BeanModel{

	String serialNumber_s, orderID_s, facilityID_s;
	Date recordDate_d;
	String recordDate_s;
	Integer action_s;
	String mappingSerialNumber_s, vehicleID_s, vehicleCPG_s;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	Integer spanMinute_i;//收费分钟
	Integer wholeIncludeTime_i;
	Integer preIncludeTime_i;
	Double  cost_i; //费用 
	
	String  facilityName; //道路名称,非数据库字段
	String  orderName; //订单名称,非数据库字段	
	ReceptionOrder receptionOrder ;	
	RoadInfo roadInfo ;	
	 
	String customerName_s;
	String startSDate,startEDate,endSDate,endEDate;//逻辑字段，用于查询条件赋值
	String manualCPG; //人工CPG
	
	String current ;//显示流水 1 是
	/*BarrierGate barrierGate;*/
	
	
	/*
	public BarrierGate getBarrierGate() {
		return barrierGate;
	}

	public void setBarrierGate(BarrierGate barrierGate) {
		this.barrierGate = barrierGate;
	}*/

	
	
	@Override
	public String toString() {
		return "Station [action_s=" + action_s + ", cost_i=" + cost_i
				+ ", createDate_t=" + createDate_t + ", createUser_s="
				+ createUser_s + ", customerName_s=" + customerName_s
				+ ", endEDate=" + endEDate + ", endSDate=" + endSDate
				+ ", facilityID_s=" + facilityID_s + ", facilityName="
				+ facilityName + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", manualCPG="
				+ manualCPG + ", mappingSerialNumber_s="
				+ mappingSerialNumber_s + ", orderID_s=" + orderID_s
				+ ", orderName=" + orderName + ", preIncludeTime_i="
				+ preIncludeTime_i + ", receptionOrder=" + receptionOrder
				+ ", recordDate_d=" + recordDate_d + ", recordDate_s="
				+ recordDate_s + ", resaveds1_s=" + resaveds1_s
				+ ", resaveds2_s=" + resaveds2_s + ", resaveds3_s="
				+ resaveds3_s + ", resaveds4_s=" + resaveds4_s
				+ ", resaveds5_s=" + resaveds5_s + ", roadInfo=" + roadInfo
				+ ", serialNumber_s=" + serialNumber_s + ", spanMinute_i="
				+ spanMinute_i + ", startEDate=" + startEDate + ", startSDate="
				+ startSDate + ", vehicleCPG_s=" + vehicleCPG_s
				+ ", vehicleID_s=" + vehicleID_s + ", wholeIncludeTime_i="
				+ wholeIncludeTime_i + "]";
	}
	
	
	public String getCurrent() {
		return current;
	}


	public void setCurrent(String current) {
		this.current = current;
	}


	public String getRecordDate_s() {
		return recordDate_s;
	}


	public void setRecordDate_s(String recordDateS) {
		recordDate_s = recordDateS;
	}


	public String getManualCPG() {
		return manualCPG;
	}

	public void setManualCPG(String manualCPG) {
		this.manualCPG = manualCPG;
	}

	public String getCustomerName_s() {
		return customerName_s;
	}

	public void setCustomerName_s(String customerNameS) {
		customerName_s = customerNameS;
	}

	public String getStartSDate() {
		return startSDate;
	}

	public void setStartSDate(String startSDate) {
		this.startSDate = startSDate;
	}

	 
	public String getEndSDate() {
		return endSDate;
	}

	public void setEndSDate(String endSDate) {
		this.endSDate = endSDate;
	}

	 
	public String getStartEDate() {
		return startEDate;
	}

	public void setStartEDate(String startEDate) {
		this.startEDate = startEDate;
	}

	public String getEndEDate() {
		return endEDate;
	}

	public void setEndEDate(String endEDate) {
		this.endEDate = endEDate;
	}

	public RoadInfo getRoadInfo() {
		return roadInfo;
	}

	public void setRoadInfo(RoadInfo roadInfo) {
		this.roadInfo = roadInfo;
	}

	public ReceptionOrder getReceptionOrder() {
		return receptionOrder;
	}

	public void setReceptionOrder(ReceptionOrder receptionOrder) {
		this.receptionOrder = receptionOrder;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Integer getSpanMinute_i() {
		return spanMinute_i;
	}

	public void setSpanMinute_i(Integer spanMinuteI) {
		spanMinute_i = spanMinuteI;
	}

	public Double getCost_i() {
		return cost_i;
	}

	public void setCost_i(Double costI) {
		cost_i = costI;
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

	public Date getRecordDate_d() {
		return recordDate_d;
	}

	public void setRecordDate_d(Date recordDate_d) {
		this.recordDate_d = recordDate_d;
	}

	public Integer getAction_s() {
		return action_s;
	}

	public void setAction_s(Integer action_s) {
		this.action_s = action_s;
	}

	public String getMappingSerialNumber_s() {
		return mappingSerialNumber_s;
	}

	public void setMappingSerialNumber_s(String mappingSerialNumber_s) {
		this.mappingSerialNumber_s = mappingSerialNumber_s;
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

	public Date getCreateDate_t() {
		return createDate_t;
	}

	public void setCreateDate_t(Date createDate_t) {
		this.createDate_t = createDate_t;
	}

	public String getCreateUser_s() {
		return createUser_s;
	}

	public void setCreateUser_s(String createUser_s) {
		this.createUser_s = createUser_s;
	}

	public String getLastUpdateUser_s() {
		return lastUpdateUser_s;
	}

	public void setLastUpdateUser_s(String lastUpdateUser_s) {
		this.lastUpdateUser_s = lastUpdateUser_s;
	}

	public Date getLastUpdateDate_t() {
		return lastUpdateDate_t;
	}

	public void setLastUpdateDate_t(Date lastUpdateDate_t) {
		this.lastUpdateDate_t = lastUpdateDate_t;
	}

	public String getResaveds1_s() {
		return resaveds1_s;
	}

	public void setResaveds1_s(String resaveds1_s) {
		this.resaveds1_s = resaveds1_s;
	}

	public String getResaveds2_s() {
		return resaveds2_s;
	}

	public void setResaveds2_s(String resaveds2_s) {
		this.resaveds2_s = resaveds2_s;
	}

	public String getResaveds3_s() {
		return resaveds3_s;
	}

	public void setResaveds3_s(String resaveds3_s) {
		this.resaveds3_s = resaveds3_s;
	}

	public String getResaveds4_s() {
		return resaveds4_s;
	}

	public void setResaveds4_s(String resaveds4_s) {
		this.resaveds4_s = resaveds4_s;
	}

	public String getResaveds5_s() {
		return resaveds5_s;
	}

	public void setResaveds5_s(String resaveds5_s) {
		this.resaveds5_s = resaveds5_s;
	}


	public Integer getWholeIncludeTime_i() {
		return wholeIncludeTime_i;
	}


	public void setWholeIncludeTime_i(Integer wholeIncludeTimeI) {
		wholeIncludeTime_i = wholeIncludeTimeI;
	}


	public Integer getPreIncludeTime_i() {
		return preIncludeTime_i;
	}


	public void setPreIncludeTime_i(Integer preIncludeTimeI) {
		preIncludeTime_i = preIncludeTimeI;
	}

}
