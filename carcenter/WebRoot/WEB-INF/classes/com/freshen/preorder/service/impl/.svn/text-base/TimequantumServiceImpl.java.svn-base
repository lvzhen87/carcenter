package com.freshen.preorder.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.freshen.clims.baseclass.ClimsException;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.OrderSharingRoad;
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.preorder.service.ITimequantumService;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class TimequantumServiceImpl extends ClimsServiceBase implements ITimequantumService{

	Session session = HibernateUtil.getSession();
	/**
	 * 精确预订， 获得指定日期，指定道路24小时段的可预约数量
	 * getTimequantum 
	 * @param   startdate_t  指定日期
	 * 	    	roadid_s 指定道路
	 * @param  @return    设定文件    		
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<Map<String,Integer>> getTimequantum(Date startdate_t,String roadid_s) throws Exception{
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		
		try{
			int maxcapacity_i = 0; 
			String startdate_s = DateUtil.getDate(startdate_t, "yyyy-MM-dd");
			conn = HibernateUtil.getJDBCconn();
			stat = conn.createStatement();
			String sql="select  t2.roadid_s,t1.startdate_t,t1.timequantum_s,t1.carnumber_i," +
					"t2.maxcapacity_i,t2.maxcapacity_i-t1.carnumber_i allownumber " +
					"from (" +
					"select roadid_s,startdate_t,timequantum_s,sum(t.carnumber_i) carnumber_i " +
					"from t_subscribe_orderPreRoad t " +
					"where to_char(startdate_t,'yyyy-MM-dd')='"+startdate_s+"' " +
					"group by t.roadid_s,t.startdate_t,t.timequantum_s) t1," +
					"t_basis_roadInfo t2 " +
					"where  " +
					"t2.roadid_s='"+roadid_s+"' " +
					"and t1.roadid_s(+) = t2.roadid_s";
			rs = stat.executeQuery(sql);			
			Map<String,Integer>map = new HashMap<String,Integer>();//<小时段，可用数量>	
			while(rs.next()){
				maxcapacity_i = rs.getInt("maxcapacity_i");
				String timequantum_s = rs.getString("timequantum_s");
				if(timequantum_s!=null){
					map.put(timequantum_s, rs.getInt("allownumber"));
				}
			}
			//查询是否在预订规则内以及是否有包场，有的话可预订数为0
			sql = "select * from table (split ((select timequantum_s from t_basis_timeRule b), 'vv')) " +
			      "union " +
			      "select s.timequantum_s from t_subscribe_orderWholeRoad s where s.roadid_s='"+roadid_s+"' and to_char(startdate_t,'yyyy-MM-dd')='"+startdate_s+"'";
			rs = stat.executeQuery(sql);
			while(rs.next()){
				map.put(rs.getString(1),0);
			}
			//循环出24小时段每段的可以数量
			for(int i=0;i<24;i++){
				Integer timequantum_s = map.get(i+1+"");
				if(timequantum_s!=null&&!("null").equals(timequantum_s)){
					Map<String,Integer>tmpmap = new HashMap<String,Integer>();
					tmpmap.put("01", timequantum_s);
					list.add(i,tmpmap);
				}else{
					Map<String,Integer>tmpmap = new HashMap<String,Integer>();
					tmpmap.put("01", maxcapacity_i);
					list.add(i,tmpmap);
				}
			}
			return list;
		}catch(Exception e){
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			HibernateUtil.closeJDBC(conn);
		}
	}
	
	/**
	 * 预约的共享道路是否可通过	   
	 * isPassBySharingRoad 
	 * @param   orderSharingRoads :共享预订集合    
	 * @param  @return    1:表示通过，其他非通过
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isPassBySharingRoad(List<OrderSharingRoad> orderSharingRoads)throws Exception{
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;		
		if(orderSharingRoads==null || orderSharingRoads.size()<1)
			return 1;
		
		try{
			conn = HibernateUtil.getJDBCconn();
			stat = conn.createStatement();
			for(OrderSharingRoad tmp:orderSharingRoads){
				//是否被包场
				String sql = "select getincludeTime(to_char(startdate_t,'yyyy-MM-dd'),to_number(timeQuantum_s),to_date('"+DateUtil.getDate(tmp.getStartDate_t(), "yyyy-MM-dd HH:mm:ss")+"','yyyy-mm-dd hh24:mi:ss'),to_date('"+DateUtil.getDate(tmp.getEndDate_t(), "yyyy-MM-dd HH:mm:ss")+"','yyyy-mm-dd hh24:mi:ss')) from t_subscribe_orderWholeRoad  where roadid_s = '"+tmp.getRoadID_s()+"' ";
				rs = stat.executeQuery(sql);
				while(rs.next()){
					int request = rs.getInt(1);
					if(request>0){
						throw new ClimsException("开始时间："+tmp.getStartDate_t()+",结束时间："+tmp.getEndDate_t()+",道路:"+tmp.getRoadID_s()+"的共享预订与包场预订冲突，请修改该共享预订，谢谢");
					}
				}
			}
			return 1;
		}catch(Exception e){
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block					
					e.printStackTrace();
					throw e;
				}
			}
			HibernateUtil.closeJDBC(conn);
		}
	}
	
	/**
	 * 预约的预付费道路是否可通过
	 * isPassBySharingRoad 
	 * @param   orderPreRoads :预付费道路预订集合    
	 * @param  @return    1:表示通过，其他非通过
	 * @return String
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isPassByPrepaymentRoad(List<OrderPreRoad> orderPreRoads)throws Exception{
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;		
		if(orderPreRoads==null || orderPreRoads.size()<1)
			return 1;
		
		try{
			conn = HibernateUtil.getJDBCconn();
			stat = conn.createStatement();
			for(OrderPreRoad tmp:orderPreRoads){
				//1、与包场是否冲突
				String sql = "select * from t_subscribe_orderWholeRoad  where  roadid_s='"+tmp.getRoadID_s()+"' and timeQuantum_s='"+tmp.getTimeQuantum_s()+"'";
				rs = stat.executeQuery(sql);
				while(rs.next()){
					throw new ClimsException("开始时间："+tmp.getStartDate_t()+",时间段："+tmp.getTimeQuantum_s()+",道路:"+tmp.getRoadID_s()+",的精确预订与包场预订冲突，请修改该共享预订，谢谢");
				}
				//2、是否超过了最大车辆数
				List<Map<String,Integer>> list = getTimequantum(tmp.getStartDate_t(),tmp.getRoadID_s());
				int carc = list.get(Integer.valueOf(tmp.getTimeQuantum_s())-1).get("01")-tmp.getCarNumber_i();
				if(carc<0){
					throw new ClimsException("开始时间："+tmp.getStartDate_t()+",时间段："+tmp.getTimeQuantum_s()+",道路:"+tmp.getRoadID_s()+",的精确预订车辆数目过大，目前只能预订"+list.get(Integer.valueOf(tmp.getTimeQuantum_s())-1).get("01")+"辆,"+"请修改该共享预订，谢谢");
				}
			}
			return 1;
		}catch(Exception e){
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block					
					e.printStackTrace();
					throw e;
				}
			}
			HibernateUtil.closeJDBC(conn);
		}
	}
	
	/**
	 * 预约的 包场道路是否可通过
	 * isPassBySharingRoad 
	 * @param   orderWholeRoads :包场预订集合    
	 * @param  @return    1:表示通过，其他非通过
	 * @return String
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isPassByWholeRoad(List<OrderWholeRoad> orderWholeRoads)throws Exception{
		ResultSet rs = null;
		Statement stat = null;
		Connection conn = null;	
		if(orderWholeRoads==null || orderWholeRoads.size()<1)
			return 1;
		try{
			conn = HibernateUtil.getJDBCconn();
			stat = conn.createStatement();
			for(OrderWholeRoad tmp:orderWholeRoads){
				//1、与预付费或包场是否冲突
				String sql = "select count(1) from t_subscribe_orderPreRoad t,t_subscribe_orderWholeRoad t1 where (t.roadid_s='"+tmp.getRoadID_s()+"' and t.timequantum_s='"+tmp.getTimeQuantum_s()+"') or (t1.roadid_s='"+tmp.getRoadID_s()+"' and t1.timequantum_s='"+tmp.getTimeQuantum_s()+"')";
				rs = stat.executeQuery(sql);
				while(rs.next()){
					int request = rs.getInt(1);
					if(request>0){
						throw new ClimsException("时间："+tmp.getStartDate_t()+",时间段："+tmp.getTimeQuantum_s()+",道路："+tmp.getRoadID_s()+"的包场预订与其他预订冲突，请修改该包场预订，谢谢");
					}
				}
				//2、共享道路是否预订
				sql = "select sum(getincludeTime(to_char(to_date('"+DateUtil.getDate(tmp.getStartDate_t(), "yyyy-MM-dd")+"','yyyy-MM-dd'),'yyyy-MM-dd'),to_number('"+tmp.getTimeQuantum_s()+"'),s.startdate_t,s.enddate_t)) from t_subscribe_orderSharingRoad s where roadid_s = '"+tmp.getRoadID_s()+"'";
				rs = stat.executeQuery(sql);
				while(rs.next()){
					int request = rs.getInt(1);
					if(request>0){
						throw new ClimsException("时间："+tmp.getStartDate_t()+",时间段："+tmp.getTimeQuantum_s()+",道路："+tmp.getRoadID_s()+"的包场预订与其他预订冲突，请修改该包场预订，谢谢");
					}
				}
			}
			return 1;
		}catch(Exception e){
			throw e;
		}finally{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block					
					e.printStackTrace();
					throw e;
				}
			}
			HibernateUtil.closeJDBC(conn);
		}
	}
	
	/**
	 * 该车间是否在指定日期是否可预订
	 * isSubscribeWorkShop 
	 * @param   orderWorkShops 车间预订对象
	 *           
	 * @param  @return    1 可以预订
	 * @return throws ClimsException
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int isSubscribeWorkShop(List<OrderWorkShop> orderWorkShops)throws Exception{
		IorderWorkShopService impl = new OrderWorkShopServiceImpl();
		for(OrderWorkShop tmp:orderWorkShops){
			List<OrderWorkShop> l = impl.getBasisWorkShopByDate(tmp, ConstantUtil.pagingNot, 0);
			if(l.size()>0&&!BasicTools.isnotNull(l)){
				tmp = l.get(0);
				throw new ClimsException(tmp.getWorkShopName_s()+"已经预约，请重新选定时间，谢谢");
			}
		}
		return 1;
	}
	public static void main(String[] a){
		TimequantumServiceImpl TimequantumServiceImpl = new TimequantumServiceImpl();
		try {
			String d = "2014-08-06";
			Date date = DateUtil.getDate(d, "yyyy-MM-dd");
			List list = TimequantumServiceImpl.getTimequantum(date, "R008");
			//System.out.println(list);
			//System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
