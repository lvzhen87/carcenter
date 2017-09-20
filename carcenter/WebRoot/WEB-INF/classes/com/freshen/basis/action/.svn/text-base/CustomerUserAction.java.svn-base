package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.ICustomerUserViewService;
import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.CutomerUserViewServiceimpl;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.VCustomeuser;
import com.freshen.preorder.service.IcustomerRegisterService;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.impl.CustomerRegisterServiceimpl;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class CustomerUserAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	CustomerUser customeruser=new CustomerUser();
	VCustomeuser vcustomeruser=new VCustomeuser();
	List<VCustomeuser> userList=new ArrayList<VCustomeuser>();
	
	List<Customer> customerListForUser=new ArrayList<Customer>();

	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	//页面传过来的值
	String customerUserID,customerId,customerName,department,customerUserName,identityCard,telephone,position,facsimile,email;
	String drivingLicenceCPG_s;
	private int search=0;	//标识  确定是否 由搜索按钮 进入该Action
	int userType;

	String msg, flag;
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=14;
	
	/**
	 * 默认查询所有客户人员基础信息，当有查询条件时查询该信息
	 * @author sharonyshi 2014-7-ConstantUtil.pageSize
	 */
	public String execute(){
		try {
//			CustomerUser cu=new CustomerUser();
//			cu.setCustomerName_s(customerName);
//			cu.setCustomerUserName_s(customerUserName);
//			cu.setDepartment_s(department);
//			cu.setUserType_i(userType);
			//逻辑变化，从  由客户人员和驾驶员表 所组成的视图中 查找信息  by freshen
			VCustomeuser vu=null;
//			if(search>0){
//				vu=new VCustomeuser();
//				vu.setCustomerName_s(customerName);
//				vu.setCustomerusername_s(customerUserName);
//				vu.setDepartment_s(department);
//				if(userType>0)		//-1为查询 全部人员
//					vu.setUsertypeI(userType);
//			}
			/*if(flag!=null){
				if(customerName!=null && customerName.trim().length()>1)
					customerName=(new String(customerName.getBytes("ISO-8859-1"),"UTF-8" ));
				if(department!=null&&department.trim().length()>1)
					department=(new String(department.getBytes("ISO-8859-1"),"UTF-8" ));
				if(customerUserName!=null&&customerUserName.trim().length()>1)
					customerUserName=(new String(customerUserName.getBytes("ISO-8859-1"),"UTF-8" ));
			}*/
			vu=new VCustomeuser();
			vu.setCustomerName_s(customerName);
			vu.setCustomerusername_s(customerUserName);
			vu.setDepartment_s(department);
			if(userType>0)		//-1为查询 全部人员
				vu.setUsertypeI(userType);
			
			
//			IcustomerUserService icus=new CustomerUserServiceImpl();
			ICustomerUserViewService ivus=new CutomerUserViewServiceimpl();
			//确定记录总数
			totalPages =ivus.getCustomerUserNumber(vu);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			if(totalPages > 0){
				userList=ivus.getCustomerUser(vu,currentPage*pageSize, pageSize);
			}
			
			//System.out.println("查出客户人员 数量 ："+userList.size());
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return SUCCESS;
	}
	
	
	/**
	 * 添加新的客户人员信息
	 * @author sharonyshi 2014-7-ConstantUtil.pageSize
	 */
	public String prepareCustomerUser(){
		try {
			
			VCustomeuser custemp=new VCustomeuser();
			//如果customerUserID不为空，查询该公司ID和name,说明是更新操作
			if(customerUserID!=null){
				custemp.setCustomeruserid_s(customerUserID);
				ICustomerUserViewService ivus=new CutomerUserViewServiceimpl();
				userList=ivus.getCustomerUser(custemp, ConstantUtil.pagingNot, 0);
				IcustomerService ics = new CustomerServiceImpl();
				customerListForUser = ics.getCustomer(null, -1, 0);
				if(userList!=null){
					vcustomeruser=userList.get(0);
				}
	
			}else{//说明是新增操作，需要查询客户信息
				IcustomerService icustomerService=new CustomerServiceImpl();
				customerListForUser=icustomerService.getCustomer(null, ConstantUtil.pagingNot,0);
				vcustomeruser =null;
			}

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
	 * 添加新的客户人员信息
	 * @author sharonyshi 2014-7-ConstantUtil.pageSize
	 */
	public String addCustomerUser(){
		try {
			//说明是驾驶员 
			if(userType ==3){
				Driver driver=new Driver();
				if(customerUserID !=null && !customerUserID.equals("")){//说明是更新操作
					driver.setLastUpdateDate_t(DateUtil.getCurrentDate());
					driver.setLastUpdateUser_s(employ.getCustomerUserName_s());
				}else{//说明是新增操作
					driver.setCreateDate_t(DateUtil.getCurrentDate());
					driver.setCreateUser_s(employ.getCustomerUserName_s());
					driver.setLastUpdateDate_t(DateUtil.getCurrentDate());
				}
				
				driver.setCustomerUserID_s(customerUserID);
				driver.setCustomerID_s(customerId);
				driver.setCustomerName_s(customerName);
				driver.setCustomerUserName_s(customerUserName);
				driver.setTelephone_s(telephone);
				driver.setDepartment_s(department);
				driver.setPosition_s(position);
				driver.setDrivingLicenceCPG_s(drivingLicenceCPG_s);
				driver.setIdentityCard_s(identityCard);
				driver.setEmail_s(email);
				//driver.setUserType_i(userType);
				ArrayList<Driver> dlist=new ArrayList<Driver>();
				dlist.add(driver);
				
				IDriverService ids=new DriverServiceImpl();
				ids.saveOrUpdateBasisDriverInfo(dlist);
				
			}else{
				CustomerUser addUser=new CustomerUser();
				if(customerUserID !=null && !customerUserID.equals("")){//说明是更新操作
					addUser.setLastUpdateDate_t(DateUtil.getCurrentDate());
					addUser.setLastUpdateUser_s(employ.getCustomerUserName_s());
				}else{//说明是新增操作
					addUser.setCreateDate_t(DateUtil.getCurrentDate());
					addUser.setCreateUser_s(employ.getCustomerUserName_s());
					addUser.setLastUpdateDate_t(DateUtil.getCurrentDate());
				}
				addUser.setCustomerUserID_s(customerUserID);
				addUser.setCustomerID_s(customerId);
				addUser.setCustomerUserName_s(customerUserName);
				addUser.setDepartment_s(department);
				addUser.setIdentityCard_s(identityCard);
				addUser.setPosition_s(position);
				addUser.setTelephone_s(telephone);
				addUser.setFacsimile_s(facsimile);
				addUser.setEmail_s(email);
				addUser.setUserType_i(userType);
				
				IcustomerUserService iuserService=new CustomerUserServiceImpl();
				int result=iuserService.OperationBasisCustomerUser(addUser);
			}	
			
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
	 * 删除客户人员信息
	 * @author sharonyshi 2014-7-ConstantUtil.pageSize
	 */
	public String deleteCustomerUser(){
		try {

			IcustomerRegisterService irs=new CustomerRegisterServiceimpl();
			boolean istrue=irs.isCustomerUserhere(customerUserID);
			if(istrue){
				//说明存在不能删除
				msg ="对不起！该人员在试验订单中，不能删除！";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println( msg);  
		        out.flush();  
		        out.close();
			}else{
				CustomerUser user=new CustomerUser();
				user.setCustomerUserID_s(customerUserID);
				
				IcustomerUserService iuserService=new CustomerUserServiceImpl();
				iuserService.DeleteBasisCustomerUser(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	public CustomerUser getCustomeruser() {
		return customeruser;
	}

	public void setCustomeruser(CustomerUser customeruser) {
		this.customeruser = customeruser;
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


	public String getCustomerUserID() {
		return customerUserID;
	}


	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}


	public List<VCustomeuser> getUserList() {
		return userList;
	}


	public void setUserList(List<VCustomeuser> userList) {
		this.userList = userList;
	}


	public Employee getEmploy() {
		return employ;
	}


	public void setEmploy(Employee employ) {
		this.employ = employ;
	}


	public int getSearch() {
		return search;
	}


	public void setSearch(int search) {
		this.search = search;
	}


	public VCustomeuser getVcustomeruser() {
		return vcustomeruser;
	}


	public void setVcustomeruser(VCustomeuser vcustomeruser) {
		this.vcustomeruser = vcustomeruser;
	}


	public String getDrivingLicenceCPG_s() {
		return drivingLicenceCPG_s;
	}


	public void setDrivingLicenceCPG_s(String drivingLicenceCPG_s) {
		this.drivingLicenceCPG_s = drivingLicenceCPG_s;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
