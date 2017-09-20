package com.freshen.ground.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.preorder.service.ITimequantumService;
import com.freshen.preorder.service.IorderWorkShopService;
import com.freshen.preorder.service.impl.OrderWorkShopServiceImpl;
import com.freshen.preorder.service.impl.TimequantumServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class WorkshopAction extends CapgActionSupport{
	String orderId=(String) ActionContext.getContext().getSession().get("orderId");
	List<OrderWorkShop> workshoplist=new ArrayList<OrderWorkShop>();
	OrderWorkShop workshop=new OrderWorkShop();
	List<WorkShopInfo> wslist=new ArrayList<WorkShopInfo>();
	String orderWorkShopID_s,startdate,workshopName,remark,createDate,createUser;
	String workshopID;
	//车间预定修改了
	private int orderDuration;	//预定时长，填写数字 
	private int dateType;	//预定时长的单位，如 1表示 天，2 月，3半年，4 年

	int isupdate;//0代表新增，1代表更新
	
	String errmsg="";	//返回的json字符串
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	
	public String execute(){
		try {
			OrderWorkShop ows=new OrderWorkShop();
			ows.setOrderID_s(orderId);
			
			IorderWorkShopService iwss=new OrderWorkShopServiceImpl();
			workshoplist=iwss.getBasisWorkShop(ows,ConstantUtil.pagingNot, 0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		 
		}
		return SUCCESS;
	}


	public String initWorkshop(){
		try {
			OrderWorkShop ows=new OrderWorkShop();
			ows.setOrderWorkShopID_s(orderWorkShopID_s);
			
			IorderWorkShopService iwss=new OrderWorkShopServiceImpl();
			List<OrderWorkShop> list=iwss.getBasisWorkShop(ows,ConstantUtil.pagingNot, 0);
			if(list!=null){
				workshop=list.get(0);
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
	
	
	
	
	public String preparenewWorkshop(){
		try {
			//新增车间，查询所有车间的名称和ID
			IworkShopInfoService iwis=new WorkShopInfoServiceImpl();
			wslist=iwis.getWorkShopInfo(null, ConstantUtil.pagingNot,0);
			workshop=null;
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	
	public String modifyWorkshop(){
		try {
			//验证车间预定的有效性，有的车间只运行 按月预定，有的车间只运行按年预定
			IworkShopInfoService iwis=new WorkShopInfoServiceImpl();
			List<WorkShopInfo> workShopInfos=iwis.getWorkShopInfo(null, ConstantUtil.pagingNot,0);
			for (int i = 0; i < workShopInfos.size(); i++) {
				WorkShopInfo wsInfo =workShopInfos.get(i);
				if(wsInfo.getWorkShopID_s().equals(workshopID)){
					if(dateType==1 && wsInfo.getIsdaysubscribe_i()<1){
						setErrmsg("设施【"+wsInfo.getWorkShopName_s()+"】，不允许按日预定.");
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter(); 
				        out.println( errmsg);  
				        out.flush();  
				        out.close();  
						return null;
					}else if(dateType==2 && wsInfo.getIsmonthSubscribe_i()<1){
						setErrmsg("设施【"+wsInfo.getWorkShopName_s()+"】，不允许按月预定.");
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter(); 
				        out.println( errmsg);  
				        out.flush();  
				        out.close(); 
						return null;
					} 
					//判断预定天数是否符合要求
					if(dateType==1 && wsInfo.getIsdaysubscribe_i()>0 && orderDuration<wsInfo.getBeginningday_i() ){
						setErrmsg("设施【"+wsInfo.getWorkShopName_s()+"】，最少预定天数为"+wsInfo.getBeginningday_i()+".");
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("text/html;charset=UTF-8"); 
						PrintWriter out = response.getWriter(); 
				        out.println( errmsg);  
				        out.flush();  
				        out.close(); 
						return null;
					}
				}
			}
			
			//将申请 车间 数据 封装成对象 
			OrderWorkShop oworkshop=new OrderWorkShop();
			oworkshop.setOrderID_s(orderId);
			oworkshop.setOrderWorkShopID_s(orderWorkShopID_s);
			oworkshop.setStatus_i(0);//预定车间 初始状态
			oworkshop.setStartDate_t(DateUtil.getDate(startdate,"M/d/yyyy hh:mm:ss"));
			//处理结束日期，由预定的时长，转换为日期
			if(dateType==1&&orderDuration<5){
				setErrmsg("车间及设施预定最少5天.");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println( errmsg);  
		        out.flush();  
		        out.close(); 
				return null;
			}
			Date endDate =DateUtil.addDate(DateUtil.getDate(startdate, "M/d/yyyy hh:mm:ss"), dateType, orderDuration);
			//oworkshop.setEndDate_t(DateUtil.getDate(enddatepicker,"M/d/yyyy hh:mm:ss"));
			oworkshop.setEndDate_t(endDate);
			oworkshop.setWorkShopID_s(workshopID);
			oworkshop.setWorkShopName_s(workshopName);
			
			//oworkshop.setUseInfo_s(useInfo);
			//oworkshop.setRemark_s(remark);
			if(isupdate == 1){//更新
				oworkshop.setCreateDate_t(DateUtil.getDate(createDate));
				oworkshop.setCreateUser_s(createUser);
				oworkshop.setLastUpdateDate_t(DateUtil.getCurrentDate_s());
				oworkshop.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{//新增
				oworkshop.setCreateDate_t(DateUtil.getCurrentDate());
				oworkshop.setCreateUser_s(employ.getCustomerUserName_s());
			}
			
			List<OrderWorkShop> list=new ArrayList<OrderWorkShop>();
			list.add(oworkshop);
			
			ITimequantumService its=new TimequantumServiceImpl();
			int istrue=its.isSubscribeWorkShop(list);
			if(istrue == 1){//可以预定
				IorderWorkShopService iws=new OrderWorkShopServiceImpl();
				int re=iws.OperationorderWorkShop(list, 1);
				if(re==1){
					errmsg="操作成功！";
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/html;charset=UTF-8"); 
					PrintWriter out = response.getWriter(); 
			        out.println( errmsg);  
			        out.flush();  
			        out.close(); 
				}
			}else{
				errmsg="对不起，设施【"+workshopName+"】预订冲突！";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println( errmsg);  
		        out.flush();  
		        out.close(); 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}
	
	
	public String deleteorderWorkshop(){
		try {
			OrderWorkShop ws=new OrderWorkShop();
			ws.setOrderWorkShopID_s(orderWorkShopID_s);
			
			List<OrderWorkShop> wlist=new ArrayList<OrderWorkShop>();
			wlist.add(ws);
			
			IorderWorkShopService iws=new OrderWorkShopServiceImpl();
			iws.OperationorderWorkShop(wlist, 2);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	
	/*
	*//**
	 * 查询指定 车间ID的介绍信息，组成成json串，返回
	 *//*
	public String showWorkshop(){
		//System.out.println("准备查询 车间"+workshopID+" 的描述信息，返回json串。");
		ActionContext context = ActionContext.getContext();   
		HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			String str="{'total':28,'rows':["+
			"{'productid':'ID"+workshopID+"','productname':'车间收费描述正在策划中，需等待确认','unitcost':0},"+
	"{'productid':'建筑面积，平米','productname':'一层ConstantUtil.pageSizem*22m，二层ConstantUtil.pageSizem*6m','unitcost':420},"+
	"{'productid':'私密停车小院面积，平米','productname':'ConstantUtil.pageSizem*12m,带3米高围墙','unitcost':180},"+
	"{'productid':'年租金，万元','productname':'另收服务管理费每月每平米12元','unitcost':65},"+
	"{'productid':'半年租金，万元','productname':'另收服务管理费每月每平米12元','unitcost':40},"+
	"{'productid':'K9-DL-01','productname':'Dalmation','unitcost':12.00}"+
	"]}";
			str=str.replaceAll("\'", "\"");
			out.println(str);
			out.flush();
			out.close();
			//System.out.println("返回的 json串是 "+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	*/

	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public List<OrderWorkShop> getWorkshoplist() {
		return workshoplist;
	}



	public void setWorkshoplist(List<OrderWorkShop> workshoplist) {
		this.workshoplist = workshoplist;
	}


	public OrderWorkShop getWorkshop() {
		return workshop;
	}


	public void setWorkshop(OrderWorkShop workshop) {
		this.workshop = workshop;
	}


	public List<WorkShopInfo> getWslist() {
		return wslist;
	}


	public void setWslist(List<WorkShopInfo> wslist) {
		this.wslist = wslist;
	}


	public String getOrderWorkShopID_s() {
		return orderWorkShopID_s;
	}


	public void setOrderWorkShopID_s(String orderWorkShopID_s) {
		this.orderWorkShopID_s = orderWorkShopID_s;
	}


	public String getWorkshopID() {
		return workshopID;
	}


	public void setWorkshopID(String workshopID) {
		this.workshopID = workshopID;
	}


	public int getOrderDuration() {
		return orderDuration;
	}


	public void setOrderDuration(int orderDuration) {
		this.orderDuration = orderDuration;
	}


	public int getDateType() {
		return dateType;
	}


	public void setDateType(int dateType) {
		this.dateType = dateType;
	}


	public String getErrmsg() {
		return errmsg;
	}


	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getWorkshopName() {
		return workshopName;
	}


	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public int getIsupdate() {
		return isupdate;
	}


	public void setIsupdate(int isupdate) {
		this.isupdate = isupdate;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	

	
}
