package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IBarrierGateService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.IvroadRaletiveService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.RoadCost;
import com.freshen.entity.basis.RoadExperimentType;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.VRoadRaletive;
import com.freshen.entity.basis.ViewOrganization;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class RoadInfoServiceImpl extends ClimsServiceBase implements IroadInfoService{

	//Session session= HibernateUtil.getSession();
	String roadID_s,roadName_s,technicalParameters_s,remark_s,createUser_s,lastUpdateUser_s;
	Integer maxCapacity_i,state_i;
	Date inputDate_t,createDate_t,lastUpdateDate_t;
	String resaveds1_s,resaveds2_s,resaveds3_s,resaveds4_s,	resaveds5_s;
	String roadType_s;
	Integer beginningDay_i;
	
	public ArrayList<RoadInfo> getRoadInfo(RoadInfo roadInfo) throws Exception {
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			return getRoadInfoByTX(roadInfo,session);	
		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
			session.clear();
		}
	}

	/**
	 * 用于使用事务	   
	 * getRoadInfoByTX 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<RoadInfo> getRoadInfoByTX(RoadInfo roadInfo,Session session) throws Exception {
		
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<RoadInfo> list = new ArrayList();	
			if(roadInfo == null)
			{
				Query query=session.createQuery(" from RoadInfo as roadInfo ");
			    list = query.list();	    
				return (ArrayList<RoadInfo>) list;	
			}
			roadID_s   = roadInfo.getRoadID_s();
			roadName_s = roadInfo.getRoadName_s();		
			technicalParameters_s = roadInfo.getTechnicalParameters_s();
			remark_s = roadInfo.getRemark_s();
			maxCapacity_i = roadInfo.getMaxCapacity_i();
			state_i = roadInfo.getState_i();
			inputDate_t= roadInfo.getInputDate_t();
			roadType_s = roadInfo.getRoadType_s();
			beginningDay_i = roadInfo.getBeginningDay_i();
			String hql="from RoadInfo as roadInfo where 1=1 "; 			
		    String condition = "";
			if(roadID_s!=null && roadID_s.trim().length()>1){
				condition = condition + " and roadInfo.roadID_s like '%"+roadID_s+"%'";
		    }
			
		    if(roadName_s!=null&&roadName_s.trim().length()>1){
		    	condition += " and roadInfo.roadName_s like '%"+roadName_s.trim()+"%'";
		    }
		    if(technicalParameters_s!=null&&technicalParameters_s.trim().length()>=1){
		    	condition = condition+" and roadInfo.technicalParameters_s like '%"+technicalParameters_s+"%'";
		    }
		    if(roadType_s!=null&&roadType_s.trim().length()>=1){
		    	condition = condition+" and roadInfo.roadType_s like '%"+roadType_s+"%'";
		    }
		    if(maxCapacity_i!=null){
		    	condition = condition+" and roadInfo.maxCapacity_i='"+maxCapacity_i+"'";
		    }
		    if(beginningDay_i!=null){
		    	condition = condition+" and roadInfo.beginningDay_i='"+beginningDay_i+"'";
		    }
		    if(state_i!=null  && state_i != -1){
		    	condition = condition+" and roadInfo.state_i='"+state_i+"'";
		    }
		    if(inputDate_t!=null){		    	
		    	condition = condition+" and to_char(roadInfo.inputDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(inputDate_t, "yyyy-MM-dd") +"'";
		    } 
		    Query query=session.createQuery(hql+condition);
		    list = query.list();	    
			return (ArrayList<RoadInfo>) list;	
		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
			 
		}
	}

	public ArrayList<RoadInfo> getRoadInfo(RoadInfo roadInfo, int start,
			int size) throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
		List<RoadInfo> list = new ArrayList();
		if(roadInfo == null)
		{
			Query query=session.createQuery(" from RoadInfo as roadInfo order by roadInfo.roadID_s");
			if(start!= -1)
			{
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();	    
			return (ArrayList<RoadInfo>) list;	
		}
		roadID_s   = roadInfo.getRoadID_s();
		roadName_s = roadInfo.getRoadName_s();		
		technicalParameters_s = roadInfo.getTechnicalParameters_s();
		remark_s = roadInfo.getRemark_s();
		maxCapacity_i = roadInfo.getMaxCapacity_i();
		state_i = roadInfo.getState_i();
		inputDate_t= roadInfo.getInputDate_t();
		roadType_s = roadInfo.getRoadType_s();
		beginningDay_i = roadInfo.getBeginningDay_i();
	 
		/*2014-5-22 sharonyshi
		 * if(roadID_s!=null){
			roadInfo=(RoadInfo)session.get(roadInfo.getClass(), roadID_s);
	    	list.add(roadInfo);
	    	return (ArrayList)list;
	    }*/
		String hql=" from RoadInfo as roadInfo where 1=1 "; 			
	    String condition = "";
	    
	    
	    if(roadID_s!=null && roadID_s.trim().length()>0){
			condition = condition + " and roadInfo.roadID_s like '%"+roadID_s+"%'";
	    }
	    if(roadName_s!=null&&roadName_s.trim().length()>0){
	    	condition = " and roadInfo.roadName_s like '%"+roadName_s+"%'";
	    }
	    if(roadType_s!=null&&roadType_s.trim().length()>=1){
	    	condition = condition+" and roadInfo.roadType_s like '%"+roadType_s+"%'";
	    }
	    if(technicalParameters_s!=null && technicalParameters_s.trim().length()>0){
	    	condition = condition+" and roadInfo.technicalParameters_s like '%"+technicalParameters_s+"%'";
	    }
	    
	    if(beginningDay_i!=null){
	    	condition = condition+" and roadInfo.beginningDay_i='"+beginningDay_i+"'";
	    }
	    if(maxCapacity_i!=null){
	    	condition = condition+" and roadInfo.maxCapacity_i='"+maxCapacity_i+"'";
	    }
	    if(state_i!=null && state_i != -1){
	    	condition = condition+" and roadInfo.state_i='"+state_i+"'";
	    }
	    if(inputDate_t!=null){		    	
	    	condition = condition+" and to_char(roadInfo.inputDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(inputDate_t, "yyyy-MM-dd") +"'";
	    } 

	    condition = condition +" order by roadInfo.roadID_s desc,roadInfo.lastUpdateDate_t DESC";

	    Query query=session.createQuery(hql+condition);
	    if(start != -1)
	    {
	    	query.setFirstResult(start);
		    query.setMaxResults(size);
	    	
	    }	    
	    list = query.list();	    
		return (ArrayList<RoadInfo>) list;	
		}catch(Exception e){
			throw e;
		}
		finally{
			session.clear();
		}
	}
	
	//sharonyshi 2014-5-22
	public long getRoadInfoNumber(RoadInfo roadInfo) throws Exception{
		Session session= HibernateUtil.getSession();
		try {			
			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}
			long n = 0;
			
			if(roadInfo==null){
				Query query = session.createQuery("select count(*) from RoadInfo ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			roadID_s   = roadInfo.getRoadID_s();
			roadName_s = roadInfo.getRoadName_s();		
			technicalParameters_s = roadInfo.getTechnicalParameters_s();
			remark_s = roadInfo.getRemark_s();
			maxCapacity_i = roadInfo.getMaxCapacity_i();
			state_i = roadInfo.getState_i();
			inputDate_t= roadInfo.getInputDate_t();
			roadType_s = roadInfo.getRoadType_s();
			beginningDay_i= roadInfo.getBeginningDay_i();
			String hql="select count(*) from RoadInfo as roadInfo where 1=1 "; 			
		    String condition = "";
		    
		    if(roadID_s!=null && roadID_s.trim().length()>0){
				condition = condition + " and roadInfo.roadID_s like '%"+roadID_s+"%'";
		    }
		    if(roadName_s!=null&&roadName_s.trim().length()>0){
		    	condition = " and roadInfo.roadName_s like '%"+roadName_s+"%'";
		    }
		    if(technicalParameters_s!=null && technicalParameters_s.trim().length()>0){
		    	condition = condition+" and roadInfo.technicalParameters_s like '%"+technicalParameters_s+"%'";
		    }
		    if(roadType_s!=null&&roadType_s.trim().length()>=1){
		    	condition = condition+" and roadInfo.roadType_s like '%"+roadType_s+"%'";
		    }
		    if(maxCapacity_i!=null){
		    	condition = condition+" and roadInfo.maxCapacity_i='"+maxCapacity_i+"'";
		    }
		    if(beginningDay_i!=null){
		    	condition = condition+" and roadInfo.beginningDay_i='"+beginningDay_i+"'";
		    }
		    if(state_i!=null && state_i != -1){
		    	condition = condition+" and roadInfo.state_i='"+state_i+"'";
		    }
		    if(inputDate_t!=null){		    	
		    	condition = condition+" and to_char(roadInfo.inputDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(inputDate_t, "yyyy-MM-dd") +"'";
		    } 
		    
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }
		    return n;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.clear();
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		RoadInfo roadInfo = new RoadInfo();
		roadInfo.setRoadID_s("R001");
		RoadInfoServiceImpl ris = new RoadInfoServiceImpl();
		ArrayList<RoadInfo> list = new ArrayList();
		list = ris.getRoadInfo(roadInfo, -1, 10);
		//System.out.println(list.size());
		roadInfo = list.get(0);
		Set<RoadExperimentType> l = roadInfo.getRoadExperimentTypeSet();
		for(RoadExperimentType t:l){
			//System.out.println(t.toString());
		}
		 
		/*roadInfo.setCreateDate_t(new Date());
		roadInfo.setRoadName_s("22");
		roadInfo.setCreateUser_s("1111111");
		roadInfo.setState_i(0);
		roadInfo.setRoadID_s("DL2014051001");
		list.add(roadInfo);
		ris.OperationRoadInfoInfo(list, 1);*/
	}

	public int OperationRoadInfoInfo(List<RoadInfo> roadInfo, int operation)
			throws Exception {
		Transaction tx = null;
		Session session= HibernateUtil.getSession();
		boolean b = false;
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			String cpg = "";
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				RoadInfo road = new RoadInfo();
				if(roadInfo!=null||roadInfo.size()>0){
					for(int i=0;i<roadInfo.size();i++){		
						if(roadInfo.get(i).getRoadID_s()== null || roadInfo.get(i).getRoadID_s().trim().equals(""))
						{
							road = roadInfo.get(i);
							cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DLBusiness, session);
							road.setRoadID_s(cpg);
							road.getRoadCost().setRoadID_s(cpg);
							road.getRoadCost().getRoadInfo().setRoadID_s(cpg);
							b = true;
							session.merge(road);
						}
						else
						{
							road = roadInfo.get(i);
							RoadInfo tmp = (RoadInfo)session.get(RoadInfo.class, road.getRoadID_s());
							roadID_s = road.getRoadID_s();
							roadName_s = road.getRoadName_s();
							technicalParameters_s = road.getTechnicalParameters_s();
							remark_s = road.getRemark_s();
							createUser_s = road.getCreateUser_s();
							lastUpdateUser_s = road.getLastUpdateUser_s();
							maxCapacity_i = road.getMaxCapacity_i();
							state_i = road.getState_i();
							inputDate_t = road.getInputDate_t();
							createDate_t = road.getCreateDate_t();
							lastUpdateDate_t = road.getLastUpdateDate_t();
							resaveds1_s = road.getResaveds1_s();
							resaveds2_s= road.getResaveds2_s();
							resaveds3_s= road.getResaveds3_s();
							resaveds4_s= road.getResaveds4_s();
							resaveds5_s= road.getResaveds5_s();
							roadType_s = road.getRoadType_s();
							beginningDay_i = road.getBeginningDay_i();
							if(roadID_s==null){
								road.setRoadID_s(tmp.getRoadID_s());
							}
							if(beginningDay_i == null){
								road.setBeginningDay_i(tmp.getBeginningDay_i());
							}
							if(roadType_s==null){
								road.setRoadType_s(tmp.getRoadType_s());
							}
							if(roadName_s ==null){
								road.setRoadName_s(tmp.getRoadName_s());
							}
							if(technicalParameters_s == null){
								road.setTechnicalParameters_s(tmp.getTechnicalParameters_s());
							}
							if(remark_s ==null){
								road.setRemark_s(tmp.getRemark_s());
							}
							if(createUser_s == null){
								road.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								road.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(maxCapacity_i == null){
								road.setMaxCapacity_i(tmp.getMaxCapacity_i());
							}
							if(state_i == null){
								road.setState_i(tmp.getState_i());
							}
							if(inputDate_t == null){
								road.setInputDate_t(tmp.getInputDate_t());
							}
							if(createDate_t == null){
								road.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(lastUpdateDate_t == null){
								road.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								road.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								road.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								road.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								road.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								road.setResaveds5_s(tmp.getResaveds5_s());
							}
							session.merge(road);
						}
						
					  //session.saveOrUpdate(road);
						session.flush();
					}
				}
			}
			//删除
			if(operation==2){
				IvroadRaletiveService ivt = new VRoadRaletiveServiceImpl();
				IBarrierGateService ibg = new BarrierGateServiceImpl();
				VRoadRaletive vr = new VRoadRaletive();
				List<VRoadRaletive> list = new ArrayList();
				List<BarrierGate> barrierList = new ArrayList();
				BarrierGate barrierGate = new BarrierGate();
				if(roadInfo!=null&&roadInfo.size()>0){
					for(int i=0;i<roadInfo.size();i++){
						
						RoadInfo tmp = new RoadInfo();
						RoadCost cost = new RoadCost();
						tmp = roadInfo.get(i);
						vr.setRoadid(tmp.getRoadID_s());
						list =ivt.getBasisVRoadRaletiveInfo(vr, session);
						if(list!= null && list.size()>0)
						{
							return 0;
						}
						barrierGate.setEntranceRoadIDs(tmp.getRoadID_s());
						barrierList = ibg.getBasisBarrierGateInfo(barrierGate, -1, 0);
						if(barrierList!= null && barrierList.size()>0)
						{
							for(int j =0;j<barrierList.size();j++)
							{
								barrierList.get(j).setEntranceRoadIDs("");
								barrierList.get(j).getEnterroadinfo().setRoadID_s("");
							}
							ibg.OperationBasisBarrierGateInfo(barrierList, 1);
						}
						cost = (RoadCost)session.get(cost.getClass(), tmp.getRoadID_s());
						if(cost!= null)
						{
							cost.setRoadInfo(tmp);
							tmp.setRoadCost(cost);
						}
						session.delete(tmp);
						session.flush();
 					}
				}
			}
			tx.commit();
			if(b){
				initOrderRoadCost(null,cpg);
			}
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
	}
	
	/**
	 * 添加道路同步订单道路费用信息表
	 * initOrderPrice 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void initOrderRoadCost(String orderID,String roadID) throws Exception{
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		try{	
			
			tx=session.beginTransaction();//开启事务
			String procedure = "{call OrderCostCompute.synchronizationRoadcost(?,?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.setString(1, roadID);
			q.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			session.clear();
		}
	}
	/**
	 * 判断该条道路信息是否为道闸的入口，如果是则不能够删除，否则查不出来就能删除该条道路
	 * @param roadID 入口ID
	 * @return
	 * @throws Exception
	 */
	public boolean getIsVisible(String roadID)
	throws Exception {
		boolean returnValue = false;
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			if(roadID != null){
				
				String hql = "select count(*)  from BarrierGate as garrierGate where 1=1 ";
				String condition="";
				
				if(roadID != null && !roadID.trim().equals("")){
			    	condition = " and garrierGate.enterroadinfo = '" + roadID + "'";
			    }
				
				
				Query query = session.createQuery(hql + condition);
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				if(n>0)
				{
					returnValue = true;
				}
				else
				{
					returnValue = false;
				}
			}
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		finally
		{
			session.clear();
			return returnValue;	
		}
	}
}
