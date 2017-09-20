package com.freshen.login.action;

import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: WelcomeAction.java
 *  Function:欢迎登录，默认Action
 *     Modifications:   
 *  @author   DateTime 2014-4-17 上午10:00:48    
 *  @version 1.0
 */
public class WelcomeAction extends CapgActionSupport {
	String rs=SUCCESS;
	
	public String execute(){
		//System.out.println("welcome Action in!!!");
		return rs;
	}
	/**
	 *  Function:退出登录
	 *  @author Freshen  DateTime 2014-4-17 下午12:06:30
	 *  @return
	 */
	public String loginOut(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
