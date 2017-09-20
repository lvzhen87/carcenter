package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;

public class OrganizationDept  extends  BeanModel{

	String organizationDept_s, deptName_s, createUser_s, lastUpdateUser_s;
	Date createDate_t, lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String superior_s;//上级编号
	
	String subordinateNextSeq_s;//下一个下级序号
	
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

	public String getOrganizationDept_s() {
		return organizationDept_s;
	}

	public void setOrganizationDept_s(String organizationDept_s) {
		this.organizationDept_s = organizationDept_s;
	}

	public String getDeptName_s() {
		return deptName_s;
	}

	public void setDeptName_s(String deptName_s) {
		this.deptName_s = deptName_s;
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

	@Override
	public String toString() {
		return "OrganizationDept [createDate_t=" + createDate_t
				+ ", createUser_s=" + createUser_s + ", deptName_s="
				+ deptName_s + ", lastUpdateDate_t=" + lastUpdateDate_t
				+ ", lastUpdateUser_s=" + lastUpdateUser_s
				+ ", organizationDept_s=" + organizationDept_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", superior_s=" + superior_s + "]";
	}

	/**
	 * 根据组织结构树对象生成组织架构部门对象
	 * setProbyorganizationTree 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setProbyorganizationTree(OrganizationTree organizationTree){
		organizationDept_s = organizationTree.getOrganization_s();
		deptName_s = organizationTree.getName_s();
		createUser_s = organizationTree.getCreateUser_s();
		lastUpdateUser_s = organizationTree.getLastUpdateUser_s();
		createDate_t = organizationTree.getCreateDate_t();
		lastUpdateDate_t = organizationTree.getLastUpdateDate_t();		
		superior_s = organizationTree.getSuperior_s();		
		subordinateNextSeq_s = organizationTree.getSubordinateNextSeq_s();
	}
}
