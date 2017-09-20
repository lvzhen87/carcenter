package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IinterphoneInfoService;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.InterphoneInfo;
import com.freshen.entity.process.TProcessInterphoneemployinfo;
import com.freshen.entity.reception.CardInfo;

import com.freshen.process.service.TProcessInterPhoneEmployinfoService;
import com.freshen.process.service.impl.TProcessInterphoneEmployinfoServiceImpl;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class InterphoneInfoServiceImpl extends ClimsServiceBase implements IinterphoneInfoService{

	String interphoneID_s;
	String interphonePast_s, brand_s;
	//	对讲机状态（0：故障 1：使用中 2：闲置）
	Integer state_i;
	Date createDate_t = new Date();
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t = new Date();
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	//String vehicleCardid_s;//车卡id kxc 2015-5-17
	//String userCardid_s;//人卡id  kxc 2015-5-17
	/**
	 * 通过条件查询对讲机信息表
	   
	 * getBasisInterPhoneInfo 
	 * @param   name    
	 * @param  @return    List    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<InterphoneInfo> getBasisInterPhoneInfo(InterphoneInfo interPhoneInfo, int start, int size) throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			return getBasisInterPhoneInfoBysession(interPhoneInfo,start,size,session);
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}	 
	}

	/**
	 * 通过条件查询对讲机信息表
	   
	 * getBasisInterPhoneInfo 
	 * @param   name    
	 * @param  @return    List    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<InterphoneInfo> getBasisInterPhoneInfoBysession(InterphoneInfo interPhoneInfo, int start, int size,Session session) throws Exception{
			 
		try{
			List<InterphoneInfo> list = new ArrayList();
			
			if(interPhoneInfo == null){
				Query query = session.createQuery("from InterphoneInfo as interphoneInfo ");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			interphoneID_s = interPhoneInfo.getInterphoneID_s();
			interphonePast_s = interPhoneInfo.getInterphonePast_s();
			brand_s = interPhoneInfo.getBrand_s();
			state_i = interPhoneInfo.getState_i();
			createDate_t = interPhoneInfo.getCreateDate_t();
			createUser_s = interPhoneInfo.getCreateUser_s();
			lastUpdateUser_s = interPhoneInfo.getLastUpdateUser_s();
			lastUpdateDate_t = interPhoneInfo.getLastUpdateDate_t();
			resaveds1_s = interPhoneInfo.getResaveds1_s();
			resaveds2_s = interPhoneInfo.getResaveds2_s();
			resaveds3_s = interPhoneInfo.getResaveds3_s();
			resaveds4_s = interPhoneInfo.getResaveds4_s();
			resaveds5_s = interPhoneInfo.getResaveds5_s();

			if(interphoneID_s != null && !interphoneID_s.trim().equals("")){
				interPhoneInfo = (InterphoneInfo)session.get(interPhoneInfo.getClass(), interphoneID_s);
		    	list.add(interPhoneInfo);
		    	return (ArrayList) list;
		    }
			
			String hql = " from InterphoneInfo as interPhoneInfo where 1=1 ";
		    String condition = "";

		    if(interphoneID_s != null && !interphoneID_s.trim().equals("")){
				condition = " and interPhoneInfo.interphoneID_s like '%" + interphoneID_s.trim() + "%'";
		    }
		    if(interphonePast_s != null && !interphonePast_s.trim().equals("")){
		    	condition = " and interPhoneInfo.interphonePast_s like '%" + interphonePast_s.trim() + "%'";
		    }
		    if(brand_s != null && !brand_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.brand_s like '%" + brand_s.trim() + "%'";
		    }
		    if(state_i != null && state_i != -1){
		    	condition = condition + " and interPhoneInfo.state_i like '%" + state_i + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(interPhoneInfo.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(interPhoneInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and interPhoneInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    condition = condition +" order by interPhoneInfo.lastUpdateDate_t DESC";
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
		 
		}	 
	}
	
	/**
	 * 通过条件查询对讲机信息表，返回取得个数
	   
	 * getBasisInterPhoneInfoNumber 
	 * @param   name    
	 * @param  @return    Long    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public long getBasisInterPhoneInfoNumber(InterphoneInfo interPhoneInfo) throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<InterphoneInfo> list = new ArrayList();

			if(interPhoneInfo == null){
				Query query = session.createQuery("select count(*) from InterphoneInfo as interphoneInfo");
			    if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			interphoneID_s = interPhoneInfo.getInterphoneID_s();
			interphonePast_s = interPhoneInfo.getInterphonePast_s();
			brand_s = interPhoneInfo.getBrand_s();
			state_i = interPhoneInfo.getState_i();
			createDate_t = interPhoneInfo.getCreateDate_t();
			createUser_s = interPhoneInfo.getCreateUser_s();
			lastUpdateUser_s = interPhoneInfo.getLastUpdateUser_s();
			lastUpdateDate_t = interPhoneInfo.getLastUpdateDate_t();
			resaveds1_s = interPhoneInfo.getResaveds1_s();
			resaveds2_s = interPhoneInfo.getResaveds2_s();
			resaveds3_s = interPhoneInfo.getResaveds3_s();
			resaveds4_s = interPhoneInfo.getResaveds4_s();
			resaveds5_s = interPhoneInfo.getResaveds5_s();

			String hql = "select count(*) from InterphoneInfo as interphoneInfo where 1=1 "; 
		    String condition = "";
			if(interphoneID_s != null && !interphoneID_s.trim().equals("")){
				condition = " and interphoneInfo.interphoneID_s like '%" + interphoneID_s.trim() + "%'";
		    }

		    if(interphonePast_s != null && !interphonePast_s.trim().equals("")){
		    	condition = " and interphoneInfo.interphonePast_s like '%" + interphonePast_s.trim() + "%'";
		    }
		    if(brand_s != null && !brand_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.brand_s like '%" + brand_s.trim() + "%'";
		    }
		    if(state_i != null && state_i!= -1){
		    	condition = condition + " and interphoneInfo.state_i like '%" + state_i + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(interphoneInfo.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(interphoneInfo.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and interphoneInfo.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    
		    Query query = session.createQuery(hql + condition);

		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }  		  
		    return n;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}	
	}
	
	/**
	 * 保存对讲机信息
	   
	 * saveOrUpdateBasisInterPhoneInfo 
	 * @param   name    1:增加 修改 2：删除
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationInterphoneInfo(List<InterphoneInfo> interphoneInfo, int operation)
	throws Exception {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session= HibernateUtil.getSession();
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				InterphoneInfo phone =new InterphoneInfo();
				if(interphoneInfo!=null||interphoneInfo.size()>0){
					for(int i=0;i<interphoneInfo.size();i++){
						phone=interphoneInfo.get(i);
						
						//if(interphoneInfo.get(i).getInterphoneID_s() == null || interphoneInfo.get(i).getInterphoneID_s().trim().equals("") )
						InterphoneInfo phonetmp = (InterphoneInfo)session.get(phone.getClass(), interphoneInfo.get(i).getInterphoneID_s());
						if(phonetmp==null)
						{
							/*String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DJJBusiness, session);
							phone.setInterphoneID_s(cpg);*/
							phone.setCreateDate_t(new Date());
							session.merge(phone);
						}else{
							phonetmp = (InterphoneInfo)session.get(phone.getClass(), interphoneInfo.get(i).getInterphoneID_s());
							 
							interphonePast_s = phone.getInterphonePast_s();
							brand_s = phone.getBrand_s();
							state_i = phone.getState_i();
						 
							lastUpdateUser_s = phone.getLastUpdateUser_s();
							lastUpdateDate_t = phone.getLastUpdateDate_t();
							resaveds1_s = phone.getResaveds1_s();
							resaveds2_s = phone.getResaveds2_s();
							resaveds3_s = phone.getResaveds3_s();
							resaveds4_s = phone.getResaveds4_s();
							resaveds5_s = phone.getResaveds5_s();

						    if(interphonePast_s != null && !interphonePast_s.trim().equals("")){
						    	phonetmp.setInterphonePast_s(interphonePast_s);
						    }
						    if(brand_s != null && !brand_s.trim().equals("")){
						    	phonetmp.setBrand_s(brand_s);
						    }
						    if(state_i != null && state_i!= -1){
						    	phonetmp.setState_i(state_i);
						    }
						    
						    if(lastUpdateDate_t != null){
						    	phonetmp.setLastUpdateDate_t(lastUpdateDate_t);
						    }
						    
						    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
						    	phonetmp.setLastUpdateUser_s(lastUpdateUser_s);
						    }
						    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
						    	phonetmp.setResaveds1_s(resaveds1_s);
						    }
						    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
						    	phonetmp.setResaveds2_s(resaveds2_s);
						    }
						    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
						    	phonetmp.setResaveds3_s(resaveds3_s);
						    }
						    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
						    	phonetmp.setResaveds4_s(resaveds4_s);
						    }
						    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
						    	phonetmp.setResaveds5_s(resaveds5_s);
						    }
						    session.merge(phonetmp);
						}
						
						//session.saveOrUpdate(phone);
						session.flush();
 					}
				}
			}
			//删除
			if(operation==2){
				if(interphoneInfo!=null&&interphoneInfo.size()>0){
					for(int i=0;i<interphoneInfo.size();i++){
						session.delete(interphoneInfo.get(i));
						session.flush();
 					}
				}
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
	    	session.clear();		 
		}	
	}
			
	/**
	 * 保存对讲机信息
	   
	 * saveOrUpdateBasisInterPhoneInfo 
	 * @param   name    1:增加 修改 2：删除
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int OperationInterphoneInfoBysession(List<InterphoneInfo> interphoneInfo, int operation,Session session)
	throws Exception {
		// TODO Auto-generated method stub		 
		try{
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				InterphoneInfo phone =new InterphoneInfo();
				if(interphoneInfo!=null||interphoneInfo.size()>0){
					for(int i=0;i<interphoneInfo.size();i++){
						phone=interphoneInfo.get(i);
						
						//if(interphoneInfo.get(i).getInterphoneID_s() == null || interphoneInfo.get(i).getInterphoneID_s().trim().equals("") )
						InterphoneInfo phonetmp = (InterphoneInfo)session.get(phone.getClass(), interphoneInfo.get(i).getInterphoneID_s());
						if(phonetmp==null)
						{
							/*String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DJJBusiness, session);
							phone.setInterphoneID_s(cpg);*/
							phone.setCreateDate_t(new Date());
							session.merge(phone);
						}else{
							phonetmp = (InterphoneInfo)session.get(phone.getClass(), interphoneInfo.get(i).getInterphoneID_s());
							 
							interphonePast_s = phone.getInterphonePast_s();
							brand_s = phone.getBrand_s();
							state_i = phone.getState_i();
						 
							lastUpdateUser_s = phone.getLastUpdateUser_s();
							lastUpdateDate_t = phone.getLastUpdateDate_t();
							resaveds1_s = phone.getResaveds1_s();
							resaveds2_s = phone.getResaveds2_s();
							resaveds3_s = phone.getResaveds3_s();
							resaveds4_s = phone.getResaveds4_s();
							resaveds5_s = phone.getResaveds5_s();

						    if(interphonePast_s != null && !interphonePast_s.trim().equals("")){
						    	phonetmp.setInterphonePast_s(interphonePast_s);
						    }
						    if(brand_s != null && !brand_s.trim().equals("")){
						    	phonetmp.setBrand_s(brand_s);
						    }
						    if(state_i != null && state_i!= -1){
						    	phonetmp.setState_i(state_i);
						    }
						    
						    if(lastUpdateDate_t != null){
						    	phonetmp.setLastUpdateDate_t(lastUpdateDate_t);
						    }
						    
						    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
						    	phonetmp.setLastUpdateUser_s(lastUpdateUser_s);
						    }
						    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
						    	phonetmp.setResaveds1_s(resaveds1_s);
						    }
						    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
						    	phonetmp.setResaveds2_s(resaveds2_s);
						    }
						    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
						    	phonetmp.setResaveds3_s(resaveds3_s);
						    }
						    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
						    	phonetmp.setResaveds4_s(resaveds4_s);
						    }
						    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
						    	phonetmp.setResaveds5_s(resaveds5_s);
						    }
						    session.merge(phonetmp);
						}
						
						//session.saveOrUpdate(phone);
						session.flush();
					}
				}
			}
			//删除
			if(operation==2){
				if(interphoneInfo!=null&&interphoneInfo.size()>0){
					for(int i=0;i<interphoneInfo.size();i++){
						session.delete(interphoneInfo.get(i));
						session.flush();
					 
					}
				}
			}
			return 1;
		}catch(Exception e){
			throw e;
		}finally{				
		}	
	}
	
	public static void main(String arg[]){
		InterphoneInfo interphoneInfo = new InterphoneInfo();
		interphoneInfo.setResaveds1_s("3213");
		interphoneInfo.setResaveds2_s("3213");
		interphoneInfo.setResaveds3_s("3213");
		interphoneInfo.setCreateDate_t(null);
		interphoneInfo.setLastUpdateUser_s("kxc");

		interphoneInfo.setInterphoneID_s("555");
		IinterphoneInfoService iis = new InterphoneInfoServiceImpl();
		ArrayList<InterphoneInfo> list = new ArrayList();
		list.add(interphoneInfo);
		try {
			iis.OperationInterphoneInfo(list, 1);
			//iis.UpdateBasisInterPhoneStateInfo("DJJ2014051001","2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int UpdateBasisInterPhoneStateInfo(InterphoneInfo interphone)
			throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		if(interphone == null)
		{
			session.clear();
			throw new Exception("对讲机信息为空");
		}
		
		tx=session.beginTransaction();//开启事务
		InterphoneInfo interphoneInfo = new InterphoneInfo();
		interphoneInfo = (InterphoneInfo)session.get(InterphoneInfo.class,interphone.getInterphoneID_s());
		if(interphoneInfo == null)
		{
			session.clear();
			throw new Exception("对讲机信息为空");
		}
		else{
			if(interphone.getState_i() != null)
			{
				interphoneInfo.setState_i(interphone.getState_i());
			}
		}
		
		session.saveOrUpdate(interphoneInfo);
		session.flush();	    
	    tx.commit();
	    session.clear();
		return 1;
	}

	public int UpdateBasisTotalInterPhoneStateInfo(List<InterphoneInfo> interphoneID_s
			) throws Exception {
		// TODO Auto-generated method stub
		int n=0;
		if(interphoneID_s!= null&&interphoneID_s.size()>0){
			for (int i=0;i<interphoneID_s.size();i++){
				n = UpdateBasisInterPhoneStateInfo(interphoneID_s.get(i));
			}
		}
		return n;
	}
	
	/**
	 * 在事务中更新对讲机信息
	 * UpdateBasisInterPhoneStateInfobyTransaction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int UpdateBasisInterPhoneStateInfobyTransaction(InterphoneInfo interphone,Session session)
	throws Exception {
		// TODO Auto-generated method stub
	 
		if(interphone == null)
		{			 
			throw new Exception("对讲机信息为空");
		}
		 
		InterphoneInfo interphoneInfo = new InterphoneInfo();
		interphoneInfo = (InterphoneInfo)session.get(InterphoneInfo.class,interphone.getInterphoneID_s());
		if(interphoneInfo == null)
		{
			throw new Exception("对讲机信息为空");
		}
		else{
			if(interphone.getState_i() != null)
			{
				interphoneInfo.setState_i(interphone.getState_i());
			}
		}
		session.saveOrUpdate(interphoneInfo);
		session.flush();
		return 1;
	}
	
	/**
	 * 在事务中更新对讲机信息
	 * UpdateBasisTotalInterPhoneStateInfobyTransaction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int UpdateBasisTotalInterPhoneStateInfobyTransaction(List<InterphoneInfo> interphoneID_s,Session session
	) throws Exception {
		// TODO Auto-generated method stub
		int n=0;
		if(interphoneID_s!= null&&interphoneID_s.size()>0){
			for (int i=0;i<interphoneID_s.size();i++){
				n = UpdateBasisInterPhoneStateInfobyTransaction(interphoneID_s.get(i),session);
			}
		}
		return n;
	}
	/**
	 * 对讲机发放/收回
	 * interphoneProvide 
	 * @param   interphoneIDs:对讲机编号
	 * userCardIDs:人卡编号
	 *  vehicleCardIDs:车卡编号
	 *  orderId:订单
	 *  employ:操作人
	 *  operation:操作  ConstantUtil.interphoneOperation_1：发放  ConstantUtil.interphoneOperation_2：归还
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int interphoneProvide(List<String> interphoneIDs,List<String> userCardIDs,
			List<String> vehicleCardIDs,String orderId,Employee employ,Integer operation)
	 		throws Exception {
		Session session= HibernateUtil.getSession();
		try{
			verifyInterphoneProvide(interphoneIDs,userCardIDs,vehicleCardIDs,operation);
			ArrayList<CardInfo> cardlist=new ArrayList<CardInfo>();//卡信息表集合
			ArrayList<InterphoneInfo> interphonelist=new ArrayList<InterphoneInfo>();//对讲机基础信息表集合
			//对讲机使用过程表集合
			ArrayList<TProcessInterphoneemployinfo> processphonelist=new ArrayList<TProcessInterphoneemployinfo>();
			InterphoneInfo interPhoneInfo = null;
			for(int i=0;i<interphoneIDs.size();i++){
				String tmpInterphoneID = interphoneIDs.get(i);
				interPhoneInfo = new InterphoneInfo();
				interPhoneInfo.setInterphoneID_s(tmpInterphoneID);
				//1、判断对讲机是否存在以及对讲机状态是否为闲置
				List<InterphoneInfo> interPhoneInfos = this.getBasisInterPhoneInfo(interPhoneInfo, 0, 1);				
				if(!BasicTools.isnotNull(interPhoneInfos)){
					return 2;
					//throw new Exception("对讲机"+tmpInterphoneID+"不存在");
				}
				interPhoneInfo = interPhoneInfos.get(0);
				//当状态为发放时，判断对讲机是否为闲置，不是的话进行提示
				if(operation==ConstantUtil.interphoneOperation_1&&interPhoneInfo.getState_i()!=ConstantUtil.interphoneState_2){
					return 3;
					//throw new Exception("对讲机"+tmpInterphoneID+"状态为"+ConstantUtil.interphoneStateHashTable.get(interPhoneInfos.get(0).getState_i())+"，不能发放");
				}
				//2、状态为发放时增加卡信息表记录
				if(operation==ConstantUtil.interphoneOperation_1){
					CardInfo tempCardInfo=new CardInfo();
					tempCardInfo.setOrderID_s(orderId);
					tempCardInfo.setCard_s(tmpInterphoneID);
					tempCardInfo.setCardType_s(ConstantUtil.cardType_4);
					tempCardInfo.setCreateUser_s(employ.getCustomerUserName_s());
					tempCardInfo.setCreateDate_t(DateUtil.getCurrentDate());
					cardlist.add(tempCardInfo);
				}else{//状态为归还时删除卡信息表记录
					CardInfo tempCardInfo=new CardInfo();
					tempCardInfo.setOrderID_s(orderId);
					tempCardInfo.setCard_s(tmpInterphoneID);
					cardlist.add(tempCardInfo);
				}
				//3、保存对讲机信息表
				interPhoneInfo.setState_i(operation);
				interphonelist.add(interPhoneInfo);
				//4、保存对讲机过程管理
				TProcessInterphoneemployinfo processinterphone = new TProcessInterphoneemployinfo();
				processinterphone.setInterphoneID_s(tmpInterphoneID);
				processinterphone.setCreateDate_t(DateUtil.getCurrentDate());
				processinterphone.setOperation_i(operation);
				
				processinterphone.setCreateuserS(employ.getCustomerUserName_s());
				processinterphone.setUsercardIDS(userCardIDs.get(i));
				if(operation==ConstantUtil.interphoneOperation_1){
					processinterphone.setVehiclecardidS(vehicleCardIDs.get(i));
				}
				processphonelist.add(processinterphone);
			}
			if(!session.isOpen())
			{
				session = HibernateUtil.getSession();
			}
			
			tx=session.beginTransaction();//开启事务
			IcardInfoService cardservice=new CardInfoServiceImpl();
			//发放时添加卡信息，归还时删除卡信息
			if(operation==ConstantUtil.interphoneOperation_1){
				int result=cardservice.saveReceptionCardInfobyTransaction(cardlist,session);
			}else{
				cardservice.deleteReceptionCardInfobyTransaction(cardlist,session);
			}
			//然后修改发放的对讲机信息
			this.UpdateBasisTotalInterPhoneStateInfobyTransaction(interphonelist,session);
			TProcessInterPhoneEmployinfoService tpips=new TProcessInterphoneEmployinfoServiceImpl();
			tpips.OperationTProcessInterphoneemployinfobyTransaction(processphonelist,session, 1);
			tx.commit();
			return 1;
		}catch(Exception e){
			try{
				if(tx!=null){
					tx.rollback();
				}
			}catch(Exception e1){
				throw e1;
			}
			throw e;
		}finally{				
	    	session.clear();		 
		}
	}
	
	/**
	 * 归还对讲机
	 * interphoneReturn 
	 * @param   name    
	 * @param  processIDs 使用记录号 
	 * 		   interphoneIDs 对讲机编号
	 * 		   userCardIDs 归还人卡id
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int interphoneReturn(String processIDs,String interphoneIDs,String orderId)
		throws Exception {
		Session session= HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}			
		try{
			ArrayList<CardInfo> cardlist=new ArrayList<CardInfo>();//卡信息表集合
			ArrayList<TProcessInterphoneemployinfo> processphonelist=new ArrayList<TProcessInterphoneemployinfo>();
			TProcessInterphoneemployinfo tetmp = new TProcessInterphoneemployinfo(); //按主键查询出的对象
			ArrayList<InterphoneInfo> interphonelist=new ArrayList<InterphoneInfo>();//对讲机基础信息表集合
			TProcessInterPhoneEmployinfoService tpips=new TProcessInterphoneEmployinfoServiceImpl();
			
			IcardInfoService cardservice=new CardInfoServiceImpl();
			tx=session.beginTransaction();//开启事务
			 
			//卡集合对象
			CardInfo tempCardInfo=new CardInfo();
			tempCardInfo.setOrderID_s(orderId);
			tempCardInfo.setCard_s(interphoneIDs);
			cardlist.add(tempCardInfo);
			cardservice.deleteReceptionCardInfobyTransaction(cardlist,session);
		
			//使用过程记录
			tetmp = new TProcessInterphoneemployinfo(); 
			tetmp.setProcessID(processIDs);
			tetmp = tpips.getTProcessInterPhoneEmployinfoBysession(tetmp, ConstantUtil.pagingNot,0,session).get(0);
			tetmp.setResaveds2S(DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));//归还的时间
			processphonelist.add(tetmp);
			tpips.OperationTProcessInterphoneemployinfobysession(processphonelist, 1,session);				
			//对讲机对象
			InterphoneInfo interPhoneInfo = new InterphoneInfo();
			interPhoneInfo.setInterphoneID_s(interphoneIDs);
			interPhoneInfo = this.getBasisInterPhoneInfo(interPhoneInfo, ConstantUtil.pagingNot, 0).get(0);
			interPhoneInfo.setState_i(ConstantUtil.interphoneState_2);
			interphonelist.add(interPhoneInfo);
			this.OperationInterphoneInfoBysession(interphonelist, 1,session);
			 
			tx.commit();
			return 1;
		}catch(Exception e){
			try{
				if(tx!=null){
					tx.rollback();
				}
			}catch(Exception e1){
				throw e1;
			}
			throw e;
		}finally{				
	    	session.clear();		 
		}
	}
	
	/**
	 * 验证对讲机发放数据正确性
	 * verifyInterphoneProvide 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void verifyInterphoneProvide(List<String> interphoneIDs,List<String> userCardIDs,
			List<String> vehicleCardIDs,Integer operation) throws Exception{
		if(operation==ConstantUtil.interphoneOperation_1){
			if(interphoneIDs==null||interphoneIDs.size()==0||interphoneIDs.contains(null)){
				throw new Exception("请正确填写对讲机编号");
			}
			if(userCardIDs==null||userCardIDs.size()==0||userCardIDs.contains(null)){
				throw new Exception("请正确填写人卡编号");
			}
			if(vehicleCardIDs==null||vehicleCardIDs.size()==0||vehicleCardIDs.contains(null)){
				throw new Exception("请正确填写车卡编号");
			}
			if(interphoneIDs.size()!=userCardIDs.size()||interphoneIDs.size()!=vehicleCardIDs.size()){
				throw new Exception("请正确填写对讲机与人卡、车卡的绑定信息");
			}
		}else{
			if(interphoneIDs==null||interphoneIDs.size()==0||interphoneIDs.contains(null)){
				throw new Exception("请正确填写对讲机编号");
			}
			if(userCardIDs==null||userCardIDs.size()==0||userCardIDs.contains(null)){
				throw new Exception("请正确填写人卡编号");
			}
			if(interphoneIDs.size()!=userCardIDs.size()){
				throw new Exception("请正确填写对讲机与人卡、车卡的绑定信息");
			}
		}
	}
	
	
	
	public boolean getIsVisible(String interphoneID)
	throws Exception {
		boolean returnValue = false;
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			String hql = "select count(*) from TProcessInterphoneemployinfo as tProcessInterphoneemployinfo where 1=1";
			String condition="";
			
			if(interphoneID != null && !interphoneID.trim().equals("")){
				condition =" and tProcessInterphoneemployinfo.interphoneID_s = '" + interphoneID + "'";
		    }
			
			
			Query query = session.createQuery(hql + condition);
			if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
			}
			if(n>0)
			{
				returnValue = true;
			}
			else
			{
				returnValue = false;
			}
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		finally
		{
			session.clear();
			return returnValue;	
		}
		}

	public int UpdateBasisInterPhoneStateInfoWithoutTrans(
			InterphoneInfo interphone) throws Exception {
		// TODO Auto-generated method stub
		
		if(interphone == null)
		{
			
			throw new Exception("对讲机信息为空");
		}
		
		InterphoneInfo interphoneInfo = new InterphoneInfo();
		interphoneInfo = (InterphoneInfo)sessionImpl.get(InterphoneInfo.class,interphone.getInterphoneID_s());
		if(interphoneInfo == null)
		{
			
			throw new Exception("对讲机信息为空");
		}
		else{
			if(interphone.getState_i() != null)
			{
				interphoneInfo.setState_i(interphone.getState_i());
			}
		}
		sessionImpl.saveOrUpdate(interphoneInfo);
		sessionImpl.flush();
		sessionImpl.clear();
		return 1;
	}
}
