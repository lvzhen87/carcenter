package com.freshen.basis.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.freshen.basis.service.SequenceDao;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.basis.Sequence;
import com.freshen.util.DBconn;
import com.freshen.util.DateUtil;

public class SequenceDaoImpl extends ClimsServiceBase implements SequenceDao{

	Connection conn;
	public String getSequencebyID(String business_s) {
		// TODO Auto-generated method stub		
		//����Ӧ����Ķ��󼯺�
		Sequence sequence = new Sequence();
		PreparedStatement ps = null;
		conn = DBconn.getConnection("1");
		Calendar calendar = Calendar.getInstance();
		String pkstr="";
		boolean  b = false; //�Ƿ��д������
		try{	
			 String sql = "select  seed_i,indexNumber_i,present_i,prefixion_s,business_s  from t_system_sequence   where  ";			 
			 sql = sql +" business_s='"+business_s+"'";
			 //System.out.println("sql1 = "+sql);
			 ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				b = true;				 
				//System.out.println("rs-="+rs.getString(1));
				sequence.setSeed_i(rs.getInt(1));
				sequence.setIndexNumber_i(rs.getInt(2));
				sequence.setPresent_i(rs.getInt(3));
				sequence.setPrefixion_s(rs.getString(4));
				sequence.setBusiness_s(business_s);
				if(calendar.get(Calendar.DAY_OF_MONTH)==1){
					pkstr = DateUtil.dateToString(calendar.getTime(),"yyyyMMdd")+sequence.getSeed_i();
					sql = "update t_system_sequence set indexNumber_i="+sequence.getSeed_i()+" where business_s='"+business_s+"'";
				}
				pkstr = DateUtil.dateToString(calendar.getTime(),"yyyyMMdd")+sequence.getIndexNumber_i();
				sql = "update t_system_sequence set indexNumber_i="+(sequence.getIndexNumber_i()+1) +" where business_s='"+business_s+"'";
				//System.out.println("sql2 = "+sql);
				ps.execute(sql);
            }else{
            	sql = "insert into t_system_sequence ( seed_i,indexNumber_i,present_i,prefixion_s,business_s)" +
            			"values('1000','1001','1000','"+business_s+"','"+business_s+"')";
            	//System.out.println("sql2 = "+sql);
				ps.execute(sql);
            }
			return pkstr;
		}catch (Exception ex) {
			//System.out.println(ex);
           ex.printStackTrace();
		}finally {
           if (ps != null) {
               try {
                   ps.close();
                   ps = null;
               } catch (SQLException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }
           }
           DBconn.closeConn(conn,"1");
       }
	   
       return pkstr;
	}
	 
	public  static void main(String[] s){
    	try {
    		String l = new SequenceDaoImpl().getSequencebyID("squ");
    		//System.out.println(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
