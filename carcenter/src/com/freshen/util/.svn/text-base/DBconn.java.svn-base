package com.freshen.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;



public class DBconn {
    private static Connection con=null;
    private static int inUsed=0;     //ʹ�õ�������
    
    private static ArrayList freeConnectionssql = new ArrayList();//sql��������������
    private static ArrayList freeConnectionsorl = new ArrayList();//oracle��������������
    
    private static int minConn;      //��С������
    private static int maxConn = 200;      //�������
    private static String name ;      //���ӳ�����
    private static String password = ""; //����
    private static String url="";       //��ݿ����ӵ�ַ
    private static String driver="";    //��
    private static String user ="";      //�û���
    public static Timer timer;       //��ʱ

    public static synchronized ArrayList getfreeConnections(String conIndex)
    {
    	if(conIndex.equals("1")){
    		return freeConnectionssql;
    	}else{
    		return freeConnectionsorl;
    	}
    	 
    }
    /**
       * �������ӳ�
       */
    public DBconn(int conIndex)
    {
       
    }
    /**
       * ���꣬�ͷ�����
       * @param con
       */
    public static synchronized void freeConnection(Connection con,String conIndex)
    {
       try{
           /*if(con!=null){
               con.close();
               con=null;
           }*/
    	   getfreeConnections(conIndex).add(con);//��ӵ��������ӵ�ĩβ
           inUsed--;
       }catch(Exception e){
            //System.out.println("  ee=" + e.getMessage());
       }
       
       ////System.out.println("�ͷţ�����"+inUsed+"��������ʹ��!");
    }
    /**
       * timeout   ���timeout�õ�����
       * @param timeout
       * @return
       */
    public static synchronized Connection getConnection(long timeout,String conIndex)
    {
       Connection con=null;
       if(getfreeConnections(conIndex).size()>0)
       {
        con=(Connection)getfreeConnections(conIndex).get(0);
        if(con==null)con=getConnection(timeout,conIndex); //����������
       }
       else
       {
        con=newConnection(conIndex); //�½�����
       }
       if(maxConn==0||maxConn<inUsed)
       {
        con=null;//�ﵽ�����������ʱ���ܻ�������ˡ�
       }
        
       return con;
    }
    /**
       *
       * �����ӳ���õ����ӣ�û�еĻ��½�����
       * @return
       */
    public static synchronized Connection getConnection(String conIndex)
    {
      
       if(getfreeConnections(conIndex).size()>0)
       {
         con=(Connection)getfreeConnections(conIndex).get(0);
         getfreeConnections(conIndex).remove(0);//������ӷ����ȥ�ˣ��ʹӿ���������ɾ��
         if(con==null)con=getConnection(conIndex); //����������        
       }
       else
       {
        con=newConnection(conIndex); //�½�����
       }
       if(maxConn==0||maxConn<inUsed)
       {
            con=null;//�ȴ� �����������ʱ
       }
       if(con!=null)
       {
        inUsed++;
        //System.out.println("�õ���"+conIndex+"�������ӣ�����"+inUsed+"��������ʹ��!");
       }
        try {
            if(con.isClosed()){
              con=getConnection(conIndex);
            }
            return con;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }
        return con;
    }
    /**
       *�ͷ�ȫ������
       *
       */
    public static synchronized void release()
    {
       Iterator allConns=getfreeConnections("sql").iterator();
       while(allConns.hasNext())
       {
        Connection con=(Connection)allConns.next();
        try
        {
         con.close();
         inUsed = 0;
        }
        catch(SQLException e)
        {
         e.printStackTrace();
        }
       }
        Iterator allConns1=getfreeConnections("orl").iterator();
        while(allConns1.hasNext())
        {
          con=(Connection)allConns1.next();
         try
         {
          con.close();
          inUsed = 0;
         }
         catch(SQLException e)
         {
          e.printStackTrace();
         }
       }
       freeConnectionssql.clear();
       freeConnectionsorl.clear();
    }
    /**
       * ����������
       * @return
       */
    private static Connection newConnection(String conIndex)
    {
       try {
    	    
    	    con = DataResource.getConnect(conIndex);
    	  
       } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
	        e.printStackTrace();
	        //System.out.println("sorry can't find db driver!");
	        ExceptionDispose.saveExceptionInfo(e);
       } catch (SQLException e1) {
        // TODO Auto-generated catch block
	        e1.printStackTrace();
	        //System.out.println("sorry can't create Connection!");
	        ExceptionDispose.saveExceptionInfo(e1);
       }catch (Exception e2) {
    	   e2.printStackTrace();
    	   ExceptionDispose.saveExceptionInfo(e2);
       }
       return con;

    }
    /**
       * ��ʱ���?��
       */
    public static synchronized void TimerEvent()
    {
          //��ʱ��û��ʵ���Ժ����ϵ�
    }
    /**
       * @param args
       */
    public static void main(String[] args) {
       // TODO Auto-generated method stub
    }
    /**
       * @return the driver
       */
    public static String getDriver() {
       return driver;
    }
    /**
       *
       */
    public static void setDriver(String driver1) {
       driver = driver1;
    }
    /**
       * @return the maxConn
       */
    public static int getMaxConn() {
       return maxConn;
    }
    /**
       *
       */
    public static void setMaxConn(int maxConn1) {
       maxConn = maxConn1;
    }
    /**
       * @return the minConn
       */
    public static int getMinConn() {
       return minConn;
    }
    /**

       */
    public static void setMinConn(int minConn1) {
       minConn = minConn1;
    }
    /**
       * @return the name
       */
    public static String getName() {
       return name;
    }
    /**
       */
    public static void setName(String name1) {
       name = name1;
    }
    /**
       * @return the password
       */
    public static String getPassword() {
       return password;
    }
    /**
       */
    public static void setPassword(String password1) {
       password = password1;
    }
    /**
       * @return the url
       */
    public static String getUrl() {
       return url;
    }
    /**
       */
    public static void setUrl(String url1) {
       url = url1;
    }
    /**
       * @return the user
       */
    public static String getUser() {
       return user;
    }
    /**
       */
    public static void setUser(String user1) {
       user = user1;
    }

    //����MES
    public  static Connection getmesConn(){
        Connection conn = null;
        try{
            conn = DataResource.getConnect("1");

        }catch(Exception ex){
            //System.out.println("EX: "+ex.getLocalizedMessage());
            ExceptionDispose.saveExceptionInfo(ex);
        }
        return conn;
    }

    
    //�Ͽ���ݿ�
    public  static void closeConn(Connection conn,String conIndex){
        try{
           /* if(conn != null){
                conn.close();
                conn=null;
            }*/
        	getfreeConnections(conIndex).add(conn);
            inUsed--;
        } catch(Exception ex){
            //System.out.println("EX: "+ex.getLocalizedMessage());
            ExceptionDispose.saveExceptionInfo(ex);
        }
    }
}