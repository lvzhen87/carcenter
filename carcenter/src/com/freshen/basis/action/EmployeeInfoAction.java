package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IorganizationDeptService;
import com.freshen.basis.service.IorganizationPostService;
import com.freshen.basis.service.IpasswordInfoService;
import com.freshen.basis.service.impl.EmployeeServiceImpl;
import com.freshen.basis.service.impl.OrganizationDeptServiceImpl;
import com.freshen.basis.service.impl.OrganizationPostServiceImpl;
import com.freshen.basis.service.impl.PasswordInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationDept;
import com.freshen.entity.basis.OrganizationPost;
import com.freshen.entity.basis.PasswordInfo;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.util.StringTools;
import com.opensymphony.xwork2.ActionContext;

public class EmployeeInfoAction extends CapgActionSupport{ 

	private static final long serialVersionUID = 1L;
	
	String customerUserName_s,identityCard_s,telephone_s,facsimile_s,email_s,employeeLoginName,employeeID_s,organizationDept_s,organizationPost_s;
	String password_s;
	Employee emp=new Employee();
	List<Employee> employeelist=new ArrayList<Employee>();
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	List<OrganizationDept> organizationDeptlist=new ArrayList<OrganizationDept>();//部门
	List<OrganizationPost> organizationPostlist=new ArrayList<OrganizationPost>();//岗位
	String flag;
	/**
	 * 查询员工信息，默认时查询所有员工信息，当有查询条件时查询该信息
	 * @author sharonyshi 2014-5-5
	 */
	public String execute(){
		try {
			Employee em=new Employee();
			if(flag!=null){
				if(employeeID_s!=null && employeeID_s.trim().length()>1)
					employeeID_s=(new String(employeeID_s.getBytes("ISO-8859-1"),"UTF-8" ));
				if(customerUserName_s!=null && customerUserName_s.trim().length()>1)
					customerUserName_s=(new String(customerUserName_s.getBytes("ISO-8859-1"),"UTF-8" ));
			}
			em.setCustomerUserName_s(customerUserName_s);
			em.setEmployeeID_s(employeeID_s);
			//em.setOrganizationDept_s(organizationDept_s);
			//em.setOrganizationPost_s(organizationPost_s);
			em.setIsOnline(0);
			//System.out.println("即将查询 员工信息 :"+em);
			IemployeeService ies=new EmployeeServiceImpl();
			/*
			 * 经验证  ，如果条件查询，得到的totalPages是 0,再执行 分页查找时，传入的 currentPage将会是0
			 * 解决办法：1、修改EmployeeServiceImpl类的getEmployeesNumber方法，使其可以 查出正确的个数
			 * 		 2、如果条件查询时，不再进行分页，（当前采用此方案修改）
			 * by freshen
			 */
			/*if(customerUserName_s!=null&&customerUserName_s.trim().length()>0  ||
					employeeID_s!=null && employeeID_s.trim().length()>0 ||
					organizationDept_s!=null && organizationDept_s.trim().length()>0||
					organizationPost_s!=null && organizationPost_s.trim().length()>0){
				//条件查询
				employeelist=ies.getEmployees(em,ConstantUtil.pagingNot, pageSize);
			}else{*/
				//确定记录总数
			totalPages =ies.getEmployeesNumber(em);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//核实当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			//不进行条件查询
			if(totalPages > 0){
				employeelist=ies.getEmployees(em, currentPage*pageSize, pageSize);
			}
			//}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception			
			 
		}
		return SUCCESS;
	}
	
