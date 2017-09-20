package com.freshen.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;


/**
 * 
 *     
 * 项目名称：capg    
 * 类名称：OrderDetail    
 * 类描述：    
 * 创建人：Administrator    
 * 创建时间：2014-3-26 下午02:13:29    
 * 修改人：Administrator    
 * 修改时间：2014-3-26 下午02:13:29    
 * 修改备注：    
 * @version     
 *
 */
public class OrderDetail  extends  BeanModel{
	String orderName_s; //试验名称
	String orderID_s;
	Date reservationDate_t;
	Integer status_i;
	String customerID_s;
	Date startDate_t;
	Date endDate_t;
	String customerUserID_s;
	String employeeID_s;
	String invoiceOrder_s;
	String addedValueTax_s;
	String invoiceUser_s;
	String receiveInvoiceAddress_s,invoiceUserPhone_s;
	String customerAppraise_s;
	Date createDate_t;
	String createUser_s;
	String lastUpdateUser_s;
	Date lastUpdateDate_t;
	String resaveds1;
	String resaveds2;
	String resaveds3;
	String resaveds4;
	String resaveds5;
	//外键关联
	Employee employee  = new Employee();
	Customer customer = new Customer();
	CustomerUser customerUser = new CustomerUser();
	
	//TSubscribeOrdervehicleinfo orderVehicleinfo=new TSubscribeOrdervehicleinfo();
	
	Integer ispotential ;
	
	public Integer getIspotential() {
		return ispotential;
	}
	public void setIspotential(Integer ispotential) {
		this.ispotential = ispotential;
	}
	
	
	
