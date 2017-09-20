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

import com.freshen.basis.service.IworkShopInfoService;
import com.freshen.basis.service.impl.WorkShopInfoServiceImpl;
import com.freshen.entity.TInquityWorkShopoccupyinfo;
import com.freshen.entity.basis.WorkShopInfo;
import com.freshen.preorder.service.ItInquityWorkShopoccupyinfoService;
import com.freshen.util.HibernateUtil;import com.freshen.clims.baseclass.ClimsServiceBase;
import com.freshen.util.StringTools;

public  class TInquityWorkShopoccupyinfoServiceImpl extends ClimsServiceBase implements  ItInquityWorkShopoccupyinfoService{
	Session session= HibernateUtil.getSession();
	Transaction tx = null;
	public ArrayList<TInquityWorkShopoccupyinfo> getTInquityWorkShopoccupyinfo(
			String workShopid, Date date) throws Exception{
		if(!session.isOpen()){
			session= HibernateUtil.getSession();
		}
		try{
			String hql="from TInquityWorkShopoccupyinfo as tInquityWorkShopoccupyinfo where 1=1 "; 
			if(workShopid!=null&&!workShopid.trim().equals("")){
				hql = hql + " and tInquityWorkShopoccupyinfo.workshopid = '"+workShopid+"'";
			}
			if(date!=null){
				java.util.Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int month =calendar.get(calendar.MONTH);
				String months = StringTools.fillString(String.valueOf((month+1)), "0", 2);
				int year = calendar.get(calendar.YEAR);
				hql = hql + " and tInquityWorkShopoccupyinfo.month = '"+year+"-"+months+"'";
			}
			Query query=session.createQuery(hql);
		    List list = query.list();	    
			return (ArrayList<TInquityWorkShopoccupyinfo>) list;
		}catch (Exception e){
			tx.rollback();
			throw new Exception(e);
		}finally{
			
		}
	}
	
	public ArrayList getTInquityWorkShopoccupyinfoList(Date date) throws Exception{
		// TODO Auto-generated method stub
		ArrayList requestList = new ArrayList();
		//车间ID集合
		List workShopInfoidList = new ArrayList();
	 
		//1、得到所有车间信息
		IworkShopInfoService iworkShopInfoServiceImpl = new WorkShopInfoServiceImpl();
		List<WorkShopInfo> workShopInfoList = iworkShopInfoServiceImpl.getWorkShopInfo(new WorkShopInfo());
		for(int i=0;i<workShopInfoList.size();i++){
			WorkShopInfo workShopInfotmp = workShopInfoList.get(i);
			workShopInfoidList.add(workShopInfotmp.getWorkShopID_s());
		}
		//2、得到制定年月TInquityRoadoccupyinfo结果集
		List<TInquityWorkShopoccupyinfo> tInquityWorkShopoccupyinfoList = getTInquityWorkShopoccupyinfo(null,date);
		//3、得到返回的list
		for(int d=0;d<31;d++){
			HashMap map = new HashMap();
			if(tInquityWorkShopoccupyinfoList!=null&&tInquityWorkShopoccupyinfoList.size()>0)
			{
				//临时的道路id集合
				List workShopInfoidListtmp = new ArrayList(workShopInfoidList);
				//将已有的道路id和对应的d天的数量放到map中
				for(int i=0;i<tInquityWorkShopoccupyinfoList.size();i++){					
					TInquityWorkShopoccupyinfo tmp = tInquityWorkShopoccupyinfoList.get(i);	
					tmp.setDayData();
					String workShopid = tmp.getWorkshopid();
					List data = tmp.getDayData();
					map.put(workShopid, data.get(d));
					workShopInfoidListtmp.remove(workShopid);//去除已有的道路					
				}
				//在月度道路占用表中d天没有的道路id,在map中value为0
				for(int k=0;k<workShopInfoidListtmp.size();k++){
					map.put(workShopInfoidListtmp.get(k),"0");
				}
			}else{
				for(int k=0;k<workShopInfoidList.size();k++){
					map.put(workShopInfoidList.get(k),"0");
				}
			}
			requestList.add(d,map);
		}
		return requestList;
	}

	
	public static void main(String[] a){
		ItInquityWorkShopoccupyinfoService ItInquityRoadoccupyinfoService = new TInquityWorkShopoccupyinfoServiceImpl();
		List list;
		try {
			Date d = new Date();
			d.setMonth(5);
			list = ItInquityRoadoccupyinfoService.getTInquityWorkShopoccupyinfoList(d);
			//System.out.println(list.size());
			//System.out.println(((HashMap)list.get(3)).get("2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
