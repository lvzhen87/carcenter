package com.freshen.action.cost;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.cost.service.impl.OrdercostInfoServiceImpl;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.cost.OrdercostInfo;
import com.freshen.entity.cost.OrderroadcostTemp;
import com.freshen.entity.reception.ReceptionVehicleInfo;

import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;

import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;

import com.freshen.util.ExceptionDispose;

/**
 *  Class Name: OrderCostAction.java
 *  Function:处理订单 费用估算
 *     Modifications:   
 *  @author Freshen  DateTime 2014-7-22 上午10:38:05    
 *  @version 1.0
 */
public class OrderCostAction extends CapgActionSupport {
	private String orderID;	//条件查询 订单编号
	private int states;		//条件查询 订单状态
	private List<OrderDetail>ordersList;	//封装订单对象的集合
	private int pageSize=ConstantUtil.pageSize,currentPage=0,maxPage,maxCount;
	private int type;	//标识 请求信息  来源，1 来源于 道路费用修改请求，2 来源于车间费用请求，3 来源于 其他费用修改
	
	private OrderDetail orderDetail;	//订单对象，页面上可以 显示其中的内容
	private List<OrdercostInfo>	orderCostInfos	;//订单 下  消费的 具体明细对象
	private List<OrdercostInfo>	orderOtherlist	;//订单 下  消费的 具体明细对象 
	private List<OrderroadcostTemp>	roadcostlist	;//订单 下  消费的 具体明细对象 
	private int carNum;		//专为页面显示  该订单车辆数目
	private double totalMoney = 0;	//专为页面提供 总价
	
