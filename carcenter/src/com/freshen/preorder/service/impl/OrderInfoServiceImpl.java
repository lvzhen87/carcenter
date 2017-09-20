package com.freshen.preorder.service.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderOther;
import com.freshen.entity.OrderRoadDetail;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.Employee;

import com.freshen.entity.basis.RoadInfo;
import com.freshen.preorder.service.IorderDetailService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;
import com.freshen.clims.baseclass.ClimsServiceBase;



public class OrderInfoServiceImpl extends ClimsServiceBase implements  IorderInfoService{
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	//预约订单属性
	String orderID_s;
	String orderName_s;
	Date reservationDate_t;
	Integer status_i;
	String customerID_s;
	Date startDate_t;
	Date endDate_t;
	String customerUserID_s;
	String employeeID_s;
	String invoiceOrder_s;
	String addedValueTax_s;
	String invoiceUser_s;
	String receiveInvoiceAddress_s,invoiceUserPhone_s;
	String customerAppraise_s;
	
	//订单其他信息	 
	String vehicleType_s;
	Integer vehicleNumber_i;
	String model_s;
	Integer isConfidentiality_i;
	Integer weight_i;
	Integer maxWeight_i;
	Integer isHighRiskTest_i;
	String highRiskTestDescription_s;
	String fuelDemand_s;
	Integer isCamera_i;
	String vehicleCPG_s;
	
	//试验路面预约信息
	String type_s, roadID_s, roadName_s, hoursNumber_s;
	String orderRoadID_s;
	String maxSpeed_s, description_s;
	String carIndex_s;//车辆序号
	String carCPG_s;//试验车辆的CPG牌照号
	
