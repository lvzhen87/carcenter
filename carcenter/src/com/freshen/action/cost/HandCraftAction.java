package com.freshen.action.cost;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.freshen.action.common.CapgActionSupport;

import com.freshen.cost.service.IOrderhandcraftcostService;
import com.freshen.cost.service.impl.OrderhandcraftcostServiceImpl;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.cost.TCostOrderhandcraftcost;
import com.freshen.entity.reception.ReceptionOrder;
import com.opensymphony.xwork2.ActionContext;

public class HandCraftAction extends CapgActionSupport{
	String id,orderid,ordername,cpg,start,end,remark,usercard,occutime,queryemployee,remarkS;
	Double cost;
	List<TCostOrderhandcraftcost> hclist = new ArrayList<TCostOrderhandcraftcost>();
	TCostOrderhandcraftcost handcraft = new TCostOrderhandcraftcost();
	List<ReceptionOrder> rorderlist = new ArrayList<ReceptionOrder>();
	List<Employee> elist = new ArrayList<Employee>();
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	public String execute(){
		try {
			ReceptionOrder ro =new ReceptionOrder();
			ro.setOrderName_s(ordername);
			
			TCostOrderhandcraftcost hc = new TCostOrderhandcraftcost();
			hc.setReceptionOrder(ro);
			hc.setVehicleCPG_s(cpg);
			if(start != null && start.length() > 0){
				hc.setStartoccurdatetimeT(DateUtil.getDate(start));
			}
			if(end != null && end.length() > 0){
				hc.setEndoccurdatetimeT(DateUtil.getDate(end));
			}
			
			IOrderhandcraftcostService s = new OrderhandcraftcostServiceImpl();
			totalPages = s.getTCostOrderhandcraftcostNumber(hc);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				hclist = s.getTCostOrderhandcraftcost(hc,currentPage*pageSize, pageSize);
			}
			
//			IreceptionOrderService iros = new ReceptionOrderServiceImpl();
//			rorderlist = iros.getReceptionOrder(null,ConstantUtil.pagingNot, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String prepareHandCraft(){
		try {			
			TCostOrderhandcraftcost hc = new TCostOrderhandcraftcost();
			if(id != null && id.length() > 0){
				hc.setHandcraftserialnumberS(id);
				IOrderhandcraftcostService s = new OrderhandcraftcostServiceImpl();
				List<TCostOrderhandcraftcost> temp = s.getTCostOrderhandcraftcost(hc, ConstantUtil.pagingNot, 0);
				if(temp != null && temp.size() > 0){
					handcraft = temp.get(0);
				}
				ReceptionOrder ro = new ReceptionOrder();
				ro.setStatus_s("6vv7");
				
				IreceptionOrderService irs = new ReceptionOrderServiceImpl();
				rorderlist = irs.getReceptionOrder(ro,ConstantUtil.pagingNot,0);
			}else{
				ReceptionOrder ro = new ReceptionOrder();
				ro.setStatus_s("6vv7");
				
				IreceptionOrderService irs = new ReceptionOrderServiceImpl();
				rorderlist = irs.getReceptionOrder(ro,ConstantUtil.pagingNot,0);
				handcraft = new TCostOrderhandcraftcost();
				handcraft.setOccurdatetimeT(new Date());
				handcraft.setEmployeeNameS(employ.getCustomerUserName_s());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String addHandCraft(){
		try {
			TCostOrderhandcraftcost hc = new TCostOrderhandcraftcost();
			if(id != null && id.length() > 0){
				hc.setHandcraftserialnumberS(id);
			}
			
			hc.setOrderidS(orderid);
			
			if(occutime != null && occutime.length() > 0){
				hc.setOccurdatetimeT(DateUtil.getDate(occutime));
			}
			if(cost != null && cost > 0){
				hc.setReckoncostI(Double.valueOf(cost));
			}else{
				hc.setReckoncostI(Double.valueOf(0));
			}
			hc.setCustomerusercardS(usercard);
			hc.setVehicleCPG_s(cpg);
			hc.setEmployeeidS(employ.getEmployeeID_s());
			hc.setCreatedateT(DateUtil.getCurrentDate());
			hc.setCreateuserS(employ.getEmployeeID_s());
			hc.setRemarkS(remarkS);
			hc.setEmployeeNameS(queryemployee);
			ArrayList<TCostOrderhandcraftcost> hlist = new ArrayList<TCostOrderhandcraftcost>();
			hlist.add(hc);
			
			IOrderhandcraftcostService s = new OrderhandcraftcostServiceImpl();
			s.OperationTCostOrderhandcraftcost(hlist, 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			 HttpServletResponse response = ServletActionContext.getResponse();
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out;
			try {
				out = response.getWriter();
				out.print(errmsg);
				out.flush();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			 
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		this.setErrmsg("");
		return SUCCESS;
	}
	
	public String deleteHandCraft(){
		try {
			TCostOrderhandcraftcost hc = new TCostOrderhandcraftcost();
			hc.setHandcraftserialnumberS(id);
			
			ArrayList<TCostOrderhandcraftcost> hlist = new ArrayList<TCostOrderhandcraftcost>();
			hlist.add(hc);
			
			IOrderhandcraftcostService s = new OrderhandcraftcostServiceImpl();
			s.OperationTCostOrderhandcraftcost(hlist, 2);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getCpg() {
		return cpg;
	}

	public void setCpg(String cpg) {
		this.cpg = cpg;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUsercard() {
		return usercard;
	}

	public void setUsercard(String usercard) {
		this.usercard = usercard;
	}

	public String getOccutime() {
		return occutime;
	}

	public void setOccutime(String occutime) {
		this.occutime = occutime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<TCostOrderhandcraftcost> getHclist() {
		return hclist;
	}

	public void setHclist(List<TCostOrderhandcraftcost> hclist) {
		this.hclist = hclist;
	}

	public TCostOrderhandcraftcost getHandcraft() {
		return handcraft;
	}

	public void setHandcraft(TCostOrderhandcraftcost handcraft) {
		this.handcraft = handcraft;
	}

	public List<ReceptionOrder> getRorderlist() {
		return rorderlist;
	}

	public void setRorderlist(List<ReceptionOrder> rorderlist) {
		this.rorderlist = rorderlist;
	}

	public List<Employee> getElist() {
		return elist;
	}

	public void setElist(List<Employee> elist) {
		this.elist = elist;
	}

	public Employee getEmploy() {
		return employ;
	}

	public void setEmploy(Employee employ) {
		this.employ = employ;
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

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getQueryemployee() {
		return queryemployee;
	}

	public void setQueryemployee(String queryemployee) {
		this.queryemployee = queryemployee;
	}

	public String getRemarkS() {
		return remarkS;
	}

	public void setRemarkS(String remarkS) {
		this.remarkS = remarkS;
	}
	
	
	
}
