package com.freshen.barrierGate.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.freshen.barrierGate.service.InorOutinfoBakDao;
import com.freshen.barrierGate.service.InorOutinfoDao;
import com.freshen.entity.barrierGate.InorOutinfoModel;
import com.freshen.util.DBconn;
import com.freshen.util.DataResource;

public class InorOutinfoDaoImpl implements InorOutinfoDao{

		//Connection conn;
		 
		/**
		 * 得到中间表试验车辆出入道闸信息
		 * getInorOutinList 
		 * @param   name    
		 * @param  @return    设定文件    
		 * @return String    
		 * @Exception 异常对象    
		 */

		public List<InorOutinfoModel> getInorOutinList(InorOutinfoModel inorOutinfoModel) throws Exception{
			//返回应处理的对象集合
			List<InorOutinfoModel> requestlist = new ArrayList();
			//需要清理中间表数据的ID
			List<String> disposeList = new ArrayList(); 
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = DataResource.getConnect("0");
			boolean  b = false; //是否有待处理数据
			Statement statement = null;
			try{	
				 statement = conn.createStatement();
				 String sql = "delete T_BarrierGate_InorOutinfo WHERE barrierGateID_s = 1 or barrierGateID_s =2";
				 statement.executeUpdate(sql);
				 conn.commit();
				 sql = "select  eventNumber_s,cardID_s,barrierGateID_s,CONVERT(varchar(20) , createTime_t, 120 ),motion_s,CONVERT(varchar(20) , editFlagTime_t, 120 ),id " +
				 			  " from T_BarrierGate_InorOutinfo " +
				 			  " where 1= 1 and isTreatment_i='0' ";			 
				 sql = sql + " order by  createTime_t ";
				 //System.out.println("sql = "+sql);
				 ps = conn.prepareStatement(sql);
				 rs = ps.executeQuery();
				 while (rs.next()) {
					 b = true;
					 inorOutinfoModel = new InorOutinfoModel();
					 //System.out.println("rs-="+rs.getString(1));
					 inorOutinfoModel.setEventNumber_s(rs.getString(1));
					 inorOutinfoModel.setCordID_s(rs.getString(2));
					 inorOutinfoModel.setBarrierGateID_s(rs.getString(3));
					 inorOutinfoModel.setCreateTime_s(rs.getString(4));
					 inorOutinfoModel.setMotion_s(rs.getString(5));
					 inorOutinfoModel.setEditFlagTime_s(rs.getString(6));
					 inorOutinfoModel.setId(rs.getString(7));
					 //System.out.println(rs.getString(6));
					 //System.out.println(inorOutinfoModel.getEditFlagTime_s());
					 requestlist.add(inorOutinfoModel);
					 disposeList.add(inorOutinfoModel.getEventNumber_s());
	            }			
				 
				//2、保存到oracle备份表中
			    InorOutinfoBakDao inorOutinfoBakDao = new InorOutinfoBakDaoImpl();
			    inorOutinfoBakDao.saveInorOutinBakList(requestlist);
				if(b) disposeMiddle(disposeList,1);
			}catch (Exception ex) {
				ex.printStackTrace();
			    throw ex;
	           
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
	          // DBconn.setInUsed();
	           if(conn!=null){
		           conn.close();
		           conn=null;
	           }
	       }
	       return requestlist;
		}
		
		
		public int disposeMiddle(List<String> list,int type)  throws Exception{
			// TODO Auto-generated method stub
			//conn = DBconn.getConnection("sql");
			
			Connection conn = DataResource.getConnect("0");
			
			Statement statement = null;
			try{	
				statement = conn.createStatement();
				String sql = "update T_BarrierGate_InorOutinfo set isTreatment_i='1' where ";
				String condition = "";
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						if(i==0){
							condition = condition+" eventNumber_s in('"+list.get(i)+"'";
						}else{
							condition = condition+",'"+list.get(i)+"'";
						}
						if(i==list.size()-1){
							condition = condition+")";
						}
					}
					
					statement.executeUpdate(sql+condition);
					conn.commit();
				}else{
					return 0;
				}
			}catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
	            
			}finally {
	           if (statement != null) {
	               try {
	            	   statement.close();
	            	   statement = null;
	               } catch (SQLException e) {
	                   // TODO Auto-generated catch block
	                   e.printStackTrace();
	               }
	           }
	           conn.close();
	           conn=null;
	       }
		   
	       return 1;
		}

		public  static void main(String[] s){
	    	try {
	    		List<InorOutinfoModel> l = new InorOutinfoDaoImpl().getInorOutinList(null);
	//System.out.println(l.size());    		 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } 

}
