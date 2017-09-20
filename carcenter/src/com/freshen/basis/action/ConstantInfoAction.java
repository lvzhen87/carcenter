package com.freshen.basis.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.freshen.entity.Customer;
import com.freshen.entity.basis.ConstantInfo;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.basis.service.IConstantInfoService;
import com.freshen.basis.service.impl.ConstantInfoServiceImpl;
import com.freshen.util.ConstantUtil;
/**
 *  Class Name: RegisterUserSearchAction.java
 *  Function:对应页面中"联系人查询"功能，根据条件查询联系人，并完成分页功能。
 *     Modifications:   
 *  @author   DateTime 2014-4-9 上午11:02:32    
 *  @version 1.0
 */
public class ConstantInfoAction extends CapgActionSupport{
	String rStr=SUCCESS;	//返回的字符串
	List<ConstantInfo> ConstantInfoList;//存放客户信息
	ConstantInfo constantInfo=new ConstantInfo();//存放单个客户信息
	
	String msg,flag;
	//分页
	long totalConstantInfo;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	//条件查询字段
	//private String ConstantInfoID,ConstantInfoName,departmentName,createUserName;
	String constantID_s;
	String constantName_s;
	String constantDescribe_s;
	String constantValues_s;
	Date createDate_t, lastUpdateDate_t;
	String createUser_s, lastUpdateUser_s, resaveds1_s, resaveds2_s,
			resaveds3_s, resaveds4_s, resaveds5_s;
			
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	/**
	 * 条件查询
	 */
	public String execute() {
		//将条件查询 封装成对象
		ConstantInfo ConstantInfo=new ConstantInfo();
		//由于从页面上来的 查询属性，可能是分页时 发送的，需要处理汉字编码问题
		try {
			ConstantInfo.setConstantID_s(constantID_s);
			if(flag!=null){
				if(constantName_s!=null && constantName_s.trim().length()>1)
					constantName_s=(new String(constantName_s.getBytes("ISO-8859-1"),"UTF-8" ));
				if(constantDescribe_s!=null&&constantDescribe_s.trim().length()>1)
					constantDescribe_s=(new String(constantDescribe_s.getBytes("ISO-8859-1"),"UTF-8" ));
				 
			}
			ConstantInfo.setConstantName_s(constantName_s);
			ConstantInfo.setConstantDescribe_s(constantDescribe_s);
 		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			ExceptionDispose.saveExceptionInfo(e1);
			e1.printStackTrace();
		}
		
		//System.out.println("查询对象  ConstantInfo" + ConstantInfo);
		IConstantInfoService icus = new ConstantInfoServiceImpl();
		try {
			totalConstantInfo = icus.getConstantInfoNumber(ConstantInfo);
			// 计算总页数
			maxPage = (int) (totalConstantInfo % pageSize == 0 ? totalConstantInfo
					/ pageSize : totalConstantInfo / pageSize + 1);
			// 校验当前页码
			if (currentPage < 0)
				currentPage = 0;
			else if (currentPage > maxPage)
				currentPage = maxPage;
			//System.out.println("记录条数: " + totalConstantInfo + "总页数： " + maxPage + " 当前页 :" + currentPage);
			//分页查
			ConstantInfoList = icus.getConstantInfo(ConstantInfo, currentPage* pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return rStr;
	}


	
	public String  prepareConstant(){
		try {
			ConstantInfo c=new ConstantInfo();
			c.setConstantID_s(constantID_s);
			
			IConstantInfoService ics=new ConstantInfoServiceImpl();
			List<ConstantInfo> clist=ics.getConstantInfo(c, ConstantUtil.pagingNot,0);
			if(clist!=null){
				constantInfo=clist.get(0);
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
	
	
	public String modifyConstant(){
		try {
			ConstantInfo c=new ConstantInfo();
			c.setConstantID_s(constantID_s);
			c.setConstantName_s(constantName_s);
			c.setConstantDescribe_s(constantDescribe_s);
			c.setConstantValues_s(constantValues_s); 
			 
			c.setLastUpdateDate_t(DateUtil.getCurrentDate());
			c.setLastUpdateUser_s(employ.getCustomerUserName_s());
			
			List<ConstantInfo> clist=new ArrayList<ConstantInfo>();
			clist.add(c);
			
			IConstantInfoService ics=new ConstantInfoServiceImpl();
			ics.OperationConstantInfo(clist, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		return SUCCESS;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public List<ConstantInfo> getConstantInfoList() {
		return ConstantInfoList;
	}


	public void setConstantInfoList(List<ConstantInfo> ConstantInfoList) {
		this.ConstantInfoList = ConstantInfoList;
	}


	public long getTotalConstantInfo() {
		return totalConstantInfo;
	}


	public void setTotalConstantInfo(long totalConstantInfo) {
		this.totalConstantInfo = totalConstantInfo;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
 
	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}


 
 


	public ConstantInfo getConstantInfo() {
		return constantInfo;
	}



	public void setConstantInfo(ConstantInfo constantInfo) {
		this.constantInfo = constantInfo;
	}



	public String getrStr() {
		return rStr;
	}



	public void setrStr(String rStr) {
		this.rStr = rStr;
	}



	public String getConstantID_s() {
		return constantID_s;
	}



	public void setConstantID_s(String constantIDS) {
		constantID_s = constantIDS;
	}



	public String getConstantName_s() {
		return constantName_s;
	}



	public void setConstantName_s(String constantNameS) {
		constantName_s = constantNameS;
	}



	public String getConstantDescribe_s() {
		return constantDescribe_s;
	}



	public void setConstantDescribe_s(String constantDescribeS) {
		constantDescribe_s = constantDescribeS;
	}



	public String getConstantValues_s() {
		return constantValues_s;
	}



	public void setConstantValues_s(String constantValuesS) {
		constantValues_s = constantValuesS;
	}



	public Date getCreateDate_t() {
		return createDate_t;
	}



	public void setCreateDate_t(Date createDateT) {
		createDate_t = createDateT;
	}



	public Date getLastUpdateDate_t() {
		return lastUpdateDate_t;
	}



	public void setLastUpdateDate_t(Date lastUpdateDateT) {
		lastUpdateDate_t = lastUpdateDateT;
	}



	public String getCreateUser_s() {
		return createUser_s;
	}



	public void setCreateUser_s(String createUserS) {
		createUser_s = createUserS;
	}



	public String getLastUpdateUser_s() {
		return lastUpdateUser_s;
	}



	public void setLastUpdateUser_s(String lastUpdateUserS) {
		lastUpdateUser_s = lastUpdateUserS;
	}



	public String getResaveds1_s() {
		return resaveds1_s;
	}



	public void setResaveds1_s(String resaveds1S) {
		resaveds1_s = resaveds1S;
	}



	public String getResaveds2_s() {
		return resaveds2_s;
	}



	public void setResaveds2_s(String resaveds2S) {
		resaveds2_s = resaveds2S;
	}



	public String getResaveds3_s() {
		return resaveds3_s;
	}



	public void setResaveds3_s(String resaveds3S) {
		resaveds3_s = resaveds3S;
	}



	public String getResaveds4_s() {
		return resaveds4_s;
	}



	public void setResaveds4_s(String resaveds4S) {
		resaveds4_s = resaveds4S;
	}



	public String getResaveds5_s() {
		return resaveds5_s;
	}



	public void setResaveds5_s(String resaveds5S) {
		resaveds5_s = resaveds5S;
	}



	public Employee getEmploy() {
		return employ;
	}



	public void setEmploy(Employee employ) {
		this.employ = employ;
	}

 
	
	
}
