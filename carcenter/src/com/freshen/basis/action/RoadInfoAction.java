package com.freshen.basis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IroadExperimentTypeService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadExperimentTypeServiceImpl;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadCost;
import com.freshen.entity.basis.RoadExperimentType;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class RoadInfoAction extends CapgActionSupport{

	private static final long serialVersionUID = 1L;
	
	String roadID,roadName,technicalParameters,inputdate,remark,roadType,state;
	String exptypeID;
	String experimentTypeName;
	String overproofUnitPrie_i,unitPrie_i,wholeUnitPrie_i,wholeOverproofUnitPrie_i;
	String minuteUnitPrie_i,coefficient_i,activityUnitPrie_i,resaveds1,resaveds2,resaveds4;
	int beginningDay_i;
	String resaveds1_s;			//	道路分组
	String resaveds2_s;			//是否为洗车机用       1：是     0：否
	Date inputDate_t;
	String msg,flag;
	/*Double overproofUnitPrie_i; //大于3.5 吨&两轴,按小时算
	Double unitPrie_i;	   //小于3.5 吨&两轴,按小时算
	Double wholeUnitPrie_i;	   //包场费用小于3.5 吨&两轴,按小时算
	Double wholeOverproofUnitPrie_i;//包场费用大于3.5 吨&两轴,按小时算
*/	//ArrayList<String> experimentTypeName=new ArrayList();//存放实验类型名称
	int maxCapacity;
	ArrayList<RoadInfo> roadlist = new ArrayList<RoadInfo>();//记录道路信息
	RoadInfo roadinfo = new RoadInfo();//要更新的道路信息
	ArrayList<RoadExperimentType> roadexptypeList = new ArrayList<RoadExperimentType>();//试验类型

	//获取登录人信息，记为创建人
	Employee employ = (Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	/**
	 * 查询道路信息，默认时查询所有道路信息，当有查询条件时查询该信息
	 * @author sharonyshi 2014-5-13
	 */
	/*public String execute(){
		try {
			//设置查询条件
			RoadInfo ri=new RoadInfo();
			ri.setState_i(-1);//设置查询0和1的状态，即查询所有状态
			
			ArrayList<RoadInfo> rilist=new ArrayList<RoadInfo>();
			rilist.add(ri);
			
			IroadInfoService iris=new RoadInfoServiceImpl();
			roadlist=iris.getRoadInfo(ri);
			
			for (int i = 0; i < roadlist.size(); i++) {
				String temp="";
				Iterator<RoadExperimentType> it = roadlist.get(i).getRoadExperimentTypeSet().iterator();
				while(it.hasNext()){
					temp += it.next().getExperimentTypeName_s()+";";
				}
				roadlist.get(i).setTypes(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
		}
		
		return SUCCESS;
	}*/
	
	/**
	 * 查询道路信息，默认时查询所有道路信息，当有查询条件时查询该信息
	 * @author sharonyshi 2014-5-13
	 */
	public String searchRoadinfo(){
		try {
			//设置查询条件
			RoadInfo ri=new RoadInfo();
			if(flag != null){
				if(roadName!=null && roadName.trim().length()>1)
					roadName=(new String(roadName.getBytes("ISO-8859-1"),"UTF-8" ));				
			}
			//ri.setRoadID_s(roadID);
			ri.setRoadName_s(roadName);
			ri.setTechnicalParameters_s(technicalParameters);
			if(state!=null && !state.equals("")){
				ri.setState_i(Integer.valueOf(state));
			}else{
				ri.setState_i(-1);//设置查询0和1的状态，即查询所有状态
			}
			//封装list
			ArrayList<RoadInfo> rilist=new ArrayList<RoadInfo>();
			rilist.add(ri);
			

			IroadInfoService iris=new RoadInfoServiceImpl();
			//确定记录总数
			totalPages =iris.getRoadInfoNumber(ri);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				roadlist=iris.getRoadInfo(ri,currentPage*pageSize, pageSize);
				
				for (int i = 0; i < roadlist.size(); i++) {
					String temp="";
					Iterator<RoadExperimentType> it = roadlist.get(i).getRoadExperimentTypeSet().iterator();
					while(it.hasNext()){
						temp += it.next().getExperimentTypeName_s()+";";
					}
					roadlist.get(i).setTypes(temp);
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
	 * 判断是否存在道路编号，若不存在说明是新增，存在则需要查询相应数据
	 * @author sharonyshi 2014-5-13
	 */
	public String prepareRoadinfo(){
		try {
			if(roadID!=null){
				RoadInfo ri=new RoadInfo();
				ri.setRoadID_s(roadID);
				
				IroadInfoService iris=new RoadInfoServiceImpl();
				roadlist=iris.getRoadInfo(ri);
				if(roadlist!=null){
					roadinfo=roadlist.get(0);
				}
//				state = roadinfo.getState_i().toString();
//				roadType = roadinfo.getRoadType_s().toString();
//				inputdate = roadinfo.getInputDate_t().toString().substring(0,10);
				
				
				//下面的方法注释掉，目前道路类型没用，sharonyshi 2014-8-8
//				RoadExperimentType ret=new RoadExperimentType();
//				ret.setRoadID_s(roadID);
				
//				//获取该ID的试验类型list
//				IroadExperimentTypeService irets=new RoadExperimentTypeServiceImpl();
//				roadexptypeList=irets.getBasisRoadExperimentTypeInfo(ret, ConstantUtil.pagingNot,0);
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
	 * 添加新的道路信息
	 * @author sharonyshi 2014-5-13
	 */
	public String addRoadinfo(){
		try {
			//设置道路收费
			RoadCost rc=new RoadCost();
			rc.setRoadID_s(roadID);
			rc.setRemark_s(remark);
			rc.setCreateUser_s(employ.getCustomerUserName_s());
			rc.setCreateDate_t(DateUtil.getCurrentDate());
			rc.setLastUpdateDate_t(DateUtil.getCurrentDate());
			rc.setLastUpdateUser_s(employ.getCustomerUserName_s());
			
			//下面这几个费用值，如果从页面中传过来有值，则set那个值，否则默认值为0.0

			if(unitPrie_i !=null && !unitPrie_i.equals("")){
				rc.setUnitPrie_i(Double.valueOf(unitPrie_i));
			}else{
				rc.setUnitPrie_i(ConstantUtil.price_0);
			}
			
			if(wholeUnitPrie_i !=null && !wholeUnitPrie_i.equals("")){
				rc.setWholeUnitPrie_i(Double.valueOf(wholeUnitPrie_i));
			}else{
				rc.setWholeUnitPrie_i(ConstantUtil.price_0);
			}
			
			if(minuteUnitPrie_i !=null && !minuteUnitPrie_i.equals("")){
				rc.setMinuteUnitPrie_i(Integer.valueOf(minuteUnitPrie_i));
			}else{
				rc.setMinuteUnitPrie_i(ConstantUtil.serverprice_0);
			}
			if(coefficient_i != null && !coefficient_i.equals("")){
				rc.setCoefficient_i(Double.valueOf(coefficient_i));
			}else{
				rc.setCoefficient_i(ConstantUtil.price_1);
			}
			if(activityUnitPrie_i != null && !activityUnitPrie_i.equals("")){
				rc.setActivityUnitPrie_i(Double.valueOf(activityUnitPrie_i));
			}else{
				rc.setActivityUnitPrie_i(ConstantUtil.price_0);
			}
			if(resaveds1 != null && resaveds1.length() >0){
				rc.setResaveds1_s(resaveds1);
			}
			if(resaveds2 != null && resaveds2.length() >0){
				rc.setResaveds2_s(resaveds2);
			}else{
				rc.setResaveds2_s(ConstantUtil.price_0 + "");
			}
			
			
			
			RoadInfo ri=new RoadInfo();
			if(roadID != null &&!roadID.trim().equals("")){//更新操作
				ri.setRoadID_s(roadID);
				ri.setLastUpdateDate_t(DateUtil.getCurrentDate());
				ri.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{//新增操作
				ri.setCreateDate_t(DateUtil.getCurrentDate());
				ri.setCreateUser_s(employ.getCustomerUserName_s());
				ri.setLastUpdateDate_t(DateUtil.getCurrentDate());
			}
			ri.setRoadName_s(roadName);
			ri.setTechnicalParameters_s(technicalParameters);
			ri.setMaxCapacity_i(maxCapacity);
			//ri.setInputDate_t(DateUtil.getDate(inputdate));
			ri.setBeginningDay_i(beginningDay_i);
			ri.setState_i(Integer.valueOf(state));
			ri.setRemark_s(remark);
			ri.setRoadType_s(roadType);
			ri.setInputDate_t(inputDate_t);
			rc.setRoadInfo(ri);
			ri.setRoadCost(rc);
			ri.setResaveds1_s(resaveds1_s);
			ri.setResaveds2_s(resaveds2_s);
			ri.setResaveds4_s(resaveds4);
			//封装list
			ArrayList<RoadInfo> rilist=new ArrayList<RoadInfo>();
			rilist.add(ri);
			
		/*	sharonyshi-2014-7-31   目前没用
		 * //封装实验类型,首先是循环遍历页面中输入的试验类型名称，将每条试验类型记录与道路信息组合成一条记录
			ArrayList<RoadExperimentType> retlist=new ArrayList<RoadExperimentType>();
			String ets[]=experimentTypeName.split("vv");
			for (int i = 0; i < ets.length; i++) {
				if(!ets[i].trim().equals("")){
					RoadExperimentType temp=new RoadExperimentType();
					temp.setExperimentTypeName_s(ets[i]);
					temp.setRoadID_s(roadID);
					temp.setRoadName_s(roadName);
					temp.setCreateDate_t(DateUtil.getCurrentDate());
					temp.setCreateUser_s(employ.getCustomerUserName_s());
					retlist.add(temp);
				}
			}*/
			
			/*for (int i = 0; i < experimentTypeName.size(); i++) {
				if(!experimentTypeName.get(i).trim().equals("")){
					RoadExperimentType temp=new RoadExperimentType();
					temp.setExperimentTypeName_s(experimentTypeName.get(i));
					temp.setRoadID_s(roadID);
					temp.setRoadName_s(roadName);
					temp.setCreateDate_t(DateUtil.getCurrentDate());
					temp.setCreateUser_s(employ.getCustomerUserName_s());
					retlist.add(temp);
				}
			}*/
			
			
			IroadInfoService iris=new RoadInfoServiceImpl();
			int result = iris.OperationRoadInfoInfo(rilist, 1);
			if(result == 0){
				return ERROR;
			}
//			IroadExperimentTypeService irets=new RoadExperimentTypeServiceImpl();
//			irets.saveOrUpdateBasisRoadExperimentTypeInfo(retlist);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String deleteRoadExptype(){
		try {
			//设置要删除的试验类型
			RoadExperimentType ret=new RoadExperimentType();
			ret.setRoadID_s(roadID);
			ret.setExperimentTypeID_s(exptypeID);
			
			ArrayList<RoadExperimentType> deltypelist=new ArrayList<RoadExperimentType>();
			deltypelist.add(ret);
			
			IroadExperimentTypeService irets=new RoadExperimentTypeServiceImpl();
			irets.deleteBasisRoadExperimentTypeInfo(deltypelist);
			
			//查询删除之后的信息
			ret=new RoadExperimentType();
			ret.setRoadID_s(roadID);
			roadexptypeList = irets.getBasisRoadExperimentTypeInfo(ret,ConstantUtil.pagingNot,0);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 删除该条道路记录信息
	 * @author sharonyshi 2014-5-5
	 */
	public String deleteRoadinfo(){
		try {
			//要删除的道路ID
			RoadInfo ri=new RoadInfo();
			ri.setRoadID_s(roadID);
			//封装list
			ArrayList<RoadInfo> rilist=new ArrayList<RoadInfo>();
			rilist.add(ri);
			
			IroadInfoService iris=new RoadInfoServiceImpl();
			boolean istrue=iris.getIsVisible(roadID);
			
			if(istrue){
				msg ="对不起！该条道路信息是道闸入口，不能删除！";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println( msg);  
		        out.flush();  
		        out.close();  
			}else{
				int result = iris.OperationRoadInfoInfo(rilist, 2);
				if(result == 0){
					return ERROR;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return null;
	}



	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRoadID() {
		return roadID;
	}
	public void setRoadID(String roadID) {
		this.roadID = roadID;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	
	public String getTechnicalParameters() {
		return technicalParameters;
	}

	public void setTechnicalParameters(String technicalParameters) {
		this.technicalParameters = technicalParameters;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ArrayList<RoadInfo> getRoadlist() {
		return roadlist;
	}
	public void setRoadlist(ArrayList<RoadInfo> roadlist) {
		this.roadlist = roadlist;
	}
	public RoadInfo getRoadinfo() {
		return roadinfo;
	}
	public void setRoadinfo(RoadInfo roadinfo) {
		this.roadinfo = roadinfo;
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

	public String getExperimentTypeName() {
		return experimentTypeName;
	}

	public void setExperimentTypeName(String experimentTypeName) {
		this.experimentTypeName = experimentTypeName;
	}

	public ArrayList<RoadExperimentType> getRoadexptypeList() {
		return roadexptypeList;
	}

	public void setRoadexptypeList(ArrayList<RoadExperimentType> roadexptypeList) {
		this.roadexptypeList = roadexptypeList;
	}

	public String getExptypeID() {
		return exptypeID;
	}

	public void setExptypeID(String exptypeID) {
		this.exptypeID = exptypeID;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getOverproofUnitPrie_i() {
		return overproofUnitPrie_i;
	}

	public void setOverproofUnitPrie_i(String overproofUnitPrie_i) {
		this.overproofUnitPrie_i = overproofUnitPrie_i;
	}

	public String getUnitPrie_i() {
		return unitPrie_i;
	}

	public void setUnitPrie_i(String unitPrie_i) {
		this.unitPrie_i = unitPrie_i;
	}

	public String getWholeUnitPrie_i() {
		return wholeUnitPrie_i;
	}

	public void setWholeUnitPrie_i(String wholeUnitPrie_i) {
		this.wholeUnitPrie_i = wholeUnitPrie_i;
	}

	public String getWholeOverproofUnitPrie_i() {
		return wholeOverproofUnitPrie_i;
	}

	public void setWholeOverproofUnitPrie_i(String wholeOverproofUnitPrie_i) {
		this.wholeOverproofUnitPrie_i = wholeOverproofUnitPrie_i;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMinuteUnitPrie_i() {
		return minuteUnitPrie_i;
	}

	public void setMinuteUnitPrie_i(String minuteUnitPrie_i) {
		this.minuteUnitPrie_i = minuteUnitPrie_i;
	}

	public String getCoefficient_i() {
		return coefficient_i;
	}

	public void setCoefficient_i(String coefficient_i) {
		this.coefficient_i = coefficient_i;
	}

	public String getActivityUnitPrie_i() {
		return activityUnitPrie_i;
	}

	public void setActivityUnitPrie_i(String activityUnitPrie_i) {
		this.activityUnitPrie_i = activityUnitPrie_i;
	}

	public int getBeginningDay_i() {
		return beginningDay_i;
	}

	public void setBeginningDay_i(int beginningDay_i) {
		this.beginningDay_i = beginningDay_i;
	}
	public Date getInputDate_t() {
		return inputDate_t;
	}

	public void setInputDate_t(Date inputDate_t) {
		this.inputDate_t = inputDate_t;
	}
	public String getResaveds1_s() {
		return resaveds1_s;
	}
	public void setResaveds1_s(String resaveds1_s) {
		this.resaveds1_s = resaveds1_s;
	}
	public String getResaveds1() {
		return resaveds1;
	}
	public void setResaveds1(String resaveds1) {
		this.resaveds1 = resaveds1;
	}
	public String getResaveds2() {
		return resaveds2;
	}
	public void setResaveds2(String resaveds2) {
		this.resaveds2 = resaveds2;
	}
	public String getResaveds2_s() {
		return resaveds2_s;
	}
	public void setResaveds2_s(String resaveds2_s) {
		this.resaveds2_s = resaveds2_s;
	}



	public String getResaveds4() {
		return resaveds4;
	}



	public void setResaveds4(String resaveds4) {
		this.resaveds4 = resaveds4;
	}
	
}
