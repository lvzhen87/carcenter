package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;

public class HotelAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	List<OrderHotelOther> hotelotherlist=new ArrayList<OrderHotelOther>();
	OrderHotelOther hotel=new OrderHotelOther();
	
	String orderID_s,type1,type2,type3,startdate,enddate;
	String rentCar,isRentalDriver,rentCarMsg,otherService_s,remark_s,createDate,createUser;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	public String execute(){
		try {
			IorderInfoService iis=new OrderInfoServiceImpl();
			
			hotelotherlist=iis.getOrderHotelOther(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}

	
	public String initHotel(){
		try {
			IorderInfoService iis=new OrderInfoServiceImpl();
			hotelotherlist=iis.getOrderHotelOther(orderID_s);
			if(hotelotherlist != null){
				hotel=hotelotherlist.get(0);
			}
			if(hotel.getType_s() != null){
				String temp[]=hotel.getType_s().split(",");
				for (int i = 0; i < temp.length; i++) {
					if(temp[i].startsWith("标准")){
						String num[]=temp[i].split(":");
						type1=num[1];
					}
					if(temp[i].startsWith("大床")){
						String num[]=temp[i].split(":");
						type2=num[1];
					}
					if(temp[i].startsWith("豪华")){
						String num[]=temp[i].split(":");
						type3=num[1];
					}
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
	
	
	public String modifyHotel(){
		try {
			OrderHotelOther oh=new OrderHotelOther();
			oh.setOrderID_s(orderId);
			oh.setCreateDate_t(DateUtil.getDate(createDate));
			oh.setCreateUser_s(createUser);
			String type_s="标准房:"+type1+",大床房:"+type2+",豪华套间:"+type3;
			oh.setType_s(type_s);
			if(rentCar.equals("checked")){
				oh.setIsRentalCar_i(1);
			}else{
				oh.setIsRentalCar_i(0);
			}
			oh.setStartDate_t(DateUtil.getDate(startdate));
			oh.setEndDate_t(DateUtil.getDate(enddate));
			oh.setIsRentalDriver_i(Integer.valueOf(isRentalDriver));
			oh.setLastUpdateDate_t(DateUtil.getCurrentDate());
			oh.setLastUpdateUser_s(employ.getCustomerUserName_s());
			oh.setOtherService_s(otherService_s);
			oh.setRemark_s(remark_s);
			//System.out.println(oh.toString());
			
			List<OrderHotelOther> ohlist=new ArrayList<OrderHotelOther>();
			ohlist.add(oh);
			
			IorderInfoService iis=new OrderInfoServiceImpl();
			iis.OperationOrderHotelOther(ohlist, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
 
		}
		return SUCCESS;
	}
	
	
	
	public String delorderHotel(){
		try {
			OrderHotelOther oh=new OrderHotelOther();
			oh.setOrderID_s(orderId);
			
			List<OrderHotelOther> ohlist=new ArrayList<OrderHotelOther>();
			ohlist.add(oh);
			
			IorderInfoService iis=new OrderInfoServiceImpl();
			iis.OperationOrderHotelOther(ohlist, 2);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	

	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public List<OrderHotelOther> getHotelotherlist() {
		return hotelotherlist;
	}


	public void setHotelotherlist(List<OrderHotelOther> hotelotherlist) {
		this.hotelotherlist = hotelotherlist;
	}


	public OrderHotelOther getHotel() {
		return hotel;
	}


	public void setHotel(OrderHotelOther hotel) {
		this.hotel = hotel;
	}


	public String getOrderID_s() {
		return orderID_s;
	}


	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}


	public String getType1() {
		return type1;
	}


	public void setType1(String type1) {
		this.type1 = type1;
	}


	public String getType2() {
		return type2;
	}


	public void setType2(String type2) {
		this.type2 = type2;
	}


	public String getType3() {
		return type3;
	}


	public void setType3(String type3) {
		this.type3 = type3;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getRentCar() {
		return rentCar;
	}


	public void setRentCar(String rentCar) {
		this.rentCar = rentCar;
	}


	public String getIsRentalDriver() {
		return isRentalDriver;
	}


	public void setIsRentalDriver(String isRentalDriver) {
		this.isRentalDriver = isRentalDriver;
	}


	public String getRentCarMsg() {
		return rentCarMsg;
	}


	public void setRentCarMsg(String rentCarMsg) {
		this.rentCarMsg = rentCarMsg;
	}


	public String getRemark_s() {
		return remark_s;
	}


	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
	

}
