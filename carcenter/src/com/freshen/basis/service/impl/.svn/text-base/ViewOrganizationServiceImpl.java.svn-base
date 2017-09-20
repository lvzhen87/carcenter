package com.freshen.basis.service.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IViewOrganizationService;
import com.freshen.entity.basis.ViewOrganization;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class ViewOrganizationServiceImpl extends ClimsServiceBase implements IViewOrganizationService {

	
	String organizationdept_s;
	String deptname_s;
	String organizationpost_s;
	String postname_s;
	
	String employeeid_s;
	String employee;
	String customerusername_s;
	String orderid_s;
	
	//Session session = HibernateUtil.getSession();
	Transaction tx = null;
	
	public boolean getIsVisible(ViewOrganization viewOrganization)
			throws Exception {
		boolean returnValue = false;
		Session session = HibernateUtil.getSession();
		if(!session.isOpen()){
			session = HibernateUtil.getSession();
		}
		long n = 0;
		try {
			if(viewOrganization!=null){
				organizationdept_s = viewOrganization.getOrganizationdept_s();
				deptname_s = viewOrganization.getDeptname_s();
				organizationpost_s = viewOrganization.getOrganizationpost_s();
				postname_s = viewOrganization.getPostname_s();
				
				employeeid_s = viewOrganization.getEmployeeid_s();
				employee = viewOrganization.getEmployee();
				customerusername_s = viewOrganization.getCustomerusername_s();
				orderid_s = viewOrganization.getOrderid_s();
				
				String hql = "select count(*)  from ViewOrganization as viewOrganization where 1=1 ";
				String condition="";
				
				if(organizationdept_s != null && !organizationdept_s.trim().equals("")){
			    	condition = " and viewOrganization.organizationdept_s like '%" + organizationdept_s.trim() + "%'";
			    }
				if(deptname_s != null && !deptname_s.trim().equals("")){
			    	condition = " and viewOrganization.deptname_s like '%" + deptname_s.trim() + "%'";
			    }
				if(organizationpost_s != null && !organizationpost_s.trim().equals("")){
			    	condition = " and viewOrganization.organizationpost_s like '%" + organizationpost_s.trim() + "%'";
			    }
				if(postname_s != null && !postname_s.trim().equals("")){
			    	condition = " and viewOrganization.postname_s like '%" + postname_s.trim() + "%'";
			    }
				if(employeeid_s != null && !employeeid_s.trim().equals("")){
			    	condition = " and viewOrganization.employeeid_s like '%" + employeeid_s.trim() + "%'";
			    }
				if(customerusername_s != null && !customerusername_s.trim().equals("")){
			    	condition = " and viewOrganization.customerusername_s like '%" + customerusername_s.trim() + "%'";
			    }
				if(orderid_s != null && !orderid_s.trim().equals("")){
			    	condition = " and viewOrganization.orderid_s like '%" + orderid_s.trim() + "%'";
			    }
				
				Query query = session.createQuery(hql + condition);
				if(query.iterate().hasNext()){
					n = (Long)query.iterate().next();
				}
				if(n>0)
				{
					returnValue = true;
				}
				else
				{
					returnValue = false;
				}
			}
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		finally
		{
			session.clear();
			return returnValue;	
		}
	}
	
	public static void main(String[] args) throws Exception {
		ViewOrganizationServiceImpl viewOrganizationServiceImpl = new ViewOrganizationServiceImpl();
		
		
	}

}
