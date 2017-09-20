package com.freshen.entity.process;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 道路使用清单    
 * 项目名称：carcenter    
 * 类名称：RoadEmployInventory    
 * 类描述：    
 * 创建人：kxc    
 * 创建时间：2014-12-30 下午04:13:24    
 * 修改人：kxc    
 * 修改时间：2014-12-30 下午04:13:24    
 * 修改备注：    
 * @version     
 *
 */
public class RoadEmployInventory {
	private String cardId_s;
	private String handworkCpg;
	private String orderId_s;
	private String brandType_s;
	private String startComeDate_s;//出道路开始日期
	private String endComeDate_s;//出道路截止日期
	private List<StationDetailModel> stationDetailModelList = new ArrayList<StationDetailModel>();
	private int stationDetailModelsize = 0; 
	public String getCardId_s() {
		return cardId_s;
	}


	public void setCardId_s(String cardIdS) {
		cardId_s = cardIdS;
	}


	public String getOrderId_s() {
		return orderId_s;
	}


	public void setOrderId_s(String orderIdS) {
		orderId_s = orderIdS;
	}


	public String getBrandType_s() {
		return brandType_s;
	}


	public void setBrandType_s(String brandTypeS) {
		brandType_s = brandTypeS;
	}


	public String getStartComeDate_s() {
		return startComeDate_s;
	}


	public void setStartComeDate_s(String startComeDateS) {
		startComeDate_s = startComeDateS;
	}


	public String getEndComeDate_s() {
		return endComeDate_s;
	}


	public void setEndComeDate_s(String endComeDateS) {
		endComeDate_s = endComeDateS;
	}


	public String getHandworkCpg() {
		return handworkCpg;
	}


	public void setHandworkCpg(String handworkCpg) {
		this.handworkCpg = handworkCpg;
	}


	public List<StationDetailModel> getStationDetailModelList() {
		
		return stationDetailModelList;
	}


	public int getStationDetailModelsize() {
		stationDetailModelsize = 0;
		for(StationDetailModel tmp:stationDetailModelList){
			stationDetailModelsize += tmp.getStationDetailTimeModelSize();
		}		
		return stationDetailModelsize;
		//return stationDetailModelList.size();
		
	}


	public void setStationDetailModelsize(int stationDetailModelsize) {
		this.stationDetailModelsize = stationDetailModelsize;
	}


	public void setStationDetailModelList(
			List<StationDetailModel> stationDetailModelList) {
		this.stationDetailModelList = stationDetailModelList;
	}

	public void addStationDetailModelList(
			StationDetailModel stationDetailModel) {
		this.stationDetailModelList.add(stationDetailModel);
	}
	
	public StationDetailModel getStationDetailModel(){
		return new StationDetailModel();
	}
	/**
	 * 
	 * 使用道路明细    
	 * 项目名称：carcenter    
	 * 类名称：stationDetailModel    
	 * 类描述：    
	 * 创建人：kxc    
	 * 创建时间：2014-12-30 下午04:19:27    
	 * 修改人：kxc    
	 * 修改时间：2014-12-30 下午04:19:27    
	 * 修改备注：    
	 * @version     
	 *
	 */
	public class StationDetailModel { 
		private String roadId_s;
		private String roadName_s;
		private Integer employTimeCount = 0;//总使用时间
		private Integer shareTimeCount = 0;//共享使用时间
		private Integer preTimeCount = 0;//精确使用时间
		private Integer wholeTimeCount = 0;//包场使用时间
		private List<StationDetailTimeModel> stationDetailTimeModelList = new ArrayList<StationDetailTimeModel>();
		private int stationDetailTimeModelSize = 0;
		
		public String getRoadId_s() {
			return roadId_s;
		}


		public void setRoadId_s(String roadIdS) {
			roadId_s = roadIdS;
		}


		public String getRoadName_s() {
			return roadName_s;
		}


		public void setRoadName_s(String roadNameS) {
			roadName_s = roadNameS;
		}


		public Integer getEmployTimeCount() {
			return employTimeCount;
		}


		public void setEmployTimeCount(Integer employTimeCount) {
			this.employTimeCount += employTimeCount;
		}


		public Integer getShareTimeCount() {
			return shareTimeCount;
		}


		public void setShareTimeCount(Integer shareTimeCount) {
			this.shareTimeCount += shareTimeCount;
		}


		public Integer getPreTimeCount() {
			return preTimeCount;
		}


		public void setPreTimeCount(Integer preTimeCount) {
			this.preTimeCount += preTimeCount;
		}


		public Integer getWholeTimeCount() {
			return wholeTimeCount;
		}


		public void setWholeTimeCount(Integer wholeTimeCount) {
			this.wholeTimeCount += wholeTimeCount;
		}


		public List<StationDetailTimeModel> getStationDetailTimeModelList() {
			return stationDetailTimeModelList;
		}


		public void setStationDetailTimeModelList(
				List<StationDetailTimeModel> stationDetailTimeModelList) {
			this.stationDetailTimeModelList = stationDetailTimeModelList;
		}

		public void addStationDetailTimeModelList(
				StationDetailTimeModel stationDetailTimeModel) {
			this.stationDetailTimeModelList.add(stationDetailTimeModel);
		}
		
		public StationDetailTimeModel getStationDetailTimeModel(){
			return new StationDetailTimeModel();
		}
		
		
		public int getStationDetailTimeModelSize() {
			return stationDetailTimeModelList.size();
		}


		public void setStationDetailTimeModelSize(int stationDetailTimeModelSize) {
			this.stationDetailTimeModelSize = stationDetailTimeModelSize;
		}


		/**
		 * 
		 * 使用道路时间明细    
		 * 项目名称：carcenter    
		 * 类名称：stationDetailTimeModel    
		 * 类描述：    
		 * 创建人：kxc    
		 * 创建时间：2014-12-30 下午04:32:29    
		 * 修改人：kxc    
		 * 修改时间：2014-12-30 下午04:32:29    
		 * 修改备注：    
		 * @version     
		 *
		 */
		public class StationDetailTimeModel { 
			private String enterTime;//进道闸时间
			private String comeTime;//出道闸时间
			private Integer timeCount;//用时
			public String getEnterTime() {
				return enterTime;
			}
			public void setEnterTime(String enterTime) {
				this.enterTime = enterTime;
			}
			public String getComeTime() {
				return comeTime;
			}
			public void setComeTime(String comeTime) {
				this.comeTime = comeTime;
			}
			public Integer getTimeCount() {
				return timeCount;
			}
			public void setTimeCount(Integer timeCount) {
				this.timeCount = timeCount;
			}			
		}
	}
}
