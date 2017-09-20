package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class WorkShopInfo  extends  BeanModel{
	String workShopID_s, workShopName_s, useInfos_s, remark_s;
	Date createDate_t, lastUpdateDate_t;
	String createUser_s, lastUpdateUser_s;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String type_s;//类型
	Integer isSubscribe_i;
	Integer ismonthSubscribe_i;
	Integer isdaysubscribe_i;
	Integer beginningday_i;
	
	
	private Double unitprieI;//单价费用 按天
	
	private TBasisWorkshopcost tBasisWorkshopcost;
	
	
	
	public Integer getIsmonthSubscribe_i() {
		return ismonthSubscribe_i;
	}

	public void setIsmonthSubscribe_i(Integer ismonthSubscribe_i) {
		this.ismonthSubscribe_i = ismonthSubscribe_i;
	}

	public Integer getIsdaysubscribe_i() {
		return isdaysubscribe_i;
	}

	public void setIsdaysubscribe_i(Integer isdaysubscribe_i) {
		this.isdaysubscribe_i = isdaysubscribe_i;
	}

	public Integer getBeginningday_i() {
		return beginningday_i;
	}

	public void setBeginningday_i(Integer beginningday_i) {
		this.beginningday_i = beginningday_i;
	}

	public TBasisWorkshopcost gettBasisWorkshopcost() {
		return tBasisWorkshopcost;
	}

	public void settBasisWorkshopcost(TBasisWorkshopcost tBasisWorkshopcost) {
		this.tBasisWorkshopcost = tBasisWorkshopcost;
	}

	public Double getUnitprieI() {
		return unitprieI;
	}

	public void setUnitprieI(Double unitprieI) {
		this.unitprieI = unitprieI;
	}

	public Integer getIsSubscribe_i() {
		return isSubscribe_i;
	}

	public void setIsSubscribe_i(Integer isSubscribe_i) {
		this.isSubscribe_i = isSubscribe_i;
	}

	public String getType_s() {
		return type_s;
	}

	public void setType_s(String typeS) {
		type_s = typeS;
	}

	public String getWorkShopID_s() {
		return workShopID_s;
	}

	public void setWorkShopID_s(String workShopID_s) {
		this.workShopID_s = workShopID_s;
	}

	public String getWorkShopName_s() {
		return workShopName_s;
	}

	public void setWorkShopName_s(String workShopName_s) {
		this.workShopName_s = workShopName_s;
	}

	public String getUseInfos_s() {
		return useInfos_s;
	}

	public void setUseInfos_s(String useInfos_s) {
		this.useInfos_s = useInfos_s;
	}

	public String getRemark_s() {
		return remark_s;
	}

	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
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
		return "WorkShopInfo [createDate_t=" + createDate_t + ", createUser_s="
				+ createUser_s + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", remark_s="
				+ remark_s + ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", type_s=" + type_s + ", useInfos_s="
				+ useInfos_s + ", workShopID_s=" + workShopID_s
				+ ", workShopName_s=" + workShopName_s + "]";
	}

	
}
