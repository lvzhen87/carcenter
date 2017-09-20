package com.freshen.login.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IpasswordInfoService;
import com.freshen.basis.service.impl.EmployeeServiceImpl;
import com.freshen.basis.service.impl.PasswordInfoServiceImpl;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.PasswordInfo;

import com.freshen.util.ExceptionDispose;
import com.freshen.util.ResourceTools;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;

public class LoginAction extends CapgActionSupport{
	String loginName,loginPwd,loginRole;//页面信息
	String msg;
	public String execute(){
		Employee loginEmployee=null;
		Map mapSess=ActionContext.getContext().getSession();
		//判断是否已经登录
		if(mapSess.get("loginEmployee")!=null){
			return "forward";
		}	
		
		if(loginName==null || loginName.length()<1 || loginPwd==null ||loginPwd.length()<1){
			msg="请填写登录名和密码！";
			return LOGIN;
		}
		try {
			if(ResourceTools.getDataResource("loginname").equals(loginName) && ResourceTools.getDataResource("loginpassword").equals(loginPwd)){
				
				
				loginEmployee=new Employee();
				loginEmployee.setEmployeeID_s("admin");
				loginEmployee.setEmail_s("sharonyshi@163.com");
				loginEmployee.setCustomerUserName_s("admin");
				loginEmployee.setIsOnline(1);
				
				PasswordInfo p=new PasswordInfo();
				p.setEmployeeID_s("admin");
				p.setPassword_s("admin");
			} else {
				//校验账户
				loginEmployee=new Employee();
				//loginEmployee.setEmployeeID_s(loginName);
				loginEmployee.setEmployeeLoginName(loginName);
				IemployeeService employeeSer=new EmployeeServiceImpl();
				loginEmployee = employeeSer.getEmployeeByLoginName(loginEmployee);
				if(loginEmployee==null){
					msg="员工账户不存在，请联系管理员！";
					return LOGIN;
				}
				//校验密码
				PasswordInfo pinfo=new PasswordInfo();
				pinfo.setEmployeeID_s(loginEmployee.getEmployeeID_s());
				IpasswordInfoService ipwdSer=new PasswordInfoServiceImpl();
				PasswordInfo p =ipwdSer.getPasswordInfo(pinfo);
				if(p==null || !p.getPassword_s().equalsIgnoreCase(loginPwd)){
					msg="登录错误，请确认登录名和密码！";
					return LOGIN;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		//session中记录登录者信息
		ActionContext.getContext().getSession().put("loginEmployee", loginEmployee);
		return "forward";
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLoginRole() {
		return loginRole;
	}

	public void setLoginRole(String loginRole) {
		this.loginRole = loginRole;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
