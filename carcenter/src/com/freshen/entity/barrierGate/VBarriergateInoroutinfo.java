package com.freshen.entity.barrierGate;

import com.freshen.util.ConstantUtil;


/**
 * VBarriergateInoroutinfo entity. 
 */

public class VBarriergateInoroutinfo implements java.io.Serializable {

	// Fields

	private String cardidS;
	private String barriergateidS;
	private String createtimeS;
	private String motionS;
	private String motionChinaS;
	private Integer isokI ;
	private String eventnumberS;
	private String editflagtimeS;
	private String editflagEndtimeS;
	private String roadidS;
	private String roadtypeS;
	private String roadnameS;
	private String orderidS;
	private String ordernameS;
	private String customernameS;
	//private String resaveds2_s;
	private String resaveds3_s;
	private String resaveds4_s;
	private String speedtype_s;
	
	
	public String getSpeedtype_s() {
		return speedtype_s;
	}
	public void setSpeedtype_s(String speedtypeS) {
		speedtype_s = speedtypeS;
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
	public String getEditflagEndtimeS() {
		return editflagEndtimeS;
	}
	public void setEditflagEndtimeS(String editflagEndtimeS) {
		this.editflagEndtimeS = editflagEndtimeS;
	}
	 
	public String getCardidS() {
		return cardidS;
	}
	public void setCardidS(String cardidS) {
		this.cardidS = cardidS;
	}
	public String getBarriergateidS() {
		return barriergateidS;
	}
	public void setBarriergateidS(String barriergateidS) {
		this.barriergateidS = barriergateidS;
	}
	public String getCreatetimeS() {
		return createtimeS;
	}
	public void setCreatetimeS(String createtimeS) {
		this.createtimeS = createtimeS;
	}
	public String getMotionS() {
		return motionS;
	}
	public void setMotionS(String motionS) {
		if(motionS!=null){
			this.motionChinaS=(String)(ConstantUtil.MONTIOSMappingTable.get(motionS));
		}
		this.motionS = motionS;
	}
	
	public String getMotionChinaS() {
		return motionChinaS;
	}
	public void setMotionChinaS(String motionChinaS) {
		this.motionChinaS = motionChinaS;
	}
	public Integer getIsokI() {
		return isokI;
	}
	public void setIsokI(Integer isokI) {
		this.isokI = isokI;
	}
	public String getEventnumberS() {
		return eventnumberS;
	}
	public void setEventnumberS(String eventnumberS) {
		this.eventnumberS = eventnumberS;
	}
	public String getEditflagtimeS() {
		return editflagtimeS;
	}
	public void setEditflagtimeS(String editflagtimeS) {
		this.editflagtimeS = editflagtimeS;
	}
	public String getRoadidS() {
		return roadidS;
	}
	public void setRoadidS(String roadidS) {
		this.roadidS = roadidS;
	}
	public String getRoadtypeS() {
		return roadtypeS;
	}
	public void setRoadtypeS(String roadtypeS) {
		this.roadtypeS = roadtypeS;
	}
	public String getRoadnameS() {
		return roadnameS;
	}
	public void setRoadnameS(String roadnameS) {
		this.roadnameS = roadnameS;
	}
	public String getOrderidS() {
		return orderidS;
	}
	public void setOrderidS(String orderidS) {
		this.orderidS = orderidS;
	}
	public String getOrdernameS() {
		return ordernameS;
	}
	public void setOrdernameS(String ordernameS) {
		this.ordernameS = ordernameS;
	}
	public String getCustomernameS() {
		return customernameS;
	}
	public void setCustomernameS(String customernameS) {
		this.customernameS = customernameS;
	}
	 
	public String toString() {
		return "VBarriergateInoroutinfo [barriergateidS=" + barriergateidS
				+ ", cardidS=" + cardidS + ", createtimeS=" + createtimeS
				+ ", customernameS=" + customernameS + ", editflagtimeS="
				+ editflagtimeS + ", eventnumberS=" + eventnumberS + ", isokI="
				+ isokI + ", motionS=" + motionS + ", orderidS=" + orderidS
				+ ", ordernameS=" + ordernameS + ",  "
				+ ", roadidS=" + roadidS + ", roadnameS=" + roadnameS
				+ ", roadtypeS=" + roadtypeS + "]";
	}

	
}