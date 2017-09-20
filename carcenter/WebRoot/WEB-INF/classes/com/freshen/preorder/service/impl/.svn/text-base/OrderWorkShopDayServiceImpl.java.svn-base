package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.OrderWorkShopDay;
import com.freshen.entity.Orderroaddaydetail;
import com.freshen.preorder.service.IorderDetailService;
import com.freshen.preorder.service.IorderWorkShopDayService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OrderWorkShopDayServiceImpl extends ClimsServiceBase implements  IorderWorkShopDayService{

	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	String orderIDS;
	Integer status_i;
	public ArrayList<OrderWorkShopDay> getOrderWorkShopDay(OrderWorkShopDay orderWorkShopDay,int start,
			int pageSize) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			if(orderWorkShopDay==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from OrderWorkShopDay");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(pageSize);
				}
				List<OrderWorkShop> list = query.list();	  			
				return (ArrayList) list;
			}	
			orderIDS = orderWorkShopDay.getOrderID_s();
			status_i = orderWorkShopDay.getStatus_i();
			String hql="from OrderWorkShopDay as orderWorkShopDay where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderWorkShopDay.orderID_s='"+orderIDS+"'";
			}
			if(status_i!=null){
				condition = condition+" and orderWorkShopDay.status_i="+status_i;
			}
			Query query=session.createQuery(hql+condition);
			if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(pageSize);
			}
		    List list = query.list();
	    	return (ArrayList<OrderWorkShopDay>) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	
	}
	public long getOrderWorkShopDayNumber(OrderWorkShopDay orderWorkShopDay)  throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			if(orderWorkShopDay==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("select count(*) from OrderWorkShopDay");			
			    long n=0;
			    if(query.iterate().hasNext())
			    	n=(Long) query.iterate().next();
				return n;
			}	
			orderIDS = orderWorkShopDay.getOrderID_s();
			status_i = orderWorkShopDay.getStatus_i();
			String hql="select count(*) from OrderWorkShopDay as orderWorkShopDay where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderWorkShopDay.orderID_s='"+orderIDS+"'";
			}
			if(status_i!=null){
				condition = condition+" and orderWorkShopDay.status_i="+status_i;
			}
			Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext())
		    	n=(Long) query.iterate().next();
			return n;
		}catch (Exception e){
		
			throw new Exception(e);
		}finally{
			close();
		}
	}
	public int checkOrderWorkShopDay(List list) throws Exception {
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		//子订单ID
		String orderWorkShopID_s = "";
		//日期
		Date   dateT = new Date();
		//状态
		int statusI;
		try{
			tx=session.beginTransaction();//开启事务			
			if(list!=null&&list.size()>0){
				for(int i =0;i<list.size();i++){
					//返回的信息
					Object[] orderWorkShopDayinfo = (Object[])list.get(i);
					orderWorkShopID_s = String.valueOf(orderWorkShopDayinfo[0]);
					dateT = (Date)orderWorkShopDayinfo[1];
					statusI = Integer.valueOf(String.valueOf(orderWorkShopDayinfo[2]));					
					int result = updateorderWorkShopDayStatus(orderWorkShopID_s,dateT,statusI,session);
					if(result==0)
					{
						tx.rollback();
						return result;
					}
					
				}
			}
			tx.commit();
			return 1;
		}catch (Exception e){
			tx.rollback();
			//System.out.println(e.toString());
			throw new Exception(e);
		}finally{
			close();
		}
	}
	
	public int updateorderWorkShopDayStatus(String orderWorkShopID_s,Date dateT, Integer status,Session session) {
		// TODO Auto-generated method stub		
		String hql="update OrderWorkShopDay as orderWorkShopDay  set orderWorkShopDay.status_i='"+status+"' where 1=1"; 
		String condition = "";
		if(orderWorkShopID_s!=null){
	    	condition = condition+" and orderWorkShopDay.orderWorkShopID_s='"+orderWorkShopID_s+"'";		    
		}
		if(dateT!=null){
	    	condition = condition+" and to_char(orderWorkShopDay.date_t,'yyyy-MM-dd')='"+DateUtil.dateToString(dateT,"yyyy-MM-dd")+"'";		    
		}
		Query query = session.createQuery(hql+condition);
		query.executeUpdate();
		return 1;
	}
	public void close(){

	}
	public static void main(String[] a){
		//修改路面拆分状态
		IorderWorkShopDayService iorderRoadDayDetailService = new OrderWorkShopDayServiceImpl();
		List list = new ArrayList();
		Object[] info;
		info = new Object[3];
		info[0] = "DD201404302401";
		Date date = new Date();
		date.setMonth(3);
		date.setDate(8);
		info[1] = date;
		info[2] = 1;
		list.add(info);
		info = new Object[3];
		info[0] = "DD201404302402";
		date = new Date();
		date.setMonth(3);
		date.setDate(7);
		info[1] = date;
		info[2] = 1;
		list.add(1,info);
		info = new Object[3];
		info[0] = "DD201404302402";
		date = new Date();
		date.setMonth(3);
		date.setDate(8);
		info[1] = date;
		info[2] = 1;
		list.add(2,info);
		info = new Object[3];
		info[0] = "DD201404302402";
		date = new Date();
		date.setMonth(3);
		date.setDate(9);
		info[1] = date;
		info[2] = 1;
		list.add(2,info);
		//DD201403302001
		try {
			long i = iorderRoadDayDetailService.getOrderWorkShopDayNumber(null);
			System.out.print(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//得到路面拆分表集合
		/*List<Orderroaddaydetail> list = iorderRoadDayDetailService.getOrderRoadDay("DD2014043021");
		for(int i=0;i<list.size();i++){
			Orderroaddaydetail orderRoadDayDetail = list.get(i);
			//System.out.println(i+"   "+orderRoadDayDetail.getIsok()+"   "+orderRoadDayDetail.getMaxCapacity_i());
		}
		//得到车间拆分表集合
		IorderWorkShopDayService IorderWorkShopDayService = new OrderWorkShopDayServiceImpl();
		List<OrderWorkShopDay> list1 = IorderWorkShopDayService.getOrderWorkShopDay("DD2014033020");
		for(int i=0;i<list1.size();i++){
			OrderWorkShopDay orderWorkShopDay = list1.get(i);
			//System.out.println(i+"   "+orderWorkShopDay.getOrderWorkShopID_s());
		}*/
		
	}
}
