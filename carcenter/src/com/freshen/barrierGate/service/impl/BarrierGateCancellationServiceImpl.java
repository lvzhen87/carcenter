package com.freshen.barrierGate.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.barrierGate.service.IbarrierGateCancellationService;
import com.freshen.entity.barrierGate.TBarriergateCancellationBak;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.clims.baseclass.ClimsServiceBase;

public class BarrierGateCancellationServiceImpl extends ClimsServiceBase implements IbarrierGateCancellationService{


	/**
	 * 保存车卡作废信息oracle	   
	 * OperationBarrierGateJurisdiction 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TBarriergateCancellationBak> OperationBarrierGateJurisdiction(
			List<TBarriergateCancellationBak> barrierGateJurisdicList, int operation,Session session)
			throws Exception {
		Transaction tx = null;
		List<TBarriergateCancellationBak> requesbarrierGateJurisdicList = 
			new ArrayList<TBarriergateCancellationBak>();
		String eventNumber_s = "";
		 
		try{
			if(barrierGateJurisdicList==null||barrierGateJurisdicList.size()==0){
				return null;
			}
			 
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				for(int i=0;i<barrierGateJurisdicList.size();i++){
					TBarriergateCancellationBak barrierGateJurisdic = barrierGateJurisdicList.get(i);					
					eventNumber_s = systemSequenceServiceImpl.getPK(ConstantUtil.CCBusiness, session);
					barrierGateJurisdic.setEventnumberS(eventNumber_s);			
					session.saveOrUpdate(barrierGateJurisdic);
					session.flush();
				   // session.clear();
				    requesbarrierGateJurisdicList.add(barrierGateJurisdic);
				}
			}
			//删除
			if(operation==2){
				for(int i=0;i<barrierGateJurisdicList.size();i++){
					TBarriergateCancellationBak barrierGateJurisdic = barrierGateJurisdicList.get(i);
					if(barrierGateJurisdic!=null){
						session.delete(barrierGateJurisdic);
						session.flush();
						//session.clear();
					}
				}
			}
		 
			return requesbarrierGateJurisdicList;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{				
			 
		}	
	}
	
	/**
	 * 作废卡片保存到sql server中
	 * CancellationCardSql
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int CancellationCardSql(List<TBarriergateCancellationBak> list) throws Exception{
		if(list==null||list.size()==0){
			return 0;
		}
		Connection sqlcon = DataResource.getConnect(ConstantUtil.BarrierSERVERCONN);
		PreparedStatement prest = null;
		try{
		//获得sql server连接
		sqlcon.setAutoCommit(false);  
		String sql = "INSERT into t_BarrierGate_CardCancellation(eventNumber_s,cardID_s,editFlagTime_t,isTreatment_i) " +
				"VALUES(?,?,?,?)";  
		prest = sqlcon.prepareStatement(sql);  
		for(int i=0;i<list.size();i++){
			TBarriergateCancellationBak tmp = list.get(i);
			prest.setString(1, tmp.getEventnumberS());
			prest.setString(2, tmp.getCardidS());
			prest.setTimestamp(3,new Timestamp(tmp.getEditflagtimeT().getTime()));
			prest.setInt(4, 0);
			prest.addBatch();   
		}
		prest.executeBatch();
 
		sqlcon.commit();  
		return 1;
		}catch (Exception e){
			sqlcon.rollback();
			throw new Exception(e);
		}finally{
			try { 
				if (prest != null) prest.close(); 
			}catch(Exception e) {throw new Exception(e);} 
			try { 
				if (sqlcon != null) sqlcon.close(); 
			}
			catch (Exception e){throw new Exception(e);}
		} 		
	}
	
	/**
	 * 作废卡片操作
	 * CancellationCard 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TBarriergateCancellationBak> CancellationCard(List<TBarriergateCancellationBak> list,Session session) throws Exception{
		try{
			return this.OperationBarrierGateJurisdiction(list, 1,session);
			
		}catch (Exception e){throw new Exception(e);}
		 
		
	}
}
