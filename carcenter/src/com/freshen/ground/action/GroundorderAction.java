package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.freshen.action.common.CapgActionSupport;import com.freshen.basis.service.IOrderViewService;
import com.freshen.basis.service.impl.OrderViewServiceImpl;
import com.freshen.util.ConstantUtil;

import com.freshen.entity.ViewOrderInfo;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;

import com.freshen.util.ChineseTools;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;

public class GroundorderAction extends CapgActionSupport{
	String orderID,orderName,startdatepicker,enddatepicker;
	String customerName;
	int states;
	//ArrayList<OrderDetail> recorderList=new ArrayList<OrderDetail>();
	ArrayList<ReceptionOrder> recorderList=new ArrayList<ReceptionOrder>();
	ArrayList<ViewOrderInfo> orderlist=new ArrayList<ViewOrderInfo>();
	String startDate;
	String endDate;
	
	//分页
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	String flag;
	/**
	 * 默认时查询出所有的信息，若有查询条件则查询相应信息
	 * @author sharonyshi 2014-6-5
	 * @return
	 */
	
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		date = calendar.getTime();
		return date;
	}
	
	public String searchOrders(){
		try {
			//设置要查询的条件
			/*默认日期不要 sharonyshi-2014-11-21
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start = new Date();
			//System.out.println(startDate);
			//System.out.println(endDate);
			if(startDate == null)
			{
				start = getNextDay(new Date());
				//endDate = sdf.format(new Date()).toString(); 
				//startDate = sdf.format(start).toString(); 
				startDate= sdf.format(new Date()).toString(); 
				//OrderDetail ro=new OrderDetail();2014-8-25 之前默认查询预约表信息，改为查询接待表信息
			}*/
			ReceptionOrder ro=new ReceptionOrder();

			if(orderID != null && !orderID.trim().equals("") && ChineseTools.isMessyCode(orderID)){
				orderID = new String(orderID.getBytes("ISO-8859-1"),"UTF-8").trim();
			}

			if(orderName != null && !orderName.trim().replace(" ", "").equals("") && ChineseTools.isMessyCode(orderName)){
				orderName = new String(orderName.getBytes("ISO-8859-1"),"UTF-8").trim();
			}

			if(orderName==null||orderName.equals("") || orderName.equals(" "))
			{
				ro.setOrderName_s("");
			}
			else
			{

				ro.setOrderName_s(orderName);
			}
			ro.setOrderID_s(orderID);
			ro.setStatus_s("2vv3vv5vv6");
			
			////System.out.println(DateUtil.getDate(startdatepicker));
			////System.out.println(DateUtil.getDate(enddatepicker));
			if(startDate != null && !startDate.equals("")){
				ro.setStartDate_d(DateUtil.getDate(startDate));	
			}
			if(endDate != null && !endDate.equals("")){
				ro.setEndDate_d(DateUtil.getDate(endDate));
			}
			
			
			
			/*IorderInfoService ios=new OrderInfoServiceImpl();
			//确定记录总数
			totalPages =ios.getOrderInfoNumber(ro);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			recorderList=ios.getOrder(ro,currentPage*pageSize, pageSize);*/
			IreceptionOrderService irs=new ReceptionOrderServiceImpl();
			//确定记录总数
			totalPages =irs.getReceptionOrderNumber(ro);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			recorderList=irs.getReceptionOrder(ro,currentPage*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	
	public String searchOrdersShow(){
		try {
			//设置要查询的条件
			/*默认日期不要 sharonyshi-2014-11-21
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			Date start = new Date();
			//System.out.println(startDate);
			//System.out.println(endDate);
			if(startDate == null)
			{
				start = getNextDay(new Date());
				//endDate = sdf.format(new Date()).toString(); 
				//startDate = sdf.format(start).toString(); 
				startDate= sdf.format(new Date()).toString(); 
				//OrderDetail ro=new OrderDetail();2014-8-25 之前默认查询预约表信息，改为查询接待表信息
			}*/
			ViewOrderInfo vo=new ViewOrderInfo();
			if(orderID != null && !orderID.trim().equals("") && ChineseTools.isMessyCode(orderID)){
				orderID = new String(orderID.getBytes("ISO-8859-1"),"UTF-8").trim();
			}
			if(orderName != null && !orderName.trim().equals("") && ChineseTools.isMessyCode(orderName)){
				orderName = new String(orderName.getBytes("ISO-8859-1"),"UTF-8").trim();
			}
			if(customerName != null && !customerName.trim().equals("") && ChineseTools.isMessyCode(customerName)){
				customerName = new String(customerName.getBytes("ISO-8859-1"),"UTF-8").trim();
			}
			
			vo.setOrderid_s(orderID);
			vo.setOrdername_s(orderName);
			vo.setStatus_i(states);
			vo.setCustomerName_s(customerName);
			if(startDate != null && !startDate.equals("")){
				vo.setStartdate_d(DateUtil.getDate(startDate));	
			}
			if(endDate != null && !endDate.equals("")){
				vo.setEnddate_d(DateUtil.getDate(endDate));
			}
			
			IOrderViewService iovs=new OrderViewServiceImpl();
			totalPages =iovs.getOrderinfoNum(vo);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			orderlist =iovs.getOrderinfo(vo,currentPage*pageSize, pageSize);
			
			
			/*
			 *2014-9-25 sharonyshi 查询订单试图，将所有状态的订单都查询出来 
			ReceptionOrder ro=new ReceptionOrder();
			ro.setOrderID_s(orderID);
			ro.setOrderName_s(orderName);
			
			
			////System.out.println(DateUtil.getDate(startdatepicker));
			////System.out.println(DateUtil.getDate(enddatepicker));
			if(startDate != null && !startDate.equals("")){
				ro.setStartDate_d(DateUtil.getDate(startDate));	
			}
			if(endDate != null && !endDate.equals("")){
				ro.setEndDate_d(DateUtil.getDate(endDate));
			}
			
			
			
			IorderInfoService ios=new OrderInfoServiceImpl();
			//确定记录总数
			totalPages =ios.getOrderInfoNumber(ro);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			recorderList=ios.getOrder(ro,currentPage*pageSize, pageSize);
			IreceptionOrderService irs=new ReceptionOrderServiceImpl();
			//确定记录总数
			totalPages =irs.getReceptionOrderNumber(ro);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			recorderList=irs.getReceptionOrder(ro,currentPage*pageSize, pageSize);
			2014-9-25
			*/
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	

	
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public String getStartdatepicker() {
		return startdatepicker;
	}
	public void setStartdatepicker(String startdatepicker) {
		this.startdatepicker = startdatepicker;
	}
	public String getEnddatepicker() {
		return enddatepicker;
	}
	public void setEnddatepicker(String enddatepicker) {
		this.enddatepicker = enddatepicker;
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

	
	public ArrayList<ReceptionOrder> getRecorderList() {
		return recorderList;
	}

	public void setRecorderList(ArrayList<ReceptionOrder> recorderList) {
		this.recorderList = recorderList;
	}

	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public ArrayList<ViewOrderInfo> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(ArrayList<ViewOrderInfo> orderlist) {
		this.orderlist = orderlist;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
