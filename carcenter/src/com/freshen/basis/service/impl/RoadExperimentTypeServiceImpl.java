package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadExperimentTypeService;

import com.freshen.entity.basis.RoadExperimentType;

import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

/**
 * 道路试验类型基础信息表接口实现
   
 * RoadExperimentTypeServiceImpl
 * 
 * @author Yepeng
 * 
 * @version 1.0
 *  
 * 
 */
public class RoadExperimentTypeServiceImpl extends ClimsServiceBase implements IroadExperimentTypeService{

	String roadID_s;				//	道路编号
	String roadName_s;				//	道路名称
	String experimentTypeID_s;		//	试验类型ID
	String experimentTypeName_s;	//	试验类型名称
	Date createDate_t;				//	创建时间
	Date lastUpdateDate_t;			//	最后修改时间
	String createUser_s;			//	创建人
	String lastUpdateUser_s;		//	最后修改人
	String resaveds1_s;				//	预留1
	String resaveds2_s;				//	预留2
	String resaveds3_s;				//	预留3
	String resaveds4_s;				//	预留4
	String resaveds5_s;				//	预留5
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	/**
	 * 通过条件查询道路试验类型基础信息表
	   
	 * getBasisRoadExperimentTypeInfo
	 * @author	Yepeng
	 * @param	RoadExperimentType roadExperimentType
	 * @param	int start
	 * @param	int size
	 * @return	ArrayList<RoadExperimentType>
	 * @throws	Exception
	 * @Exception 异常对象
	 * @since  CodingExample
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RoadExperimentType> getBasisRoadExperimentTypeInfo(RoadExperimentType roadExperimentType, int start, int size) throws Exception{
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			List<RoadExperimentType> list = new ArrayList<RoadExperimentType>();
			
			if(roadExperimentType == null){
				Query query = session.createQuery("from RoadExperimentType");
				if(start != ConstantUtil.pagingNot){
				    query.setFirstResult(start);
				    query.setMaxResults(size);
			    }
			    list = query.list();
			    return (ArrayList<RoadExperimentType>) list;	
			}
			roadID_s = roadExperimentType.getRoadID_s();
			roadName_s = roadExperimentType.getRoadName_s();
			experimentTypeID_s = roadExperimentType.getExperimentTypeID_s();
			experimentTypeName_s = roadExperimentType.getExperimentTypeName_s();
			createDate_t = roadExperimentType.getCreateDate_t();
			createUser_s = roadExperimentType.getCreateUser_s();
			lastUpdateUser_s = roadExperimentType.getLastUpdateUser_s();
			lastUpdateDate_t = roadExperimentType.getLastUpdateDate_t();
			resaveds1_s = roadExperimentType.getResaveds1_s();
			resaveds2_s = roadExperimentType.getResaveds2_s();
			resaveds3_s = roadExperimentType.getResaveds3_s();
			resaveds4_s = roadExperimentType.getResaveds4_s();
			resaveds5_s = roadExperimentType.getResaveds5_s();
			String hql="from RoadExperimentType as roadExperimentType where 1=1 "; 
		    String condition = "";
			//	roadID_s，experimentTypeID_s是联合主键，只对应一条记录，所以当roadID_s，experimentTypeID_s不为空的情况，直接进行查询并返回
			if(roadID_s != null && !roadID_s.trim().equals("") && experimentTypeID_s != null && !experimentTypeID_s.trim().equals("")){
				condition = condition + " and roadExperimentType.roadID_s like '%" + roadID_s + "%'";
				condition = condition + " and roadExperimentType.experimentTypeID_s like '%" + experimentTypeID_s + "%'";
		    }
			
			
			 if(roadID_s != null && !roadID_s.trim().equals("")){
			    	condition = condition + " and roadExperimentType.roadID_s like '%" + roadID_s + "%'";
			 }
			 if(experimentTypeID_s != null && !experimentTypeID_s.trim().equals("")){
			    	condition = condition + " and roadExperimentType.experimentTypeID_s like '%" + experimentTypeID_s + "%'";
			}
		    if(roadName_s != null && !roadName_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.roadName_s like '%" + roadName_s + "%'";
		    }
		    if(experimentTypeName_s != null && !experimentTypeName_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.experimentTypeName_s like '%" + experimentTypeName_s + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(roadExperimentType.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition + " and to_char(roadExperimentType.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.createUser_s like '%" + createUser_s + "%'";
		    }
		    if(lastUpdateUser_s != null && lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.lastUpdateUser_s like '%" + lastUpdateUser_s + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds1_s like '%" + resaveds1_s + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds2_s like '%" + resaveds2_s + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds3_s like '%" + resaveds3_s + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds4_s like '%" + resaveds4_s + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds5_s like '%" + resaveds5_s + "%'";
		    }
		    Query query = session.createQuery(hql + condition);
		    if(start != ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    list = query.list();
		    return (ArrayList<RoadExperimentType>) list;	
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}

	/**
	 * 通过条件查询道路试验类型基础信息表,返回查询个数
	   
	 * getBasisRoadExperimentTypeInfo
	 * @author	Yepeng
	 * @param	RoadExperimentType roadExperimentType
	 * @return	long n
	 * @throws	Exception
	 * @Exception 异常对象
	 * @since  CodingExample
	 */
	public long getBasisRoadExperimentTypeInfoNumber(RoadExperimentType roadExperimentType) throws Exception{
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try{
			List<RoadExperimentType> list = new ArrayList<RoadExperimentType>();

			if(roadExperimentType == null){
				Query query = session.createQuery("select count(*) from RoadExperimentType");
			    if(query.iterate().hasNext()){
			    	n = (Long) query.iterate().next();
			    }    
			    return n;
			}
			roadID_s = roadExperimentType.getRoadID_s();
			roadName_s = roadExperimentType.getRoadName_s();
			experimentTypeID_s = roadExperimentType.getExperimentTypeID_s();
			experimentTypeName_s = roadExperimentType.getExperimentTypeName_s();
			createDate_t = roadExperimentType.getCreateDate_t();
			createUser_s = roadExperimentType.getCreateUser_s();
			lastUpdateUser_s = roadExperimentType.getLastUpdateUser_s();
			lastUpdateDate_t = roadExperimentType.getLastUpdateDate_t();
			resaveds1_s = roadExperimentType.getResaveds1_s();
			resaveds2_s = roadExperimentType.getResaveds2_s();
			resaveds3_s = roadExperimentType.getResaveds3_s();
			resaveds4_s = roadExperimentType.getResaveds4_s();
			resaveds5_s = roadExperimentType.getResaveds5_s();
			//	roadID_s，experimentTypeID_s是联合主键，只对应一条记录，所以当roadID_s，experimentTypeID_s不为空的情况，直接进行查询并返回,查询结果为1
			if(roadID_s != null && !roadID_s.trim().equals("") && experimentTypeID_s != null && !experimentTypeID_s.trim().equals("")){
				RoadExperimentType reType = new RoadExperimentType();
				reType.setRoadID_s(roadID_s);
				reType.setExperimentTypeID_s(experimentTypeID_s);
				roadExperimentType = (RoadExperimentType)session.get(roadExperimentType.getClass(), reType);
		    	list.add(roadExperimentType);
		    	n = 1;
		    	return n;
		    }
			
			String hql = "select count(*) from RoadExperimentType as roadExperimentType where 1=1 "; 
		    String condition = "";
		    if(roadName_s != null && !roadName_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.roadName_s like '%" + roadName_s + "%'";
		    }
		    if(experimentTypeName_s != null && !experimentTypeName_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.experimentTypeName_s like '%" + experimentTypeName_s + "%'";
		    }
		    if(createDate_t != null){
		    	condition = condition + " and to_char(roadExperimentType.createDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(createDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition + " and to_char(roadExperimentType.lastUpdateDate_t,'yyyy-MM-dd')='" + DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") + "'";
		    }
		    if(createUser_s != null && createUser_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.createUser_s like '%" + createUser_s + "%'";
		    }
		    if(lastUpdateUser_s != null && lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.lastUpdateUser_s like '%" + lastUpdateUser_s + "%'";
		    }
		    if(resaveds1_s != null && resaveds1_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds1_s like '%" + resaveds1_s + "%'";
		    }
		    if(resaveds2_s != null && resaveds2_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds2_s like '%" + resaveds2_s + "%'";
		    }
		    if(resaveds3_s != null && resaveds3_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds3_s like '%" + resaveds3_s + "%'";
		    }
		    if(resaveds4_s != null && resaveds4_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds4_s like '%" + resaveds4_s + "%'";
		    }
		    if(resaveds5_s != null && resaveds5_s.trim().equals("")){
		    	condition = condition + " and roadExperimentType.resaveds5_s like '%" + resaveds5_s + "%'";
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
	 * 保存道路试验类型基础信息
	 * saveOrUpdateBasisRoadExperimentTypeInfo 
	 * @param	ArrayList<RoadExperimentType> list
	 * @author	Yepeng
	 * @return	int 1.成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int saveOrUpdateBasisRoadExperimentTypeInfo(ArrayList<RoadExperimentType> list) throws Exception{
		Session session= HibernateUtil.getSession();
		RoadExperimentType ret = new RoadExperimentType();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).getExperimentTypeID_s() != null && !list.get(i).getExperimentTypeID_s().trim().equals("")){
						ret.setExperimentTypeID_s(list.get(i).getExperimentTypeID_s().trim());
					} else {
						IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
						String pk = systemSequenceServiceImpl.getPK(ConstantUtil.DLSYLXBusiness, session);
						//	驾驶员ID，Sequence自动生成
						ret.setExperimentTypeID_s(pk);
					}
					if(list.get(i).getRoadID_s() != null && !list.get(i).getRoadID_s().trim().equals("")){
						ret.setRoadID_s(list.get(i).getRoadID_s());
					}
					if(list.get(i).getRoadName_s() != null && !list.get(i).getRoadName_s().trim().equals("")){
						ret.setRoadName_s(list.get(i).getRoadName_s());
					}
					if(list.get(i).getExperimentTypeName_s() != null && !list.get(i).getExperimentTypeName_s().trim().equals("")){
						ret.setExperimentTypeName_s(list.get(i).getExperimentTypeName_s());
					}
					if(list.get(i).getCreateUser_s() != null && !list.get(i).getCreateUser_s().trim().equals("")){
						ret.setCreateUser_s(list.get(i).getCreateUser_s());
					}
					if(list.get(i).getCreateDate_t() != null){
						ret.setCreateDate_t(list.get(i).getCreateDate_t());
					}
					if(list.get(i).getLastUpdateUser_s() != null && !list.get(i).getLastUpdateUser_s().trim().equals("")){
						ret.setLastUpdateUser_s(list.get(i).getLastUpdateUser_s());
					}
					if(list.get(i).getLastUpdateDate_t() != null){
						ret.setLastUpdateDate_t(list.get(i).getLastUpdateDate_t());
					}
					
					if(list.get(i).getResaveds1_s() != null){
						ret.setResaveds1_s(list.get(i).getResaveds1_s());
					}
					if(list.get(i).getResaveds2_s() != null){
						ret.setResaveds2_s(list.get(i).getResaveds2_s());
					}
					if(list.get(i).getResaveds3_s() != null){
						ret.setResaveds3_s(list.get(i).getResaveds3_s());
					}
					if(list.get(i).getResaveds4_s() != null){
						ret.setResaveds2_s(list.get(i).getResaveds4_s());
					}
					if(list.get(i).getResaveds5_s() != null){
						ret.setResaveds5_s(list.get(i).getResaveds5_s());
					}
				}
				session.saveOrUpdate(ret);				
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
	
	/**
	 * 删除道路试验类型基础信息
	 * deleteBasisRoadExperimentTypeInfo
	 * @param	ArrayList<RoadExperimentType> list
	 * @author	Yepeng
	 * @return	int 1.成功    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int deleteBasisRoadExperimentTypeInfo(ArrayList<RoadExperimentType> list) throws Exception{
		RoadExperimentType ret = new RoadExperimentType();
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		try{
			tx = session.beginTransaction();//开启事务
			
			if(list != null && list.size() > 0){
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).getExperimentTypeID_s() != null && !list.get(i).getExperimentTypeID_s().trim().equals("")){
						ret.setExperimentTypeID_s(list.get(i).getExperimentTypeID_s());
					}
					if(list.get(i).getRoadID_s() != null && !list.get(i).getRoadID_s().trim().equals("")){
						ret.setRoadID_s(list.get(i).getRoadID_s());
					}
					session.delete(ret);
					session.flush();				  
				}
			}else{
				throw new Exception("道路试验类型基础信息不正确");
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
	
	
}
