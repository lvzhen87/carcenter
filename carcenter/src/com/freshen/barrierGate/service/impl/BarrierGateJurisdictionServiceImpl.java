package com.freshen.barrierGate.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.barrierGate.service.BarrierGateJurisdictionService;

import com.freshen.entity.barrierGate.BarrierGateJurisdiction;
import com.freshen.entity.basis.Employee;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class BarrierGateJurisdictionServiceImpl extends ClimsServiceBase implements
BarrierGateJurisdictionService {
	
	String cordID_s;
	String Jurisdiction_s;
	Date effectiveTime_t;
	Date invalidationTime_t;
	Date editFlagTime_t;
	String eventNumber_s;
	
	Transaction tx = null;
	public ArrayList<BarrierGateJurisdiction> getBarrierGateJurisdictionInfo(
			BarrierGateJurisdiction barrierGateJurisdic, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		ArrayList<BarrierGateJurisdiction> list = new ArrayList();
		try {
			if(barrierGateJurisdic == null)
			{
				Query query = session.createQuery(" from BarrierGateJurisdiction as barrierGateJurisdiction");
				list = (ArrayList)query.list();
				if(start !=-1)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
			 
				return list;
			}
			cordID_s= barrierGateJurisdic.getCardID_s();
			Jurisdiction_s = barrierGateJurisdic.getJurisdiction_s();
			effectiveTime_t = barrierGateJurisdic.getEffectiveTime_t();
			invalidationTime_t = barrierGateJurisdic.getInvalidationTime_t();
			editFlagTime_t = barrierGateJurisdic.getEditFlagTime_t();
			String hql = "  from BarrierGateJurisdiction as barrierGateJurisdiction where 1=1 ";
			String condition = " ";
			if(cordID_s != null && !cordID_s.trim().equals("")){
		    	condition = condition + " and barrierGateJurisdiction.cordID_s like '%" + cordID_s.trim() + "%'";
		    }
		    if(Jurisdiction_s != null && !Jurisdiction_s.trim().equals("")){
		    	condition = condition + " and barrierGateJurisdiction.Jurisdiction_s like '%" + Jurisdiction_s.trim() + "%'";
		    }
		    if(effectiveTime_t != null){
		    	condition = condition + " and to_char(barrierGateJurisdiction.effectiveTime_t,'yyyy-MM-dd')='" + DateUtil.dateToString(effectiveTime_t, "yyyy-MM-dd") +"'";
		    }
		    if(invalidationTime_t != null){
		    	condition = condition + " and to_char(barrierGateJurisdiction.invalidationTime_t,'yyyy-MM-dd')='" + DateUtil.dateToString(invalidationTime_t, "yyyy-MM-dd") +"'";
		    }
		    if(editFlagTime_t != null){
		    	condition = condition+" and to_char(barrierGateJurisdiction.editFlagTime_t,'yyyy-MM-dd')='"+DateUtil.dateToString(editFlagTime_t, "yyyy-MM-dd") +"'";
		    }
		    
		    Query query = session.createQuery(hql + condition);
			list = (ArrayList)query.list();
			if(start != ConstantUtil.pagingNot)

			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		 
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally{
			session.clear();
		}
	}

	public Long getBarrierGateJurisdictionInfo(
			BarrierGateJurisdiction barrierGateJurisdic) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		ArrayList<BarrierGateJurisdiction> list = new ArrayList();
		long n = 0;
		try {
			if(barrierGateJurisdic == null)
			{
				Query query = session.createQuery("select count(*) from BarrierGateJurisdiction as barrierGateJurisdiction");
				if(query.iterate().hasNext())
				{
					n = (Long)query.iterate().next();
					return n;
				}
			}
			cordID_s= barrierGateJurisdic.getCardID_s();
			Jurisdiction_s = barrierGateJurisdic.getJurisdiction_s();
			effectiveTime_t = barrierGateJurisdic.getEffectiveTime_t();
			invalidationTime_t = barrierGateJurisdic.getInvalidationTime_t();
			editFlagTime_t = barrierGateJurisdic.getEditFlagTime_t();
			String hql = " select count(*) from BarrierGateJurisdiction as barrierGateJurisdiction where 1=1 ";
			String condition = " ";
			if(cordID_s != null && !cordID_s.trim().equals("")){
		    	condition = condition + " and barrierGateJurisdiction.cordID_s like '%" + cordID_s.trim() + "%'";
		    }
		    if(Jurisdiction_s != null && !Jurisdiction_s.trim().equals("")){
		    	condition = condition + " and barrierGateJurisdiction.Jurisdiction_s like '%" + Jurisdiction_s.trim() + "%'";
		    }
		    if(effectiveTime_t != null){
		    	condition = condition + " and to_char(barrierGateJurisdiction.effectiveTime_t,'yyyy-MM-dd')='" + DateUtil.dateToString(effectiveTime_t, "yyyy-MM-dd") +"'";
		    }
		    if(invalidationTime_t != null){
		    	condition = condition + " and to_char(barrierGateJurisdiction.invalidationTime_t,'yyyy-MM-dd')='" + DateUtil.dateToString(invalidationTime_t, "yyyy-MM-dd") +"'";
		    }
		    if(editFlagTime_t != null){
		    	condition = condition+" and to_char(barrierGateJurisdiction.editFlagTime_t,'yyyy-MM-dd')='"+DateUtil.dateToString(editFlagTime_t, "yyyy-MM-dd") +"'";
		    }
		    
		    Query query = session.createQuery(hql + condition);
		    if(query.iterate().hasNext())
			{
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

	public List<BarrierGateJurisdiction> OperationBarrierGateJurisdictionold(
			List<BarrierGateJurisdiction> barrierGateJurisdicList, int operation)
			throws Exception {
		Transaction tx = null;
		List<BarrierGateJurisdiction> requesbarrierGateJurisdicList = 
			new ArrayList<BarrierGateJurisdiction>();
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();							
		}
		try{
			if(barrierGateJurisdicList==null||barrierGateJurisdicList.size()==0){
				return null;
			}								
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				for(int i=0;i<barrierGateJurisdicList.size();i++){
					BarrierGateJurisdiction barrierGateJurisdic = barrierGateJurisdicList.get(i);					 
					IsystemSequenceService isystemSequenceService = new SystemSequenceServiceImpl();
					eventNumber_s = isystemSequenceService.getPK(ConstantUtil.BJBusiness, session);
					barrierGateJurisdic.setEventNumber_s(eventNumber_s);
					session.saveOrUpdate(barrierGateJurisdic);
					session.flush();
				
				    requesbarrierGateJurisdicList.add(barrierGateJurisdic);
				}
			}
			//删除
			if(operation==2){
				for(int i=0;i<barrierGateJurisdicList.size();i++){
					BarrierGateJurisdiction barrierGateJurisdic = barrierGateJurisdicList.get(i);
					if(barrierGateJurisdic!=null){
						session.delete(barrierGateJurisdic);
						session.flush();
						
					}
				}
			}
			tx.commit();
			return requesbarrierGateJurisdicList;
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{				
			session.clear();
		}	
	}
	
	public List<BarrierGateJurisdiction> OperationBarrierGateJurisdiction(
			List<BarrierGateJurisdiction> barrierGateJurisdicList, int operation,Session session)
			throws Exception {
		Transaction tx = null;
		List<BarrierGateJurisdiction> requesbarrierGateJurisdicList = 
			new ArrayList<BarrierGateJurisdiction>();
		try{
			if(barrierGateJurisdicList==null||barrierGateJurisdicList.size()==0){
				return null;
			}
			 
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				for(int i=0;i<barrierGateJurisdicList.size();i++){
					BarrierGateJurisdiction barrierGateJurisdic = barrierGateJurisdicList.get(i);					 
					IsystemSequenceService isystemSequenceService = new SystemSequenceServiceImpl();
					eventNumber_s = isystemSequenceService.getPK(ConstantUtil.BJBusiness, session);
					//添加随机数
					int s = BasicTools.getRandom();
					eventNumber_s = eventNumber_s+s;
					barrierGateJurisdic.setEventNumber_s(eventNumber_s);
					session.saveOrUpdate(barrierGateJurisdic);
					session.flush();
				 
				    requesbarrierGateJurisdicList.add(barrierGateJurisdic);
				}
			}
			//删除
			if(operation==2){
				for(int i=0;i<barrierGateJurisdicList.size();i++){
					BarrierGateJurisdiction barrierGateJurisdic = barrierGateJurisdicList.get(i);
					if(barrierGateJurisdic!=null){
						session.delete(barrierGateJurisdic);
						session.flush();
						
					}
				}
			}
			 
			return requesbarrierGateJurisdicList;
		}catch(Exception e){
			e.printStackTrace();
		 
			throw e;
		}finally{				
		    			 
		}	
	}
	/**
	 * 保存sql server中间表数据	   
	 * saveSQLJurisdictionInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveSQLJurisdictionInfo(List<BarrierGateJurisdiction> list,List<String> cancelList) throws Exception{
		if(list==null||list.size()==0){
			return 0;
		}
		Connection sqlcon = DataResource.getConnect(ConstantUtil.BarrierSERVERCONN);
		PreparedStatement prest = null;
		try{
		//获得sql server连接
		sqlcon.setAutoCommit(false);  
		String sql = "INSERT into t_BarrierGate_Jurisdiction(eventNumber_s,cardID_s,jurisdiction_s,effectiveTime_t,invalidationTime_t,editFlagTime_t,isTreatment_i) " +
				"VALUES(?,?,?,?,?,?,?)";
		prest = sqlcon.prepareStatement(sql);  
		for(int i=0;i<list.size();i++){
			BarrierGateJurisdiction tmp = list.get(i);
			//当该车卡在其它订单中有效期大于当前订单有效期，则不能作废该车卡权限 20150609 kxc
			if(cancelList.lastIndexOf(tmp.getCardID_s())!=-1){
				continue;
			}
			prest.setString(1, tmp.getEventNumber_s());
			prest.setString(2, tmp.getCardID_s());
			prest.setString(3, tmp.getJurisdiction_s());
			//使生效时间延迟增加5秒
			Date d = tmp.getEffectiveTime_t();
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(d);
			rightNow.add(Calendar.SECOND, ConstantUtil.EFFECTIVETIMEDEFER);
			prest.setTimestamp(4,new Timestamp(rightNow.getTime().getTime()));
			prest.setTimestamp(5,new Timestamp(tmp.getInvalidationTime_t().getTime()));
			prest.setTimestamp(6,new Timestamp(rightNow.getTime().getTime()));
			prest.setInt(7, 0);
			prest.addBatch();   
		}
		prest.executeBatch();
 
		sqlcon.commit();  
		return 1;
		}catch (Exception e){
			sqlcon.rollback();
			throw new Exception(e);
		}finally{
			try { 
				if (prest != null) prest.close(); 
			}catch(Exception e) {throw new Exception(e);} 
			try { 
				if (sqlcon != null) sqlcon.close(); 
			}
			catch (Exception e){throw new Exception(e);}
		} 		
	}
	
	public static void main(String[] args) throws Exception {
		BarrierGateJurisdictionServiceImpl bg = new BarrierGateJurisdictionServiceImpl();
		BarrierGateJurisdiction b = new BarrierGateJurisdiction();
		ArrayList<BarrierGateJurisdiction> list = new ArrayList();
		list = bg.getBarrierGateJurisdictionInfo(b, 0, 10);
//		//System.out.println(list.size());
		
	}
}
