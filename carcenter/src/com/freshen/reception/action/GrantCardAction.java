package com.freshen.reception.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.VehicleInfo;

import com.freshen.entity.basis.Employee;
import com.freshen.entity.reception.CardInfo;
import com.freshen.entity.reception.ReceptionVehicleInfo;

import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.reception.service.IcardInfoService;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.CardInfoServiceImpl;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.BasicTools;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;

/**
 *  Class Name: GrantCardAction.java
 *  Function:发放 卡片，当接待员点击 “确认实验” 按钮之后，会前往该action
 *     Modifications:
 *  @author   DateTime 2014-4-14 下午12:09:41
 *  @version 1.0
 */
public class GrantCardAction extends CapgActionSupport{
	String rs=SUCCESS;
	String orderId=ActionContext.getContext().getSession().get("orderId").toString();
	String customerId=ActionContext.getContext().getSession().get("customerId").toString();

	String cardId;//卡号
	//String model2,axleNumber2,color2,vehicleID2,vehicleCPG2,authorizeRoad2;//记录车辆信息,增加临时车辆时使用
	String category,model,weight,maxWeight,axleNumber,fuelDemand,color,licensPlate,brandType,maxSpeed,vin,fuelConsumption;//记录车辆信息,增加临时车辆时使用
	//记录必须发放的车辆信息
	//List<String> model=new ArrayList<String>();				//收集车型
	//List<String> axleNumber=new ArrayList<String>();        //收集车轴数
	//List<String> color=new ArrayList<String>();				//收集颜色
	//List<String> vehicleCardID=new ArrayList<String>();		//收集车卡
	//List<String> vehicleCPG=new ArrayList<String>();		//收集cpg号码
	String authorizeRoads;									//收集授权道路，由于采用了隐藏域，页面把所有车辆的 授权道路 组成一个字符串，
	String orderinvalidate;
	String deleteVehicles;		//收集删除的车辆信息
	String vins,receiveCardUsers,models,axleNumbers,vehicleCardIDs,vehicleCPGs,ywvehicleCPGs,invalidates; //新增VIN,领卡人

