package com.freshen.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

import com.freshen.hibernate.HibernateSessionFactory;

public class HibernateUtil {

	//static Session session=null;
	public static Session getSession(){
		Session session = HibernateSessionFactory.getSession();
		return session;
	}
	
	/**
	 * 通过hibernate获得jdbc连接
	 * getJDBCconn 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static Connection getJDBCconn(){
		
		Connection conn = null;
		ConnectionProvider cp = null;
		
		Session session = getSession();
		if(session==null||!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}		
		return getconnBysession(session);
		  
	}
	
	/**
	 * 通过session获得conn对象
	 * getconnBysession 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static Connection getconnBysession(Session session){

		/*Connection conn = null;
		ConnectionProvider cp = null;
		 
		 
		cp = ((SessionFactoryImplementor)session.getSessionFactory()).getConnectionProvider();
		try {
			conn = cp.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//2014-11-21 kxc
		Connection conn = session.connection();
		return conn;
	}
	
	public static void closeJDBC(Connection conn){
		try{
			if(conn!=null){
				conn.close();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*private static SessionFactory factory;  
    
	   static{  
	           try{  
	            //读取hibernate.cfg.xml文件  
	            Configuration cfg=new Configuration().configure();  
	               
	            //建立SessionFactory  
	            factory=cfg.buildSessionFactory();  
	     
	           }catch(Exception e){  
	              e.printStackTrace();   
	           }  
	   }    
	     
	      //获得开启着的Session  
	   public static Session getSession(){  
	       return factory.openSession();  
	   }  
	     
	      //关闭Session  
	   public static void closeSession(Session session){  
	       if(session!=null){  
	           if(session.isOpen()){  
	               session.close();  
	           }  
	       }  
	   }  
	     
	   public static SessionFactory getSessionFactory(){  
	       return factory;  
	   }  
*/
	/*public static List Query(String hql){
		getSession();
		Query query=session.createQuery(hql);
	    List list = query.list();	    
	    session.close();
		return (ArrayList) list;
	}*/
	
	
}
