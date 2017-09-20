package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Array;

import com.freshen.basis.service.IDriverService;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.basis.RoadInfo;

import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class DriverServiceImpl extends ClimsServiceBase implements IDriverService{

	String customerUserID_s,customerID_s;
	String customerName_s, department_s, customerUserName_s, identityCard_s, position_s, telephone_s, drivingLicenceCPG_s, levelCPG_s;
	Date lastTrainDate_t = new Date();
	Date createDate_t = new Date();
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t = new Date();
	Date lastTestDate_t; //最后一次试验时间
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String sysNo_s;
	
	Transaction tx = null;
	
	/**
	 * 通过条件查询驾驶员信息表
	   
	 * getBasisDriverInfo 
	 * @param   name    
	 * @param  @return    List    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public ArrayList<Driver> getBasisDriverInfo(Driver driver, int start, int size) throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<Driver> list = new ArrayList();
			
			if(driver == null){
				Query query=session.createQuery("from Driver");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			customerID_s=driver.getCustomerID_s();
			customerUserID_s = driver.getCustomerUserID_s();
			customerName_s = driver.getCustomerName_s();
			department_s = driver.getDepartment_s();
			customerUserName_s = driver.getCustomerUserName_s();
			identityCard_s = driver.getIdentityCard_s();
			position_s = driver.getPosition_s();
			telephone_s = driver.getTelephone_s();
			drivingLicenceCPG_s = driver.getDrivingLicenceCPG_s();
			levelCPG_s = driver.getLevelCPG_s();
			lastTrainDate_t = driver.getLastTrainDate_t();
			createDate_t = driver.getCreateDate_t();
			createUser_s = driver.getCreateUser_s();
			lastUpdateUser_s = driver.getLastUpdateUser_s();
			lastUpdateDate_t = driver.getLastUpdateDate_t();
			resaveds1_s = driver.getResaveds1_s();
			resaveds2_s = driver.getResaveds2_s();
			resaveds3_s = driver.getResaveds3_s();
			resaveds4_s = driver.getResaveds4_s();
			resaveds5_s = driver.getResaveds5_s();
			lastTestDate_t = driver.getLastTestDate_t();
			sysNo_s = driver.getSysNo_s();
			String hql = " from Driver as driver where 1=1 ";
		    String condition = "";
		    
			if(customerUserID_s != null && !customerUserID_s.trim().equals("")){
				condition = condition + " and driver.customerUserID_s like '%" + customerUserID_s.trim() + "%'";
				Query query = session.createQuery(hql+condition);
				list = query.list();
		    	return (ArrayList) list;
		    }
			
			
		   
		    if(customerID_s != null && !customerID_s.trim().equals("")){
		    	condition = " and driver.customerID_s like '%" + customerID_s.trim() + "%'";
		    }
		    if(customerName_s != null && !customerName_s.trim().equals("")){
		    	condition = " and driver.customerName_s like '%" + customerName_s.trim() + "%'";
		    }
		    if(department_s != null && !department_s.trim().equals("")){
		    	condition = condition + " and driver.department_s like '%" + department_s.trim() + "%'";
		    }
		    if(customerUserName_s != null && !customerUserName_s.trim().equals("")){
		    	condition = condition + " and driver.customerUserName_s like '%" + customerUserName_s.trim() + "%'";
		    }
		    if(identityCard_s != null && !identityCard_s.trim().equals("")){
		    	condition = condition + " and driver.identityCard_s like '%" + identityCard_s.trim() + "%'";
		    }
		    if(position_s != null && !position_s.trim().equals("")){
		    	condition = condition + " and driver.position_s like '%" + position_s.trim() + "%'";
		    }
		    if(telephone_s != null && !telephone_s.trim().equals("")){
		    	condition = condition + " and driver.telephone_s like '%" + telephone_s.trim() + "%'";
		    }
		    if(drivingLicenceCPG_s != null && !drivingLicenceCPG_s.trim().equals("")){
		    	condition = condition + " and driver.drivingLicenceCPG_s like '%" + drivingLicenceCPG_s.trim() + "%'";
		    }
		    if(levelCPG_s != null && !levelCPG_s.trim().equals("")){
		    	condition = condition + " and driver.levelCPG_s like '%" + levelCPG_s.trim() + "%'";
		    }
		    if(lastTrainDate_t != null){
		    	condition = condition + " and to_char(driver.lastTrainDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastTrainDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(driver.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(driver.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and driver.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and driver.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(lastTestDate_t != null){
		    	condition = condition + " and to_char(driver.lastTestDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastTestDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(sysNo_s != null && !sysNo_s.trim().equals("")){
		    	condition = condition + " and driver.sysNo_s = '" + sysNo_s.trim() + "'";
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
	 * 通过条件查询驾驶员信息表，返回取得个数
	   
	 * getBasisDriverInfoNumber 
	 * @param   name    
	 * @param  @return    Long    
	 * @return String    
	 * @throws Exception 
	 * @Exception 异常对象    
	 * @since  CodingExample　
	 */
	public long getBasisDriverInfoNumber(Driver driver) throws Exception{
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<Driver> list = new ArrayList();

			if(driver == null){
				Query query=session.createQuery("select count(*) from Driver");
			    if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			customerUserID_s = driver.getCustomerUserID_s();
			customerName_s = driver.getCustomerName_s();
			department_s = driver.getDepartment_s();
			customerUserName_s = driver.getCustomerUserName_s();
			identityCard_s = driver.getIdentityCard_s();
			position_s = driver.getPosition_s();
			telephone_s = driver.getTelephone_s();
			drivingLicenceCPG_s = driver.getDrivingLicenceCPG_s();
			levelCPG_s = driver.getLevelCPG_s();
			lastTrainDate_t = driver.getLastTrainDate_t();
			createDate_t = driver.getCreateDate_t();
			createUser_s = driver.getCreateUser_s();
			lastUpdateUser_s = driver.getLastUpdateUser_s();
			lastUpdateDate_t = driver.getLastUpdateDate_t();
			resaveds1_s = driver.getResaveds1_s();
			resaveds2_s = driver.getResaveds2_s();
			resaveds3_s = driver.getResaveds3_s();
			resaveds4_s = driver.getResaveds4_s();
			resaveds5_s = driver.getResaveds5_s();
			lastTestDate_t = driver.getLastTestDate_t();
			if(customerUserID_s != null && !customerUserID_s.trim().equals("")){
				driver = (Driver)session.get(driver.getClass(), customerUserID_s);
		    	list.add(driver);
		    	return 1;
		    }
			
			String hql = "select count(*) from Driver as driver where 1=1 "; 
		    String condition = "";
		    if(customerID_s != null && !customerID_s.trim().equals("")){
		    	condition = " and driver.customerID_s like '%" + customerID_s.trim() + "%'";
		    }
		    if(customerName_s != null && !customerName_s.trim().equals("")){
		    	condition = " and driver.customerName_s like '%" + customerName_s.trim() + "%'";
		    }
		    if(department_s != null && !department_s.trim().equals("")){
		    	condition = condition + " and driver.department_s like '%" + department_s.trim() + "%'";
		    }
		    if(customerUserName_s != null && !customerUserName_s.trim().equals("")){
		    	condition = condition + " and driver.customerUserName_s like '%" + customerUserName_s.trim() + "%'";
		    }
		    if(identityCard_s != null && !identityCard_s.trim().equals("")){
		    	condition = condition + " and driver.identityCard_s like '%" + identityCard_s.trim() + "%'";
		    }
		    if(position_s != null && !position_s.trim().equals("")){
		    	condition = condition + " and driver.position_s like '%" + position_s.trim() + "%'";
		    }
		    if(telephone_s != null && !telephone_s.trim().equals("")){
		    	condition = condition + " and driver.telephone_s like '%" + telephone_s.trim() + "%'";
		    }
		    if(drivingLicenceCPG_s != null && !drivingLicenceCPG_s.trim().equals("")){
		    	condition = condition + " and driver.drivingLicenceCPG_s like '%" + drivingLicenceCPG_s.trim() + "%'";
		    }
		    if(levelCPG_s != null && !levelCPG_s.trim().equals("")){
		    	condition = condition + " and driver.levelCPG_s like '%" + levelCPG_s.trim() + "%'";
		    }
		    if(lastTrainDate_t != null){
		    	condition = condition + " and to_char(driver.lastTrainDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastTrainDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(driver.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(driver.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and driver.createUser_s='" + createUser_s.trim() + "'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and driver.lastUpdateUser_s='" + lastUpdateUser_s.trim() + "'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and driver.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(lastTestDate_t != null){
		    	condition = condition + " and to_char(driver.lastTestDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastTestDate_t, "yyyy-MM-dd") +"'";
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
	 * 保存驾驶员信息
	   
	 * saveOrUpdateBasisDriverInfo 
	 * @param   name    
	 * @param  @return   1. 成功    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveOrUpdateBasisDriverInfo(ArrayList<Driver> list) throws Exception{
		Session session = HibernateUtil.getSession();
		Driver driver = new Driver();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					driver=(Driver) session.get(Driver.class,list.get(i).getCustomerUserID_s());
					if(list.get(i).getCustomerUserID_s() != null && !list.get(i).getCustomerUserID_s().equals("")){
						driver.setCustomerUserID_s(list.get(i).getCustomerUserID_s());
					} else {
						IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.JSYBusiness, session);
						String pkLecence = systemSequenceServiceImpl.getPK(ConstantUtil.JSYCPGBusiness, session);
						list.get(i).setDrivingLicenceCPG_s(pkLecence);
						//	驾驶员ID，Sequence自动生成
						list.get(i).setCustomerUserID_s(pk);
						session.saveOrUpdate(list.get(i));
						break;
					}
					if(list.get(i).getCustomerID_s() != null && !list.get(i).getCustomerID_s().equals("")){
						driver.setCustomerID_s(list.get(i).getCustomerID_s());
					}
					if(list.get(i).getCustomerName_s() != null && !list.get(i).getCustomerName_s().equals("")){
						driver.setCustomerName_s(list.get(i).getCustomerName_s());
					}
					if(list.get(i).getDepartment_s() != null && !list.get(i).getDepartment_s().equals("")){
						driver.setDepartment_s(list.get(i).getDepartment_s());
					}
					if(list.get(i).getCustomerUserName_s() != null && !list.get(i).getCustomerUserName_s().equals("")){
						driver.setCustomerUserName_s(list.get(i).getCustomerUserName_s());
					}
					if(list.get(i).getIdentityCard_s() != null && !list.get(i).getIdentityCard_s().equals("")){
						driver.setIdentityCard_s(list.get(i).getIdentityCard_s());
					}
					if(list.get(i).getPosition_s() != null && !list.get(i).getPosition_s().equals("")){
						driver.setPosition_s(list.get(i).getPosition_s());
					}
					if(list.get(i).getTelephone_s() != null && !list.get(i).getTelephone_s().equals("")){
						driver.setTelephone_s(list.get(i).getTelephone_s());
					}
					if(list.get(i).getDrivingLicenceCPG_s() != null && !list.get(i).getDrivingLicenceCPG_s().equals("")){
						driver.setTelephone_s(list.get(i).getDrivingLicenceCPG_s());
					}
					else{
						IsystemSequenceService systemSequenceServiceImplLecence  = new SystemSequenceServiceImpl();
						String pkLecence = systemSequenceServiceImplLecence.getPK(ConstantUtil.JSYCPGBusiness, session);
						driver.setDrivingLicenceCPG_s(pkLecence);
					}
					if(list.get(i).getLevelCPG_s() != null && !list.get(i).getLevelCPG_s().equals("")){
						driver.setLevelCPG_s(list.get(i).getLevelCPG_s());
					}
					if(list.get(i).getEmail_s() != null && !list.get(i).getEmail_s().equals("")){
						driver.setEmail_s(list.get(i).getEmail_s());
					}
					if(list.get(i).getLastTrainDate_t() != null){
						driver.setLastTrainDate_t(list.get(i).getLastTrainDate_t());
					}
					if(list.get(i).getCreateUser_s() != null && !list.get(i).getCreateUser_s().equals("")){
						driver.setCreateUser_s(list.get(i).getCreateUser_s());
					}
					if(list.get(i).getCreateDate_t() != null){
						driver.setCreateDate_t(list.get(i).getCreateDate_t());
					}
					if(list.get(i).getLastTestDate_t() != null){
						driver.setLastTestDate_t(list.get(i).getLastTestDate_t());
					}
					//System.out.println("===="+driver.toString());
					session.saveOrUpdate(driver);
					
				}
				tx.commit();			
			}else{
				throw new Exception("驾驶员信息不正确");
			}		
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	
	public String saveOrUpdateBasisDriverInfo2(ArrayList<Driver> list) throws Exception{
		Session session = HibernateUtil.getSession();
		Driver driver = new Driver();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		String pk = null;
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					driver=(Driver) session.get(Driver.class,list.get(i).getCustomerUserID_s());
					if(list.get(i).getCustomerUserID_s() != null && !list.get(i).getCustomerUserID_s().equals("")){
						driver.setCustomerUserID_s(list.get(i).getCustomerUserID_s());
					} else {
						IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
						pk = systemSequenceServiceImpl.getPK(ConstantUtil.JSYBusiness, session);
						String pkLecence = systemSequenceServiceImpl.getPK(ConstantUtil.JSYCPGBusiness, session);
						list.get(i).setDrivingLicenceCPG_s(pkLecence);
						//	驾驶员ID，Sequence自动生成
						list.get(i).setCustomerUserID_s(pk);
						session.saveOrUpdate(list.get(i));
						break;
					}
					if(list.get(i).getCustomerID_s() != null && !list.get(i).getCustomerID_s().equals("")){
						driver.setCustomerID_s(list.get(i).getCustomerID_s());
					}
					if(list.get(i).getCustomerName_s() != null && !list.get(i).getCustomerName_s().equals("")){
						driver.setCustomerName_s(list.get(i).getCustomerName_s());
					}
					if(list.get(i).getDepartment_s() != null && !list.get(i).getDepartment_s().equals("")){
						driver.setDepartment_s(list.get(i).getDepartment_s());
					}
					if(list.get(i).getCustomerUserName_s() != null && !list.get(i).getCustomerUserName_s().equals("")){
						driver.setCustomerUserName_s(list.get(i).getCustomerUserName_s());
					}
					if(list.get(i).getIdentityCard_s() != null && !list.get(i).getIdentityCard_s().equals("")){
						driver.setIdentityCard_s(list.get(i).getIdentityCard_s());
					}
					if(list.get(i).getPosition_s() != null && !list.get(i).getPosition_s().equals("")){
						driver.setPosition_s(list.get(i).getPosition_s());
					}
					if(list.get(i).getTelephone_s() != null && !list.get(i).getTelephone_s().equals("")){
						driver.setTelephone_s(list.get(i).getTelephone_s());
					}
					if(list.get(i).getDrivingLicenceCPG_s() != null && !list.get(i).getDrivingLicenceCPG_s().equals("")){
						driver.setTelephone_s(list.get(i).getDrivingLicenceCPG_s());
					}
					else{
						IsystemSequenceService systemSequenceServiceImplLecence  = new SystemSequenceServiceImpl();
						String pkLecence = systemSequenceServiceImplLecence.getPK(ConstantUtil.JSYCPGBusiness, session);
						driver.setDrivingLicenceCPG_s(pkLecence);
					}
					if(list.get(i).getLevelCPG_s() != null && !list.get(i).getLevelCPG_s().equals("")){
						driver.setLevelCPG_s(list.get(i).getLevelCPG_s());
					}
					if(list.get(i).getEmail_s() != null && !list.get(i).getEmail_s().equals("")){
						driver.setEmail_s(list.get(i).getEmail_s());
					}
					if(list.get(i).getLastTrainDate_t() != null){
						driver.setLastTrainDate_t(list.get(i).getLastTrainDate_t());
					}
					if(list.get(i).getCreateUser_s() != null && !list.get(i).getCreateUser_s().equals("")){
						driver.setCreateUser_s(list.get(i).getCreateUser_s());
					}
					if(list.get(i).getCreateDate_t() != null){
						driver.setCreateDate_t(list.get(i).getCreateDate_t());
					}
					if(list.get(i).getLastTestDate_t() != null){
						driver.setLastTestDate_t(list.get(i).getLastTestDate_t());
					}
					//System.out.println("===="+driver.toString());
					session.saveOrUpdate(driver);
					
				}
				tx.commit();			
			}else{
				throw new Exception("驾驶员信息不正确");
			}		
			return pk;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	
	public static void main(String arg[]) throws Exception{
		List<Driver> list = new ArrayList();
//		Session session = HibernateUtil.getSession();
//		Query query = session.createQuery(" from Driver as driver where customerUserID_s='JSY2014041000' ");
//		List<Driver> listInsert = new ArrayList();
//		listInsert = (ArrayList)query.list();
//		session.clear();
		Driver driver = new Driver();
		driver.setCustomerName_s("fdsafd");
		driver.setDepartment_s("部门1");
		driver.setIdentityCard_s("432432");
		driver.setCustomerName_s("lz");
		driver.setCustomerUserName_s("lz");
		driver.setCreateDate_t(new Date());
		driver.setCreateUser_s("lz");
		driver.setLastTestDate_t(new Date());
		Date date = new Date();
		date.setYear(112);
		driver.setLastTrainDate_t(date);
		list.add(driver);
		IDriverService ids = new DriverServiceImpl();
		//Driver d  = new Driver();
		int i =ids.saveOrUpdateBasisDriverInfo((ArrayList)list);
	//	list = ids.getBasisDriverInfo(d, -1, 10);
	}

	public int deleteBasisDriverInfo(ArrayList<Driver> list) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
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
