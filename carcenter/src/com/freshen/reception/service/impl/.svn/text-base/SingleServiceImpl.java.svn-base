package com.freshen.reception.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.basis.Driver;
import com.freshen.entity.reception.Single;
import com.freshen.reception.service.IsingleServie;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;



public class SingleServiceImpl extends ClimsServiceBase implements IsingleServie {

	String orderID_s, singleID_s, vehicleID_s;
	Date date_t;
	String fieldID_s;
	Date startDate_t, endDate_t, createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<Single> getSingleInfo(Single single, int start, int size)
			throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			 List<Single> list = new ArrayList();
			
			 if(single == null)
			 {
				 Query query = session.createQuery(" from Single as single ");
				 query.setFirstResult(start);
				 query.setMaxResults(size);
				 list = query.list();
				 return (ArrayList)list;
			 }
			 
			 String hql = "  from Single as single where 1=1 ";
			 String condition = "";
			 
			 if(orderID_s != null &&!orderID_s.trim().equals("") ){
				 condition = " and single.orderID_s like '%" + orderID_s.trim() + "%'";
			 }
			 if(singleID_s != null &&!singleID_s.trim().equals("") ){
				 condition = " and single.singleID_s like '%" + singleID_s.trim() + "%'";
			 }
			 if(vehicleID_s != null &&!vehicleID_s.trim().equals("") ){
				 condition = " and single.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
			 }
			 if(date_t != null){
		    	 condition = condition + " and to_char(single.date_t,'yyyy-MM-dd')='" + DateUtil.dateToString(date_t, "yyyy-MM-dd") +"'";
		     }
			 if(fieldID_s != null &&!fieldID_s.trim().equals("") ){
				 condition = " and single.fieldID_s like '%" + fieldID_s.trim() + "%'";
			 }
			 if(startDate_t != null){
		    	 condition = condition + " and to_char(single.startDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(endDate_t != null){
		    	 condition = condition + " and to_char(single.endDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(createDate_t != null){
		    	 condition = condition + " and to_char(single.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(createUser_s != null &&!createUser_s.trim().equals("") ){
				 condition = " and single.createUser_s like '%" + createUser_s.trim() + "%'";
			 }
			 if(lastUpdateUser_s != null &&!lastUpdateUser_s.trim().equals("") ){
				 condition = " and single.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			 }
			 if(lastUpdateDate_t != null){
		    	 condition = condition + " and to_char(single.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(resaveds1_s != null &&!resaveds1_s.trim().equals("") ){
				 condition = " and single.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			 }
			 if(resaveds2_s != null &&!resaveds2_s.trim().equals("") ){
				 condition = " and single.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			 }
			 if(resaveds3_s != null &&!resaveds3_s.trim().equals("") ){
				 condition = " and single.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			 }
			 if(resaveds4_s != null &&!resaveds4_s.trim().equals("") ){
				 condition = " and single.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			 }
			 if(resaveds5_s != null &&!resaveds5_s.trim().equals("") ){
				 condition = " and single.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			 }
			 Query query = session.createQuery(hql+condition);
			 query.setFirstResult(start);
			 query.setMaxResults(size);
			 list = query.list();
			 return (ArrayList)list;
			 
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		}
	}

	public long getSingleNumber(Single single) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			 List<Single> list = new ArrayList();
			
			 if(single == null)
			 {
				 Query query = session.createQuery(" select count(*) from Single as single ");
				 if(query.iterate().hasNext()){
					 n = (Long)query.iterate().next();
					 return n;
				 }
			 }
			 
			 String hql = "  from Single as single where 1=1 ";
			 String condition = "";
			 
			 if(orderID_s != null &&!orderID_s.trim().equals("") ){
				 condition = " and single.orderID_s like '%" + orderID_s.trim() + "%'";
			 }
			 if(singleID_s != null &&!singleID_s.trim().equals("") ){
				 condition = " and single.singleID_s like '%" + singleID_s.trim() + "%'";
			 }
			 if(vehicleID_s != null &&!vehicleID_s.trim().equals("") ){
				 condition = " and single.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
			 }
			 if(date_t != null){
		    	 condition = condition + " and to_char(single.date_t,'yyyy-MM-dd')='" + DateUtil.dateToString(date_t, "yyyy-MM-dd") +"'";
		     }
			 if(fieldID_s != null &&!fieldID_s.trim().equals("") ){
				 condition = " and single.fieldID_s like '%" + fieldID_s.trim() + "%'";
			 }
			 if(startDate_t != null){
		    	 condition = condition + " and to_char(single.startDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(endDate_t != null){
		    	 condition = condition + " and to_char(single.endDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(createDate_t != null){
		    	 condition = condition + " and to_char(single.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(createUser_s != null &&!createUser_s.trim().equals("") ){
				 condition = " and single.createUser_s like '%" + createUser_s.trim() + "%'";
			 }
			 if(lastUpdateUser_s != null &&!lastUpdateUser_s.trim().equals("") ){
				 condition = " and single.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			 }
			 if(lastUpdateDate_t != null){
		    	 condition = condition + " and to_char(single.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		     }
			 if(resaveds1_s != null &&!resaveds1_s.trim().equals("") ){
				 condition = " and single.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			 }
			 if(resaveds2_s != null &&!resaveds2_s.trim().equals("") ){
				 condition = " and single.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			 }
			 if(resaveds3_s != null &&!resaveds3_s.trim().equals("") ){
				 condition = " and single.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			 }
			 if(resaveds4_s != null &&!resaveds4_s.trim().equals("") ){
				 condition = " and single.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			 }
			 if(resaveds5_s != null &&!resaveds5_s.trim().equals("") ){
				 condition = " and single.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			 }
			 Query query = session.createQuery(hql+condition);
			 if(query.iterate().hasNext()){
				 n=(Long)query.iterate().next();
				 return n;
			 }
			 
		}catch(Exception e){
			throw e;
		}finally{
			session.clear();
		}
		return 0;
	}

	public int saveOrUpdateSingleInfo(ArrayList<Single> list) throws Exception {
		// TODO Auto-generated method stub
		Single single = new Single();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					
					if(list.get(i).getOrderID_s() != null && !list.get(i).getOrderID_s().equals("")){
						single.setOrderID_s(list.get(i).getOrderID_s());
					} 
					if(list.get(i).getSingleID_s() != null && !list.get(i).getSingleID_s().equals("")){
						single.setSingleID_s(list.get(i).getSingleID_s());
					}else{
						IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.ZDDBusiness, session);
						single.setSingleID_s(pk);
					}
					if(list.get(i).getVehicleID_s() != null && !list.get(i).getVehicleID_s().equals("")){
						single.setVehicleID_s(list.get(i).getVehicleID_s());
					}
					if(list.get(i).getDate_t() != null ){
						single.setDate_t(list.get(i).getDate_t());
					}
					if(list.get(i).getFieldID_s() != null && !list.get(i).getFieldID_s().equals("")){
						single.setFieldID_s(list.get(i).getFieldID_s());
					}
					if(list.get(i).getStartDate_t() != null ){
						single.setStartDate_t(list.get(i).getStartDate_t());
					}
					if(list.get(i).getEndDate_t() != null ){
						single.setEndDate_t(list.get(i).getEndDate_t());
					}
					if(list.get(i).getCreateDate_t() != null ){
						single.setCreateDate_t(list.get(i).getCreateDate_t());
					}
					if(list.get(i).getCreateUser_s() != null && !list.get(i).getCreateUser_s().equals("")){
						single.setCreateUser_s(list.get(i).getCreateUser_s());
					}
					if(list.get(i).getLastUpdateUser_s() != null && !list.get(i).getLastUpdateUser_s().equals("")){
						single.setLastUpdateUser_s(list.get(i).getLastUpdateUser_s());
					}
					if(list.get(i).getLastUpdateDate_t() != null){
						single.setLastUpdateDate_t(list.get(i).getLastUpdateDate_t());
					}
					if(list.get(i).getResaveds1_s() != null && !list.get(i).getResaveds1_s().equals("")){
						single.setCreateUser_s(list.get(i).getCreateUser_s());
					}
					if(list.get(i).getResaveds2_s() != null && !list.get(i).getResaveds2_s().equals("")){
						single.setResaveds2_s(list.get(i).getResaveds2_s());
					}
					if(list.get(i).getResaveds3_s() != null && !list.get(i).getResaveds3_s().equals("")){
						single.setResaveds3_s(list.get(i).getResaveds3_s());
					}
					if(list.get(i).getResaveds4_s() != null && !list.get(i).getResaveds4_s().equals("")){
						single.setResaveds4_s(list.get(i).getResaveds4_s());
					}
					if(list.get(i).getResaveds5_s() != null && !list.get(i).getResaveds5_s().equals("")){
						single.setResaveds5_s(list.get(i).getResaveds5_s());
					}
					//System.out.println("===="+single.toString());
					session.saveOrUpdate(single);
					tx.commit();
				}
								
			}else{
				throw new Exception("子订单信息不正确");
			}		
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	
	public static void main(String arg[]) throws Exception{
		List<Single> list = new ArrayList();
		Single single = new Single();
		single.setCreateUser_s("fdsafd");
		single.setLastUpdateUser_s("部门1");
		single.setDate_t(new Date());
		single.setCreateDate_t(new Date());
		single.setStartDate_t(new Date());
		single.setEndDate_t(new Date());
		single.setOrderID_s("erds");
//		single.setCreateUser_s("lz");
		Date date = new Date();
		date.setYear(112);
		single.setLastUpdateDate_t(new Date());
		list.add(single);
		IsingleServie iss = new SingleServiceImpl();
//		int i = iss.saveOrUpdateSingleInfo((ArrayList)list);
		iss.getSingleInfo(null, -1, 10);
	}

	
}
