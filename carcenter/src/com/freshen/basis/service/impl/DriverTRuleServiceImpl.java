package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IDriverTRuleService;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.basis.DriverTrainingRule;
import com.freshen.entity.basis.PreRule;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.HibernateUtil;

public class DriverTRuleServiceImpl extends ClimsServiceBase implements IDriverTRuleService{
	Integer id;
	Integer day_i;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	
	Transaction tx = null;
	
	public DriverTrainingRule getTrainingRule(DriverTrainingRule rule)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try {
			DriverTrainingRule dtr=null;
			if(rule == null){
				Query query = session.createQuery("from DriverTrainingRule");
				List<DriverTrainingRule> drlist=query.list();
				if(null != drlist && drlist.size()>0){
					dtr =drlist.get(0);
				}
			    return (DriverTrainingRule) dtr;	
			}
			return (DriverTrainingRule) dtr;	
		} catch (Exception e) {
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

	public int OperationTrainingRule(DriverTrainingRule dr, int operation)
			throws Exception {
		DriverTrainingRule trainrule=new DriverTrainingRule();
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(dr != null){
				if(operation == 1)
				{
						if(dr.getId() != null ){
							trainrule.setId(dr.getId());
						} else {
							//	ID，Sequence自动生成
							trainrule.setId(1);
						}
						if(dr.getDay_i() != null){
							trainrule.setDay_i(dr.getDay_i());
						}
						if(dr.getCreateUser_s() != null && !dr.getCreateUser_s().trim().equals("")){
							trainrule.setCreateUser_s(dr.getCreateUser_s());
						}
						if(dr.getCreateDate_t() != null){
							trainrule.setCreateDate_t(dr.getCreateDate_t());
						}
						if(dr.getLastUpdateUser_s() != null && !dr.getLastUpdateUser_s().trim().equals("")){
							trainrule.setLastUpdateUser_s(dr.getLastUpdateUser_s());
						}
						if(dr.getLastUpdateDate_t() != null){
							trainrule.setLastUpdateDate_t(dr.getLastUpdateDate_t());
						}
					session.saveOrUpdate(trainrule);	
						
				}
				if(operation == 2)
				{
					session.delete(dr);
					session.flush();
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
