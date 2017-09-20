package com.freshen.basis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IAuthorPageService;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationPost;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;

public class AuthorPageServiceImpl extends ClimsServiceBase implements IAuthorPageService {

	String organizationPost_s;
	String limitpage = "";
	
	Transaction tx = null;
	
	public String getAuthorPageString(Employee employee) throws Exception {
		Session session = HibernateUtil.getSession();
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		limitpage=  "";
		OrganizationPost organizationPost = new OrganizationPost();
		List<OrganizationPost> list = new ArrayList<OrganizationPost>();
		String[] limitMessage;
		String[] limitDetail;
		String LimitAll = "";
		try {
			if(employee!=null)
			{
				organizationPost_s = employee.getOrganizationPost_s();
				if(organizationPost_s!= null && !organizationPost_s.trim().equals(""))
				{
					Query query = session.createQuery("  from OrganizationPost as organizationPost where organizationPost.organizationPost_s like '%" + organizationPost_s + "%'");
					if(query.iterate().hasNext()){
						list = (ArrayList)query.list();
						organizationPost = (OrganizationPost)list.get(0);
						LimitAll = organizationPost.getLimitpage_s();
						limitMessage = LimitAll.split("vv");
						for(int i = 0;i<limitMessage.length;i++)
						{
							limitDetail = limitMessage[i].split(",");
							if( i == 0)
							{
								limitpage += limitDetail[1];
							}
							else
							{
								limitpage += "vv" + limitDetail[1];
							}
						}
					}
				}
			}
		} catch (Exception e) {
			limitpage = "";
			e.printStackTrace();
			throw e;
			// TODO: handle exception
		}
		finally{
			session.clear();
			return limitpage;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		String limit = "";
		if(!session.isOpen())
		{
			session = HibernateUtil.getSession();
		}
		Employee employee = new Employee();
		employee = (Employee)session.get(employee.getClass(), "EmpPost001");
		
		AuthorPageServiceImpl a = new AuthorPageServiceImpl();
		limit = a.getAuthorPageString(employee);
//		//System.out.println(limit);
	}

}
