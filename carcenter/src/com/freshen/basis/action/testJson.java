package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class testJson extends CapgActionSupport{
	//String gateID,gateNumber,newgateNumber,gateType,gateCompany,entranceRoadID,outRoadID;
	String gateID,gateNumber,newgateNumber,gateType,entranceRoadID,outRoadID;
	int status;
	List<BarrierGate> barriergateList=new ArrayList<BarrierGate>();//记录道闸信息
	ArrayList<RoadInfo> roadforbarrier=new ArrayList<RoadInfo>();//道路信息
	BarrierGate barriergate=new BarrierGate();//要更新的道闸信息
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	int isUpdate;
	String errmsg;
	
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=15;
	List<WorkShopInfo> list=new ArrayList<WorkShopInfo>();//存放转换后的json树
	public final static String closepage = "closepage";
	
	String Dptid;
	
	public String getDptid() {
		return Dptid;
	}
	public void setDptid(String dptid) {
		Dptid = dptid;
	}
	/**
	 * 默认查询所有道闸信息，当有查询条件时查询该道闸记录
	 * @author sharonyshi 2014-5-12
	 */
	public String execute(){
		try {
			//System.out.println("Dptid-->"+Dptid);
			WorkShopInfoServiceImpl its=new WorkShopInfoServiceImpl();
			list=its.getWorkShopInfo(null);
			String json = JSONArray.fromObject(list).toString();
			
			String s="[{\"id\":\"BM001\",\"text\": \"试验场\",\"iconCls\": \"icon-ok\",\"state\": \"closed\"}," +
			"{\"id\":\"BM001\",\"text\": \"试验场\",\"iconCls\": \"icon-ok\",\"state\": \"closed\"},"+
			"{\"id\":\"BM001\",\"text\": \"试验场\",\"iconCls\": \"icon-ok\",\"state\": \"closed\"},"+
				"{\"id\":\"Dept00\",\"text\": \"试验场\",\"iconCls\": \"icon-ok\",\"state\": \"closed\"}]";
			  
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			response.getWriter().write(json);
            response.getWriter().flush();
			
//            HttpServletResponse response=ServletActionContext.getResponse();  
//            response.setContentType("text/html;charset=UTF-8"); 
//            //以下代码从JSON.java中拷过来的  
//            response.setContentType("text/html");  
//            PrintWriter out;  
//            out = response.getWriter();  
//            //将要被返回到客户端的对象  
//            BarrierGate user=new BarrierGate();  
//            user.setGateID_s("321321");
//            user.setCreateUser_s("432432");
//            user.setGateNumber_s("fdsafdsa"); 
//            JSONObject json=new JSONObject();  
//            json.accumulate("success", true);  
//            json.accumulate("user", user);  
//            out.println(json.toString());  
            
		} catch (Exception e) {
			//System.out.println(e.toString());
			// TODO: handle exception
			ExceptionDispose.saveExceptionInfo(e);
		}
		return SUCCESS;
	}
	public String getGateID() {
		return gateID;
	}

	public void setGateID(String gateID) {
		this.gateID = gateID;
	}

	public String getGateType() {
		return gateType;
	}

	public void setGateType(String gateType) {
		this.gateType = gateType;
	}

//	public String getGateCompany() {
//		return gateCompany;
//	}
//
//	public void setGateCompany(String gateCompany) {
//		this.gateCompany = gateCompany;
//	}
	public List<BarrierGate> getBarriergateList() {
		return barriergateList;
	}

	public void setBarriergateList(List<BarrierGate> barriergateList) {
		this.barriergateList = barriergateList;
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


	public ArrayList<RoadInfo> getRoadforbarrier() {
		return roadforbarrier;
	}


	public void setRoadforbarrier(ArrayList<RoadInfo> roadforbarrier) {
		this.roadforbarrier = roadforbarrier;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	public BarrierGate getBarriergate() {
		return barriergate;
	}

	public void setBarriergate(BarrierGate barriergate) {
		this.barriergate = barriergate;
	}

	public String getEntranceRoadID() {
		return entranceRoadID;
	}

	public void setEntranceRoadID(String entranceRoadID) {
		this.entranceRoadID = entranceRoadID;
	}

	public String getOutRoadID() {
		return outRoadID;
	}

	public void setOutRoadID(String outRoadID) {
		this.outRoadID = outRoadID;
	}
	
	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getGateNumber() {
		return gateNumber;
	}

	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}

	public String getNewgateNumber() {
		return newgateNumber;
	}

	public void setNewgateNumber(String newgateNumber) {
		this.newgateNumber = newgateNumber;
	}
}
