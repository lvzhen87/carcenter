package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IOtherChargeInfoService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.OtherChargeInfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class OtherChargeInfoServiceImpl extends ClimsServiceBase implements IOtherChargeInfoService {

	Integer id_i;
	Integer electricCharge_i;
	Integer administrativeFee_i;
	Integer telephoneBill_i;
	Integer artisanCharge_i;
	Date createDate_t;
	String createUser_s;
	String resaveds1_s;
	String resaveds2_s;
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s;
	
	Transaction tx = null;
	
	public List<OtherChargeInfo> getOtherChargeInfo(
			OtherChargeInfo otherChargeInfo, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
			RoadInfo roadInfomodel = new RoadInfo();
			List<OtherChargeInfo> list = new ArrayList<OtherChargeInfo>();
			Query query = session.createQuery("from OtherChargeInfo as otherChargeInfo ");
			if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
			list = query.list();
			return (ArrayList)list;
		}
		catch(Exception e){
			return null;
		}finally{				
    		session.clear();	 
		}	
	}

	public long getOtherChargeInfo(OtherChargeInfo otherChargeInfo)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int OperationOtherChargeInfo(ArrayList<OtherChargeInfo> otherChargeInfo,
			Integer operation) throws Exception {
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
				OtherChargeInfo gate = new OtherChargeInfo();
			
				if(otherChargeInfo!=null||otherChargeInfo.size()>0){
					for(int i=0;i<otherChargeInfo.size();i++){		
						
						OtherChargeInfo tmp = (OtherChargeInfo)session.get(OtherChargeInfo.class, otherChargeInfo.get(i).getId_i());
						
						id_i  = gate.getId_i();
						electricCharge_i = gate.getElectricCharge_i();
						administrativeFee_i = gate.getAdministrativeFee_i();
						telephoneBill_i = gate.getTelephoneBill_i();
						artisanCharge_i = gate.getArtisanCharge_i();
						createDate_t = gate.getCreateDate_t();
						createUser_s = gate.getCreateUser_s();
						resaveds1_s = gate.getResaveds1_s();
						resaveds2_s = gate.getResaveds2_s();
						resaveds3_s = gate.getResaveds3_s();
						resaveds4_s = gate.getResaveds4_s();
						resaveds5_s = gate.getResaveds5_s();
						if(electricCharge_i == null){
							gate.setElectricCharge_i(tmp.getElectricCharge_i());
						}
						if(administrativeFee_i == null){
							gate.setAdministrativeFee_i(tmp.getAdministrativeFee_i());
						}
						if(telephoneBill_i == null){
							gate.setTelephoneBill_i(tmp.getTelephoneBill_i());
						}
						if(artisanCharge_i==null){
							gate.setArtisanCharge_i(tmp.getArtisanCharge_i());
						}
						if(createDate_t == null){
							gate.setCreateDate_t(tmp.getCreateDate_t());
						}
						if(createUser_s == null){
							gate.setCreateUser_s(tmp.getCreateUser_s());
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
						session.saveOrUpdate(gate);
						
						session.flush();
					  //  session.clear();
					}
				}
			}
			//删除
			if(operation==2){
//				if(barrierGate!=null&&barrierGate.size()>0){
//					for(int i=0;i<barrierGate.size();i++){
//						session.delete(barrierGate.get(i));
//						session.flush();
//						session.clear();
//					}
//				}
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

	public int OperationOtherChargeInfoWithOutTrans(
			ArrayList<OtherChargeInfo> otherChargeInfo, Integer operation)
			throws Exception {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				OtherChargeInfo gate = new OtherChargeInfo();
			
				if(otherChargeInfo!=null||otherChargeInfo.size()>0){
					for(int i=0;i<otherChargeInfo.size();i++){		
						gate = otherChargeInfo.get(i);
						if(otherChargeInfo.get(i).getId_i() == null)
						{
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.QTFYBusiness, session);
							gate.setId_i(Integer.parseInt(cpg));
							session.saveOrUpdate(gate);
							tx.commit();
							return 1;
						}
						
						OtherChargeInfo tmp = (OtherChargeInfo)session.get(OtherChargeInfo.class, otherChargeInfo.get(i).getId_i());
						if(tmp == null){
							tx.commit();
							return 0;
						}
						id_i  = gate.getId_i();
						electricCharge_i = gate.getElectricCharge_i();
						administrativeFee_i = gate.getAdministrativeFee_i();
						telephoneBill_i = gate.getTelephoneBill_i();
						artisanCharge_i = gate.getArtisanCharge_i();
						createDate_t = gate.getCreateDate_t();
						createUser_s = gate.getCreateUser_s();
						resaveds1_s = gate.getResaveds1_s();
						resaveds2_s = gate.getResaveds2_s();
						resaveds3_s = gate.getResaveds3_s();
						resaveds4_s = gate.getResaveds4_s();
						resaveds5_s = gate.getResaveds5_s();
						if(electricCharge_i == null){
							gate.setElectricCharge_i(tmp.getElectricCharge_i());
						}
						if(administrativeFee_i == null){
							gate.setAdministrativeFee_i(tmp.getAdministrativeFee_i());
						}
						if(telephoneBill_i == null){
							gate.setTelephoneBill_i(tmp.getTelephoneBill_i());
						}
						if(artisanCharge_i==null){
							gate.setArtisanCharge_i(tmp.getArtisanCharge_i());
						}
						if(createDate_t == null){
							gate.setCreateDate_t(tmp.getCreateDate_t());
						}
						if(createUser_s == null){
							gate.setCreateUser_s(tmp.getCreateUser_s());
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
						session.merge(gate);
						
					}
				}
			}
			//删除
			if(operation==2){
//				if(barrierGate!=null&&barrierGate.size()>0){
//					for(int i=0;i<barrierGate.size();i++){
//						session.delete(barrierGate.get(i));
//						session.flush();
//						session.clear();
//					}
//				}
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

}
