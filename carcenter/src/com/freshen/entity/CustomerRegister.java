package com.freshen.entity;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.basis.VCustomeuser;


public class CustomerRegister  extends  BeanModel{

	String customerUserID_s;
	String orderID_s;
	Integer userType_i;
	Integer isSafetyTrain_i;
	Integer isAirportPickup_i;
	Integer isCheckinHotel_i;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	
	VCustomeuser vcustomeuser;		//对应一个 视图， 客户的联系人和 驾驶员  构造的视图

	
	
	public String getCustomerUserID_s() {
		return customerUserID_s;
	}
	public void setCustomerUserID_s(String customerUserID_s) {
		this.customerUserID_s = customerUserID_s;
	}
	public String getOrderID_s() {
		return orderID_s;
	}
	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}
	public Integer getUserType_i() {
		return userType_i;
	}
	public void setUserType_i(Integer userType_i) {
		this.userType_i = userType_i;
	}
	public Integer getIsSafetyTrain_i() {
		return isSafetyTrain_i;
	}
	public void setIsSafetyTrain_i(Integer isSafetyTrain_i) {
		this.isSafetyTrain_i = isSafetyTrain_i;
	}
	public Integer getIsAirportPickup_i() {
		return isAirportPickup_i;
	}
	public void setIsAirportPickup_i(Integer isAirportPickup_i) {
		this.isAirportPickup_i = isAirportPickup_i;
	}
	public Integer getIsCheckinHotel_i() {
		return isCheckinHotel_i;
	}
	public void setIsCheckinHotel_i(Integer isCheckinHotel_i) {
		this.isCheckinHotel_i = isCheckinHotel_i;
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
	public VCustomeuser getVcustomeuser() {
		return vcustomeuser;
	}
	public void setVcustomeuser(VCustomeuser vcustomeuser) {
		this.vcustomeuser = vcustomeuser;
	}
	
	

}
