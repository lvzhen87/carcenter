package com.freshen.util;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

import com.freshen.entity.Customer;

public class DynamicBinding {
	public <T> T MakeDynamicBindingData(Class c1 ,T entity,T oldEntity)
	{
		try {
			String status_s = "";
			Method methlist[] = c1.getDeclaredMethods();
			Class pvec = null;
			 Field fieldlist[] = c1.getDeclaredFields(); 
		     for (int i = 0; i < fieldlist.length; i++) { 
		        Field fld = fieldlist[i]; 
		        fld.setAccessible(true);
		        status_s = fld.getName().substring(fld.getName().length()-1);
		        pvec = fld.getType();
		        Method setMet = c1.getMethod("set" + inicap(fld.getName()),pvec);
		        Method getMet = c1.getMethod("get" + inicap(fld.getName()));
		        if(getMet.invoke(entity, null)==null){
		        	////System.out.println("null");
		        	continue;
		        }
		        setMet.invoke(oldEntity, getMet.invoke(entity, null));
		       
		     } 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			return oldEntity;
		}
		
        
	}
	
	public static String inicap (String str){
		return str.substring(0,1).toUpperCase().concat(str.substring(1));
	}
	
	public static void main(String[] args) throws Exception {
		Class c1 = Customer.class;
		Customer c = new Customer();
		c.setCustomerID_s("321dsafs");
		Customer c2 = new Customer();
		DynamicBinding d = new DynamicBinding();
		d.MakeDynamicBindingData(Customer.class,c,c2);
	}
}
