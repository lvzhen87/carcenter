package com.freshen.util;


import java.sql.Connection;
import java.sql.DriverManager;


public class DataResource {
 

	/**
	 * 获得数据库连接	   
	 * getConnect 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
    public static Connection getConnect (String index) throws Exception {
//        //System.out.println("driver22222======"+ResourceTools.getDataResource("driver"+index));
        try{
	        Class.forName(ResourceTools.getDataResource("driver"+index)).newInstance();
//	        //System.out.println("drive11111r======"+ResourceTools.getDataResource("driver"+index));
//			//System.out.println("url======"+ResourceTools.getDataResource("url"+index));
//			//System.out.println("username======"+ResourceTools.getDataResource("username"+index));
//			//System.out.println("password======"+ResourceTools.getDataResource("password"+index));
	        Connection conn=DriverManager.getConnection(ResourceTools.getDataResource("url"+index),ResourceTools.getDataResource("username"+index), ResourceTools.getDataResource("password"+index));
//	        //System.out.println("conn="+conn);
	        return conn;
        }catch(Exception e){
        	throw new Exception("数据库连接错误，错误信息"+e.getMessage());
        }
    }

    
   
    public  static void main(String[] s){
    	try {
    		 
    		Connection con = DataResource.getConnect("2");
    		//System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
}
