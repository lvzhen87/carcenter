package com.freshen.entity.process;

import java.util.Date;

import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;

/**
 * TProcessWashcarinvalid entity. @author MyEclipse Persistence Tools
 */

public class TProcessWashcarinvalid implements java.io.Serializable {

	// Fields

	private String serialnumberS;
	private String orderidS;
	private Date recorddateT;
	private String vehicleidS;
	private String vehiclecpgS;
	private Date createdateT;
	private String createuserS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private String resaveds1S;
	private String resaveds2S;
	private String resaveds3S;
	private String resaveds4S;
	private String resaveds5S;
	private String facilityID_s;
	String orderName;
	Date startDate_t;//发生开始时间
	Date endDate_t;//发生结束时间
	Date createstartDate_t;//作废开始时间
	Date createendDate_t;//作废结束时间
 	ReceptionOrder receptionOrder;
	RoadInfo roadInfo;
	ReceptionVehicleInfo receptionVehicleInfo;
	String manualCPG;//人工录入CPG
	
	/** default constructor */
	public TProcessWashcarinvalid() {
	}

	/** minimal constructor */
	public TProcessWashcarinvalid(String serialnumberS) {
		this.serialnumberS = serialnumberS;
	}

	/** full constructor */
	public TProcessWashcarinvalid(String serialnumberS, String orderidS,
			Date recorddateT, String vehicleidS, String vehiclecpgS,
			Date createdateT, String createuserS, String lastupdateuserS,
			Date lastupdatedateT, String resaveds1S, String resaveds2S,
			String resaveds3S, String resaveds4S, String resaveds5S) {
		this.serialnumberS = serialnumberS;
		this.orderidS = orderidS;
		this.recorddateT = recorddateT;
		this.vehicleidS = vehicleidS;
		this.vehiclecpgS = vehiclecpgS;
		this.createdateT = createdateT;
		this.createuserS = createuserS;
		this.lastupdateuserS = lastupdateuserS;
		this.lastupdatedateT = lastupdatedateT;
		this.resaveds1S = resaveds1S;
		this.resaveds2S = resaveds2S;
		this.resaveds3S = resaveds3S;
		this.resaveds4S = resaveds4S;
		this.resaveds5S = resaveds5S;
	}

	// Property accessors

	public String getSerialnumberS() {
		return this.serialnumberS;
	}

	public String getFacilityID_s() {
		return facilityID_s;
	}

	public void setFacilityID_s(String facilityIDS) {
		facilityID_s = facilityIDS;
	}

	public String getManualCPG() {
		return manualCPG;
	}

	public void setManualCPG(String manualCPG) {
		this.manualCPG = manualCPG;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public ReceptionOrder getReceptionOrder() {
		return receptionOrder;
	}

	public void setReceptionOrder(ReceptionOrder receptionOrder) {
		this.receptionOrder = receptionOrder;
	}

	public RoadInfo getRoadInfo() {
		return roadInfo;
	}

	public void setRoadInfo(RoadInfo roadInfo) {
		this.roadInfo = roadInfo;
	}

	public ReceptionVehicleInfo getReceptionVehicleInfo() {
		return receptionVehicleInfo;
	}

	public void setReceptionVehicleInfo(ReceptionVehicleInfo receptionVehicleInfo) {
		this.receptionVehicleInfo = receptionVehicleInfo;
	}

	public void setSerialnumberS(String serialnumberS) {
		this.serialnumberS = serialnumberS;
	}

	public String getOrderidS() {
		return this.orderidS;
	}

	public void setOrderidS(String orderidS) {
		this.orderidS = orderidS;
	}

	public Date getRecorddateT() {
		return this.recorddateT;
	}

	public void setRecorddateT(Date recorddateT) {
		this.recorddateT = recorddateT;
	}

	public String getVehicleidS() {
		return this.vehicleidS;
	}

	public void setVehicleidS(String vehicleidS) {
		this.vehicleidS = vehicleidS;
	}

	public String getVehiclecpgS() {
		return this.vehiclecpgS;
	}

	public void setVehiclecpgS(String vehiclecpgS) {
		this.vehiclecpgS = vehiclecpgS;
	}

	public Date getCreatedateT() {
		return this.createdateT;
	}

	public void setCreatedateT(Date createdateT) {
		this.createdateT = createdateT;
	}

	public String getCreateuserS() {
		return this.createuserS;
	}

	public void setCreateuserS(String createuserS) {
		this.createuserS = createuserS;
	}

	public String getLastupdateuserS() {
		return this.lastupdateuserS;
	}

	public void setLastupdateuserS(String lastupdateuserS) {
		this.lastupdateuserS = lastupdateuserS;
	}

	public Date getLastupdatedateT() {
		return this.lastupdatedateT;
	}

	public void setLastupdatedateT(Date lastupdatedateT) {
		this.lastupdatedateT = lastupdatedateT;
	}

	public String getResaveds1S() {
		return this.resaveds1S;
	}

	public void setResaveds1S(String resaveds1S) {
		this.resaveds1S = resaveds1S;
	}

	public String getResaveds2S() {
		return this.resaveds2S;
	}

	public void setResaveds2S(String resaveds2S) {
		this.resaveds2S = resaveds2S;
	}

	public String getResaveds3S() {
		return this.resaveds3S;
	}

	public void setResaveds3S(String resaveds3S) {
		this.resaveds3S = resaveds3S;
	}

	public String getResaveds4S() {
		return this.resaveds4S;
	}

	public void setResaveds4S(String resaveds4S) {
		this.resaveds4S = resaveds4S;
	}

	public String getResaveds5S() {
		return this.resaveds5S;
	}

	public void setResaveds5S(String resaveds5S) {
		this.resaveds5S = resaveds5S;
	}

	public Date getStartDate_t() {
		return startDate_t;
	}

	public void setStartDate_t(Date startDateT) {
		startDate_t = startDateT;
	}

	public Date getEndDate_t() {
		return endDate_t;
	}

	public void setEndDate_t(Date endDateT) {
		endDate_t = endDateT;
	}

	public Date getCreatestartDate_t() {
		return createstartDate_t;
	}

	public void setCreatestartDate_t(Date createstartDateT) {
		createstartDate_t = createstartDateT;
	}

	public Date getCreateendDate_t() {
		return createendDate_t;
	}

	public void setCreateendDate_t(Date createendDateT) {
		createendDate_t = createendDateT;
	}

	
}