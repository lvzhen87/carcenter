package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.Date;

import com.freshen.entity.OrderOther;
import com.freshen.entity.TInquityRoadoccupyinfo;
import com.freshen.entity.TInquityWorkShopoccupyinfo;

public interface ItInquityWorkShopoccupyinfoService {

	/**
	 * 得到按月度查询车间占用情况表数据	   
	 * getTInquityWorkShopoccupyinfo 
	 * @param   roadid 设施id
	 *          date   日期
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<TInquityWorkShopoccupyinfo> getTInquityWorkShopoccupyinfo(String workShopid,Date date)throws Exception ;
	/**
	 * 将数据整理为list,list共有31个元素(代码31天),其中每个元素为一个map，
	 * 每个map为<道路1id,第一天数据>，<道路2id,第一天数据>....<道路nid,第一天数据>>
	 * getTInquityRoadoccupyinfoList 
	 * @param   name    
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList getTInquityWorkShopoccupyinfoList(Date date) throws Exception;
}
