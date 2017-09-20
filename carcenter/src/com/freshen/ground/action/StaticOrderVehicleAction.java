package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.entity.VehicleInfo;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.reception.CardInfo;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;

public class StaticOrderVehicleAction extends CapgActionSupport {
	String orderId=ConstantUtil.ORDERIDFinal;
	
	String cardId;//卡号
	String model2,axleNumber2,color2,vehicleID2,vehicleCPG2,authorizeRoad2;//记录车辆信息,增加临时车辆时使用
	//记录必须发放的车辆信息
	List<String> model=new ArrayList<String>();				//收集车型
	List<String> axleNumber=new ArrayList<String>();        //收集车轴数
	List<String> color=new ArrayList<String>();				//收集颜色
	List<String> vehicleCardID=new ArrayList<String>();		//收集车卡
	//List<String> vehicleCPG=new ArrayList<String>();		//收集cpg号码
	String authorizeRoads;									//收集授权道路，由于采用了隐藏域，页面把所有车辆的 授权道路 组成一个字符串，
	List<String> invalidate=new ArrayList<String>();         //收集最后时间
	List<String> vehicleCPG=new ArrayList<String>();		//主键
	int pagetype;//获取传来页信息

	List<ReceptionVehicleInfo> recVehicleInfo=new ArrayList<ReceptionVehicleInfo>();//记录登记的车辆信息



