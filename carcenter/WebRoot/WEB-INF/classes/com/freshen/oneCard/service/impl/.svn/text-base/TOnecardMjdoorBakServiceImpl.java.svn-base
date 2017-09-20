package com.freshen.oneCard.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.impl.SessionImpl;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.Sequence;
import com.freshen.entity.oneCard.TOnecardMjdoorBak;
import com.freshen.entity.process.Station;
import com.freshen.oneCard.service.ITOnecardMjdoorBakService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DBconn;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.BeanModel;
import com.freshen.clims.baseclass.ClimsServiceBase;

public class TOnecardMjdoorBakServiceImpl extends ClimsServiceBase implements ITOnecardMjdoorBakService{

	Session session = HibernateUtil.getSession();
	Transaction tx = null;
	private Integer doorIdI;
	private String doorNameS;
	private Integer devicesysidI;
	private Integer channelnumI;
	private Integer isUse_i;
	private String isGroup_s;
	private String groupId_s;
	/**
	 * 获得房门信息
	 * getTOnecardMjdoorBak 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public   List<TOnecardMjdoorBak> getTOnecardMjdoorBak(TOnecardMjdoorBak tOnecardMjdoorBak) throws Exception{
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		
		try {
			List<TOnecardMjdoorBak> list = new ArrayList();
			
			if(!TOnecardMjdoorBak.isnotNull(tOnecardMjdoorBak)){
				Query query=session.createQuery("from TOnecardMjdoorBak as tOnecardMjdoorBak order by tOnecardMjdoorBak.isGroup_s");			 
			    list = query.list();
				return (ArrayList) list;
			}
			setPro(tOnecardMjdoorBak);
			String hql = " from TOnecardMjdoorBak as tOnecardMjdoorBak where 1=1 ";
		    String condition = "";
		    
		    if(doorIdI != null)
		    {
		    	condition += " and tOnecardMjdoorBak.doorIdI = '" + doorIdI + "'";
		    }
		    if(doorNameS != null && !doorNameS.trim().equals(""))
		    {
		    	condition += " and tOnecardMjdoorBak.doorNameS like '%" + doorNameS.trim() + "%'";
		    }
		    if(devicesysidI != null)
		    {
		    	condition += " and tOnecardMjdoorBak.devicesysidI = '" + devicesysidI + "'";
		    }
		    if(isUse_i !=null){
		    	condition += " and tOnecardMjdoorBak.isUse_i ="+isUse_i;
		    }
		    if(groupId_s !=null){
		    	condition += "and tOnecardMjdoorBak.groupId_s ='"+groupId_s+"'";
		    }
		    if(isGroup_s !=null){
		    	condition += "and tOnecardMjdoorBak.isGroup_s ='"+isGroup_s+"'";
		    }
		    condition += " order by tOnecardMjdoorBak.groupId_s";
		    Query query=session.createQuery(hql+condition);
		    list = query.list();	  			
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.clear();
		}
	}
	
	
	private void setPro(TOnecardMjdoorBak tOnecardMjdoorBak){
		this.channelnumI = tOnecardMjdoorBak.getChannelnumI();
		this.devicesysidI = tOnecardMjdoorBak.getDevicesysidI();
		this.doorIdI = tOnecardMjdoorBak.getDoorIdI();
		this.doorNameS = tOnecardMjdoorBak.getDoorNameS();
		this.isUse_i=tOnecardMjdoorBak.getIsUse_i();
		this.groupId_s = tOnecardMjdoorBak.getGroupId_s();
	//	this.isGroup_s=tOnecardMjdoorBak.getIsGroup_s();
	}
	
	/**
	 * 获得人卡房门表/输出通道 信息
	 * getMjDoorInfo 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public List<TOnecardMjdoorBak> getMjDoorInfo() throws Exception{
		Connection conn = DBconn.getConnection(ConstantUtil.OneCardSERVERCONN);
		List<TOnecardMjdoorBak> list = new ArrayList();
		PreparedStatement ps = null;
		try{				 
			 String sql = "select  Door_id,Door_name,DeviceSysid,ChannelNum  from Mj_door  ";			 
			 
			 //System.out.println("sql1 = "+sql);
			 ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				TOnecardMjdoorBak tmp = new TOnecardMjdoorBak();
				tmp.setDoorIdI(rs.getInt(1));
				tmp.setDoorNameS(rs.getString(2));
				tmp.setDevicesysidI(rs.getInt(3));
				tmp.setChannelnumI(rs.getInt(4));
				tmp.setIsUse_i(1);
				list.add(tmp);
           }
		   return list;
		}catch (Exception ex) {
			//System.out.println(ex);
			ex.printStackTrace();
			throw ex;
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
          DBconn.closeConn(conn,ConstantUtil.OneCardSERVERCONN);
		}
	}
	
	public int OperationTOnecardMjdoorBak(List<TOnecardMjdoorBak> tOnecardMjdoorBaks )
	throws Exception {
		// TODO Auto-generated method stub
		 
		String msgid = null;
		try{
		 
			//删除
			String hql = "delete TOnecardMjdoorBak tOnecardMjdoorBak";
			Query q=sessionImpl.createQuery(hql);
			q.executeUpdate();
			//新增 
			if(tOnecardMjdoorBaks!=null||tOnecardMjdoorBaks.size()>0){
				for(TOnecardMjdoorBak tmp:tOnecardMjdoorBaks){
					sessionImpl.saveOrUpdate(tmp);
				}
			}
			return 1;
		}catch(Exception e){
			throw e;
		}finally{				
		    			 
		}	
	}
	
	public int OperationTOnecardMjdoorBak1(List<TOnecardMjdoorBak> tOnecardMjdoorBaks )
	throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		String delid = null;
		tx=session.beginTransaction();//开启事务
		try{

			if(tOnecardMjdoorBaks!=null||tOnecardMjdoorBaks.size()>0){
				for(int i=0;i<tOnecardMjdoorBaks.size();i++){
					TOnecardMjdoorBak tmp = tOnecardMjdoorBaks.get(i);
					TOnecardMjdoorBak tmp1 = new TOnecardMjdoorBak();
					tmp1.setDoorIdI(tmp.getDoorIdI());
					List<TOnecardMjdoorBak> tmpList = this.getTOnecardMjdoorBak(tmp1);
					//目前系统已有该房门
					if(BasicTools.isnotNull(tmpList)&&tmpList.size()>0){
						tmp1 = tmpList.get(0);
						tmp1.setChannelnumI(tmp.getChannelnumI());
						tmp1.setDevicesysidI(tmp.getDevicesysidI());
						tmp1.setDoorNameS(tmp.getDoorNameS());
						session.update(tmp1);
					}else{
						session.save(tmp);
					}
					if(i==0){
						delid = "(";
					}
					delid = delid+"'"+tmp.getDoorIdI()+"'";
					if(i<tOnecardMjdoorBaks.size()-1){
						delid = delid+",";
					}else{
						delid = delid+")";
					}
				}
			}
			
			//删除
			String hql = "delete TOnecardMjdoorBak tOnecardMjdoorBak where tOnecardMjdoorBak.doorIdI not in "+delid;
			Query q=session.createQuery(hql);
			q.executeUpdate();
			 
			session.flush();
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
		    			 
		}	
	}
	public int ChangeDoorIsUse(ArrayList<TOnecardMjdoorBak> tOnecardMjdoorBaks )
	throws Exception {
		Transaction tx = null;
		try{
			Session session= HibernateUtil.getSession();
			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
		// TODO Auto-generated method stub
			if(tOnecardMjdoorBaks != null && tOnecardMjdoorBaks.size()>0){
				for (int i = 0; i < tOnecardMjdoorBaks.size(); i++) {
					TOnecardMjdoorBak tb=(TOnecardMjdoorBak) session.get(TOnecardMjdoorBak.class, tOnecardMjdoorBaks.get(i).getDoorIdI());
					if(tOnecardMjdoorBaks.get(i).getDoorIdI() != null && tOnecardMjdoorBaks.get(i).getDoorIdI().toString().length()>0){
						tb.setDoorIdI(tOnecardMjdoorBaks.get(i).getDoorIdI());
					}
				/*	if(tOnecardMjdoorBaks.get(i).getIsGroup_s() != null){
						if(tOnecardMjdoorBaks.get(i).getIsGroup_s().equals("NA")){
							tb.setGroupId_s("");
						}
						else{
							tb.setGroupId_s(tOnecardMjdoorBaks.get(i).getIsGroup_s());
						}
						
					}*/
					if(tOnecardMjdoorBaks.get(i).getGroupId_s() != null){
						if(tOnecardMjdoorBaks.get(i).getGroupId_s().equals("NA")){
							tb.setGroupId_s("");
						}
						else{
							tb.setGroupId_s(tOnecardMjdoorBaks.get(i).getGroupId_s());
						}
						
					}
					if(tOnecardMjdoorBaks.get(i).getIsUse_i() != null){
						tb.setIsUse_i(tOnecardMjdoorBaks.get(i).getIsUse_i());
					}
					
