package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.ITimeRuleService;
import com.freshen.entity.TimeRule;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class TimeRuleServiceImpl extends ClimsServiceBase implements ITimeRuleService {

	String timeQuantum_s;
	Date createDate_t;
	String createUser_s;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<TimeRule> getTimeRule(TimeRule timeRule, int start,
			int size) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			List<TimeRule> list = new ArrayList<TimeRule>();
			
			if(timeRule == null){
				Query query = session.createQuery("from TimeRule as timeRule");
				 if(start != ConstantUtil.pagingNot){
					    query.setFirstResult(start);
					    query.setMaxResults(size);
				    }
				    list = query.list();
				    return (ArrayList<TimeRule>) list;	
			}
			
			timeQuantum_s = timeRule.getTimeQuantum_s();
			createDate_t = timeRule.getCreateDate_t();
			createUser_s = timeRule.getCreateUser_s();
			resaveds1_s = timeRule.getResaveds1_s();
			resaveds2_s = timeRule.getResaveds2_s();
			resaveds3_s = timeRule.getResaveds3_s();
			resaveds4_s = timeRule.getResaveds4_s();
			resaveds5_s = timeRule.getResaveds5_s();
			String hql="from TimeRule as timeRule where 1=1 "; 
		    String condition = "";
						
			 if(timeQuantum_s != null && !timeQuantum_s.trim().equals("")){
			    	condition = condition + " and timeRule.eventNumber_s like '%" + timeQuantum_s + "%'";
			 }
		   
		    if(createDate_t != null){
		    	condition = condition + " and to_char(unsubscribeRule.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("")){
		    	condition = condition + " and timeRule.createUser_s like '%" + createUser_s + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds1_s like '%" + resaveds1_s + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds2_s like '%" + resaveds2_s + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds3_s like '%" + resaveds3_s + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds4_s like '%" + resaveds4_s + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds5_s like '%" + resaveds5_s + "%'";
		    }
		    Query query = session.createQuery(hql + condition);
		    if(start != ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();
		    return (ArrayList<TimeRule>) list;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

	public long getTimeRule(TimeRule timeRule) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<TimeRule> list = new ArrayList<TimeRule>();
			
			if(timeRule == null){
				Query query = session.createQuery("from UnsubscribeRule as unsubscribeRule");
				if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;	
			}
			
			timeQuantum_s = timeRule.getTimeQuantum_s();
			createDate_t = timeRule.getCreateDate_t();
			createUser_s = timeRule.getCreateUser_s();
			resaveds1_s = timeRule.getResaveds1_s();
			resaveds2_s = timeRule.getResaveds2_s();
			resaveds3_s = timeRule.getResaveds3_s();
			resaveds4_s = timeRule.getResaveds4_s();
			resaveds5_s = timeRule.getResaveds5_s();
			String hql="from TimeRule as timeRule where 1=1 "; 
		    String condition = "";
						
			 if(timeQuantum_s != null && !timeQuantum_s.trim().equals("")){
			    	condition = condition + " and timeRule.eventNumber_s like '%" + timeQuantum_s + "%'";
			 }
		   
		    if(createDate_t != null){
		    	condition = condition + " and to_char(unsubscribeRule.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("")){
		    	condition = condition + " and timeRule.createUser_s like '%" + createUser_s + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds1_s like '%" + resaveds1_s + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds2_s like '%" + resaveds2_s + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds3_s like '%" + resaveds3_s + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds4_s like '%" + resaveds4_s + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("")){
		    	condition = condition + " and timeRule.resaveds5_s like '%" + resaveds5_s + "%'";
		    }
		    Query query = session.createQuery(hql + condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }    
		    return n;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

	public int OperationTimeRule(List<TimeRule> list, int operation)
			throws Exception {
		Session session = HibernateUtil.getSession();
		TimeRule tr = new TimeRule();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				if(operation == 1)
				{
					for(int i = 0; i < list.size(); i++){
//						if(list.get(i).getTimeQuantum_s() != null && !list.get(i).getTimeQuantum_s().trim().equals("")){
//							tr.setTimeQuantum_s(list.get(i).getTimeQuantum_s().trim());
//						} else {
//							IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
//							String pk = systemSequenceServiceImpl.getPK(ConstantUtil.TimeBusiness, session);
//							//	驾驶员ID，Sequence自动生成
//							tr.setTimeQuantum_s(pk);
//						}
						tr.setResaveds1_s("TR001");
						
						if(list.get(i).getTimeQuantum_s() != null && !list.get(i).getTimeQuantum_s().trim().equals("")){
							tr.setTimeQuantum_s(list.get(i).getTimeQuantum_s());
						}
						if(list.get(i).getCreateUser_s() != null && !list.get(i).getCreateUser_s().trim().equals("")){
							tr.setCreateUser_s(list.get(i).getCreateUser_s());
						}
						if(list.get(i).getCreateDate_t() != null){
							tr.setCreateDate_t(list.get(i).getCreateDate_t());
						}
						if(list.get(i).getResaveds1_s() != null){
							tr.setResaveds1_s(list.get(i).getResaveds1_s());
						}
						if(list.get(i).getResaveds2_s() != null){
							tr.setResaveds2_s(list.get(i).getResaveds2_s());
						}
						if(list.get(i).getResaveds3_s() != null){
							tr.setResaveds3_s(list.get(i).getResaveds3_s());
						}
						if(list.get(i).getResaveds4_s() != null){
							tr.setResaveds2_s(list.get(i).getResaveds4_s());
						}
						if(list.get(i).getResaveds5_s() != null){
							tr.setResaveds5_s(list.get(i).getResaveds5_s());
						}
					}
					session.saveOrUpdate(tr);
				}
				else{
					throw new Exception("驾驶员信息不正确");
				}			
			}
			if(operation == 2)
			{
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						session.delete(list.get(i));
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

}
