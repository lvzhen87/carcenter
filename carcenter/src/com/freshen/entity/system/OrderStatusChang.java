package com.freshen.entity.system;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class OrderStatusChang  extends  BeanModel{

	String orderID_s, status_i, remark_s, updateUser_s;
	Date updateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;

	public String getOrderID_s() {
		return orderID_s;
	}

	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}

	public String getStatus_i() {
		return status_i;
	}

	public void setStatus_i(String status_i) {
		this.status_i = status_i;
	}

	public String getRemark_s() {
		return remark_s;
	}

	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}

	public String getUpdateUser_s() {
		return updateUser_s;
	}

	public void setUpdateUser_s(String updateUser_s) {
		this.updateUser_s = updateUser_s;
	}

	public Date getUpdateDate_t() {
		return updateDate_t;
	}

	public void setUpdateDate_t(Date updateDate_t) {
		this.updateDate_t = updateDate_t;
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
