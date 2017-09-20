package com.freshen.basis.service.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.TBasisRoadweekstatusinfo;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.HibernateUtil;

/**
 	* A data access object (DAO) providing persistence and search support for TBasisRoadweekstatusinfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.freshen.hbm.basis.TBasisRoadweekstatusinfo
  * @author MyEclipse Persistence Tools 
 */

public class TBasisRoadweekstatusinfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TBasisRoadweekstatusinfoDAO.class);
		//property constants
	public static final String WEEKSTATUS_S = "weekstatusS";
	public static final String CREATEUSER_S = "createuserS";
	public static final String LASTUPDATEUSER_S = "lastupdateuserS";
	public static final String RESAVEDS1_S = "resaveds1S";
	public static final String RESAVEDS2_S = "resaveds2S";
	public static final String RESAVEDS3_S = "resaveds3S";
	public static final String RESAVEDS4_S = "resaveds4S";
	public static final String RESAVEDS5_S = "resaveds5S";



    
    public void save(TBasisRoadweekstatusinfo transientInstance) {
        log.debug("saving TBasisRoadweekstatusinfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TBasisRoadweekstatusinfo persistentInstance) {
        log.debug("deleting TBasisRoadweekstatusinfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TBasisRoadweekstatusinfo findById( java.lang.String id) {
        log.debug("getting TBasisRoadweekstatusinfo instance with id: " + id);
        try {
            TBasisRoadweekstatusinfo instance = (TBasisRoadweekstatusinfo) getSession()
                    .get("com.freshen.hbm.basis.TBasisRoadweekstatusinfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TBasisRoadweekstatusinfo instance) {
        log.debug("finding TBasisRoadweekstatusinfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.freshen.hbm.basis.TBasisRoadweekstatusinfo")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding TBasisRoadweekstatusinfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TBasisRoadweekstatusinfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByWeekstatusS(Object weekstatusS
	) {
		return findByProperty(WEEKSTATUS_S, weekstatusS
		);
	}
	
	public List findByCreateuserS(Object createuserS
	) {
		return findByProperty(CREATEUSER_S, createuserS
		);
	}
	
	public List findByLastupdateuserS(Object lastupdateuserS
	) {
		return findByProperty(LASTUPDATEUSER_S, lastupdateuserS
		);
	}
	
	public List findByResaveds1S(Object resaveds1S
	) {
		return findByProperty(RESAVEDS1_S, resaveds1S
		);
	}
	
	public List findByResaveds2S(Object resaveds2S
	) {
		return findByProperty(RESAVEDS2_S, resaveds2S
		);
	}
	
	public List findByResaveds3S(Object resaveds3S
	) {
		return findByProperty(RESAVEDS3_S, resaveds3S
		);
	}
	
	public List findByResaveds4S(Object resaveds4S
	) {
		return findByProperty(RESAVEDS4_S, resaveds4S
		);
	}
	
	public List findByResaveds5S(Object resaveds5S
	) {
		return findByProperty(RESAVEDS5_S, resaveds5S
		);
	}
	

	public List findAll() {
		log.debug("finding all TBasisRoadweekstatusinfo instances");
		try {
			String queryString = "from TBasisRoadweekstatusinfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TBasisRoadweekstatusinfo merge(TBasisRoadweekstatusinfo detachedInstance) {
        log.debug("merging TBasisRoadweekstatusinfo instance");
        try {
            TBasisRoadweekstatusinfo result = (TBasisRoadweekstatusinfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TBasisRoadweekstatusinfo instance) {
        log.debug("attaching dirty TBasisRoadweekstatusinfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TBasisRoadweekstatusinfo instance) {
        log.debug("attaching clean TBasisRoadweekstatusinfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
/*
	public int OperationBasisBarrierGateInfo(List<TBasisRoadweekstatusinfo> roadweekstatus,
			int operation) throws Exception {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Session session= HibernateUtil.getSession();
		try{			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//寮�惎浜嬪姟
			//鏂板
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				BarrierGate gate = new BarrierGate();
				//鑾峰緱閬撹矾淇℃伅
				IroadInfoService roadInfoServiceImpl = new RoadInfoServiceImpl();
				RoadInfo roadInfotmp = new RoadInfo();
				boolean b1 = false; //娌℃湁淇敼鍏ュ彛閬撹矾
				boolean b2 = false; //娌℃湁淇敼鍑哄彛閬撹矾
				if(roadweekstatus!=null||roadweekstatus.size()>0){
					for(int i=0;i<roadweekstatus.size();i++){								 
						TBasisRoadweekstatusinfo tmp = (TBasisRoadweekstatusinfo)session.get(TBasisRoadweekstatusinfo.class, roadweekstatus.get(i).getRoadidS());
						WEEKSTATUS_S = tmp.getWeekstatusS();
						CREATEUSER_S = tmp.getCreateuserS();
						LASTUPDATEUSER_S = tmp.getLastupdateuserS()
						RESAVEDS1_S = tmp.getResaveds1S();
						RESAVEDS2_S = tmp.getResaveds2S();
						RESAVEDS3_S = tmp.getResaveds3S();
						RESAVEDS4_S = tmp.getResaveds4S();
						RESAVEDS5_S = tmp.getResaveds5S();

							gate = barrierGate.get(i);
							gateID_s = gate.getGateID_s();
							gateType_s = gate.getGateType_s();
							//gateCompany_s = gate.getGateCompany_s();
//							roadID_s = gate.getRoadID_s();
							state_i = gate.getState_i();
							createDate_t = gate.getCreateDate_t();
							createUser_s = gate.getCreateUser_s();
							lastUpdateUser_s =gate.getLastUpdateUser_s();
							lastUpdateDate_t = gate.getLastUpdateDate_t();
							resaveds1_s = gate.getResaveds1_s();
							resaveds2_s = gate.getResaveds2_s();
							resaveds3_s = gate.getResaveds3_s();
							resaveds4_s = gate.getResaveds4_s();
							resaveds5_s = gate.getResaveds5_s();
							entranceRoadID_s=gate.getEntranceRoadIDs();
							outRoadID_s=gate.getOutRoadID_s();
							gateNumber_s = gate.getGateNumber_s();
							outroadinfo = gate.getOutroadinfo();
							enterroadinfo = gate.getEnterroadinfo();
							
							if(outroadinfo==null)
							{
								gate.setOutroadinfo(outroadinfo);
							}
							if(enterroadinfo==null){
								gate.setEnterroadinfo(enterroadinfo);
							}
							if(gateNumber_s == null){
								gate.setGateNumber_s(tmp.getGateNumber_s());
							}
							if(gateID_s == null){
								gate.setGateID_s(tmp.getGateID_s());
							}
							if(gateType_s == null){
								gate.setGateType_s(tmp.getGateType_s());
							}
//							if(gateCompany_s==null){
//								gate.setGateCompany_s(tmp.getGateCompany_s());
//							}
//							if(roadID_s == null){
//								gate.setRoadID_s(tmp.getRoadID_s());
//							}
							if(entranceRoadID_s == null){
								gate.getEnterroadinfo().setRoadID_s(tmp.getEntranceRoadIDs());
								b1 = true;
							}else{
								roadInfotmp = new RoadInfo();
								roadInfotmp.setRoadID_s(entranceRoadID_s);
								roadInfotmp = roadInfoServiceImpl.getRoadInfo(roadInfotmp).get(0);
								gate.setEnterroadinfo(roadInfotmp);
							}
							if(outRoadID_s == null){
								gate.setOutRoadID_s(tmp.getOutRoadID_s());
								b2 = true;
							}else{
								roadInfotmp = new RoadInfo();
								roadInfotmp.setRoadID_s(outRoadID_s);
								roadInfotmp = roadInfoServiceImpl.getRoadInfo(roadInfotmp).get(0);
								gate.setOutroadinfo(roadInfotmp);
							}
							if(state_i==null){
								gate.setState_i(tmp.getState_i());
							}
							if(createDate_t == null){
								gate.setCreateDate_t(tmp.getCreateDate_t());
							}
							if(createUser_s == null){
								gate.setCreateUser_s(tmp.getCreateUser_s());
							}
							if(lastUpdateUser_s==null){
								gate.setLastUpdateUser_s(tmp.getLastUpdateUser_s());
							}
							if(lastUpdateDate_t==null){
								gate.setLastUpdateDate_t(tmp.getLastUpdateDate_t());
							}
							if(resaveds1_s==null){
								gate.setResaveds1_s(tmp.getResaveds1_s());
							}
							if(resaveds2_s==null){
								gate.setResaveds2_s(tmp.getResaveds3_s());
							}
							if(resaveds3_s==null){
								gate.setResaveds3_s(tmp.getResaveds3_s());
							}
							if(resaveds4_s==null){
								gate.setResaveds4_s(tmp.getResaveds4_s());
							}
							if(resaveds5_s==null){
								gate.setResaveds5_s(tmp.getResaveds5_s());
							}
//							if(!b1||!b2){
//								BarrierGate barrierGatetmp = this.getBasisBarrierGateInfo(gate, 0, 1).get(0);
//								if(!b1){
//									gate.setEnterroadinfo(barrierGatetmp.getEnterroadinfo());
//								}
//								if(!b2){
//									gate.setOutroadinfo(barrierGatetmp.getOutroadinfo());
//								}
//							}
							session.saveOrUpdate(gate);
							
						}
						session.flush();
					  //  session.clear();
					}
				}
			}
			//鍒犻櫎
			if(operation==2){
				if(barrierGate!=null&&barrierGate.size()>0){
					for(int i=0;i<barrierGate.size();i++){
						session.delete(barrierGate.get(i));
						session.flush();
						session.clear();
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
	}*/
}