package com.freshen.basis.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.basis.service.ICustomerUserViewService;
import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.IDriverTRuleService;
import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IorganizationDeptService;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.DriverTrainingRule;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.ExpendRecord;
import com.freshen.entity.basis.OrganizationDept;
import com.freshen.entity.basis.VCustomeuser;

import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DataResource;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;import com.freshen.util.Page;
import com.freshen.clims.baseclass.ClimsServiceBase;

public class CutomerUserViewServiceimpl extends ClimsServiceBase implements ICustomerUserViewService {
	String customername ;
	String customeruserid_s;
	String department_s;
	String customerusername_s; 
	String identitycard_s;
	String position_s; 
	String telephone_s; 
	String facsimile_s;
	String email_s;
	int usertypeI; 
	Date createdateT;
	String createuser_s; 
	String lastupdateuser_s;
	Date lastupdatedateT;
	String resaveds1_s; 
	String resaveds2_s; 
	String resaveds3_s;
	String resaveds4_s;
	String resaveds5_s; 
	String customerid_s;
	String invoiceaddress_s;
	String registeraddress_s;
	String responsibleuserid_s;
	String invoiceuserid_s;
	Boolean ispotential; 
	String emplycode_s; 
	String empbrithday_t;
	String emplyusertype_s;
	String emplypass_s;
	String emplysex_s;
	Date empbirthdayT;
	String duty_s;
	String nation_s; 
	String degree_s; 
	String address_s;
	String memo_s; 
	String sysno_s;
	
	String customerName_s;
	String drivingLicenceCPG_s,levelCPG_s;
	Date lastTrainDate_t,lastTestDate_t;
	
	
	//Session session= HibernateUtil.getSession();
	Transaction tx = null;
	
