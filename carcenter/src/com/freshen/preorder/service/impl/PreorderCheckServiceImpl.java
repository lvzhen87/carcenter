package com.freshen.preorder.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderWorkShopDay;
import com.freshen.entity.Orderroaddaydetail;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IorderDetailService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.IorderRoadDayDetailService;
import com.freshen.preorder.service.IorderWorkShopDayService;
import com.freshen.preorder.service.IpreorderCheckService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.HibernateUtil;
import com.freshen.util.OperationPDF;
import com.freshen.util.SimpleMailSender;

public class PreorderCheckServiceImpl extends ClimsServiceBase implements IpreorderCheckService {

	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	public int customerCheck(String customerid, String status)throws Exception  {
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			// TODO Auto-generated method stub
			tx=session.beginTransaction();//开启事务
			//更新客户人员表状态
		//	IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		//	icustomerUserService.updateCustomerUserStatus(customerUserid, status,session);		
			//得到客户信息
			String hql="from Customer as customer where 1=1 "; 
			if(customerid!=null){
				hql = hql+" and customer.customerID_s='"+customerid+"'";
		    }else{
		    	tx.rollback();
		    	throw new Exception("客户编号不能为空");
		    }
			Query query=session.createQuery(hql);
		    List<Customer> list = query.list();	 
		    if(list!=null&&list.size()>0){
		    	Customer customer = list.get(0);
		    	//修改客户信息表状态
		    	IcustomerService icustomerService = new CustomerServiceImpl();
		    	icustomerService.updateCustomerStatus(customer.getCustomerID_s(), status,session);	
		    	tx.commit();
		    	new SimpleMailSender().sendCustomerCheckMail(customer.getCustomerID_s());
		    }	    	    	
	    	//客户注册审核发送邮件
	    	
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
		 
		}
	}
	
	/**
	 * 
	   对路面试验和车间试验进行判断，当所有都通过审核后修改order状态为预订已确认并发邮件
	 * preorderCheckold 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int preorderCheckold(String orderID,int type)throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
//System.out.println("-------------------进入preorderCheck-------------")	;	
		tx=session.beginTransaction();//开启事务
		try{
			 
			IorderInfoService iorderInfoService = new OrderInfoServiceImpl();
			IorderWorkShopDayService iorderWorkShopDayService = new OrderWorkShopDayServiceImpl();
			IorderRoadDayDetailService iorderRoadDayDetailService = new OrderRoadDayDetailServiceImpl();
			int result = -1;
			// TODO Auto-generated method stub
			OrderDetail orderDetail = new OrderDetail();
			ReceptionOrder receptionOrder = new ReceptionOrder();
			orderDetail.setOrderID_s(orderID);			
			List<OrderDetail> list = iorderInfoService.getOrder(orderDetail);			
			if(list!=null&&list.size()>0){
				orderDetail = list.get(0);
				//试验路面预约详细订单拆分信息 
				Orderroaddaydetail orderroaddaydetail = new Orderroaddaydetail();
				orderroaddaydetail.setOrderidS(orderID);
				orderroaddaydetail.setStatusI(ConstantUtil.subitemOrderStatus_0);
				long number= iorderRoadDayDetailService.getOrderRoadDayNumber(orderroaddaydetail);
				if(number>0){
		//			new SimpleMailSender().sendOrderCheckMail(orderID);
					return 0;
				}
				//试车间及办公室预订拆分信息 
				OrderWorkShopDay orderWorkShopDay= new OrderWorkShopDay();
				orderWorkShopDay.setOrderID_s(orderID);
				orderWorkShopDay.setStatus_i(ConstantUtil.subitemOrderStatus_0);
				
				number = iorderWorkShopDayService.getOrderWorkShopDayNumber(orderWorkShopDay);
				if(number>0){
		//			new SimpleMailSender().sendOrderCheckMail(orderID);
					return 0;
				}
				
				//子订单全部通过,修改预约订单状态
				IorderDetailService iorderDetailService = new OrderDetailServiceImpl();
				iorderDetailService.updateOrderStatus(orderID,ConstantUtil.orderStatus_2,session);
				//保存到计划订单表
				
				receptionOrder.setAddedValueTax_s(orderDetail.getAddedValueTax_s());
				receptionOrder.setCapgUserID_s(orderDetail.getEmployeeID_s());
				receptionOrder.getCustomer().setCustomerID_s(orderDetail.getCustomerID_s());
				receptionOrder.setEndDate_d(orderDetail.getEndDate_t());
				receptionOrder.setInvoiceOrder_s(orderDetail.getInvoiceOrder_s());			
				receptionOrder.setInvoiceUser_s(orderDetail.getInvoiceUser_s());
				receptionOrder.setOrderID_s(orderDetail.getOrderID_s());
				receptionOrder.setReservationDate_t(orderDetail.getReservationDate_t());
				receptionOrder.setStartDate_d(orderDetail.getStartDate_t());
				receptionOrder.setStatus_i(orderDetail.getStatus_i());	
				receptionOrder.setCustomerUserID_s(orderDetail.getCustomerUserID_s());	
				receptionOrder.setOrderName_s(orderDetail.getOrderName_s());
				receptionOrder.setIspotential(orderDetail.getIspotential());
				
			}else{
				 
				throw new Exception("订单编号不存在");
			}
			
			session.saveOrUpdate(receptionOrder);
			if(result==0){
				tx.rollback();
				return result;
			}
	    	tx.commit();
	    	//发送邮件
	    	
	    	String path=this.getClass().getResource("/").getPath();
	    	path = path.replaceAll("%20", " ");
	    	//System.out.println(path);
	    	OperationPDF.generatePDF(path+"/江苏盐城试验场确认函.jasper",orderID); 	 
	  // 	OperationPDF.generatePDF("/../classes/com/freshen/file/pdf/江苏盐城试验场确认函.jasper",orderID); 	 
	    	//OperationPDF.generatePDF("src/com/freshen/file/pdf/江苏盐城试验场确认函.jasper",orderID);
	    	new SimpleMailSender().sendOrderCheckMail(orderID);
	    	
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
			session.close();
		}
	}
	
	public int preorderCheck(String orderID,int type)throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
//System.out.println("-------------------进入preorderCheck-------------")	;	
		tx=session.beginTransaction();//开启事务
		try{
			 
			IorderInfoService iorderInfoService = new OrderInfoServiceImpl();
			//IorderWorkShopDayService iorderWorkShopDayService = new OrderWorkShopDayServiceImpl();
			//IorderRoadDayDetailService iorderRoadDayDetailService = new OrderRoadDayDetailServiceImpl();
			int result = -1;
			// TODO Auto-generated method stub
			OrderDetail orderDetail = new OrderDetail();
			ReceptionOrder receptionOrder = new ReceptionOrder();
			orderDetail.setOrderID_s(orderID);			
			List<OrderDetail> list = iorderInfoService.getOrder(orderDetail);			
			if(type==1){//审核通过
				if(list!=null&&list.size()>0){
					orderDetail = list.get(0);
				 
					//子订单全部通过,修改预约订单状态
					IorderDetailService iorderDetailService = new OrderDetailServiceImpl();
					iorderDetailService.updateOrderStatus(orderID,ConstantUtil.orderStatus_2,session);
					//保存到计划订单表
					
					receptionOrder.setAddedValueTax_s(orderDetail.getAddedValueTax_s());
					receptionOrder.setCapgUserID_s(orderDetail.getEmployee().getEmployeeID_s());
					//receptionOrder.setCapgUserID_s(orderDetail.getEmployeeID_s());
					receptionOrder.getCustomer().setCustomerID_s(orderDetail.getCustomerID_s());
					receptionOrder.setEndDate_d(orderDetail.getEndDate_t());
					receptionOrder.setInvoiceOrder_s(orderDetail.getInvoiceOrder_s());
					receptionOrder.setInvoiceUser_s(orderDetail.getInvoiceUser_s());
					receptionOrder.setOrderID_s(orderDetail.getOrderID_s());
					receptionOrder.setReservationDate_t(orderDetail.getReservationDate_t());
					receptionOrder.setStartDate_d(orderDetail.getStartDate_t());
					receptionOrder.setStatus_i(ConstantUtil.orderStatus_2);	//设置订单状态为2，以确认
					receptionOrder.setCustomerUserID_s(orderDetail.getCustomerUserID_s());	
					receptionOrder.setReceiverlnvoiceaddress_s(orderDetail.getReceiveInvoiceAddress_s());
					receptionOrder.setOrderName_s(orderDetail.getOrderName_s());
					receptionOrder.setInvoiceUserPhone_s(orderDetail.getInvoiceUserPhone_s());
				}else{
					throw new Exception("订单编号不存在");
				}
				session.saveOrUpdate(receptionOrder);
				if(result==0){
					tx.rollback();
					return result;
				}
		    	
		    	//发送邮件
		    	OperationPDF.generatePDF("c:/江苏盐城试验场确认函.jasper",orderID); 	 
				  String path=this.getClass().getResource("/").getPath();//得到d:/tomcat/webapps/工程名WEB-INF/classes/路径
				  path = path.replaceAll("%20", " ");

				  //System.out.println(path);		         
				 
		    	//OperationPDF.generatePDF("src/com/freshen/file/pdf/江苏盐城试验场确认函.jasper",orderID);
		   //暂时注释
			//	OperationPDF.generatePDF(path+"/江苏盐城试验场确认函.jasper",orderID);   
			//	new SimpleMailSender().sendOrderCheckMail(orderID);
		    	tx.commit();
			}else{
				//暂时注释
			//	new SimpleMailSender().sendOrderCheckMail(orderID);
			}
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
			session.close();
		}
	}
	/**
	 * 一键审核方法
	 * @param orderId_s
	 * @param status
	 * @return
	 */
	public int OneKeyCheckOrder(String orderId_s,String status)throws Exception{
		try{
			
			
		}catch(Exception e){
			
		}finally{
			return 1;
		}
		
	}
	public  static void main(String[] a){
	//	IcustomerUserService ipreorderCheckService = new CustomerUserServiceImpl();
		try {
			new PreorderCheckServiceImpl().preorderCheck("DD2014041007",1);			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*SimpleMailSender s = new SimpleMailSender();
		s.sendOrderCheckMailnew("DD2014041001");*/
	}
}
