package com.freshen.entity.basis;

import com.freshen.clims.baseclass.BeanModel;

public class RoadUseStatistic  extends  BeanModel{

	private static final long serialVersionUID = 1L;
	
	String roadID_s,roadName_s,technicalParameters_s,maxcapacity_s,usefultime_s,createdate_s,rate_s,runtime_s;

	
	public String getRuntime_s() {
		return runtime_s;
	}

	public void setRuntime_s(String runtime_s) {
		this.runtime_s = runtime_s;
	}

	public String getRoadID_s() {
		return roadID_s;
	}

	public void setRoadID_s(String roadID_s) {
		this.roadID_s = roadID_s;
	}

	public String getRoadName_s() {
		return roadName_s;
	}

	public void setRoadName_s(String roadName_s) {
		this.roadName_s = roadName_s;
	}

	public String getTechnicalParameters_s() {
		return technicalParameters_s;
	}

	public void setTechnicalParameters_s(String technicalParameters_s) {
		this.technicalParameters_s = technicalParameters_s;
	}

	public String getMaxcapacity_s() {
		return maxcapacity_s;
	}

	public void setMaxcapacity_s(String maxcapacity_s) {
		this.maxcapacity_s = maxcapacity_s;
	}

	public String getUsefultime_s() {
		return usefultime_s;
	}

	public void setUsefultime_s(String usefultime_s) {
		this.usefultime_s = usefultime_s;
	}

	public String getCreatedate_s() {
		return createdate_s;
	}

	public void setCreatedate_s(String createdate_s) {
		this.createdate_s = createdate_s;
	}

	public String getRate_s() {
		return rate_s;
	}

	public void setRate_s(String rate_s) {
		this.rate_s = rate_s;
	}
	
	
}
