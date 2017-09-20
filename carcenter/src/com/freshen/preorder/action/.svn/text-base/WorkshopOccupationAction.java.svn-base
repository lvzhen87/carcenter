package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;
import com.freshen.entity.OrderWorkShopDay;
import com.freshen.entity.TInquityRoadoccupyinfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.preorder.service.IorderWorkShopDayService;
import com.freshen.preorder.service.ItInquityRoadoccupyinfoService;
import com.freshen.preorder.service.impl.OrderWorkShopDayServiceImpl;
import com.freshen.preorder.service.impl.TInquityRoadoccupyinfoServiceImpl;
import com.freshen.preorder.service.impl.TInquityWorkShopoccupyinfoServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: 
 *  Function:车间占用信息查询 ，跳转到车间占用信息页面，方便试验安排时参考
 *     Modifications:   
 *  @author   DateTime 2014-4-10 上午11:00:37    
 *  @version 1.0
 */
public class WorkshopOccupationAction extends CapgActionSupport{
	String rstr=SUCCESS;
	List<Map<String,String>>workshopData=new ArrayList();
	Date currentDate;
	List workshopNames=new ArrayList();
	int dayOfMon[]={31,28,31,30,31,30,31,31,30,31,30,31};
	
	public String execute(){
		//车间占用的业务逻辑
		ArrayList<Map<String,String>>workshopDs=null;	//车间占用 具体数据
		ArrayList<WorkShopInfo> wsList=null;				//车间集合
		try {
			if(currentDate==null)
				currentDate=DateUtil.getCurrentDate();
			//查询车间占用 具体数据
			TInquityWorkShopoccupyinfoServiceImpl workshopOccupy=new TInquityWorkShopoccupyinfoServiceImpl();
			OrderWorkShopDay owsd=new OrderWorkShopDay();
			workshopDs=workshopOccupy.getTInquityWorkShopoccupyinfoList(currentDate);
			//System.out.println("车间占用查询 ： 车间占用数据 条数 "+workshopDs.size() );
			
			//查询车间 名称
			IworkShopInfoService workshopSer=new WorkShopInfoServiceImpl();
			WorkShopInfo wsi =new WorkShopInfo();
			//获取试验场 共有车间条数
			wsList = workshopSer.getWorkShopInfo(wsi);
			//System.out.println("车间占用查询  ： 试验场车间条数 "+wsList.size());
			//将查询到的 试验场车间 添加
			setWorkshopNames(wsList);
			workshopNames.add(0, "01");
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
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
			workshopData.add(null);
		}
		//填充日历数据
		for (int i = 0; i < workshopDs.size(); i++) {
			Map m =workshopDs.get(i);
			m.put("01", i+1);
			m.put("02", "MAX");
		}
		//设置具体数据
		workshopData.addAll(workshopDs);
		
//		//System.out.println("车间条数"+roadNames.size());
//		//System.out.println("当前数据个数"+roadData.size()+" "+roadData.toString());
		return rstr;
	}
	
	public static void main(String[] args) {
		new WorkshopOccupationAction().execute();
	}
	public String getCurrentDate() {
		return DateUtil.dateToString(currentDate, "yyyy-MM-dd");
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public List<Map<String, String>> getWorkshopData() {
		return workshopData;
	}

	public void setWorkshopData(List<Map<String, String>> workshopData) {
		this.workshopData = workshopData;
	}

	public List getWorkshopNames() {
		return workshopNames;
	}

	public void setWorkshopNames(List workshopNames) {
		this.workshopNames = workshopNames;
	}
}
