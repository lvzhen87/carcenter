package com.freshen.preorder.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.freshen.entity.OrderDetail;
import com.freshen.entity.OrderHotelOther;
import com.freshen.entity.OrderOther;
import com.freshen.entity.OrderWorkShop;
import com.freshen.entity.OrderWorkShopDay;
import com.freshen.entity.Orderroaddaydetail;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.IorderRoadDayDetailService;
import com.freshen.preorder.service.IorderWorkShopDayService;
import com.freshen.preorder.service.IpreorderCheckService;
import com.freshen.preorder.service.impl.OrderInfoServiceImpl;
import com.freshen.preorder.service.impl.OrderRoadDayDetailServiceImpl;
import com.freshen.preorder.service.impl.OrderWorkShopDayServiceImpl;
import com.freshen.preorder.service.impl.PreorderCheckServiceImpl;
import com.freshen.util.ConstantUtil;
import com.freshen.util.DateUtil;
import com.freshen.util.ExceptionDispose;
import com.opensymphony.xwork2.ActionContext;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 *     
 * 项目名称：carcenter    
 * 类名称：CheckOrderAction    
 * 类描述：    员工审核订单是否通过
 * 创建人：sharonyshi    
 * 创建时间：2014-4-2 下午04:36:19    
 * 修改人：sharonyshi    
 * 修改时间：2014-4-2 下午04:36:19    
 * 修改备注：    
 * @version     
 *
 */
public class CheckOrderAction extends CapgActionSupport{
	String orderid;
	String currentTab="0";	//当前选中哪一个面板
	String QUERY="query";
	//子订单 记录 集
	List<String> selRoadItem=new ArrayList();	//标志 记录是否被选中
	List<String> selWorkshopItem=new ArrayList();	//标志 记录是否被选中
	List<String> workshopids=new ArrayList(),workshopstatus=new ArrayList();	//收集页面提交 的 拆分成天的  记录信息
	
	//车辆及信息安全和车辆信息
	List<OrderOther> orderotherList=new ArrayList<OrderOther>();
	//酒店预订信息
	List<OrderHotelOther> orderhotelList=new ArrayList<OrderHotelOther>();
	public String resStr=SUCCESS;
	//List<Date> roaddates=new ArrayList(),workshopdates=new ArrayList();		//拆分成天的  记录 日期
	
