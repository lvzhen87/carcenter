package com.freshen.reception.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Driver;
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

public class CustomerUserAction extends CapgActionSupport{
	String rs=SUCCESS;
	CustomerUser customeruser=new CustomerUser();
	List<CustomerUser> userList=new ArrayList();
	
	List<Customer> customerListForUser=new ArrayList<Customer>();
	
	//页面传过来的值
	String customerId,customerName,department,customerUserName,identityCard,telephone,position,facsimile,email;
	int userType;
	

	/**
	 *查询CustomerUser信息，根据条件，默认无条件 ，全部查询 ，需要分页
	 */
	public String execute(){
		
		return rs;
	}
	/**
	 *  Function:准备添加CustomerUser
	 *  @author sharonyshi  DateTime 2014-4-20 下午07:48:34
	 *  @return
	 */
	public String prepareAddCustomerUser(){
		try {
			Customer custemp=new Customer();
			//如果customerId不为空，查询该公司ID和name
			if(customerId!=null){
				custemp.setCustomerID_s(customerId);
			}
		
			IcustomerService icustomerService=new CustomerServiceImpl();
			customerListForUser=icustomerService.getCustomer(custemp, ConstantUtil.pagingNot,0);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return rs;
	}
	/**
	 *  Function:添加CustomerUser
	 *  @author sharonyshi  DateTime 2014-4-20 下午07:48:34
	 *  @return
	 */
	public String addCustomerUser(){
		try {
			CustomerUser addUser=new CustomerUser();
			addUser.setCustomerID_s(customerId);
			addUser.setCustomerUserName_s(customerUserName);
			addUser.setDepartment_s(department);
			addUser.setIdentityCard_s(identityCard);
			addUser.setPosition_s(position);
			addUser.setTelephone_s(telephone);
			addUser.setFacsimile_s(facsimile);
			addUser.setEmail_s(email);
			addUser.setUserType_i(userType);
			//获取登录员工name，为该操作的创建人
			Employee loginee=(Employee) ActionContext.getContext().getSession().get("loginEmployee");
			addUser.setCreateUser_s(loginee.getCustomerUserName_s());
			addUser.setCreateDate_t(DateUtil.getCurrentDate());
			//System.out.println(addUser.toString());
			
			
			IcustomerUserService iuserService=new CustomerUserServiceImpl();
			int result=iuserService.OperationBasisCustomerUser(addUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
 			
		}
		
		return rs;
	}
	/**
	 *  Function:更新CustomerUser
	 *  @author sharonyshi  DateTime 2014-4-20下午08:43:58
	 *  @return
	 */
	public String updateCustomerUser(){
		
		return rs;
	}
	/**
	 *  Function:删除CustomerUser
	 * 
	 *  @author sharonyshi  DateTime 2014-4-20 下午08:44:18
	 *  @return
	 */
	public String deleteCustomerUser(){
		
		return rs;
	}
	public List<CustomerUser> getUserList() {
		return userList;
	}
	public void setUserList(List<CustomerUser> userList) {
		this.userList = userList;
	}
	public List<Customer> getCustomerListForUser() {
		return customerListForUser;
	}
	public void setCustomerListForUser(List<Customer> customerListForUser) {
		this.customerListForUser = customerListForUser;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public CustomerUser getCustomeruser() {
		return customeruser;
	}
	public void setCustomeruser(CustomerUser customeruser) {
		this.customeruser = customeruser;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFacsimile() {
		return facsimile;
	}
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	
}
