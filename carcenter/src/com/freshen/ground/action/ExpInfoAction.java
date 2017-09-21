package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.derby.client.net.Typdef;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.reception.ReceptionOrder;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.IorderDetailService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.preorder.service.impl.OrderDetailServiceImpl;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.reception.service.IreceptionOrderService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.reception.service.impl.ReceptionOrderServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.clims.baseclass.ServiceImpl;

public class ExpInfoAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	//List<OrderDetail> infolist=new ArrayList<OrderDetail>();
	//OrderDetail orderdetail=new OrderDetail();
	List<ReceptionOrder> infolist=new ArrayList<ReceptionOrder>();
	ReceptionOrder orderdetail=new ReceptionOrder();
	
	String customerId,experimentName,companyName,companyAddress,companyDepartment,contactUserID,
	invoice,taxNum,invoiceUser,invoiceUserPhone,invoiceAddress;
	String startdatepicker,enddatepicker;
	
	List<CustomerUser> customeruser =new ArrayList<CustomerUser>();   //存放客户人员信息
	List<CustomerUser> customeruserNew =new ArrayList<CustomerUser>(); 
	


	Customer customer=new Customer();
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	//2014-8-25查询接待模块的订单
	public String searchInfoDatail(){
		try {
		/*	//设置要查询的订单编号
			OrderDetail od=new OrderDetail();
			od.setOrderID_s(orderId);
			
			IorderInfoService iis=new OrderInfoServiceImpl();
			infolist=iis.getOrder(od);*/
			
			ReceptionOrder ro=new ReceptionOrder();
			ro.setOrderID_s(orderId);
			
			IreceptionOrderService irs=new ReceptionOrderServiceImpl();
			infolist=irs.getReceptionOrder(ro, ConstantUtil.pagingNot,0);
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
	 *  Function:进入订单 第一页面，初始化 联系人
	 *  之前是查询预约表中的基础信息，2014-08-25修改为查询接待表中的基础信息
	 *  @author sharonyshi  DateTime 2014-7-14 下午01:40:24
	 *  @return
	 */
	public String initOrderInfo(){
		try {
			//设置要查询的订单编号2014-8-25注释
			/*OrderDetail od=new OrderDetail();
			od.setOrderID_s(orderId);
			
			IorderInfoService iis=new OrderInfoServiceImpl();
			infolist=iis.getOrder(od);
			if(infolist!=null){
				orderdetail=infolist.get(0);
			}*/
			ReceptionOrder ro=new ReceptionOrder();
			ro.setOrderID_s(orderId);
			
			IreceptionOrderService irs=new ReceptionOrderServiceImpl();
			infolist=irs.getReceptionOrder(ro, ConstantUtil.pagingNot,0);
			if(BasicTools.isnotNull(infolist)){
				orderdetail= infolist.get(0);
			}
			
			CustomerUser cu=new CustomerUser();
			cu.setCustomerID_s(customerId);
			cu.setUserType_i(1);
			IcustomerUserService customerUserSer =new CustomerUserServiceImpl();
			customeruser=customerUserSer.findCustomerUser(cu);
			//System.out.println("查出联系人数量 "+customeruser.size());
			for(int i = 0;i<customeruser.size();i++){
				if(customeruser.get(i).getClass() == cu.getClass()){
					if(customeruser.get(i).getUserType_i() == 1   ){
						customeruserNew.add(customeruser.get(i));
					}
				}
				
			}
			customeruser = customeruserNew;
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
		 
		}
		return SUCCESS;
	}
	
	
	public String modifyInfo(){
		try {
			/*
			 * 2014-8-25改为订单基础信息修改接待模块的表，之前的预约模块基础信息保留原样
			//获取OrderDetail对象
			//OrderDetail orderinfo=new OrderDetail();
			 */			
			ReceptionOrder orderinfo=new ReceptionOrder();
			orderinfo.setOrderID_s(orderId);
			orderinfo.setOrderName_s(experimentName);
			orderinfo.getCustomer().setCustomerID_s(customerId);
			//orderinfo.setCustomerID_s(customerId);
			//orderinfo.setReservationDate_t(DateUtil.getCurrentDate());
			orderinfo.setCustomerUserID_s(contactUserID);
			//orderinfo.setCustomerUserName(contactUserName);
			orderinfo.setInvoiceOrder_s(invoice);
			orderinfo.setAddedValueTax_s(taxNum);
			orderinfo.setStartDate_d(DateUtil.getDate(startdatepicker));
			orderinfo.setEndDate_d(DateUtil.getDate(enddatepicker));
			orderinfo.setInvoiceUser_s(invoiceUser);
			//orderinfo.setReceiveInvoiceAddress_s(invoiceAddress);
			//orderinfo.setInvoiceUserPhone_s(invoiceUserPhone);
			orderinfo.setLastUpdateDate_t(DateUtil.getCurrentDate());
			orderinfo.setLastUpdateUser_s(employ.getCustomerUserName_s());
			
			//IorderDetailService ids=new OrderDetailServiceImpl();
			//ids.OperationOrder(orderinfo, 1);
			/*Object[] o={orderinfo,1};
			
			List<ServiceImpl> se = new ArrayList();
			
			ServiceImpl tmp = new ServiceImpl(OrderDetailServiceImpl.class.toString().substring(6),"OperationOrder",o);
			se.add(tmp);
			ServiceImpl.invoke(se);*/
			Object[] o={orderinfo,Integer.valueOf(1)};
			
			List<ServiceImpl> se = new ArrayList();
			
			ServiceImpl tmp = new ServiceImpl("com.freshen.reception.service.impl.ReceptionOrderServiceImpl","OperationReceptionOrderWithoutTx",o);
			se.add(tmp);
			ServiceImpl.invoke(se);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}
	
	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	

	public String getExperimentName() {
		return experimentName;
	}


	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyAddress() {
		return companyAddress;
	}


	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}


	public String getCompanyDepartment() {
		return companyDepartment;
	}


	public void setCompanyDepartment(String companyDepartment) {
		this.companyDepartment = companyDepartment;
	}


	public String getContactUserID() {
		return contactUserID;
	}


	public void setContactUserID(String contactUserID) {
		this.contactUserID = contactUserID;
	}


	

	public String getInvoice() {
		return invoice;
	}


	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}


	public String getTaxNum() {
		return taxNum;
	}


	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}


	public String getInvoiceUser() {
		return invoiceUser;
	}


	public void setInvoiceUser(String invoiceUser) {
		this.invoiceUser = invoiceUser;
	}


	public String getInvoiceUserPhone() {
		return invoiceUserPhone;
	}


	public void setInvoiceUserPhone(String invoiceUserPhone) {
		this.invoiceUserPhone = invoiceUserPhone;
	}


	public String getInvoiceAddress() {
		return invoiceAddress;
	}


	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}



	public String getStartdatepicker() {
		return startdatepicker;
	}


	public void setStartdatepicker(String startdatepicker) {
		this.startdatepicker = startdatepicker;
	}


	public String getEnddatepicker() {
		return enddatepicker;
	}


	public void setEnddatepicker(String enddatepicker) {
		this.enddatepicker = enddatepicker;
	}


	public List<CustomerUser> getCustomeruser() {
		return customeruser;
	}
	public void setCustomeruser(List<CustomerUser> customeruser) {
		this.customeruser = customeruser;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerUser> getCustomeruserNew() {
		return customeruserNew;
	}


	public void setCustomeruserNew(List<CustomerUser> customeruserNew) {
		this.customeruserNew = customeruserNew;
	}


	public List<ReceptionOrder> getInfolist() {
		return infolist;
	}


	public void setInfolist(List<ReceptionOrder> infolist) {
		this.infolist = infolist;
	}


	public ReceptionOrder getOrderdetail() {
		return orderdetail;
	}


	public void setOrderdetail(ReceptionOrder orderdetail) {
		this.orderdetail = orderdetail;
	}
	

}
