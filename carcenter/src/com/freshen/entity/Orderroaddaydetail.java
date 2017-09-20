package com.freshen.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.basis.RoadExperimentType;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.util.DateUtil;

public class Orderroaddaydetail  extends  BeanModel{
	private String orderroadidS     ;
	private String orderidS         ;
	private Integer statusI          ;
	private Date dateT            ;
	private Date dateTStr;	//EL表达式，提取 日期字符串，不需要时间
	private String typeS            ;
	private String roadidS          ;
	private String roadnameS        ;
	private String hoursnumberS     ;
	private Integer carnumberI       ;
	private String maxspeedS        ;
	private String descriptionS     ;
	private Date createdateT      ;
	private String createuserS      ;
	private String lastupdateuserS  ;
	private Date lastupdatedateT  ;
	private String resaveds1S       ;
	private String resaveds2S       ;
	private String resaveds3S       ;
	private String resaveds4S       ;
	private String resaveds5S       ;
	private Integer maxCapacity_i;
	private Integer isok;
	private String  occupy_s;       //道路占用信息字符串 kxc
	
	private String experimentTypeID_s;//试验类型ID
	
	RoadExperimentType roadExperimentTypeModel = new RoadExperimentType();//道路试验类型基础信息表
	Integer billingMode_i;//计费方式 1按时间计费，2按里程计费
	String carIndex_s;//车辆序号
	String carCPG_s;//试验车辆的CPG牌照号
	
	
	public String getCarIndex_s() {
		return carIndex_s;
	}
	public void setCarIndex_s(String carIndex_s) {
		this.carIndex_s = carIndex_s;
	}
	public String getCarCPG_s() {
		return carCPG_s;
	}
	public void setCarCPG_s(String carCPG_s) {
		this.carCPG_s = carCPG_s;
	}
	public Integer getBillingMode_i() {
		return billingMode_i;
	}
	public void setBillingMode_i(Integer billingModeI) {
		billingMode_i = billingModeI;
	}
	public String getExperimentTypeID_s() {
		return experimentTypeID_s;
	}
	public void setExperimentTypeID_s(String experimentTypeID_s) {
		this.experimentTypeID_s = experimentTypeID_s;
		if(experimentTypeID_s!=null&&!experimentTypeID_s.trim().equals("")){
			setRoadExperimentType();
		}
	}
	public RoadExperimentType getRoadExperimentTypeModel() {
		return roadExperimentTypeModel;
	}
	public void setRoadExperimentTypeModel(RoadExperimentType roadExperimentTypeModel) {
		this.roadExperimentTypeModel = roadExperimentTypeModel;		
	}
	

	public String getOccupy_s() {
		return occupy_s;
	}
	public void setOccupy_s(String occupyS) {
		occupy_s = occupyS;
	}
	public void setDateTStr(Date dateTStr) {
		this.dateTStr = dateTStr;
	}
	public Integer getMaxCapacity_i() {
		return maxCapacity_i;
	}
	public void setMaxCapacity_i(Integer maxCapacityI) {
		maxCapacity_i = maxCapacityI;
	}
	public Integer getIsok() {
		return isok;
	}
	public void setIsok(Integer isok) {
		this.isok = isok;
	}
	public String getOrderroadidS() {
		return orderroadidS;
	}
	public void setOrderroadidS(String orderroadidS) {
		this.orderroadidS = orderroadidS;
	}
	public String getOrderidS() {
		return orderidS;
	}
	public void setOrderidS(String orderidS) {
		this.orderidS = orderidS;
	}
	public Integer getStatusI() {
		return statusI;
	}
	public void setStatusI(Integer statusI) {
		this.statusI = statusI;
	}
	public Date getDateT() {
		return dateT;
	}
	public void setDateT(Date dateT) {
		this.dateT = dateT;
	}
	public String getTypeS() {
		return typeS;
	}
	public void setTypeS(String typeS) {
		this.typeS = typeS;
	}
	public String getRoadidS() {
		return roadidS;
	}
	public void setRoadidS(String roadidS) {
		this.roadidS = roadidS;
		if(roadidS!=null&&!roadidS.trim().equals("")){
			setRoadExperimentType();
		}
	}
	public String getRoadnameS() {
		return roadnameS;
	}
	public void setRoadnameS(String roadnameS) {
		this.roadnameS = roadnameS;
	}
	public String getHoursnumberS() {
		return hoursnumberS;
	}
	public void setHoursnumberS(String hoursnumberS) {
		this.hoursnumberS = hoursnumberS;
	}
	public Integer getCarnumberI() {
		return carnumberI;
	}
	public void setCarnumberI(Integer carnumberI) {
		this.carnumberI = carnumberI;
	}
	public String getMaxspeedS() {
		return maxspeedS;
	}
	public void setMaxspeedS(String maxspeedS) {
		this.maxspeedS = maxspeedS;
	}
	public String getDescriptionS() {
		return descriptionS;
	}
	public void setDescriptionS(String descriptionS) {
		this.descriptionS = descriptionS;
	}
	 
