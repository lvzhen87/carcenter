package com.freshen.barrierGate.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.barrierGate.service.BarrierGateInorOutinfoService;
import com.freshen.barrierGate.service.VBarrierGateInorOutinfoService;
import com.freshen.entity.barrierGate.BarrierGateInorOutinfo;
import com.freshen.entity.barrierGate.VBarriergateInoroutinfo;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DBconn;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class VBarrierGateInorOutinfoServiceImpl extends ClimsServiceBase implements
	VBarrierGateInorOutinfoService {

	private String cardidS;
	private String barriergateidS;
	private String createtimeS;
	private String motionS;
	private int isokI;
	private String eventnumberS;
	private String editflagtimeS;
	private String editflagEndtimeS;
	private String roadidS;
	private String roadtypeS;
	private String roadnameS;
	private String orderidS;
	private String ordernameS;
	private String customernameS;
 	private String resaveds3_s;
	private String resaveds4_s;
	
	Transaction tx = null;
	/**
	 * 
	 * @param orderid :道路id
	 * @param overtime :超时时间
	 * @return
	 * @throws Exception
	 */
	public ArrayList<VBarriergateInoroutinfo> getOvertimeinfo(
			String orderid,String overtime)
			throws Exception {
		Connection conn = HibernateUtil.getJDBCconn();
		//System.out.println("oracle="+conn);
		PreparedStatement prest = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<VBarriergateInoroutinfo> list = new ArrayList();
		try {
			conn.setAutoCommit(false);
			String sql = "select * from ("
						+" select t3.orderid_s,case                                            "   
						+"         when t3.ordername_s is null then                                      "
						+"          '公卡'                                                               "
						+"         else                                                                  "
						+"          t3.ordername_s                                                       "
						+"       end ordername_s,                                                        "
						+"       t4.customername_s,                                                      "
						+"       t2.resaveds3_s,                                                         "
						+"       t2.editflagtime_s,                                                      "
						+"      round((sysdate-to_date(editflagtime_s,'yyyy-MM-dd  HH24:mi:ss')) *24*60) mini, "
						+"       t6.roadname_s                                                      "
						+"  from (select cardid_s, max(createtime_s) m                                   "
						+"          from t_barriergate_inoroutinfo_bak t                                 "
						+"         group by cardid_s) t1,t_basis_barriergate t5,t_basis_roadinfo t6,                                                "
						+"       t_barriergate_inoroutinfo_bak t2                                        "
						+"  left join t_subscribe_order t3 on t2.resaveds2_s = t3.orderid_s              "
						+"  left join t_subscribe_customer t4 on t3.customerid_s = t4.customerid_s       "
						+" where t1.cardid_s = t2.cardid_s                                               "
						+"   and t1.m = t2.createtime_s                                                  "
						+"   and t2.motion_s = 1  " 
						+" and t2.barriergateid_s = t5.gatenumber_s"
						+" and t5.entranceroadid_s = t6.roadid_s                                                       ";
					//	+"   and t2.createtime_s > to_char(sysdate, 'yyyy-MM-dd')                        ";
			String sql1 =" and t2.barriergateid_s in "
						+"       (select b.gatenumber_s                                                  "
						+"          from t_basis_barriergate b                                           "
						+"         where b.entranceroadid_s = '"+orderid+"'                             "
						+"           and b.resaveds1_s = '1')" ;
			if(orderid==null||orderid.equals("")||orderid.equals("-1")){
				sql1 = "";
			}
			sql = sql + sql1 +") where mini>"+overtime;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				VBarriergateInoroutinfo tmp = new VBarriergateInoroutinfo();
				tmp.setOrderidS(rs.getString(1));
				tmp.setOrdernameS(rs.getString(2));
				tmp.setCustomernameS(rs.getString(3));
				tmp.setResaveds3_s(rs.getString(4));
				tmp.setEditflagEndtimeS(rs.getString(5));
				tmp.setResaveds4_s(rs.getString(6));
				tmp.setRoadnameS(rs.getString(7));
				list.add(tmp);
			}		 
			return list;			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally{
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
	           conn.close();
	           conn = null;
		}
	}
	
	public ArrayList<VBarriergateInoroutinfo> getBarrierGateInorOutinfo(
			VBarriergateInoroutinfo barrierGateInorOutinfo, int start, int size)
			throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		ArrayList<VBarriergateInoroutinfo> list = new ArrayList();
		try {
			if(barrierGateInorOutinfo == null)
			{
				Query query = session.createQuery(" from VBarriergateInoroutinfo as barrierGateInorOutinfo");
				list = (ArrayList)query.list();
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
			 
				return list;
			}
			this.setPro(barrierGateInorOutinfo);
			String hql = "  from VBarriergateInoroutinfo as barrierGateInorOutinfo where 1=1 ";
			String condition = " ";
			if(barrierGateInorOutinfo.getOrderidS() != null && !barrierGateInorOutinfo.getOrderidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.orderidS like '%" + barrierGateInorOutinfo.getOrderidS().trim() + "%'";
		    }
			if(barrierGateInorOutinfo.getCardidS() != null && !barrierGateInorOutinfo.getCardidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.cardidS like '%" + barrierGateInorOutinfo.getCardidS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getBarriergateidS() != null && !barrierGateInorOutinfo.getBarriergateidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.barriergateidS like '%" + barrierGateInorOutinfo.getBarriergateidS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getCreatetimeS() != null){
		    	condition = condition + " and barrierGateInorOutinfo.createtimeS <= '"+barrierGateInorOutinfo.getCreatetimeS()+"'";
		    }
		    
		    if(barrierGateInorOutinfo.getMotionS() != null){
		    	condition = condition + " and barrierGateInorOutinfo.motionS like '%" + barrierGateInorOutinfo.getMotionS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getIsokI() != null && barrierGateInorOutinfo.getIsokI() != 0){
		    	condition = condition + " and barrierGateInorOutinfo.isokI ='" + barrierGateInorOutinfo.getIsokI() + "'";
		    }
		    if(barrierGateInorOutinfo.getEventnumberS() != null&& !barrierGateInorOutinfo.getEventnumberS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.eventnumberS ='" + barrierGateInorOutinfo.getEventnumberS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getEditflagtimeS() != null&& !barrierGateInorOutinfo.getEditflagtimeS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.editflagtimeS >='" + barrierGateInorOutinfo.getEditflagtimeS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getEditflagEndtimeS() != null&& !barrierGateInorOutinfo.getEditflagEndtimeS().trim().equals("")){
		    	Date d = DateUtil.getDate(barrierGateInorOutinfo.getEditflagEndtimeS().trim());
		    	Calendar cal = Calendar.getInstance();
		    	cal.setTime(d);
		    	cal.add(Calendar.DATE, 1);
		    	d = cal.getTime();
		    	condition = condition + " and barrierGateInorOutinfo.editflagtimeS <='" + DateUtil.dateToString(d,"yyyy-MM-dd") + "'";
		    }
		    if(barrierGateInorOutinfo.getRoadidS() != null&& !barrierGateInorOutinfo.getRoadidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.roadidS ='" + barrierGateInorOutinfo.getRoadidS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getRoadtypeS() != null && !barrierGateInorOutinfo.getRoadtypeS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.roadtypeS = '" + barrierGateInorOutinfo.getRoadtypeS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getRoadnameS() != null && !barrierGateInorOutinfo.getRoadnameS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.roadnameS like '%" + barrierGateInorOutinfo.getRoadnameS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getOrdernameS() != null && !barrierGateInorOutinfo.getOrdernameS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.ordernameS like '%" + barrierGateInorOutinfo.getOrdernameS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getCustomernameS() != null && !barrierGateInorOutinfo.getCustomernameS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.customernameS like '%" + barrierGateInorOutinfo.getCustomernameS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getResaveds3_s() != null && !barrierGateInorOutinfo.getResaveds3_s().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.resaveds3_s like '%" + barrierGateInorOutinfo.getResaveds3_s().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getResaveds4_s() != null && !barrierGateInorOutinfo.getResaveds4_s().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.resaveds4_s = '" + barrierGateInorOutinfo.getResaveds4_s().trim() + "'";
		    }
		    Query query = session.createQuery(hql + condition+" order by barrierGateInorOutinfo.editflagtimeS desc ");
			
			if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
			list = (ArrayList)query.list();
			 
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally{
			session.clear();
		}
	}

	public long getVBarrierGateInorOutinfo(
			VBarriergateInoroutinfo barrierGateInorOutinfo) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		ArrayList<BarrierGateInorOutinfo> list = new ArrayList();
		long n = 0;
		try {
			if(barrierGateInorOutinfo == null)
			{
				Query query = session.createQuery("select count(*) from from VBarriergateInoroutinfo as barrierGateInorOutinfo");
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			} 
			
			String hql = " select count(*) from VBarriergateInoroutinfo as barrierGateInorOutinfo where 1=1 ";
			String condition = " ";
			if(barrierGateInorOutinfo.getCardidS() != null && !barrierGateInorOutinfo.getCardidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.cardidS like '%" + barrierGateInorOutinfo.getCardidS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getBarriergateidS() != null && !barrierGateInorOutinfo.getBarriergateidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.barriergateidS like '%" + barrierGateInorOutinfo.getBarriergateidS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getCreatetimeS() != null){
		    	condition = condition + " and barrierGateInorOutinfo.createtimeS <= '"+barrierGateInorOutinfo.getCreatetimeS()+"'";
		    }
		    
		    if(barrierGateInorOutinfo.getMotionS() != null){
		    	condition = condition + " and barrierGateInorOutinfo.motionS like '%" + barrierGateInorOutinfo.getMotionS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getIsokI() != null && barrierGateInorOutinfo.getIsokI() != 0){
		    	condition = condition + " and barrierGateInorOutinfo.isokI ='" + barrierGateInorOutinfo.getIsokI() + "'";
		    }
		    if(barrierGateInorOutinfo.getEventnumberS() != null&& !barrierGateInorOutinfo.getEventnumberS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.eventnumberS ='" + barrierGateInorOutinfo.getEventnumberS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getEditflagtimeS() != null&& !barrierGateInorOutinfo.getEditflagtimeS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.editflagtimeS >='" + barrierGateInorOutinfo.getEditflagtimeS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getEditflagEndtimeS() != null&& !barrierGateInorOutinfo.getEditflagEndtimeS().trim().equals("")){
		    	Date d = DateUtil.getDate(barrierGateInorOutinfo.getEditflagEndtimeS().trim());
		    	Calendar cal = Calendar.getInstance();
		    	cal.setTime(d);
		    	cal.add(Calendar.DATE, 1);
		    	d = cal.getTime();
		    	condition = condition + " and barrierGateInorOutinfo.editflagtimeS <='" + DateUtil.dateToString(d,"yyyy-MM-dd") + "'";
		    }
		    if(barrierGateInorOutinfo.getRoadidS() != null&& !barrierGateInorOutinfo.getRoadidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.roadidS ='" + barrierGateInorOutinfo.getRoadidS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getRoadtypeS() != null && !barrierGateInorOutinfo.getRoadtypeS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.roadtypeS = '" + barrierGateInorOutinfo.getRoadtypeS().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getRoadnameS() != null && !barrierGateInorOutinfo.getRoadnameS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.roadnameS like '%" + barrierGateInorOutinfo.getRoadnameS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getOrdernameS() != null && !barrierGateInorOutinfo.getOrdernameS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.ordernameS like '%" + barrierGateInorOutinfo.getOrdernameS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getCustomernameS() != null && !barrierGateInorOutinfo.getCustomernameS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.customernameS like '%" + barrierGateInorOutinfo.getCustomernameS().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getResaveds3_s() != null && !barrierGateInorOutinfo.getResaveds3_s().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.resaveds3_s like '%" + barrierGateInorOutinfo.getResaveds3_s().trim() + "%'";
		    }
		    if(barrierGateInorOutinfo.getResaveds4_s() != null && !barrierGateInorOutinfo.getResaveds4_s().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.resaveds4_s = '" + barrierGateInorOutinfo.getResaveds4_s().trim() + "'";
		    }
		    if(barrierGateInorOutinfo.getOrderidS() != null && !barrierGateInorOutinfo.getOrderidS().trim().equals("")){
		    	condition = condition + " and barrierGateInorOutinfo.orderidS = '" + barrierGateInorOutinfo.getOrderidS().trim() + "'";
		    }
		    Query query = session.createQuery(hql + condition);
			list = (ArrayList)query.list();
			if(query.iterate().hasNext()){
				n = (Long)query.iterate().next();
			}
			return n;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally{
			session.clear();
		}
	}
  
	/**
	 * 设定属性值	   
	 * setPro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setPro(VBarriergateInoroutinfo tmp){
		this.cardidS = tmp.getCardidS();
		this.barriergateidS = tmp.getBarriergateidS();
		this.createtimeS = tmp.getCreatetimeS();
		this.motionS = tmp.getMotionS();
		//this.isokI = tmp.getIsokI();
		this.eventnumberS = tmp.getEventnumberS();
		this.editflagtimeS = tmp.getEditflagtimeS();
		this.editflagEndtimeS = tmp.getEditflagEndtimeS();		
		this.roadidS = tmp.getRoadidS();
		this.roadtypeS = tmp.getRoadtypeS();
		this.roadnameS = tmp.getRoadnameS();
		this.orderidS = tmp.getOrderidS();
		this.ordernameS = tmp.getOrdernameS();
		this.customernameS = tmp.getCustomernameS();
		this.resaveds3_s = tmp.getResaveds3_s();
		this.resaveds4_s = tmp.getResaveds4_s();
	}
	public static void main(String[] args) throws Exception {
		VBarrierGateInorOutinfoServiceImpl bg = new VBarrierGateInorOutinfoServiceImpl();
		VBarriergateInoroutinfo b = new VBarriergateInoroutinfo();
	//	b.setResaveds2_s("1");
		ArrayList<VBarriergateInoroutinfo> list = new ArrayList<VBarriergateInoroutinfo>();
		list = bg.getBarrierGateInorOutinfo(b, ConstantUtil.pagingNot, 0);
		//System.out.println(list.get(1).getCustomernameS());
	}
}
