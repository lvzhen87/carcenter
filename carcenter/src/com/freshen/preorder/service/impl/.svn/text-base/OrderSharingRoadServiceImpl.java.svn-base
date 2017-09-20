package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.preorder.service.IorderSharingRoadService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OrderSharingRoadServiceImpl extends ClimsServiceBase implements IorderSharingRoadService {

	String orderSharingRoadID_s;
	String orderID_s;
	Integer status_i;
	String roadID_s;
	String roadName_s;
	String hoursNumber_s;
	String maxSpeed_s ;
	String description_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	Date startDate_t;
	Date endDate_t; 
	Integer carNumber_i;
	Integer isHighRiskTest_i;
	String highRiskTestDescription_s;
	Integer isCamera_i;
	String accidentPrevention_s;
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<OrderSharingRoad> getBasisOrderSharingRoad(
			OrderSharingRoad orderSharingRoad, int start, int size)
			throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		try {
			
			List<OrderSharingRoad> list = new ArrayList<OrderSharingRoad>();
			if(orderSharingRoad==null)
			{
				Query query = session.createQuery("from OrderSharingRoad as orderSharingRoad ");
				if(start != -1)
				{
					query.setFirstResult(start);		
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			String hql = " from OrderSharingRoad as orderSharingRoad where 1=1 ";
			String condition="";
			
			orderSharingRoadID_s = orderSharingRoad.getOrderSharingRoadID_s();
			if(orderSharingRoadID_s!= null &&!orderSharingRoadID_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.orderSharingRoadID_s like '%" + orderSharingRoadID_s.trim() + "%'";
			}
			orderID_s = orderSharingRoad.getOrderID_s();
			if(orderID_s!= null &&!orderID_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			status_i = orderSharingRoad.getStatus_i();
			if(status_i != null && status_i != -1){
				condition = condition + " and orderSharingRoad.orderID_s  = '" + status_i +"'";
			}
			roadID_s = orderSharingRoad.getRoadID_s();
			if(roadID_s!= null &&!roadID_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.roadID_s like '%" + roadID_s.trim() + "%'";
			}
			roadName_s = orderSharingRoad.getRoadName_s();
			if(roadName_s!= null &&!roadName_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.roadName_s like '%" + roadName_s.trim() + "%'";
			}
			hoursNumber_s = orderSharingRoad.getHoursNumber_s();
			if(hoursNumber_s!= null &&!hoursNumber_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.hoursNumber_s like '%" + hoursNumber_s.trim() + "%'";
			}
			maxSpeed_s  = orderSharingRoad.getMaxSpeed_s();
			if(maxSpeed_s!= null &&!maxSpeed_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.maxSpeed_s like '%" + maxSpeed_s.trim() + "%'";
			}
			description_s = orderSharingRoad.getDescription_s();
			if(description_s!= null &&!description_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.description_s like '%" + description_s.trim() + "%'";
			}
			createDate_t = orderSharingRoad.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }			
			createUser_s = orderSharingRoad.getCreateUser_s();
			if(createUser_s!= null &&!createUser_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderSharingRoad.getLastUpdateUser_s();
			if(lastUpdateUser_s!= null &&!lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderSharingRoad.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = orderSharingRoad.getResaveds1_s();
			if(resaveds1_s!= null &&!resaveds1_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			}
			resaveds2_s = orderSharingRoad.getResaveds2_s(); 
			if(resaveds2_s!= null &&!resaveds2_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			}
			resaveds3_s = orderSharingRoad.getResaveds3_s();
			if(resaveds3_s!= null &&!resaveds3_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			}
			resaveds4_s = orderSharingRoad.getResaveds4_s();
			if(resaveds4_s!= null &&!resaveds4_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			}
			resaveds5_s = orderSharingRoad.getResaveds5_s();
			if(resaveds5_s!= null &&!resaveds5_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			}
			startDate_t = orderSharingRoad.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderSharingRoad.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			carNumber_i = orderSharingRoad.getCarNumber_i();
			if(carNumber_i != null ){
			  	condition = condition + " and orderSharingRoad.carNumber_i ='" + carNumber_i+ "'";
			}
			isHighRiskTest_i = orderSharingRoad.getIsHighRiskTest_i();
			if(isHighRiskTest_i != null ){
			  	condition = condition + " and orderSharingRoad.isHighRiskTest_i ='" + isHighRiskTest_i+ "'";
			}
			highRiskTestDescription_s = orderSharingRoad.getHighRiskTestDescription_s();
			if(highRiskTestDescription_s != null && !highRiskTestDescription_s.trim().equals("")){
		    	condition = condition + " and orderSharingRoad.highRiskTestDescription_s like '%" + highRiskTestDescription_s.trim() + "%'";
		    }
			isCamera_i = orderSharingRoad.getIsCamera_i();
			if(isCamera_i != null ){
			  	condition = condition + " and orderSharingRoad.isCamera_i ='" + isCamera_i+ "'";
			}
			accidentPrevention_s = orderSharingRoad.getAccidentPrevention_s();
			if(accidentPrevention_s != null && !accidentPrevention_s.trim().equals("")){
		    	condition = condition + " and orderSharingRoad.accidentPrevention_s like '%" + accidentPrevention_s.trim() + "%'";
		    }
			
			condition = condition+" order by orderSharingRoad.orderSharingRoadID_s ";
		    Query query = session.createQuery(hql+condition);
		    
		    if(start != -1)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
		    
		    return (ArrayList)list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			session.clear();
		}
	}
	
	
	public long getBasisOrderSharingRoad(OrderSharingRoad orderSharingRoad)
	throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			
			List<OrderSharingRoad> list = new ArrayList<OrderSharingRoad>();
			if(orderSharingRoad==null)
			{
				Query query = session.createQuery(" select count(*) from OrderSharingRoad as orderSharingRoad ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			String hql = " select count(*) from OrderSharingRoad as orderSharingRoad where 1=1 ";
			String condition="";
			
			orderSharingRoadID_s = orderSharingRoad.getOrderSharingRoadID_s();
			if(orderSharingRoadID_s!= null &&!orderSharingRoadID_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.orderSharingRoadID_s like '%" + orderSharingRoadID_s.trim() + "%'";
			}
			orderID_s = orderSharingRoad.getOrderID_s();
			if(orderID_s!= null &&!orderID_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			status_i = orderSharingRoad.getStatus_i();
			if(status_i != null && status_i != -1){
				condition = condition + " and orderSharingRoad.orderID_s  = '" + status_i +"'";
			}
			roadID_s = orderSharingRoad.getRoadID_s();
			if(roadID_s!= null &&!roadID_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.roadID_s like '%" + roadID_s.trim() + "%'";
			}
			roadName_s = orderSharingRoad.getRoadName_s();
			if(roadName_s!= null &&!roadName_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.roadName_s like '%" + roadName_s.trim() + "%'";
			}
			hoursNumber_s = orderSharingRoad.getHoursNumber_s();
			if(hoursNumber_s!= null &&!hoursNumber_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.hoursNumber_s like '%" + hoursNumber_s.trim() + "%'";
			}
			maxSpeed_s  = orderSharingRoad.getMaxSpeed_s();
			if(maxSpeed_s!= null &&!maxSpeed_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.maxSpeed_s like '%" + maxSpeed_s.trim() + "%'";
			}
			description_s = orderSharingRoad.getDescription_s();
			if(description_s!= null &&!description_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.description_s like '%" + description_s.trim() + "%'";
			}
			createDate_t = orderSharingRoad.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }			
			createUser_s = orderSharingRoad.getCreateUser_s();
			if(createUser_s!= null &&!createUser_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderSharingRoad.getLastUpdateUser_s();
			if(lastUpdateUser_s!= null &&!lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderSharingRoad.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = orderSharingRoad.getResaveds1_s();
			if(resaveds1_s!= null &&!resaveds1_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			}
			resaveds2_s = orderSharingRoad.getResaveds2_s(); 
			if(resaveds2_s!= null &&!resaveds2_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			}
			resaveds3_s = orderSharingRoad.getResaveds3_s();
			if(resaveds3_s!= null &&!resaveds3_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			}
			resaveds4_s = orderSharingRoad.getResaveds4_s();
			if(resaveds4_s!= null &&!resaveds4_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			}
			resaveds5_s = orderSharingRoad.getResaveds5_s();
			if(resaveds5_s!= null &&!resaveds5_s.trim().equals("")){
				condition = condition + " and orderSharingRoad.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			}
			startDate_t = orderSharingRoad.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderSharingRoad.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderSharingRoad.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			carNumber_i = orderSharingRoad.getCarNumber_i();
			if(carNumber_i != null ){
			  	condition = condition + " and orderSharingRoad.carNumber_i ='" + carNumber_i+ "'";
			}
			isHighRiskTest_i = orderSharingRoad.getIsHighRiskTest_i();
			if(isHighRiskTest_i != null ){
			  	condition = condition + " and orderSharingRoad.isHighRiskTest_i ='" + isHighRiskTest_i+ "'";
			}
			highRiskTestDescription_s = orderSharingRoad.getHighRiskTestDescription_s();
			if(highRiskTestDescription_s != null && !highRiskTestDescription_s.trim().equals("")){
		    	condition = condition + " and orderSharingRoad.highRiskTestDescription_s like '%" + highRiskTestDescription_s.trim() + "%'";
		    }
			isCamera_i = orderSharingRoad.getIsCamera_i();
			if(isCamera_i != null ){
			  	condition = condition + " and orderSharingRoad.isCamera_i ='" + isCamera_i+ "'";
			}
			accidentPrevention_s = orderSharingRoad.getAccidentPrevention_s();
			if(accidentPrevention_s != null && !accidentPrevention_s.trim().equals("")){
		    	condition = condition + " and orderSharingRoad.accidentPrevention_s like '%" + accidentPrevention_s.trim() + "%'";
		    }
			
			condition = condition+" order by orderSharingRoad.orderSharingRoadID_s ";
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
			}
			return n;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally{
			session.clear();
		}
	}
		
	
	public int OperationOrderSharingRoad(
			List<OrderSharingRoad> orderSharingRoad, int operation)
			throws Exception {
		// TODO Auto-generated method stub
		tx = null;
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		tx=session.beginTransaction();//开启事务
		try {
			if(operation ==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				OrderSharingRoad sharingRoad = new OrderSharingRoad();
				if(orderSharingRoad!=null&&orderSharingRoad.size()>0){
					for(int i =0;i<orderSharingRoad.size();i++){
						sharingRoad = orderSharingRoad.get(i);
						if(orderSharingRoad.get(i).getOrderSharingRoadID_s() ==null || orderSharingRoad.get(i).getOrderSharingRoadID_s().trim().equals("")){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.GXCSBusiness, session);
							sharingRoad.setOrderSharingRoadID_s(cpg);
							session.merge(sharingRoad);
						}
						else{
							OrderSharingRoad tmp = (OrderSharingRoad)session.get(OrderSharingRoad.class, sharingRoad.getOrderSharingRoadID_s());
							orderID_s = sharingRoad.getOrderID_s();
							status_i = sharingRoad.getStatus_i();
							roadID_s = sharingRoad.getRoadID_s();
							roadName_s = sharingRoad.getRoadName_s();
							hoursNumber_s = sharingRoad.getHoursNumber_s();
							maxSpeed_s  = sharingRoad.getMaxSpeed_s();
							description_s = sharingRoad.getDescription_s();
							createDate_t = sharingRoad.getCreateDate_t();
							createUser_s = sharingRoad.getCreateUser_s();
							lastUpdateUser_s = sharingRoad.getLastUpdateUser_s();
							lastUpdateDate_t = sharingRoad.getLastUpdateDate_t();
							resaveds1_s = sharingRoad.getResaveds1_s();
							resaveds2_s = sharingRoad.getResaveds2_s(); 
							resaveds3_s = sharingRoad.getResaveds3_s();
							resaveds4_s = sharingRoad.getResaveds4_s();
							resaveds5_s = sharingRoad.getResaveds5_s();
							startDate_t = sharingRoad.getStartDate_t();
							endDate_t = sharingRoad.getEndDate_t();
							carNumber_i = sharingRoad.getCarNumber_i();
							isHighRiskTest_i = sharingRoad.getIsHighRiskTest_i();
							highRiskTestDescription_s = sharingRoad.getHighRiskTestDescription_s();
							isCamera_i = sharingRoad.getIsCamera_i();
							accidentPrevention_s =sharingRoad.getAccidentPrevention_s();
							if(orderID_s == null){
								sharingRoad.setOrderID_s(tmp.getOrderID_s());
							}
							if(status_i ==null){
								sharingRoad.setStatus_i(tmp.getStatus_i());
							}
							if(roadID_s == null){
								sharingRoad.setRoadID_s(tmp.getRoadID_s());
							}
							if(roadName_s == null){
								sharingRoad.setRoadName_s(tmp.getRoadName_s());
							}
							if(hoursNumber_s == null){
								sharingRoad.setHoursNumber_s(tmp.getHoursNumber_s());
							}
							if(maxSpeed_s == null){
								sharingRoad.setMaxSpeed_s(tmp.getMaxSpeed_s());
							}
							if(description_s == null){
								sharingRoad.setDescription_s(tmp.getDescription_s());
							}
							if(createDate_t == null){
								sharingRoad.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								sharingRoad.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								sharingRoad.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t == null){
								sharingRoad.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								sharingRoad.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								sharingRoad.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								sharingRoad.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								sharingRoad.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								sharingRoad.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(startDate_t == null){
								sharingRoad.setStartDate_t(tmp.getStartDate_t());
							}
							if(endDate_t == null){
								sharingRoad.setEndDate_t(tmp.getEndDate_t());
							}
							if(carNumber_i == null){
								sharingRoad.setCarNumber_i(tmp.getCarNumber_i());
							}
							if(isHighRiskTest_i == null){
								sharingRoad.setIsHighRiskTest_i(tmp.getIsHighRiskTest_i());
							}
							if(highRiskTestDescription_s == null){
								sharingRoad.setHighRiskTestDescription_s(tmp.getHighRiskTestDescription_s());
							}
							if(isCamera_i == null){
								sharingRoad.setIsCamera_i(tmp.getIsCamera_i());
							}
							if(accidentPrevention_s == null){
								sharingRoad.setAccidentPrevention_s(tmp.getAccidentPrevention_s());
							}
							session.merge(sharingRoad);
							
						}
						
						session.flush();
					    session.clear();
						
						
					}
				}
			}
			if(operation ==2){
				if(orderSharingRoad!=null&&orderSharingRoad.size()>0){
					for(int i =0;i<orderSharingRoad.size();i++){
						session.delete(orderSharingRoad.get(i));
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			return 1;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			throw e;
		}
		finally{
			session.clear();
		}
	}

	

	

}
