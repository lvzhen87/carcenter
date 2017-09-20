package com.freshen.action.common;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * action的父类    
 * 项目名称：carcenter    
 * 类名称：CapgActionSupport    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-8-7 上午11:26:46    
 * 修改人：kxc    
 * 修改时间：2014-8-7 上午11:26:46    
 * 修改备注：    
 * @version     
 *
 */
public class CapgActionSupport extends ActionSupport{

	public String errmsg = "";
	
	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	public void mm(){
//		//System.out.println("mm");
	}
	
}
