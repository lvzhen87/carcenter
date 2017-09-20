package com.freshen.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.preorder.service.IvehicleInfoService;
import com.freshen.preorder.service.impl.VehicleInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.HibernateUtil;

/*
 * @table t_subscribe_orderOther
 * @author 
 * @time 2014/3/11
 * 修改
 * 20140429
 * kxc
 */
public class OrderOther  extends  BeanModel{
	String orderID_s;
	String vehicleCPG_s;
	Integer isConfidentiality_i;
	Integer isHighRiskTest_i;
	String highRiskTestDescription_s;
	Integer isCamera_i;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1;
	String resaveds2;
	String resaveds3;
	String resaveds4;
	String resaveds5;
	VehicleInfo vehicleInfoModel = new VehicleInfo();
	String status_i;
	
	//车辆信息
	String model_s;
	String color_s;
	String fuelDemand_s;
	String weight_s;
	String maxWeight_s;
	
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

	public String getFuelDemand_s() {
		return fuelDemand_s;
	}

	public void setFuelDemand_s(String fuelDemand_s) {
		this.fuelDemand_s = fuelDemand_s;
	}

	public String getWeight_s() {
		return weight_s;
	}

	public void setWeight_s(String weight_s) {
		this.weight_s = weight_s;
	}

	public String getMaxWeight_s() {
		return maxWeight_s;
	}

	public void setMaxWeight_s(String maxWeight_s) {
		this.maxWeight_s = maxWeight_s;
	}

	public String getStatus_i() {
		return status_i;
	}

	public void setStatus_i(String statusI) {
		status_i = statusI;
	}

	public String getOrderID_s() {
		return orderID_s;
	}

	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
		/*if((vehicleCPG_s!=null&&!vehicleCPG_s.trim().equals(""))&&
				(this.orderID_s!=null&&!this.orderID_s.trim().equals(""))){
			IvehicleInfoService ivehicleInfoService = new VehicleInfoServiceImpl();
			vehicleInfoModel.setVehicleCPG_s(this.vehicleCPG_s);
			vehicleInfoModel.setOrderID_s(this.orderID_s);
			try {
				List<VehicleInfo> l = ivehicleInfoService.getVehicleInfo(vehicleInfoModel, ConstantUtil.pagingNot, 0);
				if(l!=null&&l.size()>0){					
					this.vehicleInfoModel = l.get(0);
					setVehiclePro(vehicleInfoModel);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//setVehicleInfo();
	}

  
	public Integer getIsConfidentiality_i() {
		return isConfidentiality_i;
	}

	public void setIsConfidentiality_i(Integer isConfidentiality_i) {
		this.isConfidentiality_i = isConfidentiality_i;
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

	public String getVehicleCPG_s() {
		return vehicleCPG_s;
	}

	public void setVehicleCPG_s(String vehicleCPGS) {
		vehicleCPG_s = vehicleCPGS;
		/*if((vehicleCPG_s!=null&&!vehicleCPG_s.trim().equals(""))&&
				(this.orderID_s!=null&&!this.orderID_s.trim().equals(""))){
			IvehicleInfoService ivehicleInfoService = new VehicleInfoServiceImpl();
			vehicleInfoModel.setVehicleCPG_s(vehicleCPGS);
			vehicleInfoModel.setOrderID_s(this.getOrderID_s());
			try {
				List<VehicleInfo> l = ivehicleInfoService.getVehicleInfo(vehicleInfoModel, ConstantUtil.pagingNot, 0);
				if(l!=null&&l.size()>0){					
					this.vehicleInfoModel = l.get(0);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//setVehicleInfo();
	}

	public VehicleInfo getVehicleInfoModel() {
		return vehicleInfoModel;
	}

	public void setVehicleInfoModel(VehicleInfo vehicleInfoModel) {
		this.vehicleInfoModel = vehicleInfoModel;
	}

	@Override
	public String toString() {
		return "OrderOther [createDate_t=" + createDate_t + ", createUser_s="
				+ createUser_s + ", highRiskTestDescription_s="
				+ highRiskTestDescription_s + ", isCamera_i=" + isCamera_i
				+ ", isConfidentiality_i=" + isConfidentiality_i
				+ ", isHighRiskTest_i=" + isHighRiskTest_i
				+ ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", orderID_s="
				+ orderID_s + ", resaveds1=" + resaveds1 + ", resaveds2="
				+ resaveds2 + ", resaveds3=" + resaveds3 + ", resaveds4="
				+ resaveds4 + ", resaveds5=" + resaveds5 + ", status_i="
				+ status_i + ", vehicleCPG_s=" + vehicleCPG_s
				+ ", vehicleInfoModel=" + vehicleInfoModel + "]";
	}
 
	public void setVehiclePro(VehicleInfo vehicleInfo){
		this.model_s = vehicleInfo.getModel_s();
		this.color_s =vehicleInfo.getColor_s() ;
		this.fuelDemand_s = vehicleInfo.getFuelDemand_s();
		this.weight_s = vehicleInfo.getWeight_s();
		this.maxWeight_s = vehicleInfo.getMaxWeight_s();
	}

	public void setVehicleInfo(){
		if((vehicleCPG_s!=null&&!vehicleCPG_s.trim().equals(""))&&
				(this.orderID_s!=null&&!this.orderID_s.trim().equals(""))){
			Session session = HibernateUtil.getSession();
			vehicleInfoModel.setOrderID_s(orderID_s);
			vehicleInfoModel.setVehicleCPG_s(vehicleCPG_s);
			vehicleInfoModel = (VehicleInfo)session.get(vehicleInfoModel.getClass(), vehicleInfoModel);
			setVehiclePro(vehicleInfoModel);
		}
	}
}
