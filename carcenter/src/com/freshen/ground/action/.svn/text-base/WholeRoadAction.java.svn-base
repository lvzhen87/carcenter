package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IUnsubscribeRuleService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.basis.service.impl.UnsubscribeRuleServiceImpl;
import com.freshen.clims.baseclass.ServiceImpl;
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.UnsubscribeRule;
import com.freshen.entity.cost.TCostOrderunsubscribecost;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class WholeRoadAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	List<OrderWholeRoad> wholeroadlist=new ArrayList<OrderWholeRoad>();
	OrderWholeRoad wholeroad=new OrderWholeRoad();
	List<RoadInfo> roadinfolist=new ArrayList<RoadInfo>();
	List<UnsubscribeRule> rulelist=new ArrayList<UnsubscribeRule>();//存放退订规则信息	
	
	String orderWholeRoadID_s,card;		//子订单编号
	private String errmsg;
	public String execute(){
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

	/**
	 *  Function: 查询出某一 条  包场信息的数据
	 *  @author Freshen  DateTime 2014-8-4 下午04:19:28
	 *  @return
	 */
	public String initWholeRoad(){
		try {
			OrderWholeRoad wr=new OrderWholeRoad();
			wr.setOrderWholeRoadID_s(orderWholeRoadID_s);
			
			IorderWholeRoadService iowrs=new OrderWholeRoadServiceImpl();
			List<OrderWholeRoad> list=iowrs.getBasisOrderWholeRoad(wr, ConstantUtil.pagingNot,0);
			if(list!=null){
				wholeroad=list.get(0);
			}
			
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadinfolist=irs.getRoadInfo(null, ConstantUtil.pagingNot, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return SUCCESS;
	}
	/**
	 *  Function:跳转到 新添加  包场记录 页面
	 *  @author Freshen  DateTime 2014-8-4 下午04:32:27
	 *  @return
	 */
	public String addWholeRoad(){
		try {
			//查询道路信息
			RoadInfo sr=new RoadInfo();
			sr.setRoadType_s("1");//查询共享道路
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadinfolist=irs.getRoadInfo(sr, ConstantUtil.pagingNot,0);
			//将查出的 道路集合 放在 session中，避免每次 确认时间段 还需要 重新查 道路
			ActionContext.getContext().getSession().put("roadinfolist", roadinfolist);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return SUCCESS;
	}
	/**
	 *  Function:删除 包场 的某一条记录
	 *  @author Freshen  DateTime 2014-8-4 下午04:22:39
	 *  @return
	 */
	public String delWholeRoad(){
		try {
			/*2014-8-21注释sharonyshi
			 * OrderWholeRoad wr=new OrderWholeRoad();
			wr.setOrderWholeRoadID_s(orderWholeRoadID_s);
			//调用业务逻辑，删除
			IorderWholeRoadService wrSer=new OrderWholeRoadServiceImpl();
			List<OrderWholeRoad> ls=new ArrayList<OrderWholeRoad> ();
			ls.add(wr);
			wrSer.OperationOrderWholeRoad(ls, 2);*/
			TCostOrderunsubscribecost tcost = new TCostOrderunsubscribecost();
			tcost.setOrderSubscribeidS(orderWholeRoadID_s);
			tcost.setCustomerUsercardS(card);
			tcost.setSubscribetypeI(1);
			OrderWholeRoad wr=new OrderWholeRoad();
			wr.setOrderWholeRoadID_s(orderWholeRoadID_s);
			wr.setResaveds3_s("1");
			List<OrderWholeRoad> wrlist=new ArrayList<OrderWholeRoad>();
			wrlist.add(wr);
			
			
			Object[] o1 = {tcost,Integer.valueOf(1)};
			Object[] o2 = {wrlist,Integer.valueOf(1)};
			List<ServiceImpl> se = new ArrayList();
			ServiceImpl tmp1 = new ServiceImpl("com.freshen.cost.service.impl.OrderUnsubscribeCostServiceImpl","OperationTCostOrderothercost",o1);
			ServiceImpl tmp2 = new ServiceImpl("com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl","OperationOrderWholeRoadWithoutTx",o2);
			se.add(tmp1);
			se.add(tmp2);
			ServiceImpl.invoke(se);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
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
			for (int i = 0; i < rulelist.size(); i++) {
				//System.out.println(rulelist.get(i).toString());
			}
			
			//System.out.println(orderWholeRoadID_s);
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



	public List<OrderWholeRoad> getWholeroadlist() {
		return wholeroadlist;
	}



	public OrderWholeRoad getWholeroad() {
		return wholeroad;
	}


	public void setWholeroad(OrderWholeRoad wholeroad) {
		this.wholeroad = wholeroad;
	}


	public List<RoadInfo> getRoadinfolist() {
		return roadinfolist;
	}


	public void setRoadinfolist(List<RoadInfo> roadinfolist) {
		this.roadinfolist = roadinfolist;
	}


	public String getOrderWholeRoadID_s() {
		return orderWholeRoadID_s;
	}


	public void setOrderWholeRoadID_s(String orderWholeRoadID_s) {
		this.orderWholeRoadID_s = orderWholeRoadID_s;
	}


	public void setWholeroadlist(List<OrderWholeRoad> wholeroadlist) {
		this.wholeroadlist = wholeroadlist;
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
