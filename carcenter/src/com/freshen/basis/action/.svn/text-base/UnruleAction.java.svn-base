package com.freshen.basis.action;

import java.util.ArrayList;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IUnsubscribeRuleService;

import com.freshen.basis.service.impl.UnsubscribeRuleServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.UnsubscribeRule;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class UnruleAction extends CapgActionSupport{
	
	ArrayList<UnsubscribeRule> unrulelist=new ArrayList<UnsubscribeRule>();
	UnsubscribeRule unrule=new UnsubscribeRule();
	
	//页面收集的信息
	String eventNumber_s,isEffect,breakPromiseDeduction_i;
	int greaterHourNumber_i,lessHourNumber_i;
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	public String initUnrule(){
		try {
			
			IUnsubscribeRuleService iurs=new UnsubscribeRuleServiceImpl();

			//UnsubscribeRule ur=new UnsubscribeRule();
			if(isEffect !=null && !isEffect.equals("")){
				unrule.setIsEffect(Integer.valueOf(isEffect));
			}else{
				unrule.setIsEffect(-1);
			}
			if(breakPromiseDeduction_i !=null && !breakPromiseDeduction_i.equals("")){
				unrule.setBreakPromiseDeduction_i(Integer.valueOf(breakPromiseDeduction_i));
			}else{
				unrule.setBreakPromiseDeduction_i(-1);
			}
			//确定记录总数
			totalPages =iurs.getUnsubscribeRule(unrule);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				unrulelist=iurs.getUnsubscribeRule(unrule, currentPage*pageSize, pageSize);
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
	 
	
	
	public String searchUnrule(){
		try {
			//UnsubscribeRule ur=new UnsubscribeRule();
			if(isEffect !=null && !isEffect.equals("")){
				unrule.setIsEffect(Integer.valueOf(isEffect));
			}else{
				unrule.setIsEffect(-1);
			}
			if(breakPromiseDeduction_i !=null && !breakPromiseDeduction_i.equals("")){
				unrule.setBreakPromiseDeduction_i(Integer.valueOf(breakPromiseDeduction_i));
			}else{
				unrule.setBreakPromiseDeduction_i(-1);
			}			
			
			IUnsubscribeRuleService iurs=new UnsubscribeRuleServiceImpl();
			//确定记录总数
			totalPages =iurs.getUnsubscribeRule(unrule);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			if(totalPages > 0){
				unrulelist=iurs.getUnsubscribeRule(unrule, currentPage*pageSize, pageSize);
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

	
	

	public String prepareUnrule(){
		try {
			//编号存在，说明是更新操作
			if(eventNumber_s !=null){
				UnsubscribeRule rule=new UnsubscribeRule();
				rule.setEventNumber_s(eventNumber_s);
				
				//查询相关信息
				IUnsubscribeRuleService iurs=new UnsubscribeRuleServiceImpl();
				unrulelist=iurs.getUnsubscribeRule(rule, ConstantUtil.pagingNot,0);
				if(unrulelist != null){
					unrule=unrulelist.get(0);
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
	
	public String addUnrule(){
		try {
			
			UnsubscribeRule rule=new UnsubscribeRule();
			if(eventNumber_s !=null && !eventNumber_s.trim().equals("")){//说明是更新操作
				rule.setEventNumber_s(eventNumber_s);
				rule.setLastUpdateDate_t(DateUtil.getCurrentDate());
				rule.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{
				rule.setCreateDate_t(DateUtil.getCurrentDate());
				rule.setCreateUser_s(employ.getCustomerUserName_s());
				rule.setLastUpdateDate_t(DateUtil.getCurrentDate());

			}
			rule.setGreaterHourNumber_i(greaterHourNumber_i);
			rule.setLessHourNumber_i(lessHourNumber_i);
			if(isEffect !=null){
				rule.setIsEffect(Integer.valueOf(isEffect));
			}
			if(breakPromiseDeduction_i != null){
				rule.setBreakPromiseDeduction_i(Integer.valueOf(breakPromiseDeduction_i));

			}
			
			ArrayList<UnsubscribeRule> UnsubscribeRuleliset=new ArrayList<UnsubscribeRule>();
			UnsubscribeRuleliset.add(rule);
			//操作，1是新增或更新
			IUnsubscribeRuleService iurs=new UnsubscribeRuleServiceImpl();
			iurs.OperationUnsubscribeRule(UnsubscribeRuleliset, 1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public String deleteUnrule(){
		try {
			//删除记录只需要有id信息
			UnsubscribeRule rule=new UnsubscribeRule();
			rule.setEventNumber_s(eventNumber_s);
			
			
			ArrayList<UnsubscribeRule> UnsubscribeRuleliset=new ArrayList<UnsubscribeRule>();
			UnsubscribeRuleliset.add(rule);
			
			//删除操作，2是删除
			IUnsubscribeRuleService iurs=new UnsubscribeRuleServiceImpl();
			iurs.OperationUnsubscribeRule(UnsubscribeRuleliset, 2);
			
			//重新查询所有数据
			//确定记录总数
			totalPages =iurs.getUnsubscribeRule(null);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			unrulelist=iurs.getUnsubscribeRule(null, currentPage*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public ArrayList<UnsubscribeRule> getUnrulelist() {
		return unrulelist;
	}


	public void setUnrulelist(ArrayList<UnsubscribeRule> unrulelist) {
		this.unrulelist = unrulelist;
	}




	public String getIsEffect() {
		return isEffect;
	}



	public void setIsEffect(String isEffect) {
		this.isEffect = isEffect;
	}



	public String getBreakPromiseDeduction_i() {
		return breakPromiseDeduction_i;
	}



	public void setBreakPromiseDeduction_i(String breakPromiseDeduction_i) {
		this.breakPromiseDeduction_i = breakPromiseDeduction_i;
	}



	public String getEventNumber_s() {
		return eventNumber_s;
	}


	public void setEventNumber_s(String eventNumber_s) {
		this.eventNumber_s = eventNumber_s;
	}


	public int getGreaterHourNumber_i() {
		return greaterHourNumber_i;
	}


	public void setGreaterHourNumber_i(int greaterHourNumber_i) {
		this.greaterHourNumber_i = greaterHourNumber_i;
	}


	public int getLessHourNumber_i() {
		return lessHourNumber_i;
	}


	public void setLessHourNumber_i(int lessHourNumber_i) {
		this.lessHourNumber_i = lessHourNumber_i;
	}


	public Employee getEmploy() {
		return employ;
	}


	public void setEmploy(Employee employ) {
		this.employ = employ;
	}


	public long getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
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


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public UnsubscribeRule getUnrule() {
		return unrule;
	}


	public void setUnrule(UnsubscribeRule unrule) {
		this.unrule = unrule;
	}
	
	
	

}
