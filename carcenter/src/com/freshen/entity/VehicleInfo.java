package com.freshen.entity;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

/*
 * @table t_subscribe_vehicleInfo
 * @author sharonyshi
 * @time 3014/3/11
 */
public class VehicleInfo extends BeanModel{
	String orderID_s;
	String vehicleCPG_s;
	String model_s;
	String color_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1;
	String resaveds2;
	String resaveds3;
	String resaveds4;
	String resaveds5;
	String fuelDemand_s;
	String weight_s;
	String maxWeight_s;
	String licensPlate_s;
	String brandType_s;
	String maxSpeed_s;
	String vin_s;
	String fuelConsumption_s;
	Integer category_i;
	
	Integer axleNumber_i;

	
	
	public Integer getAxleNumber_i() {
		return axleNumber_i;
	}

	public void setAxleNumber_i(Integer axleNumber_i) {
		this.axleNumber_i = axleNumber_i;
	}

	public String getLicensPlate_s() {
		return licensPlate_s;
	}

	public void setLicensPlate_s(String licensPlate_s) {
		this.licensPlate_s = licensPlate_s;
	}

	public String getBrandType_s() {
		return brandType_s;
	}

	public void setBrandType_s(String brandType_s) {
		this.brandType_s = brandType_s;
	}

	public String getMaxSpeed_s() {
		return maxSpeed_s;
	}

	public void setMaxSpeed_s(String maxSpeed_s) {
		this.maxSpeed_s = maxSpeed_s;
	}

	public String getVin_s() {
		return vin_s;
	}

	public void setVin_s(String vin_s) {
		this.vin_s = vin_s;
	}

	public String getFuelConsumption_s() {
		return fuelConsumption_s;
	}

	public void setFuelConsumption_s(String fuelConsumption_s) {
		this.fuelConsumption_s = fuelConsumption_s;
	}

	public Integer getCategory_i() {
		return category_i;
	}

	public void setCategory_i(Integer category_i) {
		this.category_i = category_i;
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

	public String getOrderID_s() {
		return orderID_s;
	}

	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}

	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}

	public void setVehicleCPG_s(String vehicleCPG_s) {
		this.vehicleCPG_s = vehicleCPG_s;
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

	public String getResaveds1() {
		return resaveds1;
	}

	public void setResaveds1(String resaveds1) {
		this.resaveds1 = resaveds1;
	}

	public String getResaveds2() {
		return resaveds2;
	}

	public void setResaveds2(String resaveds2) {
		this.resaveds2 = resaveds2;
	}

	public String getResaveds3() {
		return resaveds3;
	}

	public void setResaveds3(String resaveds3) {
		this.resaveds3 = resaveds3;
	}

	public String getResaveds4() {
		return resaveds4;
	}

	public void setResaveds4(String resaveds4) {
		this.resaveds4 = resaveds4;
	}

	public String getResaveds5() {
		return resaveds5;
	}

	public void setResaveds5(String resaveds5) {
		this.resaveds5 = resaveds5;
	}

	@Override
	public String toString() {
		return "VehicleInfo [color_s=" + color_s + ", createDate_t="
				+ createDate_t + ", createUser_s=" + createUser_s
				+ ", fuelDemand_s=" + fuelDemand_s + ", lastUpdateDate_t="
				+ lastUpdateDate_t + ", lastUpdateUser_s=" + lastUpdateUser_s
				+ ", maxWeight_s=" + maxWeight_s + ", model_s=" + model_s
				+ ", orderID_s=" + orderID_s + ", resaveds1=" + resaveds1
				+ ", resaveds2=" + resaveds2 + ", resaveds3=" + resaveds3
				+ ", resaveds4=" + resaveds4 + ", resaveds5=" + resaveds5
				+ ", vehicleCPG_s=" + vehicleCPG_s + ", weight_s=" + weight_s
				+ "]";
	}

	
}
