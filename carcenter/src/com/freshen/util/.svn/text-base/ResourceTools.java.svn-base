package com.freshen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
/**
 * 
 *     
 * 项目名称：carcenter    
 * 类名称：ResourceTools    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-6-6 下午01:10:57    
 * 修改人：kxc    
 * 修改时间：2014-6-6 下午01:10:57    
 * 修改备注：    
 * @version     
 *
 */
public class ResourceTools {

	private static final String PATH = "\\com\\freshen\\util\\static.properties";
	private static final String CONNPATH = "\\com\\freshen\\file\\resources\\dataConnect.properties";
	
	
	public static String getPath() {
		return PATH;
	}

	/**
	 * 获得数据库连接参数
	   
	 * getDataResource 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static String getDataResource(String key)
    {
		 Locale locale3 = new Locale("en", "US"); 
		 ResourceBundle messages = ResourceBundle.getBundle("com.freshen.file.resources.dataConnect",locale3);
     //   ResourceBundle resource = ResourceBundle.getBundle("dataConnect",locale);
         //System.out.println(messages);
         return messages.getString(key);
    }
	
	
	public static String getStaticDataResource(String key)
    {
		try
		{
			Properties prop = new Properties();// 属性集合对象 
			String p = new File(ResourceTools.class.getResource("/").getFile()).getAbsolutePath()+PATH;  

			//ResourceTools.class.getClass().getResource(PATH).getPath();
//			Utils.class.getClass().getResource(PATH).getPath();
			FileInputStream fis = new FileInputStream(p);// 属性文件输入流 
			prop.load(fis);// 将属性文件流装载到Properties对象中 
			fis.close();// 关闭流 
			return prop.getProperty(key);
		}
		catch(Exception e)
		{
			return null;
		}
		
		
		// 获取属性值，sitename已在文件中定义 
//		//System.out.println("获取属性值：password=" + prop.getProperty("password")); 
//		prop.setProperty(key, value); 
//		 Locale locale3 = new Locale("en", "US"); 
//		 ResourceBundle messages = ResourceBundle.getBundle("com.freshen.util.static",locale3);
//     //   ResourceBundle resource = ResourceBundle.getBundle("dataConnect",locale);
//         //System.out.println(messages);
//         return messages.getString(key);
    }
	
	
	public static void writeData(String key, String value) { 
		try {
			Properties prop = new Properties();// 属性集合对象 
			String p = new File(ResourceTools.class.getResource("/").getFile()).getAbsolutePath()+PATH;  

			//ResourceTools.class.getClass().getResource(PATH).getPath();
//			Utils.class.getClass().getResource(PATH).getPath();
			FileInputStream fis = new FileInputStream(p);// 属性文件输入流 
			prop.load(fis);// 将属性文件流装载到Properties对象中 
			fis.close();// 关闭流 

			// 获取属性值，sitename已在文件中定义 
			//System.out.println("获取属性值：" + prop.getProperty(key)); 
			prop.setProperty(key, value); 
			// 文件输出流 
			FileOutputStream fos = new FileOutputStream(p); 
			// 将Properties集合保存到流中 
			prop.store(fos, "Copyright (c) Boxcode Studio"); 
			fos.close();// 关闭流 
			//System.out.println("获取修改后的属性值：key=" + prop.getProperty(key)); 

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }   
	 
	public static void main(String[] s){
		 //System.out.println(ResourceTools.getDataResource("jobname"));
	}
}



