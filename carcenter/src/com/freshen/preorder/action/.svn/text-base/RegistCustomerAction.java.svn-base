package com.freshen.preorder.action;

import java.io.File;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;

import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * RegistCustomerAction 内网注册客户信息
 * 
 * @author	yepeng   
 * 
 * @Exception	异常对象    
 * @since  CodingExample　Ver(编码范例查看) 1.1
 * 
 */
public class RegistCustomerAction extends CapgActionSupport implements ModelDriven<Customer>{


	//	客户实体t_subscribe_customer
	Customer customer = new Customer();
	//	客户人员和负责人实体t_basis_customerUser
	CustomerUser contactcustomerUser = new CustomerUser();
	CustomerUser responsecustomerUser = new CustomerUser();
	
	//Sequence sequence = new Sequence();	//注册客户ＩＤ
	//Sequence cseq = new Sequence();		//客户人员ID序列
	
	//Session session = null;
	//Transaction tx = null;
	//负责人姓名，电话，邮箱        2014-06-17sharonyshi
	String responsibleUserName_s,responsibleUserEmail_s,identifyCard_s,resaveds1_s;
	//	上传文件
	File uploadfile;
	//	上传文件属性
	String uploadfileContentType;
	//	上传文件保存路径，在struts-regist中有配置
	String uploadPath;
	//	密码
	String password;
	//	错误信息
	String errmsg;
	//	成功信息
	String sucessmsg;
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	// 身份证号
	String identityCard_s;
	/**
	 * 
	 * RegistCustomerAction 内网注册客户信息主方法
	 * 
	 * @author	yepeng   
	 * 
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 * 
	 */
	public String executeold(){
		//	实例接口
		IcustomerService cusImpl = new CustomerServiceImpl();
		//System.out.println(customer);
		/*
		 * 判断必填项
		 * 必填项：客户公司名称、账户密码、公司所在地、昵称、联系人、联系电话、联系人邮箱、职位、上传执照
		 * */
		if(customer.getCustomerName_s() == null || customer.getCustomerName_s().length() < 1){
			errmsg = "请填写公司名称！";
			return ERROR;
		}
		if(customer.getCustomerLoginName_s() == null || customer.getCustomerLoginName_s().length() < 1){
			errmsg = "请填写昵称！";
			return ERROR;
		} else {
			try {
				long result = cusImpl.getCustomerLoginName(customer.getCustomerLoginName_s());
				if(result > 0){
					errmsg = "客户昵称不能重复！";
					return ERROR;
				}
			} catch (Exception e) {
				e.printStackTrace();
				this.setErrmsg(e.getMessage());			
				ExceptionDispose.saveExceptionInfo(e);
				return ERROR;
				 
			}
		}
		if(customer.getCustomerAddress_s() == null || customer.getCustomerAddress_s().length() < 1){
			errmsg = "请填写公司驻地！";
			return ERROR;
		}
		if(customer.getDepartment_s() == null || customer.getDepartment_s().length() < 1){
			errmsg = "请填写部门名称！";
			return ERROR;
		}
		if(customer.getInvoiceOrder_s() == null || customer.getInvoiceOrder_s().length() < 1){
			errmsg = "请填写客户发票抬头！";
			return ERROR;
		} /*sharonyshi 2014-10-31 发票抬头可以重复，不校验
		else {
			try {
				long result = cusImpl.getInvoiceOrder(customer.getInvoiceOrder_s());
				if(result > 0){
					errmsg = "客户发票抬头不能重复！";
					return ERROR;
				}
			} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
				 
			}
		}*/
		if(customer.getAddedValueTax_s() == null || customer.getAddedValueTax_s().length() < 1){
			errmsg = "请填写客户增值税号！";
			return ERROR;
		}
		if(password == null || password.length() < 1){
			errmsg = "请填写账户密码！";
			return ERROR;
		}else{
			/*MD5加密密码 */
			try {
				MessageDigest md5=MessageDigest.getInstance("MD5");
				//使用Base64格式对字符串进行编码
				sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
				String temp = base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
				customer.setPassword_s(temp);
			} catch (NoSuchAlgorithmException e) {
				ExceptionDispose.saveExceptionInfo(e);
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				ExceptionDispose.saveExceptionInfo(e);
				e.printStackTrace();
			}
		}
		if(customer.getCustomerUserName_s() == null || customer.getCustomerUserName_s().length() < 1){
			errmsg = "请填写客户联系人！";
			return ERROR;
		}
		if(customer.getCustomerUserPhone_s() == null || customer.getCustomerUserPhone_s().length() < 1){
			errmsg = "请填写客户联系电话！";
			return ERROR;
		}
		if(customer.getCustomerUserEmail_s() == null || customer.getCustomerUserEmail_s().length() < 1){
			errmsg = "请填写客户联系人邮箱！";
			return ERROR;
		}
//		if(uploadfile == null || uploadfile.getName().length() < 1){
//			errmsg = "请上传执照压缩包！";
//			return ERROR;
//		}else{
//			//上传文件
//			//保存上传文件
//			boolean r = new UploadFile().saveFile(uploadPath, customer.getCustomerName_s() + ".zip", uploadfile);
//			if(!r){
//				errmsg = "上传文件错误，请重试！";
//				return ERROR;
//			}
//			//保存文件信息
//			customer.setUploadFilePath_s(uploadPath + customer.getCustomerName_s() + ".zip");//保存路径(公司名称)					
//		}
		//	保存文件信息,保存路径(公司名称)
		//customer.setUploadFilePath_s(uploadPath + customer.getCustomerName_s() + ".zip");
		//	设置用户类型,默认为1（0：未通过 1:提交 2:已通过 ）
		customer.setStatus_i(1);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String d = df.format(new java.util.Date());
		Date createtime = null;
		try {
			createtime = (Date) df.parse(d);
		
			//	创建时间为当前时间
			customer.setCreateDate_t(createtime);
			//	创建人默认为联系人
			customer.setCreateUser_s(employ.getCustomerUserName_s());
			
			//	联系人客户人员信息表t_basis_customerUser数据准备
			//	部门名称
			contactcustomerUser.setDepartment_s(customer.getDepartment_s());
			//	客户人员名称
			contactcustomerUser.setCustomerUserName_s(customer.getCustomerUserName_s());
			//	创建时间为当前时间
			contactcustomerUser.setCreateDate_t(createtime);
			//	创建人默认为联系人
			contactcustomerUser.setCreateUser_s(employ.getCustomerUserName_s());
			//	客户Email
			contactcustomerUser.setEmail_s(customer.getCustomerUserEmail_s());
			//	设置客户人员类别,默认为1（1：客户负责人  2：陪同人员 ）
			contactcustomerUser.setUserType_i(1);
			// 设置身份证号
			contactcustomerUser.setIdentityCard_s(identifyCard_s);
			
			//	部门名称
			responsecustomerUser.setDepartment_s(customer.getDepartment_s());
			//	客户人员名称
			responsecustomerUser.setCustomerUserName_s(responsibleUserName_s);
			//	创建时间为当前时间
			responsecustomerUser.setCreateDate_t(createtime);
			responsecustomerUser.setLastUpdateDate_t(createtime);
			//	创建人默认为联系人
			responsecustomerUser.setCreateUser_s(employ.getCustomerUserName_s());
			//	客户Email
			responsecustomerUser.setEmail_s(responsibleUserEmail_s);
			//	设置客户人员类别,默认为1（1：客户负责人  2：陪同人员 ）
			responsecustomerUser.setUserType_i(1);
			
			responsecustomerUser.setIdentityCard_s(identifyCard_s);
			//	注册客户信息，插入t_subscribe_customer表,t_basis_customerUser表中
			//	注册客户信息，插入t_subscribe_customer表,t_basis_customerUser表中
			cusImpl.registCustomer(customer, contactcustomerUser,responsecustomerUser);
			
			sucessmsg = "注册成功！";
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
	}
	
	/**
	 * 
	 * RegistCustomerAction 内网注册客户信息主方法
	 * 
	 * @author	yepeng   
	 * 
	 * @Exception	异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 * 
	 */
	public String execute(){
		//	实例接口
		IcustomerService cusImpl = new CustomerServiceImpl();
		//System.out.println(customer);
		/*
		 * 判断必填项
		 * 必填项：客户公司名称、账户密码、公司所在地、昵称、联系人、联系电话、联系人邮箱、职位、上传执照
		 * */
		if(customer.getCustomerName_s() == null || customer.getCustomerName_s().length() < 1){
			errmsg = "请填写公司名称！";
			return ERROR;
		}
		if(customer.getCustomerLoginName_s() == null || customer.getCustomerLoginName_s().length() < 1){
			errmsg = "请填写昵称！";
			return ERROR;
		} else {
			try {
				long result = cusImpl.getCustomerLoginName(customer.getCustomerLoginName_s());
				if(result > 0){
					errmsg = "客户昵称不能重复！";
					return ERROR;
				}
			} catch (Exception e) {
				e.printStackTrace();
				this.setErrmsg(e.getMessage());			
				ExceptionDispose.saveExceptionInfo(e);
				return ERROR;
				 
			}
		}
		if(customer.getCustomerAddress_s() == null || customer.getCustomerAddress_s().length() < 1){
			errmsg = "请填写公司驻地！";
			return ERROR;
		}
		if(customer.getDepartment_s() == null || customer.getDepartment_s().length() < 1){
			errmsg = "请填写部门名称！";
			return ERROR;
		}
		if(customer.getInvoiceOrder_s() == null || customer.getInvoiceOrder_s().length() < 1){
			errmsg = "请填写客户发票抬头！";
			return ERROR;
		}  
		if(customer.getAddedValueTax_s() == null || customer.getAddedValueTax_s().length() < 1){
			errmsg = "请填写客户增值税号！";
			return ERROR;
		}
		if(password == null || password.length() < 1){
			errmsg = "请填写账户密码！";
			return ERROR;
			
		}else{
			/*MD5加密密码 */
			try {
				MessageDigest md5=MessageDigest.getInstance("MD5");
				//使用Base64格式对字符串进行编码
				sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
				String temp = base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
				customer.setPassword_s(temp);
			} catch (NoSuchAlgorithmException e) {
				ExceptionDispose.saveExceptionInfo(e);
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				ExceptionDispose.saveExceptionInfo(e);
				e.printStackTrace();
			}
		}
		if(customer.getCustomerUserName_s() == null || customer.getCustomerUserName_s().length() < 1){
			errmsg = "请填写客户联系人！";
			return ERROR;
		}
		if(customer.getCustomerUserPhone_s() == null || customer.getCustomerUserPhone_s().length() < 1){
			errmsg = "请填写客户联系电话！";
			return ERROR;
		}
		if(customer.getCustomerUserEmail_s() == null || customer.getCustomerUserEmail_s().length() < 1){
			errmsg = "请填写客户联系人邮箱！";
			return ERROR;
		}
		if(resaveds1_s == null || resaveds1_s.length() < 1){
			errmsg = "请填写发票接收地址！";
			return ERROR;
		}
		customer.setResavedes1(resaveds1_s);
		customer.setStatus_i(1);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = df.format(new java.util.Date());
		Date createtime = null;
		try {
			createtime = (Date) df.parse(d);
		
			//	创建时间为当前时间
			customer.setCreateDate_t(createtime);
			//	创建人默认为联系人
			customer.setCreateUser_s(employ.getCustomerUserName_s());
			
			//	联系人客户人员信息表t_basis_customerUser数据准备
			//	部门名称
			contactcustomerUser.setDepartment_s(customer.getDepartment_s());
			//	客户人员名称
			contactcustomerUser.setCustomerUserName_s(customer.getCustomerUserName_s());
			//	创建时间为当前时间
			contactcustomerUser.setCreateDate_t(createtime);
			//	创建人默认为联系人
			contactcustomerUser.setCreateUser_s(employ.getCustomerUserName_s());
			//	客户Email
			contactcustomerUser.setEmail_s(customer.getCustomerUserEmail_s());
			//	设置客户人员类别,默认为1（1：客户负责人  2：陪同人员 ）
			contactcustomerUser.setUserType_i(1);
			// 设置身份证号
			contactcustomerUser.setIdentityCard_s(identifyCard_s);
			  
			//	注册客户信息，插入t_subscribe_customer表,t_basis_customerUser表中
			//	注册客户信息，插入t_subscribe_customer表,t_basis_customerUser表中
			cusImpl.registCustomer(customer, contactcustomerUser,null);
			
			
			sucessmsg = "注册成功！";
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
	}
	public String getIdentityCard_s() {
		return identityCard_s;
	}

	public void setIdentityCard_s(String identityCard_s) {
		this.identityCard_s = identityCard_s;
	}

	public Customer getModel() {
		return customer;
	}
	

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}	
	public String getSucessmsg() {
		return sucessmsg;
	}
	public void setSucessmsg(String sucessmsg) {
		this.sucessmsg = sucessmsg;
	}
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerUser getContactcustomerUser() {
		return contactcustomerUser;
	}

	public void setContactcustomerUser(CustomerUser contactcustomerUser) {
		this.contactcustomerUser = contactcustomerUser;
	}

	public CustomerUser getResponsecustomerUser() {
		return responsecustomerUser;
	}

	public void setResponsecustomerUser(CustomerUser responsecustomerUser) {
		this.responsecustomerUser = responsecustomerUser;
	}

	public String getResponsibleUserName_s() {
		return responsibleUserName_s;
	}

	public void setResponsibleUserName_s(String responsibleUserName_s) {
		this.responsibleUserName_s = responsibleUserName_s;
	}

	public String getResponsibleUserEmail_s() {
		return responsibleUserEmail_s;
	}

	public void setResponsibleUserEmail_s(String responsibleUserEmail_s) {
		this.responsibleUserEmail_s = responsibleUserEmail_s;
	}

	public String getIdentifyCard_s() {
		return identifyCard_s;
	}

	public void setIdentifyCard_s(String identifyCard_s) {
		this.identifyCard_s = identifyCard_s;
	}

	public String getResaveds1_s() {
		return resaveds1_s;
	}

	public void setResaveds1_s(String resaveds1S) {
		resaveds1_s = resaveds1S;
	}	
	
	
}
