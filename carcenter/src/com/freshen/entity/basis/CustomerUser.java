package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.util.ConstantUtil;

/**
 * @table t_basis_CustomerUser
 * @author sharonyshi
 *
 */

public class CustomerUser  extends  BeanModel{
	String customerUserID_s,customerID_s;
	String department_s,customerUserName_s,	
		identityCard_s,position_s,telephone_s,facsimile_s,email_s,createUser_s,lastUpdateUser_s,
		resaveds1_s,resaveds2_s,resaveds3_s,resaveds4_s,resaveds5_s;
	Integer userType_i;
	Date createDate_t,lastUpdateDate_t;	
	int isDriver=0;//逻辑字段，常量 ，用于判断不是驾驶员sharonyshi 2014-5-26	
	String customerName_s;
	Integer dptid_i = ConstantUtil.SHOURTIMECOUSUMERDEPT; //部门 编号,默认为短期
	
	 
	String emplycode_s ="";//识别码   
	String emplyusertype_s ="";//用户类型，A~P 之间的大写字母。
	String emplypass_s="" ;// 个人密码，0~9之间的四位数字
	String emplysex_s="";// 性别，“男”或“女“
	Date empbirthday_t;// 生日
	String duty_s;//职务
	String nation_s;// 民族
	String degree_s;// 学历
	String address_s; //地址
	String memo_s ;//备注
	String card_s;//卡号
	Date invalidate;//有效日期  只作为临时存储字段，不存放在数据库中
	String serialface_s;//卡面编号 只作为临时存储字段，不存放在数据库中
	String sysNo_s;//一卡通人员编号只作为临时存储字段，不存放在数据库中
	//String iodate;//进道闸时间，不存放在数据库中
	Date iodate;
	
	 
	
	public Date getIodate() {
		return iodate;
	}
	public void setIodate(Date iodate) {
		this.iodate = iodate;
	}
	public String getSerialface_s() {
		return serialface_s;
	}
	public void setSerialface_s(String serialfaceS) {
		serialface_s = serialfaceS;
	}
	public Date getInvalidate() {
		return invalidate;
	}
	public void setInvalidate(Date invalidate) {
		this.invalidate = invalidate;
	}
	public String getCard_s() {
		return card_s;
	}
	public void setCard_s(String cardS) {
		card_s = cardS;
	}
	public String getSysNo_s() {
		return sysNo_s;
	}
	public void setSysNo_s(String sysNoS) {
		sysNo_s = sysNoS;
	}
	public String getEmplycode_s() {
		return emplycode_s;
	}
	public void setEmplycode_s(String emplycodeS) {
		emplycode_s = emplycodeS;
	}
	public String getEmplyusertype_s() {
		return emplyusertype_s;
	}
	public void setEmplyusertype_s(String emplyusertypeS) {
		emplyusertype_s = emplyusertypeS;
	}
	public String getEmplypass_s() {
		return emplypass_s;
	}
	public void setEmplypass_s(String emplypassS) {
		emplypass_s = emplypassS;
	}
	public String getEmplysex_s() {
		return emplysex_s;
	}
	public void setEmplysex_s(String emplysexS) {
		emplysex_s = emplysexS;
	}
	public Date getEmpbirthday_t() {
		return empbirthday_t;
	}
	public void setEmpbirthday_t(Date empbirthdayT) {
		empbirthday_t = empbirthdayT;
	}
	public String getDuty_s() {
		return duty_s;
	}
	public void setDuty_s(String dutyS) {
		duty_s = dutyS;
	}
	public String getNation_s() {
		return nation_s;
	}
	public void setNation_s(String nationS) {
		nation_s = nationS;
	}
	public String getDegree_s() {
		return degree_s;
	}
	public void setDegree_s(String degreeS) {
		degree_s = degreeS;
	}
	public String getAddress_s() {
		return address_s;
	}
	public void setAddress_s(String addressS) {
		address_s = addressS;
	}
	public String getMemo_s() {
		return memo_s;
	}
	public void setMemo_s(String memoS) {
		memo_s = memoS;
	}
	public Integer getDptid_i() {
		return dptid_i;
	}
	public void setDptid_i(Integer dptidI) {
		dptid_i = dptidI;
	}
	public String getCustomerName_s() {
		return customerName_s;
	}
	public void setCustomerName_s(String customerName_s) {
		this.customerName_s = customerName_s;
	}
	public int getIsDriver() {
		return isDriver;
	}
	public void setIsDriver(int isDriver) {
		this.isDriver = isDriver;
	}
	public String getCustomerID_s() {
		return customerID_s;
	}
	public void setCustomerID_s(String customerIDS) {
		customerID_s = customerIDS;
	}
	
