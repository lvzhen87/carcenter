package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.Orderroaddaydetail;
import com.freshen.entity.TInquityRoadoccupyinfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.preorder.service.IorderRoadDayDetailService;
import com.freshen.preorder.service.ItInquityRoadoccupyinfoService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
public class OrderRoadDayDetailServiceImpl extends ClimsServiceBase implements IorderRoadDayDetailService{

	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	String orderIDS;
	Integer statusI;
	public ArrayList<Orderroaddaydetail> getOrderRoadDay(Orderroaddaydetail orderroaddaydetail,int start,
			int pageSize) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		List<Orderroaddaydetail> list = new ArrayList();
		try{
			if(orderroaddaydetail==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from Orderroaddaydetail");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(pageSize);
				}
				list = query.list();
			}else{
				orderIDS = orderroaddaydetail.getOrderidS();
				statusI = orderroaddaydetail.getStatusI();
				String hql="from Orderroaddaydetail as orderRoadDayDetail where 1=1 "; 
				String condition = "";
				if(orderIDS!=null){
			    	condition = condition+" and orderRoadDayDetail.orderidS='"+orderIDS+"'";		    
				}
				if(statusI!=null){
			    	condition = condition+" and orderRoadDayDetail.statusI="+statusI;		    
				}
				Query query=session.createQuery(hql+condition);
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(pageSize);
				}
				list = query.list();	  
			}
		
		    if(list!=null&&list.size()>0){
		    	for(int i=0;i<list.size();i++){
		    		int maxCapacity_i = 0;
		    		String occupy_s =""       ;//道路占用信息字符串 kxc
		    		Orderroaddaydetail orderRoadDayDetail = (Orderroaddaydetail)list.get(i);
		    		//得到道路id
		    		String roadID_s = orderRoadDayDetail.getRoadidS();
		    		RoadInfo roadInfo = new RoadInfo();
		    		roadInfo.setRoadID_s(roadID_s);
		    		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		    		List<RoadInfo> listRoadInfo = iroadInfoService.getRoadInfo(roadInfo);
		    		if(listRoadInfo!=null&&listRoadInfo.size()>0){
		    			maxCapacity_i = listRoadInfo.get(0).getMaxCapacity_i();
		    			//道路最大容量
		    		 
		    			orderRoadDayDetail.setMaxCapacity_i(maxCapacity_i);	    			
		    		}
		    		 
		    		//得到当天当道路预约数量
		    		Date date = orderRoadDayDetail.getDateT();
		    		ConstantUtil a;
		     		ItInquityRoadoccupyinfoService tInquityRoadoccupyinfoService = new TInquityRoadoccupyinfoServiceImpl();
		     		List<TInquityRoadoccupyinfo> inquityRoadoccupyinfoList = tInquityRoadoccupyinfoService.getTInquityRoadoccupyinfo(roadID_s, date);
		     		//已进行过审核
		     		if(orderRoadDayDetail.getStatusI()==ConstantUtil.subitemOrderStatus_0){	     				     		
			     		if(inquityRoadoccupyinfoList==null||inquityRoadoccupyinfoList.size()==0){
			     			//orderRoadDayDetail.setStatusI(1);
			     		}else{
			     			TInquityRoadoccupyinfo tInquityRoadoccupyinfo = inquityRoadoccupyinfoList.get(0);
			     			tInquityRoadoccupyinfo.setDayData();
			     			int day = date.getDay();
			     			//当天的预约数量
			     			int daynumber = Integer.valueOf(String.valueOf(tInquityRoadoccupyinfo.dayData.get(day)));
			     			occupy_s = daynumber+"/"+maxCapacity_i;
			     			/*if(daynumber>maxCapacity_i){			     				
			     				orderRoadDayDetail.setStatusI(ConstantUtil.subitemOrderStatus_2);
			     			}else{
			     				orderRoadDayDetail.setStatusI(ConstantUtil.subitemOrderStatus_1);
			     			}*/
			     			orderRoadDayDetail.setOccupy_s(daynumber+"");
			     		}
		     		}
		     		
		     		list.set(i, orderRoadDayDetail);
		    	}
		    }		
    	return (ArrayList<Orderroaddaydetail>) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		 
		}		   
	}
	public long getOrderRoadDayNumber(Orderroaddaydetail orderroaddaydetail) throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			if(orderroaddaydetail==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("select count(*) from Orderroaddaydetail");			
			    long n=0;
			    if(query.iterate().hasNext())
			    	n=(Long) query.iterate().next();
				return n;
			}	
			orderIDS = orderroaddaydetail.getOrderidS();
			statusI = orderroaddaydetail.getStatusI();
			String hql="select count(*) from Orderroaddaydetail as orderroaddaydetail where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderroaddaydetail.orderidS='"+orderIDS+"'";
			}
			if(statusI!=null){
				condition = condition+" and orderroaddaydetail.statusI="+statusI;
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
	public int checkOrderRoadDay(List list) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		//子订单ID
		String orderroadidS = "";
		//日期
		Date   dateT = new Date();
		//状态
		int statusI;
		try{
			tx=session.beginTransaction();//开启事务			
			if(list!=null&&list.size()>0){
				for(int i =0;i<list.size();i++){
					//返回的信息
					Object[] orderRoadDayinfo = (Object[])list.get(i);
					orderroadidS = String.valueOf(orderRoadDayinfo[0]);
					dateT = (Date)orderRoadDayinfo[1];
					statusI = Integer.valueOf(String.valueOf(orderRoadDayinfo[2]));					
					int result = updateOrderRoadDayStatus(orderroadidS,dateT,statusI,session);
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
	
	public int updateOrderRoadDayStatus(String orderRoadIDS,Date dateT, Integer status,Session session) {
		// TODO Auto-generated method stub
		
		Orderroaddaydetail orderroaddaydetail = new Orderroaddaydetail();
		String hql="update Orderroaddaydetail as orderroaddaydetail  set orderroaddaydetail.statusI='"+status+"' where 1=1"; 
		String condition = "";
		if(orderRoadIDS!=null){
	    	condition = condition+" and orderroaddaydetail.orderroadidS='"+orderRoadIDS+"'";		    
		}
		if(dateT!=null){
	    	condition = condition+" and to_char(orderroaddaydetail.dateT,'yyyy-MM-dd')='"+DateUtil.dateToString(dateT,"yyyy-MM-dd")+"'";		    
		}
		Query query = session.createQuery(hql+condition);
		query.executeUpdate();
		 
		
		return 1;
	}
	
	public void close(){
	}
	public static void main(String[] a){
		//修改路面拆分状态
		IorderRoadDayDetailService iorderRoadDayDetailService = new OrderRoadDayDetailServiceImpl();
		List list = new ArrayList();
		Object[] info;
		info = new Object[3];
		info[0] = "DD201404302401";
		Date date = new Date();
		date.setMonth(3);
		date.setDate(2);
		info[1] = date;
		info[2] = 1;
		list.add(info);
		info = new Object[3];
		info[0] = "DD201404302401";
		date = new Date();
		date.setMonth(3);
		date.setDate(3);
		info[1] = date;
		info[2] = 1;
		list.add(1,info);
		info = new Object[3];
		info[0] = "DD201404302401";
		date = new Date();
		date.setMonth(3);
		date.setDate(4);
		info[1] = date;
		info[2] = 1;
		list.add(2,info);
		info = new Object[3];
		info[0] = "DD201404302401";
		date = new Date();
		date.setMonth(3);
		date.setDate(1);
		info[1] = date;
		info[2] = 1;
		list.add(2,info);
		info = new Object[3];
		info[0] = "DD201404302402";
		date = new Date();
		date.setMonth(3);
		date.setDate(10);
		info[1] = date;
		info[2] = 1;
		list.add(2,info);
		//DD201403302001
		try {
			long l = iorderRoadDayDetailService.getOrderRoadDayNumber(null);
			System.out.print(l);
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
