package com.freshen.basis.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.freshen.basis.service.IBarrierGateService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class BarrierGateServiceImpl extends ClimsServiceBase implements IBarrierGateService {

	//String gateID_s, gateType_s, gateCompany_s, roadID_s;
	String gateID_s, gateType_s, roadID_s;
	Integer state_i;
	Date createDate_t;
	String createUser_s, lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String  entranceRoadID_s,outRoadID_s;
	RoadInfo enterroadinfo = new RoadInfo();
	RoadInfo outroadinfo = new RoadInfo();
	String gateNumber_s;
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public ArrayList<BarrierGate> getBasisBarrierGateInfo(
			BarrierGate barrierGate, int start, int size) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		try{
			return getBasisBarrierGateInfoByTx( barrierGate,  start,  size, session);
		}catch(Exception e){
			throw e;
		}
		finally{
			session.clear();
		}
	}

	/**
	 * 事务中查询
	 * @param barrierGate
	 * @param start
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BarrierGate> getBasisBarrierGateInfoByTx(
			BarrierGate barrierGate, int start, int size,Session session) throws Exception {
		// TODO Auto-generated method stub
		 
		try{
			IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
			RoadInfo roadInfomodel = new RoadInfo();
			List<BarrierGate> list = new ArrayList<BarrierGate>();
			if(barrierGate== null){
				Query query = session.createQuery("from BarrierGate as barrierGate ");
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			gateID_s = barrierGate.getGateID_s();
			gateType_s = barrierGate.getGateType_s();
			//gateCompany_s = barrierGate.getGateCompany_s();
			state_i = barrierGate.getState_i();
			createDate_t = barrierGate.getCreateDate_t();
			createUser_s = barrierGate.getCreateUser_s();
			lastUpdateUser_s =barrierGate.getLastUpdateUser_s();
			lastUpdateDate_t = barrierGate.getLastUpdateDate_t();
			resaveds1_s = barrierGate.getResaveds1_s();
			resaveds2_s = barrierGate.getResaveds2_s();
			resaveds3_s = barrierGate.getResaveds3_s();
			resaveds4_s = barrierGate.getResaveds4_s();
			resaveds5_s = barrierGate.getResaveds5_s();
			gateNumber_s = barrierGate.getGateNumber_s();
			entranceRoadID_s = barrierGate.getEntranceRoadIDs();
			outRoadID_s = barrierGate.getOutRoadID_s();
			String hql = " from BarrierGate as barrierGate where 1=1 ";
			String condition="";
			
			if(gateID_s != null && !gateID_s.trim().equals("")){
		    	condition = condition + " and barrierGate.gateID_s like '%" +  gateID_s.trim() + "%'";
		    	Query query = session.createQuery(hql+condition);
		    	list = query.list();
		    	return (ArrayList) list;
		    }
		    if(gateType_s != null && !gateType_s.trim().equals("")){
		    	condition = condition + " and barrierGate.gateType_s like '%" + gateType_s.trim() + "%'";
		    }
//		    if(gateCompany_s != null && !gateCompany_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.gateCompany_s like '%" + gateCompany_s.trim() + "%'";
//		    }
//		    if(roadID_s != null && !roadID_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.roadID_s like '%" + roadID_s.trim() + "%'";
//		    }
		    if(state_i != null && state_i != -1){
		    	condition = condition + " and barrierGate.state_i ='" + state_i+ "'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(barrierGate.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and barrierGate.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and barrierGate.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(barrierGate.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(gateNumber_s != null && !gateNumber_s.trim().equals("")){
		    	condition = condition + " and barrierGate.gateNumber_s like '%" + gateNumber_s.trim() + "%'";
		    }
		    if(entranceRoadID_s != null && !entranceRoadID_s.equals("-1")){		    	 
		    	condition = condition + " and barrierGate.enterroadinfo like '%" + entranceRoadID_s + "%'";
		    }
		    if(outRoadID_s != null && !outRoadID_s.trim().equals("")){
		    	condition = condition + " and barrierGate.outroadinfo like '%" + outRoadID_s.trim() + "%'";
		    }
		    condition = condition+" order by barrierGate.lastUpdateUser_s DESC ";
		    Query query = session.createQuery(hql+condition);
		    if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list= query.list();
//		    RoadInfo ri = new RoadInfo();
//		    if(list!=null&&list.size()>0){
//				for(int i=0;i<list.size();i++){
//					BarrierGate bg = new BarrierGate();
//					bg = list.get(i);
//					RoadInfo r = bg.getRoadinfo();
//					r.setRoadID_s(barrierGate.getRoadID_s());
//					bg.setRoadinfo(r);
//					list.set(i, bg);
//				}
//			}
		    
		    return (ArrayList)list;
		    
		}
		catch(Exception e){
			throw e;
		}
		finally{
			
		}
	}
	
	public long getBasisBasisBarrierGateInfoNumber(BarrierGate barrierGate)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try
		{
			IroadInfoService iroadInfoService = new RoadInfoServiceImpl();
			RoadInfo roadInfomodel = new RoadInfo();
			if(barrierGate==null){
				Query query = session.createQuery("select count(*) from BarrierGate");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			gateID_s = barrierGate.getGateID_s();
			gateType_s = barrierGate.getGateType_s();
			//gateCompany_s = barrierGate.getGateCompany_s();
//			roadID_s = barrierGate.getRoadID_s();
			state_i = barrierGate.getState_i();
			createDate_t = barrierGate.getCreateDate_t();
			createUser_s = barrierGate.getCreateUser_s();
			lastUpdateUser_s =barrierGate.getLastUpdateUser_s();
			lastUpdateDate_t = barrierGate.getLastUpdateDate_t();
			resaveds1_s = barrierGate.getResaveds1_s();
			resaveds2_s = barrierGate.getResaveds2_s();
			resaveds3_s = barrierGate.getResaveds3_s();
			resaveds4_s = barrierGate.getResaveds4_s();
			resaveds5_s = barrierGate.getResaveds5_s();
			gateNumber_s = barrierGate.getGateNumber_s();
			entranceRoadID_s = barrierGate.getEntranceRoadIDs();
			
			outRoadID_s = barrierGate.getOutRoadID_s();
			String hql = "select count(*)  from BarrierGate as barrierGate where 1=1 ";
			String condition="";
			
			if(gateID_s != null && !gateID_s.trim().equals("")){
		    	condition = " and barrierGate.gateID_s like '%" + gateID_s.trim() + "%'";
		    }
		    if(gateType_s != null && !gateType_s.trim().equals("")){
		    	condition = condition + " and barrierGate.gateType_s like '%" + gateType_s.trim() + "%'";
		    }
//		    if(gateCompany_s != null && !gateCompany_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.gateCompany_s like '%" + gateCompany_s.trim() + "%'";
//		    }
//		    if(roadID_s != null && !roadID_s.trim().equals("")){
//		    	condition = condition + " and barrierGate.roadID_s like '%" + roadID_s.trim() + "%'";
//		    }
		    if(state_i != null  && state_i != -1 ){
		    	condition = condition + " and barrierGate.state_i ='" + state_i + "'";
		    }
		    if(createDate_t != null){
		    	condition = condition+" and to_char(barrierGate.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s != null && !createUser_s.trim().equals("")){
		    	condition = condition + " and barrierGate.createUser_s like '%" + createUser_s.trim() + "%'";
		    }
		    if(lastUpdateUser_s != null && !lastUpdateUser_s.trim().equals("")){
		    	condition = condition + " and barrierGate.lastUpdateUser_s like '%" + lastUpdateUser_s.trim() + "%'";
		    }
		    if(lastUpdateDate_t != null){
		    	condition = condition+" and to_char(barrierGate.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(resaveds1_s != null && !resaveds1_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds1_s like '%" + resaveds1_s.trim() + "%'";
		    }
		    if(resaveds2_s != null && !resaveds2_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds2_s like '%" + resaveds2_s.trim() + "%'";
		    }
		    if(resaveds3_s != null && !resaveds3_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds3_s like '%" + resaveds3_s.trim() + "%'";
		    }
		    if(resaveds4_s != null && !resaveds4_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds4_s like '%" + resaveds4_s.trim() + "%'";
		    }
		    if(resaveds5_s != null && !resaveds5_s.trim().equals("")){
		    	condition = condition + " and barrierGate.resaveds5_s like '%" + resaveds5_s.trim() + "%'";
		    }
		    if(gateNumber_s != null && !gateNumber_s.trim().equals("")){
		    	condition = condition + " and barrierGate.gateNumber_s like '%" + gateNumber_s.trim() + "%'";
		    }
		    if(entranceRoadID_s != null && !entranceRoadID_s.equals("-1")){		    	 
		    	condition = condition + " and barrierGate.enterroadinfo like '%" + entranceRoadID_s + "%'";
		    }
		    if(outRoadID_s != null && !outRoadID_s.trim().equals("")){
		    	condition = condition + " and barrierGate.outroadinfo like '%" + outRoadID_s.trim() + "%'";
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

	public int OperationBasisBarrierGateInfo(List<BarrierGate> barrierGate,
			int operation) throws Exception {
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
				BarrierGate gate = new BarrierGate();
				//获得道路信息
				IroadInfoService roadInfoServiceImpl = new RoadInfoServiceImpl();
				RoadInfo roadInfotmp = new RoadInfo();
				boolean b1 = false; //没有修改入口道路
				boolean b2 = false; //没有修改出口道路
				if(barrierGate!=null||barrierGate.size()>0){
					for(int i=0;i<barrierGate.size();i++){		
						if(barrierGate.get(i).getGateID_s()== null || barrierGate.get(i).getGateID_s().trim().equals(""))
						{
							gate = barrierGate.get(i);
							
							entranceRoadID_s = gate.getEntranceRoadIDs();
							if(entranceRoadID_s == null){
								return 0;
							}else{
								roadInfotmp = new RoadInfo();
								roadInfotmp.setRoadID_s(entranceRoadID_s);
								roadInfotmp = roadInfoServiceImpl.getRoadInfo(roadInfotmp).get(0);
								gate.setEnterroadinfo(roadInfotmp);
							}
							outRoadID_s = gate.getOutRoadID_s();
							if(outRoadID_s == null){
								return 0;
							}else{
								roadInfotmp = new RoadInfo();
								roadInfotmp.setRoadID_s(outRoadID_s);
								roadInfotmp = roadInfoServiceImpl.getRoadInfo(roadInfotmp).get(0);
								gate.setOutroadinfo(roadInfotmp);
							}
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.DJBusiness, session);
							gate.setGateID_s(cpg);
							session.saveOrUpdate(gate);
						}
						else
						{
							BarrierGate tmp = (BarrierGate)session.get(BarrierGate.class, barrierGate.get(i).getGateID_s());
							
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
							/*outroadinfo = gate.getOutroadinfo();
							enterroadinfo = gate.getEnterroadinfo();
							
							if(outroadinfo==null)
							{
								gate.setOutroadinfo(outroadinfo);
							}
							if(enterroadinfo==null){
								gate.setEnterroadinfo(enterroadinfo);
							}*/
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
			//删除
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
	}
	
	/**
	 * 获得sqlserver道闸信息
	 * getBarrierGateModelList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<BarrierGate> getBarrierGateModelList() throws Exception {
		List<BarrierGate> list = 
			new ArrayList<BarrierGate>();
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = DataResource.getConnect("0");
		String GateId = "";
		boolean  b = false; //是否有待处理数据
		try{	
			 String sql = "SELECT ID,PassageWayID,Name,InOut,UsedFlag,editFlagTime_t,isTreatment_i "+
			 " from t_PassageWay   where  ";			 
			 sql = sql + " isTreatment_i='"+0+"'";
			 IsystemSequenceService sequenceDaoImpl = new SystemSequenceServiceImpl();
			 
//			 //System.out.println("sql = "+sql);
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while (rs.next()) {
				 BarrierGate tmp = new BarrierGate();
				 GateId = sequenceDaoImpl.getPK("DZ",session);
				 tmp.setGateNumber_s(rs.getString(1));
				 tmp.setState_i(rs.getInt(5));
				 tmp.setGateType_s(rs.getString(3));
				 tmp.setCreateUser_s("sys");
				 tmp.setGateID_s(GateId);
				 list.add(tmp);
            }
		}catch (Exception ex) {
			//System.out.println(ex);
           ex.printStackTrace();
		}finally {
			if(rs!=null){
	        	   rs.close();
	        	   rs=null;
		    }
            if (ps != null) {
                try {
                   ps.close();
                   ps = null;
                } catch (SQLException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
                }
            }           
            if(conn!=null){
	           conn.close();
	           conn=null;
            }
            session.clear();
       }
	   
       return list;
	}
	
	public int saveBarrierGateModel(List<BarrierGate> barrierGateModel)
	throws Exception {
		Connection conn = DataResource.getConnect("0");
		Connection connora = HibernateUtil.getJDBCconn();
		Statement st = connora.createStatement();
		ResultSet rs = null;
		PreparedStatement prest = null;
		PreparedStatement ps = null;
		conn.setAutoCommit(false); 
		String sqlora = "";
		try {
			//System.out.println("conn="+conn.getCatalog());
		 
			String sqlorl ="INSERT into t_basis_barrierGate "+
			"(gateID_s,gateNumber_s,gateType_s,state_i,createDate_t,createUser_s) values("+
			"?,?,?,?,?,?)";
			if(barrierGateModel!=null&&barrierGateModel.size()>0){
				for(int i=0;i<barrierGateModel.size();i++){
					BarrierGate tmp = barrierGateModel.get(i);
					prest = null;
					ps = null;
					//该道闸是否已存在
					sqlora = "select t.gatenumber_s from t_basis_barrierGate t where t.gatenumber_s='"+tmp.getGateNumber_s()+"'";
					rs = st.executeQuery(sqlora);  
					if(rs.next()){
						sqlora = "update t_basis_barrierGate set gateType_s='"+tmp.getGateType_s()+"',state_i='"+tmp.getState_i()+"' where gateNumber_s='"+tmp.getGateNumber_s()+"'";
						st.executeUpdate(sqlora);
					}else{
						prest = connora.prepareStatement(sqlorl,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  
						prest.setString(1, tmp.getGateID_s());
						prest.setString(2, tmp.getGateNumber_s());
						prest.setString(3, tmp.getGateType_s());		
						prest.setInt(4, tmp.getState_i());
						// Test2 wich Calendar
						Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间			
			            Timestamp ts = new Timestamp(dt.getTime());
						prest.setTimestamp(5,ts);
						prest.setString(6, tmp.getCreateUser_s());
						prest.addBatch();
						prest.executeBatch();  
					}
					String sql ="update t_PassageWay set isTreatment_i = 1 where ID="+tmp.getGateNumber_s();
					ps = conn.prepareStatement(sql);				
					ps.executeUpdate();
					connora.commit();
					conn.commit();
				}
			}else{
				return 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			conn.rollback();
			connora.rollback();
		    throw ex;
		}
		finally{
		   if (prest != null) {
			   prest.close();
		 	   prest = null;
		   } if (prest != null) {
			   ps.close();
		 	   ps = null;
		   }
		   connora.close();
		   connora = null;
		   conn.close();
		   conn = null;		 
		}
		return 0;
	}
	public static void main(String arg[]){
		BarrierGate barrierGate = new BarrierGate();
//		barrierGate.setRoadID_s("3213");
//		barrierGate.setResaveds1_s("3213");
//		barrierGate.setResaveds2_s("3213");
//		barrierGate.setResaveds3_s("3213");
//		barrierGate.setCreateUser_s("3213");
//		barrierGate.setCreateDate_t(new Date());

		barrierGate.setGateID_s("DJ2014051005");

		barrierGate.setGateID_s("DJ");

		barrierGate.setState_i(-1);
		List<BarrierGate> list = new ArrayList();
		IBarrierGateService ibs = new BarrierGateServiceImpl();
	//	list.add(barrierGate);
		try {
			list = ibs.getBarrierGateModelList();
			ibs.saveBarrierGateModel(list);
		    //System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
