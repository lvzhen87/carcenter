package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.CustomerRegister;
import com.freshen.preorder.service.IcustomerRegisterService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class CustomerRegisterServiceimpl extends ClimsServiceBase implements IcustomerRegisterService {

	String customerUserID_s;
	String orderID_s;
	Integer userType_i;
	Integer isSafetyTrain_i;
	Integer isAirportPickup_i;
	Integer isCheckinHotel_i;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<CustomerRegister> getBasisCustomerRegister(
			CustomerRegister customerRegister, int start, int size)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		try {
			
			List<CustomerRegister> list = new ArrayList<CustomerRegister>();
			if(customerRegister==null)
			{
				Query query = session.createQuery("from CustomerRegister as customerRegister ");
				if(start != -1)
				{
					query.setFirstResult(start);		
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			String hql = " from CustomerRegister as customerRegister  where 1=1 ";
			String condition="";
			
			customerUserID_s = customerRegister.getCustomerUserID_s();
			if(customerUserID_s!= null &&!customerUserID_s.trim().equals("")){
				condition = condition + " and customerRegister.customerUserID_s like '%" + customerUserID_s.trim() + "%'";
			}
			orderID_s = customerRegister.getOrderID_s();
			if(orderID_s!= null &&!orderID_s.trim().equals("")){
				condition = condition + " and customerRegister.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			userType_i = customerRegister.getUserType_i();
			if(userType_i != null && userType_i != -1){
				condition = condition + " and customerRegister.userType_i  = '" + userType_i +"'";
			}
			isSafetyTrain_i = customerRegister.getIsSafetyTrain_i();
			if(isSafetyTrain_i != null && isSafetyTrain_i != -1){
				condition = condition + " and customerRegister.isSafetyTrain_i  = '" + isSafetyTrain_i +"'";
			}
			isAirportPickup_i = customerRegister.getIsAirportPickup_i();
			if(isAirportPickup_i != null && isAirportPickup_i != -1){
				condition = condition + " and customerRegister.isAirportPickup_i  = '" + isAirportPickup_i +"'";
			}
			isCheckinHotel_i = customerRegister.getIsCheckinHotel_i();
			if(isCheckinHotel_i != null && isCheckinHotel_i != -1){
				condition = condition + " and customerRegister.isCheckinHotel_i  = '" + isCheckinHotel_i +"'";
			}
			createDate_t = customerRegister.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(customerRegister.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }			
			createUser_s = customerRegister.getCreateUser_s();
			if(createUser_s!= null &&!createUser_s.trim().equals("")){
				condition = condition + " and customerRegister.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = customerRegister.getLastUpdateUser_s();
			if(lastUpdateUser_s!= null &&!lastUpdateUser_s.trim().equals("")){
				condition = condition + " and customerRegister.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = customerRegister.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(customerRegister.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = customerRegister.getResaveds1_s();
			if(resaveds1_s!= null &&!resaveds1_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			}
			resaveds2_s = customerRegister.getResaveds2_s(); 
			if(resaveds2_s!= null &&!resaveds2_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			}
			resaveds3_s = customerRegister.getResaveds3_s();
			if(resaveds3_s!= null &&!resaveds3_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			}
			resaveds4_s = customerRegister.getResaveds4_s();
			if(resaveds4_s!= null &&!resaveds4_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			}
			resaveds5_s = customerRegister.getResaveds5_s();
			if(resaveds5_s!= null &&!resaveds5_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			}
			
			condition = condition+" order by customerRegister.createDate_t ";
		    Query query = session.createQuery(hql+condition);
		    
		    if(start != -1)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
		    
		    return (ArrayList)list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public long getBasisCustomerRegister(CustomerRegister customerRegister)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			
			List<CustomerRegister> list = new ArrayList<CustomerRegister>();
			if(customerRegister==null)
			{
				Query query = session.createQuery("select count(*)  from CustomerRegister as customerRegister ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			String hql = "select count(*) from CustomerRegister as customerRegister  where 1=1 ";
			String condition="";
			
			customerUserID_s = customerRegister.getCustomerUserID_s();
			if(customerUserID_s!= null &&!customerUserID_s.trim().equals("")){
				condition = condition + " and customerRegister.customerUserID_s like '%" + customerUserID_s.trim() + "%'";
			}
			orderID_s = customerRegister.getOrderID_s();
			if(orderID_s!= null &&!orderID_s.trim().equals("")){
				condition = condition + " and customerRegister.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			userType_i = customerRegister.getUserType_i();
			if(userType_i != null && userType_i != -1){
				condition = condition + " and customerRegister.userType_i  = '" + userType_i +"'";
			}
			isSafetyTrain_i = customerRegister.getIsSafetyTrain_i();
			if(isSafetyTrain_i != null && isSafetyTrain_i != -1){
				condition = condition + " and customerRegister.isSafetyTrain_i  = '" + isSafetyTrain_i +"'";
			}
			isAirportPickup_i = customerRegister.getIsAirportPickup_i();
			if(isAirportPickup_i != null && isAirportPickup_i != -1){
				condition = condition + " and customerRegister.isAirportPickup_i  = '" + isAirportPickup_i +"'";
			}
			isCheckinHotel_i = customerRegister.getIsCheckinHotel_i();
			if(isCheckinHotel_i != null && isCheckinHotel_i != -1){
				condition = condition + " and customerRegister.isCheckinHotel_i  = '" + isCheckinHotel_i +"'";
			}
			createDate_t = customerRegister.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(customerRegister.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }			
			createUser_s = customerRegister.getCreateUser_s();
			if(createUser_s!= null &&!createUser_s.trim().equals("")){
				condition = condition + " and customerRegister.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = customerRegister.getLastUpdateUser_s();
			if(lastUpdateUser_s!= null &&!lastUpdateUser_s.trim().equals("")){
				condition = condition + " and customerRegister.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = customerRegister.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(customerRegister.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = customerRegister.getResaveds1_s();
			if(resaveds1_s!= null &&!resaveds1_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			}
			resaveds2_s = customerRegister.getResaveds2_s(); 
			if(resaveds2_s!= null &&!resaveds2_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			}
			resaveds3_s = customerRegister.getResaveds3_s();
			if(resaveds3_s!= null &&!resaveds3_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			}
			resaveds4_s = customerRegister.getResaveds4_s();
			if(resaveds4_s!= null &&!resaveds4_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			}
			resaveds5_s = customerRegister.getResaveds5_s();
			if(resaveds5_s!= null &&!resaveds5_s.trim().equals("")){
				condition = condition + " and customerRegister.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			}
			
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
				n = (Long) query.iterate().next();
			}
			return n;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public int OperationCustomerRegister(
			List<CustomerRegister> customerRegister, int operation)
			throws Exception {
		tx = null;
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		tx=session.beginTransaction();//开启事务
		try {
			if(operation ==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				CustomerRegister register = new CustomerRegister();
				if(customerRegister!=null&&customerRegister.size()>0){
					for(int i =0;i<customerRegister.size();i++){
						register = customerRegister.get(i);
						if((register.getOrderID_s() ==null && register.getOrderID_s().trim().equals(""))
								||(register.getCreateUser_s() ==null && register.getCreateUser_s().trim().equals(""))){
							return 0;
						}
						else{
							session.merge(register);
						}
						
						session.flush();
					    session.clear();
						
						
					}
				}
			}
			if(operation ==2){
				if(customerRegister!=null&&customerRegister.size()>0){
					for(int i =0;i<customerRegister.size();i++){
						session.delete(customerRegister.get(i));
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			return 1;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			throw e;
		}
		finally{
			session.clear();
		}
	}
	
	public boolean isCustomerUserhere(String customeruserId) throws Exception{
		boolean returnValue = false;
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n1 = 0;
		long n2 = 0;
		try {
			if(customeruserId != null && !customeruserId.equals("")){
				//查询随行人员表中是否有记录，t-subscribe-customerregister
				String hql1 = "select count(*)  from CustomerRegister as cr where 1=1 ";
				String condition1=" and cr.customerUserID_s= '" + customeruserId + "'";
				Query query1 = session.createQuery(hql1 + condition1);
				if(query1.iterate().hasNext()){
					n1 = (Long)query1.iterate().next();
				}
				
				
				//查询接待人员表中是否有记录， t-reception-customeruser
				String hql2 ="select count(*) from ReceptionCustomerUser as receptionCustomerUser where 1=1 ";
				String condition2= " and receptionCustomerUser.customerUserID_s like '%"+customeruserId+"%'";
				Query query2 = session.createQuery(hql2 + condition2);
				if(query2.iterate().hasNext()){
					n2 = (Long)query2.iterate().next();
				}
				
				if(n1>0 || n2>0)
				{
					returnValue = true;
				}
				else
				{
					returnValue = false;
				}
			}
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		finally
		{
			session.clear();
			return returnValue;	
		}
		
	}

}
