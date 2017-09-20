package com.freshen.cost.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.cost.service.IOrderWorkShopCostBasisService;

import com.freshen.entity.cost.TCostOrderworkshopcostbasis;

import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OrderWorkShopCostBasisServiceImpl extends ClimsServiceBase implements
		IOrderWorkShopCostBasisService {

	private String workshopidS;
	private String orderidS;
 
	private Double unitprieI;
	private String remarkS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	Date createDate_t;
	String createUser_s;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s; 
	String resaveds4_s; 
	String resaveds5_s;
	
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	Double	monthUnitPrie_i;
	Double	yearUnitPrie_i;
	Double	halfUnitPrie_i;
	Integer	serveManageUnitPrie_i;
	
	public ArrayList<TCostOrderworkshopcostbasis> getTCostOrderworkshopcostbasis(
			TCostOrderworkshopcostbasis tCostOrderworkshopcostbasis, int start,
			int size) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<TCostOrderworkshopcostbasis> list = new ArrayList<TCostOrderworkshopcostbasis>();
			if(tCostOrderworkshopcostbasis== null){
				Query query = session.createQuery("from TCostOrderworkshopcostbasis as tCostOrderworkshopcostbasis ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			unitprieI = tCostOrderworkshopcostbasis.getUnitprieI();
			remarkS = tCostOrderworkshopcostbasis.getRemarkS();
			lastupdateuserS = tCostOrderworkshopcostbasis.getLastupdateuserS();
			lastupdatedateT = tCostOrderworkshopcostbasis.getLastupdatedateT();
			orderidS = tCostOrderworkshopcostbasis.getOrderidS();
			workshopidS = tCostOrderworkshopcostbasis.getWorkshopidS();
			createDate_t = tCostOrderworkshopcostbasis.getCreateDate_t();
			createUser_s = tCostOrderworkshopcostbasis.getCreateUser_s();
			resaveds1_s = tCostOrderworkshopcostbasis.getResaveds1_s();
			resaveds2_s = tCostOrderworkshopcostbasis.getResaveds2_s();
			resaveds3_s = tCostOrderworkshopcostbasis.getResaveds3_s();
			resaveds4_s = tCostOrderworkshopcostbasis.getResaveds4_s();
			resaveds5_s = tCostOrderworkshopcostbasis.getResaveds5_s();
			monthUnitPrie_i = tCostOrderworkshopcostbasis.getMonthUnitPrie_i();
			yearUnitPrie_i = tCostOrderworkshopcostbasis.getYearUnitPrie_i();
			halfUnitPrie_i = tCostOrderworkshopcostbasis.getHalfUnitPrie_i();
			serveManageUnitPrie_i = tCostOrderworkshopcostbasis.getServeManageUnitPrie_i();
			String hql = " from TCostOrderworkshopcostbasis as tCostOrderworkshopcostbasis where 1=1 ";
			String condition="";
			 if(monthUnitPrie_i != null ){
			    	condition = condition + " and tCostOrderworkshopcostbasis.monthUnitPrie_i ='" + monthUnitPrie_i+ "'";
			    }
			 if(yearUnitPrie_i != null ){
			    	condition = condition + " and tCostOrderworkshopcostbasis.yearUnitPrie_i ='" + yearUnitPrie_i+ "'";
			    }
			 if(halfUnitPrie_i != null ){
			    	condition = condition + " and tCostOrderworkshopcostbasis.halfUnitPrie_i ='" + halfUnitPrie_i+ "'";
			    }
			 if(serveManageUnitPrie_i != null ){
			    	condition = condition + " and tCostOrderworkshopcostbasis.serveManageUnitPrie_i ='" + serveManageUnitPrie_i+ "'";
			    }
			if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.orderidS like '%" + orderidS.trim() + "%'";
		    }
			if(remarkS != null && !remarkS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.remarkS like '%" + remarkS.trim() + "%'";
		    }
			if(lastupdateuserS != null && !lastupdateuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.lastupdateuserS like '%" + lastupdateuserS.trim() + "%'";
		    }
			if(workshopidS != null && !workshopidS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.workshopidS like '%" + workshopidS.trim() + "%'";
		    }
		    
			 if(unitprieI != null ){
			    	condition = condition + " and tCostOrderworkshopcostbasis.unitprieI ='" + unitprieI+ "'";
			    }
			 
		    if(lastupdatedateT != null){
		    	condition = condition+" and to_char(tCostOrderworkshopcostbasis.lastupdatedateT,'yyyy-MM-dd')='"+DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderworkshopcostbasis.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderworkshopcostbasis.createDate_t ";
		    Query query = session.createQuery(hql+condition);
		    if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
		    
		    return (ArrayList)list;
		    
		}
		catch(Exception e){
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public long getTCostOrderworkshopcostbasisNumber(
			TCostOrderworkshopcostbasis tCostOrderworkshopcostbasis)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n =0;
		try{
			List<TCostOrderworkshopcostbasis> list = new ArrayList<TCostOrderworkshopcostbasis>();
			if(tCostOrderworkshopcostbasis== null){
				Query query = session.createQuery("from TCostOrderworkshopcostbasis as tCostOrderworkshopcostbasis ");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }
				    return n;
			}
			unitprieI = tCostOrderworkshopcostbasis.getUnitprieI();
			remarkS = tCostOrderworkshopcostbasis.getRemarkS();
			lastupdateuserS = tCostOrderworkshopcostbasis.getLastupdateuserS();
			lastupdatedateT = tCostOrderworkshopcostbasis.getLastupdatedateT();
			orderidS = tCostOrderworkshopcostbasis.getOrderidS();
			workshopidS = tCostOrderworkshopcostbasis.getWorkshopidS();
			createDate_t = tCostOrderworkshopcostbasis.getCreateDate_t();
			createUser_s = tCostOrderworkshopcostbasis.getCreateUser_s();
			resaveds1_s = tCostOrderworkshopcostbasis.getResaveds1_s();
			resaveds2_s = tCostOrderworkshopcostbasis.getResaveds2_s();
			resaveds3_s = tCostOrderworkshopcostbasis.getResaveds3_s();
			resaveds4_s = tCostOrderworkshopcostbasis.getResaveds4_s();
			resaveds5_s = tCostOrderworkshopcostbasis.getResaveds5_s();
			String hql = " from TCostOrderworkshopcostbasis as tCostOrderworkshopcostbasis where 1=1 ";
			String condition="";
			
			if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.orderidS like '%" + orderidS.trim() + "%'";
		    }
			if(remarkS != null && !remarkS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.remarkS like '%" + remarkS.trim() + "%'";
		    }
			if(lastupdateuserS != null && !lastupdateuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.lastupdateuserS like '%" + lastupdateuserS.trim() + "%'";
		    }
			if(workshopidS != null && !workshopidS.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.workshopidS like '%" + workshopidS.trim() + "%'";
		    }
		    
			 if(unitprieI != null ){
			    	condition = condition + " and tCostOrderworkshopcostbasis.unitprieI ='" + unitprieI+ "'";
			    }
			 
		    if(lastupdatedateT != null){
		    	condition = condition+" and to_char(tCostOrderworkshopcostbasis.lastupdatedateT,'yyyy-MM-dd')='"+DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderworkshopcostbasis.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderworkshopcostbasis.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderworkshopcostbasis.createDate_t ";
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }
		    return n;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public int OperationTCostOrderworkshopcostbasis(
			List<TCostOrderworkshopcostbasis> tCostOrderworkshopcostbasis,
			int operation) throws Exception {
		Transaction tx = null;
		Session session= HibernateUtil.getSession();
		int r=-1;
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				//IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				TCostOrderworkshopcostbasis gate = null;
				if(tCostOrderworkshopcostbasis!=null||tCostOrderworkshopcostbasis.size()>0){
					for(int i=0;i<tCostOrderworkshopcostbasis.size();i++){
						gate=tCostOrderworkshopcostbasis.get(i);
						if(gate.getOrderidS()== null || tCostOrderworkshopcostbasis.get(i).getOrderidS().trim().equals(""))
						{
//							gate = tCostOrderotherchargebasis.get(i);
//							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DJBusiness, session);
//							gate.setGateID_s(cpg);
//							session.saveOrUpdate(gate);
						}
						else
						{
							List<TCostOrderworkshopcostbasis> list = null;
							TCostOrderworkshopcostbasis tmp ;
							//= (TCostOrderworkshopcostbasis)session.get(TCostOrderworkshopcostbasis.class, tCostOrderworkshopcostbasis.get(i).getCostWorkShopID());
							TCostOrderworkshopcostbasis searchTemp=new TCostOrderworkshopcostbasis();
							searchTemp.setOrderidS(gate.getOrderidS());
							searchTemp.setWorkshopidS(gate.getWorkshopidS());
							list = this.getTCostOrderworkshopcostbasis(searchTemp, -1, 0);
							if(list== null)
							{
								return 0;
							}
							else
							{
								tmp = list.get(0);
							}
							
							/*sharonyshi
							 * 2014-10-17
							gate.setCreateDate_t(tmp.getCreateDate_t());
							gate.setCreateUser_s(tmp.getCreateUser_s());
							gate.setResaveds1_s(tmp.getResaveds1_s());
							gate.setResaveds2_s(tmp.getResaveds2_s());
							gate.setResaveds3_s(tmp.getResaveds3_s());
							gate.setResaveds4_s(tmp.getResaveds4_s());*/
							if(gate.getUnitprieI() != null){
								tmp.setUnitprieI(gate.getUnitprieI());
							}
							if(gate.getMonthUnitPrie_i() != null){
								tmp.setMonthUnitPrie_i(gate.getMonthUnitPrie_i());
							}
							if(gate.getHalfUnitPrie_i() != null){
								tmp.setHalfUnitPrie_i(gate.getHalfUnitPrie_i());
							}
							if(gate.getYearUnitPrie_i() != null){
								tmp.setYearUnitPrie_i(gate.getYearUnitPrie_i());
							}
							if(gate.getResaveds1_s() != null){
								tmp.setResaveds1_s(gate.getResaveds1_s());
							}
							
							session.saveOrUpdate(tmp);
						}
						r=1;
					}
				}
			}else if(operation==2){
				if(tCostOrderworkshopcostbasis!=null&&tCostOrderworkshopcostbasis.size()>0){
					for(int i=0;i<tCostOrderworkshopcostbasis.size();i++){
						session.delete(tCostOrderworkshopcostbasis.get(i));
						r=1;
					}
				}
			}
			tx.commit();
			r=1;
		}catch(Exception e){
			r=-1;
			tx.rollback();
			throw e;
		}finally{		
    		session.clear();	 
		}
		return r;
	}
	
	public static void main(String[] args) throws Exception {
		OrderWorkShopCostBasisServiceImpl ot = new OrderWorkShopCostBasisServiceImpl();
		
	}

}