	//分页必须
	long roadMaxItem,workMaxItem,otherMaxItem;
	int roadCurrentPage,pageSize=ConstantUtil.pageSize,roadMaxPage;
	int workCurrentPage,workMaxPage;
	int otherCurrentPage,otherMaxPage;
	/**
	 *  Function:查询出，订单 被拆分成天的 信息,其中查出的 道路 和车间 拆分后的数据 ，被放入 HttpSession中了，此处   未做   修改
	 *  @author Freshen  DateTime 2014-4-17 下午01:36:00
	 *  @return
	 */
	public String initorders(){
//		//System.out.println("查询  订单 的拆分道路" +orderid);
		
		List<Orderroaddaydetail> oroads;
		try {
			//查询，按天拆分的 道路
			IorderRoadDayDetailService iorderroaddayService=new OrderRoadDayDetailServiceImpl();
			
			Orderroaddaydetail ordd=new Orderroaddaydetail();
			ordd.setOrderidS(orderid);	//所属订单编号
			//ordd.setStatusI(0);			//状态为0  属于初始状态，1 已确认状态
			//System.out.println("预查出拆分  道路 "+ordd);
			//获取记录 数目
			roadMaxItem=iorderroaddayService.getOrderRoadDayNumber(ordd);
			roadMaxPage =(int) (roadMaxItem%pageSize==0?roadMaxItem/pageSize:roadMaxItem/pageSize+1);
			//验证当前页面
			if(roadCurrentPage<=0)roadCurrentPage=0;
			if(roadCurrentPage>=roadMaxPage)roadCurrentPage=roadMaxPage;
			//分页查询记录
			oroads = iorderroaddayService.getOrderRoadDay(ordd,roadCurrentPage*pageSize,pageSize);
			
			//	预订使用类型"0:共享/1:专用"设置
			for(int i = 0; i < oroads.size(); i++){
				if(null != oroads.get(i).getTypeS() && !oroads.get(i).getTypeS().trim().equals("")){
					if(oroads.get(i).getTypeS().equals("0")){
						oroads.get(i).setTypeS(ConstantUtil.orderRoadType_0);
					} else if(oroads.get(i).getTypeS().equals("1")){
						oroads.get(i).setTypeS(ConstantUtil.orderRoadType_1);
					}
				}
			}
			
			ActionContext.getContext().getSession().put("roadsList", oroads);
//			//System.out.println("制定路面信息条数："+oroads.size());
			
			//查询，按天拆分的 车间
			IorderWorkShopDayService iorderworkshopdayService=new OrderWorkShopDayServiceImpl();
			OrderWorkShopDay owsd=new OrderWorkShopDay();
			owsd.setOrderID_s(orderid);
			//owsd.setStatus_i(0);
			//计算车间记录 最大数
			workMaxItem =iorderworkshopdayService.getOrderWorkShopDayNumber(owsd);
			workMaxPage = (int) (workMaxItem%pageSize==0? workMaxItem/pageSize:workMaxItem/pageSize+1);
			//验证当前页面的 合法性
			if(workCurrentPage<=0)workCurrentPage=0;
			if(workCurrentPage>=workMaxPage)workCurrentPage=workMaxPage;
			
			List<OrderWorkShopDay> workshopday=iorderworkshopdayService.getOrderWorkShopDay(owsd,workCurrentPage*pageSize,pageSize);
			ActionContext.getContext().getSession().put("workshopList", workshopday);
			
			//System.out.println("办公预订信息条数："+workshopday.size());
			

			
			//查询车辆安全信息和车辆信息
			IorderInfoService iorderohterService=new OrderInfoServiceImpl();
			OrderOther orderohter=new OrderOther();
			orderohter.setOrderID_s(orderid);
			//记录最大数
			otherMaxItem=iorderohterService.getOrderOtherbyModelNumber(orderohter);
			otherMaxPage=(int)(otherMaxItem%pageSize==0? otherMaxItem/pageSize:otherMaxItem/pageSize+1);
			//验证当前页面的 合法性
			if(otherCurrentPage<=0)otherCurrentPage=0;
			if(otherCurrentPage>=otherMaxPage)otherCurrentPage=otherMaxPage;
			orderotherList=iorderohterService.getOrderOtherbyModel(orderohter,otherCurrentPage*pageSize,pageSize);
			
			//查询酒店预订信息，只为显示
			orderhotelList=iorderohterService.getOrderHotelOther(orderid); 
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return QUERY;
	}
	/**
	 *  Function:确认 被拆分成 每一天的道路信息
	 *  @author Freshen  DateTime 2014-4-17 下午01:38:50
	 *  @return
	 */
	public String checkroadorders(){
		////System.out.println("修改 订单 状态 订单 的拆分道路" +orderid);
		//System.out.println("checkroadorders执行  复选道路数 "+selRoadItem.size());
		////System.out.println("selRoadItem "+selRoadItem.toString());
		List list = new ArrayList();//存放  拆分 成天的 道路 记录
		Set<String>subRoadOrderIDs=new HashSet();
		//
		//System.out.println("从页面收集 数据元素集合  大小   roadids="+selRoadItem.size() + " roadstatus="+selRoadItem.size());
		try {
			//将从页面上收集的 拆分 记录，封装成 Object数组，放入集合。（业务逻辑 需要这样）
			for (int i = 0; i < selRoadItem.size(); i++) {
				//if(!roadstatus.get(i).equals("1"))continue;
				String subs[]=selRoadItem.get(i).split(",");
				Object[] info = new Object[3];
				info[0] = subs[0];
				info[1] = DateUtil.stringToDate(subs[1]);
				info[2] = "1";
				list.add(info);
				//System.out.println("修改 拆分 订单 "+info[0]+"  "+info[1]+" "+info[2]);
			}
			//检测并修改  拆分成天的 状态
			IorderRoadDayDetailService iorderroaddayService=new OrderRoadDayDetailServiceImpl();
			int roadresult=iorderroaddayService.checkOrderRoadDay(list);
			//如果 拆分 的天，都被检验通过，则修改 道路预定状态,修改子订单状态
			IpreorderCheckService ipreorderCheckService = new PreorderCheckServiceImpl();
//			for (String subRoadId : subRoadOrderIDs) {
//				ipreorderCheckService.preorderCheck(subRoadId,1);
//			}
			//System.out.println("拆分后状态修改了，尝试修改订单 状态 orderid="+orderid);
			//ipreorderCheckService.preorderCheck(orderid,1);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return QUERY;
	}
	/**
	 *  Function:确认 被拆分成 每一天的 车间 信息
	 *  @author Freshen  DateTime 2014-4-17 下午01:38:50
	 *  @return
	 */
	public String checkworkshoporders(){
		//System.out.println("确认拆分成天的 车间 数据   ，复选车间数 ="+selWorkshopItem.size());
		
		try {
			IorderWorkShopDayService iorderworkshopdayService=new OrderWorkShopDayServiceImpl();
			List list = new ArrayList();
			for (int i = 0; i < selWorkshopItem.size(); i++){
				String subs[]=selWorkshopItem.get(i).split(",");
				Object[] info= new Object[3];
				info[0] = subs[0];
				info[1] = DateUtil.stringToDate(subs[1]);
				info[2] = "1";
				list.add(info);
			}
			int roadresult=iorderworkshopdayService.checkOrderWorkShopDay(list);
			//更新 车间 预定 状态
			IpreorderCheckService ipreorderCheckService = new PreorderCheckServiceImpl();
			//System.out.println("更新拆分车间状态时  orderid="+orderid);
			//ipreorderCheckService.preorderCheck(orderid,2);		
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO Auto-generated catch block
			 
		}
		return QUERY;
	}
	
	
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public long getRoadMaxItem() {
		return roadMaxItem;
	}
	public void setRoadMaxItem(long roadMaxItem) {
		this.roadMaxItem = roadMaxItem;
	}
	public long getWorkMaxItem() {
		return workMaxItem;
	}
	public void setWorkMaxItem(long workMaxItem) {
		this.workMaxItem = workMaxItem;
	}
	public int getRoadCurrentPage() {
		return roadCurrentPage;
	}
	public void setRoadCurrentPage(int roadCurrentPage) {
		this.roadCurrentPage = roadCurrentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRoadMaxPage() {
		return roadMaxPage;
	}
	public void setRoadMaxPage(int roadMaxPage) {
		this.roadMaxPage = roadMaxPage;
	}
	public int getWorkCurrentPage() {
		return workCurrentPage;
	}
	public void setWorkCurrentPage(int workCurrentPage) {
		this.workCurrentPage = workCurrentPage;
	}
	public int getWorkMaxPage() {
		return workMaxPage;
	}
	public void setWorkMaxPage(int workMaxPage) {
		this.workMaxPage = workMaxPage;
	}
	public List<String> getWorkshopids() {
		return workshopids;
	}
	public void setWorkshopids(List<String> workshopids) {
		this.workshopids = workshopids;
	}
	public List<String> getWorkshopstatus() {
		return workshopstatus;
	}
	public void setWorkshopstatus(List<String> workshopstatus) {
		this.workshopstatus = workshopstatus;
	}
	public List<String> getSelRoadItem() {
		return selRoadItem;
	}
	public void setSelRoadItem(List<String> selRoadItem) {
		this.selRoadItem = selRoadItem;
	}
	public List<String> getSelWorkshopItem() {
		return selWorkshopItem;
	}
	public void setSelWorkshopItem(List<String> selWorkshopItem) {
		this.selWorkshopItem = selWorkshopItem;
	}
	public String getCurrentTab() {
		return currentTab;
	}
	public void setCurrentTab(String currentTab) {
		this.currentTab = currentTab;
	}
	public List<OrderOther> getOrderotherList() {
		return orderotherList;
	}
	public void setOrderotherList(List<OrderOther> orderotherList) {
		this.orderotherList = orderotherList;
	}
	public List<OrderHotelOther> getOrderhotelList() {
		return orderhotelList;
	}
	public void setOrderhotelList(List<OrderHotelOther> orderhotelList) {
		this.orderhotelList = orderhotelList;
	}
	public long getOtherMaxItem() {
		return otherMaxItem;
	}
	public void setOtherMaxItem(long otherMaxItem) {
		this.otherMaxItem = otherMaxItem;
	}
	public int getOtherCurrentPage() {
		return otherCurrentPage;
	}
	public void setOtherCurrentPage(int otherCurrentPage) {
		this.otherCurrentPage = otherCurrentPage;
	}
	public int getOtherMaxPage() {
		return otherMaxPage;
	}
	public void setOtherMaxPage(int otherMaxPage) {
		this.otherMaxPage = otherMaxPage;
	}
	
}
