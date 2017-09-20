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
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.cost.OrdercostInfo;
import com.freshen.entity.cost.TCostOrderroadcostbasis;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.NumTools;

public class OrderWholeRoadServiceImpl extends ClimsServiceBase implements IorderWholeRoadService {

	String orderWholeRoadID_s;
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
	
	public ArrayList<OrderWholeRoad> getBasisOrderWholeRoad(
			OrderWholeRoad orderWholeRoad, int start, int size)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		try {
			List<OrderWholeRoad> list = new ArrayList<OrderWholeRoad>();
			if(orderWholeRoad == null){
				Query query = session.createQuery(" from OrderWholeRoad as orderWholeRoad");
				if(start != -1){
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			
			String hql = " from OrderWholeRoad as orderWholeRoad where 1=1 ";
			String condition="";
			orderWholeRoadID_s = orderWholeRoad.getOrderWholeRoadID_s();
			if(orderWholeRoadID_s != null && !orderWholeRoadID_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.orderWholeRoadID_s like '%" +  orderWholeRoadID_s.trim() + "%'";
	    	}
			orderID_s = orderWholeRoad.getOrderID_s();
			if(orderID_s != null && !orderID_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.orderID_s like '%" +  orderID_s.trim() + "%'";
	    	}
			status_i = orderWholeRoad.getStatus_i();
			if(status_i != null){
				condition = condition + " and orderWholeRoad.status_i = '" +  status_i + "'";
			}
			roadID_s = orderWholeRoad.getRoadID_s();
			if(roadID_s != null && !roadID_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadID_s like '%" +  roadID_s.trim() + "%'";
	    	}
			roadName_s = orderWholeRoad.getRoadName_s();
			if(roadName_s != null && !roadName_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadName_s like '%" +  roadName_s.trim() + "%'";
	    	}
			createDate_t = orderWholeRoad.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			createUser_s = orderWholeRoad.getCreateUser_s();
			if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.createUser_s like '%" +  createUser_s.trim() + "%'";
	    	}
			lastUpdateUser_s = orderWholeRoad.getLastUpdateUser_s();
			if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadName_s like '%" +  lastUpdateUser_s.trim() + "%'";
	    	}
			lastUpdateDate_t = orderWholeRoad.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = orderWholeRoad.getResaveds1_s();
			if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds1_s like '%" +  resaveds1_s.trim() + "%'";
	    	}
			resaveds2_s = orderWholeRoad.getResaveds2_s();
			if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds2_s like '%" +  resaveds2_s.trim() + "%'";
	    	}
			resaveds3_s = orderWholeRoad.getResaveds3_s();
			if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds3_s like '%" +  resaveds3_s.trim() + "%'";
	    	}
			resaveds4_s = orderWholeRoad.getResaveds4_s();
			if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds4_s like '%" +  resaveds4_s.trim() + "%'";
	    	}
			resaveds5_s = orderWholeRoad.getResaveds5_s();
			if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds5_s like '%" +  resaveds5_s.trim() + "%'";
	    	}
			startDate_t = orderWholeRoad.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderWholeRoad.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			carNumber_i = orderWholeRoad.getCarNumber_i();
			if(status_i != null){
				condition = condition + " and orderWholeRoad.status_i = '" +  status_i + "'";
			}
			timeQuantum_s = orderWholeRoad.getTimeQuantum_s();
			if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadName_s like '%" +  lastUpdateUser_s.trim() + "%'";
	    	}
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

	public long getBasisOrderWholeRoad(OrderWholeRoad orderWholeRoad)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<OrderWholeRoad> list = new ArrayList<OrderWholeRoad>();
			if(orderWholeRoad == null){
				Query query = session.createQuery("select count(*) from OrderWholeRoad as orderWholeRoad");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			
			String hql = "select count(*) from OrderWholeRoad as orderWholeRoad where 1=1 ";
			String condition="";
			orderWholeRoadID_s = orderWholeRoad.getOrderWholeRoadID_s();
			if(orderWholeRoadID_s != null && !orderWholeRoadID_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.orderWholeRoadID_s like '%" +  orderWholeRoadID_s.trim() + "%'";
	    	}
			orderID_s = orderWholeRoad.getOrderID_s();
			if(orderID_s != null && !orderID_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.orderID_s like '%" +  orderID_s.trim() + "%'";
	    	}
			status_i = orderWholeRoad.getStatus_i();
			if(status_i != null){
				condition = condition + " and orderWholeRoad.status_i = '" +  status_i + "'";
			}
			roadID_s = orderWholeRoad.getRoadID_s();
			if(roadID_s != null && !roadID_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadID_s like '%" +  roadID_s.trim() + "%'";
	    	}
			roadName_s = orderWholeRoad.getRoadName_s();
			if(roadName_s != null && !roadName_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadName_s like '%" +  roadName_s.trim() + "%'";
	    	}
			createDate_t = orderWholeRoad.getCreateDate_t();
			if(createDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
			createUser_s = orderWholeRoad.getCreateUser_s();
			if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.createUser_s like '%" +  createUser_s.trim() + "%'";
	    	}
			lastUpdateUser_s = orderWholeRoad.getLastUpdateUser_s();
			if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadName_s like '%" +  lastUpdateUser_s.trim() + "%'";
	    	}
			lastUpdateDate_t = orderWholeRoad.getLastUpdateDate_t();
			if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
			resaveds1_s = orderWholeRoad.getResaveds1_s();
			if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds1_s like '%" +  resaveds1_s.trim() + "%'";
	    	}
			resaveds2_s = orderWholeRoad.getResaveds2_s();
			if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds2_s like '%" +  resaveds2_s.trim() + "%'";
	    	}
			resaveds3_s = orderWholeRoad.getResaveds3_s();
			if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds3_s like '%" +  resaveds3_s.trim() + "%'";
	    	}
			resaveds4_s = orderWholeRoad.getResaveds4_s();
			if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds4_s like '%" +  resaveds4_s.trim() + "%'";
	    	}
			resaveds5_s = orderWholeRoad.getResaveds5_s();
			if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.resaveds5_s like '%" +  resaveds5_s.trim() + "%'";
	    	}
			startDate_t = orderWholeRoad.getStartDate_t();
			if(startDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.startDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(startDate_t, "yyyy-MM-dd") +"'";
		    }
			endDate_t = orderWholeRoad.getEndDate_t();
			if(endDate_t != null){
		    	condition = condition+" and to_char(orderWholeRoad.endDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(endDate_t, "yyyy-MM-dd") +"'";
		    }
			carNumber_i = orderWholeRoad.getCarNumber_i();
			if(status_i != null){
				condition = condition + " and orderWholeRoad.status_i = '" +  status_i + "'";
			}
			timeQuantum_s = orderWholeRoad.getTimeQuantum_s();
			if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and orderWholeRoad.roadName_s like '%" +  lastUpdateUser_s.trim() + "%'";
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

	public int OperationOrderWholeRoad(List<OrderWholeRoad> orderWholeRoad,
			int operation) throws Exception {
		// TODO Auto-generated method stub
		tx = null;
		if(!session.isOpen()){
			session= HibernateUtil.getSession();							
		}
		tx=session.beginTransaction();//开启事务
		try {
			if(orderWholeRoad != null && orderWholeRoad.size()>0)
			{
				
				if(operation==1){
					IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
					OrderWholeRoad wholeToad=null;
					for(int i=0;i<orderWholeRoad.size();i++){
						wholeToad= orderWholeRoad.get(i);
						if(wholeToad.getOrderWholeRoadID_s() == null || wholeToad.getOrderWholeRoadID_s().trim().length()<1){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.BCYDBusiness, session);
							wholeToad.setOrderWholeRoadID_s(cpg);
							session.save(wholeToad);
							session.flush();
							session.clear();
							//session.merge(wholeToad);
						}
						else
						{
							OrderWholeRoad tmp = (OrderWholeRoad)session.get(OrderWholeRoad.class, wholeToad.getOrderWholeRoadID_s());
							
							orderID_s = wholeToad.getOrderID_s();
							status_i = wholeToad.getStatus_i();
							roadID_s = wholeToad.getRoadID_s();
							roadName_s = wholeToad.getRoadName_s();
							createDate_t = wholeToad.getCreateDate_t();
							createUser_s = wholeToad.getCreateUser_s();
							lastUpdateUser_s = wholeToad.getLastUpdateUser_s();
							lastUpdateDate_t = wholeToad.getLastUpdateDate_t();
							resaveds1_s = wholeToad.getResaveds1_s();
							resaveds2_s = wholeToad.getResaveds2_s();
							resaveds3_s = wholeToad.getResaveds3_s();
							resaveds4_s = wholeToad.getResaveds4_s();
							resaveds5_s = wholeToad.getResaveds5_s();
							startDate_t = wholeToad.getStartDate_t();
							endDate_t = wholeToad.getEndDate_t();
							carNumber_i = wholeToad.getCarNumber_i();
							timeQuantum_s = wholeToad.getTimeQuantum_s();
							if(orderID_s == null){
								wholeToad.setOrderID_s(tmp.getOrderID_s());
							}
							if(status_i == null){
								wholeToad.setStatus_i(tmp.getStatus_i());
							}
							if(roadID_s == null){
								wholeToad.setRoadID_s(tmp.getRoadID_s());
							}
							if(roadName_s == null){
								wholeToad.setRoadName_s(tmp.getRoadName_s());
							}
							if(createDate_t == null){
								wholeToad.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								wholeToad.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								wholeToad.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t == null){
								wholeToad.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								wholeToad.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								wholeToad.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								wholeToad.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								wholeToad.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								wholeToad.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(startDate_t == null){
								wholeToad.setStartDate_t(tmp.getStartDate_t());
							}
							if(endDate_t == null){
								wholeToad.setEndDate_t(tmp.getEndDate_t());
							}
							if(carNumber_i == null){
								wholeToad.setCarNumber_i(tmp.getCarNumber_i());
							}
							if(timeQuantum_s == null){
								wholeToad.setTimeQuantum_s(tmp.getTimeQuantum_s());
							}
							session.merge(wholeToad);
						}
					}
					session.flush();
				    session.clear();
				
				}
				if(operation==2){
					if(orderWholeRoad!=null&&orderWholeRoad.size()>0){
						for(int i=0;i<orderWholeRoad.size();i++){
							session.delete(orderWholeRoad.get(i));
							session.flush();
							session.clear();
						}
					}
				}
				tx.commit();
				return 1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			throw e;
		}
		finally{
			session.clear();
		}
		return 0;
	}
	
	public int OperationOrderWholeRoadWithoutTx(ArrayList<OrderWholeRoad> orderWholeRoad,
			Integer operation) throws Exception {
		// TODO Auto-generated method stub
	
		try {
			if(orderWholeRoad != null && orderWholeRoad.size()>0)
			{
				
				if(operation==1){
					IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
					OrderWholeRoad wholeToad=null;
					for(int i=0;i<orderWholeRoad.size();i++){
						wholeToad= orderWholeRoad.get(i);
						if(wholeToad.getOrderWholeRoadID_s() == null || wholeToad.getOrderWholeRoadID_s().trim().length()<1){
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.BCYDBusiness, session);
							wholeToad.setOrderWholeRoadID_s(cpg);
							sessionImpl.save(wholeToad);
							sessionImpl.flush();
							sessionImpl.clear();
							//session.merge(wholeToad);
						}
						else
						{
							OrderWholeRoad tmp = (OrderWholeRoad)sessionImpl.get(OrderWholeRoad.class, wholeToad.getOrderWholeRoadID_s());
							
							orderID_s = wholeToad.getOrderID_s();
							status_i = wholeToad.getStatus_i();
							roadID_s = wholeToad.getRoadID_s();
							roadName_s = wholeToad.getRoadName_s();
							createDate_t = wholeToad.getCreateDate_t();
							createUser_s = wholeToad.getCreateUser_s();
							lastUpdateUser_s = wholeToad.getLastUpdateUser_s();
							lastUpdateDate_t = wholeToad.getLastUpdateDate_t();
							resaveds1_s = wholeToad.getResaveds1_s();
							resaveds2_s = wholeToad.getResaveds2_s();
							resaveds3_s = wholeToad.getResaveds3_s();
							resaveds4_s = wholeToad.getResaveds4_s();
							resaveds5_s = wholeToad.getResaveds5_s();
							startDate_t = wholeToad.getStartDate_t();
							endDate_t = wholeToad.getEndDate_t();
							carNumber_i = wholeToad.getCarNumber_i();
							timeQuantum_s = wholeToad.getTimeQuantum_s();
							if(orderID_s == null){
								wholeToad.setOrderID_s(tmp.getOrderID_s());
							}
							if(status_i == null){
								wholeToad.setStatus_i(tmp.getStatus_i());
							}
							if(roadID_s == null){
								wholeToad.setRoadID_s(tmp.getRoadID_s());
							}
							if(roadName_s == null){
								wholeToad.setRoadName_s(tmp.getRoadName_s());
							}
							if(createDate_t == null){
								wholeToad.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								wholeToad.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								wholeToad.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t == null){
								wholeToad.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								wholeToad.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								wholeToad.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								wholeToad.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								wholeToad.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								wholeToad.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(startDate_t == null){
								wholeToad.setStartDate_t(tmp.getStartDate_t());
							}
							if(endDate_t == null){
								wholeToad.setEndDate_t(tmp.getEndDate_t());
							}
							if(carNumber_i == null){
								wholeToad.setCarNumber_i(tmp.getCarNumber_i());
							}
							if(timeQuantum_s == null){
								wholeToad.setTimeQuantum_s(tmp.getTimeQuantum_s());
							}
							sessionImpl.merge(wholeToad);
						}
					}
					sessionImpl.flush();
					sessionImpl.clear();
				
				}
				if(operation==2){
					if(orderWholeRoad!=null&&orderWholeRoad.size()>0){
						for(int i=0;i<orderWholeRoad.size();i++){
							sessionImpl.delete(orderWholeRoad.get(i));
							sessionImpl.flush();
							sessionImpl.clear();
						}
					}
				}
				
				return 1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			//tx.rollback();
			throw e;
		}
		finally{
			
		}
		return 0;
	}

	/**
	 * 获得order包场预订道路费用信息
	 * getWholeRoadcostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<OrdercostInfo> getWholeRoadcostInfo(String orderID) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		IOrderRoadCostBasisService orderRoadCostBasisServiceImpl = new OrderRoadCostBasisServiceImpl();
		IOrdercostInfoService iordercostInfoServiceImpl = new OrdercostInfoServiceImpl();
		try {
			List<OrdercostInfo> list = new ArrayList();
			String hql = " select orderWholeRoad.roadID_s,count(orderWholeRoad.timeQuantum_s),sum(orderWholeRoad.reckonCost_i)  " +
						 " from OrderWholeRoad as orderWholeRoad " +
						 " where  orderWholeRoad.orderID_s = '" + orderID + "' " +						
						 " group by orderWholeRoad.roadID_s";
		    Query query=session.createQuery(hql);
		    List tmplist = query.list();
		    Iterator iterator = tmplist.iterator();
			while(iterator.hasNext()){
				OrdercostInfo tmp = new OrdercostInfo();
				Object[] o = (Object[])iterator.next();
				String roadID_s = (String)o[0];//道路编号
				RoadInfo roadInfo = new RoadInfo();
				roadInfo.setRoadID_s(roadID_s);
				roadInfo = iroadInfoService.getRoadInfo(roadInfo).get(0);
				tmp.setFacilityName(roadInfo.getRoadName_s());//名称
				//设置数量
				//System.out.println("o[1]="+o[1]);
				String spanMinute_i = o[1]+"";
				if(NumTools.isNumber(spanMinute_i,false)){
					tmp.setNumber(Integer.valueOf(spanMinute_i));
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
				tmp.setUnit("万元/小时");
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
				//tmp.setUnitPrie_i(Double.valueOf(tCostOrderroadcostbasis.getActivityUnitPrie_i()));
				tmp.setUnitPrie_i(Double.valueOf(tCostOrderroadcostbasis.getWholeunitprieI()));
				tmp.setType(ConstantUtil.COSTTYPE04);
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
