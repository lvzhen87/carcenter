package com.freshen.ground.action;

import java.util.ArrayList;

import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.entity.CustomerRegister;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.preorder.service.IcustomerRegisterService;
import com.freshen.preorder.service.impl.CustomerRegisterServiceimpl;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.util.ConstantUtil;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class CustomerUserRegisterAction extends CapgActionSupport{
	//订单ID 和 订单状态
	private String orderState= (String) ActionContext.getContext().getSession().get("orderstatus");
	private String orderId=(String) ActionContext.getContext().getSession().get("orderId");	//订单ID
	private List registerlist=new ArrayList();	//试验人员信息集合
	private String userID;	//人员ID，删除人员时使用
	private String errmsg;	//错题信息提示
	/**
	 * 查询出 指定 订单下，试验人员信息，包括 联系人和 驾驶员
	 */
	public String execute(){
		try {
			int state=Integer.parseInt(orderState);
			//根据订单状态的不同，查询不同的 试验人员表
			if(state==1 || state==2){
				//订单未 接待状态，此时 试验人员信息，都存在 预约模块的表中
				CustomerRegister cr=new CustomerRegister();
				cr.setOrderID_s(orderId);
				IcustomerRegisterService irs=new CustomerRegisterServiceimpl();
				registerlist=irs.getBasisCustomerRegister(cr,ConstantUtil.pagingNot, 0);
				//System.out.println("查出订单 "+orderId +"  下 试验人员数量为"+registerlist.size() );
			}else{
				//订单接待了
				ReceptionCustomerUser cu=new ReceptionCustomerUser();
				cu.setOrderID_s(orderId);
				IreceptionCustomerUserService rcuSer =new ReceptionCustomerUserServiceImpl();
				//ArrayList<ReceptionCustomerUser> cus =rcuSer.getCustomerUserAllpro(cu);
				registerlist=rcuSer.getReceptionCustomerUser(cu, ConstantUtil.pagingNot, 1);
				//System.out.println("查出订单 "+orderId +"  下 试验人员数量为"+registerlist.size() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 *  Function:根据 人员ID，删除人员信息，需要注意 订单状态 会影响操作的 表不同
	 *  @author Freshen  DateTime 2014-8-6 上午11:14:ConstantUtil.pageSize
	 *  @return
	 */
	public String delUserRegister(){
		try {
			int state=Integer.parseInt(orderState);
			if(state==1 || state==2){
				//删除 预约模块中  的 人员信息
				CustomerRegister cr=new CustomerRegister();
				cr.setCustomerUserID_s(userID);
				IcustomerRegisterService irs=new CustomerRegisterServiceimpl();
				List<CustomerRegister> ls =new ArrayList();
				ls.add(cr);
				irs.OperationCustomerRegister(ls, 2);
			}else{
				//删除接待模块中的人员信息
				ReceptionCustomerUser cu=new ReceptionCustomerUser();
				cu.setCustomerUserID_s(userID);
				IreceptionCustomerUserService rcuSer =new ReceptionCustomerUserServiceImpl();
				List<ReceptionCustomerUser> ls =new ArrayList();
				rcuSer.OperationReceptionCustomerUser(ls, 2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public List getRegisterlist() {
		return registerlist;
	}
	public void setRegisterlist(List registerlist) {
		this.registerlist = registerlist;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
