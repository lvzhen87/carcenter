package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.preorder.service.IorderSharingRoadService;
import com.freshen.preorder.service.impl.OrderSharingRoadServiceImpl;

import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class SharingRoadAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	List<OrderSharingRoad> sharingroadlist=new ArrayList<OrderSharingRoad>();
	OrderSharingRoad sharingroad=new OrderSharingRoad();
	private String orderID;//订单编号
	String orderSharingRoadID_s;//订单子项编号
	List<RoadInfo> roadinfolist=new ArrayList<RoadInfo>();	//存放 道路基本信息
	//共享道路  页面更新时，收集数据属性
	int status_i;
	String roadID_s;
	String roadName_s;
	String hoursNumber_s;
	String maxSpeed_s ;
	String description_s;
	Date createDate_t;
	String createUser_s;
	Date startDate_t;
	Date endDate_t;
	Integer carNumber_i;
	Integer isHighRiskTest_i;
	String highRiskTestDescription_s;
	Integer isCamera_i;
	String accidentPrevention_s;
	ArrayList<RoadInfo> roadforbarrier=new ArrayList<RoadInfo>();//道路信息
	
	public String execute(){
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
	/**
	 *  Function: 查询某个订单下，指定 子订单的 具体信息
	 *  @author Freshen  DateTime 2014-8-4 上午11:30:08
	 *  @return
	 */
	public String initSharingroad(){
		try {
			
			OrderSharingRoad r=new OrderSharingRoad();
			r.setOrderSharingRoadID_s(orderSharingRoadID_s);
			
			IorderSharingRoadService iosrs=new OrderSharingRoadServiceImpl();
			List<OrderSharingRoad> rlist=iosrs.getBasisOrderSharingRoad(r,ConstantUtil.pagingNot, 0);
			if(rlist!= null){
				sharingroad=rlist.get(0);
			}
			//查询道路信息
			//准备预定 共享道路
			if(orderSharingRoadID_s == null ){
				RoadInfo sr=new RoadInfo();
				sr.setRoadType_s("1");//查询共享道路
				
				IroadInfoService irs=new RoadInfoServiceImpl();
				roadinfolist=irs.getRoadInfo(sr, ConstantUtil.pagingNot,0);
				//System.out.println("roadinfolist length="+ roadinfolist.size());
			}
			
			//查询道路信息
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadforbarrier=irs.getRoadInfo(null);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return SUCCESS;
	}
	/**
	 *  Function: 给指导订单，添加新的 共享道路预定信息
	 *  @author Freshen  DateTime 2014-8-4 上午11:29:ConstantUtil.pageSize
	 *  @return
	 */
	public String addsharingRoad(){
		//查询道路信息
		RoadInfo sr=new RoadInfo();
		sr.setRoadType_s("1");//查询共享道路
		IroadInfoService irs=new RoadInfoServiceImpl();
		try {
			roadinfolist=irs.getRoadInfo(sr, ConstantUtil.pagingNot,0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		
		return SUCCESS;
	}
	/**
	 *  Function: 根据指导 ID，删除某条 共享预定记录
	 *  @author Freshen  DateTime 2014-8-4 上午11:29:ConstantUtil.pageSize
	 *  @return
	 */
	public String delsharingRoad(){
		//System.out.println("即将删掉  子订单  ："+orderSharingRoadID_s);
		OrderSharingRoad sr=new OrderSharingRoad();
		sr.setOrderSharingRoadID_s(orderSharingRoadID_s);
		
		try {
			IorderSharingRoadService sharSer =new OrderSharingRoadServiceImpl();
			List<OrderSharingRoad> ls =new ArrayList<OrderSharingRoad>();
			ls.add(sr);
			sharSer.OperationOrderSharingRoad(ls, 2);
			//System.out.println("删除操作结束！");
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return SUCCESS;
	}
	/**
	 *  Function:根据指定ID，修改 某条记录 中的 数据
	 *  @author Freshen  DateTime 2014-8-4 上午11:29:42
	 *  @return
	 */
	public String modifySharingRoad(){
		try {
			//将页面上的数据，封装到对象中
			Map sessMap =ActionContext.getContext().getSession();
			Employee loginUser=(Employee)sessMap.get("loginEmployee");
			sharingroad.setOrderID_s(sessMap.get("orderId").toString());
			sharingroad.setLastUpdateDate_t(DateUtil.getCurDBDate());
			sharingroad.setLastUpdateUser_s(loginUser.getCustomerUserName_s());
			sharingroad.setOrderSharingRoadID_s(orderSharingRoadID_s);	//设置子订单编号
			sharingroad.setStatus_i(status_i);
			sharingroad.setRoadID_s(roadID_s);
			sharingroad.setRoadName_s(roadName_s);
			sharingroad.setHoursNumber_s(hoursNumber_s);
			sharingroad.setAccidentPrevention_s(accidentPrevention_s);
			sharingroad.setCarNumber_i(carNumber_i);
			sharingroad.setCreateDate_t(createDate_t);
			sharingroad.setCreateUser_s(createUser_s);
			sharingroad.setDescription_s(description_s);
			sharingroad.setHighRiskTestDescription_s(highRiskTestDescription_s);
			sharingroad.setIsCamera_i(isCamera_i);
			sharingroad.setIsHighRiskTest_i(isHighRiskTest_i);
			sharingroad.setMaxSpeed_s(maxSpeed_s);
			sharingroad.setStartDate_t(startDate_t);
			sharingroad.setEndDate_t(endDate_t);
			
			
			IorderSharingRoadService sharSer =new OrderSharingRoadServiceImpl();
			List<OrderSharingRoad> ls =new ArrayList<OrderSharingRoad>();
			ls.add(sharingroad);
			//System.out.println("即将更新 共享预定 道路 ="+sharingroad);
			sharSer.OperationOrderSharingRoad(ls, 1);
			//System.out.println("更新操作结束！");
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return SUCCESS;
	}
	
	
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderSharingRoad> getSharingroadlist() {
		return sharingroadlist;
	}

	public void setSharingroadlist(List<OrderSharingRoad> sharingroadlist) {
		this.sharingroadlist = sharingroadlist;
	}



	public OrderSharingRoad getSharingroad() {
		return sharingroad;
	}



	public void setSharingroad(OrderSharingRoad sharingroad) {
		this.sharingroad = sharingroad;
	}



	public String getOrderSharingRoadID_s() {
		return orderSharingRoadID_s;
	}



	public void setOrderSharingRoadID_s(String orderSharingRoadID_s) {
		this.orderSharingRoadID_s = orderSharingRoadID_s;
	}



	public List<RoadInfo> getRoadinfolist() {
		return roadinfolist;
	}



	public void setRoadinfolist(List<RoadInfo> roadinfolist) {
		this.roadinfolist = roadinfolist;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getStatus_i() {
		return status_i;
	}
	public void setStatus_i(int status_i) {
		this.status_i = status_i;
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
	public Integer getCarNumber_i() {
		return carNumber_i;
	}
	public void setCarNumber_i(Integer carNumber_i) {
		this.carNumber_i = carNumber_i;
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
	public String getAccidentPrevention_s() {
		return accidentPrevention_s;
	}
	public void setAccidentPrevention_s(String accidentPrevention_s) {
		this.accidentPrevention_s = accidentPrevention_s;
	}
	public ArrayList<RoadInfo> getRoadforbarrier() {
		return roadforbarrier;
	}
	public void setRoadforbarrier(ArrayList<RoadInfo> roadforbarrier) {
		this.roadforbarrier = roadforbarrier;
	}
	
	

}
