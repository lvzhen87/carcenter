package com.freshen.cost.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.cost.service.ICostOrderothercostService;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.cost.TCostOrderotherchargebasis;
import com.freshen.entity.cost.TCostOrderothercost;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class CostOrderothercostServiceImpl extends ClimsServiceBase implements
		ICostOrderothercostService {

	 private String orderidS;
	 private double electricchargeI;
	 private double administrativefeeI;
	 private double telephonebillI;
	 private double artisanchargeI;
	 Date createDate_t;
	 String createUser_s;
	 String resaveds1_s;
	 String resaveds2_s;
	 String resaveds3_s; 
	 String resaveds4_s; 
	 String resaveds5_s;
	 private int datenumberI=0;
	
	 //Session session = HibernateUtil.getSession();
	 Transaction tx = null;
	 
	public ArrayList<TCostOrderothercost> getTCostOrderothercost(
			TCostOrderothercost tCostOrderothercost, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<TCostOrderothercost> list = new ArrayList<TCostOrderothercost>();
			if(tCostOrderothercost== null){
				Query query = session.createQuery("from TCostOrderothercost as tCostOrderothercost ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			datenumberI = tCostOrderothercost.getDatenumberI();
			orderidS = tCostOrderothercost.getOrderidS();
			electricchargeI = tCostOrderothercost.getElectricchargeI();
			administrativefeeI = tCostOrderothercost.getAdministrativefeeI();
			telephonebillI = tCostOrderothercost.getTelephonebillI();
			artisanchargeI = tCostOrderothercost.getArtisanchargeI();
			createDate_t = tCostOrderothercost.getCreateDate_t();
			createUser_s = tCostOrderothercost.getCreateUser_s();
			resaveds1_s = tCostOrderothercost.getResaveds1_s();
			resaveds2_s = tCostOrderothercost.getResaveds2_s();
			resaveds3_s = tCostOrderothercost.getResaveds3_s();
			resaveds4_s = tCostOrderothercost.getResaveds4_s();
			resaveds5_s = tCostOrderothercost.getResaveds5_s();
			String hql = " from TCostOrderothercost as tCostOrderothercost where 1=1 ";
			String condition="";
			
		    if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.orderidS like '%" + orderidS.trim() + "%'";
		    }
		    
		    if(datenumberI >0 ){
		    	condition = condition + " and tCostOrderothercost.datenumberI =" + datenumberI+ "";
		    }
		    if(electricchargeI>0 ){
		    	condition = condition + " and tCostOrderothercost.electricchargeI ='" + electricchargeI+ "'";
		    }
		    if(administrativefeeI>0){
		    	condition = condition + " and tCostOrderothercost.administrativefeeI ='" + administrativefeeI+ "'";
		    }
		    if(telephonebillI >0 ){
		    	condition = condition + " and tCostOrderothercost.telephonebillI ='" + telephonebillI+ "'";
		    }
		    if(artisanchargeI >0 ){
		    	condition = condition + " and tCostOrderothercost.artisanchargeI ='" + artisanchargeI+ "'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderothercost.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderothercost.createDate_t ";
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

	public long getTCostOrderothercostNumber(
			TCostOrderothercost tCostOrderothercost) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n= 0;
		try{
			List<TCostOrderothercost> list = new ArrayList<TCostOrderothercost>();
			if(tCostOrderothercost== null){
				Query query = session.createQuery("select count(*) from TCostOrderothercost as tCostOrderothercost ");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }
				    return n;
			}
			datenumberI = tCostOrderothercost.getDatenumberI();
			orderidS = tCostOrderothercost.getOrderidS();
			 
			electricchargeI = tCostOrderothercost.getElectricchargeI();
			administrativefeeI = tCostOrderothercost.getAdministrativefeeI();
			telephonebillI = tCostOrderothercost.getTelephonebillI();
			artisanchargeI = tCostOrderothercost.getArtisanchargeI();
			createDate_t = tCostOrderothercost.getCreateDate_t();
			createUser_s = tCostOrderothercost.getCreateUser_s();
			resaveds1_s = tCostOrderothercost.getResaveds1_s();
			resaveds2_s = tCostOrderothercost.getResaveds2_s();
			resaveds3_s = tCostOrderothercost.getResaveds3_s();
			resaveds4_s = tCostOrderothercost.getResaveds4_s();
			resaveds5_s = tCostOrderothercost.getResaveds5_s();
			String hql = "select count(*) from TCostOrderothercost as tCostOrderothercost where 1=1 ";
			String condition="";
			
		    if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.orderidS like '%" + orderidS.trim() + "%'";
		    }
		    
		    if(datenumberI >0){
		    	condition = condition + " and tCostOrderothercost.datenumberI ='" + datenumberI+ "'";
		    }
		    if(electricchargeI >0){
		    	condition = condition + " and tCostOrderothercost.electricchargeI ='" + electricchargeI+ "'";
		    }
		    if(administrativefeeI >0){
		    	condition = condition + " and tCostOrderothercost.administrativefeeI ='" + administrativefeeI+ "'";
		    }
		    if(telephonebillI >0 ){
		    	condition = condition + " and tCostOrderothercost.telephonebillI ='" + telephonebillI+ "'";
		    }
		    if(artisanchargeI>0 ){
		    	condition = condition + " and tCostOrderothercost.artisanchargeI ='" + artisanchargeI+ "'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderothercost.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderothercost.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderothercost.createDate_t ";
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

	public int OperationTCostOrderothercost(
			List<TCostOrderothercost> tCostOrderothercost, int operation)
			throws Exception {
		Transaction tx = null;
		int r=-1;
		Session session= HibernateUtil.getSession();
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				TCostOrderothercost gate = null;
				//RoadInfo roadInfotmp = new RoadInfo();
//				boolean b1 = false; //没有修改入口道路
//				boolean b2 = false; //没有修改出口道路
				if(tCostOrderothercost!=null||tCostOrderothercost.size()>0){
					for(int i=0;i<tCostOrderothercost.size();i++){
						gate =tCostOrderothercost.get(i);
						if(gate.getOrderidS()== null || tCostOrderothercost.get(i).getOrderidS().trim().equals(""))
						{
//							gate = tCostOrderotherchargebasis.get(i);
//							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DJBusiness, session);
//							gate.setGateID_s(cpg);
//							session.saveOrUpdate(gate);
						}
						else
						{
							TCostOrderothercost tmp =(TCostOrderothercost)session.get(TCostOrderothercost.class, tCostOrderothercost.get(i).getOrderidS());
							tmp.setAdministrativefeeI(gate.getAdministrativefeeI());
							tmp.setArtisanchargeI(gate.getArtisanchargeI());
							if(gate.getDatenumberI()>0)
								tmp.setDatenumberI(gate.getDatenumberI());
							tmp.setElectricchargeI(gate.getElectricchargeI());
							tmp.setTelephonebillI(gate.getTelephonebillI());
							session.saveOrUpdate(tmp);
							r=1;
						}
					}
				}
			}
			//删除
			if(operation==2){
				if(tCostOrderothercost!=null&&tCostOrderothercost.size()>0){
					for(int i=0;i<tCostOrderothercost.size();i++){
						session.delete(tCostOrderothercost.get(i));
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
	
}
