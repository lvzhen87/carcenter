package com.freshen.clims.baseclass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.impl.SessionImpl;

import com.freshen.entity.reception.CardInfo;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

/**
 * 启动一个事务，调用通过list传进来的多个service方法
 * 项目名称：carcenter    
 * 类名称：ServiceImpl    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-8-8 上午10:27:07    
 * 修改人：kxc    
 * 修改时间：2014-8-8 上午10:27:07    
 * 修改备注：    
 * @version     
 *
 */
public class ServiceImpl {

	private String serviceName;
	private String methodName;
	private Object[] parameter;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getParameter() {
		return parameter;
	}
	public void setParameter(Object[] parameter) {
		this.parameter = parameter;
	}
	public ServiceImpl(String serviceName,String methodName,Object[] parameter){
		this.serviceName = serviceName;
		this.methodName = methodName;
		this.parameter = parameter;
	}
	
	public static Class[] getClasses(Object[] objects) {
		 if (objects == null) {
			 return null;
		 }
		 Class[] result = new Class[objects.length];
		 for (int i = 0; i < objects.length; i++) {
			 if (objects[i] != null) {
				 result[i] = objects[i].getClass();
			 }
		 }
		 return result;
	}
	public void set(String s){
		CardInfo cardInfo = new CardInfo();		 
		cardInfo.setCard_s(s);
		 
	}
	/**
	 * 在同一事务中执行多个service方法	   
	 * invoke 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static void invoke(List<ServiceImpl> serviceImpls)throws Exception {
		Session session = HibernateUtil.getSession();
		
		if(!session.isOpen()){
			session=HibernateUtil.getSession();
		}
		Transaction tx = null;		
		try{
			 
			tx=session.beginTransaction();//开启事务
			for(ServiceImpl tmp:serviceImpls){
				Class demo = Class.forName(tmp.getServiceName());
				Field[] filed1 = demo.getFields();
				
				//Object[] p = tmp.getParameter();
				/*Object[] o = new Object[p.length+1];
				for(int i=0;i<p.length;i++){
					o[i] = p[i];
				}
				o[o.length-1] = session;*/
				Object obj = demo.newInstance();
				Field field = demo.getField("sessionImpl");
		        field.setAccessible(true);
		        field.set(obj, session);
		        setter(obj,"SessionImpl",session,org.hibernate.impl.SessionImpl.class);
				Class[] paramClass = getClasses(tmp.getParameter());
				Method method=demo.getMethod(tmp.getMethodName(),paramClass);				
				method.invoke(demo.newInstance(), tmp.getParameter());
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			throw e;
		}finally{		
			session.clear();
		}
	}
	
	/**
	 * 	类型为obj的对象，att属性的get方法
	 * getter 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static void getter(Object obj, String att) {
        try {

            Method method = obj.getClass().getMethod("get" + att);
            
            //System.out.println(method.invoke(obj));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
	
	/**
	 * 类型为obj的对象，att属性的set方法， value是值，type是值的类型
	 * setter 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public static void setter(Object obj, String att, Object value,

            Class<?> type) {

        try {

            Method method = obj.getClass().getMethod("set" + att, type);

            method.invoke(obj, value);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
	public static void main(String[] a){		 
		try {			
			ArrayList<CardInfo> list = new ArrayList();
			CardInfo cardInfo = new CardInfo();
			cardInfo.setOrderID_s("1");
			cardInfo.setCard_s("1");
			list.add(cardInfo);
			List<ServiceImpl> se = new ArrayList();
			Object[] o = {list};
			ServiceImpl tmp = new ServiceImpl("com.freshen.reception.service.impl.CardInfoServiceImpl","deleteReceptionCardInfobyTransaction1",o);			 
			se.add(tmp);
			ServiceImpl.invoke(se);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
