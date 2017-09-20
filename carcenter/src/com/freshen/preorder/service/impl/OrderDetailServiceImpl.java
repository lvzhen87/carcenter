package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderOther;
import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.preorder.service.IorderDetailService;
import com.freshen.preorder.service.IorderOthersListService;
import com.freshen.preorder.service.IorderRoadDetailsService;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OrderDetailServiceImpl extends ClimsServiceBase implements IorderDetailService{

	Session session=HibernateUtil.getSession();;
	Transaction tx = null;
	

	public int updateOrderRoadStatus(String orderRoadIDS, Integer status,Session session) {
		// TODO Auto-generated method stub
		
		OrderRoadDetail orderRoadDetail = new OrderRoadDetail();
		orderRoadDetail=(OrderRoadDetail)session.get(orderRoadDetail.getClass(), orderRoadIDS);
    	if(orderRoadDetail==null){    	    	
    		return 0;
    	}     	    	
    	orderRoadDetail.setStatus_i(Integer.valueOf(status));	    	 
    	session.update(orderRoadDetail);
		return 1;
	}

	public int updateOrderStatus(String orderIDS, Integer status,Session session) {
		// TODO Auto-generated method stub
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail=(OrderDetail)session.get(orderDetail.getClass(), orderIDS);
    	if(orderDetail==null){    	    	
    		return 0;
    	}     	    	
    	orderDetail.setStatus_i(Integer.valueOf(status));	    	 
    	session.update(orderDetail);   
		return 1;
		
	}

	public int updateOrderWorkShopStatus(String orderWorkShopIDS,
			Integer status,Session session) {
		// TODO Auto-generated method stub
		
		OrderWorkShop orderWorkShop = new OrderWorkShop();
		orderWorkShop=(OrderWorkShop)session.get(orderWorkShop.getClass(), orderWorkShopIDS);
    	if(orderWorkShop==null){    	
    	
    		return 0;
    	}     	    	
    	orderWorkShop.setStatus_i(Integer.valueOf(status));	    	 
    	session.saveOrUpdate(orderWorkShop);       	
		return 1;
	}

	public int OperationOrderWorkShopStatusInfo(OrderDetail orderDetail,
			List<OrderRoadDetail> orderRoadDetailList,
			List<OrderOther> orderOthersList,
			List<OrderWorkShop> orderWorkShopsList,
			OrderHotelOther orderHotelOther) throws Exception {
		// TODO Auto-generated method stub
		Integer OrderState_i = 0;
		String OrderId_i = "";
		IorderRoadDetailsService iorderRoadDetailsService = new OrderRoadDetailServiceImpl();
		IorderOthersListService  iorderOthersListService = new OrderOtherServiceImpl();
		IorderWorkShopService iorderWorkShopService = new OrderWorkShopServiceImpl();
		IreceptionOrderService ireceptionOrderService = new ReceptionOrderServiceImpl();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try{
			if(orderDetail!=null){
				OrderState_i = orderDetail.getStatus_i();
				if(OrderState_i == 1 || OrderState_i ==3){
					
					
					//删除ORDER表，触发删除相关的订单表
					OperationOrder(orderDetail,2,session);
					//新增ORDER表，并新增相关的订单表
					OperationOrder(orderDetail,1,session);
					iorderRoadDetailsService.OperationRoadDetail(orderRoadDetailList, 1, session);
					iorderOthersListService.OperationorderOthers(orderOthersList, 1, session);
					iorderWorkShopService.OperationorderWorkShop(orderWorkShopsList, 1, session);
					
				}
				else if(OrderState_i ==2 || OrderState_i >4){
					 
					OrderId_i = orderDetail.getOrderID_s();
					ReceptionOrder receptionOrder = new ReceptionOrder();
					receptionOrder = (ReceptionOrder)session.get(ReceptionOrder.class, OrderId_i);
					OrderState_i = orderDetail.getStatus_i();
					//将order状态改为1，路面占用查询数量会修改
					orderDetail.setStatus_i(1);
					OperationOrder(orderDetail,1,session);
					//删除ORDER表，触发删除相关的订单表
					OperationOrder(orderDetail,2,session);
					//新增ORDER表，并新增相关的订单表
					OperationOrder(orderDetail,1,session);
					iorderRoadDetailsService.OperationRoadDetail(orderRoadDetailList, 1, session);
					iorderOthersListService.OperationorderOthers(orderOthersList, 1, session);
					iorderWorkShopService.OperationorderWorkShop(orderWorkShopsList, 1, session);
					ireceptionOrderService.OperationReceptionOrder(receptionOrder, 2, session);
					orderDetail.setStatus_i(OrderState_i);
					OperationOrder(orderDetail,1,session);
					
				}
			}
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			
		}
		return 0;
	}

	public int OperationOrder(OrderDetail orderDetail,int operation,Session session) throws Exception{
		try{
			if(orderDetail==null){
				throw new Exception(this.getClass().getMethods()[0].getName()+"订单不存在");			
			}else{
				if(operation==1){
					OrderDetail tmp = (OrderDetail)session.get(OrderDetail.class, orderDetail.getOrderID_s());
					String orderName_s = orderDetail.getOrderName_s(); //试验名称
					String orderID_s = orderDetail.getOrderID_s();
					Date reservationDate_t = orderDetail.getReservationDate_t();
					Integer status_i = orderDetail.getStatus_i();
					String customerID_s = orderDetail.getCustomerID_s();
					Date startDate_t = orderDetail.getStartDate_t();
					Date endDate_t = orderDetail.getEndDate_t();
					String customerUserID_s = orderDetail.getCustomerUserID_s();
					String employeeID_s = orderDetail.getEmployeeID_s();
					String invoiceOrder_s = orderDetail.getInvoiceOrder_s();
					String addedValueTax_s = orderDetail.getAddedValueTax_s();
					String invoiceUser_s = orderDetail.getInvoiceUser_s();
					String receiveInvoiceAddress_s = orderDetail.getReceiveInvoiceAddress_s();
					String invoiceUserPhone_s = orderDetail.getInvoiceUserPhone_s(); 
					String customerAppraise_s = orderDetail.getCustomerAppraise_s();
					Date createDate_t = orderDetail.getCreateDate_t();
					String createUser_s = orderDetail.getCreateUser_s();
					String lastUpdateUser_s = orderDetail.getLastUpdateUser_s();
					Date lastUpdateDate_t = orderDetail.getLastUpdateDate_t();
					String resaveds1= orderDetail.getResaveds1();
					String resaveds2= orderDetail.getResaveds2();
					String resaveds3= orderDetail.getResaveds3();
					String resaveds4= orderDetail.getResaveds4();
					String resaveds5= orderDetail.getResaveds5();
					
					if(orderName_s==null){
						orderDetail.setOrderName_s(tmp.getOrderName_s());
					}
					if(orderID_s==null){
						orderDetail.setOrderID_s(tmp.getOrderID_s());
					}
					if(reservationDate_t==null){
						orderDetail.setReservationDate_t(tmp.getReservationDate_t());
					}
					if(status_i==null){
						orderDetail.setStatus_i(tmp.getStatus_i());
					}
					if(customerID_s == null){
						orderDetail.setCustomerID_s(tmp.getCustomerID_s());
					}
					if(startDate_t == null){
						orderDetail.setStartDate_t(tmp.getStartDate_t());
					}
					if(endDate_t == null){
						orderDetail.setEndDate_t(tmp.getEndDate_t());
					}
					if(customerUserID_s == null){
						orderDetail.setCustomerUserID_s(tmp.getCustomerUserID_s());
					}
					if(employeeID_s == null){
						orderDetail.setEmployeeID_s(tmp.getEmployeeID_s());
					}
					if(invoiceOrder_s == null){
						orderDetail.setInvoiceOrder_s(tmp.getInvoiceOrder_s());
					}
					if(addedValueTax_s == null){
						orderDetail.setAddedValueTax_s(tmp.getAddedValueTax_s());
					}
					if(invoiceUser_s == null){
						orderDetail.setInvoiceUser_s(tmp.getInvoiceUser_s());
					}
					if(receiveInvoiceAddress_s == null){
						orderDetail.setReceiveInvoiceAddress_s(tmp.getReceiveInvoiceAddress_s());
					}
					if(invoiceUserPhone_s==null){
						orderDetail.setInvoiceUserPhone_s(tmp.getInvoiceUserPhone_s());
					}
					if(customerAppraise_s==null){
						orderDetail.setCustomerAppraise_s(tmp.getCustomerAppraise_s());
					}
					if(createDate_t==null){
						orderDetail.setCreateDate_t(tmp.getCreateDate_t());
					}
					if(createUser_s==null){
						orderDetail.setCreateUser_s(tmp.getCreateUser_s());
					}
					if(lastUpdateUser_s==null){
						orderDetail.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
					}
					if(lastUpdateDate_t==null){
						orderDetail.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
					}
					if(resaveds1==null){
						orderDetail.setResaveds1(tmp.getResaveds1());
					}
					if(resaveds2==null){
						orderDetail.setResaveds2(tmp.getResaveds2());
					}
					if(resaveds3==null){
						orderDetail.setResaveds3(tmp.getResaveds3());
					}
					if(resaveds4==null){
						orderDetail.setResaveds4(tmp.getResaveds4());
					}
					if(resaveds5==null){
						orderDetail.setResaveds5(tmp.getResaveds5());
					}
					session.saveOrUpdate(orderDetail);
					session.flush();
				    session.clear();
				}
				//删除
				if(operation==2){
					session.delete(orderDetail);
					session.flush();
					session.clear();
				}
				return 1;
			}
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}
	
	public static void main(String arg[]) throws Exception{
		OrderDetailServiceImpl impl = new OrderDetailServiceImpl();
		Session session = HibernateUtil.getSession();
		OrderDetail orderDetail = new OrderDetail();// (OrderDetail)session.get(OrderDetail.class, "DD2014041007");
		orderDetail.setOrderID_s("DD2014041007");
		orderDetail =  (OrderDetail)session.get(OrderDetail.class, "DD2014041007");
		
		List<OrderRoadDetail> orderRoadDetailList = new ArrayList<OrderRoadDetail>();
		OrderRoadDetail orderRoadDetail = new OrderRoadDetail();// (OrderRoadDetail)session.get(OrderRoadDetail.class, "DD2014041007");
		orderRoadDetail.setOrderID_s("DD2014041007");
		orderRoadDetail.setStatus_i(0);
		orderRoadDetail.setType_s("0");
		orderRoadDetail.setCreateUser_s("orderRoadDetail1111");
		orderRoadDetail.setDescription_s("orderRoadDetail2222222");
		orderRoadDetail.setHoursNumber_s("orderRoadDetail3333333");
//		orderRoadDetail.setCreateDate_t(new Date());
		String de = "2014-05-07";
		Date datee = DateUtil.stringToDateformat(de, "yyyy-MM-dd");
		orderRoadDetail.setEndDate_t(new Date());
		orderRoadDetail.setOrderRoadID_s("4321");
		String d = "2014-05-02";
		Date date = DateUtil.stringToDateformat(d, "yyyy-MM-dd");
		
		orderRoadDetail.setStartDate_t(date);
		orderRoadDetailList.add(orderRoadDetail);
		
		List<OrderOther> orderOthersList = new ArrayList<OrderOther>();
		OrderOther orderOther = new OrderOther();// (OrderOther)session.get(OrderOther.class, "DD2014041007");
		orderOther.setOrderID_s("DD2014041007");
		orderOther.setColor_s("orderOthersList111111");
		orderOther.setFuelDemand_s("orderOthersList2222222");
		orderOther.setMaxWeight_s("orderOthersList3333333");
		orderOthersList.add(orderOther);
		
		List<OrderWorkShop> orderWorkShopsList = new ArrayList<OrderWorkShop>();
		OrderWorkShop orderWorkShop = new OrderWorkShop();// (OrderWorkShop)session.get(OrderWorkShop.class, "DD2014041007");
		orderWorkShop.setOrderID_s("DD2014041007");
		orderWorkShop.setRemark("orderWorkShop111111");
		orderWorkShop.setResaveds1("orderWorkShop2222222");
		orderWorkShop.setResaveds2("orderWorkShop3333333");
		orderWorkShop.setEndDate_t(new Date());
		String da = "2014-05-02";
		Date dates = DateUtil.stringToDateformat(da, "yyyy-MM-dd");
		orderWorkShop.setStartDate_t(dates);
		orderWorkShop.setCreateDate_t(new Date());
		orderWorkShopsList.add(orderWorkShop);
		
		OrderHotelOther orderHotelOther = new OrderHotelOther();// (OrderHotelOther)session.get(OrderHotelOther.class, "DD2014041007");
		orderHotelOther.setOrderID_s("DD2014041007");
		orderHotelOther.setRemark_s("orderHotelOther1111");
		orderHotelOther.setResaveds1("orderHotelOther22222");
		orderHotelOther.setResaveds3("orderHotelOther3333333");
		
		impl.OperationOrderWorkShopStatusInfo(orderDetail,orderRoadDetailList,orderOthersList,orderWorkShopsList,
				orderHotelOther);
		
	}

	public int setOrderDetailState(String orderId_s, int state_i)
			throws Exception {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		tx = session.beginTransaction();
		try{
			if(orderId_s != null && !orderId_s.trim().equals(""))
			{
				Query query = session.createQuery(" from OrderDetail as orderDetail where orderDetail.orderID_s ='" + orderId_s + "'");
				if(query.list() != null)
				{
					orderDetail = (OrderDetail)query.list().get(0);
					orderDetail.setStatus_i(state_i);
					session.saveOrUpdate(orderDetail);
					tx.commit();
					return 1;
				}
			}
		}
		catch(Exception e){
			tx.rollback();
			throw e;
		}
		finally{
			
		}
		return 0;
	}

	public int OperationOrder(OrderDetail orderDetail, Integer operation)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		try{
			if(orderDetail==null){
				throw new Exception(this.getClass().getMethods()[0].getName()+"订单不存在");			
			}else{
				if(operation==1){
					OrderDetail tmp = (OrderDetail)session.get(OrderDetail.class, orderDetail.getOrderID_s());
					String orderName_s = orderDetail.getOrderName_s(); //试验名称
					String orderID_s = orderDetail.getOrderID_s();
					Date reservationDate_t = orderDetail.getReservationDate_t();
					Integer status_i = orderDetail.getStatus_i();
					String customerID_s = orderDetail.getCustomerID_s();
					Date startDate_t = orderDetail.getStartDate_t();
					Date endDate_t = orderDetail.getEndDate_t();
					String customerUserID_s = orderDetail.getCustomerUserID_s();
					String employeeID_s = orderDetail.getEmployeeID_s();
					String invoiceOrder_s = orderDetail.getInvoiceOrder_s();
					String addedValueTax_s = orderDetail.getAddedValueTax_s();
					String invoiceUser_s = orderDetail.getInvoiceUser_s();
					String receiveInvoiceAddress_s = orderDetail.getReceiveInvoiceAddress_s();
					String invoiceUserPhone_s = orderDetail.getInvoiceUserPhone_s(); 
					String customerAppraise_s = orderDetail.getCustomerAppraise_s();
					Date createDate_t = orderDetail.getCreateDate_t();
					String createUser_s = orderDetail.getCreateUser_s();
					String lastUpdateUser_s = orderDetail.getLastUpdateUser_s();
					Date lastUpdateDate_t = orderDetail.getLastUpdateDate_t();
					String resaveds1= orderDetail.getResaveds1();
					String resaveds2= orderDetail.getResaveds2();
					String resaveds3= orderDetail.getResaveds3();
					String resaveds4= orderDetail.getResaveds4();
					String resaveds5= orderDetail.getResaveds5();
					if(orderName_s!=null){
						tmp.setOrderName_s(orderName_s);
					}
					if(receiveInvoiceAddress_s != null){
						tmp.setReceiveInvoiceAddress_s(receiveInvoiceAddress_s);
					}
					
					if(orderName_s!=null){
						tmp.setOrderName_s(orderName_s);
					}
					if(orderID_s!=null){
						tmp.setOrderID_s(orderID_s);
					}
					if(reservationDate_t!=null){
						tmp.setReservationDate_t(reservationDate_t);
					}
					if(status_i!=null){
						tmp.setStatus_i(status_i);
					}
					if(customerID_s != null){
						tmp.setCustomerID_s(customerID_s);
					}
					if(startDate_t != null){
						tmp.setStartDate_t(startDate_t);
					}
					if(endDate_t != null){
						tmp.setEndDate_t(endDate_t);
					}
					if(customerUserID_s != null){
						tmp.setCustomerUserID_s(customerUserID_s);
					}
					if(employeeID_s != null){
						tmp.setEmployeeID_s(employeeID_s);
					}
					if(invoiceOrder_s != null){
						tmp.setInvoiceOrder_s(invoiceOrder_s);
					}
					if(addedValueTax_s != null){
						tmp.setAddedValueTax_s(addedValueTax_s);
					}
					if(invoiceUser_s != null){
						tmp.setInvoiceUser_s(invoiceUser_s);
					}
					if(receiveInvoiceAddress_s != null){
						tmp.setReceiveInvoiceAddress_s(receiveInvoiceAddress_s);
					}
					if(invoiceUserPhone_s  != null){
						tmp.setInvoiceUserPhone_s(invoiceUserPhone_s);
					}
					if(customerAppraise_s != null){
						tmp.setCustomerAppraise_s(customerAppraise_s);
					}
					if(createDate_t != null){
						tmp.setCreateDate_t(createDate_t);
					}
					if(createUser_s != null){
						tmp.setCreateUser_s(createUser_s);
					}
					if(lastUpdateUser_s !=null){
						tmp.setLastUpdateUser_s(lastUpdateUser_s);
					}
					if(lastUpdateDate_t!=null){
						tmp.setLastUpdateDate_t(lastUpdateDate_t);
					}
					if(resaveds1 !=null){
						tmp.setResaveds1(resaveds1);
					}
					if(resaveds2 !=null){
						tmp.setResaveds2(resaveds2);
					}
					if(resaveds3!=null){
						tmp.setResaveds3(resaveds3);
					}
					if(resaveds4!=null){
						tmp.setResaveds4(resaveds4);
					}
					if(resaveds5!=null){
						tmp.setResaveds5(resaveds5);
					}
					session.saveOrUpdate(tmp);
					session.flush();
				    session.clear();
				}
				//删除
				if(operation==2){
					session.delete(orderDetail);
					session.flush();
					session.clear();
				}
				return 1;
			}
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}

	public int updateOrderDetail(Employee employee, Session session) {
		int value = 0;
//		Transaction tx = session.beginTransaction();
		try {
			if(employee.getOrganizationDept_s() == null && employee.getOrganizationPost_s() == null && !employee.getEmployeeID_s().trim().equals("")){
				Query query = session.createQuery("update OrderDetail orderDetail set orderDetail.employeeID_s = '' where orderDetail.employeeID_s = '" 
						+ employee.getEmployeeID_s().trim() + "' and status_i < 3" ); 
				query.executeUpdate(); 
				session.flush();
//				tx.commit();
			}
		} catch (Exception e) {
//			tx.rollback();
			// TODO: handle exception
		}finally{
			return value;
		}
	}

}
