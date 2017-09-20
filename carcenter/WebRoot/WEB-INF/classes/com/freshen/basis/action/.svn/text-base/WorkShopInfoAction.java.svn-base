package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.TBasisWorkshopcost;
import com.freshen.entity.basis.WorkShopInfo;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class WorkShopInfoAction extends CapgActionSupport{
	String workShopID,workShopName,remark,deluseinfo,useInfosearch;
	int isSubscribe,ismonthSubscribe_i,isdaysubscribe_i;
	String beginningday_i,unitprieI,monthUnitPrie_i,yearUnitPrie_i,halfUnitPrie_i,serveManageUnitPrie_i;
	String resaveds1;	
	String useInfo;
	//List<String> useInfo=new ArrayList<String>();//记录添加的车间使用内容
	List<String> useInfoList=new ArrayList<String>();//存放拆分后的车间使用内容
	ArrayList<WorkShopInfo> workshoplist=new ArrayList<WorkShopInfo>();
	WorkShopInfo workshop=new WorkShopInfo();
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	
	String msg="";
	String flag;
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	/**
	 * 默认查询所有车间基础信息，当有查询条件时查询该信息
	 * @author sharonyshi 2014-5-13
	 */
	public String execute(){
		try {
			////System.out.println("zhixingwo ");
			//设置要查询的信息，默认为查询所有信息
			WorkShopInfo ws=new WorkShopInfo();
			//ws.setWorkShopID_s(workShopID);
			if(flag != null){
				if(workShopName!=null && workShopName.trim().length()>1)
					workShopName=(new String(workShopName.getBytes("ISO-8859-1"),"UTF-8" ));
			}
			ws.setWorkShopName_s(workShopName);
			ws.setUseInfos_s(useInfosearch);
			
			IworkShopInfoService iwsis=new WorkShopInfoServiceImpl();
			//确定记录总数
			totalPages =iwsis.getWorkShopInfoNumber(ws);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				workshoplist=iwsis.getWorkShopInfo(ws,currentPage*pageSize, pageSize);
			}
			/*if(workshoplist != null){
				for (int i = 0; i < workshoplist.size(); i++) {
					if(workshoplist.get(i).getUseInfos_s() !=null && !workshoplist.get(i).equals("")){
					workshoplist.get(i).setUseInfos_s(workshoplist.get(i).getUseInfos_s().replace("vv","; "));
					}
				}
			}*/
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
	 * 判断是否存在ID，若有ID说明是更新操作需要查询相关信息，若没有ID则是添加操作
	 * @author sharonyshi 2014-5-13
	 */
	public String prepareWorkshopInfo(){
		try {
			WorkShopInfo wsi=new WorkShopInfo();
			if(workShopID != null && !workShopID.trim().equals("")){//说明是更新操作
				wsi.setWorkShopID_s(workShopID);
				//要查询该工作车间的使用内容list
				IworkShopInfoService iwsis=new WorkShopInfoServiceImpl();
				workshoplist=iwsis.getWorkShopInfo(wsi);
				if(workshoplist!=null){
					workshop=workshoplist.get(0);
					/*if(workshop.getUseInfos_s()!=null){
						String temp[]=workshop.getUseInfos_s().split("vv");
						for (int i = 0; i < temp.length; i++) {
							useInfoList.add(temp[i]);
						}
					}*/
				}
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
	
	
	/**
	 * 添加新的车间基础信息
	 * @author sharonyshi 2014-5-5
	 */
	public String addWorkshopInfo(){
		try {
			TBasisWorkshopcost tbcost=new TBasisWorkshopcost();
			tbcost.setCreatedateT(DateUtil.getCurrentDate());
			tbcost.setCreateuserS(employ.getCustomerUserName_s());
			tbcost.setWorkshopidS(workShopID);
			//下面这几个费用值，如果从页面中传过来有值，则set那个值，否则默认值为0.0
			if(unitprieI!=null && !unitprieI.equals("")){
				tbcost.setUnitprieI(Double.valueOf(unitprieI));
			}else{
				tbcost.setUnitprieI(ConstantUtil.price_0);
			}
			if(monthUnitPrie_i!=null && !monthUnitPrie_i.equals("")){
				tbcost.setMonthUnitPrie_i(Double.valueOf(monthUnitPrie_i));
			}else{
				tbcost.setMonthUnitPrie_i(ConstantUtil.price_0);
			}
			if(yearUnitPrie_i!=null && !yearUnitPrie_i.equals("")){
				tbcost.setYearUnitPrie_i(Double.valueOf(yearUnitPrie_i));
			}else{
				tbcost.setYearUnitPrie_i(ConstantUtil.price_0);
			}
			if(halfUnitPrie_i!=null && !halfUnitPrie_i.equals("")){
				tbcost.setHalfUnitPrie_i(Double.valueOf(halfUnitPrie_i));
			}else{
				tbcost.setHalfUnitPrie_i(ConstantUtil.price_0);
			}
			if(serveManageUnitPrie_i !=null && !serveManageUnitPrie_i.equals("")){
				tbcost.setServeManageUnitPrie_i(Integer.valueOf(serveManageUnitPrie_i));
			}else{
				tbcost.setServeManageUnitPrie_i(ConstantUtil.serverprice_0);
			}
			if(resaveds1 != null && resaveds1.length() > 0){
				tbcost.setResaveds1S(resaveds1);
			}else{
				tbcost.setResaveds1S(ConstantUtil.m2 + "");
			}
			
			
			WorkShopInfo wsi=new WorkShopInfo();
			if(workShopID != null && !workShopID.trim().equals("")){//说明是更新操作
				wsi.setWorkShopID_s(workShopID);
				wsi.setLastUpdateDate_t(DateUtil.getCurrentDate());
				wsi.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{//新增操作
				wsi.setCreateUser_s(employ.getCustomerUserName_s());
				wsi.setCreateDate_t(DateUtil.getCurrentDate());
				wsi.setLastUpdateDate_t(DateUtil.getCurrentDate());
			}
			wsi.setWorkShopName_s(workShopName);
			wsi.setIsSubscribe_i(isSubscribe);
			wsi.setIsdaysubscribe_i(isdaysubscribe_i);
			wsi.setIsmonthSubscribe_i(ismonthSubscribe_i);
			//如果最少预订天数有值就set
			if(beginningday_i !=null && !beginningday_i.equals("")){
				wsi.setBeginningday_i(Integer.valueOf(beginningday_i));
			}else{//否则默认为1
				wsi.setBeginningday_i(ConstantUtil.beginningday);
			}
			/*String alluseinfo="";
			if(useInfo !=null && !useInfo.equals("") ){
				alluseinfo= useInfo.substring(0,useInfo.length()-2);
			}
			wsi.setUseInfos_s(alluseinfo);*/
			wsi.setRemark_s(remark);
			
			tbcost.setWorkShopInfo(wsi);
			wsi.settBasisWorkshopcost(tbcost);
			
			
			//封装list中
			ArrayList<WorkShopInfo> wslist=new ArrayList<WorkShopInfo>();
			wslist.add(wsi);
			
			IworkShopInfoService iwsis=new WorkShopInfoServiceImpl();
			int result=iwsis.OperationWorkShopInfo(wslist, 1);
			msg="success";
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}
	
	/**
	 * 根据ID删除相应的使用内容
	 * @author sharonyshi 2014-5-20
	 * @return
	 */
	public String deleteuseinfo(){
		try {
			IworkShopInfoService iwsis=new WorkShopInfoServiceImpl();
			iwsis.OperationWorkShopInfoUseInfos(workShopID, deluseinfo);
			
			//删除之后，继续查询该信息
			WorkShopInfo wsi=new WorkShopInfo();
			wsi.setWorkShopID_s(workShopID);
			workshoplist=iwsis.getWorkShopInfo(wsi);
			if(workshoplist!=null){
				workshop=workshoplist.get(0);
				String temp[]=workshop.getUseInfos_s().split("vv");
				for (int i = 0; i < temp.length; i++) {
					useInfoList.add(temp[i]);
				}
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
	
	
	/**
	 * 删除该条车间基础信息
	 * @author sharonyshi 2014-5-5
	 */
	public String deleteWorkshopInfo(){
		try {
			TBasisWorkshopcost tbcost=new TBasisWorkshopcost();
			tbcost.setWorkshopidS(workShopID);
			
			WorkShopInfo ws=new WorkShopInfo();
			ws.setWorkShopID_s(workShopID);
			
			tbcost.setWorkShopInfo(ws);
			ws.settBasisWorkshopcost(tbcost);
			//封装list中
			ArrayList<WorkShopInfo> wslist=new ArrayList<WorkShopInfo>();
			wslist.add(ws);
			
			IworkShopInfoService iwsis=new WorkShopInfoServiceImpl();
			int result=iwsis.OperationWorkShopInfo(wslist, 2);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			  
		}
		return SUCCESS;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getWorkShopID() {
		return workShopID;
	}

	public void setWorkShopID(String workShopID) {
		this.workShopID = workShopID;
	}

	public String getWorkShopName() {
		return workShopName;
	}

	public void setWorkShopName(String workShopName) {
		this.workShopName = workShopName;
	}

	public String getUseInfosearch() {
		return useInfosearch;
	}

	public void setUseInfosearch(String useInfosearch) {
		this.useInfosearch = useInfosearch;
	}

	/*public List<String> getUseInfo() {
		return useInfo;
	}

	public void setUseInfo(List<String> useInfo) {
		this.useInfo = useInfo;
	}
*/
	
	public ArrayList<WorkShopInfo> getWorkshoplist() {
		return workshoplist;
	}

	

	public void setWorkshoplist(ArrayList<WorkShopInfo> workshoplist) {
		this.workshoplist = workshoplist;
	}

	public WorkShopInfo getWorkshop() {
		return workshop;
	}

	public void setWorkshop(WorkShopInfo workshop) {
		this.workshop = workshop;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public List<String> getUseInfoList() {
		return useInfoList;
	}



	public void setUseInfoList(List<String> useInfoList) {
		this.useInfoList = useInfoList;
	}


	public String getDeluseinfo() {
		return deluseinfo;
	}
	public void setDeluseinfo(String deluseinfo) {
		this.deluseinfo = deluseinfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public int getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(int isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getUseInfo() {
		return useInfo;
	}

	public void setUseInfo(String useInfo) {
		this.useInfo = useInfo;
	}

	public int getIsmonthSubscribe_i() {
		return ismonthSubscribe_i;
	}

	public void setIsmonthSubscribe_i(int ismonthSubscribe_i) {
		this.ismonthSubscribe_i = ismonthSubscribe_i;
	}

	public int getIsdaysubscribe_i() {
		return isdaysubscribe_i;
	}

	public void setIsdaysubscribe_i(int isdaysubscribe_i) {
		this.isdaysubscribe_i = isdaysubscribe_i;
	}

	public String getBeginningday_i() {
		return beginningday_i;
	}

	public void setBeginningday_i(String beginningday_i) {
		this.beginningday_i = beginningday_i;
	}

	public String getUnitprieI() {
		return unitprieI;
	}

	public void setUnitprieI(String unitprieI) {
		this.unitprieI = unitprieI;
	}

	public String getMonthUnitPrie_i() {
		return monthUnitPrie_i;
	}

	public void setMonthUnitPrie_i(String monthUnitPrie_i) {
		this.monthUnitPrie_i = monthUnitPrie_i;
	}

	public String getYearUnitPrie_i() {
		return yearUnitPrie_i;
	}

	public void setYearUnitPrie_i(String yearUnitPrie_i) {
		this.yearUnitPrie_i = yearUnitPrie_i;
	}

	public String getHalfUnitPrie_i() {
		return halfUnitPrie_i;
	}

	public void setHalfUnitPrie_i(String halfUnitPrie_i) {
		this.halfUnitPrie_i = halfUnitPrie_i;
	}

	public String getServeManageUnitPrie_i() {
		return serveManageUnitPrie_i;
	}

	public void setServeManageUnitPrie_i(String serveManageUnitPrie_i) {
		this.serveManageUnitPrie_i = serveManageUnitPrie_i;
	}

	public String getResaveds1() {
		return resaveds1;
	}

	public void setResaveds1(String resaveds1) {
		this.resaveds1 = resaveds1;
	}

	

	
	
}
