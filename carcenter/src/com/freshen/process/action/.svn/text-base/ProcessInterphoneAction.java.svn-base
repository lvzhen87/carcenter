package com.freshen.process.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.IinterphoneInfoService;
import com.freshen.basis.service.impl.InterphoneInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.clims.baseclass.ServiceImpl;
import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.entity.process.TProcessInterphoneemployinfo;
import com.freshen.entity.reception.CardInfo;
import com.freshen.process.service.TProcessInterPhoneEmployinfoService;
import com.freshen.process.service.impl.TProcessInterphoneEmployinfoServiceImpl;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.util.ExceptionDispose;

public class ProcessInterphoneAction extends CapgActionSupport{
	List<TProcessInterphoneemployinfo> processlist=new ArrayList<TProcessInterphoneemployinfo>();
	
	String interphoneID_s,card,orderId;
	String processID;
	int operation_i;
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	public String execute(){
		try {
			TProcessInterphoneemployinfo tp=new TProcessInterphoneemployinfo();
			tp.setInterphoneID_s(interphoneID_s);
			tp.setOperation_i(operation_i);
			
			TProcessInterPhoneEmployinfoService tps=new TProcessInterphoneEmployinfoServiceImpl();
			//确定记录总数
			totalPages =tps.getTProcessInterPhoneEmployinfo(tp);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			processlist=tps.getTProcessInterPhoneEmployinfo(tp,currentPage*pageSize, pageSize);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}

	
	public String callbackInterphone(){
		try {
			
			CardInfo c=new CardInfo();
			c.setCard_s(interphoneID_s);
			c.setCreateDate_t(null);
			c.setLastUpdateDate_t(null);
			ArrayList<CardInfo> list = new ArrayList<CardInfo>();
			IcardInfoService ics = new CardInfoServiceImpl();
			list = ics.getReceptionCardInfo(c, -1, 0);
			
			InterphoneInfo interphone = new InterphoneInfo();
			interphone.setInterphoneID_s(interphoneID_s);
			interphone.setState_i(ConstantUtil.interphoneState_2);
			
			TProcessInterphoneemployinfo tp=new TProcessInterphoneemployinfo();
			tp.setInterphoneID_s(interphoneID_s);
			tp.setResaveds1S(card);
			List<TProcessInterphoneemployinfo> tPlist = new ArrayList<TProcessInterphoneemployinfo>();
			TProcessInterPhoneEmployinfoService tip = new TProcessInterphoneEmployinfoServiceImpl();
			tPlist =  tip.getTProcessInterPhoneEmployinfo(tp, -1, 0);
			for(int i  = 0 ;i<tPlist.size();i++){
				tPlist.get(i).setOperation_i(2);
			}
			Object[] o1 = {list};
			Object[] o2 = {interphone};
			Object[] o3 = {tPlist,1};
			List<ServiceImpl> se = new ArrayList();
			
			ServiceImpl tmp1 = new ServiceImpl(CardInfoServiceImpl.class.toString().substring(6),"deleteReceptionCardInfo",o1);
			ServiceImpl tmp2 = new ServiceImpl("com.freshen.basis.service.impl.InterphoneInfoServiceImpl","UpdateBasisInterPhoneStateInfoWithoutTrans",o2);
			ServiceImpl tmp3 = new ServiceImpl("com.freshen.process.service.impl.TProcessInterphoneEmployinfoServiceImpl","OperationTProcessInterphoneemployinfoWithoutTrans",o3);

			se.add(tmp1);
			se.add(tmp2);
			se.add(tmp3);
			ServiceImpl.invoke(se);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String predelIphone(){
		try {
			IinterphoneInfoService InterphoneInfoServiceImpl = new InterphoneInfoServiceImpl();
			
			InterphoneInfoServiceImpl.interphoneReturn(processID, interphoneID_s, orderId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}

	public List<TProcessInterphoneemployinfo> getProcesslist() {
		return processlist;
	}


	public void setProcesslist(List<TProcessInterphoneemployinfo> processlist) {
		this.processlist = processlist;
	}


	public String getInterphoneID_s() {
		return interphoneID_s;
	}


	public void setInterphoneID_s(String interphoneID_s) {
		this.interphoneID_s = interphoneID_s;
	}


	public int getOperation_i() {
		return operation_i;
	}


	public void setOperation_i(int operation_i) {
		this.operation_i = operation_i;
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


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getProcessID() {
		return processID;
	}


	public void setProcessID(String processID) {
		this.processID = processID;
	}
	
	
	

}
