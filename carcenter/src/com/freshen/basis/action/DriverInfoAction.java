package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class DriverInfoAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	Driver driver=new Driver();
	List<Driver> driverlist=new ArrayList<Driver>();
	List<Customer> customerListForDriver=new ArrayList<Customer>();
	
	String customerId,customerName,department,customerUserName,identityCard,telephone,position,drivingLicenceCPG,levelCPG,createUser,createDate;
	String customerUserID;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	/**
	 * 查询驾驶员信息，默认时查询所有驾驶员信息，当有查询条件时查询该信息
	 * @author sharonyshi 2014-5-5
	 */
	public String execute(){
		try {
			//设置要查询的驾驶员条件
			Driver searchdriver=new Driver();
			searchdriver.setCustomerUserID_s(customerUserID);
			searchdriver.setCustomerName_s(customerName);
			searchdriver.setCustomerUserName_s(customerUserName);
			searchdriver.setIdentityCard_s(identityCard);
			searchdriver.setPosition_s(position);
			
			IDriverService driverService=new DriverServiceImpl();
			//确定记录总数
			totalPages =driverService.getBasisDriverInfoNumber(searchdriver);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			driverlist=driverService.getBasisDriverInfo(searchdriver, currentPage*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	

	/**
	 *  Function:准备添加驾驶员信息
	 *  @author Freshen  DateTime 2014-4-14 下午07:48:34
	 *  @return
	 */
	public String prepareDriverInfo(){
		try {
			if(customerUserID!=null && !customerUserID.trim().equals("")){//说明更新操作
				Driver d=new Driver();
				d.setCustomerUserID_s(customerUserID);
				
				IDriverService ids=new DriverServiceImpl();
				ArrayList<Driver> result=ids.getBasisDriverInfo(d, ConstantUtil.pagingNot,0);
				if(result!=null){
					driver=result.get(0);
				}
			}
			IcustomerService ics=new CustomerServiceImpl();
			customerListForDriver=ics.getCustomer(null, ConstantUtil.pagingNot,0);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception 
		}
		return SUCCESS;
	}
	
	/**
	 * 添加新的驾驶员信息
	 * @author sharonyshi 2014-5-5
	 */
	public String addDriver(){
		try {
			Driver adddriver=new Driver();
			adddriver.setCustomerID_s(customerId);
			adddriver.setCustomerName_s(customerName);
			adddriver.setCustomerUserName_s(customerUserName);
			adddriver.setDepartment_s(department);
			adddriver.setTelephone_s(telephone);
			adddriver.setIdentityCard_s(identityCard);
			adddriver.setPosition_s(position);
			//获取登录员工name，为该操作的创建人
			adddriver.setCreateUser_s(employ.getCustomerUserName_s());
			adddriver.setCreateDate_t(DateUtil.getCurrentDate());
			
			//System.out.println(adddriver.toString());
			
			IDriverService idriverService=new DriverServiceImpl();
			//封装要添加的驾驶员信息
			ArrayList<Driver> addDriver=new ArrayList();
			addDriver.add(adddriver);
			
			int result=idriverService.saveOrUpdateBasisDriverInfo(addDriver);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	
	/**
	 * 删除驾驶员信息
	 * @author sharonyshi 2014-5-5
	 */
	public String deleteDriver(){
		try {
			Driver driver=new Driver();
			driver.setCustomerID_s(customerUserID);
			
			IDriverService idriverService=new DriverServiceImpl();
			//封装要添加的驾驶员信息
			ArrayList<Driver> dlist=new ArrayList();
			dlist.add(driver);
			//要删除用哪个方法？
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	

	public List<Driver> getDriverlist() {
		return driverlist;
	}


	public void setDriverlist(List<Driver> driverlist) {
		this.driverlist = driverlist;
	}


	public List<Customer> getCustomerListForDriver() {
		return customerListForDriver;
	}


	public void setCustomerListForDriver(List<Customer> customerListForDriver) {
		this.customerListForDriver = customerListForDriver;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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


	public String getDrivingLicenceCPG() {
		return drivingLicenceCPG;
	}


	public void setDrivingLicenceCPG(String drivingLicenceCPG) {
		this.drivingLicenceCPG = drivingLicenceCPG;
	}


	public String getLevelCPG() {
		return levelCPG;
	}


	public void setLevelCPG(String levelCPG) {
		this.levelCPG = levelCPG;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getCustomerUserID() {
		return customerUserID;
	}


	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}


	public long getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
