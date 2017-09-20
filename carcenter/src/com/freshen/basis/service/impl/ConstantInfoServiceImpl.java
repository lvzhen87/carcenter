package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IConstantInfoService;
import com.freshen.basis.service.IroadCostService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.ConstantInfo;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public   class ConstantInfoServiceImpl extends ClimsServiceBase implements IConstantInfoService{

	String constantID_s;
	String constantName_s;
	String constantDescribe_s;
	String constantValues_s;
	
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
	
	public ArrayList<ConstantInfo> getConstantInfo(ConstantInfo constantInfo, int start,
			int size) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<ConstantInfo> list = new ArrayList<ConstantInfo>();
			if(constantInfo== null){
				Query query = session.createQuery("from ConstantInfo as constantInfo ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			constantID_s = constantInfo.getConstantID_s();
			constantName_s = constantInfo.getConstantName_s();
			constantDescribe_s = constantInfo.getConstantDescribe_s();
			constantValues_s = constantInfo.getConstantValues_s();
		 
			createDate_t = constantInfo.getCreateDate_t();
			createUser_s = constantInfo.getCreateUser_s();
			lastUpdateUser_s =constantInfo.getLastUpdateUser_s();
			lastUpdateDate_t = constantInfo.getLastUpdateDate_t();
			resaveds1_s = constantInfo.getResaveds1_s();
			resaveds2_s = constantInfo.getResaveds2_s();
			resaveds3_s = constantInfo.getResaveds3_s();
			resaveds4_s = constantInfo.getResaveds4_s();
			resaveds5_s = constantInfo.getResaveds5_s();
		 
			String hql = " from ConstantInfo as constantInfo where 1=1 ";
			String condition="";
			
			if(constantID_s != null && !constantID_s.trim().equals("")){
		    	condition = condition + " and constantInfo.constantID_s like '%" +  constantID_s.trim() + "%'";
		    	Query query = session.createQuery(hql+condition);
		    	list = query.list();
		    	return (ArrayList) list;
		    }
			if(constantName_s != null &&!constantName_s.trim().equals("") ){
		    	condition = condition + " and constantInfo.constantName_s like '%" + constantName_s.trim() + "%'";
		    }
			if(constantDescribe_s != null &&!constantDescribe_s.trim().equals("")  ){
		    	condition = condition + " and  constantInfo.constantDescribe_s  like '%" + constantDescribe_s + "%'";
		    }
			if(constantValues_s!= null &&!constantValues_s.trim().equals("") ){
		    	condition = condition + " and constantInfo.constantValues_s  ='" + constantValues_s  + "'";
		    }
			 
//		    if(roadID_s != null && !roadID_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.roadID_s like '%" + roadID_s.trim() + "%'";
//		    }
		    if(createDate_t != null  ){
		    	condition = condition+" and to_char(ConstantInfo.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and constantInfo.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and constantInfo.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(constantInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		   
		    condition = condition+" order by constantInfo.createDate_t  ";
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

	public long getConstantInfoNumber(ConstantInfo constantInfo) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<ConstantInfo> list = new ArrayList<ConstantInfo>();
			if(constantInfo== null){
				Query query = session.createQuery("select count(*) from ConstantInfo as ConstantInfo ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			constantID_s = constantInfo.getConstantID_s();
			constantName_s = constantInfo.getConstantName_s();
			constantDescribe_s = constantInfo.getConstantDescribe_s();
			constantValues_s = constantInfo.getConstantValues_s();
			 
			createDate_t = constantInfo.getCreateDate_t();
			createUser_s = constantInfo.getCreateUser_s();
			lastUpdateUser_s =constantInfo.getLastUpdateUser_s();
			lastUpdateDate_t = constantInfo.getLastUpdateDate_t();
			resaveds1_s = constantInfo.getResaveds1_s();
			resaveds2_s = constantInfo.getResaveds2_s();
			resaveds3_s = constantInfo.getResaveds3_s();
			resaveds4_s = constantInfo.getResaveds4_s();
			resaveds5_s = constantInfo.getResaveds5_s();
		 
			String hql = "select count(*) from ConstantInfo as constantInfo where 1=1 ";
			String condition="";
			if(constantID_s != null && !constantID_s.trim().equals("")){
		    	condition = condition + " and constantInfo.constantID_s like '%" +  constantID_s.trim() + "%'";
		    	Query query = session.createQuery(hql+condition);
		    	if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}		    
		    }
			if(constantName_s != null ){
		    	condition = condition + " and constantInfo.constantName_s like '%" + constantName_s.trim() + "%'";
		    }
			if(constantDescribe_s != null ){
		    	condition = condition + " and  constantInfo.constantDescribe_s  like '%" + constantDescribe_s + "%'";
		    }
			if(constantValues_s!= null ){
		    	condition = condition + " and constantInfo.constantValues_s  ='" + constantValues_s  + "'";
		    }
			 
//		    if(roadID_s != null && !roadID_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.roadID_s like '%" + roadID_s.trim() + "%'";
//		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(constantInfo.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and constantInfo.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and constantInfo.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(constantInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and constantInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and ConstantInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		   
	//	    condition = condition+" order by constantInfo.constantID_s ";
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

	public int OperationConstantInfo(List<ConstantInfo> constantInfo, int operation)
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
				ConstantInfo tmp = new ConstantInfo();
				boolean b1 = false; //没有修改入口道路
				boolean b2 = false; //没有修改出口道路
				if(constantInfo!=null||constantInfo.size()>0){
					for(int i=0;i<constantInfo.size();i++){		
						tmp = constantInfo.get(i);
						if(constantInfo.get(i).getConstantID_s()== null || constantInfo.get(i).getConstantID_s().trim().equals(""))
						{
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.CLBusiness, session);
							tmp.setConstantID_s(cpg);
							session.saveOrUpdate(tmp);
						}
						else
						{
							ConstantInfo rc = (ConstantInfo)session.get(ConstantInfo.class, constantInfo.get(i).getConstantID_s());							 
							
							constantID_s  = tmp.getConstantID_s();
							constantName_s = tmp.getConstantName_s();
							constantDescribe_s = tmp.getConstantDescribe_s();
							constantValues_s = tmp.getConstantValues_s();							
							createDate_t = tmp.getCreateDate_t();
							createUser_s = tmp.getCreateUser_s();
							lastUpdateUser_s =tmp.getLastUpdateUser_s();
							lastUpdateDate_t = tmp.getLastUpdateDate_t();
							resaveds1_s = tmp.getResaveds1_s();
							resaveds2_s = tmp.getResaveds2_s();
							resaveds3_s = tmp.getResaveds3_s();
							resaveds4_s = tmp.getResaveds4_s();
							resaveds5_s = tmp.getResaveds5_s();
							 
							/*outroadinfo = gate.getOutroadinfo();
							enterroadinfo = gate.getEnterroadinfo();
							
							if(outroadinfo==null)
							{
								gate.setOutroadinfo(outroadinfo);
							}
							if(enterroadinfo==null){
								gate.setEnterroadinfo(enterroadinfo);
							}*/
							if(constantID_s == null){
								tmp.setConstantID_s(rc.getConstantID_s());
							}
							if(constantName_s == null){
								tmp.setConstantName_s(rc.getConstantName_s());
							}
							if(constantDescribe_s  == null){
								tmp.setConstantValues_s(rc.getConstantValues_s());
							}
							if(constantValues_s == null){
								tmp.setConstantValues_s(rc.getConstantValues_s());
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
							session.merge(tmp);
							
						}
						session.flush();
					  //  session.clear();
					}
				}
			}
			//删除
			if(operation==2){
				if(constantInfo!=null&&constantInfo.size()>0){
					for(int i=0;i<constantInfo.size();i++){
						session.delete(constantInfo.get(i));
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
