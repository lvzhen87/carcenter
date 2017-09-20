package com.freshen.preorder.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Array;

import com.freshen.basis.service.IDriverService;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.TSubscribeOrdervehicleinfo;
import com.freshen.entity.basis.Driver;

import com.freshen.preorder.service.IorderVehicleInfoService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OrderVehicleInfoServiceImpl extends ClimsServiceBase implements IorderVehicleInfoService{

	private String orderidS;
	private OrderDetail TSubscribeOrder;
	private Integer testvehiclenumberI;
	private Integer escortvehiclenumberI;
	private String maxweightS;
	private Date createdateT;
	private String createuserS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private String resaveds1S;
	private String resaveds2S;
	private String resaveds3S;
	private String resaveds4S;
	private String resaveds5S;
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	/**
	 * 获得订单车辆信息表
	   
	 * getOrderVehicleInfo 
	 * @param   TSubscribeOrdervehicleinfo tSubscribeOrdervehicleinfo查询条件
	 * @param  @return    List    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<TSubscribeOrdervehicleinfo> getOrderVehicleInfo(TSubscribeOrdervehicleinfo tSubscribeOrdervehicleinfo, int start, int size) throws Exception{
		
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<TSubscribeOrdervehicleinfo> list = new ArrayList();
			
			if(tSubscribeOrdervehicleinfo == null){
				Query query=session.createQuery("from TSubscribeOrdervehicleinfo as tSubscribeOrdervehicleinfo");				
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			orderidS=tSubscribeOrdervehicleinfo.getOrderidS();
			testvehiclenumberI = tSubscribeOrdervehicleinfo.getTestvehiclenumberI();
			escortvehiclenumberI = tSubscribeOrdervehicleinfo.getEscortvehiclenumberI();
			maxweightS = tSubscribeOrdervehicleinfo.getMaxweightS();
		 
			if(orderidS != null && !orderidS.trim().equals("")){
				tSubscribeOrdervehicleinfo = (TSubscribeOrdervehicleinfo)session.get(tSubscribeOrdervehicleinfo.getClass(), orderidS);
		    	list.add(tSubscribeOrdervehicleinfo);
		    	return (ArrayList) list;
		    }
			
			String hql = " from TSubscribeOrdervehicleinfo as tSubscribeOrdervehicleinfo where 1=1 ";
		    String condition = "";
		   
		    if(testvehiclenumberI != null && !testvehiclenumberI.equals("")){
		    	condition = " and tSubscribeOrdervehicleinfo.testvehiclenumberI = '" + testvehiclenumberI + "'";
		    }
		    if(escortvehiclenumberI != null && !escortvehiclenumberI.equals("")){
		    	condition = " and tSubscribeOrdervehicleinfo.escortvehiclenumberI = '" + escortvehiclenumberI + "'";
		    }
		    if(maxweightS != null && !maxweightS.trim().equals("")){
		    	condition = condition + " and tSubscribeOrdervehicleinfo.maxweightS like '%" + maxweightS.trim() + "%'";
		    }
		    
		    Query query = session.createQuery(hql + condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();
		    return (ArrayList) list;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	 
	}

	 
	/**
	 * 保存订单车辆信息表
	   
	 * saveOrUpdateOrderVehicleInfoInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveOrUpdateOrderVehicleInfo(ArrayList<TSubscribeOrdervehicleinfo> list) throws Exception{
		
		TSubscribeOrdervehicleinfo driver = new TSubscribeOrdervehicleinfo();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					 
					//System.out.println("===="+driver.toString());
					session.saveOrUpdate(list.get(i));
					session.flush();
					session.clear();
				}
			}else{
				throw new Exception("驾驶员信息不正确");
			}		
			tx.commit();
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	
	public static void main(String arg[]) throws Exception{
		List<TSubscribeOrdervehicleinfo> list = new ArrayList();		 
		TSubscribeOrdervehicleinfo driver = new TSubscribeOrdervehicleinfo();
		 
		driver.setTestvehiclenumberI(2);
		driver.setEscortvehiclenumberI(2);
		OrderInfoServiceImpl OrderInfoServiceImpl = new OrderInfoServiceImpl();
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderID_s("DD2014041007");
		orderDetail = OrderInfoServiceImpl.getOrder(orderDetail).get(0);
		driver.setOrderidS("DD2014041007");
		driver.setTSubscribeOrder(orderDetail);
		list.add(driver);
		OrderVehicleInfoServiceImpl ids = new OrderVehicleInfoServiceImpl();
		int i =ids.saveOrUpdateOrderVehicleInfo((ArrayList)list);
	
	//	OrderVehicleInfoServiceImpl ids = new OrderVehicleInfoServiceImpl();
		List l = ids.getOrderVehicleInfo(null,-1,0);
		 driver = (TSubscribeOrdervehicleinfo)l.get(0);
		OrderDetail tSubscribeOrder = driver.getTSubscribeOrder();
		//System.out.println(tSubscribeOrder.toString());
		//System.out.println("l"+l.size());
	//	ids.deleteOrdervehicleinfoInfo((ArrayList<TSubscribeOrdervehicleinfo>)l);
	}

	public int deleteOrdervehicleinfoInfo(ArrayList<TSubscribeOrdervehicleinfo> list) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen())
		{
			session= HibernateUtil.getSession();
		}
		tx = session.beginTransaction();
		try {
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					session.delete(list.get(i));
					session.flush();
					session.clear();
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
			
		}
		
	}
	
 
	
}
