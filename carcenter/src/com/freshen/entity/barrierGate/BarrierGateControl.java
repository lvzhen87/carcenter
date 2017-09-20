package com.freshen.entity.barrierGate;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class BarrierGateControl  extends  BeanModel{
	String eventNumber_s;
	String barrierGateID_s;
	Date createTime_t;
	String schema_s;
	Integer isEfficiency_i;
	public String getEventNumber_s() {
		return eventNumber_s;
	}
	public void setEventNumber_s(String eventNumber_s) {
		this.eventNumber_s = eventNumber_s;
	}
	public String getBarrierGateID_s() {
		return barrierGateID_s;
	}
	public void setBarrierGateID_s(String barrierGateID_s) {
		this.barrierGateID_s = barrierGateID_s;
	}
	public Date getCreateTime_t() {
		return createTime_t;
	}
	public void setCreateTime_t(Date createTime_t) {
		this.createTime_t = createTime_t;
	}
	public String getSchema_s() {
		return schema_s;
	}
	public void setSchema_s(String schema_s) {
		this.schema_s = schema_s;
	}
	public Integer getIsEfficiency_i() {
		return isEfficiency_i;
	}
	public void setIsEfficiency_i(Integer isEfficiency_i) {
		this.isEfficiency_i = isEfficiency_i;
	}

	
}
