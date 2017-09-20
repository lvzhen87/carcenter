package com.freshen.entity.reception;

import java.util.Date;

import org.hibernate.Session;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.hibernate.HibernateSessionFactory;
import com.freshen.util.DateUtil;
import com.freshen.util.HibernateUtil;

public class ReceptionOrder  extends  BeanModel{
	
	String orderName_s;
	String  orderID_s;
	Date    reservationDate_t;
	String  reservationDate_s;//日期显示 kxc
	Integer status_i;
	String  status_s;//状态以"vv"分割
	String  customerID_s;
	Date    startDate_d,
			endDate_d;
	String  startDate_s,endDate_s;//日期显示 kxc
	String  customerUserID_s,
			capgUserID_s,
			invoiceOrder_s,
			addedValueTax_s,
			invoiceUser_s;
	Date    actualDate_d,
			createDate_t;
	String  createUser_s,
			lastUpdateUser_s;
	Date    lastUpdateDate_t;
	String  resaveds1_s,
			resaveds2_s,
			resaveds3_s,
			resaveds4_s,
			resaveds5_s;
	String receiverlnvoiceaddress_s;
	String invoiceUserPhone_s;
	String  greaterStatus_s;//大于状态
	String  lessStatus_s;//小于状态
	//外键关联 kxc 2014/05/06
	Employee employee  = new Employee();
	Customer customer = new Customer();
	CustomerUser customerUser = new CustomerUser();
	 
	int testVehicleNumber_i;//试验车辆数，用于试验场管理的查询显示，sharonyshi-2014-6-5	
	Integer ispotential ;
	
	
	public String getInvoiceUserPhone_s() {
		return invoiceUserPhone_s;
	}
	public void setInvoiceUserPhone_s(String invoiceUserPhoneS) {
		invoiceUserPhone_s = invoiceUserPhoneS;
	}
	public String getReceiverlnvoiceaddress_s() {
		return receiverlnvoiceaddress_s;
	}
	public void setReceiverlnvoiceaddress_s(String receiverlnvoiceaddressS) {
		receiverlnvoiceaddress_s = receiverlnvoiceaddressS;
	}
	public Integer getIspotential() {
		return ispotential;
	}
	public void setIspotential(Integer ispotential) {
		this.ispotential = ispotential;
	}
	public int getTestVehicleNumber_i() {
		return testVehicleNumber_i;
	}
	public void setTestVehicleNumber_i(int testVehicleNumber_i) {
		this.testVehicleNumber_i = testVehicleNumber_i;
	}
	public String getReservationDate_s() {
		return reservationDate_s;
	}
	public void setReservationDate_s(String reservationDateS) {
		reservationDate_s = reservationDateS;
	}
	public String getStartDate_s() {
		return startDate_s;
	}
	public void setStartDate_s(String startDateS) {
		startDate_s = startDateS;
	}
	public String getEndDate_s() {
		return endDate_s;
	}
	public void setEndDate_s(String endDateS) {
		endDate_s = endDateS;
	}
	public String getOrderName_s() {
		return orderName_s;
	}
	public void setOrderName_s(String orderNameS) {
		orderName_s = orderNameS;
	}
	public void setEmployee() {
		Session session=HibernateSessionFactory.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		employee=(Employee)session.get(Employee.class, this.getCapgUserID_s());    			
	}
	public void setCustomer() {
		/*Session session=HibernateSessionFactory.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}*/
		/*customer=(Customer)session.get(Customer.class, this.getCustomerID_s());
		if(customer!=null){
			setCustomerpro(customer);
		}*/
	}
	public void setCustomerUser() {
		Session session=HibernateSessionFactory.getSession();
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		customerUser=(CustomerUser)session.get(CustomerUser.class, this.getCustomerUserID_s());
	}
	//设置order里有关customer的属性
	public void setCustomerpro(Customer customer){
		this.invoiceOrder_s = customer.getInvoiceOrder_s();
		this.addedValueTax_s = customer.getAddedValueTax_s();
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		if(customer!=null){
			this.customerID_s = customer.getCustomerID_s();
		}
		this.customer = customer;
	}
	public CustomerUser getCustomerUser() {
		return customerUser;
	}
	public void setCustomerUser(CustomerUser customerUser) {
		this.customerUser = customerUser;
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
		reservationDate_s = DateUtil.dateToString(reservationDate_t, "yyyy-MM-dd");		
	}
	public Integer getStatus_i() {
		return status_i;
	}
	public void setStatus_i(Integer status_i) {
		this.status_i = status_i;
	}
	
