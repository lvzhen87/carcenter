package com.freshen.entity.cost;

import java.util.ArrayList;
import java.util.List;

/**
 *     
 * 项目名称：carcenter    
 * 类名称：OrderroadcostTemp    
 * 类描述： 道路费用显示存储
 * 创建人：kxc    
 * 创建时间：2014-11-1 上午09:20:22    
 * 修改人：kxc    
 * 修改时间：2014-11-1 上午09:20:22    
 * 修改备注：    
 * @version     
 *
 */
public class OrderroadcostTemp {

	private List<String> roadInfo = new ArrayList();
	private String cardId;
	private double sumcost =0;
	
	 
	public double getSumcost() {
		return sumcost;
	}
	public void setSumcost(double sumcost) {
		this.sumcost = sumcost;
	}
	public void setRoadInfo(List<String> roadInfo) {
		this.roadInfo = roadInfo;
	}
	public List<String> getRoadInfo() {
		return roadInfo;
	}
 
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	
}
