package com.freshen.passageway.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.basis.Driver;
import com.freshen.passageway.entity.PassageWay;
import com.freshen.passageway.service.IPassageWayService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class PassageWayServiceimpl extends ClimsServiceBase implements IPassageWayService {

	Integer id;
	Integer passageWayId;
	String name;
	Integer inout;
	Integer usedFlag;
	Date editFlagtime_t;
	Integer istreament_i;
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<PassageWay> getBasisPassageWayInfo(PassageWay passageWay,
			int start, int size) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try {
			List<PassageWay> list = new ArrayList();
			
			if(passageWay == null){
				Query query=session.createQuery("from PassageWay as passageWay");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			
			id = passageWay.getId();
			passageWayId = passageWay.getPassageWayId();
			name = passageWay.getName();
			inout  =passageWay.getInout();
			usedFlag = passageWay.getUsedFlag();
			editFlagtime_t = passageWay.getEditFlagtime_t();
			istreament_i = passageWay.getIstreament_i();
			
			String hql = " from PassageWay as passageWay where 1=1 ";
		    String condition = "";
		    
		    if(id != null )
		    {
		    	condition += " and passageWay.id = '" + id + "'";
		    }
		    if(passageWayId != null )
		    {
		    	condition += " and passageWay.passageWayId = '" + passageWayId + "'";
		    }
		    if(name != null && name.trim().equals("") )
		    {
		    	condition += " and passageWay.name like '%" + name.trim() + "%'";
		    }
		    if(inout != null )
		    {
		    	condition += " and passageWay.inout = '" + inout + "'";
		    }
		    if(usedFlag != null )
		    {
		    	condition += " and passageWay.usedFlag = '" + usedFlag + "'";
		    }
		    if(editFlagtime_t != null )
		    {
		    	condition = condition + " and to_char(passageWay.editFlagtime_t,'yyyy-MM-dd')='" + DateUtil.dateToString(editFlagtime_t, "yyyy-MM-dd") +"'";
		    }
			
		    Query query=session.createQuery(hql+condition);
			if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();	  			
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}

	}

	public long getBasisPassageWayInfoNumber(PassageWay passageWay)
			throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<PassageWay> list = new ArrayList();
			
			if(passageWay == null){
				Query query=session.createQuery("select count(*) from PassageWay as passageWay");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }    
				    return n;
			}
			
			id = passageWay.getId();
			passageWayId = passageWay.getPassageWayId();
			name = passageWay.getName();
			inout  =passageWay.getInout();
			usedFlag = passageWay.getUsedFlag();
			editFlagtime_t = passageWay.getEditFlagtime_t();
			istreament_i = passageWay.getIstreament_i();
			
			String hql = "select count(*)  from PassageWay as passageWay where 1=1 ";
		    String condition = "";
		    
		    if(id != null )
		    {
		    	condition += " and passageWay.id = '" + id + "'";
		    }
		    if(passageWayId != null )
		    {
		    	condition += " and passageWay.passageWayId = '" + passageWayId + "'";
		    }
		    if(name != null && name.trim().equals("") )
		    {
		    	condition += " and passageWay.name like '%" + name.trim() + "%'";
		    }
		    if(inout != null )
		    {
		    	condition += " and passageWay.inout = '" + inout + "'";
		    }
		    if(usedFlag != null )
		    {
		    	condition += " and passageWay.usedFlag = '" + usedFlag + "'";
		    }
		    if(editFlagtime_t != null )
		    {
		    	condition = condition + " and to_char(passageWay.editFlagtime_t,'yyyy-MM-dd')='" + DateUtil.dateToString(editFlagtime_t, "yyyy-MM-dd") +"'";
		    }
			
		    Query query=session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }    
		    return n;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}

	}

	public int UpdateBasisPassageWayInfo(List<PassageWay> list) throws Exception {
		Driver driver = new Driver();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					
					if(list.get(i).getId() != null && !list.get(i).getId().equals("")){
						session.update(driver);
						tx.commit();
					}
					//System.out.println("===="+driver.toString());
					session.saveOrUpdate(driver);
					tx.commit();
				}
								
			}else{
				throw new Exception("驾驶员信息不正确");
			}		
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

}