	public String getStatus_s() {
		return status_s;
	}
	public void setStatus_s(String statusS) {
		status_s = statusS;
	}
	public String getCustomerID_s() {
		return customerID_s;
	}
	public void setCustomerID_s(String customerID_s) {
		this.customerID_s = customerID_s;
		if(customerID_s!=null){
			this.customer.setCustomerID_s(customerID_s);
		}	
	}
	public Date getStartDate_d() {
		
		
		return startDate_d;
	}
	public void setStartDate_d(Date startDate_d) {
		this.startDate_d = startDate_d;
		startDate_s = DateUtil.dateToString(startDate_d, "yyyy-MM-dd");
	}
	public Date getEndDate_d() {
		return endDate_d;
	}
	public void setEndDate_d(Date endDate_d) {
		this.endDate_d = endDate_d;
		endDate_s = DateUtil.dateToString(endDate_d, "yyyy-MM-dd");	
	}
	public String getCustomerUserID_s() {
		return customerUserID_s;
	}
	public void setCustomerUserID_s(String customerUserID_s) {
		this.customerUserID_s = customerUserID_s;
		if(customerUserID_s!=null){
			setCustomerUser();
		}	
	}
	public String getCapgUserID_s() {
		return capgUserID_s;
	}
	public void setCapgUserID_s(String capgUserID_s) {
		this.capgUserID_s = capgUserID_s;
		 
		if(capgUserID_s!=null){
			setEmployee() ;
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
	public Date getActualDate_d() {
		return actualDate_d;
	}
	public void setActualDate_d(Date actualDate_d) {
		this.actualDate_d = actualDate_d;
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
	public String getResaveds1_s() {
		return resaveds1_s;
	}
	public void setResaveds1_s(String resaveds1_s) {
		this.resaveds1_s = resaveds1_s;
	}
	public String getResaveds2_s() {
		return resaveds2_s;
	}
	public void setResaveds2_s(String resaveds2_s) {
		this.resaveds2_s = resaveds2_s;
	}
	public String getResaveds3_s() {
		return resaveds3_s;
	}
	public void setResaveds3_s(String resaveds3_s) {
		this.resaveds3_s = resaveds3_s;
	}
	public String getResaveds4_s() {
		return resaveds4_s;
	}
	public void setResaveds4_s(String resaveds4_s) {
		this.resaveds4_s = resaveds4_s;
	}
	public String getResaveds5_s() {
		return resaveds5_s;
	}
	public void setResaveds5_s(String resaveds5_s) {
		this.resaveds5_s = resaveds5_s;
	}
		
	public String getGreaterStatus_s() {
		return greaterStatus_s;
	}
	public void setGreaterStatus_s(String greaterStatusS) {
		greaterStatus_s = greaterStatusS;
	}
	
	
	public String getLessStatus_s() {
		return lessStatus_s;
	}
	public void setLessStatus_s(String lessStatusS) {
		lessStatus_s = lessStatusS;
	}
	@Override
	public String toString() {
		return "ReceptionOrder [actualDate_d=" + actualDate_d
				+ ", addedValueTax_s=" + addedValueTax_s + ", capgUserID_s="
				+ capgUserID_s + ", createDate_t=" + createDate_t
				+ ", createUser_s=" + createUser_s + ", customer=" + customer
				+ ", customerID_s=" + customerID_s + ", customerUser="
				+ customerUser + ", customerUserID_s=" + customerUserID_s
				+ ", employee=" + employee + ", endDate_d=" + endDate_d
				+ ", endDate_s=" + endDate_s + ", invoiceOrder_s="
				+ invoiceOrder_s + ", invoiceUserPhone_s=" + invoiceUserPhone_s
				+ ", invoiceUser_s=" + invoiceUser_s + ", ispotential="
				+ ispotential + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s + ", orderID_s="
				+ orderID_s + ", orderName_s=" + orderName_s
				+ ", receiverlnvoiceaddress_s=" + receiverlnvoiceaddress_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", reservationDate_s=" + reservationDate_s
				+ ", reservationDate_t=" + reservationDate_t + ", startDate_d="
				+ startDate_d + ", startDate_s=" + startDate_s + ", status_i="
				+ status_i + ", status_s=" + status_s
				+ ", testVehicleNumber_i=" + testVehicleNumber_i + "]";
	}
	 


}