	public String getCustomerUserID_s() {
		return customerUserID_s;
	}
	public void setCustomerUserID_s(String customerUserID_s) {
		this.customerUserID_s = customerUserID_s;
	}
	
	public String getDepartment_s() {
		return department_s;
	}
	public void setDepartment_s(String department_s) {
		this.department_s = department_s;
	}
	public String getCustomerUserName_s() {
		return customerUserName_s;
	}
	public void setCustomerUserName_s(String customerUserName_s) {
		this.customerUserName_s = customerUserName_s;
	}
	public String getIdentityCard_s() {
		return identityCard_s;
	}
	public void setIdentityCard_s(String identityCard_s) {
		this.identityCard_s = identityCard_s;
	}
	public String getPosition_s() {
		return position_s;
	}
	public void setPosition_s(String position_s) {
		this.position_s = position_s;
	}
	public String getTelephone_s() {
		return telephone_s;
	}
	public void setTelephone_s(String telephone_s) {
		this.telephone_s = telephone_s;
	}
	public String getFacsimile_s() {
		return facsimile_s;
	}
	public void setFacsimile_s(String facsimile_s) {
		this.facsimile_s = facsimile_s;
	}
	public String getEmail_s() {
		return email_s;
	}
	public void setEmail_s(String email_s) {
		this.email_s = email_s;
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
	public Integer getUserType_i() {
		return userType_i;
	}
	public void setUserType_i(Integer userType_i) {
		this.userType_i = userType_i;
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
	@Override
	public String toString() {
		return "CustomerUser [address_s=" + address_s + ", card_s=" + card_s
				+ ", createDate_t=" + createDate_t + ", createUser_s="
				+ createUser_s + ", customerID_s=" + customerID_s
				+ ", customerName_s=" + customerName_s + ", customerUserID_s="
				+ customerUserID_s + ", customerUserName_s="
				+ customerUserName_s + ", degree_s=" + degree_s
				+ ", department_s=" + department_s + ", dptid_i=" + dptid_i
				+ ", duty_s=" + duty_s + ", email_s=" + email_s
				+ ", empbirthday_t=" + empbirthday_t + ", emplycode_s="
				+ emplycode_s + ", emplypass_s=" + emplypass_s
				+ ", emplysex_s=" + emplysex_s + ", emplyusertype_s="
				+ emplyusertype_s + ", facsimile_s=" + facsimile_s
				+ ", identityCard_s=" + identityCard_s + ", invalidate="
				+ invalidate + ", isDriver=" + isDriver + ", lastUpdateDate_t="
				+ lastUpdateDate_t + ", lastUpdateUser_s=" + lastUpdateUser_s
				+ ", memo_s=" + memo_s + ", nation_s=" + nation_s
				+ ", position_s=" + position_s + ", resaveds1_s=" + resaveds1_s
				+ ", resaveds2_s=" + resaveds2_s + ", resaveds3_s="
				+ resaveds3_s + ", resaveds4_s=" + resaveds4_s
				+ ", resaveds5_s=" + resaveds5_s + ", serialface_s="
				+ serialface_s + ", sysNo_s=" + sysNo_s + ", telephone_s="
				+ telephone_s + ", userType_i=" + userType_i + "]";
	}
}
