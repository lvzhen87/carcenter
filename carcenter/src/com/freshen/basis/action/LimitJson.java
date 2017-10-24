package com.freshen.basis.action;

import java.util.ArrayList;

public class LimitJson {
	String strjson="";
	ArrayList<TreeJson> jsonlist;
	
	public String limitJson(String limitpage){
		strjson += "[{";
		strjson += "\"id\":\"1\",\"text\": \" 试验场\",";
		strjson += "\"children\":[{";
		strjson += "\"id\":11,";
		strjson += "\"text\":\"客户管理\",";
		strjson += "\"children\":[{";
		strjson += "\"id\":\"registCustomer.jsp\",";
		strjson += "\"text\":\"客户注册\"";	
		//if判断
		if(limitpage != null){
			if(limitpage.contains("客户注册")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson += "},{";
		strjson += "\"id\":\"showcustomer.jsp\",";
		strjson += "\"text\":\"企业信息管理\"";
		//if判断
		if(limitpage != null){
			if(limitpage.contains("企业信息管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchcustomeruserAction\",";
		strjson +="\"text\":\"企业人员管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("企业人员管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson += "}]";	
		
		strjson += "},{";
		strjson += "\"id\":12,";
		strjson += "\"text\":\"预约管理\",";
		strjson += "\"children\":[{";
		strjson += "\"id\":\"distrubuteOrderAction\",";
		strjson += "\"text\":\"待分配试验\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("待分配试验")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson += "},{";
		strjson += "\"id\":\"searchMyOrderAction\",";
		strjson += "\"text\":\"审核试验\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("审核试验")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson += "}]";	
		
		strjson += "},{";	
		strjson += "\"id\":13,";
	    strjson += "\"text\":\"接待管理\",";
		strjson += "\"children\":[{";
		strjson += "\"id\":\"receptExpAction\",";
		strjson += "\"text\":\"今日试验接待\"";	
		//if
		if(limitpage != null){
			if(limitpage.contains("今日试验接待")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson += "},{";
		strjson += "\"id\":\"recepExperienceAction\",";
		strjson += "\"text\":\"已接待试验\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("已接待试验")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		/*strjson += "},{";
		strjson += "\"id\":\"intoMemberInfoCheckAction\",";
		strjson += "\"text\":\"进场人员信息核对\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("进场人员信息核对")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}*/
		/*strjson += "},{";
		strjson += "\"id\":\"recExperiencephoneAction\",";
		strjson += "\"text\":\"对讲机发放\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("对讲机发放")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}*/
		strjson += "}]"	;
		strjson +="},{";
		
		strjson +="\"id\":14,";
		strjson +="\"text\":\"信息管理\",";
		strjson +="\"children\":[{";
		
		strjson +="\"id\":\"organizationpage.jsp\",";
		strjson +="\"text\":\"组织架构管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("组织架构管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchemployeeInfoAction\",";
		strjson +="\"text\":\"职员管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("职员管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"initLimitAction\",";
		strjson +="\"text\":\"权限管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("权限管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		
		strjson +="},{";
		strjson +="\"id\":\"searchbarrierAction\",";
		strjson +="\"text\":\"道闸管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("道闸管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="},{";
		strjson +="\"id\":\"searchroadAction\",";
		strjson +="\"text\":\"道路管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("道路管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		

		strjson +="},{";
		strjson +="\"id\":\"searchBasisRoadweekstatusinfo\",";
		strjson +="\"text\":\"本周道路状态管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("本周道路状态管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="},{";
		strjson +="\"id\":\"searchworkshopAction\",";
		strjson +="\"text\":\"车间管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("车间管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchinterphoneAction\",";
		strjson +="\"text\":\"对讲机管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("对讲机管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchTrainruleAction\",";
		strjson +="\"text\":\"驾驶员培训规则管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("驾驶员培训规则管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchunRuleAction\",";
		strjson +="\"text\":\"退订规则管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("退订规则管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchTimeruleAction\",";
		strjson +="\"text\":\"预订时间规则管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("预订时间规则管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchRuleAction\",";
		strjson +="\"text\":\"道路精确预订规则管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("道路精确预订规则管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="},{";
		strjson +="\"id\":\"expendRecordAction\",";
		strjson +="\"text\":\"发放补贴查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("发放补贴查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}

		strjson +="},{";
		strjson +="\"id\":\"ConstantInfoAction\",";
		strjson +="\"text\":\"常量信息管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("常量信息管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"initChargeAction\",";
		strjson +="\"text\":\"其他费用管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("其他费用管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}		
		strjson +="},{";
		strjson +="\"id\":\"initDoorinfoAction\",";
		strjson +="\"text\":\"门禁管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("门禁管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}	
		strjson +="},{";
		strjson +="\"id\":\"catarcManageAction\",";
		strjson +="\"text\":\"试验场管理信息\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("试验场管理信息")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}	
		strjson +="},{";
		strjson +="\"id\":\"getsubsidiesinfoAction\",";
		strjson +="\"text\":\"补贴设置\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("补贴设置")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}	
		strjson +="},{";
		strjson +="\"id\":\"/basismanage/changepwd.jsp\",";
		strjson +="\"text\":\"修改密码\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("修改密码")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}	
		strjson +="}]";
		strjson +="},{";
		strjson +="\"id\":15,";
		strjson +="\"text\":\"场内管理\",";
		strjson +="\"children\":[{";
		strjson +="\"id\":\"searchRecorderAction\",";
		strjson +="\"text\":\"订单修改\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("订单修改")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchRecorderShowAction\",";
		strjson +="\"text\":\"订单查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("订单查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchRecuserShowAction\",";
		strjson +="\"text\":\"在场人员查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("在场人员查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchVeRecordShowAction\",";
		strjson +="\"text\":\"车辆通过查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("车辆通过查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchprocessAction\",";
		strjson +="\"text\":\"订单道路查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("订单道路查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="},{";
		strjson +="\"id\":\"searchOvertimeAction\",";
		strjson +="\"text\":\"车辆超时查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("车辆超时查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="},{";
		strjson +="\"id\":\"searchinterphoneAction\",";
		strjson +="\"text\":\"对讲机记录查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("对讲机记录查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"recExperiencephoneAction\",";
		strjson +="\"text\":\"对讲机发放与回收\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("对讲机发放与回收")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"initVehicleCardAction\",";
		strjson +="\"text\":\"公卡管理\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("公卡管理")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"initWashcarAction\",";
		strjson +="\"text\":\"洗车信息查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("洗车信息查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="},{";
		strjson +="\"id\":\"roadstaticticstatistic\",";
		strjson +="\"text\":\"道路使用率查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("道路使用率查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		
		strjson +="}]";
		/*strjson +="},{";
		strjson +="\"id\":16,";
		strjson +="\"text\":\"过程管理\",";
		strjson +="\"children\":[{";
		strjson +="\"id\":\"searchprocessAction\",";
		strjson +="\"text\":\"出入道路查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("出入道路查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchinterphoneAction\",";
		strjson +="\"text\":\"对讲机过程查询\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("对讲机过程查询")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"callbackinterphone.jsp\",";
		strjson +="\"text\":\"对讲机回收\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("对讲机回收")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="}]";*/
		strjson +="},{";
		strjson +="\"id\":17,";
		strjson +="\"text\":\"订单核算\",";
		strjson +="\"children\":[{";
		strjson +="\"id\":\"initOrderCostAction\",";
		strjson +="\"text\":\"费用核算\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("费用核算")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"initOrderCostAction\",";
		strjson +="\"text\":\"费用调整\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("费用调整")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"searchPeriodCostAction\",";
		strjson +="\"text\":\"道路使用量确认清单\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("道路使用量确认清单")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="},{";
		strjson +="\"id\":\"initHandcraftAction\",";
		strjson +="\"text\":\"手工录入费用信息\"";
		//if
		if(limitpage != null){
			if(limitpage.contains("手工录入费用信息")){
				strjson += ",";
				strjson += "\"checked\" : \"true\"";
			}
		}
		strjson +="}]";
		strjson +="}]";
		strjson +="}]";

		
		return strjson;
	}
}
