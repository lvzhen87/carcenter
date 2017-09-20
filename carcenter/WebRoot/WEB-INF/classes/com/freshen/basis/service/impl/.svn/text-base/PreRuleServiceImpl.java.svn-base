package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IpreRuleService;
import com.freshen.entity.basis.PreRule;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class PreRuleServiceImpl extends ClimsServiceBase implements IpreRuleService {

	
	String eventNumber_s;
	Integer dayNumber_i;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	
	
	Transaction tx = null;
	
	public ArrayList<PreRule> getUnsubscribeRule(PreRule preRule, int start,
			int size) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			List<PreRule> list = new ArrayList<PreRule>();
			
			Query query = session.createQuery("from PreRule as preRule");
			 if(start != ConstantUtil.pagingNot){
				    query.setFirstResult(start);
				    query.setMaxResults(size);
			    }
			    list = query.list();
			    return (ArrayList<PreRule>) list;	
			
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

	public int OperationUnsubscribeRule(List<PreRule> list, int operation)
			throws Exception {
		PreRule ur = new PreRule();
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				if(operation == 1)
				{
					for(int i = 0; i < list.size(); i++){
						if(list.get(i).getEventNumber_s() != null && !list.get(i).getEventNumber_s().trim().equals("")){
							ur.setEventNumber_s(list.get(i).getEventNumber_s().trim());
						} else {
							IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
							String pk = systemSequenceServiceImpl.getPK(ConstantUtil.UnSubscibeBusiness, session);
							//	ID，Sequence自动生成
							ur.setEventNumber_s(pk);
						}
						if(list.get(i).getDayNumber_i() != null){
							ur.setDayNumber_i(list.get(i).getDayNumber_i());
						}
						if(list.get(i).getCreateUser_s() != null && !list.get(i).getCreateUser_s().trim().equals("")){
							ur.setCreateUser_s(list.get(i).getCreateUser_s());
						}
						if(list.get(i).getCreateDate_t() != null){
							ur.setCreateDate_t(list.get(i).getCreateDate_t());
						}
						if(list.get(i).getLastUpdateUser_s() != null && !list.get(i).getLastUpdateUser_s().trim().equals("")){
							ur.setLastUpdateUser_s(list.get(i).getLastUpdateUser_s());
						}
						if(list.get(i).getLastUpdateDate_t() != null){
							ur.setLastUpdateDate_t(list.get(i).getLastUpdateDate_t());
						}
						
						if(list.get(i).getResaveds1_s() != null){
							ur.setResaveds1_s(list.get(i).getResaveds1_s());
						}
						if(list.get(i).getResaveds2_s() != null){
							ur.setResaveds2_s(list.get(i).getResaveds2_s());
						}
						if(list.get(i).getResaveds3_s() != null){
							ur.setResaveds3_s(list.get(i).getResaveds3_s());
						}
						if(list.get(i).getResaveds4_s() != null){
							ur.setResaveds2_s(list.get(i).getResaveds4_s());
						}
						if(list.get(i).getResaveds5_s() != null){
							ur.setResaveds5_s(list.get(i).getResaveds5_s());
						}
					}
					session.saveOrUpdate(ur);
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
			}
			
			else{
				throw new Exception("信息不正确");
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
