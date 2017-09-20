package com.freshen.preorder.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.OrderWorkShop;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OrderWorkShopServiceImpl extends ClimsServiceBase implements IorderWorkShopService {

	String orderWorkShopID_s;
	String orderID_s;
	Integer status_i;
	Date startDate_t;
	Date endDate_t;
	String workShopID_s;
	String workShopName_s;
	String useInfo_s;
	String remark_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	String lastUpdateDate_t;
	String resaveds1;
	String resaveds2;
	String resaveds3;
	String resaveds4;
	String resaveds5;
	
	String startDateStr,endDateStr;
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public int OperationorderWorkShop(List<OrderWorkShop> orderWorkShop,
			int operation, Session session) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(orderWorkShop!=null && orderWorkShop.size()>0){
				
				for(int i=0;i<orderWorkShop.size();i++){
					OrderWorkShop ord = orderWorkShop.get(i);
					if(operation==1){
						session.saveOrUpdate(ord);
						session.flush();
					    session.clear();
					}
					//删除
					if(operation==2){
						session.delete(ord);
						session.flush();
						session.clear();
					}
					return 1;
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
	
	
	public int OperationorderWorkShop(List<OrderWorkShop> orderWorkShop,int operation) throws Exception {
		// TODO Auto-generated method stub
		try{
			tx=session.beginTransaction();
			if(orderWorkShop!=null && orderWorkShop.size()>0){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				for(int i=0;i<orderWorkShop.size();i++){
					OrderWorkShop ord = orderWorkShop.get(i);
					if(operation==1){
						if(ord.getOrderWorkShopID_s() == null || ord.getOrderWorkShopID_s().equals("")){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.GCBusiness, session);
							ord.setOrderWorkShopID_s(cpg);
						}
						session.saveOrUpdate(ord);
						//session.flush();
						tx.commit();
					    session.clear();
					}
					//删除
					if(operation==2){
						session.delete(ord);
						//session.flush();
						tx.commit();
						session.clear();
					}
					return 1;
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

	public ArrayList<OrderWorkShop> getBasisWorkShop(
			OrderWorkShop orderWorkShop, int start, int size) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		
		try {
			List<OrderWorkShop> list = new ArrayList<OrderWorkShop>();
			if(orderWorkShop == null){
				Query query = session.createQuery("from OrderWorkShop as orderWorkShop ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				
				return (ArrayList)list;
			}
			
			String hql = " from OrderWorkShop as orderWorkShop where 1=1 ";
			String condition="";
			
			orderWorkShopID_s = orderWorkShop.getOrderWorkShopID_s() ;
			if(orderWorkShopID_s!=null && !orderWorkShopID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.orderWorkShopID_s like '%" + orderWorkShopID_s.trim() + "%'";
			}
			orderID_s = orderWorkShop.getOrderID_s();
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			status_i = orderWorkShop.getStatus_i();
			if(status_i!=null ){
				condition = condition + " and orderWorkShop.status_i = '" + status_i + "'";
			}
			startDate_t = orderWorkShop.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderWorkShop.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			workShopID_s = orderWorkShop.getWorkShopID_s();
			if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.workShopID_s like '%" + workShopID_s.trim() + "%'";
			}
			workShopName_s = orderWorkShop.getWorkShopName_s();
			if(workShopName_s!=null && !workShopName_s.trim().equals("")){
				condition = condition + " and orderWorkShop.workShopName_s like '%" + workShopName_s.trim() + "%'";
			}
			useInfo_s = orderWorkShop.getUseInfo_s();
			if(useInfo_s!=null && !useInfo_s.trim().equals("")){
				condition = condition + " and orderWorkShop.useInfo_s like '%" + useInfo_s.trim() + "%'";
			}
			remark_s = orderWorkShop.getRemark();
			if(remark_s!=null && !remark_s.trim().equals("")){
				condition = condition + " and orderWorkShop.remark_s like '%" + remark_s.trim() + "%'";
			}
			createDate_t = orderWorkShop.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			createUser_s = orderWorkShop.getCreateUser_s();
			if(createUser_s!=null && !createUser_s.trim().equals("")){
				condition = condition + " and orderWorkShop.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderWorkShop.getLastUpdateUser_s();
			if(lastUpdateUser_s!=null && !lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderWorkShop.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderWorkShop.getLastUpdateDate_t();
//			if(lastUpdateDate_t != null){
//		    	condition = condition+" and to_char(orderWorkShop.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
//		    }
			resaveds1 = orderWorkShop.getResaveds1();
			if(resaveds1!=null && !resaveds1.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds1 like '%" + resaveds1.trim() + "%'";
			}
			resaveds2 = orderWorkShop.getResaveds2();
			if(resaveds2!=null && !resaveds2.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds2 like '%" + resaveds2.trim() + "%'";
			}
			resaveds3 = orderWorkShop.getResaveds3();
			if(resaveds3!=null && !resaveds3.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds3 like '%" + resaveds3.trim() + "%'";
			}
			resaveds4 = orderWorkShop.getResaveds4();
			if(resaveds4!=null && !resaveds4.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds4 like '%" + resaveds4.trim() + "%'";
			}
			resaveds5 = orderWorkShop.getResaveds5();
			if(resaveds5!=null && !resaveds5.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds5 like '%" + resaveds5.trim() + "%'";
			}
//			startDateStr = orderWorkShop.getStartDateStr();
//			
//			endDateStr = orderWorkShop.getEndDateStr();
			
			 Query query = session.createQuery(hql+condition);
			    if(start !=  ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
			    list= query.list();
			    
			    return (ArrayList)list;
		} catch (Exception e) {
			//System.out.println(e.toString());
			// TODO: handle exception
		}
		finally{
			
		}
		
		return null;
	}

	public long getBasisWorkShop(OrderWorkShop orderWorkShop) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long  n = 0;
		try {
			List<OrderWorkShop> list = new ArrayList<OrderWorkShop>();
			if(orderWorkShop == null){
				Query query = session.createQuery("select count(*) from OrderWorkShop as orderWorkShop  ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			
			String hql = " select count(*) from OrderWorkShop as orderWorkShop where 1=1 ";
			String condition="";
			
			orderWorkShopID_s = orderWorkShop.getOrderWorkShopID_s() ;
			if(orderWorkShopID_s!=null && !orderWorkShopID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.orderWorkShopID_s like '%" + orderWorkShopID_s.trim() + "%'";
			}
			orderID_s = orderWorkShop.getOrderID_s();
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			status_i = orderWorkShop.getStatus_i();
			if(status_i!=null ){
				condition = condition + " and orderWorkShop.status_i = '" + status_i + "'";
			}
			startDate_t = orderWorkShop.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderWorkShop.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			workShopID_s = orderWorkShop.getWorkShopID_s();
			if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.workShopID_s like '%" + workShopID_s.trim() + "%'";
			}
			workShopName_s = orderWorkShop.getWorkShopName_s();
			if(workShopName_s!=null && !workShopName_s.trim().equals("")){
				condition = condition + " and orderWorkShop.workShopName_s like '%" + workShopName_s.trim() + "%'";
			}
			useInfo_s = orderWorkShop.getUseInfo_s();
			if(useInfo_s!=null && !useInfo_s.trim().equals("")){
				condition = condition + " and orderWorkShop.useInfo_s like '%" + useInfo_s.trim() + "%'";
			}
			remark_s = orderWorkShop.getRemark();
			if(remark_s!=null && !remark_s.trim().equals("")){
				condition = condition + " and orderWorkShop.remark_s like '%" + remark_s.trim() + "%'";
			}
			createDate_t = orderWorkShop.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			createUser_s = orderWorkShop.getCreateUser_s();
			if(createUser_s!=null && !createUser_s.trim().equals("")){
				condition = condition + " and orderWorkShop.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderWorkShop.getLastUpdateUser_s();
			if(lastUpdateUser_s!=null && !lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderWorkShop.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderWorkShop.getLastUpdateDate_t();
//			if(lastUpdateDate_t != null){
//		    	condition = condition+" and to_char(orderWorkShop.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
//		    }
			resaveds1 = orderWorkShop.getResaveds1();
			if(resaveds1!=null && !resaveds1.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds1 like '%" + resaveds1.trim() + "%'";
			}
			resaveds2 = orderWorkShop.getResaveds2();
			if(resaveds2!=null && !resaveds2.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds2 like '%" + resaveds2.trim() + "%'";
			}
			resaveds3 = orderWorkShop.getResaveds3();
			if(resaveds3!=null && !resaveds3.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds3 like '%" + resaveds3.trim() + "%'";
			}
			resaveds4 = orderWorkShop.getResaveds4();
			if(resaveds4!=null && !resaveds4.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds4 like '%" + resaveds4.trim() + "%'";
			}
			resaveds5 = orderWorkShop.getResaveds5();
			if(resaveds5!=null && !resaveds5.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds5 like '%" + resaveds5.trim() + "%'";
			}
//			startDateStr = orderWorkShop.getStartDateStr();
//			
//			endDateStr = orderWorkShop.getEndDateStr();
			
			Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
			}
			return n;
		} catch (Exception e) {
			//System.out.println(e.toString());
			// TODO: handle exception
		}
		finally{
			
		}
		
		return 0;
	}
	
	/**
	 * 估计订单下车间使用费用	   
	 * reckonCostOrderWorkShop 
	 * @param   orderID_s 订单编号    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int reckonCostOrderWorkShop(String orderID_s,Session session)throws Exception{
		try{
			Connection con  = HibernateUtil.getconnBysession(session);
			String procedure = "{call OrderCostCompute.workShopCostCompute(?)}"; 
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID_s);
			q.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return 1;
	}
	

	/**
	 * 按照对象开始时间和结束时间查询是否有在该时间段内预订的车间	   
	 * getBasisWorkShopByDate 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrderWorkShop> getBasisWorkShopByDate(
			OrderWorkShop orderWorkShop, int start, int size) throws Exception {
		// TODO Auto-generated method stub
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		
		try {
			List<OrderWorkShop> list = new ArrayList<OrderWorkShop>();
			if(orderWorkShop == null){
				Query query = session.createQuery("from OrderWorkShop as orderWorkShop ");
				if(start == -1)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				
				return (ArrayList)list;
			}
			
			String hql = " from OrderWorkShop as orderWorkShop where 1=1 ";
			String condition="";
			
			orderWorkShopID_s = orderWorkShop.getOrderWorkShopID_s() ;
			if(orderWorkShopID_s!=null && !orderWorkShopID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.orderWorkShopID_s like '%" + orderWorkShopID_s.trim() + "%'";
			}
			orderID_s = orderWorkShop.getOrderID_s();
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.orderID_s ='" + orderID_s.trim() + "'";
			}
			status_i = orderWorkShop.getStatus_i();
			if(status_i!=null ){
				condition = condition + " and orderWorkShop.status_i = '" + status_i + "'";
			}
			 
			startDate_t = orderWorkShop.getStartDate_t();
			endDate_t = orderWorkShop.getEndDate_t();
			if(startDate_t != null&&endDate_t!=null){
		    	condition = condition+" and ( to_date('"+DateUtil.getDate(startDate_t, "yyyy-MM-dd")+"','yyyy-MM-dd') between startDate_t and endDate_t " +
		    			"or to_date('"+DateUtil.getDate(startDate_t, "yyyy-MM-dd")+"','yyyy-MM-dd') between startDate_t and endDate_t)";		    	
			}else if(startDate_t != null){
				condition = condition+" and  to_date('"+DateUtil.getDate(startDate_t, "yyyy-MM-dd")+"','yyyy-MM-dd') between startDate_t and endDate_t " ;
			}else if(endDate_t != null){
				condition = condition+" and  to_date('"+DateUtil.getDate(startDate_t, "yyyy-MM-dd")+"','yyyy-MM-dd') between startDate_t and endDate_t)";
		    }
			workShopID_s = orderWorkShop.getWorkShopID_s();
			if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				condition = condition + " and orderWorkShop.workShopID_s like '%" + workShopID_s.trim() + "%'";
			}
			workShopName_s = orderWorkShop.getWorkShopName_s();
			if(workShopName_s!=null && !workShopName_s.trim().equals("")){
				condition = condition + " and orderWorkShop.workShopName_s like '%" + workShopName_s.trim() + "%'";
			}
			useInfo_s = orderWorkShop.getUseInfo_s();
			if(useInfo_s!=null && !useInfo_s.trim().equals("")){
				condition = condition + " and orderWorkShop.useInfo_s like '%" + useInfo_s.trim() + "%'";
			}
			remark_s = orderWorkShop.getRemark();
			if(remark_s!=null && !remark_s.trim().equals("")){
				condition = condition + " and orderWorkShop.remark_s like '%" + remark_s.trim() + "%'";
			}
			createDate_t = orderWorkShop.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderWorkShop.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			createUser_s = orderWorkShop.getCreateUser_s();
			if(createUser_s!=null && !createUser_s.trim().equals("")){
				condition = condition + " and orderWorkShop.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderWorkShop.getLastUpdateUser_s();
			if(lastUpdateUser_s!=null && !lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderWorkShop.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderWorkShop.getLastUpdateDate_t();
//			if(lastUpdateDate_t != null){
//		    	condition = condition+" and to_char(orderWorkShop.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
//		    }
			resaveds1 = orderWorkShop.getResaveds1();
			if(resaveds1!=null && !resaveds1.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds1 like '%" + resaveds1.trim() + "%'";
			}
			resaveds2 = orderWorkShop.getResaveds2();
			if(resaveds2!=null && !resaveds2.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds2 like '%" + resaveds2.trim() + "%'";
			}
			resaveds3 = orderWorkShop.getResaveds3();
			if(resaveds3!=null && !resaveds3.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds3 like '%" + resaveds3.trim() + "%'";
			}
			resaveds4 = orderWorkShop.getResaveds4();
			if(resaveds4!=null && !resaveds4.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds4 like '%" + resaveds4.trim() + "%'";
			}
			resaveds5 = orderWorkShop.getResaveds5();
			if(resaveds5!=null && !resaveds5.trim().equals("")){
				condition = condition + " and orderWorkShop.resaveds5 like '%" + resaveds5.trim() + "%'";
			}
//			startDateStr = orderWorkShop.getStartDateStr();
//			
//			endDateStr = orderWorkShop.getEndDateStr();
			
			 Query query = session.createQuery(hql+condition);
			    if(start != -1)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
			    list= query.list();
			    
			    return (ArrayList)list;
		} catch (Exception e) {
			//System.out.println(e.toString());
			// TODO: handle exception
		}
		finally{
			session.clear();
		}
		
		return null;
	}
	
	public static void main(String[] a){
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		Transaction tx = null;
		tx=session.beginTransaction();//开启事务
		OrderWorkShopServiceImpl orderWorkShopServiceImpl = new OrderWorkShopServiceImpl();
		try {
			orderWorkShopServiceImpl.reckonCostOrderWorkShop("DD2014071017", session);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}		
	}
}
