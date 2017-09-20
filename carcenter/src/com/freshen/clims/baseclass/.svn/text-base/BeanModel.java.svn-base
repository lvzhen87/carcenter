package com.freshen.clims.baseclass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.freshen.entity.Customer;
import com.freshen.util.StringTools;



/**
 * 
 * pojo的基类    
 * 项目名称：carcenter    
 * 类名称：BeanModel    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-6-23 下午12:05:57    
 * 修改人：kxc    
 * 修改时间：2014-6-23 下午12:05:57    
 * 修改备注：    
 * @version     
 *
 */
public class BeanModel implements java.io.Serializable{

	/**
	 * 判断对象是否等于null	   
	 * isnotNull 
	 * @param   beanModel 对象    
	 * @param  @return     true 为null false不为null
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static boolean isnotNull(Object beanModel){
		Method metd = null;
		try {
			if(beanModel==null){
				return false;
			}else{
				Class c1 = beanModel.getClass();// 获取集合中的对象类型
				Field[] fds = c1.getDeclaredFields();// 获取他的字段数组
				for (Field field : fds) {// 遍历该数组
					String fdname = field.getName();// 得到字段名
					metd = c1.getMethod("get" + StringTools.getstrUpperCase(fdname,0,1), null);
					Object name = metd.invoke(beanModel, null);					
					if(name!=null&&!name.equals("")){
						return true;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 根据字段名找到对应的get方法，null表示无参数
		return false;
	}
	public static void main(String[] a){
		Customer customer = new Customer();
		customer.setCustomerID_s("123");  
		boolean b = customer.isnotNull(customer);
//		//System.out.println(b);
	}
}
