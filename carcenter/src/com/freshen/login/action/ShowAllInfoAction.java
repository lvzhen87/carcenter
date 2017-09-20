package com.freshen.login.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.freshen.action.common.CapgActionSupport;
import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.util.ExceptionDispose;

public class ShowAllInfoAction extends CapgActionSupport{
	 
	String msg;
	ArrayList<RoadInfo> roadInfoList= new ArrayList<RoadInfo>();
	int[][] s = new int[9][2];
	public ArrayList<RoadInfo> getRoadInfoList() {
		return roadInfoList;
	}

	public void setRoadInfoList(ArrayList<RoadInfo> roadInfoList) {
		this.roadInfoList = roadInfoList;
	}

	 

	public int[][] getS() {
		return s;
	}

	public void setS(int[][] s) {
		this.s = s;
	}

	public String execute(){
		try {
			IroadInfoService roadInfoService=new RoadInfoServiceImpl();
			roadInfoList = roadInfoService.getRoadInfo(null);
			for(int i=0;i<roadInfoList.size();i++){
				int[] st = new int[2];
				RoadInfo t = roadInfoList.get(i);
				st[1]=t.getMaxCapacity_i();
				st[0]=Integer.valueOf(t.getResaveds3_s());
				s[i] = st;								
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return SUCCESS;
	}
	/**
	 * 得到实时的道路车辆信息
	 * @return
	 */
	public String showall(){
		try {
			System.out.println("showall");
			IroadInfoService roadInfoService=new RoadInfoServiceImpl();
			roadInfoList = roadInfoService.getRoadInfo(null);
			for(int i=0;i<roadInfoList.size();i++){
				int[] st = new int[2];
				RoadInfo t = roadInfoList.get(i);
				st[1]=t.getMaxCapacity_i();
				st[0]=Integer.valueOf(t.getResaveds3_s());
				s[i] = st;
				if(i!=0){
					msg=msg+"!"+t.getMaxCapacity_i()+","+t.getResaveds3_s();
				}else{
					msg=t.getMaxCapacity_i()+","+t.getResaveds3_s();
				}
			}
			System.out.println("msg====="+msg);
			HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8"); 
				PrintWriter out = response.getWriter(); 
		        out.println(msg);  
		        out.flush();
		        out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			// TODO: handle exception
			 
		}
		return null;
	}
	
	public void getAllInfo(){
		IroadInfoService roadInfoService=new RoadInfoServiceImpl();
		try {
			roadInfoList = roadInfoService.getRoadInfo(null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
