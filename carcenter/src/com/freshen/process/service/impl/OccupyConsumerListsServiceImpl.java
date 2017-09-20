package com.freshen.process.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.process.OccupyConsumerLists;
import com.freshen.entity.process.Station;
import com.freshen.process.service.IoccupyConsumerListsService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OccupyConsumerListsServiceImpl extends ClimsServiceBase implements
		IoccupyConsumerListsService {

	String orderID_s,
		facilityID_s,
		serialNumber_s,
		mappingSerialNumber_s,
		vehicleID_s,
		expense,
		vehicleCPG_s;
	String createUser_s,
	    lastUpdateUser_s;
	String resaveds1_s,
	    resaveds2_s,
	    resaveds3_s,
	    resaveds4_s,
	    resaveds5_s;
	Date   lastUpdateDate_t;
	Date   createDate_t;
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<OccupyConsumerLists> getBasisOccupyConsumerListsInfo(
			OccupyConsumerLists occupyConsumerLists, int start, int size)
			throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try {
			List<Station> list = new ArrayList();
			
			if(occupyConsumerLists == null){
				Query query=session.createQuery("from OccupyConsumerLists as occupyConsumerLists");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			
			orderID_s = occupyConsumerLists.getOrderID_s();
			facilityID_s = occupyConsumerLists.getFacilityID_s();
			serialNumber_s = occupyConsumerLists.getSerialNumber_s();
			mappingSerialNumber_s = occupyConsumerLists.getMappingSerialNumber_s();
			vehicleID_s = occupyConsumerLists.getVehicleID_s();
			expense = occupyConsumerLists.getExpense();
			vehicleCPG_s = occupyConsumerLists.getVehicleCPG_s();
			createUser_s = occupyConsumerLists.getCreateUser_s();
		    lastUpdateUser_s =occupyConsumerLists.getLastUpdateUser_s();
		    resaveds1_s  = occupyConsumerLists.getResaveds1_s();
		    resaveds2_s =occupyConsumerLists.getResaveds2_s();
		    resaveds3_s = occupyConsumerLists.getResaveds3_s();
		    resaveds4_s = occupyConsumerLists.getResaveds4_s();
		    resaveds5_s = occupyConsumerLists.getResaveds5_s();
		    lastUpdateDate_t = occupyConsumerLists.getLastUpdateDate_t();
		    createDate_t = occupyConsumerLists.getCreateDate_t();
			
			String hql = " from OccupyConsumerLists as occupyConsumerLists where 1=1 ";
		    String condition = "";
		    
		    if(orderID_s != null && !orderID_s.trim().equals(""))
		    {
		    	condition += " and occupyConsumerLists.orderID_s like '%" + orderID_s.trim() + "%'";
		    }
		    if(facilityID_s != null && facilityID_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.facilityID_s like '%" + facilityID_s.trim() + "%'";
		    }
		    
		    if(createDate_t != null )
		    {
		     	condition = condition + " and to_char(occupyConsumerLists.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null )
		    {
		     	condition = condition + " and to_char(occupyConsumerLists.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(serialNumber_s != null && serialNumber_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.serialNumber_s like '%" + serialNumber_s.trim() + "%'";
		    }
		    if(mappingSerialNumber_s != null && mappingSerialNumber_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.mappingSerialNumber_s like '%" + mappingSerialNumber_s.trim() + "%'";
		    }
		    if(vehicleID_s != null && vehicleID_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(vehicleCPG_s != null && vehicleCPG_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.vehicleCPG_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && lastUpdateUser_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    } 
		    if(expense != null && expense.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.expense like '%" + expense.trim() + "%'";
		    }
			
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

	public long getBasisOccupyConsumerListsInfo(
			OccupyConsumerLists occupyConsumerLists) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<Station> list = new ArrayList();
			
			if(occupyConsumerLists == null){
				Query query=session.createQuery(" select count(*) from OccupyConsumerLists as occupyConsumerLists");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }    
				    return n;
			}
			
			orderID_s = occupyConsumerLists.getOrderID_s();
			facilityID_s = occupyConsumerLists.getFacilityID_s();
			serialNumber_s = occupyConsumerLists.getSerialNumber_s();
			mappingSerialNumber_s = occupyConsumerLists.getMappingSerialNumber_s();
			vehicleID_s = occupyConsumerLists.getVehicleID_s();
			expense = occupyConsumerLists.getExpense();
			vehicleCPG_s = occupyConsumerLists.getVehicleCPG_s();
			createUser_s = occupyConsumerLists.getCreateUser_s();
		    lastUpdateUser_s =occupyConsumerLists.getLastUpdateUser_s();
		    resaveds1_s  = occupyConsumerLists.getResaveds1_s();
		    resaveds2_s =occupyConsumerLists.getResaveds2_s();
		    resaveds3_s = occupyConsumerLists.getResaveds3_s();
		    resaveds4_s = occupyConsumerLists.getResaveds4_s();
		    resaveds5_s = occupyConsumerLists.getResaveds5_s();
		    lastUpdateDate_t = occupyConsumerLists.getLastUpdateDate_t();
		    createDate_t = occupyConsumerLists.getCreateDate_t();
			
			String hql = " select count(*)  from OccupyConsumerLists as occupyConsumerLists where 1=1 ";
		    String condition = "";
		    
		    if(orderID_s != null && !orderID_s.trim().equals(""))
		    {
		    	condition += " and occupyConsumerLists.orderID_s like '%" + orderID_s.trim() + "%'";
		    }
		    if(facilityID_s != null && facilityID_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.facilityID_s like '%" + facilityID_s.trim() + "%'";
		    }
		    
		    if(createDate_t != null )
		    {
		     	condition = condition + " and to_char(occupyConsumerLists.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null )
		    {
		     	condition = condition + " and to_char(occupyConsumerLists.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(serialNumber_s != null && serialNumber_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.serialNumber_s like '%" + serialNumber_s.trim() + "%'";
		    }
		    if(mappingSerialNumber_s != null && mappingSerialNumber_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.mappingSerialNumber_s like '%" + mappingSerialNumber_s.trim() + "%'";
		    }
		    if(vehicleID_s != null && vehicleID_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(vehicleCPG_s != null && vehicleCPG_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.vehicleCPG_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && lastUpdateUser_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    } 
		    if(expense != null && expense.trim().equals("") )
		    {
		    	condition += " and occupyConsumerLists.expense like '%" + expense.trim() + "%'";
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

}