	public CustomerUser getCustomerUser() {
		return customerUser;
	}
	public void setCustomerUser(CustomerUser customerUser) {
		this.customerUser = customerUser;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderName_s() {
		return orderName_s;
	}
	public void setOrderName_s(String orderNameS) {
		orderName_s = orderNameS;
	}
	public String getStartDateStr(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(startDate_t);
	}
	public String getEndDateStr(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(endDate_t);
	}
	public String getEmployeeID_s() {
		return employeeID_s;
	}
	public void setEmployeeID_s(String employeeID_s) {
		this.employeeID_s = employeeID_s;
//		if(employeeID_s!=null){
//			setEmployee() ;
//		}
	}
	public String getOrderID_s() {
		return orderID_s;
	}
	public void setOrderID_s(String orderID_s) {
		this.orderID_s = orderID_s;
	}
	public Date getReservationDate_t() {
		 
		return reservationDate_t;
	}
	public void setReservationDate_t(Date reservationDate_t) {
		this.reservationDate_t = reservationDate_t;
	}
	public Integer getStatus_i() {
		return status_i;
	}
	public void setStatus_i(Integer status_i) {
		this.status_i = status_i;
	}
	public String getCustomerID_s() {
		return customerID_s;
	}
	public void setCustomerID_s(String customerID_s) {
		this.customerID_s = customerID_s;		 
	}
	
	public Date getStartDate_t() {
		return startDate_t;
	}
	public void setStartDate_t(Date startDate_t) {
		this.startDate_t = startDate_t;
	}
	public Date getEndDate_t() {
		return endDate_t;
	}
	public void setEndDate_t(Date endDate_t) {
		this.endDate_t = endDate_t;
	}
	public String getCustomerUserID_s() {
		return customerUserID_s;
	}
	public void setCustomerUserID_s(String customerUserID_s) {
		this.customerUserID_s = customerUserID_s;
		if(customerUserID_s!=null&&!customerUserID_s.trim().equals("")){
			setCustomerUser();
		}
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
	public String getInvoiceUser_s() {
		return invoiceUser_s;
	}
	public void setInvoiceUser_s(String invoiceUser_s) {
		this.invoiceUser_s = invoiceUser_s;
	}
	public String getCustomerAppraise_s() {
		return customerAppraise_s;
	}
	public void setCustomerAppraise_s(String customerAppraise_s) {
		this.customerAppraise_s = customerAppraise_s;
	}
	public Date getCreateDate_t() {
		return createDate_t;
	}
	public void setCreateDate_t(Date createDate_t) {
		this.createDate_t = createDate_t;
	}
	public String getCreateUser_s() {
		return createUser_s;
	}
	public void setCreateUser_s(String createUser_s) {
		this.createUser_s = createUser_s;
	}
	public String getLastUpdateUser_s() {
		return lastUpdateUser_s;
	}
	public void setLastUpdateUser_s(String lastUpdateUser_s) {
		this.lastUpdateUser_s = lastUpdateUser_s;
	}
	public Date getLastUpdateDate_t() {
		return lastUpdateDate_t;
	}
	public void setLastUpdateDate_t(Date lastUpdateDate_t) {
		this.lastUpdateDate_t = lastUpdateDate_t;
	}
	public String getResaveds1() {
		return resaveds1;
	}
	public void setResaveds1(String resaveds1) {
		this.resaveds1 = resaveds1;
	}
	public String getResaveds2() {
		return resaveds2;
	}
	public void setResaveds2(String resaveds2) {
		this.resaveds2 = resaveds2;
	}
	public String getResaveds3() {
		return resaveds3;
	}
	public void setResaveds3(String resaveds3) {
		this.resaveds3 = resaveds3;
	}
	public String getResaveds4() {
		return resaveds4;
	}
	public void setResaveds4(String resaveds4) {
		this.resaveds4 = resaveds4;
	}
	public String getResaveds5() {
		return resaveds5;
	}
	public void setResaveds5(String resaveds5) {
		this.resaveds5 = resaveds5;
	}
	public String getReceiveInvoiceAddress_s() {
		return receiveInvoiceAddress_s;
	}
	public void setReceiveInvoiceAddress_s(String receiveInvoiceAddress_s) {
		this.receiveInvoiceAddress_s = receiveInvoiceAddress_s;
	}
	public String getInvoiceUserPhone_s() {
		return invoiceUserPhone_s;
	}
	public void setInvoiceUserPhone_s(String invoiceUserPhone_s) {
		this.invoiceUserPhone_s = invoiceUserPhone_s;
	}
 
	public String toString() {
		return "OrderDetail [orderID_s=" + orderID_s + ", reservationDate_t="
				+ reservationDate_t + ", status_i=" + status_i
				+ ", customerID_s=" + customerID_s + ", startDate_t="
				+ startDate_t + ", endDate_t=" + endDate_t
				+ ", customerUserID_s=" + customerUserID_s + ", employeeID_s="
				+ employeeID_s + ", invoiceOrder_s=" + invoiceOrder_s
				+ ", addedValueTax_s=" + addedValueTax_s + ", invoiceUser_s="
				+ invoiceUser_s + ", receiveInvoiceAddress_s="
				+ receiveInvoiceAddress_s + ", invoiceUserPhone_s="
				+ invoiceUserPhone_s + ", customerAppraise_s="
				+ customerAppraise_s + ", createDate_t=" + createDate_t
				+ ", createUser_s=" + createUser_s + ", lastUpdateUser_s="
				+ lastUpdateUser_s + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", resaveds1=" + resaveds1 + ", resaveds2=" + resaveds2
				+ ", resaveds3=" + resaveds3 + ", resaveds4=" + resaveds4
				+ ", resaveds5=" + resaveds5 + "]";
	}
	public Employee getEmployee() {
		return employee;
	}
//	public void setEmployee() {
//		Session session=HibernateSessionFactory.getSession();
//		if(!session.isOpen()){
//			session= HibernateUtil.getSession();
//		}
//		employee=(Employee)session.get(employee.getClass(), this.getEmployeeID_s());    			
//	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer() {
		Session session=HibernateSessionFactory.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		customer=(Customer)session.get(customer.getClass(), this.getCustomerID_s());
		if(customer!=null){
			setCustomerpro(customer);
		}
	}
	public void setCustomerUser() {
		Session session=HibernateSessionFactory.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		customerUser=(CustomerUser)session.get(customerUser.getClass(), this.getCustomerUserID_s());    			
	}
	//设置order里有关customer的属性
	public void setCustomerpro(Customer customer){
	//	this.invoiceOrder_s = customer.getInvoiceOrder_s();
	//	this.addedValueTax_s = customer.getAddedValueTax_s();
	}
	
	
	
}
