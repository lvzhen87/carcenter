package com.freshen.cost.service.impl;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.barrierGate.service.impl.InorOutinfoDaoImpl;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.cost.service.ICostOrderotherchargebasisService;
import com.freshen.cost.service.ICostOrderothercostService;
import com.freshen.cost.service.IOrderWorkShopCostBasisService;
import com.freshen.cost.service.IOrdercostInfoService;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.barrierGate.InorOutinfoModel;
import com.freshen.entity.cost.OrdercostInfo;
import com.freshen.entity.cost.OrderroadcostTemp;
import com.freshen.entity.cost.TCostOrderotherchargebasis;
import com.freshen.entity.cost.TCostOrderothercost;
import com.freshen.entity.cost.TCostOrderworkshopcostbasis;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.preorder.service.impl.OrderPreRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderWorkShopServiceImpl;
import com.freshen.process.service.IstationService;
import com.freshen.process.service.impl.StationServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class OrdercostInfoServiceImpl extends ClimsServiceBase implements IOrdercostInfoService{

    Double orderPrice = Double.valueOf("0");//订单总价
    
    

	public void OrderProcessStationCostByTimeandCarID(String orderID,
			String startTime, String endTime, String carid) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();		
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		//List<InorOutinfoModel> l = new InorOutinfoDaoImpl().getInorOutinList(null);
		Transaction tx = null;
		tx=session.beginTransaction();//开启事务
		try{			
			String procedure = "{call OrderCostCompute.mappingInorOutByTimeCarID(?,?,?,?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.setString(1, startTime);
			q.setString(2, endTime);
			q.setString(3, carid);
			q.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
	}
	
    /**
	 * 计算订单进出设施费用信息 
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void OrderProcessStationCostByTime(String orderID,String startTime,String endTime)throws Exception{
		Session session = HibernateUtil.getSession();		
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		//List<InorOutinfoModel> l = new InorOutinfoDaoImpl().getInorOutinList(null);
		Transaction tx = null;
		tx=session.beginTransaction();//开启事务
		try{			
			String procedure = "{call OrderCostCompute.mappingInorOutStationByTime(?,?,?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.setString(1, startTime);
			q.setString(2, endTime);
			q.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
	}
	
	/**
	 * 获得订单车间费用信息
	 * getOrderWorkShopCost 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> getOrderWorkShopCost(String orderID)throws Exception{
		try{
			IorderWorkShopService orderWorkShopService = new OrderWorkShopServiceImpl();
			OrderWorkShop orderWorkShop = new OrderWorkShop();
			orderWorkShop.setOrderID_s(orderID);
			ArrayList<OrderWorkShop>  list= orderWorkShopService.getBasisWorkShop(orderWorkShop, ConstantUtil.pagingNot, 0);
			return this.setProByWorkShop(list, OrderWorkShop.class);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 通过车间预订表信息对订单费用信息赋值
	 * setProByWorkShop 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> setProByWorkShop(List list,Class classname)throws Exception{
		List<OrdercostInfo> ordercostInfos= new ArrayList();
		IOrderWorkShopCostBasisService service = new OrderWorkShopCostBasisServiceImpl();
		ICostOrderotherchargebasisService otherchargebasisService  = new CostOrderotherchargebasisServiceImpl();
		IorderInfoService iorderInfoService = new OrderInfoServiceImpl();
		if(BasicTools.isnotNull(list)){
			for(int i=0;i<list.size();i++){
				//当类型为车间
				if(classname.equals(OrderWorkShop.class)){
					OrdercostInfo ordercostInfo = new OrdercostInfo();
					OrderWorkShop tmp = (OrderWorkShop)list.get(i);
					ordercostInfo.setFacilityName(tmp.getWorkShopName_s());
					Date startDate_t = tmp.getStartDate_t();
					Date endDate_t = tmp.getEndDate_t();
					ordercostInfo.setNumber(DateUtil.countNatureDayNum(startDate_t, endDate_t));
					ordercostInfo.setTotalprice(tmp.getReckonCost_i());
					//ordercostInfo.setUnit("万元/天");
					ordercostInfo.setUnit("元/天");
					TCostOrderworkshopcostbasis tCostOrderworkshopcostbasis = new TCostOrderworkshopcostbasis();
					tCostOrderworkshopcostbasis.setOrderidS(tmp.getOrderID_s());
					tCostOrderworkshopcostbasis.setWorkshopidS(tmp.getWorkShopID_s());
					List<TCostOrderworkshopcostbasis> tCostOrderworkshopcostbasises = service.getTCostOrderworkshopcostbasis(tCostOrderworkshopcostbasis, ConstantUtil.pagingNot, 0);
					if(!BasicTools.isnotNull(tCostOrderworkshopcostbasises)){//order没有对应的费用基础信息
						//初始化orders单价表
						initOrderPriceBytransaction(tmp.getOrderID_s());
						tCostOrderworkshopcostbasis = service.getTCostOrderworkshopcostbasis(tCostOrderworkshopcostbasis, ConstantUtil.pagingNot, 0).get(0);						
					}else{
						tCostOrderworkshopcostbasis = tCostOrderworkshopcostbasises.get(0);
					}
					ordercostInfo.setUnitPrie_i(tCostOrderworkshopcostbasis.getUnitprieI());
					ordercostInfo.setType(ConstantUtil.COSTTYPE01);
					ordercostInfos.add(ordercostInfo);
				}
				//订单其他费用
				if(classname.equals(TCostOrderothercost.class)){
					TCostOrderothercost tmp = (TCostOrderothercost)list.get(i);
					//订单其他费用单价基础信息表
					TCostOrderotherchargebasis tCostOrderotherchargebasis = new TCostOrderotherchargebasis();
					tCostOrderotherchargebasis.setOrderidS(tmp.getOrderidS());
					tCostOrderotherchargebasis = otherchargebasisService.getTCostOrderotherchargebasis(tCostOrderotherchargebasis, ConstantUtil.pagingNot, 0).get(0);
					//电费
					OrdercostInfo ordercostInfo = new OrdercostInfo();
					ordercostInfo.setFacilityName("耗电（RMB/KW/h，估计每天）");
					ordercostInfo.setNumber(tmp.getDatenumberI());
					ordercostInfo.setTotalprice(tmp.getElectricchargeI());
					ordercostInfo.setUnitPrie_i(tCostOrderotherchargebasis.getElectricchargeI().doubleValue());
					ordercostInfo.setUnit("元/天");
					ordercostInfo.setType(ConstantUtil.COSTTYPE05);
					ordercostInfos.add(ordercostInfo);
					//电话费
					ordercostInfo = new OrdercostInfo();
					ordercostInfo.setFacilityName("电话费（预计每天）");
					ordercostInfo.setNumber(tmp.getDatenumberI());
					ordercostInfo.setTotalprice(tmp.getTelephonebillI());
					ordercostInfo.setUnitPrie_i(tCostOrderotherchargebasis.getTelephonebillI().doubleValue());
					ordercostInfo.setUnit("元/天");
					ordercostInfo.setType(ConstantUtil.COSTTYPE06);
					ordercostInfos.add(ordercostInfo);
					//洗车费
					ordercostInfo = new OrdercostInfo();
					ordercostInfo.setFacilityName("洗车费");
					if(tmp.getResaveds2_s()!=null){
						ordercostInfo.setNumber(Integer.valueOf(tmp.getResaveds2_s()));
					}					
					ordercostInfo.setTotalprice(tmp.getTelephonebillI());
					if(tCostOrderotherchargebasis.getResaveds1_s()!=null){
						ordercostInfo.setUnitPrie_i(Double.valueOf(tCostOrderotherchargebasis.getResaveds1_s()));
					}
					ordercostInfo.setUnit("元/次");
					ordercostInfo.setType(ConstantUtil.COSTTYPE09);
					ordercostInfos.add(ordercostInfo);
					//技工
					ordercostInfo = new OrdercostInfo();
					ordercostInfo.setType(ConstantUtil.COSTTYPE07);
					ordercostInfo.setFacilityName("技工（每小时，6：00-22：00 16小时）");
					//其他模块基础信息
					ArrayList<OrderHotelOther> orderHotelOthers = iorderInfoService.getOrderHotelOther(tmp.getOrderidS());
					if(BasicTools.isnotNull(orderHotelOthers)){
						ordercostInfo.setNumber(tmp.getDatenumberI()*orderHotelOthers.get(0).getIsRentalDriver_i()*16);
					}else{
						ordercostInfo.setNumber(0);
					}
					ordercostInfo.setTotalprice(tmp.getArtisanchargeI());
					ordercostInfo.setUnitPrie_i(tCostOrderotherchargebasis.getArtisanchargeI().doubleValue());
					ordercostInfo.setUnit("元/天");
					ordercostInfos.add(ordercostInfo);
					//管理费
					ordercostInfo = new OrdercostInfo();
					ordercostInfo.setFacilityName("管理费");
					ordercostInfo.setTotalprice((orderPrice*tCostOrderotherchargebasis.getAdministrativefeeI().doubleValue())/100);
					ordercostInfo.setUnitPrie_i(tCostOrderotherchargebasis.getAdministrativefeeI().doubleValue());				 
					ordercostInfo.setType(ConstantUtil.COSTTYPE08);					
					ordercostInfo.setUnit("%");
					ordercostInfos.add(ordercostInfo);
				}
			}
		}
		return ordercostInfos;
	}
	
	/**
	 * 初始化order单价信息表	   
	 * initOrderPrice 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void initOrderPrice(String orderID,Session session) throws Exception{
		try{	
			String procedure = "{call OrderCostCompute.initUnitPrice(?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			
		}
	}
	
	/**
	 * 初始化order单价信息表在事务中	   
	 * initOrderPrice 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void initOrderPriceBytransaction(String orderID){
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		Transaction tx = null;
		tx=session.beginTransaction();//开启事务
		try {
			initOrderPrice(orderID, session);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}finally{				
    		session.clear();    		 
		}
	}
	
	/**
	 * 获得订单其它费用信息
	 * getOrderWorkShopCost 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> getOrderOtherCost(String orderID)throws Exception{
		try{
			ICostOrderothercostService costOrderothercostServiceImpl = new CostOrderothercostServiceImpl();
			TCostOrderothercost tCostOrderothercost = new TCostOrderothercost();
			tCostOrderothercost.setOrderidS(orderID);
			ArrayList<TCostOrderothercost> list= costOrderothercostServiceImpl.getTCostOrderothercost(tCostOrderothercost, ConstantUtil.pagingNot, 0);
			return this.setProByWorkShop(list, TCostOrderothercost.class);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 得到订单精确预订费用信息
	 * getAllOrdercostInfo 
	 * @param   name    
	 * @param  @return    设定文件
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> getOrderPreRoadCost(String orderID)throws Exception{
		try{
			IorderPreRoadService iorderPreRoadService = new OrderPreRoadServiceImpl();			 
			return iorderPreRoadService.getPreRoadcostInfo(orderID);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 得到订单包场预订费用信息
	 * getAllOrdercostInfo 
	 * @param   name    
	 * @param  @return    设定文件
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<OrdercostInfo> getOrderWholeRoadCost(String orderID)throws Exception{
		try{
			IorderWholeRoadService iorderWholeRoadService = new OrderWholeRoadServiceImpl();			 
			return iorderWholeRoadService.getWholeRoadcostInfo(orderID);
		}catch(Exception e){
			throw e;
		}
	}
	/**
	 * 得到订单费用信息
	 * getAllOrdercostInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List[] getAllOrdercostInfo(String orderID)throws Exception{
		ComputeOrderCost(orderID);
		sumOrderCost(orderID);
		List<OrdercostInfo> workShoplist = new ArrayList();//车间及精确预订、包场费用
		List<OrdercostInfo> otherlist = new ArrayList();//其它费用
		List<OrderroadcostTemp> roadcostlist = new ArrayList();//道路使用费用
		//车间费用
		workShoplist.addAll(getOrderWorkShopCost(orderID));
		IstationService istationService = new StationServiceImpl();
		//道路使用费用
		roadcostlist.addAll(istationService.getBasisStationcostInfo(orderID));	
		//精确预订费用
		workShoplist.addAll(getOrderPreRoadCost(orderID));
		//包场预订费用
		workShoplist.addAll(getOrderWholeRoadCost(orderID));
		//订单其他费用
		otherlist.addAll(getOrderOtherCost(orderID));
		List[] list = new List[3];
		list[0] = roadcostlist;
		list[1] = workShoplist;
		list[2] = otherlist;
		return list;
	}
	
	/**
	 * 计算订单费用总和
	 * sumOrderCost 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void sumOrderCost(String orderID)throws Exception{
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;	
		try {			
			String sql = " select sum(cost_i) cost_i " +
					"from (" +
							"select sum(t.cost_i) cost_i " +
							"from t_process_station t " +
							"where " +
							"t.orderid_s='"+orderID+"' " +
							"union " +
							"select sum(t1.reckoncost_i) " +
							"from t_subscribe_orderWorkShop t1 " +
							"where t1.orderid_s='"+orderID+"' " +
							"union " +
							"select sum(t1.reckoncost_i) " +
							"from t_subscribe_orderWholeRoad t1 " +
							"where t1.orderid_s='"+orderID+"' " +
							"union " +
							"select sum(t1.reckoncost_i) " +
							"from t_subscribe_orderPreRoad t1 " +
							"where t1.orderid_s='"+orderID+"' " +
							"union " +
							"select t2.electriccharge_i+t2.telephonebill_i+t2.artisancharge_i " +
							"from  t_cost_orderOtherCost t2   " +
							"where t2.orderid_s='"+orderID+"') ";
			con = HibernateUtil.getJDBCconn();
			stat = con.createStatement();
			rs = stat.executeQuery(sql);		   
			while (rs.next()) {
				orderPrice = rs.getDouble(1);
			}		 
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	public void get(String s,Integer i,org.hibernate.impl.SessionImpl  session){
		//System.out.println(s);
		//System.out.println(i);
		//System.out.println(session);
		 
	}
	public static void main(String[] a){
		/*OrdercostInfoServiceImpl impl = new OrdercostInfoServiceImpl();
		try {
				List<OrdercostInfo> list = impl.getAllOrdercostInfo("DD2014071028");
			for(int i=0;i<list.size();i++){
				OrdercostInfo tmp = list.get(i);
				//System.out.println("名称:"+tmp.getFacilityName()+",单价:"+tmp.getUnitPrie_i()+",数量:"+tmp.getNumber()+",总价:"+tmp.getTotalprice());
			}
			//System.out.println(list.size());
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			String s = "s1";
			Integer i=2;
			
			Class demo = Class.forName("com.freshen.cost.service.impl.OrdercostInfoServiceImpl");
		//	Method method=demo.getMethod("get",s.getClass(),int.class);
			Method method=demo.getMethod("get",s.getClass(),i.getClass());
			method.invoke(demo.newInstance(),"s",1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 计算订单费用明细	   
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void ComputeOrderCost(String orderID)throws Exception{
		Session session = HibernateUtil.getSession();		
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		Transaction tx = null;
		//接收sql过站数据
		new InorOutinfoDaoImpl().getInorOutinList(null);
		try{
			tx=session.beginTransaction();//开启事务				
			String procedure = "{call OrderCostCompute.OrderCostComputePro(?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
	}
	
	/**
	 * 计算订单进出设施费用信息 
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void OrderProcessStationCost(String orderID)throws Exception{
		Session session = HibernateUtil.getSession();		
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		//List<InorOutinfoModel> l = new InorOutinfoDaoImpl().getInorOutinList(null);
		Transaction tx = null;
		tx=session.beginTransaction();//开启事务
		try{			
			String procedure = "{call OrderCostCompute.mappingInorOutStation(?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
	}
	
	/**
	 * 计算订单预付费费用   
	 * ComputeOrderCost 
	 * @param   orderID 订单名称    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void PreRoadCost(String orderID,Session session)throws Exception{		 
		try{			
			String procedure = "{call OrderCostCompute.preRoadCostCompute(?)}";
			Query q  = session.createSQLQuery(procedure);
			q.setString(0, orderID);
			q.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			 
			throw e;
		}finally{
		 
		}
	}

	
}