					session.merge(tb);
					
				}
				
				session.flush();
//				sessionImpl.clear();
			}
			
			tx.commit();
			session.clear();
			return 1;
		}catch(Exception e){
			tx.rollback();
			session.clear();
			throw e;
		}finally{				
		    			 
		}	
	}
	
	
	
	public   List<TOnecardMjdoorBak> getTOnecardMjdoorBak(TOnecardMjdoorBak tOnecardMjdoorBak, int start, int size) throws Exception{
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		
		try {
			List<TOnecardMjdoorBak> list = new ArrayList();
			
			if(!TOnecardMjdoorBak.isnotNull(tOnecardMjdoorBak)){
				Query query=session.createQuery("from TOnecardMjdoorBak as tOnecardMjdoorBak");		
				if(start != ConstantUtil.pagingNot)
				{
					query.setFirstResult(start);
					query.setMaxResults(size);
				}
				list = query.list();
				return (ArrayList)list;
			}
			setPro(tOnecardMjdoorBak);
			String hql = " from TOnecardMjdoorBak as tOnecardMjdoorBak where 1=1 ";
		    String condition = "";
		    
		    if(doorIdI != null)
		    {
		    	condition += " and tOnecardMjdoorBak.doorIdI = '" + doorIdI + "'";
		    }
		    if(doorNameS != null && !doorNameS.trim().equals(""))
		    {
		    	condition += " and tOnecardMjdoorBak.doorNameS like '%" + doorNameS.trim() + "%'";
		    }
		    if(devicesysidI != null)
		    {
		    	condition += " and tOnecardMjdoorBak.devicesysidI = '" + devicesysidI + "'";
		    }
		    if(isUse_i !=null){
		    	condition += " and tOnecardMjdoorBak.isUse_i ="+isUse_i;
		    }
		    if(isGroup_s !=null){
		    	condition += "and tOnecardMjdoorBak.isGroup_s ='%"+isGroup_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(start != ConstantUtil.pagingNot)
			{
				query.setFirstResult(start);
				query.setMaxResults(size);
			}
		    list = query.list();	  			
			return (ArrayList) list;
		    
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			session.clear();
		}
	}

	
	public  Long getTOnecardMjdoorBakNumber(TOnecardMjdoorBak tOnecardMjdoorBak) throws Exception{
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			if(!TOnecardMjdoorBak.isnotNull(tOnecardMjdoorBak)){
				Query query=session.createQuery("select count(*) from TOnecardMjdoorBak as tOnecardMjdoorBak");			 
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				return n;
			}
			setPro(tOnecardMjdoorBak);
			String hql = "select count(*) from TOnecardMjdoorBak as tOnecardMjdoorBak where 1=1 ";
		    String condition = "";
		    
		    if(doorIdI != null)
		    {
		    	condition += " and tOnecardMjdoorBak.doorIdI = '" + doorIdI + "'";
		    }
		    if(doorNameS != null && !doorNameS.trim().equals(""))
		    {
		    	condition += " and tOnecardMjdoorBak.doorNameS like '%" + doorNameS.trim() + "%'";
		    }
		    if(devicesysidI != null)
		    {
		    	condition += " and tOnecardMjdoorBak.devicesysidI = '" + devicesysidI + "'";
		    }
		    if(isUse_i !=null){
		    	condition += " and tOnecardMjdoorBak.isUse_i ="+isUse_i;
		    }
		    if(isGroup_s !=null){
		    	condition += "and tOnecardMjdoorBak.isGroup_s ='%"+isGroup_s+"%'";
		    }
		    Query query=session.createQuery(hql+condition);
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

	
	/**
	 * 同步房门信息	   
	 * synchronMjdoor 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int synchronMjdoor()throws Exception{
		//获得立方房门信息
		List<TOnecardMjdoorBak> tOnecardMjdoorBaks = getMjDoorInfo();
		//保存房门信息
		return OperationTOnecardMjdoorBak1(tOnecardMjdoorBaks);
	}
	
	public static void main(String[] a){
		TOnecardMjdoorBakServiceImpl t = new TOnecardMjdoorBakServiceImpl();
		try {
			t.synchronMjdoor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
