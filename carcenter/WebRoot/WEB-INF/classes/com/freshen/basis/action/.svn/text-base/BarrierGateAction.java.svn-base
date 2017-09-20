package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.freshen.basis.service.IBarrierGateService;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.BarrierGateServiceImpl;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.BarrierGate;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.RoadInfo;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;

public class BarrierGateAction extends CapgActionSupport{
	 
	//String gateID,gateNumber,newgateNumber,gateType,gateCompany,entranceRoadID,outRoadID,gateStatue;
	String gateID,gateNumber,newgateNumber,gateType,entranceRoadID,outRoadID,gateStatue,resaveds1_s;
	int status;
	List<BarrierGate> barriergateList=new ArrayList<BarrierGate>();//记录道闸信息
	ArrayList<RoadInfo> roadforbarrier=new ArrayList<RoadInfo>();//道路信息
	BarrierGate barriergate=new BarrierGate();//要更新的道闸信息
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人
	int isUpdate;
	String errmsg,flag;
	
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	public final static String closepage = "closepage";
	/**
	 * 默认查询所有道闸信息，当有查询条件时查询该道闸记录
	 * @author sharonyshi 2014-5-12
	 */
	public String execute(){
		try {
			//设置查询条件
			BarrierGate bg=new BarrierGate();
			bg.setGateNumber_s(gateNumber);
			bg.setGateType_s(gateType);
			//bg.setGateCompany_s(gateCompany);
			bg.setEntranceRoadIDs(entranceRoadID);
			bg.setState_i(-1);//设置查询0和1的状态，即查询所有状态
			
			IBarrierGateService ibgs=new BarrierGateServiceImpl();
			//确定记录总数
			totalPages =ibgs.getBasisBasisBarrierGateInfoNumber(bg);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				barriergateList=ibgs.getBasisBarrierGateInfo(bg, currentPage*pageSize, pageSize);
			}
			
			//查询道路信息
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadforbarrier=irs.getRoadInfo(null);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	
	public String searchBarrierinfo(){
		try {
			//设置查询条件
			BarrierGate bg=new BarrierGate();
			if(flag != null){
				if(gateNumber!=null && gateNumber.trim().length()>1)
					gateNumber=(new String(gateNumber.getBytes("ISO-8859-1"),"UTF-8" ));
				if(gateType!=null && gateType.trim().length()>1)
					gateType=(new String(gateType.getBytes("ISO-8859-1"),"UTF-8" ));
			}
			bg.setGateNumber_s(gateNumber);
			bg.setGateType_s(gateType);
			//bg.setGateCompany_s(gateCompany);
			bg.setEntranceRoadIDs(entranceRoadID);
			//bg.setOutRoadID_s(outRoadID);
			bg.setState_i(-1);//设置查询0和1的状态，即查询所有状态
			
			IBarrierGateService ibgs=new BarrierGateServiceImpl();
			//确定记录总数
			totalPages =ibgs.getBasisBasisBarrierGateInfoNumber(bg);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			barriergateList=ibgs.getBasisBarrierGateInfo(bg, currentPage*pageSize, pageSize);
			
			
			//查询道路信息
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadforbarrier=irs.getRoadInfo(null);
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
	 * 判断是否存在道闸编号，若不存在说明是新增道闸，存在则需要查询相应数据
	 * @author sharonyshi 2014-5-12
	 * @return
	 */
	public String prepareBarrierinfo(){
		try {
			//道闸编号存在，说明是更新操作
			if(gateID !=null){
				BarrierGate bg=new BarrierGate();
				bg.setGateID_s(gateID);
				bg.setGateNumber_s(gateNumber);
				bg.setState_i(-1);
				IBarrierGateService ibgs=new BarrierGateServiceImpl();
				barriergateList=ibgs.getBasisBarrierGateInfo(bg, ConstantUtil.pagingNot,0);
				if(barriergateList != null){
					barriergate=barriergateList.get(0);
				}
			}
			
			//查询道路信息
			IroadInfoService irs=new RoadInfoServiceImpl();
			roadforbarrier=irs.getRoadInfo(null);
			
			
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
	 * 同步道闸
	 * @author sharonyshi 2014-5-12
	 * @return
	 */
	public String addBarrierinfo(){
		try {
			IBarrierGateService ibgs=new BarrierGateServiceImpl();
			List<BarrierGate> l = ibgs.getBarrierGateModelList();
			ibgs.saveBarrierGateModel(l);			
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
	 * 修改道闸信息，如果道闸状态没有值，则默认为使用
	 * @author sharonyshi 2014-5-12
	 * @return
	 */
	public String addBarrierinfoold(){
		try {
			////System.out.println("gateStatue-->"+gateStatue);
			IBarrierGateService ibgs=new BarrierGateServiceImpl();
			//设置要添加的道闸信息
			BarrierGate bg=new BarrierGate();
			bg.setGateNumber_s(newgateNumber);
			//bg.setState_i(-1);
			/*ArrayList<BarrierGate> result=ibgs.getBasisBarrierGateInfo(bg, ConstantUtil.pagingNot,0);
			
			if(isUpdate==1){//更新操作
				if(gateNumber ==null || gateNumber.equals("")){
					//说明ID号变了，要先判断一下新的ID是否存在
					if(result.size()>0){
						errmsg="该道闸ID已经存在！请重新输入！";
						prepareBarrierinfo();
						return ERROR;
					}
				}
				if(!gateNumber.equals(newgateNumber)){
					//说明ID号变了，要先判断一下新的ID是否存在
					if(result.size()>0){
						errmsg="该道闸ID已经存在！请重新输入！";
						prepareBarrierinfo();
						return ERROR;
					}
				}
				
				bg.setLastUpdateDate_t(DateUtil.getCurrentDate());
				bg.setLastUpdateUser_s(employ.getCustomerUserName_s());
			}else{
				//新增操作先判断是否存在ID号
				if(result.size()>0){
					errmsg="该道闸ID已经存在！请重新输入！";
					prepareBarrierinfo();
					return ERROR;
				}
				bg.setCreateDate_t(DateUtil.getCurrentDate());
				bg.setCreateUser_s(employ.getCustomerUserName_s());
			}*/
			bg.setGateID_s(gateID);
			bg.setGateType_s(gateType);
			//bg.setGateCompany_s(gateCompany);
			//bg.setOutRoadID_s(outRoadID);
			bg.setEntranceRoadIDs(entranceRoadID);
			bg.setState_i(status);
			bg.setLastUpdateDate_t(DateUtil.getCurrentDate());
			bg.setLastUpdateUser_s(employ.getCustomerUserName_s());
			bg.setResaveds1_s(resaveds1_s);
			ArrayList<BarrierGate> bglist=new ArrayList<BarrierGate>();
			bglist.add(bg);
			
			int r=ibgs.OperationBasisBarrierGateInfo(bglist,1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
				// TODO: handle exception\\
		 
		}
		return SUCCESS;
	}
	
	
	/**
	 * 删除选中的道闸信息
	 * @author sharonyshi 2014-5-13
	 * @return
	 */
	public String deleteBarrierinfo(){
		try {
			//设置要删除的道闸信息，只要有ID就可以操作
			BarrierGate bg=new BarrierGate();
			bg.setGateID_s(gateID);
			//将数据封装到list中
			ArrayList<BarrierGate> bglist=new ArrayList<BarrierGate>();
			bglist.add(bg);
			
			IBarrierGateService ibgs=new BarrierGateServiceImpl();
			ibgs.OperationBasisBarrierGateInfo(bglist, 2);
			
			//重新查询记录
			barriergateList=ibgs.getBasisBarrierGateInfo(null, ConstantUtil.pagingNot,0);
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

	public String getGateID() {
		return gateID;
	}

	public void setGateID(String gateID) {
		this.gateID = gateID;
	}

	public String getGateType() {
		return gateType;
	}

	public void setGateType(String gateType) {
		this.gateType = gateType;
	}

//	public String getGateCompany() {
//		return gateCompany;
//	}
//
//	public void setGateCompany(String gateCompany) {
//		this.gateCompany = gateCompany;
//	}
	public List<BarrierGate> getBarriergateList() {
		return barriergateList;
	}

	public void setBarriergateList(List<BarrierGate> barriergateList) {
		this.barriergateList = barriergateList;
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


	public ArrayList<RoadInfo> getRoadforbarrier() {
		return roadforbarrier;
	}


	public void setRoadforbarrier(ArrayList<RoadInfo> roadforbarrier) {
		this.roadforbarrier = roadforbarrier;
	}


	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BarrierGate getBarriergate() {
		return barriergate;
	}

	public void setBarriergate(BarrierGate barriergate) {
		this.barriergate = barriergate;
	}

	public String getEntranceRoadID() {
		return entranceRoadID;
	}

	public void setEntranceRoadID(String entranceRoadID) {
		this.entranceRoadID = entranceRoadID;
	}

	public String getOutRoadID() {
		return outRoadID;
	}

	public void setOutRoadID(String outRoadID) {
		this.outRoadID = outRoadID;
	}
	
	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getGateNumber() {
		return gateNumber;
	}

	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}

	public String getNewgateNumber() {
		return newgateNumber;
	}

	public void setNewgateNumber(String newgateNumber) {
		this.newgateNumber = newgateNumber;
	}

	public String getGateStatue() {
		return gateStatue;
	}

	public void setGateStatue(String gateStatue) {
		this.gateStatue = gateStatue;
	}

	public String getResaveds1_s() {
		return resaveds1_s;
	}

	public void setResaveds1_s(String resaveds1S) {
		resaveds1_s = resaveds1S;
	}
	
	
}
