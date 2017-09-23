package com.freshen.reception.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class ReceptionVehicleInfoServiceImpl extends ClimsServiceBase implements IreceptionVehicleInfoService{

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
	
	int recoverEX = 0;//异常恢复数量
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
	public ArrayList<ReceptionVehicleInfo> getReceptionVehicleInfo(ReceptionVehicleInfo rVehicleInfo,int start,	int size,Session session) throws Exception{
		if(session==null){
			session= HibernateUtil.getSession();
		}
		
		try{
			List<ReceptionVehicleInfo> list = new ArrayList();
			
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
			    	ReceptionVehicleInfo receptionVehicleInfo = list.get(i);
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
	public ArrayList<ReceptionVehicleInfo> getReceptionVehicleInfo(ReceptionVehicleInfo rVehicleInfo,int start,	int size) throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<ReceptionVehicleInfo> list = new ArrayList();
			
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
		    Query query = session.createQuery(hql + condition+" order by rVehicleInfo.resaveds1_s");
		    System.out.println("sql:"+hql + condition+" order by rVehicleInfo.resaveds1_s");
		    if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();
		 
		    //查询道路ID对应的名称
		    if(BasicTools.isnotNull(list)){
			    for (int i = 0; i < list.size(); i++) {
			    	String roadName="";
			    	ReceptionVehicleInfo receptionVehicleInfo = list.get(i);
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
	public long getReceptionVehicleInfoNumber(ReceptionVehicleInfo rVehicleInfo)throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<ReceptionVehicleInfo> list = new ArrayList();

			if(rVehicleInfo == null){
				Query query=session.createQuery("select count(*) from ReceptionVehicleInfo");
			    if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			setReceptionVehicleInfoPro(rVehicleInfo);
			if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("")){
				rVehicleInfo = (ReceptionVehicleInfo)session.get(rVehicleInfo.getClass(), vehicleCPG_s);
		    	list.add(rVehicleInfo);
		    	return 1;
		    }
			
			String hql = "select count(*) from ReceptionVehicleInfo as rVehicleInfo where 1=1 "; 
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
	public void setReceptionVehicleInfoPro(ReceptionVehicleInfo rVehicleInfo){
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
		ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
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
	 * 保存计划车辆信息，在事务中处理
	 * 修改为同步，使发卡id不会出现主键重复
	 * saveOrUpdateReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public synchronized  String saveOrUpdateReceptionVehicleInfoByTransaction(ArrayList<ReceptionVehicleInfo> list,Session session) throws Exception{
		System.out.println("----------receptionvehiclelist010401---保存接待模块计划车辆信息--saveimpl---:"+list);	
		ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
		IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
		String cpg = ""; 
		String saveFlag = "";
		try{			
			if(list != null && list.size() > 0){
				
				for(int i = 0; i < list.size(); i++){
					//	vehicleCPG_s存在的情况，做更新处理
					rVehicleInfo = list.get(i);
					saveFlag = rVehicleInfo.getResaveds5_s();
					System.out.println("----------receptionvehiclelist010401---我开始用最开始的list,遍历on/off!!!保存接待模块计划车辆信息--saveimpl---:"+list);	
					
//					if(saveFlag == null||!saveFlag.equals("on"))
//					{
//						continue;
//					}
//					
					if(saveFlag.equals("on")){
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.SUBCPGBusiness, session);
						pk = pk+""+BasicTools.getRandom();
						rVehicleInfo.setVehicleCPG_s(pk);
						
						session.save(rVehicleInfo);
						session.flush();
					}
			
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
	 * 保存计划车辆信息，在事务中处理
	 * 修改为同步，使发卡id不会出现主键重复
	 * 确认订单后改为saveOrUpdateReceptionVehicleInfoByTransaction2
	 * saveOrUpdateReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 * 确认订单时候修改调用saveOrUpdateReceptionVehicleInfoByTransaction2
	 * 防止出错
	 */
	public synchronized  String saveOrUpdateReceptionVehicleInfoByTransaction2(ArrayList<ReceptionVehicleInfo> list,Session session) throws Exception{
		
		ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
		IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
		String cpg = ""; 
		try{			
			if(list != null && list.size() > 0){
				for(int i = 0; i < list.size(); i++){
					//	vehicleCPG_s存在的情况，做更新处理
					rVehicleInfo = list.get(i);
					String pk = systemSequenceServiceImpl.getPK(ConstantUtil.SUBCPGBusiness, session);
					rVehicleInfo.setVehicleCPG_s(pk);
					/*20150609 kxc
					 * if(list.get(i).getVehicleCPG_s() != null && !list.get(i).getVehicleCPG_s().equals("")){
						rVehicleInfo.setVehicleCPG_s(list.get(i).getVehicleCPG_s());
						//session.saveOrUpdate(rVehicleInfo);
						//	rVehicleInfo = this.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0,session).get(0);
					 
						//rVehicleInfo = (ReceptionVehicleInfo)session.get(ReceptionVehicleInfo.class, list.get(i).getVehicleCPG_s());
					} else {
						//	vehicleCPG_s不存在的情况，Sequence自动生成
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.SUBCPGBusiness, session);
						//	做插入处理
						rVehicleInfo.setVehicleCPG_s(pk);
					}*/
					/*if(list.get(i).getOrderID_s() != null&&!list.get(i).getOrderID_s().equals("")){
						rVehicleInfo.setOrderID_s(list.get(i).getOrderID_s());
					}
					if(list.get(i).getRoidIds_s()!= null&&!list.get(i).getRoidIds_s().equals("")){
						rVehicleInfo.setRoidIds_s(list.get(i).getRoidIds_s());
					}
					if(list.get(i).getVehicleID_s() != null&&!list.get(i).getVehicleID_s().equals("")){
						rVehicleInfo.setVehicleID_s(list.get(i).getVehicleID_s());
					}
					if(list.get(i).getColor_s() != null&&!list.get(i).getColor_s().equals("")){
						rVehicleInfo.setColor_s(list.get(i).getColor_s());
					}
					if(list.get(i).getModel_s() != null&&!list.get(i).getModel_s().equals("")){
						rVehicleInfo.setModel_s(list.get(i).getModel_s());
					}
					if(list.get(i).getFieldID_s() != null && !list.get(i).getFieldID_s().equals("")){
						rVehicleInfo.setFieldID_s(list.get(i).getFieldID_s());
					}
					if(list.get(i).getInterPhoneID_s() != null && !list.get(i).getInterPhoneID_s().equals("")){
						rVehicleInfo.setInterPhoneID_s(list.get(i).getInterPhoneID_s());
					}
					if(list.get(i).getCreateUser_s() != null &&!list.get(i).getCreateUser_s().equals("")){
						rVehicleInfo.setCreateUser_s(list.get(i).getCreateUser_s());
					}
					if(list.get(i).getCreateDate_t() != null &&!list.get(i).getCreateDate_t().equals("")){
						rVehicleInfo.setCreateDate_t(list.get(i).getCreateDate_t());
					}
					
					
					if(list.get(i).getWeight_s() != null &&!list.get(i).getWeight_s().equals("")){
						rVehicleInfo.setWeight_s(list.get(i).getWeight_s());
					}
					if(list.get(i).getMaxWeight_s() != null &&!list.get(i).getMaxWeight_s().equals("")){
						rVehicleInfo.setMaxWeight_s(list.get(i).getMaxWeight_s());
					}
					if(list.get(i).getFuelConsumption_s() != null &&!list.get(i).getFuelConsumption_s().equals("")){
						rVehicleInfo.setFuelConsumption_s(list.get(i).getFuelConsumption_s());
					}
					if(list.get(i).getFuelDemand_s() != null &&!list.get(i).getFuelDemand_s().equals("")){
						rVehicleInfo.setFuelDemand_s(list.get(i).getFuelDemand_s());
					}
					if(list.get(i).getCategory_i() != null ){
						rVehicleInfo.setCategory_i(list.get(i).getCategory_i());
					}
					if(list.get(i).getLicensPlate_s()!= null &&!list.get(i).getLicensPlate_s().equals("")){
						rVehicleInfo.setLicensPlate_s(list.get(i).getLicensPlate_s());
					}
					if(list.get(i).getBrandType_s() != null &&!list.get(i).getBrandType_s().equals("")){
						rVehicleInfo.setBrandType_s(list.get(i).getBrandType_s());
					}
					if(list.get(i).getMaxSpeed_s()!= null &&!list.get(i).getMaxSpeed_s().equals("")){
						rVehicleInfo.setMaxSpeed_s(list.get(i).getMaxSpeed_s());
					}
					if(list.get(i).getVin_s()!= null &&!list.get(i).getVin_s().equals("")){
						rVehicleInfo.setVin_s(list.get(i).getVin_s());
					}
					if(list.get(i).getAxleNumber_i()!= null &&!list.get(i).getAxleNumber_i().equals("")){
						rVehicleInfo.setAxleNumber_i(list.get(i).getAxleNumber_i());
					}*/
					session.save(rVehicleInfo);
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
		IreceptionVehicleInfoService IreceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
		ReceptionVehicleInfo receptionVehicleInfo = new ReceptionVehicleInfo();
		receptionVehicleInfo.setOrderID_s(orderid);
		List<ReceptionVehicleInfo> receptionVehicleList = IreceptionVehicleInfoService.getReceptionVehicleInfo(receptionVehicleInfo, ConstantUtil.pagingNot, 1,session);
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
	 * 不按订单保存车卡权限信息表(oracle)
	 * assemblyJurisdictionInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<BarrierGateJurisdiction> saveNotOrderJurisdictionInfo(String orderid,Session session) throws Exception{
		
		//获得order对象
		IreceptionOrderService ireceptionOrderService = new ReceptionOrderServiceImpl();			 
		ReceptionOrder receptionOrder = new ReceptionOrder();
		receptionOrder.setOrderID_s(orderid);
		receptionOrder = ireceptionOrderService.getReceptionOrder(receptionOrder, ConstantUtil.pagingNot, 1).get(0);
		//获得计划车辆信息
		IreceptionVehicleInfoService IreceptionVehicleInfoService = new ReceptionVehicleInfoServiceImpl();
		ReceptionVehicleInfo receptionVehicleInfo = new ReceptionVehicleInfo();
		receptionVehicleInfo.setOrderID_s(orderid);
		List<ReceptionVehicleInfo> receptionVehicleList = IreceptionVehicleInfoService.getReceptionVehicleInfo(receptionVehicleInfo, ConstantUtil.pagingNot, 1,session);
		//保存车卡权限信息表
		BarrierGateJurisdictionService barrierGateJurisdictionService = new BarrierGateJurisdictionServiceImpl();
		List<BarrierGateJurisdiction> bjlist = new ArrayList();
		
		//获得道路相关道闸
		IBarrierGateService iBarrierGateService = new BarrierGateServiceImpl();
		if(receptionVehicleList!=null&&receptionVehicleList.size()>0){
			for(int i=0;i<receptionVehicleList.size();i++){
				receptionVehicleInfo = receptionVehicleList.get(i);
				//道路ID集合
				String[] roidIds_s = StringTools.split("vv",  receptionVehicleInfo.getRoidIds_s());
				if(roidIds_s.length>0){
					for(int j=0;j<roidIds_s.length;j++){
						
						//根据道路id获得该进入该道路的道闸信息
						BarrierGate barrierGate = new BarrierGate();
						barrierGate.setEntranceRoadIDs(roidIds_s[j]);
						ArrayList<BarrierGate> barrierGateList= iBarrierGateService.getBasisBarrierGateInfo(barrierGate, ConstantUtil.pagingNot,0);
						if(BasicTools.isnotNull(barrierGateList)){
							for(int m=0;m<barrierGateList.size();m++){
								barrierGate = barrierGateList.get(m);
								BarrierGateJurisdiction barrierGateJurisdiction = new BarrierGateJurisdiction();
								barrierGateJurisdiction.setCardID_s(receptionVehicleInfo.getVehicleID_s());
								barrierGateJurisdiction.setEditFlagTime_t(new Date());
								barrierGateJurisdiction.setEffectiveTime_t(receptionOrder.getStartDate_d());
								barrierGateJurisdiction.setInvalidationTime_t(receptionOrder.getEndDate_d());
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
	public int deleteReceptionVehicleInfoByTx(ArrayList<ReceptionVehicleInfo> list,Session session)  {		
		ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();		 
		 
		System.out.println("----------receptionvehiclelist010301---开始删除计划车辆信息---del:"+list);

		
		
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					if(!list.get(i).getOrderID_s().equals("")){
						rVehicleInfo.setOrderID_s(list.get(i).getOrderID_s());
					}
						
//				String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.resaveds5_s ='"+list.get(i).getResaveds5_s()+"'";
//						session.createQuery(deleteParentSql).executeUpdate();
					
				if(list.get(i).getVehicleCPG_s()!=null&&!list.get(i).getVehicleCPG_s().equals("")&&(list.get(i).getResaveds5_s()==null?true:list.get(i).getResaveds5_s().equals("on"))){
						rVehicleInfo.setVehicleCPG_s(list.get(i).getVehicleCPG_s());
					/*	rVehicleInfo = this.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pageSize, 0).get(0);
						rVehicleInfo.setResaveds3_s("1");*/
      					String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.vehicleCPG_s ='"+list.get(i).getVehicleCPG_s().replace("\r\n", "")+"'";
						session.createQuery(deleteParentSql).executeUpdate();
						
					/*	session.delete(rVehicleInfo);
						session.flush();	*/	
					}
					else{ //20150514 kxc 
						System.out.println("iii====="+list.get(i).getOrderID_s());
						String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.orderID_s='"+list.get(i).getOrderID_s()+"'";
					 
						session.createQuery(deleteParentSql).executeUpdate();
					}		
				}
				}
			else
				{
				//删除临时添加的但没发卡的车辆记录
				String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.vehicleID_s is null and r.resaveds2_s is null";
				session.createQuery(deleteParentSql).executeUpdate();
			}
			session.flush();
			return 1;
		
	}
	/**
	 * GK鍏崱鍒犻櫎璁″垝杞﹁締淇℃伅 need fix text 
	 * deleteReceptionVehicleInfo
	 * @param   ArrayList<ReceptionVehicleInfo>
	 * @return   1. 鎴愬姛
	 * @Exception 寮傚父瀵硅薄
	 * @since  CodingExample銆€Ver(缂栫爜鑼冧緥鏌ョ湅) 1.1
	 */
	public int deleteReceptionVehicleInfoByTxGKService(ArrayList<ReceptionVehicleInfo> list,Session session)  {
	  ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();

	    if(list != null){
	      for(int i = 0; i < list.size(); i++){
	        if(!list.get(i).getOrderID_s().equals("")){
	          rVehicleInfo.setOrderID_s(list.get(i).getOrderID_s());
	        }
	        if(list.get(i).getVehicleCPG_s()!=null&&!list.get(i).getVehicleCPG_s().equals("")){
	          rVehicleInfo.setVehicleCPG_s(list.get(i).getVehicleCPG_s());
	        /*	rVehicleInfo = this.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pageSize, 0).get(0);
	          rVehicleInfo.setResaveds3_s("1");*/
	          String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.vehicleCPG_s ='"+list.get(i).getVehicleCPG_s()+"'";
	          session.createQuery(deleteParentSql).executeUpdate();

	        /*	session.delete(rVehicleInfo);
	          session.flush();	*/
	        }else{ //20150514 kxc
	          System.out.println("iii====="+list.get(i).getOrderID_s());
	          String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.orderID_s='"+list.get(i).getOrderID_s()+"'";

	          session.createQuery(deleteParentSql).executeUpdate();
	        }
	      }
	    }else{
	      //鍒犻櫎涓存椂娣诲姞鐨勪絾娌″彂鍗＄殑杞﹁締璁板綍
	      String deleteParentSql = "delete from ReceptionVehicleInfo as r where r.vehicleID_s is null and r.resaveds2_s is null";
	      session.createQuery(deleteParentSql).executeUpdate();
	    }
	    session.flush();
	    return 1;

	}
	
	/**
	 * 删除计划车辆信息
	 * deleteReceptionVehicleInfo 
	 * @param   ArrayList<ReceptionVehicleInfo>    
	 * @return   1. 成功 
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteReceptionVehicleInfo(ArrayList<ReceptionVehicleInfo> list) throws Exception{
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
	 * 车卡发放方法
	 * 1、保存接待模块计划车辆信息
	 * 2、保存oracle车卡权限信息表
	 * 3、保存sql server车卡权限信息表
	 * saveJurisdiction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int provideJurisdiction(ArrayList<ReceptionVehicleInfo> receptionvehiclelist,String orderids,List cancelList) throws Exception{
		int i = this.lockOrder(orderids);
		if(i==1){
			return 0;
		}
		Session session = HibernateUtil.getSession();
		try{
			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}
			tx = session.beginTransaction();//开启事务
			ReceptionVehicleInfo r = new ReceptionVehicleInfo();
			r.setOrderID_s(orderids); 
			//作废之前卡权限 20150608 
			TBarriergateCancellationBak tmp = null;
			//订单原车辆记录
			ArrayList<ReceptionVehicleInfo> receptionVehicleInfoListOld = this.getReceptionVehicleInfo(r, ConstantUtil.pagingNot,0, session);
			List<TBarriergateCancellationBak> tBarriergateCancellationBakList = new ArrayList(); 
			for(ReceptionVehicleInfo rvmodel:receptionVehicleInfoListOld){
				//当该车卡在其它订单中有效期大于当前订单有效期，则不能作废该车卡权限 20150609
				if(cancelList.lastIndexOf(rvmodel.getVehicleID_s())!=-1){
					continue;
				}
				tmp = new TBarriergateCancellationBak();
				tmp.setCardidS(rvmodel.getVehicleID_s());
				Calendar cal1 = Calendar.getInstance();
				tmp.setEditflagtimeT(cal1.getTime());
				tBarriergateCancellationBakList.add(tmp);
			}
			receptionVehicleInfoListOld = null;
			IbarrierGateCancellationService IbarrierGateCancellationService = new BarrierGateCancellationServiceImpl();
			
			//将计划车辆信息保存到备份表:先删除之前该订单的车辆信息
			IreceptionVehicleInfoBakService ireceptionVehicleInfoBakService = new ReceptionVehicleInfoBakServiceImpl();
			ArrayList<ReceptionVehicleInfoBak> tmplist = new ArrayList<ReceptionVehicleInfoBak>();
			//kxc 2016-12-5注释 start
			/*ReceptionVehicleInfoBak tmpRVinfo = new ReceptionVehicleInfoBak();
			tmpRVinfo.setOrderID_s(orderids);
			tmplist.add(tmpRVinfo);		*/	
			// kxc 2016-12-5注释 end
			//ireceptionVehicleInfoBakService.deleteReceptionVehicleInfoByTx(tmplist,session);			
			//tx.commit();
			//将计划车辆信息保存到备份表
			//tx = session.beginTransaction();//开启事务
			System.out.println("----------receptionvehiclelist0102---save BAK:"+receptionvehiclelist);
			ireceptionVehicleInfoBakService.saveOrUpdateReceptionVehicleInfoByTransaction(receptionvehiclelist,session);
			tx.commit();
			System.out.println("----------receptionvehiclelist010201---save BAK END OK:"+receptionvehiclelist);
			
			
			System.out.println("----------receptionvehiclelist0103---开始删除计划车辆信息:"+receptionvehiclelist);
			tx = session.beginTransaction();//开启事务
			//删除order对应的计划车辆信息表
			ArrayList<ReceptionVehicleInfo>  dlist = new ArrayList();
			
			for(i=0;i<receptionvehiclelist.size();i++)
			{
		
//				
//				if(r.getVehicleCPG_s()==null || r.getVehicleCPG_s().equals(""))
//				{
//					continue;
//				}
//				
				r = new ReceptionVehicleInfo();
				r.setOrderID_s(orderids); 
				if(receptionvehiclelist.get(i).getResaveds5_s().equals("on")){
					r.setVehicleCPG_s(receptionvehiclelist.get(i).getVehicleCPG_s());
					r.setResaveds5_s(receptionvehiclelist.get(i).getResaveds5_s());
					dlist.add(r);
				}
//				System.out.println(receptionvehiclelist.get(i).getResaveds5_s());
//				if(receptionvehiclelist.get(i).getResaveds5_s() != null && receptionvehiclelist.get(i).getResaveds5_s().equals("on"))
//				{
//					dlist.add(r);
//				}
				else
				{
					if(i ==receptionvehiclelist.size()-1 )
					{
						
					}
					else
					{

						continue;
					}
				}
//				System.out.println(dlist);
				
			}
			if(dlist.size()>0)
			{
				deleteReceptionVehicleInfoByTx(dlist,session);
			}
			tx.commit();
			System.out.println("----------receptionvehiclelist0103---开始删除计划车辆信息---END:"+receptionvehiclelist);

			
			
			System.out.println("----------receptionvehiclelist0104---删除完了,我想拿数据了吧---:"+receptionvehiclelist);			
			tx = session.beginTransaction();//开启事务
			//保存接待模块计划车辆信息
			System.out.println("----------receptionvehiclelist010401---保存接待模块计划车辆信息---:"+receptionvehiclelist);			
			saveOrUpdateReceptionVehicleInfoByTransaction(receptionvehiclelist,session);
			System.out.println("----------receptionvehiclelist010401---保存接待模块计划车辆信息END---:"+receptionvehiclelist);	
 			//保存到车卡权限作废信息表中(oracle)
			tBarriergateCancellationBakList = IbarrierGateCancellationService.CancellationCard(tBarriergateCancellationBakList,session);
			//作废卡权限sql server zanshi
			IbarrierGateCancellationService.CancellationCardSql(tBarriergateCancellationBakList);
			
			//保存车卡权限信息表(oracle)
			List<BarrierGateJurisdiction> list = this.saveJurisdictionInfo(orderids,session);
			
			//向sql server中间表写数据  zanshi
			BarrierGateJurisdictionService barrierGateJurisdictionService = new BarrierGateJurisdictionServiceImpl();
			int request = barrierGateJurisdictionService.saveSQLJurisdictionInfo(list,cancelList);
			 
			tx.commit();
			System.out.println("----------receptionvehiclelist0104---end---OK,我好想存完了---:"+receptionvehiclelist);			

		}catch (Exception e){
			tx.rollback();
			e.printStackTrace();
		//	this.recoverOrderInfo(receptionvehiclelist, orderids, cancelList);
			throw new Exception(e);
		}finally{
			 session.clear();
			 session.close();
			 this.unlockOrder(orderids);
		}
		return 1;
	}
	
	/**
	 * 公卡发放车卡发放方法位置：servie/impl/IreceptionVehicleInfoServiceImpl
	 * 1、保存接待模块计划车辆信息
	 * 2、保存oracle车卡权限信息表
	 * 3、保存sql server车卡权限信息表
	 * saveJurisdiction
	 * @param   name
	 * @param  @return    设定文件
	 * @return String
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int provideJurisdictionGKService(ArrayList<ReceptionVehicleInfo> receptionvehiclelist,String orderids,List cancelList) throws Exception{
	  int i = this.lockOrder(orderids);
	  if(i==1){
	    return 0;
	  }
	  Session session = HibernateUtil.getSession();
	  try{
	    if(!session.isOpen()){
	      session = HibernateUtil.getSession();
	    }
	    tx = session.beginTransaction();//开启事务
	    ReceptionVehicleInfo r = new ReceptionVehicleInfo();
	    r.setOrderID_s(orderids);
	    //作废之前卡权限 20150608
	    TBarriergateCancellationBak tmp = null;
	    //订单原车辆记录
	    ArrayList<ReceptionVehicleInfo> receptionVehicleInfoListOld = this.getReceptionVehicleInfo(r, ConstantUtil.pagingNot,0, session);
	    List<TBarriergateCancellationBak> tBarriergateCancellationBakList = new ArrayList();
	    for(ReceptionVehicleInfo rvmodel:receptionVehicleInfoListOld){
	      //当该车卡在其它订单中有效期大于当前订单有效期，则不能作废该车卡权限 20150609
	      if(cancelList.lastIndexOf(rvmodel.getVehicleID_s())!=-1){
	        continue;
	      }
	      tmp = new TBarriergateCancellationBak();
	      tmp.setCardidS(rvmodel.getVehicleID_s());
	      Calendar cal1 = Calendar.getInstance();
	      tmp.setEditflagtimeT(cal1.getTime());
	      tBarriergateCancellationBakList.add(tmp);
	    }
	    receptionVehicleInfoListOld = null;
	    IbarrierGateCancellationService IbarrierGateCancellationService = new BarrierGateCancellationServiceImpl();

	    //将计划车辆信息保存到备份表:先删除之前该订单的车辆信息
	    IreceptionVehicleInfoBakService ireceptionVehicleInfoBakService = new ReceptionVehicleInfoBakServiceImpl();
	    ArrayList<ReceptionVehicleInfoBak> tmplist = new ArrayList<ReceptionVehicleInfoBak>();
	    ReceptionVehicleInfoBak tmpRVinfo = new ReceptionVehicleInfoBak();
	    tmpRVinfo.setOrderID_s(orderids);
	    tmplist.add(tmpRVinfo);
	    //ireceptionVehicleInfoBakService.deleteReceptionVehicleInfoByTx(tmplist,session);
	    //tx.commit();
	    //将计划车辆信息保存到备份表
	    //tx = session.beginTransaction();//开启事务
	    ireceptionVehicleInfoBakService.saveOrUpdateReceptionVehicleInfoByTransaction(receptionvehiclelist,session);
	    tx.commit();

	    tx = session.beginTransaction();//开启事务
	    //删除order对应的计划车辆信息表
	    ArrayList<ReceptionVehicleInfo>  dlist = new ArrayList();
	    dlist.add(r);
	    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	    deleteReceptionVehicleInfoByTxGKService(dlist,session);
	    tx.commit();
	    tx = session.beginTransaction();//开启事务
	    //保存接待模块计划车辆信息
	    saveOrUpdateReceptionVehicleInfoByTransaction2(receptionvehiclelist,session);
	    
	    System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	    //保存到车卡权限作废信息表中(oracle)
	    tBarriergateCancellationBakList = IbarrierGateCancellationService.CancellationCard(tBarriergateCancellationBakList,session);
	    //作废卡权限sql server zanshi
	    IbarrierGateCancellationService.CancellationCardSql(tBarriergateCancellationBakList);

	    /*20150608 kxc
	    //作废之前卡权限
	    if(receptionvehiclelist!=null&&receptionvehiclelist.size()>0){
	      TBarriergateCancellationBak tmp = null;
	      List<TBarriergateCancellationBak> tBarriergateCancellationBakList = new ArrayList();
	      for(ReceptionVehicleInfo rvmodel:receptionvehiclelist){
	        tmp = new TBarriergateCancellationBak();
	        tmp.setCardidS(rvmodel.getVehicleID_s());
	        Calendar cal1 = Calendar.getInstance();
	        tmp.setEditflagtimeT(cal1.getTime());
	        tBarriergateCancellationBakList.add(tmp);
	      }
	      IbarrierGateCancellationService IbarrierGateCancellationService = new BarrierGateCancellationServiceImpl();
	      tBarriergateCancellationBakList = IbarrierGateCancellationService.CancellationCard(tBarriergateCancellationBakList,session);
	      //作废卡权限sql server
	      IbarrierGateCancellationService.CancellationCardSql(tBarriergateCancellationBakList);
	    }*/

	    //保存车卡权限信息表(oracle)
	    List<BarrierGateJurisdiction> list = this.saveJurisdictionInfo(orderids,session);

	    //向sql server中间表写数据  zanshi
	    BarrierGateJurisdictionService barrierGateJurisdictionService = new BarrierGateJurisdictionServiceImpl();
	    int request = barrierGateJurisdictionService.saveSQLJurisdictionInfo(list,cancelList);

	    tx.commit();
	  }catch (Exception e){
	    tx.rollback();
	    e.printStackTrace();
	  //	this.recoverOrderInfo(receptionvehiclelist, orderids, cancelList);
	    throw new Exception(e);
	  }finally{
	     session.clear();
	     session.close();
	     this.unlockOrder(orderids);
	  }
	  return 1;
	}


	
	/**
	 * 当发卡出现错误使，使用备份表数据恢复该订单
	 */
	public void recoverOrderInfo(ArrayList<ReceptionVehicleInfo> receptionvehiclelist,String orderids,List cancelList)throws Exception{
		if(recoverEX!=0){
			return;
		}
		recoverEX++;
		Connection connora = HibernateUtil.getJDBCconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String str = "select * from t_reception_vehicleinfo b where  b.orderid_s ='"+orderids+"'";
		ps = connora.prepareStatement(str);
		rs = ps.executeQuery();
		if(rs.next()){
			return;
		}
		str = "insert into t_reception_vehicleinfo select * from t_reception_vehicleinfo_bak b where  b.orderid_s ='"+orderids+"'";
		try {
			Statement st = connora.createStatement();
			st.executeUpdate(str);
			connora.commit();
			try {
				this.provideJurisdiction(receptionvehiclelist, orderids, cancelList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e);
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
		saveOrUpdateReceptionVehicleInfoByTransaction2(receptionVehicleInfos,session);
	}
	
	
	public static void main(String[] a){
		ReceptionVehicleInfoServiceImpl impl = new ReceptionVehicleInfoServiceImpl();
		try {
			ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
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
	

	/**
	 * 查询订单状态，如果订单被锁返回1，否则锁订单返回0
	 * @param orderID
	 * @return
	 * @throws Exception
	 */
	public int lockOrder(String orderID) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection connora = HibernateUtil.getJDBCconn();
		try {			
			String str = "select resaveds2_s from t_reception_order b where  b.orderid_s ='"+orderID+"'";
			ps = connora.prepareStatement(str);
			rs = ps.executeQuery();
			String lock = "";
			if(rs.next()){
				lock = rs.getString("resaveds2_s");
			}
			if(lock==null||!"1".equals(lock)){
				str = "update t_reception_order b set resaveds2_s='1' ";
//				str = "update t_reception_order b set resaveds2_s='1' where  b.orderid_s ='"+orderID+"'";
				Statement st = connora.createStatement();
				st.executeUpdate(str);
				connora.commit();
				return 0;
			}else{
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connora.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			if (ps != null) {
			   ps.close();
		 	   ps = null;
		   } 
		   connora.close();
		   connora = null;			 
		}		
 	}
	
	/**
	 * 解锁
	 * @param orderID
	 * @return
	 * @throws Exception
	 */
	public void unlockOrder(String orderID) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection connora = HibernateUtil.getJDBCconn();
		try {			
			String str = "update t_reception_order b set resaveds2_s='0' where  b.orderid_s ='"+orderID+"'";
			Statement st = connora.createStatement();
			st.executeUpdate(str);
			connora.commit();
			return ;		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connora.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}finally{
			if (ps != null) {
			   ps.close();
		 	   ps = null;
		   } 
		   connora.close();
		   connora = null;			 
		}		
 	}
}
