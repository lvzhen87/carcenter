package com.freshen.cost.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.impl.UnsubscribeRuleServiceImpl;

import com.freshen.cost.service.IOrderUnsubscribeCostService;
import com.freshen.cost.service.IOrdercostInfoService;

import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.entity.cost.TCostOrderothercost;
import com.freshen.entity.cost.TCostOrderunsubscribecost;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.preorder.service.impl.OrderPreRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.BeanModel;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.clims.baseclass.ServiceImpl;

public class OrderUnsubscribeCostServiceImpl extends ClimsServiceBase implements
	IOrderUnsubscribeCostService {

	private String unsubscribeserialnumberS;
    private String orderidS;
    private Date startdatetimeT;
    private Date unsubscribetimeT;
    private Double spanhournumberI;
    private Double reckoncostI;
    private String customerUsercardS;
    private String orderSubscribeidS;
    private Integer subscribetypeI;
    private Date createdateT;
    private String createuserS;
    private String resaveds1S;
    private String resaveds2S;
    private String resaveds3S;
    private String resaveds4S;
    private String resaveds5S;
	
	//Session session = HibernateUtil.getSession();
		Transaction tx = null;
	 
	public ArrayList<TCostOrderunsubscribecost> getTCostOrderothercost(
			TCostOrderunsubscribecost tCostOrderunsubscribecost, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			List<TCostOrderothercost> list = new ArrayList<TCostOrderothercost>();
			if(tCostOrderunsubscribecost== null){
				Query query = session.createQuery("from TCostOrderunsubscribecost as tCostOrderunsubscribecost ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			} 
			this.setPro(tCostOrderunsubscribecost);
			String hql = " from TCostOrderunsubscribecost as tCostOrderunsubscribecost where 1=1 ";
			String condition="";
			
		    if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.orderidS like '%" + orderidS.trim() + "%'";
		    }
		    if(startdatetimeT != null){
		    	condition = condition+" and to_char(tCostOrderunsubscribecost.startdatetimeT,'yyyy-MM-dd')='"+DateUtil.dateToString(startdatetimeT, "yyyy-MM-dd") +"'";
		    }
		    if(unsubscribetimeT != null){
		    	condition = condition+" and to_char(tCostOrderunsubscribecost.unsubscribetimeT,'yyyy-MM-dd')='"+DateUtil.dateToString(unsubscribetimeT, "yyyy-MM-dd") +"'";
		    }
		    if(customerUsercardS != null){
		    	condition = condition + " and tCostOrderunsubscribecost.customerUsercardS like '%" + customerUsercardS.trim() + "%'";
		    }
		    if(orderSubscribeidS != null){
		    	condition = condition + " and tCostOrderunsubscribecost.orderSubscribeidS like '%" + orderSubscribeidS.trim() + "%'";
		    }
		    if(subscribetypeI != null){
		    	condition = condition + " and tCostOrderunsubscribecost.subscribetypeI = '"+subscribetypeI+"'";
		    }
		    if(createdateT != null){
		    	condition = condition+" and to_char(tCostOrderunsubscribecost.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(createdateT, "yyyy-MM-dd") +"'";
		    }
		    if(createuserS != null && !createuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.createuserS like '%" + createuserS.trim() + "%'";
		    }
		    if(resaveds1S != null && !resaveds1S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds1S like '%" + resaveds1S.trim() + "%'";
		    }
		    if(resaveds2S != null && !resaveds2S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds2S like '%" + resaveds2S.trim() + "%'";
		    }
		    if(resaveds3S != null && !resaveds3S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds3S like '%" + resaveds3S.trim() + "%'";
		    }
		    if(resaveds4S != null && !resaveds4S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds4S like '%" + resaveds4S.trim() + "%'";
		    }
		    if(resaveds5S != null && !resaveds5S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds5S like '%" + resaveds5S.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderunsubscribecost.createdateT ";
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
 

	public long getTCostOrderothercostNumber(
			TCostOrderunsubscribecost tCostOrderunsubscribecost)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<TCostOrderothercost> list = new ArrayList<TCostOrderothercost>();
			if(tCostOrderunsubscribecost== null){
				Query query = session.createQuery("select count(*) from TCostOrderunsubscribecost as tCostOrderunsubscribecost ");
				if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }
			    return n;
			} 
			this.setPro(tCostOrderunsubscribecost);
			String hql = "select count(*) from TCostOrderunsubscribecost as tCostOrderunsubscribecost where 1=1 ";
			String condition="";
			
		    if(orderidS != null && !orderidS.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.orderidS like '%" + orderidS.trim() + "%'";
		    }
		    if(startdatetimeT != null){
		    	condition = condition+" and to_char(tCostOrderunsubscribecost.startdatetimeT,'yyyy-MM-dd')='"+DateUtil.dateToString(startdatetimeT, "yyyy-MM-dd") +"'";
		    }
		    if(unsubscribetimeT != null){
		    	condition = condition+" and to_char(tCostOrderunsubscribecost.unsubscribetimeT,'yyyy-MM-dd')='"+DateUtil.dateToString(unsubscribetimeT, "yyyy-MM-dd") +"'";
		    }
		    if(customerUsercardS != null){
		    	condition = condition + " and tCostOrderunsubscribecost.customerUsercardS like '%" + customerUsercardS.trim() + "%'";
		    }
		    if(orderSubscribeidS != null){
		    	condition = condition + " and tCostOrderunsubscribecost.orderSubscribeidS like '%" + orderSubscribeidS.trim() + "%'";
		    }
		    if(subscribetypeI != null){
		    	condition = condition + " and tCostOrderunsubscribecost.subscribetypeI = '"+subscribetypeI+"'";
		    }
		    if(createdateT != null){
		    	condition = condition+" and to_char(tCostOrderunsubscribecost.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(createdateT, "yyyy-MM-dd") +"'";
		    }
		    if(createuserS != null && !createuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.createuserS like '%" + createuserS.trim() + "%'";
		    }
		    if(resaveds1S != null && !resaveds1S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds1S like '%" + resaveds1S.trim() + "%'";
		    }
		    if(resaveds2S != null && !resaveds2S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds2S like '%" + resaveds2S.trim() + "%'";
		    }
		    if(resaveds3S != null && !resaveds3S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds3S like '%" + resaveds3S.trim() + "%'";
		    }
		    if(resaveds4S != null && !resaveds4S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds4S like '%" + resaveds4S.trim() + "%'";
		    }
		    if(resaveds5S != null && !resaveds5S.trim().equals("")){
		    	condition = condition + " and tCostOrderunsubscribecost.resaveds5S like '%" + resaveds5S.trim() + "%'";
		    }
		    condition = condition+" order by tCostOrderunsubscribecost.createdateT ";
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
	public int OperationTCostOrderothercost(
			TCostOrderunsubscribecost tCostOrderunsubscribecost, Integer operation)
			throws Exception {
		 
		int r=-1;
		Date startdatetimeT  = new Date();//预订开始日期
		int timeQuantum = 0;//时间段
		try{
			//新增
			if(operation==1){				 
				if(BeanModel.isnotNull(tCostOrderunsubscribecost)){
					tCostOrderunsubscribecost.setCreatedateT(new Date());
					//预订类型
					int subscribetype = tCostOrderunsubscribecost.getSubscribetypeI();
					Integer reckonCost_i = 0;//预订的总费用
					if(subscribetype==1){//包场
						OrderWholeRoad orderWholeRoad = new OrderWholeRoad();
						orderWholeRoad.setOrderWholeRoadID_s(orderSubscribeidS);
						IorderWholeRoadService iorderWholeRoadService = new OrderWholeRoadServiceImpl();
						List<OrderWholeRoad> list = iorderWholeRoadService.getBasisOrderWholeRoad(orderWholeRoad,ConstantUtil.pagingNot,0);
						if(BasicTools.isnotNull(list)){
							orderWholeRoad = list.get(0);
							reckonCost_i = orderWholeRoad.getReckonCost_i();
							if(reckonCost_i==null||reckonCost_i==0){
								//计算订单费用
								IOrdercostInfoService ordercostInfoServiceImpl = new OrdercostInfoServiceImpl();
								ordercostInfoServiceImpl.PreRoadCost(orderWholeRoad.getOrderID_s(),sessionImpl);
								orderWholeRoad = new OrderWholeRoad();
								orderWholeRoad.setOrderWholeRoadID_s(orderSubscribeidS);
								orderWholeRoad = iorderWholeRoadService.getBasisOrderWholeRoad(orderWholeRoad,ConstantUtil.pagingNot,0).get(0);
								reckonCost_i = orderWholeRoad.getReckonCost_i();
							}
							startdatetimeT = orderWholeRoad.getStartDate_t();
							//1代表从0点开始，2代表从1点开始，所以减去1
							timeQuantum = Integer.valueOf(orderWholeRoad.getTimeQuantum_s())-1;
							tCostOrderunsubscribecost.setOrderidS(orderWholeRoad.getOrderID_s());
							tCostOrderunsubscribecost.setStartdatetimeT(startdatetimeT);
						}
						
					}else if(subscribetype==2){//精确预订
						OrderPreRoad orderPreRoad = new OrderPreRoad();
						orderPreRoad.setOrderPrepaymentRoadID_s(orderSubscribeidS);
						IorderPreRoadService iorderPreRoadService = new OrderPreRoadServiceImpl();
						List<OrderPreRoad> list = iorderPreRoadService.getBasisOrderPreRoad(orderPreRoad,ConstantUtil.pagingNot,0);
						if(BasicTools.isnotNull(list)){
							orderPreRoad = list.get(0);
							reckonCost_i = orderPreRoad.getReckonCost_i();
							if(reckonCost_i==null||reckonCost_i==0){
								//计算订单费用
								IOrdercostInfoService ordercostInfoServiceImpl = new OrdercostInfoServiceImpl();
								ordercostInfoServiceImpl.PreRoadCost(orderPreRoad.getOrderID_s(),sessionImpl);
								orderPreRoad = new OrderPreRoad();
								orderPreRoad.setOrderPrepaymentRoadID_s(orderSubscribeidS);
								orderPreRoad = iorderPreRoadService.getBasisOrderPreRoad(orderPreRoad,ConstantUtil.pagingNot,0).get(0);
								reckonCost_i = orderPreRoad.getReckonCost_i();
								
							}
							startdatetimeT = orderPreRoad.getStartDate_t();
							//1代表从0点开始，2代表从1点开始，所以减去1
							timeQuantum = Integer.valueOf(orderPreRoad.getTimeQuantum_s())-1;
							tCostOrderunsubscribecost.setOrderidS(orderPreRoad.getOrderID_s());
							tCostOrderunsubscribecost.setStartdatetimeT(startdatetimeT);
						}
					}
					if(reckonCost_i==null){
						reckonCost_i = 0;
					}
					//生成退订序号
					IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
					String pk = systemSequenceServiceImpl.getPK(ConstantUtil.USBusiness, sessionImpl);
					tCostOrderunsubscribecost.setUnsubscribeserialnumberS(pk);
					
					//得到预订的开始时间单位到小时
					startdatetimeT = DateUtil.addDate(startdatetimeT, 5,timeQuantum);
					//提交与试验开始时间的小时差
					int i = DateUtil.countDistanceHourNum(new Date(), startdatetimeT);
					UnsubscribeRuleServiceImpl impl = new UnsubscribeRuleServiceImpl();
					tCostOrderunsubscribecost.setSpanhournumberI(Double.valueOf(i));
					tCostOrderunsubscribecost.setUnsubscribetimeT(new Date());
					//得到扣减比例
					int breakPromiseDeduction = impl.getBreakPromiseDeduction(i);
					//得到预订信息id
					String orderSubscribeidS = tCostOrderunsubscribecost.getOrderSubscribeidS();
					
					
					//需扣除的费用
					tCostOrderunsubscribecost.setReckoncostI(Double.valueOf(reckonCost_i*breakPromiseDeduction/100));
					sessionImpl.save(tCostOrderunsubscribecost);
				}
			}
			//删除
			if(operation==2){
				if(tCostOrderunsubscribecost!=null){
					sessionImpl.delete(tCostOrderunsubscribecost);
				}
			}
			r=1;
		}catch(Exception e){
			r=-1;
			 
			throw e;
		}finally{				
    	 
		}
		return r;
	}

	/**
	 * 对属性进行赋值	   
	 * setPro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private void setPro(TCostOrderunsubscribecost tCostOrderunsubscribecost){
		unsubscribeserialnumberS=tCostOrderunsubscribecost.getUnsubscribeserialnumberS();
		orderidS                =tCostOrderunsubscribecost.getOrderidS();
		startdatetimeT          =tCostOrderunsubscribecost.getStartdatetimeT();          
		unsubscribetimeT        =tCostOrderunsubscribecost.getUnsubscribetimeT();       
		spanhournumberI         =tCostOrderunsubscribecost.getSpanhournumberI();         
		reckoncostI             =tCostOrderunsubscribecost.getReckoncostI();             
		customerUsercardS         =tCostOrderunsubscribecost.getCustomerUsercardS();         
		orderSubscribeidS           =tCostOrderunsubscribecost.getOrderSubscribeidS();         
		 subscribetypeI         =tCostOrderunsubscribecost.getSubscribetypeI();         
		 createdateT            =tCostOrderunsubscribecost.getCreatedateT();            
		createuserS             =tCostOrderunsubscribecost.getCreateuserS();             
		resaveds1S              =tCostOrderunsubscribecost.getResaveds1S();              
		resaveds2S              =tCostOrderunsubscribecost.getResaveds2S();              
		resaveds3S              =tCostOrderunsubscribecost.getResaveds3S();              
		resaveds4S              =tCostOrderunsubscribecost.getResaveds4S();              
		resaveds5S              =tCostOrderunsubscribecost.getResaveds5S();              
	}
	
	public static void main(String[] a){
		TCostOrderunsubscribecost tCostOrderunsubscribecost = new TCostOrderunsubscribecost();
		 
		
		tCostOrderunsubscribecost.setCustomerUsercardS("111");
		tCostOrderunsubscribecost.setOrderSubscribeidS("BCYD2014081000");
		tCostOrderunsubscribecost.setSubscribetypeI(1);
		 
		tCostOrderunsubscribecost.setTimeQuantum_s("3");
		List<ServiceImpl> se = new ArrayList();
		Object[] o = {tCostOrderunsubscribecost,1};
		ServiceImpl tmp = new ServiceImpl("com.freshen.cost.service.impl.OrderUnsubscribeCostServiceImpl","OperationTCostOrderothercost",o);			 
		se.add(tmp);
		try {
			ServiceImpl.invoke(se);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
