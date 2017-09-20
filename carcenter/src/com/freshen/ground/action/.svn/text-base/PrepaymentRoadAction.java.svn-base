package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IUnsubscribeRuleService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.basis.service.impl.UnsubscribeRuleServiceImpl;
import com.freshen.clims.baseclass.ServiceImpl;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.cost.service.impl.OrdercostInfoServiceImpl;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.UnsubscribeRule;
import com.freshen.entity.cost.TCostOrderunsubscribecost;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.preorder.service.impl.OrderPreRoadServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class PrepaymentRoadAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	List<OrderPreRoad> preroadlist=new ArrayList<OrderPreRoad>();
	OrderPreRoad orderpreroad=new OrderPreRoad();
	String orderPrepaymentRoadID_s,card;		//子订单编号
	List<RoadInfo> roadinfolist=new ArrayList<RoadInfo>();
	List<UnsubscribeRule> rulelist=new ArrayList<UnsubscribeRule>();//存放退订规则信息	
	
	private String errmsg;	
	public String execute(){
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
	
	/**
	 *  Function:初始信息，前往 添加精确 预定 信息 页面
	 *  @author Freshen  DateTime 2014-8-5 下午02:18:37
	 *  @return
	 */
	public String addPreRoad(){
		try {
			RoadInfo ri=new RoadInfo();
			ri.setRoadType_s("2");//设置精确预订道路
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadinfolist=irs.getRoadInfo(ri, ConstantUtil.pagingNot, 0);
			//把道路集合  放入session， 在确定时间段时，不需要重新 刷 道路
			ActionContext.getContext().getSession().put("roadinfolist", roadinfolist);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	
	
	/**
	 *  Function:退订预订信息
	 *  @author sharonyshi  DateTime 2014-8-21 
	 *  @return
	 */
	public String delPreRoad(){
		try {
			/*2014-8-21注释 sharonyshi
			 * OrderPreRoad pr =new OrderPreRoad();
			pr.setOrderPrepaymentRoadID_s(orderPrepaymentRoadID_s);
			
			IorderPreRoadService preSer =new OrderPreRoadServiceImpl();
			List<OrderPreRoad>ls =new ArrayList<OrderPreRoad>();
			ls.add(pr);
			preSer.OperationOrderPreRoad(ls, 2);
			*/
			TCostOrderunsubscribecost tcost = new TCostOrderunsubscribecost();
			tcost.setOrderSubscribeidS(orderPrepaymentRoadID_s);
			tcost.setCustomerUsercardS(card);
			tcost.setSubscribetypeI(2);
			OrderPreRoad pr =new OrderPreRoad();
			pr.setOrderPrepaymentRoadID_s(orderPrepaymentRoadID_s);
			pr.setResaveds3_s("1");
			List<OrderPreRoad>ls =new ArrayList<OrderPreRoad>();
			ls.add(pr);
			
			Object[] o1 = {tcost,Integer.valueOf(1)};
			Object[] o2 = {ls,Integer.valueOf(1)};
			List<ServiceImpl> se = new ArrayList();
			//IOrdercostInfoService ordercostInfoServiceImpl = new OrdercostInfoServiceImpl();
			//ordercostInfoServiceImpl.ComputeOrderCost(orderId);

			ServiceImpl tmp1 = new ServiceImpl("com.freshen.cost.service.impl.OrderUnsubscribeCostServiceImpl","OperationTCostOrderothercost",o1);
			ServiceImpl tmp2 = new ServiceImpl("com.freshen.preorder.service.impl.OrderPreRoadServiceImpl","OperationOrderPreRoadWithoutTx",o2);
			se.add(tmp1);
			se.add(tmp2);
			ServiceImpl.invoke(se);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	/**
	 *  Function:查询退订规则
	 *  @author sharonyshi  DateTime 2014-8-20 下午04:22:39
	 *  @return
	 */
	public String showRules(){
		try {
			UnsubscribeRule r=new UnsubscribeRule();
			r.setIsEffect(1);//查询生效的违约条例
			IUnsubscribeRuleService ius=new UnsubscribeRuleServiceImpl();
			rulelist=ius.getUnsubscribeRule(r, ConstantUtil.pagingNot,0);
			
			//System.out.println(orderPrepaymentRoadID_s);
		} catch (Exception e) {
			// TODO: handle exception
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


	public List<OrderPreRoad> getPreroadlist() {
		return preroadlist;
	}


	public void setPreroadlist(List<OrderPreRoad> preroadlist) {
		this.preroadlist = preroadlist;
	}


	public OrderPreRoad getOrderpreroad() {
		return orderpreroad;
	}


	public void setOrderpreroad(OrderPreRoad orderpreroad) {
		this.orderpreroad = orderpreroad;
	}


	public String getOrderPrepaymentRoadID_s() {
		return orderPrepaymentRoadID_s;
	}


	public void setOrderPrepaymentRoadID_s(String orderPrepaymentRoadID_s) {
		this.orderPrepaymentRoadID_s = orderPrepaymentRoadID_s;
	}


	public List<RoadInfo> getRoadinfolist() {
		return roadinfolist;
	}


	public void setRoadinfolist(List<RoadInfo> roadinfolist) {
		this.roadinfolist = roadinfolist;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public List<UnsubscribeRule> getRulelist() {
		return rulelist;
	}

	public void setRulelist(List<UnsubscribeRule> rulelist) {
		this.rulelist = rulelist;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	
	

}
