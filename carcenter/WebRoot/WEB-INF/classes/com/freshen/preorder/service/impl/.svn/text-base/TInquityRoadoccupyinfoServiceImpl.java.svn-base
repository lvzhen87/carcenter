package com.freshen.preorder.service.impl;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.OrderDetail;
import com.freshen.entity.TInquityRoadoccupyinfo;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.preorder.service.IorderInfoService;
import com.freshen.preorder.service.ItInquityRoadoccupyinfoService;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

public class TInquityRoadoccupyinfoServiceImpl extends ClimsServiceBase implements  ItInquityRoadoccupyinfoService{
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<TInquityRoadoccupyinfo> getTInquityRoadoccupyinfo(
			String roadid, Date date) throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql="from TInquityRoadoccupyinfo as tInquityRoadoccupyinfo where 1=1 "; 
			if(roadid!=null&&!roadid.equals("")){
				hql = hql + " and tInquityRoadoccupyinfo.roadid = '"+roadid+"'";
			}
			if(date!=null){
				java.util.Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int month =calendar.get(calendar.MONTH);
				String months = StringTools.fillString(String.valueOf((month+1)), "0", 2);
				int year = calendar.get(calendar.YEAR);
				hql = hql + " and tInquityRoadoccupyinfo.month = '"+year+"-"+months+"'";
			}
			Query query=session.createQuery(hql);
		    List list = query.list();	    
			return (ArrayList<TInquityRoadoccupyinfo>) list;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			
		}
	}
	
	public ArrayList getTInquityRoadoccupyinfoList(Date date) throws Exception{
		// TODO Auto-generated method stub
		ArrayList requestList = new ArrayList();
		//道路ID集合
		List roadInfoidList = new ArrayList();
		//道路ID与最大容量对照
		Map roadmaxCapacity = new HashMap();
		//1、得到所有道路信息
		IroadInfoService iroadInfoServiceImpl = new RoadInfoServiceImpl();
		List<RoadInfo> roadInfoList = iroadInfoServiceImpl.getRoadInfo(new RoadInfo());
		for(int i=0;i<roadInfoList.size();i++){
			RoadInfo roadInfotmp = roadInfoList.get(i);
			roadInfoidList.add(roadInfotmp.getRoadID_s());
			roadmaxCapacity.put(roadInfotmp.getRoadID_s(),roadInfotmp.getMaxCapacity_i());
		}
		//2、得到制定年月TInquityRoadoccupyinfo结果集
		List<TInquityRoadoccupyinfo> tInquityRoadoccupyinfoList = getTInquityRoadoccupyinfo(null,date);
		//3、得到返回的list
		for(int d=0;d<31;d++){
			HashMap map = new HashMap();
			if(tInquityRoadoccupyinfoList!=null&&tInquityRoadoccupyinfoList.size()>0)
			{
				//临时的道路id集合
				List roadInfoidListtmp = new ArrayList(roadInfoidList);
				//将已有的道路id和对应的d天的数量放到map中
				for(int i=0;i<tInquityRoadoccupyinfoList.size();i++){					
					TInquityRoadoccupyinfo tmp = tInquityRoadoccupyinfoList.get(i);	
					tmp.setDayData();
					String roadInfoid = tmp.getRoadid();
					List data = tmp.getDayData();
					map.put(roadInfoid, data.get(d));
					roadInfoidListtmp.remove(roadInfoid);//去除已有的道路					
				}
				//在月度道路占用表中d天没有的道路id,在map中value为0
				for(int k=0;k<roadInfoidListtmp.size();k++){
					map.put(roadInfoidListtmp.get(k),"0");
				}
			}else{
				for(int k=0;k<roadInfoidList.size();k++){
					map.put(roadInfoidList.get(k),"0");
				}
			}
			requestList.add(d,map);
		}
		return requestList;
	}

	
	public static void main(String[] a){
		ItInquityRoadoccupyinfoService ItInquityRoadoccupyinfoService = new TInquityRoadoccupyinfoServiceImpl();
		List list;
		try {
			list = ItInquityRoadoccupyinfoService.getTInquityRoadoccupyinfoList(new Date());
			//System.out.println(list.size());
			//System.out.println(((HashMap)list.get(3)).get("R007"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
