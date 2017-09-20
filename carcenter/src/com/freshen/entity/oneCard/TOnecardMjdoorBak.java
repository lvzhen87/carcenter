package com.freshen.entity.oneCard;

import java.math.BigDecimal;
import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

/**
 * TOnecardMjdoorBak entity. @author MyEclipse Persistence Tools
 */

public class TOnecardMjdoorBak extends BeanModel {

	// Fields

	private Integer doorIdI;
	private String doorNameS;
	private Integer devicesysidI;
	private Integer channelnumI;
	private Integer isUse_i;//新增字段，1代表要管理的，0代表不需要管理的
	//private String isGroup_s;
	//private Date editFlagTimeT;//操作时间 oracle 中有，sql中没有
	// Constructors

	private String groupId_s;
	
	public String getGroupId_s() {
		return groupId_s;
	}

	public void setGroupId_s(String groupId_s) {
		this.groupId_s = groupId_s;
	}

	/** default constructor */
	public TOnecardMjdoorBak() {
	}

	/** minimal constructor */
	 
	/** full constructor */
	public TOnecardMjdoorBak(Integer doorIdI, String doorNameS,
			Integer devicesysidI, Integer channelnumI,Integer isUse_i,String isGroup_s) {
		this.doorIdI = doorIdI;
		this.doorNameS = doorNameS;
		this.devicesysidI = devicesysidI;
		this.channelnumI = channelnumI;
		this.isUse_i=isUse_i;
		//this.isGroup_s=isGroup_s;
	}

	// Property accessors

	 
	
	public Integer getIsUse_i() {
		return isUse_i;
	}
	public void setIsUse_i(Integer isUse_i) {
		this.isUse_i = isUse_i;
	}
	public String getDoorNameS() {
		return this.doorNameS;
	}

	public void setDoorNameS(String doorNameS) {
		this.doorNameS = doorNameS;
	}

	public Integer getDoorIdI() {
		return doorIdI;
	}

	public void setDoorIdI(Integer doorIdI) {
		this.doorIdI = doorIdI;
	}

	public Integer getDevicesysidI() {
		return devicesysidI;
	}

	public void setDevicesysidI(Integer devicesysidI) {
		this.devicesysidI = devicesysidI;
	}

	public Integer getChannelnumI() {
		return channelnumI;
	}

	public void setChannelnumI(Integer channelnumI) {
		this.channelnumI = channelnumI;
	}

	@Override
	public String toString() {
		return "TOnecardMjdoorBak [doorIdI=" + doorIdI + ", doorNameS="
				+ doorNameS + ", devicesysidI=" + devicesysidI
				+ ", channelnumI=" + channelnumI + ", isUse_i=" + isUse_i
				+ "";
	}

	

}