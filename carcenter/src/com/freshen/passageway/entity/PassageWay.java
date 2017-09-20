package com.freshen.passageway.entity;

import java.util.Date;

public class PassageWay {
	Integer id;
	Integer passageWayId;
	String name;
	Integer inout;
	Integer usedFlag;
	Date editFlagtime_t;
	Integer istreament_i;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPassageWayId() {
		return passageWayId;
	}
	public void setPassageWayId(Integer passageWayId) {
		this.passageWayId = passageWayId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInout() {
		return inout;
	}
	public void setInout(Integer inout) {
		this.inout = inout;
	}
	public Integer getUsedFlag() {
		return usedFlag;
	}
	public void setUsedFlag(Integer usedFlag) {
		this.usedFlag = usedFlag;
	}

	public Date getEditFlagtime_t() {
		return editFlagtime_t;
	}
	public void setEditFlagtime_t(Date editFlagtime_t) {
		this.editFlagtime_t = editFlagtime_t;
	}
	public Integer getIstreament_i() {
		return istreament_i;
	}
	public void setIstreament_i(Integer istreament_i) {
		this.istreament_i = istreament_i;
	}
	
}
