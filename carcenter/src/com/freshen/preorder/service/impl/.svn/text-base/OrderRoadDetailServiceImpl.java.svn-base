package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.basis.RoadExperimentType;
import com.freshen.preorder.service.IorderRoadDetailsService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;



public class OrderRoadDetailServiceImpl extends ClimsServiceBase implements IorderRoadDetailsService {

	String orderRoadID_s, orderID_s;
	Integer status_i;
	Date startDate_t;
	Date endDate_t;
	String type_s, roadID_s, roadName_s, hoursNumber_s;
	 
	String maxSpeed_s, description_s;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	Integer maxCapacity_i; //最大容量
	Integer isok; //建议是否审核通过 1:是 0:否
	String experimentTypeID_s;//试验类型ID
	RoadExperimentType roadExperimentTypeModel;//道路试验类型基础信息表
	Integer billingMode_i;//计费方式 1按时间计费，2按里程计费
	String carIndex_s;//车辆序号
	String carCPG_s;//试验车辆的CPG牌照号
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public int OperationRoadDetail(List<OrderRoadDetail> orderRoadDetail,
			int operation, Session session) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(orderRoadDetail!=null && orderRoadDetail.size()>0){
				
				for(int i=0;i<orderRoadDetail.size();i++){
					OrderRoadDetail ord = orderRoadDetail.get(i);
					if(operation==1){
						session.saveOrUpdate(ord);
						session.flush();
					    session.clear();
					}
					//删除
					if(operation==2){
						session.delete(ord);
						session.flush();
						session.clear();
					}
					return 1;
				}
			}
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
		return 0;
	}

	public ArrayList<OrderRoadDetail> getBasisOrderRoadDetail(
			OrderRoadDetail orderRoadDetail, int start, int size)
			throws Exception {
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		
		try {
			List<OrderRoadDetail> list = new ArrayList<OrderRoadDetail>();
			if(orderRoadDetail == null){
				Query query = session.createQuery("from OrderRoadDetail as orderRoadDetail ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				
				return (ArrayList)list;
			}
			orderRoadID_s= orderRoadDetail.getOrderRoadID_s();
			orderID_s = orderRoadDetail.getOrderID_s();
			status_i = orderRoadDetail.getStatus_i();
			startDate_t = orderRoadDetail.getStartDate_t();
			endDate_t = orderRoadDetail.getEndDate_t();
			type_s = orderRoadDetail.getType_s(); 
			roadID_s = orderRoadDetail.getRoadID_s();
			roadName_s = orderRoadDetail.getRoadName_s();
			hoursNumber_s = orderRoadDetail.getHoursNumber_s();
			 
			maxSpeed_s = orderRoadDetail.getMaxSpeed_s();
			description_s = orderRoadDetail.getDescription_s();
			createDate_t = orderRoadDetail.getCreateDate_t();
			createUser_s = orderRoadDetail.getCreateUser_s();
			lastUpdateUser_s = orderRoadDetail.getLastUpdateUser_s();
			lastUpdateDate_t = orderRoadDetail.getLastUpdateDate_t();
			resaveds1_s = orderRoadDetail.getResaveds1_s();
			resaveds2_s = orderRoadDetail.getResaveds2_s();
			resaveds3_s = orderRoadDetail.getResaveds3_s();
			resaveds4_s = orderRoadDetail.getResaveds4_s();
			resaveds5_s = orderRoadDetail.getResaveds5_s();
			maxCapacity_i=orderRoadDetail.getMaxCapacity_i(); //最大容量
			isok = orderRoadDetail.getIsok(); //建议是否审核通过 1:是 0:否
			experimentTypeID_s= orderRoadDetail.getExperimentTypeID_s();//试验类型ID
			roadExperimentTypeModel = orderRoadDetail.getRoadExperimentTypeModel();//道路试验类型基础信息表
			billingMode_i = orderRoadDetail.getBillingMode_i();//计费方式 1按时间计费，2按里程计费
			carIndex_s = orderRoadDetail.getCarIndex_s();//车辆序号
			carCPG_s = orderRoadDetail.getCarCPG_s();//试验车辆的CPG牌照号
			
			String hql = " from OrderRoadDetail as orderRoadDetail where 1=1 ";
			String condition="";
			
			if(orderRoadID_s!=null && !orderRoadID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.orderRoadID_s like '%" + orderRoadID_s.trim() + "%'";
			}
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			if(status_i!=null ){
				condition = condition + " and orderRoadDetail.status_i = '" + status_i + "'";
			}
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			if(type_s!=null && !type_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.type_s like '%" + type_s.trim() + "%'";
			}
			if(roadID_s!=null && !roadID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.roadID_s like '%" + roadID_s.trim() + "%'";
			}
			if(roadName_s!=null && !roadName_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.roadName_s like '%" + roadName_s.trim() + "%'";
			}
			if(hoursNumber_s!=null && !hoursNumber_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.hoursNumber_s like '%" + hoursNumber_s.trim() + "%'";
			}
			if(maxSpeed_s!=null && !maxSpeed_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.maxSpeed_s like '%" + maxSpeed_s.trim() + "%'";
			} 
			if(description_s!=null && !description_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.description_s like '%" + description_s.trim() + "%'";
			} 
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			if(createUser_s!=null && !createUser_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.createUser_s like '%" + createUser_s.trim() + "%'";
			} 
			if(lastUpdateUser_s!=null && !lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			} 
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			if(resaveds1_s!=null && !resaveds1_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			} 
			if(resaveds2_s!=null && !resaveds2_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			} 
			if(resaveds3_s!=null && !resaveds3_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			} 
			if(resaveds4_s!=null && !resaveds4_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			} 
			if(resaveds5_s!=null && !resaveds5_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			} 
			if(maxCapacity_i!=null ){
				condition = condition + " and orderRoadDetail.maxCapacity_i like ='" + maxCapacity_i + "'";
			} 
			if(isok!=null ){
				condition = condition + " and orderRoadDetail.isok = '" + isok + "'";
			} 
			if(experimentTypeID_s!=null && !experimentTypeID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.experimentTypeID_s like '%" + experimentTypeID_s.trim() + "%'";
			} 
//			if(maxSpeed_s!=null && !maxSpeed_s.trim().equals("")){
//				condition = condition + " and orderRoadDetail.maxSpeed_s like '%" + maxSpeed_s.trim() + "%'";
//			} 
//			roadExperimentTypeModel = orderRoadDetail.getRoadExperimentTypeModel();//道路试验类型基础信息表
			if(billingMode_i!=null ){
				condition = condition + " and orderRoadDetail.billingMode_i = '" + billingMode_i + "'";
			} 
			if(carIndex_s!=null && !carIndex_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.carIndex_s like '%" + carIndex_s.trim() + "%'";
			} 
			if(carCPG_s!=null && !carCPG_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.carCPG_s like '%" + carCPG_s.trim() + "%'";
			} 
			
		    Query query = session.createQuery(hql+condition);
		    if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
		    
		    return (ArrayList)list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
		return null;
	}
	
	public long getBasisOrderRoadDetail(
			OrderRoadDetail orderRoadDetail)
			throws Exception {
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<OrderRoadDetail> list = new ArrayList<OrderRoadDetail>();
			if(orderRoadDetail == null){
				Query query = session.createQuery("select count(*) from OrderRoadDetail as orderRoadDetail ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			orderRoadID_s= orderRoadDetail.getOrderRoadID_s();
			orderID_s = orderRoadDetail.getOrderID_s();
			status_i = orderRoadDetail.getStatus_i();
			startDate_t = orderRoadDetail.getStartDate_t();
			endDate_t = orderRoadDetail.getEndDate_t();
			type_s = orderRoadDetail.getType_s(); 
			roadID_s = orderRoadDetail.getRoadID_s();
			roadName_s = orderRoadDetail.getRoadName_s();
			hoursNumber_s = orderRoadDetail.getHoursNumber_s();
			 
			maxSpeed_s = orderRoadDetail.getMaxSpeed_s();
			description_s = orderRoadDetail.getDescription_s();
			createDate_t = orderRoadDetail.getCreateDate_t();
			createUser_s = orderRoadDetail.getCreateUser_s();
			lastUpdateUser_s = orderRoadDetail.getLastUpdateUser_s();
			lastUpdateDate_t = orderRoadDetail.getLastUpdateDate_t();
			resaveds1_s = orderRoadDetail.getResaveds1_s();
			resaveds2_s = orderRoadDetail.getResaveds2_s();
			resaveds3_s = orderRoadDetail.getResaveds3_s();
			resaveds4_s = orderRoadDetail.getResaveds4_s();
			resaveds5_s = orderRoadDetail.getResaveds5_s();
			maxCapacity_i=orderRoadDetail.getMaxCapacity_i(); //最大容量
			isok = orderRoadDetail.getIsok(); //建议是否审核通过 1:是 0:否
			experimentTypeID_s= orderRoadDetail.getExperimentTypeID_s();//试验类型ID
			roadExperimentTypeModel = orderRoadDetail.getRoadExperimentTypeModel();//道路试验类型基础信息表
			billingMode_i = orderRoadDetail.getBillingMode_i();//计费方式 1按时间计费，2按里程计费
			carIndex_s = orderRoadDetail.getCarIndex_s();//车辆序号
			carCPG_s = orderRoadDetail.getCarCPG_s();//试验车辆的CPG牌照号
			
			String hql = " select count(*) from OrderRoadDetail as orderRoadDetail where 1= 1 ";
			String condition="";
			
			if(orderRoadID_s!=null && !orderRoadID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.orderRoadID_s like '%" + orderRoadID_s.trim() + "%'";
			}
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			if(status_i!=null ){
				condition = condition + " and orderRoadDetail.status_i = '" + status_i + "'";
			}
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			if(type_s!=null && !type_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.type_s like '%" + type_s.trim() + "%'";
			}
			if(roadID_s!=null && !roadID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.roadID_s like '%" + roadID_s.trim() + "%'";
			}
			if(roadName_s!=null && !roadName_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.roadName_s like '%" + roadName_s.trim() + "%'";
			}
			if(hoursNumber_s!=null && !hoursNumber_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.hoursNumber_s like '%" + hoursNumber_s.trim() + "%'";
			}
			if(maxSpeed_s!=null && !maxSpeed_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.maxSpeed_s like '%" + maxSpeed_s.trim() + "%'";
			} 
			if(description_s!=null && !description_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.description_s like '%" + description_s.trim() + "%'";
			} 
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			if(createUser_s!=null && !createUser_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.createUser_s like '%" + createUser_s.trim() + "%'";
			} 
			if(lastUpdateUser_s!=null && !lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			} 
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderRoadDetail.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			if(resaveds1_s!=null && !resaveds1_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			} 
			if(resaveds2_s!=null && !resaveds2_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			} 
			if(resaveds3_s!=null && !resaveds3_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			} 
			if(resaveds4_s!=null && !resaveds4_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			} 
			if(resaveds5_s!=null && !resaveds5_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			} 
			if(maxCapacity_i!=null ){
				condition = condition + " and orderRoadDetail.maxCapacity_i like ='" + maxCapacity_i + "'";
			} 
			if(isok!=null ){
				condition = condition + " and orderRoadDetail.isok = '" + isok + "'";
			} 
			if(experimentTypeID_s!=null && !experimentTypeID_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.experimentTypeID_s like '%" + experimentTypeID_s.trim() + "%'";
			} 
//			if(maxSpeed_s!=null && !maxSpeed_s.trim().equals("")){
//				condition = condition + " and orderRoadDetail.maxSpeed_s like '%" + maxSpeed_s.trim() + "%'";
//			} 
//			roadExperimentTypeModel = orderRoadDetail.getRoadExperimentTypeModel();//道路试验类型基础信息表
			if(billingMode_i!=null ){
				condition = condition + " and orderRoadDetail.billingMode_i = '" + billingMode_i + "'";
			} 
			if(carIndex_s!=null && !carIndex_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.carIndex_s like '%" + carIndex_s.trim() + "%'";
			} 
			if(carCPG_s!=null && !carCPG_s.trim().equals("")){
				condition = condition + " and orderRoadDetail.carCPG_s like '%" + carCPG_s.trim() + "%'";
			} 
			
		    Query query = session.createQuery(hql+condition);
		    query.list().get(0);
		    if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
			}
			return n;
		} catch (Exception e) {
			//System.out.println(e.toString());
			// TODO: handle exception
		}finally{
			
		}
		return 0;
	}
	
	
	
}
