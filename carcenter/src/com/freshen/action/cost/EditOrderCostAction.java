package com.freshen.action.cost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;

import com.freshen.cost.service.ICostOrderotherchargebasisService;
import com.freshen.cost.service.IOrderRoadCostBasisService;
import com.freshen.cost.service.IOrderWorkShopCostBasisService;
import com.freshen.cost.service.impl.CostOrderotherchargebasisServiceImpl;
import com.freshen.cost.service.impl.OrderRoadCostBasisServiceImpl;
import com.freshen.cost.service.impl.OrderWorkShopCostBasisServiceImpl;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.entity.cost.TCostOrderotherchargebasis;
import com.freshen.entity.cost.TCostOrderroadcostbasis;
import com.freshen.entity.cost.TCostOrderworkshopcostbasis;
import com.freshen.entity.reception.ReceptionOrder;

import com.freshen.util.ConstantUtil;
import com.freshen.util.BasicTools;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;

import com.opensymphony.xwork2.ActionContext;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;

/**
 *  Class Name: EditOrderCostAction.java
 *  Function:修改 订单 费用
 *     Modifications:   
 *  @author   DateTime 2014-7-22 下午05:22:34    
 *  @version 1.0
 */
public class EditOrderCostAction extends CapgActionSupport {
	private int type=1;	//标志位，1 修改道路费用，2 修改车间费用，3 修改其他费用， 
	private String orderID;	//订单编号
	