	public long getCustomerUserNumber(VCustomeuser vcustomeuser) throws Exception {
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try {
			List list=new ArrayList<VCustomeuser>();
			if(vcustomeuser == null){
				String hql="select count(*) from VCustomeuser"; 
				Query query=session.createQuery(hql);
			    long n=0;
			    if(query.iterate().hasNext()){
			    	n=(Long) query.iterate().next();
			    }    
				return n;
			}
			//	20140812 Yepeng Update Add
			//customername=vcustomeuser.getCustomername();
			customername = vcustomeuser.getCustomerName_s();
			//	20140812 Yepeng Update End
			customerid_s=vcustomeuser.getCustomerid_s();
			customeruserid_s=vcustomeuser.getCustomeruserid_s();
			customerusername_s=vcustomeuser.getCustomerusername_s();
			department_s=vcustomeuser.getDepartment_s();
			drivingLicenceCPG_s=vcustomeuser.getDrivingLicenceCPG_s();
			levelCPG_s=vcustomeuser.getLevelCPG_s();
			email_s=vcustomeuser.getEmail_s();
			usertypeI=vcustomeuser.getUsertypeI();
			
			String hql="select count(*) from VCustomeuser as vcustomeuser where 1=1 "; 
		    String condition = "";
		    if(customername!=null&&!customername.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.customername='"+customername+"'";
		    	condition += " and vcustomeuser.customername like '%" + customername + "%'";
		    	//	20140812 Yepeng Update End
		    }			    
		    if(customerid_s!=null&&!customerid_s.equals("")){
		    	condition += " and vcustomeuser.customerid_s='"+customerid_s+"'";
		    }
		    if(customeruserid_s!=null&&!customeruserid_s.equals("")){
				condition += " and vcustomeuser.customeruserid_s='"+customeruserid_s+"'";
		    }		    
		    if(customerusername_s!=null&&!customerusername_s.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.customerusername_s='"+customerusername_s+"'";
		    	condition += " and vcustomeuser.customerusername_s like '%" + customerusername_s + "%'";
		    	//	20140812 Yepeng Update End
		    }
		    if(department_s!=null&&!department_s.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.department_s ='"+department_s+"'";
		    	condition += " and vcustomeuser.department_s like '%" + department_s + "%'";
		    	//	20140812 Yepeng Update End
		    }	    
		    if(drivingLicenceCPG_s!=null&&!drivingLicenceCPG_s.equals("")){
		    	condition += " and vcustomeuser.drivingLicenceCPG_s='"+drivingLicenceCPG_s+"'";
		    }
		    if(levelCPG_s!=null&&!levelCPG_s.equals("")){
				condition += " and vcustomeuser.levelCPG_s='"+levelCPG_s+"'";
		    }		    
		    if(email_s!=null&&!email_s.equals("")){
		    	condition += " and vcustomeuser.email_s='"+email_s+"'";
		    }
		    if(usertypeI != 0){
		    	condition += " and vcustomeuser.usertypeI='"+usertypeI+"'";
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


	public ArrayList<VCustomeuser> getCustomerUser(VCustomeuser vcustomeuser,int start,int size)
			throws Exception {
		Session session= HibernateUtil.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try {			
			List<VCustomeuser> list = new ArrayList<VCustomeuser>();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(vcustomeuser==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from VCustomeuser");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}
			
			//	20140812 Yepeng Update Add
			//customername=vcustomeuser.getCustomername();
			customername = vcustomeuser.getCustomerName_s();
			//	20140812 Yepeng Update End
			customerid_s=vcustomeuser.getCustomerid_s();
			customeruserid_s=vcustomeuser.getCustomeruserid_s();
			customerusername_s=vcustomeuser.getCustomerusername_s();
			department_s=vcustomeuser.getDepartment_s();
			drivingLicenceCPG_s=vcustomeuser.getDrivingLicenceCPG_s();
			levelCPG_s=vcustomeuser.getLevelCPG_s();
			email_s=vcustomeuser.getEmail_s();
			usertypeI=vcustomeuser.getUsertypeI();
			
			String hql="from VCustomeuser as vcustomeuser where 1=1 "; 
		    String condition = "";
		    if(customername!=null&&!customername.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.customername='"+customername+"'";
		    	condition += " and vcustomeuser.customername like '%" + customername + "%'";
		    	//	20140812 Yepeng Update End
		    }		    
		    if(customerid_s!=null&&!customerid_s.equals("")){
		    	condition += " and vcustomeuser.customerid_s='"+customerid_s+"'";
		    }
		    if(customeruserid_s!=null&&!customeruserid_s.equals("")){
				condition += " and vcustomeuser.customeruserid_s='"+customeruserid_s+"'";
		    }		    
		    if(customerusername_s!=null&&!customerusername_s.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.customerusername_s='"+customerusername_s+"'";
		    	condition += " and vcustomeuser.customerusername_s like '%" + customerusername_s + "%'";
		    	//	20140812 Yepeng Update End
		    }
		    if(department_s!=null&&!department_s.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.department_s ='"+department_s+"'";
		    	condition += " and vcustomeuser.department_s like '%" + department_s + "%'";
		    	//	20140812 Yepeng Update End
		    }		    
		    if(drivingLicenceCPG_s!=null&&!drivingLicenceCPG_s.equals("")){
		    	condition += " and vcustomeuser.drivingLicenceCPG_s='"+drivingLicenceCPG_s+"'";
		    }
		    if(levelCPG_s!=null&&!levelCPG_s.equals("")){
				condition += " and vcustomeuser.levelCPG_s='"+levelCPG_s+"'";
		    }		    
		    if(email_s!=null&&!email_s.equals("")){
		    	condition += " and vcustomeuser.email_s='"+email_s+"'";
		    }
		    if(usertypeI != 0){
		    	condition += " and vcustomeuser.usertypeI='"+usertypeI+"'";
		    }
		    condition += " order by vcustomeuser.createdateT DESC,vcustomeuser.lastupdatedateT DESC";
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    
		    list = query.list();
		    
		    return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();		    
		}			
	}
	
	
	
	/**
	 * 查询进入到试验场
	 * getIndata
	 * 
	 * @param		String strSysNo
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public ArrayList<CustomerUser> getIndata(String dptName, String emplyName, Page page) throws Exception{
		//System.out.println("page===="+page.toString());
		ArrayList<CustomerUser> customerUserList = new ArrayList();
		IcustomerUserService iuserService = new CustomerUserServiceImpl();
		IcustomerService icustomerService = new CustomerServiceImpl();
		IemployeeService iemployeeService = new EmployeeServiceImpl();
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		IDriverService ids=new DriverServiceImpl();		
		
		//	立方数据库连接
    	Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;
				
		String sql = " select t.serial,t.iodate,t1.EmplyName,t1.DptId,t2.DptName " +
					 " from Mj_Clims_Indata t,pb_emply t1,pb_depart t2 " +
					 " where " +
					 " t.serial = t1.Serial " +
					 " and t1.DptId=t2.DptId ";
		if(null != dptName && !"".equals(dptName.trim())){
			sql += " and t2.DptName like '%"+dptName+"%'";
		}
		if(null != emplyName && !"".equals(emplyName.trim())){
			sql += " and t1.EmplyName like '%"+emplyName+"%'";
		} 
		sql += "order by t.iodate desc";
		prest = sqlcon.prepareStatement(sql ,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		prest.setMaxRows(page.getEndIndex());		//	关键代码，设置最大记录数为当前页记录的截止下标 
		ResultSet rs = prest.executeQuery();

		if (page.getBeginIndex() > 0) { 
			rs.absolute(page.getBeginIndex());		//	关键代码，直接移动游标为当前页起始记录处 
		}
		while (rs.next()) {
			CustomerUser tmp = new CustomerUser();
			String serial = rs.getString("serial");//人员id
			tmp.setSysNo_s(serial);
			//得到客户人员的信息
			ArrayList<CustomerUser> list = iuserService.getCustomerUser(tmp);
			if(BasicTools.isnotNull(list)){//是客户人员
				tmp = list.get(0);
				//所属公司
				String customerID = tmp.getCustomerID_s();
				Customer customer = new Customer();
				customer.setCustomerID_s(customerID);
				ArrayList<Customer> customerlist = icustomerService.getCustomer(customer, ConstantUtil.pagingNot, 0);
				if(BasicTools.isnotNull(customerlist)){
					tmp.setCustomerName_s(customerlist.get(0).getCustomerName_s());
				}
			}else{//是职员
				Employee employee = new Employee();
				employee.setResaveds1_s(serial);
				List<Employee> employeelist = iemployeeService.getEmployees(employee, ConstantUtil.pagingNot, 0);
				if(BasicTools.isnotNull(employeelist)){
					employee = employeelist.get(0);
					OrganizationDept organizationDept = new OrganizationDept();
					organizationDept.setOrganizationDept_s("1");//获得根节点
					organizationDept = iorganizationDeptService.getOrganizationDept(organizationDept, ConstantUtil.pagingNot, 0).get(0);
					tmp.setCustomerName_s(organizationDept.getDeptName_s());					
				}
			}
			String iodate = rs.getString("iodate");
			//String temp = tempTime.replace(":", "");
			tmp.setIodate(DateUtil.strToDate(iodate, "yyyy-MM-dd HH:mm:ss"));
			tmp.setCustomerUserName_s(rs.getString("EmplyName"));
			tmp.setDepartment_s(rs.getString("DptName"));
			tmp.setCard_s(serial);
			customerUserList.add(tmp);			
		}
		return customerUserList;
	}

	
	/**
	 * 查询进入到试验场人员总数
	 * getIndataNumber
	 * 
	 * @param		String strSysNo
	 * @return		ArrayList    
	 * @throws		Exception 
	 * @Exception	异常对象    
	 * @since		CodingExample　
	 */
	public int getIndataNumber(String dptName, String emplyName) throws Exception{
		ArrayList<CustomerUser> customerUserList = new ArrayList();
		IcustomerUserService iuserService = new CustomerUserServiceImpl();
		IcustomerService icustomerService = new CustomerServiceImpl();
		IemployeeService iemployeeService = new EmployeeServiceImpl();
		IorganizationDeptService iorganizationDeptService = new OrganizationDeptServiceImpl();
		IDriverService ids=new DriverServiceImpl();		
		
		//	立方数据库连接
    	Connection sqlcon = DataResource.getConnect(ConstantUtil.OneCardSERVERCONN);
		PreparedStatement prest = null;				
		String sql = " select count(*)" +
					 " from Mj_Clims_Indata t,pb_emply t1,pb_depart t2 " +
					 " where " +
					 " t.serial = t1.Serial " +
					 " and t1.DptId=t2.DptId";
		if(null != dptName && !"".equals(dptName.trim())){
			sql += " and t2.DptName like '%"+dptName+"%'";
			 
		} 
		if(null != emplyName && !"".equals(emplyName.trim())){
			sql += " and t1.EmplyName like '%"+emplyName+"%'";
			 
		} 
		prest = sqlcon.prepareStatement(sql );
		
	 	//	关键代码，设置最大记录数为当前页记录的截止下标 
		ResultSet rs = prest.executeQuery();
		int number =0;
		while (rs.next()) {
			number = rs.getInt(1);
		}
		return number;
	}
	
	public static void main(String[] a){
		CutomerUserViewServiceimpl c = new CutomerUserViewServiceimpl();
		try {
			int i = c.getIndataNumber("安" , "");
			//System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<VCustomeuser> getCusUserforReception(
			VCustomeuser vcustomeuser, int start, int size) throws Exception {
		// TODO Auto-generated method stub		 
		Session	session= HibernateUtil.getSession();		 
		try {			
			List<VCustomeuser> list = new ArrayList<VCustomeuser>();
			//CustomerUser customerUsermodel = new CustomerUser();
			if(vcustomeuser==null){
				//System.out.println("执行无条件查询 分页");
				Query query=session.createQuery("from VCustomeuser");
				if(start!=ConstantUtil.pagingNot){
					query.setFirstResult(start);
				    query.setMaxResults(size);
				}
			    list = query.list();	  			
				return (ArrayList) list;
			}			
			//	20140812 Yepeng Update Add			
			customername = vcustomeuser.getCustomerName_s();
			//	20140812 Yepeng Update End
			customerid_s=vcustomeuser.getCustomerid_s();
			customeruserid_s=vcustomeuser.getCustomeruserid_s();
			customerusername_s=vcustomeuser.getCustomerusername_s();
			department_s=vcustomeuser.getDepartment_s();
			drivingLicenceCPG_s=vcustomeuser.getDrivingLicenceCPG_s();
			levelCPG_s=vcustomeuser.getLevelCPG_s();
			email_s=vcustomeuser.getEmail_s();
			usertypeI=vcustomeuser.getUsertypeI();
			
			String hql="from VCustomeuser as vcustomeuser where 1=1 "; 
		    String condition = "";
		    if(customername!=null&&!customername.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.customername='"+customername+"'";
		    	condition += " and vcustomeuser.customername like '%" + customername + "%'";
		    	//	20140812 Yepeng Update End
		    }		    
		    if(customerid_s!=null&&!customerid_s.equals("")){
		    	condition += " and vcustomeuser.customerid_s='"+customerid_s+"'";
		    }
		    if(customeruserid_s!=null&&!customeruserid_s.equals("")){
				condition += " and vcustomeuser.customeruserid_s='"+customeruserid_s+"'";
		    }		    
		    if(customerusername_s!=null&&!customerusername_s.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.customerusername_s='"+customerusername_s+"'";
		    	condition += " and vcustomeuser.customerusername_s like '%" + customerusername_s + "%'";
		    	//	20140812 Yepeng Update End
		    }
		    if(department_s!=null&&!department_s.trim().equals("")){
				//	20140812 Yepeng Update Add
				//condition += " and vcustomeuser.department_s ='"+department_s+"'";
		    	condition += " and vcustomeuser.department_s like '%" + department_s + "%'";
		    	//	20140812 Yepeng Update End
		    }		    
		    if(drivingLicenceCPG_s!=null&&!drivingLicenceCPG_s.equals("")){
		    	condition += " and vcustomeuser.drivingLicenceCPG_s='"+drivingLicenceCPG_s+"'";
		    }
		    if(levelCPG_s!=null&&!levelCPG_s.equals("")){
				condition += " and vcustomeuser.levelCPG_s='"+levelCPG_s+"'";
		    }		    
		    if(email_s!=null&&!email_s.equals("")){
		    	condition += " and vcustomeuser.email_s='"+email_s+"'";
		    }
		    if(usertypeI != 0){
		    	condition += " and vcustomeuser.usertypeI='"+usertypeI+"'";
		    }
		    Query query=session.createQuery(hql+condition);
		    if(start!=ConstantUtil.pagingNot){
			    query.setFirstResult(start);
			    query.setMaxResults(size);
		    }
		    
		    list = query.list();
		    
		    IDriverTRuleService idrs=new DriverTRuleServiceImpl();
		    DriverTrainingRule dr=idrs.getTrainingRule(null);
		    //驾驶员判断是否需要培训
		    for (int i = 0; i < list.size(); i++) {
		    	if(list.get(i).getUsertypeI() < 3){
		    		continue;
		    	}else{
		    		//System.out.println(list.get(i).getLastTestDate_t()+","+DateUtil.getCurrentDate());
		    		//如果驾驶员培训规则存在，当前驾驶员的最后培训日期也存在，那么计算当前时间与最后培训日期时间相差天数
		    		if(dr != null && dr.getDay_i() > 0  ){
		    			if(list.get(i).getLastTestDate_t() != null){
			    			int days=DateUtil.timeInterval(list.get(i).getLastTestDate_t(),DateUtil.getCurrentDate());
					    	//System.out.println("days-->"+days);
					    	//如果超过了培训规则日期，则必须继续培训
					    	if(days > dr.getDay_i()){
					    		list.get(i).setIsTrain(0);
					    	}else{//否则可以直接加入试验
					    		list.get(i).setIsTrain(1);
					    	}
				    	}else{//如果当前日期不存在，则必须先进行培训
				    		list.get(i).setIsTrain(0);
				    	}
		    		}else{
		    			list.get(i).setIsTrain(1);
		    		}			    	
		    	} 	
			}
		    
		    return (ArrayList) list;
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			session.clear();
		    
		}
	}
}
