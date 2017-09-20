package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IOrderViewService;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.ViewOrderInfo;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class OrderViewServiceImpl extends ClimsServiceBase implements IOrderViewService{
	String ordername_s;
	String orderid_s;
	int states; 
	Date startDate;
	Date endDate;
	String customerName_s;
	
	//Session session= HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<ViewOrderInfo> getOrderinfo(ViewOrderInfo vorderinfo,
			int start, int size) throws Exception {
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try {
			List<ViewOrderInfo> vorder=new ArrayList<ViewOrderInfo>();
			if(vorderinfo==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from ViewOrderInfo");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
				vorder = query.list();	  			
				return (ArrayList) vorder;
			}
			
			
			orderid_s =vorderinfo.getOrderid_s();
			ordername_s = vorderinfo.getOrdername_s();
			states =vorderinfo.getStatus_i();
			startDate =vorderinfo.getStartdate_d();
			endDate =vorderinfo.getEnddate_d();
			customerName_s=vorderinfo.getCustomerName_s();
			
			String hql="from ViewOrderInfo as vo where 1=1 "; 
			String condition = "";
			if(orderid_s != null && orderid_s.length()>0){
				condition = condition + " and vo.orderid_s ='"+orderid_s+"'";
			}
			if(ordername_s != null && ordername_s.length()>0){
				condition = condition + " and vo.ordername_s like '%"+ordername_s+"%'";
			}
			if(customerName_s != null && customerName_s.length() >0){
				condition = condition +" and vo.customerName_s like '%"+customerName_s+"%'";
			}
			if(states >0 ){
		    	condition = condition + " and vo.status_i="+states+"";
		    }
			if(startDate!=null&&endDate!=null){
		    	String startDate_s = DateUtil.dateToString(startDate,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(vo.startdate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate!=null){
		    	String startDate_s = DateUtil.dateToString(startDate,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(vo.startdate_d,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate!=null){
		    	String endDate_s = DateUtil.dateToString(endDate,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(vo.startdate_d,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
			condition = condition +" order by vo.startdate_d DESC";
			 Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    vorder = query.list();		
		//    list = HibernateUtil.Query(hql+condition);
			return (ArrayList) vorder;
		} catch (Exception e) {
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	   
		
	}

	public long getOrderinfoNum(ViewOrderInfo vorderinfo) throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try {
			List<ViewOrderInfo> vorder=new ArrayList<ViewOrderInfo>();
			if(vorderinfo==null){
				Query query=session.createQuery("select count(*) from ViewOrderInfo");
				long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    } 
			}
			
			
			orderid_s =vorderinfo.getOrderid_s();
			ordername_s = vorderinfo.getOrdername_s();
			states =vorderinfo.getStatus_i();
			startDate =vorderinfo.getStartdate_d();
			endDate =vorderinfo.getEnddate_d();
			customerName_s=vorderinfo.getCustomerName_s();
			
			String hql="select count(*) from ViewOrderInfo as vo where 1=1 "; 
			String condition = "";
			if(orderid_s != null && orderid_s.length()>0){
				condition = condition + " and vo.orderid_s ='"+orderid_s+"'";
			}
			if(ordername_s != null && ordername_s.length()>0){
				condition = condition + " and vo.ordername_s like '%"+ordername_s+"%'";
			}
			if(customerName_s != null && customerName_s.length() >0){
				condition = condition +" and vo.customerName_s like '%"+customerName_s+"%'";
			}
			if(states > 0){
		    	condition = condition + " and vo.status_i='"+states+"'";
		    }
			if(startDate!=null&&endDate!=null){
		    	String startDate_s = DateUtil.dateToString(startDate,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(vo.startdate_d,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate!=null){
		    	String startDate_s = DateUtil.dateToString(startDate,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(vo.startdate_d,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate!=null){
		    	String endDate_s = DateUtil.dateToString(endDate,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(vo.startdate_d,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
			
			Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }  		   
			return n;
		} catch (Exception e) {
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	
	}

}
