package com.freshen.entity.basis;

import java.util.Date;

import com.freshen.clims.baseclass.BeanModel;
import com.freshen.util.ConstantUtil;

/**
 * 
 * 组织架构树对象    
 * 项目名称：carcenter    
 * 类名称：OrganizationTree    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-6-20 上午11:12:47    
 * 修改人：kxc    
 * 修改时间：2014-6-20 上午11:12:47    
 * 修改备注：    
 * @version     
 *
 */
public class OrganizationTree  extends  BeanModel{

	String organization_s; //编号  职工信息表的employeeID_s
	String name_s; //名称
	String createUser_s; //创建人 
	String lastUpdateUser_s;
	Date createDate_t, lastUpdateDate_t;
	String resaveds1_s, resaveds2_s, resaveds3_s, resaveds4_s, resaveds5_s;
	String superior_s;//上级编号 部门上级为部门或根节点编号 岗位上级为部门编号或岗位编号  员工上级为岗位编号
	Integer type_i;//1:部门 2：岗位 3：员工  4根结点
	Integer superiorType_i;//上级节点的类型1:部门 2：岗位 3：员工  4根结点
	String subordinateNextSeq_s;//下一个下级序号
	//以下为员工信息
	//员工的部门
	String organizationDept_s;
	String identityCard_s;
	String telephone_s, facsimile_s,email_s;
	String customerUserName_s;
	 
	
	public String getCustomerUserName_s() {
		return customerUserName_s;
	}

	public void setCustomerUserName_s(String customerUserNameS) {
		customerUserName_s = customerUserNameS;
	}

	public Integer getSuperiorType_i() {
		return superiorType_i;
	}

	public void setSuperiorType_i(Integer superiorTypeI) {
		superiorType_i = superiorTypeI;
	}

	public String getSubordinateNextSeq_s() {
		return subordinateNextSeq_s;
	}

	public void setSubordinateNextSeq_s(String subordinateNextSeqS) {
		subordinateNextSeq_s = subordinateNextSeqS;
	}

	public Integer getType_i() {
		return type_i;
	}

	public void setType_i(Integer typeI) {
		type_i = typeI;
	}

	public String getOrganizationDept_s() {
		return organizationDept_s;
	}

	public void setOrganizationDept_s(String organizationDeptS) {
		organizationDept_s = organizationDeptS;
	}

	 
	public String getIdentityCard_s() {
		return identityCard_s;
	}

	public void setIdentityCard_s(String identityCardS) {
		identityCard_s = identityCardS;
	}

	public String getTelephone_s() {
		return telephone_s;
	}

	public void setTelephone_s(String telephoneS) {
		telephone_s = telephoneS;
	}

	public String getFacsimile_s() {
		return facsimile_s;
	}

	public void setFacsimile_s(String facsimileS) {
		facsimile_s = facsimileS;
	}

	public String getEmail_s() {
		return email_s;
	}

	public void setEmail_s(String emailS) {
		email_s = emailS;
	}

	public String getSuperior_s() {
		return superior_s;
	}

	public void setSuperior_s(String superiorS) {
		superior_s = superiorS;
	}
 
	public String getOrganization_s() {
		return organization_s;
	}

	public void setOrganization_s(String organizationS) {
		organization_s = organizationS;
	}

	public String getName_s() {
		return name_s;
	}

	public void setName_s(String nameS) {
		name_s = nameS;
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
		return "OrganizationTree [createDate_t=" + createDate_t
				+ ", createUser_s=" + createUser_s + ", lastUpdateDate_t="
				+ lastUpdateDate_t + ", lastUpdateUser_s=" + lastUpdateUser_s
				+ ", name_s=" + name_s + ", organization_s=" + organization_s
				+ ", resaveds1_s=" + resaveds1_s + ", resaveds2_s="
				+ resaveds2_s + ", resaveds3_s=" + resaveds3_s
				+ ", resaveds4_s=" + resaveds4_s + ", resaveds5_s="
				+ resaveds5_s + ", superior_s=" + superior_s + "]";
	}

	/**
	 * 填充OrganizationTree对象
	 * setpro 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public void setpro(Object o){
		//部门对象
		if(o.getClass().equals(OrganizationDept.class)){
			OrganizationDept tmp = (OrganizationDept)o;
			this.organization_s =  tmp.getOrganizationDept_s();
			this.name_s = tmp.getDeptName_s();
			this.createUser_s = tmp.getCreateUser_s();
			this.createDate_t = tmp.getCreateDate_t();
			this.superior_s = tmp.getSuperior_s();
			this.lastUpdateUser_s = tmp.getLastUpdateUser_s();
			this.type_i = ConstantUtil.organizationType_1;
		}
		//岗位对象
		if(o.getClass().equals(OrganizationPost.class)){
			OrganizationPost tmp = (OrganizationPost)o;
			this.organization_s =  tmp.getOrganizationPost_s();
			this.name_s = tmp.getPostName_s();
			this.createUser_s = tmp.getCreateUser_s();
			this.createDate_t = tmp.getCreateDate_t();
			this.superior_s = tmp.getDeptID_s();
			this.lastUpdateUser_s = tmp.getLastUpdateUser_s();
			this.type_i = ConstantUtil.organizationType_2;
		}
		//职员对象
		if(o.getClass().equals(Employee.class)){
			Employee tmp = (Employee)o;
			this.organization_s =  tmp.getEmployeeID_s();
			this.name_s = tmp.getCustomerUserName_s();
			this.createUser_s = tmp.getCreateUser_s();
			this.createDate_t = tmp.getCreateDate_t();
			this.superior_s = tmp.getOrganizationPost_s();
			this.organizationDept_s = tmp.getOrganizationDept_s();
			this.lastUpdateUser_s = tmp.getLastUpdateUser_s();			 
			this.identityCard_s = tmp.getIdentityCard_s();
			this.telephone_s = tmp.getTelephone_s(); 
			this.facsimile_s = tmp.getFacsimile_s();
			this.email_s = tmp.getEmail_s();
			this.type_i = ConstantUtil.organizationType_3;
		}
	}
}
