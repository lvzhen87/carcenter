package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

/**
 * 对接机信息表
 *     
 * 项目名称：carcenter    
 * 类名称：InterphoneInfo    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-5-17 上午11:56:41    
 * 修改人：kxc    
 * 修改时间：2014-5-17 上午11:56:41    
 * 修改备注：    
 * @version     
 *
 */
public class InterphoneInfo  extends  BeanModel{

	String interphoneID_s, interphonePast_s, brand_s;
	Integer state_i;
	

	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;

	
	
	 

	public String getInterphoneID_s() {
		return interphoneID_s;
	}

	public void setInterphoneID_s(String interphoneID_s) {
		this.interphoneID_s = interphoneID_s;
	}

	public String getInterphonePast_s() {
		return interphonePast_s;
	}

	public void setInterphonePast_s(String interphonePast_s) {
		this.interphonePast_s = interphonePast_s;
	}

	public String getBrand_s() {
		return brand_s;
	}

	public void setBrand_s(String brand_s) {
		this.brand_s = brand_s;
	}
	public Integer getState_i() {
		return state_i;
	}

	public void setState_i(Integer state_i) {
		this.state_i = state_i;
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

	@Override
	public String toString() {
		return "InterphoneInfo [brand_s=" + brand_s + ", createDate_t="
				+ createDate_t + ", createUser_s=" + createUser_s
				+ ", interphoneID_s=" + interphoneID_s + ", interphonePast_s="
				+ interphonePast_s + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", resaveds1_s="
				+ resaveds1_s + ", resaveds2_s=" + resaveds2_s
				+ ", resaveds3_s=" + resaveds3_s + ", resaveds4_s="
				+ resaveds4_s + ", resaveds5_s=" + resaveds5_s + ", state_i="
				+ state_i +  "]";
	}



}
