package com.freshen.ground.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.Employee;
import com.freshen.entity.basis.OrderPreRoad;
import com.freshen.entity.basis.OrderWholeRoad;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.preorder.service.ITimequantumService;
import com.freshen.preorder.service.IorderPreRoadService;
import com.freshen.preorder.service.IorderWholeRoadService;
import com.freshen.preorder.service.impl.OrderPreRoadServiceImpl;
import com.freshen.preorder.service.impl.OrderWholeRoadServiceImpl;
import com.freshen.preorder.service.impl.TimequantumServiceImpl;

import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.util.StringTools;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;

public class OrderRoadPreAction extends CapgActionSupport {
	private String roadName_s,roadID_s,startDate_t,endDate_t;
	private String timeQuantum; //包场的时间段  ,待定  freshen 
	private int carNumber;	//包场的 车辆数
	private String errmsg;
	private int itemIndex=-1;	//元素在集合中的编号，删除session集合中的元素时  使用
	private int currentRoadMax;	//当前选择道路的 最大容量值
	/**
	 *  Function:查询预定精确 道路的  时间段信息
	 *  @author Freshen  DateTime 2014-7-7 下午03:55:48
	 *  @return
	 */
	public String execute(){
		List<Map<String,Integer>>preRoadDataInfo= new ArrayList<Map<String,Integer>>();	//存放时间段信息
		Map mapSess=ActionContext.getContext().getSession();
		try {
			ITimequantumService timeQuantumSer=new TimequantumServiceImpl();
			preRoadDataInfo = timeQuantumSer.getTimequantum(DateUtil.getDate(startDate_t, "M/d/yyyy HH:mm:ss"), roadID_s);
			mapSess.put("orderPreRoadTimeSquan", preRoadDataInfo);
			//产出当前道路的 最大容量值
			RoadInfo road=new RoadInfo();
			road.setRoadID_s(roadID_s);	//设置需要查询的道路ID
			IroadInfoService roadSer=new RoadInfoServiceImpl();
			ArrayList<RoadInfo> roads=roadSer.getRoadInfo(road);
			setCurrentRoadMax(roads.get(0).getMaxCapacity_i());	//将查出的当前道路的最大值 设置
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		 
		}
		return SUCCESS;
	}
	/**
	 *  Function:保存保存记录信息
	 *  @author Freshen  DateTime 2014-8-5 上午11:14:32
	 *  @return
	 */
	public String saveWholeRoad(){
		try {
			List<OrderPreRoad>roadsList =new ArrayList<OrderPreRoad>();
			//根据时间段，用v成分成多个对象
			String ts[]=timeQuantum.split("v");
			for (int i = 0; i < ts.length; i++) {
				OrderPreRoad owr=new OrderPreRoad();
				owr.setCarNumber_i(carNumber);
				owr.setRoadID_s(roadID_s);
				owr.setRoadName_s(roadName_s);
				if(startDate_t!=null && startDate_t.length()>1)
					owr.setStartDate_t(DateUtil.strToDate(startDate_t, "MM/dd/yyyy hh:mm:ss"));
				//补充 包场道路的 其他信息
				owr.setCreateDate_t(DateUtil.getCurDBDate() );
				Map sessMap =ActionContext.getContext().getSession();
				Employee loginUser=(Employee)sessMap.get("loginEmployee");
				owr.setCreateUser_s(loginUser.getCustomerUserName_s());
				owr.setOrderID_s(sessMap.get("orderId").toString());
				owr.setStatus_i(0);
				owr.setTimeQuantum_s(ts[i]);
				owr.setResaveds3_s("0");
				roadsList.add(owr);
			}
			IorderPreRoadService owSer=new OrderPreRoadServiceImpl();
			owSer.OperationOrderPreRoad(roadsList, 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return SUCCESS;
	}
	
	public String getRoadName_s() {
		return roadName_s;
	}

	public void setRoadName_s(String roadName_s) {
		this.roadName_s = roadName_s;
	}

	public String getRoadID_s() {
		return roadID_s;
	}

	public void setRoadID_s(String roadID_s) {
		this.roadID_s = roadID_s;
	}

	public String getStartDate_t() {
		return startDate_t;
	}

	public void setStartDate_t(String startDate_t) {
		this.startDate_t = startDate_t;
	}

	public String getEndDate_t() {
		return endDate_t;
	}

	public void setEndDate_t(String endDate_t) {
		this.endDate_t = endDate_t;
	}

	public String getTimeQuantum() {
		return timeQuantum;
	}

	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getItemIndex() {
		return itemIndex;
	}
	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}
	public int getCurrentRoadMax() {
		return currentRoadMax;
	}
	public void setCurrentRoadMax(int currentRoadMax) {
		this.currentRoadMax = currentRoadMax;
	}
}
