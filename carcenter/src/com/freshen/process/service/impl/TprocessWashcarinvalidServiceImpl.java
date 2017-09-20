package com.freshen.process.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.process.Station;
import com.freshen.entity.process.TProcessWashcarinvalid;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.process.service.TprocessWashcarinvalidService;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class TprocessWashcarinvalidServiceImpl extends ClimsServiceBase implements TprocessWashcarinvalidService{

	private String serialnumberS;
	private String orderName;
	private Date recorddateT;
	private String vehicleidS;
	private String vehiclecpgS;
	private Date createdateT;
	private String createuserS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private String resaveds1S;
	private String resaveds2S;
	private String resaveds3S;
	private String resaveds4S;
	private String resaveds5S;
	private String manualCPG;
	Date startDate_t;//发生开始时间
	Date endDate_t;//发生结束时间
	
	Date createstartDate_t;//作废开始时间
	Date createendDate_t;//作废结束时间
	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<TProcessWashcarinvalid> getTProcessWashcarinvalidInfo(TProcessWashcarinvalid bean, int start,
			int size) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try {
			List<Station> list = new ArrayList();
			
			if(bean == null){
				Query query=session.createQuery("from TProcessWashcarinvalid as bean");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			this.setPro(bean);
			
			String hql = " from TProcessWashcarinvalid as bean where 1=1 ";
		    String condition = "";
		    
		    if(serialnumberS != null && !serialnumberS.trim().equals(""))
		    {
		    	condition += " and bean.serialnumberS like '%" + serialnumberS.trim() + "%'";
		    }
		    if(orderName != null && !orderName.trim().equals("") )
		    {
		    	condition += " and bean.receptionOrder.orderName_s = '" + orderName + "'";
		    }
		    if(startDate_t!=null&&endDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.recorddateT,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.recorddateT,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }else if(endDate_t != null){
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.recorddateT,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(createstartDate_t!=null&&createendDate_t!=null){
		    	String createstartDate_s = DateUtil.dateToString(createstartDate_t,"yyyy-MM-dd");
		    	String createendDate_s   = DateUtil.dateToString(createendDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.createDate_t,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+createstartDate_s+"','yyyy-MM-dd') and to_date('"+createendDate_s+"','yyyy-MM-dd')";
		    }else if(createstartDate_t!=null){
		    	String createstartDate_s = DateUtil.dateToString(createstartDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.createDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+createstartDate_s+"','yyyy-MM-dd')";
		    }else if(createendDate_t != null){
		    	String createendDate_s   = DateUtil.dateToString(createendDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.createDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+createendDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(manualCPG != null && !manualCPG.trim().equals(""))
		    {
		    	condition += " and bean.receptionVehicleInfo.resaveds2_s = '" + manualCPG + "'";
		    }
		    if(lastupdatedateT != null )
		    {
		     	condition = condition + " and to_char(bean.lastupdatedateT,'yyyy-MM-dd')='" + DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    } 					    
		    if(createuserS != null && !createuserS.trim().equals("") )
		    {
		    	condition += " and bean.createuserS like '%" + createuserS.trim() + "%'";
		    }
		    if(lastupdateuserS != null && !lastupdateuserS.trim().equals("") )
		    {
		    	condition += " and bean.lastupdateuserS like '%" + lastupdateuserS.trim() + "%'";
		    }		      
		    if(resaveds1S != null && !resaveds1S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds1S like '%" + resaveds1S.trim() + "%'";
		    }
		    if(resaveds2S != null && "null".equals(resaveds2S.trim())){
		    	condition += " and bean.resaveds2S is null";
			}else 
		    if(resaveds2S != null && !resaveds2S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds2S = '" + resaveds2S.trim() + "'";
		    }
		    if(resaveds3S != null && !resaveds3S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds3S like '%" + resaveds3S.trim() + "%'";
		    }
		    if(resaveds4S != null && !resaveds4S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds4S like '%" + resaveds4S.trim() + "%'";
		    }
		    if(resaveds5S != null && !resaveds5S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds5S like '%" + resaveds5S.trim() + "%'";
		    }
			condition +=" order by bean.recorddateT desc";
		    
		    Query query=session.createQuery(hql+condition);
			if(start!=ConstantUtil.pagingNot){
				query.setFirstResult(start);
			    query.setMaxResults(size);
			}
		    list = query.list();
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}

	public long getTProcessWashcarinvalidInfoNum(TProcessWashcarinvalid bean) throws Exception {
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<Station> list = new ArrayList();

			if(bean == null){
				Query query=session.createQuery("select count(*) from TProcessWashcarinvalid as bean");
				if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			this.setPro(bean);
			
			String hql = "select count(*) from TProcessWashcarinvalid as bean where 1=1 ";
		    String condition = "";
		    
		    if(serialnumberS != null && !serialnumberS.trim().equals(""))
		    {
		    	condition += " and bean.serialnumberS like '%" + serialnumberS.trim() + "%'";
		    }
		    if(orderName != null && !orderName.trim().equals("") )
		    {
		    	condition += " and bean.receptionOrder.orderName_s = '" + orderName + "'";
		    }
		    if(startDate_t!=null&&endDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition += condition+" and  to_date(to_char(bean.recorddateT,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+startDate_s+"','yyyy-MM-dd') and to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }else if(startDate_t!=null){
		    	String startDate_s = DateUtil.dateToString(startDate_t,"yyyy-MM-dd");
		    	condition += condition+" and  to_date(to_char(bean.recorddateT,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+startDate_s+"','yyyy-MM-dd')";
		    }else if(endDate_t != null){
		    	String endDate_s   = DateUtil.dateToString(endDate_t,"yyyy-MM-dd");
		    	condition += condition+" and  to_date(to_char(bean.recorddateT,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+endDate_s+"','yyyy-MM-dd')";
		    }
		    
		    if(createstartDate_t!=null&&createendDate_t!=null){
		    	String createstartDate_s = DateUtil.dateToString(createstartDate_t,"yyyy-MM-dd");
		    	String createendDate_s   = DateUtil.dateToString(createendDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.createDate_t,'yyyy-MM-dd'),'yyyy-MM-dd') between to_date('"+createstartDate_s+"','yyyy-MM-dd') and to_date('"+createendDate_s+"','yyyy-MM-dd')";
		    }else if(createstartDate_t!=null){
		    	String createstartDate_s = DateUtil.dateToString(createstartDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.createDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+createstartDate_s+"','yyyy-MM-dd')";
		    }else if(createendDate_t != null){
		    	String createendDate_s   = DateUtil.dateToString(createendDate_t,"yyyy-MM-dd");
		    	condition += " and  to_date(to_char(bean.createDate_t,'yyyy-MM-dd'),'yyyy-MM-dd')=to_date('"+createendDate_s+"','yyyy-MM-dd')";
		    }
		    if(manualCPG != null && !manualCPG.trim().equals("") )
		    {
		    	condition += " and bean.receptionVehicleInfo.resaveds2_s = '" + manualCPG + "'";
		    }
		    if(lastupdatedateT != null )
		    {
		     	condition = condition + " and to_char(bean.lastupdatedateT,'yyyy-MM-dd')='" + DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    } 					    
		    if(createuserS != null && !createuserS.trim().equals("") )
		    {
		    	condition += " and bean.createuserS like '%" + createuserS.trim() + "%'";
		    }
		    if(lastupdateuserS != null && !lastupdateuserS.trim().equals("") )
		    {
		    	condition += " and bean.lastupdateuserS like '%" + lastupdateuserS.trim() + "%'";
		    }		      
		    if(resaveds1S != null && !resaveds1S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds1S like '%" + resaveds1S.trim() + "%'";
		    }
		    if(resaveds2S != null && "null".equals(resaveds2S.trim())){
		    	condition += " and bean.resaveds2S is null";
			}else 
		    if(resaveds2S != null && !resaveds2S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds2S = '" + resaveds2S.trim() + "'";
		    }
		    if(resaveds3S != null && !resaveds3S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds3S like '%" + resaveds3S.trim() + "%'";
		    }
		    if(resaveds4S != null && !resaveds4S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds4S like '%" + resaveds4S.trim() + "%'";
		    }
		    if(resaveds5S != null && !resaveds5S.trim().equals("") )
		    {
		    	condition += " and bean.resaveds5S like '%" + resaveds5S.trim() + "%'";
		    }
		    
		    Query query=session.createQuery(hql+condition);
		    
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }    
		    return n;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			
		}
	}

	/**
	 * 维护洗车作废表	   
	 * OperationCustomer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessWashcarinvalidInfo(List<TProcessWashcarinvalid> list, int operation)
	throws Exception {
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		tx=session.beginTransaction();//开启事务
		try{
			OperationTProcessWashcarinvalidInfoByTx( list,  operation, session);
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{					 
		}
	}
	/**
	 * 维护洗车作废表	   
	 * OperationCustomer 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessWashcarinvalidInfoByTx(List<TProcessWashcarinvalid> list, int operation,Session session)
	throws Exception {
	// TODO Auto-generated method stub
		try{
	 
			TProcessWashcarinvalid tmp = new TProcessWashcarinvalid();
			//新增
			if(operation==1){			
				if(list!=null||list.size()>0){
					for(int i=0;i<list.size();i++){		
						tmp = list.get(i);
						if(tmp.getOrderidS()!=null){
							ReceptionOrder r = (ReceptionOrder)session.get(ReceptionOrder.class, tmp.getOrderidS());
							tmp.setReceptionOrder(r);
						}
						if(tmp.getFacilityID_s()!=null){
							RoadInfo roadInfo = (RoadInfo)session.get(RoadInfo.class, tmp.getFacilityID_s());
							tmp.setRoadInfo(roadInfo);
						}
						if(tmp.getVehiclecpgS()!=null){
							ReceptionVehicleInfo receptionVehicleInfo = (ReceptionVehicleInfo)session.get(ReceptionVehicleInfo.class, tmp.getVehiclecpgS());
							tmp.setReceptionVehicleInfo(receptionVehicleInfo);
						}
						tmp.setResaveds1S("1");
					    session.saveOrUpdate(tmp);
						session.flush();
					}
				}
			}
			//删除
			if(operation==2){
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						tmp = list.get(i);
						tmp = (TProcessWashcarinvalid)session.get(TProcessWashcarinvalid.class, tmp.getSerialnumberS());
						tmp.setResaveds1S("0");
						session.update(tmp);
						session.flush();
					}
				}
			}
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{					 
		}
	}
	/**
	 * 对属性赋值	   
	 * setPro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	private void setPro(TProcessWashcarinvalid bean){
		serialnumberS=  bean.getSerialnumberS();
		orderName=      bean.getOrderName(); 
		recorddateT=    bean.getRecorddateT  ();  
		vehicleidS=     bean.getVehicleidS   ();  
		vehiclecpgS=    bean.getVehiclecpgS  ();  
		createdateT=    bean.getCreatedateT  ();  
		createuserS=    bean.getCreateuserS  ();
		lastupdateuserS=bean.getLastupdateuserS();
		lastupdatedateT=bean.getLastupdatedateT();
		resaveds1S=     bean.getResaveds1S();     
		resaveds2S=     bean.getResaveds2S();     
		resaveds3S=     bean.getResaveds3S();     
		resaveds4S=     bean.getResaveds4S();     
		resaveds5S=     bean.getResaveds5S();
		startDate_t = bean.getStartDate_t();
		endDate_t = bean.getEndDate_t();
		createstartDate_t= bean.getCreatestartDate_t();
		createendDate_t= bean.getCreateendDate_t();
		manualCPG = bean.getManualCPG();
	}
	
	public static void main(String arg[]){
		TprocessWashcarinvalidServiceImpl service = new TprocessWashcarinvalidServiceImpl();
		Station s = new Station ();
		s.setFacilityID_s("DL2014091003");
		try {
			TProcessWashcarinvalid b = new TProcessWashcarinvalid();
			b.setSerialnumberS("11112");
			/*b.setOrderidS("DD2014081001");
			b.setFacilityID_s("DL2014081000");
			b.setRecorddateT(new Date());
			b.setVehiclecpgS("SCPG2014101031");
			b.setCreatedateT(new Date());
			b.setCreateuserS("kk");
			List l = new ArrayList();
			l.add(b);*/
			//service.OperationTProcessWashcarinvalidInfo(l, 2);
			List l = service.getTProcessWashcarinvalidInfo(b, ConstantUtil.pagingNot, 0);
			//System.out.println(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
