package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.cost.service.IOrderRoadCostBasisService;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.cost.service.impl.OrderRoadCostBasisServiceImpl;
import com.freshen.cost.service.impl.OrdercostInfoServiceImpl;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.cost.OrdercostInfo;
import com.freshen.entity.cost.TCostOrderroadcostbasis;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.NumTools;

public class OrderPreRoadServiceImpl extends ClimsServiceBase implements IorderPreRoadService {

	String orderPrepaymentRoadID_s;
	String orderID_s;
	Integer status_i;
	String roadID_s;
	String roadName_s;
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
	String timeQuantum_s;
	
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<OrderPreRoad> getBasisOrderPreRoad(
			OrderPreRoad orderPreRoad, int start, int size) throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		try {
			
			List<OrderPreRoad> list = new ArrayList<OrderPreRoad>();
			if(orderPreRoad==null)
			{
				Query query = session.createQuery("from OrderPreRoad as orderPreRoad ");
				if(start != -1)
				{
					query.setFirstResult(start);		
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			String hql = " from OrderPreRoad as orderPreRoad  where 1=1 ";
			String condition="";
			
			orderPrepaymentRoadID_s = orderPreRoad.getOrderPrepaymentRoadID_s();
			if(orderPrepaymentRoadID_s!= null &&!orderPrepaymentRoadID_s.trim().equals("")){
				condition = condition + " and orderPreRoad.orderPrepaymentRoadID_s like '%" + orderPrepaymentRoadID_s.trim() + "%'";
			}
			orderID_s = orderPreRoad.getOrderID_s();
			if(orderID_s!= null &&!orderID_s.trim().equals("")){
				condition = condition + " and orderPreRoad.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			status_i = orderPreRoad.getStatus_i();
			if(status_i != null && status_i != -1){
				condition = condition + " and orderPreRoad.orderID_s  = '" + status_i +"'";
			}
			roadID_s = orderPreRoad.getRoadID_s();
			if(roadID_s!= null &&!roadID_s.trim().equals("")){
				condition = condition + " and orderPreRoad.roadID_s like '%" + roadID_s.trim() + "%'";
			}
			roadName_s = orderPreRoad.getRoadName_s();
			if(roadName_s!= null &&!roadName_s.trim().equals("")){
				condition = condition + " and orderPreRoad.roadName_s like '%" + roadName_s.trim() + "%'";
			}
			createDate_t = orderPreRoad.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }			
			createUser_s = orderPreRoad.getCreateUser_s();
			if(createUser_s!= null &&!createUser_s.trim().equals("")){
				condition = condition + " and orderPreRoad.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderPreRoad.getLastUpdateUser_s();
			if(lastUpdateUser_s!= null &&!lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderPreRoad.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderPreRoad.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = orderPreRoad.getResaveds1_s();
			if(resaveds1_s!= null &&!resaveds1_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			}
			resaveds2_s = orderPreRoad.getResaveds2_s(); 
			if(resaveds2_s!= null &&!resaveds2_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			}
			resaveds3_s = orderPreRoad.getResaveds3_s();
			if(resaveds3_s!= null &&!resaveds3_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			}
			resaveds4_s = orderPreRoad.getResaveds4_s();
			if(resaveds4_s!= null &&!resaveds4_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			}
			resaveds5_s = orderPreRoad.getResaveds5_s();
			if(resaveds5_s!= null &&!resaveds5_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			}
			startDate_t = orderPreRoad.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderPreRoad.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			carNumber_i = orderPreRoad.getCarNumber_i();
			if(carNumber_i != null ){
			  	condition = condition + " and orderPreRoad.carNumber_i ='" + carNumber_i+ "'";
			}
			timeQuantum_s = orderPreRoad.getTimeQuantum_s();
			if(timeQuantum_s!= null &&!timeQuantum_s.trim().equals("")){
				condition = condition + " and orderPreRoad.timeQuantum_s like '%" + timeQuantum_s.trim() + "%'";
			}
			
			condition = condition+" order by orderPreRoad.orderPrepaymentRoadID_s ";
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

	public long getBasisOrderPreRoad(OrderPreRoad orderPreRoad)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			
			List<OrderPreRoad> list = new ArrayList<OrderPreRoad>();
			if(orderPreRoad==null)
			{
				Query query = session.createQuery("select count(*) from OrderPreRoad as orderPreRoad ");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			String hql = "select count(*) from OrderPreRoad as orderPreRoad  where 1=1 ";
			String condition="";
			
			orderPrepaymentRoadID_s = orderPreRoad.getOrderPrepaymentRoadID_s();
			if(orderPrepaymentRoadID_s!= null &&!orderPrepaymentRoadID_s.trim().equals("")){
				condition = condition + " and orderPreRoad.orderPrepaymentRoadID_s like '%" + orderPrepaymentRoadID_s.trim() + "%'";
			}
			orderID_s = orderPreRoad.getOrderID_s();
			if(orderID_s!= null &&!orderID_s.trim().equals("")){
				condition = condition + " and orderPreRoad.orderID_s like '%" + orderID_s.trim() + "%'";
			}
			status_i = orderPreRoad.getStatus_i();
			if(status_i != null && status_i != -1){
				condition = condition + " and orderPreRoad.orderID_s  = '" + status_i +"'";
			}
			roadID_s = orderPreRoad.getRoadID_s();
			if(roadID_s!= null &&!roadID_s.trim().equals("")){
				condition = condition + " and orderPreRoad.roadID_s like '%" + roadID_s.trim() + "%'";
			}
			roadName_s = orderPreRoad.getRoadName_s();
			if(roadName_s!= null &&!roadName_s.trim().equals("")){
				condition = condition + " and orderPreRoad.roadName_s like '%" + roadName_s.trim() + "%'";
			}
			createDate_t = orderPreRoad.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }			
			createUser_s = orderPreRoad.getCreateUser_s();
			if(createUser_s!= null &&!createUser_s.trim().equals("")){
				condition = condition + " and orderPreRoad.createUser_s like '%" + createUser_s.trim() + "%'";
			}
			lastUpdateUser_s = orderPreRoad.getLastUpdateUser_s();
			if(lastUpdateUser_s!= null &&!lastUpdateUser_s.trim().equals("")){
				condition = condition + " and orderPreRoad.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
			}
			lastUpdateDate_t = orderPreRoad.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = orderPreRoad.getResaveds1_s();
			if(resaveds1_s!= null &&!resaveds1_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
			}
			resaveds2_s = orderPreRoad.getResaveds2_s(); 
			if(resaveds2_s!= null &&!resaveds2_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
			}
			resaveds3_s = orderPreRoad.getResaveds3_s();
			if(resaveds3_s!= null &&!resaveds3_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
			}
			resaveds4_s = orderPreRoad.getResaveds4_s();
			if(resaveds4_s!= null &&!resaveds4_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
			}
			resaveds5_s = orderPreRoad.getResaveds5_s();
			if(resaveds5_s!= null &&!resaveds5_s.trim().equals("")){
				condition = condition + " and orderPreRoad.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
			}
			startDate_t = orderPreRoad.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderPreRoad.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderPreRoad.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			carNumber_i = orderPreRoad.getCarNumber_i();
			if(carNumber_i != null ){
			  	condition = condition + " and orderPreRoad.carNumber_i ='" + carNumber_i+ "'";
			}
			timeQuantum_s = orderPreRoad.getTimeQuantum_s();
			if(timeQuantum_s!= null &&!timeQuantum_s.trim().equals("")){
				condition = condition + " and orderPreRoad.timeQuantum_s like '%" + timeQuantum_s.trim() + "%'";
			}
			
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
	
	public int OperationOrderPreRoad(List<OrderPreRoad> orderPreRoad,
			int operation) throws Exception {
		tx = null;
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		tx=session.beginTransaction();//开启事务
		try {
			if(operation ==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				OrderPreRoad proOrder = new OrderPreRoad();
				if(orderPreRoad!=null&&orderPreRoad.size()>0){
					for(int i =0;i<orderPreRoad.size();i++){
						proOrder = orderPreRoad.get(i);
						if(proOrder.getOrderPrepaymentRoadID_s()==null || proOrder.getOrderPrepaymentRoadID_s().trim().length()<1){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.YFFBusiness, session);
							proOrder.setOrderPrepaymentRoadID_s(cpg);
							session.save(proOrder);
							session.flush();
							session.clear();
						}
						else{
							OrderPreRoad tmp = (OrderPreRoad)session.get(OrderPreRoad.class, proOrder.getOrderPrepaymentRoadID_s());
							
							orderID_s = proOrder.getOrderID_s();
							status_i = proOrder.getStatus_i();
							roadID_s = proOrder.getRoadID_s();
							roadName_s = proOrder.getRoadName_s();
							createDate_t = proOrder.getCreateDate_t();
							createUser_s = proOrder.getCreateUser_s();
							lastUpdateUser_s = proOrder.getLastUpdateUser_s();
							lastUpdateDate_t = proOrder.getLastUpdateDate_t();
							resaveds1_s = proOrder.getResaveds1_s();
							resaveds2_s = proOrder.getResaveds2_s(); 
							resaveds3_s = proOrder.getResaveds3_s();
							resaveds4_s = proOrder.getResaveds4_s();
							resaveds5_s = proOrder.getResaveds5_s();
							startDate_t = proOrder.getStartDate_t();
							endDate_t = proOrder.getEndDate_t();
							carNumber_i = proOrder.getCarNumber_i();
							timeQuantum_s =  proOrder.getTimeQuantum_s();
							if(orderID_s == null){
								proOrder.setOrderID_s(tmp.getOrderID_s());
							}
							if(status_i ==null){
								proOrder.setStatus_i(tmp.getStatus_i());
							}
							if(roadID_s == null){
								proOrder.setRoadID_s(tmp.getRoadID_s());
							}
							if(roadName_s == null){
								proOrder.setRoadName_s(tmp.getRoadName_s());
							}
							if(createDate_t == null){
								proOrder.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								proOrder.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								proOrder.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t == null){
								proOrder.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								proOrder.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								proOrder.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								proOrder.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								proOrder.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								proOrder.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(startDate_t == null){
								proOrder.setStartDate_t(tmp.getStartDate_t());
							}
							if(endDate_t == null){
								proOrder.setEndDate_t(tmp.getEndDate_t());
							}
							if(carNumber_i == null){
								proOrder.setCarNumber_i(tmp.getCarNumber_i());
							}
							if(timeQuantum_s == null){
								proOrder.setTimeQuantum_s(tmp.getTimeQuantum_s());
							}
							session.merge(proOrder);
							
						}
						
						session.flush();
					    session.clear();
						
						
					}
				}
			}
			if(operation ==2){
				if(orderPreRoad!=null&&orderPreRoad.size()>0){
					for(int i =0;i<orderPreRoad.size();i++){
						session.delete(orderPreRoad.get(i));
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
	
	public int OperationOrderPreRoadWithoutTx(ArrayList<OrderPreRoad> orderPreRoad,
			Integer operation) throws Exception {
	
		try {
			if(operation ==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				OrderPreRoad proOrder = new OrderPreRoad();
				if(orderPreRoad!=null&&orderPreRoad.size()>0){
					for(int i =0;i<orderPreRoad.size();i++){
						proOrder = orderPreRoad.get(i);
						if(proOrder.getOrderPrepaymentRoadID_s()==null || proOrder.getOrderPrepaymentRoadID_s().trim().length()<1){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.YFFBusiness, sessionImpl);
							proOrder.setOrderPrepaymentRoadID_s(cpg);
							sessionImpl.save(proOrder);
							sessionImpl.flush();
							sessionImpl.clear();
						}
						else{
							OrderPreRoad tmp = (OrderPreRoad)sessionImpl.get(OrderPreRoad.class, proOrder.getOrderPrepaymentRoadID_s());
							
							orderID_s = proOrder.getOrderID_s();
							status_i = proOrder.getStatus_i();
							roadID_s = proOrder.getRoadID_s();
							roadName_s = proOrder.getRoadName_s();
							createDate_t = proOrder.getCreateDate_t();
							createUser_s = proOrder.getCreateUser_s();
							lastUpdateUser_s = proOrder.getLastUpdateUser_s();
							lastUpdateDate_t = proOrder.getLastUpdateDate_t();
							resaveds1_s = proOrder.getResaveds1_s();
							resaveds2_s = proOrder.getResaveds2_s(); 
							resaveds3_s = proOrder.getResaveds3_s();
							resaveds4_s = proOrder.getResaveds4_s();
							resaveds5_s = proOrder.getResaveds5_s();
							startDate_t = proOrder.getStartDate_t();
							endDate_t = proOrder.getEndDate_t();
							carNumber_i = proOrder.getCarNumber_i();
							timeQuantum_s =  proOrder.getTimeQuantum_s();
							if(orderID_s == null){
								proOrder.setOrderID_s(tmp.getOrderID_s());
							}
							if(status_i ==null){
								proOrder.setStatus_i(tmp.getStatus_i());
							}
							if(roadID_s == null){
								proOrder.setRoadID_s(tmp.getRoadID_s());
							}
							if(roadName_s == null){
								proOrder.setRoadName_s(tmp.getRoadName_s());
							}
							if(createDate_t == null){
								proOrder.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								proOrder.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								proOrder.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t == null){
								proOrder.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								proOrder.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								proOrder.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								proOrder.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								proOrder.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								proOrder.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(startDate_t == null){
								proOrder.setStartDate_t(tmp.getStartDate_t());
							}
							if(endDate_t == null){
								proOrder.setEndDate_t(tmp.getEndDate_t());
							}
							if(carNumber_i == null){
								proOrder.setCarNumber_i(tmp.getCarNumber_i());
							}
							if(timeQuantum_s == null){
								proOrder.setTimeQuantum_s(tmp.getTimeQuantum_s());
							}
							sessionImpl.merge(proOrder);
							
						}
						
						sessionImpl.flush();
						sessionImpl.clear();
						
						
					}
				}
			}
			if(operation ==2){
				if(orderPreRoad!=null&&orderPreRoad.size()>0){
					for(int i =0;i<orderPreRoad.size();i++){
						sessionImpl.delete(orderPreRoad.get(i));
						sessionImpl.flush();
						sessionImpl.clear();
					}
				}
			}
			
			return 1;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw e;
		}
		finally{
		
		}
	}

	/**
	 * 获得order精确预订道路费用信息
	 * getPreRoadcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrdercostInfo> getPreRoadcostInfo(String orderID) throws Exception {
		 
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		IOrderRoadCostBasisService orderRoadCostBasisServiceImpl = new OrderRoadCostBasisServiceImpl();
		IOrdercostInfoService iordercostInfoServiceImpl = new OrdercostInfoServiceImpl();
		try {
			List<OrdercostInfo> list = new ArrayList();
			String hql = " select orderPreRoad.roadID_s,count(orderPreRoad.timeQuantum_s),sum(orderPreRoad.reckonCost_i)  " +
						 " from OrderPreRoad as orderPreRoad " +
						 " where  orderPreRoad.orderID_s = '" + orderID + "' " +						
						 " group by orderPreRoad.roadID_s";
		    Query query=session.createQuery(hql);
		    List tmplist = query.list();
		    Iterator iterator = tmplist.iterator();
			while(iterator.hasNext()){
				OrdercostInfo tmp = new OrdercostInfo();
				Object[] o = (Object[])iterator.next();
				String roadID_s = (String)o[0];//道路编号
				RoadInfo roadInfo = new RoadInfo();
				roadInfo.setRoadID_s(roadID_s);
				ArrayList<RoadInfo> roadinfos = iroadInfoService.getRoadInfo(roadInfo);
				if(BasicTools.isnotNull(roadinfos)){
					roadInfo = roadinfos.get(0);
					tmp.setFacilityName(roadInfo.getRoadName_s());//名称
				}else{
					tmp.setFacilityName("");
				}
				//设置数量
				String spanMinute_i = o[1]+"";
				if(NumTools.isNumber(spanMinute_i,false)){
					tmp.setNumber(Integer.valueOf(spanMinute_i)*60);
				}else{
					tmp.setNumber(0);
				}
				//设置总价
				String cost_i = o[2]+"";
				if(NumTools.isNumber(cost_i,true)){
					tmp.setTotalprice(Double.valueOf(cost_i));
				}else{
					tmp.setTotalprice(Double.valueOf("0"));
				}
				tmp.setUnit("元/分钟");
				//得到单价
				TCostOrderroadcostbasis tCostOrderroadcostbasis = new TCostOrderroadcostbasis();
				tCostOrderroadcostbasis.setOrderidS(orderID);
				tCostOrderroadcostbasis.setRoadidS(roadID_s);
				ArrayList<TCostOrderroadcostbasis> tCostOrderroadcostbasises= orderRoadCostBasisServiceImpl.getTCostOrderroadcostbasis(tCostOrderroadcostbasis, ConstantUtil.pagingNot, 0);
				if(!BasicTools.isnotNull(tCostOrderroadcostbasises)){//order没有对应的费用基础信息
					//初始化orders单价表
					iordercostInfoServiceImpl.initOrderPriceBytransaction(orderID);
					tCostOrderroadcostbasis = orderRoadCostBasisServiceImpl.getTCostOrderroadcostbasis(tCostOrderroadcostbasis, ConstantUtil.pagingNot, 0).get(0);						
				}else{
					tCostOrderroadcostbasis = tCostOrderroadcostbasises.get(0);
				}
				//tmp.setUnitPrie_i(tCostOrderroadcostbasis.getUnitprieI());
				tmp.setUnitPrie_i(Double.valueOf(tCostOrderroadcostbasis.getMinuteUnitPrie_i()));
				tmp.setType(ConstantUtil.COSTTYPE03);
				list.add(tmp);
			}
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}
}
