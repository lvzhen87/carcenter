package com.freshen.cost.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadCostService;
import com.freshen.basis.service.impl.RoadCostServiceImpl;
import com.freshen.cost.service.IOrderRoadCostBasisService;
import com.freshen.entity.basis.RoadCost;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.cost.TCostOrderothercost;
import com.freshen.entity.cost.TCostOrderroadcostbasis;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.clims.baseclass.ServiceImpl;

public class OrderRoadCostBasisServiceImpl extends ClimsServiceBase implements
		IOrderRoadCostBasisService {


	Date createDate_t;
	String createUser_s;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s; 
	String resaveds4_s; 
	String resaveds5_s;
	private String roadidS;
	private String orderidS;
	private Double unitprieI;
	private String remarkS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private Double overproofunitprieI;
	private Double wholeunitprieI;
	private Double wholeoverproofunitprieI;
	Integer minuteUnitPrie_i ;
	Double coefficient_i;
	Double activityUnitPrie_i;
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<TCostOrderroadcostbasis> getTCostOrderroadcostbasis(
			TCostOrderroadcostbasis tCostOrderroadcostbasis, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<TCostOrderroadcostbasis> list = new ArrayList<TCostOrderroadcostbasis>();
			if(tCostOrderroadcostbasis== null){
				Query query = session.createQuery("from TCostOrderroadcostbasis as tCostOrderroadcostbasis ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			unitprieI = tCostOrderroadcostbasis.getUnitprieI();
			remarkS = tCostOrderroadcostbasis.getRemarkS();
			lastupdateuserS = tCostOrderroadcostbasis.getLastupdateuserS();
			lastupdatedateT = tCostOrderroadcostbasis.getLastupdatedateT();
			overproofunitprieI = tCostOrderroadcostbasis.getOverproofunitprieI();
			wholeunitprieI = tCostOrderroadcostbasis.getWholeunitprieI();
			wholeoverproofunitprieI = tCostOrderroadcostbasis.getWholeoverproofunitprieI();
			orderidS = tCostOrderroadcostbasis.getOrderidS();
			roadidS = tCostOrderroadcostbasis.getRoadidS();
			
			createDate_t = tCostOrderroadcostbasis.getCreateDate_t();
			createUser_s = tCostOrderroadcostbasis.getCreateUser_s();
			resaveds1_s = tCostOrderroadcostbasis.getResaveds1_s();
			resaveds2_s = tCostOrderroadcostbasis.getResaveds2_s();
			resaveds3_s = tCostOrderroadcostbasis.getResaveds3_s();
			resaveds4_s = tCostOrderroadcostbasis.getResaveds4_s();
			resaveds5_s = tCostOrderroadcostbasis.getResaveds5_s();
			minuteUnitPrie_i =  tCostOrderroadcostbasis.getMinuteUnitPrie_i();
			coefficient_i = tCostOrderroadcostbasis.getCoefficient_i();
			activityUnitPrie_i = tCostOrderroadcostbasis.getActivityUnitPrie_i();
			String hql = " from TCostOrderroadcostbasis as tCostOrderroadcostbasis where 1=1 ";
			String condition="";
			
			if(minuteUnitPrie_i != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.minuteUnitPrie_i ='" + minuteUnitPrie_i+ "'";
		    }
			if(coefficient_i != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.coefficient_i ='" + coefficient_i+ "'";
		    }
			if(activityUnitPrie_i != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.activityUnitPrie_i ='" + activityUnitPrie_i+ "'";
		    }
			if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.orderidS like '%" + orderidS.trim() + "%'";
		    }
			if(remarkS != null && !remarkS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.remarkS like '%" + remarkS.trim() + "%'";
		    }
			if(lastupdateuserS != null && !lastupdateuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.lastupdateuserS like '%" + lastupdateuserS.trim() + "%'";
		    }
			if(roadidS != null && !roadidS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.roadidS like '%" + roadidS.trim() + "%'";
		    }
		    
			 if(unitprieI != null ){
			    	condition = condition + " and tCostOrderroadcostbasis.unitprieI ='" + unitprieI+ "'";
			    }
			 if(overproofunitprieI != null ){
			    	condition = condition + " and tCostOrderroadcostbasis.overproofunitprieI ='" + overproofunitprieI+ "'";
			    }
		    if(wholeunitprieI != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.wholeunitprieI ='" + wholeunitprieI+ "'";
		    }
		    if(wholeoverproofunitprieI != null && wholeoverproofunitprieI != -1){
		    	condition = condition + " and tCostOrderroadcostbasis.wholeoverproofunitprieI ='" + wholeoverproofunitprieI+ "'";
		    }
		    if(lastupdatedateT != null){
		    	condition = condition+" and to_char(tCostOrderroadcostbasis.lastupdatedateT,'yyyy-MM-dd')='"+DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderroadcostbasis.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderroadcostbasis.createDate_t desc";
		    Query query = session.createQuery(hql+condition);
		    if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
		    
		    return (ArrayList)list;
		    
		}
		catch(Exception e){
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public long getTCostOrderroadcostbasis(
			TCostOrderroadcostbasis tCostOrderroadcostbasis) throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<TCostOrderothercost> list = new ArrayList<TCostOrderothercost>();
			if(tCostOrderroadcostbasis== null){
				Query query = session.createQuery("from TCostOrderroadcostbasis as tCostOrderroadcostbasis ");
				 if(query.iterate().hasNext()){
				    	n = (Long) query.iterate().next();
				    }
				    return n;
			}
			unitprieI = tCostOrderroadcostbasis.getUnitprieI();
			remarkS = tCostOrderroadcostbasis.getRemarkS();
			lastupdateuserS = tCostOrderroadcostbasis.getLastupdateuserS();
			lastupdatedateT = tCostOrderroadcostbasis.getLastupdatedateT();
			overproofunitprieI = tCostOrderroadcostbasis.getOverproofunitprieI();
			wholeunitprieI = tCostOrderroadcostbasis.getWholeunitprieI();
			wholeoverproofunitprieI = tCostOrderroadcostbasis.getWholeoverproofunitprieI();
			orderidS = tCostOrderroadcostbasis.getOrderidS();
			roadidS = tCostOrderroadcostbasis.getRoadidS();
			
			createDate_t = tCostOrderroadcostbasis.getCreateDate_t();
			createUser_s = tCostOrderroadcostbasis.getCreateUser_s();
			resaveds1_s = tCostOrderroadcostbasis.getResaveds1_s();
			resaveds2_s = tCostOrderroadcostbasis.getResaveds2_s();
			resaveds3_s = tCostOrderroadcostbasis.getResaveds3_s();
			resaveds4_s = tCostOrderroadcostbasis.getResaveds4_s();
			resaveds5_s = tCostOrderroadcostbasis.getResaveds5_s();
			minuteUnitPrie_i =  tCostOrderroadcostbasis.getMinuteUnitPrie_i();
			coefficient_i = tCostOrderroadcostbasis.getCoefficient_i();
			activityUnitPrie_i = tCostOrderroadcostbasis.getActivityUnitPrie_i();
			String hql = "select count(*) from TCostOrderroadcostbasis as tCostOrderroadcostbasis where 1=1 ";
			String condition="";
			
			if(minuteUnitPrie_i != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.minuteUnitPrie_i ='" + minuteUnitPrie_i+ "'";
		    }
			if(coefficient_i != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.coefficient_i ='" + coefficient_i+ "'";
		    }
			if(activityUnitPrie_i != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.activityUnitPrie_i ='" + activityUnitPrie_i+ "'";
		    }
			if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.orderid_S like '%" + orderidS.trim() + "%'";
		    }
			if(remarkS != null && !remarkS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.remarkS like '%" + remarkS.trim() + "%'";
		    }
			if(lastupdateuserS != null && !lastupdateuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.lastupdateuserS like '%" + lastupdateuserS.trim() + "%'";
		    }
			if(roadidS != null && !roadidS.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.roadid_S like '%" + roadidS.trim() + "%'";
		    }
			 if(unitprieI != null ){
			    	condition = condition + " and tCostOrderroadcostbasis.unitprieI ='" + unitprieI+ "'";
			    }
			 if(overproofunitprieI != null ){
			    	condition = condition + " and tCostOrderroadcostbasis.overproofunitprieI ='" + overproofunitprieI+ "'";
			    }
		    if(wholeunitprieI != null ){
		    	condition = condition + " and tCostOrderroadcostbasis.wholeunitprieI ='" + wholeunitprieI+ "'";
		    }
		    if(wholeoverproofunitprieI != null && wholeoverproofunitprieI != -1){
		    	condition = condition + " and tCostOrderroadcostbasis.wholeoverproofunitprieI ='" + wholeoverproofunitprieI+ "'";
		    }
		    if(lastupdatedateT != null){
		    	condition = condition+" and to_char(tCostOrderroadcostbasis.lastupdatedateT,'yyyy-MM-dd')='"+DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(tCostOrderroadcostbasis.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and tCostOrderroadcostbasis.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		   
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
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

	public int OperationTCostOrderroadcostbasis(
			List<TCostOrderroadcostbasis> tCostOrderroadcostbasis, int operation)
			throws Exception {
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		int r=-1;
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				TCostOrderroadcostbasis gate = new TCostOrderroadcostbasis();
				if(tCostOrderroadcostbasis!=null||tCostOrderroadcostbasis.size()>0){
					for(int i=0;i<tCostOrderroadcostbasis.size();i++){
						gate = tCostOrderroadcostbasis.get(i);					
						List<TCostOrderroadcostbasis> list =null;
						TCostOrderroadcostbasis tmp ;
//								(TCostOrderroadcostbasis)session.get(TCostOrderroadcostbasis.class, tCostOrderroadcostbasis.get(i).getCostRoadID());
						OrderRoadCostBasisServiceImpl ot = new OrderRoadCostBasisServiceImpl();
						TCostOrderroadcostbasis temp=new TCostOrderroadcostbasis();
						temp.setOrderidS(gate.getOrderidS());
						temp.setRoadidS(gate.getRoadidS());
						list = ot.getTCostOrderroadcostbasis(temp, ConstantUtil.pagingNot, 0);
						if(BasicTools.isnotNull(list)){
							temp = list.get(0);
							if(gate.getUnitprieI()!=null){
								temp.setUnitprieI(gate.getUnitprieI());
							}
							if(gate.getWholeunitprieI()!=null){
								temp.setWholeunitprieI(gate.getWholeunitprieI());
							}
							if(gate.getMinuteUnitPrie_i()!=null){
								temp.setMinuteUnitPrie_i(gate.getMinuteUnitPrie_i());
							}
							if(gate.getCoefficient_i()!=null){
								temp.setCoefficient_i(gate.getCoefficient_i());
							}
							if(gate.getResaveds1_s() != null){
								temp.setResaveds1_s(gate.getResaveds1_s());
							}
							if(gate.getResaveds2_s() != null){
								temp.setResaveds2_s(gate.getResaveds2_s());
							}
							session.saveOrUpdate(temp);
						}else{
							session.saveOrUpdate(gate);
						}
						r=1;
					}
				}
			}
			//删除
			if(operation==2){
				if(tCostOrderroadcostbasis!=null&&tCostOrderroadcostbasis.size()>0){
					for(int i=0;i<tCostOrderroadcostbasis.size();i++){
						session.delete(tCostOrderroadcostbasis.get(i));
						session.flush();
						session.clear();
						r=1;
					}
				}
			}
			tx.commit();
		}catch(Exception e){
			r=-1;
			tx.rollback();
			throw e;
		}finally{				
    		session.clear();	 
		}	
		return r;
	}
	
	/**
	 * 同步订单的道路价格	   
	 * synchronizationRoadcost 
	 * @param   name    orderId：指定订单
	 *                  roadID_s：指定道路
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int synchronizationRoadcost(String orderId,String roadID)throws Exception{
		Session session= HibernateUtil.getSession();
		Connection con  = HibernateUtil.getconnBysession(sessionImpl);
		String procedure = "{call OrderCostCompute.synchronizationRoadcost(?,?)}";
		Query q  = session.createSQLQuery(procedure);
		q.setString(0, orderId);
		q.setString(1, roadID);
		q.executeUpdate();
		session.clear();
		return 1;
	}
	
	public static void main(String[] args)  {

		String orderId="DD2014091004";
		String roadID = "DL2014091003";
		Object[] o = {orderId,roadID};
		ServiceImpl tmp = new ServiceImpl("com.freshen.cost.service.impl.OrderRoadCostBasisServiceImpl","synchronizationRoadcost",o);
		List<ServiceImpl> se = new ArrayList();
		se.add(tmp);
		try {
			ServiceImpl.invoke(se);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
