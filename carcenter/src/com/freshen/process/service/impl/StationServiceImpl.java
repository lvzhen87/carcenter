package com.freshen.process.service.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.cost.service.IOrderRoadCostBasisService;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.cost.service.impl.OrderRoadCostBasisServiceImpl;
import com.freshen.cost.service.impl.OrdercostInfoServiceImpl;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.cost.OrdercostInfo;
import com.freshen.entity.cost.OrderroadcostTemp;
import com.freshen.entity.cost.TCostOrderroadcostbasis;
import com.freshen.entity.process.RoadEmployInventory;
import com.freshen.entity.process.Station;
import com.freshen.entity.process.RoadEmployInventory.StationDetailModel;
import com.freshen.entity.process.RoadEmployInventory.StationDetailModel.StationDetailTimeModel;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.process.service.IstationService;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;
import com.freshen.util.NumTools;
import com.freshen.util.SavePDFUtil;

public class StationServiceImpl extends ClimsServiceBase implements IstationService {

	String serialNumber_s;
	String orderID_s;
	String	facilityID_s;
	Date recordDate_d;
	Integer action_s;
	String mappingSerialNumber_s;
	String vehicleID_s;
	String vehicleCPG_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	String road_name;
	String road_id;
	String startSDate,startEDate,endSDate,endEDate;//逻辑字段，用于查询条件赋值
	String current;
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<Station> getBasisStationInfo(Station station, int start,
			int size) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try {
			List<Station> list = new ArrayList();
			
			if(station == null){
				Query query=session.createQuery("from Station as station");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();
				return (ArrayList) list;
			}
			
			serialNumber_s = station.getSerialNumber_s();
			orderID_s = station.getOrderID_s();
			facilityID_s = station.getFacilityID_s();
			recordDate_d = station.getRecordDate_d();
			action_s = station.getAction_s();
			mappingSerialNumber_s = station.getMappingSerialNumber_s();
			vehicleID_s = station.getVehicleID_s();
			vehicleCPG_s = station.getVehicleCPG_s();
			createDate_t = station.getCreateDate_t();
			createUser_s = station.getCreateUser_s();
			lastUpdateUser_s = station.getLastUpdateUser_s();
			lastUpdateDate_t = station.getLastUpdateDate_t();
			resaveds1_s = station.getResaveds1_s();
			resaveds2_s = station.getResaveds2_s();
			resaveds3_s = station.getResaveds3_s();
			resaveds4_s = station.getResaveds4_s();
			resaveds5_s = station.getResaveds5_s();
		 
			startSDate =station.getStartSDate();
			endSDate =station.getEndSDate();
			startEDate =station.getStartEDate();
			endEDate =station.getEndEDate();
			current = station.getCurrent();
			if(station.getRoadInfo()!=null){
				road_name = station.getRoadInfo().getRoadName_s();
				road_id = station.getRoadInfo().getRoadID_s();
			}
			String hql = " from Station as station where 1=1 ";
		    String condition = "";
		    
		    if(serialNumber_s != null && !serialNumber_s.trim().equals(""))
		    {
		    	condition += " and station.serialNumber_s like '%" + serialNumber_s.trim() + "%'";
		    }
		    //显示配对的记录并将未配对的流水显示
		    if(current!=null && current.equals("1")){
		    	 condition +=" and station.serialNumber_s not in (select t.mappingSerialNumber_s " +
		    		"from Station t where t.receptionOrder.orderID_s = '"+orderID_s+"' " +
		    		"and (t.resaveds2_s is null) and t.mappingSerialNumber_s is not null)";
		    }
		    if(orderID_s != null && !orderID_s.trim().equals("") )
		    {
		    	condition += " and station.receptionOrder.orderID_s = '" + orderID_s + "'";
		    }
		    if(facilityID_s != null && !facilityID_s.trim().equals("") )
		    {
		    	condition += " and station.roadInfo.roadID_s like '%" + facilityID_s.trim() + "%'";
		    }
		    if(road_name != null && !road_name.trim().equals("") )
		    {
		    	condition += " and station.roadInfo.roadName_s like '%" + road_name.trim() + "%'";
		    }
		    if(road_id != null && !road_id.trim().equals("") )
		    {
		    	condition += " and station.roadInfo.roadID_s like '%" + road_id.trim() + "%'";
		    }
		    
		    if(createDate_t != null )
		    {
		     	condition = condition + " and to_char(station.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null )
		    {
		     	condition = condition + " and to_char(station.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(action_s != null  )
		    {
		    	condition += " and station.action_s = '" + action_s+ "'";
		    }
		    if(mappingSerialNumber_s!=null&&"notnull".equals(mappingSerialNumber_s)){
		    	condition += " and station.mappingSerialNumber_s is not null";
		    }else if(mappingSerialNumber_s != null && !mappingSerialNumber_s.trim().equals(""))
		    {
		    	condition += " and station.mappingSerialNumber_s like '%" + mappingSerialNumber_s.trim() + "%'";
		    }
			
		    if(vehicleID_s != null && !vehicleID_s.trim().equals("") )
		    {
		    	condition += " and station.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("") )
		    {
		    	condition += " and station.vehicleCPG_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("") )
		    {
		    	condition += " and station.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("") )
		    {
		    	condition += " and station.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    
		    if(startSDate!=null &&!"".equals(startSDate) && startEDate !=null &&!"".equals(startEDate)){
		    	condition = condition+" and  to_date(to_char(station.recordDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startSDate+"','yyyy-MM-dd') and to_date('"+startEDate+"','yyyy-MM-dd')";
		    }else if(startSDate!=null&&!"".equals(startSDate)){
		    	condition = condition+" and  to_date(to_char(station.recordDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') >=to_date('"+startSDate+"','yyyy-MM-dd')";
		    }else if(startEDate!=null&&!"".equals(startEDate)){
		    	condition = condition+" and  to_date(to_char(station.recordDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') <=to_date('"+startEDate+"','yyyy-MM-dd')";
		    }
		    
		    if(endSDate!=null &&!"".equals(endSDate) && endEDate !=null &&!"".equals(endEDate)){
		    	condition = condition+" and  to_date(to_char(to_date(station.resaveds3_s,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+endSDate+"','yyyy-MM-dd') and to_date('"+endEDate+"','yyyy-MM-dd')";
		    }else if(endSDate!=null&&!"".equals(endSDate)){
		    	condition = condition+" and  to_date(to_char(to_date(station.resaveds3_s,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd'),'yyyy-MM-dd') >=to_date('"+endSDate+"','yyyy-MM-dd')";
		    }else if(endEDate!=null&&!"".equals(endEDate)){
		    	condition = condition+" and  to_date(to_char(to_date(station.resaveds3_s,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd'),'yyyy-MM-dd') <=to_date('"+endEDate+"','yyyy-MM-dd')";
		    }		     	   
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && "null".equals(resaveds2_s.trim())){
		    	condition += " and station.resaveds2_s is null";
			}else 
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds2_s = '" + resaveds2_s.trim() + "'";
		    }
		   
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds5_s ='" + resaveds5_s.trim() + "'";
		    }
			condition +=" order by station.recordDate_d desc";
		    
		    Query query=session.createQuery(hql+condition); 
			if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();
			return (ArrayList) list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}

	 
	
	public long getBasisStationInfo(Station station) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<Station> list = new ArrayList();
			
			if(station == null){
				Query query=session.createQuery("select count(*) from Station as station");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }    
				    return n;
			}
			
			serialNumber_s = station.getSerialNumber_s();
			orderID_s = station.getOrderID_s();
			facilityID_s = station.getFacilityID_s();
			recordDate_d = station.getRecordDate_d();
			action_s = station.getAction_s();
			mappingSerialNumber_s = station.getMappingSerialNumber_s();
			vehicleID_s = station.getVehicleID_s();
			vehicleCPG_s = station.getVehicleCPG_s();
			createDate_t = station.getCreateDate_t();
			createUser_s = station.getCreateUser_s();
			lastUpdateUser_s = station.getLastUpdateUser_s();
			lastUpdateDate_t = station.getLastUpdateDate_t();
			resaveds1_s = station.getResaveds1_s();
			resaveds2_s = station.getResaveds2_s();
			resaveds3_s = station.getResaveds3_s();
			resaveds4_s = station.getResaveds4_s();
			resaveds5_s = station.getResaveds5_s();
		 
			startSDate =station.getStartSDate();
			endSDate =station.getEndSDate();
			startEDate =station.getStartEDate();
			endEDate =station.getEndEDate();
			current = station.getCurrent();
			if(station.getRoadInfo()!=null){
				road_name = station.getRoadInfo().getRoadName_s();
				road_id = station.getRoadInfo().getRoadID_s();
			}
		 
			String hql = "select count(*) from Station as station where 1=1 ";
		    String condition = "";
		    
		    if(serialNumber_s != null && !serialNumber_s.trim().equals(""))
		    {
		    	condition += " and station.serialNumber_s like '%" + serialNumber_s.trim() + "%'";
		    }
		    //显示配对的记录并将未配对的流水显示
		    if(current!=null && current.equals("1")){
		    	 condition +=" and station.serialNumber_s not in (select t.mappingSerialNumber_s " +
		    		"from Station t where t.receptionOrder.orderID_s = '"+orderID_s+"' " +
		    		"and (t.resaveds2_s is null) and t.mappingSerialNumber_s is not null)";
		    }
		    if(orderID_s != null && !orderID_s.trim().equals("") )
		    {
		    	condition += " and station.receptionOrder.orderID_s = '" + orderID_s + "'";
		    }
		    if(facilityID_s != null && !facilityID_s.trim().equals("") )
		    {
		    	condition += " and station.roadInfo.roadID_s like '%" + facilityID_s.trim() + "%'";
		    }
		    if(road_name != null && !road_name.trim().equals("") )
		    {
		    	condition += " and station.roadInfo.roadName_s like '%" + road_name.trim() + "%'";
		    }
		    if(road_id != null && !road_id.trim().equals("") )
		    {
		    	condition += " and station.roadInfo.roadID_s like '%" + road_id.trim() + "%'";
		    }
		    
		    if(createDate_t != null )
		    {
		     	condition = condition + " and to_char(station.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null )
		    {
		     	condition = condition + " and to_char(station.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(action_s != null  )
		    {
		    	condition += " and station.action_s = '" + action_s+ "'";
		    }
		    if(mappingSerialNumber_s!=null&&"notnull".equals(mappingSerialNumber_s)){
		    	condition += " and station.mappingSerialNumber_s is not null";
		    }else if(mappingSerialNumber_s != null && !mappingSerialNumber_s.trim().equals(""))
		    {
		    	condition += " and station.mappingSerialNumber_s like '%" + mappingSerialNumber_s.trim() + "%'";
		    }
		    if(vehicleID_s != null && !vehicleID_s.trim().equals("") )
		    {
		    	condition += " and station.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("") )
		    {
		    	condition += " and station.vehicleCPG_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("") )
		    {
		    	condition += " and station.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("") )
		    {
		    	condition += " and station.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(startSDate!=null &&!"".equals(startSDate) && startEDate !=null &&!"".equals(startEDate)){
		    	condition = condition+" and  to_date(to_char(station.recordDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startSDate+"','yyyy-MM-dd') and to_date('"+startEDate+"','yyyy-MM-dd')";
		    }else if(startSDate!=null&&!"".equals(startSDate)){
		    	condition = condition+" and  to_date(to_char(station.recordDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') >=to_date('"+startSDate+"','yyyy-MM-dd')";
		    }else if(startEDate!=null&&!"".equals(startEDate)){
		    	condition = condition+" and  to_date(to_char(station.recordDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') <=to_date('"+startEDate+"','yyyy-MM-dd')";
		    }
		    
		    if(endSDate!=null &&!"".equals(endSDate) && endEDate !=null &&!"".equals(endEDate)){
		    	condition = condition+" and  to_date(to_char(to_date(station.resaveds3_s,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+endSDate+"','yyyy-MM-dd') and to_date('"+endEDate+"','yyyy-MM-dd')";
		    }else if(endSDate!=null&&!"".equals(endSDate)){
		    	condition = condition+" and  to_date(to_char(to_date(station.resaveds3_s,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd'),'yyyy-MM-dd') >=to_date('"+endSDate+"','yyyy-MM-dd')";
		    }else if(endEDate!=null&&!"".equals(endEDate)){
		    	condition = condition+" and  to_date(to_char(to_date(station.resaveds3_s,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd'),'yyyy-MM-dd') <=to_date('"+endEDate+"','yyyy-MM-dd')";
		    }
		    
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && "null".equals(resaveds2_s.trim())){
		    	condition += " and station.resaveds2_s is null";
			}else 
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds2_s = '" + resaveds2_s.trim() + "'";
		    }
		  
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("") )
		    {
		    	condition += " and station.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
			
		    Query query=session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }    
		    return n;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}

	/**
	 * 获得order进出道闸费用信息
	 * getBasisStationcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrdercostInfo> getBasisStationcostInfoold(String orderID) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		IOrderRoadCostBasisService orderRoadCostBasisServiceImpl = new OrderRoadCostBasisServiceImpl();
		IOrdercostInfoService iordercostInfoServiceImpl = new OrdercostInfoServiceImpl();
		try {			
			List<OrdercostInfo> list = new ArrayList();
			String hql = " select station.roadInfo.roadID_s,sum(station.spanMinute_i),sum(station.cost_i) " +
						 " from Station as station where 1=1 " +
						 " and  station.resaveds2_s = '1' " +
						 " and  station.receptionOrder.orderID_s = ? " +
						 " and  station.cost_i>0 " +
						 " group by station.roadInfo";
			//System.out.println("hql="+hql);
		    Query query=session.createQuery(hql);
		   // query.setParameter(0, receptionOrder);  
		    query.setParameter(0, orderID);  		    
		    List tmplist = query.list();
		    Iterator iterator = tmplist.iterator();
			while(iterator.hasNext()){
				OrdercostInfo tmp = new OrdercostInfo();
				Object[] o = (Object[])iterator.next();
				
			    RoadInfo roadInfo = new RoadInfo();
				roadInfo.setRoadID_s(String.valueOf(o[0]));
				ArrayList<RoadInfo> roadInfos = iroadInfoService.getRoadInfo(roadInfo);
				roadInfo = roadInfos.get(0);				 
				tmp.setFacilityName(roadInfo.getRoadName_s());//名称						
				//设置数量
				String spanMinute_i = String.valueOf(o[1]);
				if(NumTools.isNumber(spanMinute_i,false)){
					tmp.setNumber(Integer.valueOf(spanMinute_i));
				}else{
					tmp.setNumber(0);
				}
				//设置总价
				String cost_i = o[2].toString();
				if(NumTools.isNumber(cost_i,true)){
					tmp.setTotalprice(Double.valueOf(cost_i));
				}else{
					tmp.setTotalprice(Double.valueOf("0"));
				}
				tmp.setUnit("元/分钟");
				//得到单价
				TCostOrderroadcostbasis tCostOrderroadcostbasis = new TCostOrderroadcostbasis();
				tCostOrderroadcostbasis.setOrderidS(orderID);
				tCostOrderroadcostbasis.setRoadidS(String.valueOf(o[0]));
				ArrayList<TCostOrderroadcostbasis> tCostOrderroadcostbasises= orderRoadCostBasisServiceImpl.getTCostOrderroadcostbasis(tCostOrderroadcostbasis, ConstantUtil.pagingNot, 0);
				if(!BasicTools.isnotNull(tCostOrderroadcostbasises)){//order没有对应的费用基础信息
					//初始化orders单价表
					iordercostInfoServiceImpl.initOrderPriceBytransaction(orderID);
					tCostOrderroadcostbasis = orderRoadCostBasisServiceImpl.getTCostOrderroadcostbasis(tCostOrderroadcostbasis, ConstantUtil.pagingNot, 0).get(0);						
				}else{
					tCostOrderroadcostbasis = tCostOrderroadcostbasises.get(0);
				}
			//	tmp.setUnitPrie_i(tCostOrderroadcostbasis.getUnitprieI());
				tmp.setUnitPrie_i(Double.valueOf(tCostOrderroadcostbasis.getMinuteUnitPrie_i()));
				tmp.setType(ConstantUtil.COSTTYPE02);
				list.add(tmp);
			}
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}
	
	/**
	 * 获得order进出道闸费用信息
	 * getBasisStationcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderroadcostTemp>  getBasisStationcostInfo(String orderID) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}	 
		IroadInfoService iRoadInfoServiceImpl = new RoadInfoServiceImpl();
		try {			
			ArrayList<OrderroadcostTemp> list = new ArrayList();
			OrderroadcostTemp orderroadcostTemp = new OrderroadcostTemp();
			
			//得到费用记录
			Station station = new Station();
			station.setResaveds2_s("1");
			station.setOrderID_s(orderID);
			ArrayList<Station> stationes = this.getBasisStationInfo(station, ConstantUtil.pagingNot, 0);
			//得到在使用的道路
			RoadInfo roadInfo = new RoadInfo();
			roadInfo.setState_i(1);
			ArrayList<RoadInfo> roadInfoes = iRoadInfoServiceImpl.getRoadInfo(roadInfo);
			//道路名称
			List<String> roadInfos = new ArrayList(); 
			for(int i=0;i<roadInfoes.size();i++){
				roadInfos.add(roadInfoes.get(i).getRoadName_s()+"/n/t(时间/费用)(分钟/元)");
				orderroadcostTemp = new OrderroadcostTemp();
				orderroadcostTemp.setRoadInfo(roadInfos);
			}
			list.add(orderroadcostTemp);
			//填放道路对应费用和时间
			String vehicleID = new String();//车卡号
			for(int i=0;i<stationes.size();i++){
				station = new Station();
				station = stationes.get(i);
				//每张车卡一条记录
				if(!vehicleID.equals(station.getVehicleID_s())){
					vehicleID = station.getVehicleID_s();
					if(i!=0){
						list.add(orderroadcostTemp);
					}
					orderroadcostTemp = new OrderroadcostTemp();
					orderroadcostTemp.setCardId(station.getVehicleID_s());
					for(int j=0;j<roadInfoes.size();j++){
						orderroadcostTemp.getRoadInfo().add(j,"");
					}
				}
				for(int j=0;j<roadInfoes.size();j++){
					if(station.getRoadInfo().getRoadID_s().equals(roadInfoes.get(j).getRoadID_s())){										
						orderroadcostTemp.getRoadInfo().set(j, station.getSpanMinute_i()+"/"+station.getCost_i());
						orderroadcostTemp.setSumcost(orderroadcostTemp.getSumcost()+station.getCost_i());
					}
				}
				if(i==stationes.size()-1){
					list.add(orderroadcostTemp);
				}
			}
			return  list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}
	/**
	 * 获得order进出道闸按车辆、道路的统计信息
	 * getBasisStationStaticsInfo 
	 * @param   name    
	 * @param  @return     resaveds1_s：总用时(分钟)
	 *                     spanMinute_i：收费用时
	 *                     facilityID_s:道路id
	 *                     FacilityName:道路名称
	 *                     vehicleCPG_s：车的CPG号
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getBasisStationStaticsInfo(String orderID) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		
		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		boolean b = false;//是否进行了统计
		try {
			List<Station> list = new ArrayList();
			String hql = " select sum(station.resaveds1_s),sum(station.spanMinute_i),station.roadInfo.roadID_s,station.vehicleID_s,station.vehicleCPG_s " +
						 " from Station as station where 1=1 " +
						 " and  station.receptionOrder.orderID_s = '" + orderID + "' " +						
						 " group by station.roadInfo,station.vehicleID_s,station.vehicleCPG_s";
		    Query query=session.createQuery(hql);
		    List tmplist = query.list();
		    Iterator iterator = tmplist.iterator();
		    
			while(iterator.hasNext()){
				b = true;
				Station tmp = new Station();
				Object[] o = (Object[])iterator.next();
				String resaveds1_s = String.valueOf(o[0]);//合计
				tmp.setResaveds1_s(resaveds1_s);
				if(o[1]!=null){//代表出道闸的记录
					int  spanminute_i =  ((Long)o[1]).intValue();//收费时间合计
					tmp.setSpanMinute_i(spanminute_i);
				}
				RoadInfo roadInfo = new RoadInfo();
				roadInfo.setRoadID_s(String.valueOf(o[2]));
				ArrayList<RoadInfo> roadInfos = iroadInfoService.getRoadInfo(roadInfo);
				if(BasicTools.isnotNull(roadInfos)){
					roadInfo = roadInfos.get(0);
					tmp.setFacilityID_s(roadInfo.getRoadID_s());//ID
					tmp.setFacilityName(roadInfo.getRoadName_s());//名称
					tmp.setRoadInfo(roadInfo);
				}else{
					tmp.setFacilityID_s("");
					tmp.setFacilityName("");//名称
				}
				tmp.setVehicleID_s(String.valueOf(o[3]));
				tmp.setVehicleCPG_s(String.valueOf(o[4]));
				tmp.setOrderID_s(orderID);
				list.add(tmp);
			}
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}
	
	/**
	 * 获得进入道闸按车辆的车辆统计信息
	 * getProcessStationInCardInfo 
	 * @param   name    
	 * @param  @return     
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getProcessStationInCardInfo(Station station) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try {
			ArrayList<Station> list = new ArrayList();
			String condition = ""; 
			if(station!=null){
				if(station.getFacilityID_s()!=null && !"-1".equals(station.getFacilityID_s())){
					condition = condition +" and t1.facilityid_s='"+station.getFacilityID_s()+"'";
				}
				if(station.getOrderID_s()!=null){					
					condition = condition +" and t1.orderid_s='"+station.getOrderID_s()+"'";
				}
				if(station.getRecordDate_d()!=null){
					condition = condition +" and t1.recorddate_d>=to_date('"+DateUtil.formatDate(station.getRecordDate_d(),"yyyy-MM-dd HH:mm:ss")+"','yyyy-MM-dd HH24:mi:ss')";
				}
			}
			String hql = " select t.orderid_s,t.vehicleid_s,to_char(t.recorddate_d,'yyyy-MM-dd HH24:mi:ss') recorddate_d,t3.ordername_s,t4.roadname_s"+
						 " from t_process_station t ,("+
							    " select max(t1.recorddate_d) recorddate_d,t1.vehicleid_s  " +
							    " from t_process_station t1"+ 
							    " where  t1.mappingserialnumber_s is null"+
							    " and t1.action_s = '2'"+condition+
							    " group by vehicleid_s ) t2,"+
							    " t_subscribe_order t3,"+
							    " t_basis_roadinfo t4"+
						 " where t.vehicleid_s = t2.vehicleid_s"+
						   " and t.recorddate_d = t2.recorddate_d"+
						   " and t.orderid_s = t3.orderid_s(+)"+
						   " and t.facilityid_s = t4.roadid_s(+)"+
						   " order by t.recorddate_d DESC ";
		    Query query = session.createSQLQuery(hql);
		    List tmplist = query.list();
		    Iterator iterator = tmplist.iterator();
		    
			while(iterator.hasNext()){
				Station tmp = new Station();
				Object[] o = (Object[])iterator.next();
				tmp.setOrderID_s((String)o[0]);
				tmp.setVehicleID_s((String)o[1]);
				tmp.setRecordDate_d(DateUtil.stringToDateformat((String)o[2], "yyyy-MM-dd HH:mm:ss"));
				tmp.setOrderName((String)o[3]);
				tmp.setFacilityName((String)o[4]);
				list.add(tmp);
			}
			return (ArrayList) list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}
	
	/**
	 * 获得order进出道闸按车辆、道路的统计信息,如果没有信息，进行一次费用统计
	 * getBasisStationStaticsInfo 
	 * @param   name    
	 * @param  @return     resaveds1_s：总用时(分钟)
	 *                     spanMinute_i：收费用时
	 *                     facilityID_s:道路id
	 *                     FacilityName:道路名称
	 *                     vehicleCPG_s：车的CPG号
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getBasisStationStaticsInfoBymain(String orderID) throws Exception {
		ArrayList<Station> list = new ArrayList();
		list = this.getBasisStationStaticsInfo(orderID);
		if(!BasicTools.isnotNull(list)){
			IOrdercostInfoService impl = new OrdercostInfoServiceImpl();
			impl.OrderProcessStationCost(orderID);
			list = this.getBasisStationStaticsInfo(orderID);
		}
		return list;
	}
	
	/**
	 * 获得洗车信息
	 * getxcInOutInfo 
	 * @param   name    
	 * @param  @return     
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<Station> getXcInOutInfo(Station station,int start,
			int size) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		boolean b = false;//是否进行了统计
		try {
			conn = HibernateUtil.getconnBysession(session);
			
			List<Station> list = new ArrayList();
			String condition = "";
			String hql ="select * from (select s.*,rownum rn from ("+ 
						" select t.serialnumber_s,t.facilityid_s,to_char(t.recorddate_d,'yyyy-MM-dd HH24:mi:ss') recorddate_d , t.vehicleid_s, t.orderid_s, t2.ordername_s,t3.customername_s,t.vehiclecpg_s,t.resaveds5_s " +
						 " from t_process_station t, t_reception_order t2,t_subscribe_customer t3 " +
						 " where (t.resaveds4_s is null or t.resaveds4_s != '1') " +
						 " and (t.resaveds2_s is null or t.resaveds2_s != '1')"+
						 " and t.orderid_s = t2.orderid_s"+
						 " and t2.customerid_s = t3.customerid_s"+
						 
						 " and t.facilityid_s in (select t1.roadid_s " +
						 " from t_basis_roadInfo t1 " +
						 " where t1.resaveds2_s = '1') " +
						 " and t.serialnumber_s not in (" +
						 " 				select serialnumber_s from t_process_washCarinValid " +
						 "              where resaveds1_s='1') " ;
					
			if(station!=null){
				if(station.getOrderID_s()!=null&&!station.getOrderID_s().trim().equals("")){
					condition += " and t.orderid_s='"+station.getOrderID_s()+"'"; 
				}
				if(station.getOrderName()!=null&&!station.getOrderName().trim().equals("")){
					condition += " and t2.ordername_s like '%"+station.getOrderName()+"%'"; 
				}
				
				if(station.getStartSDate()!=null&&station.getStartEDate()!=null){
			    	
			    	condition += condition+" and  to_date(to_char(t.recorddate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+station.getStartSDate()+"','yyyy-MM-dd') and to_date('"+station.getStartEDate()+"','yyyy-MM-dd')";
			    }else if(station.getStartSDate()!=null){
			    	
			    	condition += condition+" and  to_date(to_char(t.recorddate_d,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+station.getStartSDate()+"','yyyy-MM-dd')";
			    }else if(station.getStartEDate() != null){
			    	
			    	condition += condition+" and  to_date(to_char(t.recorddate_d,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+station.getStartEDate()+"','yyyy-MM-dd')";
			    }
			}
			hql =hql +condition+ " order by t.recorddate_d desc ) s where rownum<="+(start+size)+")where  rn>"+start;
			//hql =hql +condition+ " order by t.recorddate_d desc ) where ROWNUM between "+start+" and "+(start+size)+"";
			//System.out.println("sql2====="+hql);
			stat = conn.createStatement();
			
			rs = stat.executeQuery(hql);
			
			while(rs.next()){
				b = true;
				Station tmp = new Station();
				//Object[] o = (Object[])iterator.next();
				tmp.setFacilityID_s(rs.getString("facilityid_s"));
				tmp.setSerialNumber_s(rs.getString("serialnumber_s"));
				tmp.setRecordDate_s(rs.getString("recorddate_d"));
				tmp.setRecordDate_d(DateUtil.stringToDateformat(rs.getString("recorddate_d"), "yyyy-MM-dd HH:mm:ss"));
				tmp.setVehicleID_s(rs.getString("vehicleid_s"));
				tmp.setOrderID_s(rs.getString("orderid_s"));
				tmp.setOrderName(rs.getString("ordername_s"));
				tmp.setCustomerName_s(rs.getString("customername_s"));
				tmp.setResaveds5_s(rs.getString("resaveds5_s"));
				tmp.setVehicleCPG_s(rs.getString("vehiclecpg_s"));
				list.add(tmp);
			}
			return (ArrayList) list;		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(stat!=null){
				stat.close();
				stat = null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			session.clear();
		}
	}
	
	public long getXcInOutInfoNum(Station station) throws Exception{
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		boolean b = false;//是否进行了统计
		long num = 0;
		try {
			conn = HibernateUtil.getconnBysession(session);
			
			
			String condition = "";
			String hql = " select count(1) c" +
						 " from t_process_station t,t_reception_order t2,t_subscribe_customer t3 " +
						 " where " +
						 " (t.resaveds4_s is null or t.resaveds4_s != '1')" +
						 " and (t.resaveds2_s is null or t.resaveds2_s != '1') " +
						 " and t.orderid_s = t2.orderid_s "+
		                 " and t2.customerid_s = t3.customerid_s "+
						 " and exists   (" +
						 	" select t1.roadid_s  " +
						 	" from t_basis_roadInfo t1  " +
						 	"where t1.resaveds2_s = '1' and  t.facilityid_s = t1.roadid_s) " +
						 	"and exists (" +
						 	"			select serialnumber_s from t_process_washCarinValid " +
						 	"           where  resaveds1_s='1' and  t.serialnumber_s != serialnumber_s) " ;
					
			if(station!=null){
				if(station.getOrderID_s()!=null&&!station.getOrderID_s().trim().equals("")){
					condition += " and t.orderid_s='"+station.getOrderID_s()+"'"; 
				}
				if(station.getOrderName()!=null&&!station.getOrderName().trim().equals("")){
					condition += " and t2.ordername_s like '%"+station.getOrderName()+"%'"; 
				}
				if(station.getStartSDate()!=null&&station.getStartEDate()!=null){
			    	condition += condition+" and  to_date(to_char(t.recorddate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+station.getStartSDate()+"','yyyy-MM-dd') and to_date('"+station.getStartEDate()+"','yyyy-MM-dd')";
			    }else if(station.getStartSDate()!=null){
			    	condition += condition+" and  to_date(to_char(t.recorddate_d,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+station.getStartSDate()+"','yyyy-MM-dd')";
			    }else if(station.getStartEDate() != null){
			    	condition += condition+" and  to_date(to_char(t.recorddate_d,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+station.getStartEDate()+"','yyyy-MM-dd')";
			    }
			}
			//System.out.println("sql1====="+hql+condition);
			stat = conn.createStatement();
			rs = stat.executeQuery(hql+condition);
			if(rs.next()){
				num = rs.getInt("c");
			}
			 
			return num;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(stat!=null){
				stat.close();
				stat = null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			session.clear();
		}
	}
	
	/**
	 * 道路使用量确认清单	   
	 * getRoadEmployInventoryList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<RoadEmployInventory> getRoadEmployInventoryList(RoadEmployInventory model)throws Exception{
		Session session = HibernateUtil.getSession();
		List<RoadEmployInventory> list = new ArrayList<RoadEmployInventory>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		 
		try {
			if(model==null){
				return null;
			}
			if(model.getOrderId_s()==null||"".equals(model.getOrderId_s().trim())){
				return null;
			}
			conn = HibernateUtil.getconnBysession(session);
			String hql = "select t.vehicleid_s,                                               "+  
						 "t.Facilityid_s,                                              "+
						 "t.resaveds5_s,                                               "+
						 //"t1.brandtype_s,                                              "+
						 "t2.roadname_s,                                               "+
						 "t.resaveds1_s,                                               "+
						 "t.Spanminute_i,                                              "+
						 "t.preincludetime_i,                                          "+
						 "t.wholeincludetime_i,                                        "+
						 "to_char(t.recorddate_d,'yyyy-MM-dd HH24:mi:ss') recorddate_d,"+
						"t.resaveds3_s resaveds3_s                                    "+
						// " from t_process_station t ,t_reception_vehicleinfo t1,t_basis_roadinfo t2" +
						 " from t_process_station t ,t_basis_roadinfo t2" +
						 " where t.orderid_s = '"+model.getOrderId_s()+"' " +
						 " and t.resaveds3_s is not null " +
						 " and t.resaveds3_s > '"+model.getStartComeDate_s()+"' " +
						 " and t.resaveds3_s < '"+model.getEndComeDate_s()+"' " +
						// " and t.vehiclecpg_s = t1.vehiclecpg_s "+
						 " and t.facilityid_s = t2.roadid_s "+
						 " order by t.vehicleID_s,t.Facilityid_s,t.resaveds3_s";
//System.out.println("hsql="+hql);
			  
			stat = conn.createStatement();
			rs = stat.executeQuery(hql);
			String facilityid_s = "";//道路id
			String vehicleid_s = "";//车卡id
			int i=0;
			StationDetailModel stationDetailModel = null;
			RoadEmployInventory tmpmodel = null;
			int row=0;//相同道路分页
			int row1=0;//同一车辆分页
			boolean b = false;
			while(rs.next()){
				vehicleid_s  = rs.getString("vehicleid_s");
				facilityid_s = rs.getString("Facilityid_s");
				if(i==0){
					tmpmodel = new RoadEmployInventory();
					tmpmodel.setCardId_s(vehicleid_s);
					tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
					//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
					tmpmodel.setBrandType_s("");
					stationDetailModel = tmpmodel.getStationDetailModel();
					stationDetailModel.setRoadId_s(facilityid_s);
					stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
					stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
					stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
					stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
					stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
					StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
					stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
					stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
					stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
					stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
				}else{
					//同一辆车
					if(vehicleid_s.equals(tmpmodel.getCardId_s())){
						//同一条道路
						if(facilityid_s.equals(stationDetailModel.getRoadId_s())){
							row++;
							row1++;
							if(row>=20){
								b = true;
								row=0;
								row1=0;
								tmpmodel.addStationDetailModelList(stationDetailModel);
								list.add(tmpmodel);
								tmpmodel = new RoadEmployInventory();
								tmpmodel.setCardId_s(vehicleid_s);
								tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
								//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
								tmpmodel.setBrandType_s("");
								stationDetailModel = tmpmodel.getStationDetailModel();
								stationDetailModel.setRoadId_s(facilityid_s);
								stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
								stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
								stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
								stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
								StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
								stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
								stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
								stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
							}else{
								stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
								stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
								stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
								StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
								stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
								stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
								stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
							}
							 
						}else{
							b = false;
							row=0;
							row1++;
							System.out.println("row1================================================="+row1);
							if(row1>=40){
								System.out.println("row222222222222222222222222================================================="+row1);
								b = true;
								row=0;
								row1=0;
								tmpmodel.addStationDetailModelList(stationDetailModel);
								list.add(tmpmodel);
								tmpmodel = new RoadEmployInventory();
								tmpmodel.setCardId_s(vehicleid_s);
								tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
								//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
								tmpmodel.setBrandType_s("");
								stationDetailModel = tmpmodel.getStationDetailModel();
								stationDetailModel.setRoadId_s(facilityid_s);
								stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
								stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
								stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
								stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
								StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
								stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
								stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
								stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
							}else{
								row1++;
								tmpmodel.addStationDetailModelList(stationDetailModel);						 
								stationDetailModel = tmpmodel.getStationDetailModel();
								stationDetailModel.setRoadId_s(facilityid_s);
								stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
								stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
								stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
								stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
								StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
								stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
								stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
								stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
								stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
							}
						}
					}
					else{
						b = false;
						row=0;
						row1=0;
						tmpmodel.addStationDetailModelList(stationDetailModel);
						list.add(tmpmodel);
						tmpmodel = new RoadEmployInventory();
						tmpmodel.setCardId_s(vehicleid_s);
						tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
						//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
						tmpmodel.setBrandType_s("");
						stationDetailModel = tmpmodel.getStationDetailModel();
						stationDetailModel.setRoadId_s(facilityid_s);
						stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
						stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
						stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
						stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
						stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
						StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
						stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
						stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
						stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
						stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
					}
				}
				i++;				
			}
			if(i!=0){	
				tmpmodel.addStationDetailModelList(stationDetailModel);
				list.add(tmpmodel);
			}
			return list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(stat!=null){
				stat.close();
				stat = null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			session.clear();
		}
	}
	
	/**
	 * 道路使用量确认清单	   
	 * getRoadEmployInventoryList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<RoadEmployInventory> getRoadEmployInventoryListold(RoadEmployInventory model)throws Exception{
		Session session = HibernateUtil.getSession();
		List<RoadEmployInventory> list = new ArrayList<RoadEmployInventory>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		 
		try {
			if(model==null){
				return null;
			}
			if(model.getOrderId_s()==null||"".equals(model.getOrderId_s().trim())){
				return null;
			}
			conn = HibernateUtil.getconnBysession(session);
			String hql = "select t.vehicleid_s,                                               "+  
						 "t.Facilityid_s,                                              "+
						 "t.resaveds5_s,                                               "+
						 //"t1.brandtype_s,                                              "+
						 "t2.roadname_s,                                               "+
						 "t.resaveds1_s,                                               "+
						 "t.Spanminute_i,                                              "+
						 "t.preincludetime_i,                                          "+
						 "t.wholeincludetime_i,                                        "+
						 "to_char(t.recorddate_d,'yyyy-MM-dd HH24:mi:ss') recorddate_d,"+
						"t.resaveds3_s resaveds3_s                                    "+
						 //" from t_process_station t ,t_reception_vehicleinfo t1,t_basis_roadinfo t2" +
						 " from t_process_station t ,t_basis_roadinfo t2" +
						 " where t.orderid_s = '"+model.getOrderId_s()+"' " +
						 " and t.resaveds3_s is not null " +
						 " and t.resaveds3_s > '"+model.getStartComeDate_s()+"' " +
						 " and t.resaveds3_s < '"+model.getEndComeDate_s()+"' " +
						 //" and t.vehiclecpg_s = t1.vehiclecpg_s "+
						 " and t.facilityid_s = t2.roadid_s "+
						 " order by t.vehicleID_s,t.Facilityid_s,t.resaveds3_s";
//System.out.println("hsql="+hql);
			  
			stat = conn.createStatement();
			rs = stat.executeQuery(hql);
			String facilityid_s = "";//道路id
			String vehicleid_s = "";//车卡id
			int i=0;
			StationDetailModel stationDetailModel = null;
			RoadEmployInventory tmpmodel = null;
			int row=0;
			boolean b = false;
			while(rs.next()){
				vehicleid_s  = rs.getString("vehicleid_s");
				facilityid_s = rs.getString("Facilityid_s");
				if(i==0){
					tmpmodel = new RoadEmployInventory();
					tmpmodel.setCardId_s(vehicleid_s);
					tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
					//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
					tmpmodel.setBrandType_s("");
					stationDetailModel = tmpmodel.getStationDetailModel();
					stationDetailModel.setRoadId_s(facilityid_s);
					stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
					stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
					stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
					stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
					stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
					StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
					stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
					stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
					stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
					stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
				}else{
					//同一辆车
					if(vehicleid_s.equals(tmpmodel.getCardId_s())){
						//同一条道路
						if(facilityid_s.equals(stationDetailModel.getRoadId_s())){
							row++;
							if(row%20==0){
								tmpmodel.addStationDetailModelList(stationDetailModel);
								//list.add(tmpmodel);
								tmpmodel = new RoadEmployInventory();
								tmpmodel.setCardId_s(vehicleid_s);
								tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
								//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
								tmpmodel.setBrandType_s("");
								stationDetailModel.setRoadId_s(facilityid_s);
								stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
								//stationDetailModel = tmpmodel.getStationDetailModel();
								row=0;
								b = true;
							}else if(b){
								b = false;
								tmpmodel = new RoadEmployInventory();
								tmpmodel.setCardId_s(vehicleid_s);
								tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
								//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
								tmpmodel.setBrandType_s("");
								stationDetailModel.setRoadId_s(facilityid_s);
								stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
								//stationDetailModel = tmpmodel.getStationDetailModel();
							}
							stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
							stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
							stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
							stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
							StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
							stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
							stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
							stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
							stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
							
						}else{
							b = false;
							row=0;
							tmpmodel.addStationDetailModelList(stationDetailModel);
							
							/*list.add(tmpmodel);
							tmpmodel = new RoadEmployInventory();
							tmpmodel.setCardId_s(vehicleid_s);
							tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
							tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
							stationDetailModel.setRoadId_s(facilityid_s);
							stationDetailModel.setRoadName_s(rs.getString("roadname_s"));*/
							
							stationDetailModel = tmpmodel.getStationDetailModel();
							stationDetailModel.setRoadId_s(facilityid_s);
							stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
							stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
							stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
							stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
							stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
							StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
							stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
							stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
							stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
							stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
						}
					}
					else{
						b = false;
						row=0;
						tmpmodel.addStationDetailModelList(stationDetailModel);
						list.add(tmpmodel);
						tmpmodel = new RoadEmployInventory();
						tmpmodel.setCardId_s(vehicleid_s);
						tmpmodel.setHandworkCpg(rs.getString("resaveds5_s"));
						//tmpmodel.setBrandType_s(rs.getString("brandtype_s"));
						tmpmodel.setBrandType_s("");
						stationDetailModel = tmpmodel.getStationDetailModel();
						stationDetailModel.setRoadId_s(facilityid_s);
						stationDetailModel.setRoadName_s(rs.getString("roadname_s"));
						stationDetailModel.setEmployTimeCount(rs.getInt("resaveds1_s"));
						stationDetailModel.setShareTimeCount(rs.getInt("spanMinute_i"));
						stationDetailModel.setPreTimeCount(rs.getInt("preincludetime_i"));
						stationDetailModel.setWholeTimeCount(rs.getInt("wholeincludetime_i"));
						StationDetailTimeModel stationDetailTimeModel = stationDetailModel.getStationDetailTimeModel();
						stationDetailTimeModel.setComeTime(rs.getString("recorddate_d"));
						stationDetailTimeModel.setEnterTime(rs.getString("resaveds3_s"));
						stationDetailTimeModel.setTimeCount(rs.getInt("resaveds1_s"));
						stationDetailModel.addStationDetailTimeModelList(stationDetailTimeModel);
					}
				}
				i++;				
			}
			if(i!=0){	
				tmpmodel.addStationDetailModelList(stationDetailModel);
				list.add(tmpmodel);
			}
			return list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(stat!=null){
				stat.close();
				stat = null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			session.clear();
		}
	}
	
	/**
	 * 道路使用量确认清单导出pdf	   
	 * getRoadEmployInventoryList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String[] 1:pdf名称  2:客户名称    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String[] getRoadEmployInventoryPDF(RoadEmployInventory model,List<RoadEmployInventory> list)throws Exception{
		String[] request = new String[2];
		//List<RoadEmployInventory> list = this.getRoadEmployInventoryList(model);
		IreceptionOrderService rs = new ReceptionOrderServiceImpl();
		ReceptionOrder receptionOrder =  new ReceptionOrder();
		receptionOrder.setOrderID_s(model.getOrderId_s());
		receptionOrder = rs.getReceptionOrder(receptionOrder, ConstantUtil.pagingNot, 0).get(0);
		//File file = File.createTempFile(receptionOrder.getOrderName_s(), ".pdf");
		IOrdercostInfoService impl = new OrdercostInfoServiceImpl();
		//impl.OrderProcessStationCost(model.getOrderId_s());
		String carid = model.getCardId_s();
//		if(carid != null && !carid.equals(""))
//		{
//			impl.OrderProcessStationCostByTimeandCarID(model.getOrderId_s(),model.getStartComeDate_s(),model.getEndComeDate_s(), carid);
//		}else
//		{
//
//			impl.OrderProcessStationCostByTime(model.getOrderId_s(),model.getStartComeDate_s(),model.getEndComeDate_s());
//		}
		String filenames = receptionOrder.getCustomer().getCustomerName_s()+receptionOrder.getOrderName_s()+DateUtil.dateToString(receptionOrder.getStartDate_d(),"yyyy-MM-dd");
		File file = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath()+"/pdf/"+filenames+".pdf");
		SavePDFUtil.createPDFFile(file, list,receptionOrder.getCustomer().getCustomerName_s(), model.getOrderId_s(), model.getStartComeDate_s(), model.getEndComeDate_s());
		request[0] = filenames;
		request[1] = receptionOrder.getCustomer().getCustomerName_s();
		return request;
	}
	
	
	/**
	 * 道路使用量确认清单导出pdf	   
	 * getRoadEmployInventoryList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String[] 1:pdf名称  2:客户名称    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void CaluEmployInventory(RoadEmployInventory model)throws Exception{
		String[] request = new String[2];
		//List<RoadEmployInventory> list = this.getRoadEmployInventoryList(model);
		IreceptionOrderService rs = new ReceptionOrderServiceImpl();
		ReceptionOrder receptionOrder =  new ReceptionOrder();
		receptionOrder.setOrderID_s(model.getOrderId_s());
		receptionOrder = rs.getReceptionOrder(receptionOrder, ConstantUtil.pagingNot, 0).get(0);
		//File file = File.createTempFile(receptionOrder.getOrderName_s(), ".pdf");
		IOrdercostInfoService impl = new OrdercostInfoServiceImpl();
		//impl.OrderProcessStationCost(model.getOrderId_s());
		String carid = model.getCardId_s();
		if(carid != null && !carid.equals(""))
		{
			impl.OrderProcessStationCostByTimeandCarID(model.getOrderId_s(),model.getStartComeDate_s(),model.getEndComeDate_s(), carid);
		}else
		{

			impl.OrderProcessStationCostByTime(model.getOrderId_s(),model.getStartComeDate_s(),model.getEndComeDate_s());
		}
		
	}
	
	public static void main(String arg[]){
		/*StationServiceImpl service = new StationServiceImpl();
		Station s = new Station ();
		s.setFacilityID_s("DL2014091003");
		try {
			RoadEmployInventory model = new RoadEmployInventory();
			model.setOrderId_s("DD2014111017");
			model.setStartComeDate_s("2013-09-30");
			model.setEndComeDate_s("2015-10-30");
			service.getRoadEmployInventoryPDF(model);
			List l = service.getXcInOutInfo(null,ConstantUtil.pagingNot,15);
			Iterator iterator = l.iterator();
			//System.out.println(l.size());
			
			List<RoadEmployInventory> l = service.getRoadEmployInventoryList(model);
			//System.out.println(l.size());
			for(int i=0;i<l.size();i++){
				RoadEmployInventory t = l.get(i);
				//System.out.println(i+"卡号"+t.getCardId_s());
				//System.out.println(i+"类型"+t.getBrandType_s());
				//System.out.println(i+"数量"+t.getStationDetailModelsize());
				List<StationDetailModel> stationDetailModelList = t.getStationDetailModelList();
				for(int j=0;j<stationDetailModelList.size();j++){
					StationDetailModel s1 = stationDetailModelList.get(j);
					//System.out.println(j+"道路"+s1.getRoadId_s()+" "+s1.getRoadName_s());
					//System.out.println(j+"总时间"+s1.getEmployTimeCount());
					//System.out.println(j+"精确时间"+s1.getPreTimeCount());
					//System.out.println(j+"共享"+s1.getShareTimeCount());
					//System.out.println(j+"包场"+s1.getWholeTimeCount());
					//System.out.println(j+"数量"+s1.getStationDetailTimeModelSize());
					List<StationDetailTimeModel> StationDetailTimeModell = s1.getStationDetailTimeModelList();
					for(int k=0;k<StationDetailTimeModell.size();k++){
						StationDetailTimeModel s2 = StationDetailTimeModell.get(k);
						//System.out.println(k+"进时间"+s2.getComeTime());
						//System.out.println(k+"出时间"+s2.getEnterTime());
						//System.out.println(k+"总时间"+s2.getTimeCount());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//System.out.println(60%20);
		
	}
}
