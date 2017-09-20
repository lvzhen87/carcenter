package com.freshen.entity.reception;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.CustomerRegister;
import com.freshen.entity.basis.CustomerUser;

public class ReceptionCustomerUser  extends  BeanModel{

	String customerUserID_s, orderID_s, customerUserName_s;
	Integer userType_i;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;//客户部门 编号
	String resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String userType_s;
	
	String invoiceAddress_s;
	String registerAddress_s;
	String responsibleUserID_s;
	String invoiceUserID_s;
	String card_s;//人卡号
	String sysNo_s;//一卡通人员编号 不存放数据库
	String serialface_s;//卡面编号
	String deviceSysid_s;//所属设备集合 已"vv"作为分隔符
	String doorCode_s;// 登记门号
	 
	Integer isCheckinHotel_i;//是否入住酒店
	Integer isSafetyTrain_i; //是否进行安全培训
	
	Date invalidate_t;
	String invalidatestr;//sharonyshi，逻辑字段用于显示invalidate
	
	
	
	public String getInvalidatestr() {
		return invalidatestr;
	}

	public void setInvalidatestr(String invalidatestr) {
		this.invalidatestr = invalidatestr;
	}

	public Date getInvalidate_t() {
		return invalidate_t;
	}

	public void setInvalidate_t(Date invalidate_t) {
		this.invalidate_t = invalidate_t;
	}

	public Integer getIsCheckinHotel_i() {
		return isCheckinHotel_i;
	}

	public void setIsCheckinHotel_i(Integer isCheckinHotelI) {
		isCheckinHotel_i = isCheckinHotelI;
	}

	public Integer getIsSafetyTrain_i() {
		return isSafetyTrain_i;
	}

	public void setIsSafetyTrain_i(Integer isSafetyTrainI) {
		isSafetyTrain_i = isSafetyTrainI;
	}

	public String getDoorCode_s() {
		return doorCode_s;
	}

	public void setDoorCode_s(String doorCodeS) {
		doorCode_s = doorCodeS;
	}

	public String getDeviceSysid_s() {
		return deviceSysid_s;
	}

	public void setDeviceSysid_s(String deviceSysidS) {
		deviceSysid_s = deviceSysidS;
	}

	public String getSerialface_s() {
		return serialface_s;
	}

	public void setSerialface_s(String serialfaceS) {
		serialface_s = serialfaceS;
	}

	public String getSysNo_s() {
		return sysNo_s;
	}

	public void setSysNo_s(String sysNoS) {
		sysNo_s = sysNoS;
	}

	public String getCard_s() {
		return card_s;
	}

	public void setCard_s(String cardS) {
		card_s = cardS;
	}

	public String getInvoiceAddress_s() {
		return invoiceAddress_s;
	}

	public void setInvoiceAddress_s(String invoiceAddress_s) {
		this.invoiceAddress_s = invoiceAddress_s;
	}

	public String getRegisterAddress_s() {
		return registerAddress_s;
	}

	public void setRegisterAddress_s(String registerAddress_s) {
		this.registerAddress_s = registerAddress_s;
	}

	public String getResponsibleUserID_s() {
		return responsibleUserID_s;
	}

	public void setResponsibleUserID_s(String responsibleUserID_s) {
		this.responsibleUserID_s = responsibleUserID_s;
	}

	public String getInvoiceUserID_s() {
		return invoiceUserID_s;
	}

	public void setInvoiceUserID_s(String invoiceUserID_s) {
		this.invoiceUserID_s = invoiceUserID_s;
	}

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

	public String getCustomerUserName_s() {
		return customerUserName_s;
	}

	public void setCustomerUserName_s(String customerUserName_s) {
		this.customerUserName_s = customerUserName_s;
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

	
	
	public String getUserType_s() {
		return userType_s;
	}

	public void setUserType_s(String userType_s) {
		this.userType_s = userType_s;
	}

	@Override
	public String toString() {
		return "ReceptionCustomerUser [card_s=" + card_s + ", createDate_t="
				+ createDate_t + ", createUser_s=" + createUser_s
				+ ", customerUserID_s=" + customerUserID_s
				+ ", customerUserName_s=" + customerUserName_s
				+ ", deviceSysid_s=" + deviceSysid_s + ", doorCode_s="
				+ doorCode_s + ", invoiceAddress_s=" + invoiceAddress_s
				+ ", invoiceUserID_s=" + invoiceUserID_s
				+ ", isCheckinHotel_i=" + isCheckinHotel_i
				+ ", isSafetyTrain_i=" + isSafetyTrain_i
				+ ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", orderID_s="
				+ orderID_s + ", registerAddress_s=" + registerAddress_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", responsibleUserID_s=" + responsibleUserID_s
				+ ", serialface_s=" + serialface_s + ", sysNo_s=" + sysNo_s
				+ ", userType_i=" + userType_i + ", userType_s=" + userType_s
				+ "]";
	}

	/**
	 * 使用预约模块到访人员信息登记表对订单相关客户人员信息表进行赋值	   
	 * setproByCustomerRegister 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setproByCustomerRegister(CustomerRegister customerRegister){
		this.customerUserID_s = customerRegister.getCustomerUserID_s();
		this.orderID_s = customerRegister.getOrderID_s();
		this.userType_i = customerRegister.getUserType_i();
		this.createDate_t = customerRegister.getCreateDate_t();
		this.createUser_s = customerRegister.getCreateUser_s();
		this.isCheckinHotel_i = customerRegister.getIsCheckinHotel_i();
		this.isSafetyTrain_i = customerRegister.getIsSafetyTrain_i();
		this.customerUserName_s = customerRegister.getVcustomeuser().getCustomerusername_s();
	}
}
