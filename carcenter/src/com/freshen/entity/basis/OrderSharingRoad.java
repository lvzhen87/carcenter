package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class OrderSharingRoad  extends  BeanModel{

	String orderSharingRoadID_s;
	String orderID_s;
	Integer status_i;
	String roadID_s;
	String roadName_s;
	String hoursNumber_s;
	String maxSpeed_s ;
	String description_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	Date startDate_t;
	Date endDate_t;
	Integer carNumber_i;
	Integer isHighRiskTest_i;
	String highRiskTestDescription_s;
	Integer isCamera_i;
	String accidentPrevention_s;
	
	
	public String getOrderSharingRoadID_s() {
		return orderSharingRoadID_s;
	}
	public void setOrderSharingRoadID_s(String orderSharingRoadID_s) {
		this.orderSharingRoadID_s = orderSharingRoadID_s;
	}
	public String getOrderID_s() {
		return orderID_s;
	}
	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}
	public Integer getStatus_i() {
		return status_i;
	}
	public void setStatus_i(Integer status_i) {
		this.status_i = status_i;
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
	public String getHoursNumber_s() {
		return hoursNumber_s;
	}
	public void setHoursNumber_s(String hoursNumber_s) {
		this.hoursNumber_s = hoursNumber_s;
	}
	public String getMaxSpeed_s() {
		return maxSpeed_s;
	}
	public void setMaxSpeed_s(String maxSpeed_s) {
		this.maxSpeed_s = maxSpeed_s;
	}
	public String getDescription_s() {
		return description_s;
	}
	public void setDescription_s(String description_s) {
		this.description_s = description_s;
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
	public Date getStartDate_t() {
		return startDate_t;
	}
	public void setStartDate_t(Date startDate_t) {
		this.startDate_t = startDate_t;
	}
	public Date getEndDate_t() {
		return endDate_t;
	}
	public void setEndDate_t(Date endDate_t) {
		this.endDate_t = endDate_t;
	}
	public Integer getCarNumber_i() {
		return carNumber_i;
	}
	public void setCarNumber_i(Integer carNumber_i) {
		this.carNumber_i = carNumber_i;
	}
	public Integer getIsHighRiskTest_i() {
		return isHighRiskTest_i;
	}
	public void setIsHighRiskTest_i(Integer isHighRiskTest_i) {
		this.isHighRiskTest_i = isHighRiskTest_i;
	}
	public String getHighRiskTestDescription_s() {
		return highRiskTestDescription_s;
	}
	public void setHighRiskTestDescription_s(String highRiskTestDescription_s) {
		this.highRiskTestDescription_s = highRiskTestDescription_s;
	}
	public Integer getIsCamera_i() {
		return isCamera_i;
	}
	public void setIsCamera_i(Integer isCamera_i) {
		this.isCamera_i = isCamera_i;
	}
	public String getAccidentPrevention_s() {
		return accidentPrevention_s;
	}
	public void setAccidentPrevention_s(String accidentPrevention_s) {
		this.accidentPrevention_s = accidentPrevention_s;
	}
	@Override
	public String toString() {
		return "OrderSharingRoad [orderSharingRoadID_s=" + orderSharingRoadID_s
				+ ", orderID_s=" + orderID_s + ", status_i=" + status_i
				+ ", roadID_s=" + roadID_s + ", roadName_s=" + roadName_s
				+ ", hoursNumber_s=" + hoursNumber_s + ", maxSpeed_s="
				+ maxSpeed_s + ", description_s=" + description_s
				+ ", createDate_t=" + createDate_t + ", createUser_s="
				+ createUser_s + ", lastUpdateUser_s=" + lastUpdateUser_s
				+ ", lastUpdateDate_t=" + lastUpdateDate_t + ", resaveds1_s="
				+ resaveds1_s + ", resaveds2_s=" + resaveds2_s
				+ ", resaveds3_s=" + resaveds3_s + ", resaveds4_s="
				+ resaveds4_s + ", resaveds5_s=" + resaveds5_s
				+ ", startDate_t=" + startDate_t + ", endDate_t=" + endDate_t
				+ ", carNumber_i=" + carNumber_i + ", isHighRiskTest_i="
				+ isHighRiskTest_i + ", highRiskTestDescription_s="
				+ highRiskTestDescription_s + ", isCamera_i=" + isCamera_i
				+ ", accidentPrevention_s=" + accidentPrevention_s
				+ ", getOrderSharingRoadID_s()=" + getOrderSharingRoadID_s()
				+ ", getOrderID_s()=" + getOrderID_s() + ", getStatus_i()="
				+ getStatus_i() + ", getRoadID_s()=" + getRoadID_s()
				+ ", getRoadName_s()=" + getRoadName_s()
				+ ", getHoursNumber_s()=" + getHoursNumber_s()
				+ ", getMaxSpeed_s()=" + getMaxSpeed_s()
				+ ", getDescription_s()=" + getDescription_s()
				+ ", getCreateDate_t()=" + getCreateDate_t()
				+ ", getCreateUser_s()=" + getCreateUser_s()
				+ ", getLastUpdateUser_s()=" + getLastUpdateUser_s()
				+ ", getLastUpdateDate_t()=" + getLastUpdateDate_t()
				+ ", getResaveds1_s()=" + getResaveds1_s()
				+ ", getResaveds2_s()=" + getResaveds2_s()
				+ ", getResaveds3_s()=" + getResaveds3_s()
				+ ", getResaveds4_s()=" + getResaveds4_s()
				+ ", getResaveds5_s()=" + getResaveds5_s()
				+ ", getStartDate_t()=" + getStartDate_t()
				+ ", getEndDate_t()=" + getEndDate_t() + ", getCarNumber_i()="
				+ getCarNumber_i() + ", getIsHighRiskTest_i()="
				+ getIsHighRiskTest_i() + ", getHighRiskTestDescription_s()="
				+ getHighRiskTestDescription_s() + ", getIsCamera_i()="
				+ getIsCamera_i() + ", getAccidentPrevention_s()="
				+ getAccidentPrevention_s() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
