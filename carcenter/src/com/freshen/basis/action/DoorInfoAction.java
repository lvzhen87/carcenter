package com.freshen.basis.action;

import java.util.ArrayList;
import java.util.List;

import com.freshen.action.common.CapgActionSupport;

import com.freshen.entity.oneCard.TOnecardMjdoorBak;
import com.freshen.oneCard.service.ITOnecardMjdoorBakService;
import com.freshen.oneCard.service.impl.TOnecardMjdoorBakServiceImpl;

import com.freshen.util.ConstantUtil;
import com.freshen.util.ExceptionDispose;

public class DoorInfoAction extends CapgActionSupport{
	
	TOnecardMjdoorBak door=new TOnecardMjdoorBak();
	List<TOnecardMjdoorBak> doorlist=new ArrayList<TOnecardMjdoorBak>();
	
	String doorID;
	String doorName;
	
	String doorsID,groupsID,isUse;//收集页面中信息
	//分页必须
	long totalPages;
	int currentPage,maxPage,pageSize=ConstantUtil.pageSize;
	String flag;
	
	public String initDoorInfo(){
		try {
			TOnecardMjdoorBak tdoor=new TOnecardMjdoorBak();
			//tdoor.setIsUse_i(1);
			
			ITOnecardMjdoorBakService its=new TOnecardMjdoorBakServiceImpl();
			//确定记录总数
			if(flag != null){
				if(doorName!=null && doorName.trim().length()>1)
					doorName=(new String(doorName.getBytes("ISO-8859-1"),"UTF-8" ));
			}
			if(null != doorID && !doorID.trim().equals("")){
				tdoor.setDoorIdI(Integer.valueOf(doorID));				
			}
			tdoor.setDoorNameS(doorName);
			
			totalPages =its.getTOnecardMjdoorBakNumber(tdoor);
			maxPage=(int) (totalPages%pageSize==0?totalPages/pageSize:totalPages/pageSize+1);
			//合适当前页的有效性
			if(currentPage<=0){
				currentPage=0;
			}else if(currentPage>=maxPage){
				currentPage=maxPage;
			}
			
			if(totalPages > 0){
				doorlist=its.getTOnecardMjdoorBak(tdoor, currentPage*pageSize, pageSize);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}

	
	
	
	public String modifyDoor(){
		try {
			String dd[]=doorsID.split(",");
			String gg[]=groupsID.split(",");
			String uu[]=isUse.split(",");
			//System.out.println(dd.length +"-"+ gg.length +"-"+uu.length );
			ArrayList<TOnecardMjdoorBak> doorslist=new ArrayList<TOnecardMjdoorBak>();
			for (int i = 0; i < dd.length; i++) {
				if(dd[i] != null && dd[i].length()>0){
					TOnecardMjdoorBak temp=new TOnecardMjdoorBak();
					temp.setDoorIdI(Integer.valueOf(dd[i]));
					if(gg[i] !=null && gg[i].length()>0){
						//temp.setIsGroup_s(gg[i]);
						temp.setGroupId_s(gg[i]);
					}else{
					//	temp.setIsGroup_s("NA");
						temp.setGroupId_s("");
					}
					
					temp.setIsUse_i(Integer.valueOf(uu[i]));
					
					doorslist.add(temp);
				}
			}
//			Object[] o = {doorslist};
//			List<ServiceImpl> se = new ArrayList<ServiceImpl>();
//			ServiceImpl tmp = new ServiceImpl("com.freshen.oneCard.service.impl.TOnecardMjdoorBakServiceImpl","ChangeDoorIsUse",o);
//			se.add(tmp);
//			ServiceImpl.invoke(se);
			TOnecardMjdoorBakServiceImpl tbs = new TOnecardMjdoorBakServiceImpl();
			tbs.ChangeDoorIsUse(doorslist);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public TOnecardMjdoorBak getDoor() {
		return door;
	}
	public void setDoor(TOnecardMjdoorBak door) {
		this.door = door;
	}
	public List<TOnecardMjdoorBak> getDoorlist() {
		return doorlist;
	}
	public void setDoorlist(List<TOnecardMjdoorBak> doorlist) {
		this.doorlist = doorlist;
	}
//
//	public int getDoorID() {
//		return doorID;
//	}
//	public void setDoorID(int doorID) {
//		this.doorID = doorID;
//	}
	
	public String getDoorName() {
		return doorName;
	}
	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}

	public String getDoorID() {
		return doorID;
	}
	public void setDoorID(String doorID) {
		this.doorID = doorID;
	}
	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getDoorsID() {
		return doorsID;
	}
	public void setDoorsID(String doorsID) {
		this.doorsID = doorsID;
	}

	public String getGroupsID() {
		return groupsID;
	}
	public void setGroupsID(String groupsID) {
		this.groupsID = groupsID;
	}

	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	
	
}
