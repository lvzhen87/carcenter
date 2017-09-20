package com.freshen.preorder.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Driver;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.system.service.IsystemSequenceService;
import com.freshen.system.service.impl.SystemSequenceServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class CustomerUserServiceImpl extends ClimsServiceBase implements  IcustomerUserService{

	String customerID_s;
	String customerUserID_s;
	Integer status_i;
	String  status_s;
	String customerName_s;
	String department_s;
	String customerUserName_s;
	String identityCard_s;
	String position_s;
	String telephone_s;
	String facsimile_s;
	String email_s;
	Integer userType_i;
	String customerAddress_s;
	
	
	String emplycode_s;
	String emplyusertype_s;
	String emplypass_s;
	String emplysex_s;
	Date empbirthday_t;
	String duty_s;
	String nation_s;
	String degree_s;
	String address_s;
	String memo_s;
	String sysno_s;
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList getCustomerUser(CustomerUser customerUser) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<CustomerUser> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(!CustomerUser.isnotNull(customerUser)){
				Query query=session.createQuery("from CustomerUser");
			    list = query.list();	  			
				return (ArrayList) list;
			}
			customerID_s = customerUser.getCustomerID_s();
			customerUserID_s = customerUser.getCustomerUserID_s();		 
			department_s = customerUser.getDepartment_s();
			customerUserName_s = customerUser.getCustomerUserName_s();
			position_s = customerUser.getPosition_s();
			telephone_s = customerUser.getTelephone_s();
			facsimile_s = customerUser.getFacsimile_s();
			email_s = customerUser.getEmail_s();
			userType_i = customerUser.getUserType_i();		
			sysno_s = customerUser.getSysNo_s();
			String hql="from CustomerUser as customerUser where 1=1 "; 
		    String condition = "";
			if(customerUserID_s!=null&&!customerUserID_s.equals("")){
				condition += " and customerUser.customerUserID_s='"+customerUserID_s+"'";
		    }		    
		    if(customerID_s!=null&&!customerID_s.equals("")){
		    	condition += " and customerUser.customerID_s='"+customerID_s+"'";
		    }
		    if(status_i!=null){
		    	condition = condition+" and customerUser.status_i='"+status_i+"'";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (customerUser.status_i='"+statusarr[i]+"'";
		    		}else{
		    			condition = condition+" or customerUser.status_i='"+statusarr[i]+"'";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(customerName_s!=null&&!customerName_s.equals("")){
		    	condition = condition+" and customerUser.customerName_s like '%"+customerName_s+"%'";
		    }
		    if(department_s!=null&&!department_s.equals("")){
		    	condition = condition+" and customerUser.department_s like '%"+department_s+"%'";
		    }
		    if(customerAddress_s!=null&&!customerAddress_s.equals("")){
		    	condition = condition+" and customerUser.customerAddress_s='"+customerAddress_s+"'";
		    }
		    
		    if(customerUserName_s!=null&&!customerUserName_s.equals("")){
		    	condition = condition+" and customerUser.customerUserName_s like '%"+customerUserName_s+"%'";
		    }
		    if(position_s!=null&&!position_s.equals("")){
		    	condition = condition+" and customerUser.position_s like '%"+position_s+"%'";
		    }
		    if(telephone_s!=null&&!telephone_s.equals("")){
		    	condition = condition+" and customerUser.telephone_s like '%"+telephone_s+"%'";
		    }
		    if(facsimile_s!=null){
		    	condition = condition+" and customerUser.facsimile_s='"+facsimile_s+"'";
		    }
		    if(email_s!=null){
		    	condition = condition+" and customerUser.email_s='"+email_s+"'";
		    }
		    if(userType_i!=null && userType_i != 0){
		    	condition = condition+" and customerUser.userType_i="+userType_i+"";
		    }
		    if(sysno_s!=null  ){
		    	condition = condition+" and customerUser.sysNo_s='"+sysno_s+"'";
		    }
		    emplycode_s = customerUser.getEmplycode_s();
			emplyusertype_s = customerUser.getEmplyusertype_s();
			emplypass_s = customerUser.getEmplypass_s();
			emplysex_s = customerUser.getEmplysex_s();
			empbirthday_t = customerUser.getEmpbirthday_t();
			duty_s = customerUser.getDuty_s();
			nation_s = customerUser.getNation_s();
			degree_s = customerUser.getDegree_s();
			address_s = customerUser.getAddress_s();
			memo_s = customerUser.getMemo_s();
			if(emplycode_s!=null&&!emplycode_s.equals("")){
		    	condition = condition+" and customerUser.emplycode_s='"+emplycode_s+"'";
		    }
			if(emplyusertype_s!=null&&!emplyusertype_s.equals("")){
		    	condition = condition+" and customerUser.emplyusertype_s='"+emplyusertype_s+"'";
		    }
			if(emplypass_s!=null&&!emplypass_s.equals("")){
		    	condition = condition+" and customerUser.emplypass_s='"+emplypass_s+"'";
		    }
			if(emplysex_s!=null&&!emplysex_s.equals("")){
		    	condition = condition+" and customerUser.emplysex_s='"+emplysex_s+"'";
		    }
			if(duty_s!=null&&!duty_s.equals("")){
		    	condition = condition+" and customerUser.duty_s='"+duty_s+"'";
		    }
			if(nation_s!=null&&!nation_s.equals("")){
		    	condition = condition+" and customerUser.nation_s='"+nation_s+"'";
		    }
			if(degree_s!=null&&!degree_s.equals("")){
		    	condition = condition+" and customerUser.degree_s='"+degree_s+"'";
		    }
			if(address_s!=null&&!address_s.equals("")){
		    	condition = condition+" and customerUser.address_s='"+address_s+"'";
		    }
			if(memo_s!=null&&!memo_s.equals("")){
		    	condition = condition+" and customerUser.memo_s='"+memo_s+"'";
		    }
			if(empbirthday_t!=null){
		    	condition = condition+" and to_char(customerUser.empbirthday_t,'yyyy-MM-dd')='"+DateUtil.dateToString(empbirthday_t, "yyyy-MM-dd") +"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    list = query.list();
		    if(!BasicTools.isnotNull(list)){//查询结果为空，查看驾驶员信息
		    	IDriverService iDriverService = new DriverServiceImpl();
		    	Driver driver = new Driver();
		    	driver.setproByCustomerUser(customerUser);
		    	ArrayList<Driver> driverlist = iDriverService.getBasisDriverInfo(driver,ConstantUtil.pagingNot,0);
		    	return driverlist;
		    }
		    if(customerID_s!= null && !customerID_s.trim().equals("")){
		    	Customer customer = (Customer)session.get(Customer.class, customerID_s);
		    	for(int i = 0 ;i<list.size();i++){
		    		list.get(i).setCustomerName_s(customer.getCustomerName_s());
		    	}
		    }
		    return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		}	    
	}
	
	public ArrayList findCustomerUser(CustomerUser customerUser) throws Exception{
		// TODO Auto-generated method stub
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<CustomerUser> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(!CustomerUser.isnotNull(customerUser)){
				Query query=session.createQuery("from CustomerUser");
			    list = query.list();	  			
				return (ArrayList) list;
			}
			
			customerID_s = customerUser.getCustomerID_s();		 
			userType_i = customerUser.getUserType_i();		
			
			String hql="from CustomerUser as customerUser where 1=1 "; 
		    String condition = "";    
		    if(customerID_s!=null&&!customerID_s.equals("")){
		    	condition += " and customerUser.customerID_s='"+customerID_s+"'";
		    }		    
//		    if(userType_i!=null && userType_i != 0){
//		    	condition = condition+" and customerUser.userType_i="+userType_i+"";
//		    }
		     
		   
		    Query query=session.createQuery(hql+condition);
		    list = query.list();
		    
		    return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}	    
	}

	/**
	 * 
	 * updateCustomerUserStatus 修改状态
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	/*public int updateCustomerUserStatus(String customerUserid, String status,Session session) throws Exception {
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
	
	//实现分页查询注册用户
	public ArrayList getCustomerUser(CustomerUser customerUser, int start,
			int size) throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			List<CustomerUser> list = new ArrayList();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(customerUser==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from CustomerUser");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			//System.out.println("执行条件查询 分页 customerUser= "+customerUser);
			customerID_s = customerUser.getCustomerID_s();
			customerUserID_s = customerUser.getCustomerUserID_s();
			 
			department_s = customerUser.getDepartment_s();
		 		 
			customerUserName_s = customerUser.getCustomerUserName_s();
			position_s = customerUser.getPosition_s();
			telephone_s = customerUser.getTelephone_s();
			facsimile_s = customerUser.getFacsimile_s();
			email_s = customerUser.getEmail_s();
			userType_i = customerUser.getUserType_i();
		 
			if(customerUserID_s!=null&&customerUserID_s.length()>2){
				if(customerUserID_s.substring(0, 3).equals("JSY"))
				{
					Driver d = (Driver)session.get(Driver.class, customerUserID_s);
					//customerUser=(CustomerUser)session.get(customerUser.getClass(), customerUserID_s);
			    	list.add(d);
			    	return (ArrayList)list;
				}
				customerUser=(CustomerUser)session.get(customerUser.getClass(), customerUserID_s);
		    	list.add(customerUser);
		    	return (ArrayList)list;
		    }
		    
		    String hql="from CustomerUser as customerUser where 1=1 "; 
		    String condition = "";
		    if(customerID_s!=null){
		    	condition = " and customerUser.customerID_s like '"+customerID_s+"'";
		    }
		    if(status_i!=null){
		    	condition = condition+" and customerUser.status_i like '"+status_i+"'";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (customerUser.status_i='"+statusarr[i]+"'";
		    		}else{
		    			condition = condition+" or customerUser.status_i='"+statusarr[i]+"'";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(customerName_s!=null &&customerName_s.length()>0){
		    	condition = condition+" and customerUser.customerName_s like '"+customerName_s+"'";
		    }
		    if(department_s!=null && department_s.length()>0){
		    	condition = condition+" and customerUser.department_s like '"+department_s+"'";
		    }
		    if(customerAddress_s!=null&&!customerAddress_s.equals("")){
		    	condition = condition+" and customerUser.customerAddress_s='"+customerAddress_s+"'";
		    }
		     
		    if(customerUserName_s!=null&&!customerUserName_s.equals("")){
		    	condition = condition+" and customerUser.customerUserName_s like '%"+customerUserName_s+"%'";
		    }
		    if(position_s!=null&&!position_s.equals("")){
		    	condition = condition+" and customerUser.position_s like '%"+position_s+"%'";
		    }
		    if(telephone_s!=null&&!telephone_s.equals("")){
		    	condition = condition+" and customerUser.telephone_s like '%"+telephone_s+"%'";
		    }
		    if(facsimile_s!=null){
		    	condition = condition+" and customerUser.facsimile_s='"+facsimile_s+"'";
		    }
		    if(email_s!=null){
		    	condition = condition+" and customerUser.email_s='"+email_s+"'";
		    }
		    if(userType_i!=null && userType_i != 0){
		    	condition = condition+" and customerUser.userType_i='"+userType_i+"'";
		    }
		    
		    emplycode_s = customerUser.getEmplycode_s();
			emplyusertype_s = customerUser.getEmplyusertype_s();
			emplypass_s = customerUser.getEmplypass_s();
			emplysex_s = customerUser.getEmplysex_s();
			empbirthday_t = customerUser.getEmpbirthday_t();
			duty_s = customerUser.getDuty_s();
			nation_s = customerUser.getNation_s();
			degree_s = customerUser.getDegree_s();
			address_s = customerUser.getAddress_s();
			memo_s = customerUser.getMemo_s();
			if(emplycode_s!=null&&!emplycode_s.equals("")){
		    	condition = condition+" and customerUser.emplycode_s='"+emplycode_s+"'";
		    }
			if(emplyusertype_s!=null&&!emplyusertype_s.equals("")){
		    	condition = condition+" and customerUser.emplyusertype_s='"+emplyusertype_s+"'";
		    }
			if(emplypass_s!=null&&!emplypass_s.equals("")){
		    	condition = condition+" and customerUser.emplypass_s='"+emplypass_s+"'";
		    }
			if(emplysex_s!=null&&!emplysex_s.equals("")){
		    	condition = condition+" and customerUser.emplysex_s='"+emplysex_s+"'";
		    }
			if(duty_s!=null&&!duty_s.equals("")){
		    	condition = condition+" and customerUser.duty_s='"+duty_s+"'";
		    }
			if(nation_s!=null&&!nation_s.equals("")){
		    	condition = condition+" and customerUser.nation_s='"+nation_s+"'";
		    }
			if(degree_s!=null&&!degree_s.equals("")){
		    	condition = condition+" and customerUser.degree_s='"+degree_s+"'";
		    }
			if(address_s!=null&&!address_s.equals("")){
		    	condition = condition+" and customerUser.address_s='"+address_s+"'";
		    }
			if(memo_s!=null&&!memo_s.equals("")){
		    	condition = condition+" and customerUser.memo_s='"+memo_s+"'";
		    }
			if(empbirthday_t!=null){
		    	condition = condition+" and to_char(customerUser.empbirthday_t,'yyyy-MM-dd')='"+DateUtil.dateToString(empbirthday_t, "yyyy-MM-dd") +"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    
		    list = query.list();
		    if(customerID_s!= null && !customerID_s.trim().equals("")){
		    	Customer customer = (Customer)session.get(Customer.class, customerID_s);
		    	for(int i = 0 ;i<list.size();i++){
		    		list.get(i).setCustomerName_s(customer.getCustomerName_s());
		    	}
		    }
		    return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}
	}
	//
	public long getCustomerUserNubmer(CustomerUser customerUser) throws Exception{
		//CustomerUser customerUsermodel = new CustomerUser();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			if(customerUser==null){
				//System.out.println("执行无条件查询 总数");
				String hql="select count(*) from CustomerUser"; 
				Query query=session.createQuery(hql);
			    long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    }    
				return n;
			}
			customerID_s = customerUser.getCustomerID_s();
			customerUserID_s = customerUser.getCustomerUserID_s();
		 
			department_s = customerUser.getDepartment_s();
	 
			customerUserName_s = customerUser.getCustomerUserName_s();
			position_s = customerUser.getPosition_s();
			telephone_s = customerUser.getTelephone_s();
			facsimile_s = customerUser.getFacsimile_s();
			email_s = customerUser.getEmail_s();
			userType_i = customerUser.getUserType_i();
			   
		    String hql="select count(*) from CustomerUser as customerUser where 1=1 "; 
		    String condition = "";
		    
		    if(customerUserID_s!=null &&customerUserID_s.length()>1 ){
		    	 
		    	condition = condition+" and customerUser.customerUserID_s like '"+customerUserID_s+"'";
		    }
		    if(customerID_s!=null){
		    	condition += " and customerUser.customerID_s like '"+customerID_s+"'";
		    }
		    if(status_i!=null){
		    	condition += " and customerUser.status_i='"+status_i+"'";
		    }
		    if(status_s!=null){	    	
		    	String[] statusarr = status_s.split("vv");
		    	for(int i=0;i<statusarr.length;i++){
		    		if(i==0){
		    			condition = condition+" and (customerUser.status_i='"+statusarr[i]+"'";
		    		}else{
		    			condition = condition+" or customerUser.status_i='"+statusarr[i]+"'";
		    		}
		    		if(i==statusarr.length-1){
		    			condition = condition+")";
		    		}
		    	}	    
		    }
		    if(customerName_s!=null &&customerName_s.length()>1){
		    	condition = condition+" and customerUser.customerName_s like '%"+customerName_s+"%'";
		    }
		    if(department_s!=null && department_s.length()>1){
		    	condition = condition+" and customerUser.department_s like '%"+department_s+"%'";
		    }
		    if(customerAddress_s!=null&&!customerAddress_s.equals("")){
		    	condition = condition+" and customerUser.customerAddress_s='"+customerAddress_s+"'";
		    }
		    
		    if(customerUserName_s!=null&&!customerUserName_s.equals("")){
		    	condition = condition+" and customerUser.customerUserName_s like '%"+customerUserName_s+"%'";
		    }
		    if(position_s!=null&&!position_s.equals("")){
		    	condition = condition+" and customerUser.position_s like '%"+position_s+"%'";
		    }
		    if(telephone_s!=null&&!telephone_s.equals("")){
		    	condition = condition+" and customerUser.telephone_s like '%"+telephone_s+"%'";
		    }
		    if(facsimile_s!=null){
		    	condition = condition+" and customerUser.facsimile_s='"+facsimile_s+"'";
		    }
		    if(email_s!=null){
		    	condition = condition+" and customerUser.email_s='"+email_s+"'";
		    }
		    if(userType_i!=null && userType_i != 0){
		    	condition = condition+" and customerUser.userType_i='"+userType_i+"'";
		    }
		    
		    emplycode_s = customerUser.getEmplycode_s();
			emplyusertype_s = customerUser.getEmplyusertype_s();
			emplypass_s = customerUser.getEmplypass_s();
			emplysex_s = customerUser.getEmplysex_s();
			empbirthday_t = customerUser.getEmpbirthday_t();
			duty_s = customerUser.getDuty_s();
			nation_s = customerUser.getNation_s();
			degree_s = customerUser.getDegree_s();
			address_s = customerUser.getAddress_s();
			memo_s = customerUser.getMemo_s();
			if(emplycode_s!=null&&!emplycode_s.equals("")){
		    	condition = condition+" and customerUser.emplycode_s='"+emplycode_s+"'";
		    }
			if(emplyusertype_s!=null&&!emplyusertype_s.equals("")){
		    	condition = condition+" and customerUser.emplyusertype_s='"+emplyusertype_s+"'";
		    }
			if(emplypass_s!=null&&!emplypass_s.equals("")){
		    	condition = condition+" and customerUser.emplypass_s='"+emplypass_s+"'";
		    }
			if(emplysex_s!=null&&!emplysex_s.equals("")){
		    	condition = condition+" and customerUser.emplysex_s='"+emplysex_s+"'";
		    }
			if(duty_s!=null&&!duty_s.equals("")){
		    	condition = condition+" and customerUser.duty_s='"+duty_s+"'";
		    }
			if(nation_s!=null&&!nation_s.equals("")){
		    	condition = condition+" and customerUser.nation_s='"+nation_s+"'";
		    }
			if(degree_s!=null&&!degree_s.equals("")){
		    	condition = condition+" and customerUser.degree_s='"+degree_s+"'";
		    }
			if(address_s!=null&&!address_s.equals("")){
		    	condition = condition+" and customerUser.address_s='"+address_s+"'";
		    }
			if(memo_s!=null&&!memo_s.equals("")){
		    	condition = condition+" and customerUser.memo_s='"+memo_s+"'";
		    }
			if(empbirthday_t!=null){
		    	condition = condition+" and to_char(customerUser.empbirthday_t,'yyyy-MM-dd')='"+DateUtil.dateToString(empbirthday_t, "yyyy-MM-dd") +"'";
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
	
	public int OperationBasisCustomerUser(CustomerUser customerUser) throws Exception{
		try{
			tx = session.beginTransaction();
			if(customerUser!=null){
				String customeruserID = customerUser.getCustomerUserID_s();
				if(customeruserID == null || customeruserID.trim().equals("")){
					IsystemSequenceService isystemSequenceService = new SystemSequenceServiceImpl();
					customeruserID = isystemSequenceService.getPK(ConstantUtil.RYBusiness, session);
					customerUser.setCustomerUserID_s(customeruserID);
					session.merge(customerUser);
				}else{
					CustomerUser oldemp=(CustomerUser) session.get(customerUser.getClass(), customerUser.getCustomerUserID_s());
					 if(customerUser.getCustomerUserID_s()!=null && !customerUser.getCustomerUserID_s().equals("") ){
				    	 oldemp.setCustomerUserID_s(customerUser.getCustomerUserID_s());
					 }
					 if(customerUser.getCustomerUserName_s() !=null && !customerUser.getCustomerUserName_s().equals("")){
						 oldemp.setCustomerUserName_s(customerUser.getCustomerUserName_s());
					 }
					 if(customerUser.getCustomerID_s()!=null && !customerUser.getCustomerID_s().equals("") ){
				    	 oldemp.setCustomerID_s(customerUser.getCustomerID_s());
					 }
					 if(customerUser.getDepartment_s()!=null && !customerUser.getDepartment_s().equals("") ){
				    	 oldemp.setDepartment_s(customerUser.getDepartment_s());
					 }
					 if(customerUser.getCustomerName_s() !=null && !customerUser.getCustomerName_s().equals("")){
						 oldemp.setCustomerName_s(customerUser.getCustomerName_s());
					 }
					 if(customerUser.getEmail_s()!=null && !customerUser.getEmail_s().equals("") ){
				    	 oldemp.setEmail_s(customerUser.getEmail_s());
					 } 
					 if(customerUser.getFacsimile_s()!=null && !customerUser.getFacsimile_s().equals("") ){
				    	 oldemp.setFacsimile_s(customerUser.getFacsimile_s());
					 }
					 if(customerUser.getIdentityCard_s() !=null && !customerUser.getIdentityCard_s().equals("")){
						 oldemp.setIdentityCard_s(customerUser.getIdentityCard_s());
					 }
					 if(customerUser.getTelephone_s()!=null && !customerUser.getTelephone_s().equals("") ){
				    	 oldemp.setTelephone_s(customerUser.getTelephone_s());
					 }
					 if(customerUser.getUserType_i() !=null && !customerUser.getUserType_i().equals("")){
						 oldemp.setUserType_i(customerUser.getUserType_i());
					 }
					 if(customerUser.getCreateUser_s()!=null && !customerUser.getCreateUser_s().equals("") ){
				    	 oldemp.setCreateUser_s(customerUser.getCreateUser_s());
					 }
					 if(customerUser.getCreateDate_t()!=null && !customerUser.getCreateDate_t().equals("") ){
				    	 oldemp.setCreateDate_t(customerUser.getCreateDate_t());
					 }
					 if(customerUser.getLastUpdateDate_t() !=null && !customerUser.getLastUpdateDate_t().equals("")){
						 oldemp.setLastUpdateDate_t(customerUser.getLastUpdateDate_t());
					 }
					 if(customerUser.getLastUpdateUser_s()!=null && !customerUser.getLastUpdateUser_s().equals("") ){
				    	 oldemp.setLastUpdateUser_s(customerUser.getLastUpdateUser_s());
					 }
					 session.merge(oldemp);
				}
				session.flush();
			    session.clear();
			}
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
				    
		}
		return 1;
	}

	public String OperationBasisCustomerUser2(CustomerUser customerUser) throws Exception{
		String customeruserID = null;
		try{
			tx = session.beginTransaction();
			
			if(customerUser!=null){
				customeruserID = customerUser.getCustomerUserID_s();
				if(customeruserID == null || customeruserID.trim().equals("")){
					IsystemSequenceService isystemSequenceService = new SystemSequenceServiceImpl();
					customeruserID = isystemSequenceService.getPK(ConstantUtil.RYBusiness, session);
					customerUser.setCustomerUserID_s(customeruserID);
					session.merge(customerUser);
				}else{
					CustomerUser oldemp=(CustomerUser) session.get(customerUser.getClass(), customerUser.getCustomerUserID_s());
					 if(customerUser.getCustomerUserID_s()!=null && !customerUser.getCustomerUserID_s().equals("") ){
				    	 oldemp.setCustomerUserID_s(customerUser.getCustomerUserID_s());
					 }
					 if(customerUser.getCustomerUserName_s() !=null && !customerUser.getCustomerUserName_s().equals("")){
						 oldemp.setCustomerUserName_s(customerUser.getCustomerUserName_s());
					 }
					 if(customerUser.getCustomerID_s()!=null && !customerUser.getCustomerID_s().equals("") ){
				    	 oldemp.setCustomerID_s(customerUser.getCustomerID_s());
					 }
					 if(customerUser.getDepartment_s()!=null && !customerUser.getDepartment_s().equals("") ){
				    	 oldemp.setDepartment_s(customerUser.getDepartment_s());
					 }
					 if(customerUser.getCustomerName_s() !=null && !customerUser.getCustomerName_s().equals("")){
						 oldemp.setCustomerName_s(customerUser.getCustomerName_s());
					 }
					 if(customerUser.getEmail_s()!=null && !customerUser.getEmail_s().equals("") ){
				    	 oldemp.setEmail_s(customerUser.getEmail_s());
					 } 
					 if(customerUser.getFacsimile_s()!=null && !customerUser.getFacsimile_s().equals("") ){
				    	 oldemp.setFacsimile_s(customerUser.getFacsimile_s());
					 }
					 if(customerUser.getIdentityCard_s() !=null && !customerUser.getIdentityCard_s().equals("")){
						 oldemp.setIdentityCard_s(customerUser.getIdentityCard_s());
					 }
					 if(customerUser.getTelephone_s()!=null && !customerUser.getTelephone_s().equals("") ){
				    	 oldemp.setTelephone_s(customerUser.getTelephone_s());
					 }
					 if(customerUser.getUserType_i() !=null && !customerUser.getUserType_i().equals("")){
						 oldemp.setUserType_i(customerUser.getUserType_i());
					 }
					 if(customerUser.getCreateUser_s()!=null && !customerUser.getCreateUser_s().equals("") ){
				    	 oldemp.setCreateUser_s(customerUser.getCreateUser_s());
					 }
					 if(customerUser.getCreateDate_t()!=null && !customerUser.getCreateDate_t().equals("") ){
				    	 oldemp.setCreateDate_t(customerUser.getCreateDate_t());
					 }
					 if(customerUser.getLastUpdateDate_t() !=null && !customerUser.getLastUpdateDate_t().equals("")){
						 oldemp.setLastUpdateDate_t(customerUser.getLastUpdateDate_t());
					 }
					 if(customerUser.getLastUpdateUser_s()!=null && !customerUser.getLastUpdateUser_s().equals("") ){
				    	 oldemp.setLastUpdateUser_s(customerUser.getLastUpdateUser_s());
					 }
					 session.merge(oldemp);
				}
				session.flush();
			    session.clear();
			}
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
				    
		}
		return customeruserID;
	}
	
	public int DeleteBasisCustomerUser(CustomerUser customerUser)
			throws Exception {
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		tx = session.beginTransaction();
		try {
			if(customerUser != null)
			{
				session.delete(customerUser);
				session.flush();
				session.clear();
			}
			tx.commit();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			throw e;
		}
		finally{
			
		}
	}
 
	 
	public int OperationBasisCustomerUserList(List<CustomerUser> customerUsers,Session session) throws Exception{
		try{
			for(CustomerUser customerUser:customerUsers){
				if(customerUser!=null){
					String customeruserID = customerUser.getCustomerUserID_s();
					if(customeruserID!=null&&!"".equals(customeruserID)){
						session.merge(customerUser);
						session.flush();
					}else{
						IsystemSequenceService isystemSequenceService = new SystemSequenceServiceImpl();
						customeruserID = isystemSequenceService.getPK(ConstantUtil.RYBusiness, session);
						customerUser.setCustomerUserID_s(customeruserID);
						session.merge(customerUser);
						session.flush();
					}
				}
			}
			 
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			 
		}
		return 1;
	}
	
	public  static void main(String[] a){
		IcustomerUserService icustomerUserService = new CustomerUserServiceImpl();
		CustomerUser customerUser = new CustomerUser();	
		customerUser.setSysNo_s("0");
		List list;
		try {
			list = icustomerUserService.getCustomerUser(customerUser);
			//System.out.println(list);
	//		//System.out.println(((CustomerUser)list.get(0)).getCustomerName_s());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
