package com.freshen.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.basis.RoadExperimentType;
import com.freshen.hibernate.HibernateSessionFactory;

/**
 * 
 *     
 * 项目名称：carcenter    
 * 类名称：OrderRoadDetail    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-4-28 下午12:16:18    
 * 修改人：kxc    
 * 修改时间：2014-4-28 下午12:16:18    
 * 修改备注：   增加试验类型ID和试验名称
 * @version     
 *
 */
public class OrderRoadDetail  extends  BeanModel{

	String orderRoadID_s, orderID_s;
	Integer status_i;
	Date startDate_t;
	Date endDate_t;
	String type_s, roadID_s, roadName_s, hoursNumber_s;
	 
	String maxSpeed_s, description_s;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	Integer maxCapacity_i; //最大容量
	Integer isok; //建议是否审核通过 1:是 0:否
	String experimentTypeID_s;//试验类型ID
	RoadExperimentType roadExperimentTypeModel;//道路试验类型基础信息表
	Integer billingMode_i;//计费方式 1按时间计费，2按里程计费
	String carIndex_s;//车辆序号
	String carCPG_s;//试验车辆的CPG牌照号
	
	
	public String getCarIndex_s() {
		return carIndex_s;
	}

	public void setCarIndex_s(String carIndexS) {
		carIndex_s = carIndexS;
	}

	public String getCarCPG_s() {
		return carCPG_s;
	}

	public void setCarCPG_s(String carCPGS) {
		carCPG_s = carCPGS;
	}

	public Integer getBillingMode_i() {
		return billingMode_i;
	}

	public void setBillingMode_i(Integer billingModeI) {
		billingMode_i = billingModeI;
	}

	public RoadExperimentType getRoadExperimentTypeModel() {
		return roadExperimentTypeModel;
	}

	public void setRoadExperimentTypeModel(
			RoadExperimentType roadExperimentTypeModel) {
		this.roadExperimentTypeModel = roadExperimentTypeModel;
	}

	public String getExperimentTypeID_s() {
		return experimentTypeID_s;
	}

	public void setExperimentTypeID_s(String experimentTypeIDS) {
		experimentTypeID_s = experimentTypeIDS;
		if(experimentTypeID_s!=null&&!experimentTypeID_s.trim().equals("")){
			
		}
	}

	public Integer getMaxCapacity_i() {
		return maxCapacity_i;
	}

	public void setMaxCapacity_i(Integer maxCapacityI) {
		maxCapacity_i = maxCapacityI;
	}

	public Integer getIsok() {
		return isok;
	}

	public void setIsok(Integer isok) {
		this.isok = isok;
	}

	public String getStartDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(startDate_t);
	}

	public String getEndDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(endDate_t);
	}

	public String getOrderRoadID_s() {
		return orderRoadID_s;
	}

	public void setOrderRoadID_s(String orderRoadID_s) {
		this.orderRoadID_s = orderRoadID_s;
	}

	public String getOrderID_s() {
		return orderID_s;
	}

	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}

	public Integer getStatus_i() {
		return status_i;
	}

	public void setStatus_i(Integer status_i) {
		this.status_i = status_i;
	}

	public Date getStartDate_t() {
		return startDate_t;
	}

	public void setStartDate_t(Date startDate_t) {
		this.startDate_t = startDate_t;
	}

	public Date getEndDate_t() {
		return endDate_t;
	}

	public void setEndDate_t(Date endDate_t) {
		this.endDate_t = endDate_t;
	}

	public String getType_s() {
		return type_s;
	}

	public void setType_s(String type_s) {
		this.type_s = type_s;
	}

	public String getRoadID_s() {
		return roadID_s;
	}

	public void setRoadID_s(String roadID_s) {
		this.roadID_s = roadID_s;
	}

	public String getRoadName_s() {
		return roadName_s;
	}

	public void setRoadName_s(String roadName_s) {
		this.roadName_s = roadName_s;
	}

	public String getHoursNumber_s() {
		return hoursNumber_s;
	}

	public void setHoursNumber_s(String hoursNumber_s) {
		this.hoursNumber_s = hoursNumber_s;
	}
 
	public String getMaxSpeed_s() {
		return maxSpeed_s;
	}

	public void setMaxSpeed_s(String maxSpeed_s) {
		this.maxSpeed_s = maxSpeed_s;
	}

	public String getDescription_s() {
		return description_s;
	}

	public void setDescription_s(String description_s) {
		this.description_s = description_s;
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
		return "OrderRoadDetail [billingMode_i=" + billingMode_i
				+ ", createDate_t="
				+ createDate_t + ", createUser_s=" + createUser_s
				+ ", description_s=" + description_s + ", endDate_t="
				+ endDate_t + ", experimentTypeID_s=" + experimentTypeID_s
				+ ", hoursNumber_s=" + hoursNumber_s + ", isok=" + isok
				+ ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", maxCapacity_i="
				+ maxCapacity_i + ", maxSpeed_s=" + maxSpeed_s + ", orderID_s="
				+ orderID_s + ", orderRoadID_s=" + orderRoadID_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", roadExperimentTypeModel="
				+ roadExperimentTypeModel + ", roadID_s=" + roadID_s
				+ ", roadName_s=" + roadName_s + ", startDate_t=" + startDate_t
				+ ", status_i=" + status_i + ", type_s=" + type_s + "]";
	}
 
	public void setCustomerUser() {
		Session session=HibernateSessionFactory.getSession();
		if(roadID_s != null && !roadID_s.trim().equals("") && experimentTypeID_s != null && !experimentTypeID_s.trim().equals("")){
			RoadExperimentType reType = new RoadExperimentType();
			reType.setRoadID_s(roadID_s);
			reType.setExperimentTypeID_s(experimentTypeID_s);
			roadExperimentTypeModel = (RoadExperimentType)session.get(roadExperimentTypeModel.getClass(), reType);	    	 
	    }    			
	}	
}
