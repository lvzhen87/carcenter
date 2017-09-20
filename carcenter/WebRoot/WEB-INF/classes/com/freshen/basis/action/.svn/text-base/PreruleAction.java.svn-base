package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IpreRuleService;
import com.freshen.basis.service.impl.PreRuleServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.PreRule;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class PreruleAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	List<PreRule> rulelist=new ArrayList<PreRule>();
	PreRule prerule=new PreRule();
	String eventNumber_s;
	int dayNumber_i;
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	public String execute(){
		try {
			IpreRuleService ips=new PreRuleServiceImpl();
			rulelist =ips.getUnsubscribeRule(null, ConstantUtil.pagingNot,0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return SUCCESS;
	}
	
	public String prepareRule(){
		try {
			PreRule p=new PreRule();
			//说明有ID，是更新操作
			if(eventNumber_s != null && !eventNumber_s.equals("")){
				p.setEventNumber_s(eventNumber_s);
				IpreRuleService ips=new PreRuleServiceImpl();
				rulelist=ips.getUnsubscribeRule(p, ConstantUtil.pagingNot,0);
				
				if(rulelist != null){
					prerule=rulelist.get(0);
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
	
	
	public String addPrerule(){
		try {
			PreRule prerule=new PreRule();
			if(eventNumber_s != null && !eventNumber_s.equals("")){
				//说明是更新操作
				prerule.setEventNumber_s(eventNumber_s);
				prerule.setLastUpdateDate_t(DateUtil.getCurrentDate());
				prerule.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{//说明是新增操作
				
				prerule.setCreateDate_t(DateUtil.getCurrentDate());
				prerule.setCreateUser_s(employ.getCustomerUserName_s());
				prerule.setLastUpdateDate_t(DateUtil.getCurrentDate());
			}
			prerule.setDayNumber_i(dayNumber_i);
			
			List<PreRule> list=new ArrayList<PreRule>();
			list.add(prerule);
			
			IpreRuleService ips=new PreRuleServiceImpl();
			ips.OperationUnsubscribeRule(list, 1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public String deletePrerule(){
		try {
			PreRule prerule=new PreRule();
			prerule.setEventNumber_s(eventNumber_s);
			
			List<PreRule> list=new ArrayList<PreRule>();
			list.add(prerule);
			
			IpreRuleService ips=new PreRuleServiceImpl();
			ips.OperationUnsubscribeRule(list, 2);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	

	public List<PreRule> getRulelist() {
		return rulelist;
	}

	public void setRulelist(List<PreRule> rulelist) {
		this.rulelist = rulelist;
	}

	public PreRule getPrerule() {
		return prerule;
	}

	public void setPrerule(PreRule prerule) {
		this.prerule = prerule;
	}

	public String getEventNumber_s() {
		return eventNumber_s;
	}

	public void setEventNumber_s(String eventNumber_s) {
		this.eventNumber_s = eventNumber_s;
	}

	public int getDayNumber_i() {
		return dayNumber_i;
	}

	public void setDayNumber_i(int dayNumber_i) {
		this.dayNumber_i = dayNumber_i;
	}
	
	
	
}
