package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.OrganizationPost;
import com.freshen.entity.basis.RoadCost;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.DynamicBinding;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.BeanModel;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

public class CustomerServiceImpl extends ClimsServiceBase implements  IcustomerService{

	String customerID_s;
	Integer status_i;
	String  status_s;
	String customerName_s;
	String department_s;
	String customerAddress_s;
	String customerUserID_s;
	String customerUserPhone_s;
	String customerUserEmail_s;
	String invoiceOrder_s;
	String addedValueTax_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resavedes1;
	String resavedes2;
	String resavedes3;
	String resavedes4;
	String resavedes5;
	
	String invoiceAddress_s;
	String registerAddress_s;
	String invoiceUserID_s;
	String responsibleUserID_s;
	
	String customerUserName_s,password_s,uploadFilePath_s;
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	public int updateCustomerStatus(String customer_id, String status,Session session)throws Exception {
		Customer customermodel = new Customer();				 		
		if(customer_id!=null){
	    	customermodel=(Customer)session.get(customermodel.getClass(), customer_id);
	    	if(customermodel==null){
	    		throw new Exception("客户信息不存在");
	    	}
	    	customermodel.setStatus_i(Integer.valueOf(status));	   	    	
	    	session.update(customermodel);
	    }
		return 1;
	}
	public ArrayList<Customer> getCustomer(Customer customer, int start, int size)
			throws Exception {
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<Customer> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(customer==null){
				Query query=session.createQuery("from Customer as customer");
			    list = query.list();	  		
			    if(start!=ConstantUtil.pagingNot){
			    	query.setFirstResult(start);
				    query.setMaxResults(size);
			    }
				return (ArrayList) list;
			}
			customerID_s   = customer.getCustomerID_s();			
			status_i       = customer.getStatus_i();
			status_s       = customer.getStatus_s();
			customerName_s = customer.getCustomerName_s();
			department_s   = customer.getDepartment_s();
			customerAddress_s = customer.getCustomerAddress_s();
			customerUserID_s = customer.getCreateUser_s();
			customerUserPhone_s = customer.getCustomerUserPhone_s();
			customerUserEmail_s = customer.getCustomerUserEmail_s();
			invoiceOrder_s = customer.getInvoiceOrder_s();
			addedValueTax_s = customer.getAddedValueTax_s();
			createDate_t = customer.getCreateDate_t();
			createUser_s = customer.getCreateUser_s();
			lastUpdateUser_s = customer.getLastUpdateUser_s();
			lastUpdateDate_t = customer.getLastUpdateDate_t();
			resavedes1 = customer.getResavedes1();
			resavedes2 = customer.getResavedes2();
			resavedes3 = customer.getResavedes3();
			resavedes4 = customer.getResavedes4();
			resavedes5 = customer.getResavedes5();
			invoiceAddress_s = customer.getInvoiceAddress_s();
			registerAddress_s = customer.getRegisterAddress_s();
			invoiceUserID_s = customer.getInvoiceUserID_s();
			responsibleUserID_s = customer.getResponsibleUserID_s();

			String hql="from Customer as customer where 1=1 "; 
		    String condition = "";
			if(customerID_s!=null&&!customerID_s.trim().equals("")){
				condition = condition+" and customer.customerID_s like'%"+customerID_s+"%'";
		    }
			
		    if(status_i!=null){
		    	condition += " and customer.status_i='"+status_i+"'";
		    }
		    if(status_s!=null){
		    	String[] tmp = status_s.split("vv");
		    	for(int i=0;i<tmp.length;i++){
		    		//String s = tmp[i];
		    		if(i==0){
		    			condition = condition+" and (customer.status_i='"+i+"'";
		    		}else{
		    			condition = condition+" customer.status_i='"+i+"'";
		    		}
		    		if(i==tmp.length-1){
		    			condition = condition+")";
		    		}else{
		    			condition = condition+" or ";
		    		}
		    	}
		    }
		    if(customerName_s!=null && !customerName_s.trim().equals("") ){
		    	condition = condition+" and customer.customerName_s like'%"+customerName_s+"%'";
		    }
		    if(department_s!=null && department_s.trim().length()>0){
		    	condition = condition+" and customer.department_s like '%"+department_s+"%'";
		    }
		    if(customerAddress_s!=null&&customerAddress_s.trim().length()>0){
		    	condition = condition+" and customer.customerAddress_s like'%"+customerAddress_s+"%'";
		    }
		    if(customerUserID_s!=null && customerUserID_s.trim().length()>0 ){
		    	condition = condition+" and customer.customerUserID_s like '%"+customerUserID_s+"%'";
		    }
		    if(customerUserPhone_s!=null && customerUserPhone_s.trim().length()>1){
		    	condition = condition+" and customer.customerUserPhone_s like '%"+customerUserPhone_s+"%'";
		    }
		    if(customerUserEmail_s!=null && customerUserEmail_s.trim().length()>1){
		    	condition = condition+" and customer.customerUserEmail_s like '%"+customerUserEmail_s+"%'";
		    }
		    if(invoiceOrder_s!=null && invoiceOrder_s.trim().length()>1){
		    	condition = condition+" and customer.invoiceOrder_s like '%"+invoiceOrder_s+"%'";
		    }
		    if(addedValueTax_s!=null&& addedValueTax_s.trim().length()>1){
		    	condition = condition+" and customer.addedValueTax_s like '%"+addedValueTax_s+"%'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(customer.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null && createUser_s.trim().length()>1){
		    	condition = " and customer.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null ){
		    	condition = condition+" and to_char(customer.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateUser_s!=null&& lastUpdateUser_s.trim().length()>1){
		    	condition = condition+" and customer.lastUpdateUser_s like '%"+lastUpdateUser_s+"%'";
		    } 
		    if(resavedes1!=null && resavedes1.trim().length()>1){
		    	condition = condition+" and customer.resavedes1 like '%"+resavedes1+"%'";
		    } 
		    if(resavedes2!=null && resavedes2.trim().length()>1){
		    	condition = condition+" and customer.resavedes2='"+resavedes2+"'";
		    } 
		    if(resavedes3!=null && resavedes3.trim().length()>1){
		    	condition = condition+" and customer.resavedes3='"+resavedes3+"'";
		    } 
		    if(resavedes4!=null && resavedes4.trim().length()>1){
		    	condition = condition+" and customer.resavedes4='"+resavedes4+"'";
		    } 
		    if(resavedes5!=null && resavedes5.trim().length()>1){
		    	condition = condition+" and customer.resavedes5='"+resavedes5+"'";
		    } 
		    if(invoiceAddress_s!=null && invoiceAddress_s.trim().length()>1){
		    	condition = condition+" and customer.invoiceAddress_s='"+invoiceAddress_s+"'";
		    } 
		    if(registerAddress_s!=null && registerAddress_s.trim().length()>1){
		    	condition = condition+" and customer.registerAddress_s='"+registerAddress_s+"'";
		    } 
		    if(invoiceUserID_s!=null && invoiceUserID_s.trim().length()>1){
		    	condition = condition+" and customer.invoiceUserID_s='"+invoiceUserID_s+"'";
		    } 
		    if(responsibleUserID_s!=null && responsibleUserID_s.trim().length()>1){
		    	condition = condition+" and customer.responsibleUserID_s='"+responsibleUserID_s+"'";
		    } 
		    condition = condition +" order by customer.createDate_t DESC,customer.lastUpdateDate_t DESC";
			Query query=session.createQuery(hql+condition);
			if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
			list = query.list();	
		    return (ArrayList<Customer>) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}	   
		// TODO Auto-generated method stub
	}
	
	public long getCustomerNubmer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			//CustomerUser customerUsermodel = new CustomerUser();
			if(customer==null){
				Query query=session.createQuery("select count(*) from Customer");
			  
			    long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    }    
			    return n;
			}
			customerID_s   = customer.getCustomerID_s();			
			status_i       = customer.getStatus_i();
			customerName_s = customer.getCustomerName_s();
			department_s   = customer.getDepartment_s();
			customerAddress_s = customer.getCustomerAddress_s();
			customerUserID_s = customer.getCreateUser_s();
			customerUserPhone_s = customer.getCustomerUserPhone_s();
			customerUserEmail_s = customer.getCustomerUserEmail_s();
			invoiceOrder_s = customer.getInvoiceOrder_s();
			addedValueTax_s = customer.getAddedValueTax_s();
			createDate_t = customer.getCreateDate_t();
			createUser_s = customer.getCreateUser_s();
			lastUpdateUser_s = customer.getLastUpdateUser_s();
			lastUpdateDate_t = customer.getLastUpdateDate_t();
			resavedes1 = customer.getResavedes1();
			resavedes2 = customer.getResavedes2();
			resavedes3 = customer.getResavedes3();
			resavedes4 = customer.getResavedes4();
			resavedes5 = customer.getResavedes5();
			invoiceAddress_s = customer.getInvoiceAddress_s();
			registerAddress_s = customer.getRegisterAddress_s();
			invoiceUserID_s = customer.getInvoiceUserID_s();
			responsibleUserID_s = customer.getResponsibleUserID_s();
			//System.out.println( customerID_s );
			if(customerID_s!=null&&!customerID_s.trim().equals("")){
				customer =(Customer)session.get(customer.getClass(), customerID_s);
		    	 
		    	return customer==null?0:1;
		    }
			String hql="select count(*) from Customer as customer where 1=1 "; 
		    String condition = "";
		    if(status_i!=null){
		    	condition = condition+" and customer.status_i='"+status_i+"'";
		    }
		    if(status_s!=null){
		    	String[] tmp = status_s.split("vv");
		    	for(int i=0;i<tmp.length;i++){
		    		String s = tmp[i];
		    		if(i==0){
		    			condition = condition+" and (customer.status_i='"+i+"'";
		    		}else{
		    			condition = condition+" customer.status_i='"+i+"'";
		    		}
		    		if(i==tmp.length-1){
		    			condition = condition+")";
		    		}else{
		    			condition = condition+" or ";
		    		}
		    	}
		    }
		    if(customerName_s!=null && !customerName_s.trim().equals("")){
		    	condition = condition+" and customer.customerName_s like '%"+customerName_s+"%'";
		    }
		    if(department_s!=null && !department_s.trim().equals("")){
		    	condition = condition+" and customer.department_s like '%"+department_s+"%'";
		    }
		    if(customerAddress_s!=null){
		    	condition = condition+" and customer.customerAddress_s='"+customerAddress_s+"'";
		    }
		    if(customerUserID_s!=null && customerUserID_s.trim().length()>2 ){
		    	condition = condition+" and customer.customerUserID_s='"+customerUserID_s+"'";
		    }
		    if(customerUserPhone_s!=null && customerUserPhone_s.trim().length()>2){
		    	condition = condition+" and customer.customerUserPhone_s='"+customerUserPhone_s+"'";
		    }
		    if(customerUserEmail_s!=null){
		    	condition = condition+" and customer.customerUserEmail_s='"+customerUserEmail_s+"'";
		    }
		    if(invoiceOrder_s!=null){
		    	condition = condition+" and customer.invoiceOrder_s='"+invoiceOrder_s+"'";
		    }
		    if(addedValueTax_s!=null){
		    	condition = condition+" and customer.addedValueTax_s='"+addedValueTax_s+"'";
		    }
		    if(createDate_t!=null){
		    	condition = condition+" and to_char(customer.createDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(createDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(createUser_s!=null &&createUser_s.trim().length()>2){
		    	condition = condition+" and customer.createUser_s like '%"+createUser_s+"%'";
		    }
		    if(lastUpdateDate_t!=null){
		    	condition = condition+" and to_char(customer.lastUpdateDate_t,'yyyy-MM-dd')='"+DateUtil.dateToString(lastUpdateDate_t, "yyyy-MM-dd") +"'";
		    }
		    if(lastUpdateUser_s!=null){
		    	condition = condition+" and customer.lastUpdateUser_s='"+lastUpdateUser_s+"'";
		    } 
		    if(resavedes1!=null){
		    	condition = condition+" and customer.resavedes1='"+resavedes1+"'";
		    } 
		    if(resavedes2!=null){
		    	condition = condition+" and customer.resavedes2='"+resavedes2+"'";
		    } 
		    if(resavedes3!=null){
		    	condition = condition+" and customer.resavedes3='"+resavedes3+"'";
		    } 
		    if(resavedes4!=null){
		    	condition = condition+" and customer.resavedes4='"+resavedes4+"'";
		    } 
		    if(resavedes5!=null){
		    	condition = condition+" and customer.resavedes5='"+resavedes5+"'";
		    } 
		    if(invoiceAddress_s!=null && invoiceAddress_s.trim().length()>1){
		    	condition = condition+" and customer.invoiceAddress_s='"+invoiceAddress_s+"'";
		    } 
		    if(registerAddress_s!=null && registerAddress_s.trim().length()>1){
		    	condition = condition+" and customer.registerAddress_s='"+registerAddress_s+"'";
		    } 
		    if(invoiceUserID_s!=null && invoiceUserID_s.trim().length()>1){
		    	condition = condition+" and customer.invoiceUserID_s='"+invoiceUserID_s+"'";
		    } 
		    if(responsibleUserID_s!=null && responsibleUserID_s.trim().length()>1){
		    	condition = condition+" and customer.responsibleUserID_s='"+responsibleUserID_s+"'";
		    } 
		    
		    Query query=session.createQuery(hql+condition);
		    long n=0;
		    if(query.iterate().hasNext()){
		    	n=(Long) query.iterate().next();
		    }  		  
		    return n;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	
	}
	
	/**
	 * 
	 * registCustomer 内网注册客户信息
	 * @param	Customer
	 * @param	CustomerUser
	 * @return	int 1.注册成功  
	 * @author	yepeng   
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public int registCustomer(Customer customer,CustomerUser contactcustomerUser,CustomerUser responsecustomerUser) throws Exception {
		try{
			IsystemSequenceService systemSequenceServiceImpl  = new SystemSequenceServiceImpl();
			String contactUserIdPk = "";
			String responseUserIdPk = "";
			if(!session.isOpen()){
				session= HibernateUtil.getSession();
			}
//			开启事务
			tx = session.beginTransaction();
			if(BeanModel.isnotNull(contactcustomerUser)){
				//联系人员ID，Sequence自动生成
				contactUserIdPk = systemSequenceServiceImpl.getPK(ConstantUtil.RYBusiness, session);
			}
			if(BeanModel.isnotNull(responsecustomerUser)){
				//负责人ID，Sequence自动生成
				responseUserIdPk = systemSequenceServiceImpl.getPK(ConstantUtil.RYBusiness, session);
			}
			//	客户ID，Sequence自动生成
			String customerIdPk = systemSequenceServiceImpl.getPK(ConstantUtil.KHBusiness, session);
			//	t_subscribe_customer客户ID
			customer.setCustomerID_s(customerIdPk);
			//	t_subscribe_customer客户联系人员ID
			customer.setCustomerUserID_s(contactUserIdPk);
			//t_subscribe_customer客户负责人ID
			customer.setResponsibleUserID_s(responseUserIdPk);
			if(BeanModel.isnotNull(contactcustomerUser)){
				//	t_basis_customerUser客户ID
				contactcustomerUser.setCustomerID_s(customerIdPk);
				//	t_basis_customerUser客户联系人员ID
				contactcustomerUser.setCustomerUserID_s(contactUserIdPk);
				session.saveOrUpdate(contactcustomerUser);
			}
			if(BeanModel.isnotNull(responsecustomerUser)){
				//t_basis_customerUser负责人公司ID
				responsecustomerUser.setCustomerID_s(customerIdPk);
				//	t_basis_customerUser负责人ID
				responsecustomerUser.setCustomerUserID_s(responseUserIdPk);
				session.saveOrUpdate(responsecustomerUser);
			}
			session.saveOrUpdate(customer);
			tx.commit();
			return 1;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			session.clear();
		}
	}
	
	/**
	 * 
	 * getInvoiceOrder 发票抬头不能重复的check
	 * @param	    
	 * @return	
	 * @author	yepeng   
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getInvoiceOrder(String invoiceOrder) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql = "select count(*) from Customer as customer where 1=1 ";
			String condition = "";
			if(invoiceOrder != null && !invoiceOrder.trim().equals("")){
				condition = " and customer.invoiceOrder_s='" + invoiceOrder + "'";
			}
			
		    Query query = session.createQuery(hql + condition);
		    long result = 0;
		    if(query.iterate().hasNext()){
		    	result = (Long) query.iterate().next();
		    }  		  
		    return result;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear(); 
		}	
	}
	
	/**
	 * 
	 * getCustomerLoginName 昵称不能重复的check
	 * @param	    
	 * @return	
	 * @author	yepeng   
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public long getCustomerLoginName(String CustomerLoginName) throws Exception {
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql = "select count(*) from Customer as customer where 1=1 ";
			String condition = "";
			if(CustomerLoginName != null && !CustomerLoginName.trim().equals("")){
				condition = " and customer.customerLoginName_s='" + CustomerLoginName + "'";
			}
			
		    Query query = session.createQuery(hql + condition);
		    long result = 0;
		    if(query.iterate().hasNext()){
		    	result = (Long) query.iterate().next();
		    }  		  
		    return result;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear(); 
		}	
	}


/*	public int updateCustomerUserStatus(String customerUserid, String status,Session session) throws Exception {
		CustomerUser customerUsermodel = new CustomerUser();				 		 
		
		if(customerUserid!=null){
			customerUsermodel=(CustomerUser)session.get(customerUsermodel.getClass(), customerUserid);
	    	if(customerUsermodel==null){
	    		throw new Exception("客户人员信息不存在");
	    	}
	    	customerUsermodel.setStatus_i(Integer.valueOf(status));	    	 
	    	session.update(customerUsermodel);	    	 
	    }
		return 1;
	}*/
	
	public static void main(String arg[]){
		Customer customer = new Customer();
		customer.setCustomerID_s("KH2014042045");
		 try {
			List l = new CustomerServiceImpl().getCustomer(customer,-1,2);
			//System.out.println(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int OperationCustomer(List<Customer> list, int operation)
			throws Exception {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try{
			Session session= HibernateUtil.getSession();
			
			if(!session.isOpen()){
				session= HibernateUtil.getSession();							
			}
			tx=session.beginTransaction();//开启事务
			//新增
			if(operation==1){
				IsystemSequenceService systemSequenceServiceImpl = new SystemSequenceServiceImpl();
				Customer tmp = new Customer();
				
				if(list!=null||list.size()>0){
					for(int i=0;i<list.size();i++){		
						tmp = list.get(i);
						if(list.get(i).getCustomerID_s()== null || list.get(i).getCustomerID_s().trim().equals(""))
						{
							String cpg = systemSequenceServiceImpl.getPK(ConstantUtil.KHBusiness, session);
							tmp.setCustomerID_s(cpg);
							session.saveOrUpdate(tmp);
						}
						else
						{
							Customer rc = (Customer)session.get(Customer.class, list.get(i).getCustomerID_s());
							
							DynamicBinding d = new DynamicBinding();
							rc = d.MakeDynamicBindingData(Customer.class,tmp, rc);
							
							session.saveOrUpdate(rc);
							
						}
						session.flush();
					  //  session.clear();
					}
				}
			}
			//删除
			if(operation==2){
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						session.delete(list.get(i));
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			return 1;
		}catch(Exception e){
			tx.rollback();
			throw e;
		}finally{				
    		session.clear();	 
		}
	}
}
