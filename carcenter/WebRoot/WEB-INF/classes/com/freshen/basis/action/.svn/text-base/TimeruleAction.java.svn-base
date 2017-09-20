package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.ITimeRuleService;
import com.freshen.basis.service.impl.TimeRuleServiceImpl;
import com.freshen.entity.TimeRule;
import com.freshen.entity.basis.Employee;
import com.freshen.util.BasicTools;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class TimeruleAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	List<TimeRule> timerulelist=new ArrayList<TimeRule>();
	String timeQuantum_s;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	/**
	 * 查询所有禁用时间段规则，用于显示
	 * sharonyshi 2014-07-14
	 */
	public String execute(){
		try {
			ITimeRuleService itrs=new TimeRuleServiceImpl();
			
			ArrayList<TimeRule> templist=itrs.getTimeRule(null, ConstantUtil.pagingNot,0);
			//如果有值，将字段分割
			if(BasicTools.isnotNull(templist)){
				String tq[]=templist.get(0).getTimeQuantum_s().split("vv");
				for (int i = 0; i < tq.length; i++) {
					//将时间段分割用于显示
					TimeRule trtemp=new TimeRule();
					trtemp.setTimeQuantum_s(tq[i].toString());
					timerulelist.add(trtemp);
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
	
	
	public String prepareTimerule(){
		try {
			//准备添加或者更新操作，目前定为只是新增，所以暂时无需查询
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
	 * 添加新的禁用时间段规则
	 * sharonyshi 2014-07-14
	 */
	public String addTimerule(){
		try {
			//先取出已经存在的禁用时间规则
			ITimeRuleService itrs=new TimeRuleServiceImpl();
			ArrayList<TimeRule> templist=itrs.getTimeRule(null, ConstantUtil.pagingNot,0);
			
			TimeRule tr=new TimeRule();
			//说明数据库中有数据
			
			if(BasicTools.isnotNull(templist)){
				//设置时间规则
				if(templist.get(0).getTimeQuantum_s()!=null && !templist.get(0).getTimeQuantum_s().equals("")){
					tr.setTimeQuantum_s(templist.get(0).getTimeQuantum_s()+"vv"+timeQuantum_s);
				}else{
					tr.setTimeQuantum_s(timeQuantum_s);
				}
			}else{
				tr.setTimeQuantum_s(timeQuantum_s);
			}
			tr.setCreateDate_t(DateUtil.getCurrentDate());
			tr.setCreateUser_s(employ.getCustomerUserName_s());
			
			//封装成list
			ArrayList<TimeRule> trlist=new ArrayList<TimeRule>();
			trlist.add(tr);
			
			ITimeRuleService its=new TimeRuleServiceImpl();
			its.OperationTimeRule(trlist,1);
			
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
	 * 删除禁用时间段规则
	 * sharonyshi 2014-07-14
	 */
	public String deleteTimerule(){
		try {
			//先取出已经存在的禁用时间规则
			ITimeRuleService itrs=new TimeRuleServiceImpl();
			ArrayList<TimeRule> templist=itrs.getTimeRule(null, ConstantUtil.pagingNot,0);
			String newtr="";
			if(BasicTools.isnotNull(templist)){
				String tq[]=templist.get(0).getTimeQuantum_s().split("vv");
				for (int i = 0; i < tq.length; i++) {
					if(!tq[i].equals(timeQuantum_s)){
						newtr += tq[i]+"vv";
					}
				}
				newtr= newtr.substring(0,newtr.length()-2);
			}
			
			//设置要删除的时间规则
			TimeRule tr=new TimeRule();
			tr.setTimeQuantum_s(newtr);
			tr.setCreateDate_t(DateUtil.getCurrentDate());
			tr.setCreateUser_s(employ.getCustomerUserName_s());
			
			//封装成list
			ArrayList<TimeRule> trlist=new ArrayList<TimeRule>();
			trlist.add(tr);
			
			ITimeRuleService its=new TimeRuleServiceImpl();
			its.OperationTimeRule(trlist,1);
			
			//删除之后重新查询所有信息，用于显示
			execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	public List<TimeRule> getTimerulelist() {
		return timerulelist;
	}
	public void setTimerulelist(List<TimeRule> timerulelist) {
		this.timerulelist = timerulelist;
	}
	public String getTimeQuantum_s() {
		return timeQuantum_s;
	}
	public void setTimeQuantum_s(String timeQuantum_s) {
		this.timeQuantum_s = timeQuantum_s;
	}
	
	
	
}
