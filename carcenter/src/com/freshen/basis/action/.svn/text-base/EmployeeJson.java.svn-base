package com.freshen.basis.action;

import java.util.List;

import com.freshen.entity.basis.Employee;
import com.freshen.util.BasicTools;

public class EmployeeJson {

	String strjson="";
	
	
	public String drawejson(List<Employee> elist){
		//判断elist中是否有值
		if(BasicTools.isnotNull(elist)){
			strjson +="{\"total\":"+elist.size()+",\"rows\":";
			strjson +="[";
			for (int i = 0; i < elist.size(); i++) {
				strjson +="{";
				strjson +="\"employid\":\""+ elist.get(i).getEmployeeID_s() +"\",";
				strjson +="\"employname\":\""+ elist.get(i).getCustomerUserName_s() +"\"";
				strjson +="},";
			}
			strjson=strjson.substring(0, strjson.length() - 1); 
			strjson +="]}";
		}
		
		return	strjson;
	}
	
	
}
