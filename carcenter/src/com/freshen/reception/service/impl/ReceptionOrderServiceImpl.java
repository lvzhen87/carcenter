package com.freshen.reception.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.TSubscribeOrdervehicleinfo;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.reception.ReceptionOrder;

import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.IreceptionVehicleInfoService;

import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.opensymphony.xwork2.ActionContext;

public class ReceptionOrderServiceImpl extends ClimsServiceBase implements IreceptionOrderService{

	String orderName_s;
	String  orderID_s;
	Date    reservationDate_t;
	Integer status_i;
	String  status_s;	
	String  customerID_s;
	Date    startDate_d,
			endDate_d;
	String  customerUserID_s,
			capgUserID_s,
			/*invoiceOrder_s,
			addedValueTax_s,*/
			invoiceUser_s;
	Date    actualDate_d,
			createDate_t = new Date();
	String  createUser_s,
			lastUpdateUser_s;
	Date    lastUpdateDate_t= new Date();
	String  resaveds1_s,
			resaveds2_s,
			resaveds3_s,
			resaveds4_s,
			resaveds5_s,
			invoiceOrder_s,
			addedValueTax_s;
	Customer customer;
	
	String  greaterStatus_s;//大于状态
	String  lessStatus_s;//小于状态
	Session session= HibernateUtil.getSession();
	public ArrayList<ReceptionOrder> getReceptionOrder(
			ReceptionOrder receptionOrder,int start,
			int size) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{			
			return getReceptionOrderByTx(receptionOrder,start,size,session);	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
			session.close();
		}	 
	}

	/**
	 * 按事务查询
	 * @param receptionOrder
	 * @param start
	 * @param size
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ReceptionOrder> getReceptionOrderByTx(
			ReceptionOrder receptionOrder,int start,
			int size,Session session) throws Exception{
		// TODO Auto-generated method stub
		 
		try{
			List<ReceptionOrder> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(receptionOrder==null){
				Query query=session.createQuery("from ReceptionOrder");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			orderName_s = receptionOrder.getOrderName_s();
			customerUserID_s = receptionOrder.getCustomerUserID_s();
			status_i = receptionOrder.getStatus_i();
			status_s = receptionOrder.getStatus_s();
			orderID_s = receptionOrder.getOrderID_s();
			reservationDate_t = receptionOrder.getReservationDate_t();
			customerID_s = receptionOrder.getCustomer().getCustomerID_s();
			startDate_d = receptionOrder.getStartDate_d();
			endDate_d = receptionOrder.getEndDate_d();
			capgUserID_s = receptionOrder.getCapgUserID_s();
			 
			invoiceUser_s = receptionOrder.getInvoiceUser_s();
			actualDate_d = receptionOrder.getActualDate_d();
			createDate_t = receptionOrder.getCreateDate_t();
			createUser_s = receptionOrder.getCreateUser_s();
			lastUpdateUser_s = receptionOrder.getLastUpdateUser_s();
			lastUpdateDate_t = receptionOrder.getLastUpdateDate_t();
			resaveds1_s = receptionOrder.getResaveds1_s();
			resaveds2_s = receptionOrder.getResaveds2_s();
			resaveds3_s = receptionOrder.getResaveds3_s();
			resaveds4_s = receptionOrder.getResaveds4_s();
			resaveds5_s = receptionOrder.getResaveds5_s();
			greaterStatus_s = receptionOrder.getGreaterStatus_s();
			lessStatus_s = receptionOrder.getLessStatus_s();
			customer=receptionOrder.getCustomer();
			invoiceOrder_s = receptionOrder.getInvoiceOrder_s();
			addedValueTax_s = receptionOrder.getAddedValueTax_s();
			String hql="from ReceptionOrder as receptionOrder where 1=1 "; 
			    String condition = "";
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition += " and receptionOrder.orderID_s like '%"+orderID_s+"%'";
		    }
		    
		   
		    if(status_i!=null){
		    	condition += " and receptionOrder.status_i="+status_i+"";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (receptionOrder.status_i="+statusarr[i]+"";
		    		}else{
		    			condition = condition+" or receptionOrder.status_i="+statusarr[i]+"";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(greaterStatus_s!=null&&greaterStatus_s.trim().equals(greaterStatus_s)){
		    	condition +=" and receptionOrder.status_i>"+greaterStatus_s;
		    }
		    if(lessStatus_s!=null&&lessStatus_s.trim().equals(lessStatus_s)){
		    	condition +=" and receptionOrder.status_i<"+lessStatus_s;
		    }
		    if(orderName_s!=null  && orderName_s.length()>0){
		    	condition = condition+" and receptionOrder.orderName_s like '%"+orderName_s+"%'";
		    }
		    if(customerUserID_s!=null){
		    	condition = condition+" and receptionOrder.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(reservationDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.reservationDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(reservationDate_t, "yyyy-MM-dd")+"'";
		    }
		    if(customerID_s!=null){
		    	condition = condition+" and receptionOrder.customer.customerID_s like '%"+customerID_s+"%'";
		    }
		    if(customer.getCustomerName_s()!=null && customer.getCustomerName_s().length() >0){
		    	condition = condition+" and receptionOrder.customer.customerName_s like '%"+customer.getCustomerName_s()+"%'";
		    }
		   
		    if(startDate_d!=null&&endDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate_d!=null){
		    	String endDate_s = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(capgUserID_s!=null){
		    	condition = condition+" and receptionOrder.capgUserID_s like '%"+capgUserID_s+"%'";
		    }
		     
		    if(invoiceUser_s!=null){
		    	condition = condition+" and receptionOrder.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(actualDate_d!=null){
		    	condition = condition+" and to_char(receptionOrder.actualDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(actualDate_d, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and receptionOrder.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and receptionOrder.lastUpdateUser_s like '"+lastUpdateUser_s+"'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and receptionOrder.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and receptionOrder.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and receptionOrder.resaveds3_s like '%"+resaveds3_s+"%'";
		    }	    
		    if(resaveds4_s!=null){
		    	condition = condition+" and receptionOrder.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and receptionOrder.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    condition = condition +" order by receptionOrder.reservationDate_t desc";
		    
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();		
		//    list = HibernateUtil.Query(hql+condition);
			return (ArrayList) list;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			 
		}	 
	}

	
	public long getReceptionOrderNumber(ReceptionOrder receptionOrder) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionOrder> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(receptionOrder==null){
				Query query=session.createQuery("from ReceptionOrder");
				long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    } 
			}
			customerUserID_s = receptionOrder.getCustomerUserID_s();
			status_i = receptionOrder.getStatus_i();
			status_s = receptionOrder.getStatus_s();
			orderID_s = receptionOrder.getOrderID_s();
			reservationDate_t = receptionOrder.getReservationDate_t();
			customerID_s = receptionOrder.getCustomer().getCustomerID_s();
			startDate_d = receptionOrder.getStartDate_d();
			endDate_d = receptionOrder.getEndDate_d();
			capgUserID_s = receptionOrder.getCapgUserID_s();
		
			invoiceUser_s = receptionOrder.getInvoiceUser_s();
			actualDate_d = receptionOrder.getActualDate_d();
			createDate_t = receptionOrder.getCreateDate_t();
			createUser_s = receptionOrder.getCreateUser_s();
			lastUpdateUser_s = receptionOrder.getLastUpdateUser_s();
			lastUpdateDate_t = receptionOrder.getLastUpdateDate_t();
			resaveds1_s = receptionOrder.getResaveds1_s();
			resaveds2_s = receptionOrder.getResaveds2_s();
			resaveds3_s = receptionOrder.getResaveds3_s();
			resaveds4_s = receptionOrder.getResaveds4_s();
			resaveds5_s = receptionOrder.getResaveds5_s();
			orderName_s = receptionOrder.getOrderName_s();
			customer = receptionOrder.getCustomer();
			greaterStatus_s = receptionOrder.getGreaterStatus_s();
			lessStatus_s = receptionOrder.getLessStatus_s();
		    String hql="select count(*) from ReceptionOrder as receptionOrder where 1=1 "; 
		    String condition = "";
		    if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition += " and receptionOrder.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(status_i!=null){
		    	condition = " and receptionOrder.status_i="+status_i+"";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (receptionOrder.status_i="+statusarr[i]+"";
		    		}else{
		    			condition = condition+" or receptionOrder.status_i="+statusarr[i]+"";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(greaterStatus_s!=null&&greaterStatus_s.trim().equals(greaterStatus_s)){
		    	condition +=" and receptionOrder.status_i>"+greaterStatus_s;
		    }
		    if(lessStatus_s!=null&&lessStatus_s.trim().equals(lessStatus_s)){
		    	condition +=" and receptionOrder.status_i<"+lessStatus_s;
		    }
		    if(orderName_s!=null && orderName_s.length()>0){
		    	condition = condition+" and receptionOrder.orderName_s like '%"+orderName_s+"%'";
		    }
		    if(customerUserID_s!=null){
		    	condition = condition+" and receptionOrder.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(reservationDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.reservationDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(reservationDate_t, "yyyy-MM-dd")+"'";
		    }
		    if(customerID_s!=null){
		    	condition = condition+" and receptionOrder.customer.customerID_s like '%"+customerID_s+"%'";
		    }
		    if(customer.getCustomerName_s()!=null && customer.getCustomerName_s().length() >0){
		    	condition = condition+" and receptionOrder.customer.customerName_s like '%"+customer.getCustomerName_s()+"%'";
		    }
		   
		    
		    if(startDate_d!=null&&endDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate_d!=null){
		    	String endDate_s = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(capgUserID_s!=null){
		    	condition = condition+" and receptionOrder.capgUserID_s like '%"+capgUserID_s+"%'";
		    }
		    
		    if(invoiceUser_s!=null){
		    	condition = condition+" and receptionOrder.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(actualDate_d!=null){
		    	condition = condition+" and to_char(receptionOrder.actualDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(actualDate_d, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and receptionOrder.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and receptionOrder.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and receptionOrder.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and receptionOrder.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and receptionOrder.resaveds3_s like '%"+resaveds3_s+"%'";
		    }	    
		    if(resaveds4_s!=null){
		    	condition = condition+" and receptionOrder.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and receptionOrder.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }  		   
		//    list = HibernateUtil.Query(hql+condition);
			return n;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
			session.close();
		}	
	}
	
	public int OperationReceptionOrderWithoutTx(ReceptionOrder receptionOrder,Integer operation) throws Exception{
		// TODO Auto-generated method stub
		try{
			if(operation==1){
				if(receptionOrder != null){
					ReceptionOrder temp=(ReceptionOrder) sessionImpl.get(ReceptionOrder.class,receptionOrder.getOrderID_s());
					orderName_s = receptionOrder.getOrderName_s();
					customerUserID_s = receptionOrder.getCustomerUserID_s();
					status_i = receptionOrder.getStatus_i();
					status_s = receptionOrder.getStatus_s();
					orderID_s = receptionOrder.getOrderID_s();
					reservationDate_t = receptionOrder.getReservationDate_t();
					customerID_s = receptionOrder.getCustomer().getCustomerID_s();
					startDate_d = receptionOrder.getStartDate_d();
					endDate_d = receptionOrder.getEndDate_d();
					capgUserID_s = receptionOrder.getCapgUserID_s();
					 
					invoiceUser_s = receptionOrder.getInvoiceUser_s();
					actualDate_d = receptionOrder.getActualDate_d();
					createDate_t = receptionOrder.getCreateDate_t();
					createUser_s = receptionOrder.getCreateUser_s();
					lastUpdateUser_s = receptionOrder.getLastUpdateUser_s();
					lastUpdateDate_t = receptionOrder.getLastUpdateDate_t();
					resaveds1_s = receptionOrder.getResaveds1_s();
					resaveds2_s = receptionOrder.getResaveds2_s();
					resaveds3_s = receptionOrder.getResaveds3_s();
					resaveds4_s = receptionOrder.getResaveds4_s();
					resaveds5_s = receptionOrder.getResaveds5_s();
					invoiceOrder_s = receptionOrder.getInvoiceOrder_s();
					addedValueTax_s = receptionOrder.getAddedValueTax_s();
					
					if(invoiceOrder_s!=null && !invoiceOrder_s.trim().equals("")){
						temp.setInvoiceOrder_s(invoiceOrder_s);
				    }
					if(addedValueTax_s!=null && !addedValueTax_s.trim().equals("")){
						temp.setAddedValueTax_s(addedValueTax_s);
				    }
					if(orderID_s!=null && !orderID_s.trim().equals("")){
						temp.setOrderID_s(orderID_s);
				    }
				   
				    if(status_i!=null){
				    	temp.setStatus_i(status_i);
				    }
				    
				    if(orderName_s!=null && orderName_s.length() >0){
				    	temp.setOrderName_s(orderName_s);
				    }
				    if(customerUserID_s!=null && customerUserID_s.length() >0){
				    	temp.setCustomerUserID_s(customerUserID_s);
				    }
				    if(reservationDate_t!=null){
				    	temp.setReservationDate_t(reservationDate_t);
				    }
				    
				    if(customerID_s!=null && customerID_s.length()>0){				    
						customer=(Customer)sessionImpl.get(Customer.class, customerID_s);
						temp.setCustomer(customer);
				    	temp.getCustomer().setCustomerID_s(customerID_s);
				    }
				   
				    if(startDate_d!=null){
				    	temp.setStartDate_d(startDate_d);
				    }
				    if(endDate_d!=null){
					   temp.setEndDate_d(endDate_d);
				    }
				    
				    if(invoiceUser_s!=null){
				    	temp.setInvoiceUser_s(invoiceUser_s);
				    }
				    if(actualDate_d!=null){
				    	temp.setActualDate_d(actualDate_d);
				    }
				    if(createDate_t!=null){
				    	temp.setCreateDate_t(createDate_t);
				    }
				    if(createUser_s!=null){
				    	temp.setCreateUser_s(createUser_s);
				    }
				    if(lastUpdateUser_s!=null){
				    	temp.setLastUpdateUser_s(lastUpdateUser_s);
				    }
				    if(lastUpdateDate_t!=null){
				    	temp.setLastUpdateDate_t(lastUpdateDate_t);
				    }
				    if(resaveds1_s!=null){
				    	temp.setResaveds1_s(resaveds1_s);
				    }
				    if(resaveds2_s!=null){
				    	temp.setResaveds2_s(resaveds2_s);
				    }
				    if(resaveds3_s!=null){
				    	temp.setResaveds3_s(resaveds3_s);
				    }	    
				    if(resaveds4_s!=null){
				    	temp.setResaveds4_s(resaveds4_s);
				    }
				    if(resaveds5_s!=null){
				    	temp.setResaveds5_s(resaveds5_s);
				    }
				    sessionImpl.saveOrUpdate(temp);
					sessionImpl.flush();
				    sessionImpl.clear();
				}
			}
			//删除
			if(operation==2){
				sessionImpl.delete(receptionOrder);
				sessionImpl.flush();
				sessionImpl.clear();
			}
			
			
			return 1;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			//session.clear();
		    
		}	 
	}
	public ArrayList<ReceptionOrder> getReceptionOrderbyDate(
			ReceptionOrder receptionOrder,int start,
			int size) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionOrder> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(receptionOrder==null){
				Query query=session.createQuery("from ReceptionOrder");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	
			    TSubscribeOrdervehicleinfo ts = new TSubscribeOrdervehicleinfo();
			    for(int j = 0 ;j<list.size();j++){
			    	if(list.get(j).getOrderID_s()!=null && !list.get(j).getOrderID_s().trim().equals("")){
			    		ts = (TSubscribeOrdervehicleinfo)session.get(ts.getClass(), list.get(j).getOrderID_s()) ;
				    	list.get(j).setTestVehicleNumber_i(ts.getTestvehiclenumberI());
			    	}
			    }
				return (ArrayList) list;
			}
			customerUserID_s = receptionOrder.getCustomerUserID_s();
			status_i = receptionOrder.getStatus_i();
			status_s = receptionOrder.getStatus_s();
			orderID_s = receptionOrder.getOrderID_s();
			reservationDate_t = receptionOrder.getReservationDate_t();
			customerID_s = receptionOrder.getCustomer().getCustomerID_s();
			startDate_d = receptionOrder.getStartDate_d();
			endDate_d = receptionOrder.getEndDate_d();
			capgUserID_s = receptionOrder.getCapgUserID_s();
			 
			invoiceUser_s = receptionOrder.getInvoiceUser_s();
			actualDate_d = receptionOrder.getActualDate_d();
			createDate_t = receptionOrder.getCreateDate_t();
			createUser_s = receptionOrder.getCreateUser_s();
			lastUpdateUser_s = receptionOrder.getLastUpdateUser_s();
			lastUpdateDate_t = receptionOrder.getLastUpdateDate_t();
			resaveds1_s = receptionOrder.getResaveds1_s();
			resaveds2_s = receptionOrder.getResaveds2_s();
			resaveds3_s = receptionOrder.getResaveds3_s();
			resaveds4_s = receptionOrder.getResaveds4_s();
			resaveds5_s = receptionOrder.getResaveds5_s();
			orderName_s = receptionOrder.getOrderName_s();
			 
		    
		    String hql="from ReceptionOrder as receptionOrder where 1=1 "; 
		    String condition = "";
		    if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition += " and receptionOrder.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(status_i!=null){
		    	condition = " and receptionOrder.status_i='"+status_i+"'";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (receptionOrder.status_i='"+statusarr[i]+"'";
		    		}else{
		    			condition = condition+" or receptionOrder.status_i='"+statusarr[i]+"'";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(orderName_s!=null){
		    	condition = condition+" and receptionOrder.orderName_s like '%"+orderName_s+"%'";
		    }
		    if(customerUserID_s!=null){
		    	condition = condition+" and receptionOrder.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(reservationDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.reservationDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(reservationDate_t, "yyyy-MM-dd")+"'";
		    }
		    if(customerID_s!=null){
		    	condition = condition+" and receptionOrder.customer.customerID_s like '%"+customerID_s+"%'";
		    }
		   
		    if(startDate_d!=null&&endDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	condition = condition+" and to_char(receptionOrder.startDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_d, "yyyy-MM-dd") +"'";
		    }
		    else if(endDate_d!=null){
		    	String endDate_s = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(capgUserID_s!=null){
		    	condition = condition+" and receptionOrder.capgUserID_s like '%"+capgUserID_s+"%'";
		    }
		     
		    if(invoiceUser_s!=null){
		    	condition = condition+" and receptionOrder.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(actualDate_d!=null){
		    	condition = condition+" and to_char(receptionOrder.actualDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(actualDate_d, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and receptionOrder.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and receptionOrder.lastUpdateUser_s like '"+lastUpdateUser_s+"'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and receptionOrder.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and receptionOrder.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and receptionOrder.resaveds3_s like '%"+resaveds3_s+"%'";
		    }	    
		    if(resaveds4_s!=null){
		    	condition = condition+" and receptionOrder.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and receptionOrder.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    condition = condition +" order by receptionOrder.reservationDate_t desc";
		    
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();
		    TSubscribeOrdervehicleinfo ts = new TSubscribeOrdervehicleinfo();
		    for(int k = 0 ;k<list.size();k++){
		    	if(list.get(k).getOrderID_s() != null && !list.get(k).getOrderID_s().trim().equals(""))
		    	{
			    	ts = (TSubscribeOrdervehicleinfo)session.get(ts.getClass(), list.get(k).getOrderID_s()) ;
			    	if(ts !=null){
				    	list.get(k).setTestVehicleNumber_i(ts.getTestvehiclenumberI());
			    	}else{
			    		ts = new TSubscribeOrdervehicleinfo();
			    	}
		    	}
		    }
		//    list = HibernateUtil.Query(hql+condition);
			return (ArrayList) list;	
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	 
	}
	public long getReceptionOrderbyDateNumber(ReceptionOrder receptionOrder) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionOrder> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(receptionOrder==null){
				Query query=session.createQuery("from ReceptionOrder");
				long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    } 
			}
			customerUserID_s = receptionOrder.getCustomerUserID_s();
			status_i = receptionOrder.getStatus_i();
			status_s = receptionOrder.getStatus_s();
			orderID_s = receptionOrder.getOrderID_s();
			reservationDate_t = receptionOrder.getReservationDate_t();
			customerID_s = receptionOrder.getCustomer().getCustomerID_s();
			startDate_d = receptionOrder.getStartDate_d();
			endDate_d = receptionOrder.getEndDate_d();
			capgUserID_s = receptionOrder.getCapgUserID_s();
		
			invoiceUser_s = receptionOrder.getInvoiceUser_s();
			actualDate_d = receptionOrder.getActualDate_d();
			createDate_t = receptionOrder.getCreateDate_t();
			createUser_s = receptionOrder.getCreateUser_s();
			lastUpdateUser_s = receptionOrder.getLastUpdateUser_s();
			lastUpdateDate_t = receptionOrder.getLastUpdateDate_t();
			resaveds1_s = receptionOrder.getResaveds1_s();
			resaveds2_s = receptionOrder.getResaveds2_s();
			resaveds3_s = receptionOrder.getResaveds3_s();
			resaveds4_s = receptionOrder.getResaveds4_s();
			resaveds5_s = receptionOrder.getResaveds5_s();
			orderName_s = receptionOrder.getOrderName_s();
			 
		    
		    String hql="select count(*) from ReceptionOrder as receptionOrder where 1=1 "; 
		    String condition = "";
		    if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition += " and receptionOrder.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(status_i!=null){
		    	condition = " and receptionOrder.status_i='"+status_i+"'";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (receptionOrder.status_i='"+statusarr[i]+"'";
		    		}else{
		    			condition = condition+" or receptionOrder.status_i='"+statusarr[i]+"'";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(orderName_s!=null){
		    	condition = condition+" and receptionOrder.orderName_s like '%"+orderName_s+"%'";
		    }
		    if(customerUserID_s!=null){
		    	condition = condition+" and receptionOrder.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(reservationDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.reservationDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(reservationDate_t, "yyyy-MM-dd")+"'";
		    }
		    if(customerID_s!=null){
		    	condition = condition+" and receptionOrder.customerID_s like '%"+customerID_s+"%'";
		    }
		   
		    if(startDate_d!=null&&endDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_d!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate_d!=null){
		    	String endDate_s = DateUtil.dateToString(endDate_d,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(receptionOrder.startDate_d,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(capgUserID_s!=null){
		    	condition = condition+" and receptionOrder.capgUserID_s like '%"+capgUserID_s+"%'";
		    }
		    
		    if(invoiceUser_s!=null){
		    	condition = condition+" and receptionOrder.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(actualDate_d!=null){
		    	condition = condition+" and to_char(receptionOrder.actualDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(actualDate_d, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and receptionOrder.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and receptionOrder.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(receptionOrder.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and receptionOrder.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and receptionOrder.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and receptionOrder.resaveds3_s like '%"+resaveds3_s+"%'";
		    }	    
		    if(resaveds4_s!=null){
		    	condition = condition+" and receptionOrder.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and receptionOrder.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }  		   
		//    list = HibernateUtil.Query(hql+condition);
			return n;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	
	}
	

	public int OperationReceptionOrder(ReceptionOrder receptionOrder,
			int operation, Session session) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(receptionOrder!= null){
				if(operation==1){
					session.saveOrUpdate(receptionOrder);
					session.flush();
				    session.clear();
				}
				//删除
				if(operation==2){
					session.delete(receptionOrder);
					session.flush();
					session.clear();
					
				}
			}
		}
		catch(Exception e){
			
		}
		finally{
			
		}
		return 0;
	}

	
	public int setReceptionOrderAndOrderDetailState(String orderId_s, int state_i,Session session)
	throws Exception {
// TODO Auto-generated method stu
ReceptionOrder receptionOrder = new ReceptionOrder();
List<ReceptionOrder> list = new ArrayList();
OrderDetail orderDetail = new OrderDetail();
List<OrderDetail> listDetail = new ArrayList();
 
Employee employee=(Employee) ActionContext.getContext().getSession().get("loginEmployee");
try{
	if(orderId_s != null && !orderId_s.trim().equals(""))
	{
		Query query = session.createQuery(" from ReceptionOrder as receptionOrder where receptionOrder.orderID_s ='" + orderId_s + "'");
		if(query.iterate().hasNext())
		{
			Query queryDetail = session.createQuery(" from OrderDetail as orderDetail where orderDetail.orderID_s ='" + orderId_s + "'");
			if(queryDetail.iterate().hasNext())
			{
				receptionOrder = (ReceptionOrder)query.list().get(0);
				receptionOrder.setStatus_i(state_i);
				receptionOrder.setActualDate_d(DateUtil.getCurrentDate());
				receptionOrder.setCreateUser_s(employee.getCustomerUserName_s());
				receptionOrder.setCreateDate_t(DateUtil.getCurrentDate());
				orderDetail = (OrderDetail)queryDetail.list().get(0);
				orderDetail.setStatus_i(state_i);
				session.saveOrUpdate(receptionOrder);
				session.saveOrUpdate(orderDetail);
				return 1;
			}
		}
	}
}
catch(Exception e){
	throw e;
}
finally{
	
}
return 0;
}

	/**
	 * 确认订单进行接待	   
	 * affirmReception 
	 * @param   orderID_s 订单id    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void affirmReception(String orderID_s) throws Exception{
		Transaction tx = null;
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		tx = session.beginTransaction();
		
		try{
			//1、修改订单状态为5：已进场
			setReceptionOrderAndOrderDetailState(orderID_s,ConstantUtil.orderStatus_5,session);
			//2、将车辆信息从预约模块复制到接待模块
			IreceptionVehicleInfoService ireceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
			ireceptionVehicleInfoService.addReceptionVehicleInfo(orderID_s,session);
			//3、将人员信息从预约模块复制到接待模块
			IreceptionCustomerUserService ireceptionCustomerUserService = new ReceptionCustomerUserServiceImpl();
			ireceptionCustomerUserService.addReceptionCustomerUser(orderID_s, session);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw e;
		}
		finally{
			session.clear();
			session.close();
		}
	} 
	
	public static void main(String arg[]){
		try{
		Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		String sql = "SELECT * FROM pb_Icanteen where sysno='000133' order by Recordid desc";		
		PreparedStatement ps = sqlcon.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		Connection sqlcon1 = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		String sql1 = "SELECT * FROM pb_Icanteen where sysno='000133' order by Recordid desc";
		PreparedStatement ps1 = sqlcon1.prepareStatement(sql1);
		ResultSet rs1 = ps1.executeQuery();
		String Balance1 ="";
		String Balance2 ="";
		Double d = Double.valueOf(0);
		
			Connection sqlcon3 = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
			Statement ps3 = sqlcon3.createStatement();
			rs.next();
			while (rs1.next()) {
				Balance1 = rs1.getString("Balance");				 
				if(rs.next()){
					Balance2 = rs.getString("Balance");
					d = Double.valueOf(Balance1)-Double.valueOf(Balance2);
					String s = "update pb_Icanteen set dealmoney='"+d+"' where sysno='000133' and Recordid = '"+rs1.getString("Recordid")+"'";
					ps3.executeUpdate(s);
				}
			}
			
		}catch(Exception e){
		 e.printStackTrace();
			 
		}
		finally{
		 
		}
		
		 
	}
}
