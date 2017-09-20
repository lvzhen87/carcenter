package com.freshen.action.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;

public class ErrorProcessAction extends CapgActionSupport {
	//错误提示信息
	private String errMsg;
	private String errmsg;
	
	public String execute(){
		ActionContext context = ActionContext.getContext();   
		HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			StringBuffer sb =new StringBuffer();
			sb.append("<script type=#text/javascript#>alert(#");
			
			String str="此次操作未能成功执行！";
			if(errMsg!=null&&errMsg.trim().length()>0){
				str=errMsg;
			}else if(errmsg!=null&&errmsg.trim().length()>0){
				str=new String(errmsg.getBytes("ISO-8859-1"),"UTF-8");
				str=str.replace("\"", "\'");
			}
			sb.append(str);
			sb.append("#)</script>");
			str=sb.toString().replaceAll("#", "\"");
//			//System.out.println("处理错误的 action 执行。错误信息是 "+str);
			out.println(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
