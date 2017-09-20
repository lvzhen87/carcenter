package com.freshen.ground.action;

import java.util.ArrayList;

import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.preorder.service.IorderSharingRoadService;
import com.freshen.preorder.service.impl.OrderSharingRoadServiceImpl;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class AddSharingRoadAction extends CapgActionSupport {
	//封装页面数据
	private String roadID_s,roadName,hoursNumber,maxSpeed,startdatepicker,enddatepicker;
	private String description,hightRiskTestDescription,accidentPrevention;
	private int carNumber,isHightRiskTest,isCamera;
	
	private String errmsg;
	
	
	/**
	 * 添加 共享 道路 预定信息
	 */
	public String execute(){
		try {
			String orderId=(String) ActionContext.getContext().getSession().get("orderId");
			OrderSharingRoad sr=new OrderSharingRoad();
			sr.setOrderID_s(orderId);
			sr.setRoadID_s(roadID_s);
			sr.setRoadName_s(roadName);
			sr.setHoursNumber_s(hoursNumber);
			sr.setMaxSpeed_s(maxSpeed);
			sr.setCarNumber_i(carNumber);
			sr.setIsHighRiskTest_i(isHightRiskTest);
			sr.setIsCamera_i(isCamera);
			sr.setStartDate_t(DateUtil.strToDate(startdatepicker, "yyyy-MM-dd"));
			sr.setEndDate_t(DateUtil.stringToDateformat(enddatepicker, "yyyy-MM-dd"));
			sr.setDescription_s(description);
			sr.setHighRiskTestDescription_s(hightRiskTestDescription);
			sr.setAccidentPrevention_s(accidentPrevention);
			
			IorderSharingRoadService sharSer =new OrderSharingRoadServiceImpl();
			List<OrderSharingRoad> ls =new ArrayList<OrderSharingRoad>();
			ls.add(sr);
			int r=sharSer.OperationOrderSharingRoad(ls, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return SUCCESS;
	}

	public String getRoadID_s() {
		return roadID_s;
	}

	public void setRoadID_s(String roadID_s) {
		this.roadID_s = roadID_s;
	}

	public String getHoursNumber() {
		return hoursNumber;
	}

	public void setHoursNumber(String hoursNumber) {
		this.hoursNumber = hoursNumber;
	}

	public String getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public String getStartdatepicker() {
		return startdatepicker;
	}

	public void setStartdatepicker(String startdatepicker) {
		this.startdatepicker = startdatepicker;
	}

	public String getEnddatepicker() {
		return enddatepicker;
	}

	public void setEnddatepicker(String enddatepicker) {
		this.enddatepicker = enddatepicker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHightRiskTestDescription() {
		return hightRiskTestDescription;
	}

	public void setHightRiskTestDescription(String hightRiskTestDescription) {
		this.hightRiskTestDescription = hightRiskTestDescription;
	}

	public String getAccidentPrevention() {
		return accidentPrevention;
	}

	public void setAccidentPrevention(String accidentPrevention) {
		this.accidentPrevention = accidentPrevention;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getIsHightRiskTest() {
		return isHightRiskTest;
	}

	public void setIsHightRiskTest(int isHightRiskTest) {
		this.isHightRiskTest = isHightRiskTest;
	}

	public int getIsCamera() {
		return isCamera;
	}

	public void setIsCamera(int isCamera) {
		this.isCamera = isCamera;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
}
