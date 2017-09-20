package com.freshen.basis.service.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class WorkShopInfoServiceImpl extends ClimsServiceBase implements IworkShopInfoService{

	//Session session= HibernateUtil.getSession();
	String workShopID_s, workShopName_s, useInfos_s, remark_s,createUser_s,lastUpdateUser_s,type_s;
	 
	Date  createDate_t,lastUpdateDate_t;
	String resaveds1_s,resaveds2_s,resaveds3_s,resaveds4_s,	resaveds5_s;
	Integer isSubscribe_i;
	Double unitprieI;
	
	Integer ismonthSubscribe_i;
	Integer isdaysubscribe_i;
	Integer beginningday_i;
	public ArrayList<WorkShopInfo> getWorkShopInfo(WorkShopInfo workShopInfo) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession(); 
		try{
			List<WorkShopInfo> list = new ArrayList();	
			if(workShopInfo==null)
			{
				Query query=session.createQuery(" from WorkShopInfo as workShopInfo ");
//			    query.setFirstResult(start);
//			    query.setMaxResults(size);
			    list = query.list();	    
				return (ArrayList<WorkShopInfo>) list;	
			}
			workShopID_s   = workShopInfo.getWorkShopID_s();
			workShopName_s = workShopInfo.getWorkShopName_s();
			useInfos_s = workShopInfo.getUseInfos_s();
			remark_s = workShopInfo.getRemark_s();
			type_s = workShopInfo.getType_s();
			isSubscribe_i = workShopInfo.getIsSubscribe_i();
			ismonthSubscribe_i = workShopInfo.getIsmonthSubscribe_i();
			isdaysubscribe_i = workShopInfo.getIsdaysubscribe_i();
			beginningday_i = workShopInfo.getBeginningday_i();
			String hql="from WorkShopInfo as workShopInfo where 1=1 "; 			
		    String condition = "";

			if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				condition += " and workShopInfo.workShopID_s like '%"+workShopID_s+"%'";
		    }
		
		    if(workShopID_s!=null && !workShopID_s.trim().equals("")){
		    	condition += " and workShopInfo.workShopID_s like '%"+workShopID_s+"%'";
		    }
		    if(workShopName_s!=null && !workShopName_s.trim().equals("")){
		    	condition += " and workShopInfo.workShopName_s like '%"+workShopName_s+"%'";
		    }
		    if(type_s!=null && !type_s.trim().equals("")){
		    	condition += " and workShopInfo.type_s like '%"+type_s+"%'";
		    }
		    if(useInfos_s!=null && !useInfos_s.trim().equals("")){
		    	condition += " and workShopInfo.useInfos_s like '%"+useInfos_s+"%'";
		    }
		    if(isSubscribe_i!= null){
		    	condition += " and workShopInfo.isSubscribe_i = '"+isSubscribe_i+"'";
		    }
		    if(ismonthSubscribe_i!= null){
		    	condition += " and workShopInfo.ismonthSubscribe_i = '"+ismonthSubscribe_i+"'";
		    }
		    if(isdaysubscribe_i!= null){
		    	condition += " and workShopInfo.isdaysubscribe_i = '"+isdaysubscribe_i+"'";
		    }
		    if(beginningday_i!= null){
		    	condition += " and workShopInfo.beginningday_i = '"+beginningday_i+"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    list = query.list();	    
			return (ArrayList<WorkShopInfo>) list;		
		}
		catch(Exception e)
		{
			throw e;
		}
		finally{
			session.clear();
		}
	}

	public ArrayList<WorkShopInfo> getWorkShopInfo(WorkShopInfo workShopInfo,
			int start, int size) throws Exception {
		Session session = HibernateUtil.getSession();
		try{
			List<WorkShopInfo> list = new ArrayList();
			if(workShopInfo==null)
			{
				Query query=session.createQuery(" from WorkShopInfo as workShopInfo ");
				if(start != -1){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
				}
			    list = query.list();	    
				return (ArrayList<WorkShopInfo>) list;	
			}
			workShopID_s   = workShopInfo.getWorkShopID_s();
			workShopName_s = workShopInfo.getWorkShopName_s();
			useInfos_s = workShopInfo.getUseInfos_s();
			remark_s = workShopInfo.getRemark_s();
			type_s = workShopInfo.getType_s();
			isSubscribe_i = workShopInfo.getIsSubscribe_i();
			ismonthSubscribe_i = workShopInfo.getIsmonthSubscribe_i();
			isdaysubscribe_i = workShopInfo.getIsdaysubscribe_i();
			beginningday_i = workShopInfo.getBeginningday_i();
			/*sharonyshi 2014-5-22
			 * if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				workShopInfo=(WorkShopInfo)session.get(workShopInfo.getClass(), workShopID_s);
		    	list.add(workShopInfo);
		    	return (ArrayList)list;
		    }*/
			String hql="from WorkShopInfo as workShopInfo where 1=1 "; 			
		    String condition = "";
		    
		    if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				condition += " and workShopInfo.workShopID_s like '%"+workShopID_s+"%'";
		    }
		
		    if(workShopName_s!=null && !workShopName_s.trim().equals("")){
		    	condition += " and workShopInfo.workShopName_s like '%"+workShopName_s+"%'";
		    }
		    if(type_s!=null && !type_s.trim().equals("")){
		    	condition += " and workShopInfo.type_s like '%"+type_s+"%'";
		    }
		    if(useInfos_s!=null && !useInfos_s.trim().equals("")){
		    	condition += " and workShopInfo.useInfos_s like '%"+useInfos_s+"%'";
		    }
		    if(isSubscribe_i!=null){
		    	condition += " and workShopInfo.isSubscribe_i like='"+isSubscribe_i+"'";
		    }
		    if(ismonthSubscribe_i!= null){
		    	condition += " and workShopInfo.ismonthSubscribe_i = '"+ismonthSubscribe_i+"'";
		    }
		    if(isdaysubscribe_i!= null){
		    	condition += " and workShopInfo.isdaysubscribe_i = '"+isdaysubscribe_i+"'";
		    }
		    if(beginningday_i!= null){
		    	condition += " and workShopInfo.beginningday_i = '"+beginningday_i+"'";
		    }
		    condition += " order by workShopInfo.lastUpdateDate_t DESC";
		    
		    Query query=session.createQuery(hql+condition);
		    if(start != -1){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
				}
		    list = query.list();	    
			return (ArrayList<WorkShopInfo>) list;	
		}
		catch(Exception e ){
			throw e;
		}
		finally{
			session.clear();
		}
	}
	
	public static void main(String[] args) throws Exception {
		WorkShopInfo roadInfo = new WorkShopInfo();
		WorkShopInfoServiceImpl ris = new WorkShopInfoServiceImpl();
		ArrayList<WorkShopInfo> list = new ArrayList();
		list = ris.getWorkShopInfo(roadInfo, -1, 10);
		
	}

	public int OperationWorkShopInfo(List<WorkShopInfo> workShopInfo,
			int operation) throws Exception {
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
				WorkShopInfo wsi = new WorkShopInfo();
				if(workShopInfo!=null||workShopInfo.size()>0){
					for(int i=0;i<workShopInfo.size();i++){		
						if(workShopInfo.get(i).getWorkShopID_s()== null || workShopInfo.get(i).getWorkShopID_s().trim().equals(""))
						{
							wsi = workShopInfo.get(i);
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.GCBusiness, session);
							wsi.setWorkShopID_s(cpg);
							wsi.gettBasisWorkshopcost().setWorkshopidS(cpg);
							session.merge(wsi);
						}
						else
						{
							wsi = workShopInfo.get(i);
							WorkShopInfo tmp = (WorkShopInfo)session.get(WorkShopInfo.class, wsi.getWorkShopID_s());
							workShopID_s = wsi.getWorkShopID_s();
							workShopName_s = wsi.getWorkShopName_s();
							useInfos_s = wsi.getUseInfos_s();
							remark_s = wsi.getRemark_s();
							createUser_s = wsi.getCreateUser_s();
							lastUpdateUser_s = wsi.getLastUpdateUser_s();
							type_s = wsi.getType_s();
							createDate_t = wsi.getCreateDate_t();
							lastUpdateDate_t = wsi.getLastUpdateDate_t();
							resaveds1_s = wsi.getResaveds1_s();
							resaveds2_s = wsi.getResaveds2_s();
							resaveds3_s = wsi.getResaveds3_s();
							resaveds4_s	 = wsi.getResaveds4_s();
							resaveds5_s = wsi.getResaveds5_s();
							isSubscribe_i = wsi.getIsSubscribe_i();
							ismonthSubscribe_i = wsi.getIsmonthSubscribe_i();
							isdaysubscribe_i = wsi.getIsdaysubscribe_i();
							beginningday_i = wsi.getBeginningday_i();
							
							if(ismonthSubscribe_i ==null){
								wsi.setIsmonthSubscribe_i(tmp.getIsmonthSubscribe_i());
							}
							if(isdaysubscribe_i ==null){
								wsi.setIsdaysubscribe_i(tmp.getIsdaysubscribe_i());
							}
							if(beginningday_i == null){
								wsi.setBeginningday_i(tmp.getBeginningday_i());
							}
							
							if(workShopID_s == null){
								wsi.setWorkShopID_s(tmp.getWorkShopID_s());
							}
							if(workShopName_s == null){
								wsi.setWorkShopName_s(tmp.getWorkShopName_s());
							}
							if(useInfos_s == null || useInfos_s.equals("")){
								wsi.setUseInfos_s(tmp.getUseInfos_s());
							}else{
								//String[] str = useInfos_s.split("vv");
								String ui ="";
								if(tmp.getUseInfos_s() != null || !tmp.getUseInfos_s().equals("")){
									ui=tmp.getUseInfos_s() +"vv" +useInfos_s;	
								}else{
									ui=useInfos_s;
								}
								wsi.setUseInfos_s(ui);
								/*if(!tmp.getUseInfos_s().trim().equals(""))
								{
									ui = tmp.getUseInfos_s();
								}
								
								if(str.length == 0){
									wsi.setUseInfos_s(tmp.getUseInfos_s());
								}else{
									for(int j = 0;j<str.length;j++){
										if(!str[j].trim().equals("")){
											if(!ui.trim().equals("")){
												ui = ui + "vv" +  str[j]; 
											}else{
												ui = ui + str[j];
											}
										}
									}
									
									if(!ui.trim().equals("")){
										wsi.setUseInfos_s(ui);
									}
								}*/
								
							}
							if(remark_s == null){
								wsi.setRemark_s(tmp.getRemark_s());
							}
							if(createUser_s == null){
								wsi.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								wsi.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(type_s == null){
								wsi.setType_s(tmp.getType_s());
							}
							if(createDate_t == null){
								wsi.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(lastUpdateDate_t == null){
								wsi.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								wsi.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								wsi.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								wsi.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								wsi.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								wsi.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(isSubscribe_i == null){
								wsi.setIsSubscribe_i(tmp.getIsSubscribe_i());
							}
							
							session.merge(wsi);
						}
						
//						session.saveOrUpdate(wsi);
						session.flush();					
					}
				}
			}
			//删除
			if(operation==2){
				if(workShopInfo!=null&&workShopInfo.size()>0){
					for(int i=0;i<workShopInfo.size();i++){
						session.delete(workShopInfo.get(i));
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
	
	
	
	public int OperationWorkShopInfoUseInfos(String workShopID_s,
			String useInfos_s) throws Exception {
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Transaction tx = session.beginTransaction();
		try
		{
			if(workShopID_s != null && !workShopID_s.trim().equals("")){
				WorkShopInfo wsi = (WorkShopInfo)session.get(WorkShopInfo.class,workShopID_s);
				if(wsi!= null){
					String uis = wsi.getUseInfos_s();
					String[] str = uis.split("vv");
					String newUseInfos = "";
					if (str.length>0)
					{
						for(int i = 0;i<str.length;i++){
							if(!str[i].equals(useInfos_s)){
								if(!newUseInfos.trim().equals("")){
									newUseInfos+= "vv" + str[i];
								}
								else{
									newUseInfos+=str[i];
								}
							}
							
						}						
						wsi.setUseInfos_s(newUseInfos);
						session.merge(wsi);
						session.flush();
					    session.clear();
					    tx.commit();
					    return 1;
					}
				}
				
			}
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{
			session.clear();
		}
		return 0;
	}

	public long getWorkShopInfoNumber(WorkShopInfo workshopInfo)
			throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		try {
			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}
			long n = 0;
			if(workshopInfo==null){
				Query query = session.createQuery("select count(*) from WorkShopInfo");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			workShopID_s   = workshopInfo.getWorkShopID_s();
			workShopName_s = workshopInfo.getWorkShopName_s();
			useInfos_s = workshopInfo.getUseInfos_s();
			remark_s = workshopInfo.getRemark_s();
			type_s = workshopInfo.getType_s();
			
			String hql="select count(*) from WorkShopInfo as workShopInfo where 1=1 "; 			
		    String condition = "";
		    
		    if(workShopID_s!=null && !workShopID_s.trim().equals("")){
				condition += " and workShopInfo.workShopID_s like '%"+workShopID_s+"%'";
		    }
		
		    if(workShopName_s!=null && !workShopName_s.trim().equals("")){
		    	condition += " and workShopInfo.workShopName_s like '%"+workShopName_s+"%'";
		    }
		    if(type_s!=null && !type_s.trim().equals("")){
		    	condition += " and workShopInfo.type_s like '%"+type_s+"%'";
		    }
		    if(useInfos_s!=null && !useInfos_s.trim().equals("")){
		    	condition += " and workShopInfo.useInfos_s like '%"+useInfos_s+"%'";
		    }
			
		    Query query = session.createQuery(hql+condition);
		    if(query.iterate().hasNext()){
		    	n = (Long) query.iterate().next();
		    }
		    return n;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{			
			session.clear();
		}
	}

	public int OperationWorkShopInfo(List<WorkShopInfo> workShopInfo,
			int operation, Session session) throws Exception {
		Transaction tx = null;
		try{
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				WorkShopInfo wsi = new WorkShopInfo();
				if(workShopInfo!=null||workShopInfo.size()>0){
					for(int i=0;i<workShopInfo.size();i++){		
						if(workShopInfo.get(i).getWorkShopID_s()== null || workShopInfo.get(i).getWorkShopID_s().trim().equals(""))
						{
							wsi = workShopInfo.get(i);
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.GCBusiness, session);
							wsi.setWorkShopID_s(cpg);
							wsi.gettBasisWorkshopcost().setWorkshopidS(cpg);
							session.merge(wsi);
						}
						else
						{							
							wsi = workShopInfo.get(i);
							WorkShopInfo tmp = (WorkShopInfo)session.get(WorkShopInfo.class, wsi.getWorkShopID_s());
							workShopID_s = wsi.getWorkShopID_s();
							workShopName_s = wsi.getWorkShopName_s();
							useInfos_s = wsi.getUseInfos_s();
							remark_s = wsi.getRemark_s();
							createUser_s = wsi.getCreateUser_s();
							lastUpdateUser_s = wsi.getLastUpdateUser_s();
							type_s = wsi.getType_s();
							createDate_t = wsi.getCreateDate_t();
							lastUpdateDate_t = wsi.getLastUpdateDate_t();
							resaveds1_s = wsi.getResaveds1_s();
							resaveds2_s = wsi.getResaveds2_s();
							resaveds3_s = wsi.getResaveds3_s();
							resaveds4_s	 = wsi.getResaveds4_s();
							resaveds5_s = wsi.getResaveds5_s();
							isSubscribe_i = wsi.getIsSubscribe_i();
							ismonthSubscribe_i = wsi.getIsmonthSubscribe_i();
							isdaysubscribe_i = wsi.getIsdaysubscribe_i();
							beginningday_i = wsi.getBeginningday_i();
							
							if(ismonthSubscribe_i ==null){
								wsi.setIsmonthSubscribe_i(tmp.getIsmonthSubscribe_i());
							}
							if(isdaysubscribe_i ==null){
								wsi.setIsdaysubscribe_i(tmp.getIsdaysubscribe_i());
							}
							if(beginningday_i == null){
								wsi.setBeginningday_i(tmp.getBeginningday_i());
							}
							
							if(workShopID_s == null){
								wsi.setWorkShopID_s(tmp.getWorkShopID_s());
							}
							if(workShopName_s == null){
								wsi.setWorkShopName_s(tmp.getWorkShopName_s());
							}
							if(useInfos_s == null && useInfos_s.equals("")){
								wsi.setUseInfos_s(tmp.getUseInfos_s());
							}else{
								//String[] str = useInfos_s.split("vv");
								String ui ="";
								if(tmp.getUseInfos_s() != null && !tmp.getUseInfos_s().equals("")){
									ui=tmp.getUseInfos_s() +"vv" +useInfos_s;	
								}else{
									ui=useInfos_s;
								}
								wsi.setUseInfos_s(ui);
								/*if(!tmp.getUseInfos_s().trim().equals(""))
								{
									ui = tmp.getUseInfos_s();
								}
								
								if(str.length == 0){
									wsi.setUseInfos_s(tmp.getUseInfos_s());
								}else{
									for(int j = 0;j<str.length;j++){
										if(!str[j].trim().equals("")){
											if(!ui.trim().equals("")){
												ui = ui + "vv" +  str[j]; 
											}else{
												ui = ui + str[j];
											}
										}
									}
									
									if(!ui.trim().equals("")){
										wsi.setUseInfos_s(ui);
									}
								}*/
								
							}
							if(remark_s == null){
								wsi.setRemark_s(tmp.getRemark_s());
							}
							if(createUser_s == null){
								wsi.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s == null){
								wsi.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(type_s == null){
								wsi.setType_s(tmp.getType_s());
							}
							if(createDate_t == null){
								wsi.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(lastUpdateDate_t == null){
								wsi.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s == null){
								wsi.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s == null){
								wsi.setResaveds2_s(tmp.getResaveds2_s());
							}
							if(resaveds3_s == null){
								wsi.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s == null){
								wsi.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s == null){
								wsi.setResaveds5_s(tmp.getResaveds5_s());
							}
							if(isSubscribe_i == null){
								wsi.setIsSubscribe_i(tmp.getIsSubscribe_i());
							}
							session.merge(wsi);
						}
//						session.saveOrUpdate(wsi);
					}
				}
			}
			//删除
			if(operation==2){
				if(workShopInfo!=null&&workShopInfo.size()>0){
					for(int i=0;i<workShopInfo.size();i++){
						session.delete(workShopInfo.get(i));
					}
				}
			}
			return 1;
		}catch(Exception e){
			throw e;
		}finally{				
		    			 
		}	
	}


}
