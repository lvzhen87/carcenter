package com.freshen.process.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.impl.InterphoneInfoServiceImpl;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.process.TProcessInterphoneemployinfo;
import com.freshen.process.service.TProcessInterPhoneEmployinfoService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class TProcessInterphoneEmployinfoServiceImpl extends ClimsServiceBase implements TProcessInterPhoneEmployinfoService {

	Session session = HibernateUtil.getSession();
	
	private String processID;
	private String interphoneID_s;
	private Integer operation_i;
	private Date createDate_t;
	private String vehiclecardidS;
	private String usercardIDS;
	private String createuserS;
	private String lastupdateuserS;
	private Date lastupdatedateT;
	private String resaveds1S;
	private String resaveds2S;
	private String resaveds3S;
	private String resaveds4S;
	private String resaveds5S;
	
	public ArrayList<TProcessInterphoneemployinfo> getTProcessInterPhoneEmployinfo(
			TProcessInterphoneemployinfo tProcessInterphoneemployinfo,
			int start, int size) throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		
		try {
			return getTProcessInterPhoneEmployinfoBysession(tProcessInterphoneemployinfo,start,size,session);			
		} catch (Exception e) {
			throw e;
		}finally{
			session.close();
		}
	}

	public ArrayList<TProcessInterphoneemployinfo> getTProcessInterPhoneEmployinfoBysession(
			TProcessInterphoneemployinfo tProcessInterphoneemployinfo,
			int start, int size,Session session) throws Exception {
	 
		try {
			List<TProcessInterphoneemployinfo> list = new ArrayList();	
			if(tProcessInterphoneemployinfo== null){
				Query query = session.createQuery("from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo ");
				list  = query.list();
				if(start != -1){
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				return (ArrayList)list ;
			}
			String hql = "from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo where 1= 1";
				//tProcessInterphoneemployinfo.InterphoneInfo.interphoneID_s ="+;
			String condition = " ";
			
			processID=tProcessInterphoneemployinfo.getProcessID();
			interphoneID_s = tProcessInterphoneemployinfo.getInterphoneID_s();
			operation_i=tProcessInterphoneemployinfo.getOperation_i();
			createDate_t=tProcessInterphoneemployinfo.getCreateDate_t();
			vehiclecardidS = tProcessInterphoneemployinfo.getVehiclecardidS();
			usercardIDS = tProcessInterphoneemployinfo.getUsercardIDS();
			createuserS = tProcessInterphoneemployinfo.getCreateuserS();
			lastupdateuserS = tProcessInterphoneemployinfo.getLastupdateuserS();
			lastupdatedateT = tProcessInterphoneemployinfo.getLastupdatedateT();
			resaveds1S = tProcessInterphoneemployinfo.getResaveds1S();
			resaveds2S = tProcessInterphoneemployinfo.getResaveds2S();
			resaveds3S = tProcessInterphoneemployinfo.getResaveds3S();
			resaveds4S = tProcessInterphoneemployinfo.getResaveds4S();
			resaveds5S = tProcessInterphoneemployinfo.getResaveds5S();
			
			/*sharonyshi 由于实体的修改，ID字段的定义有改动，所以目前注释掉这部分2014-6-25
			 * if(id != null){
				if(id.getInterphoneID_s()!= null)
				{
					condition += " and tProcessInterphoneemployinfo.id.TBasisInterphoneinfo.interphoneID_s like '%" + id.getInterphoneID_s()
							+"%'";
				}
				if(id.getOperationI()!= null)
				{
					condition += " and tProcessInterphoneemployinfo.id.operationI  ='" + id.getOperationI()
					+"'";
				}
				if(id.getCreatedateT() != null)
				{
					condition += " and to_char(tProcessInterphoneemployinfo.id.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(id.getCreatedateT(), "yyyy-MM-dd") +"'";
					
				}
			}*/
			if(interphoneID_s !=null && !interphoneID_s.trim().equals("")){
				condition+=" and tProcessInterphoneemployinfo.interphoneID_s like '%" + interphoneID_s + "%'";
			}
			if(operation_i !=null && operation_i!=-1 && operation_i !=0){
				condition +=" and tProcessInterphoneemployinfo.operation_i like '%" + operation_i + "%'";
			}
			if(createDate_t != null){
				condition += " and tProcessInterphoneemployinfo.createDate_t like '%" + createDate_t + "%'";
			}
			if(vehiclecardidS != null&&!vehiclecardidS.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.vehiclecardidS like '%" + vehiclecardidS + "%'";
			}
			if(usercardIDS !=null &&! usercardIDS.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.usercardIDS like '%" + usercardIDS + "%'";
			}
			if(createuserS !=null &&! createuserS.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.createuserS like '%" + createuserS + "%'";
			}
			if(lastupdateuserS !=null &&! lastupdateuserS.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.lastupdateuserS like '%" + lastupdateuserS + "%'";
			}
			if(lastupdatedateT!=null){		    	
		    	condition += " and to_char(tProcessInterphoneemployinfo.lastupdatedateT,'yyyy-MM-dd')='"+DateUtil.dateToString(lastupdatedateT, "yyyy-MM-dd") +"'";
		    } 
			if(resaveds1S !=null && !resaveds1S.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.resaveds1S like '%" + resaveds1S + "%'";
			}
			if(resaveds2S !=null &&! resaveds2S.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.resaveds2S like '%" + resaveds2S + "%'";
			}
			if(resaveds3S !=null &&! resaveds3S.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.resaveds3S like '%" + resaveds3S + "%'";
			}
			if(resaveds4S !=null &&! resaveds4S.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.resaveds4S like '%" + resaveds4S + "%'";
			}
			if(resaveds5S !=null &&! resaveds5S.trim().equals("")){
				condition += " and tProcessInterphoneemployinfo.resaveds5S like '%" + resaveds5S + "%'";
			}
			condition += " order by tProcessInterphoneemployinfo.createDate_t DESC,tProcessInterphoneemployinfo.lastupdatedateT DESC";
			Query query = session.createQuery(hql+condition);
			if(start != -1){
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
			
			list  = query.list();
			return (ArrayList)list;
			
		} catch (Exception e) {
			throw e;
		}finally{
		 
		}
	}
	
	public ArrayList<TProcessInterphoneemployinfo> getTotalTProcessInterPhoneEmployinfo(
			TProcessInterphoneemployinfo tProcessInterphoneemployinfo) throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		
		try {
			List<TProcessInterphoneemployinfo> list = new ArrayList();	
			if(tProcessInterphoneemployinfo== null){
				Query query = session.createQuery("from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo ");
				return (ArrayList)list ;
			}
			String hql = "from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo where 1= 1";
				//tProcessInterphoneemployinfo.InterphoneInfo.interphoneID_s ="+;
			String condition = " ";
			
			processID=tProcessInterphoneemployinfo.getProcessID();
			interphoneID_s = tProcessInterphoneemployinfo.getInterphoneID_s();
			operation_i=tProcessInterphoneemployinfo.getOperation_i();
			createDate_t=tProcessInterphoneemployinfo.getCreateDate_t();
			vehiclecardidS = tProcessInterphoneemployinfo.getVehiclecardidS();
			usercardIDS = tProcessInterphoneemployinfo.getUsercardIDS();
			createuserS = tProcessInterphoneemployinfo.getCreateuserS();
			lastupdateuserS = tProcessInterphoneemployinfo.getLastupdateuserS();
			lastupdatedateT = tProcessInterphoneemployinfo.getLastupdatedateT();
			resaveds1S = tProcessInterphoneemployinfo.getResaveds1S();
			resaveds2S = tProcessInterphoneemployinfo.getResaveds2S();
			resaveds3S = tProcessInterphoneemployinfo.getResaveds3S();
			resaveds4S = tProcessInterphoneemployinfo.getResaveds4S();
			resaveds5S = tProcessInterphoneemployinfo.getResaveds5S();
			/*sharonyshi 由于实体的修改，ID字段的定义有改动，所以目前注释掉这部分2014-6-25
			 * if(id != null){
				if(id.getInterphoneID_s()!= null)
				{
					condition += " and tProcessInterphoneemployinfo.id.TBasisInterphoneinfo.interphoneID_s like '%" + id.getInterphoneID_s()
							+"%'";
				}
				if(id.getOperationI()!= null)
				{
					condition += " and tProcessInterphoneemployinfo.id.operationI like '%" + id.getOperationI()
					+"%'";
				}
				if(id.getCreatedateT() != null)
				{
					condition += " and to_char(tProcessInterphoneemployinfo.id.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(id.getCreatedateT(), "yyyy-MM-dd") +"'";
					
				}
			}*/
			if(interphoneID_s !=null && !interphoneID_s.trim().equals("")){
				condition+=" and tProcessInterphoneemployinfo.interphoneID_s like '%" + interphoneID_s + "%'";
			}
			if(operation_i !=null && operation_i!=-1){
				condition +=" and tProcessInterphoneemployinfo.operation_i like '%" + operation_i + "%'";
			}
			if(createDate_t != null){
				condition += " and tProcessInterphoneemployinfo.createDate_t like '%" + createDate_t + "%'";
			}
			
			Query query = session.createQuery(hql+condition);
			list  = query.list();
			return (ArrayList)list;
			
		} catch (Exception e) {
			throw e;
		}finally{
			session.clear();
		}
	}
	
	public long getTProcessInterPhoneEmployinfo(
			TProcessInterphoneemployinfo tProcessInterphoneemployinfo)
			throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			List<TProcessInterphoneemployinfo> list = new ArrayList();	
			if(tProcessInterphoneemployinfo== null){
				Query query = session.createQuery("select count(*) from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo ");
				if(query.iterate().hasNext())
				{
					n = (Long)query.iterate().next();
				}
				return n ;
			}
			String hql = "select count(*) from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo where 1= 1";
				//tProcessInterphoneemployinfo.InterphoneInfo.interphoneID_s ="+;
			String condition = " ";
			
			processID=tProcessInterphoneemployinfo.getProcessID();
			interphoneID_s = tProcessInterphoneemployinfo.getInterphoneID_s();
			operation_i=tProcessInterphoneemployinfo.getOperation_i();
			createDate_t=tProcessInterphoneemployinfo.getCreateDate_t();
			vehiclecardidS = tProcessInterphoneemployinfo.getVehiclecardidS();
			usercardIDS = tProcessInterphoneemployinfo.getUsercardIDS();
			createuserS = tProcessInterphoneemployinfo.getCreateuserS();
			lastupdateuserS = tProcessInterphoneemployinfo.getLastupdateuserS();
			lastupdatedateT = tProcessInterphoneemployinfo.getLastupdatedateT();
			resaveds1S = tProcessInterphoneemployinfo.getResaveds1S();
			resaveds2S = tProcessInterphoneemployinfo.getResaveds2S();
			resaveds3S = tProcessInterphoneemployinfo.getResaveds3S();
			resaveds4S = tProcessInterphoneemployinfo.getResaveds4S();
			resaveds5S = tProcessInterphoneemployinfo.getResaveds5S();
			/*sharonyshi 由于实体的修改，ID字段的定义有改动，所以目前注释掉这部分2014-6-25
			 * if(id != null){
				if(id.getInterphoneID_s()!= null)
				{
					condition += " and tProcessInterphoneemployinfo.id.TBasisInterphoneinfo.interphoneID_s like '%" + id.getInterphoneID_s()
							+"%'";
				}
				if(id.getOperationI()!= null)
				{
					condition += " and tProcessInterphoneemployinfo.id.operationI like '%" + id.getOperationI()
					+"%'";
				}
				if(id.getCreatedateT() != null)
				{
					condition += " and to_char(tProcessInterphoneemployinfo.id.createdateT,'yyyy-MM-dd')='"+DateUtil.dateToString(id.getCreatedateT(), "yyyy-MM-dd") +"'";
					
				}
			}*/
			if(interphoneID_s !=null && !interphoneID_s.trim().equals("")){
				condition+=" and tProcessInterphoneemployinfo.interphoneID_s like '%" + interphoneID_s + "%'";
			}
			if(operation_i !=null && operation_i!=-1 && operation_i!=0){
				condition +=" and tProcessInterphoneemployinfo.operation_i like '%" + operation_i + "%'";
			}
			if(createDate_t != null){
				condition += " and tProcessInterphoneemployinfo.createDate_t like '%" + createDate_t + "%'";
			}
			
			Query query = session.createQuery(hql+condition);
			if(query.iterate().hasNext())
			{
				n = (Long)query.iterate().next();
			}
			return n ;
			
		} catch (Exception e) {
			throw e;
		}finally{
			session.clear();
		}
	}

	public int OperationTProcessInterphoneemployinfo(
			List<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo,
			int operation) throws Exception {
			
			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}
			Transaction tx ;
			tx = session.beginTransaction();
			try {
				OperationTProcessInterphoneemployinfobysession(tProcessInterphoneemployinfo,operation,session);			    
				tx.commit();				
				return 1;
			} catch (Exception e) {
				//System.out.println(e.toString());
				tx.rollback();
			}finally{
				session.clear();
			}
		return 0;
	}

	/**
	 * 归还使用
	 * OperationTProcessInterphoneemployinfobysession 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessInterphoneemployinfobysession(
			List<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo,
			int operation,Session session) throws Exception {			 		 
			try {
				InterphoneInfo ii = new InterphoneInfo();
				TProcessInterphoneemployinfo te = new TProcessInterphoneemployinfo(); //需要保存对象
				TProcessInterphoneemployinfo tetmp = new TProcessInterphoneemployinfo(); //按主键查询出的对象
				
				if(tProcessInterphoneemployinfo==null){
					return 0;
				}
				for(int i =0;i<tProcessInterphoneemployinfo.size();i++)
				{
					if(operation==1){
						te=tProcessInterphoneemployinfo.get(i);
						tetmp.setProcessID(te.getProcessID());
						if(te.getInterphoneID_s()==null||te.getOperation_i()==null||te.getCreateDate_t()==null){
						 
							throw new Exception("对讲机id、动作、发生时间均不能为空。");
						}					 						
						
						List<TProcessInterphoneemployinfo> list = getTotalTProcessInterPhoneEmployinfo(tetmp);
						if(!BasicTools.isnotNull(list)){
							tetmp = list.get(0);
						}
						
						
						if(tetmp!=null ){
							
							interphoneID_s=tProcessInterphoneemployinfo.get(i).getInterphoneID_s();
							operation_i=tProcessInterphoneemployinfo.get(i).getOperation_i();
							createDate_t=tProcessInterphoneemployinfo.get(i).getCreateDate_t();
							vehiclecardidS = tProcessInterphoneemployinfo.get(i).getVehiclecardidS();
							usercardIDS = tProcessInterphoneemployinfo.get(i).getUsercardIDS();
							createuserS = tProcessInterphoneemployinfo.get(i).getCreateuserS();
							lastupdateuserS = tProcessInterphoneemployinfo.get(i).getLastupdateuserS();
							lastupdatedateT = tProcessInterphoneemployinfo.get(i).getLastupdatedateT();
							resaveds1S = tProcessInterphoneemployinfo.get(i).getResaveds1S();
							resaveds2S = tProcessInterphoneemployinfo.get(i).getResaveds2S();
							resaveds3S = tProcessInterphoneemployinfo.get(i).getResaveds3S();
							resaveds4S = tProcessInterphoneemployinfo.get(i).getResaveds4S();
							resaveds5S = tProcessInterphoneemployinfo.get(i).getResaveds5S();
							
						/*	sharonyshi 2014-6-25注释原因同上
						 * if(teid != null){
								teid.setTBasisInterphoneinfo(interphoneInfo);
								tetmp.setId(teid);
							}*/
							if(interphoneID_s!=null){
								tetmp.setInterphoneID_s(interphoneID_s);
							}
							if(operation_i!=null){
								tetmp.setOperation_i(operation_i);
							}
							if(createDate_t != null){
								tetmp.setCreateDate_t(createDate_t);
							}
							if(vehiclecardidS!=null ){
								tetmp.setVehiclecardidS(vehiclecardidS);
							}
							if(usercardIDS!=null ){
								tetmp.setUsercardIDS(usercardIDS);
							}
							if(createuserS!=null ){
								tetmp.setCreateuserS(createuserS);
							}
							if(lastupdateuserS!=null ){
								tetmp.setLastupdateuserS(lastupdateuserS);
							}
							if(lastupdatedateT!= null){
								tetmp.setLastupdatedateT(lastupdatedateT);
							}
							if(resaveds1S!=null ){
								tetmp.setResaveds1S(resaveds1S);
							}
							if(resaveds2S!=null){
								tetmp.setResaveds1S(resaveds2S);
							}
							if(resaveds3S!=null ){
								tetmp.setResaveds1S(resaveds3S);
							}
							if(resaveds4S!=null){
								tetmp.setResaveds1S(resaveds4S);
							}
							if(resaveds5S!=null){
								tetmp.setResaveds1S(resaveds5S);
							}
							
							session.merge(tetmp);
							session.flush();
						}
						else
						{
							//String interphoneID_s = te.getInterphoneID_s();
							//InterphoneInfo ipinfo = new InterphoneInfo();
							//ipinfo = (InterphoneInfo)session.get(InterphoneInfo.class, interphoneID_s);
							//te.setTBasisInterphoneinfo(ipinfo);
							//tetmp.setId(te);
							IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
							String proID = systemSequenceServiceImpl.getPK(ConstantUtil.ProcessBusiness, session);
							te.setProcessID(proID);
							session.merge(te);
							return 0;
						}
						
					}
					if(operation ==2){
						te=tProcessInterphoneemployinfo.get(i);
						//teid = te.getId();
						if(te.getInterphoneID_s()==null||te.getOperation_i()==null||te.getCreateDate_t()==null){
							throw new Exception("对讲机id、动作、发生时间均不能为空。");
						}
						List<TProcessInterphoneemployinfo> list = getTotalTProcessInterPhoneEmployinfo(te);
						if(list!=null&&list.size()>0){
							tetmp = list.get(0);
						}
						if (tetmp != null){
							session.delete(tetmp);
						}
						session.flush();
					}
				}			 			
				return 1;
			} catch (Exception e) {
				//System.out.println(e.toString());	
				throw e;
			}finally{			 
			}		 
	}
	
	/**
	 * 在事务中保存对讲机使用过程
	 * OperationTProcessInterphoneemployinfobyTransaction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationTProcessInterphoneemployinfobyTransaction(
			List<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo,Session session,
			int operation) throws Exception {
	
		try {
			InterphoneInfo ii = new InterphoneInfo();
			TProcessInterphoneemployinfo te = new TProcessInterphoneemployinfo(); //需要保存对象
			TProcessInterphoneemployinfo tetmp = new TProcessInterphoneemployinfo(); //按主键查询出的对象
			//TProcessInterphoneemployinfoId teid = new TProcessInterphoneemployinfoId();
			if(!BasicTools.isnotNull(tProcessInterphoneemployinfo)){
				throw new Exception("对讲机id、动作、发生时间均不能为空。");
			}
			for(int i =0;i<tProcessInterphoneemployinfo.size();i++)
			{
				if(operation==1){
					te=tProcessInterphoneemployinfo.get(i);
					//teid = te.getId();
					if(te.getInterphoneID_s()==null||te.getOperation_i()==null||te.getCreateDate_t()==null){							
						throw new Exception("对讲机id、动作、发生时间均不能为空。");
					} 
					InterphoneInfo interphoneInfo = new InterphoneInfo();
					InterphoneInfoServiceImpl  ipimpl = new InterphoneInfoServiceImpl();
					ArrayList<InterphoneInfo> interphonelist = new ArrayList();
					interphoneInfo.setInterphoneID_s(te.getInterphoneID_s());
					interphonelist = ipimpl.getBasisInterPhoneInfo(interphoneInfo, 0, 1);
					if(interphonelist== null || interphonelist.size()<1){
						throw new Exception("对讲机id、动作、发生时间均不能为空。");
					}
					interphoneInfo = interphonelist.get(0);
					
					//归还,查询该对讲机最后一次发放并且没有归还的记录
					if(te.getOperation_i().intValue()==ConstantUtil.interphoneOperation_2){
						String hql = " from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo " +
								"where " +
								" tProcessInterphoneemployinfo.interphoneID_s='"+te.getInterphoneID_s()+"' " +
							    " and tProcessInterphoneemployinfo.resaveds1S is null" +
							    " order by  tProcessInterphoneemployinfo.createDate_t desc";
						Query query = session.createQuery(hql);
						List<TProcessInterphoneemployinfo> list  = query.list();
						if(BasicTools.isnotNull(list)){//有该记录
							tetmp = list.get(0);
							tetmp.setResaveds1S(te.getUsercardIDS());//归还的人卡
							tetmp.setResaveds2S(DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));//归还的时间
							session.saveOrUpdate(tetmp);
						}else{
							IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
							String proID = systemSequenceServiceImpl.getPK(ConstantUtil.ProcessBusiness, session);
							tetmp.setProcessID(proID);
							tetmp.setInterphoneID_s(te.getInterphoneID_s());
							tetmp.setResaveds1S(te.getUsercardIDS());//归还的人卡
							tetmp.setResaveds2S(DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));//归还的时间
							session.save(tetmp);
							return 1;
						}
					}else //发放
					{
						/*String interphoneID_s = teid.getInterphoneID_s();
						InterphoneInfo ipinfo = new InterphoneInfo();
						ipinfo = (InterphoneInfo)session.get(InterphoneInfo.class, interphoneID_s);
						teid.setTBasisInterphoneinfo(ipinfo);
						tetmp.setId(teid);*/
						IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
						String proID = systemSequenceServiceImpl.getPK(ConstantUtil.ProcessBusiness, session);
						te.setProcessID(proID);
						session.save(te);
						return 1;
					}
				}					
			}
			return 1;
		} catch (Exception e) {
			throw e;
		}finally{
		}
	}
	

	public TProcessInterphoneemployinfo getTProcessInterPhoneEmployinfoByInterphone(
			InterphoneInfo info) throws Exception {
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		
		try {
			List<TProcessInterphoneemployinfo> list = new ArrayList();	
			String Interphoneid = info.getInterphoneID_s();
			if(info== null || Interphoneid== null){
				Query query = session.createQuery("from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo order by  tProcessInterphoneemployinfo.createDate_t desc");
				query.setFirstResult(0);
				query.setMaxResults(1);
				if(query.iterate().hasNext()){
					return (TProcessInterphoneemployinfo)list.get(0) ;
				}
				else
				{
					return null;
				}
			}
			String hql = "from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo where 1= 1";
				//tProcessInterphoneemployinfo.InterphoneInfo.interphoneID_s ="+;
			String condition = " ";
			
			
			if(Interphoneid!= null)
			{
				condition += " and tProcessInterphoneemployinfo.interphoneID_s like '%" + Interphoneid
						+"%'";
			}
			
			condition += " order by tProcessInterphoneemployinfo.createDate_t desc";
			Query query = session.createQuery(hql+condition);
			query.setFirstResult(0);
			query.setMaxResults(1);
			list  = query.list();
			if(query.iterate().hasNext()){
				return (TProcessInterphoneemployinfo)list.get(0) ;
			}
			else
			{
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
			session.close();
		}
	}

	public ArrayList<TProcessInterphoneemployinfo> getTProcessInterPhoneEmployinfoListByInterphone(
			ArrayList<InterphoneInfo> info) throws Exception {
		
			ArrayList<TProcessInterphoneemployinfo> list = new ArrayList();
			InterphoneInfo ii = new InterphoneInfo();
			TProcessInterphoneemployinfo titmp = new TProcessInterphoneemployinfo();
			if(info!= null && info.size()>0)
			{
				for(int i = 0;i<info.size();i++){
					ii = info.get(i);
					if(ii!= null){
						titmp =  getTProcessInterPhoneEmployinfoByInterphone(ii);
						if(titmp!= null){
							titmp.setInterphoneID_s(ii.getInterphoneID_s());
							list.add(titmp);
						}
					}
				}
			}
			return list;
				
	}

	public int OperationTProcessInterphoneemployinfoWithoutTrans(
			ArrayList<TProcessInterphoneemployinfo> tProcessInterphoneemployinfo,
			Integer operation) throws Exception {
		try {
			InterphoneInfo ii = new InterphoneInfo();
			TProcessInterphoneemployinfo te = new TProcessInterphoneemployinfo(); //需要保存对象
			TProcessInterphoneemployinfo tetmp = new TProcessInterphoneemployinfo(); //按主键查询出的对象
			
			if(tProcessInterphoneemployinfo==null){
				return 0;
			}
			for(int i =0;i<tProcessInterphoneemployinfo.size();i++)
			{
				if(operation==1){
					te=tProcessInterphoneemployinfo.get(i);
					if(te.getInterphoneID_s()==null||te.getOperation_i()==null||te.getCreateDate_t()==null){
						
						throw new Exception("对讲机id、动作、发生时间均不能为空。");
					}
					InterphoneInfo interphoneInfo = new InterphoneInfo();
					InterphoneInfoServiceImpl  ipimpl = new InterphoneInfoServiceImpl();
					ArrayList<InterphoneInfo> interphonelist = new ArrayList();
					interphoneInfo.setInterphoneID_s(te.getInterphoneID_s());
					interphonelist = ipimpl.getBasisInterPhoneInfo(interphoneInfo, 0, 1);
					if(interphonelist== null || interphonelist.size()<1){
						throw new Exception("对讲机id、动作、发生时间均不能为空。");
					}
					interphoneInfo = interphonelist.get(0);
					
					List<TProcessInterphoneemployinfo> list = getTotalTProcessInterPhoneEmployinfo(te);
					if(list!=null&&list.size()>0){
						tetmp = list.get(0);
					}
					
					
					if(tetmp!=null ){
						
						interphoneID_s=tProcessInterphoneemployinfo.get(i).getInterphoneID_s();
						operation_i=tProcessInterphoneemployinfo.get(i).getOperation_i();
						createDate_t=tProcessInterphoneemployinfo.get(i).getCreateDate_t();
						vehiclecardidS = tProcessInterphoneemployinfo.get(i).getVehiclecardidS();
						usercardIDS = tProcessInterphoneemployinfo.get(i).getUsercardIDS();
						createuserS = tProcessInterphoneemployinfo.get(i).getCreateuserS();
						lastupdateuserS = tProcessInterphoneemployinfo.get(i).getLastupdateuserS();
						lastupdatedateT = tProcessInterphoneemployinfo.get(i).getLastupdatedateT();
						resaveds1S = tProcessInterphoneemployinfo.get(i).getResaveds1S();
						resaveds2S = tProcessInterphoneemployinfo.get(i).getResaveds2S();
						resaveds3S = tProcessInterphoneemployinfo.get(i).getResaveds3S();
						resaveds4S = tProcessInterphoneemployinfo.get(i).getResaveds4S();
						resaveds5S = tProcessInterphoneemployinfo.get(i).getResaveds5S();
						processID = tProcessInterphoneemployinfo.get(i).getProcessID();
					/*	sharonyshi 2014-6-25注释原因同上
					 * if(teid != null){
							teid.setTBasisInterphoneinfo(interphoneInfo);
							tetmp.setId(teid);
						}*/
						if(interphoneID_s!=null && interphoneID_s.length()>0){
							tetmp.setInterphoneID_s(interphoneID_s);
						}
						if(operation_i!=null ){
							tetmp.setOperation_i(operation_i);
						}
						if(createDate_t != null){
							tetmp.setCreateDate_t(createDate_t);
						}
						if(vehiclecardidS!=null && vehiclecardidS.length()>0){
							tetmp.setVehiclecardidS(vehiclecardidS);
						}
						if(usercardIDS!=null && usercardIDS.length()>0){
							tetmp.setUsercardIDS(usercardIDS);
						}
						if(createuserS!=null && createuserS.length()>0){
							tetmp.setCreateuserS(createuserS);
						}
						if(lastupdateuserS!=null && lastupdateuserS.length()>0){
							tetmp.setLastupdateuserS(lastupdateuserS);
						}
						if(lastupdatedateT!= null){
							tetmp.setLastupdatedateT(lastupdatedateT);
						}
						if(resaveds1S!=null ){
							tetmp.setResaveds1S(resaveds1S);
						}
						if(resaveds2S!=null){
							tetmp.setResaveds1S(resaveds2S);
						}
						if(resaveds3S!=null ){
							tetmp.setResaveds1S(resaveds3S);
						}
						if(resaveds4S!=null){
							tetmp.setResaveds1S(resaveds4S);
						}
						if(resaveds5S!=null){
							tetmp.setResaveds1S(resaveds5S);
						}
						if(processID!=null && processID.length()>0){
							tetmp.setProcessID(processID);
						}
						sessionImpl.merge(tetmp);
						sessionImpl.flush();
					}
					else
					{
						//String interphoneID_s = te.getInterphoneID_s();
						//InterphoneInfo ipinfo = new InterphoneInfo();
						//ipinfo = (InterphoneInfo)session.get(InterphoneInfo.class, interphoneID_s);
						//te.setTBasisInterphoneinfo(ipinfo);
						//tetmp.setId(te);
						IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
						String proID = systemSequenceServiceImpl.getPK(ConstantUtil.ProcessBusiness, session);
						te.setProcessID(proID);
						sessionImpl.merge(te);
						return 0;
					}
					
				}
				if(operation ==2){
					te=tProcessInterphoneemployinfo.get(i);
					//teid = te.getId();
					if(te.getInterphoneID_s()==null||te.getOperation_i()==null||te.getCreateDate_t()==null){
						
						throw new Exception("对讲机id、动作、发生时间均不能为空。");
					}
					List<TProcessInterphoneemployinfo> list = getTotalTProcessInterPhoneEmployinfo(te);
					if(list!=null&&list.size()>0){
						tetmp = list.get(0);
					}
					if (tetmp != null){
						sessionImpl.delete(tetmp);
					}
					sessionImpl.flush();
					
				}
			}
			
			sessionImpl.clear();
			return 1;
		} catch (Exception e) {
			//System.out.println(e.toString());
		}finally{
		}
		return 0;
	}
	 

	public static void main(String[] args) throws Exception {
		TProcessInterphoneEmployinfoServiceImpl tpe = new TProcessInterphoneEmployinfoServiceImpl();
		InterphoneInfo ii = new InterphoneInfo();
		ii.setInterphoneID_s("DJJ2014051004");
		ArrayList<InterphoneInfo> info = new ArrayList();
		TProcessInterphoneemployinfo tid = new TProcessInterphoneemployinfo();
		tid.setInterphoneID_s("DJJ2014051014");
		tid.setOperation_i(2);
		tid.setUsercardIDS("kxc11");
		tid.setCreateDate_t(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-07-26 11:22:13"));
		ArrayList<TProcessInterphoneemployinfo> list = new ArrayList<TProcessInterphoneemployinfo>();
		list.add(tid);
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Transaction tx ;
		tx = session.beginTransaction();
		tpe.OperationTProcessInterphoneemployinfobyTransaction(list, session, 1);
		tx.commit();
		
	}
}
