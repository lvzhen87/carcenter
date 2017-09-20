package com.freshen.entity.oneCard;

import java.math.BigDecimal;
import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

/**
 * TOnecardMjreguserBak entity. @author MyEclipse Persistence Tools
 */

public class TOnecardMjreguserBak extends BeanModel {

	// Fields

	private String recordidS;
	private String sysnoS;
	private String serialS;
	private Integer devicesysidI;
	private String doorcodeS;
	private String isdownS;
	private Date editFlagTimeT;//操作时间 oracle 中有，sql中没有
	private Date endtime;//失效时间
	private Date starttime;//失效时间
	private String dptid;//所属部门
	private String pass;
	private String groupList;
	
	
	// Constructors

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGroupList() {
		return groupList;
	}

	public void setGroupList(String groupList) {
		this.groupList = groupList;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getDptid() {
		return dptid;
	}

	public void setDptid(String dptid) {
		this.dptid = dptid;
	}

	/** default constructor */
	public TOnecardMjreguserBak() {
	}

	/** minimal constructor */
	 
	/** full constructor */
	public TOnecardMjreguserBak(String recordidS, String sysnoS,
			String serialS, Integer devicesysidI, String doorcodeS,
			String isdownS) {
		this.recordidS = recordidS;
		this.sysnoS = sysnoS;
		this.serialS = serialS;
		this.devicesysidI = devicesysidI;
		this.doorcodeS = doorcodeS;
		this.isdownS = isdownS;
	}

	// Property accessors

	 
	public Date getEditFlagTimeT() {
		return editFlagTimeT;
	}

	public void setEditFlagTimeT(Date editFlagTimeT) {
		this.editFlagTimeT = editFlagTimeT;
	}

	public String getSysnoS() {
		return this.sysnoS;
	}

	public void setSysnoS(String sysnoS) {
		this.sysnoS = sysnoS;
	}

	public String getSerialS() {
		return this.serialS;
	}

	public void setSerialS(String serialS) {
		this.serialS = serialS;
	}

	 

	@Override
	public String toString() {
		return "TOnecardMjreguserBak [devicesysidI=" + devicesysidI
				+ ", doorcodeS=" + doorcodeS + ", editFlagTimeT="
				+ editFlagTimeT + ", isdownS=" + isdownS + ", recordidS="
				+ recordidS + ", serialS=" + serialS + ", sysnoS=" + sysnoS
				+ "]";
	}

	 

	public String getRecordidS() {
		return recordidS;
	}

	public void setRecordidS(String recordidS) {
		this.recordidS = recordidS;
	}

	public Integer getDevicesysidI() {
		return devicesysidI;
	}

	public void setDevicesysidI(Integer devicesysidI) {
		this.devicesysidI = devicesysidI;
	}

	public String getDoorcodeS() {
		return this.doorcodeS;
	}

	public void setDoorcodeS(String doorcodeS) {
		this.doorcodeS = doorcodeS;
	}

	public String getIsdownS() {
		return this.isdownS;
	}

	public void setIsdownS(String isdownS) {
		this.isdownS = isdownS;
	}

}