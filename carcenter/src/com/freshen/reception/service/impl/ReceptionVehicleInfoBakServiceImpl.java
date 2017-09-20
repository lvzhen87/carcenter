package com.freshen.reception.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.barrierGate.service.BarrierGateJurisdictionService;
import com.freshen.barrierGate.service.IbarrierGateCancellationService;
import com.freshen.barrierGate.service.impl.BarrierGateCancellationServiceImpl;
import com.freshen.barrierGate.service.impl.BarrierGateJurisdictionServiceImpl;
import com.freshen.basis.service.IBarrierGateService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.BarrierGateServiceImpl;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;

import com.freshen.entity.VehicleInfo;
import com.freshen.entity.barrierGate.BarrierGateJurisdiction;
import com.freshen.entity.barrierGate.TBarriergateCancellationBak;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.RoadInfo;

import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;
//import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.entity.reception.ReceptionVehicleInfoBak;

import com.freshen.preorder.service.IvehicleInfoService;
import com.freshen.preorder.service.impl.VehicleInfoServiceImpl;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.IreceptionVehicleInfoBakService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;

import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

public class ReceptionVehicleInfoBakServiceImpl extends ClimsServiceBase implements IreceptionVehicleInfoBakService{

	String orderID_s;
	String vehicleID_s, vehicleCPG_s, model_s, color_s, interPhoneID_s, fieldID_s;
	Date createDate_t = new Date();
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t = new Date();
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String roidIds_s;//道路ID集合
//	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	Integer axleNumber_i;
	/**
	 * 通过条件查询计划车辆信息表
	 * getReceptionVehicleInfo 
	 * @param  ReceptionVehicleInfo
	 * @param  page开始页
	 * @param  page总数
	 * @return    ArrayList     
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<ReceptionVehicleInfoBak> getReceptionVehicleInfo(ReceptionVehicleInfoBak rVehicleInfo,int start,	int size,Session session) throws Exception{
		if(session==null){
			session= HibernateUtil.getSession();
		}
		
		try{
			List<ReceptionVehicleInfoBak> list = new ArrayList();
			
			if(rVehicleInfo == null){
				Query query=session.createQuery("from ReceptionVehicleInfo");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			setReceptionVehicleInfoPro(rVehicleInfo);
			//	vehicleCPG_s是主键，只对应一条记录，所以当vehicleCPG_s不为空的情况，直接进行查询并返回
			String hql = " from ReceptionVehicleInfo as rVehicleInfo where 1=1 ";
		    String condition = "";
			if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("")){
				condition += " and rVehicleInfo.vehicleCPG_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
			
		    if(vehicleID_s != null && !vehicleID_s.trim().equals("")){
		    	condition += " and rVehicleInfo.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(orderID_s != null && !orderID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.orderID_s like '%" + orderID_s.trim() + "%'";
		    }
		    if(model_s != null && !model_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.model_s like '%" + model_s.trim() + "%'";
		    }
		    if(color_s != null && !color_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.color_s like '%" + color_s.trim() + "%'";
		    }
		    if(interPhoneID_s != null && !interPhoneID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.interPhoneID_s like '%" + interPhoneID_s.trim() + "%'";
		    }
		    if(fieldID_s != null && !fieldID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.fieldID_s like '%" + fieldID_s.trim() + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(rVehicleInfo.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(rVehicleInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(roidIds_s != null && !roidIds_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.roidIds_s like '%" + roidIds_s.trim() + "%'";
		    }
		    Query query = session.createQuery(hql + condition);
		    if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();
		   
		    //查询道路ID对应的名称
		    if(BasicTools.isnotNull(list)){
			    for (int i = 0; i < list.size(); i++) {
			    	String roadName="";
			    	ReceptionVehicleInfoBak receptionVehicleInfo = list.get(i);
			    	if(receptionVehicleInfo.getRoidIds_s()==null||"".equals(receptionVehicleInfo.getRoidIds_s())){
			    		continue;
			    	}
			    	 
					String roadid[]=list.get(i).getRoidIds_s().split("vv");
					for (int j = 0; j < roadid.length; j++) {
						RoadInfo ri=new RoadInfo();
						ri.setRoadID_s(roadid[j]);
						
						IroadInfoService irs=new RoadInfoServiceImpl();
						List<RoadInfo> rlist=irs.getRoadInfoByTX(ri,session);
						if(rlist != null && rlist.size()>0){
							roadName += rlist.get(0).getRoadName_s() +",";
						}
					}
					if(roadName.length() > 0){
						list.get(i).setRoadNames_s(roadName.substring(0, roadName.length()-1));
					
					}else{
						list.get(i).setRoadNames_s(roadName);
					}		
				}
		    }
		    return (ArrayList) list;	
		}catch(Exception e){
			
			throw new Exception(e);
		}finally{
			//session.clear();
		    
		}	 
	}

	/**
	 * 通过条件查询计划车辆信息表
	 * getReceptionVehicleInfo 
	 * @param  ReceptionVehicleInfo
	 * @param  page开始页
	 * @param  page总数
	 * @return    ArrayList     
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<ReceptionVehicleInfoBak> getReceptionVehicleInfo(ReceptionVehicleInfoBak rVehicleInfo,int start,	int size) throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionVehicleInfoBak> list = new ArrayList();
			
			if(rVehicleInfo == null){
				Query query=session.createQuery("from ReceptionVehicleInfo");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			setReceptionVehicleInfoPro(rVehicleInfo);
			//	vehicleCPG_s是主键，只对应一条记录，所以当vehicleCPG_s不为空的情况，直接进行查询并返回
			String hql = " from ReceptionVehicleInfoBak as rVehicleInfo where 1=1 ";
		    String condition = "";
			if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("")){
				condition += " and rVehicleInfo.vehicleCPG_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
			
		    if(vehicleID_s != null && !vehicleID_s.trim().equals("")){
		    	condition += " and rVehicleInfo.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(orderID_s != null && !orderID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.orderID_s like '%" + orderID_s.trim() + "%'";
		    }
		    if(model_s != null && !model_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.model_s like '%" + model_s.trim() + "%'";
		    }
		    if(color_s != null && !color_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.color_s like '%" + color_s.trim() + "%'";
		    }
		    if(interPhoneID_s != null && !interPhoneID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.interPhoneID_s like '%" + interPhoneID_s.trim() + "%'";
		    }
		    if(fieldID_s != null && !fieldID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.fieldID_s like '%" + fieldID_s.trim() + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(rVehicleInfo.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(rVehicleInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(roidIds_s != null && !roidIds_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.roidIds_s like '%" + roidIds_s.trim() + "%'";
		    }
		    Query query = session.createQuery(hql + condition+" order by rVehicleInfo.resaveds1_s");
		    if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();
		 
		    //查询道路ID对应的名称
		    if(BasicTools.isnotNull(list)){
			    for (int i = 0; i < list.size(); i++) {
			    	String roadName="";
			    	ReceptionVehicleInfoBak receptionVehicleInfo = list.get(i);
			    	if(receptionVehicleInfo.getRoidIds_s()==null||"".equals(receptionVehicleInfo.getRoidIds_s())){
			    		continue;
			    	}
			    
					String roadid[]=list.get(i).getRoidIds_s().split("vv");
					for (int j = 0; j < roadid.length; j++) {
						RoadInfo ri=new RoadInfo();
						ri.setRoadID_s(roadid[j]);
						
						IroadInfoService irs=new RoadInfoServiceImpl();
						ArrayList<RoadInfo> rlist=irs.getRoadInfo(ri);
						if(rlist != null && rlist.size()>0){
							roadName += rlist.get(0).getRoadName_s() +",";
						}
					}
					//list.get(i).setRoadNames_s(roadName.substring(0, roadName.length()-1));
					if(roadName.length() > 0){
						list.get(i).setRoadNames_s(roadName.substring(0, roadName.length()-1));
					}else{
						list.get(i).setRoadNames_s(roadName);
					}
				}
		    }
		    return (ArrayList) list;	
		}catch(Exception e){
			throw new Exception(e);			
		}finally{
			session.clear();
			session.close();
		}	 
	}

	/**
	 * 通过条件查询计划车辆信息表，返回取得个数
	   
	 * getReceptionVehicleInfoNumber 
	 * @param   name    
	 * @param  @return    Long    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public long getReceptionVehicleInfoNumber(ReceptionVehicleInfoBak rVehicleInfo)throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<ReceptionVehicleInfoBak> list = new ArrayList();

			if(rVehicleInfo == null){
				Query query=session.createQuery("select count(*) from ReceptionVehicleInfoBak");
			    if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			setReceptionVehicleInfoPro(rVehicleInfo);
			if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("")){
				rVehicleInfo = (ReceptionVehicleInfoBak)session.get(rVehicleInfo.getClass(), vehicleCPG_s);
		    	list.add(rVehicleInfo);
		    	return 1;
		    }
			
			String hql = "select count(*) from ReceptionVehicleInfoBak as rVehicleInfo where 1=1 "; 
		    String condition = "";
		    
		    if(vehicleID_s != null && !vehicleID_s.trim().equals("")){
		    	condition = " and rVehicleInfo.vehicleID_s like '%" + vehicleID_s.trim() + "%'";
		    }
		    if(orderID_s != null && !orderID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.orderID_s like '%" + orderID_s.trim() + "%'";
		    }
		    if(model_s != null && !model_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.model_s like '%" + model_s.trim() + "%'";
		    }
		    if(color_s != null && !color_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.color_s like '%" + color_s.trim() + "%'";
		    }
		    if(interPhoneID_s != null && !interPhoneID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.interPhoneID_s like '%" + interPhoneID_s.trim() + "%'";
		    }
		    if(fieldID_s != null && !fieldID_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.fieldID_s like '%" + fieldID_s.trim() + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(rVehicleInfo.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(rVehicleInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and rVehicleInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(axleNumber_i != null ){
		    	condition = condition + " and rVehicleInfo.axleNumber_i ='" + axleNumber_i + "'";
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
			session.close();
		}	
	}
	
	/**
	 * 对属性进行赋值	   
	 * setReceptionVehicleInfoPro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setReceptionVehicleInfoPro(ReceptionVehicleInfoBak rVehicleInfo){
		orderID_s = rVehicleInfo.getOrderID_s();
		vehicleID_s = rVehicleInfo.getVehicleID_s();
		vehicleCPG_s = rVehicleInfo.getVehicleCPG_s();
		model_s = rVehicleInfo.getModel_s();
		color_s = rVehicleInfo.getColor_s();
		interPhoneID_s = rVehicleInfo.getInterPhoneID_s();
		fieldID_s = rVehicleInfo.getFieldID_s();
		createDate_t = rVehicleInfo.getCreateDate_t();
		createUser_s = rVehicleInfo.getCreateUser_s();
		lastUpdateUser_s = rVehicleInfo.getLastUpdateUser_s();
		lastUpdateDate_t = rVehicleInfo.getLastUpdateDate_t();
		resaveds1_s = rVehicleInfo.getResaveds1_s();
		resaveds2_s = rVehicleInfo.getResaveds2_s();
		resaveds3_s = rVehicleInfo.getResaveds3_s();
		resaveds4_s = rVehicleInfo.getResaveds4_s();
		resaveds5_s = rVehicleInfo.getResaveds5_s();
		roidIds_s = rVehicleInfo.getRoidIds_s();
		axleNumber_i = rVehicleInfo.getAxleNumber_i();
	}
	/**
	 * 保存计划车辆信息
	 * saveOrUpdateReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功       
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String saveOrUpdateReceptionVehicleInfo(ArrayList<ReceptionVehicleInfo> list) throws Exception{
		Session session = HibernateUtil.getSession();
		ReceptionVehicleInfoBak rVehicleInfo = new ReceptionVehicleInfoBak();
		IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			String cpg = saveOrUpdateReceptionVehicleInfoByTransaction(list,session);
			tx.commit();
			return cpg;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
			session.close();
		}
	}
	
	/**
	 * 根据原车辆信息  保存备份计划车辆信息，
	 * saveOrUpdateReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功       
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String saveOrUpdateReceptionVehicleInfoByTransaction(ArrayList<ReceptionVehicleInfo> list,Session session) throws Exception{
		
		System.out.println("----------receptionvehiclelist010201---save BAK--impl:"+list);
		ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
		IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
		String cpg = ""; 
		try{			
			if(list != null && list.size() > 0){
				for(int i = 0; i < list.size(); i++){
					//	vehicleCPG_s存在的情况，做更新处理
					rVehicleInfo = list.get(i);
					ReceptionVehicleInfoBak tmp = new ReceptionVehicleInfoBak();
					tmp.copyVI(rVehicleInfo);
					if(tmp.getVehicleCPG_s()==null||"".equals(tmp.getVehicleCPG_s())){
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.SUBCPGBBAKusiness, session);
						tmp.setVehicleCPG_s(pk);
					}
					
					session.save(tmp);
					//session.merge(rVehicleInfo);
					session.flush();
				//    session.clear();
				}
			}		
			cpg = rVehicleInfo.getVehicleCPG_s();
			return cpg;
		}catch (Exception e){
		 
			throw new Exception(e);
		}finally{
			 
		}
	}
	/**
	 * 按订单保存车卡权限信息表(oracle)
	 * assemblyJurisdictionInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<BarrierGateJurisdiction> saveJurisdictionInfo(String orderid,Session session) throws Exception{
		
		//获得order对象
		ReceptionOrder receptionOrder = new ReceptionOrder();
		if(!orderid.equals(ConstantUtil.ORDERIDFinal)){
			IreceptionOrderService ireceptionOrderService = new ReceptionOrderServiceImpl();			 			
			receptionOrder.setOrderID_s(orderid);
			receptionOrder = ireceptionOrderService.getReceptionOrderByTx(receptionOrder, ConstantUtil.pagingNot, 1,session).get(0);
		}
		//获得计划车辆信息
		IreceptionVehicleInfoBakService IreceptionVehicleInfoService = new ReceptionVehicleInfoBakServiceImpl();
		ReceptionVehicleInfoBak receptionVehicleInfo = new ReceptionVehicleInfoBak();
		receptionVehicleInfo.setOrderID_s(orderid);
		List<ReceptionVehicleInfoBak> receptionVehicleList = IreceptionVehicleInfoService.getReceptionVehicleInfo(receptionVehicleInfo, ConstantUtil.pagingNot, 1,session);
		//保存车卡权限信息表
		BarrierGateJurisdictionService barrierGateJurisdictionService = new BarrierGateJurisdictionServiceImpl();
		List<BarrierGateJurisdiction> bjlist = new ArrayList();
		
		//获得道路相关道闸
		IBarrierGateService iBarrierGateService = new BarrierGateServiceImpl();
		if(receptionVehicleList!=null&&receptionVehicleList.size()>0){
			for(int i=0;i<receptionVehicleList.size();i++){
				receptionVehicleInfo = receptionVehicleList.get(i);
				//道路ID集合
				if(receptionVehicleInfo.getRoidIds_s()==null){
					continue;
				}
				String[] roidIds_s = StringTools.split("vv",  receptionVehicleInfo.getRoidIds_s());
				if(roidIds_s.length>0){
					for(int j=0;j<roidIds_s.length;j++){
						
						//根据道路id获得该进入该道路的道闸信息
						BarrierGate barrierGate = new BarrierGate();
						barrierGate.setEntranceRoadIDs(roidIds_s[j]);
						ArrayList<BarrierGate> barrierGateList= iBarrierGateService.getBasisBarrierGateInfoByTx(barrierGate, ConstantUtil.pagingNot,0,session);
						if(BasicTools.isnotNull(barrierGateList)){
							for(int m=0;m<barrierGateList.size();m++){
								barrierGate = barrierGateList.get(m);
								BarrierGateJurisdiction barrierGateJurisdiction = new BarrierGateJurisdiction();
								barrierGateJurisdiction.setCardID_s(receptionVehicleInfo.getVehicleID_s());
								barrierGateJurisdiction.setEditFlagTime_t(new Date());
								if(!orderid.equals(ConstantUtil.ORDERIDFinal)){
									//barrierGateJurisdiction.setEffectiveTime_t(receptionOrder.getStartDate_d());
									barrierGateJurisdiction.setEffectiveTime_t(new Date());
									barrierGateJurisdiction.setInvalidationTime_t(receptionOrder.getEndDate_d());
								}else{
									barrierGateJurisdiction.setEffectiveTime_t(new Date());
									barrierGateJurisdiction.setInvalidationTime_t(DateUtil.getDate(receptionVehicleInfo.getResaveds1_s()));
								}
								barrierGateJurisdiction.setInvalidationTime_t(DateUtil.getDate(receptionVehicleInfo.getResaveds1_s()));
								barrierGateJurisdiction.setJurisdiction_s(barrierGate.getGateNumber_s());												
								bjlist.add(barrierGateJurisdiction);
							}
						}
					}
				}
			}
			bjlist = barrierGateJurisdictionService.OperationBarrierGateJurisdiction(bjlist, 1,session);
		}
		return bjlist;
	}
	
	 
	
	/**
	 * 删除计划车辆信息
	 * deleteReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功 
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionVehicleInfoByTx(ArrayList<ReceptionVehicleInfoBak> list,Session session) throws Exception{		
		ReceptionVehicleInfoBak rVehicleInfo = new ReceptionVehicleInfoBak();		 
		try{
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					if(!list.get(i).getOrderID_s().equals("")){
						rVehicleInfo.setOrderID_s(list.get(i).getOrderID_s());
					}
					if(list.get(i).getVehicleCPG_s()!=null&&!list.get(i).getVehicleCPG_s().equals("")){
						rVehicleInfo.setVehicleCPG_s(list.get(i).getVehicleCPG_s());
					/*	rVehicleInfo = this.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pageSize, 0).get(0);
						rVehicleInfo.setResaveds3_s("1");*/
						String deleteParentSql = "delete from ReceptionVehicleInfoBak as r where r.vehicleCPG_s ='"+list.get(i).getVehicleCPG_s()+"'";
						session.createQuery(deleteParentSql).executeUpdate();
						
