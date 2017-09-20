package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.basis.service.IemployeeService;
import com.freshen.basis.service.IorganizationPostService;
import com.freshen.basis.service.impl.EmployeeServiceImpl;
import com.freshen.basis.service.impl.OrganizationPostServiceImpl;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrganizationPost;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.util.PageMsgBox;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 *     
 * 项目名称：carcenter    
 * 类名称：ManageOrderAction    
 * 类描述：查询未确认订单，制定客户助理    
 * 创建人：Administrator    
 * 创建时间：2014-4-2 下午08:41:31    
 * 修改人：Administrator    
 * 修改时间：2014-4-2 下午08:41:31    
 * 修改备注：    
 * @version     
 *
 */
public class ManageOrderAction extends CapgActionSupport implements ModelDriven<OrderDetail>{
	String QUERY="query";
	List<OrderDetail> ordersList=new ArrayList<OrderDetail>();
	String orderid,employeeID;
	OrderDetail orderdetail=new OrderDetail();
	//分页必须
	long totalOrderInfos;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	List<Employee>employeeList=new ArrayList();
	String msg;
	int  states;		//订单状态字段，0：查询已分配和未分配的全部订单  1：待分配订单   2：已分配订单
	
	/**
	 *  Function: 查询   预定试验数据，以便 分配 试验助理
	 *  @author Freshen  DateTime 2014-4-10 下午06:06:54
	 *  @return
	 */
	public String execute(){
		//System.out.println("订单分配查询，状态为 "+states);
		try {
			IorderInfoService iorderInfoService=new OrderInfoServiceImpl();
			OrderDetail orders=new OrderDetail();
			//确定查询 订单分配 类别
			if(states==1){
				orders.setEmployeeID_s("null");
			}else if(states==2){
				orders.setEmployeeID_s("notnull");
			}
			orders.setStatus_i(ConstantUtil.orderStatus_1);
			
			//确定记录总数
			totalOrderInfos =iorderInfoService.getOrderInfoNumber(orders);
			maxPage=(int) (totalOrderInfos%pageSize==0?totalOrderInfos/pageSize:totalOrderInfos/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0)
				currentPage=0;
			else if(currentPage>=maxPage)
				currentPage=maxPage;
			
			
			ordersList=iorderInfoService.getOrder(orders,currentPage*pageSize,pageSize);
			//System.out.println("查出 信息 "+ordersList.toString());
			msg="订单查询成功";
			//查询试验助理的岗位ID
			OrganizationPost op=new OrganizationPost();
			op.setLimitpage_s("searchMyOrderAction,审核试验");
			IorganizationPostService ios=new OrganizationPostServiceImpl();
			List<OrganizationPost> oplist=ios.getOrganizationPost(op, ConstantUtil.pagingNot, 0);
			
			//查询employee表
			IemployeeService es=new EmployeeServiceImpl();
			
			if(oplist!=null && oplist.size()>0){//如果客户助理不为空的话
				for (int i = 0; i < oplist.size(); i++) {
					Employee expAssistant =new Employee();
					expAssistant.setOrganizationPost_s(oplist.get(i).getOrganizationPost_s());	//查询岗位为 GW001 的职员，表示查 实验助手
					List<Employee> temp=es.getEmployees(expAssistant,ConstantUtil.pagingNot,0);	//查询出所有助手
					employeeList.addAll(temp);
				}
				
				if(employeeList!=null)
					System.out.println("预分配功能，查出助理人数 "+employeeList.size());
				else
					System.out.println("没有查出实验助理人员");
			}else{
				System.out.println("请设置试验助理岗位！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return "query";	
	}
	/**
	 *	Function: 给当前订单分配客户助理
	 *  @author sharonyshi
	 *  @return
	 */
	public String employwork(){
		//System.out.println(orderid +"---"+employeeID);
		try {
			IorderInfoService iorderInfoService=new OrderInfoServiceImpl();
			int employ=iorderInfoService.updateOrderDetailEmployeeID(orderid,employeeID);
			//操作成功后，从session中删除该项
			if(employ==1){
				msg=PageMsgBox.showMsgBox("分配成功订单"+orderid+"成功！");
			}else
				msg=PageMsgBox.showMsgBox("分配成功订单"+orderid+"失败！");
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return "forward";
	}

	public List<OrderDetail> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<OrderDetail> ordersList) {
		this.ordersList = ordersList;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public OrderDetail getModel() {
		// TODO Auto-generated method stub
		return orderdetail;
	}

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public long getTotalOrderInfos() {
		return totalOrderInfos;
	}

	public void setTotalOrderInfos(long totalOrderInfos) {
		this.totalOrderInfos = totalOrderInfos;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	
	
	
}
