package com.freshen.preorder.service;

import java.util.ArrayList;
import java.util.Date;

import com.freshen.entity.OrderOther;
import com.freshen.entity.TInquityRoadoccupyinfo;

public interface ItInquityRoadoccupyinfoService {

	/**
	 * 得到按月度查询道路占用情况表数据	   
	 * getTInquityRoadoccupyinfo 
	 * @param   roadid 设施id
	 *          date   日期
	 * @param  @return    设定文件    
	 * @return String    
	 * @Exception 异常对象    
	 * @since  CodingExample　Ver(编码范例查看) 1.1
	 */
	public ArrayList<TInquityRoadoccupyinfo> getTInquityRoadoccupyinfo(String roadid,Date date)throws Exception ;
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
	public ArrayList getTInquityRoadoccupyinfoList(Date date) throws Exception;
}
