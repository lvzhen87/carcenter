package com.freshen.login.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IAuthorPageService;
import com.freshen.basis.service.impl.AuthorPageServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.Employee;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;


/**
 * @describe 登录成功后查询员工信息，为订单分配准备
 * 目前还没有分部门，只是模拟测试阶段！！！！
 * @author sharonyshi  edit by freshen
 *
 */
public class LoginApplyAction extends CapgActionSupport{
	List<Employee> employeeList;	//存放 员工信息列表
	int numReg=0,numExp=0,numTodayReception=0,numTodayExp=0;	//统计数据
	String msg;
	/**
	 * 登录成功后查询员工信息，为订单分配准备
	 * 目前还没有分部门，只是模拟测试阶段！！！！
	 */
	public String execute(){
		Map mapSess =ActionContext.getContext().getSession();
		Employee loginUser=(Employee)mapSess.get("loginEmployee");
		if(loginUser==null){
			msg="登录错误，请重试.";
			return ERROR;
		}
		//准备 top.jsp页面所需要的数据
		try {
			//确定 待审核 客户数量
			IcustomerService cusSer=new CustomerServiceImpl();
			Customer cu=new Customer();
			cu.setStatus_i(1);	//状态为1，表示该客户实体 是提交状态
			numReg=(int) cusSer.getCustomerNubmer(cu);
			//确定 待审核的试验 数量
			IorderInfoService ordSer=new OrderInfoServiceImpl();
			OrderDetail ord=new OrderDetail();
			ord.setStatus_i(1);	//状态为1，订单已提交，需要审核
			ord.setEmployeeID_s(loginUser.getEmployeeID_s());	//查询登录员工，所分配到的试验订单
			numExp=(int) ordSer.getOrderInfoNumber(ord);
			//确定 今日接待试验数量
			ord.setStatus_i(2);	//状态为2，订单已经确认
			ord.setStartDate_t(DateUtil.getCurrentDate());	//试验开始日期为今日
			ord.setEmployeeID_s(null);	//接待员将接待所有 订单，不区分 实验助理
			numTodayReception=(int) ordSer.getOrderInfoNumber(ord);
			//确定，今日正在试验数量
			ord=new OrderDetail();
			ord.setStatus_i(56);
			numTodayExp=(int) ordSer.getOrderInfoNumber(ord);
			//将查出的统计数据放入mapSession，这些数据是在top.jsp中用的
			mapSess.put("numExp", numExp);
			mapSess.put("numReg", numReg);
			mapSess.put("numTodayReception", numTodayReception);
			mapSess.put("numTodayExp", numTodayExp);
			
			//确定 ，该员工被授权的页面
			IAuthorPageService authorSer=new AuthorPageServiceImpl();
			String authorPagesStr=authorSer.getAuthorPageString(loginUser);
			//System.out.println("员工 ："+loginUser+"被授权的页面是  "+authorPagesStr);
			mapSess.put("authorPagesStr", authorPagesStr);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		
		
		return SUCCESS;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getNumReg() {
		return numReg;
	}

	public void setNumReg(int numReg) {
		this.numReg = numReg;
	}

	public int getNumExp() {
		return numExp;
	}

	public void setNumExp(int numExp) {
		this.numExp = numExp;
	}

	public int getNumTodayReception() {
		return numTodayReception;
	}

	public void setNumTodayReception(int numTodayReception) {
		this.numTodayReception = numTodayReception;
	}

	public int getNumTodayExp() {
		return numTodayExp;
	}

	public void setNumTodayExp(int numTodayExp) {
		this.numTodayExp = numTodayExp;
	}
}

