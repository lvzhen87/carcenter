package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.TInquityRoadoccupyinfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.preorder.service.ItInquityRoadoccupyinfoService;
import com.freshen.preorder.service.impl.TInquityRoadoccupyinfoServiceImpl;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: RoadOccupationAction.java
 *  Function:道路占用信息查询 ，跳转到道路占用信息页面，方便试验安排时参考
 *     Modifications:   
 *  @author   DateTime 2014-4-10 上午11:00:37    
 *  @version 1.0
 */

public class RoadOccupationAction extends CapgActionSupport{
	String rstr=SUCCESS;
	List<Map<String,String>>roadData=new ArrayList();
	Date currentDate;
	List roadNames=new ArrayList();
	int dayOfMon[]={31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	public String execute(){
		//道路占用的业务逻辑
		ArrayList<Map<String,String>>roadDs=null;	//道路占用 具体数据
		ArrayList<RoadInfo> rds=null;				//道路集合
		try {
			if(currentDate==null)
				currentDate=DateUtil.getCurrentDate();
			ItInquityRoadoccupyinfoService roadOccupy=new TInquityRoadoccupyinfoServiceImpl();
			roadDs=roadOccupy.getTInquityRoadoccupyinfoList(currentDate);
			//System.out.println("道路占用查询 ： 道路占用数据 条数 "+roadDs.size() );
//			for (Map item : roadDs) {
//				//System.out.println(item);
//			}
			
			IroadInfoService roadSer=new RoadInfoServiceImpl();
			RoadInfo ri =new RoadInfo();
			//获取试验场 共有道路条数
			rds = roadSer.getRoadInfo(ri);
			//System.out.println("道路占用查询  ： 试验场道路条数 "+rds.size());
			//将查询到的 试验场道路 添加
			setRoadNames(rds);
			roadNames.add(0, "01");
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
//		roadNames.add("01");
//		roadNames.add("11");
//		roadNames.add("12");
//		roadNames.add("13");
		//准备生成日历 
		Calendar c =Calendar.getInstance();
		c.set(Calendar.YEAR, DateUtil.getYear(currentDate));
		c.set(Calendar.MONTH, currentDate.getMonth());
		//c.set(Calendar.MONTH, 4);
		c.set(Calendar.DATE, 1);
		//System.out.println("年 "+c.get(Calendar.YEAR));
		Date d =c.getTime();
		//System.out.println(DateUtil.dateToString(d) +"  "+currentDate.getMonth());
		//修改闰年二月
		int y=currentDate.getYear();
		if(y%4==0&& y%100!=0 || y%400==0)
			dayOfMon[1]=29;
		int n=c.get(Calendar.DAY_OF_WEEK);//第一天星期
		//System.out.println("DAY_OF_WEEK"+n);
		//填充无效数据
		for (int i = 0; i < n-1; i++) {
			roadData.add(null);
		}
		//填充日历数据
		for (int i = 0; i < roadDs.size(); i++) {
			Map m =roadDs.get(i);
			m.put("01", i+1);
			m.put("02", "ConstantUtil.pageSize");
		}
//		for (int i = 0; i <dayOfMon[currentDate.getMonth()]; i++) {
//			Map item =new HashMap();
//			item.put("00", "ConstantUtil.pageSize");
//			item.put("01", i+1);
//			roadData.add(item);
//		}
		//设置具体数据
		roadData.addAll(roadDs);
		
//		//System.out.println("道路条数"+roadNames.size());
//		//System.out.println("当前数据个数"+roadData.size()+" "+roadData.toString());
		return rstr;
	}
	
	public static void main(String[] args) {
		new RoadOccupationAction().execute();
	}

	public List getRoadNames() {
		return roadNames;
	}

	public void setRoadNames(List roadNames) {
		this.roadNames = roadNames;
	}

	public List getRoadData() {
		return roadData;
	}

	public void setRoadData(List roadData) {
		this.roadData = roadData;
	}

	public String getCurrentDate() {
		return DateUtil.dateToString(currentDate, "yyyy-MM-dd");
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	
}
