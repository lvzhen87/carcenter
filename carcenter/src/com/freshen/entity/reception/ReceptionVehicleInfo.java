package com.freshen.entity.reception;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.VehicleInfo;

public class ReceptionVehicleInfo  extends  BeanModel{

	String orderID_s, vehicleID_s, model_s, color_s, interPhoneID_s, fieldID_s,vehicleCPG_s;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String roidIds_s; //道路ID集合 已"vv"作为分隔符   存储订单每辆车道路权限  2014-06-11
	
	String weight_s;	
	String maxWeight_s;
	String fuelDemand_s;
	String fuelConsumption_s;
	Integer category_i;
	String licensPlate_s;
	String brandType_s;
	String maxSpeed_s;
	Integer axleNumber_i;
	String roadNames_s;//逻辑字段，用于存放roadID查寻出来的roadName
	
	String vin_s;  //cxcat 增加VIN号[表中原先已存在字段]
	
	
	
	public String getRoadNames_s() {
		return roadNames_s;
	}

	public void setRoadNames_s(String roadNames_s) {
		this.roadNames_s = roadNames_s;
	}

	public Integer getAxleNumber_i() {
		return axleNumber_i;
	}

	public void setAxleNumber_i(Integer axleNumber_i) {
		this.axleNumber_i = axleNumber_i;
	}

	public String getWeight_s() {
		return weight_s;
	}

	public void setWeight_s(String weightS) {
		weight_s = weightS;
	}

	public String getMaxWeight_s() {
		return maxWeight_s;
	}

	public void setMaxWeight_s(String maxWeightS) {
		maxWeight_s = maxWeightS;
	}

	public String getFuelDemand_s() {
		return fuelDemand_s;
	}

	public void setFuelDemand_s(String fuelDemandS) {
		fuelDemand_s = fuelDemandS;
	}

	public String getFuelConsumption_s() {
		return fuelConsumption_s;
	}

	public void setFuelConsumption_s(String fuelConsumptionS) {
		fuelConsumption_s = fuelConsumptionS;
	}

	public Integer getCategory_i() {
		return category_i;
	}

	public void setCategory_i(Integer categoryI) {
		category_i = categoryI;
	}

	public String getLicensPlate_s() {
		return licensPlate_s;
	}

	public void setLicensPlate_s(String licensPlateS) {
		licensPlate_s = licensPlateS;
	}

	public String getBrandType_s() {
		return brandType_s;
	}

	public void setBrandType_s(String brandTypeS) {
		brandType_s = brandTypeS;
	}

	public String getMaxSpeed_s() {
		return maxSpeed_s;
	}

	public void setMaxSpeed_s(String maxSpeedS) {
		maxSpeed_s = maxSpeedS;
	}

	public String getVin_s() {
		return vin_s;
	}

	public void setVin_s(String vinS) {
		vin_s = vinS;
	}

	public String getRoidIds_s() {
		return roidIds_s;
	}

	public void setRoidIds_s(String roidIdsS) {
		roidIds_s = roidIdsS;
	}

	public String getOrderID_s() {
		return orderID_s;
	}

	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}

	public String getVehicleID_s() {
		return vehicleID_s;
	}

	public void setVehicleID_s(String vehicleID_s) {
		this.vehicleID_s = vehicleID_s;
	}



	public String getModel_s() {
		return model_s;
	}

	public void setModel_s(String model_s) {
		this.model_s = model_s;
	}

	public String getColor_s() {
		return color_s;
	}

	public void setColor_s(String color_s) {
		this.color_s = color_s;
	}

	public String getInterPhoneID_s() {
		return interPhoneID_s;
	}

	public void setInterPhoneID_s(String interPhoneID_s) {
		this.interPhoneID_s = interPhoneID_s;
	}

	public String getFieldID_s() {
		return fieldID_s;
	}

	public void setFieldID_s(String fieldID_s) {
		this.fieldID_s = fieldID_s;
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

	

	public void setVehicleCPG_s(String vehicleCPG_s) {
		this.vehicleCPG_s = vehicleCPG_s;
	}

	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}

	@Override
	public String toString() {
		return "ReceptionVehicleInfo [orderID_s=" + orderID_s
				+ ", vehicleID_s=" + vehicleID_s + ", vehicleCPG_s="
				+ getVehicleCPG_s() + ", model_s=" + model_s + ", color_s="
				+ color_s + ", interPhoneID_s=" + interPhoneID_s
				+ ", fieldID_s=" + fieldID_s + ", createDate_t=" + createDate_t
				+ ", createUser_s=" + createUser_s + ", lastUpdateUser_s="
				+ lastUpdateUser_s + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", roidIds_s=" + roidIds_s + ", weight_s="
				+ weight_s + ", maxWeight_s=" + maxWeight_s + ", fuelDemand_s="
				+ fuelDemand_s + ", fuelConsumption_s=" + fuelConsumption_s
				+ ", category_i=" + category_i + ", licensPlate_s="
				+ licensPlate_s + ", brandType_s=" + brandType_s
				+ ", maxSpeed_s=" + maxSpeed_s + ", vin_s=" + vin_s
				+ ", axleNumber_i=" + axleNumber_i + ", roadNames_s="
				+ roadNames_s + "]";
	}

	/**
	 * 用预约模块单台车辆信息表对接待模块计划车辆信息赋值	   
	 * setProByVehicleInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 * 20170825 添加了其他属性的带入
	 */
	public void setProByVehicleInfo(VehicleInfo vehicleInfo){
		orderID_s = vehicleInfo.getOrderID_s();
		vehicleCPG_s = vehicleInfo.getVehicleCPG_s();
		model_s = vehicleInfo.getModel_s();
		color_s = vehicleInfo.getColor_s();
		this.createDate_t = vehicleInfo.getCreateDate_t();
		this.createUser_s = vehicleInfo.getCreateUser_s();
		
		resaveds1_s = vehicleInfo.getResaveds1();
		resaveds2_s = vehicleInfo.getResaveds2();
		resaveds3_s = vehicleInfo.getResaveds3();
		resaveds4_s = vehicleInfo.getResaveds4();
		resaveds5_s = vehicleInfo.getResaveds5();
	     
		weight_s = vehicleInfo.getWeight_s();	
		maxWeight_s = vehicleInfo.getMaxWeight_s();
		
		fuelDemand_s = vehicleInfo.getFuelDemand_s();
		fuelConsumption_s = vehicleInfo.getFuelConsumption_s();
		category_i = vehicleInfo.getCategory_i();
		licensPlate_s = vehicleInfo.getLicensPlate_s();
		brandType_s = vehicleInfo.getBrandType_s();
		maxSpeed_s = vehicleInfo.getMaxSpeed_s();
		vin_s = vehicleInfo.getVin_s();
		axleNumber_i = vehicleInfo.getAxleNumber_i();	
	}


	
	
	
}
