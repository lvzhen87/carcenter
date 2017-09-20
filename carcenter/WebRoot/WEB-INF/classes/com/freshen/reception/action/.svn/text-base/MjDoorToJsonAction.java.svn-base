package com.freshen.reception.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.freshen.entity.oneCard.TOnecardMjdoorBak;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.oneCard.service.IOneCardPbEmplyService;
import com.freshen.oneCard.service.ITOnecardMjdoorBakService;
import com.freshen.oneCard.service.impl.TOnecardMjdoorBakServiceImpl;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class MjDoorToJsonAction extends CapgActionSupport implements ServletResponseAware{
	String jsonStr;
	private HttpServletResponse response; 
	String customerUserID ;
	String orderID;
	public String getCustomerUserID() {
		return customerUserID;
	}
	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	/**
	 *  Class Name: RoadNameToJsonAction.java
	 *  Function:该类用于将门房表 输出管道，转换为json串，传给jsp
	 *     Modifications:   
	 *  @author   DateTime 2014-6-17 下午12:03:55    
	 *  @version 1.0
	 */
	public String executeold(){
		try {
			response.setCharacterEncoding("utf-8"); 
			List<TOnecardMjdoorBak> doorNames=null;
			List<ReceptionCustomerUser> rcuList = new ArrayList<ReceptionCustomerUser>();
			ITOnecardMjdoorBakService doorSer=new TOnecardMjdoorBakServiceImpl();
			//设置要查询房门isUse字段为1的数据
			TOnecardMjdoorBak tdoor=new TOnecardMjdoorBak();
			tdoor.setIsUse_i(1);
			
			PrintWriter pw=null;
			String groupIdOld = "";
			Integer doorID =0;
			String doorName= "";
			String channel = "";
			Integer sequence = 0;
			ReceptionCustomerUser rcu = new ReceptionCustomerUser();
			rcu.setCustomerUserID_s(customerUserID);
			rcu.setOrderID_s(orderID);
			IreceptionCustomerUserService icu = new ReceptionCustomerUserServiceImpl();
			String[] GateNumTotal ;
			List<String> GateNumList = new ArrayList<String>();
			if(customerUserID!= null &&  !customerUserID.trim().equals(""))
			{
				rcuList = icu.getReceptionCustomerUser(rcu, -1, 0);
				if(rcuList!= null && rcuList.size()>0)
				{
					if(rcuList.get(0).getDeviceSysid_s()!= null)
					{
						GateNumTotal = rcuList.get(0).getDeviceSysid_s().split("vv");
						for(int j=0;j<GateNumTotal.length;j++)
						{
							GateNumList.add(GateNumTotal[j]);
						}
					}
				}
			}
			doorNames=doorSer.getTOnecardMjdoorBak(tdoor);
			if(doorNames==null||doorNames.size()<1){
				jsonStr="[{'id':0,'text':'查无数据'}]";
			}else{
				jsonStr="[";
				StringBuffer sb=new StringBuffer();
				for (int i = 0; i < doorNames.size(); i++) {
					TOnecardMjdoorBak door=doorNames.get(i);
					if(door.getGroupId_s() != null && !door.getGroupId_s().trim().equals(""))
					{
						groupIdOld = door.getGroupId_s();
						doorID = door.getDoorIdI();
						doorName = door.getDoorNameS();
						sequence = sequence > door.getChannelnumI()? sequence:door.getChannelnumI();
						continue;
					}
					if(!groupIdOld.trim().equals("") && doorID != 0 && !doorName.trim().equals("")  && sequence != 0)
					{
//							switch (sequence) {
//							case 1:
//								channel = "01";
//								
//								break;
//							case 2:
//								channel = "03";		
//								break;
//							case 3:
//								channel = "07";
//								break;
//							case 4:
//								channel = "15";
//								break;
//							default:
//								break;
//							} 
						if(GateNumList.contains(doorID.toString()))
						{
							sb.append("{'id':"+doorID +",'text':'"+groupIdOld + "','selected':true},");
						}
						else
						{
							sb.append("{'id':"+doorID +",'text':'"+groupIdOld +"'},");
						}
					}
					if(GateNumList.contains(door.getDoorIdI().toString()))
					{
						sb.append("{'id':"+door.getDoorIdI() +",'text':'"+door.getDoorNameS()+"','selected':true},");
					}
					else
					{
						sb.append("{'id':"+door.getDoorIdI() +",'text':'"+door.getDoorNameS()+"'},");
					}
					groupIdOld = "";
					doorID =0;
					doorName= "";
					channel = "";
					sequence = 0;
					//sb.append("{'id':"+(i+1)+",'text':'"+door.getDoorNameS()+"("+door.getDevicesysidI()+")'},");
				}
				jsonStr+=sb.substring(0, sb.length()-1)+"]";
			}
			pw=response.getWriter();
			pw.println(jsonStr.replace("'", "\""));
			pw.flush();
			pw.close();
		
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
	}
	
	/**
	 *  Class Name: RoadNameToJsonAction.java
	 *  Function:该类用于将门房表 输出管道，转换为json串，传给jsp
	 *     Modifications:   
	 *  @author   DateTime 2014-6-17 下午12:03:55    
	 *  @version 1.0
	 */
	public String execute(){
		try {
			response.setCharacterEncoding("utf-8"); 
			List<TOnecardMjdoorBak> doorNames=null;
			List<ReceptionCustomerUser> rcuList = new ArrayList<ReceptionCustomerUser>();
			ITOnecardMjdoorBakService doorSer=new TOnecardMjdoorBakServiceImpl();
			//设置要查询房门isUse字段为1的数据
			TOnecardMjdoorBak tdoor=new TOnecardMjdoorBak();
			tdoor.setIsUse_i(1);
			
			PrintWriter pw=null;
			boolean b = false;
			String groupIdOld = "";
			String groupId = "";
			Integer doorID =0;
			String doorName= "";
			String channel = "";
			Integer sequence = 0;
			ReceptionCustomerUser rcu = new ReceptionCustomerUser();
			rcu.setCustomerUserID_s(customerUserID);
			rcu.setOrderID_s(orderID);
			IreceptionCustomerUserService icu = new ReceptionCustomerUserServiceImpl();
			String[] GateNumTotal ;
			List<String> GateNumList = new ArrayList<String>();
			if(customerUserID!= null &&  !customerUserID.trim().equals(""))
			{
				rcuList = icu.getReceptionCustomerUser(rcu, -1, 0);
				if(rcuList!= null && rcuList.size()>0)
				{
					if(rcuList.get(0).getDeviceSysid_s()!= null)
					{
						GateNumTotal = rcuList.get(0).getDeviceSysid_s().split("vv");
						for(int j=0;j<GateNumTotal.length;j++)
						{
							GateNumList.add(GateNumTotal[j]);
						}
					}
				}
			}
			doorNames=doorSer.getTOnecardMjdoorBak(tdoor);
			if(doorNames==null||doorNames.size()<1){
				jsonStr="[{'id':0,'text':'查无数据'}]";
			}else{
				jsonStr="[";
				StringBuffer sb=new StringBuffer();
				for (int i = 0; i < doorNames.size(); i++) {
					TOnecardMjdoorBak door=doorNames.get(i);
					if(door.getDoorIdI().toString().trim().equals("25")||door.getDoorIdI().toString().trim().equals("63")||door.getDoorIdI().toString().trim().equals("31")){
						String a = "";
					}
					if(door.getGroupId_s() != null && !door.getGroupId_s().trim().equals(""))
					{
						b = true;
						groupId = door.getGroupId_s();
						if(groupIdOld.equals("")){
							doorID = door.getDoorIdI();
							doorName = door.getDoorNameS();
							sequence = sequence > door.getChannelnumI()? sequence:door.getChannelnumI();
							groupIdOld = door.getGroupId_s();
						}
						if(!groupId.equals(groupIdOld)){
							if(GateNumList.contains(doorID.toString()))
							{
								sb.append("{'id':"+doorID +",'text':'"+groupIdOld + "','selected':true},");
							}
							else
							{
								sb.append("{'id':"+doorID +",'text':'"+groupIdOld +"'},");
							}
							groupIdOld = groupId;
							doorID = door.getDoorIdI();
							doorName = door.getDoorNameS();
							sequence = sequence > door.getChannelnumI()? sequence:door.getChannelnumI();
						}
						continue;
					}else if(b==true){
						if(GateNumList.contains(doorID.toString()))
						{
							sb.append("{'id':"+doorID +",'text':'"+groupIdOld + "','selected':true},");
						}
						else
						{
							sb.append("{'id':"+doorID +",'text':'"+groupIdOld +"'},");
						}
						b = false;
					}
					/*if(!groupIdOld.trim().equals("") && doorID != 0 && !doorName.trim().equals("")  && sequence != 0)
					{
//							switch (sequence) {
//							case 1:
//								channel = "01";
//								
//								break;
//							case 2:
//								channel = "03";		
//								break;
//							case 3:
//								channel = "07";
//								break;
//							case 4:
//								channel = "15";
//								break;
//							default:
//								break;
//							} 
						if(GateNumList.contains(doorID.toString()))
						{
							sb.append("{'id':"+doorID +",'text':'"+groupIdOld + "','selected':true},");
						}
						else
						{
							sb.append("{'id':"+doorID +",'text':'"+groupIdOld +"'},");
						}
					}*/
					if(GateNumList.contains(door.getDoorIdI().toString()))
					{
						sb.append("{'id':"+door.getDoorIdI() +",'text':'"+door.getDoorNameS()+"','selected':true},");
					}
					else
					{
						sb.append("{'id':"+door.getDoorIdI() +",'text':'"+door.getDoorNameS()+"'},");
					}
					groupIdOld = "";
					doorID =0;
					doorName= "";
					channel = "";
					sequence = 0;
					//sb.append("{'id':"+(i+1)+",'text':'"+door.getDoorNameS()+"("+door.getDevicesysidI()+")'},");
				}
				jsonStr+=sb.substring(0, sb.length()-1)+"]";
			}
			pw=response.getWriter();
			pw.println(jsonStr.replace("'", "\""));
			pw.flush();
			pw.close();
		
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
	}
	
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
}
