package com.freshen.groundcontrol.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.groundcontrol.FacilityState;
import com.freshen.groundcontrol.service.IfacilityStatelService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class FacilityStateSerceImpl extends ClimsServiceBase implements IfacilityStatelService {

	String serialNumber_s;
	String facilityID_s, state_s, specialInfo_s;
	Date appointDate_d, createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<FacilityState> getfacilityStatelInfo(
			FacilityState facilityState, int start, int size) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			List<FacilityState> list = new ArrayList<FacilityState>();
			if(facilityState==null ){
				Query query = session.createQuery("from FacilityState as facilityState") ;
				query.setFirstResult(start);
				query.setMaxResults(size);
				list = query.list();
				return (ArrayList<FacilityState>) list;
			}
			serialNumber_s = facilityState.getSerialNumber_s() ;
			facilityID_s = facilityState.getFacilityID_s();
			state_s = facilityState.getState_s();
			specialInfo_s = facilityState.getSpecialInfo_s();
			appointDate_d = facilityState.getAppointDate_d();
			createDate_t = facilityState.getCreateDate_t();
			createUser_s = facilityState.getCreateUser_s();
			lastUpdateUser_s = facilityState.getLastUpdateUser_s();
			lastUpdateDate_t = facilityState.getLastUpdateDate_t();
			resaveds1_s= facilityState.getResaveds1_s();
		    resaveds2_s= facilityState.getResaveds2_s();
		    resaveds3_s= facilityState.getResaveds3_s();
		    resaveds4_s= facilityState.getResaveds4_s();
		    resaveds5_s= facilityState.getResaveds5_s();
		    
		    String hql = "  from FacilityState as facilityState where 1=1 ";
		    String condition = "";
		    if (serialNumber_s!=null && !serialNumber_s.trim().equals("")){
		    	condition = condition + " and facilityState.serialNumber_s like '%" +  serialNumber_s + "%' ";
		    }
		    if (facilityID_s!=null && !facilityID_s.trim().equals("")){
		    	condition = condition + " and facilityState.facilityID_s like '%" + facilityID_s.trim() + "%' " ;
		    }
		    if (state_s!=null && !state_s.trim().equals("")){
		    	condition = condition + " and facilityState.state_s like '%" + state_s.trim() + "%' ";
		    }
		    if (specialInfo_s!=null&& !specialInfo_s.trim().equals("")){
		    	condition = condition + " and facilityState.specialInfo_s like '%" + specialInfo_s.trim() + "%' ";
		    }
		    if(appointDate_d != null){
		    	condition = condition+" and to_char(facilityState.appointDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(appointDate_d, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(facilityState.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if (createUser_s!=null&& !createUser_s.trim().equals("")){
		    	condition = condition + " and facilityState.createUser_s like '%" + createUser_s.trim() + "%' ";
		    }
		    if (lastUpdateUser_s!=null&& !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and facilityState.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%' ";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(facilityState.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if (resaveds1_s!=null&& !resaveds1_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds1_s like '%" + resaveds1_s.trim() + "%' ";
		    }
		    if (resaveds2_s!=null&& !resaveds2_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds2_s like '%" + resaveds2_s.trim() + "%' ";
		    }
		    if (resaveds3_s!=null&& !resaveds3_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds3_s like '%" + resaveds3_s.trim() + "%' ";
		    }
		    if (resaveds4_s!=null&& !resaveds4_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds4_s like '%" + resaveds4_s.trim() + "%' ";
		    }
		    if (resaveds5_s!=null&& !resaveds5_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds5_s like '%" + resaveds5_s.trim() + "%' ";
		    }
		    Query query = session.createQuery(hql+condition);
		    query.setFirstResult(start);
		    query.setMaxResults(size);
		    list = query.list();
		    return (ArrayList)list;
		}catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}

	public long getfacilityStatelInfoNumber(FacilityState facilityState)
			throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<FacilityState> list = new ArrayList<FacilityState>();
			if(facilityState==null ){
				Query query = session.createQuery("select count(*) from FacilityState") ;
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
					return n;
				}
			}
			serialNumber_s = facilityState.getSerialNumber_s() ;
			facilityID_s = facilityState.getFacilityID_s();
			state_s = facilityState.getState_s();
			specialInfo_s = facilityState.getSpecialInfo_s();
			appointDate_d = facilityState.getAppointDate_d();
			createDate_t = facilityState.getCreateDate_t();
			createUser_s = facilityState.getCreateUser_s();
			lastUpdateUser_s = facilityState.getLastUpdateUser_s();
			lastUpdateDate_t = facilityState.getLastUpdateDate_t();
			resaveds1_s= facilityState.getResaveds1_s();
		    resaveds2_s= facilityState.getResaveds2_s();
		    resaveds3_s= facilityState.getResaveds3_s();
		    resaveds4_s= facilityState.getResaveds4_s();
		    resaveds5_s= facilityState.getResaveds5_s();
		    
		    String hql = " select count(*) from FacilityState as facilityState where 1=1 ";
		    String condition = "";
		    if (serialNumber_s!=null && !serialNumber_s.trim().equals("")){
		    	condition = condition + " and facilityState.serialNumber_s like '%" +  serialNumber_s + "%' ";
		    }
		    if (facilityID_s!=null && !facilityID_s.trim().equals("")){
		    	condition = condition + " and facilityState.facilityID_s like '%" + facilityID_s.trim() + "%' " ;
		    }
		    if (state_s!=null && !state_s.trim().equals("")){
		    	condition = condition + " and facilityState.state_s like '%" + state_s.trim() + "%' ";
		    }
		    if (specialInfo_s!=null&& !specialInfo_s.trim().equals("")){
		    	condition = condition + " and facilityState.specialInfo_s like '%" + specialInfo_s.trim() + "%' ";
		    }
		    if(appointDate_d != null){
		    	condition = condition+" and to_char(facilityState.appointDate_d,'yyyy-MM-dd')='"+DateUtil.dateToString(appointDate_d, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(facilityState.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if (createUser_s!=null&& !createUser_s.trim().equals("")){
		    	condition = condition + " and facilityState.createUser_s like '%" + createUser_s.trim() + "%' ";
		    }
		    if (lastUpdateUser_s!=null&& !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and facilityState.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%' ";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(facilityState.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if (resaveds1_s!=null&& !resaveds1_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds1_s like '%" + resaveds1_s.trim() + "%' ";
		    }
		    if (resaveds2_s!=null&& !resaveds2_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds2_s like '%" + resaveds2_s.trim() + "%' ";
		    }
		    if (resaveds3_s!=null&& !resaveds3_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds3_s like '%" + resaveds3_s.trim() + "%' ";
		    }
		    if (resaveds4_s!=null&& !resaveds4_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds4_s like '%" + resaveds4_s.trim() + "%' ";
		    }
		    if (resaveds5_s!=null&& !resaveds5_s.trim().equals("")){
		    	condition = condition + " and facilityState.resaveds5_s like '%" + resaveds5_s.trim() + "%' ";
		    }
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n =(Long)query.iterate().next();
		    }
		    return n;
		}catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}

	public int OperationfacilityStatelInfo(List<FacilityState> facilityState,
			int operation) throws Exception {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try{
			Session session= HibernateUtil.getSession();
			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				if(facilityState!=null&&facilityState.size()>0){
					for(int i=0;i<facilityState.size();i++){	
						if(facilityState.get(i)==null){
							return 0 ;
						}else{
							FacilityState fs = facilityState.get(i);
							FacilityState tmp = new FacilityState();
							if(fs.getSerialNumber_s()== null || fs.getSerialNumber_s().trim().equals("")){
								String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.SBZYBusiness, session);
								fs.setSerialNumber_s(cpg);
								session.merge(fs);
								session.flush();
							    session.clear();
							    tx.commit();
								return 1;
							}
							serialNumber_s = fs.getSerialNumber_s() ;
							facilityID_s = fs.getFacilityID_s();
							state_s = fs.getState_s();
							specialInfo_s = fs.getSpecialInfo_s();
							appointDate_d = fs.getAppointDate_d();
							createDate_t = fs.getCreateDate_t();
							createUser_s = fs.getCreateUser_s();
							lastUpdateUser_s = fs.getLastUpdateUser_s();
							lastUpdateDate_t = fs.getLastUpdateDate_t();
							resaveds1_s= fs.getResaveds1_s();
						    resaveds2_s= fs.getResaveds2_s();
						    resaveds3_s= fs.getResaveds3_s();
						    resaveds4_s= fs.getResaveds4_s();
						    resaveds5_s= fs.getResaveds5_s();
							
						    if(serialNumber_s == null){
						    	fs.setSerialNumber_s(tmp.getSerialNumber_s());
						    }
						    if(facilityID_s == null){
						    	fs.setFacilityID_s(tmp.getFacilityID_s());
						    }
						    if(state_s == null){
						    	fs.setState_s(tmp.getState_s());
						    }
						    if(specialInfo_s == null){
						    	fs.setSpecialInfo_s(tmp.getSpecialInfo_s());
						    }
						    if(appointDate_d == null){
						    	fs.setAppointDate_d(tmp.getAppointDate_d());
						    }
						    if(createDate_t == null){
						    	fs.setCreateDate_t(tmp.getCreateDate_t());
						    }
						    if(createUser_s == null){
						    	fs.setCreateUser_s(tmp.getCreateUser_s());
						    }
						    if(lastUpdateUser_s == null){
						    	fs.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
						    }
						    if(lastUpdateDate_t == null){
						    	fs.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
						    }
						    if(resaveds1_s == null){
						    	fs.setResaveds1_s(tmp.getResaveds1_s());
						    }
						    if(resaveds2_s == null){
						    	fs.setResaveds2_s(tmp.getResaveds2_s());
						    }
						    if(resaveds3_s == null){
						    	fs.setResaveds3_s(tmp.getResaveds3_s());
						    }
						    if(resaveds4_s == null){
						    	fs.setResaveds4_s(tmp.getResaveds4_s());
						    }
						    if(resaveds5_s == null){
						    	fs.setResaveds5_s(tmp.getResaveds5_s());
						    }
						    
						    session.merge(fs);
						}
						
					}
					session.flush();
				    session.clear();
				}
			}
			//删除
			if(operation==2){
				if(facilityState!=null&&facilityState.size()>0){
					for(int i=0;i<facilityState.size();i++){
						session.delete(facilityState.get(i));
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
		    			 
		}	
	}
	
	public static void main(String arg[]) throws Exception{
		
	}
}
