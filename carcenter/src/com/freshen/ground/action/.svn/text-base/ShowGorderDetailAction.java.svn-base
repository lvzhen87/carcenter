package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.CustomerRegister;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.VehicleInfo;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.preorder.service.IcustomerRegisterService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.preorder.service.IorderSharingRoadService;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.preorder.service.IvehicleInfoService;
import com.freshen.preorder.service.impl.CustomerRegisterServiceimpl;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.preorder.service.impl.OrderPreRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderSharingRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderWorkShopServiceImpl;
import com.freshen.preorder.service.impl.VehicleInfoServiceImpl;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class ShowGorderDetailAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	String status=(String) ActionContext.getContext().getSession().get("orderstatus");
	
	List infolist=new ArrayList();
	List<OrderHotelOther> hotelotherlist=new ArrayList<OrderHotelOther>();//酒店信息集合
	List<OrderPreRoad> preroadlist=new ArrayList<OrderPreRoad>();//预付费道路集合
	List registerlist=new ArrayList();	//试验人员信息集合
	List<OrderSharingRoad> sharingroadlist=new ArrayList<OrderSharingRoad>();
	List<OrderWholeRoad> wholeroadlist=new ArrayList<OrderWholeRoad>();
	List<OrderWorkShop> workshoplist=new ArrayList<OrderWorkShop>();
	List vehiclelist=new ArrayList();
	
	
	public String showInfo(){
		try {
			int state=Integer.parseInt(status);
			if(state==1 || state==2){
				OrderDetail od=new OrderDetail();
				od.setOrderID_s(orderId);
				
				IorderInfoService ios=new OrderInfoServiceImpl();
				infolist=ios.getOrder(od);
			}else{
				ReceptionOrder ro=new ReceptionOrder();
				ro.setOrderID_s(orderId);
				
				IreceptionOrderService irs=new ReceptionOrderServiceImpl();
				infolist=irs.getReceptionOrder(ro, ConstantUtil.pagingNot,0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String showHotel(){
		try {
			IorderInfoService iis=new OrderInfoServiceImpl();
			hotelotherlist=iis.getOrderHotelOther(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String showPreroad(){
		try {
			OrderPreRoad or=new OrderPreRoad();
			or.setOrderID_s(orderId);
			
			IorderPreRoadService ips=new OrderPreRoadServiceImpl();
			preroadlist=ips.getBasisOrderPreRoad(or, ConstantUtil.pagingNot,0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String showReceptionUser(){
		try {
			int state=Integer.parseInt(status);
			//根据订单状态的不同，查询不同的 试验人员表
			if(state==1 || state==2){
				//订单未 接待状态，此时 试验人员信息，都存在 预约模块的表中
				CustomerRegister cr=new CustomerRegister();
				cr.setOrderID_s(orderId);
				IcustomerRegisterService irs=new CustomerRegisterServiceimpl();
				registerlist=irs.getBasisCustomerRegister(cr,ConstantUtil.pagingNot, 0);
				//System.out.println("查出订单 "+orderId +"  下 试验人员数量为"+registerlist.size() );
			}else{
				//订单接待了
				ReceptionCustomerUser cu=new ReceptionCustomerUser();
				cu.setOrderID_s(orderId);
				IreceptionCustomerUserService rcuSer =new ReceptionCustomerUserServiceImpl();
				//ArrayList<ReceptionCustomerUser> cus =rcuSer.getCustomerUserAllpro(cu);
				registerlist=rcuSer.getReceptionCustomerUser(cu, ConstantUtil.pagingNot, 1);
				//System.out.println("查出订单 "+orderId +"  下 试验人员数量为"+registerlist.size() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String showSharingroad(){
		try {
			OrderSharingRoad osd=new OrderSharingRoad();
			osd.setOrderID_s(orderId);
			
			IorderSharingRoadService iosrs=new OrderSharingRoadServiceImpl();
			
			sharingroadlist=iosrs.getBasisOrderSharingRoad(osd,ConstantUtil.pagingNot, 0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String showWholeroad(){
		try {
			OrderWholeRoad owd=new OrderWholeRoad();
			owd.setOrderID_s(orderId);
			
			IorderWholeRoadService iowrs=new OrderWholeRoadServiceImpl();
			wholeroadlist=iowrs.getBasisOrderWholeRoad(owd, ConstantUtil.pagingNot,0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String showWorkshop(){
		try {
			OrderWorkShop ows=new OrderWorkShop();
			ows.setOrderID_s(orderId);
			
			IorderWorkShopService iwss=new OrderWorkShopServiceImpl();
			workshoplist=iwss.getBasisWorkShop(ows,ConstantUtil.pagingNot, 0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String showVehicle(){
		try {
			if(Integer.valueOf(status) > 3){
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
		}
		return SUCCESS;
	}

	
	

	public List<OrderHotelOther> getHotelotherlist() {
		return hotelotherlist;
	}
	public void setHotelotherlist(List<OrderHotelOther> hotelotherlist) {
		this.hotelotherlist = hotelotherlist;
	}
	public List<OrderPreRoad> getPreroadlist() {
		return preroadlist;
	}
	public void setPreroadlist(List<OrderPreRoad> preroadlist) {
		this.preroadlist = preroadlist;
	}
	public List getRegisterlist() {
		return registerlist;
	}
	public void setRegisterlist(List registerlist) {
		this.registerlist = registerlist;
	}
	public List<OrderSharingRoad> getSharingroadlist() {
		return sharingroadlist;
	}
	public void setSharingroadlist(List<OrderSharingRoad> sharingroadlist) {
		this.sharingroadlist = sharingroadlist;
	}
	public List<OrderWholeRoad> getWholeroadlist() {
		return wholeroadlist;
	}
	public void setWholeroadlist(List<OrderWholeRoad> wholeroadlist) {
		this.wholeroadlist = wholeroadlist;
	}

	public List<OrderWorkShop> getWorkshoplist() {
		return workshoplist;
	}

	public void setWorkshoplist(List<OrderWorkShop> workshoplist) {
		this.workshoplist = workshoplist;
	}
	public List getVehiclelist() {
		return vehiclelist;
	}
	public void setVehiclelist(List vehiclelist) {
		this.vehiclelist = vehiclelist;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List getInfolist() {
		return infolist;
	}


	public void setInfolist(List infolist) {
		this.infolist = infolist;
	}



}