	String flag;                //标志位信息
	String endTime;
	String checkRoads; //addFuction
	//List<String> invalidate=new ArrayList<String>();         //收集最后时间
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
	 *  @author Freshen  DateTime 2014-4-16 下午05:09:06
	 *  @return
	 */
	public String prepareRecordVehicle(){
		//System.out.println("orderId==="+orderId);
		try {
			/*IreceptionVehicleInfoService ireceptVehicleService=new ReceptionVehicleInfoServiceImpl();
			ireceptVehicleService.deleteReceptionVehicleInfo(null);*/
			//获取该订单的车辆信息。每个车都需要发卡
			//现在只读  接待模块中的 车辆信息表，所以下面代码注释掉
//			VehicleInfo vehicleinfo=new VehicleInfo();
//			vehicleinfo.setOrderID_s(orderId);
//
//			IvehicleInfoService ivs=new VehicleInfoServiceImpl();
//			vehicleList=ivs.getVehicleInfo(vehicleinfo, ConstantUtil.pagingNot,0);
//
			//查询该订单的结束时间用于默认人卡的有效时间
			OrderDetail od=new OrderDetail();
			od.setOrderID_s(orderId);
			IorderInfoService ios=new OrderInfoServiceImpl();
			List<OrderDetail> odlist=ios.getOrder(od);
			if(odlist!=null&&odlist.size()>0)
			endTime = odlist.get(0).getEndDateStr();

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
			recVehicleInfo=irecVehicleService.getReceptionVehicleInfo(vehicle,ConstantUtil.pagingNot,0);
			//如果车辆记录中没有截止日期，则默认订单的结束日期
			for (int i = 0; i < recVehicleInfo.size(); i++) {
				if(recVehicleInfo.get(i).getResaveds1_s() == null || recVehicleInfo.get(i).getResaveds1_s().length() < 1){
					if(odlist!=null){
						recVehicleInfo.get(i).setResaveds1_s(odlist.get(0).getEndDateStr());
					}
				}else{
					Date dtmp = DateUtil.stringToDate(recVehicleInfo.get(i).getResaveds1_s());
					dtmp.setDate(dtmp.getDate()-1);
					recVehicleInfo.get(i).setResaveds1_s(DateUtil.dateToString(dtmp,"yyyy-MM-dd"));
					String tempCPG = recVehicleInfo.get(i).getVehicleCPG_s().replace("\r\n", "");
					recVehicleInfo.get(i).setVehicleCPG_s(tempCPG);
					//recVehicleInfo.get(i).setResaveds1_s(odlist.get(0).getEndDateStr());
				}
			}
			
		 System.out.println("查询接待模块中车辆信息；获取数条数"+recVehicleInfo.size());
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception

		}

		return rs;
	}
	/**
	 *  Function:录入车辆信息，发车卡
	 *  @author sharonyshi  DateTime 2014-4-23
	 *  @return
	 */
	public synchronized  String recordVehicleInfo(){
 		try {
			ArrayList<ReceptionVehicleInfo> receptionvehiclelist=new ArrayList<ReceptionVehicleInfo>();
			ArrayList<ReceptionVehicleInfo> delreceptionvehiclelist=new ArrayList<ReceptionVehicleInfo>();
			ArrayList<CardInfo> vehiclecardlist=new ArrayList<CardInfo>();
			ArrayList<CardInfo> delvehiclecardlist=new ArrayList<CardInfo>();
			IreceptionVehicleInfoService ivis = new ReceptionVehicleInfoServiceImpl();
 			ReceptionVehicleInfo rvi  = new ReceptionVehicleInfo();
			List<ReceptionVehicleInfo> listRvi = new ArrayList<ReceptionVehicleInfo>();
			//将组装在一个串中 授权道路 拆成数组
			//System.out.println("待拆分的 字符串 "+ authorizeRoads);
			String authRoadArr []=authorizeRoads.split(",");
			//将组装在一个串中 车辆型号 拆成数组
			String model[] = models.split(",");
			
			//新增将组装在一个串中 VIN号 拆成数组
			String vin[] = vins.split(",");
			//新增将组装在一个串中 领卡人 拆成数组
			String receivecardusers[] = receiveCardUsers.split(",");
					
			//将组装在一个串中 车轴数 拆成数组
			String axleNumber[] = axleNumbers.split(",");
			//将组装在一个串中 cpg拆成数组
			String cpg[] = vehicleCPGs.split(",");
			//将组装在一个串中 车卡拆成数组
			String carid[] =  vehicleCardIDs.split(",");
			//业务cpg
			String ywvehicleCPG[] =  ywvehicleCPGs.split(",");
			//将组装在一个串中 失效日期拆成数组
			String invalidateses[] =  invalidates.split(",");

			String checkroad[] = checkRoads.split(",");

			String f[]=flag.split(",");
			List cancelList = new ArrayList();
			/*String cardtmp = icardService.isCardApply(vehicleCardID);
			if(cardtmp!=null){
				this.setErrmsg(cardtmp+"该卡正在使用不能继续发放");
				return ERROR;
			}*/

			IcardInfoService icardService=new CardInfoServiceImpl();
			if(carid != null && !carid[0].equals("")){
				for(int i=0;i<carid.length;i++){
					String tmp = carid[i];
					for(int j=i+1;j<carid.length;j++){
						if(tmp.equals(carid[j])){
							this.setErrmsg(tmp+"该卡只能发放一次!");
							carid[j]="";
							model[j]="";
 							/*carid[i]="";
							model[i]="";*/
 							//	20150514 Kangxiaochen Add
							carid[i]="";
							model[i]="";
 							//return ERROR;
						}
					}
					Date dtmp = DateUtil.stringToDate(invalidateses[i]);
					if(dtmp==null){
						dtmp = new Date();
					}
					boolean b = dtmp.before(new Date());
			    	if(!b){//当有效期大于当前日期比较是否有其它订单中有效的卡
						String cardtmp = icardService.isCardApply(tmp,orderId);
						if(cardtmp!=null){
							this.setErrmsg(tmp+"该卡正在订单"+cardtmp+"使用，不能继续发放!");
							carid[i]="";
							model[i]="";
							//return ERROR;
						}
			    	}else{//当其它订单中有效期大于当前日期，此卡不在当前订单发权限。 201506009 kxc
			    		String cardtmp = icardService.isCardApply(tmp,orderId);
						if(cardtmp!=null){
							cancelList.add(tmp);//不作废权限
							//carid[i]="";
							//model[i]="";
						}
			    	}
				}
			}

			/*List<String> tmplist = vehicleCardID;

			for(int i=0;i<vehicleCardID.size();i++){
				String tmp = vehicleCardID.get(i);
				for(int j=i+1;j<vehicleCardID.size();j++){
					if(tmp.equals(vehicleCardID.get(j))){
						this.setErrmsg(tmp+"该卡只能发放一次");
						return ERROR;
					}
				}
				String cardtmp = icardService.isCardApply(tmp,orderId);
				if(cardtmp!=null){
					this.setErrmsg(tmp+"该卡正在使用不能继续发放");
					return ERROR;
				}
			}*/

			//分解要删除的车辆信息
			if(deleteVehicles != null && deleteVehicles.length() > 0){
				String temp[] = deleteVehicles.split("I");
				for (int j = 0; j < temp.length; j++) {
					String del[]=temp[j].split(",");

					//String info[] = del[j].split(",");
					//为删除reception-vehicleInfo表
					ReceptionVehicleInfo deleteVehicle=new ReceptionVehicleInfo();
					deleteVehicle.setOrderID_s(orderId);
					deleteVehicle.setVehicleCPG_s(del[0]);
					//存入list列表中
					delreceptionvehiclelist.add(deleteVehicle);
					//为删除reception-cardinfo表
					if(del.length > 1 ){
						CardInfo deleteCard=new CardInfo();
						ReceptionVehicleInfo rVehicleInfo = new ReceptionVehicleInfo();
						rVehicleInfo.setVehicleCPG_s(del[0]);
						ArrayList<ReceptionVehicleInfo> l = ivis.getReceptionVehicleInfo(rVehicleInfo, ConstantUtil.pagingNot, 0);
						if(BasicTools.isnotNull(l)){
							deleteCard.setOrderID_s(orderId);
							deleteCard.setCard_s(l.get(0).getVehicleID_s());
							delvehiclecardlist.add(deleteCard);
						}
					}
				}
			}
			if(model != null ){
 				for (int i = 0; i < model.length; i++) {
					if(carid[i]==null||model[i]==null||carid[i].trim().equals("")||model[i].trim().equals("")){
						continue;
					}
					//为记录reception-vehicleinfo表中,查询车辆信息表
					ReceptionVehicleInfo recepvehicle=new ReceptionVehicleInfo();
					recepvehicle.setOrderID_s(orderId);
					//recepvehicle.setVehicleID_s(carid[i]);
					recepvehicle.setVehicleCPG_s(ywvehicleCPG[i]);
					listRvi = ivis.getReceptionVehicleInfo(recepvehicle, -1, 0);
					if(listRvi!= null&& listRvi.size()>0)
					{
						rvi = listRvi.get(0);
						if(rvi != null)
						{
							recepvehicle.setVehicleID_s(carid[i]);
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
							//recepvehicle.setVehicleID_s(rvi.getVehicleID_s());
							recepvehicle.setVin_s(rvi.getVin_s());
							recepvehicle.setWeight_s(rvi.getWeight_s());
							//recepvehicle.setVehicleCPG_s(rvi.getVehicleCPG_s());

						}
					}

					recepvehicle.setResaveds5_s(checkroad[i]);
					//recepvehicle.setModel_s(model[i]);
					recepvehicle.setBrandType_s(model[i]);
					//recepvehicle.setColor_s(color.get(i));  //车辆颜色不再收集
					recepvehicle.setAxleNumber_i(Integer.valueOf(axleNumber[i]));
					recepvehicle.setResaveds2_s(cpg[i]);
					//处理每条道路，只提取道路ID号
					String ar=authRoadArr[i];
					String arIdNames[]=ar.split("-");
					String ids="";
					for (int j = 0; j < arIdNames.length; j++) {
						ids+=arIdNames[j].substring(0, arIdNames[j].indexOf("_"))+"vv";
					}
					System.out.println("授权道路的 ID串是 "+ids.substring(0,ids.length()-2));
					recepvehicle.setRoidIds_s(ids.substring(0,ids.length()-2));
					Date dtmp = DateUtil.stringToDate(invalidateses[i]);
					dtmp.setDate(dtmp.getDate()+1);
					recepvehicle.setResaveds1_s(DateUtil.dateToString(dtmp,"yyyy-MM-dd"));
					recepvehicle.setCreateDate_t(DateUtil.getCurrentDate());
					recepvehicle.setCreateUser_s(employ.getCustomerUserName_s());
					//新增测试插入字段vins,领卡人字段
					if(vin.length>i)
					{
						recepvehicle.setVin_s(vin[i]);
					}
					//使用Resaveds4_s字段作为领卡人存储
					if(receivecardusers.length>i)
					{
						recepvehicle.setResaveds4_s(receivecardusers[i]);
					}
					
					receptionvehiclelist.add(recepvehicle);


					//记录卡信息表reception-cardinfo
					CardInfo vehiclecardinfo=new CardInfo();
					vehiclecardinfo.setOrderID_s(orderId);
					vehiclecardinfo.setCard_s(carid[i]);
					vehiclecardinfo.setCardType_s(ConstantUtil.cardType_2);
					vehiclecardinfo.setCreateUser_s(employ.getCustomerUserName_s());
					vehiclecardinfo.setCreateDate_t(DateUtil.getCurrentDate());
					vehiclecardlist.add(vehiclecardinfo);
				}
			}

			//录入reception-vehicleinfo操作
			IreceptionVehicleInfoService ireceptVehicleService=new ReceptionVehicleInfoServiceImpl();
			
			System.out.println("----------receptionvehiclelist01:"+receptionvehiclelist);
			int result1=ireceptVehicleService.provideJurisdiction(receptionvehiclelist,orderId,cancelList);
			System.out.println("----------receptionvehiclelist01END:"+result1);
			
			if(result1==0){//订单被锁
				this.setErrmsg("该订单正在发卡请稍后再试");
				return ERROR;
			}
			System.out.println("ReceptionVehicleInfoService result==="+result1);
			//录入reception-cardinfo操作
			CardInfo cardInfo = new CardInfo();
			cardInfo.setOrderID_s(orderId);
			cardInfo.setCreateDate_t(null);
			cardInfo.setLastUpdateDate_t(null);
			
			ArrayList<CardInfo>  list = icardService.getReceptionCardInfo(cardInfo, ConstantUtil.pagingNot, 0);
			icardService.deleteReceptionCardInfoAlone(list);
			int result2=icardService.saveOrUpdateReceptionCardInfo(vehiclecardlist);
			System.out.println("ReceptionCardInfoService result==="+result2);
//ALL RIGHT 
			//删除车卡
			if(delvehiclecardlist != null && delvehiclecardlist.size() > 0){
				IcardInfoService cardService=new CardInfoServiceImpl();
				int result3=cardService.deleteReceptionCardInfoAlone(delvehiclecardlist);
			}
			//删除车辆信息
			if( delreceptionvehiclelist!= null &&  delreceptionvehiclelist.size() > 0){
				int result4=ivis.deleteReceptionVehicleInfo(delreceptionvehiclelist);
			}
			//IreceptionVehicleInfoService ireceptVehicleService=new ReceptionVehicleInfoServiceImpl();
			//ireceptVehicleService.deleteReceptionVehicleInfo(null);

		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg("发卡错误请联系IT人员处理");
		//	ExceptionDispose.saveEStringInfo("道路串===="+authorizeRoads);
			ExceptionDispose.saveExceptionInfo(e);


			return ERROR;


			// TODO: handle exception
		}finally{

		}
		if(this.getErrmsg()!=null&&!this.getErrmsg().trim().equals("")){
			return ERROR;
		}
		return rs;
	}


