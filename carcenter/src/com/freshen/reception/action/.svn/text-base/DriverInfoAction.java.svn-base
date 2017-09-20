package com.freshen.reception.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: DriverInfoAction.java
 *  Function: 驾驶员信息查询
 *     Modifications:   
 *  @author   DateTime 2014-4-14 下午04:18:37    
 *  @version 1.0
 */
public class DriverInfoAction extends CapgActionSupport {
	String rs=SUCCESS;
	Driver driver=new Driver();
	List<Driver> drivers=new ArrayList();
	List<Customer> customerListForDriver=new ArrayList<Customer>();
	
	String customerId,customerName,department,customerUserName,identityCard,telephone,position,drivingLicenceCPG,levelCPG,createUser,createDate;
	String customerUserID;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	String flag;
	
	public String execute(){
		//	yepeng add Start
		searchDriverInfo();
		//	yepeng add End
		
		return rs;
	}
	
	/**
	 *查询驾驶员信息，根据条件，默认无条件 ，全部查询 ，需要分页
	 */
	public String searchDriverInfo(){
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
			
			drivers=driverService.getBasisDriverInfo(searchdriver, currentPage*pageSize, pageSize);
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
	 *  Function:准备添加驾驶员信息
	 *  @author Freshen  DateTime 2014-4-14 下午07:48:34
	 *  @return
	 */
	public String prepareAddDriverInfo(){
		try {
			Customer custemp=new Customer();
			//如果customerId不为空，查询该公司ID和name
			if(customerId!=null){
				custemp.setCustomerID_s(customerId);
			}
		
			IcustomerService icustomerService=new CustomerServiceImpl();
			customerListForDriver=icustomerService.getCustomer(custemp, ConstantUtil.pagingNot,0);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}//查询注册公司
		return rs;
	}
	/**
	 *  Function:添加驾驶员信息
	 *  @author Freshen  DateTime 2014-4-14 下午07:48:34
	 *  @return
	 */
	public String addDriverInfo(){
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
			Employee loginee=(Employee) ActionContext.getContext().getSession().get("loginEmployee");
			adddriver.setCreateUser_s(loginee.getCustomerUserName_s());
			adddriver.setCreateDate_t(DateUtil.getCurrentDate());
			
			//System.out.println(adddriver.toString());
			
			IDriverService idriverService=new DriverServiceImpl();
			//封装要添加的驾驶员信息
			ArrayList<Driver> addDriver=new ArrayList();
			addDriver.add(adddriver);
			
			//System.out.println("333333333333");
			int result=idriverService.saveOrUpdateBasisDriverInfo(addDriver);	
			//System.out.println("===="+result);
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
	 *  Function:更新driver
	 *  @author Freshen  DateTime 2014-4-14 下午08:43:58
	 *  @return
	 */
	public String updateDriver(){
		
		return rs;
	}
	/**
	 *  Function:删除driver
	 * 
	 *  @author Freshen  DateTime 2014-4-14 下午08:44:18
	 *  @return
	 */
	public String deleteDriver(){
		
		return rs;
	}
	
	/**
	 * Function 准备培训驾驶员信息，带入参数
	 * @author sharonyshi 2014-5-7
	 * @return
	 */
	public String preparetrainDrivers(){
		try {
			//System.out.println(customerUserID);
			//设置要查询的驾驶员信息
			Driver driver=new Driver();
			driver.setCustomerUserID_s(customerUserID);
			
			IDriverService idriverService=new DriverServiceImpl();
			drivers=idriverService.getBasisDriverInfo(driver, ConstantUtil.pagingNot,0);
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
	 * Function 培训驾驶员，修改最后培训时间为当前时间
	 * @author sharonyshi 2014-4-25
	 * @return
	 */
	public String trainDrivers(){
		try {
			//培训驾驶员信息
			Driver driver=new Driver();
			driver.setCustomerID_s(customerId);
			driver.setCustomerName_s(customerName);
			driver.setCustomerUserName_s(customerUserName);
			driver.setCustomerUserID_s(customerUserID);
			driver.setDepartment_s(department);
			driver.setIdentityCard_s(identityCard);
			driver.setPosition_s(position);
			driver.setTelephone_s(telephone);
			driver.setDrivingLicenceCPG_s(drivingLicenceCPG);
			driver.setLevelCPG_s(levelCPG);
			driver.setCreateUser_s(createUser);
			driver.setCreateDate_t(DateUtil.getDate(createDate));
			driver.setLastTrainDate_t(DateUtil.getCurrentDate());
			driver.setLastUpdateUser_s(employ.getCustomerUserName_s());
			driver.setLastUpdateDate_t(DateUtil.getCurrentDate());
			
			ArrayList<Driver> temp=new ArrayList<Driver>();
			temp.add(driver);
			
			IDriverService idriverService=new DriverServiceImpl();
			int s=idriverService.saveOrUpdateBasisDriverInfo(temp);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return rs;
	}
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
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
	public List<Customer> getCustomerListForDriver() {
		return customerListForDriver;
	}
	public void setCustomerListForDriver(List<Customer> customerListForDriver) {
		this.customerListForDriver = customerListForDriver;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
	
	
}
