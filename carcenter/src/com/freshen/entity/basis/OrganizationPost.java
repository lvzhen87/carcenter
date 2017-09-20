package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class OrganizationPost  extends  BeanModel{
	String organizationPost_s, deptID_s, postName_s, createUser_s,
			lastUpdateUser_s;
	Date createDate_t, lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;

	String superior_s;//上级编号
	String subordinateNextSeq_s;//下一个下级序号
	
	String limitpage_s;//权限用于存放jsp名和导航名。用vv分割
	
	
	
	

	public String getLimitpage_s() {
		return limitpage_s;
	}

	public void setLimitpage_s(String limitpage_s) {
		this.limitpage_s = limitpage_s;
	}

	public String getSubordinateNextSeq_s() {
		return subordinateNextSeq_s;
	}

	public void setSubordinateNextSeq_s(String subordinateNextSeqS) {
		subordinateNextSeq_s = subordinateNextSeqS;
	}

	public String getSuperior_s() {
		return superior_s;
	}

	public void setSuperior_s(String superiorS) {
		superior_s = superiorS;
	}

	public String getOrganizationPost_s() {
		return organizationPost_s;
	}

	public void setOrganizationPost_s(String organizationPost_s) {
		this.organizationPost_s = organizationPost_s;
	}

	public String getDeptID_s() {
		return deptID_s;
	}

	public void setDeptID_s(String deptID_s) {
		this.deptID_s = deptID_s;
	}

	public String getPostName_s() {
		return postName_s;
	}

	public void setPostName_s(String postName_s) {
		this.postName_s = postName_s;
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

	public Date getCreateDate_t() {
		return createDate_t;
	}

	public void setCreateDate_t(Date createDate_t) {
		this.createDate_t = createDate_t;
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
		organizationPost_s = organizationTree.getOrganization_s();
		deptID_s = organizationTree.getOrganizationDept_s();
		postName_s = organizationTree.getName_s();
		createUser_s = organizationTree.getCreateUser_s();
		lastUpdateUser_s = organizationTree.getLastUpdateUser_s();
		createDate_t = organizationTree.getCreateDate_t();
		lastUpdateDate_t = organizationTree.getLastUpdateDate_t();		
		superior_s = organizationTree.getSuperior_s();		
		subordinateNextSeq_s = organizationTree.getSubordinateNextSeq_s();
	}
}
