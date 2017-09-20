package com.freshen.reception.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.freshen.basis.service.IroadInfoService;
import com.freshen.basis.service.impl.RoadInfoServiceImpl;
import com.freshen.entity.basis.RoadInfo;
import com.freshen.entity.reception.ReceptionVehicleInfo;
import com.freshen.reception.service.IreceptionVehicleInfoService;
import com.freshen.reception.service.impl.ReceptionVehicleInfoServiceImpl;
import com.freshen.util.ExceptionDispose;
import com.freshen.action.common.CapgActionSupport;import com.freshen.util.ConstantUtil;
/**
 *  Class Name: RoadNameToJsonAction.java
 *  Function:该类用于将全部道路名称，转换为json串，传给jsp
 *     Modifications:   
 *  @author   DateTime 2014-6-17 下午12:03:55    
 *  @version 1.0
 */
public class RoadNameToJsonAction extends CapgActionSupport implements ServletResponseAware{
	String jsonStr;
	private HttpServletResponse response; 
	String vehicleID_s;
	String cpg,orderID_s;
	
	
	public String getOrderID_s() {
		return orderID_s;
	}
	public void setOrderID_s(String orderIDS) {
		orderID_s = orderIDS;
	}
	public String getCpg() {
		return cpg;
	}
	public void setCpg(String cpg) {
		this.cpg = cpg;
	}
	public String getVehicleID_s() {
		return vehicleID_s;
	}
	public void setVehicleID_s(String vehicleID_s) {
		this.vehicleID_s = vehicleID_s;
	}
	
	public String execute(){
		response.setCharacterEncoding("utf-8"); 
		List<RoadInfo>roadNames=null;
		IroadInfoService roadSer=new RoadInfoServiceImpl();
		PrintWriter pw=null;
		List<ReceptionVehicleInfo> rvList = new ArrayList<ReceptionVehicleInfo>();
		List<String> vroadList = new ArrayList<String>();
		String[] vroadTotal;
		ReceptionVehicleInfo rv = new ReceptionVehicleInfo();
		IreceptionVehicleInfoService ivi = new ReceptionVehicleInfoServiceImpl();
		try {
			
			if(vehicleID_s!= null && !vehicleID_s.trim().equals(""))
			{
			
				rv.setVehicleID_s(vehicleID_s);
				rv.setOrderID_s(orderID_s);
				rv.setResaveds2_s(cpg);
				
				rvList = ivi.getReceptionVehicleInfo(rv, -1, 0);
				if(rvList!= null && rvList.size()>0)
				{
					if(rvList.get(0).getRoidIds_s()!= null)
					{
						vroadTotal = rvList.get(0).getRoidIds_s().split("vv");
						if(vroadTotal!= null && vroadTotal.length>0)
						{
							for(int j = 0;j<vroadTotal.length;j++)
							{
								vroadList.add(vroadTotal[j]);
							}
						}
					}
					
				}
			}
			roadNames=roadSer.getRoadInfo(null);
			if(roadNames==null||roadNames.size()<1){
				jsonStr="[{'id':0,'text':'查无数据'}]";
			}else{
				jsonStr="[";
				StringBuffer sb=new StringBuffer();
				for (int i = 0; i < roadNames.size(); i++) {
					RoadInfo ri=roadNames.get(i);
					if(vroadList.contains(ri.getRoadID_s()))
					{
						sb.append("{'id':"+(i+1)+",'text':'"+ri.getRoadID_s()+"_"+ri.getRoadName_s()+"','selected':true},");
					}
					else
					{
						sb.append("{'id':"+(i+1)+",'text':'"+ri.getRoadID_s()+"_"+ri.getRoadName_s()+"'},");
					}
				}
				jsonStr+=sb.substring(0, sb.length()-1)+"]";
			}
			pw=response.getWriter();
			pw.println(jsonStr.replace("'", "\""));
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			this.setErrmsg(e.getMessage());			
			ExceptionDispose.saveExceptionInfo(e);
			return ERROR;
			 
		}
		return null;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		this.response=arg0;
	}
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
}
