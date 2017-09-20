package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.IBarrierGateService;

import com.freshen.basis.service.IOrderViewService;
import com.freshen.basis.service.ITimeRuleService;
import com.freshen.basis.service.IUnsubscribeRuleService;
import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IinterphoneInfoService;
import com.freshen.basis.service.IpreRuleService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.BarrierGateServiceImpl;
import com.freshen.basis.service.impl.EmployeeServiceImpl;
import com.freshen.basis.service.impl.InterphoneInfoServiceImpl;
import com.freshen.basis.service.impl.OrderViewServiceImpl;
import com.freshen.basis.service.impl.PreRuleServiceImpl;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.basis.service.impl.TimeRuleServiceImpl;
import com.freshen.basis.service.impl.UnsubscribeRuleServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.TimeRule;
import com.freshen.entity.ViewOrderInfo;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.entity.basis.PreRule;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.oneCard.TOnecardMjdoorBak;

import com.freshen.oneCard.service.ITOnecardMjdoorBakService;
import com.freshen.oneCard.service.impl.TOnecardMjdoorBakServiceImpl;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;

public class CatarcManageAction extends CapgActionSupport{
	
	long customerCount;			//	试验场客户数量
	long orderCount;			//	试验场订单数量
	long emplyCount;			//	试验场员工数量
	long barrierGateCount;		//	试验场道闸数量
	long roadCount;				//	试验场道路数量
	long interPhoneCount;		//	试验场对讲机数量
	long entranceCount;			//	试验场门禁数量
	long unsubscribeRule;		//	退订规则
	long subscribeTimeRule;		//	预定时间规则
	long accurateSubRule;		//	精确预定规则
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 试验场管理信息查询
	 * @author Ypeng 2014-09-23
	 */
	public String execute(){
		try {
			//	取得试验场客户数量
			Customer customer = new Customer();
			IcustomerService icus = new CustomerServiceImpl();
			//	确定记录总数
			customerCount = icus.getCustomerNubmer(customer);
			
			//	取得试验场订单数量
			ViewOrderInfo vo = new ViewOrderInfo();
			IOrderViewService iovs = new OrderViewServiceImpl();
			orderCount = iovs.getOrderinfoNum(vo);
			
			
			//	取得试验场员工数量
			Employee em = new Employee();
			IemployeeService ies = new EmployeeServiceImpl();
			//	确定记录总数
			emplyCount = ies.getEmployeesNumber(em);
			
			//	取得试验场道路数量
			RoadInfo ri = new RoadInfo();
			IroadInfoService iris = new RoadInfoServiceImpl();
			//	确定记录总数
			roadCount =iris.getRoadInfoNumber(ri);
			
			//	取得试验场道闸数量
			BarrierGate bg = new BarrierGate();
			IBarrierGateService ibgs = new BarrierGateServiceImpl();
			//	确定记录总数
			barrierGateCount = ibgs.getBasisBasisBarrierGateInfoNumber(bg);
			barrierGateCount = barrierGateCount / 2;
			
			//	取得试验场对讲机数量
			InterphoneInfo iphone = new InterphoneInfo();
			IinterphoneInfoService is = new InterphoneInfoServiceImpl();
			//	确定记录总数
			interPhoneCount = is.getBasisInterPhoneInfoNumber(iphone);
			
			//	取得试验场门禁数量
			TOnecardMjdoorBak tdoor = new TOnecardMjdoorBak();
			ITOnecardMjdoorBakService its = new TOnecardMjdoorBakServiceImpl();
			//	确定记录总数
			entranceCount = its.getTOnecardMjdoorBakNumber(tdoor);
			
			//	取得试验场退订规则
			IUnsubscribeRuleService iurs = new UnsubscribeRuleServiceImpl();
			//	确定记录总数
			unsubscribeRule = iurs.getUnsubscribeRule(null);
			
			//	取得试验场预定时间规则
			ITimeRuleService itrs = new TimeRuleServiceImpl();
			ArrayList<TimeRule> templist=itrs.getTimeRule(null, ConstantUtil.pagingNot,0);
			//如果有值，将字段分割
			if(BasicTools.isnotNull(templist)){
				String tq[]=templist.get(0).getTimeQuantum_s().split("vv");
				subscribeTimeRule = tq.length;
			} else {
				subscribeTimeRule = 0;
			}
						
			//	取得试验场精确预定规则
			IpreRuleService ips = new PreRuleServiceImpl();
			List<PreRule> rulelist = ips.getUnsubscribeRule(null, ConstantUtil.pagingNot,0);
			if(null != rulelist && rulelist.size() > 0){
				accurateSubRule = rulelist.size();
			} else {
				accurateSubRule = 0;
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


	public long getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(long customerCount) {
		this.customerCount = customerCount;
	}


	public long getOrderCount() {
		return orderCount;
	}


	public void setOrderCount(long orderCount) {
		this.orderCount = orderCount;
	}


	public long getEmplyCount() {
		return emplyCount;
	}


	public void setEmplyCount(long emplyCount) {
		this.emplyCount = emplyCount;
	}


	public long getBarrierGateCount() {
		return barrierGateCount;
	}


	public void setBarrierGateCount(long barrierGateCount) {
		this.barrierGateCount = barrierGateCount;
	}


	public long getRoadCount() {
		return roadCount;
	}


	public void setRoadCount(long roadCount) {
		this.roadCount = roadCount;
	}


	public long getInterPhoneCount() {
		return interPhoneCount;
	}


	public void setInterPhoneCount(long interPhoneCount) {
		this.interPhoneCount = interPhoneCount;
	}


	public long getEntranceCount() {
		return entranceCount;
	}


	public void setEntranceCount(long entranceCount) {
		this.entranceCount = entranceCount;
	}


	public long getUnsubscribeRule() {
		return unsubscribeRule;
	}


	public void setUnsubscribeRule(long unsubscribeRule) {
		this.unsubscribeRule = unsubscribeRule;
	}


	public long getSubscribeTimeRule() {
		return subscribeTimeRule;
	}


	public void setSubscribeTimeRule(long subscribeTimeRule) {
		this.subscribeTimeRule = subscribeTimeRule;
	}


	public long getAccurateSubRule() {
		return accurateSubRule;
	}


	public void setAccurateSubRule(long accurateSubRule) {
		this.accurateSubRule = accurateSubRule;
	}

}