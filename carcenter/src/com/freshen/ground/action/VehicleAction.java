package com.freshen.ground.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.entity.VehicleInfo;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.preorder.service.IvehicleInfoService;
import com.freshen.preorder.service.impl.VehicleInfoServiceImpl;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.util.ConstantUtil;

public class VehicleAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	String orderStatus=(String) ActionContext.getContext().getSession().get("orderstatus");	
	List vehiclelist=new ArrayList();
	VehicleInfo vehicle=new VehicleInfo();
	ReceptionVehicleInfo recvehicle=new ReceptionVehicleInfo();
	String vehicleCPG,vehicleID_s;
	String categoryFace,modelFace,weight,maxWeight,axleNumber,fuelDemandFace,color,licensPlate,brandType,maxSpeed,vin,fuelConsumption;
	String createUser,createDate;
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	String msg;
	
	
	public String execute(){
		try {

			if(Integer.valueOf(orderStatus) > 3){
				ReceptionVehicleInfo rvi=new ReceptionVehicleInfo();
				rvi.setOrderID_s(orderId);
				
				//读取接待模块中的车辆信息
				IreceptionVehicleInfoService irvs=new ReceptionVehicleInfoServiceImpl();
				vehiclelist=irvs.getReceptionVehicleInfo(rvi, ConstantUtil.pagingNot,0,null);
			}else{
				
				VehicleInfo vi=new VehicleInfo();
				vi.setOrderID_s(orderId);
				//读取预约模块中的信息
				IvehicleInfoService ivs=new VehicleInfoServiceImpl();
				vehiclelist=ivs.getVehicleInfo(vi,ConstantUtil.pagingNot, 0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}

	
	public String initVehicle(){
		try {
		if(vehicleCPG !=null && !vehicleCPG.equals("")){
			VehicleInfo vi=new VehicleInfo();
			vi.setOrderID_s(orderId);
			vi.setVehicleCPG_s(vehicleCPG);
			
			IvehicleInfoService ivs=new VehicleInfoServiceImpl();
			List<VehicleInfo> vlist=ivs.getVehicleInfo(vi, ConstantUtil.pagingNot, 0);
			if(vlist!= null){
				vehicle=vlist.get(0);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	public String initRecVehicle(){
		try {
			IreceptionVehicleInfoService ivis = new ReceptionVehicleInfoServiceImpl();
			ReceptionVehicleInfo rviTmp  = new ReceptionVehicleInfo();
			List<ReceptionVehicleInfo> listRvi = new ArrayList<ReceptionVehicleInfo>();
			
			ReceptionVehicleInfo rvi=new ReceptionVehicleInfo();
			rvi.setOrderID_s(orderId);
			rvi.setVehicleCPG_s(vehicleCPG);
			
			IreceptionVehicleInfoService irvs=new ReceptionVehicleInfoServiceImpl();
			List<ReceptionVehicleInfo> vlist=irvs.getReceptionVehicleInfo(rvi, ConstantUtil.pagingNot, 0,null);
			if(vlist!= null){
				recvehicle=vlist.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	
	
	public String addVehicle(){
		try {
			//新增的车辆直接跳转
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	
	public String modifyVehicle(){
		try {
			VehicleInfo v=new VehicleInfo();
			if(vehicleCPG ==null || vehicleCPG.equals("")){
				//说明是新增操作
				v.setCreateDate_t(DateUtil.getCurrentDate());
				v.setCreateUser_s(employ.getCustomerUserName_s());
			}else{
				v.setCreateDate_t(DateUtil.getDate(createDate));
				v.setCreateUser_s(createUser);
				v.setLastUpdateDate_t(DateUtil.getCurrentDate());
				v.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}
			v.setOrderID_s(orderId);
			v.setVehicleCPG_s(vehicleCPG);
			v.setModel_s(modelFace);
			v.setColor_s(color);
			v.setWeight_s(weight);
			v.setMaxWeight_s(maxWeight);
			v.setFuelDemand_s(fuelDemandFace);
			v.setFuelConsumption_s(fuelConsumption);
			v.setCategory_i(Integer.valueOf(categoryFace));
			v.setLicensPlate_s(licensPlate);
			v.setBrandType_s(brandType);
			v.setMaxSpeed_s(maxSpeed);
			v.setVin_s(vin);
			v.setAxleNumber_i(Integer.valueOf(axleNumber));
			
			
			List<VehicleInfo> vlist=new ArrayList<VehicleInfo>();
			vlist.add(v);
			
			IvehicleInfoService ivs=new VehicleInfoServiceImpl();
			ivs.OperationSubscribeVehicleInfo(vlist, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public String modifyRecVehicle(){
		try {
			IreceptionVehicleInfoService ivis = new ReceptionVehicleInfoServiceImpl();
			ReceptionVehicleInfo rvi  = new ReceptionVehicleInfo();
			List<ReceptionVehicleInfo> listRvi = new ArrayList<ReceptionVehicleInfo>();
			ReceptionVehicleInfo v=new ReceptionVehicleInfo();
			IroadInfoService irs = new RoadInfoServiceImpl();
			List<RoadInfo> roadlist = new ArrayList<RoadInfo>();
			RoadInfo roadInfo = new RoadInfo();
			v.setOrderID_s(orderId);
			v.setVehicleCPG_s(vehicleCPG);
			String roadArray[];
			String roadName = "";
			listRvi = ivis.getReceptionVehicleInfo(v, -1, 0);
			if(listRvi!= null&& listRvi.size()>0)
			{
				rvi = listRvi.get(0);
				if(rvi != null)
				{
					v.setVehicleID_s(rvi.getVehicleID_s());
					v.setRoidIds_s(rvi.getRoidIds_s());
					roadArray = rvi.getRoidIds_s().split("vv");
					if(roadArray!= null && roadArray.length>0)
					{
						for(int i = 0 ;i<roadArray.length;i++)
						{
							roadInfo.setRoadID_s(roadArray[i]);
							roadlist = irs.getRoadInfo(roadInfo);
							if(roadlist!= null&& roadlist.size()>0)
							{
								roadName = roadName + roadlist.get(0).getRoadName_s() + " | ";
							}
						}
						roadName = roadName.substring(0, roadName.length()-1);
					}
				}
			}
			v.setRoadNames_s(roadName);
			if(vehicleCPG ==null || vehicleCPG.equals("")){
				//说明是新增操作
				v.setCreateDate_t(DateUtil.getCurrentDate());
				v.setCreateUser_s(employ.getCustomerUserName_s());
			}else{
				v.setCreateDate_t(DateUtil.getDate(createDate));
				v.setCreateUser_s(createUser);
				v.setLastUpdateDate_t(DateUtil.getCurrentDate());
				v.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}
			
			v.setModel_s(modelFace);
			v.setColor_s(color);
			v.setWeight_s(weight);
			v.setMaxWeight_s(maxWeight);
			v.setFuelDemand_s(fuelDemandFace);
			v.setFuelConsumption_s(fuelConsumption);
			v.setCategory_i(Integer.valueOf(categoryFace));
			v.setLicensPlate_s(licensPlate);
			v.setBrandType_s(brandType);
			v.setMaxSpeed_s(maxSpeed);
			v.setVin_s(vin);
			v.setAxleNumber_i(Integer.valueOf(axleNumber));
			
			
			
			ArrayList<ReceptionVehicleInfo> vlist=new ArrayList<ReceptionVehicleInfo>();
			vlist.add(v);
			
			IreceptionVehicleInfoService irvs=new ReceptionVehicleInfoServiceImpl();
			irvs.saveOrUpdateReceptionVehicleInfo(vlist);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public String deleteorderVehicle(){
		try {
			VehicleInfo v=new VehicleInfo();
			v.setVehicleCPG_s(vehicleCPG);
			v.setOrderID_s(orderId);
			
			List<VehicleInfo> vlist=new ArrayList<VehicleInfo>();
			vlist.add(v);
			
			IvehicleInfoService ivs=new VehicleInfoServiceImpl();
			ivs.OperationSubscribeVehicleInfo(vlist, 2);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;
		
	}
	
	
	public String deleteorderrecVehicle(){
		try {
			ReceptionVehicleInfo v=new ReceptionVehicleInfo();
			v.setVehicleCPG_s(vehicleCPG);
			v.setOrderID_s(orderId);
			
			ArrayList<ReceptionVehicleInfo> vlist=new ArrayList<ReceptionVehicleInfo>();
			vlist.add(v);

			IreceptionVehicleInfoService irvs=new ReceptionVehicleInfoServiceImpl();
			boolean istrue=irvs.getIsVisible(vehicleID_s); 
			
			if(istrue){
				msg ="对不起！该车辆已经进入道闸，不能删除！";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println( msg);  
		        out.flush();  
		        out.close();  
			}else{
		
				irvs.deleteReceptionVehicleInfo(vlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getVehicleCPG() {
		return vehicleCPG;
	}


	public void setVehicleCPG(String vehicleCPG) {
		this.vehicleCPG = vehicleCPG;
	}


	public VehicleInfo getVehicle() {
		return vehicle;
	}


	public void setVehicle(VehicleInfo vehicle) {
		this.vehicle = vehicle;
	}


	public String getCategoryFace() {
		return categoryFace;
	}


	public void setCategoryFace(String categoryFace) {
		this.categoryFace = categoryFace;
	}


	public String getModelFace() {
		return modelFace;
	}


	public void setModelFace(String modelFace) {
		this.modelFace = modelFace;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getMaxWeight() {
		return maxWeight;
	}


	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}


	public String getAxleNumber() {
		return axleNumber;
	}


	public void setAxleNumber(String axleNumber) {
		this.axleNumber = axleNumber;
	}


	public String getFuelDemandFace() {
		return fuelDemandFace;
	}


	public void setFuelDemandFace(String fuelDemandFace) {
		this.fuelDemandFace = fuelDemandFace;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getLicensPlate() {
		return licensPlate;
	}


	public void setLicensPlate(String licensPlate) {
		this.licensPlate = licensPlate;
	}


	public String getBrandType() {
		return brandType;
	}


	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}


	public String getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public String getFuelConsumption() {
		return fuelConsumption;
	}


	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public ReceptionVehicleInfo getRecvehicle() {
		return recvehicle;
	}


	public void setRecvehicle(ReceptionVehicleInfo recvehicle) {
		this.recvehicle = recvehicle;
	}


	public void setVehiclelist(List vehiclelist) {
		this.vehiclelist = vehiclelist;
	}


	public List getVehiclelist() {
		return vehiclelist;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getVehicleID_s() {
		return vehicleID_s;
	}


	public void setVehicleID_s(String vehicleID_s) {
		this.vehicleID_s = vehicleID_s;
	}
	
	

}
