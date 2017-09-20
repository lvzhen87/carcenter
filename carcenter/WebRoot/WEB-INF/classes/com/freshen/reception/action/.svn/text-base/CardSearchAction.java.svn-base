package com.freshen.reception.action;

import java.util.ArrayList;

import com.freshen.entity.reception.CardInfo;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: CardSearchAction.java
 *  Function:接待员查询 卡信息，根据提供的orderID查看此订单下有哪些卡片
 *     Modifications:   
 *  @author   DateTime 2014-4-14 下午02:57:30    
 *  @version 1.0
 */
public class CardSearchAction extends CapgActionSupport {
	String rs=SUCCESS;
	String orderID;
	ArrayList<String> personCardList=new ArrayList<String>();
	ArrayList<String> oilCardList=new ArrayList<String>();
	ArrayList<String> vehicleCardList=new ArrayList<String>();

	int personcardnum,oilcardnum,vehiclecardnum;//记录各类型卡数量
	String msg;
	public String execute(){
		try {
			/*if(orderID==null){
				msg="请填写要查询的订单编号！";
				return rs;
			}*/
			
			//要查询的订单号
			CardInfo cardsearch=new CardInfo();
			cardsearch.setOrderID_s(orderID);
			cardsearch.setCreateDate_t(null);
			cardsearch.setLastUpdateDate_t(null);
			
			IcardInfoService cardinfoService=new CardInfoServiceImpl();
			ArrayList<CardInfo> cardinfolist=new ArrayList<CardInfo>();
			cardinfolist=cardinfoService.getReceptionCardInfo(cardsearch, ConstantUtil.pagingNot,0);
			//遍历查询出来的记录，分别记录在人卡，油卡，车卡中
			for (int i = 0; i < cardinfolist.size(); i++) {
//				//System.out.println(cardinfolist.get(i).toString());
				//人卡
				if(cardinfolist.get(i).getCardType_s().equals(ConstantUtil.cardType_1)){
					personCardList.add(cardinfolist.get(i).getCard_s());
				}else if(cardinfolist.get(i).getCardType_s().equals(ConstantUtil.cardType_3)){//油卡
					oilCardList.add(cardinfolist.get(i).getCard_s());
				}else if(cardinfolist.get(i).getCardType_s().equals(ConstantUtil.cardType_2)){//车卡
					vehicleCardList.add(cardinfolist.get(i).getCard_s());
				}
			}
			
			//得到查询的卡数目
			personcardnum=personCardList.size();
			oilcardnum=oilCardList.size();
			vehiclecardnum=vehicleCardList.size();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return rs;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	

	public ArrayList<String> getPersonCardList() {
		return personCardList;
	}

	public void setPersonCardList(ArrayList<String> personCardList) {
		this.personCardList = personCardList;
	}

	public ArrayList<String> getOilCardList() {
		return oilCardList;
	}

	public void setOilCardList(ArrayList<String> oilCardList) {
		this.oilCardList = oilCardList;
	}

	public ArrayList<String> getVehicleCardList() {
		return vehicleCardList;
	}

	public void setVehicleCardList(ArrayList<String> vehicleCardList) {
		this.vehicleCardList = vehicleCardList;
	}

	public int getPersoncardnum() {
		return personcardnum;
	}

	public void setPersoncardnum(int personcardnum) {
		this.personcardnum = personcardnum;
	}

	public int getOilcardnum() {
		return oilcardnum;
	}

	public void setOilcardnum(int oilcardnum) {
		this.oilcardnum = oilcardnum;
	}

	public int getVehiclecardnum() {
		return vehiclecardnum;
	}

	public void setVehiclecardnum(int vehiclecardnum) {
		this.vehiclecardnum = vehiclecardnum;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
