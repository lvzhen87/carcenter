package com.freshen.preorder.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: RegisterUserSearchAction.java
 *  Function:对应页面中"联系人查询"功能，根据条件查询联系人，并完成分页功能。
 *     Modifications:   
 *  @author   DateTime 2014-4-9 上午11:02:32    
 *  @version 1.0
 */
public class RegisterCustomerSearchAction extends CapgActionSupport{
	String rStr=SUCCESS;	//返回的字符串
	List<Customer> customerList;//存放客户信息
	Customer customer=new Customer();//存放单个客户信息
	List<CustomerUser> customerlist=new ArrayList<CustomerUser>();//存放客户的人员信息
	String msg,flag;
	//分页
	long totalCustomer;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	//条件查询字段
	private String customerID,customerName,departmentName,createUserName;
	//修改客户信息字段
	String customerId,customerName_s,customerLoginName_s,registerAddress_s,customerAddress_s,department_s,password_s,
	invoiceOrder_s,addedValueTax_s,customerUserPhone_s,invoiceUserID_s,invoiceAddress_s,customerUserID_s,responsibleUserID_s,resavedes1;
			
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	/**
	 * 条件查询
	 */
	public String execute() {
		//将条件查询 封装成对象
		Customer customer=new Customer();
		//由于从页面上来的 查询属性，可能是分页时 发送的，需要处理汉字编码问题
		try {
			customer.setCustomerID_s(customerID);
			if(flag!=null){
				if(customerName!=null && customerName.trim().length()>1)
					customerName=(new String(customerName.getBytes("ISO-8859-1"),"UTF-8" ));
				if(departmentName!=null&&departmentName.trim().length()>1)
					departmentName=(new String(departmentName.getBytes("ISO-8859-1"),"UTF-8" ));
				if(createUserName!=null&&createUserName.trim().length()>1)
					createUserName=(new String(createUserName.getBytes("ISO-8859-1"),"UTF-8"));
			}
			customer.setCustomerName_s(customerName);
			customer.setDepartment_s(departmentName);
			customer.setCreateUser_s(createUserName);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			ExceptionDispose.saveExceptionInfo(e1);
			e1.printStackTrace();
		}
		
		//System.out.println("查询对象  customer" + customer);
		IcustomerService icus = new CustomerServiceImpl();
		try {
			totalCustomer = icus.getCustomerNubmer(customer);
			// 计算总页数
			maxPage = (int) (totalCustomer % pageSize == 0 ? totalCustomer
					/ pageSize : totalCustomer / pageSize + 1);
			// 校验当前页码
			if (currentPage < 0)
				currentPage = 0;
			else if (currentPage > maxPage)
				currentPage = maxPage;
			//System.out.println("记录条数: " + totalCustomer + "总页数： " + maxPage + " 当前页 :" + currentPage);
			//分页查
			customerList = icus.getCustomer(customer, currentPage* pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return rStr;
	}


	
	public String prepareCustomer(){
		try {
			Customer c=new Customer();
			c.setCustomerID_s(customerID);
			
			IcustomerService ics=new CustomerServiceImpl();
			List<Customer> clist=ics.getCustomer(c, ConstantUtil.pagingNot,0);
			if(clist!=null){
				customer=clist.get(0);
			}
			
			CustomerUser cu=new CustomerUser();
			cu.setCustomerID_s(customerID);
			IcustomerUserService icus=new CustomerUserServiceImpl();
			customerlist=icus.getCustomerUser(cu);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;
	}
	
	
	public String modifyCustomer(){
		try {
			Customer c=new Customer();
			c.setCustomerID_s(customerId);
			c.setCustomerName_s(customerName_s);
			c.setDepartment_s(department_s);
			c.setCustomerUserID_s(customerUserID_s);
			c.setInvoiceOrder_s(invoiceOrder_s);
			c.setAddedValueTax_s(addedValueTax_s);
			c.setCustomerAddress_s(customerAddress_s);
			c.setCustomerUserPhone_s(customerUserPhone_s);
			c.setCustomerLoginName_s(customerLoginName_s);
			c.setInvoiceAddress_s(invoiceAddress_s);
			c.setRegisterAddress_s(registerAddress_s);
			c.setInvoiceUserID_s(invoiceUserID_s);
			c.setResponsibleUserID_s(responsibleUserID_s);
			c.setResavedes1(resavedes1);
			if(password_s == null){
				return ERROR;
			}
			if(password_s.length()>0 ){//如果初始化密码没有值就不设置
				/*MD5加密密码 */
				
				MessageDigest md5=MessageDigest.getInstance("MD5");
				//使用Base64格式对字符串进行编码
				sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
				String temp = base64Encoder.encode(md5.digest(password_s.getBytes("utf-8")));
				c.setPassword_s(temp);
				
			}
			c.setLastUpdateDate_t(DateUtil.getCurrentDate());
			c.setLastUpdateUser_s(employ.getCustomerUserName_s());
			
			List<Customer> clist=new ArrayList<Customer>();
			clist.add(c);
			
			IcustomerService ics=new CustomerServiceImpl();
			ics.OperationCustomer(clist, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public List<Customer> getCustomerList() {
		return customerList;
	}


	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}


	public long getTotalCustomer() {
		return totalCustomer;
	}


	public void setTotalCustomer(long totalCustomer) {
		this.totalCustomer = totalCustomer;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getCreateUserName() {
		return createUserName;
	}


	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}


	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public List<CustomerUser> getCustomerlist() {
		return customerlist;
	}



	public void setCustomerlist(List<CustomerUser> customerlist) {
		this.customerlist = customerlist;
	}



	public String getrStr() {
		return rStr;
	}



	public void setrStr(String rStr) {
		this.rStr = rStr;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName_s() {
		return customerName_s;
	}



	public void setCustomerName_s(String customerName_s) {
		this.customerName_s = customerName_s;
	}



	public String getCustomerLoginName_s() {
		return customerLoginName_s;
	}



	public void setCustomerLoginName_s(String customerLoginName_s) {
		this.customerLoginName_s = customerLoginName_s;
	}



	public String getRegisterAddress_s() {
		return registerAddress_s;
	}



	public void setRegisterAddress_s(String registerAddress_s) {
		this.registerAddress_s = registerAddress_s;
	}



	public String getCustomerAddress_s() {
		return customerAddress_s;
	}



	public void setCustomerAddress_s(String customerAddress_s) {
		this.customerAddress_s = customerAddress_s;
	}



	public String getDepartment_s() {
		return department_s;
	}



	public void setDepartment_s(String department_s) {
		this.department_s = department_s;
	}



	public String getInvoiceOrder_s() {
		return invoiceOrder_s;
	}



	public void setInvoiceOrder_s(String invoiceOrder_s) {
		this.invoiceOrder_s = invoiceOrder_s;
	}



	public String getAddedValueTax_s() {
		return addedValueTax_s;
	}



	public void setAddedValueTax_s(String addedValueTax_s) {
		this.addedValueTax_s = addedValueTax_s;
	}



	public String getCustomerUserPhone_s() {
		return customerUserPhone_s;
	}



	public void setCustomerUserPhone_s(String customerUserPhone_s) {
		this.customerUserPhone_s = customerUserPhone_s;
	}



	public String getInvoiceUserID_s() {
		return invoiceUserID_s;
	}



	public void setInvoiceUserID_s(String invoiceUserID_s) {
		this.invoiceUserID_s = invoiceUserID_s;
	}



	public String getInvoiceAddress_s() {
		return invoiceAddress_s;
	}



	public void setInvoiceAddress_s(String invoiceAddress_s) {
		this.invoiceAddress_s = invoiceAddress_s;
	}



	public String getCustomerUserID_s() {
		return customerUserID_s;
	}



	public void setCustomerUserID_s(String customerUserID_s) {
		this.customerUserID_s = customerUserID_s;
	}



	public String getResponsibleUserID_s() {
		return responsibleUserID_s;
	}



	public void setResponsibleUserID_s(String responsibleUserID_s) {
		this.responsibleUserID_s = responsibleUserID_s;
	}



	public String getPassword_s() {
		return password_s;
	}


	public void setPassword_s(String password_s) {
		this.password_s = password_s;
	}



	public String getResavedes1() {
		return resavedes1;
	}



	public void setResavedes1(String resavedes1) {
		this.resavedes1 = resavedes1;
	}
	
	
	
}
