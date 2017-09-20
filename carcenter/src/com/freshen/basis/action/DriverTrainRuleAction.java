package com.freshen.basis.action;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.IDriverTRuleService;
import com.freshen.basis.service.impl.DriverTRuleServiceImpl;
import com.freshen.entity.basis.DriverTrainingRule;
import com.freshen.entity.basis.Employee;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class DriverTrainRuleAction extends CapgActionSupport{
	int day_i;
	String id;
	DriverTrainingRule dtrainingrule=new DriverTrainingRule();
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	public String execute(){
		try {
			IDriverTRuleService idts=new DriverTRuleServiceImpl();
			dtrainingrule=idts.getTrainingRule(null);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String prepareTrainRule(){
		try {
			
			if(id != null && id.length() >0){
				DriverTrainingRule tr=new DriverTrainingRule();
				tr.setId(Integer.parseInt(id));
				IDriverTRuleService idrs=new DriverTRuleServiceImpl();
				dtrainingrule=idrs.getTrainingRule(tr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String modifyTrainRule(){
		try {
			DriverTrainingRule tr=new DriverTrainingRule();
			if(id != null && id.length()>0){//id存在是说明修改
				tr.setLastUpdateDate_t(DateUtil.getCurDBDate());
				tr.setLastUpdateUser_s(employ.getCustomerUserName_s());
				tr.setId(Integer.parseInt(id));
			}else{//说明是新增
				tr.setCreateDate_t(DateUtil.getCurrentDate());
				tr.setCreateUser_s(employ.getCustomerUserName_s());
				tr.setLastUpdateDate_t(DateUtil.getCurDBDate());
			}
			
			tr.setDay_i(day_i);
			
			IDriverTRuleService idrs=new DriverTRuleServiceImpl();
			idrs.OperationTrainingRule(tr, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	public String deleteTrainRule(){
		try {
			DriverTrainingRule tr=new DriverTrainingRule();
			tr.setId(Integer.parseInt(id));
			IDriverTRuleService idrs=new DriverTRuleServiceImpl();
			idrs.OperationTrainingRule(tr, 2);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}



	
	
	
	public int getDay_i() {
		return day_i;
	}

	public void setDay_i(int day_i) {
		this.day_i = day_i;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DriverTrainingRule getDtrainingrule() {
		return dtrainingrule;
	}
	public void setDtrainingrule(DriverTrainingRule dtrainingrule) {
		this.dtrainingrule = dtrainingrule;
	}

	
	
}
