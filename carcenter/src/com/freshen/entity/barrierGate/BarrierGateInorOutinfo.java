package com.freshen.entity.barrierGate;

import java.util.Date;


import com.freshen.clims.baseclass.BeanModel;

public class BarrierGateInorOutinfo  extends  BeanModel{
	String cardID_s;
	String barrierGateID_s;
	String createTime_s;
	String motion_s;
	Integer Isok_i;
	String eventNumber_s;
	private String resaveds1_s;
	private String resaveds2_s;
	private String resaveds3_s;
	private String resaveds4_s;
	private String resaveds5_s;
	String editflagtime_s;
	String roadID_s;//��·id���ֹ���дʱҳ����Ҫ
	String cpg_s;
	String speedtype_s;//速度类型
	
	
	public String getSpeedtype_s() {
		return speedtype_s;
	}
	public void setSpeedtype_s(String speedtypeS) {
		speedtype_s = speedtypeS;
	}
	public String getEditflagtime_s() {
		return editflagtime_s;
	}
	public void setEditflagtime_s(String editflagtimeS) {
		editflagtime_s = editflagtimeS;
	}
	public String getCpg_s() {
		return cpg_s;
	}
	public void setCpg_s(String cpgS) {
		cpg_s = cpgS;
	}
	public String getRoadID_s() {
		return roadID_s;
	}
	public void setRoadID_s(String roadIDS) {
		roadID_s = roadIDS;
	}
	public String getEventNumber_s() {
		return eventNumber_s;
	}
	public void setEventNumber_s(String eventNumberS) {
		eventNumber_s = eventNumberS;
	}
	public String getCardID_s() {
		return cardID_s;
	}
	public void setCardID_s(String cardIDS) {
		cardID_s = cardIDS;
	}
	public String getBarrierGateID_s() {
		return barrierGateID_s;
	}
	public void setBarrierGateID_s(String barrierGateID_s) {
		this.barrierGateID_s = barrierGateID_s;
	}
	 
	 
	public String getCreateTime_s() {
		return createTime_s;
	}
	public void setCreateTime_s(String createTimeS) {
		createTime_s = createTimeS;
	}
	public String getMotion_s() {
		return motion_s;
	}
	public void setMotion_s(String motionS) {
		motion_s = motionS;
	}
	public Integer getIsok_i() {
		return Isok_i;
	}
	public void setIsok_i(Integer isok_i) {
		Isok_i = isok_i;
	}
	public String getResaveds1_s() {
		return resaveds1_s;
	}
	public void setResaveds1_s(String resaveds1S) {
		resaveds1_s = resaveds1S;
	}
	public String getResaveds2_s() {
		return resaveds2_s;
	}
	public void setResaveds2_s(String resaveds2S) {
		resaveds2_s = resaveds2S;
	}
	public String getResaveds3_s() {
		return resaveds3_s;
	}
	public void setResaveds3_s(String resaveds3S) {
		resaveds3_s = resaveds3S;
	}
	public String getResaveds4_s() {
		return resaveds4_s;
	}
	public void setResaveds4_s(String resaveds4S) {
		resaveds4_s = resaveds4S;
	}
	public String getResaveds5_s() {
		return resaveds5_s;
	}
	public void setResaveds5_s(String resaveds5S) {
		resaveds5_s = resaveds5S;
	}
	@Override
	public String toString() {
		return "BarrierGateInorOutinfo [Isok_i=" + Isok_i
				+ ", barrierGateID_s=" + barrierGateID_s + ", cardID_s="
				+ cardID_s + ", createTime_s=" + createTime_s
				+ ", eventNumber_s=" + eventNumber_s + ", motion_s=" + motion_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + "]";
	}
	
}
