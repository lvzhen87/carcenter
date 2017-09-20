package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.Customer;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class Driver  extends  CustomerUser{
	//String customerID_s,customerUserID_s, customerName_s, department_s, customerUserName_s,identityCard_s, position_s, telephone_s;
	String  drivingLicenceCPG_s,
			levelCPG_s;
	Date lastTrainDate_t, createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	//驾驶员 关联 客户公司 ID
	 
	//是否需要培训 1代表不需要培训  0代表需要培训
	String isTrain;
	Date lastTestDate_t;//最后一次试验时间 kxc 2014-05-16
	 
	public int getIsDriver() {
		return isDriver;
	}

	public void setIsDriver(int isDriver) {
		this.isDriver = isDriver;
	}

	public Date getLastTestDate_t() {
		return lastTestDate_t;
	}

	public void setLastTestDate_t(Date lastTestDateT) {
		lastTestDate_t = lastTestDateT;
	}

	public String getIsTrain() {
		return isTrain;
	}

	public void setIsTrain(String isTrain) {
		this.isTrain = isTrain;
	}

	public String getCustomerUserID_s() {
		return customerUserID_s;
	}

	public void setCustomerUserID_s(String customerUserID_s) {
		this.customerUserID_s = customerUserID_s;
	}

	public String getCustomerName_s() {
		return customerName_s;
	}

	public void setCustomerName_s(String customerName_s) {
		this.customerName_s = customerName_s;
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

	public String getDrivingLicenceCPG_s() {
		return drivingLicenceCPG_s;
	}

	public void setDrivingLicenceCPG_s(String drivingLicenceCPG_s) {
		this.drivingLicenceCPG_s = drivingLicenceCPG_s;
	}

	public String getLevelCPG_s() {
		return levelCPG_s;
	}

	public void setLevelCPG_s(String levelCPG_s) {
		this.levelCPG_s = levelCPG_s;
	}

	public Date getLastTrainDate_t() {
		return lastTrainDate_t;
	}

	public void setLastTrainDate_t(Date lastTrainDate_t) {
		this.lastTrainDate_t = lastTrainDate_t;
		if(lastTrainDate_t!=null)
		{
			Date today = new Date();
			int diffeDay = DateUtil.countDistanceDayNum(lastTrainDate_t, today);
			if(diffeDay>ConstantUtil.TrainDay){
				this.isTrain = "0";
			}
			else
			{
				this.isTrain = "1";
			}
		}
		else
		{
			this.isTrain = "0";
		}
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

	public String getCustomerID_s() {
		return customerID_s;
	}

	public void setCustomerID_s(String customerID_s) {
		this.customerID_s = customerID_s;
	}

	@Override
	public String toString() {
		return "Driver [customerUserID_s=" + customerUserID_s
				+ ", customerName_s=" + customerName_s + ", department_s="
				+ department_s + ", customerUserName_s=" + customerUserName_s
				+ ", identityCard_s=" + identityCard_s + ", position_s="
				+ position_s + ", telephone_s=" + telephone_s
				+ ", drivingLicenceCPG_s=" + drivingLicenceCPG_s
				+ ", levelCPG_s=" + levelCPG_s + ", lastTrainDate_t="
				+ lastTrainDate_t + ", createDate_t=" + createDate_t
				+ ", createUser_s=" + createUser_s + ", lastUpdateUser_s="
				+ lastUpdateUser_s + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", customerID_s=" + customerID_s + ", isTrain="
				+ isTrain + "]";
	}

	/**
	 * 用CustomerUser对驾驶员对象赋值
	 * setproByCustomerUser 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setproByCustomerUser(CustomerUser customerUser){
		customerUserID_s = customerUser.getCustomerUserID_s();
		customerName_s = customerUser.getCustomerName_s();
		department_s = customerUser.getDepartment_s();
		customerUserName_s = customerUser.getCustomerUserName_s();
		identityCard_s = customerUser.getIdentityCard_s();
		position_s = customerUser.getPosition_s();
		telephone_s = customerUser.getTelephone_s();
		sysNo_s = customerUser.getSysNo_s();
		isDriver = 1;
		customerID_s = customerUser.getCustomerID_s();
	}
}