	/**
	 *  Function:额外录入车辆信息，发车卡
	 *  @author sharonyshi  DateTime 2014-4-23
	 *  @return
	 */
	public String exrecordVehicleInfo(){
		try {
			//为记录reception-vehicleinfo表中
			ReceptionVehicleInfo recepvehicle=new ReceptionVehicleInfo();
			recepvehicle.setOrderID_s(orderId);
			recepvehicle.setCategory_i(Integer.parseInt(category));
			recepvehicle.setModel_s(model);
			recepvehicle.setWeight_s(weight);
			recepvehicle.setMaxWeight_s(maxWeight);
			recepvehicle.setAxleNumber_i(Integer.parseInt(axleNumber));
			recepvehicle.setFuelDemand_s(fuelDemand);
			recepvehicle.setColor_s(color);
			recepvehicle.setLicensPlate_s(licensPlate);
			recepvehicle.setBrandType_s(brandType);
			recepvehicle.setMaxSpeed_s(maxSpeed);
			recepvehicle.setVin_s(vin);
			recepvehicle.setFuelConsumption_s(fuelConsumption);
			recepvehicle.setCreateDate_t(DateUtil.getCurrentDate());
			recepvehicle.setCreateUser_s(employ.getCustomerUserName_s());
			recepvehicle.setResaveds5_s("on");
			ArrayList<ReceptionVehicleInfo> receptionvehiclelist=new ArrayList<ReceptionVehicleInfo>();
			receptionvehiclelist.add(recepvehicle);

			//录入reception-vehicleinfo操作
			IreceptionVehicleInfoService ireceptVehicleService= new ReceptionVehicleInfoServiceImpl();
					
			String msg=ireceptVehicleService.saveOrUpdateReceptionVehicleInfo(receptionvehiclelist);
			
			//System.out.println("ReceptionVehicleInfoService result==="+result1);

			/*if(result1 == 1){
				msg ="SUCCESS";
			}*/

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
	        out.println(msg);
	        out.flush();
	        out.close();

		}catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;

			// TODO: handle exception
		}
		return null;
	}
	/*public String exrecordVehicleInfo(){
		try {

				//为记录reception-vehicleinfo表中
				ReceptionVehicleInfo recepvehicle=new ReceptionVehicleInfo();
				recepvehicle.setOrderID_s(orderId);
				recepvehicle.setVehicleID_s(vehicleID2);
				recepvehicle.setAxleNumber_i(Integer.valueOf(axleNumber2));
				recepvehicle.setModel_s(model2);
				recepvehicle.setColor_s(color2);
				//设置授权道路，页面传来是道路名称需要处理
				if(authorizeRoad2!=null&&authorizeRoad2.length()>1){
					String arIdNames[]=authorizeRoad2.split("-");	//先拆分成 单条道路
					String arids="";
					for (int i = 0; i < arIdNames.length; i++) {
						arids+=arIdNames[i].substring(0,arIdNames[i].indexOf("_"))+"vv";
					}
					recepvehicle.setRoidIds_s(arids.substring(0,arids.length()-2));
					System.out.println("额外增加车辆  授权的道路id是 "+arids.substring(0,arids.length()-2));
				}
				recepvehicle.setCreateDate_t(DateUtil.getCurrentDate());
				recepvehicle.setCreateUser_s(employ.getCustomerUserName_s());
				ArrayList<ReceptionVehicleInfo> receptionvehiclelist=new ArrayList<ReceptionVehicleInfo>();
				receptionvehiclelist.add(recepvehicle);


				//记录卡信息表reception-cardinfo
				CardInfo vehiclecardinfo=new CardInfo();
				vehiclecardinfo.setOrderID_s(orderId);
				vehiclecardinfo.setCard_s(vehicleID2);
				vehiclecardinfo.setCardType_s(ConstantUtil.cardType_2);
				vehiclecardinfo.setCreateUser_s(employ.getCustomerUserName_s());
				vehiclecardinfo.setCreateDate_t(DateUtil.getCurrentDate());
				ArrayList<CardInfo> vehiclecardlist=new ArrayList<CardInfo>();
				vehiclecardlist.add(vehiclecardinfo);



			//录入reception-vehicleinfo操作
			IreceptionVehicleInfoService ireceptVehicleService=new ReceptionVehicleInfoServiceImpl();
			int result1=ireceptVehicleService.saveOrUpdateReceptionVehicleInfo(receptionvehiclelist);
			System.out.println("ReceptionVehicleInfoService result==="+result1);
			//录入reception-cardinfo操作
			IcardInfoService icardService=new CardInfoServiceImpl();
			icardService.deleteReceptionCardInfoByOrderId(orderId,ConstantUtil.cardType_2);
			int result2=icardService.saveOrUpdateReceptionCardInfo(vehiclecardlist);
			System.out.println("ReceptionCardInfoService result==="+result2);

		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;

			// TODO: handle exception
		}
		return rs;
	}*/

	/**
	 * Function 删除车辆信息，同时删除卡信息表中相关信息
	 * 注释，改为与发放一起操作
	 * @author sharonyshi 2014-11-17
	 * @return
	 */
	public String deleteVehicleInfo(){
		/*Session session = HibernateUtil.getSession();
		Transaction tx = null;
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

			if(!session.isOpen()){
				session = HibernateUtil.getSession();
			}
			tx = session.beginTransaction();//开启事务
			//删除车卡
			IcardInfoService cardService=new CardInfoServiceImpl();
			int result1=cardService.deleteReceptionCardInfo(deleteCardInfo,session);

			//删除车辆信息
			IreceptionVehicleInfoService ivehicleService=new ReceptionVehicleInfoServiceImpl();
			int result2=ivehicleService.deleteReceptionVehicleInfo(deleteVehicleList,session);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());
			ExceptionDispose.saveExceptionInfo(e);

			if(tx!=null){
				tx.rollback();
			}
			return ERROR;


			// TODO: handle exception
		}finally{
			 session.clear();
		}
		*/
		return rs;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getAuthorizeRoads() {
		return authorizeRoads;
	}
	public void setAuthorizeRoads(String authorizeRoads) {
		this.authorizeRoads = authorizeRoads;
	}
	public String getOrderinvalidate() {
		return orderinvalidate;
	}
	public void setOrderinvalidate(String orderinvalidate) {
		this.orderinvalidate = orderinvalidate;
	}
	public String getDeleteVehicles() {
		return deleteVehicles;
	}
	public void setDeleteVehicles(String deleteVehicles) {
		this.deleteVehicles = deleteVehicles;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getModels() {
		return models;
	}
	public void setModels(String models) {
		this.models = models;
	}
	public String getAxleNumbers() {
		return axleNumbers;
	}
	public void setAxleNumbers(String axleNumbers) {
		this.axleNumbers = axleNumbers;
	}
	public String getVehicleCardIDs() {
		return vehicleCardIDs;
	}
	public void setVehicleCardIDs(String vehicleCardIDs) {
		this.vehicleCardIDs = vehicleCardIDs;
	}
	public String getVehicleCPGs() {
		return vehicleCPGs;
	}
	public void setVehicleCPGs(String vehicleCPGs) {
		this.vehicleCPGs = vehicleCPGs;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}
	public String getAxleNumber() {
		return axleNumber;
	}
	public void setAxleNumber(String axleNumber) {
		this.axleNumber = axleNumber;
	}
	public String getFuelDemand() {
		return fuelDemand;
	}
	public void setFuelDemand(String fuelDemand) {
		this.fuelDemand = fuelDemand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getLicensPlate() {
		return licensPlate;
	}
	public void setLicensPlate(String licensPlate) {
		this.licensPlate = licensPlate;
	}
	public String getBrandType() {
		return brandType;
	}
	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}
	public String getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getInvalidates() {
		return invalidates;
	}
	public void setInvalidates(String invalidates) {
		this.invalidates = invalidates;
	}
	public String getYwvehicleCPGs() {
		return ywvehicleCPGs;
	}
	public void setYwvehicleCPGs(String ywvehicleCPGs) {
		this.ywvehicleCPGs = ywvehicleCPGs;
	}
	public String getCheckRoads() {
		return checkRoads;
	}
	public void setCheckRoads(String checkRoads) {
		this.checkRoads = checkRoads;
	}
	public void setVins(String vins) {
		this.vins = vins;
	}
	public String getVins() {
		return vins;
	}
	public void setReceiveCardUsers(String receiveCardUsers) {
		this.receiveCardUsers = receiveCardUsers;
	}
	public String getReceiveCardUsers() {
		return receiveCardUsers;
	}





}