	public String prepareEmployee(){
		try {
			//System.out.println(employeeID_s);
			//道闸编号存在，说明是更新操作
			if(employeeID_s !=null){
				//查询该员工的信息
				Employee em=new Employee();
				em.setEmployeeID_s(employeeID_s);
				//em.setIsOnline(1);
				IemployeeService ies=new EmployeeServiceImpl();
				employeelist=ies.getEmployees(em, ConstantUtil.pagingNot,0);
				if(employeelist != null){
					emp=employeelist.get(0);
				}
				if(organizationDept_s!=null){
					emp.setOrganizationDept_s(organizationDept_s);
				}
				IorganizationDeptService organizationDeptService = new OrganizationDeptServiceImpl();				
				organizationDeptlist = organizationDeptService.getOrganizationDept(null, ConstantUtil.pagingNot, 0);
				
				OrganizationPost organizationPost = new OrganizationPost();
				organizationPost.setDeptID_s(emp.getOrganizationDept_s());
				IorganizationPostService organizationPostService = new OrganizationPostServiceImpl();
				organizationPostlist = organizationPostService.getOrganizationPost(organizationPost, ConstantUtil.pagingNot, 0);				
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
	 
	public String changepwdAction(){
		Map mapSess =ActionContext.getContext().getSession();
		Employee loginUser=(Employee)mapSess.get("loginEmployee");
		try {	 
			IpasswordInfoService ipasswordInfoService = new PasswordInfoServiceImpl();
			PasswordInfo pwd = new PasswordInfo();
			pwd.setEmployeeID_s(loginUser.getEmployeeID_s());
			pwd.setPassword_s(password_s);
			ipasswordInfoService.OperationPasswordInfo(pwd, 1);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			out.flush();  
	        out.close();  
	        return null;
		}catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}	 
	}
	public String getPostList(){
		try {	 
			OrganizationPost organizationPost = new OrganizationPost();
			organizationPost.setDeptID_s(organizationDept_s);
										 
			IorganizationPostService organizationPostService = new OrganizationPostServiceImpl();
			organizationPostlist = organizationPostService.getOrganizationPost(organizationPost, ConstantUtil.pagingNot, 0);
			StringBuffer buffer = new StringBuffer(); 
			for(int i=0;i<organizationPostlist.size();i++){
				buffer.append("{\"id\" : \""+organizationPostlist.get(i).getOrganizationPost_s()+"\" , \"value\" : \""+organizationPostlist.get(i).getPostName_s()+"\"},"); 
			}
			System.out.println("buffer==="+buffer);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
			String json = StringTools.formatJson(buffer.toString());
	        out.println( json);  
	        out.flush();  
	        out.close();  
	        return null;
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}	 
	}
	/**
	 * 添加新的员工信息
	 * @author sharonyshi 2014-5-5
	 */
	public String updateEmployee(){
		try {
			//先判断一下登录名是否存在，如果存在不能添加。
			
			Employee em=new Employee();
			em.setEmployeeID_s(employeeID_s);
			IemployeeService ies=new EmployeeServiceImpl();
			if(employeeID_s== null || employeeID_s.trim().equals("")){
				
				boolean istrue=ies.isLoginNamehere(employeeLoginName);
				if(istrue){
					String msg ="对不起！员工登录名不能重复！请重新填写登录名！";
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter(); 
			        out.println( msg);  
			        out.flush();  
			        out.close();  
			        return null;
				}
			}
				if (employeeID_s != null) {//说明是更新操作
					em.setLastUpdateDate_t(DateUtil.getCurrentDate());
					em.setLastUpdateUser_s(employ.getCustomerUserName_s());
				}else{
					em.setCreateDate_t(DateUtil.getCurrentDate());
					em.setCreateUser_s(employ.getCustomerUserName_s());
					em.setLastUpdateDate_t(DateUtil.getCurrentDate());
				}
				
				em.setCustomerUserName_s(customerUserName_s);
				em.setEmail_s(email_s);
				em.setEmployeeLoginName(employeeLoginName);
				em.setFacsimile_s(facsimile_s);
				em.setIdentityCard_s(identityCard_s);
				em.setIsOnline(0);//有效员工
				em.setTelephone_s(telephone_s);
				em.setOrganizationDept_s(organizationDept_s);
				em.setOrganizationPost_s(organizationPost_s);
				//IemployeeService ies=new EmployeeServiceImpl();
				String id=ies.OperationEmployeesold(em, 1);
				//登录密码不为空操作密码表
				if(password_s!= null && !password_s.equals("")){
					PasswordInfo pi=new PasswordInfo();
					pi.setEmployeeID_s(em.getEmployeeID_s());
					pi.setPassword_s(password_s);
					pi.setCreateUser_s(employ.getCustomerUserName_s());
					
					IpasswordInfoService ipis=new PasswordInfoServiceImpl();
					ipis.OperationPasswordInfo(pi, 1);
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
	 * 删除该员工信息记录
	 * @author sharonyshi 2014-5-5
	 */
	public String deleteEmployee(){
		try {
			Employee ee=new Employee();
			ee.setEmployeeID_s(employeeID_s);
			ee.setIsOnline(1);//离线员工，无效人
			
			PasswordInfo pi=new PasswordInfo();
			pi.setEmployeeID_s(employeeID_s);
			
			IemployeeService ies=new EmployeeServiceImpl();
			ies.OperationEmployeesold(ee, 2);
			
			IpasswordInfoService ips=new PasswordInfoServiceImpl();
			ips.OperationPasswordInfo(pi, 2);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCustomerUserName_s() {
		return customerUserName_s;
	}

	public void setCustomerUserName_s(String customerUserName_s) {
		this.customerUserName_s = customerUserName_s;
	}

	public String getEmployeeID_s() {
		return employeeID_s;
	}

	public void setEmployeeID_s(String employeeID_s) {
		this.employeeID_s = employeeID_s;
	}

	public String getOrganizationDept_s() {
		return organizationDept_s;
	}

	public void setOrganizationDept_s(String organizationDept_s) {
		System.out.println("organizationDept_sorganizationDept_sorganizationDept_s="+organizationDept_s);
		this.organizationDept_s = organizationDept_s;
	}

	public String getOrganizationPost_s() {
		return organizationPost_s;
	}

	public void setOrganizationPost_s(String organizationPost_s) {
		this.organizationPost_s = organizationPost_s;
	}

	public List<Employee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<Employee> employeelist) {
		this.employeelist = employeelist;
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

	public String getIdentityCard_s() {
		return identityCard_s;
	}

	public void setIdentityCard_s(String identityCard_s) {
		this.identityCard_s = identityCard_s;
	}

	public String getTelephone_s() {
		return telephone_s;
	}

	public void setTelephone_s(String telephone_s) {
		this.telephone_s = telephone_s;
	}

	public String getFacsimile_s() {
		return facsimile_s;
	}

	public void setFacsimile_s(String facsimile_s) {
		this.facsimile_s = facsimile_s;
	}

	public String getEmail_s() {
		return email_s;
	}

	public void setEmail_s(String email_s) {
		this.email_s = email_s;
	}

	public String getEmployeeLoginName() {
		return employeeLoginName;
	}

	public void setEmployeeLoginName(String employeeLoginName) {
		this.employeeLoginName = employeeLoginName;
	}

	public String getPassword_s() {
		return password_s;
	}

	public void setPassword_s(String password_s) {
		this.password_s = password_s;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Employee getEmploy() {
		return employ;
	}

	public void setEmploy(Employee employ) {
		this.employ = employ;
	}

	public List<OrganizationDept> getOrganizationDeptlist() {
		return organizationDeptlist;
	}

	public void setOrganizationDeptlist(List<OrganizationDept> organizationDeptlist) {
		this.organizationDeptlist = organizationDeptlist;
	}

	public List<OrganizationPost> getOrganizationPostlist() {
		return organizationPostlist;
	}

	public void setOrganizationPostlist(List<OrganizationPost> organizationPostlist) {
		this.organizationPostlist = organizationPostlist;
	}
	
	
	
	
	
}
