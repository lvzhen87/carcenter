package com.freshen.entity.process;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

/**
 * TProcessInterphoneemployinfo entity. @author MyEclipse Persistence Tools
 */

public class TProcessInterphoneemployinfo  extends  BeanModel{

	// Fields

	private String processID;
	private String interphoneID_s;
	private Integer operation_i;
	private Date createDate_t;
	private String vehiclecardidS;
	private String usercardIDS;
	private String createuserS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private String resaveds1S;
	private String resaveds2S;
	private String resaveds3S;
	private String resaveds4S;
	private String resaveds5S;

	// Constructors

	
	
	public String getUsercardIDS() {
		return usercardIDS;
	}


	public String getProcessID() {
		return processID;
	}


	public void setProcessID(String processID) {
		this.processID = processID;
	}


	public String getInterphoneID_s() {
		return interphoneID_s;
	}


	public void setInterphoneID_s(String interphoneID_s) {
		this.interphoneID_s = interphoneID_s;
	}


	


	public Integer getOperation_i() {
		return operation_i;
	}


	public void setOperation_i(Integer operation_i) {
		this.operation_i = operation_i;
	}


	public Date getCreateDate_t() {
		return createDate_t;
	}


	public void setCreateDate_t(Date createDate_t) {
		this.createDate_t = createDate_t;
	}


	public void setUsercardIDS(String usercardIDS) {
		this.usercardIDS = usercardIDS;
	}


	
	public String getVehiclecardidS() {
		return this.vehiclecardidS;
	}

	public void setVehiclecardidS(String vehiclecardidS) {
		this.vehiclecardidS = vehiclecardidS;
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

}