					/*	session.delete(rVehicleInfo);
						session.flush();	*/	
					}else{ //20150514 kxc 
						String deleteParentSql = "delete from ReceptionVehicleInfoBak as r where r.orderID_s='"+list.get(i).getOrderID_s()+"'";
						session.createQuery(deleteParentSql).executeUpdate(); 
					}		
				}
			}else{
				//删除临时添加的但没发卡的车辆记录
				String deleteParentSql = "delete from ReceptionVehicleInfoBak as r where r.vehicleID_s is null and r.resaveds2_s is null";
				session.createQuery(deleteParentSql).executeUpdate();
			}
			session.flush();
			return 1;
		}catch (Exception e){
			throw new Exception(e);
		}finally{
		
		}
	}
	
	/**
	 * 删除计划车辆信息
	 * deleteReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功 
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionVehicleInfo(ArrayList<ReceptionVehicleInfoBak> list) throws Exception{
		Session session = HibernateUtil.getSession();	 
		Transaction tx=session.beginTransaction();
		try{
			 
			deleteReceptionVehicleInfoByTx(list,session);
			tx.commit();
			return 1;
		}catch (Exception e){
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			session.clear();
			session.close();
		}
	}
	 
	
	
	/**
	 * 根据订单得到预约模块单台车辆信息表复制到接待模块计划车辆信息表	   
	 * addReceptionVehicleInfo 
	 * @param   orderID_s 订单编号    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void addReceptionVehicleInfo(String orderID_s,Session session)throws Exception{
		ArrayList<ReceptionVehicleInfo> receptionVehicleInfos = new ArrayList();
		//1、通过订单ID获得单台车辆信息表
		IvehicleInfoService ivehicleInfoService = new VehicleInfoServiceImpl();
		VehicleInfo vehicleInfo = new VehicleInfo();
		vehicleInfo.setOrderID_s(orderID_s);
		List<VehicleInfo> vehicleInfos = ivehicleInfoService.getVehicleInfo(vehicleInfo, ConstantUtil.pagingNot, 0);
		//2、将单台车辆信息表复制到接待模块计划车辆信息表
		for(int i=0;i<vehicleInfos.size();i++){
			VehicleInfo tmp = vehicleInfos.get(i);
			ReceptionVehicleInfo receptionVehicleInfo = new ReceptionVehicleInfo();
			receptionVehicleInfo.setProByVehicleInfo(tmp);
			receptionVehicleInfos.add(receptionVehicleInfo);
		}
		saveOrUpdateReceptionVehicleInfoByTransaction(receptionVehicleInfos,session);
	}
	
	
	public static void main(String[] a){
		ReceptionVehicleInfoBakServiceImpl impl = new ReceptionVehicleInfoBakServiceImpl();
		try {
			ReceptionVehicleInfoBak rVehicleInfo = new ReceptionVehicleInfoBak();
			rVehicleInfo.setVehicleCPG_s("SCPG2014091008");
			List l = impl.getReceptionVehicleInfo(rVehicleInfo,-1,0,null);
			System.out.println(l.size());
			//impl.saveJurisdiction("DD2014041007");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//判断该车是否进入道闸，如果进入过道闸，不能被删除！2014-9-25
	public boolean getIsVisible(String vehicleID) throws Exception {
		// TODO Auto-generated method stub
		boolean returnValue = false;
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			if(vehicleID != null){
				
				String hql = "select count(*)  from  BarrierGateInorOutinfo as bgio  where 1=1 ";
				String condition="";
				
				if(vehicleID != null && !vehicleID.trim().equals("")){
			    	condition = " and  bgio.cardID_s= '" + vehicleID + "'";
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
			// TODO: handle exception
		}finally{
			session.clear();
			session.close();
			return returnValue;	
		}
		//return false;
	}
}
