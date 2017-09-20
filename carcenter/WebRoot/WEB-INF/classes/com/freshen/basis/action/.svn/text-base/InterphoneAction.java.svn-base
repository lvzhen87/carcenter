package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

import com.freshen.basis.service.IinterphoneInfoService;
import com.freshen.basis.service.impl.InterphoneInfoServiceImpl;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class InterphoneAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	String interphoneID, interphonePast, brand;	//条件查询时，所用字段
	int state;
	ArrayList<InterphoneInfo> interphonelist=new ArrayList<InterphoneInfo>();
	InterphoneInfo interphone=new InterphoneInfo();
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	String msg, flag;
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	/**
	 * 默认查询所有对讲机信息，当有查询条件时，查询该信息
	 * @author sharonyshi 2014-5-14
	 */
	public String execute(){
		try {
			//设置要查询的对讲机信息
			InterphoneInfo iphone=new InterphoneInfo();
			if(flag != null){
				if(interphoneID!=null && interphoneID.trim().length()>1){
					interphoneID=(new String(interphoneID.getBytes("ISO-8859-1"),"UTF-8" ));
				}
				if(interphonePast!=null && interphonePast.trim().length()>1){
					interphonePast=(new String(interphonePast.getBytes("ISO-8859-1"),"UTF-8" ));
				}
				if(brand!=null && brand.trim().length()>1){
					brand=(new String(brand.getBytes("ISO-8859-1"),"UTF-8" ));
				}				
			}
				
			iphone.setInterphoneID_s(interphoneID);
			iphone.setInterphonePast_s(interphonePast);
			iphone.setBrand_s(brand);
			iphone.setState_i(-1);
			IinterphoneInfoService is=new InterphoneInfoServiceImpl();
			//确定记录总数
			totalPages =is.getBasisInterPhoneInfoNumber(iphone);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			if(totalPages > 0){
				interphonelist=is.getBasisInterPhoneInfo(iphone,currentPage*pageSize, pageSize);
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
	
	/**
	 * 判断是否存在对讲机编号，若不存在说明是新增对讲机，存在则需要查询相应数据
	 * @author sharonyshi 2014-5-13
	 * @return
	 */
	public String prepareInterphone(){
		try {
			//编号存在，说明是更新操作
			if(interphoneID !=null){
				InterphoneInfo iphone=new InterphoneInfo();
				iphone.setInterphoneID_s(interphoneID);
				iphone.setState_i(-1);
				//查询相关信息
				IinterphoneInfoService is=new InterphoneInfoServiceImpl();
				interphonelist=is.getBasisInterPhoneInfo(iphone, ConstantUtil.pagingNot,0);
				if(interphonelist != null){
					interphone=interphonelist.get(0);
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
	
	
	/**
	 * 新增/更新对讲机信息，如果对讲机编号没有值，则为新增操作
	 * @author sharonyshi 2014-5-14
	 * @return
	 */
	public String addInterphone(){
		try {
			InterphoneInfo iphone=new InterphoneInfo();
			if(interphoneID !=null && !interphoneID.trim().equals("")){//说明是更新操作
				
				iphone.setLastUpdateDate_t(DateUtil.getCurrentDate());
				iphone.setLastUpdateUser_s(employ.getCustomerUserName_s());
				iphone.setCreateDate_t(DateUtil.getCurrentDate());
				iphone.setCreateUser_s(employ.getCustomerUserName_s());
			}else{
				iphone.setCreateDate_t(DateUtil.getCurrentDate());
				iphone.setCreateUser_s(employ.getCustomerUserName_s());
				iphone.setLastUpdateDate_t(DateUtil.getCurrentDate());
			}
			iphone.setInterphoneID_s(interphoneID);
			iphone.setInterphonePast_s(interphonePast);
			iphone.setBrand_s(brand);
			iphone.setState_i(state);
			
			ArrayList<InterphoneInfo> iphonelist=new ArrayList<InterphoneInfo>();
			iphonelist.add(iphone);
			 
			//删除操作，1是新增或更新
			IinterphoneInfoService iphoneService=new InterphoneInfoServiceImpl();
			iphoneService.OperationInterphoneInfo(iphonelist, 1);
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
	 * 删除对讲机信息
	 * @author sharonyshi 2014-5-14
	 * @return
	 */
	public String deleteInterphone(){
		try {
			
			//删除记录只需要有id信息	
			InterphoneInfo iphone=new InterphoneInfo();
			iphone.setInterphoneID_s(interphoneID);
			iphone.setState_i(ConstantUtil.interphoneState_3);//设置对讲机状态为停用

			ArrayList<InterphoneInfo> iphonelist=new ArrayList<InterphoneInfo>();
			iphonelist.add(iphone);
			
			
			//删除操作，2是删除
			IinterphoneInfoService iphoneService=new InterphoneInfoServiceImpl();
			boolean istrue=iphoneService.getIsVisible(interphoneID);
			if(istrue){
				msg ="对不起！该对讲机在过程管理中使用！";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println( msg);  
		        out.flush();  
		        out.close();  
			}else{
				iphoneService.OperationInterphoneInfo(iphonelist, 1);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}

	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getInterphoneID() {
		return interphoneID;
	}

	public void setInterphoneID(String interphoneID) {
		this.interphoneID = interphoneID;
	}

	public String getInterphonePast() {
		return interphonePast;
	}

	public void setInterphonePast(String interphonePast) {
		this.interphonePast = interphonePast;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ArrayList<InterphoneInfo> getInterphonelist() {
		return interphonelist;
	}

	public void setInterphonelist(ArrayList<InterphoneInfo> interphonelist) {
		this.interphonelist = interphonelist;
	}

	public InterphoneInfo getInterphone() {
		return interphone;
	}

	public void setInterphone(InterphoneInfo interphone) {
		this.interphone = interphone;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
