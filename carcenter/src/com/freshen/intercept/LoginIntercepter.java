package com.freshen.intercept;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginIntercepter extends  AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map mapSess=ai.getInvocationContext().getSession();
		if(mapSess.get("loginEmployee")!=null){
			return ai.invoke();
		}
		mapSess.put("msg", "请先登录！");
		return Action.LOGIN;
		
	}

}
