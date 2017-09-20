package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class Employee  extends  BeanModel{

	String employeeID_s, organizationPost_s, organizationDept_s,
			customerUserName_s, identityCard_s, telephone_s, facsimile_s,
			email_s;
	Date createDate_t, lastUpdateDate_t;
	String createUser_s, lastUpdateUser_s, resaveds1_s, resaveds2_s,
			resaveds3_s, resaveds4_s, resaveds5_s;
	int isOnline; //记录员工是否有效，删除员工操作记为0。默认有效值为1
	
	//新增，做关联的两个属性，Map文件并无配置，By freshen
	private OrganizationDept employeeDept;	//关联部门
	private OrganizationPost employeePost;	//关联职位
	private String employeeLoginName;	//员工登录名，表中唯一
	private String issynchronization;   //是否是同步
	
	
	public String getIssynchronization() {
		return issynchronization;
	}

	public void setIssynchronization(String issynchronization) {
		this.issynchronization = issynchronization;
	}

	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public String getEmployeeID_s() {
		return employeeID_s;
	}

	public void setEmployeeID_s(String employeeID_s) {
		this.employeeID_s = employeeID_s;
	}

	public String getOrganizationPost_s() {
		return organizationPost_s;
	}

	public void setOrganizationPost_s(String organizationPost_s) {
		this.organizationPost_s = organizationPost_s;
	}

	public String getOrganizationDept_s() {
		return organizationDept_s;
	}

	public void setOrganizationDept_s(String organizationDept_s) {
		this.organizationDept_s = organizationDept_s;
	}

	public String getCustomerUserName_s() {
		return customerUserName_s;
	}

	public void setCustomerUserName_s(String customerUserName_s) {
		this.customerUserName_s = customerUserName_s;
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

	@Override
	public String toString() {
		return "Employee [createDate_t=" + createDate_t + ", createUser_s="
				+ createUser_s + ", customerUserName_s=" + customerUserName_s
				+ ", email_s=" + email_s + ", employeeDept=" + employeeDept
				+ ", employeeID_s=" + employeeID_s + ", employeeLoginName="
				+ employeeLoginName + ", employeePost=" + employeePost
				+ ", facsimile_s=" + facsimile_s + ", identityCard_s="
				+ identityCard_s + ", isOnline=" + isOnline
				+ ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s
				+ ", organizationDept_s=" + organizationDept_s
				+ ", organizationPost_s=" + organizationPost_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", telephone_s=" + telephone_s + "]";
	}

	public OrganizationDept getEmployeeDept() {
		return employeeDept;
	}

	public void setEmployeeDept(OrganizationDept employeeDept) {
		this.employeeDept = employeeDept;
	}

	public OrganizationPost getEmployeePost() {
		return employeePost;
	}

	public void setEmployeePost(OrganizationPost employeePost) {
		this.employeePost = employeePost;
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

	/**
	 * 根据组织结构树对象生成组织架构岗位对象
	 * setProbyorganizationTree 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setProbyorganizationTree(OrganizationTree organizationTree){
		organizationPost_s = organizationTree.getSuperior_s();
		createUser_s = organizationTree.getCreateUser_s();
		lastUpdateUser_s = organizationTree.getLastUpdateUser_s();
		createDate_t = organizationTree.getCreateDate_t();
		lastUpdateDate_t = organizationTree.getLastUpdateDate_t();		
		employeeID_s = organizationTree.getOrganization_s();
		organizationDept_s = organizationTree.getOrganizationDept_s();
		customerUserName_s = organizationTree.getName_s();
		identityCard_s = organizationTree.getIdentityCard_s();
		telephone_s = organizationTree.getTelephone_s();
		facsimile_s = organizationTree.getFacsimile_s();
		email_s = organizationTree.getEmail_s();
	}

	public String getEmployeeLoginName() {
		return employeeLoginName;
	}

	public void setEmployeeLoginName(String employeeLoginName) {
		this.employeeLoginName = employeeLoginName;
	}
}
