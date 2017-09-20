package com.freshen.entity.basis;

import java.util.Date;
import java.util.Set;

import com.freshen.clims.baseclass.BeanModel;

public class RoadInfo  extends  BeanModel{

	private static final long serialVersionUID = 1L;
	
	String roadID_s,roadName_s,technicalParameters_s,remark_s,createUser_s,lastUpdateUser_s;
	Integer maxCapacity_i,state_i;
	Date inputDate_t,createDate_t,lastUpdateDate_t;
	String resaveds2_s,resaveds3_s,resaveds4_s,	resaveds5_s;
	String types;//记录试验类型字符串，不在数据库，逻辑字段
	String roadType_s;	//标识 该条道路 出现在何种 预约模式下
	
	private Set<RoadExperimentType> roadExperimentTypeSet; //one-to-many 道路试验类型基础信息表
	
	private Set<BarrierGate> BarrierGateEnter;
	
	private Set<BarrierGate> BarrierGateOut;
	
	Double overproofUnitPrie_i; //大于3.5 吨&两轴,按小时算
	Double unitPrie_i;	   //小于3.5 吨&两轴,按小时算
	
	private RoadCost roadCost;
	
	Integer beginningDay_i;
	
	String resaveds1_s;		//	道路分组

	
	
	public static long getSerialVersionUID() {
			           
		return serialVersionUID;
	}
	public Integer getBeginningDay_i() {
		return beginningDay_i;
	}
	public void setBeginningDay_i(Integer beginningDay_i) {
		this.beginningDay_i = beginningDay_i;
	}
	public RoadCost getRoadCost() {
		return roadCost;
	}
	public void setRoadCost(RoadCost roadCost) {
		this.roadCost = roadCost;
	}
	public Double getOverproofUnitPrie_i() {
		return overproofUnitPrie_i;
	}
	public void setOverproofUnitPrie_i(Double overproofUnitPrieI) {
		overproofUnitPrie_i = overproofUnitPrieI;
	}
	public Double getUnitPrie_i() {
		return unitPrie_i;
	}
	public void setUnitPrie_i(Double unitPrieI) {
		unitPrie_i = unitPrieI;
	}
	public String getRoadType_s() {
		return roadType_s;
	}
	public void setRoadType_s(String roadType_s) {
		this.roadType_s = roadType_s;
	}
	public Set<BarrierGate> getBarrierGateEnter() {
		return BarrierGateEnter;
	}
	public void setBarrierGateEnter(Set<BarrierGate> barrierGateEnter) {
		BarrierGateEnter = barrierGateEnter;
	}
	public Set<BarrierGate> getBarrierGateOut() {
		return BarrierGateOut;
	}
	public void setBarrierGateOut(Set<BarrierGate> barrierGateOut) {
		BarrierGateOut = barrierGateOut;
	}
	public Set<RoadExperimentType> getRoadExperimentTypeSet() {
		return roadExperimentTypeSet;
	}
	public void setRoadExperimentTypeSet(
			Set<RoadExperimentType> roadExperimentTypeSet) {
		this.roadExperimentTypeSet = roadExperimentTypeSet;
	}
	
	
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
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
	public String getTechnicalParameters_s() {
		return technicalParameters_s;
	}
	public void setTechnicalParameters_s(String technicalParameters_s) {
		this.technicalParameters_s = technicalParameters_s;
	}
	public String getRemark_s() {
		return remark_s;
	}
	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
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
	public Integer getMaxCapacity_i() {
		return maxCapacity_i;
	}
	public void setMaxCapacity_i(Integer maxCapacity_i) {
		this.maxCapacity_i = maxCapacity_i;
	}
	public Integer getState_i() {
		return state_i;
	}
	public void setState_i(Integer state_i) {
		this.state_i = state_i;
	}
	public Date getInputDate_t() {
		return inputDate_t;
	}
	public void setInputDate_t(Date inputDate_t) {
		this.inputDate_t = inputDate_t;
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
		return "RoadInfo [roadID_s=" + roadID_s + ", roadName_s=" + roadName_s
				+ ", technicalParameters_s=" + technicalParameters_s
				+ ", remark_s=" + remark_s + ", createUser_s=" + createUser_s
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", maxCapacity_i="
				+ maxCapacity_i + ", state_i=" + state_i + ", inputDate_t="
				+ inputDate_t + ", createDate_t=" + createDate_t
				+ ", lastUpdateDate_t=" + lastUpdateDate_t + ", resaveds1_s="
				+ resaveds1_s + ", resaveds2_s=" + resaveds2_s
				+ ", resaveds3_s=" + resaveds3_s + ", resaveds4_s="
				+ resaveds4_s + ", resaveds5_s=" + resaveds5_s + "]";
	}
	

}
