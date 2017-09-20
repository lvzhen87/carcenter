package com.freshen.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.SequenceDao;
import com.freshen.basis.service.impl.SequenceDaoImpl;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;



public class ExceptionDispose {

	/**
	 * ����ӿ��쳣��Ϣ
	   
	 * saveExceptionInfo 
	 * @param   classInfo_s     ����
	 * 			functionName_s  ������
	 *   		ex ������Ϣ
	 * @param  @return    �趨�ļ�    
	 * @return String    
	 * @Exception �쳣����    
	 * @since  CodingExample��Ver(���뷶��鿴) 1.1
	 * String classInfo_s,String functionName_s,
	 */
	private static Connection conn;
	public static void saveExceptionInfo(Exception ex,String classname,String funcationName){
		StackTraceElement[] traceElements = ex.getStackTrace();
		StringBuffer exInfo = new StringBuffer();
		exInfo.append("ex===================="+ex.getLocalizedMessage());
		IsystemSequenceService sequenceDaoImpl = new SystemSequenceServiceImpl();
		for (int i = 0; i < traceElements.length; i++) {			 
			exInfo.append("method " + traceElements[i].getMethodName());
			exInfo.append("(" + traceElements[i].getClassName() + ":");        
			exInfo.append(traceElements[i].getLineNumber() + ")"+"\n\t");      
		}
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Transaction tx ;
		tx = session.beginTransaction();
		String s = exInfo.toString().substring(0,3000);
		String squpk = sequenceDaoImpl.getPK("insquex", session) ;
		String sql = "insert into t_interface_exceptionLog (eventNumber_s,createTime_t,exceptionInfo_s,resaveds1_s,resaveds2_s) values" +
				"('"+squpk+"',sysdate,'"+s+"','"+classname+"','"+funcationName+"')";
		conn  = HibernateUtil.getconnBysession(session);
		//System.out.println("oracle="+conn);
		PreparedStatement prest = null;
		try{			 
			Statement stat = conn.createStatement();
			stat.execute(sql);
			tx.commit();
		}catch (Exception e) {
            ex.printStackTrace();   
            tx.rollback();
		}finally {
           if (prest != null) {                
        	   try {
				prest.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
           session.clear();
       }
	}
	
	public static void saveEStringInfo(String s){
		IsystemSequenceService sequenceDaoImpl = new SystemSequenceServiceImpl();
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Transaction tx ;
		tx = session.beginTransaction();
		String squpk = sequenceDaoImpl.getPK("insquex", session) ;
		String sql = "insert into t_interface_exceptionLog (eventNumber_s,createTime_t,exceptionInfo_s) values" +
		"('"+squpk+"',sysdate,'"+s+"')";
		conn  = HibernateUtil.getconnBysession(session);
		System.out.println("sqleeee="+sql);
		PreparedStatement prest = null;
		try{			 
			Statement stat = conn.createStatement();
			stat.execute(sql);
			tx.commit();
		}catch (Exception e) {
		    e.printStackTrace();   
		    tx.rollback();
		}finally {
		   if (prest != null) {                
			   try {
				prest.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   session.clear();
		}
	}
	public static void saveExceptionInfo(Exception ex){
		StackTraceElement[] traceElements = ex.getStackTrace();
		StringBuffer exInfo = new StringBuffer();
		exInfo.append("ex===================="+ex.getLocalizedMessage());
		IsystemSequenceService sequenceDaoImpl = new SystemSequenceServiceImpl();
		
		for (int i = 0; i < traceElements.length; i++) {			 
			exInfo.append("method " + traceElements[i].getMethodName());
			exInfo.append("(" + traceElements[i].getClassName() + ":");        
			exInfo.append(traceElements[i].getLineNumber() + ")"+"\n\t");      
		}
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		Transaction tx ;
		tx = session.beginTransaction();
		String eStr = exInfo.toString();
		String s = "";
		String s1 = ""; 
		String s2 = "";
		if(eStr.length()>3000){
			s = exInfo.toString().substring(0,3000);
			if(exInfo.length()<6000){
				s1 = exInfo.toString().substring(3000,exInfo.length()-1);
			}else{
				s1 = exInfo.toString().substring(3000,6000);
				s2 = exInfo.toString().substring(6000,exInfo.length()-1);
			}
		}else{
			s = exInfo.toString().substring(0,eStr.length());
		}
		
		 
//		if(exInfo.length()<6000){
//			s1 = exInfo.toString().substring(3099,exInfo.length()-1);
//		}else{
//			s1 = exInfo.toString().substring(3099,6099);
//			s2 = exInfo.toString().substring(6099,exInfo.length()-1);
//		}
		String squpk = sequenceDaoImpl.getPK("insquex", session) ;
		String sql = "insert into t_interface_exceptionLog (eventNumber_s,createTime_t,exceptionInfo_s,RESAVEDS1_S,RESAVEDS2_S) values" +
				"('"+squpk+"',sysdate,'"+s+"','"+s1+"','"+s2+"')";
		conn  = HibernateUtil.getconnBysession(session);
		System.out.println("sqleeee="+sql);
		PreparedStatement prest = null;
		try{			 
			Statement stat = conn.createStatement();
			stat.execute(sql);
			tx.commit();
		}catch (Exception e) {
            e.printStackTrace();   
            tx.rollback();
		}finally {
           if (prest != null) {                
        	   try {
				prest.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
           session.clear();
       }
	}
}