	public ArrayList<OrderDetail> getOrder(OrderDetail orderDetail) throws Exception{
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		
		try{
			List<OrderDetail> list = null;
			if(orderDetail==null){
				Query query=session.createQuery("from OrderDetail");
			    list = query.list();	  			
				return (ArrayList) list;
			}
			customerUserID_s = orderDetail.getCustomerUserID_s();
			orderName_s = orderDetail.getOrderName_s();
			status_i = orderDetail.getStatus_i();		
			orderID_s = orderDetail.getOrderID_s();
			reservationDate_t = orderDetail.getReservationDate_t();
			startDate_t = orderDetail.getStartDate_t();
			endDate_t = orderDetail.getEndDate_t();
			employeeID_s = orderDetail.getEmployeeID_s();
			
			invoiceUser_s = orderDetail.getInvoiceUser_s();
			receiveInvoiceAddress_s = orderDetail.getReceiveInvoiceAddress_s();
			invoiceUserPhone_s = orderDetail.getInvoiceUserPhone_s();		
		 
			/*if(orderID_s!=null){
				orderDetail=(OrderDetail)session.get(orderDetail.getClass(), orderID_s);
				if(orderDetail==null){
					return null;
				}
		    	list = new ArrayList();
				list.add(orderDetail);
		    	return (ArrayList)list;
		    }*/
	
			String hql="from OrderDetail as orderDetail where 1=1 "; 
		    String condition = "";
		    if(orderID_s!=null){
		    	condition +=" and orderDetail.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(orderName_s!=null){
		    	condition += condition+" and orderDetail.orderIDName_s like '%"+orderName_s+"%'";
		    }
		    if(status_i!=null){
		    	condition += " and orderDetail.status_i='"+status_i+"'";
		    }
		    if(customerUserID_s!=null){
		    	condition += condition+" and orderDetail.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(startDate_t!=null&&endDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition += condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	condition += condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }		     
		    if(employeeID_s!=null){
		    	//以没有设定客户助理查询
		    	if("null".equals(employeeID_s)){
		    		condition += condition+" and orderDetail.employee.employeeID_s is null";
		    	}else if("notnull".equals(employeeID_s)){
		    		condition += condition+" and orderDetailemployee.employeeID_s is not null";
		    	}else{
		    		condition += condition+" and orderDetail.employee.employeeID_s = '"+employeeID_s+"'";
		    	}
		    }
		    
		    if(invoiceUser_s!=null){
		    	condition += condition+" and orderDetail.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(receiveInvoiceAddress_s!=null){
		    	condition += condition+" and orderDetail.receiveInvoiceAddress_s like '%"+receiveInvoiceAddress_s+"%'";
		    }
		    if(invoiceUserPhone_s!=null){
		    	condition += condition+" and orderDetail.invoiceUserPhone_s like '%"+invoiceUserPhone_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
		    list = query.list();	
		    return (ArrayList<OrderDetail>) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}		   
	}
	/*public int checkOrder(List list) throws Exception {
		// TODO Auto-generated method stub
		IorderDetailService iorderDetailService = new OrderDetailServiceImpl();
		if(list!=null&&list.size()>0){
			for(int i =0;i<list.size();i++){
				String[] info = String.valueOf(list.get(i)).split("vv");
				int result = iorderDetailService.updateOrderStatus(info[0],Integer.valueOf(info[1]),session);
				if(result==0)
				{
					return result;
				}
			}
		}
		return 1;
	}*/
	public int checkOrderHotelOther(List list) throws Exception {
		// TODO Auto-generated method stub
		IorderDetailService iorderDetailService = new OrderDetailServiceImpl();
		if(list!=null&&list.size()>0){
			for(int i =0;i<list.size();i++){
				String[] info = String.valueOf(list.get(i)).split("vv");
	//			iorderDetailService .updateOrderHotelOtherStatus(info[0],Integer.valueOf(info[1]));
			}
		}
		return 1;
	}
	public int checkOrderRoad(List list) throws Exception {
		// TODO Auto-generated method stub
		try{
			if(!session.isOpen()){
				session= HibernateUtil.getSession();
			}
			tx=session.beginTransaction();//开启事务
			IorderDetailService iorderDetailService = new OrderDetailServiceImpl();
			if(list!=null&&list.size()>0){
				for(int i =0;i<list.size();i++){
					String[] info = String.valueOf(list.get(i)).split("vv");
					int result = iorderDetailService.updateOrderRoadStatus(info[0],Integer.valueOf(info[1]),session);
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
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	public int checkOrderWorkShop(List list) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			tx=session.beginTransaction();//开启事务
			IorderDetailService iorderDetailService = new OrderDetailServiceImpl();
			if(list!=null&&list.size()>0){
				for(int i =0;i<list.size();i++){
					String[] info = String.valueOf(list.get(i)).split("vv");
					int result = iorderDetailService.updateOrderWorkShopStatus(info[0],Integer.valueOf(info[1]),session);
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
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	public ArrayList<OrderHotelOther> getOrderHotelOther(String orderIDS)throws Exception{
		// TODO Auto-generated method stub\	 
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql="from OrderHotelOther as orderHotelOther where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderHotelOther.orderID_s='"+orderIDS+"'";		    
			}
			Query query=session.createQuery(hql+condition);
		    List list = query.list();
		    return (ArrayList<OrderHotelOther>) list;
		}catch (Exception e){
			
			throw new Exception(e);
		}finally{
			session.clear();
		}
    	
	}
	public ArrayList<OrderOther> getOrderOther(String orderIDS) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql="from OrderOther as orderOther where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderOther.orderID_s='"+orderIDS+"'";		    
			}
			Query query=session.createQuery(hql+condition);
		    List list = query.list();	    		
	    	return (ArrayList<OrderOther>) list;
		}catch (Exception e){
		
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	public ArrayList<OrderRoadDetail> getOrderRoad(String orderIDS) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql="from OrderRoadDetail as orderRoadDetail where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderRoadDetail.orderID_s='"+orderIDS+"'";		    
			}
			Query query=session.createQuery(hql+condition+" order by orderRoadDetail.carCPG_s");
		    List list = query.list();
		    if(list!=null&&list.size()>0){
		    	for(int i=0;i<list.size();i++){
		    		OrderRoadDetail orderRoadDetail = (OrderRoadDetail)list.get(i);
		    		//得到道路id
		    		String roadID_s = orderRoadDetail.getRoadID_s();
		    		RoadInfo roadInfo = new RoadInfo();
		    		roadInfo.setRoadID_s(roadID_s);
		    		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		    		List<RoadInfo> listRoadInfo = iroadInfoService.getRoadInfo(roadInfo);
		    		if(listRoadInfo!=null&&listRoadInfo.size()>0){
		    			int maxCapacity_i = listRoadInfo.get(0).getMaxCapacity_i();
		    			//道路最大容量
		    			orderRoadDetail.setMaxCapacity_i(maxCapacity_i);	    			
		    		}
		    	}
		    }
		    return (ArrayList<OrderRoadDetail>) list;
		}catch (Exception e){
			
			throw new Exception(e);
		}finally{
			session.clear();
		}    	
	}
	
	public ArrayList<OrderRoadDetail> getOrderRoadByModel(OrderRoadDetail orderRoadDetail) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<OrderRoadDetail> list = null;
			if(orderRoadDetail==null){
				Query query=session.createQuery("from orderRoadDetail");
			    list = query.list();	  			
				return (ArrayList) list;
			}
			setOrderRoadDetailpro(orderRoadDetail);
			
			String hql="from OrderRoadDetail as orderRoadDetail where 1=1 "; 
			String condition = "";
			if(type_s!=null&&!type_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.type_s like '%"+type_s+"%'";		    
			}
			if(roadID_s!=null&&!roadID_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.roadID_s like '%"+roadID_s+"%'";		    
			}
			if(roadName_s!=null&&!roadName_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.roadName_s like '%"+roadName_s+"%'";		    
			}
			if(hoursNumber_s!=null&&!hoursNumber_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.hoursNumber_s like '%"+hoursNumber_s+"%'";		    
			}
			if(orderRoadID_s!=null&&!orderRoadID_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.orderRoadID_s like '%"+orderRoadID_s+"%'";		    
			}
			if(maxSpeed_s!=null&&!maxSpeed_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.maxSpeed_s like '%"+maxSpeed_s+"%'";		    
			}
			if(description_s!=null&&!description_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.description_s like '%"+description_s+"%'";		    
			}
			if(carCPG_s!=null&&!carCPG_s.trim().equals("")){
		    	condition = condition+" and orderRoadDetail.carCPG_s like '%"+carCPG_s+"%'";		    
			}
			Query query=session.createQuery(hql+condition);
		    list = query.list();
		    if(list!=null&&list.size()>0){
		    	for(int i=0;i<list.size();i++){
		    		orderRoadDetail = (OrderRoadDetail)list.get(i);
		    		//得到道路id
		    		String roadID_s = orderRoadDetail.getRoadID_s();
		    		RoadInfo roadInfo = new RoadInfo();
		    		roadInfo.setRoadID_s(roadID_s);
		    		IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
		    		List<RoadInfo> listRoadInfo = iroadInfoService.getRoadInfo(roadInfo);
		    		if(listRoadInfo!=null&&listRoadInfo.size()>0){
		    			int maxCapacity_i = listRoadInfo.get(0).getMaxCapacity_i();
		    			//道路最大容量
		    			orderRoadDetail.setMaxCapacity_i(maxCapacity_i);	    			
		    		}
		    	}
		    }
		    return (ArrayList<OrderRoadDetail>) list;
		}catch (Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}    	
	}
	/**
	 * 对试验路面属性进行赋值	   
	 * setOrderRoadDetailpro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setOrderRoadDetailpro(OrderRoadDetail orderRoadDetailModel){
		type_s = orderRoadDetailModel.getType_s();
		roadID_s = orderRoadDetailModel.getRoadID_s();
		roadName_s = orderRoadDetailModel.getRoadName_s();
		hoursNumber_s = orderRoadDetailModel.getHoursNumber_s();
		orderRoadID_s = orderRoadDetailModel.getOrderRoadID_s();
		maxSpeed_s = orderRoadDetailModel.getMaxSpeed_s();
		description_s = orderRoadDetailModel.getDescription_s();
		carCPG_s = orderRoadDetailModel.getCarCPG_s();
	}
	public ArrayList<OrderWorkShop> getOrderWorkShop(String orderIDS)throws Exception{
		// TODO Auto-generated method stub	
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql="from OrderWorkShop as orderWorkShop where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderWorkShop.orderID_s='"+orderIDS+"'";		    
			}
			Query query=session.createQuery(hql+condition);
		    List<OrderWorkShop> list = query.list();	    		
	    	return (ArrayList<OrderWorkShop>) list;		
		}catch (Exception e){		
			throw new Exception(e);
		}finally{
			session.clear();
		}    
	}
	public ArrayList<OrderWorkShop> getOrderWorkShop(String orderIDS,int start,
			int pageSize)throws Exception{
		// TODO Auto-generated method stub	
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			if(orderIDS==null||"".equals(orderIDS)){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from orderWorkShop");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(pageSize);
				}
				List<OrderWorkShop> list = query.list();	  			
				return (ArrayList) list;
			}		
			String hql="from OrderWorkShop as orderWorkShop where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderWorkShop.orderID_s like '%"+orderIDS+"%'";		    
			}
			Query query=session.createQuery(hql+condition);
			if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(pageSize);
			}
		    List<OrderWorkShop> list = query.list();	    		
	    	return (ArrayList<OrderWorkShop>) list;		
		}catch (Exception e){		
			throw new Exception(e);
		}finally{
			session.clear();
		}    
	}
	/**
	 * 实现 查询 订单数目
	 */
	public long getOrderWorkShopNumber(String orderIDS)  throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			if(orderIDS==null||"".equals(orderIDS)){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("select count(*) from OrderWorkShopDay");			
			    long n=0;
			    if(query.iterate().hasNext())
			    	n=(Long) query.iterate().next();
				return n;
			}	
			String hql="select count(*) from OrderWorkShop as orderWorkShop where 1=1 "; 
			String condition = "";
			if(orderIDS!=null){
		    	condition = condition+" and orderWorkShop.orderID_s like '%"+orderIDS+"%'";		    
			}
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext())
		    	n=(Long) query.iterate().next();
			return n;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	public int updateOrderDetailEmployeeID(String orderID_s, String employeeID_s) throws Exception {
		 
		Session	session= HibernateUtil.getSession();
		
		try{
			tx=session.beginTransaction();//开启事务
			OrderDetail orderDetail = new OrderDetail();
			if(orderID_s!=null){
				orderDetail =(OrderDetail)session.get(OrderDetail.class, orderID_s);		
				if(orderDetail!=null){
					Employee employee =(Employee)session.get(Employee.class, employeeID_s);	
					orderDetail.setEmployee(employee);
					session.saveOrUpdate(orderDetail);
				}
			}
			session.flush();
			tx.commit();
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	 
	
	public ArrayList<OrderDetail> getOrder(OrderDetail orderDetail, int start,
			int pageSize) throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		List<OrderDetail> list = null;
		try{
			if(orderDetail==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from OrderDetail");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(pageSize);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}			
			customerUserID_s = orderDetail.getCustomerUserID_s();
			status_i = orderDetail.getStatus_i();		
			orderID_s = orderDetail.getOrderID_s();
			reservationDate_t = orderDetail.getReservationDate_t();
			startDate_t = orderDetail.getStartDate_t();
			endDate_t = orderDetail.getEndDate_t();
			employeeID_s = orderDetail.getEmployeeID_s();
		 
			invoiceUser_s = orderDetail.getInvoiceUser_s();
			receiveInvoiceAddress_s = orderDetail.getReceiveInvoiceAddress_s();
			invoiceUserPhone_s = orderDetail.getInvoiceUserPhone_s();		
			orderName_s = orderDetail.getOrderName_s();		 
	
			String hql="from OrderDetail as orderDetail where 1=1 "; 
		    String condition = "";
		    //System.out.println("查询订单状态"+status_i);
		    if(status_i!=null){
		    	//System.out.println("查询订单状态"+status_i);
		    	//为了能够查询多种状态的订单，改造状态，如果状态小于10，则查询一种状态的 订单,
		    	//否则，查询多种状态， 组合规则为  将状态数 组成  多位数， 如查询状态为5和6的订单，则实体中传入的status_s将会是56,by freshen
		    	if(status_i<10){
		    		condition += " and orderDetail.status_i="+status_i+"";
		    	}else{
		    		condition += " and orderDetail.status_i in (";
		    		//拆分多种状态
		    		String ss=status_i.toString();
		    		int n;
		    		for(int i=0;i<ss.length();i++){
		    			n=Integer.parseInt( ss.substring(i, i+1) );
		    			condition=condition+n+",";
		    		}
		    		condition=condition.substring(0, condition.length()-1)+" )";
		    		//System.out.println("查询状态为 "+condition+"的订单");
		    	}
		    }
		    if(orderID_s!=null){
		    	condition+=" and orderDetail.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(orderName_s!=null){
		    	condition = condition+" and orderDetail.orderName_s like '%"+orderName_s+"%'";
		    }
		    
		    if(customerUserID_s!=null){
		    	condition = condition+" and orderDetail.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		          
		    if(employeeID_s!=null){
		    	//以没有设定客户助理查询
		    	if("null".equals(employeeID_s)){
		    		condition = condition+" and orderDetail.employee.employeeID_s is null";
		    	}else if("notnull".equals(employeeID_s)){
		    		condition = condition+" and orderDetail.employee.employeeID_s is not null";
		    	}else{
		    		condition = condition+" and orderDetail.employee.employeeID_s like '%"+employeeID_s+"%'";
		    	}
		    }
		     
		    if(invoiceUser_s!=null){
		    	condition = condition+" and orderDetail.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(receiveInvoiceAddress_s!=null){
		    	condition = condition+" and orderDetail.receiveInvoiceAddress_s like '%"+receiveInvoiceAddress_s+"%'";
		    }
		    if(invoiceUserPhone_s!=null){
		    	condition = condition+" and orderDetail.invoiceUserPhone_s like '%"+invoiceUserPhone_s+"%'";
		    } 
		    if(startDate_t!=null&&endDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate_t!=null){
		    	String endDate_s = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    condition = condition +" order by orderDetail.reservationDate_t DESC";
		     
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(pageSize);
		    }
		    list = query.list();	    
			return (ArrayList<OrderDetail>) list;
		}catch (Exception e){		
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	/**
	 * 实现 查询 订单数目
	 */
	public long getOrderInfoNumber(OrderDetail orderDetail)  throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			customerUserID_s = orderDetail.getCustomerUserID_s();
			status_i = orderDetail.getStatus_i();		
			orderID_s = orderDetail.getOrderID_s();
			reservationDate_t = orderDetail.getReservationDate_t();
			startDate_t = orderDetail.getStartDate_t();
			endDate_t = orderDetail.getEndDate_t();
			employeeID_s = orderDetail.getEmployeeID_s();
			 
			invoiceUser_s = orderDetail.getInvoiceUser_s();
			receiveInvoiceAddress_s = orderDetail.getReceiveInvoiceAddress_s();
			invoiceUserPhone_s = orderDetail.getInvoiceUserPhone_s();		
			orderName_s = orderDetail.getOrderName_s();
			
			String hql="select count(*) from OrderDetail as orderDetail where 1=1 "; 
		    String condition = "";
//		    if(orderName_s!=null && orderName_s.trim().length()>1){
//		    	condition += " and orderDetail.orderIDName_s like '%"+orderName_s+"%'";
//		    }
		    if(status_i!=null){
		    	//System.out.println("查询订单状态"+status_i);
		    	//为了能够查询多种状态的订单，改造状态，如果状态小于10，则查询一种状态的 订单,
		    	//否则，查询多种状态， 组合规则为  将状态数 组成  多位数， 如查询状态为5和6的订单，则实体中传入的status_s将会是56,by freshen
		    	if(status_i<10){
		    		condition += " and orderDetail.status_i='"+status_i+"'";
		    	}else{
		    		condition += " and orderDetail.status_i in (";
		    		//拆分多种状态
		    		String ss=status_i.toString();
		    		int n;
		    		for(int i=0;i<ss.length();i++){
		    			n=Integer.parseInt( ss.substring(i, i+1) );
		    			condition=condition+n+",";
		    		}
		    		condition=condition.substring(0, condition.length()-1)+" )";
		    		//System.out.println("查询状态为 "+condition+"的订单");
		    	}
		    }
			if(orderID_s!=null && !orderID_s.trim().equals("")){
				condition += " and orderDetail.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(orderName_s!=null && !orderName_s.trim().equals("")){
		    	condition += " and orderDetail.orderName_s like '%"+orderName_s+"%'";
		    }
		   
		    if(customerUserID_s!=null && !customerUserID_s.trim().equals("")){
		    	condition = condition+" and orderDetail.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		          
		    if(employeeID_s!=null){
		    	//以没有设定客户助理查询
		    	if("null".equals(employeeID_s)){
		    		condition = condition+" and orderDetail.employee.employeeID_s is null";
		    	}else if("notnull".equals(employeeID_s)){
		    		condition = condition+" and orderDetail.employee.employeeID_s is not null";
		    	}else{
		    		condition = condition+" and orderDetail.employee.employeeID_s like '%"+employeeID_s+"%'";
		    	}
		    }
		     
		    if(invoiceUser_s!=null){
		    	condition = condition+" and orderDetail.invoiceUser_s like '%"+invoiceUser_s+"%'";
		    }
		    if(receiveInvoiceAddress_s!=null){
		    	condition = condition+" and orderDetail.receiveInvoiceAddress_s like '%"+receiveInvoiceAddress_s+"%'";
		    }
		    if(invoiceUserPhone_s!=null){
		    	condition = condition+" and orderDetail.invoiceUserPhone_s like '%"+invoiceUserPhone_s+"%'";
		    } 
		    if(startDate_t!=null&&endDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endDate_t!=null){
		    	String endDate_s = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(orderDetail.startDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext())
		    	n=(Long) query.iterate().next();
			return n;
		}catch (Exception e){
		//	tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	public ArrayList<OrderOther> getOrderOtherbyModel(OrderOther orderOther,
			int start, int size) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		List<OrderOther> list=new ArrayList<OrderOther>();
		try{
			orderID_s = orderOther.getOrderID_s();
			vehicleCPG_s = orderOther.getVehicleCPG_s();
			isConfidentiality_i = orderOther.getIsConfidentiality_i();
			isHighRiskTest_i = orderOther.getIsHighRiskTest_i();
			highRiskTestDescription_s = orderOther.getHighRiskTestDescription_s();
			isCamera_i = orderOther.getIsCamera_i();
			/*if(orderID_s!=null&&vehicleCPG_s!=null){
				orderOther = (OrderOther)session.get(orderOther.getClass(), orderOther);
				orderOther.setVehicleInfo();
				list.add(orderOther);
				return (ArrayList<OrderOther>)list;
			}
			*/
			String hql=" from OrderOther as orderOther where 1=1 "; 
		    String condition = "";
		    if(orderID_s!=null){
		    	condition = condition+" and orderOther.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(vehicleCPG_s!=null){
		    	condition = condition+" and orderOther.vehicleCPG_s like '%"+vehicleCPG_s+"%'";
		    }
		    if(isConfidentiality_i!=null){
		    	condition = condition+" and orderOther.isConfidentiality_i='"+isConfidentiality_i+"'";
		    }
		    if(isHighRiskTest_i!=null){
		    	condition = condition+" and orderOther.isHighRiskTest_i='"+isHighRiskTest_i+"'";
		    }
		    if(highRiskTestDescription_s!=null){
		    	condition = condition+" and orderOther.highRiskTestDescription_s like '%"+highRiskTestDescription_s+"%'";
		    }
		    if(isCamera_i!=null){
		    	condition = condition+" and orderOther.isCamera_i='"+isCamera_i+"'";
		    }
		    
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();
		    if(list!=null&&list.size()>0){
		    	for(int i=0;i<list.size();i++){
			    	OrderOther tmp = (OrderOther)list.get(i);
			    	tmp.setVehicleInfo();
			    	list.set(i, tmp);
		    	}
		    }
		    return (ArrayList<OrderOther>) list;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}
	public long getOrderOtherbyModelNumber(
			OrderOther orderOther) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		List<OrderOther> list = null;
		try{
			orderID_s = orderOther.getOrderID_s();
			vehicleCPG_s = orderOther.getVehicleCPG_s();
			isConfidentiality_i = orderOther.getIsConfidentiality_i();
			isHighRiskTest_i = orderOther.getIsHighRiskTest_i();
			highRiskTestDescription_s = orderOther.getHighRiskTestDescription_s();
			isCamera_i = orderOther.getIsCamera_i();
			if(orderID_s!=null&&vehicleCPG_s!=null){
				orderOther = (OrderOther)session.get(orderOther.getClass(), orderOther);
				return (orderOther == null)?0:1;
			}
			String hql=" select count(*) from OrderOther as orderOther where 1=1 "; 
		    String condition = "";
		    if(orderID_s!=null){
		    	condition = condition+" and orderOther.orderID_s like '%"+orderID_s+"%'";
		    }
		    if(vehicleCPG_s!=null){
		    	condition = condition+" and orderOther.vehicleCPG_s like '%"+vehicleCPG_s+"%'";
		    }
		    if(isConfidentiality_i!=null){
		    	condition = condition+" and orderOther.isConfidentiality_i='"+isConfidentiality_i+"'";
		    }
		    if(isHighRiskTest_i!=null){
		    	condition = condition+" and orderOther.isHighRiskTest_i='"+isHighRiskTest_i+"'";
		    }
		    if(highRiskTestDescription_s!=null){
		    	condition = condition+" and orderOther.highRiskTestDescription_s like '%"+highRiskTestDescription_s+"%'";
		    }
		    if(isCamera_i!=null){
		    	condition = condition+" and orderOther.isCamera_i='"+isCamera_i+"'";
		    }
		    
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }    
		    return n;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}
	public int OperationOrderHotelOther(List<OrderHotelOther> orderHotelOther,
			int operation) throws Exception {
		String orderID_s;
		Integer status_i;
		Date startDate_t;
		Date endDate_t;
		String type_s;
		String remark_s;
		Date createDate_t;
		String createUser_s;
		String lastUpdateUser_s;
		Date lastUpdateDate_t;
		String resaveds1;
		String resaveds2;
		String resaveds3;
		String resaveds4;
		String resaveds5;
		Integer isRentalCar_i;
		Integer isRentalDriver_i;
		String otherService_s;
		
		Integer standardRoomNumber_i;	//标准房预订房数
		Integer doubleRoomNumber_i;		//大床房预订房数
		Integer deluxeRoomNUmber_i;		//豪华套间预订房数
		tx = null;
		if(!session.isOpen()){
			session= HibernateUtil.getSession();							
		}
		tx=session.beginTransaction();//开启事务
		try {
			if(orderHotelOther != null && orderHotelOther.size()>0)
			{
				
				if(operation==1){
					IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
					OrderHotelOther orderhotel=null;
					for(int i=0;i<orderHotelOther.size();i++){
						orderhotel= orderHotelOther.get(i);
						if(orderhotel.getOrderID_s() == null || orderhotel.getOrderID_s().trim().length()<1){
							return 0;
							//session.merge(wholeToad);
						}
						else
						{
							OrderHotelOther tmp = (OrderHotelOther)session.get(OrderHotelOther.class, orderhotel.getOrderID_s());
							
							orderID_s = orderhotel.getOrderID_s();
							status_i = orderhotel.getStatus_i();
							startDate_t = orderhotel.getStartDate_t();
							endDate_t = orderhotel.getEndDate_t();
							type_s = orderhotel.getType_s();
							remark_s = orderhotel.getRemark_s();
							createDate_t = orderhotel.getCreateDate_t();
							createUser_s = orderhotel.getCreateUser_s();
							lastUpdateUser_s = orderhotel.getLastUpdateUser_s();
							lastUpdateDate_t = orderhotel.getLastUpdateDate_t();
							resaveds1 = orderhotel.getResaveds1();
							resaveds2 = orderhotel.getResaveds2();
							resaveds3 = orderhotel.getResaveds3();
							resaveds4 = orderhotel.getResaveds4();
							resaveds5 = orderhotel.getResaveds5();
	
							if(orderID_s == null){
								orderhotel.setOrderID_s(tmp.getOrderID_s());
							}
							if(status_i == null){
								orderhotel.setStatus_i(tmp.getStatus_i());
							}
							if(startDate_t == null){
								orderhotel.setStartDate_t(tmp.getStartDate_t());
							}
							if(endDate_t == null){
								orderhotel.setEndDate_t(tmp.getEndDate_t());
							}
							if(type_s == null){
								orderhotel.setType_s(tmp.getType_s());
							}
							if(remark_s == null){
								orderhotel.setRemark_s(tmp.getRemark_s());
							}
							if(createDate_t == null){
								orderhotel.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								orderhotel.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateDate_t == null){
								orderhotel.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(lastUpdateUser_s == null){
								orderhotel.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(resaveds1 == null){
								orderhotel.setResaveds1(tmp.getResaveds1());
							}
							if(resaveds2 == null){
								orderhotel.setResaveds2(tmp.getResaveds2());
							}
							if(resaveds3 == null){
								orderhotel.setResaveds3(tmp.getResaveds3());
							}
							if(resaveds4 == null){
								orderhotel.setResaveds4(tmp.getResaveds4());
							}
							if(resaveds5 ==null){
								orderhotel.setResaveds5(tmp.getResaveds5());
							}
							isRentalCar_i = orderhotel.getIsRentalCar_i();
							if(isRentalCar_i == null){
								orderhotel.setIsRentalCar_i(tmp.getIsRentalCar_i());
							}
							isRentalDriver_i = orderhotel.getIsRentalDriver_i();
							if(isRentalDriver_i == null){
								orderhotel.setIsRentalDriver_i(tmp.getIsRentalDriver_i());
							}
							otherService_s = orderhotel.getOtherService_s();
							if(otherService_s == null){
								orderhotel.setOtherService_s(tmp.getOtherService_s());
							}
							standardRoomNumber_i = orderhotel.getStandardRoomNumber_i();	
							if(standardRoomNumber_i == null){
								orderhotel.setStandardRoomNumber_i(tmp.getStandardRoomNumber_i());
							}
							doubleRoomNumber_i = orderhotel.getDoubleRoomNumber_i();		
							if(doubleRoomNumber_i == null){
								orderhotel.setDoubleRoomNumber_i(tmp.getDoubleRoomNumber_i());
							}
							deluxeRoomNUmber_i = orderhotel.getDeluxeRoomNUmber_i();
							if(deluxeRoomNUmber_i == null){
								orderhotel.setDeluxeRoomNUmber_i(tmp.getDeluxeRoomNUmber_i());
							}
							session.merge(orderhotel);
						}
					}
					session.flush();
				    session.clear();
				
				}
				if(operation==2){
					if(orderHotelOther!=null&&orderHotelOther.size()>0){
						for(int i=0;i<orderHotelOther.size();i++){
							session.delete(orderHotelOther.get(i));
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
	
	public static void main(String[] a){
		try {
			//new OrderInfoServiceImpl().updateOrderDetailEmployeeID("DD2014033003", "kxc");
			IorderInfoService iorderInfoService=new OrderInfoServiceImpl();
			OrderOther otherOther = new OrderOther();
			OrderRoadDetail orderRoadDetail = new OrderRoadDetail();
			orderRoadDetail.setCarCPG_s("bbb");
			iorderInfoService.updateOrderDetailEmployeeID("DD2014091002", "123");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