	public Date getCreatedateT() {
		return createdateT;
	}
	public void setCreatedateT(Date createdateT) {
		this.createdateT = createdateT;
	}
	public String getCreateuserS() {
		return createuserS;
	}
	public void setCreateuserS(String createuserS) {
		this.createuserS = createuserS;
	}
	public String getLastupdateuserS() {
		return lastupdateuserS;
	}
	public void setLastupdateuserS(String lastupdateuserS) {
		this.lastupdateuserS = lastupdateuserS;
	}
	 
	public Date getLastupdatedateT() {
		return lastupdatedateT;
	}
	public void setLastupdatedateT(Date lastupdatedateT) {
		this.lastupdatedateT = lastupdatedateT;
	}
	public String getResaveds1S() {
		return resaveds1S;
	}
	public void setResaveds1S(String resaveds1s) {
		resaveds1S = resaveds1s;
	}
	public String getResaveds2S() {
		return resaveds2S;
	}
	public void setResaveds2S(String resaveds2s) {
		resaveds2S = resaveds2s;
	}
	public String getResaveds3S() {
		return resaveds3S;
	}
	public void setResaveds3S(String resaveds3s) {
		resaveds3S = resaveds3s;
	}
	public String getResaveds4S() {
		return resaveds4S;
	}
	public void setResaveds4S(String resaveds4s) {
		resaveds4S = resaveds4s;
	}
	public String getResaveds5S() {
		return resaveds5S;
	}

	public void setResaveds5S(String resaveds5s) {
		resaveds5S = resaveds5s;
	}
	public String getDateTStr() {
		return DateUtil.dateToString(dateT, "yyyy-MM-dd");
	}
	@Override
	public String toString() {
		return "Orderroaddaydetail [orderroadidS=" + orderroadidS
				+ ", orderidS=" + orderidS + ", statusI=" + statusI
				+ ", dateT=" + dateT + ", dateTStr=" + dateTStr + ", typeS="
				+ typeS + ", roadidS=" + roadidS + ", roadnameS=" + roadnameS
				+ ", hoursnumberS=" + hoursnumberS + ", carnumberI="
				+ carnumberI + ", maxspeedS=" + maxspeedS + ", descriptionS="
				+ descriptionS + ", createdateT=" + createdateT
				+ ", createuserS=" + createuserS + ", lastupdateuserS="
				+ lastupdateuserS + ", lastupdatedateT=" + lastupdatedateT
				+ ", resaveds1S=" + resaveds1S + ", resaveds2S=" + resaveds2S
				+ ", resaveds3S=" + resaveds3S + ", resaveds4S=" + resaveds4S
				+ ", resaveds5S=" + resaveds5S + ", maxCapacity_i="
				+ maxCapacity_i + ", isok=" + isok + ", occupy_s=" + occupy_s
				+ ", experimentTypeID_s=" + experimentTypeID_s
				+ ", roadExperimentTypeModel=" + roadExperimentTypeModel + "]";
	}
	public void setRoadExperimentType (){
		Session session=HibernateSessionFactory.getSession();
		if(roadidS != null && !roadidS.trim().equals("") && experimentTypeID_s != null && !experimentTypeID_s.trim().equals("")){
			RoadExperimentType reType = new RoadExperimentType();
			reType.setRoadID_s(roadidS);
			reType.setExperimentTypeID_s(experimentTypeID_s);
			roadExperimentTypeModel = (RoadExperimentType)session.get(roadExperimentTypeModel.getClass(), reType);	    	 
			//System.out.println(roadExperimentTypeModel);
		} 
	}
	
}