	private ReceptionOrder receptionorder;//接待订单基本信息
	private TCostOrderroadcostbasis costRoad; // 道路费用 对象
	private List<TCostOrderroadcostbasis> costRoads; //待更新的 道路费用 对象
	private TCostOrderworkshopcostbasis costWorkshop; //车间费用对象
	private List<TCostOrderworkshopcostbasis> costWorkshops; //待更新的 车间费用对象
	private TCostOrderotherchargebasis costOther;	//待更新的其他费用对象
	
	
	private String errmsg;
	/**
	 * 初始化  费用更新页面，根据更新不同的内容 ，查询相应数据
	 */
	public String execute(){
		if(orderID==null || orderID.trim().length()<2){
			setErrmsg("订单编号丢失，数据查询终止.");
			return SUCCESS;
		}
		try {
			ReceptionOrder ro=new ReceptionOrder();
			ro.setOrderID_s(orderID);
			
			IreceptionOrderService iros=new ReceptionOrderServiceImpl();
			ArrayList<ReceptionOrder> rlist =iros.getReceptionOrder(ro,ConstantUtil.pagingNot,ConstantUtil.pageSize);
			if(BasicTools.isnotNull(rlist)){
				receptionorder= rlist.get(0);
			}
			
			if(type==1){
				TCostOrderroadcostbasis costRoad =new TCostOrderroadcostbasis();
//				CostRoadID crid=new CostRoadID();
//				crid.setOrderid_S(orderID);
//				costRoad.setCostRoadID(crid);
				costRoad.setOrderidS(orderID);
				IOrderRoadCostBasisService costRoadSer =new OrderRoadCostBasisServiceImpl();
				costRoads=costRoadSer.getTCostOrderroadcostbasis(costRoad,ConstantUtil.pagingNot,1);
				//用于显示道路名称，2014-10-10sharonyshi
				if(costRoads !=null && costRoads.size()>0){
					for (int i = 0; i < costRoads.size(); i++) {
						RoadInfo r=new RoadInfo();
						r.setRoadID_s(costRoads.get(i).getRoadidS());
						
						IroadInfoService irs=new RoadInfoServiceImpl();
						ArrayList<RoadInfo> temp=irs.getRoadInfo(r);
						if(temp != null && temp.size()>0){
							costRoads.get(i).setRoadName(temp.get(0).getRoadName_s());
						}
					}
				}
				
				
				
				return "type1";
			}else if(type==2){
				TCostOrderworkshopcostbasis costWork =new TCostOrderworkshopcostbasis();
				costWork.setOrderidS(orderID);
				IOrderWorkShopCostBasisService costWorkSer=new OrderWorkShopCostBasisServiceImpl();
				costWorkshops=costWorkSer.getTCostOrderworkshopcostbasis(costWork, ConstantUtil.pagingNot, 1);
				//用于显示道路名称，2014-10-10sharonyshi
				if(costWorkshops !=null && costWorkshops.size()>0){
					for (int i = 0; i < costWorkshops.size(); i++) {
						WorkShopInfo ws=new WorkShopInfo();
						ws.setWorkShopID_s(costWorkshops.get(i).getWorkshopidS());
						
						IworkShopInfoService iws=new WorkShopInfoServiceImpl();
						ArrayList<WorkShopInfo> temp=iws.getWorkShopInfo(ws);
						if(temp != null && temp.size()>0){
							costWorkshops.get(i).setWorkshopName(temp.get(0).getWorkShopName_s());
						}
					}
				}
				
				return "type2";
			}else if(type==3){
				TCostOrderotherchargebasis costOther =new TCostOrderotherchargebasis();
				costOther.setOrderidS(orderID);
				ICostOrderotherchargebasisService costOtherSer =new CostOrderotherchargebasisServiceImpl();
				ArrayList<TCostOrderotherchargebasis> rs=costOtherSer.getTCostOrderotherchargebasis(costOther, ConstantUtil.pagingNot, 1);
				if(rs!=null && rs.size()>0)
					setCostOther(rs.get(0));
				return "type3";
			}
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
	 *  Function:更新 路面费用
	 *  @author Freshen  DateTime 2014-7-23 上午10:33:48
	 *  @return
	 */
	public String updateRoadCost(){
//		//System.out.println("更新 道路费用  "+costRoad +" 订单id="+orderID );
		//补充修改 时间 和修改人
		try {
			costRoad.setLastupdatedateT(DateUtil.getCurDBDate());
			Map mapSess =ActionContext.getContext().getSession();
			Employee loginUser=(Employee)mapSess.get("loginEmployee");
			costRoad.setLastupdateuserS(loginUser.getCustomerUserName_s());	//修改人姓名
			//costRoad.setRemarkS(new String(costRoad.getRemarkS().getBytes("ISO-8859-1"),"UTF-8"));
			IOrderRoadCostBasisService costRoadSer =new OrderRoadCostBasisServiceImpl();
			List<TCostOrderroadcostbasis>ls =new ArrayList<TCostOrderroadcostbasis>();
			ls.add(costRoad);
			int r =costRoadSer.OperationTCostOrderroadcostbasis(ls, 1);
			if(r>0){
				setErrmsg("更新操作成功执行");
			}else{
				setErrmsg("更新操作失败");
			}
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
	 *  Function:更新 车间费用
	 *  @author Freshen  DateTime 2014-7-23 上午10:33:48
	 *  @return
	 */
	public String updateWorkshopCost(){
//		//System.out.println("更新 车间费用  "+costWorkshop + " orderid ="+orderID);
		//补充修改 时间 和修改人
		try {
			costWorkshop.setLastupdatedateT(DateUtil.getCurDBDate());
			Map mapSess =ActionContext.getContext().getSession();
			Employee loginUser=(Employee)mapSess.get("loginEmployee");
			costWorkshop.setLastupdateuserS(loginUser.getCustomerUserName_s());	//修改人姓名
			costWorkshop.setRemarkS(new String (costWorkshop.getRemarkS().getBytes("ISO-8859-1"),"UTF-8"));
			IOrderWorkShopCostBasisService costWorkShopSer =new OrderWorkShopCostBasisServiceImpl();
			List<TCostOrderworkshopcostbasis>ls =new ArrayList<TCostOrderworkshopcostbasis>();
			ls.add(costWorkshop);
			int r =costWorkShopSer.OperationTCostOrderworkshopcostbasis(ls, 1);
			if(r>0){
				setErrmsg("更新操作成功执行");
			}else{
				setErrmsg("更新操作失败");
			}
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
	 *  Function:更新 其他费用
	 *  @author Freshen  DateTime 2014-7-23 上午10:33:48
	 *  @return
	 */
	public String updateOtherCost(){
//		//System.out.println("更新 其他费用  "+costOther + " orderid ="+orderID);
		//补充修改 时间 和修改人
		try {
			//costOther.setLastupdatedateT(DateUtil.getCurDBDate());
//			Map mapSess =ActionContext.getContext().getSession();
//			Employee loginUser=(Employee)mapSess.get("loginEmployee");
//			costWorkshop.setLastupdateuserS(loginUser.getCustomerUserName_s());	//修改人姓名
			
			ICostOrderotherchargebasisService costOtherSer =new CostOrderotherchargebasisServiceImpl();
			List<TCostOrderotherchargebasis>ls =new ArrayList<TCostOrderotherchargebasis>();
			ls.add(costOther);
			int r =costOtherSer.OperationTCostOrderotherchargebasis(ls, 1);
			if(r>0){
				setErrmsg("更新操作成功执行");
			}else{
				setErrmsg("更新操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return SUCCESS;
	}
	

	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public TCostOrderroadcostbasis getCostRoad() {
		return costRoad;
	}


	public void setCostRoad(TCostOrderroadcostbasis costRoad) {
		this.costRoad = costRoad;
	}


	public TCostOrderworkshopcostbasis getCostWorkshop() {
		return costWorkshop;
	}


	public void setCostWorkshop(TCostOrderworkshopcostbasis costWorkshop) {
		this.costWorkshop = costWorkshop;
	}

	public String getErrmsg() {
		return errmsg;
	}


	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}


	public String getOrderID() {
		return orderID;
	}


	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public List<TCostOrderroadcostbasis> getCostRoads() {
		return costRoads;
	}
	public void setCostRoads(List<TCostOrderroadcostbasis> costRoads) {
		this.costRoads = costRoads;
	}
	public List<TCostOrderworkshopcostbasis> getCostWorkshops() {
		return costWorkshops;
	}
	public void setCostWorkshops(List<TCostOrderworkshopcostbasis> costWorkshops) {
		this.costWorkshops = costWorkshops;
	}
	public TCostOrderotherchargebasis getCostOther() {
		return costOther;
	}
	public void setCostOther(TCostOrderotherchargebasis costOther) {
		this.costOther = costOther;
	}
	public ReceptionOrder getReceptionorder() {
		return receptionorder;
	}
	public void setReceptionorder(ReceptionOrder receptionorder) {
		this.receptionorder = receptionorder;
	}
	
}
