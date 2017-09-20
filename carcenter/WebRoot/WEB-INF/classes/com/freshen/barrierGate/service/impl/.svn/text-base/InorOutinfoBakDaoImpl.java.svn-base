package com.freshen.barrierGate.service.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.freshen.barrierGate.service.InorOutinfoBakDao;
import com.freshen.entity.barrierGate.InorOutinfoModel;
import com.freshen.util.DBconn;
import com.freshen.util.HibernateUtil;
 
public class InorOutinfoBakDaoImpl implements InorOutinfoBakDao{

	Connection conn;
	public int saveInorOutinBakList(
			List<InorOutinfoModel> list) throws Exception{
		//连接oracle
		//conn = DBconn.getConnection("orl");
		conn = HibernateUtil.getJDBCconn();
		//System.out.println("oracle="+conn);
		PreparedStatement prest = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn.setAutoCommit(false);
			String sql = "INSERT into t_Barriergate_Inoroutinfo_Bak" +
							"(eventNumber_s," +
							"cardID_s," +
							"barrierGateID_s," +
							"createTime_s," +
							"motion_s, " +
							"editFlagTime_s, " +
							"resaveds2_s,"+
							"resaveds3_s,"+
							"resaveds4_s) " +
							"VALUES(?,?,?,?,?,?,?,?,?)";  
			prest = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);  			 
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					InorOutinfoModel inorOutinfoModel = list.get(i);
					int r = getInorOut(inorOutinfoModel.getId());
					if(r==0){
						continue;
					}					
					prest.setString(1, inorOutinfoModel.getId());
					prest.setString(2, inorOutinfoModel.getCordID_s());
					prest.setString(3, inorOutinfoModel.getBarrierGateID_s());
					prest.setString(4, inorOutinfoModel.getCreateTime_s());
					prest.setString(5, inorOutinfoModel.getMotion_s());
					prest.setString(6, inorOutinfoModel.getEditFlagTime_s());
					String tsql = "select orderID_s,resaveds2_s,axleNumber_i from t_reception_vehicleInfo t  " +
					" where vehicleID_s='"+inorOutinfoModel.getCordID_s()+"' " +
					" and (t.orderID_s in (" +
					"	select orderID_s from t_reception_order " +
					"	where to_char(endDate_d,'YYYY-MM-DD') >= " +
					"		  to_char(to_date('"+inorOutinfoModel.getEditFlagTime_s()+"','yyyy-MM-dd HH24:mi:ss'),'YYYY-MM-DD')) or t.orderID_s='order01')";
		
					ps = conn.prepareStatement(tsql);
					rs = ps.executeQuery();
					if(rs.next()){
						prest.setString(7, rs.getString("orderID_s"));
						prest.setString(8, rs.getString("resaveds2_s"));
						prest.setString(9, rs.getString("axleNumber_i"));
					}else{
						prest.setString(7,"");
						prest.setString(8,"");
						prest.setString(9,"");
					}
					prest.addBatch();  
				}
				prest.executeBatch();  
				conn.commit();  
			}else{
				return 0;
			}
		}catch (Exception ex) {
			
            ex.printStackTrace();
            throw ex;
		}finally {
           if (prest != null) {                
        	   prest.close();           
           }
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
           DBconn.closeConn(conn,"orl");
       }	   
       return 1;
	}

	//是否已经添加了该过站记录
	public int getInorOut(String id)throws Exception{
		if(conn==null){
			conn = DBconn.getConnection("orl");
		}
		Statement st = null;
		ResultSet rs = null;
		try{
			st = conn.createStatement();
			String sql = "select 1 from t_Barriergate_Inoroutinfo_Bak where eventNumber_s='"+id+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				return 0;
			}
			return 1;
		}catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
		}finally {
		   if (rs != null) {                
        	   rs.close();           
           }
           if (st != null) {                
        	   st.close();           
           }
           DBconn.closeConn(conn,"orl");
       }
	} 
	 
	public  static void main(String[] s){
    	try {
    		InorOutinfoModel inorOutinfoModel = new InorOutinfoModel();
    		List list = new InorOutinfoDaoImpl().getInorOutinList(inorOutinfoModel);
    		int l = new InorOutinfoBakDaoImpl().saveInorOutinBakList(list);
    		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
