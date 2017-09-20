package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadCostService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.RoadCost;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class RoadCostServiceImpl extends ClimsServiceBase implements IroadCostService {

	
	String roadID_s;
	Double overproofUnitPrie_i; //大于3.5 吨&两轴,按小时算
	Double unitPrie_i;	   //小于3.5 吨&两轴,按小时算
	String remark_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	Integer minuteUnitPrie_i ;
	Double coefficient_i;
	Double activityUnitPrie_i;
	
	public ArrayList<RoadCost> getRoadCostInfo(RoadCost roadCost, int start,
			int size) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<RoadCost> list = new ArrayList<RoadCost>();
			if(roadCost== null){
				Query query = session.createQuery("from RoadCost as roadCost ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			roadID_s =roadCost.getRoadID_s();
			unitPrie_i = roadCost.getUnitPrie_i();
			overproofUnitPrie_i = roadCost.getOverproofUnitPrie_i();
			remark_s = roadCost.getRemark_s();
			createDate_t = roadCost.getCreateDate_t();
			createUser_s = roadCost.getCreateUser_s();
			lastUpdateUser_s =roadCost.getLastUpdateUser_s();
			lastUpdateDate_t = roadCost.getLastUpdateDate_t();
			resaveds1_s = roadCost.getResaveds1_s();
			resaveds2_s = roadCost.getResaveds2_s();
			resaveds3_s = roadCost.getResaveds3_s();
			resaveds4_s = roadCost.getResaveds4_s();
			resaveds5_s = roadCost.getResaveds5_s();
			minuteUnitPrie_i =  roadCost.getMinuteUnitPrie_i();
			coefficient_i = roadCost.getCoefficient_i();
			activityUnitPrie_i = roadCost.getActivityUnitPrie_i();
			String hql = " from RoadCost as roadCost where 1=1 ";
			String condition="";
			
			if(roadID_s != null && !roadID_s.trim().equals("")){
		    	condition = condition + " and roadCost.roadID_s like '%" +  roadID_s.trim() + "%'";
		    	Query query = session.createQuery(hql+condition);
		    	list = query.list();
		    	return (ArrayList) list;
		    }
			if(unitPrie_i != null ){
		    	condition = condition + " and roadCost.unitPrie_i ='" + unitPrie_i + "'";
		    }
			if(minuteUnitPrie_i != null ){
		    	condition = condition + " and roadCost.minuteUnitPrie_i ='" + minuteUnitPrie_i + "'";
		    }
			if(coefficient_i != null ){
		    	condition = condition + " and roadCost.coefficient_i ='" + coefficient_i + "'";
		    }
			if(activityUnitPrie_i != null ){
		    	condition = condition + " and roadCost.activityUnitPrie_i ='" + activityUnitPrie_i + "'";
		    }
			if(overproofUnitPrie_i != null ){
		    	condition = condition + " and roadCost.overproofUnitPrie_i ='" + overproofUnitPrie_i + "'";
		    }
		    if(remark_s != null && !remark_s.trim().equals("")){
		    	condition = condition + " and roadCost.remark_s like '%" + remark_s.trim() + "%'";
		    }
//		    if(roadID_s != null && !roadID_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.roadID_s like '%" + roadID_s.trim() + "%'";
//		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(roadCost.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and roadCost.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and roadCost.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(roadCost.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		   
		    condition = condition+" order by roadCost.roadID_s ";
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

	public long getRoadCostInfoNumber(RoadCost roadCost) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<RoadCost> list = new ArrayList<RoadCost>();
			if(roadCost== null){
				Query query = session.createQuery("from RoadCost as roadCost ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			roadID_s =roadCost.getRoadID_s();
			unitPrie_i = roadCost.getUnitPrie_i();
			overproofUnitPrie_i = roadCost.getOverproofUnitPrie_i();
			remark_s = roadCost.getRemark_s();
			createDate_t = roadCost.getCreateDate_t();
			createUser_s = roadCost.getCreateUser_s();
			lastUpdateUser_s =roadCost.getLastUpdateUser_s();
			lastUpdateDate_t = roadCost.getLastUpdateDate_t();
			resaveds1_s = roadCost.getResaveds1_s();
			resaveds2_s = roadCost.getResaveds2_s();
			resaveds3_s = roadCost.getResaveds3_s();
			resaveds4_s = roadCost.getResaveds4_s();
			resaveds5_s = roadCost.getResaveds5_s();
			minuteUnitPrie_i =  roadCost.getMinuteUnitPrie_i();
			coefficient_i = roadCost.getCoefficient_i();
			activityUnitPrie_i = roadCost.getActivityUnitPrie_i();
			String hql = " from RoadCost as roadCost where 1=1 ";
			String condition="";
			
			if(roadID_s != null && !roadID_s.trim().equals("")){
		    	condition = condition + " and roadCost.roadID_s like '%" +  roadID_s.trim() + "%'";
		    	Query query = session.createQuery(hql+condition);
		    	if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
		    }
			if(unitPrie_i != null ){
		    	condition = condition + " and roadCost.unitPrie_i ='" + unitPrie_i + "'";
		    }
			if(minuteUnitPrie_i != null ){
		    	condition = condition + " and roadCost.minuteUnitPrie_i ='" + minuteUnitPrie_i + "'";
		    }
			if(coefficient_i != null ){
		    	condition = condition + " and roadCost.coefficient_i ='" + coefficient_i + "'";
		    }
			if(activityUnitPrie_i != null ){
		    	condition = condition + " and roadCost.activityUnitPrie_i ='" + activityUnitPrie_i + "'";
		    }
			if(overproofUnitPrie_i != null ){
		    	condition = condition + " and roadCost.overproofUnitPrie_i ='" + overproofUnitPrie_i + "'";
		    }
		    if(remark_s != null && !remark_s.trim().equals("")){
		    	condition = condition + " and roadCost.remark_s like '%" + remark_s.trim() + "%'";
		    }
//		    if(roadID_s != null && !roadID_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.roadID_s like '%" + roadID_s.trim() + "%'";
//		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(roadCost.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and roadCost.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and roadCost.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(roadCost.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and roadCost.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		   
		    condition = condition+" order by roadCost.roadID_s ";
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
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

	public int OperationRoadCostInfo(List<RoadCost> roadCost, int operation)
			throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		try{					
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				RoadCost tmp = new RoadCost();
				boolean b1 = false; //没有修改入口道路
				boolean b2 = false; //没有修改出口道路
				if(roadCost!=null||roadCost.size()>0){
					for(int i=0;i<roadCost.size();i++){		
						tmp = roadCost.get(i);
						if(roadCost.get(i).getRoadID_s()== null || roadCost.get(i).getRoadID_s().trim().equals(""))
						{
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DLFYBusiness, session);
							tmp.setRoadID_s(cpg);
							session.saveOrUpdate(tmp);
						}
						else
						{
							RoadCost rc = (RoadCost)session.get(BarrierGate.class, roadCost.get(i).getRoadID_s());
							
							roadID_s = tmp.getRoadID_s();
							unitPrie_i = tmp.getUnitPrie_i();
							overproofUnitPrie_i = tmp.getOverproofUnitPrie_i();
							remark_s = tmp.getRemark_s();
							createDate_t = tmp.getCreateDate_t();
							createUser_s = tmp.getCreateUser_s();
							lastUpdateUser_s =tmp.getLastUpdateUser_s();
							lastUpdateDate_t = tmp.getLastUpdateDate_t();
							resaveds1_s = tmp.getResaveds1_s();
							resaveds2_s = tmp.getResaveds2_s();
							resaveds3_s = tmp.getResaveds3_s();
							resaveds4_s = tmp.getResaveds4_s();
							resaveds5_s = tmp.getResaveds5_s();
							minuteUnitPrie_i =  tmp.getMinuteUnitPrie_i();
							coefficient_i = tmp.getCoefficient_i();
							activityUnitPrie_i = tmp.getActivityUnitPrie_i();
							/*outroadinfo = gate.getOutroadinfo();
							enterroadinfo = gate.getEnterroadinfo();
							
							if(outroadinfo==null)
							{
								gate.setOutroadinfo(outroadinfo);
							}
							if(enterroadinfo==null){
								gate.setEnterroadinfo(enterroadinfo);
							}*/
							if(minuteUnitPrie_i == null){
								tmp.setMinuteUnitPrie_i(rc.getMinuteUnitPrie_i());
							}
							if(coefficient_i == null){
								tmp.setCoefficient_i(rc.getCoefficient_i());
							}
							if(activityUnitPrie_i == null){
								tmp.setActivityUnitPrie_i(rc.getActivityUnitPrie_i());
							}
							if(unitPrie_i == null){
								tmp.setUnitPrie_i(rc.getUnitPrie_i());
							}
							if(overproofUnitPrie_i == null)
							{
								tmp.setOverproofUnitPrie_i(rc.getOverproofUnitPrie_i());
							}
							if(remark_s == null){
								tmp.setRemark_s(rc.getRemark_s());
							}
							if(createDate_t == null){
								tmp.setCreateDate_t(rc.getCreateDate_t());
							}
							if(createUser_s == null){
								tmp.setCreateUser_s(rc.getCreateUser_s());
							}
							if(lastUpdateUser_s==null){
								tmp.setLastUpdateUser_s(rc.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t==null){
								tmp.setLastUpdateDate_t(rc.getLastUpdateDate_t());
							}
							if(resaveds1_s==null){
								tmp.setResaveds1_s(rc.getResaveds1_s());
							}
							if(resaveds2_s==null){
								tmp.setResaveds2_s(rc.getResaveds3_s());
							}
							if(resaveds3_s==null){
								tmp.setResaveds3_s(rc.getResaveds3_s());
							}
							if(resaveds4_s==null){
								tmp.setResaveds4_s(rc.getResaveds4_s());
							}
							if(resaveds5_s==null){
								tmp.setResaveds5_s(rc.getResaveds5_s());
							}
//							if(!b1||!b2){
//								BarrierGate barrierGatetmp = this.getBasisBarrierGateInfo(gate, 0, 1).get(0);
//								if(!b1){
//									gate.setEnterroadinfo(barrierGatetmp.getEnterroadinfo());
//								}
//								if(!b2){
//									gate.setOutroadinfo(barrierGatetmp.getOutroadinfo());
//								}
//							}
							session.saveOrUpdate(tmp);
							
						}
						session.flush();
					  //  session.clear();
					}
				}
			}
			//删除
			if(operation==2){
				if(roadCost!=null&&roadCost.size()>0){
					for(int i=0;i<roadCost.size();i++){
						session.delete(roadCost.get(i));
						session.flush();			
					}
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

}
