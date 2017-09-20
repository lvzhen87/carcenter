package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IUnsubscribeRuleService;
import com.freshen.entity.basis.UnsubscribeRule;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class UnsubscribeRuleServiceImpl extends ClimsServiceBase implements IUnsubscribeRuleService {

	
	String eventNumber_s;
	Integer greaterHourNumber_i;
	Integer lessHourNumber_i;
	Integer breakPromiseDeduction_i;
	Integer isEffect;
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
	
	
	public ArrayList<UnsubscribeRule> getUnsubscribeRule(
			UnsubscribeRule unsubscribeRule, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			List<UnsubscribeRule> list = new ArrayList<UnsubscribeRule>();
			
			if(unsubscribeRule == null){
				Query query = session.createQuery("from UnsubscribeRule as unsubscribeRule");
				 if(start != ConstantUtil.pagingNot){
					    query.setFirstResult(start);
					    query.setMaxResults(size);
				    }
				    list = query.list();
				    return (ArrayList<UnsubscribeRule>) list;	
			}
			
			eventNumber_s = unsubscribeRule.getEventNumber_s();
			greaterHourNumber_i = unsubscribeRule.getGreaterHourNumber_i();
			lessHourNumber_i = unsubscribeRule.getLessHourNumber_i();
			breakPromiseDeduction_i = unsubscribeRule.getBreakPromiseDeduction_i();
			isEffect = unsubscribeRule.getIsEffect();
			createDate_t = unsubscribeRule.getCreateDate_t();
			createUser_s = unsubscribeRule.getCreateUser_s();
			lastUpdateUser_s = unsubscribeRule.getLastUpdateUser_s();
			lastUpdateDate_t = unsubscribeRule.getLastUpdateDate_t();
			resaveds1_s = unsubscribeRule.getResaveds1_s();
			resaveds2_s = unsubscribeRule.getResaveds2_s();
			resaveds3_s = unsubscribeRule.getResaveds3_s();
			resaveds4_s = unsubscribeRule.getResaveds4_s();
			resaveds5_s = unsubscribeRule.getResaveds5_s();
			String hql="from UnsubscribeRule as unsubscribeRule where 1=1 "; 
		    String condition = "";
						
			 if(eventNumber_s != null && !eventNumber_s.trim().equals("")){
			    	condition = condition + " and unsubscribeRule.eventNumber_s like '%" + eventNumber_s + "%'";
			 }
			 if(greaterHourNumber_i != null){
			    	condition = condition + " and unsubscribeRule.greaterHourNumber_i <= '" + greaterHourNumber_i + "'";
			}
			 if(lessHourNumber_i != null){
			    	condition = condition + " and  unsubscribeRule.lessHourNumber_i >'" + lessHourNumber_i + "' ";
			}
			 if(breakPromiseDeduction_i != null && breakPromiseDeduction_i != -1){
			    	condition = condition + " and unsubscribeRule.breakPromiseDeduction_i = '" + breakPromiseDeduction_i + "'";
			}
			 if(isEffect != null && isEffect != -1){
			    	condition = condition + " and unsubscribeRule.isEffect = '" + isEffect + "'";
			}
		   
		    if(createDate_t != null){
		    	condition = condition + " and to_char(unsubscribeRule.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition + " and to_char(unsubscribeRule.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.createUser_s like '%" + createUser_s + "%'";
		    }
		    if(lastUpdateUser_s != null && lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.lastUpdateUser_s like '%" + lastUpdateUser_s + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds1_s like '%" + resaveds1_s + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds2_s like '%" + resaveds2_s + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds3_s like '%" + resaveds3_s + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds4_s like '%" + resaveds4_s + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds5_s like '%" + resaveds5_s + "%'";
		    }
		    condition = condition +" order by unsubscribeRule.lastUpdateDate_t DESC";
		    Query query = session.createQuery(hql + condition);
		    if(start != ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();
		    return (ArrayList<UnsubscribeRule>) list;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

	public long getUnsubscribeRule(UnsubscribeRule unsubscribeRule)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long  n = 0;
		try{
			List<UnsubscribeRule> list = new ArrayList<UnsubscribeRule>();
			
			if(unsubscribeRule == null){
				Query query = session.createQuery("select count(*) from UnsubscribeRule");
				if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			
			eventNumber_s = unsubscribeRule.getEventNumber_s();
			greaterHourNumber_i = unsubscribeRule.getGreaterHourNumber_i();
			lessHourNumber_i = unsubscribeRule.getLessHourNumber_i();
			breakPromiseDeduction_i = unsubscribeRule.getBreakPromiseDeduction_i();
			isEffect = unsubscribeRule.getIsEffect();
			createDate_t = unsubscribeRule.getCreateDate_t();
			createUser_s = unsubscribeRule.getCreateUser_s();
			lastUpdateUser_s = unsubscribeRule.getLastUpdateUser_s();
			lastUpdateDate_t = unsubscribeRule.getLastUpdateDate_t();
			resaveds1_s = unsubscribeRule.getResaveds1_s();
			resaveds2_s = unsubscribeRule.getResaveds2_s();
			resaveds3_s = unsubscribeRule.getResaveds3_s();
			resaveds4_s = unsubscribeRule.getResaveds4_s();
			resaveds5_s = unsubscribeRule.getResaveds5_s();
			String hql="select count(*) from UnsubscribeRule as unsubscribeRule where 1=1 "; 
		    String condition = "";
						
			 if(eventNumber_s != null && !eventNumber_s.trim().equals("")){
			    	condition = condition + " and unsubscribeRule.eventNumber_s like '%" + eventNumber_s + "%'";
			 }
			 if(greaterHourNumber_i != null){
			    	condition = condition + " and unsubscribeRule.greaterHourNumber_i = '" + greaterHourNumber_i + "'";
			}
			 if(lessHourNumber_i != null){
			    	condition = condition + " and unsubscribeRule.lessHourNumber_i = '" + lessHourNumber_i + "'";
			}
			 if(breakPromiseDeduction_i != null && breakPromiseDeduction_i != -1){
			    	condition = condition + " and unsubscribeRule.breakPromiseDeduction_i = '" + breakPromiseDeduction_i + "'";
			}
			 if(isEffect != null && isEffect != -1){
			    	condition = condition + " and unsubscribeRule.isEffect = '" + isEffect + "'";
			}
		   
		    if(createDate_t != null){
		    	condition = condition + " and to_char(unsubscribeRule.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition + " and to_char(unsubscribeRule.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.createUser_s like '%" + createUser_s + "%'";
		    }
		    if(lastUpdateUser_s != null && lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.lastUpdateUser_s like '%" + lastUpdateUser_s + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds1_s like '%" + resaveds1_s + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds2_s like '%" + resaveds2_s + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds3_s like '%" + resaveds3_s + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds4_s like '%" + resaveds4_s + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("")){
		    	condition = condition + " and unsubscribeRule.resaveds5_s like '%" + resaveds5_s + "%'";
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

	public int OperationUnsubscribeRule(List<UnsubscribeRule> list,
			int operation) throws Exception {
		UnsubscribeRule ur = new UnsubscribeRule();
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
							//	驾驶员ID，Sequence自动生成
							ur.setEventNumber_s(pk);
						}
						if(list.get(i).getGreaterHourNumber_i() != null){
							ur.setGreaterHourNumber_i(list.get(i).getGreaterHourNumber_i());
						}
						if(list.get(i).getLessHourNumber_i() != null ){
							ur.setLessHourNumber_i(list.get(i).getLessHourNumber_i());
						}
						if(list.get(i).getBreakPromiseDeduction_i() != null){
							ur.setBreakPromiseDeduction_i(list.get(i).getBreakPromiseDeduction_i());
						}
						if(list.get(i).getIsEffect() != null ){
							ur.setIsEffect(list.get(i).getIsEffect());
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

	/**
	 * 根据相差的时间得到扣减的比例	   
	 * getBreakPromiseDeduction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int getBreakPromiseDeduction(int differHour)throws Exception{
		UnsubscribeRule unsubscribeRule = new UnsubscribeRule();
		unsubscribeRule.setIsEffect(1);
		unsubscribeRule.setGreaterHourNumber_i(differHour);
		unsubscribeRule.setLessHourNumber_i(differHour);
		List<UnsubscribeRule> list = this.getUnsubscribeRule(unsubscribeRule, ConstantUtil.pagingNot, 0);
		if(BasicTools.isnotNull(list)){
			return list.get(0).getBreakPromiseDeduction_i();
		}
		return 0;
	}
	
	public static void main(String[] a){
		UnsubscribeRuleServiceImpl impl = new UnsubscribeRuleServiceImpl();
		try {
			int i = impl.getBreakPromiseDeduction(11);
			//System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
