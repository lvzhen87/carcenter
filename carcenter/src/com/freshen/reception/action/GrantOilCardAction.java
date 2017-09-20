package com.freshen.reception.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.reception.CardInfo;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class GrantOilCardAction extends CapgActionSupport{
	String orderId=ActionContext.getContext().getSession().get("orderId").toString();
	String customerId=ActionContext.getContext().getSession().get("customerId").toString();
	int oilNum;//记录人卡，油卡的数目
	List<String> searchOilCard=new ArrayList<String>();//记录该项订单已经发放的油卡
	List<String> oilCard=new ArrayList<String>();//记录油卡一维码

	String cardId;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	public String prepareOilcard(){
		try {
			IcardInfoService cardinfoService=new CardInfoServiceImpl();
			CardInfo cardsearch=new CardInfo();
			cardsearch.setOrderID_s(orderId);
			cardsearch.setCreateDate_t(null);
			cardsearch.setLastUpdateDate_t(null);
			
			List<CardInfo> cardList=cardinfoService.getReceptionCardInfo(cardsearch, ConstantUtil.pagingNot,0);
			for (int i = 0; i < cardList.size(); i++) {
				/*//人卡
				if(cardList.get(i).getCardType_s().equals(ConstantUtil.cardType_1)){
					searchPersonCard.add(cardList.get(i).getCard_s());
				}*/
				//油卡
				if(cardList.get(i).getCardType_s().equals(ConstantUtil.cardType_3)){
					searchOilCard.add(cardList.get(i).getCard_s());
				}
			}
			//personNum=searchPersonCard.size();//已经发放的人卡数
			oilNum=searchOilCard.size();//已经发放的油卡数
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public String recordOilCard(){
		try {
			IcardInfoService cardservice=new CardInfoServiceImpl();
			ArrayList<CardInfo> oilcardlist=new ArrayList<CardInfo>();//记录人卡信息
			//Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
			for (int i = 0; i < oilCard.size(); i++) {
				if(oilCard.get(i)==null || oilCard.get(i).length()<1){
					continue;
				}
				CardInfo temp=new CardInfo();
				temp.setOrderID_s(orderId);
				temp.setCard_s(oilCard.get(i).toString());
				temp.setCardType_s(ConstantUtil.cardType_3);
				temp.setCreateUser_s(employ.getCustomerUserName_s());
				temp.setCreateDate_t(DateUtil.getCurrentDate());
				oilcardlist.add(temp);
				//System.out.println(temp.toString());
			}

			int result=cardservice.saveOrUpdateReceptionCardInfo(oilcardlist);
			//System.out.println("result===="+result);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;

	}
	
	public String deleteOilCard(){
		
		try {			
			
			//设置要删除的卡记录信息
			CardInfo deleteCards=new CardInfo();
			deleteCards.setOrderID_s(orderId);
			deleteCards.setCard_s(cardId);
			
			ArrayList<CardInfo> deleteCardList=new ArrayList<CardInfo>();
			deleteCardList.add(deleteCards);
			
			//删除卡
			IcardInfoService cardService=new CardInfoServiceImpl();
			int result=cardService.deleteReceptionCardInfoAlone(deleteCardList);
		
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);

			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;

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

	public int getOilNum() {
		return oilNum;
	}

	public void setOilNum(int oilNum) {
		this.oilNum = oilNum;
	}

	public List<String> getSearchOilCard() {
		return searchOilCard;
	}

	public void setSearchOilCard(List<String> searchOilCard) {
		this.searchOilCard = searchOilCard;
	}

	public List<String> getOilCard() {
		return oilCard;
	}

	public void setOilCard(List<String> oilCard) {
		this.oilCard = oilCard;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	
	
	
	
}