	List<VehicleInfo> vehicleList=new ArrayList<VehicleInfo>();//记录需要发卡的车信息
	
//	int personNum,oilNum;//记录人卡，油卡的数目
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	
	//获取登录人信息，记为创建人
	Employee employ=(Employee) ActionContext.getContext().getSession().get("loginEmployee");//获取登录人信息，记为创建人

	
	
	
	/**
	 *  Function:准备车辆信息，发车卡
	 *  @author sharonyshi  DateTime 2014-10-27 下午05:09:06
	 *  @return
	 */
	public String prepareRecordVehicle(){
		//System.out.println("orderId==="+orderId);
		try {
			//获取该订单的车辆信息。每个车都需要发卡
			//现在只读  接待模块中的 车辆信息表，所以下面代码注释掉
//			VehicleInfo vehicleinfo=new VehicleInfo();
//			vehicleinfo.setOrderID_s(orderId);
//			
//			IvehicleInfoService ivs=new VehicleInfoServiceImpl();
//			vehicleList=ivs.getVehicleInfo(vehicleinfo, ConstantUtil.pagingNot,0);
//			
			//设置要查询的orderid
			ReceptionVehicleInfo vehicle=new ReceptionVehicleInfo();
			vehicle.setOrderID_s(orderId);
			IreceptionVehicleInfoService irecVehicleService=new ReceptionVehicleInfoServiceImpl();
			//不 支持 分页了
//			//确定记录总数
//			totalPages =irecVehicleService.getReceptionVehicleInfoNumber(vehicle);
//			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
//			//合适当前页的有效性
//			if(currentPage<=0){
//				currentPage=0;
//			}else if(currentPage>=maxPage){
//				currentPage=maxPage;
//			}
			recVehicleInfo=irecVehicleService.getReceptionVehicleInfo(vehicle,ConstantUtil.pagingNot,0,null);
		/*	for (int i = 0; i < recVehicleInfo.size(); i++) {
				//System.out.println(recVehicleInfo.get(i).toString());
			}*/
			//System.out.println("查询接待模块中车辆信息；获取数条数"+recVehicleInfo.size());
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
	 *  Function:录入车辆信息，发车卡
	 *  @author sharonyshi  DateTime 2014-10-27
	 *  @return
	 */
	public String recordOVehicleInfo(){
		try {
			ArrayList<ReceptionVehicleInfo> receptionvehiclelist=new ArrayList<ReceptionVehicleInfo>();
			ArrayList<CardInfo> vehiclecardlist=new ArrayList<CardInfo>();
			IreceptionVehicleInfoService ivis = new ReceptionVehicleInfoServiceImpl();
			ReceptionVehicleInfo rvi  = new ReceptionVehicleInfo();
			List<ReceptionVehicleInfo> listRvi = new ArrayList<ReceptionVehicleInfo>();
			List cancelList = new ArrayList();
			//将组装在一个串中 授权道路 拆成数组
			//System.out.println("待拆分的 字符串 "+ authorizeRoads);
			String authRoadArr []=authorizeRoads.split(",");
			IcardInfoService icardService=new CardInfoServiceImpl();
			List<String> tmplist = vehicleCardID;
			for(int i=0;i<vehicleCardID.size();i++){
				String tmp = vehicleCardID.get(i);
				for(int j=i+1;j<vehicleCardID.size();j++){
					if(tmp.equals(vehicleCardID.get(j))){
						this.setErrmsg(tmp+"该卡只能发放一次");
						return ERROR;
					}
				}
				
				Date dtmp = DateUtil.stringToDate(invalidate.get(i));
				boolean b = dtmp.before(new Date());			    	 
		    	if(!b){//当有效期大于当前日期比较是否有其它订单中有效的卡
					String cardtmp = icardService.isCardApply(tmp,orderId);
					if(cardtmp!=null){
						this.setErrmsg(tmp+"该卡正在使用不能继续发放");
						return ERROR;
					}
			    }else{//当其它订单中有效期大于当前日期，此卡不在当前订单发权限。 201506009 kxc
		    		String cardtmp = icardService.isCardApply(tmp,orderId);
					if(cardtmp!=null){
						cancelList.add(tmp);//不作废权限										
					}
		    	}	
			}
			
			for (int i = 0; i < model.size(); i++) {
				//为记录reception-vehicleinfo表中
				ReceptionVehicleInfo recepvehicle=new ReceptionVehicleInfo();
				//当该车卡在其它订单中有效期大于当前订单有效期，则不发放该车卡 20150609 kxc
				if(cancelList.lastIndexOf(vehicleCardID.get(i))!=-1){
					continue;
				}
				recepvehicle.setOrderID_s(orderId);
				recepvehicle.setVehicleID_s(vehicleCardID.get(i));
				listRvi = ivis.getReceptionVehicleInfo(recepvehicle, -1, 0);
				if(listRvi!= null&& listRvi.size()>0)
				{
					rvi = listRvi.get(0);
					if(rvi != null)
					{
						recepvehicle.setModel_s(rvi.getModel_s());
						recepvehicle.setCategory_i(rvi.getCategory_i());
						recepvehicle.setColor_s(rvi.getColor_s());
						recepvehicle.setCreateDate_t(rvi.getCreateDate_t());
						recepvehicle.setCreateUser_s(rvi.getCreateUser_s());
						recepvehicle.setFieldID_s(rvi.getFieldID_s());
						recepvehicle.setFuelConsumption_s(rvi.getFuelConsumption_s());
						recepvehicle.setFuelDemand_s(rvi.getFuelDemand_s());
						recepvehicle.setInterPhoneID_s(rvi.getInterPhoneID_s());
						recepvehicle.setLastUpdateDate_t(rvi.getLastUpdateDate_t());
						recepvehicle.setLastUpdateUser_s(rvi.getLastUpdateUser_s());
						recepvehicle.setLicensPlate_s(rvi.getLicensPlate_s());
						recepvehicle.setMaxSpeed_s(rvi.getMaxSpeed_s());
						recepvehicle.setMaxWeight_s(rvi.getMaxWeight_s());
						recepvehicle.setRoadNames_s(rvi.getRoadNames_s());
						recepvehicle.setVehicleID_s(rvi.getVehicleID_s());
						recepvehicle.setVin_s(rvi.getVin_s());
						recepvehicle.setWeight_s(rvi.getWeight_s());
						
					}
				}
				
				
				recepvehicle.setModel_s(model.get(i));
				//新增
				if(vehicleCPG!=null&&vehicleCPG.size()>i){
					recepvehicle.setVehicleCPG_s(vehicleCPG.get(i));
				}
				//recepvehicle.setColor_s(color.get(i));  //车辆颜色不再收集
				recepvehicle.setAxleNumber_i(Integer.valueOf(axleNumber.get(i)));
				//recepvehicle.setVehicleCPG_s(vehicleCPG.get(i));
				recepvehicle.setResaveds1_s(invalidate.get(i));
				//处理每条道路，只提取道路ID号
				String ar=authRoadArr[i];
				String arIdNames[]=ar.split("-");
				String ids="";
				for (int j = 0; j < arIdNames.length; j++) {
					ids+=arIdNames[j].substring(0, arIdNames[j].indexOf("_"))+"vv";
				}
				//System.out.println("授权道路的 ID串是 "+ids.substring(0,ids.length()-2));
				recepvehicle.setRoidIds_s(ids.substring(0,ids.length()-2));
				recepvehicle.setCreateDate_t(DateUtil.getCurrentDate());
				recepvehicle.setCreateUser_s(employ.getCustomerUserName_s());
				
				
				
				receptionvehiclelist.add(recepvehicle);
				
				
				//记录卡信息表reception-cardinfo
				CardInfo vehiclecardinfo=new CardInfo();
				vehiclecardinfo.setOrderID_s(orderId);
				vehiclecardinfo.setCard_s(vehicleCardID.get(i));
				vehiclecardinfo.setCardType_s(ConstantUtil.cardType_2);
				vehiclecardinfo.setCreateUser_s(employ.getCustomerUserName_s());
				vehiclecardinfo.setCreateDate_t(DateUtil.getCurrentDate());
				vehiclecardlist.add(vehiclecardinfo);
			}
			
			//录入reception-vehicleinfo操作
			IreceptionVehicleInfoService ireceptVehicleService=new ReceptionVehicleInfoServiceImpl();
			//fuck this code author
			//int result1=ireceptVehicleService.provideJurisdiction(receptionvehiclelist,orderId,cancelList);
			//更新发放公卡接口为:provideJurisdictionGKService
			int result1=ireceptVehicleService.provideJurisdictionGKService(receptionvehiclelist,orderId,cancelList);
			if(result1==0){//订单被锁
				this.setErrmsg("该订单正在发卡请稍后再试");					 			 
				return ERROR;
			}
			//System.out.println("ReceptionVehicleInfoService result==="+result1);
			//录入reception-cardinfo操作
			
			int result2=icardService.saveOrUpdateReceptionCardInfo(vehiclecardlist);
			//System.out.println("ReceptionCardInfoService result==="+result2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg("发卡失败，请联系it人员处理\n\t"+e.getLocalizedMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception			  
		}
		return SUCCESS;
	}
	
	
	
	/**
	 * Function 删除车辆信息，同时删除卡信息表中相关信息
	 * @author sharonyshi 2014-4-25
	 * @return
	 */
	public String deleteOVehicleInfo(){
		 
		try {
			//为删除reception-vehicleInfo表
			ReceptionVehicleInfo deleteVehicle=new ReceptionVehicleInfo();
			deleteVehicle.setOrderID_s(orderId);
			deleteVehicle.setVehicleCPG_s(vehicleCPG2);
			//存入list列表中
			ArrayList<ReceptionVehicleInfo> deleteVehicleList=new ArrayList<ReceptionVehicleInfo>();
			deleteVehicleList.add(deleteVehicle);
			
			//为删除reception-cardinfo表
			CardInfo deleteCard=new CardInfo();
			deleteCard.setOrderID_s(orderId);
			deleteCard.setCard_s(vehicleID2);
			ArrayList<CardInfo> deleteCardInfo=new ArrayList<CardInfo>();
			deleteCardInfo.add(deleteCard);
			 
			//删除车卡
			IcardInfoService cardService=new CardInfoServiceImpl();
			int result1=cardService.deleteReceptionCardInfoAlone(deleteCardInfo);
			
			//删除车辆信息
			IreceptionVehicleInfoService ivehicleService=new ReceptionVehicleInfoServiceImpl();
			int result2=ivehicleService.deleteReceptionVehicleInfo(deleteVehicleList);
			 
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
 
			return ERROR;
			 
			 
			// TODO: handle exception
		} 
		
		return SUCCESS;
	}
	

	

	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	
	
	public int getPagetype() {
		return pagetype;
	}
	public void setPagetype(int pagetype) {
		this.pagetype = pagetype;
	}
	
	public List<ReceptionVehicleInfo> getRecVehicleInfo() {
		return recVehicleInfo;
	}
	public void setRecVehicleInfo(List<ReceptionVehicleInfo> recVehicleInfo) {
		this.recVehicleInfo = recVehicleInfo;
	}
	

	public List<VehicleInfo> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<VehicleInfo> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public String getModel2() {
		return model2;
	}
	public void setModel2(String model2) {
		this.model2 = model2;
	}
	public String getColor2() {
		return color2;
	}
	public void setColor2(String color2) {
		this.color2 = color2;
	}
	public String getVehicleID2() {
		return vehicleID2;
	}
	public void setVehicleID2(String vehicleID2) {
		this.vehicleID2 = vehicleID2;
	}
	public String getVehicleCPG2() {
		return vehicleCPG2;
	}
	public void setVehicleCPG2(String vehicleCPG2) {
		this.vehicleCPG2 = vehicleCPG2;
	}
	public List<String> getModel() {
		return model;
	}
	public void setModel(List<String> model) {
		this.model = model;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public List<String> getVehicleCardID() {
		return vehicleCardID;
	}
	public void setVehicleCardID(List<String> vehicleID) {
		this.vehicleCardID = vehicleID;
	}
	
	public String getAuthorizeRoads() {
		return authorizeRoads;
	}
	public void setAuthorizeRoads(String authorizeRoads) {
		this.authorizeRoads = authorizeRoads;
	}
	public String getAuthorizeRoad2() {
		return authorizeRoad2;
	}
	public void setAuthorizeRoad2(String authorizeRoad2) {
		this.authorizeRoad2 = authorizeRoad2;
	}
	public String getAxleNumber2() {
		return axleNumber2;
	}
	public void setAxleNumber2(String axleNumber2) {
		this.axleNumber2 = axleNumber2;
	}
	public List<String> getAxleNumber() {
		return axleNumber;
	}
	public void setAxleNumber(List<String> axleNumber) {
		this.axleNumber = axleNumber;
	}
	public List<String> getInvalidate() {
		return invalidate;
	}
	public void setInvalidate(List<String> invalidate) {
		this.invalidate = invalidate;
	}
	public List<String> getVehicleCPG() {
		return vehicleCPG;
	}
	public void setVehicleCPG(List<String> vehicleCPG) {
		this.vehicleCPG = vehicleCPG;
	}
	 
	

	
}
