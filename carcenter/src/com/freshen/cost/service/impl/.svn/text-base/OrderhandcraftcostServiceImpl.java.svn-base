package com.freshen.cost.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.ICustomerUserViewService;
import com.freshen.basis.service.impl.CutomerUserViewServiceimpl;
import com.freshen.clims.baseclass.BeanModel;
import com.freshen.clims.baseclass.ClimsException;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.cost.service.IOrderhandcraftcostService;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.VCustomeuser;
import com.freshen.entity.cost.TCostOrderhandcraftcost;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class OrderhandcraftcostServiceImpl extends ClimsServiceBase implements IOrderhandcraftcostService{

	Transaction tx = null;
	private String handcraftserialnumberS;
    private String orderidS;
    private Date startoccurdatetimeT;
    private Date endoccurdatetimeT;
    private Double reckoncostI;
    private Date createdateT;
    private String createuserS;
    private String remarkS;
    private String resaveds1S;
    private String resaveds2S;
    private String resaveds3S;
    private String resaveds4S;
    private String resaveds5S;
    private String vehicleCPG_s;
    
    ReceptionOrder receptionOrder ;
    VCustomeuser customerUser;      //相关客户人员
    ReceptionVehicleInfo receptionVehicleInfo;//相关车辆
    //Employee employee;//确认职员
    String employeeNameS;
    public ArrayList<TCostOrderhandcraftcost> getTCostOrderhandcraftcost(
    		TCostOrderhandcraftcost tCostOrderhandcraftcost, int start,
			int size) throws Exception {
		
    	Session session =HibernateUtil.getSession();
		
		try{
			List<TCostOrderhandcraftcost> list = new ArrayList<TCostOrderhandcraftcost>();
			if(tCostOrderhandcraftcost== null){
				Query query = session.createQuery("from TCostOrderhandcraftcost as tCostOrderhandcraftcost ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			setPro(tCostOrderhandcraftcost);
			String hql = " from TCostOrderhandcraftcost as tCostOrderhandcraftcost where 1=1 ";
			String condition="";
			if(handcraftserialnumberS != null ){
			    condition = condition + " and tCostOrderhandcraftcost.handcraftserialnumberS ='" + handcraftserialnumberS+ "'";
			}
			if(startoccurdatetimeT!=null&&endoccurdatetimeT!=null){
		    	String startDate_s = DateUtil.dateToString(startoccurdatetimeT,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endoccurdatetimeT,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(tCostOrderhandcraftcost.occurdatetimeT,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startoccurdatetimeT!=null){
		    	String startDate_s = DateUtil.dateToString(startoccurdatetimeT,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(tCostOrderhandcraftcost.occurdatetimeT,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endoccurdatetimeT!=null){
		    	String endDate_s = DateUtil.dateToString(endoccurdatetimeT,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(tCostOrderhandcraftcost.occurdatetimeT,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
			if(remarkS != null && !remarkS.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.remarkS like '%" + remarkS.trim() + "%'";
		    }
			if(reckoncostI != null && !reckoncostI.equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.reckoncostI = '" + reckoncostI + "'";
		    }
			   
		    if(createdateT != null){
		    	condition = condition+" and to_char(tCostOrderhandcraftcost.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(createdateT, "yyyy-MM-dd") +"'";
		    }
		    if(createuserS != null && !createuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.createuserS like '%" + createuserS.trim() + "%'";
		    }
		    if(resaveds1S != null && !resaveds1S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds1S like '%" + resaveds1S.trim() + "%'";
		    }
		    if(resaveds2S != null && !resaveds2S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds2S like '%" + resaveds2S.trim() + "%'";
		    }
		    if(resaveds3S != null && !resaveds3S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds3S like '%" + resaveds3S.trim() + "%'";
		    }
		    if(resaveds4S != null && !resaveds4S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds4S like '%" + resaveds4S.trim() + "%'";
		    }
		    if(resaveds5S != null && !resaveds5S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds5S like '%" + resaveds5S.trim() + "%'";
		    }
		    if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.receptionVehicleInfo.resaveds2_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
		    if(receptionOrder!=null){
			    if(receptionOrder.getOrderName_s() != null && !receptionOrder.getOrderName_s().trim().equals("")){
			    	condition = condition + " and tCostOrderhandcraftcost.receptionOrder.orderName_s like '%" + receptionOrder.getOrderName_s().trim() + "%'";
			    }
		    }
		    if(customerUser!=null){
			    if(customerUser.getCustomername()!= null && !customerUser.getCustomername().trim().equals("")){
			    	condition = condition + " and tCostOrderhandcraftcost.customerUser.customername like '%" + customerUser.getCustomername().trim() + "%'";
			    }
		    }
		    if(receptionVehicleInfo!=null){//手工cpg
			    if(receptionVehicleInfo.getResaveds2_s()!= null && !receptionVehicleInfo.getResaveds2_s().trim().equals("")){
			    	condition = condition + " and tCostOrderhandcraftcost.receptionVehicleInfo.resaveds2_s like '%" + receptionVehicleInfo.getResaveds2_s().trim() + "%'";
			    }
		    }
		    if(employeeNameS != null && !employeeNameS.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.employeeNameS like '%" + employeeNameS.trim() + "%'";
		    }
		     
		    condition = condition+" order by tCostOrderhandcraftcost.occurdatetimeT desc ";
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

    public Long getTCostOrderhandcraftcostNumber(
    		TCostOrderhandcraftcost tCostOrderhandcraftcost) throws Exception {
		 
    	Session session =HibernateUtil.getSession();
		
		long n =0;
		try{
			List<TCostOrderhandcraftcost> list = new ArrayList<TCostOrderhandcraftcost>();
			if(tCostOrderhandcraftcost== null){
				Query query = session.createQuery("select count(*) from TCostOrderhandcraftcost as tCostOrderhandcraftcost ");
				if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }
			    return n;
			}
			setPro(tCostOrderhandcraftcost);
			String hql = " select count(*) from TCostOrderhandcraftcost as tCostOrderhandcraftcost where 1=1 ";
			String condition="";
			if(handcraftserialnumberS != null ){
			    condition = condition + " and tCostOrderhandcraftcost.handcraftserialnumberS ='" + handcraftserialnumberS+ "'";
			}
			if(startoccurdatetimeT!=null&&endoccurdatetimeT!=null){
		    	String startDate_s = DateUtil.dateToString(startoccurdatetimeT,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endoccurdatetimeT,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(tCostOrderhandcraftcost.occurdatetimeT,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startoccurdatetimeT!=null){
		    	String startDate_s = DateUtil.dateToString(startoccurdatetimeT,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(tCostOrderhandcraftcost.occurdatetimeT,'yyyy-MM-dd'),'yyyy-MM-dd')>=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }
		    else if(endoccurdatetimeT!=null){
		    	String endDate_s = DateUtil.dateToString(endoccurdatetimeT,"yyyy-MM-dd");
		    	condition = condition+" and  to_date(to_char(tCostOrderhandcraftcost.occurdatetimeT,'yyyy-MM-dd'),'yyyy-MM-dd')<=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
			if(remarkS != null && !remarkS.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.remarkS like '%" + remarkS.trim() + "%'";
		    }
			if(reckoncostI != null && !reckoncostI.equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.reckoncostI = '" + reckoncostI + "'";
		    }
			   
		    if(createdateT != null){
		    	condition = condition+" and to_char(tCostOrderhandcraftcost.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(createdateT, "yyyy-MM-dd") +"'";
		    }
		    if(createuserS != null && !createuserS.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.createuserS like '%" + createuserS.trim() + "%'";
		    }
		    if(resaveds1S != null && !resaveds1S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds1S like '%" + resaveds1S.trim() + "%'";
		    }
		    if(resaveds2S != null && !resaveds2S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds2S like '%" + resaveds2S.trim() + "%'";
		    }
		    if(resaveds3S != null && !resaveds3S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds3S like '%" + resaveds3S.trim() + "%'";
		    }
		    if(resaveds4S != null && !resaveds4S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds4S like '%" + resaveds4S.trim() + "%'";
		    }
		    if(resaveds5S != null && !resaveds5S.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.resaveds5S like '%" + resaveds5S.trim() + "%'";
		    }
		    if(vehicleCPG_s != null && !vehicleCPG_s.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.receptionVehicleInfo.resaveds2_s like '%" + vehicleCPG_s.trim() + "%'";
		    }
		    if(receptionOrder!=null){
			    if(receptionOrder.getOrderName_s() != null && !receptionOrder.getOrderName_s().trim().equals("")){
			    	condition = condition + " and tCostOrderhandcraftcost.receptionOrder.orderName_s like '%" + receptionOrder.getOrderName_s().trim() + "%'";
			    }
		    }
		    if(customerUser!=null){
			    if(customerUser.getCustomername()!= null && !customerUser.getCustomername().trim().equals("")){
			    	condition = condition + " and tCostOrderhandcraftcost.customerUser.customername like '%" + customerUser.getCustomername().trim() + "%'";
			    }
		    }
		    if(receptionVehicleInfo!=null){//手工cpg
			    if(receptionVehicleInfo.getResaveds2_s()!= null && !receptionVehicleInfo.getResaveds2_s().trim().equals("")){
			    	condition = condition + " and tCostOrderhandcraftcost.receptionVehicleInfo.resaveds2_s like '%" + receptionVehicleInfo.getResaveds2_s().trim() + "%'";
			    }
		    }
		    if(employeeNameS != null && !employeeNameS.trim().equals("")){
		    	condition = condition + " and tCostOrderhandcraftcost.employeeNameS like '%" + employeeNameS.trim() + "%'";
		    }
		    
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

	private void setPro(TCostOrderhandcraftcost tCostOrderhandcraftcost){
		handcraftserialnumberS=tCostOrderhandcraftcost.getHandcraftserialnumberS();
		orderidS              =tCostOrderhandcraftcost.getOrderidS();              
		startoccurdatetimeT   =tCostOrderhandcraftcost.getStartoccurdatetimeT();
		endoccurdatetimeT     =tCostOrderhandcraftcost.getEndoccurdatetimeT();
		reckoncostI           =tCostOrderhandcraftcost.getReckoncostI();           
		createdateT           =tCostOrderhandcraftcost.getCreatedateT();             
		createuserS           =tCostOrderhandcraftcost.getCreateuserS();           
		remarkS               =tCostOrderhandcraftcost.getRemarkS();               
		resaveds1S            =tCostOrderhandcraftcost.getResaveds1S();            
		resaveds2S            =tCostOrderhandcraftcost.getResaveds2S();            
		resaveds3S            =tCostOrderhandcraftcost.getResaveds3S();            
		resaveds4S            =tCostOrderhandcraftcost.getResaveds4S();            
		resaveds5S            =tCostOrderhandcraftcost.getResaveds5S();            
		receptionOrder        =tCostOrderhandcraftcost.getReceptionOrder ();      
		customerUser  =tCostOrderhandcraftcost.getCustomerUser() ;      //相关客户人员
	    receptionVehicleInfo =tCostOrderhandcraftcost.getReceptionVehicleInfo();//相关车辆
	    employeeNameS =tCostOrderhandcraftcost.getEmployeeNameS();//确认职员
	    vehicleCPG_s = tCostOrderhandcraftcost.getVehicleCPG_s();
	}
	
	public int OperationTCostOrderhandcraftcost(
			List<TCostOrderhandcraftcost> tCostOrderhandcraftcost, int operation)
			throws Exception {
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		int r=-1;
		try{
			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				TCostOrderhandcraftcost tmp = new TCostOrderhandcraftcost();
				if(tCostOrderhandcraftcost!=null||tCostOrderhandcraftcost.size()>0){
					for(int i=0;i<tCostOrderhandcraftcost.size();i++){
						tmp = tCostOrderhandcraftcost.get(i);
						List<TCostOrderhandcraftcost> list =null;
						 
						TCostOrderhandcraftcost temp1=new TCostOrderhandcraftcost();
						if(tmp.getHandcraftserialnumberS()!=null&&!tmp.getHandcraftserialnumberS().equals("")){
							temp1.setHandcraftserialnumberS(tmp.getHandcraftserialnumberS());
							list = this.getTCostOrderhandcraftcost(temp1, ConstantUtil.pagingNot, 0);
							if(BasicTools.isnotNull(list)){
								temp1 = list.get(0);
						 
								ReceptionOrder receptionOrder = new ReceptionOrder();
								receptionOrder.setOrderID_s(tmp.getOrderidS());								
								ReceptionOrderServiceImpl impl = new ReceptionOrderServiceImpl();
								receptionOrder = impl.getReceptionOrder(receptionOrder, ConstantUtil.pagingNot, 0).get(0);
								temp1.setReceptionOrder(receptionOrder);
								 
								if(tmp.getCustomerusercardS()!=null&&!"".equals(tmp.getCustomerusercardS())){
									VCustomeuser v = new VCustomeuser();
									v.setCustomeruserid_s(tmp.getCustomerusercardS());
									tmp.setCustomerUser(v);
									ICustomerUserViewService iCustomerUserViewService = new CutomerUserViewServiceimpl();
									List l = iCustomerUserViewService.getCustomerUser(v, ConstantUtil.pagingNot, 0);
									if(!BasicTools.isnotNull(l)){
										throw new ClimsException("客户人员不存在");
									}
								}else{
									tmp.setCustomerUser(null);
								}
								if(tmp.getVehicleCPG_s()!=null&&!"".equals(tmp.getVehicleCPG_s())){
									IreceptionVehicleInfoService service = new ReceptionVehicleInfoServiceImpl();
									ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
									rVehicleInfo.setResaveds2_s(tmp.getVehicleCPG_s());
									rVehicleInfo.setOrderID_s(tmp.getOrderidS());
									ArrayList<ReceptionVehicleInfo> l = service.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0,session);
									if(BasicTools.isnotNull(l)){
										tmp.setReceptionVehicleInfo((ReceptionVehicleInfo)l.get(0));
									}else{
										throw new ClimsException("车辆CPG牌照号不存在或不是该订单车辆");
									}
								}else{
									tmp.setReceptionVehicleInfo(null);
								}
								
								if(tmp.getOccurdatetimeT()!=null){
									temp1.setOccurdatetimeT(tmp.getOccurdatetimeT());
								}
								if(tmp.getReckoncostI()!=null){
									temp1.setReckoncostI(tmp.getReckoncostI());
								}
								
								/*if(tmp.getReceptionVehicleInfo()!= null){
									temp1.setReceptionVehicleInfo(tmp.getReceptionVehicleInfo());
								}*/
								if(tmp.getEmployeeNameS() != null){
									temp1.setEmployeeNameS(tmp.getEmployeeNameS());
								}
								if(tmp.getRemarkS() != null){
									temp1.setRemarkS(tmp.getRemarkS());
								}
								if(BeanModel.isnotNull(tmp.getReceptionVehicleInfo())){
									temp1.setReceptionVehicleInfo(tmp.getReceptionVehicleInfo());
								}else{
									temp1.setReceptionVehicleInfo(null);
								}
								if(BeanModel.isnotNull(tmp.getCustomerUser())){
									temp1.setCustomerUser(tmp.getCustomerUser());
								}else{
									temp1.setCustomerUser(null);
								}
								session.saveOrUpdate(temp1);
							}else{		
								if(!BeanModel.isnotNull(temp1.getReceptionVehicleInfo())){
									tmp.setReceptionVehicleInfo(null);
								}
								if(!BeanModel.isnotNull(temp1.getCustomerUser())){
									tmp.setCustomerUser(null);
								}
								
								ReceptionOrder receptionOrder = new ReceptionOrder();
								receptionOrder.setOrderID_s(tmp.getOrderidS());
								tmp.setReceptionOrder(receptionOrder);
								
								VCustomeuser v = new VCustomeuser();
								v.setCustomeruserid_s(tmp.getCustomerusercardS());
								tmp.setCustomerUser(v);
								
								IreceptionVehicleInfoService service = new ReceptionVehicleInfoServiceImpl();
								ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
								rVehicleInfo.setResaveds2_s(tmp.getVehicleCPG_s());
								ArrayList<ReceptionVehicleInfo> l = service.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0,session);
								if(BasicTools.isnotNull(l)){
									tmp.setReceptionVehicleInfo(l.get(0));
								}
								
								String pk = systemSequenceServiceImpl.getPK(ConstantUtil.HCBusiness, session);
								tmp.setHandcraftserialnumberS(pk);
								session.saveOrUpdate(tmp);
							}
							r=1;
						}
						else{			
							
							if(!BeanModel.isnotNull(temp1.getReceptionVehicleInfo())){
								tmp.setReceptionVehicleInfo(null);
							}
							if(!BeanModel.isnotNull(temp1.getCustomerUser())){
								tmp.setCustomerUser(null);
							}
							
							ReceptionOrder receptionOrder = new ReceptionOrder();
							receptionOrder.setOrderID_s(tmp.getOrderidS());
							tmp.setReceptionOrder(receptionOrder);
							
							if(tmp.getCustomerusercardS()!=null&&!"".equals(tmp.getCustomerusercardS())){
								VCustomeuser v = new VCustomeuser();
								v.setCustomeruserid_s(tmp.getCustomerusercardS());
								tmp.setCustomerUser(v);
								ICustomerUserViewService iCustomerUserViewService = new CutomerUserViewServiceimpl();
								List l = iCustomerUserViewService.getCustomerUser(v, ConstantUtil.pagingNot, 0);
								if(!BasicTools.isnotNull(l)){
									throw new ClimsException("客户人员不存在");
								}
							}else{
								tmp.setCustomerUser(null);
							}
							if(tmp.getVehicleCPG_s()!=null&&!"".equals(tmp.getVehicleCPG_s())){
								IreceptionVehicleInfoService service = new ReceptionVehicleInfoServiceImpl();
								ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
								rVehicleInfo.setResaveds2_s(tmp.getVehicleCPG_s());
								rVehicleInfo.setOrderID_s(tmp.getOrderidS());
								List l = service.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0,session);
								if(BasicTools.isnotNull(l)){
									tmp.setReceptionVehicleInfo((ReceptionVehicleInfo)l.get(0));
								}else{
									throw new ClimsException("车辆CPG牌照号不存在");
								}
							}else{
								tmp.setReceptionVehicleInfo(null);
							}
							String pk = systemSequenceServiceImpl.getPK(ConstantUtil.HCBusiness, session);
							tmp.setHandcraftserialnumberS(pk);
							session.saveOrUpdate(tmp);
							
						}
						r=1;
					}
				}
			}
			//删除
			if(operation==2){
				if(tCostOrderhandcraftcost!=null&&tCostOrderhandcraftcost.size()>0){
					for(int i=0;i<tCostOrderhandcraftcost.size();i++){
						TCostOrderhandcraftcost tmp = this.getTCostOrderhandcraftcost(tCostOrderhandcraftcost.get(i), ConstantUtil.pagingNot, 0).get(0);
						session.delete(tmp);
						session.flush();
						session.clear();
						r=1;
					}
				}
			}
			tx.commit();
		}catch(Exception e){
			r=-1;
			tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{				
    		session.clear();	 
		}	
		return r;
	}
	
	public static void main(String[] a){
		IOrderhandcraftcostService s = new OrderhandcraftcostServiceImpl();
		TCostOrderhandcraftcost tmp = new TCostOrderhandcraftcost();
		tmp.setCreatedateT(new Date());
		ReceptionOrder receptionOrder = new ReceptionOrder();
		receptionOrder.setOrderID_s("DD2014091003");
		tmp.setReceptionOrder(receptionOrder);
		tmp.setOccurdatetimeT(new Date());
		tmp.setReckoncostI(new Double(11));
		VCustomeuser v = new VCustomeuser();
		v.setCustomeruserid_s("RY2014091003");
		tmp.setCustomerUser(v);
		/*ReceptionVehicleInfo r = new ReceptionVehicleInfo();
		r.setVehicleCPG_s("SCPG2014101031");
		tmp.setReceptionVehicleInfo(r);*/
//		tmp.setReceptionVehicleInfo(null);
		 tmp.setEmployeeNameS("aaaa");
		//tmp.setEmployee(e);
		List<TCostOrderhandcraftcost> tCostOrderhandcraftcost = new ArrayList();
		tCostOrderhandcraftcost.add(tmp);
		try {
			s.OperationTCostOrderhandcraftcost(tCostOrderhandcraftcost, 1);
			/*TCostOrderhandcraftcost t = new TCostOrderhandcraftcost();
			t.getReceptionVehicleInfo().setResaveds2_s("123");
			List<TCostOrderhandcraftcost> l = s.getTCostOrderhandcraftcost(t, ConstantUtil.pagingNot, 0);
			s.OperationTCostOrderhandcraftcost(l, 2);
			//System.out.println(l.size());*/
		 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
