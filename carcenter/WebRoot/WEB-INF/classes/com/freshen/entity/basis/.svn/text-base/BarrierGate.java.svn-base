package com.freshen.entity.basis;

import java.util.Date;
import com.freshen.clims.baseclass.BeanModel;

public class BarrierGate  extends  BeanModel{

	//String gateID_s, gateType_s, gateCompany_s, entranceRoadIDs,outRoadIsD_s;
	String gateID_s, gateType_s, entranceRoadIDs,outRoadID_s;
	Integer state_i;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	
	//外键关联
	RoadInfo enterroadinfo = new RoadInfo();
	
	RoadInfo outroadinfo = new RoadInfo();
	
	
//	public void setOutroadinfo(RoadInfo outroadinfo) {
//		Session session=HibernateSessionFactory.getSession();
//		if(!session.isOpen()){
//			session= HibernateUtil.getSession();
//		}
//		this.outroadinfo=(RoadInfo)session.get(outroadinfo.getClass(), this.getOutRoadID_s());   
//	}
	
	String gateNumber_s;
	
	

	public String getGateNumber_s() {
		return gateNumber_s;
	}
	public void setGateNumber_s(String gateNumber_s) {
		this.gateNumber_s = gateNumber_s;
	}
	public RoadInfo getEnterroadinfo() {
		return enterroadinfo;
	}
	public void setEnterroadinfo(RoadInfo enterroadinfo) {
		this.enterroadinfo = enterroadinfo;
	}

	public RoadInfo getOutroadinfo() {
		return outroadinfo;
	}

	public void setOutroadinfo(RoadInfo outroadinfo) {
		this.outroadinfo = outroadinfo;
	}

	public String getGateID_s() {
		return gateID_s;
	}

	public void setGateID_s(String gateID_s) {
		this.gateID_s = gateID_s;
	}

	public String getGateType_s() {
		return gateType_s;
	}

	public void setGateType_s(String gateType_s) {
		this.gateType_s = gateType_s;
	}

//	public String getGateCompany_s() {
//		return gateCompany_s;
//	}
//
//	public void setGateCompany_s(String gateCompany_s) {
//		this.gateCompany_s = gateCompany_s;
//	}


	public String getEntranceRoadIDs() {
		return entranceRoadIDs;
	}

	public void setEntranceRoadIDs(String entranceRoadIDs) {
		this.entranceRoadIDs = entranceRoadIDs;
		this.enterroadinfo.setRoadID_s(entranceRoadIDs);
	}

	public String getOutRoadID_s() {
		return outRoadID_s;
	}

	public void setOutRoadID_s(String outRoadID_s) {
		this.outRoadID_s = outRoadID_s;
	}

	 
	public Integer getState_i() {
		return state_i;
	}

	public void setState_i(Integer stateI) {
		state_i = stateI;
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

}