package com.freshen.reception.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IinterphoneInfoService;
import com.freshen.basis.service.impl.InterphoneInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.entity.process.TProcessInterphoneemployinfo;

import com.freshen.entity.reception.CardInfo;
import com.freshen.process.service.TProcessInterPhoneEmployinfoService;
import com.freshen.process.service.impl.TProcessInterphoneEmployinfoServiceImpl;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class GrantInterphoneAction extends CapgActionSupport{

	//String orderId=ActionContext.getContext().getSession().get("orderId").toString();
	//String customerId=ActionContext.getContext().getSession().get("customerId").toString();
	String orderId,customerId;
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	String processID =""; //方法记录号
	List<String> interphoneID=new ArrayList<String>();//记录发放的对讲机编号
	List<String> vehicleCardID=new ArrayList<String>();//记录绑定的车卡信息
	List<String> userCardID=new ArrayList<String>();//记录绑定的人卡信息
	List<String> searchInterphone=new ArrayList<String>();//记录已经发放的对讲机信息
	List<TProcessInterphoneemployinfo> processInterphonelist=new ArrayList<TProcessInterphoneemployinfo>();//记录对讲机发放信息 
	
	int interphoneNum;//记录发放的对讲机数目
	String cardId;
	String interphone;//对讲机编号，用于判断是否为闲置对讲机
	
	String interphoneerrmsg;
	
	/**
	 * 准备发放对讲机信息，首先查询该订单已经发放的对讲机编号
	 * @author sharonyshi 2014-5-6
	 */
	public String execute(){
		try {
			CardInfo cardsearch=new CardInfo();
			cardsearch.setOrderID_s(orderId);
			cardsearch.setCreateDate_t(null);
			cardsearch.setLastUpdateDate_t(null);
			
			IcardInfoService cardinfoService=new CardInfoServiceImpl();

			List<CardInfo> cardList=cardinfoService.getReceptionCardInfo(cardsearch, ConstantUtil.pagingNot,0);
			ArrayList<InterphoneInfo> phonelist=new ArrayList<InterphoneInfo>();
			for (int i = 0; i < cardList.size(); i++) {
				//对讲机
				if(cardList.get(i).getCardType_s().equals(ConstantUtil.cardType_4)){
					searchInterphone.add(cardList.get(i).getCard_s());
					//设置对讲机ID
					InterphoneInfo temp=new InterphoneInfo();
					temp.setInterphoneID_s(cardList.get(i).getCard_s());
					phonelist.add(temp);//封装对讲机过程
				}
			}
			interphoneNum=searchInterphone.size();//已经发放的对讲机数
		
			//查询对讲机过程表，用于展示和删除
			TProcessInterPhoneEmployinfoService tpips=new TProcessInterphoneEmployinfoServiceImpl();
			processInterphonelist=tpips.getTProcessInterPhoneEmployinfoListByInterphone(phonelist);
			
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
	 * 判断对讲机信息是否为闲置状态，若闲置则能发放，否则取消
	 * @author sharonyshi 2014-5-8
	 */
	public String judgeInterphone(){
		try {
			//设置要查询的对讲机
			InterphoneInfo iphone=new InterphoneInfo();
			iphone.setInterphoneID_s(interphone);
			
			IinterphoneInfoService iphoneSeriver=new InterphoneInfoServiceImpl();
			ArrayList<InterphoneInfo> phoneinfo=iphoneSeriver.getBasisInterPhoneInfo(iphone, ConstantUtil.pagingNot,0);
			
			//判读该对讲机状态
			if(phoneinfo==null){
				interphoneerrmsg="该对讲机不存在！";
				return SUCCESS;
			}
			if(phoneinfo.get(0).getState_i()!=2){
				interphoneerrmsg="该对讲机在使用中或者发生故障！";
				return SUCCESS;
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
	 * 发放对讲机信息，并修改对讲机状态
	 * @author sharonyshi 2014-5-6
	 */
	public String grantInterphone(){
		//System.out.println("记录条数："+interphoneID.size());
		try {
			//先将对讲机信息记录reception-cardinfo表中
			/*IcardInfoService cardservice=new CardInfoServiceImpl();
			ArrayList<CardInfo> cardlist=new ArrayList<CardInfo>();//记录对讲机信息
			ArrayList<String> interphoneid=new ArrayList<String>();//记录对讲机编号，修改对讲机状态
			ArrayList<InterphoneInfo> banginterphonelist=new ArrayList<InterphoneInfo>();
			ArrayList<TProcessInterphoneemployinfo> processphonelist=new ArrayList<TProcessInterphoneemployinfo>();
			for (int i = 0; i < interphoneID.size(); i++) {
				//判断是否有空，若有空放直接跳过
				if(interphoneID.get(i)==null || interphoneID.get(i).length()<1){
					continue;
				}
				//卡信息表记录
				CardInfo temp=new CardInfo();
				temp.setOrderID_s(orderId);
				temp.setCard_s(interphoneID.get(i).toString());
				temp.setCardType_s(ConstantUtil.cardType_4);
				temp.setCreateUser_s(employ.getCustomerUserName_s());
				temp.setCreateDate_t(DateUtil.getCurrentDate());
				cardlist.add(temp);
				interphoneid.add(temp.getCard_s());
				
				
				//对讲机状态修改，改成：使用中
				InterphoneInfo interphone=new InterphoneInfo();
				interphone.setInterphoneID_s(interphoneID.get(i));
				interphone.setState_i(ConstantUtil.interphoneState_1);
				banginterphonelist.add(interphone);
				
				
				//对讲机过程管理，借出
				TProcessInterphoneemployinfoId id = new TProcessInterphoneemployinfoId();
				id.setInterphoneID_s(interphoneID.get(i));
				id.setCreatedateT(DateUtil.getCurrentDate());
				id.setOperationI(ConstantUtil.interphoneState_1);//1借出
				TProcessInterphoneemployinfo tpi=new TProcessInterphoneemployinfo();
				tpi.setId(id);
				tpi.setCreateuserS(employ.getCustomerUserName_s());
				tpi.setUsercardIDS(userCardID.get(i));
				tpi.setVehiclecardidS(vehicleCardID.get(i));
				
				processphonelist.add(tpi);
			}*/
			//int result=cardservice.saveOrUpdateReceptionCardInfo(cardlist);

			//然后修改发放的对讲机信息，改为状态1：使用中,绑定人卡、车卡
			//IinterphoneInfoService interphoneService=new InterphoneInfoServiceImpl();
			//int inter=interphoneService.UpdateBasisTotalInterPhoneStateInfo(interphoneid,ConstantUtil.interphoneState_1);
			//interphoneService.UpdateBasisTotalInterPhoneStateInfo(banginterphonelist);
			
			//TProcessInterPhoneEmployinfoService tpips=new TProcessInterphoneEmployinfoServiceImpl();
			//tpips.OperationTProcessInterphoneemployinfo(processphonelist, 1);
			
			
			IinterphoneInfoService iis=new InterphoneInfoServiceImpl();
			int res=iis.interphoneProvide(interphoneID,userCardID,vehicleCardID,orderId,employ,ConstantUtil.interphoneOperation_1);
			if(res == 2){
				interphoneerrmsg="对讲机"+interphoneID+"不存在";
			}
			if(res == 3){
				interphoneerrmsg="对讲机"+interphoneID+"状态为使用中，不能发放";
			}
			execute();
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
	 * 删除发放的对讲机，并修改对讲机状态
	 * @author sharonyshi 2014-5-6
	 */
	public String deleteInterphone(){
		try {
			//设置要删除的对讲机记录信息
			CardInfo deleteCards=new CardInfo();
			deleteCards.setOrderID_s(orderId);
			deleteCards.setCard_s(cardId);
			deleteCards.setCreateDate_t(null);
			deleteCards.setLastUpdateDate_t(null);
			
			ArrayList<CardInfo> deleteCardList=new ArrayList<CardInfo>();
			deleteCardList.add(deleteCards);
			
			//删除卡
			IcardInfoService cardService=new CardInfoServiceImpl();
			int result=cardService.deleteReceptionCardInfoAlone(deleteCardList);
			
			//修改对讲机信息的状态，修改为2：闲置
			IinterphoneInfoService interphoneService=new InterphoneInfoServiceImpl();
			InterphoneInfo iphone=new InterphoneInfo();
			iphone.setInterphoneID_s(cardId);
			iphone.setState_i(ConstantUtil.interphoneState_2);
			interphoneService.UpdateBasisInterPhoneStateInfo(iphone);
			//int inter=interphoneService.UpdateBasisInterPhoneStateInfo(cardId,ConstantUtil.interphoneState_2);
		
			//对讲机过程管理，归还
			TProcessInterPhoneEmployinfoService tpipservice=new TProcessInterphoneEmployinfoServiceImpl();
			
			
			TProcessInterphoneemployinfo processinterphone=new TProcessInterphoneemployinfo();
			processinterphone.setInterphoneID_s(cardId);
			processinterphone.setCreateDate_t(DateUtil.getCurrentDate());
			processinterphone.setOperation_i(ConstantUtil.interphoneState_2);//归还状态
			
			ArrayList<TProcessInterphoneemployinfo> processlist=new ArrayList<TProcessInterphoneemployinfo>();
			processlist.add(processinterphone);
			
			tpipservice.OperationTProcessInterphoneemployinfo(processlist,1);//2是删除，即归还状态
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		
		return SUCCESS;
	}


	public List<String> getInterphoneID() {
		return interphoneID;
	}


	public void setInterphoneID(List<String> interphoneID) {
		this.interphoneID = interphoneID;
	}


	public List<String> getSearchInterphone() {
		return searchInterphone;
	}


	public void setSearchInterphone(List<String> searchInterphone) {
		this.searchInterphone = searchInterphone;
	}


	public int getInterphoneNum() {
		return interphoneNum;
	}


	public void setInterphoneNum(int interphoneNum) {
		this.interphoneNum = interphoneNum;
	}


	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public String getInterphone() {
		return interphone;
	}


	public void setInterphone(String interphone) {
		this.interphone = interphone;
	}



	public String getInterphoneerrmsg() {
		return interphoneerrmsg;
	}


	public void setInterphoneerrmsg(String interphoneerrmsg) {
		this.interphoneerrmsg = interphoneerrmsg;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public List<String> getVehicleCardID() {
		return vehicleCardID;
	}


	public void setVehicleCardID(List<String> vehicleCardID) {
		this.vehicleCardID = vehicleCardID;
	}


	public List<String> getUserCardID() {
		return userCardID;
	}


	public void setUserCardID(List<String> userCardID) {
		this.userCardID = userCardID;
	}


	public List<TProcessInterphoneemployinfo> getProcessInterphonelist() {
		return processInterphonelist;
	}


	public void setProcessInterphonelist(
			List<TProcessInterphoneemployinfo> processInterphonelist) {
		this.processInterphonelist = processInterphonelist;
	}


	public String getProcessID() {
		return processID;
	}


	public void setProcessID(String processID) {
		this.processID = processID;
	}
	
	
	
	
}
