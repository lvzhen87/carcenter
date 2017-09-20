package com.freshen.cost.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.cost.service.ICostOrderotherchargebasisService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.cost.TCostOrderotherchargebasis;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class CostOrderotherchargebasisServiceImpl extends ClimsServiceBase implements
		ICostOrderotherchargebasisService {

	private Integer idI;
	private String orderidS;
	 
	private Integer electricchargeI;
	private Integer administrativefeeI;
	private Integer telephonebillI;
	private Integer artisanchargeI;
	Date createDate_t;
	String createUser_s;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s; 
	String resaveds4_s; 
	String resaveds5_s;
	
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<TCostOrderotherchargebasis> getTCostOrderotherchargebasis(
			TCostOrderotherchargebasis tCostOrderotherchargebasis, int start,
			int size) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
			RoadInfo roadInfomodel = new RoadInfo();
			List<TCostOrderotherchargebasis> list = new ArrayList<TCostOrderotherchargebasis>();
			if(tCostOrderotherchargebasis== null){
				Query query = session.createQuery("from TCostOrderotherchargebasis as tCostOrderotherchargebasis ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			idI = tCostOrderotherchargebasis.getIdI();
			orderidS = tCostOrderotherchargebasis.getOrderidS();
			electricchargeI = tCostOrderotherchargebasis.getElectricchargeI();
			administrativefeeI = tCostOrderotherchargebasis.getAdministrativefeeI();
			telephonebillI = tCostOrderotherchargebasis.getTelephonebillI();
			artisanchargeI = tCostOrderotherchargebasis.getArtisanchargeI();
			createDate_t = tCostOrderotherchargebasis.getCreateDate_t();
			createUser_s = tCostOrderotherchargebasis.getCreateUser_s();
			resaveds1_s = tCostOrderotherchargebasis.getResaveds1_s();
			resaveds2_s = tCostOrderotherchargebasis.getResaveds2_s();
			resaveds3_s = tCostOrderotherchargebasis.getResaveds3_s();
			resaveds4_s = tCostOrderotherchargebasis.getResaveds4_s();
			resaveds5_s = tCostOrderotherchargebasis.getResaveds5_s();
			String hql = " from TCostOrderotherchargebasis as tCostOrderotherchargebasis where 1=1 ";
			String condition="";
			
			if(idI != null ){
		    	condition = condition + " and tCostOrderotherchargebasis.idI = '" +  idI + "'";
		    	Query query = session.createQuery(hql+condition);
		    	list = query.list();
		    	return (ArrayList) list;
		    }
		    if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.orderidS like '%" + orderidS.trim() + "%'";
		    }
		    if(electricchargeI != null && electricchargeI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.electricchargeI ='" + electricchargeI+ "'";
		    }
		    if(administrativefeeI != null && administrativefeeI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.administrativefeeI ='" + administrativefeeI+ "'";
		    }
		    if(telephonebillI != null && telephonebillI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.telephonebillI ='" + telephonebillI+ "'";
		    }
		    if(artisanchargeI != null && artisanchargeI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.artisanchargeI ='" + artisanchargeI+ "'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderotherchargebasis.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderotherchargebasis.idI ";
		    Query query = session.createQuery(hql+condition);
		    if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
//		    RoadInfo ri = new RoadInfo();
//		    if(list!=null&&list.size()>0){
//				for(int i=0;i<list.size();i++){
//					BarrierGate bg = new BarrierGate();
//					bg = list.get(i);
//					RoadInfo r = bg.getRoadinfo();
//					r.setRoadID_s(barrierGate.getRoadID_s());
//					bg.setRoadinfo(r);
//					list.set(i, bg);
//				}
//			}
		    return (ArrayList)list;
		    
		}
		catch(Exception e){
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public long getTCostOrderotherchargebasisNumber(
			TCostOrderotherchargebasis tCostOrderotherchargebasis)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n = 0;
		try{
			IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
			RoadInfo roadInfomodel = new RoadInfo();
			List<TCostOrderotherchargebasis> list = new ArrayList<TCostOrderotherchargebasis>();
			if(tCostOrderotherchargebasis== null){
				Query query = session.createQuery("from TCostOrderotherchargebasis as tCostOrderotherchargebasis ");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }
				    return n;
			}
			idI = tCostOrderotherchargebasis.getIdI();
			orderidS = tCostOrderotherchargebasis.getOrderidS();
			 
			electricchargeI = tCostOrderotherchargebasis.getElectricchargeI();
			administrativefeeI = tCostOrderotherchargebasis.getAdministrativefeeI();
			telephonebillI = tCostOrderotherchargebasis.getTelephonebillI();
			artisanchargeI = tCostOrderotherchargebasis.getArtisanchargeI();
			createDate_t = tCostOrderotherchargebasis.getCreateDate_t();
			createUser_s = tCostOrderotherchargebasis.getCreateUser_s();
			resaveds1_s = tCostOrderotherchargebasis.getResaveds1_s();
			resaveds2_s = tCostOrderotherchargebasis.getResaveds2_s();
			resaveds3_s = tCostOrderotherchargebasis.getResaveds3_s();
			resaveds4_s = tCostOrderotherchargebasis.getResaveds4_s();
			resaveds5_s = tCostOrderotherchargebasis.getResaveds5_s();
			String hql = " from TCostOrderotherchargebasis as tCostOrderotherchargebasis where 1=1 ";
			String condition="";
			if(idI != null ){
		    	condition = condition + " and tCostOrderotherchargebasis.idI = '" +  idI + "'";
		    	Query query = session.createQuery(hql+condition);
		    	 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }
				    return n;
		    }
		    if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.orderidS like '%" + orderidS.trim() + "%'";
		    }
		    if(electricchargeI != null && electricchargeI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.electricchargeI ='" + electricchargeI+ "'";
		    }
		    if(administrativefeeI != null && administrativefeeI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.administrativefeeI ='" + administrativefeeI+ "'";
		    }
		    if(telephonebillI != null && telephonebillI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.telephonebillI ='" + telephonebillI+ "'";
		    }
		    if(artisanchargeI != null && artisanchargeI != -1){
		    	condition = condition + " and tCostOrderotherchargebasis.artisanchargeI ='" + artisanchargeI+ "'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderotherchargebasis.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderotherchargebasis.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderotherchargebasis.idI ";
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

	public int OperationTCostOrderotherchargebasis(
			List<TCostOrderotherchargebasis> tCostOrderotherchargebasis,
			int operation) throws Exception {
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		int r=-1;
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				TCostOrderotherchargebasis gate =null;
				if(tCostOrderotherchargebasis!=null||tCostOrderotherchargebasis.size()>0){
					for(int i=0;i<tCostOrderotherchargebasis.size();i++){		
						gate =tCostOrderotherchargebasis.get(i);
						if(gate.getIdI()== null || tCostOrderotherchargebasis.get(i).getIdI().equals(""))
						{
//							gate = tCostOrderotherchargebasis.get(i);
//							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DJBusiness, session);
//							gate.setGateID_s(cpg);
//							session.saveOrUpdate(gate);
						}
						else
						{
							//创建临时对象，提供 主键查询
							TCostOrderotherchargebasis temp =new TCostOrderotherchargebasis();
							temp.setIdI(gate.getIdI());
							temp.setOrderidS(gate.getOrderidS());
							//检索数据库中的对象
							TCostOrderotherchargebasis tmp = (TCostOrderotherchargebasis)session.get(TCostOrderotherchargebasis.class, temp);
							tmp.setAdministrativefeeI(gate.getAdministrativefeeI());
							tmp.setArtisanchargeI(gate.getArtisanchargeI());
							tmp.setElectricchargeI(gate.getElectricchargeI());
							tmp.setTelephonebillI(gate.getTelephonebillI());
							session.saveOrUpdate(tmp);
							session.flush();
							r=1;
						}
					}
				}
			}
			//删除
			if(operation==2){
				if(tCostOrderotherchargebasis!=null&&tCostOrderotherchargebasis.size()>0){
					for(int i=0;i<tCostOrderotherchargebasis.size();i++){
						session.delete(tCostOrderotherchargebasis.get(i));
					}
				}
				r=1;
			}
			//session.flush();
			tx.commit();
		}catch(Exception e){
			r=-1;
			tx.rollback();
			throw e;
		}finally{	
			session.flush();
    		session.clear();	 
		}	
		return r;
	}

}