	private String errmsg;	//
	/**
	 * 初始化订单核算页面 
	 */
	public String execute(){
		if(type==1){
			return "type1";
		}else if(type==2){
			return "type2";
		}else if(type==3){
			return "type3";
		}
		searchOrderCost();
		return SUCCESS;
		
	}
	/**
	 *  Function:条件查询 估算订单
	 *  @author Freshen  DateTime 2014-7-22 上午10:54:58
	 *  @return
	 */
	public String searchOrderCost(){
		//将查询条件 封装成 OrderDetail对象
		OrderDetail order =new OrderDetail();
		if(orderID!=null && orderID.trim().length()>5)
			order.setOrderID_s(orderID);
		if(states!=-1)
		{
			order.setStatus_i(states);
		}
		//调用业务逻辑
		try {
			IorderInfoService orderInfoSer =new OrderInfoServiceImpl();
			//获取 符合条件的记录总数
			maxCount=(int) orderInfoSer.getOrderInfoNumber(order);
			maxPage=maxCount%pageSize==0?maxCount/pageSize:maxCount/pageSize+1;
			if(currentPage<0)currentPage=0;
			if(currentPage>maxPage)currentPage=maxPage;
			ArrayList<OrderDetail> orders=orderInfoSer.getOrder(order, currentPage*pageSize, pageSize);
			//System.out.println("订单估算  查出订单条数 "+orders.size());
			setOrdersList(orders);
			setErrmsg("");
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		if(type==1){
			return "type1";
		}else if(type==2){
			return "type2";
		}else if(type==3){
			return "type3";
		}
		return SUCCESS;
	}
	/**
	 *  Function: 查询某一订单 详细 费用，跳转到 对应页面
	 *  @author Freshen  DateTime 2014-7-22 下午12:34:06
	 *  @return
	 */
	/*public String costDetailold(){
		if(orderID==null || orderID.trim().length()<2){
			return SUCCESS;
		}
		try {
			//查询 订单对象
			IorderInfoService orderSer =new OrderInfoServiceImpl();
			OrderDetail tempOrder =new OrderDetail();
			tempOrder.setOrderID_s(orderID);
			ArrayList<OrderDetail> ls=orderSer.getOrder(tempOrder);
			if(ls!=null && ls.size()>0){
				setOrderDetail(ls.get(0));
			}else{
				return SUCCESS;
			}
			//查询订单 消费明细的 对象			
			IOrdercostInfoService iOrdercostInfoService = new OrdercostInfoServiceImpl();
			List<OrdercostInfo> orderCostInfs = iOrdercostInfoService.getAllOrdercostInfo(orderID);
			IorderPreRoadService iorderPreRoadService = new OrderPreRoadServiceImpl();		
			List<OrdercostInfo> orderCostInfs = iorderPreRoadService.getPreRoadcostInfo(orderID);
			setOrderCostInfos(orderCostInfs);		//设置页面显示的集合
			if(orderCostInfos!=null){
				setOrderCostInfos(orderCostInfos);
				//计算总价
				for (int i = 0; i < orderCostInfos.size(); i++) {
					OrdercostInfo c=orderCostInfos.get(i);
					totalMoney+=c.getTotalprice();
				}
				setTotalMoney(totalMoney);
				//System.out.println("查出订单 "+orderID +" 的消费明细 项目数 "+orderCostInfos.size());
			}
			//查车辆数目
			IreceptionVehicleInfoService rvser=new ReceptionVehicleInfoServiceImpl();
			ReceptionVehicleInfo rvinfo=new ReceptionVehicleInfo();
			rvinfo.setOrderID_s(orderID);
			int n=(int) rvser.getReceptionVehicleInfoNumber(rvinfo);
			setCarNum(n);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return SUCCESS;
	}*/
	
	/**
	 *  Function: 查询某一订单 详细 费用，跳转到 对应页面
	 *  @author Freshen  DateTime 2014-7-22 下午12:34:06
	 *  @return
	 */
	public String costDetail(){
		if(orderID==null || orderID.trim().length()<2){
			return SUCCESS;
		}
		try {
			//查询 订单对象
			IorderInfoService orderSer =new OrderInfoServiceImpl();
			OrderDetail tempOrder =new OrderDetail();
			tempOrder.setOrderID_s(orderID);
			ArrayList<OrderDetail> ls=orderSer.getOrder(tempOrder);
			if(ls!=null && ls.size()>0){
				setOrderDetail(ls.get(0));
			}else{
				return SUCCESS;
			}
			//查询订单 消费明细的 对象			
			IOrdercostInfoService iOrdercostInfoService = new OrdercostInfoServiceImpl();
			List[] orderCostInfs = iOrdercostInfoService.getAllOrdercostInfo(orderID);
			/*IorderPreRoadService iorderPreRoadService = new OrderPreRoadServiceImpl();		
			List<OrdercostInfo> orderCostInfs = iorderPreRoadService.getPreRoadcostInfo(orderID);*/
			setOrderCostInfos(orderCostInfs[1]);		//设置页面显示的集合
			this.setRoadcostlist(orderCostInfs[0]);
			this.setOrderOtherlist(orderCostInfs[2]);
			if(orderCostInfos!=null){
				//计算总价
				for (int i = 0; i < orderCostInfos.size(); i++) {
					OrdercostInfo c=orderCostInfos.get(i);		
					if(c.getTotalprice()!=null){
						totalMoney+=c.getTotalprice();
					}
				}
			}
			if(roadcostlist!=null){
				//计算总价
				for (int i = 0; i < roadcostlist.size(); i++) {
					OrderroadcostTemp c=roadcostlist.get(i);
					 
					totalMoney+=c.getSumcost();
				}
			}
			if(orderOtherlist!=null){
				//计算总价
				for (int i = 0; i < orderOtherlist.size(); i++) {
					OrdercostInfo c=orderOtherlist.get(i);
					if(c.getTotalprice()!=null){
						totalMoney+=c.getTotalprice();
					}
					totalMoney+=c.getTotalprice();
				}
			}
			setTotalMoney(totalMoney);
//			//System.out.println("查出订单 "+orderID +" 的消费明细 项目数 "+orderCostInfos.size());
			//查车辆数目
			IreceptionVehicleInfoService rvser=new ReceptionVehicleInfoServiceImpl();
			ReceptionVehicleInfo rvinfo=new ReceptionVehicleInfo();
			rvinfo.setOrderID_s(orderID);
			int n=(int) rvser.getReceptionVehicleInfoNumber(rvinfo);
			setCarNum(n);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return SUCCESS;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public List<OrderDetail> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<OrderDetail> ordersList) {
		this.ordersList = ordersList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public List<OrdercostInfo> getOrderCostInfos() {
		return orderCostInfos;
	}
	public void setOrderCostInfos(List<OrdercostInfo> orderCostInfos) {
		this.orderCostInfos = orderCostInfos;
	}
	
	 
	public List<OrdercostInfo> getOrderOtherlist() {
		return orderOtherlist;
	}
	public void setOrderOtherlist(List<OrdercostInfo> orderOtherlist) {
		this.orderOtherlist = orderOtherlist;
	}
	public List<OrderroadcostTemp> getRoadcostlist() {
		return roadcostlist;
	}
	public void setRoadcostlist(List<OrderroadcostTemp> roadcostlist) {
		this.roadcostlist = roadcostlist;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
}
