package com.freshen.barrierGate.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.barrierGate.service.BarrierGateInorOutinfoService;
import com.freshen.basis.service.IBarrierGateService;
import com.freshen.basis.service.impl.BarrierGateServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.barrierGate.BarrierGateInorOutinfo;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class BarrierGateInorOutinfoServiceImpl extends ClimsServiceBase implements
		BarrierGateInorOutinfoService {

	String cardID_s;
	String barrierGateID_s;
	String createTime_s;
	String motion_s;
	Integer Isok_i;
	String resaveds1_s,
	resaveds2_s,
	resaveds3_s,
	resaveds4_s,
	resaveds5_s,
	createDate_s;
 	 
	 
	String speedtype_s;
	Transaction tx = null;
	public ArrayList<BarrierGateInorOutinfo> getBarrierGateInorOutinfo(
			BarrierGateInorOutinfo barrierGateInorOutinfo, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		ArrayList<BarrierGateInorOutinfo> list = new ArrayList();
		try {
			if(barrierGateInorOutinfo == null)
			{
				Query query = session.createQuery(" from BarrierGateInorOutinfo as barrierGateInorOutinfo");
				list = (ArrayList)query.list();
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				session.clear();
				return list;
			}
			cardID_s= barrierGateInorOutinfo.getCardID_s();
			barrierGateID_s = barrierGateInorOutinfo.getBarrierGateID_s();
			createTime_s = barrierGateInorOutinfo.getCreateTime_s();
			motion_s = barrierGateInorOutinfo.getMotion_s();
			Isok_i = barrierGateInorOutinfo.getIsok_i();
			String hql = "  from BarrierGateInorOutinfo as barrierGateInorOutinfo where 1=1 ";
			String condition = " ";
			if(cardID_s != null && !cardID_s.trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.cordID_s like '%" + cardID_s.trim() + "%'";
		    }
		    if(barrierGateID_s != null && !barrierGateID_s.trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.barrierGateID_s like '%" + barrierGateID_s.trim() + "%'";
		    }
		    if(createTime_s != null){
		    	condition = condition + " and barrierGateInorOutinfo.createTime_s like '%" + createTime_s + "%'";
		    }
		    if(motion_s != null){
		    	condition = condition + " and barrierGateInorOutinfo.motion_s like '%" + motion_s.trim() + "%'";
		    }
		    if(Isok_i != null){
		    	condition = condition + " and barrierGateInorOutinfo.Isok_i ='" + Isok_i + "'";
		    }
		    
		    Query query = session.createQuery(hql + condition);
			list = (ArrayList)query.list();
			if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
			session.clear();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally{
			session.clear();
		}
	}

	public long getBarrierGateInorOutinfo(
			BarrierGateInorOutinfo barrierGateInorOutinfo) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		ArrayList<BarrierGateInorOutinfo> list = new ArrayList();
		long n = 0;
		try {
			if(barrierGateInorOutinfo == null)
			{
				Query query = session.createQuery("select count(*) from from BarrierGateInorOutinfo as barrierGateInorOutinfo");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			cardID_s= barrierGateInorOutinfo.getCardID_s();
			barrierGateID_s = barrierGateInorOutinfo.getBarrierGateID_s();
			createTime_s = barrierGateInorOutinfo.getCreateTime_s();
			motion_s = barrierGateInorOutinfo.getMotion_s();
			Isok_i = barrierGateInorOutinfo.getIsok_i();
			String hql = "  from BarrierGateInorOutinfo as barrierGateInorOutinfo where 1=1 ";
			String condition = " ";
			if(cardID_s != null && !cardID_s.trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.cordID_s like '%" + cardID_s.trim() + "%'";
		    }
		    if(barrierGateID_s != null && !barrierGateID_s.trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.barrierGateID_s like '%" + barrierGateID_s.trim() + "%'";
		    }
		    if(createTime_s != null){
		    	condition = condition + " and barrierGateInorOutinfo.createTime_s like '%" + createTime_s + "%'";
		    }
		    if(motion_s != null&& !motion_s.trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.motion_s like '%" + motion_s.trim() + "%'";
		    }
		    if(Isok_i != null){
		    	condition = condition + " and barrierGateInorOutinfo.Isok_i ='" + Isok_i + "'";
		    }
		    
		    Query query = session.createQuery(hql + condition);
			list = (ArrayList)query.list();
			if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
			}
			return n;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally{
			session.clear();
		}
	}


	/**
	 * 操作进出道闸流水表
	 */
	public String OperationBarrierGateInorOutinfoService(BarrierGateInorOutinfo barrierGateInorOutinfo, int operation)
	throws Exception {
		try{
			String motion_s = barrierGateInorOutinfo.getMotion_s();
			String roadID_s = barrierGateInorOutinfo.getRoadID_s();
			String cpg_s = barrierGateInorOutinfo.getResaveds3_s();
			IBarrierGateService bser = new BarrierGateServiceImpl();
			//得到对应的道闸
			BarrierGate barrierGate = new BarrierGate();
			barrierGate.setResaveds1_s(motion_s);
			barrierGate.setEntranceRoadIDs(roadID_s);
			barrierGateInorOutinfo.setBarrierGateID_s(bser.getBasisBarrierGateInfo(barrierGate, ConstantUtil.pagingNot,0).get(0).getGateNumber_s());
			//得到车卡号和订单号
			IreceptionVehicleInfoService rvSer = new ReceptionVehicleInfoServiceImpl();
			ReceptionVehicleInfo rVehic1leInfo = new ReceptionVehicleInfo();
			rVehic1leInfo.setResaveds2_s(cpg_s);
			List<ReceptionVehicleInfo> l = rvSer.getReceptionVehicleInfo(rVehic1leInfo, ConstantUtil.pagingNot, 0);
			if(!BasicTools.isnotNull(l)){				
				return "请输入正确的CPG牌照号";
			}else if(l.size()>1){				
				return "请输入正确的CPG牌照号";
			}else{
				barrierGateInorOutinfo.setCardID_s(l.get(0).getVehicleID_s());
				barrierGateInorOutinfo.setResaveds2_s(l.get(0).getOrderID_s());
			}
			String times = barrierGateInorOutinfo.getCreateTime_s();
			times = DateUtil.dateStringTOstr(times);
			times = DateUtil.dateToString(DateUtil.stringToDateformat(times,"MM/dd/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss");
			barrierGateInorOutinfo.setCreateTime_s(times);
			barrierGateInorOutinfo.setEditflagtime_s(times);
 			this.OperationBarrierGateInorOutinfo(barrierGateInorOutinfo, operation);
 			return null;
 			
		}catch(Exception e){
			 
			throw e;
		}finally{
			
		}
	}
			
	/**
	 * 操作进出道闸流水表
	 */
	public int OperationBarrierGateInorOutinfo(
			BarrierGateInorOutinfo barrierGateInorOutinfo, int operation)
			throws Exception {
		Transaction tx = null;
		Session session= HibernateUtil.getSession();
		try{
			if(!session.isOpen()){
				session= HibernateUtil.getSession();
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				if(barrierGateInorOutinfo.getEventNumber_s()==null){
					IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
					String pk = systemSequenceServiceImpl.getPK(ConstantUtil.IOBBusiness, session);
					barrierGateInorOutinfo.setEventNumber_s(pk);
				}
				session.merge(barrierGateInorOutinfo);
				session.flush();
			    session.clear();
			}
			//删除
			if(operation==2){
				if(barrierGateInorOutinfo!=null){
					barrierGateInorOutinfo.setResaveds1_s("1");
					session.update(barrierGateInorOutinfo);
					session.flush();
					session.clear();
				}
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
			session.clear();
		}	
	}
	

	public int OperationBarrierGateInorOutinfo2(BarrierGateInorOutinfo barrierGateInorOutinfo, int operation) throws Exception{
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session= HibernateUtil.getSession();
		try{			
			if(operation==1){
				if(barrierGateInorOutinfo != null){
					if(!session.isOpen()){
						session= HibernateUtil.getSession();
					}
					tx=session.beginTransaction();//开启事务
					BarrierGateInorOutinfo temp=(BarrierGateInorOutinfo) session.get(BarrierGateInorOutinfo.class,barrierGateInorOutinfo.getEventNumber_s());					 					
					createTime_s = barrierGateInorOutinfo.getCreateTime_s();				 
					resaveds1_s = barrierGateInorOutinfo.getResaveds1_s();
					resaveds2_s = barrierGateInorOutinfo.getResaveds2_s();
					resaveds3_s = barrierGateInorOutinfo.getResaveds3_s();
					resaveds4_s = barrierGateInorOutinfo.getResaveds4_s();
					resaveds5_s = barrierGateInorOutinfo.getResaveds5_s();
					speedtype_s = barrierGateInorOutinfo.getSpeedtype_s();
					cardID_s = barrierGateInorOutinfo.getCardID_s();
					barrierGateID_s = barrierGateInorOutinfo.getBarrierGateID_s();					
					motion_s = barrierGateInorOutinfo.getMotion_s();
					Isok_i = barrierGateInorOutinfo.getIsok_i();
					
					if(speedtype_s!=null){
				    	temp.setSpeedtype_s(speedtype_s);
				    }
					if(cardID_s!=null){
				    	temp.setCardID_s(cardID_s);
				    }
					if(barrierGateID_s!=null){
				    	temp.setBarrierGateID_s(barrierGateID_s);
				    }
					if(motion_s!=null){
				    	temp.setMotion_s(motion_s);
				    }
					if(Isok_i!=null){
				    	temp.setIsok_i(Isok_i);
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
				    session.saveOrUpdate(temp);
				    session.flush();
				    session.clear();
				}
			}
			//删除
			if(operation==2){
				session.delete(barrierGateInorOutinfo);
				session.flush();
				session.clear();
			}
			
			tx.commit();
			return 1;	
		}catch(Exception e){
			tx.rollback();
			throw new Exception(e);
			
		}finally{
			//session.clear();
			session.clear();
		}	 
	}
	
	public static void main(String[] args) throws Exception {
		String t = "8/2/2011 3";
		String s[] = t.split("/");
		if(s[0].length()<2){
			t = "0"+t;
		}
		if(s[1].length()<2){
			t=t.substring(0,3)+"0"+t.substring(3, t.length());
		}
//		//System.out.println(t);
	}

}
