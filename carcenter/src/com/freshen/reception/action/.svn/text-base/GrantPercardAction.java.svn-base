package com.freshen.reception.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.basis.service.ICustomerUserViewService;
import com.freshen.basis.service.IDriverService;
import com.freshen.basis.service.impl.CutomerUserViewServiceimpl;
import com.freshen.basis.service.impl.DriverServiceImpl;
import com.freshen.entity.Customer;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.basis.CustomerUser;
import com.freshen.entity.basis.Driver;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.VCustomeuser;
import com.freshen.entity.oneCard.TOnecardMjdoorBak;
import com.freshen.entity.reception.CardInfo;
import com.freshen.entity.reception.ReceptionCustomerUser;
import com.freshen.oneCard.service.IOneCardPbEmplyService;
import com.freshen.oneCard.service.ITOnecardMjdoorBakService;
import com.freshen.oneCard.service.ItOnecardMjreguserService;
import com.freshen.oneCard.service.impl.OneCardPbEmplyServiceImpl;
import com.freshen.oneCard.service.impl.TOnecardMjdoorBakServiceImpl;
import com.freshen.oneCard.service.impl.TOnecardMjreguserServiceImpl;
import com.freshen.preorder.service.IcustomerService;
import com.freshen.preorder.service.IcustomerUserService;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.CustomerServiceImpl;
import com.freshen.preorder.service.impl.CustomerUserServiceImpl;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.IreceptionCustomerUserService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.reception.service.impl.ReceptionCustomerUserServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class GrantPercardAction extends CapgActionSupport{
	String orderId=ActionContext.getContext().getSession().get("orderId").toString();
	String customerId=ActionContext.getContext().getSession().get("customerId").toString();
	
	String orderinvalidate;
	List<String> personCard=new ArrayList<String>();//记录人卡一维码
	List<ReceptionCustomerUser> recepUserList=new ArrayList<ReceptionCustomerUser>();//记录查询出来的登记的接待人员
	List<CustomerUser> customeruserlist=new ArrayList<CustomerUser>();//记录该公司的人员信息，用于额外添加的人员
	List<VCustomeuser> vcustomeruserlist=new ArrayList<VCustomeuser>();//记录公司所有人员试图
	Customer customer=new Customer();
	//List customeruserlist =new ArrayList();
	//List<ReceptionCustomerUser> unUserList=new ArrayList<ReceptionCustomerUser>();//记录还没有发卡的接待人员
	
	//记录发放人卡的信息
	List<String> customerUserID =new ArrayList<String>();
	List<String> customerUserName=new ArrayList<String>();
	List<String> serialface=new ArrayList<String>();
	List<String> card=new ArrayList<String>();
	List<Integer> userType=new ArrayList<Integer>();
	List<String> invalidate=new ArrayList<String>();
	List<String> sysNo=new ArrayList<String>();
	List<String> resaveds1=new ArrayList<String>();
	String authorizeDoors;
	String flagcard;//用于标志是发卡还是删除
	
	//页面传过来的值
	String customerName,department,UserName,identityCard,telephone,position,facsimile,email,type;
	//extra add customer-user,special use in no record reception
	String userids,usernames,usertypes;
	
	String drivingLicenceCPG_s;
	//记录额外添加的人员信息
	List<String> receptionCustomerUser=new ArrayList<String>();
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	
	
	public String execute(){
		try {
			//查询该订单的结束时间用于默认人卡的有效时间
			OrderDetail od=new OrderDetail();
			od.setOrderID_s(orderId);
			IorderInfoService ios=new OrderInfoServiceImpl();
			List<OrderDetail> odlist=ios.getOrder(od);
			
			//查询接待模块中的以存在的人员信息，用于发卡，此时人员信息是从预约表中copy过来的信息-sharonyshi
			ReceptionCustomerUser rcu=new ReceptionCustomerUser();
			rcu.setOrderID_s(orderId);
			
			IreceptionCustomerUserService ircus=new ReceptionCustomerUserServiceImpl();
			recepUserList=ircus.getReceptionCustomerUser(rcu, ConstantUtil.pagingNot,0);
			for (int i = 0; i <recepUserList.size(); i++) {
				if(recepUserList.get(i).getInvalidate_t() == null){
					//默认人卡的有效时间
					if(odlist!=null){
						recepUserList.get(i).setInvalidatestr(odlist.get(0).getEndDateStr());
					}
				}else{
					recepUserList.get(i).setInvalidatestr(DateUtil.dateToString(recepUserList.get(i).getInvalidate_t(), "yyyy-MM-dd"));
				}
			}
			
			/*List<ReceptionCustomerUser> templist=ircus.getReceptionCustomerUser(rcu, ConstantUtil.pagingNot,0);
			for (int i = 0; i < templist.size(); i++) {
				if(templist.get(i).getCard_s()!=null && !templist.get(i).equals("")){
					recepUserList.add(templist.get(i));
				}else{
					if(templist.get(i).getDeviceSysid_s()!=null){
						String tt=templist.get(i).getDeviceSysid_s().replace("vv",",");
						templist.get(i).setDeviceSysid_s(tt);
					}
					
					unUserList.add(templist.get(i));
				}
			}*/
			
			
			//显示该公司的额外人员，用于勾选添加
			
			//设置查询条件：客户ID
			VCustomeuser vcuser=new VCustomeuser();
			vcuser.setCustomerid_s(customerId);
			
			/*IcustomerUserService iUserService=new CustomerUserServiceImpl();
			customeruserlist=iUserService.getCustomerUser(customeruser,ConstantUtil.pagingNot, 0);
			*/
			ICustomerUserViewService iuserService=new CutomerUserViewServiceimpl();
			vcustomeruserlist=iuserService.getCusUserforReception(vcuser,ConstantUtil.pagingNot, 0);
			/*for (int i = 0; i < customeruserlist.size(); i++) {
				if(customeruserlist.get(i).getUserType_i()==null){
					customeruserlist.get(i).setUserType_i(3);//说明是驾驶员
					//customeruserlist.get(i)
				}
			}*/
			//确定记录总数
			totalPages =vcustomeruserlist.size();
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
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
	
	
	public String recordPersoncard(){
		try {
			List<ReceptionCustomerUser> culist=new ArrayList<ReceptionCustomerUser>();
			ArrayList<CardInfo> personcardlist=new ArrayList<CardInfo>();
			//String flag[]=flagcard.split(",");
			//将组装在一个串中 授权房门  拆成数组
			//System.out.println("待拆分的 字符串 "+ authorizeDoors);
			String authDoorArr []=authorizeDoors.split("I");
			for (int i = 0; i < customerUserID.size(); i++) {
				//if(flag[i].equals("0")) continue;
				if(card.get(i) != null && card.get(i).length() > 0){
					//为记录reception-customeruser表中
					ReceptionCustomerUser rcu=new ReceptionCustomerUser();
						rcu.setCustomerUserID_s(customerUserID.get(i).toString());
						rcu.setOrderID_s(orderId);
						rcu.setCustomerUserName_s(customerUserName.get(i).toString());
						rcu.setCard_s(card.get(i).toString());
						rcu.setSerialface_s(serialface.get(i).toString());
						//传的值是ID
						if(i < authDoorArr.length){
							String doors = getDoorList(authDoorArr[i]);
							//rcu.setDeviceSysid_s(authDoorArr[i].replace(",","vv"));
							rcu.setDeviceSysid_s(doors);
						}else{
							rcu.setDeviceSysid_s(null);
						}
						rcu.setInvalidate_t(DateUtil.getDate(invalidate.get(i).toString()));
						rcu.setCreateDate_t(DateUtil.getCurrentDate());
						rcu.setCreateUser_s(employ.getCustomerUserName_s());
						rcu.setSysNo_s(sysNo.get(i));
						rcu.setResaveds1_s(resaveds1.get(i));
						rcu.setUserType_i(userType.get(i));
						rcu.setUserType_s(""+userType.get(i));
						culist.add(rcu);//封装接待人员
					
					//为记录reception-cardinfo表中
					CardInfo temp=new CardInfo();
						temp.setOrderID_s(orderId);
						temp.setCard_s(card.get(i).toString());
						temp.setCardType_s(ConstantUtil.cardType_1);
						temp.setCreateUser_s(employ.getCustomerUserName_s());
						temp.setCreateDate_t(DateUtil.getCurrentDate());
					personcardlist.add(temp);//封装卡信息
				}
				
			}
			
			// 操作一卡通用户信息表
			//1、增加一卡通系统用户信息，获得sysno
			//2、删除oracle中原订单的用户
			//3、修改用户基础信息表，绑定sysno
			//4、保存orale订单的相关用户
			//5、调用一卡通的发卡存储过程
			IOneCardPbEmplyService ioces=new OneCardPbEmplyServiceImpl();
			ioces.OperationPbEmply(culist,orderId,1);
			//赋权或删除权限操作	 
			ItOnecardMjreguserService ioms=new TOnecardMjreguserServiceImpl();
			ioms.OperationMjreguser(orderId, 1);
			//删除原先的人卡信息，保存现在卡信息 cardInfo
			IcardInfoService cardservice=new CardInfoServiceImpl();
			cardservice.deleteReceptionCardInfoByOrderId(orderId,ConstantUtil.cardType_1);
			cardservice.saveOrUpdateReceptionCardInfo(personcardlist);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
			// TODO: handle exception
		}
		return SUCCESS;
	}

	
	public String recordExpersoncard(){
		try {
			//查询该订单的结束时间用于默认人卡的有效时间
			OrderDetail od=new OrderDetail();
			od.setOrderID_s(orderId);
			IorderInfoService ios=new OrderInfoServiceImpl();
			List<OrderDetail> odlist=ios.getOrder(od);
			OrderDetail order = new OrderDetail();
			if(odlist != null && odlist.size() > 0){
				order = odlist.get(0);
			}
			
			//set reception customer user  sharonyshi
			String uid[] = userids.split(",");
			String uname[] = usernames.split(",");
			String utype[] = usertypes.split(",");
			List<ReceptionCustomerUser> culist = new ArrayList<ReceptionCustomerUser>();
			//最后一次循环肯定是空值
			for (int i = 0; i < uid.length; i++) {
				ReceptionCustomerUser exuser = new ReceptionCustomerUser();
				exuser.setCustomerUserID_s(uid[i]);
				exuser.setOrderID_s(orderId);
				exuser.setCustomerUserName_s(uname[i]);
				if(utype[i] != null && utype[i].length() > 0){
					exuser.setUserType_i(Integer.valueOf(utype[i]));
				}
				exuser.setCreateDate_t(DateUtil.getCurrentDate());
				exuser.setCreateUser_s(employ.getCustomerUserName_s());
				exuser.setInvalidate_t(order.getEndDate_t());
				
				culist.add(exuser);
			}
			
			
			IreceptionCustomerUserService ius = new ReceptionCustomerUserServiceImpl();
			ius.OperationReceptionCustomerUser(culist, 1);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 获得与authDoorArr为同一组的door的id字符串，以vv分割
	 * getDoorList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public String getDoorList(String authDoorArr)throws Exception{
		ITOnecardMjdoorBakService iTOnecardMjdoorBakService = new TOnecardMjdoorBakServiceImpl();
		String doorId = "";
		try{
			String authDoorArres[] = authDoorArr.split(",");
			if(authDoorArres.length>0){
				for(String tmp:authDoorArres){
					TOnecardMjdoorBak tOnecardMjdoorBak = new TOnecardMjdoorBak();
					tOnecardMjdoorBak.setDoorIdI(Integer.valueOf(tmp));
					List<TOnecardMjdoorBak> list = iTOnecardMjdoorBakService.getTOnecardMjdoorBak(tOnecardMjdoorBak);
					if(BasicTools.isnotNull(list)){
						//得到组id
						String groupid_s = list.get(0).getGroupId_s();
						if(groupid_s!=null&&!"".equals(groupid_s.trim())){//是否有组
							tOnecardMjdoorBak = new TOnecardMjdoorBak();
							tOnecardMjdoorBak.setGroupId_s(groupid_s);
						//	tOnecardMjdoorBak.setIsGroup_s(groupid_s);
							List<TOnecardMjdoorBak> listtmp = iTOnecardMjdoorBakService.getTOnecardMjdoorBak(tOnecardMjdoorBak);
							for(TOnecardMjdoorBak tOnecardMjdoorBaktmp:listtmp){
								if(doorId.equals("")){
									doorId = doorId+tOnecardMjdoorBaktmp.getDoorIdI();
								}else{
									doorId = doorId+"vv"+tOnecardMjdoorBaktmp.getDoorIdI();
								}
							}
						}else{
							if(doorId.equals("")){
								doorId = doorId+tmp;
							}else{
								doorId = doorId+"vv"+tmp;
							}
						}
					}
				}
			}
			return doorId;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}		
	}
	
	/**
	 * 临时添加额外人员
	 * sharonyshi 2014-11-17
	 * @return
	 */
	public String exPerson(){
		try {
			String resultid=null;
			//说明是驾驶员 
			if(type.equals("3")){
				Driver driver=new Driver();
				driver.setCreateDate_t(DateUtil.getCurrentDate());
				driver.setCreateUser_s(employ.getCustomerUserName_s());
				driver.setLastUpdateDate_t(DateUtil.getCurrentDate());
				driver.setCustomerID_s(customerId);
				driver.setCustomerName_s(customerName);
				driver.setCustomerUserName_s(UserName);
				driver.setTelephone_s(telephone);
				driver.setDepartment_s(department);
				driver.setPosition_s(position);
				driver.setDrivingLicenceCPG_s(drivingLicenceCPG_s);
				driver.setIdentityCard_s(identityCard);
				driver.setEmail_s(email);
				//driver.setUserType_i(userType);
				ArrayList<Driver> dlist=new ArrayList<Driver>();
				dlist.add(driver);
				
				IDriverService ids=new DriverServiceImpl();
				resultid=ids.saveOrUpdateBasisDriverInfo2(dlist);
				
			}else{
				CustomerUser addUser=new CustomerUser();
				addUser.setCreateDate_t(DateUtil.getCurrentDate());
				addUser.setCreateUser_s(employ.getCustomerUserName_s());
				addUser.setLastUpdateDate_t(DateUtil.getCurrentDate());
				addUser.setCustomerID_s(customerId);
				addUser.setCustomerUserName_s(UserName);
				addUser.setDepartment_s(department);
				addUser.setIdentityCard_s(identityCard);
				addUser.setPosition_s(position);
				addUser.setTelephone_s(telephone);
				addUser.setFacsimile_s(facsimile);
				addUser.setEmail_s(email);
				addUser.setUserType_i(Integer.parseInt(type));
				
				IcustomerUserService iuserService=new CustomerUserServiceImpl();
				resultid=iuserService.OperationBasisCustomerUser2(addUser);
			}	
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter(); 
	        out.println(resultid);  
	        out.flush();  
	        out.close();  
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	public String prepareexPerson(){
		try {
			Customer c= new Customer();
			c.setCustomerID_s(customerId);
			
			IcustomerService ics=new CustomerServiceImpl();
			ArrayList<Customer> clist=ics.getCustomer(c, ConstantUtil.pagingNot,ConstantUtil.pageSize);
			if(clist != null && clist.size() > 0){
				customer =clist.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
/*	public String exPerson(){
		try {
			//如果没有勾选任何额外人员，就直接返回
			if(receptionCustomerUser==null ||receptionCustomerUser.size()<1){
				return SUCCESS;
			}
			
			List<ReceptionCustomerUser> recuserlist=new ArrayList<ReceptionCustomerUser>();//传入相关客户信息
			//Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");
			//System.out.println("orderId"+orderId.toString());
			for (int i = 0; i < receptionCustomerUser.size(); i++) {
				String[] uu=receptionCustomerUser.get(i).split(",");
				ReceptionCustomerUser temp=new ReceptionCustomerUser();
				temp.setCustomerUserID_s(uu[0].toString());
				temp.setOrderID_s(orderId);
				temp.setCustomerUserName_s(uu[1].toString());
				temp.setUserType_i(Integer.parseInt(uu[2]));
				temp.setCreateUser_s(employ.getCustomerUserName_s());
				temp.setCreateDate_t(DateUtil.getCurrentDate());
				//System.out.println(temp.toString());
				recuserlist.add(temp);
			}
			
			IreceptionCustomerUserService ireceptionUserService=new ReceptionCustomerUserServiceImpl();
			int result=ireceptionUserService.OperationReceptionCustomerUser(recuserlist, 1);//1：新增
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
			// TODO: handle exception
		}
		return SUCCESS;
		
	}*/
	public String deletePersoncard(){
		try {
			
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<String> getPersonCard() {
		return personCard;
	}

	public void setPersonCard(List<String> personCard) {
		this.personCard = personCard;
	}

	public List<ReceptionCustomerUser> getRecepUserList() {
		return recepUserList;
	}

	public void setRecepUserList(List<ReceptionCustomerUser> recepUserList) {
		this.recepUserList = recepUserList;
	}

	public List<String> getCustomerUserID() {
		return customerUserID;
	}
	public void setCustomerUserID(List<String> customerUserID) {
		this.customerUserID = customerUserID;
	}
	public List<String> getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(List<String> customerUserName) {
		this.customerUserName = customerUserName;
	}
	public List<String> getSerialface() {
		return serialface;
	}
	public void setSerialface(List<String> serialface) {
		this.serialface = serialface;
	}
	public String getAuthorizeDoors() {
		return authorizeDoors;
	}
	public void setAuthorizeDoors(String authorizeDoors) {
		this.authorizeDoors = authorizeDoors;
	}
	public List<String> getCard() {
		return card;
	}
	public void setCard(List<String> card) {
		this.card = card;
	}

	public List<Integer> getUserType() {
		return userType;
	}
	public void setUserType(List<Integer> userType) {
		this.userType = userType;
	}
	public List<String> getReceptionCustomerUser() {
		return receptionCustomerUser;
	}
	public void setReceptionCustomerUser(List<String> receptionCustomerUser) {
		this.receptionCustomerUser = receptionCustomerUser;
	}
	public List<CustomerUser> getCustomeruserlist() {
		return customeruserlist;
	}
	public void setCustomeruserlist(List<CustomerUser> customeruserlist) {
		this.customeruserlist = customeruserlist;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
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
	public List<String> getSysNo() {
		return sysNo;
	}
	public void setSysNo(List<String> sysNo) {
		this.sysNo = sysNo;
	}
	public List<String> getInvalidate() {
		return invalidate;
	}
	public void setInvalidate(List<String> invalidate) {
		this.invalidate = invalidate;
	}
	public String getOrderinvalidate() {
		return orderinvalidate;
	}
	public void setOrderinvalidate(String orderinvalidate) {
		this.orderinvalidate = orderinvalidate;
	}
	public List<String> getResaveds1() {
		return resaveds1;
	}
	public void setResaveds1(List<String> resaveds1) {
		this.resaveds1 = resaveds1;
	}
	public List<VCustomeuser> getVcustomeruserlist() {
		return vcustomeruserlist;
	}
	public void setVcustomeruserlist(List<VCustomeuser> vcustomeruserlist) {
		this.vcustomeruserlist = vcustomeruserlist;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFacsimile() {
		return facsimile;
	}
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDrivingLicenceCPG_s() {
		return drivingLicenceCPG_s;
	}
	public void setDrivingLicenceCPG_s(String drivingLicenceCPG_s) {
		this.drivingLicenceCPG_s = drivingLicenceCPG_s;
	}
	public String getFlagcard() {
		return flagcard;
	}
	public void setFlagcard(String flagcard) {
		this.flagcard = flagcard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserids() {
		return userids;
	}
	public void setUserids(String userids) {
		this.userids = userids;
	}
	public String getUsernames() {
		return usernames;
	}
	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}
	public String getUsertypes() {
		return usertypes;
	}
	public void setUsertypes(String usertypes) {
		this.usertypes = usertypes;
	}
	
	
}
