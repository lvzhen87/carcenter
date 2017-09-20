package com.freshen.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.system.CardCancellationRule;
import com.freshen.system.service.IcardCancellationRule;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class CardCancellationRuleServiceImpl extends ClimsServiceBase  implements IcardCancellationRule {

	
	String eventNumber_s;
	String settime_s ;
	Integer dayseed_i;
	Integer isEffect_i; 
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<CardCancellationRule> getCardCancellationRule(
			CardCancellationRule cardCancellationRule, int start, int size)
			throws Exception {
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<CardCancellationRule> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(cardCancellationRule==null){
//				//System.out.println("执行无条件查询 分页");
				//	执行无条件查询 分页
				Query query=session.createQuery("from CardCancellationRule as cardCancellationRule");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			
			eventNumber_s = cardCancellationRule.getEventNumber_s();
			settime_s  = cardCancellationRule.getSettime_s();
			dayseed_i = cardCancellationRule.getDayseed_i();
			isEffect_i = cardCancellationRule.getIsEffect_i();
			createDate_t = cardCancellationRule.getCreateDate_t();
			createUser_s = cardCancellationRule.getCreateUser_s();
			lastUpdateDate_t = cardCancellationRule.getLastUpdateDate_t();
			lastUpdateUser_s = cardCancellationRule.getLastUpdateUser_s();
			resaveds1_s = cardCancellationRule.getResaveds1_s();
			resaveds2_s = cardCancellationRule.getResaveds2_s();
			resaveds3_s = cardCancellationRule.getResaveds3_s();
			resaveds4_s = cardCancellationRule.getResaveds4_s();
			resaveds5_s = cardCancellationRule.getResaveds5_s();
			
			/*if(customerUserID_s!=null && orderID_s!=null){
				receptionCustomerUser.setCustomerUserID_s(customerUserID_s);
				receptionCustomerUser.setOrderID_s(orderID_s);
				receptionCustomerUser=(ReceptionCustomerUser)session.load(receptionCustomerUser.getClass(), orderID_s);
				list.add(receptionCustomerUser);
		    	return (ArrayList)list;
			}*/
			String hql="from CardCancellationRule as cardCancellationRule where 1=1 "; 
		    String condition = "";
		    if(eventNumber_s!=null && !eventNumber_s.trim().equals("")){
		    	condition = " and cardCancellationRule.eventNumber_s like '%"+eventNumber_s.trim()+"%'";
		    }
		    if(settime_s!=null && !settime_s.trim().equals("")){
		    	condition = condition+" and cardCancellationRule.settime_s like '%"+settime_s.trim()+"%'";
		    }
		    if(isEffect_i!=null){
		    	condition = condition+" and cardCancellationRule.isEffect_i = '"+isEffect_i+"'";
		    }
		    if(dayseed_i!=null){
		    	condition = condition+" and cardCancellationRule.dayseed_i='"+dayseed_i+"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and cardCancellationRule.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(cardCancellationRule.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and cardCancellationRule.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds3_s like '%"+resaveds3_s+"%'";
		    }
		    if(resaveds4_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
		    	query.setFirstResult(start);
		    	query.setMaxResults(size);
		    }
		    list = query.list();
			return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();		 
		}	 
	}

	public long getCardCancellationRule(
			CardCancellationRule cardCancellationRule) throws Exception {
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<CardCancellationRule> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(cardCancellationRule==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("select count(*) from CardCancellationRule as cardCancellationRule");
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    } 
			    return n;
			}
			
			eventNumber_s = cardCancellationRule.getEventNumber_s();
			settime_s  = cardCancellationRule.getSettime_s();
			dayseed_i = cardCancellationRule.getDayseed_i();
			isEffect_i = cardCancellationRule.getIsEffect_i();
			createDate_t = cardCancellationRule.getCreateDate_t();
			createUser_s = cardCancellationRule.getCreateUser_s();
			lastUpdateDate_t = cardCancellationRule.getLastUpdateDate_t();
			lastUpdateUser_s = cardCancellationRule.getLastUpdateUser_s();
			resaveds1_s = cardCancellationRule.getResaveds1_s();
			resaveds2_s = cardCancellationRule.getResaveds2_s();
			resaveds3_s = cardCancellationRule.getResaveds3_s();
			resaveds4_s = cardCancellationRule.getResaveds4_s();
			resaveds5_s = cardCancellationRule.getResaveds5_s();
			
			/*if(customerUserID_s!=null && orderID_s!=null){
				receptionCustomerUser.setCustomerUserID_s(customerUserID_s);
				receptionCustomerUser.setOrderID_s(orderID_s);
				receptionCustomerUser=(ReceptionCustomerUser)session.load(receptionCustomerUser.getClass(), orderID_s);
				list.add(receptionCustomerUser);
		    	return (ArrayList)list;
			}*/
			String hql=" select count(*) from from CardCancellationRule as cardCancellationRule where 1=1 "; 
		    String condition = "";
		    if(eventNumber_s!=null && !eventNumber_s.trim().equals("")){
		    	condition = " and cardCancellationRule.eventNumber_s like '%"+eventNumber_s.trim()+"%'";
		    }
		    if(settime_s!=null && !settime_s.trim().equals("")){
		    	condition = condition+" and cardCancellationRule.settime_s like '%"+settime_s.trim()+"%'";
		    }
		    if(isEffect_i!=null){
		    	condition = condition+" and cardCancellationRule.isEffect_i = '"+isEffect_i+"'";
		    }
		    if(dayseed_i!=null){
		    	condition = condition+" and cardCancellationRule.dayseed_i='"+dayseed_i+"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(receptionCustomerUser.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null){
		    	condition = condition+" and cardCancellationRule.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(cardCancellationRule.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and cardCancellationRule.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    }
		    if(resaveds1_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds1_s like '%"+resaveds1_s+"%'";
		    }
		    if(resaveds2_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds2_s like '%"+resaveds2_s+"%'";
		    }
		    if(resaveds3_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds3_s like '%"+resaveds3_s+"%'";
		    }
		    if(resaveds4_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds4_s like '%"+resaveds4_s+"%'";
		    }
		    if(resaveds5_s!=null){
		    	condition = condition+" and cardCancellationRule.resaveds5_s like '%"+resaveds5_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    } 
		    return n;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();		 
		}	
	}

	public int OperationCardCancellationRule(List cardCancellationRule,
			int operatio) throws Exception {
		try{
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			 
			//新增
			if(operatio==1){
				if(cardCancellationRule!=null||cardCancellationRule.size()>0){
					for(int i=0;i<cardCancellationRule.size();i++){						
						session.saveOrUpdate(cardCancellationRule.get(i));
						session.flush();
					    session.clear();
					}
				}
			}
			//删除
			if(operatio==2){
				if(cardCancellationRule!=null&&cardCancellationRule.size()>0){
					for(int i=0;i<cardCancellationRule.size();i++){
						session.delete(cardCancellationRule.get(i));
					}
				}
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{					 
			session.clear();
		    			 
		}	
	}

}
