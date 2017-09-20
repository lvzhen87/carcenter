package com.freshen.entity.basis;

import java.io.Serializable;
import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class RoadExperimentType  extends  BeanModel{

	private static final long serialVersionUID = 1L;
	
	String roadID_s;				//	道路编号
	String roadName_s;				//	道路名称
	String experimentTypeID_s;		//	试验类型ID
	String experimentTypeName_s;	//	试验类型名称
	Date createDate_t;				//	创建时间
	Date lastUpdateDate_t;			//	最后修改时间
	String createUser_s;			//	创建人
	String lastUpdateUser_s;		//	最后修改人
	String resaveds1_s;				//	预留1
	String resaveds2_s;				//	预留2
	String resaveds3_s;				//	预留3
	String resaveds4_s;				//	预留4
	String resaveds5_s;				//	预留5
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getRoadID_s() {
		return roadID_s;
	}
	public void setRoadID_s(String roadID_s) {
		this.roadID_s = roadID_s;
	}
	public String getRoadName_s() {
		return roadName_s;
	}
	public void setRoadName_s(String roadName_s) {
		this.roadName_s = roadName_s;
	}
	public String getExperimentTypeID_s() {
		return experimentTypeID_s;
	}
	public void setExperimentTypeID_s(String experimentTypeID_s) {
		this.experimentTypeID_s = experimentTypeID_s;
	}
	public String getExperimentTypeName_s() {
		return experimentTypeName_s;
	}
	public void setExperimentTypeName_s(String experimentTypeName_s) {
		this.experimentTypeName_s = experimentTypeName_s;
	}
	public Date getCreateDate_t() {
		return createDate_t;
	}
	public void setCreateDate_t(Date createDate_t) {
		this.createDate_t = createDate_t;
	}
	public Date getLastUpdateDate_t() {
		return lastUpdateDate_t;
	}
	public void setLastUpdateDate_t(Date lastUpdateDate_t) {
		this.lastUpdateDate_t = lastUpdateDate_t;
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
	@Override
	public String toString() {
		return "RoadExperimentType [roadID_s=" + roadID_s + ", roadName_s="
				+ roadName_s + ", experimentTypeID_s=" + experimentTypeID_s
				+ ", experimentTypeName_s=" + experimentTypeName_s
				+ ", createDate_t=" + createDate_t + ", lastUpdateDate_t="
				+ lastUpdateDate_t + ", createUser_s=" + createUser_s
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", resaveds1_s="
				+ resaveds1_s + ", resaveds2_s=" + resaveds2_s
				+ ", resaveds3_s=" + resaveds3_s + ", resaveds4_s="
				+ resaveds4_s + ", resaveds5_s=" + resaveds5_s + "]";
	}
}
